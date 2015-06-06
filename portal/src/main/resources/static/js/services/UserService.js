angular.module("broker")
    .factory("UserService", function UserServiceFactory($resource) {
        return $resource('/user/:id', {}, {});
    });