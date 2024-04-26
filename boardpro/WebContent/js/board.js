/**
 * 
 */
//댓글 삭제
ReplyDeleteServer = function(){
	$.ajax({
		
		url : `${mypath}/ReplyDelete.do`,
		type : 'get',
		data : { "renum" :  vidx},   
		success : function(res){
		
			alert(res.flag);
		},
		error : function(xhr){
			alert("오류 상태 : " + xhr.status)
		},
		dataType : 'json'
	})
	
}

//댓글 리스트 가져오기 
ReplyListServer = function(){
	
	$.ajax({
		
		url : `${mypath}/ReplyList.do`,
		type : 'get',
		data : { "bonum" :  vidx},    //{"bonum" :  reply.bonum },
		success : function(res){
			rcode = "";
			$.each(res, function(i, v){
				
				content = v.cont;
				content = content.replaceAll(/\n/g, "<br>");
				
				rcode += ` <div class="reply-body">
        	           <div class="p12">
        	              <p class="p1">
        	              
        	                작성자 <span class="rwr">${v.name}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 	 날짜    <span class="rda">${v.redate}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
        	              </p>
        	              <p class="p2">`

                 if(uvo != null && uvo.mem_name == v.name  ){
        	           rcode +=`<input type="button" idx="${v.renum}" value="댓글수정" name="r_modify" class="action">
        	                 <input type="button" idx="${v.renum}" value="댓글삭제" name="r_delete" class="action">`
        	      }     
            	 rcode += ` </p>
        	           </div>
        	           <p class="p3">${content} </p>
                    </div>
        	      </div>
        	    </div>	
           }) //반복 

           //출력 
         $(gthis).parents('.card').find('.reply-body').remove();

		 $(gthis).parents('.card').find('.card-body').append(rcode);
			
		},
		error : function(xhr){
			alert("오류 상태 : " + xhr.status)
		},
		dataType : 'json'
	})
	
	
}

//댓글 등록 
ReplyInsertServer  = function(){
	 
	$.ajax({
		
		url : `${mypath}/ReplyInsert.do`,
		type : 'post',
		data : reply,   //reply객체 - bonum, name, cont 
		success : function(res){
			
			//alert(res.flag);
			
			//성공 했ㅇ다면 
			if(res.flag== "성공"){
				//댓글 리스트 출력 
				ReplyListServer();
				
			}
		},
		error : function(xhr){
			alert("오류 상태 : " + xhr.status)
		},
		dataType : 'json'
	})
	
}

//조회수 증가 
UpdateHitServer  = function(){
	
	$.ajax({
		
		url : `${mypath}/BoardHitUpdate.do`,
		type : 'get',
		data : {"num" : vidx},
		success : function(res){
			
			//성공 했ㅇ다면 
			if(res.flag== "성공"){
				
				//조회수의 위치값 검색 
				vhit = $(gthis).parents('.card').find('.hit');
				
				//그위치에서 현재 값을 가져온다   + 1
				hitvalue =   parseInt($(vhit).text().trim()) + 1;
				
				// 화면의 조회수 값을 변경 
				$(vhit).text(hitvalue);
			}
		},
		error : function(xhr){
			alert("오류 상태 : " + xhr.status)
		},
		dataType : 'json'
	})
	
}

//게시글 수정 
UpdateBoardServer = function(){
	
	$.ajax({
		
		url : `${mypath}/BoardUpdate.do`,
		type : 'post',
		data : fdata, //writer, subject, mail, password, content, num
		success : function(res){
			
			alert(res.flag);
			
			//성공 했다면 
			if(res.flag== "성공"){
			   //수정된 글 만 회면에 다시 뿌려준다 - fdata의 값으로 본문의 내용을 수정한다
				$(vparents).find('.sub').text(fdata.subject);
				$(vparents).find('.em').text(fdata.mail);
				$(vparents).find('.pass').text(fdata.password);
				
				//날짜 수정
				today = new Date();
				today = today.toLocaleString();
				$(vparents).find('.da').text(today);
				
				vcont = fdata.content;  //엔터가 포함 ㅎ한다
				//엔터를 출력시에는 <br>로 바꾸어 출력 
				vcont = vcont.replaceAll(/\n/g, "<br>");
				
				$(vparents).find('.p3').html(vcont);
				
			}
		},
		error : function(xhr){
			alert("오류 상태 : " + xhr.status)
		},
		dataType : 'json'
	})
	
}


//게시글 저장
WriteBoardServer = function(){
	
	$.ajax({
		
		url : `${mypath}/boardWrite.do`,
		type : 'post',
		data : fdata,
		success : function(res){
			
			alert(res.flag);
			
			// 성공시
			if(res.flag=="성공"){
			 ListPageServer(1)
			}else{
				alert("글쓰기 실패");
			}
		},
		error : function(xhr){
			alert("오류 상태 : " + xhr.status)
		},
		dataType : 'json'
	})
}

// 게시글 삭제 - 번호가 필요
DeleteBoardServer = function(){
	$.ajax({
		url:`${mypath}/boardDelete.do`,
		type : 'get',
		data : {"num" : vidx },
		success : function(res){
			alert(res.flag);
			
			
			//성공 햇다면 ListPageServer를 호출
			/*if(res.flag == "성공"){
				//리스트 
				ListPageServer(1);
			} */
			
		},
		error : function(xhr){
			alert("오류 상태 : " + xhr.status)
		},
		dataType : 'json'
		
	})
	
}
//호출 ListPageServer(1)
//function ListPageServer(page){}
//ListPageServer = function(page){}

ListPageServer = (page) =>{
	//page 매개변수는 currentPage값이 넘어온 지역변수
	//pageList함수에서 사용하기 위해서 전역변수로 변경 
	gpage = page;
		
	// 한페이지당   3개씩 리스트 출력 하기 
   
    vtype = $('#stype').val().trim();
    vword = $('#sword').val().trim();


    $.ajax({
       url : 'http://localhost/boardpro/boardList.do',
       data : {
    	     "page"  : page,
    	     "stype" : vtype,
    	     "sword" : vword
         },
        dataType : 'json',
        type : 'post',
        success : function(res){
       	
           code = `<div class="container mt-3">
        		    <div id="accordion">`
        	
           $.each(res.datas,function(i, v){
        	   
        	  content = v.content;
            //엔터기호를 <br>로 변경 
           	 content = content.replaceAll(/\n/g, "<br>");
           	
        	   
        	 code += `<div class="card">
        	      <div class="card-header">
        	        <a class="btn" data-bs-toggle="collapse" href="#collapse${v.num}">
        	          ${v.subject}
        	        </a>
        	      </div>
        	      <div id="collapse${v.num}" class="collapse" data-bs-parent="#accordion">
        	        <div class="card-body">
        	           <div class="p12">
        	              <p class="p1">
        	              
        	                작성자 <span class="wr">${v.writer}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        	           <span style="display:none;" class="pass"></span>
					이메일 <span class="em">${v.mail}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
        	             조회수 <span class="hit">${v.hit}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
        	             날짜    <span class="da">${v.wdate}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
        	              </p>
        	              <p class="p2">`

                 if(uvo != null && uvo.mem_name == v.writer  ){
        	           code +=`<input type="button" idx="${v.num}" value="수정" name="modify" class="action">
        	                 <input type="button" idx="${v.num}" value="삭제" name="delete" class="action">`
        	      }     
            	 code += ` </p>
        	           </div>
        	           <p class="p3">${content} </p>
        	           <p class="p4">
        	             <textarea rows="" cols="60"></textarea>
        	             <input type="button" idx="${v.num}"  value="등록" name="reply" class="action">
        	           </p>
        	        </div>
        	      </div>
        	    </div>`
           })
           code += `</div>
        		    </div>`;
        		    
        		    
        	$('#result1').html(code);	

           vpage =  pageList(res.sp, res.ep, res.tp)  ;
           
           //vpage출력   
           $('#pagelist').html(vpage);
        	
        },
        error : function(xhr){
        	alert(" 오류 상태 : " + xhr.status);
        }
        
    })
	
}

pageList = function(s, e, t){
	//pagelist 모양만들기
	pager = "";
	
	pager += `<ul class="pagination">`;
	
	//이전페이지 
	if(s > 1){
		pager +=`<li class="page-item"><a id="prev" class="page-link" href="#">Previous</a></li>`
	}
	
	//페이지번호 
	//currentPage = 7 
	//다시 계산 한totalPage(t) = 6
	//7페이지기 없어지므로 currentPage 값을 6으로 설정 
	
	if(gpage > t)  currentPage = t;
	
	for(i=s; i<=e; i++){ //1, 2
		if(i == currentPage){
			 pager += `<li class="page-item active"><a class="page-link pageno" href="#">${i}</a></li>`
		}else{
			pager += ` <li class="page-item"><a class="page-link pageno" href="#">${i}</a></li>`
		}
     }
	
	//다음페이지 
	if( e < t){
		pager += `<li class="page-item"><a id="next" class="page-link" href="#">Next</a></li>`
	}
	
	pager += `</ul>`
	
	return pager; 
}

