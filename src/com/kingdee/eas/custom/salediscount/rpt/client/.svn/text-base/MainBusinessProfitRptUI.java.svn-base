/**
 * output package name
 */
package com.kingdee.eas.custom.salediscount.rpt.client;

import java.awt.Color;
import java.awt.event.*;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.kdf.table.KDTDataRequestManager;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTDataRequestEvent;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.custom.salediscount.rpt.SaleDiscountAnalyzeRptFacadeFactory;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.report.ICommRptBase;
import com.kingdee.eas.framework.report.client.CommRptBaseConditionUI;
import com.kingdee.eas.framework.report.util.KDTableUtil;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.framework.report.util.RptRowSet;
import com.kingdee.eas.framework.report.util.RptTableHeader;

/**
 * output class name
 */
public class MainBusinessProfitRptUI extends AbstractMainBusinessProfitRptUI
{
    private static final Logger logger = CoreUIObject.getLogger(MainBusinessProfitRptUI.class);
    
    /**
     * output class constructor
     */
    public MainBusinessProfitRptUI() throws Exception
    {
    	super();
        this.kDTable1.getStyleAttributes().setLocked(true);
        this.kDTable1.checkParsed();     
 		this.kDTable1.getDataRequestManager().addDataRequestListener(this); 
 		this.kDTable1.getDataRequestManager().setDataRequestMode(KDTDataRequestManager.VIRTUAL_MODE_PAGE);
 		enableExportExcel(this.kDTable1);
 		
 		this.setUITitle("产品销量销售额折扣统计表");
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }


	@Override
	protected RptParams getParamsForInit() {
		// TODO Auto-generated method stub
		return params;
	}

	@Override
	protected CommRptBaseConditionUI getQueryDialogUserPanel() throws Exception {
		// TODO Auto-generated method stub
		return new SaleDiscountAnalyzeRptFilterUI();
	}

	@Override
	protected ICommRptBase getRemoteInstance() throws BOSException {
		// TODO Auto-generated method stub
		return SaleDiscountAnalyzeRptFacadeFactory.getRemoteInstance();
	}

	@Override
	protected KDTable getTableForPrintSetting() {
		// TODO Auto-generated method stub
		return this.kDTable1;
	}

	@Override
	protected void query() {
		// TODO Auto-generated method stub
		this.kDTable1.removeColumns();
		this.kDTable1.removeRows();//触发取数
	}

	@Override
	public void tableDataRequest(KDTDataRequestEvent e) {
		// TODO Auto-generated method stub
		try {
			int from=e.getFirstRow();
			int len=e.getLastRow()-from+1;	
			if(from==0){
				//临时表/表头
				params.setString("tempTable",this.getTempTable());
//				params.setString("cuId",SysContext.getSysContext().getCurrentCtrlUnit().getId().toString());
				
				RptParams rpt=getRemoteInstance().createTempTable(params);
				
				this.setTempTable(rpt.getString("tempTable"));
				RptTableHeader header=(RptTableHeader)rpt.getObject("header");
				KDTableUtil.setHeader(header,this.kDTable1);
//				this.kDTable1.setRowCount(rpt.getInt("verticalCount"));				
			}
			
			//查询并填充数据
			params.setString("tempTable",this.getTempTable());
			RptParams rpt=getRemoteInstance().query(params,from,len);
			RptRowSet rs=(RptRowSet)rpt.getObject("rowset");
			KDTableUtil.insertRows(rs,from,kDTable1);		
			
			// 合计行设置颜色 
			for(int i = 0; i < kDTable1.getRowCount3(); i ++){
				String personName = (String) (kDTable1.getCell(i, "personName")==null?"":(String) kDTable1.getCell(i, "personName").getValue());
				String customerName = (String) (kDTable1.getCell(i, "customerName")==null?"":kDTable1.getCell(i, "customerName").getValue());
				String materialName = (String) kDTable1.getCell(i, "materialName").getValue();
				
				Color hjColor = new Color(240,200,100);
				Color xj1Color = new Color(240,220,140);
				Color xj2Color = new Color(240,250,180);
				if("合计".equals(personName)){
					kDTable1.getRow(i).getStyleAttributes().setBackground(hjColor);
					kDTable1.getCell(i, "personNumber").setValue("合计");
					kDTable1.getCell(i, "personName").setValue("");
					kDTable1.getCell(i, "customerName").setValue("");
					kDTable1.getCell(i, "materialName").setValue("");
				}else if("小计".equals(customerName)){
					kDTable1.getRow(i).getStyleAttributes().setBackground(xj1Color);
					kDTable1.getCell(i, "customerNumber").setValue("小计");
					kDTable1.getCell(i, "customerName").setValue("");
					kDTable1.getCell(i, "materialName").setValue("");
				}else if("小计".equals(materialName)){
					kDTable1.getCell(i, "materialNumber").setValue("小计");
					kDTable1.getCell(i, "materialName").setValue("");
					kDTable1.getRow(i).getStyleAttributes().setBackground(xj2Color);
					
				}
				else if("合计".equals(materialName)){
					kDTable1.getCell(i, "materialNumber").setValue("合计");
					kDTable1.getCell(i, "materialName").setValue("");
					kDTable1.getRow(i).getStyleAttributes().setBackground(hjColor);
					
				}
				
			}
			
		} catch (Exception ex) {
			this.handleException(ex);			
		}
	}

}