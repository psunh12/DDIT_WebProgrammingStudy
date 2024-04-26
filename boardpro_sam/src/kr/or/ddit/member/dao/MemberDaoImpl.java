package kr.or.ddit.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;
import kr.or.ddit.mybatis.config.MybatisUtil;

public class MemberDaoImpl  implements IMemberDao{
	//mapper를 수행하기 위한 SqlSession객체변수 
	private SqlSession session;
	
	//싱글톤을 위한 자신의 객체변수 선언 
	private static IMemberDao  dao;
		
	//자신의 객체를 생성하여 리턴하는 메소드 
	public static IMemberDao  getDao() {
		if(dao == null)  dao = new MemberDaoImpl();
		
		return dao;
	}
	
	 //아이디 중복검사 
	@Override
	public String selectById(String id) {
         //0.  session변수 얻어오기 
		session = MybatisUtil.getSqlSession();
		
        //1리턴변수 선언 
		String  res = null;
		
		//2.실행
		try {
			res =session.selectOne("member.selectById", id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		
		//3. 리턴 
		return res;
	}

	 //저장하기 - 회원가입하기 
	@Override
	public int insertMember(MemberVO vo) {
		 //0.  session변수 얻어오기 
		session = MybatisUtil.getSqlSession();
		
        //1리턴변수 선언 
		int  res = 0;
		
		//2.실행
		try {
			res =session.insert("member.insertMember", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		
		//3. 리턴 
		return res;
	}

	 //우편번호 찾기 
	@Override
	public List<ZipVO> selectByDong(String dong) {
		 //0.  session변수 얻어오기 
		session = MybatisUtil.getSqlSession();
		
        //1리턴변수 선언 
		List<ZipVO> list = null;
		
		//2.실행
		try {
			list =session.selectList("member.selectByDong", dong);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		
		//3. 리턴 
		return list;
	}

	@Override
	public MemberVO loginProc(Map<String, Object> map) {
		//0.  session변수 얻어오기 
		session = MybatisUtil.getSqlSession();
		
		//1리턴 변수 선언 
		MemberVO  vo = null;
		
		//2.실행
		try {
			vo =session.selectOne("member.loginProc", map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
	  return vo;
	}

	
	
	

	
	
		
	
}
