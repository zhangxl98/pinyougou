// 文件上传服务层
app.service("uploadService", function($http) {

  // 上传文件
  this.uploadFile = () => {
    let formData = new FormData()
    formData.append("file", file.files[0])
    return $http({
      method: 'POST',
      url: '../upload.do',
      data: formData,
      headers: {
        'Content-Type': undefined
      },
      transformRequest: angular.identity
    })
  }
})
