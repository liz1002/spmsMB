package com.liz.dto;

import java.util.Date;

public class SPMS {
	private int no;
	private String name;
	private String content;
	private Date startdate;
	private Date enddate;
	private String progress;
	
	public SPMS() {	}
	
	public SPMS(int no, String name, String content, Date startdate, Date enddate, String progress) {
		super();
		this.no = no;
		this.name = name;
		this.content = content;
		this.startdate = startdate;
		this.enddate = enddate;
		this.progress = progress;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	@Override
	public String toString() {
		return "\nSPMS [no=" + no + ", name=" + name + ", content=" + content + ", startdate=" + startdate + ", enddate="
				+ enddate + ", Progress=" + progress + "]";
	}	
}
