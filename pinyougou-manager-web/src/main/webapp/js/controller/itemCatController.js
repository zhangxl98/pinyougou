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

  // 根据 id 获取实体
	$scope.findOne = (id) => {
  	itemCatService.findOne(id).success(
		  (response) => {
		  	$scope.entity = response
		  }
	  )
	}

	// 根据上级 id 显示下级列表
	$scope.findByParentId = (parentId) => {
  	itemCatService.findByParentId(parentId).success(
		  (response) => {
		  	$scope.list = response
		  }
	  )
	}
})
