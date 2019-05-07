app.controller('brandController', function($scope, $controller, brandService) {
  // 继承
  $controller('baseController', {
    $scope: $scope
  })

  // 读取列表数据到表单中
  $scope.findAll = () => {
    brandService.findAll().success(
      (response) => {
        $scope.list = response
      })
  }

  //分页
  $scope.findPage = (page, rows) => {
    brandService.findPage(page, rows).success(
      (response) => {
        $scope.list = response.rows
        //更新总记录数
        $scope.paginationConf.totalItems = response.total
      }
    )
  }

  // 增加或修改品牌
  $scope.save = () => {

    // 判断是增加还是修改
    let object = null
    if ($scope.entity.id == null) {
      // 增加品牌
      object = brandService.add($scope.entity)
    } else {
      // 修改品牌
      object = brandService.update($scope.entity)
    }

    object.success(
      (response) => {
        if (response.success) {
          // 成功，显示分页列表
          $scope.reloadList()
        } else {
          // 失败，弹出提示信息
          alert(response.message)
        }
      }
    )
  }

  // 根据 id 查询实体类
  $scope.findOne = (id) => {
    brandService.findOne(id).success(
      (response) => {
        $scope.entity = response
      }
    )
  }

  // 删除品牌

  // 批量删除
  $scope.delete = () => {
    brandService.delete($scope.selectIds).success(
      (response) => {
        if (response.success) {
          // 成功，显示分页列表
          $scope.reloadList()
        } else {
          // 失败，弹出提示信息
          alert(response.message)
        }
        $scope.selectIds = []
      }
    )
  }

  // 搜索
  // 定义搜索对象
  $scope.searchEntity = {}
  //条件查询
  $scope.search = (page, rows) => {
    brandService.search(page, rows, $scope.searchEntity).success(
      (response) => {
        //总记录数
        $scope.paginationConf.totalItems = response.total
        //给列表变量赋值
        $scope.list = response.rows
      }
    )
  }
  // 刷新列表
  $scope.reloadList = () => {
    $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage)
  }

})
