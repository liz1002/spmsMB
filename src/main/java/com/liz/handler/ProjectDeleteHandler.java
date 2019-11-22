package com.liz.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.liz.controller.CommandHandler;
import com.liz.dao.SPMSDAO;
import com.liz.util.MyBatisSqlSessionFactory;

public class ProjectDeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int no = Integer.parseInt(req.getParameter("no"));

		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		SPMSDAO dao = sqlSession.getMapper(SPMSDAO.class);
		dao.delete(no);
		sqlSession.commit();
		sqlSession.close();
		resp.sendRedirect(req.getContextPath() + "/list.do");
		return null;
	}
}
