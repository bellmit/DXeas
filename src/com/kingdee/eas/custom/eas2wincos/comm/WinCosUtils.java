package com.kingdee.eas.custom.eas2wincos.comm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

public class WinCosUtils {
	/**
	 * 反写导入状态
	 * @param conn
	 * @param easBillID
	 * @param winCosBillNum
	 * @throws SQLException 
	 */
	public static void reWriteImportBillStatus(Connection conn,String tableName,String easBillID,ArrayList<Integer> winCosBillNum) throws SQLException {
		String billNumbers="";
		for(int number:winCosBillNum) {
			if(billNumbers.length()>0) {
				billNumbers+=",";
			}
			billNumbers=billNumbers+"'"+number+"'";
		}
		if(StringUtils.isBlank(billNumbers)) {
			return;
		}
		StringBuffer sql=new StringBuffer();
		sql.append(" update ").append(tableName);
		sql.append(" set AppString03='").append(easBillID).append("'");
		sql.append(" where OID in (").append(billNumbers).append(")");
		Statement stm = conn.createStatement();
		stm.execute(sql.toString());
	}
	/**
	 * 检查是否已经导出到wincos
	 * 
	 * @param ctx
	 * @param companyID
	 * @param number
	 * @return
	 * @throws SQLException
	 */
	public static int checkHasExported(Connection conn, String tableName, String billID,String entryID)
			throws SQLException {
		if(conn==null)
			return 0;
		int result = 0;
		StringBuffer sql = new StringBuffer();
		sql.append(" select distinct OID");
		sql.append(" from ").append(tableName);
		sql.append(" where AppString02='").append(billID).append("'");
		if(StringUtils.isNotBlank(entryID))
			sql.append(" and AppString03='").append(entryID).append("'");
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql.toString());
		if (rs.next()) {
			result = rs.getInt("OID");
		}
		rs.close();
		stm.close();
		return result;
	}
}
