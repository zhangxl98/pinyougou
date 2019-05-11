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



  // 设置当前级别，默认为 1
  $scope.grade = 1

  // 设置级别
  $scope.setGrade = (value) => {
    $scope.grade = value
  }

  // 读取列表
  $scope.selectList = (p_entity) => {

    if ($scope.grade === 1) {
      // 1 级
      $scope.entity_1 = null
      $scope.entity_2 = null
    } else if ($scope.grade === 2) {
      // 2 级
      $scope.entity_1 = p_entity
      $scope.entity_2 = null
    } else if ($scope.grade === 3) {
      // 3 级
      $scope.entity_2 = p_entity
    }

    $scope.findByParentId(p_entity.id)
  }
})
