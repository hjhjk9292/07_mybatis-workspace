package com.kh.mybatis.board.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.model.vo.PageInfo;

public interface BoardService {
	
	// 게시글 리스트 조회하기 위한 메소드 설계
	int selectListCount();
	ArrayList<Board> selectList(PageInfo pi);
	
	// 게시글 상세 조회
	int increaseCount(int boardNo); // 조회수 증가
	Board selectBoard(int boardNo); // 해당 게시글이 몇 번인지 알고 조회하도록 설계
	ArrayList<Reply> selectReplyList(int boardNo);
	
	// 게시글 검색
	int selectSearchCount(HashMap<String, String> map);
	ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi);
}
