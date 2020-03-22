/**
 * output package name
 */
package com.kingdee.eas.farm.food.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.KDWorkButton;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.StorageBizUnitF7;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.breed.HenhouseType;
import com.kingdee.eas.farm.food.ChickenDailyCarCassEntryInfo;
import com.kingdee.eas.farm.food.comm.FarmCommUtils;
import com.kingdee.eas.framework.AbstractCoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.client.UITools;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class ChickenDailyEditUI extends AbstractChickenDailyEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(ChickenDailyEditUI.class);
    
    /**
     * output class constructor
     */
    public ChickenDailyEditUI() throws Exception
    {
        super();
        this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
//        initControl();
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields(); 
        if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			this.mBtnAudit.setEnabled(false);
			this.mBtnUnAudit.setEnabled(true);
			this.tBtnAudit.setEnabled(false);
			this.tBtnUnAudit.setEnabled(true);
		}else if (this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)){
			this.mBtnAudit.setEnabled(true);
			this.mBtnUnAudit.setEnabled(false);
			this.tBtnAudit.setEnabled(true);
			this.tBtnUnAudit.setEnabled(false);
		}else {
			this.mBtnAudit.setEnabled(false);
			this.mBtnUnAudit.setEnabled(false);
			this.tBtnAudit.setEnabled(false);
			this.tBtnUnAudit.setEnabled(false);
		}
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
    	if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据已经审核，禁止修改！");
    		SysUtil.abort();
    	}
		super.actionEdit_actionPerformed(e);
	}
	
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
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
    	if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据已经审核，禁止再次审核！");
    		SysUtil.abort();
    	}
    	if(!FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.SUBMITED)) {
    		MsgBox.showWarning("单据尚未提交，禁止审核！");
    		SysUtil.abort();
    	}
		super.actionAudit_actionPerformed(e);
		this.editData.setBillStatus(BillBaseStatusEnum.AUDITED);
		//this.setDataObject(this.getBizInterface().getValue(new ObjectUuidPK(this.editData.getId())));
		this.loadData();
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
    	if(!FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据尚未审核，禁止反审核！");
    		SysUtil.abort();
    	}
		super.actionUnAudit_actionPerformed(e);
		//this.setDataObject(this.editData);
		this.editData.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		this.loadData();
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
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
        com.kingdee.eas.farm.food.ChickenDailyInfo objectValue = new com.kingdee.eas.farm.food.ChickenDailyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompanyOrgUnit(SysContext.getSysContext().getCurrentFIUnit());
        StorageOrgUnitInfo so = SysContext.getSysContext().getCurrentStorageUnit();
        if(so.isIsBizUnit()) {
        	objectValue.setStorageOrgUnit(so);
        }
        Date currDate = new java.util.Date();
        objectValue.setBizDate(currDate);
        objectValue.setReportDate(currDate);
        objectValue.setFIBizDate(currDate);
        /*for(int num=900;num<2600;) {
        	ChickenDailyCarCassEntryInfo entryInfo=new ChickenDailyCarCassEntryInfo();
        	entryInfo.setWeight(num+"g--"+(num+100)+"g");
        	num+=100;
			objectValue.getCarCassEntry().add(entryInfo);
        }*/
        
        return objectValue;
    }
    
   
	@Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		super.onShow();
		initControl();
	}
	private void initControl() throws Exception{
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		
		StorageBizUnitF7 storageF7 = new StorageBizUnitF7();
		storageF7.setIsCUFilter(true);
		this.prmtStorageOrgUnit.setSelector(storageF7);
		
		this.prmtStorageOrgUnit.setEnabled(false);
		this.prmtcompanyOrgUnit.setEnabled(false);
		
		StorageBizUnitF7 storageF72 = new StorageBizUnitF7();
		storageF72.setIsShowSub(true);
		this.prmtfarm.setSelector(storageF72);
		
		this.prmtfarm.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				farmChanged(e);
			}});
		
//		this.kdtCarCassEntry.checkParsed();
		KDWorkButton getPo=new KDWorkButton();
		getPo.setName("getPO");
		getPo.setText("获取重量范围");
		getPo.setSize(85,19);
		getPo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setCarCassEntry();
			}});
		UITools.addDetailButton(getPo, this.kdtCarCassEntry);
    }

    private void setCarCassEntry() {
    	
    	IRow lowrow=this.kdtCarCassEntry.addRow();
    	lowrow.getCell("weight").setValue("900g以下");
    	for(int num=900;num<2600;) {
			IRow row=this.kdtCarCassEntry.addRow();
			row.getCell("weight").setValue(num+"g--"+(num+100)+"g");
        	num+=100;
        }
    	IRow row=this.kdtCarCassEntry.addRow();
		row.getCell("weight").setValue("2600g以上");
    }
    
    private void farmChanged(DataChangeEvent e) {
    	KDBizPromptBox prmtHenHouse = (KDBizPromptBox) kdtBodyEntry.getColumn("henHouse").getEditor().getComponent();
    	if(e.getNewValue()==null){
    		prmtHenHouse.setEntityViewInfo(null);
    	}else {
    		EntityViewInfo ev=new EntityViewInfo();
    		FilterInfo filter=new FilterInfo();
    		filter.getFilterItems().add(new FilterItemInfo("chickenFarm.name",((IPropertyContainer) prmtfarm.getValue()).getString("name"),CompareType.EQUALS));
			ev.setFilter(filter);
			prmtHenHouse.setEntityViewInfo(ev);
    	}
    }
    
    
    @Override
	protected void verifyInput(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.verifyInput(e);
		if(this.pkBizDate.getValue()==null) {
			MsgBox.showWarning("业务日期不能为空！");
			SysUtil.abort();
		}
		if(this.prmtfarm.getValue()==null) {
			MsgBox.showWarning("养殖场不能为空！");
			SysUtil.abort();
		}
		java.util.Date date=(Date) this.pkBizDate.getValue();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		date=sdf.parse(sdf.format(date));
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("bizDate",date,CompareType.GREATER_EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("bizDate",cal.getTime(),CompareType.LESS));
		filter.getFilterItems().add(new FilterItemInfo("farm.id",((AbstractCoreBaseInfo) this.prmtfarm.getValue()).getId().toString(),CompareType.EQUALS));
		if(!this.oprtState.equalsIgnoreCase("addnew")) {
			filter.getFilterItems().add(new FilterItemInfo("id",this.editData.getId().toString(),CompareType.NOTEQUALS));
		}
		ev.setFilter(filter);
		CoreBaseCollection coll = getBizInterface().getCollection(ev);
		if(coll!=null&&coll.size()>0) {
			MsgBox.showWarning("当前业务日期已经存在单据！");
			SysUtil.abort();
		}
	}
    /**
     * 养殖场选中后 设置 鸡舍过滤条件
     */
	@Override
	protected void prmtfarm_dataChanged(DataChangeEvent e) throws Exception {
		StorageOrgUnitInfo orgInfo = (StorageOrgUnitInfo) this.prmtfarm.getValue();
    	
    	// 更新各个分录中仓库的 过滤条件
    	 // 仓库添加过滤条件
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filterInfo = new FilterInfo();
//		CtrlUnitInfo cuInfo = SysContext.getSysContext().getCurrentCtrlUnit();
		if(orgInfo != null){
			filterInfo.getFilterItems().add(new FilterItemInfo("chickenFarm.id",orgInfo.getId().toString(),CompareType.EQUALS));
		}else{
			filterInfo.getFilterItems().add(new FilterItemInfo("chickenFarm.id","",CompareType.EQUALS));
		}
		filterInfo.getFilterItems().add(new FilterItemInfo("houseType",HenhouseType.CC.getValue(),CompareType.EQUALS));
//		filterInfo.getFilterItems().add(new FilterItemInfo("name","%鸡舍%",CompareType.LIKE));
		view.setFilter(filterInfo);
		
		final KDBizPromptBox kdtEntrys_henhouse_PromptBox = new KDBizPromptBox();
        kdtEntrys_henhouse_PromptBox.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
        kdtEntrys_henhouse_PromptBox.setVisible(true);
        kdtEntrys_henhouse_PromptBox.setEditable(true);
        kdtEntrys_henhouse_PromptBox.setDisplayFormat("$number$");
        kdtEntrys_henhouse_PromptBox.setEditFormat("$number$");
        kdtEntrys_henhouse_PromptBox.setCommitFormat("$number$");
        kdtEntrys_henhouse_PromptBox.setEntityViewInfo(view);
        KDTDefaultCellEditor kdtEntrys_henhouse_CellEditor = new KDTDefaultCellEditor(kdtEntrys_henhouse_PromptBox);
        // 饲喂信息
        this.kdtBodyEntry.getColumn("henHouse").setEditor(kdtEntrys_henhouse_CellEditor);
	}
    
    
    
    
}