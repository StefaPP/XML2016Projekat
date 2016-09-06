(function(angular) {
	angular.module('login', [ 'loginResource' ]).controller(
			'loginCtrl',
			function($scope, Login) {
			
				$scope.user = {};
				
				$scope.login = function() {
					console.log($scope.user)
					Login.login($scope.user.username, $scope.user.password,
							loginCbck);
				}
				function loginCbck(success) {
					if (success) {
					} else {
						$scope.value = true;
					}
				}

			});
}(angular));
