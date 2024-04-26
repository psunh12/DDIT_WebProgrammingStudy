package kr.or.ddit.member.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public interface IMemberDao {

	//메소드 선언  : public 리턴결과형 메소드이름(파리미터타입 변수명)
	
	  //아이디 중복검사 
	  public String selectById(String id);
		
	  //저장하기 - 회원가입하기 
	  public int insertMember(MemberVO  vo);
		
	 //우편번호 찾기 
	  public List<ZipVO> selectByDong(String dong);
	  
	  //로그인 
	  public MemberVO loginProc(Map<String, Object> map);
	
}
