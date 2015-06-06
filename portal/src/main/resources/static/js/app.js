angular.module('portal_app', ['ngRoute', 'ngMessages', 'ngResource', 'validation.match','ui.bootstrap'])
    .run(function ($rootScope, $location, $http) {
        $http.get('/user').success(function (data) {
            $rootScope.authenticated = true;
            $rootScope.user = data;
        }).error(function () {
            $rootScope.authenticated = false;
        });

        $rootScope.$on("$routeChangeStart", function (event, next, current) {
            if (next.auth && !$rootScope.authenticated) {
                $http.get('/user').success(function (data) {
                    $rootScope.authenticated = true;
                    $rootScope.user = data;
                }).error(function () {
                    $rootScope.authenticated = false;
                    $rootScope.postLoginUrl = $location.path();
                    $location.path("/login");
                });
            }
        });
    });