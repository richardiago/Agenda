angular
    .module("agenda")
    .controller("cadastroUsuarioController", function ($scope, $http, $state) {

        $scope.cadastrarUsuario = function () {

            $http.post("localhost:8080/usuarios", $scope.fields)
                .then(function () {
                    $state.go("login");
                })
                .catch(function e() {
                    console.error(e);
                })
        }
    });