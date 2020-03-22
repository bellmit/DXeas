package com.kingdee.eas.custom.rpt.app;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.framework.report.util.RptRowSet;
import com.kingdee.eas.framework.report.util.RptTableColumn;
import com.kingdee.eas.framework.report.util.RptTableHeader;

public class DeliveryDetailFacadeControllerBean extends AbstractDeliveryDetailFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.rpt.app.DeliveryDetailFacadeControllerBean");
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
    	String beginDate=params.getString("beginDate");
    	String endDate=params.getString("endDate");
    	String tempTable=this.getTempTableName("发运报表", ctx);
    	dropTable(tempTable, ctx);
    	StringBuffer sql=new StringBuffer();
    /*	sql.append(" select tsaleOrder.fnumber,to_char(tsaleOrder.FBizDate,'yyyy-MM-dd') FBizDate,torg.fname_l2 FOrgName,tcus.fname_l2 FCustomerName,tdl.FName_l2 FDeliveryName,");
    	sql.append(" tdbe.Fname_l2 FBeginStation,tdee.Fname_l2 FEndStation,tdl.FTotalMileage,tentry.fqty FQty");*/
    	sql.append(" select torg.fname_l2 FOrgName,tcus.fname_l2 FCustomerName,tdl.FName_l2 FDeliveryName,");
    	sql.append(" tdbe.Fname_l2 FBeginStation,tdee.Fname_l2 FEndStation,tdl.FTotalMileage,sum(isnull(tentry.fqty,0)) FQty");
    	sql.append(" into ").append(tempTable);
    	sql.append(" from t_sd_saleorder tsaleorder ");
    	sql.append(" inner join t_org_baseUnit torg on tOrg.fid=tsaleorder.FSaleOrgUnitID");
    	sql.append(" inner  join t_bd_customer tcus on tcus.Fid=tsaleorder.fordercustomerid");
    	sql.append(" inner join t_bd_customerSaleInfo tcussale on (tcussale.fcustomerid=tcus.fid and tcussale.FSaleOrgID=tsaleorder.FSaleOrgUnitID)");
    	sql.append(" inner join T_DT_DeliveryLine tdl on tdl.fid=tcusSale.CFDeliveryLineID");
    	sql.append(" inner join T_BD_Address tdbe on tdbe.FID=tdl.FBeginStationID");
    	sql.append(" inner join T_BD_Address tdee on tdee.FID=tdl.FEndStationID");
    	sql.append(" inner join t_sd_saleOrderEntry tentry on tentry.fparentid=tsaleorder.fid");
    	sql.append(" where 1=1");
    	sql.append(" and ( tsaleorder.FBaseStatus=4 or tsaleorder.FBaseStatus=7)");
    	sql.append(" and tSaleOrder.FID not in (");
    	sql.append(" select distinct FSrcObjectID from t_bot_relation ");
    	sql.append(" where FSrcEntityID='C48A423A' and FDestEntityID='8B07BBDB' ");
    	sql.append(" )");
    	sql.append(" and tsaleorder.fbizdate>={d '").append(beginDate).append("'}");
    	sql.append(" and tsaleorder.fbizdate<={d '").append(endDate).append("'}");
    	sql.append(" group by torg.fname_l2 ,tcus.fname_l2 ,tdl.FName_l2 ,");
    	sql.append(" tdbe.Fname_l2 ,tdee.Fname_l2 ,tdl.FTotalMileage");
    	executeCreateAsSelectInto(sql.toString(), null, ctx);
    	return tempTable;
    }
    
    protected RptTableHeader createHeader() {
    	//构造表头
    	RptTableHeader header=new RptTableHeader();
    	RptTableColumn col=null;
    	
    /*	col=new RptTableColumn("number");
    	col.setWidth(150);
    	header.addColumn(col);
    	
    	col=new RptTableColumn("bizDate");
    	col.setWidth(100);
    	header.addColumn(col);*/
    	
    	col=new RptTableColumn("company");
    	col.setWidth(200);
    	header.addColumn(col);
    	
    	col=new RptTableColumn("customerName");
    	col.setWidth(250);
    	header.addColumn(col);
    	
    	col=new RptTableColumn("deliveryName");
    	col.setWidth(180);
    	header.addColumn(col);
    	
    	col=new RptTableColumn("beginStation");
    	col.setWidth(100);
    	header.addColumn(col);
    	
    	col=new RptTableColumn("endStation");
    	col.setWidth(100);
    	header.addColumn(col);
    	
    	col=new RptTableColumn("mileage");
    	col.setWidth(100);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	header.addColumn(col);
    	
    	col=new RptTableColumn("sumQty");
    	col.setWidth(100);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	header.addColumn(col);
    	
    	
//    	header.setLabels(new Object[][]{{"科目编码","科目名称","级别","方向","是否现金流量"}});

    	//自动融合表头,表头行数没限制,只要数组二维长度与列数量相等就可以了.
    	header.setLabels(new Object[][]{
    			{"销售组织","客户","发运路线","起始点","结束点","总里程","总数量"}
    			//{"订单单号","业务日期","销售组织","客户","发运路线","起始点","结束点","总里程","数量"}
    			},true);
    	return header;
    }

    
    /**
     * 分页查询数据
     * 		在这里查询必要的数据
     */
    protected RptParams _query(Context ctx, RptParams params, int from, int len)throws BOSException, EASBizException
    {
    	RptRowSet rs=this.executeQuery("select * from "+params.getString("tempTable")+" order by FDeliveryName,FCustomerName",null,from,len,ctx);
    	RptParams pp=new RptParams();
    	pp.setObject("rowset",rs);
    	return pp;
    }
}