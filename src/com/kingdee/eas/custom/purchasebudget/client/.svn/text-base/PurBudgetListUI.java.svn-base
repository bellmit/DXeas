/**
 * output package name
 */
package com.kingdee.eas.custom.purchasebudget.client;

import java.awt.event.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.custom.commld.fileUtils.excelUtils;
import com.kingdee.eas.custom.purchasebudget.PurBudgetFactory;
import com.kingdee.eas.custom.purchasebudget.PurBudgetInfo;
import com.kingdee.eas.custom.purchasebudget.purBudgetFacadeFactory;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.tools.datatask.DIETemplateInfo;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class PurBudgetListUI extends AbstractPurBudgetListUI
{
	private static final Logger logger = CoreUIObject.getLogger(PurBudgetListUI.class);

	/**
	 * output class constructor
	 */
	public PurBudgetListUI() throws Exception
	{
		super();
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
		return com.kingdee.eas.custom.purchasebudget.PurBudgetFactory.getRemoteInstance();
	}

	@Override
	public void actionImportFormExcel_actionPerformed(ActionEvent e)
	throws Exception {
		//		String UIName="com.kingdee.eas.tools.datatask.client.DioMainUI";
		//		Map map = new UIContext(this);
		//		map.put("srcName","采购预算");
		//		IUIWindow uiWindow = null ;
		//		uiWindow = UIFactory.createUIFactory(UIFactoryName.EDITWIN).create(UIName, map, null,OprtState.VIEW);
		//		//开始展现UI
		//		uiWindow.show();
		//		super.actionImportFormExcel_actionPerformed(e);

		String filePath=excelUtils.selectFile(this);
		String fileType = excelUtils.checkFileType(filePath,"excel");
		String templateNumber="purBuget";
		String templateName="采购预算";
		Object templateObjectInfo = excelUtils.getTemplatePropCol(templateNumber,templateName);
		DIETemplateInfo templateInfo = null;
		if(templateObjectInfo!=null)
			templateInfo=(DIETemplateInfo)templateObjectInfo;
		else
			commUtils.giveUserTipsAndRetire("模板不存在", "showWarning");
		int propCol =templateInfo.getFieldEntries().size();
		HashMap<Object,Object> queryResult=excelUtils.readExcelFile(fileType,propCol,filePath);
		String returnStr = purBudgetFacadeFactory.getRemoteInstance().createPurBudgetInfo(templateInfo, queryResult);
		if(!returnStr.equals("true"))
			commUtils.giveUserTipsAndRetire(returnStr, "showInfo");
		else
			MsgBox.showInfo("导入成功");
		
		refreshList();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.purchasebudget.PurBudgetInfo objectValue = new com.kingdee.eas.custom.purchasebudget.PurBudgetInfo();

		return objectValue;
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		/*
    	_______________#########_______________________
    	______________############_____________________
    	______________#############____________________
    	_____________##__###########___________________
    	____________###__######_#####__________________
    	____________###_#######___####_________________
    	___________###__##########_####________________
    	__________####__###########_####_______________
    	________#####___###########__#####_____________
    	_______######___###_########___#####___________
    	_______#####___###___########___######_________
    	______######___###__###########___######_______
    	_____######___####_##############__######______
    	____#######__#####################_#######_____
    	____#######__##############################____
    	___#######__######_#################_#######___
    	___#######__######_######_#########___######___
    	___#######____##__######___######_____######___
    	___#######________######____#####_____#####____
    	____######________#####_____#####_____####_____
    	_____#####________####______#####_____###______
    	______#####______;###________###______#________
    	________##_______####________####______________
    	                           葱官赐福                                    百无禁忌                
		 */
		super.onLoad();
		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
	}

	@Override
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.getSelectedKeyValue()==null){
			MsgBox.showInfo("请选择记录行");
			SysUtil.abort();
		}
		String ID = this.getSelectedKeyValue();
		PurBudgetInfo info = PurBudgetFactory.getRemoteInstance().getPurBudgetInfo(new ObjectUuidPK(ID));
		if(info.getId()!=null)
			if(ClientUtils.checkBillInWorkflow(this, info.getId().toString())){
				MsgBox.showInfo("当前单据正处于工作流中，请稍后再试");
				SysUtil.abort();
			}
		super.actionRemove_actionPerformed(e);
	}

	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.getSelectedKeyValue()==null){
			MsgBox.showInfo("请选择记录行");
			SysUtil.abort();
		}
		super.actionAudit_actionPerformed(e);
		refreshList();
		setMessageText("审核成功");
		showMessage();
	}

	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.getSelectedKeyValue()==null){
			MsgBox.showInfo("请选择记录行");
			SysUtil.abort();
		}
		super.actionUnAudit_actionPerformed(e);
		refreshList();
		setMessageText("审核成功");
		showMessage();
	}

}