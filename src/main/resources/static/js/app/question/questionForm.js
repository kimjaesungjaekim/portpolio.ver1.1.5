/**
 * @author 연구개발 5팀 사원 김재성
 * @since 2024. 03. 13.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * 
 *      <pre>
 * [[개정이력(Modification Information)]]
 *    수정일            수정자               수정내용
 * ------------     --------    ----------------------
 * 2024.03.13.        김재성       최초 작성
 * Copyright (c) 2024 by INNOVATION-T All right reserved
 *      </pre>
 */

 
$(function(){
	
	$("#passwordMarkBtn").on("click", function(){
		 let btnType = $(this).parent("#passwordDiv").find("input");
		 
	     if (btnType.length > 0) {
	         if (btnType.attr("type") === "password") {
	             btnType.attr("type", "text");
	         } else {
	             btnType.attr("type", "password");
	         }
	     }
    	
    	console.log(" 패스워드 타입 확인 : ", btnType);
	});
/*	
	$("#qnaAddForm").on("submit",function(event){
		event.preventDefault();
		
		//let data = $(this).serialize();
		let data = {
	        userNm: $("#userNm").val(),
	        userTel: $("#userTel").val(),
	        userEmail: $("#userEmail").val(),
	        userIntroduce: $("#userIntroduce").val(),
    	};
		
		console.log("data", data);
		
		$.ajax({
			url : "/question/add",
			method : "POST",
			data : JSON.stringify(data) ,
//			data : formData ,
			dataType : 'json',
			contentType: 'application/json',
			success : function(resp){
				if(resp.result =="OK"){
					alert(resp.message);
					location.reload();
				}else{
					alert(resp.message);
				}
			},
			error : function(xhr, status,err){
				console.log("상태 : ", status);
				console.log("에러 : ", err);
				alert("잘못된 요청 발생 !");
			}
		});
	});
*/
});