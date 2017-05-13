var app=angular.module('app',[]);
app.controller('mycontroller',function($scope,$http,$log)
{
  this.name;
  this.password ;
   this.checkData=function()
   {
      ////////////////////// implement what happen 
      $http.post('localhost:8080/Student/Login/20140077/amira@yahoo').then(function(response)
      {
        $scope.data=response.data;
        $log.info(response);
      } ,function(reason){$scope.error=reason.data ; $log.info(reason); } );

       
      this.name="";
      this.password="";
   }

    
});


