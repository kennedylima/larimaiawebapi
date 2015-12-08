/**
 * Created by Lucas, William e Diosefer on 05/10/2015.
 */
'use strict';
angular.module('app.cliente',['ngNewRouter'])
    .controller('ClienteController', function($scope, $http){

    $scope.clientes = {};//Lista de clientes que estão vinculados a tela
    $scope.cliente = {};//Objeto de cliente vinculado a tela
    $scope.estado={};
    $scope.idEstadoSelecionado = 0;
    $scope.estados = [];

   $scope.listar = function(){
       $http.get("ws/cliente/lista").success(function(dados){
           $scope.clientes = dados;
       });
   };

    $scope.estados = function(){
        $http.get("ws/estado/listar").success(function(dados){
            $scope.estados = dados;
        });
    }

    //metodo salvar cliente
    $scope.salvar = function(){
        window.alert($scope.estado.nome+"-"+ $scope.cliente.nome+"-"+ $scope.cliente.email+"-"+ $scope.cliente.telefone);
        $scope.cliente.estado = $scope.estado;
        $http.post("ws/cliente/salvar", $scope.cliente).success(function(dados){
        window.alert("salvo com sucesso");
        $scope.cliente= {};
        $scope.listar();
       });

        
    };



    $scope.excluir =  function (id){$http.delete("ws/cliente/excluir/"+ id).success(function (){ $scope.listar(); });};


    $scope.editar = function(cliente){

        $scope.cliente = cliente;

    }
        $scope.listar();
        $scope.estados();
});
