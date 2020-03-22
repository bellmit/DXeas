package com.kingdee.eas.custom.weightPlatform.app;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.weightPlatform.WeightBean;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class WeightPlatformFacadeControllerBean extends AbstractWeightPlatformFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.weightPlatform.app.WeightPlatformFacadeControllerBean");
    /**
     * 自助过磅
     */
    protected String _insertOrUpdateWeightInfo(Context ctx, Object param)throws BOSException, EASBizException
    {
    	WeightBean bean=null;
    	if(param instanceof WeightBean ) {
    		bean=(WeightBean) param;
    	}else if(param instanceof String){
    		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		JSONObject json=JSONObject.fromObject(param);
    		bean=new WeightBean();
    		bean.setBillID(json.getString("billID"));
    		try {
				bean.setFirstTime((json.containsKey("firstTime")&&StringUtils.isNotEmpty(json.getString("firstTime")))?sdf.parse(json.getString("firstTime")):null);
			} catch (ParseException e) {
				throw new BOSException(e);
			}
    		BigDecimal firstQty=(json.containsKey("firstQty")&&StringUtils.isNotEmpty(json.getString("firstQty")))?new BigDecimal(json.getString("firstQty")):BigDecimal.ZERO;
    		bean.setFirstQty(firstQty);
    		try {
				bean.setSecondTime((json.containsKey("secondTime")&&StringUtils.isNotEmpty(json.getString("secondTime")))?sdf.parse(json.getString("secondTime")):null);
			} catch (ParseException e) {
				throw new BOSException(e);
			}
    		BigDecimal secondQty=(json.containsKey("secondQty")&&StringUtils.isNotEmpty(json.getString("secondQty")))?new BigDecimal(json.getString("secondQty")):BigDecimal.ZERO;
    		bean.setSecondQty(secondQty);
    		bean.setSuttleQty((bean.getFirstTime()!=null&&bean.getSecondTime()!=null)?firstQty.subtract(secondQty).abs():BigDecimal.ZERO);
    	}
    	if(bean==null) {
    		throw new EASBizException(new NumericExceptionSubItem("001","过磅更新参数为空！"));
    	}
    	StringBuffer sql=new StringBuffer();
    	sql.append(" update CT_WEI_CarSendBill ")
    	.append(" set FTareFirstTime=?,FTareFirstQty=?,")
		.append(" FTareSecondTime=?,FTareSecondQty=?,")
		.append(" CFTareWgt=?")
		.append(" where fid=?")
    	;
    	DbUtil.execute(ctx, sql.toString(),new Object[]{bean.getFirstTime()!=null?new java.sql.Timestamp(bean.getFirstTime().getTime()):null,bean.getFirstQty(),
    			bean.getSecondTime()!=null?new java.sql.Timestamp(bean.getSecondTime().getTime()):null,
    		bean.getSecondQty(),bean.getSuttleQty(),bean.getBillID()});
    	return null;
    }
    
	@Override
	protected String _getWeightInfo(Context ctx, String jsonStr) throws BOSException {
		JSONObject json=JSONObject.fromObject(jsonStr);
		
		JSONArray ja=new JSONArray();
		
		String wgtNum=json.getString("wgtNum");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Calendar cal=Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_MONTH, -7);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		StringBuffer sql = new StringBuffer();
		sql.append(" /*dialect*/ select tbill.fid,tbill.fnumber,tcar.fnumber cfcarNum,to_char(tbill.FbizDate,'yyyy-MM-dd') FbizDate,tbill.CFEstRecycleWgt cfQty,")
		.append(" 0 CFstatus,tbill.FweightNum,to_char(tbill.FTareFirstTime,'yyyy-MM-dd HH24:mi:ss') FTareFirstTime,to_char(tbill.FTareSecondTime,'yyyy-MM-dd HH24:mi:ss') FTareSecondTime,")
		.append(" tbill.FTareFirstQty,tbill.FTareSecondQty,tbill.CFTareWgt cfsuttltQty")
		.append(" from CT_WEI_CarSendBill tbill")//派车单
		.append(" inner join CT_PUB_Car tcar on tcar.fid=CFCarID")
		.append(" where fWeightNum='").append(wgtNum).append("'")
		.append(" or (")
		.append(" tcar.fid in (")
		.append(" select CFCarID from CT_WEI_CarSendBill ")
		.append(" where fWeightNum='").append(wgtNum).append("'")
		.append(" )")
		.append(" and CFRecycleDate>=to_date( '").append(sdf.format(cal.getTime())).append("','yyyy-MM-dd HH24:mi:ss')")
		.append(" and CFRecycleDate<=to_date( '").append(sdf.format(new Date())).append("','yyyy-MM-dd HH24:mi:ss')")
		.append(" )")
		.append(" order by Fbizdate desc")
		.append(" ")
		;
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		JSONObject jo;
		try {
			while(rs.next()) {
				jo=new JSONObject();
				jo.put("billID",rs.getString("fid"));
				jo.put("billNum",rs.getString("Fnumber"));
				jo.put("bizDate",rs.getString("FBizDate"));
				jo.put("carNum",rs.getString("cfcarNum"));
				jo.put("qty",rs.getBigDecimal("cfQty"));
				jo.put("wgtNum",rs.getString("FweightNum"));
				jo.put("firstQty",rs.getBigDecimal("FTareFirstQty"));
				jo.put("firstTime",rs.getString("FTareFirstTime"));
				jo.put("secondQty",rs.getBigDecimal("FTareSecondQty"));
				jo.put("secondTime",rs.getString("FTareSecondTime"));
				jo.put("suttleQty",rs.getBigDecimal("cfsuttltQty"));
				//过磅码相等
				if(rs.getString("FweightNum").equals(wgtNum)) {
					jo.put("isMain",true);
				}
				ja.add(jo);
			}
		} catch (SQLException e) {
			throw new BOSException(e);
		}
		return ja.toString();
	}
}