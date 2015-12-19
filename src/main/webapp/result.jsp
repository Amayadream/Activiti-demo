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
<form action="<%=path%>/workflow/model/saveModel" method="post">
  <input type="hidden" id="id" name="id" value="${modelId}">
  <table class="table table-bordered">
    <thead>
      <th>#</th>
      <th>步骤名称</th>
      <th>角色</th>
      <th>工具</th>
      <th>角色选择</th>
      <th>工具选择</th>
    </thead>
    <tbody>
    <c:forEach items="${result}" var="bpmn" varStatus="status">
    <tr>
    <td>${status.index + 1}</td>
    <td>${bpmn.name}</td>
    <td>${bpmn.groups}</td>
    <td>${bpmn.tools}</td>
    <td>
      <input type="hidden" id="name" name="name" value="${bpmn.name}">
      <select id="groups" name="groups">
        <option value ="teacher">教员</option>
        <option value ="student">学员</option>
      </select>
    </td>

    <td>
      <select id="tools" name="tools">
        <option value ="模型装配工具">模型装配工具</option>
        <option value ="想定编辑工具">想定编辑工具</option>
        <option value ="态势回放工具">态势回放工具</option>
        <option value ="分析评估工具">分析评估工具</option>
      </select>
    </td>
    </tr>
    </tbody>
    </c:forEach>
  </table>
  <input type="submit" class="btn btn-success" value="提交">
</form>
</body>
</html>
