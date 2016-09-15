package cn.com.util;

import java.util.*;
import java.sql.*;

import oracle.jdbc.OracleTypes;


import javax.naming.*;
import javax.sql.DataSource;
/**
 * jdbc操作类
 * @author lej
 */
public class DbUtil {
	private static Connection con = null;//连接对象
	private static PreparedStatement psmt = null; //预编译命令对象
	private static ResultSet res = null; //结果集对象
	private static CallableStatement csmt = null; //过程处理对象

	/**
	 * 获取连接对象
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		
			try {
				DbUtil.closeAll();
				Context context=new InitialContext(); //加载连接池配置文件
			DataSource dataSource=(DataSource)context.lookup("java:comp/env/jdbc/oracle"); //从相应配置文件中加载名为"java:comp/env/jdbc/oracle"的对象 
		con=		dataSource.getConnection(); //获取连接对象
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
          return con;
	}

	/**
	 * 获取预编译命令对象
	 * 
	 * @param sql
	 * @return
	 */
	public static PreparedStatement getPreparedStatement(String sql) {
		con = getConnection();
		try {
			psmt = con.prepareStatement(sql);  //获取预编译命令对象
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return psmt;
	}

	/**
	 * 获取结果集对象
	 * 
	 * @param sql
	 * @return
	 */
	public static ResultSet getResultSet(String sql) {
		psmt = getPreparedStatement(sql);
		try {
			res = psmt.executeQuery();  //获取结果集对象

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * 获取预过程对象
	 * 
	 * @param sql
	 * @return
	 */
	public static CallableStatement getCallableStatement(String sql) {
		con = getConnection();
		try {
			csmt = con.prepareCall(sql); //预处理过程
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return csmt;
	}

	/**
	 * 执行sql语句返回受影响的行数
	 * 
	 * @param sql
	 *            语句
	 * @param params
	 *            参数集合
	 * @return int
	 */
	public static int executeUpdate(String sql,  List<Object> params) {
		int count = 0;
		psmt = getPreparedStatement(sql);
		
		bindParams(psmt, params);  //绑定参数
		try {
			
			count = psmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally {
				closeAll();
			}
		return count;

	}

	/**
	 * 执行sql语句返回结果集对象
	 * 
	 * @param sql
	 *            语句
	 * @param params
	 *            参数集合
	 * @return ResultSet
	 */
	public static ResultSet executeQuery(String sql, List<Object> params) {
		ResultSet rest = null;
		psmt = getPreparedStatement(sql);
		bindParams(psmt, params); //绑定参数
		try {
			rest = psmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rest;
	}
/**
 * 执行过程方法
 * @param sql
 * @param params
 * @return
 */
	public static CallableStatement executeCallable(String sql,
			Map<Integer, MyParams> params) {
		csmt = getCallableStatement(sql);
		try {
			//绑定过程参数对象
			for (Integer key : params.keySet()) {
				if (params.get(key).getType().equals("out")) { //是输出参数的情况
					if (params.get(key).getValue().equals(OracleTypes.CURSOR)) {
						csmt.registerOutParameter(key, OracleTypes.CURSOR); //是游标对象的情况
					}
					if(params.get(key).getValue().equals(Types.INTEGER)){
						csmt.registerOutParameter(key,Types.INTEGER); //输出行数的情况
					}
				} else { //输入参数的情况
                  csmt.setObject(key, params.get(key).getValue());
				}
			}
			
			csmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return csmt;
	}

	/**
	 * 绑定参数
	 * 
	 * @param psmt
	 *            预编译命令对象
	 * @param params
	 *            参数集合
	 */
	public static void bindParams(PreparedStatement psmt,
			List<Object> params) {
		if(params!=null){
		if (params.size() > 0) {
			for (int i=0;i<params.size();i++) {
				try {
					psmt.setObject(i+1, params.get(i));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	}
	/**
	 * 关闭资源的方法
	 */
	public static void closeAll(){
		try {
			if (con != null) {

				con.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (res != null) {
				res.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
