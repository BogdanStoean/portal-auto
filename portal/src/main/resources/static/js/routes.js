angular.module('portal_app')
    .config(function ($routeProvider, $httpProvider) {
        $routeProvider
            .when('/', {
                template: " ",
                controller: function ($rootScope, $location, $http) {
                    if ($rootScope.authenticated) {
                        $location.path("/myHome");
                    } else {
                        $http.get('/user').success(function (data) {
                            $rootScope.authenticated = true;
                            $rootScope.user = data;
                            $location.path("/myHome");

                        }).error(function () {
                            $rootScope.authenticated = false;
                            $location.path("/home");
                        });
                    }
                }
            })
            .when('/home', {
                templateUrl: '/templates/home.html'
            })
            .when('/login', {
                templateUrl: '/templates/login.html',
                controller: 'LoginController'
            })
            .when('/signup', {
                templateUrl: '/templates/signup.html',
                controller: 'SignupController'
            })
            .when('/signupSuccessful', {
                templateUrl: '/templates/signupSuccessful.html'
            })
            .when("/error", {
                templateUrl: "/templates/error/error.html"
            })
            .otherwise('/');

        //authenticated pages
        $routeProvider
            .when('/myHome', {
                templateUrl: '/templates/myHome.html',
                controller: 'DashboardController',
                auth: true
            }).when('/myCars', {
                templateUrl: '/templates/myCars.html',
                controller: 'UserCarsController',
                auth: true
            }).when('/map/:carId', {
                templateUrl: '/templates/map.html',
                controller: 'MapController',
                auth: true
            }).when('/carDocuments/:carId', {
                templateUrl: '/templates/myDocuments.html',
                controller: 'DocumentsController',
                auth: true
            });

        $httpProvider.interceptors.push("statusInterceptor");
        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    });