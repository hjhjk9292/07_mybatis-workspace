package com.kh.mybatis.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.template.Template;
import com.kh.mybatis.member.model.dao.MemberDao;
import com.kh.mybatis.member.model.vo.Member;

public class MemberServiceImpl implements MemberService {
	
	private MemberDao mDao = new MemberDao(); // mybatis에서는 계속 호출할 필요 없도록..

	@Override
	public int insertMember(Member m) {
		
		/*
         * Connection conn = JDBCTemplate.getConnection();
         * int result = new MemberDao().insertMember(conn,m);
         * 
         * if(result > 0) {
         *     JDBCTemplate.commit(conn);
         * }else{
         *     JDBCTemplate.rollback(conn);
         * }
         * 
         * return result
         */
		
		SqlSession sqlSession = Template.getSqlSession(); // 이 구문이 제일 중요
		
		
		int result = mDao.insertMember(sqlSession, m);

		if(result > 0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
		
	}

	@Override
	public Member loginMember(Member m) {
		
		SqlSession sqlSession = Template.getSqlSession();
		Member loginUser = mDao.loginMember(sqlSession, m);
		
		sqlSession.close();
		return loginUser;
		
	}

	@Override
	public int updateMember(Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
