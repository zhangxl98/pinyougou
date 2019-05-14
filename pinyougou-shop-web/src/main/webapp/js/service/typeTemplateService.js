// 服务层
app.service('typeTemplateService', function($http) {

  // 根据 id 查询实体类
  this.findOne = (id) => {
    return $http.get('../typeTemplate/findOne.do?id=' + id)
  }

  // 查询规格列表
  this.findSpecList = (id) => {
    return $http.get('../typeTemplate/findSpecList.do?id=' + id)
  }

})
