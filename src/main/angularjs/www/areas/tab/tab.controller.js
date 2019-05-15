angular.module("tab", [])
.controller("tabController", function($scope, tabService) {
  $scope.cartCountObj = {
    count: 0
  }
});
