package com.liz.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.liz.controller.CommandHandler;
import com.liz.dao.SPMSDAO;
import com.liz.dto.SPMS;
import com.liz.util.MyBatisSqlSessionFactory;

public class ProjectDetailHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int no = Integer.parseInt(req.getParameter("no"));
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		SPMSDAO dao = sqlSession.getMapper(SPMSDAO.class);
		SPMS spms = dao.selectByNo(no);
		req.setAttribute("spms", spms);
		sqlSession.close();
		return "/WEB-INF/view/projectDetail.jsp";
	}
}
