// 服务层
app.service('specificationService', function($http) {

  // 读取列表数据绑定到表单中
  this.findAll = () => {
    return $http.get('../specification/findAll.do')
  }
  // 分页
  this.findPage = (page, rows) => {
    return $http.get('../specification/findPage.do?page=' + page + '&rows=' + rows)
  }

  // 增加
  this.add = (entity) => {
    console.log(entity)
    return $http.post('../specification/add.do', entity)
  }
})
