'use strict';
	var museeHome = angular.module('sitePatrimoine', []);

	/*----------------------------------------------------
			Evénéments
	------------------------------------------------------*/
	/*Initialisation de la gestion dynamique des événements*/
	museeHome.controller('EvenementsListCtrl', ['$http', function($http){
	    var sitePatrimoine = this;
	    sitePatrimoine.Evenements = [];
	    sitePatrimoine.EvenementsAccueil01 = {};
	    sitePatrimoine.EvenementsAccueil02 = {};
	    sitePatrimoine.EvenementsAccueil03 = {};
	    sitePatrimoine.EvenementsAccueil04 = {};
	    $http.get('//localhost/sitepatrimoine/scripts/mock/evenementsListe.json').success(function(data){
	      sitePatrimoine.Evenements = data;
	    }).error(function (data){
                console.log("impossible de charger la liste des événements");
        });
	    $http.get('//localhost/sitepatrimoine/scripts/mock/evenementsAcceuilListe.json').success(function(data){
	      sitePatrimoine.EvenementsAccueil01 = data[0];
	      sitePatrimoine.EvenementsAccueil02 = data[1];
	      sitePatrimoine.EvenementsAccueil03 = data[2];
	      sitePatrimoine.EvenementsAccueil04 = data[3];
	    }).error(function (data){
                console.log("impossible de charger la liste des événements de la page d'acceuil");
        });
	}]);
	/*----------------------------------------------------
			Fin Evénéments
	------------------------------------------------------*/


	/*----------------------------------------------------
			Collections
	------------------------------------------------------*/
	museeHome.controller('CollectionListCtrl', ['$http', function($http){
	    var sitePatrimoine = this;
	    sitePatrimoine.Collections = [];
	    $http.get('//localhost/sitepatrimoine/scripts/mock/collections.json').success(function(data){
	      sitePatrimoine.Collections = data;
	    }).error(function (data){
                console.log("impossible de charger la liste des collections");
        });
	}]);
		/*----------------------------------------------------
				Collection 01
		------------------------------------------------------*/
		museeHome.controller('Collection01PageCtrl', ['$http', function($http){
		    var sitePatrimoine = this;
		    sitePatrimoine.Titre ="";
		    sitePatrimoine.Objets = [];
		    $http.get('//localhost/sitepatrimoine/scripts/mock/collections.json').success(function(data){
		      sitePatrimoine.Titre = data[0].nom;
		    }).error(function (data){
	                console.log("impossible de charger la liste des collections");
	        });
		    $http.get('//localhost/sitepatrimoine/scripts/mock/collection01.json').success(function(data){
		      sitePatrimoine.Objets = data;
		    }).error(function (data){
	                console.log("impossible de charger la collection 01");
	        });
		}]);
		/*----------------------------------------------------
				Fin Collection 01
		------------------------------------------------------*/

		/*----------------------------------------------------
				Collection 02
		------------------------------------------------------*/
		museeHome.controller('Collection02PageCtrl', ['$http', function($http){
		    var sitePatrimoine = this;
		    sitePatrimoine.Titre ="";
		    sitePatrimoine.Objets = [];
		    $http.get('//localhost/sitepatrimoine/scripts/mock/collections.json').success(function(data){
		      sitePatrimoine.Titre = data[1].nom;
		    }).error(function (data){
	                console.log("impossible de charger la liste des collections");
	        });
		    $http.get('//localhost/sitepatrimoine/scripts/mock/collection02.json').success(function(data){
		      sitePatrimoine.Objets = data;
		    }).error(function (data){
	                console.log("impossible de charger la collection 02");
	        });
		}]);
		/*----------------------------------------------------
				Fin Collection 02
		------------------------------------------------------*/

		/*----------------------------------------------------
				Collection 03
		------------------------------------------------------*/
		museeHome.controller('Collection03PageCtrl', ['$http', function($http){
		    var sitePatrimoine = this;
		    sitePatrimoine.Titre ="";
		    sitePatrimoine.Objets = [];
		    $http.get('//localhost/sitepatrimoine/scripts/mock/collections.json').success(function(data){
		      sitePatrimoine.Titre = data[2].nom;
		    }).error(function (data){
	                console.log("impossible de charger la liste des collections");
	        });
		    $http.get('//localhost/sitepatrimoine/scripts/mock/collection03.json').success(function(data){
		      sitePatrimoine.Objets = data;
		    }).error(function (data){
	                console.log("impossible de charger la collection 03");
	        });
		}]);
		/*----------------------------------------------------
				Fin Collection 03
		------------------------------------------------------*/

		/*----------------------------------------------------
				Collection 04
		------------------------------------------------------*/
		museeHome.controller('Collection04PageCtrl', ['$http', function($http){
		    var sitePatrimoine = this;
		    sitePatrimoine.Titre ="";
		    sitePatrimoine.Objets = [];
		    $http.get('//localhost/sitepatrimoine/scripts/mock/collections.json').success(function(data){
		      sitePatrimoine.Titre = data[3].nom;
		    }).error(function (data){
	                console.log("impossible de charger la liste des collections");
	        });
		    $http.get('//localhost/sitepatrimoine/scripts/mock/collection04.json').success(function(data){
		      sitePatrimoine.Objets = data;
		    }).error(function (data){
	                console.log("impossible de charger la collection 04");
	        });
		}]);
		/*----------------------------------------------------
				Fin Collection 04
		------------------------------------------------------*/

		/*----------------------------------------------------
				Collection 05
		------------------------------------------------------*/
		museeHome.controller('Collection05PageCtrl', ['$http', function($http){
		    var sitePatrimoine = this;
		    sitePatrimoine.Titre ="";
		    sitePatrimoine.Objets = [];
		    $http.get('//localhost/sitepatrimoine/scripts/mock/collections.json').success(function(data){
		      sitePatrimoine.Titre = data[4].nom;
		    }).error(function (data){
	                console.log("impossible de charger la liste des collections");
	        });
		    $http.get('//localhost/sitepatrimoine/scripts/mock/collection05.json').success(function(data){
		      sitePatrimoine.Objets = data;
		    }).error(function (data){
	                console.log("impossible de charger la collection 05");
	        });
		}]);
		/*----------------------------------------------------
				Fin Collection 05
		------------------------------------------------------*/

		/*----------------------------------------------------
				Collection 06
		------------------------------------------------------*/
		museeHome.controller('Collection06PageCtrl', ['$http', function($http){
		    var sitePatrimoine = this;
		    sitePatrimoine.Titre ="";
		    sitePatrimoine.Objets = [];
		    $http.get('//localhost/sitepatrimoine/scripts/mock/collections.json').success(function(data){
		      sitePatrimoine.Titre = data[5].nom;
		    }).error(function (data){
	                console.log("impossible de charger la liste des collections");
	        });
		    $http.get('//localhost/sitepatrimoine/scripts/mock/collection06.json').success(function(data){
		      sitePatrimoine.Objets = data;
		    }).error(function (data){
	                console.log("impossible de charger la collection 06");
	        });
		}]);
		/*----------------------------------------------------
				Fin Collection 06
		------------------------------------------------------*/

		/*----------------------------------------------------
				Collection 07
		------------------------------------------------------*/
		museeHome.controller('Collection07PageCtrl', ['$http', function($http){
		    var sitePatrimoine = this;
		    sitePatrimoine.Titre ="";
		    sitePatrimoine.Objets = [];
		    $http.get('//localhost/sitepatrimoine/scripts/mock/collections.json').success(function(data){
		      sitePatrimoine.Titre = data[6].nom;
		    }).error(function (data){
	                console.log("impossible de charger la liste des collections");
	        });
		    $http.get('//localhost/sitepatrimoine/scripts/mock/collection07.json').success(function(data){
		      sitePatrimoine.Objets = data;
		    }).error(function (data){
	                console.log("impossible de charger la collection 07");
	        });
		}]);
		/*----------------------------------------------------
				Fin Collection 07
		------------------------------------------------------*/

		/*----------------------------------------------------
				Collection 08
		------------------------------------------------------*/
		museeHome.controller('Collection08PageCtrl', ['$http', function($http){
		    var sitePatrimoine = this;
		    sitePatrimoine.Titre ="";
		    sitePatrimoine.Objets = [];
		    $http.get('//localhost/sitepatrimoine/scripts/mock/collections.json').success(function(data){
		      sitePatrimoine.Titre = data[7].nom;
		    }).error(function (data){
	                console.log("impossible de charger la liste des collections");
	        });
		    $http.get('//localhost/sitepatrimoine/scripts/mock/collection08.json').success(function(data){
		      sitePatrimoine.Objets = data;
		    }).error(function (data){
	                console.log("impossible de charger la collection 08");
	        });
		}]);
		/*----------------------------------------------------
				Fin Collection 08
		------------------------------------------------------*/

		/*----------------------------------------------------
				Collection 09
		------------------------------------------------------*/
		museeHome.controller('Collection09PageCtrl', ['$http', function($http){
		    var sitePatrimoine = this;
		    sitePatrimoine.Titre ="";
		    sitePatrimoine.Objets = [];
		    $http.get('//localhost/sitepatrimoine/scripts/mock/collections.json').success(function(data){
		      sitePatrimoine.Titre = data[8].nom;
		    }).error(function (data){
	                console.log("impossible de charger la liste des collections");
	        });
		    $http.get('//localhost/sitepatrimoine/scripts/mock/collection09.json').success(function(data){
		      sitePatrimoine.Objets = data;
		    }).error(function (data){
	                console.log("impossible de charger la collection 09");
	        });
		}]);
		/*----------------------------------------------------
				Fin Collection 09
		------------------------------------------------------*/

		/*----------------------------------------------------
				Collection 10
		------------------------------------------------------*/
		museeHome.controller('Collection10PageCtrl', ['$http', function($http){
		    var sitePatrimoine = this;
		    sitePatrimoine.Titre ="";
		    sitePatrimoine.Objets = [];
		    $http.get('//localhost/sitepatrimoine/scripts/mock/collections.json').success(function(data){
		      sitePatrimoine.Titre = data[9].nom;
		    }).error(function (data){
	                console.log("impossible de charger la liste des collections");
	        });
		    $http.get('//localhost/sitepatrimoine/scripts/mock/collection10.json').success(function(data){
		      sitePatrimoine.Objets = data;
		    }).error(function (data){
	                console.log("impossible de charger la collection 10");
	        });
		}]);

		museeHome.controller('ObjetCourantCtrl', ['$http', '$sce', function($http, $sce){
			var collection10ObjetsListe = [];
			/* Initialisation de l'objet standard de la collection */
			var objetCourant = {
				id: "",
				titre: "",
				uri: "",
				uriadmin: "",
				img: "",
				imagemodelisation: "",
				nomSci: "",
				nomCom: "",
				periode: "",
				decouverte: "",
				description1: "",
				description2: "",
				description3: "",
				modelisation: ""
			}
		    var obj = this;
		    obj.Titre = "";
			obj.uri = "";
			obj.uriadmin = "";
			obj.img = "";
			obj.imagemodelisation = "";
			obj.nomSci = "";
			obj.nomCom = "";
			obj.periode = "";
			obj.decouverte = "";
			obj.description1 = "";
			obj.description2 = "";
			obj.description3 = "";
			obj.modelisation = "";
		    $http.get('//localhost/sitepatrimoine/scripts/mock/collection10.json').success(function(data){
		      	collection10ObjetsListe = data;
		      	/* Boucle qui permet de remplir le template d'objet en fonction de l'url de la page */
				for (var i = 0; i < collection10ObjetsListe.length; i++) {
					var hrefDeRef = "/pages/" + collection10ObjetsListe[i].uri;
					var hrefCourant = window.location.href.substring(window.location.href.length - 20, window.location.href.length);
					var hrefDeRefAdmin = "/pages/" + collection10ObjetsListe[i].uriadmin;
					var hrefCourantAdmin = window.location.href.substring(window.location.href.length - 26, window.location.href.length);
					if (hrefCourant == hrefDeRef || hrefDeRefAdmin == hrefCourantAdmin) {
						objetCourant = collection10ObjetsListe[i];
					}
				}

				obj.Titre = objetCourant.titre;
				obj.uri = objetCourant.uri;
				obj.uriadmin = objetCourant.uriadmin;
				obj.img = objetCourant.img;
				obj.imagemodelisation = objetCourant.imagemodelisation;
				obj.nomSci = objetCourant.nomSci;
				obj.nomCom = objetCourant.nomCom;
				obj.periode = objetCourant.periode,
				obj.decouverte = objetCourant.decouverte;
				obj.description1 = objetCourant.description1;
				obj.description2 = objetCourant.description2;
				obj.description3 = objetCourant.description3;
				obj.modelisation = $sce.trustAsResourceUrl(objetCourant.modelisation);
		    }).error(function (data){
	                console.log("impossible de charger la collection 10");
	        });
		}]);

		var c10onew = {
			id: "c10onew",
			titre: "Nouvel objet",
			uriadmin: "#newModal",
			img: "../images/Plus.png",
			description: "Cliquer sur cet objet pour en créer un nouveau."
		}

		museeHome.controller("c10onouveau", function() {
			this.Titre = c10onew.titre,
			this.uriadmin = c10onew.uriadmin,
			this.img = c10onew.img,
			this.description = c10onew.description;
		});
		/*----------------------------------------------------
				Collection 10
		------------------------------------------------------*/
	/*----------------------------------------------------
			Collections
	------------------------------------------------------*/