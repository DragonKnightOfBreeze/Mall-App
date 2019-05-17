angular.module("home", [])
.controller("homeController", function($scope, $window) {
  goTop();
  countdown();
  headerChangeColor();

  /**改变头部搜索区域颜色。*/
  function headerChangeColor() {
    let bg = $("#home-content");
    let nowOpacity = 0;
    bg.on("scroll", function() {
      if(bg.prop("scrollTop") / 250 < 0.85) {
        nowOpacity = bg.prop("scrollTop") / 250;
      }
      $("#header-bar-bg").css("opacity", nowOpacity);
    })
  }

  /**
   * 回到顶部。
   */
  function goTop() {
    let bg = $("#home-content");
    let backToTop = $(".back-to-top");
    bg.on("scroll", function() {
      let scrollTop = bg.prop("scrollTop");
      if(scrollTop > 200) {
        backToTop.css("opacity", 1);
      } else {
        backToTop.css("opacity", 0);
      }
    });
    backToTop.on("click", function() {
      bg.prop("scrollTop", 0);
    })
  }

  /**
   * 秒杀计时器。
   */
  function countdown() {
    if($window.timer) {
      clearInterval($window.timer);
    }
    let timeObj = {h: 1, m: 37, s: 13};
    let timeStr = toDouble(timeObj.h) + toDouble(timeObj.m) + toDouble(timeObj.s);
    let timeList = $(".time-text");
    timeList.each(function(i) {
      $(this).text(timeStr[i]);
    });

    function toDouble(num) {
      if(num < 10) {
        return '0' + num;
      } else {
        return '' + num;
      }
    }

    $window.timer = setInterval(function() {
      timeObj.s--;
      if(timeObj.s === -1) {
        timeObj.m--;
        timeObj.s = 59;
      }
      if(timeObj.m === -1) {
        timeObj.h--;
        timeObj.m = 59;
      }
      if(timeObj.h === -1) {
        timeObj.h = 0;
        timeObj.m = 0;
        timeObj.s = 0;
        clearInterval($window.timer);
      }
      timeStr = toDouble(timeObj.h) + toDouble(timeObj.m) + toDouble(timeObj.s);
      timeList.each(function(i) {
        $(this).text(timeStr[i]);
      });
    }, 1000);
  }
});
