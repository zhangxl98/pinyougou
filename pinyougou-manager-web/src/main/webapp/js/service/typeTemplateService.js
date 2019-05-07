// 服务层
app.service('typeTemplateService', function($http) {

  // 读取列表数据绑定到表单中
  this.findAll = () => {
    return $http.get('../typeTemplate/findAll.do')
  }
  // 分页
  this.findPage = (page, rows) => {
    return $http.get('../typeTemplate/findPage.do?page=' + page + '&rows=' + rows)
  }
})
