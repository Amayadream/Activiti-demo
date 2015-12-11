<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String path = request.getContextPath();%>
<html>
<head>
  <title>实验管理|运行中的流程</title>
  <link href="<%=path%>/plugins/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
  <link href="<%=path%>/plugins/scojs/css/scojs.css" type="text/css" rel="stylesheet">
  <link href="<%=path%>/plugins/scojs/css/sco.message.css" type="text/css" rel="stylesheet">
  <script src="<%=path%>/plugins/jquery/jquery-2.1.4.min.js"></script>
  <script src="<%=path%>/static/activiti/common.js"></script>
  <script src="<%=path%>/plugins/bootstrap/js/bootstrap.min.js"></script>
  <script src="<%=path%>/plugins/scojs/js/sco.message.js"></script>
  <script type="text/javascript">
  </script>
  <script type="text/javascript">
    var ctx = '<%=request.getContextPath() %>';
  </script>
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
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">实验管理 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="<%=path%>/experiment/list/task">实验进程显示 </a></li>
            <li><a href="<%=path%>/experiment/list/running">在运行流程</a></li>
            <li><a href="<%=path%>/experiment/list/finished">已结束流程</a></li>
          </ul>
        </li>
        <li class="dropdown active">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">工作区 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="<%=path%>/experiment/list/task">流程定义与部署管理 </a></li>
            <li><a href="<%=path%>/workflow/processinstance/running">在运行流程</a></li>
            <li class="active"><a href="<%=path%>/experiment/list/finished">模型工作区</a></li>
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

<div>
  <div class="well">
    <h2>操作</h2>
    <a href="<%=path%>/experiment/deploy">部署实验</a>
    <a href="<%=path%>/experiment/start">开始实验</a>
    <h2>总体过程</h2>
    <h4>实验准备---后勤供应调整---作战方案调整---离线仿真---仿真回放---分析评估</h4>
  </div>
  <div class="well">
    <table class="table table-bordered">
      <th>#</th>
      <th>执行者</th>
      <th>执行时间</th>
      <th>结束时间</th>
      <th>当前节点</th>
      <th>任务创建时间</th>
      <th>流程状态</th>
      <th>查看</th>
      <th>操作</th>

      <c:forEach items="${page.result }" var="experiment" varStatus="status">
        <c:set var="task" value="${experiment.task }" />
        <c:set var="pi" value="${experiment.processInstance }" />
        <tr id="${experiment.id }" tid="${task.id }">
          <td>${status.index + 1}</td>
          <td>${experiment.userid }</td>
          <td>${experiment.starttime }</td>
          <td>${experiment.endtime }</td>
          <td>
            <a class="trace" href='#' pid="${pi.id }" title="点击查看流程图">${task.name }</a>
          </td>
            <%--<td><a target="_blank" href='${ctx }/workflow/resource/process-instance?pid=${pi.id }&type=xml'>${task.name }</a></td> --%>
          <td>${task.createTime }</td>
          <td>${pi.suspended ? "已挂起" : "正常" }；<b title='流程版本号'>V: ${experiment.processDefinition.version }</b></td>
          <td>
            <button class="btn btn-success btn-sm show" id="${pi.id}" onclick="showPage('${pi.id}');">查看流程图</button>
          </td>
          <td>
            <c:if test="${empty task.assignee }">
              <a href="<%=path%>/experiment/task/claim/${task.id}">签收</a>
            </c:if>
            <c:if test="${not empty task.assignee }">
              <a href="<%=path%>/experiment/complete1/${task.id}/false">回退</a>|
              <a href="<%=path%>/experiment/complete1/${task.id}/true">继续</a>
            </c:if>
          </td>
        </tr>
      </c:forEach>

    </table>
  </div>
</div>

<!-- 删除模态框 -->
<div class="modal fade" id="show-model" tabindex="-1" role="dialog" aria-labelledby="model2" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h4 class="modal-title" id="model2">
          <span class="glyphicon glyphicon-search"></span> 流程图
        </h4>
      </div>
      <div class="modal-body">
        <img src="" id="img">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> 关闭</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script>
  <c:if test="${not empty error}">
  $.scojs_message("${error}", $.scojs_message.TYPE_ERROR);
  </c:if>
  <c:if test="${not empty message}">
  $.scojs_message("${message}", $.scojs_message.TYPE_OK);
  </c:if>
  function showPage(id){
    $("#img").attr("src",'<%=path%>/workflow/process/trace/auto/'+id).css("width",500).css("height",400);
    $("#show-model").modal();
  }
</script>
</body>
</html>
