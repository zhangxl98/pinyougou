// 基本控制层
app.controller('baseController', function($scope) {

  // 重新加载列表数据
  $scope.reloadList = () => {
    // 切换页码
    $scope.findPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage)
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

  // 定义要删除的品牌 id 数组
  $scope.selectIds = []

  // 获取要删除的 id
  $scope.updateSelection = ($event, id) => {
    // 判断选中状态
    if ($event.target.checked) {
      // 被选中 ==> 添加到数组
      $scope.selectIds.push(id)
    } else {
      // 取消选中 ==> 获取 id 在数组中的位置 ==> 移除
      $scope.selectIds.splice($scope.selectIds.indexOf(id), 1)
    }
  }

  // 提取 json 字符串数据中某个属性，返回拼接字符串 逗号分隔
  $scope.jsonToTsring = (jsonString, key) => {
    // 把字符串转化为 JSON
    let json = JSON.parse(jsonString)

    let value = ''

    // 遍历 json
    for (let i = 0; i < json.length; i++) {
      if (i > 0)
        value += '，'
      value += json[i][key]
    }
    return value
  }

})
