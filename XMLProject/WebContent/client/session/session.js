(function(angular) {
	angular.module('session', []).controller(
			'sessionCtrl',
			function($scope, Acts, Amendments,$http) {

				init();

				function init() {
					$scope.actIP = Acts.getActsInProcedure();
					$scope.actIP.$promise.then(function(data) {
						console.log('aktovi u proceduri')
						$scope.actsInProcedure = data.results.bindings;
						console.log(JSON.stringify($scope.actsInProcedure));
					})
				}
				$scope.hide = false;
				$scope.getActAmendments = function(act) {
					$scope.amId = $scope.id ? ($scope.amId = null)
							: act.oznaka.value;
					$scope.acceptedAM = Amendments.actAmendments({
						id : act.oznaka.value
					});
					$scope.acceptedAM.$promise.then(function(data) {
						$scope.amendments = data.results.bindings;
					})
					$scope.hide = !$scope.hide;
				}

				$scope.voteForAmendment = function(za, protiv,am) {
					if (za > protiv) {
						var s = am.amandman.value.split("u_proceduri/")[1]
						console.log('usao')
						$http(
								{
									method : "POST",
									url : 'http://localhost:8081/XMLProject/rest/amendments/update/' + s,
									
								}).success(function() {
									init()
						}).error(function() {
							alert('XML dokument nije validan !')
						})
						init();
					} else if (protiv > za) {
						var s = am.amandman.value.split("u_proceduri/")[1]
						Amendments.deleteAmendment({id : s},init)
						init();
					}
				}
				
				$scope.usvajaSeSve = function(act){
					
					var s = act.akt.value.split("u_proceduri/")[1]
					
					$http(
							{
								method : "POST",
								url : 'http://localhost:8081/XMLProject/rest/amendments/allAccepted/' + s,
								
							}).success(function() {
								init()
					}).error(function() {
						alert('XML dokument nije validan !')
					})
				}

			})

}(angular))
