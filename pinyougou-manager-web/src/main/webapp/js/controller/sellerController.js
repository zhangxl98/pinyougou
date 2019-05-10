 //  控制层
 app.controller('sellerController', function($scope, $controller, sellerService) {

   // 继承
   $controller('baseController', {
     $scope: $scope
   })

   // 读取列表数据绑定到表单中
   $scope.findAll = () => {
     sellerService.findAll().success(
       (response) => {
         $scope.list = response
       }
     )
   }

   // 分页
   $scope.findPage = (page, rows) => {
     sellerService.findPage(page, rows).success(
       (response) => {
         $scope.list = response.rows
         // 更新总记录数
         $scope.paginationConf.totalItems = response.total
       }
     )
   }

   // 根据 id 查询实体类
   $scope.findOne = (id) => {
     sellerService.findOne(id).success(
       (response) => {
         $scope.entity = response
       }
     )
   }

   // 更改审核状态
   $scope.updateStatus = (sellerId, status) => {
     sellerService.updateStatus(sellerId, status).success(
       (response) => {
         if (response.success) {
           // 成功，显示分页列表
           $scope.reloadList()
         } else {
           // 失败，弹出提示信息
           alert(response.message)
         }
       }
     )
   }

 })
