

	angular
			.module('amendments', [ 'amendmentsResource' ])
			.controller(
					'amendmentsCtrl',
					function($scope, $http, $state, Amendments, Acts) {

						$scope.amendments = {};
						init();
						function init() {
							$scope.act = Acts.getActsInProcedure();
							$scope.act.$promise.then(function(data) {
								$scope.$parent.acts = data.results.bindings;
							})

						}
						$scope.uploadAmendment = function(act, index) {
							var aktic = act.akt.value.substr(53,
									act.akt.value.length)
							var file = document.getElementById(act.naziv.value).files[0];
							console.log(file);
							var fileReader = new FileReader();
							fileReader.onloadend = function(e) {
								console.log("Usao odje ???")
								var data = e.target.result;
								console.log(data)
								$http(
										{
											method : "POST",
											url : 'http://localhost:8081/XMLProject/rest/amendments/suggestAmendment/'
													+ aktic,
											headers : {
												"Content-Type" : "application/xml"
											},
											data : data
										}).success(function() {

								}).error(function() {
									alert('XML dokument nije validan !')
								})

							}
							fileReader.readAsBinaryString(file);
							$state.go('/amendments')
						}

						$scope.hide = false;
						$scope.actAmendments = function(act) {
							$scope.amId = $scope.id ? ($scope.amId = null)
									: act.oznaka.value;
							$scope.actsAM = Amendments.actAmendments({
								id : act.oznaka.value
							});
							$scope.actsAM.$promise.then(function(data) {
								$scope.amendments = data.results.bindings;

							})
							$scope.hide = !$scope.hide;
						}

						$scope.povuciAmandman = function(amId) {
							var s = amId.amandman.value.split("u_proceduri/")[1];
							Amendments.deleteAmendment({
								id : s
							})
							init();
						}
					})

