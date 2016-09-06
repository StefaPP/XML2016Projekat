(function(angular) {
	angular
			.module('amendmentsResource', [ 'ngResource' ])
			.factory(
					'Amendments',
					function($resource) {
						var Amendments = $resource(
								'/amendments',
								{},
								{
									actAmendments : {
										method : 'GET',
										url : 'http://localhost:8081/XMLProject/rest/amendments/actAmendments/:id',
										id : '@id'
									},
									getAcceptedAmendments : {
										method: 'GET',
										url : 'http://localhost:8081/XMLProject/rest/amendments/getAcceptedAmendments/:id',
										id : '@id'
									},
									deleteAmendment : {
										method : 'DELETE',
										url : 'http://localhost:8081/XMLProject/rest/amendments/deleteAmendment/:id',
										id : '@id'
									},
									suggestAmendment : {
										method : 'POST',
										url : 'http://localhost:8081/XMLProject/rest/amendments/suggestAmendment/:amendment',
										amendment : '@amendment'
									},
									isArray : false,
									headers : {
										"Content-Type" : "application/xml"
									},
									update : {
										method : 'POST',
										url : 'http://localhost:8081/XMLProject/rest/amendments/update/:id',
										id : '@id'
									}

								})
						return Amendments;
					})

}(angular))