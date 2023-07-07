package kr.ac.kopo.controller.biz.comment;

public class CommentVO {
	private int no;
	private int boardNo;
	private String id;
	private String detail;
	private String date;
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "CommentVO [no=" + no + ", boardNo=" + boardNo + ", id=" + id + ", detail=" + detail + ", date=" + date
				+ "]";
	}
	
}
