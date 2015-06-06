angular.module("portal_app")
    .controller("UserCarsController", ["$scope", "$http", function ($scope, $http) {

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
    }]);

