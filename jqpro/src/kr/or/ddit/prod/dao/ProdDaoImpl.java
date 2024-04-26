package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.config.MybatisUtil;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdDaoImpl implements IProdDao {
	//mapper 수행을 위한 Sqlsession필요 -SqlSession객체변수
	private SqlSession session;
	
	// 자신의 객체변수 선언
	private static ProdDaoImpl dao;
	
	public static IProdDao getDao() {
		if(dao==null) dao = new ProdDaoImpl();
		return dao;
	}
	
	// 자신의 객체를 생성하여 리턴하는 메소드
	
	@Override
	public List<ProdVO> selectByLgu(String lgu) {
		// 0. session 객체 얻기
		session = MybatisUtil.getSqlSession();
		
		// 1. 리턴값의 변수 선언
		List<ProdVO> list = null;
		// 2. 실행
		try {
			list=session.selectList("prod.selectByLgu",lgu);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		// 3. 리턴결과
		return list;
	}

	@Override
	public ProdVO selectById(String id) {
		session=MybatisUtil.getSqlSession();
		
		ProdVO prodVo=null;
		try {
			prodVo =session.selectOne("prod.selectById",id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return prodVo;
	}

}
