<div class="col-12 question_wrapper">
		 <div class="form-group row question_count">
		    <select class="form-control col-2 questionType" id="questionType${qCount}"
		    	onchange="changeQuestionType(this.value,this,'${qCount}')" class="question_type">
				<option value="MT">MutiLine Text</option>
				<option value="SC">Single Choice</option>
				<option value="MC">Multiple Choice</option>
			</select>
			<div class="col-6 answer_wrapper">
				<input class="form-control" type="text" value="" id="question${qCount}"><br>
				<textarea  class="form-control answer${qCount}" 
					 rows="5" ></textarea><br>
			</div>
		</div>
</div>
 