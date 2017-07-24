<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	href="<%=request.getContextPath()%>/resources/css/bootstrap/bootstrap-datetimepicker.css"
	rel="stylesheet">

<script
	src="<%=request.getContextPath()%>/resources/js/jquery.1.10.2.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/main.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap/bootstrap.min.js"></script>
	<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap/bootstrap-datetimepicker.js"></script>
	
<script type="text/javascript">
            $(function () {
                $('#datetimepicker1').datetimepicker();
            });
        </script>
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
				<a href="javascript:void(0)" class="btn btn-primary">Home</a>
			 	<a href="/survey_app/survey/result" class="btn btn-default">Result</a>
			</div>
		</div>


	<form name="sur" id="sur" method="post">
		<div class="form-group row">
			<label for="example-text-input" class="col-2 col-form-label">Name:</label>
			<div class="col-6">
				<input class="form-control" type="text" value="" id="name"
					name="name">
			</div>
		</div>

		<div class="form-group row">
			<label for="example-text-input" class="col-2 col-form-label">Date of Birth:</label>
			<div class="col-6">
				<div class='input-group date' id='datetimepicker1'>
                    <input size="16" type="text" value="" id="dateOfBirth" name="dateOfBirth" 
						class="form-control">
						&nbsp;<em>(DD/MM/YYYY)</em>
                </div>
			</div>
		</div>


		<div class="form-group row">
			<label for="example-text-input" class="col-2 col-form-label">Phone:</label>
			<div class="col-6">
				<input type="text" name="phone" class="form-control" id="phone">
			</div>
		</div>

		<div class="form-group row">
			<label for="example-text-input" class="col-2 col-form-label">Address:</label>
			<div class="col-6">
				<textarea name="address" class="form-control" rows="5" id="address"></textarea>
			</div>
		</div>
		<div class="row add_new_btn_wrapper">
			<div class="col-md-12 pull-right">
				<a style="margin-right: 80px;" href="javascript:void()" onclick="addQuestion()" 
				class="btn btn-primary add_new_btn">Add New Question</a>
			</div>
		</div>
		
		<div class="row" id="main_question_wrapper"></div>
		
		<div class="row">
			<a class="btn btn-primary" onclick="send()" href="javascript:void(0)">Save</a>&nbsp;&nbsp;
			<a class="btn btn-default" onclick="send()" href="javascript:void(0)">Close</a>
		</div>
		
		
		
	</form>
 
 	</div>
   </div>
</div>
	

</body>
</html>