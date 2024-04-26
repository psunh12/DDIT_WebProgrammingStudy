package kr.or.ddit.lprod.service;

import java.util.List;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.vo.LprodVO;

public class LprodServiceImpl implements ILprodService {
	
	
	// dao 객체 필요함
	private ILprodDao dao;
	// 자신의 객체변수 선언
	private static ILprodService service;	// 여러곳의 클라이언트에서 사용할 수 있도록 static을 선언
	
	// 생성자
	private LprodServiceImpl() {
		dao = LprodDaoImpl.getDao();
	}
	
	
	
	// 자신의 객체 생성하고 리턴
	public static ILprodService getService() {
		if(service==null) service =new LprodServiceImpl();
		
		return service;
	}
	//
	@Override
	public List<LprodVO> selectLprod() {
		// 리턴 결과형의 변수 선언
		List<LprodVO> list = null;
		list=dao.selectLprod();
		
		return list;
	}

}
