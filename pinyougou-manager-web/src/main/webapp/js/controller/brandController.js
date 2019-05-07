app.controller('brandController', function($scope, $http, brandService) {
      // 读取列表数据到表单中
      $scope.findAll = () => {
        brandService.findAll().success(
          (response) => {
          $scope.list = response
        })
      }

      // 重新加载列表数据
      $scope.reloadList = () => {
        // 切换页码
        $scope.findPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage)
      }

      // 分页控件配置
      $scope.paginationConf = {
        // 当前页码
        currentPage: 1,
        // 总条数
        totalItems: 10,
        // 每页记录数
        itemsPerPage: 10,
        // 页码选项
        perPageOptions: [10, 20, 30, 40, 50],
        // 更改页面时触发事件
        onChange: () => {
          //重新加载
          $scope.reloadList()
        }
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

      // 定义要删除的品牌 id 数组
      $scope.selectIds = []

      // 获取要删除的 id
      $scope.updateSelection = ($event, id) => {
        // 判断选中状态
        if ($event.target.checked) {
          // 被选中 ==> 添加到数组
          $scope.selectIds.push(id)
        } else {
          // 取消选中 ==> 获取 id 在数组中的位置 ==> 移除
          $scope.selectIds.splice($scope.selectIds.indexOf(id), 1)
        }
      }

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
        $http.post('../brand/search.do?page=' + page + "&rows=" + rows, $scope.searchEntity).success(
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
