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

  // 根据 id 查询实体类
  this.findOne = (id) => {
    return $http.get('../seller/findOne.do?id=' + id)
  }

  // 更改审核状态
  this.updateStatus = (sellerId, status) => {
    return $http.get('../seller/updateStatus.do?sellerId=' + sellerId + '&status=' + status)
  }
})
