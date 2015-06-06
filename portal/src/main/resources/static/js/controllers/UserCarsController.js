angular.module("portal_app")
    .controller("UserCarsController",  ["$scope", "$http", function($scope,  $http) {

        $http.get('/cars').success(function (response) {
            $scope.myCars =  response;
        });

    }]);