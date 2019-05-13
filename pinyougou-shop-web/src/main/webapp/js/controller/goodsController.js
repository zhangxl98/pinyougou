// 控制层
app.controller('goodsController', function($scope, goodsService, uploadService) {

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
})
