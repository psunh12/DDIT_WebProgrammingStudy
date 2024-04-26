package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public class MemberServiceImpl implements IMemberService {
	
	 //dao접근 을 위한 dao객체 변수 선언 
	private IMemberDao  dao;
	
	//싱글톤을 위한 자신의 객체 변수 선언 
	private static IMemberService  service;
		
	 //생성자  -  dao객체 얻어오기 
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getDao();
	}
		
	//자신의 객체를 생성하여 리턴하는 메소드 
	public static IMemberService getService() {
		if(service == null)  service = new MemberServiceImpl();
		
		return service;
	}
	
	
	@Override
	public String selectById(String id) {
		// TODO Auto-generated method stub
		return dao.selectById(id);
	}

	@Override
	public int insertMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return dao.insertMember(vo);
	}

	@Override
	public List<ZipVO> selectByDong(String dong) {
		// TODO Auto-generated method stub
		return dao.selectByDong(dong);
	}


	

}
