package com.kingdee.eas.farm.stocking.webservice;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

import java.lang.String;

public class HatchRptFacadeControllerBean extends AbstractHatchRptFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.stocking.webservice.HatchRptFacadeControllerBean");
    protected String _getBEggCandlingBill(Context ctx, String param)throws BOSException
    {
    	JSONArray data = new JSONArray();
    	StringBuffer sb = getBEggCandlingBillSql(param);
    	IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
    	try {
    		JSONObject em = null;
			ResultSetMetaData metaData = rs.getMetaData();
				while(rs.next()){
					em = new JSONObject();
					for(int i=0 ;i < metaData.getColumnCount();i++){
						em.put(metaData.getColumnName(i+1), rs.getObject(i+1));
					}
					data.add(em);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return data.toString();
    }
    
    /**
     * 获取照蛋记录单的sql语句
     * @return
     */
	protected StringBuffer getBEggCandlingBillSql(String param) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		
		JSONObject fromObject = JSONObject.fromObject(param);
		String bizDateFrom = fromObject.getString("bizDateFrom");
		String bizDateTo = fromObject.getString("bizDateTo");
		String identity = fromObject.getString("identity");
		
		sb.append("/*dialect*/").append("\n");
		sb.append("SELECT").append("\n");
		sb.append(" to_char(t1.FBizDate,'yyyy-MM-dd')         日期,").append("\n");
		sb.append(" to_char(t1.FHatchDate,'yyyy-MM-dd')       上孵日期,").append("\n");
		sb.append(" t8.fname_l2			       批次,").append("\n");
		sb.append(" t3.FName_l2                               孵化区,").append("\n");
		sb.append(" t7.FName_l2                               片区,").append("\n");
		sb.append(" t6.FNumber                                合格蛋类型编码,").append("\n");
		sb.append(" t6.FName_l2                               合格单类型名称,").append("\n");
		sb.append(" t10.FName_l2                              养殖户,").append("\n");
		sb.append(" t11.CFName                                棚舍,").append("\n");
		sb.append(" t9.FName_l2                               供应商,").append("\n");
		sb.append(" t2.FWeekAge                               周龄,").append("\n");
		sb.append(" t2.FDayAge                                日龄,").append("\n");
		sb.append(" case when t2.FGenderType=0 then '父系'").append("\n");
		sb.append("      when t2.FGenderType=1 then '母系'").append("\n");
		sb.append("      else null    end                     品系,").append("\n");
		sb.append(" sum(nvl(t2.CFEggQty,0))                   上孵数量,").append("\n");
		sb.append(" sum(nvl(t2.CFHealthEggQty,0))             照蛋活胚,").append("\n");
		sb.append(" sum(nvl(t2.CFBrokenEggQty,0))             破蛋,").append("\n");
		sb.append(" sum(nvl(t2.CFNoFertileEggQty,0))          无精蛋,").append("\n");
		sb.append(" sum(nvl(t2.CFBrokenYolkQty,0))            散黄,").append("\n");
		sb.append(" sum(nvl(t2.CFAddleEggQty,0))              死胚,").append("\n");
		sb.append(" sum(nvl(t2.CFRottenEggQty,0))             臭蛋").append("\n");
		sb.append("FROM").append("\n");
		sb.append("CT_FM_BEggCandlingBill                      t1").append("\n");
		sb.append("inner join CT_FM_BECBEE                     t2  on t1.FID=t2.FParentID").append("\n");
		sb.append("      and t1.FBizDate>={ts '").append(bizDateFrom).append("'}").append("\n");
		sb.append("      and t1.FBizDate<({ts '").append(bizDateTo).append("'}+1)").append("\n");
		sb.append("inner join CT_FM_HatchBaseData              t3  on t3.FID=t1.CFHatchFactoryID").append("\n");
		sb.append("inner join T_FM_QcEggTypeEntry              t5  on t5.FQcEggsType=t2.FQcEggType").append("\n");
		sb.append("inner join T_FM_QcEggType                   t6  on t6.FID=t5.FParentID").append("\n");
		sb.append("left  join T_FM_FarmersTREE                 t7  on t7.FID=t2.FOutAreaID").append("\n");
		sb.append("left  join T_FM_StockingBatch               t8  on t8.FID=t2.CFOutBatchID").append("\n");
		sb.append("left  join T_BD_Supplier                    t9  on t9.FID=t2.CFSupplierID").append("\n");
		sb.append("left  join T_FM_Farmers                     t10 on t10.FID=t2.CFFarmerID").append("\n");
		sb.append("left  join CT_FM_FarmHouseEntry             t11 on t11.FID=t2.FOutHouseID").append("\n");
		sb.append("       and (t1.CFBaseStatus='4')").append("\n");
		sb.append("where t10.FIdentity='").append(identity.trim()).append("'\n");
		sb.append("Group by t3.FName_l2,t6.FName_l2,t6.FNumber,t7.FName_l2").append("\n");
		sb.append(",t10.FName_l2,t9.FName_l2,t11.CFName,t8.fname_l2,case when t2.FGenderType=0 then '父系'").append("\n");
		sb.append("      when t2.FGenderType=1 then '母系'").append("\n");
		sb.append("      else null    end,t2.FWeekAge,t2.FDayAge,to_char(t1.FBizDate,'yyyy-MM-dd'),to_char(t1.FHatchDate,'yyyy-MM-dd')").append("\n");
		sb.append("Order by t3.FName_l2,to_char(t1.FBizDate,'yyyy-MM-dd'),t6.FNumber,t6.FName_l2").append("\n");

		return sb;
	}
}