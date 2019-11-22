package com.liz.handler;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.liz.controller.CommandHandler;
import com.liz.dao.SPMSDAO;
import com.liz.dto.SPMS;
import com.liz.util.MyBatisSqlSessionFactory;

public class ProjectInsertHandler implements CommandHandler {
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			return "/WEB-INF/view/projectInsertForm.jsp";
		} else if(req.getMethod().equalsIgnoreCase("post")) {
			String name = req.getParameter("name");
			String content = req.getParameter("content");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date startdate = sdf.parse(req.getParameter("startdate"));
			Date enddate = sdf.parse(req.getParameter("enddate"));
			String progress = req.getParameter("progress");
				
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			SPMSDAO dao = sqlSession.getMapper(SPMSDAO.class);
			SPMS spms = new SPMS(0, name, content, startdate, enddate, progress);
			dao.insert(spms);
			sqlSession.commit();
			sqlSession.close();
			resp.sendRedirect(req.getContextPath() + "/list.do");
		}
		return null;
	}
}
