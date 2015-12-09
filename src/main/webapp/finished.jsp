<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String path = request.getContextPath();%>
<html>
<head>
  <title>实验管理|已结束流程</title>
  <link href="<%=path%>/plugins/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
  <script src="<%=path%>/plugins/jquery/jquery-2.1.4.min.js"></script>
  <script src="<%=path%>/plugins/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
  <nav class="navbar navbar-inverse">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="<%=path%>/experiment/list/task">实验管理</a>
      </div>

      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
          <li><a href="<%=path%>/experiment/list/task">实验进程显示</a></li>
          <li><a href="<%=path%>/experiment/list/running">在运行流程</a></li>
          <li class="active"><a href="<%=path%>/finished">已结束流程 <span class="sr-only">(current)</span></a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${user.getFirstName()}  ${user.getLastName()} <span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="#">个人信息</a></li>
              <li role="separator" class="divider"></li>
              <li><a href="<%=path%>/user/logout">注销</a></li>
            </ul>
          </li>
        </ul>
      </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
  </nav>

  <div class="well">
    <table class="table table-bordered">
      <th>#</th>
      <th>执行者</th>
      <th>执行时间</th>
      <th>流程启动时间</th>
      <th>流程结束时间</th>
      <th>流程结束原因</th>
      <th>流程版本</th>

      <tr>
        <td>1</td>
        <td>教师一号</td>
        <td>2015.12.09 10:27:30</td>
        <td>2015.12.09 10:27:30</td>
        <td>2015.12.09 10:27:30</td>
        <td></td>
        <td>v1</td>
      </tr>
    </table>
  </div>
</body>
</html>
