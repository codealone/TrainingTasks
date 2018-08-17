/**
 * 
 */
var myapp = angular.module('test',[]);
	myapp.controller('edit', ['$scope', '$http', function($scope, $http){
   	$scope.id = null;
	$scope.firstname = null;
	$scope.lastname = null;
	$scope.email = null;
	$scope.postdata = function (id,firstname,lastname,email) {
	var data = {
	id : id,
	firstname : firstname,
	lastname : lastname,
	email : email,
	}
	//Call the services
    $http.post('http://localhost:8080/restfulservice/rest/payment/edit?key=SHARED_KEY', JSON.stringify(data)).then(function (response) {
    	if (response.data){
    	$scope.msg = "Post Data Submitted Successfully!";
    	$scope.stat = response.data;
    	}else if(!response.data){
    		$scope.stat=response.data;
    		$scope.msg="Query could not be completed";
    	}
	}, function (response) {
	$scope.msg = "Incorrect data Request";
	$scope.statusval = response.status;

	$scope.statustext = response.statusText;

	$scope.headers = response.headers();
	
	});

	};

	}]);

myapp.directive('employee', function() {
    return {
        restrict: 'E',
        scope: {
            ngModel: '='
        },
        template: '<div><input type="text" ng-model="ngModel"></div>'            
    };
});
