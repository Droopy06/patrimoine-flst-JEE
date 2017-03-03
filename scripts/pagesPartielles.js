'use strict';

	/*----------------------------------------------------
			Gestion des pages partielles
	------------------------------------------------------*/
		/*----------------------------------------------------
				pages partielles générales
		------------------------------------------------------*/
			museeHome.directive('headerContent', function(){
				return{
					restrict: 'A',
					templateUrl: 'PartialPages/_header.html'
				};
			});

			museeHome.directive('adminHeaderContent', function(){
				return{
					restrict: 'A',
					templateUrl: 'PartialPages/_admin_header.html'
				};
			});

			museeHome.directive('hautFooterContent', function(){
				return{
					restrict: 'A',
					templateUrl: 'PartialPages/_hautFooter.html'
				};
			});

			museeHome.directive('adminHautFooterContent', function(){
				return{
					restrict: 'A',
					templateUrl: 'PartialPages/_admin_hautFooter.html'
				};
			});

			museeHome.directive('footerContent', function(){
				return{
					restrict: 'A',
					templateUrl: 'PartialPages/_footer.html'
				};
			});
		/*----------------------------------------------------
				fin pages partielles générales
		------------------------------------------------------*/

		/*----------------------------------------------------
				pages partielles acceuil
		------------------------------------------------------*/
			museeHome.directive('homeContent', function(){
				return{
					restrict: 'A',
					templateUrl: 'PartialPages/Contents/_home.html'
				};
			});

			museeHome.directive('adminHomeContent', function(){
				return{
					restrict: 'A',
					templateUrl: 'PartialPages/Contents/_admin_home.html'
				};
			});

			museeHome.directive('modalsHomeScript', function(){
				return{
					restrict: 'A',
					templateUrl: 'PartialPages/_admin_modals_home.html'
				};
			});
		/*----------------------------------------------------
				pages partielles acceuil
		------------------------------------------------------*/

		/*----------------------------------------------------
				pages partielles collections
		------------------------------------------------------*/
			museeHome.directive('collectionsContent', function(){
				return{
					restrict: 'A',
					templateUrl: 'PartialPages/Contents/_collections.html'
				};
			});

			museeHome.directive('adminCollectionsContent', function(){
				return{
					restrict: 'A',
					templateUrl: 'PartialPages/Contents/_admin_collections.html'
				};
			});

			/*----------------------------------------------------
					pages partielles collection 01
			------------------------------------------------------*/
				museeHome.directive('collection01Content', function(){
					return{
						restrict: 'A',
						templateUrl: 'PartialPages/Contents/_collection01.html'
					};
				});

				museeHome.directive('adminCollection01Content', function(){
					return{
						restrict: 'A',
						templateUrl: 'PartialPages/Contents/_admin_collection01.html'
					};
				});
			/*----------------------------------------------------
					fin pages partielles collection 01
			------------------------------------------------------*/

			/*----------------------------------------------------
					pages partielles collection 02
			------------------------------------------------------*/
				museeHome.directive('collection02Content', function(){
					return{
						restrict: 'A',
						templateUrl: 'PartialPages/Contents/_collection02.html'
					};
				});

				museeHome.directive('adminCollection02Content', function(){
					return{
						restrict: 'A',
						templateUrl: 'PartialPages/Contents/_admin_collection02.html'
					};
				});
			/*----------------------------------------------------
					pages partielles collection 02
			------------------------------------------------------*/

			/*----------------------------------------------------
					pages partielles collection 03
			------------------------------------------------------*/
				museeHome.directive('collection03Content', function(){
					return{
						restrict: 'A',
						templateUrl: 'PartialPages/Contents/_collection03.html'
					};
				});

				museeHome.directive('adminCollection03Content', function(){
					return{
						restrict: 'A',
						templateUrl: 'PartialPages/Contents/_admin_collection03.html'
					};
				});
			/*----------------------------------------------------
					pages partielles collection 03
			------------------------------------------------------*/

			/*----------------------------------------------------
					pages partielles collection 04
			------------------------------------------------------*/
				museeHome.directive('collection04Content', function(){
					return{
						restrict: 'A',
						templateUrl: 'PartialPages/Contents/_collection04.html'
					};
				});

				museeHome.directive('adminCollection04Content', function(){
					return{
						restrict: 'A',
						templateUrl: 'PartialPages/Contents/_admin_collection04.html'
					};
				});
			/*----------------------------------------------------
					pages partielles collection 04
			------------------------------------------------------*/

			/*----------------------------------------------------
					pages partielles collection 05
			------------------------------------------------------*/
				museeHome.directive('collection05Content', function(){
					return{
						restrict: 'A',
						templateUrl: 'PartialPages/Contents/_collection05.html'
					};
				});

				museeHome.directive('adminCollection05Content', function(){
					return{
						restrict: 'A',
						templateUrl: 'PartialPages/Contents/_admin_collection05.html'
					};
				});
			/*----------------------------------------------------
					pages partielles collection 05
			------------------------------------------------------*/

			/*----------------------------------------------------
					pages partielles collection 06
			------------------------------------------------------*/
				museeHome.directive('collection06Content', function(){
					return{
						restrict: 'A',
						templateUrl: 'PartialPages/Contents/_collection06.html'
					};
				});

				museeHome.directive('adminCollection06Content', function(){
					return{
						restrict: 'A',
						templateUrl: 'PartialPages/Contents/_admin_collection06.html'
					};
				});
			/*----------------------------------------------------
					pages partielles collection 06
			------------------------------------------------------*/

			/*----------------------------------------------------
					pages partielles collection 07
			------------------------------------------------------*/
				museeHome.directive('collection07Content', function(){
					return{
						restrict: 'A',
						templateUrl: 'PartialPages/Contents/_collection07.html'
					};
				});

				museeHome.directive('adminCollection07Content', function(){
					return{
						restrict: 'A',
						templateUrl: 'PartialPages/Contents/_admin_collection07.html'
					};
				});
			/*----------------------------------------------------
					pages partielles collection 07
			------------------------------------------------------*/

			/*----------------------------------------------------
					pages partielles collection 08
			------------------------------------------------------*/
				museeHome.directive('collection08Content', function(){
					return{
						restrict: 'A',
						templateUrl: 'PartialPages/Contents/_collection08.html'
					};
				});

				museeHome.directive('adminCollection08Content', function(){
					return{
						restrict: 'A',
						templateUrl: 'PartialPages/Contents/_admin_collection08.html'
					};
				});
			/*----------------------------------------------------
					pages partielles collection 08
			------------------------------------------------------*/

			/*----------------------------------------------------
					pages partielles collection 09
			------------------------------------------------------*/
				museeHome.directive('collection09Content', function(){
					return{
						restrict: 'A',
						templateUrl: 'PartialPages/Contents/_collection09.html'
					};
				});

				museeHome.directive('adminCollection09Content', function(){
					return{
						restrict: 'A',
						templateUrl: 'PartialPages/Contents/_admin_collection09.html'
					};
				});
			/*----------------------------------------------------
					pages partielles collection 09
			------------------------------------------------------*/

			/*----------------------------------------------------
					pages partielles collection 10
			------------------------------------------------------*/
				museeHome.directive('collection10Content', function(){
					return{
						restrict: 'A',
						templateUrl: 'PartialPages/Contents/_collection10.html'
					};
				});

				museeHome.directive('adminCollection10Content', function(){
					return{
						restrict: 'A',
						templateUrl: 'PartialPages/Contents/_admin_collection10.html'
					};
				});

				museeHome.directive('c10objectContent', function(){
					return{
						restrict: 'A',
						templateUrl: 'PartialPages/Contents/_c10object.html'
					};
				});

				museeHome.directive('adminC10objectContent', function(){
					return{
						restrict: 'A',
						templateUrl: 'PartialPages/Contents/_admin_c10object.html'
					};
				});
			/*----------------------------------------------------
					pages partielles collection 10
			------------------------------------------------------*/
		/*----------------------------------------------------
				fin pages partielles acceuil
		------------------------------------------------------*/
	/*----------------------------------------------------
			Fin Gestion des pages partielles
	------------------------------------------------------*/