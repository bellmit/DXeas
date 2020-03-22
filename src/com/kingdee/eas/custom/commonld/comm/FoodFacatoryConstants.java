package com.kingdee.eas.custom.commonld.comm;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.commld.ExceptionUtils;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.enums.EnumUtils;

public class FoodFacatoryConstants {


	/**
	 * 应收单获取品牌信息
	 * @param ctx
	 * @param fromObject
	 * @return
	 */
	public static String getPinPaiRpt(Context ctx, JSONObject fromObject) {
		// TODO Auto-generated method stub
		String companyID = fromObject.containsKey("company")?fromObject.getString("company"):"";
		String beginDate = fromObject.getString("beginDate");
		String endDate = fromObject.getString("endDate");
		String brandType = fromObject.getString("brandType");
		String groupType = fromObject.getString("groupType");

		StringBuffer selectStr = new StringBuffer();
		StringBuffer fromStr = new StringBuffer();
		StringBuffer groupStr = new StringBuffer();
		StringBuffer whereStr = new StringBuffer();
		StringBuffer orderStr = new StringBuffer();

		getPinPaiRptSelectStringBuffer(selectStr,groupType);
		getPinPaiRptFromStringBuffer(fromStr,groupType);
		getPinPaiRptGroupStringBuffer(groupStr,groupType);
		getPinPaiRptWhereStringBuffer(whereStr,companyID,beginDate,endDate,brandType,groupType);
		orderStr.append(" order by sum(t2.FAmount) desc");
		
		JSONObject result = new JSONObject();
		try {
			selectStr = selectStr.append(fromStr).append(whereStr).append(groupStr).append(orderStr);
			IRowSet rs = DbUtil.executeQuery(ctx, selectStr.toString());
			JSONArray json = commUtils.getRowSetData(rs);
			result.put("result",true);
			result.put("data",json);
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("result",false);
			result.put("reason",ExceptionUtils.getExceptionStatement(e));
			result.put("reasonLocation",ExceptionUtils.getExceptionLocationSimple(e));
		}
		return result.toString();
	}

	/**
	 * 获取select的内容
	 * @param selectStr
	 * @param groupType
	 * @return
	 */
	private static void getPinPaiRptSelectStringBuffer(
			StringBuffer selectStr, String groupType) {
		// TODO Auto-generated method stub
		selectStr.setLength(0);
		selectStr.append("select").append("\n");
		if(groupType.equalsIgnoreCase("customer")){
			selectStr.append("t6.FName_l2                        客户,").append("\n");
		}else if(groupType.equalsIgnoreCase("material")){
			selectStr.append("t4.FName_l2                        物料,").append("\n");
		}else if(groupType.equalsIgnoreCase("company")){
			selectStr.append("t5.FName_l2                        公司,").append("\n");
		}
		selectStr.append("sum(t2.FQuantity)   数量,").append("\n");
		selectStr.append("sum(t2.FAmount)     金额").append("\n");
	}
	private static void getPinPaiRptFromStringBuffer(
			StringBuffer fromStr, String groupType) {
		// TODO Auto-generated method stub
		fromStr.setLength(0);
		fromStr.append("\nfrom").append("\n"); 
		fromStr.append("T_AR_OtherBill                    t1").append("\n");
		fromStr.append("inner join T_AR_OtherBillentry    t2 on t1.FID=t2.FParentID").append("\n");
		fromStr.append("left  join T_BD_SaleGroup         t3 on t3.FID=t1.FSaleGroupID").append("\n");
		fromStr.append("inner join T_BD_Material          t4 on t4.FID=t2.FMaterialID").append("\n");
		fromStr.append("inner join T_ORG_Company          t5 on t5.FID=t1.FCompanyID").append("\n");
		fromStr.append("inner join T_BD_Customer          t6 on t6.FID=t1.CFSHIPINCUSTOMERID").append("\n");
	}
	private static void getPinPaiRptGroupStringBuffer(StringBuffer groupStr,
			String groupType) {
		// TODO Auto-generated method stub
		groupStr.setLength(0);
		groupStr.append("\nGroup by ");
		if(groupType.equalsIgnoreCase("customer")){
			groupStr.append("t6.FName_l2");
		}else if(groupType.equalsIgnoreCase("material")){
			groupStr.append("t4.FName_l2").append("\n");
		}else if(groupType.equalsIgnoreCase("company")){
			groupStr.append("t5.FName_l2").append("\n");
		}
	}

	private static void getPinPaiRptWhereStringBuffer(StringBuffer whereStr,
			String companyID, String beginDate, String endDate, String brandType, String groupType) {
		// TODO Auto-generated method stub
		whereStr.setLength(0);
		whereStr.append("\nwhere 1=1");
		if(StringUtils.isNotEmpty(companyID)){//公司
			whereStr.append(" and ").append("t5.FID='").append(companyID).append("'").append("\n");
		}
		if(StringUtils.isNotEmpty(beginDate)){
			whereStr.append(" and ").append("t1.FBizDate>={ts '").append(beginDate).append("'}").append("\n");
		}
		if(StringUtils.isNotEmpty(endDate)){
			whereStr.append(" and ").append("t1.FBizDate<={ts '").append(endDate).append("'}").append("\n");
		}
		if(StringUtils.isNotEmpty(brandType)){
			if(brandType.equalsIgnoreCase("Other")){
				whereStr.append(" and (t3.FID is null or t3.CFBrandType is null)").append("\n");
			}else if( commUtils.arrayListContainsElement(brandType, new String[]{"XiongYing","QiangYing","JingYing","BigBang"})){
				whereStr.append(" and t3.CFBrandType=").append(brandType.equalsIgnoreCase("XiongYing")?1:(
						brandType.equalsIgnoreCase("QiangYing")?2:
							(brandType.equalsIgnoreCase("JingYing")?3:
								(4)))).append("\n");
			}
		}
		
	}
}
