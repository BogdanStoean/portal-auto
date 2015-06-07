angular.module("portal_app")
    .controller("DashboardController", ["$scope","$http", function ($scope, $http) {
        $scope.myCars = [];

        $http.get('/cars').success(function (response) {
            $scope.myCars = response;
        });

    }]);