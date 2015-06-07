angular.module("portal_app")
    .controller("DashboardController", ["$scope","$http", function ($scope, $http) {
        $scope.myCars = [];
        $scope.alerts = [];
        $scope.verif = [];

        $http.get('/carFleet/myFlee').success(function (response) {
            $scope.myCars = response;

            $scope.alerts = response.carFleet.filter(function(e) {
                return e.map(function(m) {
                    return m.status.toLowerCase();
                }).filter(function (f) {
                    return f == "alert"
                }).length > 0
            });

            $scope.alerts = response.carFleet.filter(function(e) {
                return e.map(function(m) {
                        return m.status.toLowerCase();
                    }).filter(function (f) {
                        return f == "verificare"
                    }).length > 0
            });

        });

    }]);