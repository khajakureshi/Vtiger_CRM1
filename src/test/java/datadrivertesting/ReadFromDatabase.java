package datadrivertesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadFromDatabase {

	public static void main(String[] args) throws SQLException {
//		//step 1: create Driver instance
//		Driver dbDriver =new Driver();
//		//Step 2: Register to JDBC Driver
//		DriverManager.registerDriver(dbDriver);
		//Step 3: Establish JDBC connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advsel","root","root");
		//Step 4: Create statement
		Statement statement = connection.createStatement();
		//Step 5: Execute query to fetch data
		ResultSet result = statement.executeQuery("select * from student");
		while(result.next()) {
			System.out.println(result.getInt("sid")+"\t"+result.getString("sname")+"\t"+result.getString("phno")+"\t"+result.getString("course"));
		}
		//step 6: close database
		connection.close();
		}

	}


