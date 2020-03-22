package com.kingdee.eas.custom.salediscount.rpt.app;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import javax.ejb.*;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

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

import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.TableManagerFacadeFactory;
import com.kingdee.eas.framework.report.app.CommRptBaseControllerBean;
import com.kingdee.eas.framework.report.util.RptCellFormatter;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.framework.report.util.RptRowSet;
import com.kingdee.eas.framework.report.util.RptTableColumn;
import com.kingdee.eas.framework.report.util.RptTableHeader;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class SaleQtyCompareRptFacadeControllerBean extends AbstractSaleDiscountAnalyzeRptFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.salediscount.rpt.app.SaleDiscountAnalyzeRptFacadeControllerBean");
    
    
    @Override
	protected RptParams _createTempTable(Context ctx, RptParams params) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
    	String cuId="";
		
		// 公司ID
		String companyID = params.getString("companyID");
		// 客户组ID	
		String saleGroupId = params.getString("saleGroupId"); 
		// 期间ID
		String periodID = params.getString("periodID"); 
		
		// 开始日期
		String beginDateStr = params.getString("beginDateStr"); 
		// 结束日期
		String endDateStr = params.getString("endDateStr"); 
		// 上月开始日期
		String lastBeginDateStr = params.getString("lastBeginDateStr"); 
		// 上月结束日期
		String lastEndDateStr = params.getString("lastEndDateStr"); 
		
		
		
    	//删除旧临时表(结构可能与新查询不同,本例子临时表结构不变)
    	dropTable(params.getString("tempTable"),ctx);
//    	dropTable(params.getString("resultTable"),ctx);
    	String tempTable=this.getTempTableName("销量统计表（五日报表）数据表",ctx);
//    	String resultTable=this.getTempTableName("销量统计表（五日报表）结果表",ctx);
    	params.setString("tempTable", tempTable);
//    	params.setString("resultTable", resultTable);
    	StringBuilder sb = new StringBuilder();
    	
    	// 查询订单数据
    	sb.append("/*dialect*/ create table  ");
		sb.append(tempTable);
    	sb.append(" as  select t.fcompanyorgunitid companyID, ");
		sb.append("        te.fmaterialid materialID, ");
		sb.append("        t.fsalegroupid saleGroupID, ");
		sb.append("        sum(nvl(te.fbaseqty, 0)) currMonthSaleQty, ");
		sb.append("        0 lastMonthSaleQty ");
		sb.append("  ");
		sb.append("   from t_sd_saleorder t ");
		sb.append("  inner join t_sd_saleorderentry te ");
		sb.append("     on t.fid = te.fparentid ");
		sb.append(" where (t.fbasestatus=4 or t.fbasestatus = 7) and  t.fcompanyorgunitid ='");
    	sb.append(companyID);
    	sb.append("' and t.FBizDate >=to_date('");
    	sb.append(beginDateStr);
    	sb.append("','yyyy-MM-dd') and t.fbizDate <to_date('");
    	sb.append(endDateStr);
    	sb.append("','yyyy-MM-dd')+1 ");
    	if(StringUtils.isNotBlank(saleGroupId)){
    		sb.append(" and t.fsalegroupid='");
    		sb.append(saleGroupId);
    		sb.append("' ");
    	}
		sb.append("  group by t.fcompanyorgunitid, te.fmaterialid, t.fsalegroupid ");
		sb.append("  ");
		sb.append(" union all ");
		sb.append(" select t.fcompanyorgunitid companyID, ");
		sb.append("        te.fmaterialid materialID, ");
		sb.append("        t.fsalegroupid saleGroupID, ");
		sb.append("        0 currMonthSaleQty, ");
		sb.append("        sum(nvl(te.fbaseqty, 0)) lastMonthSaleQty ");
		sb.append("  ");
		sb.append("   from t_sd_saleorder t ");
		sb.append("  inner join t_sd_saleorderentry te ");
		sb.append("     on t.fid = te.fparentid ");
		sb.append("  ");
		
    	sb.append(" where (t.fbasestatus=4 or t.fbasestatus = 7) and  t.fcompanyorgunitid ='");
    	sb.append(companyID);
    	sb.append("' and t.FBizDate >=to_date('");
    	sb.append(lastBeginDateStr);
    	sb.append("','yyyy-MM-dd') and t.fbizDate <to_date('");
    	sb.append(lastEndDateStr);
    	sb.append("','yyyy-MM-dd')+1 ");
    	if(StringUtils.isNotBlank(saleGroupId)){
    		sb.append(" and t.fsalegroupid='");
    		sb.append(saleGroupId);
    		sb.append("' ");
    	}
    	
    	sb.append("  group by t.fcompanyorgunitid, te.fmaterialid, t.fsalegroupid ");
    	// 订单数据 创建临时表中
    	DbUtil.execute(ctx, sb.toString());
    	
    	// 退货数据导入
    	// 查询退货申请单数据
    	sb = new StringBuilder();
    	sb.append("/*dialect*/ insert into   ");
		sb.append(tempTable);
    	sb.append("  ( select t.fcompanyorgunitid companyID, ");
		sb.append("        te.fmaterialid materialID, ");
		sb.append("        t.fsalegroupid saleGroupID, ");
		sb.append("        -sum(nvl(te.fbaseqty, 0)) currMonthSaleQty, ");
		sb.append("        0 lastMonthSaleQty ");
		sb.append("  ");
		sb.append("   from t_sd_salereturns t ");
		sb.append("  inner join t_sd_salereturnsentry te ");
		sb.append("     on t.fid = te.fparentid ");
		sb.append(" where (t.fbasestatus=4 or t.fbasestatus = 7) and  t.fcompanyorgunitid ='");
    	sb.append(companyID);
    	sb.append("' and t.FBizDate >=to_date('");
    	sb.append(beginDateStr);
    	sb.append("','yyyy-MM-dd') and t.fbizDate <to_date('");
    	sb.append(endDateStr);
    	sb.append("','yyyy-MM-dd')+1 ");
    	if(StringUtils.isNotBlank(saleGroupId)){
    		sb.append(" and t.fsalegroupid='");
    		sb.append(saleGroupId);
    		sb.append("' ");
    	}
		sb.append("  group by t.fcompanyorgunitid, te.fmaterialid, t.fsalegroupid ");
		sb.append("  ");
		sb.append(" union all ");
		sb.append(" select t.fcompanyorgunitid companyID, ");
		sb.append("        te.fmaterialid materialID, ");
		sb.append("        t.fsalegroupid saleGroupID, ");
		sb.append("        0 currMonthSaleQty, ");
		sb.append("        -sum(nvl(te.fbaseqty, 0)) lastMonthSaleQty ");
		sb.append("  ");
		sb.append("   from t_sd_salereturns t ");
		sb.append("  inner join t_sd_salereturnsentry te ");
		sb.append("     on t.fid = te.fparentid ");
		sb.append("  ");
		
    	sb.append(" where (t.fbasestatus=4 or t.fbasestatus = 7) and  t.fcompanyorgunitid ='");
    	sb.append(companyID);
    	sb.append("' and t.FBizDate >=to_date('");
    	sb.append(lastBeginDateStr);
    	sb.append("','yyyy-MM-dd') and t.fbizDate <to_date('");
    	sb.append(lastEndDateStr);
    	sb.append("','yyyy-MM-dd')+1 ");
    	if(StringUtils.isNotBlank(saleGroupId)){
    		sb.append(" and t.fsalegroupid='");
    		sb.append(saleGroupId);
    		sb.append("' ");
    	}
    	sb.append("  group by t.fcompanyorgunitid, te.fmaterialid, t.fsalegroupid ");
    	sb.append(" ) ");
    	
    	// 销售退货申请单创建临时表中
    	DbUtil.execute(ctx, sb.toString());
    	
    	
    	
    	
    
    	return params;
	}
	
	protected RptParams _init(Context ctx, RptParams params) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		RptParams pp=new RptParams();
    	pp.setString("title","报表");    	
        return pp;
	}


	@Override
	protected RptParams _query(Context ctx, RptParams params) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		String tempTable = params.getString("tempTable");
		
		sb.append("select t.companyID,");
		sb.append(" t.materialID,");
		sb.append(" t.saleGroupID,");
		sb.append(" max(tm.fnumber) materialNumber,");
		sb.append(" max(tm.fname_l2) materialName,");
		sb.append(" max(tg.fnumber) saleGroupNumber,");
		sb.append(" max(tg.fname_l2) saleGroupName,");
		sb.append(" sum(t.currMonthSaleQty) currMonthSaleQty,");
		sb.append(" sum(t.lastMonthSaleQty) lastMonthSaleQty ");
		sb.append(" from ");
		sb.append(tempTable);
		sb.append(" t inner join t_bd_material tm on t.materialid = tm.fid ");
		sb.append(" inner join t_bd_salegroup tg on t.salegroupid = tg.fid ");
		sb.append(" group by  t.companyID,t.materialID,t.saleGroupID ");
		sb.append(" order by materialNumber,saleGroupNumber");
		RptRowSet rs=this.executeQuery(sb.toString(),null,ctx);
		
		RptParams pp=new RptParams();
    	pp.setObject("rs",rs);
    	return pp;
	}
	
}