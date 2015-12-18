<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String path = request.getContextPath();%>
<html>
<head>
  <title></title>
  <link href="<%=path%>/plugins/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
  <link href="<%=path%>/plugins/scojs/css/scojs.css" type="text/css" rel="stylesheet">
  <link href="<%=path%>/plugins/scojs/css/sco.message.css" type="text/css" rel="stylesheet">
  <script src="<%=path%>/plugins/jquery/jquery-2.1.4.min.js"></script>
  <script src="<%=path%>/static/activiti/common.js"></script>
  <script src="<%=path%>/plugins/bootstrap/js/bootstrap.min.js"></script>
  <script src="<%=path%>/plugins/scojs/js/sco.message.js"></script>
</head>
<body>
<table class="table table-bordered">
  <thead>
    <th>#</th>
    <th>步骤名称</th>
    <th>角色</th>
    <th>工具</th>
  </thead>
  <tbody>
  <c:forEach items="${result}" var="bpmn" varStatus="status">
  <tr>
  <td>${status.index + 1}</td>
  <td>${bpmn.name}</td>
  <td>${bpmn.groups}</td>
  <td>${bpmn.tools}</td>
  </tr>
  </tbody>
  </c:forEach>
</table>
</body>
</html>
