 // 控制层
 app.controller('sellerController', function($scope, $controller, sellerService) {

   // 增加
   $scope.add = () => {
     sellerService.add($scope.entity).success(
       (response) => {
         if (response.success)
           location.href = "shoplogin.html"
         else
           alert(response.message)
       }
     )
   }

 })
