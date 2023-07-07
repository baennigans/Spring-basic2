package aisw.web.service;

import java.sql.SQLException;
import java.util.List;

import aisw.web.entity.Notice;

public interface NoticeService {
	public List<Notice> getList(int page, String field, String query) throws ClassNotFoundException, SQLException;

	public int getCount() throws ClassNotFoundException, SQLException;

	public int insert(Notice notice) throws SQLException, ClassNotFoundException;

	public int update(Notice notice) throws SQLException, ClassNotFoundException;

	int delete(int id) throws ClassNotFoundException, SQLException;
}