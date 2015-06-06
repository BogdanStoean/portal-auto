angular.module("portal_app")
    .factory("statusInterceptor", ["$location", "$q", function ($location, $q) {
        return {
            responseError: function (response) {
                if (response.status != 403) {
                    $location.path("/error");
                } else {
                    $rootScope.authenticated = false;
                    $rootScope.user = {}
                }

                return $q.reject(response);
            }
        };
    }]);