package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PageVO;
import kr.or.ddit.board.vo.ReplyVO;

public class BoardServiceImpl implements IBoardService {

	private IBoardDao  dao;
	private static IBoardService  service;
	
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getDao();
	}
	
	public static  IBoardService getService() {
		if(service == null)  service = new BoardServiceImpl();
		
		return service;
	}
	
	@Override
	public List<BoardVO> selectByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.selectByPage(map);
	}

	@Override
	public int getTotalCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.getTotalCount(map);
	}

	@Override
	public int insertBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return dao.insertBoard(vo);
	}

	@Override
	public int updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return dao.updateBoard(vo);
	}

	@Override
	public int deleteBoard(int num) {
		// TODO Auto-generated method stub
		return dao.deleteBoard(num);
	}

	@Override
	public int updateHit(int num) {
		// TODO Auto-generated method stub
		return dao.updateHit(num);
	}

	@Override
	public PageVO getPageInfo(int page, String stype, String sword) {
		
		//전체 글 갯수 구하기 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stype", stype);
		map.put("sword" , sword);
		
		int count = this.getTotalCount(map);
		
		int plist = PageVO.getPerList();
		
		int totalPage = (int) Math.ceil( (double)count/  plist );
		
		if(page > totalPage ) page = totalPage;
			
		//start, end구하기 
		int start =(page -1) *  plist + 1;
		int end  = start + plist - 1;
		if(end > count) end = count;
		
		//startPage, endPage 
		int ppage = PageVO.getPerPage();
		int startPage =  ((page-1) /ppage * ppage) + 1;
		int endPage  = startPage + ppage - 1;
		if(endPage >  totalPage ) endPage = totalPage;
		
			
		PageVO  pvo = new PageVO();
		pvo.setStart(start);
		pvo.setEnd(end);
		pvo.setStartPage(startPage);
		pvo.setEndPage(endPage);
		pvo.setTotalPage(totalPage);
			
		return pvo;
	}

	@Override
	public List<ReplyVO> selectReply(int bonum) {
		// TODO Auto-generated method stub
		return dao.selectReply(bonum);
	}

	@Override
	public int insertReply(ReplyVO vo) {
		// TODO Auto-generated method stub
		return dao.insertReply(vo);
	}

	@Override
	public int updateReply(ReplyVO vo) {
		// TODO Auto-generated method stub
		return dao.updateReply(vo);
	}

	@Override
	public int deleteReply(int renum) {
		// TODO Auto-generated method stub
		return dao.deleteReply(renum);
	}

}












