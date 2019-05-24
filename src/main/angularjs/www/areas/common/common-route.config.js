angular.module("detailsRoute", ["details"])
  .config(function($stateProvider) {
    $stateProvider.state("tab.common", {
      url: "/common",
      views: {
        "tab-common": {
          templateUrl: "areas/common/common.html",
          controller: "commonController"
        }
      }
    });
  });
