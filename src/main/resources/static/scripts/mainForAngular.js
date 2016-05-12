'use strict';
	var museeHome = angular.module('sitePatrimoine', []);

	/*----------------------------------------------------
			Evénéments
	------------------------------------------------------*/
	var evenementsListe = [evenement01, evenement02, evenement03, evenement04, evenement05];
	var evenementsAccueilListe = [evenement01, evenement02, evenement03, evenement04];

	/*Initialisation de la gestion dynamique des événements*/
	museeHome.controller('EvenementsListCtrl', function () {
		this.Evenements = evenementsListe;
		this.EvenementsAccueil01 = evenementsAccueilListe[0];
		this.EvenementsAccueil02 = evenementsAccueilListe[1];
		this.EvenementsAccueil03 = evenementsAccueilListe[2];
		this.EvenementsAccueil04 = evenementsAccueilListe[3];
	});
	/*----------------------------------------------------
			Fin Evénéments
	------------------------------------------------------*/


	/*----------------------------------------------------
			Collections
	------------------------------------------------------*/
	var collectionsListe = [collection01, collection02, collection03, collection04, collection05, collection06, collection07, collection08, collection09, collection10];

	museeHome.controller('CollectionListCtrl', function () {
		this.Collections = collectionsListe;
	});

		/*----------------------------------------------------
				Collection 01
		------------------------------------------------------*/
		var collection01ObjetsListe = [c01sc01, c01sc02];

		museeHome.controller('Collection01PageCtrl', function () {
			this.Titre = collection01.nom,
			this.Objets = collection01ObjetsListe;
		});
		/*----------------------------------------------------
				Fin Collection 01
		------------------------------------------------------*/

		/*----------------------------------------------------
				Collection 02
		------------------------------------------------------*/
		var collection02ObjetsListe = [c02sc01, c02sc02];

		museeHome.controller('Collection02PageCtrl', function () {
			this.Titre = collection02.nom,
			this.Objets = collection02ObjetsListe;
		});
		/*----------------------------------------------------
				Fin Collection 02
		------------------------------------------------------*/

		/*----------------------------------------------------
				Collection 03
		------------------------------------------------------*/
		var collection03ObjetsListe = [c03o0001, c03o0002];

		museeHome.controller('Collection03PageCtrl', function () {
			this.Titre = collection03.nom,
			this.Objets = collection03ObjetsListe;
		});
		/*----------------------------------------------------
				Fin Collection 03
		------------------------------------------------------*/

		/*----------------------------------------------------
				Collection 04
		------------------------------------------------------*/
		var collection04ObjetsListe = [c04o0001, c04o0002];

		museeHome.controller('Collection04PageCtrl', function () {
			this.Titre = collection04.nom,
			this.Objets = collection04ObjetsListe;
		});
		/*----------------------------------------------------
				Fin Collection 04
		------------------------------------------------------*/

		/*----------------------------------------------------
				Collection 05
		------------------------------------------------------*/
		var collection05ObjetsListe = [c05sc01, c05sc02, c05sc03, c05sc04, c05sc05, c05sc06, c05sc07, c05sc08, c05sc09];

		museeHome.controller('Collection05PageCtrl', function () {
			this.Titre = collection05.nom,
			this.Objets = collection05ObjetsListe;
		});
		/*----------------------------------------------------
				Fin Collection 05
		------------------------------------------------------*/

		/*----------------------------------------------------
				Collection 06
		------------------------------------------------------*/
		var collection06ObjetsListe = [c06o0001, c06o0002];

		museeHome.controller('Collection06PageCtrl', function () {
			this.Titre = collection06.nom,
			this.Objets = collection06ObjetsListe;
		});
		/*----------------------------------------------------
				Fin Collection 06
		------------------------------------------------------*/

		/*----------------------------------------------------
				Collection 07
		------------------------------------------------------*/
		var collection07ObjetsListe = [c07o0001, c07o0002];

		museeHome.controller('Collection07PageCtrl', function () {
			this.Titre = collection07.nom,
			this.Objets = collection07ObjetsListe;
		});
		/*----------------------------------------------------
				Fin Collection 07
		------------------------------------------------------*/

		/*----------------------------------------------------
				Collection 08
		------------------------------------------------------*/
		var collection08ObjetsListe = [c08o0001, c08o0002];

		museeHome.controller('Collection08PageCtrl', function () {
			this.Titre = collection08.nom,
			this.Objets = collection08ObjetsListe;
		});
		/*----------------------------------------------------
				Fin Collection 08
		------------------------------------------------------*/

		/*----------------------------------------------------
				Collection 09
		------------------------------------------------------*/
		var collection09ObjetsListe = [c09o0001, c09o0002];

		museeHome.controller('Collection09PageCtrl', function () {
			this.Titre = collection09.nom,
			this.Objets = collection09ObjetsListe;
		});
		/*----------------------------------------------------
				Fin Collection 09
		------------------------------------------------------*/

		/*----------------------------------------------------
				Collection 10
		------------------------------------------------------*/
		var collection10ObjetsListe = [c10o0001, c10o0002];

		museeHome.controller('Collection10PageCtrl', function () {
			this.Titre = collection10.nom,
			this.Objets = collection10ObjetsListe;
		});

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

		museeHome.controller("ObjetCourantCtrl", function($sce) {
			this.Titre = objetCourant.titre,
			this.uri = objetCourant.uri,
			this.uriadmin = objetCourant.uriadmin,
			this.img = objetCourant.img,
			this.imagemodelisation = objetCourant.imagemodelisation,
			this.nomSci = objetCourant.nomSci,
			this.nomCom = objetCourant.nomCom,
			this.periode = objetCourant.periode,
			this.decouverte = objetCourant.decouverte,
			this.description1 = objetCourant.description1,
			this.description2 = objetCourant.description2,
			this.description3 = objetCourant.description3,
			this.modelisation = $sce.trustAsResourceUrl(objetCourant.modelisation);
		});

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