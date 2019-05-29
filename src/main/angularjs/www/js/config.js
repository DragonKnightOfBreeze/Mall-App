/**
 *  项目的全局配置文件，主要解决兼容性问题。
 *  如果是网络版的APP，那么需要在此文件中提供访问服务端的接口url。
 */
angular.module('config', [])
  .config(function($ionicConfigProvider) {
    // 设置android平台的选项卡位置
    $ionicConfigProvider.platform.android.tabs.position('bottom');
    $ionicConfigProvider.platform.android.tabs.style('standard');
  })
  .service('configService', function() {
    // 对外提供后台的主url
    this.hostUrl = "http://127.0.0.1:8080/MallApp";
  });
