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

public class ProjectUpdateHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			int no = Integer.parseInt(req.getParameter("no"));
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			SPMSDAO dao = sqlSession.getMapper(SPMSDAO.class);
			SPMS spms = dao.selectByNo(no);
			req.setAttribute("spms", spms);
			sqlSession.close();
			return "/WEB-INF/view/projectUpdateForm.jsp";			
		} else if(req.getMethod().equalsIgnoreCase("post")) {
			int no = Integer.parseInt(req.getParameter("no"));
			String name = req.getParameter("name");
			String content = req.getParameter("content");
			String progress = req.getParameter("progress");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date startdate = sdf.parse(req.getParameter("startdate"));
			Date enddate = sdf.parse(req.getParameter("enddate"));
			
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			SPMSDAO dao = sqlSession.getMapper(SPMSDAO.class);
			SPMS spms = new SPMS(no, name, content, startdate, enddate, progress);
			dao.update(spms);
			sqlSession.commit();
			sqlSession.close();
			resp.sendRedirect(req.getContextPath() + "/detail.do?no=" + no);
			return null;
		}
		return null;
	}
}
