package ca.kanoa.manager.sql;

public class Statements {

	public static final String TABLE_CHECK = 
			"CREATE TABLE students "
			+ "( "
			+ "ID INT PRIMARY KEY AUTO_INCREMENT, "
			+ "ParentName VARCHAR(255), "
			+ "Phone VARCHAR(15), "
			+ "Email VARCHAR(255), "
			+ "Timezone VARCHAR(255), "
			+ "Location TEXT, "
			+ "Class VARCHAR(255), "
			+ "MinecraftUsername VARCHAR(16), "
			+ "StudentAge TINYINT UNSIGNED, "
			+ "Gender TINYINT UNSIGNED, "
			+ "Notes TEXT, "
			+ "StudentName VARCHAR(255) "
			+ ");";
	
	public static final String ADD_STUDENT = 
			"INSERT INTO students  VALUES "
			+ "( "
			+ ":parent, :phone, :email, :timezone, "
			+ ":location, :class, :username, :age, "
			+ ":gender, :notes, :name "
			+ ");";
	
	public static final String FIND_STUDENT = 
			"SELECT * FROM students WHERE ID=:id";
}
