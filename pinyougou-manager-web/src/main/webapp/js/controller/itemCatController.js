//  控制层
app.controller('itemCatController', function($scope, $controller, itemCatService) {

  // 继承
  $controller('baseController', {
    $scope: $scope
  })

  // 读取列表数据绑定到表单中
  $scope.findAll = () => {
    itemCatService.findAll().success(
      (response) => {
        $scope.list = response
      }
    )
  }

  // 分页
  $scope.findPage = (page, rows) => {
    itemCatService.findPage(page, rows).success(
      (response) => {
        $scope.list = response.rows
        // 更新总记录数
        $scope.paginationConf.totalItems = response.total
      }
    )
  }

  // 根据 id 获取实体
	$scope.findOne = (id) => {
  	itemCatService.findOne(id).success(
		  (response) => {
		  	$scope.entity = response
		  }
	  )
	}
})
