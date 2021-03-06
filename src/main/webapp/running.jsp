<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String path = request.getContextPath();%>
<html>
<head>
  <title>实验管理|在运行流程</title>
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
          <li class="dropdown active">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">实验管理 <span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="<%=path%>/experiment/list/task">实验进程显示 </a></li>
              <li class="active"><a href="<%=path%>/experiment/list/running">在运行流程</a></li>
              <li><a href="<%=path%>/experiment/list/finished">已结束流程</a></li>
            </ul>
          </li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">工作区 <span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="<%=path%>/workflow/process-list">流程定义与部署管理 </a></li>
              <li><a href="<%=path%>/workflow/processinstance/process-list">所有流程 </a></li>
              <li><a href="<%=path%>/workflow/processinstance/running">在运行流程</a></li>
              <li><a href="<%=path%>/workflow/model/list">模型工作区</a></li>
            </ul>
          </li>
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
      <thead>
        <tr>
          <th>#</th>
          <th>执行者</th>
          <th>执行时间</th>
          <th>结束时间</th>
          <th>当前节点</th>
          <th>任务创建时间</th>
          <th>流程状态</th>
          <th>当前处理人</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${page.result }" var="experiment" varStatus="status">
          <c:set var="task" value="${experiment.task }" />
          <c:set var="pi" value="${experiment.processInstance }" />
          <tr id="${experiment.id }" tid="${task.id }">
            <td>${status.index +1}</td>
            <td>${experiment.userid }</td>
            <td>${experiment.starttime }</td>
            <td>${experiment.endtime }</td>
            <td>
              <a class="trace" href='#' pid="${pi.id }" title="点击查看流程图">${task.name }</a>
            </td>
            <td>${task.createTime }</td>
            <td>${pi.suspended ? "已挂起" : "正常" }；<b title='流程版本号'>V: ${experiment.processDefinition.version }</b></td>
            <td>${task.assignee }</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>

</body>
</html>
