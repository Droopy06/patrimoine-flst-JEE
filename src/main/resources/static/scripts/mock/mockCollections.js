/*----------------------------------------------------
 Mock des collections
 ------------------------------------------------------*/
var app= angular.module("sitePatrimoine",['ui.materialize']);
var data2 = [];var dataObjects = [];var dataObject = [];
app.controller("collectionctrl",function($scope,$http){
    $http.get('/patrimoine/rest/patrimoine/collections').success(function (data) {
        $scope.collections= data;
        data2 = data;
        console.log(data2);
    });
    $scope.select = {
        choices: data2
    };

});
app.controller("collectionobjectsctrl",function($scope,$http){
    $scope.init = function (nameCollection) {
        $http.get('/patrimoine/rest/patrimoine/'+nameCollection).success(function (data) {
            $scope.Objets= data;
            dataObjects = data;
            console.log(dataObjects);
        })
    }

});
app.controller("collectionobjectctrl",function($scope,$http){
    $scope.init = function (nameCollection,object) {
        $http.get('/patrimoine/rest/patrimoine/'+nameCollection+'/'+object).success(function (data) {
            $scope.Objet= data;
            dataObject = data;
        });
        $http.get('/patrimoine/rest/patrimoine/collectionsdetails/'+nameCollection).success(function (data) {
            $scope.Collection= data;
            dataObject = data;
        });
    }

});
/*----------------------------------------------------
 fin Mock des collections
 ------------------------------------------------------*/