package kr.or.ddit.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;
import kr.or.ddit.mybatis.config.MybatisUtil;

public class MemberDaoImpl implements IMemberDao {
	// mapper를 수행하기 위한 SqlSession 객체변수
	private SqlSession session;
	
	// 싱글톤을 위한 자신의 객체 변수 선언
	private static IMemberDao dao;
	
	// 자신의 객체를 생성하여 리턴하는 메소드
	public static IMemberDao getDao() {
		if(dao==null) dao= new MemberDaoImpl();
		return dao;
	}
	
	@Override
	public String selectById(String id) {
		session= MybatisUtil.getSqlSession();
		String res = null;
		
		try {
			res = session.selectOne("member.selectById",id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return res;
	}

	@Override
	public int insertMember(MemberVO memVo) {
		session = MybatisUtil.getSqlSession();
		int cnt = 0;
		
		try {
			cnt =session.insert("member.insertMember",memVo);
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		
		return cnt;
	}

	@Override
	public List<ZipVO> selectByDong(String dong) {
		session =MybatisUtil.getSqlSession();
		List<ZipVO> ziplist= null;
		
		try {
			ziplist = session.selectList("member.selectByDong",dong);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return ziplist;
	}

	@Override
	public MemberVO loginProc(Map<String, Object> map) {
		session =MybatisUtil.getSqlSession();
		MemberVO vo= null;
		
		try {
			vo = session.selectOne("member.loginProc",map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return vo;

	}
}
