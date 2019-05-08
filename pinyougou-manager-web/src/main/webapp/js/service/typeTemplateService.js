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

  // 增加
  this.add = (entity) => {
    return $http.post('../typeTemplate/add.do', entity)
  }

  // 修改
  this.update = (entity) => {
    return $http.post('../typeTemplate/update.do', entity)
  }

  // 根据 id 查询实体类
  this.findOne = (id) => {
    return $http.get('../typeTemplate/findOne.do?id=' + id)
  }
})
