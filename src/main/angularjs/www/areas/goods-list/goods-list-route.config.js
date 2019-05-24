angular.module("goodsListRoute", ["goodsList"])
  .config(function($stateProvider) {
    $stateProvider.state("tab.goods-list", {
      url: "/goods-list",
      views: {
        "tab-goods-list": {
          templateUrl: "areas/goods-list/goods-list.html",
          controller: "goodsListController"
        }
      }
    });
  });
