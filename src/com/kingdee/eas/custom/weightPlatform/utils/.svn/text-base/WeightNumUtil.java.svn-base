package com.kingdee.eas.custom.weightPlatform.utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * 过磅码
 * @author dai_andong
 *
 */
public class WeightNumUtil {
	private static String[] code=new String[]{"A","B","C","D","E","F","G","H","J","K","L","M","N","P"
			,"0","1","2","3","4","5","6","7","8","9"};
	
	private static final int verifyLength=6;//校验位长度
	
	private static String getWeightNum() {
		Random random=new Random();
		String number="";
		for(int i=0;i<verifyLength;i++) {
			number+=code[random.nextInt(code.length)];
		}
		return number;
	}
	private static boolean isExist(Context ctx,String value,String tableName,String colName) throws BOSException {
		IRowSet rs=null;
		String str="select 1 from "+tableName+" where "+colName+"='"+value+"'";
		if(ctx==null) {
			rs = SQLExecutorFactory.getRemoteInstance(str).executeSQL();
		}else {
			rs =DbUtil.executeQuery(ctx,str);
		}
		if(rs.size()>0) {
			return true;
		}
		try {
			rs.close();
		} catch (SQLException e) {
			throw new BOSException(e);
		}
		return false;
	}
	
	private static ArrayList<String> getNumTemp(Context ctx,String tableName,String colName) throws BOSException {
		IRowSet rs=null;
		ArrayList<String> tempList=new ArrayList<String>();
		String str="select "+colName+" from "+tableName;
		if(ctx==null) {
			rs = SQLExecutorFactory.getRemoteInstance(str).executeSQL();
		}else {
			rs =DbUtil.executeQuery(ctx,str);
		}
		try {
			while(rs.next()) {
				tempList.add(rs.getString(colName));
			}
			rs.close();
		} catch (SQLException e) {
			throw new BOSException(e);
		}
		return tempList;
	}
	
	/**
	 * 获取随机数
	 * @param ctx
	 * @param tableName
	 * @param colName
	 * @return
	 * @throws BOSException 
	 */
	public static String getWeightNum(Context ctx,String tableName,String colName) throws BOSException {
		String number=null;
		int rowIndex=11;
		ArrayList<String> tempList=null;
		while(true) {
			number=getWeightNum();
			if(rowIndex<=10) {
				if(!isExist(ctx,number,tableName,colName)) {
					break;
				}
				rowIndex++;
			}else {
				if(tempList==null) {
					tempList=getNumTemp(ctx, tableName, colName);
				}
				if(!tempList.contains(number)) {
					break;
				}
			}
		}
		return number;
	}
}
