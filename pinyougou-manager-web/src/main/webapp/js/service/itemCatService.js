// 服务层
app.service('itemCatService', function($http) {

  // 读取列表数据到表单中
  this.findAll = () => {
    return $http.get('../itemCat/findAll.do')
  }

  // 根据 id 获取实体
  this.findOne = (id) => {
    return $http.get('../itemCat/findOne.do?id=' + id)
  }

  //增加
  this.add = (entity) => {
    return $http.post('../itemCat/add.do', entity)
  }

  //修改
  this.update = (entity) => {
    return $http.post('../itemCat/update.do', entity)
  }

  // 根据上级 id 显示下级列表
  this.findByParentId = (parentId) => {
    return $http.get('../itemCat/findByParentId.do?parentId=' + parentId)
  }
})
