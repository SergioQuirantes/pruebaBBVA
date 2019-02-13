'use strict';

angular.module('pruebaBBVA')
		.controller('DetailCtrl', function($scope, $routeParams, libroService) {
			
			$scope.get = function() {
				console.log("Hola");
				libroService.get($routeParams.id, function(detail) {
					$scope.detallesLibro = detail.data;
				});
			}
					
			$scope.get();

		});