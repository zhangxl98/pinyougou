// 服务层
app.service('itemCatService', function($http) {

  // 读取列表数据到表单中
  this.findAll = () => {
    return $http.get('../itemCat/findAll.do')
  }

  //分页
  this.findPage = (page, rows) => {
    return $http.get('../itemCat/findPage.do?page=' + page + '&rows=' + rows)
  }

  // 根据 id 获取实体
	this.findOne = (id) => {
  	return $http.get('../itemCat/findOne.do?id=' + id)
	}
})
