package com.kingdee.eas.custom.salediscount.rpt.app;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
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

import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.report.app.CommRptBaseControllerBean;
import com.kingdee.eas.framework.report.util.RptCellFormatter;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.framework.report.util.RptRowSet;
import com.kingdee.eas.framework.report.util.RptTableColumn;
import com.kingdee.eas.framework.report.util.RptTableHeader;
import com.kingdee.eas.util.app.DbUtil;

public class CustomerProfitRptFacadeControllerBean extends AbstractCustomerProfitRptFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.salediscount.rpt.app.CustomerProfitRptFacadeControllerBean");
    
   
    /**
     * 
     * @return
     * @since 20160313 kevin_wang 修改  增加 促销费用字段
     */
	public RptTableHeader Header(){
    	//构造表头
    	RptTableHeader header=new RptTableHeader();
    	RptTableColumn col=null;
    	
    	String format=RptCellFormatter.getNumberFormat(2,true); 
    	String qtyTformat=RptCellFormatter.getNumberFormat(3,true); 
    	//1
    	col=new RptTableColumn("saleGroupNumber");
    	col.setWidth(80);
    	col.setAligment(RptTableColumn.HALIGN_LEFT);
    	header.addColumn(col);
    	//2
    	col=new RptTableColumn("saleGroupName");    	
    	col.setWidth(80);
    	col.setAligment(RptTableColumn.HALIGN_LEFT);
    	header.addColumn(col);
    	//3
    	col=new RptTableColumn("salePersonNumber");
    	col.setWidth(80);    	
    	col.setAligment(RptTableColumn.HALIGN_LEFT);
    	header.addColumn(col);   
    	//4
    	col=new RptTableColumn("salePersonName");
    	col.setWidth(150);   	
    	col.setAligment(RptTableColumn.HALIGN_LEFT);
    	//col.setFormatPattern(format);
    	header.addColumn(col);
    	
    	//3
    	col=new RptTableColumn("customerNumber");
    	col.setWidth(120);    	
    	col.setAligment(RptTableColumn.HALIGN_LEFT);
    	header.addColumn(col);   
    	//4
    	col=new RptTableColumn("customerName");
    	col.setWidth(300);   	
    	col.setAligment(RptTableColumn.HALIGN_LEFT);
    	//col.setFormatPattern(format);
    	header.addColumn(col);
    	
    	//4
    	col=new RptTableColumn("channelType");
    	col.setWidth(80);   	
    	col.setAligment(RptTableColumn.HALIGN_CENTER);
    	//col.setFormatPattern(format);
    	header.addColumn(col);
    	//5
    	col=new RptTableColumn("materialNumber");
    	col.setWidth(130);    	
    	col.setAligment(RptTableColumn.HALIGN_LEFT);
    	//col.setFormatPattern(format);
    	header.addColumn(col);
    	//6
    	col=new RptTableColumn("materialName");
    	col.setWidth(180);    	
    	col.setAligment(RptTableColumn.HALIGN_LEFT);
//    	col.setFormatPattern(format);
    	header.addColumn(col);
    	
    	col=new RptTableColumn("saleQty");
    	col.setWidth(85); 
    	col.setFormatPattern(qtyTformat);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	header.addColumn(col);
//    	//7
    	col=new RptTableColumn("salePrice");
    	col.setWidth(85);  
    	col.setFormatPattern(format);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	header.addColumn(col);
//    	//7+1
//    	col=new RptTableColumn("price");
//    	col.setWidth(85);  
//    	col.setFormatPattern(format);
//    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
//    	header.addColumn(col);
    	//7+2 厂价
    	col=new RptTableColumn("baseAmount");
    	col.setWidth(85); 
    	col.setFormatPattern(format);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	header.addColumn(col);
    	
    	// 月度折扣
    	col=new RptTableColumn("monthAmount");
    	col.setWidth(85); 
    	col.setFormatPattern(format);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	header.addColumn(col);
    	//7+2 立折
    	col=new RptTableColumn("lzAmount");
    	col.setWidth(100); 
    	col.setFormatPattern(format);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	header.addColumn(col);
    	//年折  --eudy 20160130
    	col=new RptTableColumn("YearDSAmount");
    	col.setWidth(100); 
    	col.setFormatPattern(format);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	header.addColumn(col);
    	// 促销费用
    	col=new RptTableColumn("cxFee");
    	col.setWidth(100); 
    	col.setFormatPattern(format);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	header.addColumn(col);
    	
    	
    	

    	header.setLabels(new Object[][]{
			{"销售组编码","销售组名称","销售员编码","销售员姓名","客户编码","客户名称","渠道类型","产品编码","产品名称",
				"销量(吨)","吨均价","厂价金额","月折","基本折扣(立折)","年折","促销费用"}}); //+年折  --eudy 20160130
    	return header;
    }
	
	protected RptParams _init(Context ctx, RptParams params) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		RptParams pp=new RptParams();
    	pp.setString("title","报表");    	
        return pp;
	}


	/**
	 * 
	 * @since 20160313 kevin_wang 修改  增加 促销费用
	 */
	@Override
	protected RptParams _query(Context ctx, RptParams params) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("/*dialect*/ ");
		
		String cuId="";
		Object[] cu=(Object[]) params.getObject("CU");
		// 销售组
		String saleGroupID = params.getString("saleGroupID");
		// 销售员
		String salePersonID = params.getString("salePersonID");
		
		// 公司ID
		String companyID = params.getString("companyID");
		// 客户ID	
		String customerID = params.getString("customerID"); 
		// 渠道类型ID
		String channelTypeID = params.getString("channelTypeID"); 
		// 开始日期
		String beginDate = params.getString("beginDate"); 
		// 结束日期
		String endDate = params.getString("endDate"); 

		sb.append(" select 	 ");
		sb.append(" 	 ");
//		sb.append(" max(tsg.fid) groupID,	 ");
		sb.append(" decode(tsg.fnumber,null,'合计', tsg.fnumber) groupNumber,	 ");
		
		sb.append(" decode(tsg.fnumber,null,'', max(tsg.fname_l2)) groupName,	 ");
//		sb.append(" max(tsp.fid) personID,	 ");
		sb.append(" decode(tsp.fnumber,null,'小计', tsp.fnumber) personNumber,	 ");
		sb.append(" decode(tsp.fnumber,null,'', max(tsp.fname_l2)) personName,	 ");
//		sb.append(" max(tc.fid) customerID,	 ");
		sb.append(" decode(tc.fnumber,null,'小计', tc.fnumber) customerNumber,	 ");
		sb.append(" decode(tc.fnumber,null,'', max(tc.fname_l2)) customerName,	 ");
		
		sb.append(" decode(tc.fnumber,null,'', max(tbc.fname_l2)) channelType,	 ");
		sb.append(" decode(tm.fnumber,null,'小计', tm.fnumber) materialNumber,	 ");
		sb.append(" decode(tm.fnumber,null,'', max(tm.fname_l2)) materialName,	 ");
		sb.append(" sum(te.fbaseqty)/1000 saleQty,	 ");
		sb.append(" decode(sum(te.fbaseqty),0,0,sum(te.cfbaseamount)/sum(te.fbaseqty))/1000 salePrice,	 ");
		sb.append(" sum(te.cfbaseamount) baseAmount,	 ");
		sb.append(" sum(te.cfmonthdsamount) monthDis,	 ");
		sb.append(" sum(te.cflzamount) lzDis,	 ");
		sb.append(" sum(te.CFYearDSAmount) yearDis,	 ");//年折合计  --eudy 20160130
		sb.append(" sum(te.fbaseqty*te.CFpromotionFee)/1000 cxFee	 ");//促销费用  --eudy 20160130
		
		sb.append("  from t_sd_saleorder t 	 ");
		sb.append(" inner join t_sd_saleorderentry te on t.fid = te.fparentid 	 ");
		sb.append(" inner join t_bd_salegroup tsg on t.fsalegroupid = tsg.fid	 ");
		sb.append(" inner join t_bd_person tsp on t.fsalepersonid = tsp.fid	 ");
		sb.append(" inner join t_bd_customer tc on t.fordercustomerid = tc.fid 	 ");
		sb.append(" left join T_BD_CustomerSaleInfo tcs on t.fsaleorgunitid = tcs.FSaleOrgID and tc.fid = tcs.FCustomerID	 ");
		sb.append(" left join T_BD_ChannelType tbc on tcs.FChannelTypeID = tbc.fid ");
		sb.append(" inner join t_bd_material tm on te.fmaterialid = tm.fid 	 ");
		sb.append(" 	 ");
		
		sb.append(" where  t.fbasestatus in('4','7')  ");
    	
    	sb.append(" and t.FBizDate >=to_date('");
    	sb.append(beginDate);
    	sb.append("','yyyy-MM-dd') and t.fbizDate <=to_date('");
    	sb.append(endDate);
    	sb.append("','yyyy-MM-dd') ");
    	if(StringUtils.isNotBlank(companyID)){
    		sb.append(" and t.fsaleorgunitid='");
    		sb.append(companyID);
    		sb.append("' ");
    	}
    	if(StringUtils.isNotBlank(saleGroupID)){
    		sb.append(" and t.Fsalegroupid='");
    		sb.append(saleGroupID);
    		sb.append("' ");
    	}
    	if(StringUtils.isNotBlank(channelTypeID)){
    		sb.append(" and tcs.FChannelTypeID ='");
    		sb.append(channelTypeID);
    		sb.append("' ");
    	}
    	if(StringUtils.isNotBlank(salePersonID)){
    		sb.append(" and t.FsalepersonID='");
    		sb.append(salePersonID);
    		sb.append("' ");
    	}
    	if(StringUtils.isNotBlank(customerID)){
    		sb.append(" and t.FOrderCustomerID='");
    		sb.append(customerID);
    		sb.append("' ");
    	}
		sb.append(" group by rollup (tsg.fnumber,tsp.fnumber,tc.fnumber,tm.fnumber)	 ");
		sb.append(" order by tsg.fnumber,tsp.fnumber,tc.fnumber,tm.fnumber	 ");
		sb.append(" 	 ");
		sb.append(" 	 ");

		
		RptRowSet rs=this.executeQuery(sb.toString(),null,ctx);
    	RptParams pp=new RptParams();
    	pp.setObject("header", this.Header());
    	pp.setObject("rowset",rs);
    	return pp;
	}
}