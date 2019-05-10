// 登录服务层
app.service("loginService", function($http) {

	// 读取登录用户名
	this.getLoginName = () => {
		return $http.get('../login/getName.do')
	}
})