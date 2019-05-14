// 基本控制层
app.controller('baseController', function($scope) {

  // 在集合中根据 key 查询对象
  $scope.searchObjectByKey = (list, key, keyValue) => {
    for (let i = 0; i < list.length; i++) {
      if (list[i][key] === keyValue)
        return list[i]
    }
    return null
  }
})
