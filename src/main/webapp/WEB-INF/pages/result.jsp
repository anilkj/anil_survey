<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/resources/css/style.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap/bootstrap.css"
	rel="stylesheet">


<script
	src="<%=request.getContextPath()%>/resources/js/jquery-3.2.1.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/main.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap/tether.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap/bootstrap.min.js"></script>
	
	<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap/bootstrap-treeview.js"></script>
	

</head>
<body>
<div class="container">
  <div class="row">
     <div class="col-12">
		<div class="row header_wrapper">
			<div class="col-md-9">
				<h4>Add New Survey</h4>
			</div>
			<div class="col-md-3">
				<a href="/survey_app/survey/addSurvey" class="btn btn-default">Home</a>
			 	<a href="javascript:void(0)" class="btn btn-primary">Result</a>
			</div>
		</div>
		
	   <div class="form-group row">
			<label for="example-text-input" class="col-2 col-form-label">Name:</label>
			<div class="col-6">
				${model.surveyList.name}
			</div>
		</div>

		<div class="form-group row">
			<label for="example-text-input" class="col-2 col-form-label">Phone:</label>
			<div class="col-6">
				${model.surveyList.phone}
			</div>
		</div>

		<div class="form-group row">
			<label for="example-text-input" class="col-2 col-form-label">Address:</label>
			<div class="col-6">
				${model.surveyList.address}
			</div>
		</div>
       
      <div class="row">
        <div class="col-sm-11">
         <div class="treeview">
          	 <c:forEach items="${model.questionList}" var="questions">
          		<ul class="list-group">
          			<li class="list-group-item node-treeview1" 
          				data-nodeid="0" style="color:undefined;background-color:undefined;">
          				<span class="icon expand-icon glyphicon glyphicon-minus"></span>
          				<span class="icon node-icon"></span>${questions.question}
          			</li>
       			
       			   			
          			<li class="list-group-item node-treeview1" 
          			data-nodeid="1" style="padding-left: 45px;color:undefined;background-color:undefined;">
          			<span class="indent"></span>
          			<span class="icon glyphicon"></span>
          			<span class="icon node-icon">
          			</span>&nbsp;&nbsp;&nbsp;${questions.answer}	</li>
          		</ul>
          	  </c:forEach>
          	</div>
        </div>
      </div>
      
   </div>
   </div>
</div>
<script type="text/javascript">
</script>	

</body>
</html>