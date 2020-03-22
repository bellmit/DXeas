/**
 * output package name
 */
package com.kingdee.eas.custom.salediscount.rpt.client;

import java.awt.Color;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.KDTDataRequestManager;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTDataRequestEvent;
import com.kingdee.bos.ctrl.kdf.util.style.ShareStyleAttributes;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.custom.salediscount.rpt.CustomerProfitRptFacadeFactory;
import com.kingdee.eas.framework.report.ICommRptBase;
import com.kingdee.eas.framework.report.client.CommRptBaseConditionUI;
import com.kingdee.eas.framework.report.util.KDTableUtil;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.framework.report.util.RptRowSet;
import com.kingdee.eas.framework.report.util.RptTableHeader;

/**
 * output class name
 */
public class CustomerProfitRptUI extends AbstractCustomerProfitRptUI
{
    private static final Logger logger = CoreUIObject.getLogger(CustomerProfitRptUI.class);
    
    /**
     * output class constructor
     */
    public CustomerProfitRptUI() throws Exception
    {
        super();
        
        this.kDTable1.getStyleAttributes().setLocked(true);
        this.kDTable1.checkParsed();     
 		this.kDTable1.getDataRequestManager().addDataRequestListener(this); 
 		this.kDTable1.getDataRequestManager().setDataRequestMode(KDTDataRequestManager.VIRTUAL_MODE_PAGE);
 		enableExportExcel(this.kDTable1);
 		
 		this.setUITitle("客户利润表");
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
		return new CustomerProfitRptFilterUI();
	}

	@Override
	protected ICommRptBase getRemoteInstance() throws BOSException {
		// TODO Auto-generated method stub
		return CustomerProfitRptFacadeFactory.getRemoteInstance();
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
			
				
//				this.kDTable1.setRowCount(rpt.getInt("verticalCount"));				
			
			
			//查询并填充数据
			RptParams rpt=getRemoteInstance().query(params);
			RptRowSet rs=(RptRowSet)rpt.getObject("rowset");
			RptTableHeader header=(RptTableHeader)rpt.getObject("header");
			KDTableUtil.setHeader(header,this.kDTable1);
			KDTableUtil.insertRows(rs,0,kDTable1);		
			
			// 合计行设置颜色 
			for(int i = 0; i < kDTable1.getRowCount3(); i ++){
				String groupName = (String) (kDTable1.getCell(i, "saleGroupNumber")==null?"":(String) kDTable1.getCell(i, "saleGroupNumber").getValue());
				String salePersonNumber = (String) (kDTable1.getCell(i, "salePersonNumber")==null?"":(String) kDTable1.getCell(i, "salePersonNumber").getValue());
				String customerName = (String) (kDTable1.getCell(i, "customerNumber")==null?"":kDTable1.getCell(i, "customerNumber").getValue());
				String materialName = (String) (kDTable1.getCell(i, "materialNumber")==null?"":kDTable1.getCell(i, "materialNumber").getValue());
				
				Color hjColor = new Color(240,200,100);
				Color xj1Color = new Color(240,220,140);
				Color xj2Color = new Color(240,250,180);
				
//				ShareStyleAttributes aaa = ShareStyleAttributes();
				
				if("合计".equals(groupName)){
					kDTable1.getRow(i).getStyleAttributes().setBold(true);
					kDTable1.getRow(i).getStyleAttributes().setBackground(hjColor);
					kDTable1.getCell(i, "saleGroupNumber").setValue("合计");
					kDTable1.getCell(i, "saleGroupNumber").getStyleAttributes().setHorizontalAlign(HorizontalAlignment.CENTER);
					kDTable1.getCell(i, "salePersonNumber").setValue("");
					kDTable1.getCell(i, "customerNumber").setValue("");
					kDTable1.getCell(i, "materialNumber").setValue("");
				}else if("小计".equals(salePersonNumber)){
					kDTable1.getRow(i).getStyleAttributes().setBackground(xj1Color);
					kDTable1.getRow(i).getStyleAttributes().setBold(true);
					kDTable1.getCell(i, "salePersonNumber").setValue("小计");
					
					kDTable1.getCell(i, "salePersonNumber").getStyleAttributes().setHorizontalAlign(HorizontalAlignment.CENTER);
					kDTable1.getCell(i, "customerNumber").setValue("");
					kDTable1.getCell(i, "materialNumber").setValue("");
				}else if("小计".equals(customerName)){
					kDTable1.getRow(i).getStyleAttributes().setBackground(xj1Color);
					kDTable1.getRow(i).getStyleAttributes().setBold(true);
					kDTable1.getCell(i, "customerNumber").setValue("小计");
					kDTable1.getCell(i, "customerNumber").getStyleAttributes().setHorizontalAlign(HorizontalAlignment.CENTER);
					kDTable1.getCell(i, "materialNumber").setValue("");
				}else if("小计".equals(materialName)){
					kDTable1.getRow(i).getStyleAttributes().setBold(true);
					kDTable1.getRow(i).getStyleAttributes().setBackground(xj2Color);
					kDTable1.getCell(i, "materialNumber").setValue("小计");
					kDTable1.getCell(i, "materialNumber").getStyleAttributes().setHorizontalAlign(HorizontalAlignment.CENTER);
					
					
				}
				
				
			}
			
		} catch (Exception ex) {
			this.handleException(ex);			
		}
	}
}