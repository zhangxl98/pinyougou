// 基本控制层
app.controller('baseController', function($scope) {

  // 重新加载列表数据
  $scope.reloadList = () => {
    // 切换页码
    $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage)
  }

  // 分页控件配置
  $scope.paginationConf = {
    // 当前页码
    currentPage: 1,
    // 总条数
    totalItems: 10,
    // 每页记录数
    itemsPerPage: 10,
    // 页码选项
    perPageOptions: [10, 20, 30, 40, 50],
    // 更改页面时触发事件
    onChange: () => {
      //重新加载
      $scope.reloadList()
    }
  }

  // 在集合中根据 key 查询对象
  $scope.searchObjectByKey = (list, key, keyValue) => {
    for (let i = 0; i < list.length; i++) {
      if (list[i][key] === keyValue)
        return list[i]
    }
    return null
  }
})
