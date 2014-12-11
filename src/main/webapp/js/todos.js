(function() {

var tasksApp = angular.module("TasksApp", []);

tasksApp.controller("TasksController", function ($scope, $http, $log) {
    $http.get("api/todos/all").success(function(data) {
        $scope.tasks = data;
    });
    
    $scope.text = "";
    $scope.body = "";

    $scope.create = function() {
        var data = {
            title: $scope.title,
            body: $scope.body
        };

        $log.info("Sending", data, "to server");

        $http.post("api/todos/new", data)
        .success(function(data) {
            $scope.tasks.push(data);
            $("#newtaskdialog").modal("hide");
        })
        .error(function(data) {
            
        });
    }
});

})();
