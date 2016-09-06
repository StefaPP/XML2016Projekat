(function(angular) {
	angular.module('loginResource', [ 'ngResource' ]).factory('Login',
			function($http,$state, $resource, $localStorage, $log, $location) {
				var Login = {};
				Login.login = login;
				Login.logout = logout;
				Login.getCurrentUser = getCurrentUser;

				function login(username, password, callback) {
					console.log(username + " " + password);
					var user = {};
					user.username = username;
					user.password = password;
					$http({
						method : "POST",
						url : 'http://localhost:8081/XMLProject/rest/user/login',
						data : user,
						headers : {
							'Content-Type' : 'application/json'
						}
					}).success(function(user) {
						if (user.username) {
							var currentUser = {
								username : username,
								role : user.role
							};
							$localStorage.currentUser = currentUser;
							$state.go('acts');
						} else {
							console.log("Usao u not success")
							callback(false);
						}
					})
				}

				function logout() {
					delete $localStorage.currentUser;
					$location.path('/login')
				}

				function getCurrentUser() {
					return $localStorage.currentUser;
				}

				return Login;
			})
}(angular))