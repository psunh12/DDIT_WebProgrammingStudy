package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public interface IMemberDao {
	
	// 아이디 중복검사
	public String selectById(String memId);
	// 저장하기 - 회원가입하기
	public int insertMember(MemberVO memVo);
	// 우편번호 찾기
	public List<ZipVO> selectByDong(String dong);
	
}
