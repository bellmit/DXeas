package com.kingdee.eas.custom.rpt.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.report.util.RptCellFormatter;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.framework.report.util.RptRowSet;
import com.kingdee.eas.framework.report.util.RptTableColumn;
import com.kingdee.eas.framework.report.util.RptTableHeader;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class DeliveryAnalyzeFacadeControllerBean extends AbstractDeliveryAnalyzeFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.rpt.app.DeliveryAnalyzeFacadeControllerBean");
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
    	String tempTable;
		try {
			tempTable = this.getTempTable(ctx,params);
		} catch (SQLException e) {
			throw new EASBizException(new NumericExceptionSubItem("001",e.getMessage()));
		}
    	
    	
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
     * @throws SQLException 
     */
    private String getTempTable(Context ctx,RptParams params) throws BOSException, SQLException {

    	String tempTable=this.getTempTableName("发运报表", ctx);
    	dropTable(tempTable,ctx);
    	
    	String beginStationID=params.getString("beginStation");
    	String endStationID=params.getString("endStation");
    	String tempBeginStationID="";
    	String tempEndStationID="";
    	String deliveryLintID="";
    	
    	ArrayList<String> finalList=new ArrayList<String>();//最终
    	ArrayList<String> beginStationList=new ArrayList<String>();//起点
    	ArrayList<String> endStationList=new ArrayList<String>();//终点
    	//ArrayList<HashMap<String,Object>> list=new ArrayList<HashMap<String,Object>>();
    	StringBuffer sql=new StringBuffer();
    	sql.append(" select tmain.FID,tmain.FBeginStationID,tmain.FEndStationID,tmain.FDefaultCarrierID,tmain.FTotalMileage,");
    	sql.append(" tentry.FDetailLineID FDetailLineID");
    	sql.append(" from T_DT_DeliveryLine tmain");
    	sql.append(" left join T_DT_DeliveryLineEntry tentry on tentry.fparentid=tmain.fid");
    	sql.append(" where 1=1 ");
    	sql.append(" and FStatus=2 ");//启用
    	sql.append(" and ( tmain.FEndStationID='").append(endStationID).append("'");
		sql.append(" or tmain.FBeginStationID='").append(beginStationID).append("' )");
    	IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
    	while(rs.next()) {
    		deliveryLintID=rs.getString("fid");
    		tempBeginStationID=rs.getString("FBeginStationID");
    		tempEndStationID=rs.getString("FEndStationID");
    		if(tempBeginStationID.equals(beginStationID)&&tempEndStationID.equals(endStationID)) {//起始点=终止点
    			finalList.add(deliveryLintID);
    			continue;
    		}
    		if(tempBeginStationID.equals(beginStationID)) {//起点相同，则保存终点
    			endStationList.add(tempEndStationID);
    		}
    		if(tempEndStationID.equals(endStationID)) {//终点相同，则保存起点
    			beginStationList.add(tempBeginStationID);
    		}
    	}
    	return tempTable;
    }
    
    /**
     * 设置 发运路线 李斯特
     * @param deliveryID
     * @throws SQLException 
     * @throws BOSException 
     */
    private void setDeliveryLists(Context ctx,String deliveryID) throws SQLException, BOSException {
    	StringBuffer sql=new StringBuffer();
    	sql.append(" select tmain.FID,tmain.FBeginStationID,tmain.FEndStationID,tmain.FDefaultCarrierID,tmain.FTotalMileage,");
    	sql.append(" tentry.FDetailLineID FDetailLineID");
    	sql.append(" from T_DT_DeliveryLine tmain");
    	sql.append(" left join T_DT_DeliveryLineEntry tentry on tentry.fparentid=tmain.fid");
    	sql.append(" where tmain.FID=?");
    	IRowSet rs=DbUtil.executeQuery(ctx, sql.toString(),new Object[]{deliveryID});
    	while(rs.next()) {
    		
    	}
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