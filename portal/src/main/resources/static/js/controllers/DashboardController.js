angular.module("portal_app")
    .controller("DashboardController", ["$scope","$http", function ($scope, $http) {
        $scope.myCars = [];
        $scope.alerts = [];
        $scope.verif = [];

        $scope.detailPanelTitle = 'Alert details';
        $scope.showPabelDetails = false;
        $scope.itemList = [{
            name: 'car 1',
            message: "error 1"
        }, {
            name: 'car 1',
            message: "error 2"
        }]

        $http.get('carFleet/myFleet').success(function (response) {
            $scope.myCars = response;

            for( var c in response.carFleet) {
                for( var s in c.sensorStatusDTOs) {
                    if(s.status.toLowerCase() === "alert")
                        $scope.alerts.push({name: c.name, sensor: s.name});
                    if(s.status.toLowerCase() === "verificare")
                        $scope.verif.push({name: c.name, sensor: s.name});
                }
            }

        });

    }]);