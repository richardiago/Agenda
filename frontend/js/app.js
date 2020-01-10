angular.module("agenda", ["ui.router"]);

var app = angular.module("agenda");
app.config([
    "$httpProvider",
    function ($httpProvider) {
        $httpProvider.defaults.useXDomain = true;
        $httpProvider.defaults.withCredentials = true;
        delete $httpProvider.defaults.headers.common["X-Requested-With"];
        $httpProvider.defaults.headers.common["Accept"] = "application/json";
        $httpProvider.defaults.headers.common["Content-Type"] = "application/json";
    }
]);

app.config(function ($stateProvider, $urlRouterProvider, $locationProvider) {

    $urlRouterProvider.otherwise("/home");

    $stateProvider.state("home", {
        url: "/home",
        templateUrl: "../view/home.html",
        params: { from: null },
        controller: "homeController"
    });

    $stateProvider.state("login", {
        url: "/login",
        templateUrl: "../view/login.html",
        controller: "loginController"
    });

    $stateProvider.state("cadastroContato", {
        url: "/cadastroContato",
        templateUrl: "../view/cadastroContato.html",
        controller: "cadastroContatoController"
    });

    $stateProvider.state("cadastroUsuario", {
        url: "/cadastroUsuario",
        templateUrl: "../view/cadastroUsuario.html",
        controller: "cadastroUsuarioController"
    });

    $stateProvider.state("listarContato", {
        url: "/listarContato",
        templateUrl: "../view/listarContato.html",
        controller: "listarContatoController"
    });

    $stateProvider.state("buscarContato", {
        url: "/buscarContato",
        templateUrl: "../view/buscarContato.html",
        controller: "buscarContatoController"
    });


    $locationProvider.html5Mode(true);
})