package kr.or.ddit.prod.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdServiceImpl implements IProdService {
	
	private SqlSession session;
	
	// dao 객체가 필요 -변수 선언
	private IProdDao dao;
	
	// 자신의 객체 변수 선언
	private static ProdServiceImpl service;

	// 생성자 -dao 객체 얻기
	private ProdServiceImpl(){
		dao = ProdDaoImpl.getDao();
	}
	// 자신의 객체를 생성하고 리턴하는 메소드
	public static IProdService getService() {
		if(service==null) service = new ProdServiceImpl();
		return service;
	}
	
	@Override
	public List<ProdVO> selectByLgu(String lgu) {
		// 1. 리턴 결과형 변수 선언

		// 2. 실행
		
		// 3. 리턴 결과
		return dao.selectByLgu(lgu);
	}

	@Override
	public ProdVO selectById(String id) {
		ProdVO prodVo = null;
		
		prodVo=dao.selectById(id);
		
		return prodVo;
	}

}
