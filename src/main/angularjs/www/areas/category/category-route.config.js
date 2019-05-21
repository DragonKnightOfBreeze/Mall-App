angular.module("categoryRoute", ["category"])
  .config(function($stateProvider) {
    $stateProvider.state("tab.category", {
      url: "/category",
      views: {
        "tab-category": {
          templateUrl: "areas/category/category.html",
          controller: "categoryController"
        }
      }
    });
  });
