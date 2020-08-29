<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>添加作者微信</title>
  <style type="text/css">
    .small-img {
      cursor: zoom-in;
    }

    .wrap {
      position: fixed;
      top: 0;
      left: 0;
      right: 0;
      bottom: 0;
      z-index: 10000;
      display: none;
    }

    .box {
      display: table-cell;
      text-align: center;
      vertical-align: middle;
      background-color: rgba(0, 0, 0, .3);
    }

    .box img {
      display: inline-block;
      transition: all .2s;
      cursor: zoom-out;
    }
  </style>

</head>

<body>
  <img class="small-img js-small-img" src="images/wechat.jpg" />
  <div class="wrap js-wrap">
    <div class="box js-box">
      <a href="main.jsp" style="text-decoration: none;">
      <img class="big-img js-big-img" src="images/wechat.jpg">
      <div align="center" style="padding-top: 10px;" >单击返回</div>
      </a>
    </div>
  </div>

  <script src="jquery-easyui-1.3.3/jquery.min.js"></script>
  <script>
    $('.js-box').width($(window).width());
    $('.js-box').height($(window).height());

    $('.js-small-img').click(function () {
      $('.js-big-img').attr('src', $(this).attr('src'));
      $('.js-wrap').fadeIn();
    });
    $('.js-box').click(function () {
      $('.js-wrap').fadeOut();
    });
  </script>
</body>

</html>