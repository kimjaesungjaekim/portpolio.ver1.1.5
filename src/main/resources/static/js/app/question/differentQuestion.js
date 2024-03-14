/**
 * @author 연구개발 5팀 사원 김재성
 * @since 2024. 03. 11.
 * @version 1.0
 * @see javax.servlet.http.HttpServlet
 * 
 *      <pre>
 * [[개정이력(Modification Information)]]
 *    수정일            수정자               수정내용
 * ------------     --------    ----------------------
 * 2024.03.11.        김재성       최초 작성
 * Copyright (c) 2024 by INNOVATION-T All right reserved
 *      </pre>
 */
$(function(){

  function makeTrTag(question){
        
        let trTags = `
            <tr th:data-qestn-no="${question.qestnNo}">
                <td>${question.qestnTitle}</td>
                <td>${question.qestnContent}</td>
                <td>${question.userId}</td>
                <td>${question.qestnDate}</td>
            </tr>
        `;
        return trTags;
    };
    

  $("#searchForm").on("submit", function(event){
        event.preventDefault();
      //let data = $(this).serialize();
      
      let data ={
		  searchType: $("#searchType").val(),
		  searchWord: $("#searchWord").val(),
		  page: $("#page").val()
	  };
        
      $.ajax({
      url:'/question/list',
      method : 'POST',
      data: JSON.stringify(data) ,
      dataType: 'JSON',
      //contentType : 'application/x-www-form-urlencoded',
      contentType : 'application/json',
      	success : function(resp){
        
		      let pagination = resp;  
		      let questionList = pagination.dataList;
	              
	          console.log("질문사항 리스트 출력 : ",questionList);
	          
	          let trTag= "" ;
	          
	          if(questionList.length > 0){
	              $.each(questionList, function(idx, question){
	                  trTag += makeTrTag(question);
	              });
	              
	              console.log(trTag);
	              
	              $("#qnaListBody").html(trTag);
	              
	              $("#pagingArea").html(pagination.pagingHTML);
	              
	          }else{
	              trTag += `
	                  <tr>
	                      <td colspan="5" style="text-align: center;">등록된 상담이 없습니다.</td>
	                  </tr>
	              `;
	              $("#pagingArea").empty();
	          }
	      },
	      error : function(xhr, status,err){
	        console.log("상태 : ", status);
	        console.log("에러 : ", err);
	        alert("잘못된 요청 발생 !");
	      }
    });
    return false;
  }).submit();
 

  
	$("#searchUI").on("click", "#searchBtn", function(event){
		
	    let inputs = $(this).parents("#searchUI").find(":input[name]");
	    
	    $.each(inputs, function(idx, ipt){
	        let name = ipt.name;
	        let value = $(ipt).val();
	        $("#searchForm").find(`:input[name=${name}]`).val(value);
	        });
	        $("#searchForm").submit();
	});
});

function fn_paging(page){
    searchForm.page.value = page;
    searchForm.requestSubmit();
    searchForm.page.value = "";
};


