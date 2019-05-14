// 控制层
app.controller('goodsController', function($scope, $controller, goodsService, uploadService, itemCatService, typeTemplateService) {

  // 继承
  $controller('baseController', {
    $scope: $scope
  })

  // 增加
  $scope.add = () => {

    $scope.entity.goodsDesc.introduction = editor.html()
    goodsService.add($scope.entity).success(
      (response) => {
        if (response.success) {
          alert(response.message)
          // 清空
          $scope.entity = {}
          // 清空富文本编辑器
          editor.html('')
        } else {
          alert(response.message)
        }
      }
    )
  }

  // 图片上传
  $scope.uploadFile = () => {
    uploadService.uploadFile().success(
      (response) => {
        // 如果上传成功，取出url
        if (response.success) {
          // 设置文件地址
          $scope.image_entity.url = response.message
        } else {
          alert(response.message);
        }
      }).error(() => {
      alert("上传发生错误")
    })
  }

  //定义页面实体结构
  $scope.entity = {
    goodsDesc: {
      itemImages: [],
      specificationItems: []
    }
  }

  // 添加图片列表，将当前上传的图片实体存入图片列表
  $scope.add_image_entity = () => {
    $scope.entity.goodsDesc.itemImages.push($scope.image_entity)
  }

  // 移除图片
  $scope.remove_image_entity = (index) => {
    $scope.entity.goodsDesc.itemImages.splice(index, 1)
  }

  // 读取一级分类
  $scope.selectItemCat1List = () => {
    itemCatService.findByParentId(0).success(
      (response) => {
        $scope.itemCat1List = response
      }
    )
  }

  // 读取二级分类
  // $watch方法用于监控某个变量的值，当被监控的值发生变化，就自动执行相应的函数
  $scope.$watch('entity.goods.category1Id', (newValue, oldValue) => {
    // 根据选择的值，查询二级分类
    itemCatService.findByParentId(newValue).success(
      (response) => {
        $scope.itemCat2List = response
      }
    )
  })

  // 读取三级分类
  $scope.$watch('entity.goods.category2Id', (newValue, oldValue) => {
    // 根据选择的值，查询二级分类
    itemCatService.findByParentId(newValue).success(
      (response) => {
        $scope.itemCat3List = response
      }
    )
  })

  // 三级分类选择后，读取模板 id
  $scope.$watch('entity.goods.category3Id', (newValue, oldValue) => {
    itemCatService.findOne(newValue).success(
      (response) => {
        // 更新模板 id
        $scope.entity.goods.typeTemplateId = response.typeId
      }
    )
  })

  // 选择模板后，更新品牌列表
  $scope.$watch('entity.goods.typeTemplateId', (newValue, oldValue) => {
    typeTemplateService.findOne(newValue).success(
      (response) => {
        // 获取类型模板
        $scope.typeTemplate = response
        // 品牌列表
        $scope.typeTemplate.brandIds = JSON.parse($scope.typeTemplate.brandIds)
        // 扩展属性
        $scope.entity.goodsDesc.customAttributeItems = JSON.parse($scope.typeTemplate.customAttributeItems)

      }
    )

    // 规格列表
    typeTemplateService.findSpecList(newValue).success(
      (response) => {
        $scope.findSpecList = response
      }
    )
  })

  $scope.updateSpecAttribute = ($event, name, value) => {

    /**
     * 数据格式
     * [{"attributeName":"网络制式","attributeValue":["移动3G","移动4G"]},{"attributeName":"屏幕尺寸","attributeValue":["6寸","5寸"]}]
     */
    // 查看集合中有没有 attributeName
    let object = $scope.searchObjectByKey($scope.entity.goodsDesc.specificationItems, 'attributeName', name);

    if (object !== null) {
      // 存在 attributeName ==> 追加 attributeValue

      if ($event.target.checked) {
        // 选中
        object.attributeValue.push(value)
      } else {
        // 取消勾选 ==> 移除 attributeValue
        object.attributeValue.splice(object.attributeValue.indexOf(value), 1)

        if (object.attributeValue.length === 0) {
          // attributeValue 没有值了，需要移除整个 oboject
          $scope.entity.goodsDesc.specificationItems.splice($scope.entity.goodsDesc.specificationItems.indexOf(object), 1)
        }

      }

    } else {
      // 不存在 attributeName ==> 添加 {"attributeName":"网络制式","attributeValue":["移动3G","移动4G"]}
      $scope.entity.goodsDesc.specificationItems.push({
        "attributeName": name,
        "attributeValue": [value]
      })
    }
  }
})
