/**
 * Created by Olive on 11/11/2016.
 */
/*----------------------------------------------------
 Mock des événements
 ------------------------------------------------------*/
db.evenement.insert({titre: 'Evénement 01',miniDescr: "Ceci est un exemple d'événement de niveau 1 (avec une graaaaande image)",imageuri: "/images/Evenements/evenement01.png", miniimageuri: "/images/Evenements/evenement01mini.png",twitter: "#!",facebook: "#!",go: "#!"})
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
var app= angular.module("sitePatrimoine",['ui.materialize']);
app.controller("evtsCtrl",function($scope) {
    $scope.titre1 = evenement01.titre;
    $scope.miniDescr1 = evenement01.miniDescr;
    $scope.imageuri1 = evenement01.imageuri;
    $scope.miniimageuri1=evenement01.miniimageuri;
    $scope.twitter1 = evenement01.twitter;
    $scope.facebook1 = evenement01.facebook;
    $scope.go1 = evenement01.go;
    /*----------------------------------------------------
      evenement02
     ------------------------------------------------------*/
    $scope.titre2 = evenement02.titre;
    $scope.miniDescr2 = evenement02.miniDescr;
    $scope.imageuri2 = evenement02.imageuri;
    $scope.miniimageuri2=evenement02.miniimageuri;
    $scope.twitter2 = evenement02.twitter;
    $scope.facebook2 = evenement02.facebook;
    $scope.go2 = evenement02.go;
    /*----------------------------------------------------
     evenement03
     ------------------------------------------------------*/
    $scope.titre3 = evenement03.titre;
    $scope.miniDescr3 = evenement03.miniDescr;
    $scope.imageuri3 = evenement03.imageuri;
    $scope.miniimageuri3=evenement03.miniimageuri;
    $scope.twitter3 = evenement03.twitter;
    $scope.facebook3 = evenement03.facebook;
    $scope.go3 = evenement03.go;
    /*----------------------------------------------------
     evenement04
     ------------------------------------------------------*/
    $scope.titre4 = evenement04.titre;
    $scope.miniDescr4 = evenement04.miniDescr;
    $scope.imageuri4 = evenement04.imageuri;
    $scope.miniimageuri4=evenement04.miniimageuri;
    $scope.twitter4 = evenement04.twitter;
    $scope.facebook4 = evenement04.facebook;
    $scope.go4 = evenement04.go;
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
var dataMaj = [];var dataInterm = [];var dataMin1 = [];var dataMin2 =[];
app.controller("evenementMajeurCtrl",function($scope,$http){
    $http.get('/patrimoine/rest/patrimoine/evenement').success(function (data) {
        $scope.Evenementsmajeur= data;
        dataMaj = data;
        console.log(dataMaj);
    });
    $scope.select = {
        choices: dataMaj
    };

});
app.controller("evenementIntermCtrl",function($scope,$http){
    $http.get('/patrimoine/rest/patrimoine/evenement').success(function (data) {
        $scope.EvenementsInterm= data;
        dataInterm = data;
        console.log(dataInterm);
    });
    $scope.select = {
        choices: dataInterm
    };

});
app.controller("evenementMineurctrl",function($scope,$http){
    $http.get('/patrimoine/rest/patrimoine/evenement').success(function (data) {
        $scope.EvenementsMineur= data;
        dataMin1 = data;
        console.log(dataMin1);
    });
    $scope.select = {
        choices: dataMin1
    };

});

app.controller("evenementmineurctrl2",function($scope,$http){
    $http.get('/patrimoine/rest/patrimoine/evenement').success(function (data) {
        $scope.EvenementsMineur2= data;
        dataMin1 = data;
        console.log(dataMin1);
    });
    $scope.select = {
        choices: dataMin1
    };

});

/*----------------------------------------------------
 fin Mock des événements
 ------------------------------------------------------*/