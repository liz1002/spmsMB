package com.liz.dao;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.liz.dto.SPMS;
import com.liz.util.MyBatisSqlSessionFactory;

public class TestSPMSDAO {
	private SqlSession sqlSession = null;
	private SPMSDAO dao = null;
	
	@Before
	public void openSqlSession() {
		sqlSession = MyBatisSqlSessionFactory.openSession();
		dao = sqlSession.getMapper(SPMSDAO.class);
	}
	
	@After
	public void closeSqlSession() {
		sqlSession.close();
	}
	
// ---------	Test	------------------------------------------------------
	
//	@Test
	public void testList() {
		dao.list();
	}
	
//	@Test
	public void testSelectByNo() {
		dao.selectByNo(1);
	}

//	@Test
	public void testInsert(){
		dao.insert(new SPMS(0, "프로젝트 추가 테스트", "프로젝트 추가 테스트입니다", new Date(), new Date(), "진행중"));
		sqlSession.commit();
	}
	
//	@Test
	public void testUpdate(){
		dao.update(new SPMS(1, "프로젝트 수정 테스트", "프로젝트 수정 테스트입니다", new Date(), new Date(), "진행중"));
		sqlSession.commit();
	}
	
	@Test
	public void testDelete(){
		dao.delete(2);
		sqlSession.commit();
	}
}
