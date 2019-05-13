// 控制层
app.controller('goodsController', function($scope, goodsService, uploadService, itemCatService) {

  // 增加
  $scope.add = () => {

    $scope.entity.goodsDesc.introduction = editor.html()
    goodsService.add($scope.entity).success(
      (response) => {
        if (response.success) {
          alert(response.message)
          // 清空
          $scope.entity = {}
          // 清空富文本编辑器
          editor.html('')
        } else {
          alert(response.message)
        }
      }
    )
  }

  // 图片上传
  $scope.uploadFile = () => {
    uploadService.uploadFile().success(
      (response) => {
        // 如果上传成功，取出url
        if (response.success) {
          // 设置文件地址
          $scope.image_entity.url = response.message
        } else {
          alert(response.message);
        }
      }).error(() => {
      alert("上传发生错误")
    })
  }

  //定义页面实体结构
  $scope.entity = {
    goodsDesc: {
      itemImages: []
    }
  }

  // 添加图片列表，将当前上传的图片实体存入图片列表
  $scope.add_image_entity = () => {
    $scope.entity.goodsDesc.itemImages.push($scope.image_entity)
  }

  // 移除图片
  $scope.remove_image_entity = (index) => {
    $scope.entity.goodsDesc.itemImages.splice(index, 1)
  }

  // 读取一级分类
  $scope.selectItemCat1List = () => {
    itemCatService.findByParentId(0).success(
      (response) => {
        $scope.itemCat1List = response
      }
    )
  }

  // 读取二级分类
  // $watch方法用于监控某个变量的值，当被监控的值发生变化，就自动执行相应的函数
  $scope.$watch('entity.goods.category1Id', (newValue, oldValue) => {
    // 根据选择的值，查询二级分类
    itemCatService.findByParentId(newValue).success(
      (response) => {
        $scope.itemCat2List = response
      }
    )
  })

  // 读取三级分类
  $scope.$watch('entity.goods.category2Id', (newValue, oldValue) => {
    // 根据选择的值，查询二级分类
    itemCatService.findByParentId(newValue).success(
      (response) => {
        $scope.itemCat3List = response
      }
    )
  })

  // 三级分类选择后，读取模板 id
  $scope.$watch('entity.goods.category3Id', function(newValue, oldValue) {
    itemCatService.findOne(newValue).success(
      function(response) {
        // 更新模板 id
        $scope.entity.goods.typeTemplateId = response.typeId
      }
    )
  })
})
