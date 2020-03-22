package com.kingdee.eas.custom.salediscount.rpt.client;

import java.awt.Color;
import java.math.BigDecimal;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDataRequestManager;
import com.kingdee.bos.ctrl.kdf.table.KDTSortManager;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTDataRequestEvent;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.salediscount.rpt.ProductSaleDayRptFacadeFactory;
import com.kingdee.eas.framework.report.ICommRptBase;
import com.kingdee.eas.framework.report.client.CommRptBaseConditionUI;
import com.kingdee.eas.framework.report.util.KDTableInsertHandler;
import com.kingdee.eas.framework.report.util.KDTableUtil;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.framework.report.util.RptRowSet;
import com.kingdee.eas.framework.report.util.RptTableHeader;
//产品销量日报表
public class ProductSaleDayRptUI extends AbstractProductSaleDayRptUI {
	public ProductSaleDayRptUI() throws Exception {
		super();
		this.kDTable1.checkParsed();     
		this.kDTable1.getDataRequestManager().addDataRequestListener(this); 
		this.kDTable1.getDataRequestManager().setDataRequestMode(KDTDataRequestManager.VIRTUAL_MODE_PAGE);
	    enableExportExcel(this.kDTable1); 
	    //tbl.getViewManager().setFreezeView(0,2);        
        KDTSortManager manager=new KDTSortManager(this.kDTable1); 
	    manager.setSortAuto(true);
	}

	public void onLoad() throws Exception {
		super.onLoad();
	}

	protected ICommRptBase getRemoteInstance() throws BOSException {
		return ProductSaleDayRptFacadeFactory.getRemoteInstance();
	}

	protected KDTable getTableForPrintSetting() {
		// TODO 自动生成方法存根
		return this.kDTable1;
	}

	protected RptParams getParamsForInit() {
		// TODO 自动生成方法存根
		return params;
	}

	protected CommRptBaseConditionUI getQueryDialogUserPanel() throws Exception {
		// TODO 自动生成方法存根
		return new ProductSaleDayFilterUI();
	}

	protected void query() {
		String title=params.getString("title");
		//this.lblTitle.setText(title);
		this.kDTable1.removeColumns();
		this.kDTable1.removeRows();//触发取数
		
		java.awt.Color rowColor=new Color(255,128,0);
		for(int j=0;j<kDTable1.getRowCount();j++){
			BigDecimal FLevel=(BigDecimal)kDTable1.getRow(j).getCell("FLevel").getValue();
	    	if(FLevel == null || !FLevel.toString().equals("1")){
	    		kDTable1.getRow(j).getStyleAttributes().setBackground(rowColor);
	    	}
	    	if(j==kDTable1.getRowCount()-1){
	    		String StrTotal=(String)kDTable1.getCell(j,1).getValue();
	    		if(StrTotal.equals("总合计")){
	    			kDTable1.getRow(j).getStyleAttributes().setBackground(rowColor);
	    		}
	    	}
	    }
	}

	public void tableDataRequest(KDTDataRequestEvent e) {
		try {
			int from=e.getFirstRow();
			int len=e.getLastRow()-from+1;	
			if(from==0){
				//临时表/表头
				params.setString("tempTable",this.getTempTable());
				params.setString("cuId",SysContext.getSysContext().getCurrentCtrlUnit().getId().toString());
				RptParams rpt=ProductSaleDayRptFacadeFactory.getRemoteInstance().createTempTable(params);
				this.setTempTable(rpt.getString("tempTable"));
				RptTableHeader header=(RptTableHeader)rpt.getObject("header");
				KDTableUtil.setHeader(header,this.kDTable1);	
				
				len=rpt.getInt("verticalCount")-from+1;
				this.kDTable1.setRowCount(rpt.getInt("verticalCount"));	
			}
			
			//查询并填充数据
			params.setString("tempTable",this.getTempTable());
			RptParams rpt=ProductSaleDayRptFacadeFactory.getRemoteInstance().query(params,from,len);
			RptRowSet rs=(RptRowSet)rpt.getObject("rowset");
			KDTableUtil.insertRows(rs,from,kDTable1);	
		} catch (Exception ex) {
			this.handleException(ex);			
		}
	}
	public void aa(RptRowSet rs){
		java.awt.Color rowColor=new Color(255,128,0);
		IRow row = null;
		int i=0;
		while(rs.next()){
			row = kDTable1.addRow(i);
			String FLevel=(String)rs.getString("FLevel").toString();
			if(!FLevel.equals("0")){
				this.kDTable1.getRow(i).getStyleAttributes().setBackground(rowColor);
        	}
			for(int j=0;j<kDTable1.getColumnCount();j++){
	        	String StrColumnName=kDTable1.getColumn(j).getKey();
	        	this.kDTable1.getRow(i).getCell(StrColumnName).setValue(rs.getString(StrColumnName).toString());
			}
			i++;
		}
        /*for(int j=0;j<kDTable1.getRowCount();j++){
        	String FLevel=(String)kDTable1.getRow(j).getCell("FLevel").getValue();
        	if(!FLevel.equals("0")){
        		kDTable1.getRow(j).getStyleAttributes().setBackground(rowColor);
        	}
        }*/
	}
	 public static void insertRows(RptRowSet rs, int insertRowIndex, KDTable table, boolean refreshUI, KDTableInsertHandler handler)
	    {
		 	java.awt.Color rowColor=new Color(255,128,0);
	        table.setRefresh(false);
	        IRow row = null;
	        for(; rs.next(); handler.setTableRowData(row, rs.toRowArray()))
	            row = table.addRow(insertRowIndex++);
	        if(refreshUI)
	            table.setRefresh(true);
	        if(rs.getRowCount() > 0)
	            table.reLayoutAndPaint();
	        else
	            table.repaint();
	    }

	protected void queryA() {
		// TODO 自动生成方法存根
		
	}
}
