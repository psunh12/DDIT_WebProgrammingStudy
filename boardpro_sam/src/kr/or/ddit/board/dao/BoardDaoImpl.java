package kr.or.ddit.board.dao;

import java.awt.image.DataBufferUShort;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;
import kr.or.ddit.mybatis.config.MybatisUtil;

public class BoardDaoImpl  implements IBoardDao{

	private SqlSession  session;
	private static  IBoardDao dao;
	
	private BoardDaoImpl() {};

	public static IBoardDao  getDao() {
		if(dao == null ) dao = new BoardDaoImpl();
		
		return dao;
	}
	
	@Override
	public List<BoardVO> selectByPage(Map<String, Object> map) {
		session = MybatisUtil.getSqlSession();
	
		List<BoardVO> list = null;
		  
        try {
			list = session.selectList("board.selectByPage", map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		  	session.commit();
		  	session.close();
		}
        
        return list;
	}

	@Override
	public int getTotalCount(Map<String, Object> map) {
		session = MybatisUtil.getSqlSession();
		
		int count = 0;
		 
        try {
        	 count = session.selectOne("board.getTotalCount", map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
		  	session.close();
		}
		return count;
	}

	@Override
	public int insertBoard(BoardVO vo) {
		session = MybatisUtil.getSqlSession();
		
		int count = 0;
		  
        try {
        	 count = session.insert("board.insertBoard", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
		  	session.close();
		}
		return count;
	}

	@Override
	public int updateBoard(BoardVO vo) {
		session = MybatisUtil.getSqlSession();
		
		int count = 0;
		  
        try {
        	 count = session.update("board.updateBoard", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
		  	session.close();
		}
		return count;
	}

	@Override
	public int deleteBoard(int num) {
		session = MybatisUtil.getSqlSession();
		
		int count = 0;
		  
        try {
        	 count = session.delete("board.deleteBoard", num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
		  	session.close();
		}
		return count;
	}

	@Override
	public int updateHit(int num) {
		session = MybatisUtil.getSqlSession();
		
		int count = 0;
		  
        try {
        	 count = session.update("board.updateHit", num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
		  	session.close();
		}
		return count;
	}

	@Override
	public List<ReplyVO> selectReply(int bonum) {
		session = MybatisUtil.getSqlSession();
		
		List<ReplyVO> list = null;
		  
        try {
        	 list = session.selectList("board.selectReply", bonum);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
		  	session.close();
		}
		return list;
	}

	@Override
	public int insertReply(ReplyVO vo) {
		session = MybatisUtil.getSqlSession();
		
		int res = 0;
		  
        try {
        	 res = session.insert("board.insertReply", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
		  	session.close();
		}
		return res;
	}

	@Override
	public int updateReply(ReplyVO vo) {
		session = MybatisUtil.getSqlSession();
		
		int res = 0;
		  
        try {
        	 res = session.update("board.updateReply", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
		  	session.close();
		}
		return res;
	}


	@Override
	public int deleteReply(int renum) {
		session = MybatisUtil.getSqlSession();
		
		int res = 0;
		  
        try {
        	 res = session.delete("board.deleteReply", renum);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
		  	session.close();
		}
		return res;
	}

}
