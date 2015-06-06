angular.module("portal_app")
    .factory("UserService", function UserServiceFactory($resource) {
        return $resource('/user/:id', {}, {});
    });