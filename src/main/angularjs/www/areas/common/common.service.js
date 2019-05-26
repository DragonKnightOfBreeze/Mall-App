angular.module("common", [])
  .service("commonService", function($ionicPopup) {
    this.alertPopup = function(message) {
      $ionicPopup.alert({
        title: "提示",
        template: message
      })
    }
  });
