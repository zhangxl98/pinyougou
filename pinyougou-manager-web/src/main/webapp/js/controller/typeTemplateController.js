// 控制层
app.controller('typeTemplateController', function($scope, $controller, typeTemplateService) {

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

})
