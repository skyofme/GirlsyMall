package team.girlsy.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据库连接类
 * 
 * @author August
 * 
 */
public class BaseDao {

	// 数据库驱动名称
	private final static String driverName = "com.mysql.jdbc.Driver";
	// 数据库连接地址
	private final static String url = "jdbc:mysql://localhost:3306/girlsy?useUnicode=true&characterEncoding=utf8";
	// 用户名
	private final static String username = "root";
	// 密码
	private final static String password = "root";
	// 创建CallableStatement对象
	private static Connection connection = null;
	// 创建PreparedStatement对象
	private static PreparedStatement pstmt = null;
	// 创建结果集对象
	private static ResultSet rs = null;

	// 建立数据库连接
	public static Connection getConnection() {
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, username, password);
			return connection;
		} catch (ClassNotFoundException e) {
			System.out.println("数据库驱动没有找到！");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("数据库连接失败！");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * insert update delete SQL语句的执行的统一方法
	 * 
	 * @param sql
	 *            SQL语句
	 * @param args
	 *            参数数组，若没有参数则为null
	 * @return 受影响的行数
	 */
	public static int excuteUpdate(String sql, Object... args) {
		try {
			// 调用SQL
			pstmt = getConnection().prepareStatement(sql);
			// 参数赋值
			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					pstmt.setObject(i + 1, args[i]);
				}
			}
			// 执行并返回受影响的行数
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("执行语句失败！");
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return 0;
	}

	public static List<Object> excuteQuery(String sql, Object... args) {
		List<Object> list = new ArrayList<Object>();
		try {
			// 调用SQL
			pstmt = getConnection().prepareStatement(sql);
			// 参数赋值
			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					pstmt.setObject(i + 1, args[i]);
				}
			}
			// 执行
			rs = pstmt.executeQuery();
			// 创建ResultSetMetaData对象
			ResultSetMetaData rsmd = null;
			rsmd = rs.getMetaData();
			// 获得结果集列数
			int columnCount = rsmd.getColumnCount();
			// 将ResultSet的结果保存到List中 
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 1; i <= columnCount; i++) {
					map.put(rsmd.getColumnLabel(i), rs.getObject(i));
				}
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAll();
		}
		return list;
	}
	public static ResultSet query(String sql, Object[] params){
		PreparedStatement pst;
		ResultSet rs = null;
		try {
			pst = (PreparedStatement) getConnection().prepareStatement(sql);
			if(params != null){
				for(int i = 1; i <= params.length; i++){
					pst.setObject(i, params[i-1]);
					//System.out.println("zhelimeiyoucuo");
				}
			}
			rs = pst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(rs+"zhelixian");
		return rs;
	}

	// 关闭所有资源
	public static void closeAll() {
		try {
			// 关闭结果集对象
			if (rs != null) {
				rs.close();
			}
			// 关闭PreparedStatement对象
			if (pstmt != null) {
				pstmt.close();
			}
			// 关闭Connection 对象
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			System.out.println("数据库连接关闭失败！");
			e.printStackTrace();
		}
	}
}
