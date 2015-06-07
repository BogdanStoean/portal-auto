angular.module("portal_app")
    .controller("DashboardController", ["$scope","$http", function ($scope, $http) {
        $scope.myCars = [];
        $scope.alerts = [];
        $scope.verif = [];

        $http.get('carFleet/myFleet').success(function (response) {
            $scope.myCars = response;

            for(c in response.carFleet) {
                for(s in c.sensorStatusDTOs) {
                    if(s.status.toLowerCase() === "alert")
                        $scope.alerts.push({name: c.name, sensor: s.name});
                    if(s.status.toLowerCase() === "verificare")
                        $scope.verif.push({name: c.name, sensor: s.name});
                }
            }

        });

    }]);