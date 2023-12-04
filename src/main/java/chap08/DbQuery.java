package chap08;

import org.apache.tomcat.jdbc.pool.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbQuery
{
	private DataSource ds;
	
	public DbQuery(DataSource ds)
	{
		this.ds = ds;
	}
	
	public int count()
	{
		Connection conn = null;
		try {
			conn = ds.getConnection();
			try (Statement stmt = conn.createStatement();
			     ResultSet rs = stmt.executeQuery("select count(*) from MEMBER")) {
				rs.next();
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
