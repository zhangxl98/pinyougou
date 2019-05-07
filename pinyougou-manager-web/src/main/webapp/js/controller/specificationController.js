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

   // 保存规格
   $scope.save = () => {
     // 服务层对象
     let serviceObject = null
     if ($scope.entity.specification.id != null) {
       // 如果有 ID ==> 修改
       serviceObject = specificationService.update($scope.entity)
     } else {
       // 如果没有 ID ==> 增加
       serviceObject = specificationService.add($scope.entity)
     }
     serviceObject.success(
       (response) => {
         if (response.success) {
           //重新查询
           $scope.reloadList()
         } else {
           alert(response.message)
         }
       }
     )
   }

   $scope.findOne = (id) => {
     specificationService.findOne(id).success(
       (response) => {
         $scope.entity = response
       }
     )
   }


   // 增加规格选项行
   $scope.addTableRow = () => {
     $scope.entity.specificationOptionList.push({})
   }

   //删除规格选项行
   $scope.deleTableRow = function(index) {
     $scope.entity.specificationOptionList.splice(index, 1)
   }

 })
