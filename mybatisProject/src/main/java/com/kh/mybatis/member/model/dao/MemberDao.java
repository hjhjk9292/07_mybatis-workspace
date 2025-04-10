package com.kh.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.vo.Member;

public class MemberDao {
	
	public int insertMember(SqlSession sqlSession, Member m) {
		
		/*
		 * sqlSession에서 제공하는 메소드를 통해서 sql문 찾아서 실행하고 결과 바로 받음
		 * 
		 * sqlSession.sql문 종류에 맞는 메소드("매퍼의별칭.해당sql문의고유한id", [그 sql문을 완성시킬 객체])
		 * 
		 */
		
		// int result = sqlSession.insert("memberMapper.insertMember", m);
		// return result; 한 줄로 가능 ㄱ
		
		return sqlSession.insert("memberMapper.insertMember", m);
		
	}
	
	public Member loginMember(SqlSession sqlSession, Member m) { // 
		
		// Member loginUser = sqlSession.selectOne("memberMapper.loginMember", m); 
		// 쿼리의 namespace인 memberMapper . 뒤에 id 값 작성 // 한줄로 ㄱ 
		
		return sqlSession.selectOne("memberMapper.loginMember", m); // selectOne 결과가 1개일 경우
	}

}
