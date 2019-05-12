// 服务层
app.service('goodsService', function($http) {

  // 增加
  this.add = (entity) => {
    return $http.post('../goods/add.do', entity)
  }

})
