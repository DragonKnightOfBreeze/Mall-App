angular.module("homeRoute", ["home"])
.config(function($stateProvider) {
  $stateProvider.state("tab.home", {
    url: "/home",
    views: {
      "tab-home": {
        templateUrl: "areas/home/home.html",
        controller: "homeController"
      }
    }
  });
});
