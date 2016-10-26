var nashorn = angular.module('nashorn');

nashorn.controller('NashornController', ['$scope', '$http', '$interval', function ($scope, $http, $interval)
{
    $scope.nashornobject = {name: "", script: ""}; 
    $scope.servlet = "";
    $scope.results = [];
    
    $scope.init = function(servletname)
    {
        $scope.nashornobject.name = servletname;
        $scope.servlet = servletname;
        console.log("initialised " + servletname); 
    };
    
    $scope.getNashornEngine = function()
    {
        $http({method: 'GET', url: $scope.servlet}).success(function (data, status) {

                    $scope.nashornobject = data;

            }).error(function (data, status) {

            });
    };
    
    $scope.runScript = function()
    {
        $scope.nashornobject.executionid = $scope.generateUUID();
        
        $http({method: 'POST', url: $scope.servlet, data: $scope.nashornobject}).success(function (data, status)
            {
                $scope.nashornobject = data;
                copyExecution = jQuery.extend(true, {}, data);
                $scope.results.unshift(copyExecution);
                console.log($scope.results);
                
            }).error(function (data, status)
            {
                //...and if it doesn't, throw up an error message

            });
        
    };
    
    $scope.resetScript = function()
    {
        $http({method: 'PUT', url: $scope.servlet, data: $scope.nashornobject}).success(function (data, status)
            {
                $scope.nashornobject = data;
                $scope.results = [];
                
            }).error(function (data, status)
            {
                //...and if it doesn't, throw up an error message

            });
        
    };
    
    $scope.generateUUID = function()
    {
        UUID = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
         var r = Math.random()*16|0, v = c === 'x' ? r : (r&0x3|0x8);
         return v.toString(16);
         });
         
         return UUID;
    };
    
    $(document).ready(function ()
    {
        $scope.getNashornEngine();
    });
}]);
