/**
 * output package name
 */
package com.kingdee.eas.custom.salepayment.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.EventListener;

import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.DecimalFormatEx;
import com.kingdee.bos.ctrl.swing.NumberFormatterEx;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.framework.TreeBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class MaterialStandardCostEditUI extends AbstractMaterialStandardCostEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(MaterialStandardCostEditUI.class);
    
    /**
     * output class constructor
     */
    public MaterialStandardCostEditUI() throws Exception
    {
        super();
        
        DecimalFormatEx dfEx = new DecimalFormatEx("##");
        NumberFormatterEx formatter = new NumberFormatterEx();
        formatter.setFormat(dfEx);
        this.txtyear.setDisplayFormatter(formatter);
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
        return com.kingdee.eas.custom.salepayment.MaterialStandardCostFactory.getRemoteInstance();
    }

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject) 
    {
        super.setDataObject(dataObject);
        if(STATUS_ADDNEW.equals(getOprtState())) {
            editData.put("treeid",(com.kingdee.eas.custom.salepayment.MaterialStandardCostTreeInfo)getUIContext().get(UIContext.PARENTNODE));
            String treeName = this.editData.getTreeid().getName();
            if(StringUtils.isNotBlank(treeName)){
            	int year = Integer.parseInt(treeName);
            	editData.put("year", year);
            }
            
        }
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.salepayment.MaterialStandardCostInfo objectValue = new com.kingdee.eas.custom.salepayment.MaterialStandardCostInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        
        objectValue.setBaseStatus(BillBaseStatusEnum.ADD);
        return objectValue;
    }
    /**
     * 界面初始化
     */
    @Override
	public void onLoad() throws Exception {
		super.onLoad();
		// 设置全屏
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		// 年 编辑控件	
//        this.txtyear.setHorizontalAlignment(2);		
//        this.txtyear.setDataType(0);		
//        this.txtyear.setSupportedEmpty(true);		
//        this.txtyear.setRequired(true);		
//        this.txtyear.setEnabled(false);
//        this.txtyear.getFormatter();
        
//        txtyear.getFormatterFactory();
//        JFormattedTextField.AbstractFormatter displayFormat = this.txtyear.getDispalyFormatter();
        
        
		final KDBizPromptBox kdtCostDetailEntry_material_PromptBox = new KDBizPromptBox();
        kdtCostDetailEntry_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
        kdtCostDetailEntry_material_PromptBox.setVisible(true);
        kdtCostDetailEntry_material_PromptBox.setEditable(true);
        kdtCostDetailEntry_material_PromptBox.setDisplayFormat("$number$");
        kdtCostDetailEntry_material_PromptBox.setEditFormat("$number$");
        kdtCostDetailEntry_material_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtCostDetailEntry_material_CellEditor = new KDTDefaultCellEditor(kdtCostDetailEntry_material_PromptBox);
        this.kdtCostDetailEntry.getColumn("material").setEditor(kdtCostDetailEntry_material_CellEditor);
        ObjectValueRender kdtCostDetailEntry_material_OVR = new ObjectValueRender();
        kdtCostDetailEntry_material_OVR.setFormat(new BizDataFormat("$number$"));
        this.kdtCostDetailEntry.getColumn("material").setRenderer(kdtCostDetailEntry_material_OVR);
        
//        DefaultFormatterFactory formatFac = new DefaultFormatterFactory();
//        NumberFormatter nf = new NumberFormatter();
//        this.txtyear.getFormatter().
//        this.txtyear.setDisplayFormatter()
		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
//		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		
	}
   
	/**
	 * 校验年格式
	 */
	public void checkYear(){
		int year = this.txtyear.getIntegerValue();
		if(year < 2016 || year > 2030){
			MsgBox.showInfo("请输入2016 到 2030 及以后的合法年份");
			SysUtil.abort();
		}
	}
	/**
	 * 校验单据年是否与 分类中的编码名称一致
	 */
	public void checkDataTree(TreeBaseInfo treeInfo,int year){
//		String number = treeInfo.getNumber();
//		String name = treeInfo.getName();
//		
//		String yearStr = Integer.toString(year);
//		if(!yearStr.equals(number) || !yearStr.equals(name)){
//			MsgBox.showInfo("单据年份与年份分组不一致不能保存");
//			SysUtil.abort();
//		}
	}

	
	/**
	 * 禁用操作
	 */
	@Override
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionCancel_actionPerformed(e);
	}
	/**
	 * 启用
	 */
	@Override
	public void actionCancelCancel_actionPerformed(ActionEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		super.actionCancelCancel_actionPerformed(e);
	}

	/**
	 * 
	 */
	@Override
	protected void initDataStatus() {
		super.initDataStatus();
		// 启用禁用    可见
		this.actionCancel.setVisible(true);
		this.actionCancelCancel.setVisible(true);

		
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
			MsgBox.showWarning("只能反审核处于审核状态的单据");
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
	
	/**
	 * 提交前校验
	 */
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		if(this.baseStatus.getSelectedItem() == null || 
				BillBaseStatusEnum.NULL.equals(this.baseStatus.getSelectedItem()) || 
				BillBaseStatusEnum.ADD.equals(this.baseStatus.getSelectedItem()) || 
				BillBaseStatusEnum.TEMPORARILYSAVED.equals(this.baseStatus.getSelectedItem()) ||
				BillBaseStatusEnum.SUBMITED.equals(this.baseStatus.getSelectedItem()) ){
		
				super.actionSubmit_actionPerformed(e);
				
			
			
			
		}else{
			MsgBox.showWarning("只能提交未审核的单据");
			SysUtil.abort();
		}
	}
}