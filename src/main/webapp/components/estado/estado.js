/**
 * Created by Kennedy on 07/12/2015.
 */
angular.module('app.estado',['ngMaterial'])
    .controller('EstadoController',function($scope,$http){

        $scope.estado = {} ;
        $scope.estados = [];



        $scope.listar = function(){
            $http.get('./ws/estado/listar').success(function(dados){
                $scope.estados = dados;
            });
        };

        $scope.salvar = function(){
            $http.post('./ws/estado/salvar',$scope.estado).success(function(dados){
                window.alert("Sucesso!");
                $scope.estado= {};
                $scope.listar();
            });
        }

        $scope.editar = function(estado){
            $scope.estado = estado;
        }

        $scope.excluir = function(id){
            $http.delete("./ws/estado/excluir/"+id,{}).success(function(){
                window.alert("Removido com Sucesso !");
                $scope.listar();
            });
        }

        $scope.listar();
    });