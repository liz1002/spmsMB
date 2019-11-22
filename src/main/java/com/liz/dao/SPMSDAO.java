package com.liz.dao;

import java.util.List;

import com.liz.dto.SPMS;

public interface SPMSDAO {
	public List<SPMS> list();
	public SPMS selectByNo(int no);
	public int insert(SPMS spms);
	public int update(SPMS spms);	
	public int delete(int no); 
}
