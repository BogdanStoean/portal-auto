angular.module("portal_app")
    .controller("UserCarsController", ["$scope",  function($scope) {
        $scope.myCars = [{
                'name':'Ford fiest',
                'deviceUUID':'11111',
                'active':true
            },
            {
                'name':'Ford focus',
                'deviceUUID':'11221',
                'active':true
            },{
                'name':'Ford k',
                'deviceUUID':'1551',
                'active':true
            }];

    }]);