<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html>
<head>
  <title>电商平台后台管理系统</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="../easyui/themes/bootstrap/easyui.css">
  <link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
  <link rel="stylesheet" type="text/css" href="../easyui/demo/demo.css">
  <script src="../easyui/jquery.min.js"></script>
  <script src="../easyui/jquery.easyui.min.js"></script>
  <script src="../easyui/locale/easyui-lang-zh_CN.js"></script>
  <style>
    #ma-header {
      height: 80px;
      width: 100%;
    }
    #ma-nav {
      width: 200px;
    }
  </style>
</head>
<body>
  <div class="easyui-layout" data-options="fit:true">
    <div id="ma-header" data-options="region:'north'">
      <%@include file="part/header.html" %>
    </div>

    <div id="ma-nav" data-options="region:'west',title='功能导航'">
      <%@include file="part/nav.html" %>
    </div>

    <div data-options="region:'center',title:'广告管理 | 引导管理'">
      <%@include file="part/guide-field.html" %>
      <%@include file="part/guide-dialog.html" %>
    </div>
  </div>
</body>
<script src="../plupload/js/plupload.full.min.js"></script>
<script src="../qiniu/qiniu.js"></script>

<script src="js/utils.js"></script>
<script src="js/admin.js"></script>
</html>
