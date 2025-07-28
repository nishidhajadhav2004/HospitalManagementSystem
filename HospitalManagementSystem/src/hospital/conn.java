package hospital;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;


public class conn {
	
	Connection connection;
	Statement statement;
	
	public conn() {
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root","root");
			statement=(Statement) connection.createStatement();
		}catch(Exception e)
		{
			e.printStackTrace();
			
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
}
