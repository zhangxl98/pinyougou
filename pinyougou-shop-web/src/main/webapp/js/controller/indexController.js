// 首页控制层
app.controller('indexController', function($scope, loginService) {

  // 显示当前用户名
  $scope.showLoginName = () => {
    loginService.getLoginName().success(
      (response) => {
        $scope.loginName = response.loginName
      }
    )
  }
})
