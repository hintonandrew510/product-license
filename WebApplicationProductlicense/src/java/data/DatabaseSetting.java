package data;

public class DatabaseSetting {
	public static final String MYSQL_USERNAME = System
			.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
	public static final String MYSQL_PASSWORD = System
			.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
	public static final String MYSQL_DATABASE_HOST = System
			.getenv("OPENSHIFT_MYSQL_DB_HOST");
	public static final String MYSQL_DATABASE_PORT = System
			.getenv("OPENSHIFT_MYSQL_DB_PORT");
	
}
