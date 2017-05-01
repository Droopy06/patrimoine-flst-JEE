/**
 * Created by Olive on 11/11/2016.
 */
/*----------------------------------------------------
 Mock des événements
 ------------------------------------------------------*/
var evenement01 = {
    titre: 'Evénement 01',
    miniDescr: "Ceci est un exemple d'événement de niveau 1 (avec une graaaaande image)",
    imageuri: "/images/Evenements/evenement01.png",
    miniimageuri: "/images/Evenements/evenement01mini.png",
    twitter: "#!",
    facebook: "#!",
    go: "#!",
}
var evenement02 = {
    titre: 'Evénement 02',
    miniDescr: "Ceci est un exemple d'événement de niveau 2 (avec une image de taille moyenne)",
    imageuri: "/images/Evenements/evenement02.png",
    miniimageuri: "/images/Evenements/evenement02mini.png",
    twitter: "#!",
    facebook: "#!",
    go: "#!",
}
var evenement03 = {
    titre: 'Evénement 03',
    miniDescr: "Ceci est un exemple d'événement de niveau 3 (avec une petite image)",
    imageuri: "/images/Evenements/evenement03.png",
    miniimageuri: "/images/Evenements/evenement03mini.png",
    twitter: "#!",
    facebook: "#!",
    go: "#!",
}
var evenement04 = {
    titre: 'Evénement 04',
    miniDescr: "Ceci est un exemple d'événement de niveau 3 (avec une petite image)",
    imageuri: "/images/Evenements/evenement04.png",
    miniimageuri: "/images/Evenements/evenement04mini.png",
    twitter: "#!",
    facebook: "#!",
    go: "#!",
}
var evenement05 = {
    titre: 'Evénement 05',
    miniDescr: "Ceci est un exemple d'événement de niveau 3 (avec une petite image)",
    imageuri: "/images/Evenements/evenement05.png",
    miniimageuri: "/images/Evenements/evenement05mini.png",
    twitter: "#!",
    facebook: "#!",
    go: "#!",
}
var eventHome = [];
var app= angular.module("sitePatrimoine",['ui.materialize']);
app.controller("evtsCtrl",function($scope,$http){
    $http.get('/patrimoine/rest/patrimoine/evenement/position/home').success(function (data) {
        $scope.titre1 = data[0].titre;
        $scope.miniDescr1 = data[0].miniDescr;
        $scope.imageuri1 = data[0].imageuri;
        $scope.miniimageuri1=data[0].miniimageuri;
        $scope.twitter1 = data[0].twitter;
        $scope.facebook1 = data[0].facebook;
        $scope.go1 = data[0].go;
        /*----------------------------------------------------
         evenement02
         ------------------------------------------------------*/
        $scope.titre2 = data[1].titre;
        $scope.miniDescr2 = data[1].miniDescr;
        $scope.imageuri2 = data[1].imageuri;
        $scope.miniimageuri2=data[1].miniimageuri;
        $scope.twitter2 = data[1].twitter;
        $scope.facebook2 = data[1].facebook;
        $scope.go2 = data[1].go;
        /*----------------------------------------------------
         evenement03
         ------------------------------------------------------*/
        $scope.titre3 = data[2].titre;
        $scope.miniDescr3 = data[2].miniDescr;
        $scope.imageuri3 = data[2].imageuri;
        $scope.miniimageuri3=data[2].miniimageuri;
        $scope.twitter3 = data[2].twitter;
        $scope.facebook3 = data[2].facebook;
        $scope.go3 = data[2].go
        /*----------------------------------------------------
         evenement04
         ------------------------------------------------------*/
        $scope.titre4 = data[3].titre;
        $scope.miniDescr4 = data[3].miniDescr;
        $scope.imageuri4 = data[3].imageuri;
        $scope.miniimageuri4=data[3].miniimageuri;
        $scope.twitter4 = data[3].twitter;
        $scope.facebook4 = data[3].facebook;
        $scope.go4 = data[3].go;
    });
    /*----------------------------------------------------
     evenement05
     ------------------------------------------------------*/
    $scope.titre5 = evenement05.titre;
    $scope.miniDescr5 = evenement05.miniDescr;
    $scope.imageuri5 = evenement05.imageuri;
    $scope.miniimageuri5=evenement05.miniimageuri;
    $scope.twitter5 = evenement05.twitter;
    $scope.facebook5 = evenement05.facebook;
    $scope.go5 = evenement05.go;

})
var dataMaj = [];var dataInterm = [];var dataMin1 = [];var dataMin2 =[];var dataObjets = [];
app.controller("evenementMajeurCtrl",function($scope,$http){
    $http.get('/patrimoine/rest/patrimoine/evenements').success(function (data) {
        $scope.Evenementsmajeur= data;
        dataMaj = data;
        console.log(dataMaj);
    });
    $scope.select = {
        choices: dataMaj
    };

});
app.controller("evenementIntermCtrl",function($scope,$http){
    $http.get('/patrimoine/rest/patrimoine/evenements').success(function (data) {
        $scope.EvenementsInterm= data;
        dataInterm = data;
        console.log(dataInterm);
    });
    $scope.select = {
        choices: dataInterm
    };

});
app.controller("evenementMineurctrl",function($scope,$http){
    $http.get('/patrimoine/rest/patrimoine/evenements').success(function (data) {
        $scope.EvenementsMineur= data;
        dataMin1 = data;
        console.log(dataMin1);
    });
    $scope.select = {
        choices: dataMin1
    };

});

app.controller("evenementmineurctrl2",function($scope,$http){
    $http.get('/patrimoine/rest/patrimoine/evenements').success(function (data) {
        $scope.EvenementsMineur2= data;
        dataMin1 = data;
        console.log(dataMin1);
    });
    $scope.select = {
        choices: dataMin1
    };

});
app.controller("objetEventsctrl",function($scope,$http){
    $http.get('/patrimoine/rest/patrimoine/evenements').success(function (data) {
        $scope.Objets= data;
        dataObjets = data;
        console.log(dataObjets);
    });

});
var dataObject;
app.controller("Eventctrl",function($scope,$http){
    $scope.init = function (titre) {
        $http.get('/patrimoine/rest/patrimoine/evenement/'+titre).success(function (data) {
            $scope.objet= data;
            dataObject = data;
            console.log(dataObjet);
        })
    }
});
/*----------------------------------------------------
 fin Mock des événements
 ------------------------------------------------------*/