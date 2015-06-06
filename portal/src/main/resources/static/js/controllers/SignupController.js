angular.module("broker")
    .controller("SignupController", ["$scope", "UserService", "$location", function($scope, userService, $location) {
        $scope.showValidation = false;
        $scope.user = {};
        $scope.errors = {};

        $scope.signup = function () {
            if ($scope.signupForm.$valid) {
                userService.save($scope.user, function (data) {
                    $location.path("/signupSuccessful");
                }, function (response) {
                    if (!response.data.success) {
                        angular.forEach(response.data.fieldErrors, function (value) {
                            $scope.signupForm[value.field].$setValidity('server', false);
                            $scope.signupForm[value.field].$dirty = true;
                            $scope.errors[value.field] = value.message;
                        });
                    }
                });
            } else {
                $scope.showValidation = true;
            }

        };
    }]);