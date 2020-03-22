/**
 * output package name
 */
package com.kingdee.eas.farm.dayratecost.client;

import java.awt.Component;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectManager;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectListener;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.base.permission.client.longtime.ILongTimeTask;
import com.kingdee.eas.base.permission.client.longtime.LongTimeDialog;
import com.kingdee.eas.base.uiframe.client.UIModelDialog;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.dayratecost.DayrateCalFacadeFactory;
import com.kingdee.eas.farm.dayratecost.DayratecostCalTypeEnum;
import com.kingdee.eas.farm.dayratecost.bean.DayRateCalVerigyBean;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.processbizill.StatementsBillFactory;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class DayRateCalOPUI extends AbstractDayRateCalOPUI
{
    private static final Logger logger = CoreUIObject.getLogger(DayRateCalOPUI.class);
    private JSONObject jo;
    HashMap<String,DayRateCalVerigyBean> result;
    /**
     * output class constructor
     */
    public DayRateCalOPUI() throws Exception
    {
        super();
        this.setUITitle("成本计算");
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * 日成本计算
     */
    protected void btnExeCal_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	if(prmtCompany.getValue()==null) {
    		MsgBox.showWarning("财务组织不能为空！");
    		return;
    	}
    	if(prmtCompany.getValue()==null) {
    		MsgBox.showWarning("会计期间不能为空！");
    		return;
    	}
    	if(cmbCalType.getSelectedIndex()<0) {
    		MsgBox.showWarning("计算类型不能为空！");
    		return;
    	}
    	jo=new JSONObject();
    	jo.put("companyID", ((IObjectValue) this.prmtCompany.getValue()).getString("id"));
    	jo.put("periodID",((IObjectValue) this.prmtPeriod.getValue()).getString("id"));
    	jo.put("calType",((DayratecostCalTypeEnum)this.cmbCalType.getSelectedItem()).getValue() );
    	jo.put("isBeginFirst", true);
    	
    
    	LongTimeDialog dialog = new LongTimeDialog((UIModelDialog) SwingUtilities.getWindowAncestor(this)); 
		dialog.setLongTimeTask(new ILongTimeTask() {
		public Object exec() throws Exception { 
			result=(HashMap<String, DayRateCalVerigyBean>) DayrateCalFacadeFactory.getRemoteInstance().exeCalDayrate(jo.toString());
			return null; 
		} 

		public void afterExec(Object resultObj) throws Exception {
			if(result!=null&&result.size()>0) {
	            fillVerifyMsg(result);
	        	MsgBox.showWarning("日成本计算校验不通过，请查看详细校验信息！");
	        }else{ 
	        	MsgBox.showWarning("日成本计算完成！");
	        }
		} 
		}); 
		Component[] cps=dialog.getContentPane().getComponents(); 
		for(Component cp:cps){ 
			if(cp instanceof JLabel){ 
				((JLabel) cp).setText("成本计算中......."); 
			} 
		} 
		dialog.show(); 
    }
    /**
     * 填充校验信息
     * @param result
     */
    private void fillVerifyMsg(HashMap<String,DayRateCalVerigyBean> result) {
    	this.tbMain.removeRows();
    	this.tbDetail.removeRows();
    	if(result!=null&&result.size()>0) {
    		Iterator iter = result.entrySet().iterator();
    		IRow row;
    		Map.Entry entry;
    		while (iter.hasNext()){
    			entry = (Map.Entry) iter.next();
    			Object key = entry.getKey();
    			DayRateCalVerigyBean val=(DayRateCalVerigyBean) entry.getValue();
    			row=tbMain.addRow();
    			row.getCell("batchID").setValue(val.getBatchID());
    			row.getCell("batchNum").setValue(val.getBatchNum());
    			row.getCell("henhouseID").setValue(val.getHenhouseID());
    			row.getCell("henhouseName").setValue(val.getHenhouseName());
    			row.getCell("farmName").setValue(val.getFarmName());
    		}
    	}
    }
    /**
     * 显示明细
     */
    private void showDetail(int rowIndex) {
    	this.tbDetail.removeRows();
    	if(rowIndex<0) {
    		return;
    	}
    	String key=tbMain.getCell(rowIndex, "batchID").getValue().toString()+"||"+tbMain.getCell(rowIndex, "henhouseID").getValue().toString();
    	if(result.containsKey(key)) {
    		DayRateCalVerigyBean val=result.get(key);
    		IRow row;
    		for(String msg:val.getVeriyMsgs()) {
    			row=tbDetail.addRow();
    			row.getCell("msg").setValue(msg);
    		}
    	}
    }
    
    /**
     * 取消
     */
    protected void btnCancel_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        this.destroyWindow();
    }

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		initControls();
	}

	private void initControls() {
		CompanyF7 cf7=new CompanyF7();
		cf7.setIsCUFilter(true);
		this.prmtCompany.setSelector(cf7);
		this.prmtCompany.setValue(SysContext.getSysContext().getCurrentFIUnit());
		
		this.prmtCompany.setRequired(true);
		this.prmtCompany.setRequired(true);
		
		this.tbMain.getStyleAttributes().setLocked(true);
		this.tbMain.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
		
		this.tbMain.addKDTSelectListener(new KDTSelectListener(){
			public void tableSelectChanged(KDTSelectEvent e) {
				showDetail(e.getSelectBlock().getBeginRow());
			}});
		this.tbDetail.getStyleAttributes().setLocked(true);
		this.tbDetail.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
		
		this.dpBeginDate.setDatePattern("yyyy-MM-dd");
		this.dpEndDate.setDatePattern("yyyy-MM-dd");
		this.dpBeginDate.setEnabled(false);
		this.dpEndDate.setEnabled(false);
		this.prmtPeriod.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				period_chaned();
			}});
	}
	
	private void period_chaned() {
		if(prmtCompany.getValue()!=null&&prmtPeriod.getValue()!=null) {
			 Date[] dr = StockingComm.getDateRangeByPeriod(null, ((IObjectValue) prmtCompany.getValue()).getString("id"), ((IObjectValue)prmtPeriod.getValue()).getString("id"));
			 this.dpBeginDate.setValue(dr[0]);
			 this.dpEndDate.setValue(dr[1]);
		}else{
			this.dpBeginDate.setValue(null);
			this.dpEndDate.setValue(null);
		}
	}
}