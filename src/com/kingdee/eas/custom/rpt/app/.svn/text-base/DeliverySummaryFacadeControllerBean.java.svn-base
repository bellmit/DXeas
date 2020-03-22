package com.kingdee.eas.custom.rpt.app;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.TableManagerFacadeFactory;
import com.kingdee.eas.framework.report.util.RptCellFormatter;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.framework.report.util.RptRowSet;
import com.kingdee.eas.framework.report.util.RptTableColumn;
import com.kingdee.eas.framework.report.util.RptTableHeader;
import com.kingdee.eas.util.app.DbUtil;

public class DeliverySummaryFacadeControllerBean extends AbstractDeliverySummaryFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.rpt.app.DeliverySummaryFacadeControllerBean");
    /**
     * 初始化数据
     */
    protected RptParams _init(Context ctx, RptParams params)throws BOSException, EASBizException
    {
    	RptParams pp=new RptParams();
    	pp.setString("title",params.getString("init_title")+"BBB");    	
        return pp;
    }
    /**
     * 创建临时表(非必要)
     */
    protected RptParams _createTempTable(Context ctx, RptParams params)throws BOSException, EASBizException
	{
    	//删除旧临时表(结构可能与新查询不同,本例子临时表结构不变)
    	dropTable(params.getString("tempTable"),ctx);
    	
    	String tempTable=this.getTempTable(ctx,params);
    	
    	
    	//统计总行数
    	String countSql="select count(1) cc from "+tempTable;
    	RptRowSet rs=this.executeQuery(countSql,null,ctx);
    	rs.next();
    	int count=rs.getInt(0);
    	
    	//设置返回数据
    	RptParams result=new RptParams();
    	result.setString("tempTable",tempTable);    	
    	result.setObject("header",createHeader());
    	result.setInt("verticalCount",count);
    	return result;
    }    
    /**
     * 获取sql语句
     * @return
     * @throws BOSException 
     */
    private String getTempTable(Context ctx,RptParams params) throws BOSException {
    	StringBuffer sql=new StringBuffer();
    	String tempTable=this.getTempTableName("发运报表", ctx);
    	sql.append(" create table ").append(tempTable).append(" (");
    	sql.append(" FBillID varchar(44),");
//    	sql.append(" FBillNum varchar(60),");
//    	sql.append(" FDLID varchar(44),");
    	sql.append(" FEntryID varchar(44),");
    	sql.append(" FEntryFeeID varchar(44),");
//    	sql.append(" FDLName varchar(200),");
//    	sql.append(" FBeginStation varchar(200),");
//    	sql.append(" FEndStation varchar(200),");
//    	sql.append(" FMileage decimal(28,10),");
//    	sql.append(" FDLEntryName varchar(200),");
//    	sql.append(" FEntryBeginStation varchar(200),");
//    	sql.append(" FEntryEndStation varchar(200),");
//    	sql.append(" FEntryMileage decimal(28,10),");
    	sql.append(" FStatus int default 0");
    	sql.append(" )");
    	TableManagerFacadeFactory.getLocalInstance(ctx).createTempTable(sql.toString());
    	
    	String companyID=params.getString("companyID");
    	String sendLineID=params.getString("sendLineID");
    	String beginDate=params.getString("beginDate");
    	String endDate=params.getString("endDate");
    	
    	sql.setLength(0);
    	sql.append(" insert into ").append(tempTable).append(" (");
    	sql.append(" FBillID,FEntryID,FEntryFeeID,FStatus");
    	sql.append(" )");
    	sql.append(" select distinct tBill.FID,tEntry.FID,tEntryFee.FID,1");
    	sql.append(" from T_DT_CarryBill tBill");
    	sql.append(" inner join T_DT_CarryBillEntry tEntry on tEntry.FparentId=tBill.FID");
    	sql.append(" inner join T_DT_CarryBillFeeEntry tEntryFee on ( tEntryFee.FParentID=tBill.FID and tEntryFee.FCarryBillEntryID=tEntry.FID )");
    	sql.append(" where tBill.FBaseStatus=4 ");
    	if(StringUtils.isNotBlank(companyID))
    		sql.append(" and FTranportOrgUnitID='").append(companyID).append("'");
    	if(StringUtils.isNotBlank(sendLineID))
    		sql.append(" and FSendLineID='").append(sendLineID).append("'");
    	if(StringUtils.isNotBlank(beginDate))
    		sql.append(" and FBizDate>={d'").append(beginDate).append("'}");
    	if(StringUtils.isNotBlank(endDate))
    		sql.append(" and FBizDate<={d'").append(endDate).append("'}");
    	DbUtil.execute(ctx, sql.toString());
    	String tempTable2=this.getTempTableName("发运报表2", ctx);
    	
    	sql.setLength(0);
    	sql.append(" select tBill.FNumber, to_char(tBill.FBizDate,'yyyy-MM-dd') FBizDate,tCus.FName_l2 FCustomerName,tSale.FNumber FSaleOrderNum,");
    	sql.append(" tdl.FName_l2 FDLName,tdb.FName_l2 FBeginStation,tde.FName_l2 FEndStation,tdl.FTotalMileage,");
    	sql.append(" tm.FNumber FMaterialNum,tm.FName_l2 FMaterialName,tEntry.FQty,");
    	sql.append(" tdlEntry.FName_l2 FDLNameEntry,tdbe.FName_l2 FBeginStationEntry,tdee.FName_l2 FEndStationEntry,tdlEntry.FTotalMileage FTotalMileageEntry,");
    	sql.append(" tspy.Fname_l2 FSpuName,tItem.FName_l2 FFeeName,tEntryFee.FFeeQty,tEntryFee.FFeePrice,tEntryFee.FFeeAmount,tEntryFee.FAgreePrice,tEntryFee.FAgressAmount,");
    	sql.append(" tEntry.FSeq,tEntryFee.FSeq FFeeSeq");
    	sql.append(" into ").append(tempTable2);
    	sql.append(" from ").append(tempTable).append(" tMain");
    	sql.append(" inner join T_DT_CarryBill tBill on tBill.FID=tmain.FBillID");
    	//sql.append(" left join t_bot_relation tbtp on tbtp.FDestObjectID=tbill.FID");
    	sql.append(" left join t_sd_saleOrder tSale on tSale.FID=tBill.FSourceBillID");
    	sql.append(" left join t_bd_customer tCus on tCus.FID=tSale.FOrderCustomerID");
    	sql.append(" inner join T_DT_DeliveryLine tdl on tdl.FID=tBill.FSendLineID");
    	sql.append(" inner join T_BD_Address tdb on tdb.FID=tdl.FBeginStationID");
    	sql.append(" inner join T_BD_Address tde on tde.FID=tdl.FEndStationID");
    	sql.append(" inner join T_DT_CarryBillEntry tEntry on tEntry.FID=tMain.FEntryID");
    	sql.append(" inner join t_bd_supplier tspy on tspy.fid=tEntry.FCarrierID");
    	sql.append(" inner join t_bd_material tm on tm.FID=tEntry.FMaterialID");
    	sql.append(" inner join T_DT_DeliveryLine tdlEntry on tdlEntry.FID=tEntry.FDetailLineID");
    	sql.append(" inner join T_BD_Address tdbe on tdbe.FID=tdlEntry.FBeginStationID");
    	sql.append(" inner join T_BD_Address tdee on tdee.FID=tdlEntry.FEndStationID");
    	sql.append(" inner join T_DT_CarryBillFeeEntry tEntryFee on tEntryFee.FID=FEntryFeeID");
    	sql.append(" inner join T_SCM_ExpenseItem tItem on tItem.FID=tEntryFee.FFeeItemID");
    	executeCreateAsSelectInto(sql.toString(), null, ctx);
    	dropTable(tempTable, ctx);
    	return tempTable2;
    }
    
    protected RptTableHeader createHeader() {
    	//构造表头
    	RptTableHeader header=new RptTableHeader();
    	RptTableColumn col=null;
    	
    	col=new RptTableColumn("col1");
    	col.setWidth(150);
    	header.addColumn(col);
    	
    	col=new RptTableColumn("colBizDate");
    	col.setWidth(100);
    	header.addColumn(col);
    	
    	col=new RptTableColumn("colCustomerName");
    	col.setWidth(200);
    	header.addColumn(col);
    	
    	col=new RptTableColumn("colOrderNum");
    	col.setWidth(150);
    	header.addColumn(col);
    	
    	col=new RptTableColumn("col2");
    	col.setWidth(200);
    	header.addColumn(col);
    	
    	col=new RptTableColumn("col3");
    	col.setWidth(100);
    	header.addColumn(col);
    	
    	col=new RptTableColumn("col4");
    	col.setWidth(100);
    	header.addColumn(col);
    	
    	col=new RptTableColumn("col5");
    	col.setWidth(80);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	col.setFormatPattern(RptCellFormatter.FORMAT_ZERO2EMPTY);//自定义显示格式
    	header.addColumn(col);
    	
    	col=new RptTableColumn("col6");
    	col.setWidth(100);
    	header.addColumn(col);
    	
    	col=new RptTableColumn("col7");
    	col.setWidth(200);
    	header.addColumn(col);
    	
    	col=new RptTableColumn("col8");
    	col.setWidth(80);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	col.setFormatPattern(RptCellFormatter.FORMAT_ZERO2EMPTY);//自定义显示格式
    	header.addColumn(col);
    	
    	col=new RptTableColumn("col9");
    	col.setWidth(200);
    	header.addColumn(col);
    	
    	col=new RptTableColumn("col10");
    	col.setWidth(100);
    	header.addColumn(col);
    	
    	col=new RptTableColumn("col11");
    	col.setWidth(100);
    	header.addColumn(col);
    	
    	col=new RptTableColumn("col12");
    	col.setWidth(80);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	col.setFormatPattern(RptCellFormatter.FORMAT_ZERO2EMPTY);//自定义显示格式
    	header.addColumn(col);
    	
    	col=new RptTableColumn("supplierName");
    	col.setWidth(200);
    	header.addColumn(col);
    	
    	col=new RptTableColumn("col13");
    	col.setWidth(200);
    	header.addColumn(col);
    	
    	col=new RptTableColumn("col14");
    	col.setWidth(100);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	col.setFormatPattern(RptCellFormatter.FORMAT_ZERO2EMPTY);//自定义显示格式
    	header.addColumn(col);
    	
    	col=new RptTableColumn("col15");
    	col.setWidth(80);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	col.setFormatPattern(RptCellFormatter.FORMAT_ZERO2EMPTY);//自定义显示格式
    	header.addColumn(col);
    	
    	col=new RptTableColumn("col16");
    	col.setWidth(80);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	col.setFormatPattern(RptCellFormatter.FORMAT_ZERO2EMPTY);//自定义显示格式
    	header.addColumn(col);
    	
    	col=new RptTableColumn("col17");
    	col.setWidth(80);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	col.setFormatPattern(RptCellFormatter.FORMAT_ZERO2EMPTY);//自定义显示格式
    	header.addColumn(col);
    	
    	col=new RptTableColumn("col18");
    	col.setWidth(80);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	col.setFormatPattern(RptCellFormatter.FORMAT_ZERO2EMPTY);//自定义显示格式
    	header.addColumn(col);
    	
    	col=new RptTableColumn("col19");
    	col.setWidth(0);
    	header.addColumn(col);
    	
    	col=new RptTableColumn("col20");
    	col.setWidth(0);
    	header.addColumn(col);
    	
//    	header.setLabels(new Object[][]{{"科目编码","科目名称","级别","方向","是否现金流量"}});

    	//自动融合表头,表头行数没限制,只要数组二维长度与列数量相等就可以了.
    	header.setLabels(new Object[][]{
    			{"发运单号","业务日期","客户","订单单号","总发运路线","起始点","结束点","总里程","物料编码","物料名称","数量","子发运路线","起始点","结束点","里程","承运商","费用项目","数量","额定单价","额定金额","协议单价","协议金额","FSeq","FFeeSeq"}},true);
    	return header;
    }

    
    /**
     * 分页查询数据
     * 		在这里查询必要的数据
     */
    protected RptParams _query(Context ctx, RptParams params, int from, int len)throws BOSException, EASBizException
    {
    	RptRowSet rs=this.executeQuery("select * from "+params.getString("tempTable")+" order by fnumber,FSeq,FFeeSeq",null,from,len,ctx);
    	RptParams pp=new RptParams();
    	pp.setObject("rowset",rs);
    	return pp;
    }

}