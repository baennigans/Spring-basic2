package aisw.web.service.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import aisw.web.entity.Notice;
import aisw.web.service.NoticeService;

@Service
public class JDBCNoticeService implements NoticeService {

	@Autowired
	private DataSource dataSource;

	public List<Notice> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {

		// spring JDBC
		String sql = "SELECT * FROM NOTICE";
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(dataSource);
		List<Notice> list = template.query(sql, new BeanPropertyRowMapper(Notice.class));

		return list;

	}

	// Scalar
	public int getCount() throws ClassNotFoundException, SQLException {
		int count = 0;

		String sql = "SELECT COUNT(ID) COUNT FROM NOTICE";

//			Class.forName(driver);
//			Connection con = DriverManager.getConnection(url,uid, pwd);
		Connection con = dataSource.getConnection();

		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(sql);

		if (rs.next())
			count = rs.getInt("COUNT");

		rs.close();
		st.close();
		con.close();

		return count;
	}

	public int insert(Notice notice) throws SQLException, ClassNotFoundException {
		String title = notice.getTitle();
		String writerId = notice.getWriterId();
		String content = notice.getContent();
		String files = notice.getFiles();

		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "INSERT INTO notice (    " + "    title," + "    writer_id," + "    content," + "    files"
				+ ") VALUES (?,?,?,?)";

//			Class.forName(driver);
//			Connection con = DriverManager.getConnection(url,uid, pwd);
		Connection con = dataSource.getConnection();

		// Statement st = con.createStatement();
		// st.ex....(sql)
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, writerId);
		st.setString(3, content);
		st.setString(4, files);

		int result = st.executeUpdate();

		st.close();
		con.close();

		return result;
	}

	public int update(Notice notice) throws SQLException, ClassNotFoundException {
		String title = notice.getTitle();
		String content = notice.getContent();
		String files = notice.getFiles();
		int id = notice.getId();

		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "UPDATE NOTICE " + "SET" + "    TITLE=?," + "    CONTENT=?," + "    FILES=?" + "WHERE ID=?";

//			Class.forName(driver);
//			Connection con = DriverManager.getConnection(url,uid, pwd);
		Connection con = dataSource.getConnection();

		// Statement st = con.createStatement();
		// st.ex....(sql)
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, content);
		st.setString(3, files);
		st.setInt(4, id);

		int result = st.executeUpdate();

		st.close();
		con.close();

		return result;
	}

	public int delete(int id) throws ClassNotFoundException, SQLException {

		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "DELETE NOTICE WHERE ID=?";

		// Class.forName(driver);
		// Connection con = DriverManager.getConnection(url,uid, pwd);
		Connection con = dataSource.getConnection();

		// Statement st = con.createStatement();
		// st.ex....(sql)
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);

		int result = st.executeUpdate();

		st.close();
		con.close();

		return result;
	}

}