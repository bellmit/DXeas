package com.kingdee.eas.custom.eas2temp.comm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.Context;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.util.app.ContextUtil;

public class TempUtils {
	/**
	 * ��д����״̬-------------������Ҫ�����м������޸ģ�����
	 * @param conn
	 * @param easBillID
	 * @param tempBillNum
	 * @throws SQLException 
	 */
	public static void reWriteImportBillStatus(Connection conn,String tableName,String easBillID,ArrayList<Integer> TempBillID) throws SQLException {
		if(TempBillID==null)
			return;
		String billNumbers="";
		for(int number:TempBillID) {
			if(billNumbers.length()>0) {
				billNumbers+=",";
			}
			billNumbers=billNumbers+number;
		}
		if(StringUtils.isBlank(billNumbers)) {
			return;
		}
		StringBuffer sql=new StringBuffer();
		sql.append(" update ").append(tableName);
		sql.append(" set purinwarehsID='").append(easBillID).append("'");
		//sql.append(" ,DownloadState=1");
		sql.append(" where purinwarehsID in (").append(billNumbers).append(")");
		Statement stm = conn.createStatement();
		stm.execute(sql.toString());
	}
	
	/**
	 * ��д����״̬
	 * @param conn
	 * @param easBillID
	 * @param tempBillNum
	 * @throws SQLException 
	 */
	public static void reWriteImportBillStatusByNumber(Connection conn,String tableName,String easBillID,String billColName,ArrayList<String> tempBillNum) throws SQLException {
		String billNumbers="";
		for(String number:tempBillNum) {
			if(billNumbers.length()>0) {
				billNumbers+=",";
			}
			billNumbers=billNumbers+number;
		}
		if(StringUtils.isBlank(billNumbers)) {
			return;
		}
		StringBuffer sql=new StringBuffer();
		sql.append(" update ").append(tableName);
		sql.append(" set EASBILLID='").append(easBillID).append("'");
		//sql.append(" ,DownloadState=1");
		sql.append(" where ").append(billColName).append(" in (").append(billNumbers).append(")");
		Statement stm = conn.createStatement();
		stm.execute(sql.toString());
	}
	/**
	 * ��д����״̬
	 * @param conn
	 * @param easBillID
	 * @param tempBillNum
	 * @throws SQLException 
	 */
	public static void reWriteImportBillStatus2(Connection conn,String tableName,String easBillID,ArrayList<Integer> tempBillNum) throws SQLException {
		String billNumbers="";
		for(int number:tempBillNum) {
			if(billNumbers.length()>0) {
				billNumbers+=",";
			}
			billNumbers=billNumbers+number;
		}
		if(StringUtils.isBlank(billNumbers)) {
			return;
		}
		StringBuffer sql=new StringBuffer();
		sql.append(" update ").append(tableName);
		sql.append(" set EASBILLID2='").append(easBillID).append("'");
		//sql.append(" ,DownloadState=1");
		sql.append(" where OID in (").append(billNumbers).append(")");
		Statement stm = conn.createStatement();
		stm.execute(sql.toString());
	}
	/**
	 * ����Ƿ��Ѿ��������м��
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
		int result = 0;//ԭ��ΪAppString02 AppString03
		StringBuffer sql = new StringBuffer();
		sql.append(" select distinct OID");
		sql.append(" from ").append(tableName);
		sql.append(" where EASBILLID='").append(billID).append("'");
		if(StringUtils.isNotBlank(entryID))
			sql.append(" and EASENTRYID='").append(entryID).append("'");
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql.toString());
		if (rs.next()) {
			result = rs.getInt("OID");
		}
		rs.close();
		stm.close();
		return result;
	}
	/**
	 * �����м����EAS��Ӧ���ϵ�ID�粻����������
	 * @type ��������
	 * @throws SQLException 
	 */
	public static int returnTempMaterialID(Context ctx,Connection conn,MaterialInfo mInfo,String type) throws SQLException {
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery("select id from t_material where erpid='"+mInfo.getId().toString()+"'");
		if(rs.next()) {
			return rs.getInt("id");
		}else{
			String userName="";
			if(ctx==null) {
				userName=SysContext.getSysContext().getCurrentUserInfo().getName();
			}else{
				userName=ContextUtil.getCurrentUserInfo(ctx).getName();
			}
			//���벢����Id
			StringBuffer sql=new StringBuffer();
			sql.append(" insert into t_material (")
			.append(" erpID,number,name,model,createTime,creator,type")
			.append(" )")
			.append(" values (")
			.append(" '").append(mInfo.getString("id")).append("','").append(mInfo.getNumber()).append("','")
			.append(mInfo.getName()).append("','").append(mInfo.getModel()).append("',getdate(),'")
			.append(userName).append("'")
			.append(" ,'").append(type).append("'")
			.append(" );");
			stm.execute(sql.toString());
			stm.close();
			return getLastInsertID(conn);
			
		}
	}
	
	/**
	 * �����м����EAS��Ӧ���ϵ�ID�粻����������
	 * @throws SQLException 
	 */
	public static String returnTempBOMID(Connection conn,String bomID) throws SQLException {
		Statement stm = conn.createStatement();
		
		ResultSet rs = 
			stm.executeQuery("select recipeNum from t_bom where recipeNum='"+bomID+"'");
		if(rs.next()) {
			String resint = rs.getString("recipeNum");
			stm.close();
			return resint;
			
		}
		stm.close();
		return "";
	}
	/**
	 * ��ȡ���һ�β����id
	 * @param conn
	 * @return
	 * @throws SQLException 
	 */
	public static int getLastInsertID(Connection conn) throws SQLException {
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery("SELECT  @@IDENTITY as id;");
		if(rs.next()) {
			return rs.getInt("id");
			
		}
		stm.close();
		return 0;
	}
	
}
