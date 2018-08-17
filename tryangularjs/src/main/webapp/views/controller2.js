/**
 * 
 */
angular.module('myApp',[]).controller('list', ['$scope', '$http', function($scope, $http){
	$scope.offset = null;
	$scope.limit = null;
	$scope.lblMsg = null;
	console.log("outside");
	$scope.postdata = function (offset,limit) {
	var data = {
	offset: offset,
	limit: limit,
	}
	//Call the services
    $http.post('http://localhost:8080/restfulservice1/rest/actions/list?key=SHARED_KEY', JSON.stringify(data)).then(function (response) {
    
    if (response.data){
    	$scope.employees = response.data.employees;
    	$scope.msg = "Post Data Submitted Successfully!";
    	}
	}, function (response) {
	$scope.msg = "Service not Exists";

	$scope.statusval = response.status;

	$scope.statustext = response.statusText;

	$scope.headers = response.headers();
	
	});

	};

	}]);