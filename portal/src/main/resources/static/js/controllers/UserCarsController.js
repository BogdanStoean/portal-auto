angular.module("portal_app")
    .controller("UserCarsController", ["$scope", "$http", function ($scope, $http) {

        $scope.sensorsList = [];
        $scope.car = {};

        $http.get('/cars').success(function (response) {
            $scope.myCars = response;
        });

        $scope.modalShown = false;
        $scope.toggleModal = function () {
            $scope.modalShown = !$scope.modalShown;
            $scope.car = {};
            $scope.submitCar = function () {
                console.log($scope.car);

                $http.post('/cars/create', $scope.car).
                    success(function (data, status, headers, config) {
                        console.log(data);
                        $scope.myCars.push(data);
                        $scope.modalShown = !$scope.modalShown;

                    }).
                    error(function (data, status, headers, config) {
                        console.log(data);
                    });
            }
        };

        $scope.editToggleModalShown = false;
        $scope.editToggleModal = function(carId) {
            $scope.editToggleModalShown = !$scope.editToggleModalShown;
            $http.get('/carSensorCriticalValue/list/'+carId).success(function (response) {
                $scope.sensorsList =  response;
            });

            $http.get('/cars/'+carId).success(function (response) {
                $scope.car =  response;
            });
        };


    }]);

