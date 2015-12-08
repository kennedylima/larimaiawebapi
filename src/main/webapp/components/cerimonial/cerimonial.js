/**
 * Created by Kennedy on 07/12/2015.
 */
'use strict';
angular.module('app.cerimonial',['ngMaterial'])
    .controller('CerimonialController',function($scope,$http){

        $scope.cerimonial = {} ;
        $scope.cerimoniais = [];



        $scope.listar = function(){
            $http.get('./ws/cerimonial/listar').success(function(dados){
                $scope.cerimoniais = dados;
            });
        };

        $scope.salvar = function(){
            $http.post('./ws/cerimonial/salvar',$scope.cerimonial).success(function(dados){
                window.alert("Sucesso!");
                $scope.cerimonial= {};
                $scope.listar();
            });
        }

        $scope.editar = function(cerimonial){
            $scope.cerimonial = cerimonial;
        }

        $scope.excluir = function(id){
            $http.delete("./ws/cerimonial/excluir/"+id,{}).success(function(){
                window.alert("Removido com Sucesso !");
                $scope.listar();
            });
        }

        $scope.listar();
    });