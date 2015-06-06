angular.module("portal_app")
    .controller("UserCarsController", ["$scope", "$http", function ($scope, $http) {
        $scope.myCars = [];
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
            $http.get('/cars/'+carId).success(function (response) {
                $scope.car =  response;
                $http.get('/carSensorCriticalValue/list/'+carId).success(function (response) {
                    $scope.sensorsList =  response;
                    $scope.editToggleModalShown = !$scope.editToggleModalShown;
                });
            });

            $scope.submitEditCar = function () {
                console.log($scope.car);

                $http.post('/cars/editSensors', {carModel: $scope.car, sensorsList: $scope.sensorsList}).
                    success(function (data, status, headers, config) {
                        console.log(data.carModel);
                        for (var i=0; i<$scope.myCars.length; i++){
                            if($scope.myCars[i].id == data.carModel.id){
                                $scope.myCars[i] = data.carModel;
                                break;
                            }
                        }

                        $scope.editToggleModalShown = !$scope.editToggleModalShown;
                    }).
                    error(function (data, status, headers, config) {
                        console.log(data);
                    });
            }
        };

    }]);

