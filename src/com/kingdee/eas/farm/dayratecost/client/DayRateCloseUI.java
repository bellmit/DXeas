/**
 * output package name
 */
package com.kingdee.eas.farm.dayratecost.client;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.dayratecost.DayrateCalFacadeFactory;
import com.kingdee.eas.farm.dayratecost.comm.DayrateUtils;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.util.PropertyContainer;

/**
 * output class name
 */
public class DayRateCloseUI extends AbstractDayRateCloseUI
{
    private static final Logger logger = CoreUIObject.getLogger(DayRateCloseUI.class);
    
    /**
     * output class constructor
     */
    public DayRateCloseUI() throws Exception
    {
        super();
        this.setUITitle("养殖成本结账");
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output btnExe_actionPerformed method
     */
    protected void btnExe_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	if(prmtCompany.getValue()==null) {
    		MsgBox.showWarning("财务组织不能为空！");
    		SysUtil.abort();
    	}
    	if(prmtCurPeriod.getValue()==null) {
    		MsgBox.showWarning("当前财务期间为空，请确定系统是否已经完成初始化！");
    		SysUtil.abort();
    	}
    	if(!chkBreedDayRateCost.isSelected()&&!chkEggActualCost.isSelected()) {
    		MsgBox.showWarning("需要选择至少一种结账类型！");
    		SysUtil.abort();
    	}
    	
    	if(MsgBox.showConfirm2("确定执行结账操作？")==MsgBox.YES) {
	    	DayrateCalFacadeFactory.getRemoteInstance().exeClose(((PropertyContainer) prmtCompany.getValue()).getString("id"), ((PropertyContainer) prmtCurPeriod.getValue()).getString("id"));
	    	company_changed();
	    	MsgBox.showInfo("结账完成");
    	}
    }

    /**
     * output btnUnExe_actionPerformed method
     */
    protected void btnUnExe_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	if(prmtCompany.getValue()==null) {
    		MsgBox.showWarning("财务组织不能为空！");
    		SysUtil.abort();
    	}
    	if(prmtCurPeriod.getValue()==null) {
    		MsgBox.showWarning("当前财务期间为空，请确定系统是否已经完成初始化！");
    		SysUtil.abort();
    	}
    	if(!chkBreedDayRateCost.isSelected()&&!chkEggActualCost.isSelected()) {
    		MsgBox.showWarning("需要选择至少一种结账类型！");
    		SysUtil.abort();
    	}
    	if(MsgBox.showConfirm2("确定执行反结账操作？")==MsgBox.YES) {
	    	DayrateCalFacadeFactory.getRemoteInstance().exeUnClose(((PropertyContainer) prmtCompany.getValue()).getString("id"), ((PropertyContainer) prmtCurPeriod.getValue()).getString("id"));
	    	company_changed();
	    	MsgBox.showInfo("反结账完成");
    	}
    }

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		CompanyF7 cf7=new CompanyF7();
		cf7.setIsCUFilter(true);
		prmtCompany.setSelector(cf7);
		
		this.prmtCurPeriod.setEnabled(false);
		
		this.prmtCompany.setValue(SysContext.getSysContext().getCurrentFIUnit());
		
		prmtCompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				company_changed();
			}});
		
		company_changed();
	}
    
	private void company_changed() {
		if(prmtCompany.getValue()==null){
			prmtCurPeriod.setValue(null);
			return;
		}
		this.prmtCurPeriod.setValue(DayrateUtils.getCurrentPeriod(null, ((PropertyContainer) prmtCompany.getValue()).getString("id")));
	}
    

}