angular.module("goodsList", [])
  .controller("goodsListController", function($scope, goodsListService, $stateParams, $ionicLoading, $ionicHistory) {
    //和前台页面绑定的页面对象
    $scope.goodsListData = [];
    //判断有没有更多数据可以加载
    $scope.isMoreItemsAvailable = true;
    //分页查询对象
    $scope.pageable = {page: 1, size: 6, typeNumber: ""};
    //下拉菜单刷新数据的方法
    $scope.refreshGoodsList = function() {
      //修改分页信息对象
      $scope.pageable.page = 1;
      $scope.pageable.typeNumber = $stateParams.typeNumber;
      let message = JSON.stringify($scope.pageable);
      let promise = goodsListService.refresh(message);
      promise.then(
        //成功的回调
        data => {
          if(data) {
            $scope.isMoreItemsAvailable = true;
            $scope.goodsListData = data;
          }
        },
        //失败的回调
        reason => console.log(reason)
      ).finally(
        //停止广播ion-refresher
        () => $scope.$broadcast("scroll.refreshComplete")
      )
    };
    //上拉加载更多数据的方法
    $scope.loadMoreGoodsList = function() {
      //显示载入指示器
      $ionicLoading.show({
        template: "正在请求数据……"
      });
      //修改分页信息对象，并将数据变为字符串传到service
      $scope.pageable.typeNumber = $stateParams.typeNumber;
      $scope.pageable.page++;
      let message = JSON.stringify($scope.pageable);
      let promise = goodsListService.loadMoreGoodsList(message);
      promise.then(
        data => {
          if(data) {
            //模拟加载两次上拉加载后就没有更多数据了
            if($scope.pageable.page === 3) {
              $scope.isMoreItemsAvailable = false;
            }
            $scope.goodsListData.push(data);
          }
        },
        reason => console.log(reason)
      ).finally(
        () => {
          //停止广播，关闭载入指示器
          $scope.$broadcast("scroll.infiniteScrollComplete");
          setTimeout(() => $ionicLoading.hide(), 2000);
        }
      )
    };
    //返回前一个页面
    $scope.goBack = function() {
      $ionicHistory.goBack();
    }
  });
