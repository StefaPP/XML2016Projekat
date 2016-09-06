(function(angular) {

	var xml = angular.module('xml', [ 'ngRoute', 'ui.router', 'ngStorage',
			'login', 'acts', 'amendments', 'session', 'ngResource',
			'ui.bootstrap' ])

	xml.config(config).run(run)
	function config($stateProvider) {
		// $urlRouteProvider.otherwise('#/');
		$stateProvider.state('/#', {
			templateUrl : 'index.html'
		}).state('login', {
			url : '/login',
			templateUrl : 'client/login/login.html',
			controller : 'loginCtrl'
		}).state('amendments', {
			url : '/amendments',
			templateUrl : 'client/amendments/amendments.html',
			controller : 'amendmentsCtrl'
		}).state('acts', {
			url : '/acts',
			templateUrl : 'client/acts/acts.html',
			controller : 'actsCtrl'
		}).state('session', {
			url : '/session',
			templateUrl : 'client/session/session.html',
			controller : 'sessionCtrl'
		}).state('actsInProcedure', {
			url : '/actsInProcedure',
			templateUrl : 'client/acts/actsInProcedure.html',
			controller : 'actsInProcedureCtrl'
		})
	}

	function run($rootScope, $http, $location, $localStorage, $state, Login) {
		$rootScope.$on('$stateChangeSuccess', function(event, toState,
				toParams, fromState, fromParams) {
			// lista javnih stanja
			var publicStates = [ 'login', 'acts', 'actsInProcedure', '' ];
			var restrictedState = publicStates.indexOf(toState.name) === -1;
			if (restrictedState && !Login.getCurrentUser()) {
				$state.go('login');
			}
		});

		$rootScope.logout = function() {
			console.log("Logged Out")
			Login.logout();
		}

		$rootScope.getCurrentUser = function() {
			if (!Login.getCurrentUser()) {
				return undefined;
			} else {
				return Login.getCurrentUser();
			}
		}

		$rootScope.getCurrentUserRole = function() {
			if (!Login.getCurrentUser()) {
				return undefined;
			} else {
				return Login.getCurrentUser().role;
			}
		}

		$rootScope.isLoggedIn = function() {
			if (Login.getCurrentUser()) {
				return true;
			} else {
				return false;
			}
		}

	}

}(angular))