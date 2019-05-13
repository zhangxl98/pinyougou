// 服务层
app.service('itemCatService', function($http) {

  // 根据上级 id 显示下级列表
  this.findByParentId = (parentId) => {
    return $http.get('../itemCat/findByParentId.do?parentId=' + parentId)
  }
})
