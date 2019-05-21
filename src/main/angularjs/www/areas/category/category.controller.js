angular.module("category", [])
  .controller("categoryController", function($scope, categoryService) {
    //进入view时触发
    $scope.$on("$ionicView.enter", function(event) {
      getCategoryData();
      $scope.getCategoryDetailData(100);
    });

    //获取侧边栏数据
    function getCategoryData() {
      let promise = categoryService.getCategoryData();
      promise.then(data => {
        if(data) {
          $scope.categoryData = data;
        }
      });
      //获取侧边栏菜单对应的分页信息数据
      $scope.getCategoryDetailData = function(num) {
        let promise = categoryService.getCategoryDetailData(num);
        promise.then(data => {
          if(data) {
            $scope.categoryDetailData = data;
          }
        })
      };
      //左侧分页单击样式修改
      $scope.categoryLeftClick = function(event) {
        $(event.target).addClass("nav-current")
          .siblings().removeClass().addClass("nav-blur");
      };
    }
  });

