angular.module("portal_app")
    .factory("CarsService", function CarServiceFactory($http) {
        //return $resource('/cars', {}, {});

        return({
            addCar: addCar,
            getCars: getCars,
            editCar: editCar
        });

        function addCar( car ) {

        }

        function getCars( ) {
            return $http.get('/cars');
        }

        function editCar(car) {

        }
    });