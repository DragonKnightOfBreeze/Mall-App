angular.module("goodsList", [])
  .service("goodsListService", function($http, $q) {
    this.refreshGoodsList = function(message) {
      let goodsListData = [
        {
          name: "轻舞飘絮 毛呢外套女秋冬款 2015秋款女装韩版修身毛呢大衣女6868 粉色 L",
          price: 288,
          praise: 100,
          buy: 733,
          productId: 4,
          src: "img/goodsList/goods4.jpg"
        }
        //TODO
      ];
      //假设数据请求成功
      let deferred = $q.defer();
      deferred.resolve(goodsListData);
      return deferred.promise;
    };
    this.loadMoreGoodsList = function(message) {
      //第一页展示6条数据
      let goodsListData = [
        {
          name: "轻舞飘絮 毛呢外套女秋冬款 2015秋款女装韩版修身毛呢大衣女6868 粉色 L",
          price: 288,
          praise: 100,
          buy: 733,
          productId: 4,
          src: "img/goodsList/goods4.jpg"
        }
        //TODO
      ];
      let deferred = $q.defer();
      deferred.resolve(goodsListData);
      return deferred.promise;
    }
  });
