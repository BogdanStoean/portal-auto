angular.module("portal_app")
    .controller("UserCarsController",  ["$scope", "CarsService",  function($scope, CarsService) {
        $scope.myCars = CarsService.getCars();

    }]);