<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
     <c:when test="${model.qType=='MT' }">
        <input class="form-control" type="text" value="" id="question${model.qCount}"><br>
		<textarea class="form-control answer${model.qCount}" rows="5" ></textarea><br>
	</c:when>
    <c:when test="${model.qType=='MC' }">
        <input class="form-control" type="text" value="" id="question${model.qCount}"><br>
		 <div class="checkbox">
		  <label><input class="answer${model.qCount}" type="checkbox" value="1">&nbsp;Answer Multiple Choice #1</label>
		</div>
		<div class="checkbox">
		  <label><input class="answer${model.qCount}" type="checkbox" value="2">&nbsp;Answer Multiple Choice #2</label>
		</div>
		<div class="checkbox">
		  <label><input  class="answer${model.qCount}" type="checkbox" value="3">&nbsp;Answer Multiple Choice #3</label>
		</div> 
    </c:when>
    <c:otherwise>
        <input class="form-control" type="text" value="" id="question${model.qCount}"><br>
		<input type="text" value="" class="form-control answer${model.qCount}">
		<a class="float_rt_cls" href="javascript:void(0)">Add Sub Question</a>
	</c:otherwise>
</c:choose>
