/**
 * 
 */

function proc1(){
	// 랜덤 발생, 메소드는 소문자
	cr=parseInt(Math.random()*256)
	cg=parseInt(Math.random()*256)
	cb=parseInt(Math.random()*256)
	
	
	// div를 검색 -id=res
	
//  첫번째 방법	
// let vres=window.document.getElementById('res1');
// 윈도우는 최상위객체. 생략가능.

//  두번째 방법
	let vres=document.querySelector('#res1');

// 첫번째 방법: 문자열 사용
//	vres.style.background = "rgb("+cr+
//								","+cg+
//								","+cb+")";


//	두번째방법: `백틱을 이용한 템플릿 문자열(리터럴)
	vres.style.background = `rgb(${cr}, ${cg}, ${cb})`;
								
							
}