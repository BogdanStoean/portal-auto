angular.module('portal_app')
    .controller('LoginController', ['$http', '$scope', '$rootScope', '$location', '$routeParams', function ($http, $scope, $rootScope, $location, $routeParams) {

        $scope.login = function () {
            var postData = 'username=' + encodeURIComponent($scope.credentials.username)
                + '&password=' + encodeURIComponent($scope.credentials.password)
                + '&remember-me=' + encodeURIComponent($scope.rememberme);
            $http.post('/login', postData,
                {
                    headers: {"Content-Type": "application/x-www-form-urlencoded"}
                }).success(function (data) {
                    var redirectUri;
                    $rootScope.authenticated = true;
                    $rootScope.user = data;
                    $scope.error = false;

                    redirectUri = $routeParams.redirect_uri || document.referrer;
                    if ($rootScope.postLoginUrl) {
                        $location.path($rootScope.postLoginUrl);
                    } else {
                        window.location.href = redirectUri;
                    }
                }).error(function () {
                    $scope.error = true;
                    $rootScope.authenticated = false;
                });
        };
    }]);