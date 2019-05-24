angular.module("cartRoute", ["cart"])
  .config(function($stateProvider) {
    $stateProvider.state("tab.cart", {
      url: "/cart",
      views: {
        "tab-cart": {
          templateUrl: "areas/cart/cart.html",
          controller: "cartController"
        }
      }
    });
  });
