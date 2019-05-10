// 服务层
app.service('sellerService', function($http) {

  // 读取列表数据到表单中
  this.findAll = () => {
    return $http.get('../seller/findAll.do')
  }

  //分页
  this.findPage = (page, rows) => {
    return $http.get('../seller/findPage.do?page=' + page + '&rows=' + rows)
  }
})
