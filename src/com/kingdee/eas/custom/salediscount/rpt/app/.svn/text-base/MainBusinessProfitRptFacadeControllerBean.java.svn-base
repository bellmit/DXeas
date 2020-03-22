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

public class MainBusinessProfitRptFacadeControllerBean extends AbstractMainBusinessProfitRptFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.salediscount.rpt.app.MainBusinessProfitRptFacadeControllerBean");
    
    
    
    @Override
	protected RptParams _createTempTable(Context ctx, RptParams params) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
    	String cuId="";
		Object[] cu=(Object[]) params.getObject("CU");
		// 公司ID
		String CompanyID = params.getString("companyID");
		// 客户ID	
		String customerID = params.getString("customerID"); 
		// 开始日期
		String beginDate = params.getString("beginDate"); 
		// 结束日期
		String endDate = params.getString("endDate"); 
		
		
		
    	//删除旧临时表(结构可能与新查询不同,本例子临时表结构不变)
    	dropTable(params.getString("tempTable"),ctx);
    	String tempTable=this.getTempTableName("产品销量销售额折扣统计表",ctx);
    	params.setString("tempTable", tempTable);
    	StringBuilder sb = new StringBuilder();
    	
    	// 查询订单数据
    	sb.append("/*dialect*/create table ");
    	sb.append(tempTable);
    	sb.append(" as select tm.fid materialID,max(tm.fnumber) materialNumber,max(tm.fname_l2) materialName, sum(t.fbaseqty) baseqty, sum(t.cf)");
//    	sb.append("tc.fid customerID,tc.fnumber customerNumber, tc.fname_l2 customerName, ");
//    	sb.append("tm.fid materialID,tm.fnumber materialNumber,tm.fname_l2 materialName, ");
    	sb.append("0.00 , 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00,0.00 ,0.00,0.00 ");
    	sb.append("0 price , ");

    	sb.append("te.cfBaseAmount,te.cfLzAmount,te.cfSwDsAmount,te.cfmonthdsAmount, ");
    	sb.append("te.cffxdsAmount,te.cfyeardsAmount,0 alldiscount,0 netamount,0 test   ");
    	
    	sb.append(" from t_sd_saleorder t inner join t_sd_saleorderentry te on t.fid = te.fparentid ");
    	sb.append("inner join t_bd_person tp on t.FSalePersonID = tp.fid ");
    	sb.append("inner join t_bd_customer tc on t.FOrderCustomerID = tc.fid  ");
    	sb.append("inner join t_bd_material tm on te.FMaterialID = tm.fid ");
    	sb.append(" where (t.fbasestatus=4 or t.fbasestatus = 7) and  t.FSaleOrgUnitID ='");
    	sb.append(CompanyID);
    	sb.append("' and t.FBizDate >=to_date('");
    	sb.append(beginDate);
    	sb.append("','yyyy-MM-dd') and t.fbizDate <=to_date('");
    	sb.append(endDate);
    	sb.append("','yyyy-MM-dd') ");
    	if(StringUtils.isNotBlank(customerID)){
    		sb.append(" and t.FOrderCustomerID='");
    		sb.append(customerID);
    		sb.append("' ");
    	}
    	// 订单数据 创建临时表中
    	DbUtil.execute(ctx, sb.toString());
    	
    	// 退货数据导入
    	// 查询订单数据
    	sb = new StringBuilder();
    	sb.append("/*dialect*/insert  into ");
    	sb.append(tempTable);
    	sb.append("  select tp.fid personID,tp.fnumber personNumber,tp.fname_l2 personName, ");
    	sb.append("tc.fid customerID,tc.fnumber customerNumber, tc.fname_l2 customerName, ");
    	sb.append("tm.fid materialID,tm.fnumber materialNumber,tm.fname_l2 materialName, ");
    	sb.append("-te.FBaseQty/1000 qty,");
    	sb.append("0, ");

    	sb.append("-te.cfBaseAmount,-te.cfLzAmount,-te.cfSwDsAmount,-te.cfmonthdsAmount, ");
    	sb.append("-te.cffxdsAmount,-te.cfyeardsAmount,0,0,0 ");
    	
    	sb.append(" from T_SD_SaleReturns t inner join T_SD_SaleReturnsEntry te on t.fid = te.fparentid ");
    	sb.append("inner join t_bd_person tp on t.FSalePersonID = tp.fid ");
    	sb.append("inner join t_bd_customer tc on t.FReturnsCustomerID = tc.fid  ");
    	sb.append("inner join t_bd_material tm on te.FMaterialID = tm.fid ");
    	sb.append(" where  (t.fbasestatus=4 or t.fbasestatus = 7) and t.FSaleOrgUnitID ='");
    	sb.append(CompanyID);
    	sb.append("' and t.FBizDate >=to_date('");
    	sb.append(beginDate);
    	sb.append("','yyyy-MM-dd') and t.fbizDate <=to_date('");
    	sb.append(endDate);
    	sb.append("','yyyy-MM-dd') ");
    	if(StringUtils.isNotBlank(customerID)){
    		sb.append(" and t.FReturnsCustomerID='");
    		sb.append(customerID);
    		sb.append("' ");
    	}

    	DbUtil.execute(ctx, sb.toString());
    	
    	
    	// 调整数据整理 存入临时表
    	sb = new StringBuilder();
    	sb.append("/*dialect*/insert  into ");
    	sb.append(tempTable);
    	sb.append("  ");
    	sb.append(" select tp.fid personID, tp.fnumber personNumber,tp.fname_l2 personName, ");
    	sb.append(" tc.fid customerID,tc.fnumber customerNumber,tc.fname_l2 customerName, ");
    	sb.append(" tm.fid materialID,tm.fnumber materialNumber,tm.fname_l2 materialName, ");
    	sb.append(" 0,0,0,decode(CFDiscountType,1,sum(CFDiscountAmount),0) cfLzAmount, ");
    	sb.append(" decode(CFDiscountType,2,sum(CFDiscountAmount),0) cfSwDsAmount, ");
    	sb.append(" decode(CFDiscountType,3,sum(CFDiscountAmount),0) cfmonthdsAmount, ");
    	sb.append(" decode(CFDiscountType,5,sum(CFDiscountAmount),0) cffxdsAmount, ");
    	sb.append(" decode(CFDiscountType,4,sum(CFDiscountAmount),0) cfyeardsAmount, ");
    	sb.append(" 0,0,0 ");


    	sb.append("  from CT_NDI_DiscountRecordBill t inner join CT_NDI_DiscountRecordBillEntry te on t.fid = te.fparentid ");
    	sb.append(" inner join t_bd_customer tc on t.cfcustomerID = tc.fid  ");
    	sb.append(" inner join t_bd_customersaleinfo tcs on tc.fid = tcs.FCustomerID and tcs.FSaleOrgID =  t.CFCompanyID ");
    	sb.append(" inner join T_BD_CustomerSaler tcsr on tcs.fid = tcsr.fcustomersaleid ");
    	sb.append(" inner join t_bd_person tp on tcsr.fpersonid=tp.fid ");
    	sb.append(" inner join t_bd_material tm on te.cFMaterialID = tm.fid ");
    	
    	
    	sb.append(" where t.fDescription ='调整生成'  and t.cfstatus='4'  and t.CFCompanyID ='");
    	sb.append(CompanyID);
    	sb.append("' and t.FBizDate >=to_date('");
    	sb.append(beginDate);
    	sb.append("','yyyy-MM-dd') and t.fbizDate <=to_date('");
    	sb.append(endDate);
    	sb.append("','yyyy-MM-dd') ");
    	if(StringUtils.isNotBlank(customerID)){
    		sb.append(" and t.CFCustomerID='");
    		sb.append(customerID);
    		sb.append("' ");
    	}
    	sb.append(" group by tp.fid, tp.fnumber ,tp.fname_l2 , ");
    	sb.append(" tc.fid ,tc.fnumber ,tc.fname_l2 , ");
    	sb.append(" tm.fid ,tm.fnumber ,tm.fname_l2,t.CFDiscountType ");
    	
    	DbUtil.execute(ctx, sb.toString());
    	
    	
    	
    	// 更新 总折让、销售净额、单价
    	
    	sb = new StringBuilder();
    	sb.append("/*dialect*/update ");
    	sb.append(tempTable);
    	sb.append(" set alldiscount = cfLzAmount+cfSwDsAmount+cfmonthdsAmount+cffxdsAmount+cfyeardsAmount ,");
    	sb.append("netamount = cfBaseAmount-cfLzAmount-cfSwDsAmount-cfmonthdsAmount-cffxdsAmount-cfyeardsAmount, ");
    	sb.append("price = decode(qty,0,0,round(cfBaseAmount/qty,2)) ");
    	
    	DbUtil.execute(ctx, sb.toString());
    	boolean isGroupByMaterial = params.getBoolean("isGroupByMaterial");
    	if(isGroupByMaterial){
    		params.setObject("header", materialHeader());
    	}else{
    		params.setObject("header", Header());
    	}
    	return params;
	}
//    /**
//     * 获取 创建临时表语句
//     * @param ctx
//     * @return
//     */
//	private String getGreateTempTableSql(Context ctx){
//		StringBuilder sb = new StringBuilder();
//		sb.append("");
//	}
    
    public RptTableHeader materialHeader(){
    	//构造表头
    	RptTableHeader header=new RptTableHeader();
    	RptTableColumn col=null;
    	
    	String format=RptCellFormatter.getNumberFormat(2,true); 
    	//1
//    	col=new RptTableColumn("personNumber");
//    	col.setWidth(80);
//    	col.setAligment(RptTableColumn.HALIGN_LEFT);
//    	header.addColumn(col);
//    	//2
//    	col=new RptTableColumn("personName");    	
//    	col.setWidth(80);
//    	col.setAligment(RptTableColumn.HALIGN_LEFT);
//    	header.addColumn(col);
//    	//3
//    	col=new RptTableColumn("customerNumber");
//    	col.setWidth(120);    	
//    	col.setAligment(RptTableColumn.HALIGN_LEFT);
//    	header.addColumn(col);   
//    	//4
//    	col=new RptTableColumn("customerName");
//    	col.setWidth(220);   	
//    	col.setAligment(RptTableColumn.HALIGN_LEFT);
//    	//col.setFormatPattern(format);
//    	header.addColumn(col);
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
//    	//7
    	col=new RptTableColumn("saleQty");
    	col.setWidth(85);  
    	col.setFormatPattern(format);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	header.addColumn(col);
    	//7+1
    	col=new RptTableColumn("price");
    	col.setWidth(85);  
    	col.setFormatPattern(format);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	header.addColumn(col);
    	//7+2 厂价
    	col=new RptTableColumn("baseAmount");
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
    	
    	// 实物折扣
    	col=new RptTableColumn("swAmount");
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
    	
    	
    	// 分销折扣
    	col=new RptTableColumn("fxAmount");
    	col.setWidth(85); 
    	col.setFormatPattern(format);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	header.addColumn(col);
    	
    	// 年度折扣
    	col=new RptTableColumn("yearAmount");
    	col.setWidth(85); 
    	col.setFormatPattern(format);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	header.addColumn(col);
    	
    	// 折扣合计
    	col=new RptTableColumn("allDisAmount");
    	col.setWidth(85); 
    	col.setFormatPattern(format);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	header.addColumn(col);
    	
    	// 销售净额
    	col=new RptTableColumn("netAmount");
    	col.setWidth(85); 
    	col.setFormatPattern(format);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	header.addColumn(col);
    	
    	
    	
    	

    	header.setLabels(new Object[][]{
			{"产品编码","产品名称",
				"销量(吨)","单价","厂价金额","基本折扣(立折)","实物折扣","月度折扣","分销折扣","年度折扣","折扣合计","销售净额"}});
    	return header;
    }
	public RptTableHeader Header(){
    	//构造表头
    	RptTableHeader header=new RptTableHeader();
    	RptTableColumn col=null;
    	
    	String format=RptCellFormatter.getNumberFormat(2,true); 
    	//1
    	col=new RptTableColumn("personNumber");
    	col.setWidth(80);
    	col.setAligment(RptTableColumn.HALIGN_LEFT);
    	header.addColumn(col);
    	//2
    	col=new RptTableColumn("personName");    	
    	col.setWidth(80);
    	col.setAligment(RptTableColumn.HALIGN_LEFT);
    	header.addColumn(col);
    	//3
    	col=new RptTableColumn("customerNumber");
    	col.setWidth(120);    	
    	col.setAligment(RptTableColumn.HALIGN_LEFT);
    	header.addColumn(col);   
    	//4
    	col=new RptTableColumn("customerName");
    	col.setWidth(220);   	
    	col.setAligment(RptTableColumn.HALIGN_LEFT);
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
//    	//7
    	col=new RptTableColumn("saleQty");
    	col.setWidth(85);  
    	col.setFormatPattern(format);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	header.addColumn(col);
    	//7+1
    	col=new RptTableColumn("price");
    	col.setWidth(85);  
    	col.setFormatPattern(format);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	header.addColumn(col);
    	//7+2 厂价
    	col=new RptTableColumn("baseAmount");
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
    	
    	// 实物折扣
    	col=new RptTableColumn("swAmount");
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
    	
    	
    	// 分销折扣
    	col=new RptTableColumn("fxAmount");
    	col.setWidth(85); 
    	col.setFormatPattern(format);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	header.addColumn(col);
    	
    	// 年度折扣
    	col=new RptTableColumn("yearAmount");
    	col.setWidth(85); 
    	col.setFormatPattern(format);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	header.addColumn(col);
    	
    	// 折扣合计
    	col=new RptTableColumn("allDisAmount");
    	col.setWidth(85); 
    	col.setFormatPattern(format);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	header.addColumn(col);
    	
    	// 销售净额
    	col=new RptTableColumn("netAmount");
    	col.setWidth(85); 
    	col.setFormatPattern(format);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	header.addColumn(col);
    	
    	
    	
    	

    	header.setLabels(new Object[][]{
			{"业务员编码","业务员","	客户编码","客户","产品编码","产品名称",
				"销量(吨)","单价","厂价金额","基本折扣(立折)","实物折扣","月度折扣","分销折扣","年度折扣","折扣合计","销售净额"}});
    	return header;
    }
	
	protected RptParams _init(Context ctx, RptParams params) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		RptParams pp=new RptParams();
    	pp.setString("title","报表");    	
        return pp;
	}


	@Override
	protected RptParams _query(Context ctx, RptParams params, int from, int len) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		String tempTable = params.getString("tempTable");
		String tempTable1=this.getTempTableName("产品销量销售额折扣统计表1",ctx);
		boolean isGroupByMaterial = params.getBoolean("isGroupByMaterial");
    	if(isGroupByMaterial){
    		sb.append("/*dialect*/ create table  ");
			sb.append(tempTable1);
			sb.append(" as select t.materialNumber,");
//			sb.append("decode(t.personNumber,null,'合计', max(t.personName)) personName,");
//			sb.append(" t.customerNumber,");
//			sb.append(" decode(t.customerNumber,null,'小计',max(t.customerName)) customerName,");
//			sb.append(" t.materialNumber,");
			sb.append(" decode(t.materialNumber,null,'合计',max(t.materialName)) materialName,");
			sb.append(" sum(t.qty) saleQty,");
			sb.append(" decode(sum(t.qty),0,0,round(sum(t.cfBaseAmount)/sum(t.qty),2)) price,");
			sb.append(" sum(t.cfBaseAmount) cfBaseAmount, ");
			sb.append(" sum(t.cfLzAmount) cfLzAmount, ");
			sb.append(" sum(t.cfSwDsAmount) cfSwDsAmount, ");
			sb.append(" sum(t.cfmonthdsAmount) cfmonthdsAmount, ");
			sb.append(" sum(t.cffxdsAmount) cffxdsAmount, ");
			sb.append(" sum(t.cfyeardsAmount) cfyeardsAmount, ");
			sb.append(" sum(t.alldiscount) alldiscount,");
			sb.append(" sum(t.netamount) netamount ");
			sb.append(" from ");
			sb.append(tempTable);
			sb.append(" t group by rollup(t.materialNumber) order by t.materialNumber ");
    	
    	}else{
			sb.append("/*dialect*/ create table  ");
			sb.append(tempTable1);
			sb.append(" as select t.personNumber,");
			sb.append("decode(t.personNumber,null,'合计', max(t.personName)) personName,");
			sb.append(" t.customerNumber,");
			sb.append(" decode(t.customerNumber,null,'小计',max(t.customerName)) customerName,");
			sb.append(" t.materialNumber,");
			sb.append(" decode(t.materialNumber,null,'小计',max(t.materialName)) materialName,");
			sb.append(" sum(t.qty) saleQty,");
			sb.append(" decode(sum(t.qty),0,0,round(sum(t.cfBaseAmount)/sum(t.qty),2)) price,");
			sb.append(" sum(t.cfBaseAmount) cfBaseAmount, ");
			sb.append(" sum(t.cfLzAmount) cfLzAmount, ");
			sb.append(" sum(t.cfSwDsAmount) cfSwDsAmount, ");
			sb.append(" sum(t.cfmonthdsAmount) cfmonthdsAmount, ");
			sb.append(" sum(t.cffxdsAmount) cffxdsAmount, ");
			sb.append(" sum(t.cfyeardsAmount) cfyeardsAmount, ");
			sb.append(" sum(t.alldiscount) alldiscount,");
			sb.append(" sum(t.netamount) netamount ");
			sb.append(" from ");
			sb.append(tempTable);
			sb.append(" t group by rollup(t.personNumber,t.customerNumber,t.materialNumber) order by t.personNumber,t.customerNumber,t.materialNumber ");
    	}
		DbUtil.execute(ctx,sb.toString());
		
		sb = new StringBuffer();
		sb.append("select * from ").append(tempTable1);
		RptRowSet rs=this.executeQuery(sb.toString(),null,from,len,ctx);
    	RptParams pp=new RptParams();
    	pp.setObject("rowset",rs);
    	return pp;
	}
}