package ca.kanoa.manager.sql;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class StudentMapper implements ResultSetMapper<StudentInfo> {

	@Override
	public StudentInfo map(int index, ResultSet r, StatementContext ctx) 
			throws SQLException {
		return new StudentInfo(r.getInt(0), r.getString(1), r.getString(2), 
				r.getString(3), r.getString(4), r.getString(5), r.getString(6), 
				r.getString(7), r.getInt(8), r.getInt(9), r.getString(10), 
				r.getString(11));
	}
	
}
