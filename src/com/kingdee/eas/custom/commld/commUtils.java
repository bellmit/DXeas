package com.kingdee.eas.custom.commld;

import java.sql.Date;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.hr.emp.PersonPositionFactory;
import com.kingdee.eas.hr.emp.PersonPositionInfo;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

public class commUtils {
	public static final String TipType_Error="showError";
	public static final String TipType_Warning="showWarning";
	public static final String TipType_Info="showInfo";
	/**
	 * 给予用户提示并退出
	 * @param tips  提示消息
	 */
	public static void giveUserTipsAndRetire(String tips){
		MsgBox.showInfo(tips);
		SysUtil.abort();
	} 
	/**
	 * 提示消息并退出
	 * @param tips
	 * @param tipType
	 */
	public static void giveUserTipsAndRetire(String tips,String tipType){
		if(tipType.equals(TipType_Error))
			MsgBox.showError(tips);
		else if(tipType.equals(TipType_Warning))
			MsgBox.showWarning(tips);
		else
			MsgBox.showInfo(tips);
		SysUtil.abort();
	} 
	/**
	 * 获得当前员工的行政组织
	 * @param person
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public static AdminOrgUnitInfo getAdminOrgUnit(Object information) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		if(information==null||information.toString().equals(""))
			return null;

		//获得员工
		PersonInfo person=null;

		if(information instanceof PersonInfo)
			person=(PersonInfo)information;
		if(information instanceof String){
			CoreBaseCollection colls = PersonFactory.getRemoteInstance().getCollection(" where id='"+(String)information+"' or number='"+(String)information+"'");
			if(colls.size()==0)
				return null;
			else
				person=(PersonInfo)colls.get(0);
		}

		//根据员工职业信息  寻找所在部门
		AdminOrgUnitInfo adminOrgUnitInfo=null;
		if(person==null)
			return null;
		CoreBaseCollection coll = PersonPositionFactory.getRemoteInstance().getCollection(" where person='"+person.getId().toString()+"'");
		if(coll.size()<=0)
			return null;
		PersonPositionInfo personPosition = (PersonPositionInfo)coll.get(0);
		String id = personPosition.getPersonDep().getId().toString();
		if(!id.equals("")&&id!=null)
			adminOrgUnitInfo=AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(id));
		return adminOrgUnitInfo;
	}

	/**
	 * 数组去重
	 * @param array
	 * @return
	 */
	public static String[] arrayListClearSamevalue(String [] array){
		List<String> list = new ArrayList<String>();  
		list.add(array[0]);  
		for(int i=1;i<array.length;i++){  
			if(list.toString().indexOf(array[i]) == -1){  
				list.add(array[i]);  
			}  
		}  
		String[] arrayResult = (String[]) list.toArray(new String[list.size()]); 
		return arrayResult;
	}
	
	/**
	 *循环遍历数组查询是否包含某个元素
	 * @param array
	 * @return
	 */
	public static boolean arrayListContainsElement(Object obj,Object [] array){
		for(int i=0;i<array.length;i++){
			if(obj.equals(array[i])){
				return true;
			}
		}
		return false;
	}
	public static JSONArray getRowSetData(IRowSet rs) {
		// TODO Auto-generated method stub
		JSONArray data = new JSONArray();
		JSONObject em = null;
		ResultSetMetaData metaData;
		try {
			metaData = rs.getMetaData();
			while(rs.next()){
				em = new JSONObject();
				for(int i=0 ;i < metaData.getColumnCount();i++){
					em.put(metaData.getColumnName(i+1), (rs.getObject(i+1) instanceof Date || rs.getObject(i+1) instanceof Timestamp)?UIRuleUtil.getString(rs.getDate(i+1)):rs.getObject(i+1));
				}
				data.add(em);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println();
		}
		return data;
	}
	
	
	/**
	 * 
	 * @param sb
	 */
	public static void SystemOutPrintln(StringBuffer sb){
		int i=0;
		do{
			if(sb.length()>(i*5000) && sb.length()>((i+1)*5000)){
				System.out.println(sb.substring(i*5000,(i+1)*5000));
				++i;
			}else if(sb.length()>(i*5000)){
				System.out.println(sb.substring(i*5000,sb.length()));
				break;
			}else{
				break;
			}
		}while(1==1);
	}
}
