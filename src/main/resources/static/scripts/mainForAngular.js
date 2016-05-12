'use strict';
var URLS = {};
URLS.evenements = /*[[@{/rest/patrimone/evenementss}]]*/ '/rest/patrimone/evenements';
var baseUrl = 'http://localhost:8080/patrimoine/';

var museeHome = angular.module('app', []);
var evenementsListe = [];
var evenementsAccueilListe = [];
$(document).ready(function () {
	$.getJSON(baseUrl+URLS.evenements, function (data) {
		//alert(data);
		//evenementsListe = data;
		museeHome.$scope.evenementsAccueilListe = museeHome.$scope.data;
		//evenementsAccueilListe = [evenementsListe[0],evenementsListe[1],evenementsListe[2],evenementsListe[3]];
		//alert(evenementsListe);
	})
});
var evenement01 = {titre: 'Evénement 01',miniDescr: "Ceci est un exemple d'événement de niveau 1 (avec une graaaaande image)",imageuri: "images/Evenements/evenement01.png",miniimageuri: "images/Evenements/evenement01mini.png", twitter: "#!",facebook: "#!", go: "#!"}
var evenement02 = {titre: 'Evénement 02',miniDescr: "Ceci est un exemple d'événement de niveau 2 (avec une image de taille moyenne)",imageuri: "images/Evenements/evenement02.png",	miniimageuri: "images/Evenements/evenement02mini.png",twitter: "#!",	facebook: "#!",	go: "#!"}
var evenement03 = {titre: 'Evénement 03',miniDescr: "Ceci est un exemple d'événement de niveau 3 (avec une petite image)",imageuri: "images/Evenements/evenement03.png",miniimageuri: "images/Evenements/evenement03mini.png",twitter: "#!",facebook: "#!",	go: "#!"}
var evenement04 = {titre: 'Evénement 04',miniDescr: "Ceci est un exemple d'événement de niveau 3 (avec une petite image)",imageuri: "images/Evenements/evenement04.png",	miniimageuri: "images/Evenements/evenement04mini.png",	twitter: "#!",facebook: "#!",go: "#!"}
var evenement05 = {titre: 'Evénement 05',miniDescr: "Ceci est un exemple d'événement de niveau 3 (avec une petite image)",imageuri: "images/Evenements/evenement05.png",miniimageuri: "images/Evenements/evenement05mini.png",twitter: "#!",facebook: "#!",go: "#!"}

//var evenementsAccueilListe = [{titre: 'Evénement 01',miniDescr: "Ceci est un exemple d'événement de niveau 1 (avec une graaaaande image)",imageuri: "images/Evenements/evenement01.png",miniimageuri: "images/Evenements/evenement01mini.png", twitter: "#!",facebook: "#!", go: "#!"},{titre: 'Evénement 02',miniDescr: "Ceci est un exemple d'événement de niveau 2 (avec une image de taille moyenne)",imageuri: "images/Evenements/evenement02.png",	miniimageuri: "images/Evenements/evenement02mini.png",twitter: "#!",	facebook: "#!",	go: "#!"},{titre: 'Evénement 03',miniDescr: "Ceci est un exemple d'événement de niveau 3 (avec une petite image)",imageuri: "images/Evenements/evenement03.png",miniimageuri: "images/Evenements/evenement03mini.png",twitter: "#!",facebook: "#!",	go: "#!"},{titre: 'Evénement 04',miniDescr: "Ceci est un exemple d'événement de niveau 3 (avec une petite image)",imageuri: "images/Evenements/evenement04.png",	miniimageuri: "images/Evenements/evenement04mini.png",	twitter: "#!",facebook: "#!",go: "#!"}];
/*Initialisation de la gestion dynamique des événements*/
/*museeHome.controller('EvenementsListCtrl', function ($scope) {
	$scope.Evenements = evenementsListe;
});*/



museeHome.controller("evenement01", function($scope) {
	$scope.titre = evenementsAccueilListe[0].titre,
	$scope.miniDescr = evenementsAccueilListe[0].miniDescr,
	$scope.imageuri = evenementsAccueilListe[0].imageuri,
	$scope.twitter = evenementsAccueilListe[0].twitter,
	$scope.facebook = evenementsAccueilListe[0].facebook,
	$scope.go = evenementsAccueilListe[0].go
});

museeHome.controller("evenement02", function($scope) {
	$scope.titre = evenementsAccueilListe[1].titre,
	$scope.miniDescr = evenementsAccueilListe[1].miniDescr,
	$scope.imageuri = evenementsAccueilListe[1].imageuri,
	$scope.twitter = evenementsAccueilListe[1].twitter,
	$scope.facebook = evenementsAccueilListe[1].facebook,
	$scope.go = evenementsAccueilListe[1].go
});

museeHome.controller("evenement03", function($scope) {
	$scope.titre = evenementsAccueilListe[2].titre,
	$scope.miniDescr = evenementsAccueilListe[2].miniDescr,
	$scope.imageuri = evenementsAccueilListe[2].imageuri,
	$scope.twitter = evenementsAccueilListe[2].twitter,
	$scope.facebook = evenementsAccueilListe[2].facebook,
	$scope.go = evenementsAccueilListe[2].go
});

museeHome.controller("evenement04", function($scope) {
	$scope.titre = evenementsAccueilListe[3].titre,
	$scope.miniDescr = evenementsAccueilListe[3].miniDescr,
	$scope.imageuri = evenementsAccueilListe[3].imageuri,
	$scope.twitter = evenementsAccueilListe[3].twitter,
	$scope.facebook = evenementsAccueilListe[3].facebook,
	$scope.go = evenementsAccueilListe[3].go
});

/*Initialisation des collections (remplace ce qui viendrait du métier)*/
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


var collectionsListe = [collection01, collection02, collection03, collection04, collection05, collection06, collection07, collection08, collection09, collection10];
/*Fin initialisation des collections*/

/*Initialisation de la gestion dynamique des collections*/
museeHome.controller('CollectionListCtrl', function ($scope) {
	$scope.Collections = collectionsListe;
});

museeHome.controller('CollectionsPageCtrl', function ($scope) {
	$scope.Collections = collectionsListe;
});
/*Fin initialisation de la gestion dynamique des collections*/

/*Collection 01*/
	/*Initialisation des objets de la collection*/
var c01sc01 = {
	nom: 'Herbiers',
	uri: '#!',
	uriadmin: '#!',
	img: '../images/Collections/Collection01/SousCollections/Herbiers.png',
}
var c01sc02 = {
	nom: 'Jardin N. Boulay',
	uri: '#!',
	uriadmin: '#!',
	img: '../images/Collections/Collection01/SousCollections/JardinNBoulay.png',
}

var collection01ObjetsListe = [c01sc01, c01sc02];

museeHome.controller('Collection01PageCtrl', function ($scope) {
	$scope.Titre = collection01.nom,
	$scope.Objets = collection01ObjetsListe;
});
	/*Fin Initialisation des objets de la collection*/
/*Fin Collection 01*/

/*Collection 02*/
	/*Initialisation des objets de la collection*/
var c02sc01 = {
	nom: 'Minéralogie, cristallographie',
	uri: '#!',
	uriadmin: '#!',
	img: '../images/Collections/Collection02/SousCollections/MineralogieCristallographie.png',
}
var c02sc02 = {
	nom: 'Pétrographie',
	uri: '#!',
	uriadmin: '#!',
	img: '../images/Collections/Collection02/SousCollections/Petrographie.png',
}

var collection02ObjetsListe = [c02sc01, c02sc02];

museeHome.controller('Collection02PageCtrl', function ($scope) {
	$scope.Titre = collection02.nom,
	$scope.Objets = collection02ObjetsListe;
});
	/*Fin Initialisation des objets de la collection*/
/*Fin Collection 02*/

/*Collection 03*/
	/*Initialisation des objets de la collection*/
var c03o0001 = {
	id: "c03o0001",
	titre: "Squelette Dino 1",
	uri: "#!",
	uriadmin: '#!',
	img: "../images/Collections/Collection03/T-Rex.png",
	description1: "Quare hoc quidem praeceptum, cuiuscumque est, ad tollendam amicitiam valet; illud potius praecipiendum fuit, ut eam diligentiam adhiberemus in amicitiis comparandis, ut ne quando amare inciperemus eum, quem aliquando odisse possemus. Quin etiam si minus felices in diligendo fuissemus, ferendum id Scipio potius quam inimicitiarum tempus cogitandum putabat.",
	description2: "Utque aegrum corpus quassari etiam levibus solet offensis, ita animus eius angustus et tener, quicquid increpuisset, ad salutis suae dispendium existimans factum aut cogitatum, insontium caedibus fecit victoriam luctuosam.",
	description3: "Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus agitare quaedam conducentia saluti suae per itinera conaretur, remoti sunt omnes de industria milites agentes in civitatibus perviis.",
}
var c03o0002 = {
	id: "c03o0002",
	titre: "Squelette Dino 1",
	uri: "#!",
	uriadmin: '#!',
	img: "../images/Collections/Collection03/Pterodactile.png",
	description1: "Ego vero sic intellego, Patres conscripti, nos hoc tempore in provinciis decernendis perpetuae pacis habere oportere rationem. Nam quis hoc non sentit omnia alia esse nobis vacua ab omni periculo atque etiam suspicione belli?",
	description2: "Post quorum necem nihilo lenius ferociens Gallus ut leo cadaveribus pastus multa huius modi scrutabatur. quae singula narrare non refert, me professione modum, quod evitandum est, excedamus.",
	description3: "Illud tamen clausos vehementer angebat quod captis navigiis, quae frumenta vehebant per flumen, Isauri quidem alimentorum copiis adfluebant, ipsi vero solitarum rerum cibos iam consumendo inediae propinquantis aerumnas exitialis horrebant.",
}

var collection03ObjetsListe = [c03o0001, c03o0002];

museeHome.controller('Collection03PageCtrl', function ($scope) {
	$scope.Titre = collection03.nom,
	$scope.Objets = collection03ObjetsListe;
});
	/*Initialisation des objets de la collection*/
/*Fin Collection 03*/

/*Collection 04*/
	/*Initialisation des objets de la collection*/
var c04o0001 = {
	id: "c04o0001",
	titre: "Atome",
	uri: "#!",
	uriadmin: '#!',
	img: "../images/Collections/Collection04/Atome.png",
	description1: "Quare hoc quidem praeceptum, cuiuscumque est, ad tollendam amicitiam valet; illud potius praecipiendum fuit, ut eam diligentiam adhiberemus in amicitiis comparandis, ut ne quando amare inciperemus eum, quem aliquando odisse possemus. Quin etiam si minus felices in diligendo fuissemus, ferendum id Scipio potius quam inimicitiarum tempus cogitandum putabat.",
	description2: "Utque aegrum corpus quassari etiam levibus solet offensis, ita animus eius angustus et tener, quicquid increpuisset, ad salutis suae dispendium existimans factum aut cogitatum, insontium caedibus fecit victoriam luctuosam.",
	description3: "Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus agitare quaedam conducentia saluti suae per itinera conaretur, remoti sunt omnes de industria milites agentes in civitatibus perviis.",
}
var c04o0002 = {
	id: "c04o0002",
	titre: "Trou Noir",
	uri: "#!",
	uriadmin: '#!',
	img: "../images/Collections/Collection04/TrouNoir.png",
	description1: "Ego vero sic intellego, Patres conscripti, nos hoc tempore in provinciis decernendis perpetuae pacis habere oportere rationem. Nam quis hoc non sentit omnia alia esse nobis vacua ab omni periculo atque etiam suspicione belli?",
	description2: "Post quorum necem nihilo lenius ferociens Gallus ut leo cadaveribus pastus multa huius modi scrutabatur. quae singula narrare non refert, me professione modum, quod evitandum est, excedamus.",
	description3: "Illud tamen clausos vehementer angebat quod captis navigiis, quae frumenta vehebant per flumen, Isauri quidem alimentorum copiis adfluebant, ipsi vero solitarum rerum cibos iam consumendo inediae propinquantis aerumnas exitialis horrebant.",
}

var collection04ObjetsListe = [c04o0001, c04o0002];

museeHome.controller('Collection04PageCtrl', function ($scope) {
	$scope.Titre = collection04.nom,
	$scope.Objets = collection04ObjetsListe;
});
	/*Initialisation des objets de la collection*/
/*Fin Collection 04*/

/*Collection 05*/
	/*Initialisation des objets de la collection*/
var c05sc01 = {
	nom: 'Mammifères',
	uri: '#!',
	uriadmin: '#!',
	img: '../images/Collections/Collection05/SousCollections/Mammiferes.png',
}
var c05sc02 = {
	nom: 'Reptiles',
	uri: '#!',
	uriadmin: '#!',
	img: '../images/Collections/Collection05/SousCollections/Reptiles.png',
}
var c05sc03 = {
	nom: 'Primates',
	uri: '#!',
	uriadmin: '#!',
	img: '../images/Collections/Collection05/SousCollections/Primates.png',
}
var c05sc04 = {
	nom: 'Oiseaux',
	uri: '#!',
	uriadmin: '#!',
	img: '../images/Collections/Collection05/SousCollections/Oiseaux.png',
}
var c05sc05 = {
	nom: 'Poissons',
	uri: '#!',
	uriadmin: '#!',
	img: '../images/Collections/Collection05/SousCollections/Poissons.png',
}
var c05sc06 = {
	nom: 'Autres vertébrés',
	uri: '#!',
	uriadmin: '#!',
	img: '../images/Collections/Collection05/SousCollections/AutresVertebres.png',
}
var c05sc07 = {
	nom: 'Insectes',
	uri: '#!',
	uriadmin: '#!',
	img: '../images/Collections/Collection05/SousCollections/Insectes.png',
}
var c05sc08 = {
	nom: 'Coquillages',
	uri: '#!',
	uriadmin: '#!',
	img: '../images/Collections/Collection05/SousCollections/Coquillages.png',
}
var c05sc09 = {
	nom: 'Autres invertébrés',
	uri: '#!',
	uriadmin: '#!',
	img: '../images/Collections/Collection05/SousCollections/AutresInvertebres.png',
}

var collection05ObjetsListe = [c05sc01, c05sc02, c05sc03, c05sc04, c05sc05, c05sc06, c05sc07, c05sc08, c05sc09];

museeHome.controller('Collection05PageCtrl', function ($scope) {
	$scope.Titre = collection05.nom,
	$scope.Objets = collection05ObjetsListe;
});
	/*Fin Initialisation des objets de la collection*/
/*Fin Collection 05*/

/*Collection 06*/
	/*Initialisation des objets de la collection*/
var c06o0001 = {
	id: "c06o0001",
	titre: "Ecriture cunéiforme",
	uri: "#!",
	uriadmin: '#!',
	img: "../images/Collections/Collection06/Cuneiforme.png",
	description1: "Quare hoc quidem praeceptum, cuiuscumque est, ad tollendam amicitiam valet; illud potius praecipiendum fuit, ut eam diligentiam adhiberemus in amicitiis comparandis, ut ne quando amare inciperemus eum, quem aliquando odisse possemus. Quin etiam si minus felices in diligendo fuissemus, ferendum id Scipio potius quam inimicitiarum tempus cogitandum putabat.",
	description2: "Utque aegrum corpus quassari etiam levibus solet offensis, ita animus eius angustus et tener, quicquid increpuisset, ad salutis suae dispendium existimans factum aut cogitatum, insontium caedibus fecit victoriam luctuosam.",
	description3: "Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus agitare quaedam conducentia saluti suae per itinera conaretur, remoti sunt omnes de industria milites agentes in civitatibus perviis.",
}
var c06o0002 = {
	id: "c06o0002",
	titre: "Ecriture greque",
	uri: "#!",
	uriadmin: '#!',
	img: "../images/Collections/Collection06/Grec.png",
	description1: "Ego vero sic intellego, Patres conscripti, nos hoc tempore in provinciis decernendis perpetuae pacis habere oportere rationem. Nam quis hoc non sentit omnia alia esse nobis vacua ab omni periculo atque etiam suspicione belli?",
	description2: "Post quorum necem nihilo lenius ferociens Gallus ut leo cadaveribus pastus multa huius modi scrutabatur. quae singula narrare non refert, me professione modum, quod evitandum est, excedamus.",
	description3: "Illud tamen clausos vehementer angebat quod captis navigiis, quae frumenta vehebant per flumen, Isauri quidem alimentorum copiis adfluebant, ipsi vero solitarum rerum cibos iam consumendo inediae propinquantis aerumnas exitialis horrebant.",
}

var collection06ObjetsListe = [c06o0001, c06o0002];

museeHome.controller('Collection06PageCtrl', function ($scope) {
	$scope.Titre = collection06.nom,
	$scope.Objets = collection06ObjetsListe;
});
	/*Initialisation des objets de la collection*/
/*Fin Collection 06*/

/*Collection 07*/
	/*Initialisation des objets de la collection*/
var c07o0001 = {
	id: "c07o0001",
	titre: "Violon",
	uri: "#!",
	uriadmin: '#!',
	img: "../images/Collections/Collection07/Violon.png",
	description1: "Quare hoc quidem praeceptum, cuiuscumque est, ad tollendam amicitiam valet; illud potius praecipiendum fuit, ut eam diligentiam adhiberemus in amicitiis comparandis, ut ne quando amare inciperemus eum, quem aliquando odisse possemus. Quin etiam si minus felices in diligendo fuissemus, ferendum id Scipio potius quam inimicitiarum tempus cogitandum putabat.",
	description2: "Utque aegrum corpus quassari etiam levibus solet offensis, ita animus eius angustus et tener, quicquid increpuisset, ad salutis suae dispendium existimans factum aut cogitatum, insontium caedibus fecit victoriam luctuosam.",
	description3: "Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus agitare quaedam conducentia saluti suae per itinera conaretur, remoti sunt omnes de industria milites agentes in civitatibus perviis.",
}
var c07o0002 = {
	id: "c07o0002",
	titre: "Trompette",
	uri: "#!",
	uriadmin: '#!',
	img: "../images/Collections/Collection07/Trompette.png",
	description1: "Ego vero sic intellego, Patres conscripti, nos hoc tempore in provinciis decernendis perpetuae pacis habere oportere rationem. Nam quis hoc non sentit omnia alia esse nobis vacua ab omni periculo atque etiam suspicione belli?",
	description2: "Post quorum necem nihilo lenius ferociens Gallus ut leo cadaveribus pastus multa huius modi scrutabatur. quae singula narrare non refert, me professione modum, quod evitandum est, excedamus.",
	description3: "Illud tamen clausos vehementer angebat quod captis navigiis, quae frumenta vehebant per flumen, Isauri quidem alimentorum copiis adfluebant, ipsi vero solitarum rerum cibos iam consumendo inediae propinquantis aerumnas exitialis horrebant.",
}

var collection07ObjetsListe = [c07o0001, c07o0002];

museeHome.controller('Collection07PageCtrl', function ($scope) {
	$scope.Titre = collection07.nom,
	$scope.Objets = collection07ObjetsListe;
});
	/*Initialisation des objets de la collection*/
/*Fin Collection 07*/

/*Collection 08*/
	/*Initialisation des objets de la collection*/
var c08o0001 = {
	id: "c08o0001",
	titre: "Craie",
	uri: "#!",
	uriadmin: '#!',
	img: "../images/Collections/Collection08/Craie.png",
	description1: "Quare hoc quidem praeceptum, cuiuscumque est, ad tollendam amicitiam valet; illud potius praecipiendum fuit, ut eam diligentiam adhiberemus in amicitiis comparandis, ut ne quando amare inciperemus eum, quem aliquando odisse possemus. Quin etiam si minus felices in diligendo fuissemus, ferendum id Scipio potius quam inimicitiarum tempus cogitandum putabat.",
	description2: "Utque aegrum corpus quassari etiam levibus solet offensis, ita animus eius angustus et tener, quicquid increpuisset, ad salutis suae dispendium existimans factum aut cogitatum, insontium caedibus fecit victoriam luctuosam.",
	description3: "Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus agitare quaedam conducentia saluti suae per itinera conaretur, remoti sunt omnes de industria milites agentes in civitatibus perviis.",
}
var c08o0002 = {
	id: "c08o0002",
	titre: "Cahier",
	uri: "#!",
	uriadmin: '#!',
	img: "../images/Collections/Collection08/Cahier.png",
	description1: "Ego vero sic intellego, Patres conscripti, nos hoc tempore in provinciis decernendis perpetuae pacis habere oportere rationem. Nam quis hoc non sentit omnia alia esse nobis vacua ab omni periculo atque etiam suspicione belli?",
	description2: "Post quorum necem nihilo lenius ferociens Gallus ut leo cadaveribus pastus multa huius modi scrutabatur. quae singula narrare non refert, me professione modum, quod evitandum est, excedamus.",
	description3: "Illud tamen clausos vehementer angebat quod captis navigiis, quae frumenta vehebant per flumen, Isauri quidem alimentorum copiis adfluebant, ipsi vero solitarum rerum cibos iam consumendo inediae propinquantis aerumnas exitialis horrebant.",
}

var collection08ObjetsListe = [c08o0001, c08o0002];

museeHome.controller('Collection08PageCtrl', function ($scope) {
	$scope.Titre = collection08.nom,
	$scope.Objets = collection08ObjetsListe;
});
	/*Initialisation des objets de la collection*/
/*Fin Collection 08*/

/*Collection 09*/
	/*Initialisation des objets de la collection*/
var c09o0001 = {
	id: "c09o0001",
	titre: "Carte de France",
	uri: "#!",
	uriadmin: '#!',
	img: "../images/Collections/Collection09/CarteFrance.png",
	description1: "Quare hoc quidem praeceptum, cuiuscumque est, ad tollendam amicitiam valet; illud potius praecipiendum fuit, ut eam diligentiam adhiberemus in amicitiis comparandis, ut ne quando amare inciperemus eum, quem aliquando odisse possemus. Quin etiam si minus felices in diligendo fuissemus, ferendum id Scipio potius quam inimicitiarum tempus cogitandum putabat.",
	description2: "Utque aegrum corpus quassari etiam levibus solet offensis, ita animus eius angustus et tener, quicquid increpuisset, ad salutis suae dispendium existimans factum aut cogitatum, insontium caedibus fecit victoriam luctuosam.",
	description3: "Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus agitare quaedam conducentia saluti suae per itinera conaretur, remoti sunt omnes de industria milites agentes in civitatibus perviis.",
}
var c09o0002 = {
	id: "c09o0002",
	titre: "Roman de Renart",
	uri: "#!",
	uriadmin: '#!',
	img: "../images/Collections/Collection09/RomanDeRenart.png",
	description1: "Ego vero sic intellego, Patres conscripti, nos hoc tempore in provinciis decernendis perpetuae pacis habere oportere rationem. Nam quis hoc non sentit omnia alia esse nobis vacua ab omni periculo atque etiam suspicione belli?",
	description2: "Post quorum necem nihilo lenius ferociens Gallus ut leo cadaveribus pastus multa huius modi scrutabatur. quae singula narrare non refert, me professione modum, quod evitandum est, excedamus.",
	description3: "Illud tamen clausos vehementer angebat quod captis navigiis, quae frumenta vehebant per flumen, Isauri quidem alimentorum copiis adfluebant, ipsi vero solitarum rerum cibos iam consumendo inediae propinquantis aerumnas exitialis horrebant.",
}

var collection09ObjetsListe = [c09o0001, c09o0002];

museeHome.controller('Collection09PageCtrl', function ($scope) {
	$scope.Titre = collection09.nom,
	$scope.Objets = collection09ObjetsListe;
});
	/*Initialisation des objets de la collection*/
/*Fin Collection 09*/

/*Collection 10*/
	/*Initialisation des objets de la collection*/
var c10o0001 = {
	id: "c10o0001",
	titre: "Sahelanthropus tchadensis, Toumaï",
	uri: "c10o0001.html",
	uriadmin: "Admin_c10o0001.html",
	img: "../images/Collections/Collection10/SahelanthropusTchadensis_Toumai.png",
	imagemodelisation: "../images/Collections/Collection10/SahelanthropusTchadensis_ToumaiModelisation.png",
	nomSci: "Sahelanthropus tchadensis",
	nomCom: "Toumai",
	periode: "7 millions d'années avant le présent (=avant 1950)",
	decouverte: "Quelque part à un moment",
	description1: "Quare hoc quidem praeceptum, cuiuscumque est, ad tollendam amicitiam valet; illud potius praecipiendum fuit, ut eam diligentiam adhiberemus in amicitiis comparandis, ut ne quando amare inciperemus eum, quem aliquando odisse possemus. Quin etiam si minus felices in diligendo fuissemus, ferendum id Scipio potius quam inimicitiarum tempus cogitandum putabat.",
	description2: "Utque aegrum corpus quassari etiam levibus solet offensis, ita animus eius angustus et tener, quicquid increpuisset, ad salutis suae dispendium existimans factum aut cogitatum, insontium caedibus fecit victoriam luctuosam.",
	description3: "Quo cognito Constantius ultra mortalem modum exarsit ac nequo casu idem Gallus de futuris incertus agitare quaedam conducentia saluti suae per itinera conaretur, remoti sunt omnes de industria milites agentes in civitatibus perviis.",
	modelisation: "https://sketchfab.com/models/d9626d3f19904df191e0fa9e1db9e198/embed"
}
var c10o0002 = {
	id: "c10o0002",
	titre: "Homo Sapiens",
	uri: "c10o0002.html",
	uriadmin: "Admin_c10o0002.html",
	img: "../images/Collections/Collection10/HomoSapiens.png",
	imagemodelisation: "../images/Collections/Collection10/HomoSapiensModelisation.png",
	nomSci: "Homo Sapiens",
	nomCom: "Homme moderne",
	periode: "200 000 ans avant le présent (=avant 1950)",
	decouverte: "Quelque part à un moment",
	description1: "Ego vero sic intellego, Patres conscripti, nos hoc tempore in provinciis decernendis perpetuae pacis habere oportere rationem. Nam quis hoc non sentit omnia alia esse nobis vacua ab omni periculo atque etiam suspicione belli?",
	description2: "Post quorum necem nihilo lenius ferociens Gallus ut leo cadaveribus pastus multa huius modi scrutabatur. quae singula narrare non refert, me professione modum, quod evitandum est, excedamus.",
	description3: "Illud tamen clausos vehementer angebat quod captis navigiis, quae frumenta vehebant per flumen, Isauri quidem alimentorum copiis adfluebant, ipsi vero solitarum rerum cibos iam consumendo inediae propinquantis aerumnas exitialis horrebant.",
	modelisation: "https://sketchfab.com/models/fce6d8ae677b4238a2735a1c08ef4b26/embed"
}

var collection10ObjetsListe = [c10o0001, c10o0002];

museeHome.controller('Collection10PageCtrl', function ($scope) {
	$scope.Titre = collection10.nom,
	$scope.Objets = collection10ObjetsListe;
});
	/*Initialisation des objets de la collection*/

	/*Gestion dynamique des objet de la collection*/
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

for (var i = 0; i < collection10ObjetsListe.length; i++) {
	var hrefDeRef = "/pages/" + collection10ObjetsListe[i].uri;
	var hrefCourant = window.location.href.substring(window.location.href.length - 20, window.location.href.length);
	var hrefDeRefAdmin = "/pages/" + collection10ObjetsListe[i].uriadmin;
	var hrefCourantAdmin = window.location.href.substring(window.location.href.length - 26, window.location.href.length);
	if (hrefCourant == hrefDeRef || hrefDeRefAdmin == hrefCourantAdmin) {
		objetCourant = collection10ObjetsListe[i];
	}
}

museeHome.controller("objetCourant", function($scope, $sce) {
	$scope.titre = objetCourant.titre,
	$scope.uri = objetCourant.uri,
	$scope.uriadmin = objetCourant.uriadmin,
	$scope.img = objetCourant.img,
	$scope.imagemodelisation = objetCourant.imagemodelisation,
	$scope.nomSci = objetCourant.nomSci,
	$scope.nomCom = objetCourant.nomCom,
	$scope.periode = objetCourant.periode,
	$scope.decouverte = objetCourant.decouverte,
	$scope.description1 = objetCourant.description1,
	$scope.description2 = objetCourant.description2,
	$scope.description3 = objetCourant.description3,
	$scope.modelisation = $sce.trustAsResourceUrl(objetCourant.modelisation);
});

var c10onew = {
	id: "c10onew",
	titre: "Nouvel objet",
	uriadmin: "#newModal",
	img: "../images/Plus.png",
	description: "Cliquer sur cet objet pour en créer un nouveau."
}

museeHome.controller("c10onouveau", function($scope) {
	$scope.titre = c10onew.titre,
	$scope.uriadmin = c10onew.uriadmin,
	$scope.img = c10onew.img,
	$scope.description = c10onew.description;
});
	/*Fin Gestion dynamique des objet de la collection*/
/*Fin Collection 10*/



