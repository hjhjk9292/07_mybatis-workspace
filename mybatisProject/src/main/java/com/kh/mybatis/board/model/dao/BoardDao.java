package com.kh.mybatis.board.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.model.vo.PageInfo;

public class BoardDao {
	
	public int selectListCount(SqlSession sqlSession) {
		return sqlSession.selectOne("boardMapper.selectListCount"); // xml에서 resultType="_int" int로 받겠다고 했기 때문에 return을 int로 함
	}
	
	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi){
		
		// sqlSession.selectList("boardMapper.selectList", pi, null);
		
		// 마이바티스에서는 페이징 처리를 위해 RowBounds 라는 클래스 제공
		
		// * offset : 몇개의 게시글 건너 뛰고 조회할건지에 대한 값
		
		/*
		 * ex) boardLimit : 5
		 * 
		 * 									offset(건너뛸 숫자)	limit(조회할 숫자)
		 * currentPage : 1		1~5					0					5
		 * currentPage : 2		6~10				5					5
		 * currentPage : 3		11~15				10					5
		 * ...
		 */
		
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectList", null, rowBounds); // 쿼리에 줄 값이 없을 때 null이라고 작성 // 마지막 인자를 rowBounds로 줘야함
		// return list; 한 줄 처리로 간단하게 하기 위해 ArrayList<Board> list = (ArrayList)sqlSession.selectList("boardMapper.selectList", null, rowBounds); 코드를 ㄴ위처럼 수정
	}
	
	public int increaseCount(SqlSession sqlSession, int boardNo) {
		return sqlSession.update("boardMapper.increaseCount", boardNo);
	}
	
	public Board selectBoard(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.selectBoard",boardNo); // 변수를 넘긴 것	
	}
	
	public ArrayList<Reply> selectReplyList(SqlSession sqlSession, int boardNo){
		return (ArrayList)sqlSession.selectList("boardMapper.selectReplyList", boardNo);
	}
	
	public int selectSearchCount(SqlSession sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("boardMapper.selectSearchCount", map);
	}

}
