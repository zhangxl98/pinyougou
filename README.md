# 品优购
电商网站

## 开发环境

| 工具 | 版本 |
| ---- |:--- |
| OS | Ubuntu 18.04.2 LTS x86_64 |
| IDE | IntelliJ IDEA 2018.2.2 |
| JDK | 1.8.0_201 |
| Tomcat | Tomcat 8.0.53 |
| Docker | 18.09.2 |
| MySQL | Docker mysql:5.6 |
| Maven | Apache Maven 3.6.0 |
| Dubbo | Dubbox 2.8.4 |
| ZooKeeper | Apache ZooKeeper 3.4.14 |
| FastDFS | Docker morunchang/fastdfs |



## 目标功能

- 运营商后台
  - 品牌管理
    - [x] 品牌管理的分页列表 -- 完成 
    - [x] 品牌管理的增加 -- 完成
    - [x] 品牌管理的修改 -- 完成
    - [x] 品牌管理的删除 -- 完成
    - [x] 品牌管理的条件查询 -- 完成
  - 规格管理
    - [x] 规格管理的分页列表 -- 完成 
    - [x] 规格管理的增加 -- 完成
    - [x] 规格管理的修改 -- 完成
    - [x] 规格管理的删除 -- 完成
    - [x] 规格管理的条件查询 -- 完成
  - 模板管理
    - [x] 模板管理的分页列表 -- 完成 
    - [x] 模板管理的增加 -- 完成
    - [x] 模板管理的修改 -- 完成
    - [x] 模板管理的删除 -- 完成
    - [x] 模板管理的条件查询 -- 完成
  - 登录
    - [x] 运营商登陆与安全控制 -- 完成

- 商家管理后台
  - 商家
    - [x] 商家入驻 -- 完成
    - [x] 商家审核 -- 完成
    - [x] 商家系统登陆与安全控制 -- 完成
  - 商品分类
    - [x] 商品分类的分页列表 -- 完成
    - [x] 商品分类的增加 -- 完成
    - [x] 商品分类的修改 -- 完成
    - [x] 商品分类的删除 -- 完成
  - 商品录入
    - [x] 录入商品基本信息 -- 完成
    - [x] 录入商品介绍 -- 完成
    - [x] 商品图片上传 -- 完成
    - [ ] 选择商品分类
    - [ ] 选择商品品牌
    - [ ] 选择商品扩展属性
    - [ ] 选择商品规格
    - [ ] 录入商品 SKU 信息
    - [ ] 是否启用商品规格
  - 商品管理
    - [ ] 商品的分页列表
    - [ ] 商品的条件查询
    - [ ] 商品的修改
    - [ ] 商品的审核
    - [ ] 商品的删除
- 网站前台



## 数据库表结构


| 序号 | 表名称 | 含义 |
| :------: | :--- | :--- |
| 1 | tb_brand | 品牌 |
| 2 | tb_specification | 规格 |
| 3 | tb_specification_option | 规格选项 |
| 4 | tb_type_template | 类型模板：用于关联品牌和规格 |
| 5 | tb_item_cat | 商品分类 |
| 6 | tb_seller | 商家 |
| 7 | tb_goods | 商品 |
| 8 | tb_goods_desc | 商品详情 |
| 9 | tb_item | 商品明细 |
| 10 | tb_content | 内容（广告） |
| 11 | tb_content_category | 内容（广告）类型 |
| 12 | tb_user | 用户 |
| 13 | tb_order | 订单 |
| 14 | tb_order_item | 订单明细 |
| 15 | tb_pay_log | 支付日志 |



## 项目主要结构

- 排除目录和文件

  ```
  'test|target|.idea|*.iml|*.mvn|.DS_Store|images|img|*.png|*.gif|*.jpg|*.css|plugins|pages|select2|*Mapper.xml|*Mapper.java|Tb*.java'
  ```

  

- 项目结构

  ```
  pinyougou
  ├── pinyougou-common/
  │   ├── pom.xml
  │   └── src/
  │       └── main/
  │           ├── java/
  │           │   └── com/
  │           │       └── pinyougou/
  │           │           └── utils/
  │           │               └── FastDFSClient.java
  │           └── resources/
  ├── pinyougou-dao/
  │   ├── pom.xml
  │   └── src/
  │       └── main/
  │           ├── java/
  │           │   └── com/
  │           │       └── pinyougou/
  │           │           └── mapper/
  │           └── resources/
  │               ├── com/
  │               │   └── pinyougou/
  │               │       └── mapper/
  │               ├── mybatis/
  │               │   └── SqlMapConfig.xml
  │               ├── properties/
  │               │   └── db.properties
  │               └── spring/
  │                   └── applicationContext-dao.xml
  ├── pinyougoudb-v1.3.sql*
  ├── pinyougou-manager-web/
  │   ├── pom.xml
  │   └── src/
  │       └── main/
  │           ├── java/
  │           │   └── com/
  │           │       └── pinyougou/
  │           │           └── manager/
  │           │               └── controller/
  │           │                   ├── BrandController.java
  │           │                   ├── ItemCatController.java
  │           │                   ├── LoginController.java
  │           │                   ├── SellerController.java
  │           │                   ├── SpecificationController.java
  │           │                   └── TypeTemplateController.java
  │           ├── resources/
  │           │   ├── config/
  │           │   │   └── application.properties
  │           │   └── spring/
  │           │       ├── springmvc.xml
  │           │       └── spring-security.xml
  │           └── webapp/
  │               ├── admin/
  │               │   ├── brand.html
  │               │   ├── content_category.html
  │               │   ├── content.html
  │               │   ├── goods.html
  │               │   ├── home.html
  │               │   ├── index.html
  │               │   ├── item_cat.html
  │               │   ├── seller_1.html
  │               │   ├── seller.html
  │               │   ├── specification.html
  │               │   └── type_template.html
  │               ├── css/
  │               ├── favicon.ico
  │               ├── js/
  │               │   ├── angular-select2.js
  │               │   ├── base.js
  │               │   ├── base_pagination.js
  │               │   ├── controller/
  │               │   │   ├── baseController.js
  │               │   │   ├── brandController.js
  │               │   │   ├── indexController.js
  │               │   │   ├── itemCatController.js
  │               │   │   ├── sellerController.js
  │               │   │   ├── specificationController.js
  │               │   │   └── typeTemplateController.js
  │               │   └── service/
  │               │       ├── brandService.js
  │               │       ├── itemCatService.js
  │               │       ├── loginService.js
  │               │       ├── sellerService.js
  │               │       ├── specificationService.js
  │               │       └── typeTemplateService.js
  │               ├── login.html
  │               └── WEB-INF/
  │                   └── web.xml
  ├── pinyougou-pojo/
  │   ├── pom.xml
  │   └── src/
  │       └── main/
  │           ├── java/
  │           │   ├── com/
  │           │   │   └── pinyougou/
  │           │   │       ├── pojo/
  │           │   │       └── pojogroup/
  │           │   │           ├── Goods.java
  │           │   │           └── Specification.java
  │           │   └── entity/
  │           │       ├── PageResult.java
  │           │       └── Result.java
  │           └── resources/
  ├── pinyougou-sellergoods-interface/
  │   ├── pom.xml
  │   └── src/
  │       └── main/
  │           ├── java/
  │           │   └── com/
  │           │       └── pinyougou/
  │           │           └── sellergoods/
  │           │               └── service/
  │           │                   ├── BrandService.java
  │           │                   ├── GoodsService.java
  │           │                   ├── ItemCatService.java
  │           │                   ├── SellerService.java
  │           │                   ├── SpecificationService.java
  │           │                   └── TypeTemplateService.java
  │           └── resources/
  ├── pinyougou-sellergoods-service/
  │   ├── pom.xml
  │   └── src/
  │       └── main/
  │           ├── java/
  │           │   └── com/
  │           │       └── pinyougou/
  │           │           └── sellergoods/
  │           │               └── service/
  │           │                   └── impl/
  │           │                       ├── BrandServiceImpl.java
  │           │                       ├── GoodsServiceImpl.java
  │           │                       ├── ItemCatServiceImpl.java
  │           │                       ├── SellerServiceImpl.java
  │           │                       ├── SpecificationServiceImpl.java
  │           │                       └── TypeTemplateServiceImpl.java
  │           ├── resources/
  │           │   └── spring/
  │           │       └── applicationContext-service.xml
  │           └── webapp/
  │               ├── index.jsp
  │               └── WEB-INF/
  │                   └── web.xml
  ├── pinyougou-shop-web/
  │   ├── pom.xml
  │   └── src/
  │       └── main/
  │           ├── java/
  │           │   └── com/
  │           │       └── pinyougou/
  │           │           ├── service/
  │           │           │   └── UserDetailsServiceImpl.java
  │           │           └── shop/
  │           │               └── controller/
  │           │                   ├── GoodsController.java
  │           │                   ├── ItemCatController.java
  │           │                   ├── loginController.java
  │           │                   ├── SellerController.java
  │           │                   ├── TypeTemplateController.java
  │           │                   └── UploadController.java
  │           ├── resources/
  │           │   ├── config/
  │           │   │   ├── application.properties
  │           │   │   └── fdfs_client.conf
  │           │   └── spring/
  │           │       ├── springmvc.xml
  │           │       └── spring-security.xml
  │           └── webapp/
  │               ├── admin/
  │               │   ├── goods_edit.html
  │               │   ├── goods.html
  │               │   ├── home.html
  │               │   ├── index.html
  │               │   ├── password.html
  │               │   └── seller.html
  │               ├── cooperation.html
  │               ├── css/
  │               ├── favicon.ico
  │               ├── js/
  │               │   ├── base.js
  │               │   ├── controller/
  │               │   │   ├── goodsController.js
  │               │   │   ├── indexController.js
  │               │   │   └── sellerController.js
  │               │   └── service/
  │               │       ├── goodsService.js
  │               │       ├── itemCatService.js
  │               │       ├── loginService.js
  │               │       ├── sellerService.js
  │               │       ├── typeTemplateService.js
  │               │       └── uploadService.js
  │               ├── register.html
  │               ├── sampling.html
  │               ├── shoplogin.html
  │               └── WEB-INF/
  │                   └── web.xml
  ├── pom.xml
  ├── README.md
  └── src/
      └── main/
          ├── java/
          └── resources/
  
  95 directories, 105 files
  ```
  
  



