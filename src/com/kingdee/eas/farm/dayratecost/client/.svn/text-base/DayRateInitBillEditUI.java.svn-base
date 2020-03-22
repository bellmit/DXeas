/**
 * output package name
 */
package com.kingdee.eas.farm.dayratecost.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.dayratecost.BreedTypeEnum;
import com.kingdee.eas.farm.dayratecost.DayRateBaseSettingInfo;
import com.kingdee.eas.farm.dayratecost.comm.DayrateUtils;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class DayRateInitBillEditUI extends AbstractDayRateInitBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(DayRateInitBillEditUI.class);
    private String curCompanyID;
    private boolean isLoadField=false;
    /**
     * output class constructor
     */
    public DayRateInitBillEditUI() throws Exception
    {
        super();
        this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
    }
    public void loadFields()
    {
    	isLoadField=true;
        super.loadFields();
        isLoadField=false;
		
        if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(true);
		}else if (this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)){
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(false);
		}else {
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(true);
		}
    }
    
    @Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
	}
    
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
    	if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据已经审核，禁止修改！");
    		SysUtil.abort();
    	}
		super.actionEdit_actionPerformed(e);
	}
	
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据已经审核，禁止修改！");
    		SysUtil.abort();
    	}
		super.actionRemove_actionPerformed(e);
	}
	/**
     * output actionAudit_actionPerformed
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据已经审核，禁止再次审核！");
    		SysUtil.abort();
    	}
    	if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)) {
    		MsgBox.showWarning("单据尚未提交，禁止审核！");
    		SysUtil.abort();
    	}
		super.actionAudit_actionPerformed(e);
		
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
    }
    /**
     * output actionUnAudit_actionPerformed
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据尚未审核，禁止反审核！");
    		SysUtil.abort();
    	}
		super.actionUnAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
    }
    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.dayratecost.DayRateInitBillFactory.getRemoteInstance();
    }

    /**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
		
        return null;
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.dayratecost.DayRateInitBillInfo objectValue = new com.kingdee.eas.farm.dayratecost.DayRateInitBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new Date());
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        return objectValue;
    }
    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
	     DayRateBaseSettingInfo bdInfo = DayrateUtils.getBaseSetting(null, curCompanyID);
	     if(bdInfo==null) {
	    	 MsgBox.showWarning("请先进行系统设置！");
	    	 SysUtil.abort();
	     }
        if(bdInfo.isIsInit()) {
        	this.chkisInit.setVisible(false);
        }
		super.onLoad();
		initControl();
	}
    
	private void initControl() {
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		
		CompanyF7 cf7=new CompanyF7();
		cf7.setIsCUFilter(true);
		this.prmtcompany.setSelector(cf7);
		
		prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setFilter();
			}});
		
		prmtstockingFarmer.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				setStockingFilter();
			}});
		prmtstockingFarm.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				setStockingFilter();
			}});
		prmtstockingHouse.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				setStockingFilter();
			}});
		prmtstockingBatch.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				setStockingFilter();
			}});
	}
	
	private void setFilter() {
		if(prmtcompany.getValue()==null) {
			curCompanyID="";
		}else{
			curCompanyID=((IPropertyContainer) prmtcompany.getValue()).getString("id");
		}
		setStockingFilter();
	}
	
	/**
	 * 设置过滤条件
	 * @param companyID
	 */
	private void setStockingFilter() {
		StockingClientComm.setFarmerFilter(prmtstockingFarmer, curCompanyID,false);
		String farmerID=null,farmID=null;
		if(prmtstockingFarmer.getValue()!=null) {
			farmerID=((IPropertyContainer) prmtstockingFarmer.getValue()).getString("id");
		}
		if(prmtstockingFarm.getValue()!=null) {
			farmID=((IPropertyContainer) prmtstockingFarm.getValue()).getString("id");
		}
		//养殖场过滤
		StockingClientComm.setFarmFilter(this.prmtstockingFarm, curCompanyID, farmerID);
		//棚舍过滤
		setStockingHouseFilter();
		//批次过滤
		StockingClientComm.setStockingBatchFilter(prmtstockingBatch, curCompanyID, farmerID, farmID);
	}
	
	private void setStockingHouseFilter() {
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		String batchID=null,farmID=null;
		if(prmtstockingBatch.getValue()!=null) {
			batchID=((IPropertyContainer) prmtstockingBatch.getValue()).getString("id");
		}
		if(this.prmtstockingFarm.getValue()!=null) {
			farmID=((IPropertyContainer) this.prmtstockingFarm.getValue()).getString("id");
		}
		
		//未完全出栏
		HashSet set=StockingClientComm.getAllOutHouseIDsByBatchID(curCompanyID,batchID,farmID,false);
		if(set.size()>0) {
			filter.getFilterItems().add(new FilterItemInfo("id",set,CompareType.INCLUDE));
		}
		
		ev.setFilter(filter);
		this.prmtstockingHouse.setEntityViewInfo(ev);
	}
	
    
	@Override
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		super.beforeStoreFields(arg0);
		
	}
	@Override
	public void txtbeginBreedQty_Changed() throws Exception {
		// TODO Auto-generated method stub
		super.txtbeginBreedQty_Changed();
		BigDecimal beginQty = txtbeginBreedQty.getBigDecimalValue();
		BigDecimal beginUnit;
		for(int rowIndex=0;rowIndex<kdtEntrys.getRowCount();rowIndex++) {
			if(beginQty==null||beginQty.signum()<=0) {
				kdtEntrys.getCell(rowIndex, "beginUnitCost").setValue(BigDecimal.ZERO);
			}
			beginUnit=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex,"beginCost").getValue());
			kdtEntrys.getCell(rowIndex, "beginUnitCost").setValue(beginUnit.divide(beginQty,4,BigDecimal.ROUND_HALF_UP));
		}
		
	}
	@Override
	public void txtoccurBreedQty_Changed() throws Exception {
		// TODO Auto-generated method stub
		super.txtoccurBreedQty_Changed();
		
	}
	@Override
	public void txtendBreedQty_Changed() throws Exception {
		// TODO Auto-generated method stub
		super.txtendBreedQty_Changed();
		BigDecimal endQty = txtendBreedQty.getBigDecimalValue();
		BigDecimal endUnit;
		for(int rowIndex=0;rowIndex<kdtEntrys.getRowCount();rowIndex++) {
			if(endQty==null||endQty.signum()<=0) {
				kdtEntrys.getCell(rowIndex, "endUnitCost").setValue(BigDecimal.ZERO);
			}
			endUnit=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex,"endCost").getValue());
			kdtEntrys.getCell(rowIndex, "endUnitCost").setValue(endUnit.divide(endQty,4,BigDecimal.ROUND_HALF_UP));
		}
	}
	@Override
	protected void applyDefaultValue(IObjectValue vo) {
		// TODO Auto-generated method stub
		super.applyDefaultValue(vo);
		vo.put("billStatus", BillBaseStatusEnum.ADD_VALUE);
	}
	
}