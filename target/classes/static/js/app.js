//alert("Failed to load resource:");

var app=angular.module('app',[]);
app.controller('mycontroller',function($scope,$http,$log)
{
  this.name;
  this.password ;
  
   this.checkData=function()
   {
      ////////////////////// implement what happen 
      $http.post('http://localhost:8080/Student/Login/20140077/amira@yahoo').then(function(response)
      {
        $scope.data=response.data;
        this.name=data.name;
        $log.info(response);
      } ,function(reason){$scope.error=reason.data ; $log.info(reason); } );

      
      this.name="";
      this.password="";
   }

    
});


app.config(['$routeProvider',function($routeProvider){
    $routeProvider
    .when('/',{
         templateUrl : '/partials/home.html'
    })
    .when('/about',{
         templateUrl : 'about.html'
    })
    .when('/account',{
         templateUrl : 'index.html'
    })
    .when('/Dashboard',{
         templateUrl : '/partials/dashBoard.html',
         controller:'dashboardController'
    })



    .otherwise({redirectTo : '/'})

//$locationProvider.html5Mode(true);

}]);
app.controller("dashboardController",function($scope){
    $scope.message="DashBoard";
});

app.controller("homeController",function($scope){
	$scope.redirect = function(){
		  window.location = "#!/partials/login.html";
		}

});

        app.controller('users',['$scope','&http',function users($scope,$http){
          $http.get('js/data.json').success(function(data){
                  $scope.userData=data;
          });
          }]);

app.directive('backImg',function(){
	return function(scope,element,attrs){
		var url=attrs.backImg;
		element.css({
			'background-image':'url('+url+')',
			'background-size':'cover'
		});
	};
});

app.directive("signInDirective",function(){
	return{
		templateUrl:'static/templates/login.html'
	}
});