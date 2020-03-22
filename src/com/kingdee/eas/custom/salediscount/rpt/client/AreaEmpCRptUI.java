package com.kingdee.eas.custom.salediscount.rpt.client;

import java.awt.Color;
import java.math.BigDecimal;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.KDTDataRequestManager;
import com.kingdee.bos.ctrl.kdf.table.KDTSortManager;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTDataRequestEvent;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.salediscount.rpt.AreaEmpCRptFacadeFactory;
import com.kingdee.eas.framework.report.ICommRptBase;
import com.kingdee.eas.framework.report.client.CommRptBaseConditionUI;
import com.kingdee.eas.framework.report.util.KDTableUtil;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.framework.report.util.RptRowSet;
import com.kingdee.eas.framework.report.util.RptTableHeader;
//产品分析表
public class AreaEmpCRptUI extends AbstractAreaEmpCRptUI {

	public AreaEmpCRptUI() throws Exception {
		super();
		this.kDTable1.checkParsed();     
		this.kDTable1.getDataRequestManager().addDataRequestListener(this); 
		this.kDTable1.getDataRequestManager().setDataRequestMode(KDTDataRequestManager.VIRTUAL_MODE_PAGE);
	    enableExportExcel(this.kDTable1); 
	    //tbl.getViewManager().setFreezeView(0,2);        
        KDTSortManager manager=new KDTSortManager(this.kDTable1); 
	    manager.setSortAuto(true);
	    this.setUITitle("产品分析表");
	}
	public void onLoad() throws Exception {
		super.onLoad();
	}

	protected ICommRptBase getRemoteInstance() throws BOSException {
		return AreaEmpCRptFacadeFactory.getRemoteInstance();
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
		return new AreaEmpCFilterUI();
	}

	protected void query() {
		String title=params.getString("title");
		//this.lblTitle.setText(title);
		this.kDTable1.removeColumns();
		this.kDTable1.removeRows();//触发取数
		
		
		java.awt.Color rowColor=new Color(255,128,0);
		for(int j=0;j<kDTable1.getRowCount();j++){
			BigDecimal FLevel=(BigDecimal)kDTable1.getRow(j).getCell("FLevel").getValue();
	    	if(FLevel!=null&&!FLevel.toString().equals("1")){
	    		kDTable1.getRow(j).getStyleAttributes().setBackground(rowColor);
	    	}
	    	if(j==kDTable1.getRowCount()-1){
	    		//String StrTotal=(String)kDTable1.getCell(j,1).getValue();
	    		//if(StrTotal.equals("总合计")){
	    			kDTable1.getRow(j).getStyleAttributes().setBackground(rowColor);
	    		//}
	    	}
	    }

	}

	public void tableDataRequest(KDTDataRequestEvent e) {
		try {
			int from=e.getFirstRow();
			int len=e.getLastRow()-from+1;	
			RptParams rpt=AreaEmpCRptFacadeFactory.getRemoteInstance().createTempTable(params);
			if(from==0){
				//临时表/表头
				params.setString("tempTable",this.getTempTable());
				params.setString("cuId",SysContext.getSysContext().getCurrentCtrlUnit().getId().toString());
				this.setTempTable(rpt.getString("tempTable"));
				RptTableHeader header=(RptTableHeader)rpt.getObject("header");
				KDTableUtil.setHeader(header,this.kDTable1);	
				
				//this.kDTable1.setRowCount(rpt.getInt("verticalCount"));	
				len=rpt.getInt("verticalCount")-from+1;
				this.kDTable1.setRowCount(rpt.getInt("verticalCount"));	
			}
			//查询并填充数据
			params.setString("rptname", rpt.getString("rptname"));
			params.setString("tempTable",this.getTempTable());
			rpt=AreaEmpCRptFacadeFactory.getRemoteInstance().query(params,from,len);		
			RptRowSet rs=(RptRowSet)rpt.getObject("rowset");
			KDTableUtil.insertRows(rs,from,kDTable1);	
			
		} catch (Exception ex) {
			this.handleException(ex);			
		}
	}

}
