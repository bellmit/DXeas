package com.kingdee.eas.farm.feemanager.basebizbill.app;

import org.apache.log4j.Logger;
import javax.ejb.*;

import java.math.BigDecimal;
import java.rmi.RemoteException;
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

import java.util.HashMap;

public class CalfrightFacadeControllerBean extends AbstractCalfrightFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.feemanager.basebizbill.app.CalfrightFacadeControllerBean");
    
    /**
     * 车辆运输单——运费计算方法
     * @author yumx
     * 在TransportationrecordEditUI中调用
     * 参数：车辆ID,里程数,物料ID
     * 返回值：SQL语句和结果集 （HashMap<sql，result>）
     * 时间：2017.3.28
     */

    protected HashMap _calfright(Context ctx, String carid,String milage,String material,String company)throws BOSException
    {
    	
    	HashMap<Object, Object> result = new HashMap<Object, Object>();
    	StringBuffer sql = CalfrightStringBuffer(carid,milage,material,company);
    	System.out.println("sql语句为"+sql);
    	//执行SQL
    	IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
    	//打包map
    	result.put("result", rs);
    	result.put("sql", sql.toString());
    	System.out.println(rs.toString());
        return result;
    }
    /**
     * 车辆运输单——柴油价格判断方法
     * @author yumx
     * 在TransportationrecordEditUI中调用
     * 参数：财务组织
     * 返回值：boolean
     * 时间：2017.3.29
     */

	protected HashMap _oiljudg(Context ctx, String company,String bizdate)
			throws BOSException {
		// TODO Auto-generated method stub
		HashMap<Object, Object> result = new HashMap<Object, Object>();
		StringBuffer sql = OiljudgStringBuffer(company,bizdate);
		System.out.println(sql.toString());
		//执行SQL
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		result.put("result", rs);
    	result.put("sql", sql.toString());
    	return result;
	}
	
	 /**
     * 车辆运输单——柴油标准价格判断方法
     * @author yumx
     * 在TransportationrecordEditUI中调用
     * 参数：财务组织
     * 返回值：boolean
     * 时间：2017.3.29
     */

	protected HashMap _oilsjudg(Context ctx, String company)
			throws BOSException {
		// TODO Auto-generated method stub
		HashMap<Object, Object> result = new HashMap<Object, Object>();
		StringBuffer sql = OilSjudgStringBuffer(company);
		System.out.println(sql.toString());
		//执行SQL
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		result.put("result", rs);
    	result.put("sql", sql.toString());
    	return result;
	}
	
	
	/**
     * 运费计算方法——sql定义
     * @author yumx
     * _calfright调用
     * 查询结算政策的三个值，条件是：在有效期间，状态为审核，车辆规格和车辆运输单一致。
     * 参数：车辆ID，里程数，物料ID
     * 返回值：StringBuffer
     * 时间：2017.3.28
     */
    private StringBuffer CalfrightStringBuffer(String carid,String milage,String material,String company){
    	StringBuffer sql = new StringBuffer();
    	String sp = "\n";

    	sql.append("/*dialect*/").append(sp);
    	sql.append("select ").append(sp);
    	sql.append("t1.fname_l2                  name,").append(sp);
    	sql.append("t1.fduckamount               duck,").append(sp);
    	sql.append("t6.fstandardprice            oil,").append(sp);
    	sql.append("t1.foilfloat                 oilf,").append(sp);
    	sql.append("t1.ffrightfloat              ff,").append(sp);
    	sql.append("t3.fsubprice                 sub,").append(sp);
    	sql.append("t7.fkilamount                standkil").append(sp);
    	sql.append("from T_FM_Settlement t1 ").append(sp);
    	sql.append("inner join T_FM_SettlementDE t3 on t3.fparentid = t1.fid").append(sp);
    	sql.append("inner join T_FM_SettlementME t4 on t4.fparentid = t1.fid").append(sp);
    	sql.append("inner join T_FM_OilStandPrice t6 on t6.fid = t1.foilstandpriceid").append(sp);
    	sql.append("inner join T_FM_SettlementCE t7 on  t7.fparentid = t1.fid").append(sp);
    	sql.append("inner join CT_FM_CarriageFormat t5 on t5.fid = t7.fcarsizeid").append(sp);
    	sql.append("where ").append(sp);
    	sql.append("t3.fkilometertop >= '").append(milage).append("'").append(sp);
    	sql.append("and t3.fkilometerend < '").append(milage).append("'").append(sp);
    	sql.append("-------------结算政策的有效日期、状态财务组织判定------------- ").append(sp);
    	sql.append("and t1.Fstartdate < sysdate").append(sp);
    	sql.append("and t1.Fenddate > sysdate").append(sp);
    	sql.append("and t1.fstate = '4'").append(sp);
    	sql.append("and t1.fcompanyorgunitid = '").append(company).append("'").append(sp);
    	sql.append("-----------------车厢的有效日期和状态判定-------------------- ").append(sp);
    	//sql.append("and t5.fstartdate < sysdate").append(sp);
    	//sql.append("and t5.fenddate > sysdate").append(sp);
    	sql.append("and t5.fstate = '4'").append(sp);
    	
    	sql.append("-----------------柴油的有效日期和状态判定-------------------- ").append(sp);
    	sql.append("and t6.cfstartdate < sysdate").append(sp);
    	sql.append("and t6.cfenddate > sysdate").append(sp);
    	sql.append("and t6.fstate = '4'").append(sp);
    	sql.append("and t6.fcompanyorgunitid = '").append(company).append("'").append(sp);
    	
    	sql.append("and t5.cfcarriagesize = ").append(sp);
    	sql.append("(").append(sp);
    	sql.append("    select cfcarriagesize").append(sp);
    	sql.append("    from CT_PUB_Car t1").append(sp);
    	sql.append("    inner join CT_FM_CarriageFormat t2 on t1.fcarsizeid = t2.fid").append(sp);
    	sql.append("    where t1.fid = '").append(carid).append("'").append(sp);
    	sql.append(")").append(sp);
    	sql.append("and t4.fmaterialid  = '").append(material).append("' ").append(sp);
    	sql.append("and rownum<2 ").append(sp);

    	
		return sql;
    }
    /**
     * 柴油每日价格——sql定义
     * @author yumx
     * _oiljude调用
     * 查询结算政策的三个值，条件是：当前组织不存在当前业务日期的价格。
     * 参数：组织ID
     * 返回值：StringBuffer
     * 时间：2017.3.28
     */
    private StringBuffer OiljudgStringBuffer(String company,String date){
    	StringBuffer sql = new StringBuffer();
    	String sp = "\n";

    	sql.append("/*dialect*/").append(sp);
    	sql.append("select ").append(sp);
    	sql.append("t1.cfdailyprice ").append(sp);
    	sql.append("from CT_FM_OilPrice t1").append(sp);
    	sql.append("inner join T_ORG_Company t2 on t2.fid = t1.fcompanyorgunitid").append(sp);
    	sql.append("where ").append(sp);
    	sql.append("to_char(cfstartdate,'YYYY-MM-DD') = to_char(to_date('").append(date).append("','yyyy-mm-dd'),'YYYY-MM-DD') ").append(sp);
    	sql.append("and t2.fname_l2 = '").append(company).append("'").append(sp);
    	sql.append("and fstate = '4'").append(sp);
    	sql.append("and rownum<2 ").append(sp);
    	return sql;
    } 
    
    
    
    /**
     * 柴油标准价格——sql定义
     * @author yumx
     * _oiljude调用
     * 查询结算政策的三个值，条件是：当前组织不存在当前业务日期的价格。
     * 参数：组织ID
     * 返回值：StringBuffer
     * 时间：2017.3.28
     */
    private StringBuffer OilSjudgStringBuffer(String company){
    	StringBuffer sql = new StringBuffer();
    	String sp = "\n";

    	sql.append("/*dialect*/").append(sp);
    	sql.append("select ").append(sp);
    	sql.append("t1.FStandardprice ").append(sp);
    	sql.append("from T_FM_OilStandPrice t1").append(sp);
    	sql.append("inner join T_ORG_Company t2 on t2.fid = t1.fcompanyorgunitid").append(sp);
    	sql.append("where ").append(sp);
    	sql.append("t1.cfstartdate < sysdate ").append(sp);
    	sql.append("and t1.cfenddate > sysdate ").append(sp);
    	sql.append("and t2.fname_l2 = '").append(company).append("'").append(sp);
    	sql.append("and fstate = '4'").append(sp);
    	
    	return sql;
    } 
}