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
     * ��ʼ������
     */
    protected RptParams _init(Context ctx, RptParams params)throws BOSException, EASBizException
    {
    	RptParams pp=new RptParams();
    	pp.setString("title",params.getString("init_title")+"BBB");    	
        return pp;
    }
    /**
     * ������ʱ��(�Ǳ�Ҫ)
     */
    protected RptParams _createTempTable(Context ctx, RptParams params)throws BOSException, EASBizException
	{
    	//ɾ������ʱ��(�ṹ�������²�ѯ��ͬ,��������ʱ��ṹ����)
    	String tempTable;
		try {
			tempTable = this.getTempTable(ctx,params);
		} catch (SQLException e) {
			throw new EASBizException(new NumericExceptionSubItem("001",e.getMessage()));
		}
    	
    	
    	//ͳ��������
    	String countSql="select count(1) cc from "+tempTable;
    	RptRowSet rs=this.executeQuery(countSql,null,ctx);
    	rs.next();
    	int count=rs.getInt(0);
    	
    	//���÷�������
    	RptParams result=new RptParams();
    	result.setString("tempTable",tempTable);    	
    	result.setObject("header",createHeader());
    	result.setInt("verticalCount",count);
    	return result;
    }    
    /**
     * ��ȡsql���
     * @return
     * @throws BOSException 
     * @throws SQLException 
     */
    private String getTempTable(Context ctx,RptParams params) throws BOSException, SQLException {

    	String tempTable=this.getTempTableName("���˱���", ctx);
    	dropTable(tempTable,ctx);
    	
    	String beginStationID=params.getString("beginStation");
    	String endStationID=params.getString("endStation");
    	String tempBeginStationID="";
    	String tempEndStationID="";
    	String deliveryLintID="";
    	
    	ArrayList<String> finalList=new ArrayList<String>();//����
    	ArrayList<String> beginStationList=new ArrayList<String>();//���
    	ArrayList<String> endStationList=new ArrayList<String>();//�յ�
    	//ArrayList<HashMap<String,Object>> list=new ArrayList<HashMap<String,Object>>();
    	StringBuffer sql=new StringBuffer();
    	sql.append(" select tmain.FID,tmain.FBeginStationID,tmain.FEndStationID,tmain.FDefaultCarrierID,tmain.FTotalMileage,");
    	sql.append(" tentry.FDetailLineID FDetailLineID");
    	sql.append(" from T_DT_DeliveryLine tmain");
    	sql.append(" left join T_DT_DeliveryLineEntry tentry on tentry.fparentid=tmain.fid");
    	sql.append(" where 1=1 ");
    	sql.append(" and FStatus=2 ");//����
    	sql.append(" and ( tmain.FEndStationID='").append(endStationID).append("'");
		sql.append(" or tmain.FBeginStationID='").append(beginStationID).append("' )");
    	IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
    	while(rs.next()) {
    		deliveryLintID=rs.getString("fid");
    		tempBeginStationID=rs.getString("FBeginStationID");
    		tempEndStationID=rs.getString("FEndStationID");
    		if(tempBeginStationID.equals(beginStationID)&&tempEndStationID.equals(endStationID)) {//��ʼ��=��ֹ��
    			finalList.add(deliveryLintID);
    			continue;
    		}
    		if(tempBeginStationID.equals(beginStationID)) {//�����ͬ���򱣴��յ�
    			endStationList.add(tempEndStationID);
    		}
    		if(tempEndStationID.equals(endStationID)) {//�յ���ͬ���򱣴����
    			beginStationList.add(tempBeginStationID);
    		}
    	}
    	return tempTable;
    }
    
    /**
     * ���� ����·�� ��˹��
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
    	//�����ͷ
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
    	col.setFormatPattern(RptCellFormatter.FORMAT_ZERO2EMPTY);//�Զ�����ʾ��ʽ
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
    	col.setFormatPattern(RptCellFormatter.FORMAT_ZERO2EMPTY);//�Զ�����ʾ��ʽ
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
    	col.setFormatPattern(RptCellFormatter.FORMAT_ZERO2EMPTY);//�Զ�����ʾ��ʽ
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
    	col.setFormatPattern(RptCellFormatter.FORMAT_ZERO2EMPTY);//�Զ�����ʾ��ʽ
    	header.addColumn(col);
    	
    	col=new RptTableColumn("col15");
    	col.setWidth(80);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	col.setFormatPattern(RptCellFormatter.FORMAT_ZERO2EMPTY);//�Զ�����ʾ��ʽ
    	header.addColumn(col);
    	
    	col=new RptTableColumn("col16");
    	col.setWidth(80);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	col.setFormatPattern(RptCellFormatter.FORMAT_ZERO2EMPTY);//�Զ�����ʾ��ʽ
    	header.addColumn(col);
    	
    	col=new RptTableColumn("col17");
    	col.setWidth(80);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	col.setFormatPattern(RptCellFormatter.FORMAT_ZERO2EMPTY);//�Զ�����ʾ��ʽ
    	header.addColumn(col);
    	
    	col=new RptTableColumn("col18");
    	col.setWidth(80);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	col.setFormatPattern(RptCellFormatter.FORMAT_ZERO2EMPTY);//�Զ�����ʾ��ʽ
    	header.addColumn(col);
    	
    	col=new RptTableColumn("col19");
    	col.setWidth(0);
    	header.addColumn(col);
    	
    	col=new RptTableColumn("col20");
    	col.setWidth(0);
    	header.addColumn(col);
    	
//    	header.setLabels(new Object[][]{{"��Ŀ����","��Ŀ����","����","����","�Ƿ��ֽ�����"}});

    	//�Զ��ںϱ�ͷ,��ͷ����û����,ֻҪ�����ά��������������ȾͿ�����.
    	header.setLabels(new Object[][]{
    			{"���˵���","ҵ������","�ͻ�","��������","�ܷ���·��","��ʼ��","������","�����","���ϱ���","��������","����","�ӷ���·��","��ʼ��","������","���","������","������Ŀ","����","�����","����","Э�鵥��","Э����","FSeq","FFeeSeq"}},true);
    	return header;
    }

    
    /**
     * ��ҳ��ѯ����
     * 		�������ѯ��Ҫ������
     */
    protected RptParams _query(Context ctx, RptParams params, int from, int len)throws BOSException, EASBizException
    {
    	RptRowSet rs=this.executeQuery("select * from "+params.getString("tempTable")+" order by fnumber,FSeq,FFeeSeq",null,from,len,ctx);
    	RptParams pp=new RptParams();
    	pp.setObject("rowset",rs);
    	return pp;
    }
}