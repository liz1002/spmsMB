package com.liz.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.liz.controller.CommandHandler;
import com.liz.dao.SPMSDAO;
import com.liz.dto.SPMS;
import com.liz.util.MyBatisSqlSessionFactory;

public class ProjectListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		SPMSDAO dao = sqlSession.getMapper(SPMSDAO.class);
		List<SPMS> list = dao.list();
		req.setAttribute("list", list);
		sqlSession.close();
		return "/WEB-INF/view/projectList.jsp";
	}
}
