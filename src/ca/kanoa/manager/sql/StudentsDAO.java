package ca.kanoa.manager.sql;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(StudentMapper.class)
public interface StudentsDAO {

	@SqlUpdate(Statements.TABLE_CHECK)
	void init();
	
	@SqlUpdate(Statements.ADD_STUDENT)
	void addStudent(
			@Bind("parent") String parentName, 
			@Bind("phone") String phoneNumber, 
			@Bind("email") String email,
			@Bind("timezone") String timezone, 
			@Bind("location") String location,
			@Bind("class") String studentClass,
			@Bind("username") String username,
			@Bind("age") int studentAge,
			@Bind("gender") int gender,
			@Bind("notes") String notes,
			@Bind("name") String studentName
		);
	
	@SqlQuery(Statements.FIND_STUDENT)
	StudentInfo getStudentByID(@Bind("id") int id);
	
	void close();
	
}
