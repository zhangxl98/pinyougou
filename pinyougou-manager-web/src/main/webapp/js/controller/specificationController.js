 // 控制层
 app.controller('specificationController', function($scope, $controller, specificationService) {

   // 继承
   $controller('baseController', {
     $scope: $scope
   })

   // 读取列表数据绑定到表单中
   $scope.findAll = () => {
     specificationService.findAll().success(
       (response) => {
         $scope.list = response
       }
     )
   }

   // 分页
   $scope.findPage = (page, rows) => {
     specificationService.findPage(page, rows).success(
       (response) => {
         $scope.list = response.rows
         // 更新总记录数
         $scope.paginationConf.totalItems = response.total
       }
     )
   }
 })
