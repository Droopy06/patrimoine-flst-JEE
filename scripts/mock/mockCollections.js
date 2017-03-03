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
function capitalizeFirstLetter(string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
}
app.controller("collectionobjectctrl",function($scope,$http){
    $scope.init = function (nameCollection,object) {
        $http.get('/patrimoine/rest/patrimoine/'+nameCollection+'/'+object).success(function (data) {
            $scope.Objet= data;
            dataObject = data;
        });
        nameCollection = capitalizeFirstLetter(nameCollection);
        $http.get('/patrimoine/rest/patrimoine/collectionsdetails/'+nameCollection).success(function (data) {
            $scope.Collection= data;
            dataObject = data;
        });
    }

});
function capitalizeString(string){
    return string.toUpperCase();
}
app.filter('truncate', function () {
    return function (input1,input2) {
        if (input) {
            input1 = capitalizeString(input1);
        }
        if(input2) {input2 = capitalizeString(input2);}

            if(!input1){
                return '';
        } else if (input1.indexOf(input2)>-1) {
                var linput2 = input2.length;
                var linput1 = input1.length;
            return input1.slice(linput2+1,linput1); //limit to first 10 characters only
        }
        else
            return input1;
    };
})
/*----------------------------------------------------
 fin Mock des collections
 ------------------------------------------------------*/