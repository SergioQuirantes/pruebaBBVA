'use strict';

angular.module('pruebaBBVA')
    .service('libroService', function ($http) {
        return {
            list: function (success) {
                return $http.get("/rest/libro").then(success);
            },
            save: function (libro, success) {
                return $http.post("/rest/libro", libro).then(success);
            },
            get: function(id, success){
            	return $http.get("/rest/libro/" + id).then(success);
            },
            delete: function(id, success){
            	return $http.delete("/rest/libro/" + id).then(success);
            },
            search: function(text, success){
            	return $http.get("/rest/libro/search/" + text).then(success);
            }
        };
    });