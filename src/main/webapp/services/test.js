'use strict';

angular.module('pruebaBBVA')
    .service('test', function ($http) {
        return {
            list: function (success) {
                return $http.get("/rest/libro").then(success);
            },
            save: function (test, success) {
                return $http.post("/rest/libro", test).then(success);
            }
        };
    });