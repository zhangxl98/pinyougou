// 控制层
app.controller('typeTemplateController', function($scope, $controller, typeTemplateService, brandService, specificationService) {

  // 继承
  $controller('baseController', {
    $scope: $scope
  })

  // 读取列表数据绑定到表单中
  $scope.findAll = () => {
    typeTemplateService.findAll().success(
      (response) => {
        $scope.list = response
      }
    )
  }

  // 分页
  $scope.findPage = (page, rows) => {
    typeTemplateService.findPage(page, rows).success(
      (response) => {
        $scope.list = response.rows
        // 更新总记录数
        $scope.paginationConf.totalItems = response.total
      }
    )
  }

  // 定义品牌列表
  $scope.brandList = {
    data: []
  }

  // 获取品牌数据
  $scope.findBrandList = () => {
    brandService.selectOptionList().success(
      (response) => {
        $scope.brandList = {
          data: response
        }
      }
    )
  }

  // 定义规格列表
  $scope.specList = {
    data: []
  }

  // 获取规格数据
  $scope.findSpecList = () => {
    specificationService.selectOptionList().success(
      (response) => {
        $scope.specList = {
          data: response
        }
      }
    )
  }


  // 保存规格
  $scope.save = () => {
    // 服务层对象
    let serviceObject = null
    if ($scope.entity.id != null) {
      // 如果有 ID ==> 修改
      serviceObject = typeTemplateService.update($scope.entity)
    } else {
      // 如果没有 ID ==> 增加
      serviceObject = typeTemplateService.add($scope.entity)
    }
    serviceObject.success(
      (response) => {
        if (response.success) {
          //重新查询
          $scope.reloadList()
        } else {
          alert(response.message)
        }
      }
    )
  }

  // 根据 id 查询实体类
  $scope.findOne = (id) => {
    typeTemplateService.findOne(id).success(
      (response) => {
        $scope.entity = response

        // 转换字符串为 JSON 对象
        // 品牌
        $scope.entity.brandIds = JSON.parse($scope.entity.brandIds)
        // 规格
        $scope.entity.specIds = JSON.parse($scope.entity.specIds)
        // 扩展属性
        $scope.entity.customAttributeItems = JSON.parse($scope.entity.customAttributeItems)
      }
    )
  }

  // 增加扩展属性行
  $scope.addTableRow = () => {
    $scope.entity.customAttributeItems.push({})
  }

  // 删除扩展属性行
  $scope.deleTableRow = (index) => {
    $scope.entity.customAttributeItems.splice(index, 1)
  }
})
