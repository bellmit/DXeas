package com.kingdee.eas.custom.wages.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetJDBC {
	 //��������������ݿ�����
    private final static String URL = "jdbc:sqlserver://10.1.3.30:5005;DatabaseName=People";
    private static final String USER="admin";
    private static final String PASSWORD="";
    
    private static Connection conn=null;
    //��̬����飨�������������������ݿ���뾲̬���У�
    static{
        try {
            //1.������������
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2.������ݿ������
            conn=(Connection)DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //�����ṩһ����������ȡ���ݿ�����
    public static Connection getConnection(){
        return conn;
    }
    
    
   


}
