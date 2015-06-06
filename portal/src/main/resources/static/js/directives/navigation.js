angular.module('portal_app')
    .directive('navBar', function () {
        return {
            replace: true,
            restrict: 'E',
            templateUrl: '/templates/directives/nav-bar.html',
            controller: function ($scope, $rootScope, $http, $location) {
                $scope.logout = function () {
                    $http.post('logout', {}).success(function () {
                        $rootScope.authenticated = false;
                        $location.path("/");
                    }).error(function () {
                        $rootScope.authenticated = false;
                    });
                };

                return this;
            }
        };
    })
    .directive('navBarItem', function ($location) {
        return {
            replace: true,
            restrict: 'E',
            templateUrl: '/templates/directives/nav-bar-item.html',
            scope: {
                name: '@',
                description: '@'
            },
            link: function (scope, elem, attrs, navBarCtrl) {
                scope.isActive = function () {
                    return scope.name === $location.path();
                };
            }
        }
    });