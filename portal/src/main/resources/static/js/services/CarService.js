angular.module("portal_app")
    .factory("CarsService", function UserServiceFactory($resource) {
        return $resource('/cars', {}, {});
    });