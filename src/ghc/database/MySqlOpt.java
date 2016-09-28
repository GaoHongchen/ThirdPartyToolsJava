package ghc.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import ghc.files.PropertiesOpt;

public class MySqlOpt {	
	private static final String JDBC_PROPERTIES = "src/database.properties";
	private Connection conn;
	public Statement statement;
	
	/**
	 * ��̬����mysql����
	 * ��ʽ��or:com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
	 * or��new com.mysql.jdbc.Driver();
	 */
	public MySqlOpt(){  
        try {
        	final String driver = PropertiesOpt.GetValueByKey(JDBC_PROPERTIES, "jdbc.driver");
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        System.out.println("�ɹ�����MySQL��������");
	}
	
	/**
	 * �������ݿ�
	 * MySQL��JDBC URL��д��ʽ��jdbc:mysql://�������ƣ����Ӷ˿�/���ݿ������?����=ֵ
	 * ������������Ҫָ��useUnicode��characterEncoding
	 */
	public void connectDB(){
        try { 	
        	String url = PropertiesOpt.GetValueByKey(JDBC_PROPERTIES, "jdbc.url");
			conn = DriverManager.getConnection(url);
        	//conn = DriverManager.getConnection(HOST+DATABASE,USER,PASSWORD);
			statement = (Statement) conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}      
	}
	
	/**
	 * ���ݿ��ѯ
	 */
	public void queryDB(){
		String sql = "select * from user_footdata where UserFootId > 322 and UserFootId < 416 and BrandSizeRealSNOOPY is not null";
		try {
			//executeQuery�᷵�ؽ���ļ��ϣ����򷵻ؿ�ֵ
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {    
				String str1 = rs.getString(2);
				int id = rs.getInt(4);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createTable(){
		String sql = "create table student1(NO char(20),name varchar(20),primary key(NO))";
		int result;
		try {
			result = statement.executeUpdate(sql);
			if (result != -1) {
	            System.out.println("�������ݱ�ɹ�");
	            
	            sql = "insert into student1(NO,name) values('2012001','��ΰ��')";
	            result = statement.executeUpdate(sql);

	            sql = "select * from student1";
	            ResultSet rs = statement.executeQuery(sql);//executeQuery�᷵�ؽ���ļ��ϣ����򷵻ؿ�ֵ
	            System.out.println("ѧ��\t����");
	            while (rs.next()) {
	                System.out.println(rs.getString(1) + "\t" + rs.getString(2));
	            }
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close(){
		try {
			conn.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}