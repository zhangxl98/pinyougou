// 服务层
app.service('goodsService', function($http) {

  // 增加
  this.add = (entity) => {
    return $http.post('../goods/add.do', entity)
  }

  //搜索
  this.search = (page, rows, searchEntity) => {
    return $http.post('../goods/search.do?page=' + page + "&rows=" + rows, searchEntity)
  }
})
