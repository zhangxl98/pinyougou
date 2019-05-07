// 品牌服务层
app.service('brandService', function($http) {
  // 读取列表数据到表单中
  this.findAll = () => {
    return $http.get('../brand/findAll.do')
  }

  //分页
  this.findPage = (page, rows) => {
    return $http.get('../brand/findPage.do?page=' + page + '&rows=' + rows)
  }

  // 根据 id 查询实体类
  this.findOne = (id) => {
    return $http.get('../brand/findOne.do?id=' + id)
  }

  //增加
  this.add = (entity) => {
    return $http.post('../brand/add.do', entity)
  }

  //修改
  this.update = (entity) => {
    return $http.post('../brand/update.do', entity)
  }

  //删除
  this.delete = (ids) => {
    return $http.get('../brand/delete.do?ids=' + ids)
  }

  //搜索
  this.search = (page, rows, searchEntity) => {
    return $http.post('../brand/search.do?page=' + page + "&rows=" + rows, searchEntity)
  }


})
