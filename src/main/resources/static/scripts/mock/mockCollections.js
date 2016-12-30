/*----------------------------------------------------
 Mock des collections
 ------------------------------------------------------*/
var collection01 = {
    nom: 'Botanique',
    uri: 'Collection01.html',
    uriadmin: 'Admin_Collection01.html',
    img: '../images/Collections/Botanique.png',
}
var collection02 = {
    nom: 'Géologie',
    uri: 'Collection02.html',
    uriadmin: 'Admin_Collection02.html',
    img: '../images/Collections/Geologie.png',
}
var collection03 = {
    nom: 'Paléontologie',
    uri: 'Collection03.html',
    uriadmin: 'Admin_Collection03.html',
    img: '../images/Collections/Paleontologie.png',
}
var collection04 = {
    nom: 'Physique',
    uri: 'Collection04.html',
    uriadmin: 'Admin_Collection04.html',
    img: '../images/Collections/Physique.png',
}
var collection05 = {
    nom: 'Zoologie',
    uri: 'Collection05.html',
    uriadmin: 'Admin_Collection05.html',
    img: '../images/Collections/Zoologie.png',
}
var collection06 = {
    nom: 'Typothèque',
    uri: 'Collection06.html',
    uriadmin: 'Admin_Collection06.html',
    img: '../images/Collections/Typotheque.png',
}
var collection07 = {
    nom: 'Instruments',
    uri: 'Collection07.html',
    uriadmin: 'Admin_Collection07.html',
    img: '../images/Collections/Instrument.png',
}
var collection08 = {
    nom: 'Matériel pédagogique',
    uri: 'Collection08.html',
    uriadmin: 'Admin_Collection08.html',
    img: '../images/Collections/MaterielPedagogique.png',
}
var collection09 = {
    nom: 'Ouvrages, cartes et documents',
    uri: 'Collection09.html',
    uriadmin: 'Admin_Collection09.html',
    img: '../images/Collections/Carte.png',
}
var collection10 = {
    nom: 'Préhistoire et archélologie',
    uri: 'Collection10.html',
    uriadmin: 'Admin_Collection10.html',
    img: '../images/Collections/Prehistoire.png',
}
/*----------------------------------------------------
 fin Mock des collections
 ------------------------------------------------------*/
/*var app= angular.module("sitePatrimoine",[]);
app.controller("collectionctrl",function($scope) {
    $scope.collections= collections;
})
*/
var app= angular.module("sitePatrimoine",['ui.materialize']);
app.controller("collectionctrl",function($scope,$http){
    $http.get('/patrimoine/rest/patrimoine/collections').success(function (data) {
        $scope.collections= data;

    })


})

