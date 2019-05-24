angular.module("Route", [""])
  .config(function($stateProvider) {
    $stateProvider.state("tab.details", {
      url: "/details",
      views: {
        "tab-details": {
          templateUrl: "areas/details/details.html",
          controller: "detailsController"
        }
      }
    });
  });
