angular.module("accountRoute", ["account"])
  .config(function($stateProvider) {
    $stateProvider.state("tab.account", {
      url: "/account",
      views: {
        "tab-account": {
          templateUrl: "areas/account/account.html",
          controller: "accountController"
        }
      }
    });
  });
