var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope,$http) {
  $scope.article = [];
  $http.get("./news/showDB")
  		.then(function(response){
	 		$scope.article=response.data; 
  });
});