// 控制层
app.controller('goodsController', function($scope, goodsService) {

  // 增加
  $scope.add = () => {
    goodsService.add($scope.entity).success(
      (response) => {
        if (response.success) {
          alert(response.message)
          // 清空
          $scope.entity = {}
        } else {
          alert(response.message)
        }
      }
    )
  }
})
