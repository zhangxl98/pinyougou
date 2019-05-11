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


  // 保存
  $scope.save = () => {

    // 判断是增加还是修改
    let object = null
    if ($scope.entity.id == null) {
      // 增加品牌

      // 给上级 id 赋值
      $scope.entity.parentId = $scope.parentId

      object = itemCatService.add($scope.entity)
    } else {
      // 修改品牌
      object = itemCatService.update($scope.entity)
    }

    object.success(
      (response) => {
        if (response.success) {
          // 成功，显示分页列表
          $scope.findByParentId($scope.parentId)
        } else {
          // 失败，弹出提示信息
          alert(response.message)
        }
      }
    )
  }


  // 定义上级 id，默认为 0
  $scope.parentId = 0

  // 根据上级 id 显示下级列表
  $scope.findByParentId = (parentId) => {
    // 记录上级 id
    $scope.parentId = parentId

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
