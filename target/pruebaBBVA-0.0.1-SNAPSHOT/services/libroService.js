'use strict';

angular.module('pruebaBBVA')
    .service('libroService', function ($http) {
        return {
            list: function (success) {
                return $http.get("/rest/libro").then(success);
            },
            save: function (libro, success) {
                return $http.post("/rest/libro", libro).then(success);
            }
        };
    });