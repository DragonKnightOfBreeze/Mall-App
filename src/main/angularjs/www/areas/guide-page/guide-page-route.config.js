angular.module("guidePageRoute", ["guidePage"])
.config(function($stateProvider) {
  $stateProvider.state("guidePage", {
    url: "/guidePage",
    //url从www目录开始
    templateUrl: "areas/guide-page/guide-page.html",
    controller: "guidePageController"
  })
});
