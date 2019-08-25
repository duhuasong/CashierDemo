package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jdesktop.swingx.JXLoginPane.SaveMode;

import com.google.gson.Gson;

public class Dao {
	private static String Drivde = "org.sqlite.JDBC";
	private static Logger log = LogManager.getLogger(Dao.class);
	private static Connection connection;
	private static Statement statement;

	public static void connect(String db) {
		try {
			Class.forName(Drivde);
			connection = DriverManager.getConnection("jdbc:sqlite:db/" + db);// 连接数据库zhou.db,不存在则创建
			statement = connection.createStatement(); // 创建连接对象，是Java的一个操作数据库的重要接口
			String sql = "create table transflow(order_id varchar(20),time varchar(20),pl varchar(20),amount varchar(8),status varchar(64))";
			statement.executeUpdate(sql); // 创建数据库
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 加载驱动,连接sqlite的jdbc
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void save(String[] args) {
		try {
			PreparedStatement prep = connection.prepareStatement("insert into transflow values (?, ?,?, ?, ?);");
			prep.setString(1, args[0]);
			prep.setString(2, args[1]);
			prep.setString(3, args[2]);
			prep.setString(4, args[3]);
			prep.setString(5, args[4]);
			prep.addBatch();
			connection.setAutoCommit(false);
			prep.executeBatch();
			connection.setAutoCommit(true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public List<String[]> select() {
		List<String[]> list = new ArrayList<>();
		try {
			ResultSet rs = statement.executeQuery("select * from transflow  order by time desc limit 4 ;");
			while (rs.next()) {
				String[] strings = new String[] { "", "", "", "", "" };
				strings[0] = rs.getString("order_id");
				strings[1] = rs.getString("time");
				strings[2] = rs.getString("pl");
				strings[3] = rs.getString("amount");
				strings[4] = rs.getString("status");
				list.add(strings);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public static void main(String[] args) {
		Dao dao = new Dao();
		Dao.connect("tr");
		List<String[]> strings = dao.select();
		System.out.print(new Gson().toJson(strings));

	}
}
