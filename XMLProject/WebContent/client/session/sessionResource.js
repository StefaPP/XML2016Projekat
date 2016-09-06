(function(angular) {
	angular
			.module('sessionResource', [ 'ngResource' ])
			.factory(
					'Session',
					function($resource) {
						var Session = $resource(
								'/session',
								{},
								{
									voteFor : {
										method : 'POST',
										url : 'http://localhost:8081/XMLProject/rest/amendments/voteFor/:id',
										id : '@id'
									},
									allAccepted : {
										method : 'POST',
										url : 'http://localhost:8081/XMLProject/rest/amendments/all/:id',
										id : '@id'
									}
								})

						return Session;
					})

})