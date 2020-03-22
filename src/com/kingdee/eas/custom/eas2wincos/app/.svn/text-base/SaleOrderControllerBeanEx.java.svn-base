package com.kingdee.eas.custom.eas2wincos.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.kingdee.bos.Context;
import com.kingdee.eas.custom.eas2wincos.comm.EASWUtils;

public class SaleOrderControllerBeanEx {
	public static Boolean checkHasUsedByWinCos(Context ctx,String companyID) {
		Boolean result=false;
		Connection conn = null;
		try{
			conn= EASWUtils. getWinCosConnection(ctx,companyID);//得到连接
			if(conn==null) {
				throw new Exception("请确认连接参数设置正确!");
			}
			StringBuffer sql=new StringBuffer();
			sql.append(" select ");
			sql.append(" from ");
			sql.append(" ");
			sql.append(" where ");
			sql.append(" ");
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql.toString());
			if(rs.next()) {
				result=true;
			}
			rs.close();
			stm.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
