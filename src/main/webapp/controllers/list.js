'use strict';

angular.module('pruebaBBVA')
    .controller('ListCtrl', function ($scope, libroService) {

        $scope.load = function() {
            libroService.list(function (list) {
                $scope.list = list.data;
            });
        }

        $scope.save = function() {
            libroService.save($scope.form, function() {
                $scope.load();
            });
        }

        $scope.form = {};

        $scope.load();
    });