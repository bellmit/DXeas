/**
 * output package name
 */
package com.kingdee.eas.farm.feedfactory.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.EventListener;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;

/**
 * output class name
 */
public class FeedBusinessDailyEditUI extends AbstractFeedBusinessDailyEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(FeedBusinessDailyEditUI.class);
    
    /**
     * output class constructor
     */
    public FeedBusinessDailyEditUI() throws Exception
    {
        super();
    }
    
    /**
     * 界面初始化 
     */
    @Override
	public void onLoad() throws Exception {
		super.onLoad();
		// 设置全屏
//		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
		
		
		
		if(this.getOprtState().equals("ADDNEW")){
			this.baseStatus.setSelectedIndex(1);
			StorageOrgUnitInfo stoOrg = SysContext.getSysContext().getCurrentStorageUnit();
			if(stoOrg != null ){
				String stoName = stoOrg.getName();
				if(stoName == null || stoName.indexOf("饲料") < 0){
					
					MsgBox.showInfo("饲料场经营日报只能在饲料场填报，请切换组织到饲料场");
				}
			}else{
				MsgBox.showInfo("饲料场经营日报只能在饲料场填报，请切换组织到饲料场");
			}
		}else {
			if(this.getOprtState().equals("EDIT")){
				checkCanEdit();
				
			}
			
		}
		
		
        
        // 
        this.baseStatus.setEnabled(false);
        this.baseStatus.setEditable(false);
        this.pkauditTime.setEditable(false);
        this.pkauditTime.setEnabled(false);
        
        
       
	}
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    
    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.feedfactory.FeedBusinessDailyFactory.getRemoteInstance();
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
        com.kingdee.eas.farm.feedfactory.FeedBusinessDailyInfo objectValue = new com.kingdee.eas.farm.feedfactory.FeedBusinessDailyInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBaseStatus(BillBaseStatusEnum.ADD);
        Date nowDate = new Date();
        objectValue.setBizDate(nowDate);
        
        objectValue.setStoOrg(SysContext.getSysContext().getCurrentStorageUnit());
        return objectValue;
    }

    /**
     * 设置默认值output applyDefaultValue method
     */
    protected void applyDefaultValue(IObjectValue vo) {        
		vo.put("baseStatus",new Integer(0));
        vo.put("bizDate", new Date());
        vo.put("stoOrg", SysContext.getSysContext().getCurrentStorageUnit());
       
    }
    
    /**
     * 校验当前组织是否是单据创建组织，如果不是，提示消息中断操作
     */
    private void checkCanEdit(){
    	StorageOrgUnitInfo cu = SysContext.getSysContext().getCurrentStorageUnit();
		CtrlUnitInfo billCU = this.editData.getCU();
		
		if(billCU != null){
			if(!cu.getId().toString().equals(billCU.getId().toString())){
				MsgBox.showWarning("当前组织不是单据创建组织，不能修改单据");
				SysUtil.abort();
			}
		}
    }
    
    @Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		BigDecimal elecQty = this.txtelecQty.getBigDecimalValue();
		if(elecQty != null && elecQty.compareTo(new BigDecimal(0)) < 0){
			MsgBox.showInfo("用电数不能小于0");
			SysUtil.abort();
		}
		
		super.actionSubmit_actionPerformed(e);
		reloadData();
	}
	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
		reloadData();
	}
    
    /**
     * 审核
     */
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		if(this.editData == null || this.editData.getId() == null || !this.editData.getBaseStatus().equals(BillBaseStatusEnum.SUBMITED)){
			MsgBox.showWarning("不能审核未提交的单据");
			SysUtil.abort();
		}
		try{
			super.actionAudit_actionPerformed(e);
			MsgBox.showWarning("审核完成");
			reloadData();
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
	}
	
	/**
     * 重载单据内容
     * @throws Exception 
     * @throws BOSException 
     * @throws EASBizException 
     */
	private void reloadData() throws EASBizException, BOSException, Exception{
		
		if ((this.editData == null) || (this.editData.getId() == null)) {
			return;
		}
		IObjectPK pk = new ObjectUuidPK(this.editData.getId());
		setDataObject(getValue(pk));
		EventListener[] lsts = removeDetailTableListener(KDTPropertyChangeListener.class);
		loadFields();
		restoreDetailTableListener(KDTPropertyChangeListener.class, lsts);
		initOldData(this.editData);
		setSave(true);
		setSaved(true);
		// 中断
		SysUtil.abort();
			
			
		
	}
	/**
	 * 反审核
	 */
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		if(this.editData == null || this.editData.getId() == null || !this.editData.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)){
			MsgBox.showWarning("只能反审核处于审核状态的批次");
			SysUtil.abort();
		}
		try{
			super.actionUnAudit_actionPerformed(e);
			MsgBox.showWarning("反审核完成");
			reloadData();
		}catch(BOSException bose){
			MsgBox.showError(bose.getMessage());
			SysUtil.abort();
		}
	}

	@Override
	protected void txtelecBegin_dataChanged(DataChangeEvent e) throws Exception {
		updateElecQty();
	}

	@Override
	protected void txtelecEnd_dataChanged(DataChangeEvent e) throws Exception {
		updateElecQty();
	}

	public void updateElecQty(){
		// 起始数
    	BigDecimal elecBegin = this.txtelecBegin.getBigDecimalValue();
    	elecBegin = (elecBegin == null ?new BigDecimal(0):elecBegin);
		
		// 死终止数
    	BigDecimal elecEnd = this.txtelecEnd.getBigDecimalValue();
    	elecEnd = (elecEnd == null ?new BigDecimal(0):elecEnd);
    	
    	BigDecimal elecQty = (elecEnd.subtract(elecBegin)).multiply(new BigDecimal(4000));
    	
    	this.txtelecQty.setValue(elecQty);
	}
}