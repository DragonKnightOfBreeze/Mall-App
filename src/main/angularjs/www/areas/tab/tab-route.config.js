angular.module("tabRoute", ["tab"])
.config(function($stateProvider) {
  $stateProvider.state("tab", {
    url: "/tab",
    //声明为抽象路由
    abstract: true,
    templateUrl: "areas/tab/tab.html",
    controller: "tabController"
  });
});
