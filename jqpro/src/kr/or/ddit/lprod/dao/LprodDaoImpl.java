package kr.or.ddit.lprod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.lprod.vo.LprodVO;
import kr.or.ddit.mybatis.config.MybatisUtil;

public class LprodDaoImpl implements ILprodDao{
	
	// mapper를 수행하기위해 SqlSession 이 필요
	private SqlSession session;
	
	// 자신의 객체 변수 선언
	private static ILprodDao dao;
	
	// 자신의 객체를 생성해서 return하는 메소드
	public static ILprodDao getDao() {
		if(dao == null) dao = new LprodDaoImpl();
		return dao;
	}
	
	@Override
	public List<LprodVO> selectLprod() {
		session=MybatisUtil.getSqlSession();
		
		// 리턴 결과형의 변수선언
		List<LprodVO> list = null;
		
		try {
			list= session.selectList("lprod.selectLprod");	// 경로가 정확하지않으면 500 에러남 
			
		} catch (Exception e) {
			e.printStackTrace();// 에러난 과정을 히스토리에 찍어라
		}finally {
			session.close();
		}
		
		return list;
	}

}
