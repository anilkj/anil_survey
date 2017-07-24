/**
 * created by anil
 */

function send() {
	var questionTypeLength=$('.questionType').length;
	if(questionTypeLength > 0){
		var qType=[];
		var question=[];
		var answer=[];
		for (var i=0; i<questionTypeLength; i++){
			var qTypeValue=$('#questionType'+i).length > 0 ? $('#questionType'+i).val() : "";
			var questionValue=$('#question'+i).length > 0 ? $('#question'+i).val() : "";
			
			if(qTypeValue=="MC"){
				var arr = [];
			       $('.answer'+i+':checked').each(function () {
			           arr.push($(this).val());
			       });
			       var answerValue=arr.join(", ");
			} else {
				var answerValue=$('.answer'+i).length > 0 ? $('.answer'+i).val() : "";
			}
			
			qType.push({
				questionType :qTypeValue, 
				question: questionValue,
				answer: answerValue
			});
		}
	}
	$.ajax({
        url: '/survey_app/survey/saveSurvey',
        type: 'post',
        data: JSON.stringify({name: $("#name").val(),
        	  	dateOfBirth:  $("#dateOfBirth").val(),
        	  phone: $("#phone").val(),
        	  address:$("#address").val(),
        	  questions: (qType) 
        	  }),
        processData: false,
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        traditional: true,
        success: function (data) {
        	if(data > 0){
        		window.location = "/survey_app/survey/result";
        	}
        	return false;
        	
        }
    });
	
	
}

function addQuestion(obj,qType){
	var qType=qType!=undefined ? qType : "";
	var obj=obj!=undefined ? obj : "";
	var questionCount=$('.question_count').length;
	$.ajax({
		url: "/survey_app/survey/addQuestion/"+questionCount, 
		success: function(result){
			if(qType!=""){
				$(obj).closest(".question_wrapper").after(result);
			} else {
				$("#main_question_wrapper").append(result);
			}
		}
	});
}
function changeQuestionType(objVal,obj,qCount){
	var objVal=objVal!=undefined ? objVal : "";
	var obj=obj!=undefined ? obj : "";
	var qCount=qCount!=undefined ? qCount : "";
	$.ajax({
		url: "/survey_app/survey/loadQuestionType/"+objVal+"/"+qCount, 
		success: function(result){
			$(obj).closest(".form-group").find(".answer_wrapper").html(result);
			
		}
	});
}