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


  // 增加扩展属性行
  $scope.addTableRow = () => {
    $scope.entity.customAttributeItems.push({})
  }

  // 删除扩展属性行
  $scope.deleTableRow = (index) => {
    $scope.entity.customAttributeItems.splice(index, 1)
  }
})
