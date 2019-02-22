var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope,$http) {
  $scope.user = {};
  $scope.user.Username = "";
  $scope.user.Password = "";
  
  $scope.login=function(){
	  $http.post("./user/login",{"data":JSON.stringify($scope.user)})
		.then(function(response){
	 		$scope.loginResponse=response.data; 
}); 
  }
});