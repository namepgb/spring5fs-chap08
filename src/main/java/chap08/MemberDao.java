package chap08;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class MemberDao
{
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource ds)
	{
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	public Member selectByEmail(String email)
	{
		List<Member> results = jdbcTemplate.query(
			"select * from MEMBER where EMAIL = ?",
			new RowMapper<Member>() {
				@Override
				public Member mapRow(ResultSet rs, int rowNum)
					throws SQLException
				{
					Member member = new Member(
						rs.getString("EMAIL"),
						rs.getString("PASSWORD"),
						rs.getString("NAME"),
						rs.getTimestamp("REGDATE").toLocalDateTime());
					member.setId(rs.getLong("ID"));
					return member;
				}
			}, email);
		return results.isEmpty() ? null : results.get(0);
	}
	
	public void insert(Member member)
	{
	
	}
	
	public void update(Member member)
	{
	
	}
	
	public List<Member> selectAll()
	{
		List<Member> results = jdbcTemplate.query(
			"select * from MEMBER",
			new RowMapper<Member>() {
				@Override
				public Member mapRow(ResultSet rs, int rowNum)
					throws SQLException
				{
					Member member = new Member(
						rs.getString("EMAIL"),
						rs.getString("PASSWORD"),
						rs.getString("NAME"),
						rs.getTimestamp("REGDATE").toLocalDateTime());
					member.setId(rs.getLong("ID"));
					return member;
				}
			});
		return results;
	}
}
