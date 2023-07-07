package kr.ac.kopo.controller.biz.board;

import java.util.Date;

public class BoardVO {
	private int no;
	private String id;
	private String title;
	private String detail;
	private Date date;
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "BoardVO [no=" + no + ", id=" + id + ", title=" + title + ", detail=" + detail + ", date=" + date + "]";
	}
}
