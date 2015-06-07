angular.module("portal_app")
    .controller("DashboardController", ["$scope", "$http", function ($scope, $http) {
        $scope.myCars = [];
        $scope.alerts = [];
        $scope.verif = [];
        $scope.showList = false;

        $scope.detailPanelTitle = 'Alert details';

        $http.get('carFleet/myFleet').success(function (response) {
            $scope.myCars = response;
            var carFleet = response.carFleet;

            if (carFleet && carFleet.length > 0) {
                for (var i = 0; i < carFleet.length; i++) {
                    var arr = carFleet[i].sensorStatusDTOs;
                    if (arr && arr.length > 0) {
                        for (var j = 0; j < arr.length; j++) {
                            if (arr[j].status.toLowerCase() === "alert") {
                                $scope.alerts.push({name: carFleet[i].name, message: arr[j].name});
                            } else if (arr[j].status.toLowerCase() === "verificare") {
                                $scope.verif.push({name: carFleet[i].name, message: arr[j].name});
                            }
                        }
                    }
                }
            }

        });

    }]);