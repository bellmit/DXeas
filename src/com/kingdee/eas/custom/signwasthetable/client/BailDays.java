/**
 * output package name
 */
package com.kingdee.eas.custom.signwasthetable.client;

import java.awt.Color;
import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.analysis.report.UIContext;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.custom.signwasthetable.ContractFactory;
import com.kingdee.eas.custom.signwasthetable.ContractInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class BailDays extends AbstractBailDays
{
    private static final Logger logger = CoreUIObject.getLogger(BailDays.class);
    
    /**
     * output class constructor
     */
    public BailDays() throws Exception
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
     * 确定按钮的鼠标点击事件
     */
    protected void confirm_mouseClicke(java.awt.event.MouseEvent e) throws Exception
    {
    	//取得来源单据的id，根据id获得当前合同版本的id和上一版本的id
		String id = (String) this.getUIContext().get("ID");
		if(id==null)
			this.uiWindow.close();
		ContractInfo info=ContractFactory.getRemoteInstance().getContractInfo(new ObjectUuidPK(id));//获得来源合同的info
		
		//设置值的校验
		if(this.datePicker.getValue()==null)
		{
			MsgBox.showInfo("验收日期为空");
			SysUtil.abort();
		}
		if(this.txtDays.getStringValue()==null)
		{
			MsgBox.showInfo("保证金天数为空");
			SysUtil.abort();
		}
		
		//满足条件的情况下  修改合同签呈的保证金天数   和  验收日期
		info.setBailAmtDays(this.txtDays.getIntegerValue());
		info.setCheckBeforeAcceptance(this.datePicker.getSqlDate());
		ContractFactory.getRemoteInstance().save(info);
		MsgBox.showInfo("设置保证金天数后，你可能需要在当前合同点击刷新按钮以查看更新");
		
		//关闭窗口
		this.uiWindow.close();
        super.confirm_mouseClicke(e);
    }



    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		//设置必录项
		this.txtDays.setValue(null);
		this.txtDays.setRequired(true);
		this.txtDays.setBackground(Color.yellow);
		this.datePicker.setRequired(true);
		this.datePicker.setBackground(Color.yellow);
		
		
		confirm.addKeyListener(new KeyAdapter()//设置enter事件  确定
		{
			public void keyPressed(KeyEvent e)
			{

				if(e.getKeyText(e.getKeyCode()).compareToIgnoreCase("Enter")==0)
				{
					confirm.doClick();
				}
			}
		});
		cancel.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyText(e.getKeyCode()).compareToIgnoreCase("Enter")==0)
					cancel.doClick();
			}
		});
		
		
	}
    
    /**焦点在取消按钮上，用户按Enter键后的操作：关闭当前窗口*/
    @Override
	protected void cancel_keyPresse(KeyEvent e) throws Exception {
		// TODO Auto-generated method stub
    	this.uiWindow.close();
		super.cancel_keyPresse(e);
	}

	/**焦点在  确定按钮上，用户按下Enter时的操作*/
	@Override
	protected void confirm_keyPresse(KeyEvent e) throws Exception {
		// TODO Auto-generated method stub
    	//取得来源单据的id，根据id获得当前合同版本的id
		String id = (String) this.getUIContext().get("ID");
		if(id==null)
			this.uiWindow.close();
		ContractInfo info=ContractFactory.getRemoteInstance().getContractInfo(new ObjectUuidPK(id));
		if(this.datePicker.getValue()==null)
		{
			MsgBox.showInfo("验收日期为空");
			SysUtil.abort();
		}
		if(this.txtDays.getStringValue()==null)
		{
			MsgBox.showInfo("保证金天数为空");
			SysUtil.abort();
		}
		info.setBailAmtDays(this.txtDays.getIntegerValue());
		info.setCheckBeforeAcceptance(this.datePicker.getSqlDate());
		ContractFactory.getRemoteInstance().save(info);
		MsgBox.showInfo("设置保证金天数后，你可能需要在当前合同点击刷新按钮");
		this.uiWindow.close();
		super.confirm_keyPresse(e);
	}

	/**
     * output actionPageSetup_actionPerformed
     */
    public void actionPageSetup_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPageSetup_actionPerformed(e);
    }
    /**点击取消按钮的操作*/
    @Override
	protected void cancel_mouseClicke(MouseEvent e) throws Exception {
		// TODO Auto-generated method stub
    	this.uiWindow.close();//关闭窗口
		super.cancel_mouseClicke(e);
	}

	/**
     * output actionExitCurrent_actionPerformed
     */
    public void actionExitCurrent_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExitCurrent_actionPerformed(e);
    }

    /**
     * output actionHelp_actionPerformed
     */
    public void actionHelp_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHelp_actionPerformed(e);
    }

    /**
     * output actionAbout_actionPerformed
     */
    public void actionAbout_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAbout_actionPerformed(e);
    }

    /**
     * output actionOnLoad_actionPerformed
     */
    public void actionOnLoad_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionOnLoad_actionPerformed(e);
    }

    /**
     * output actionSendMessage_actionPerformed
     */
    public void actionSendMessage_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendMessage_actionPerformed(e);
    }

    /**
     * output actionCalculator_actionPerformed
     */
    public void actionCalculator_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCalculator_actionPerformed(e);
    }

    /**
     * output actionExport_actionPerformed
     */
    public void actionExport_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExport_actionPerformed(e);
    }

    /**
     * output actionExportSelected_actionPerformed
     */
    public void actionExportSelected_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSelected_actionPerformed(e);
    }

    /**
     * output actionRegProduct_actionPerformed
     */
    public void actionRegProduct_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRegProduct_actionPerformed(e);
    }

    /**
     * output actionPersonalSite_actionPerformed
     */
    public void actionPersonalSite_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPersonalSite_actionPerformed(e);
    }

    /**
     * output actionProcductVal_actionPerformed
     */
    public void actionProcductVal_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionProcductVal_actionPerformed(e);
    }

    /**
     * output actionExportSave_actionPerformed
     */
    public void actionExportSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSave_actionPerformed(e);
    }

    /**
     * output actionExportSelectedSave_actionPerformed
     */
    public void actionExportSelectedSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSelectedSave_actionPerformed(e);
    }

    /**
     * output actionKnowStore_actionPerformed
     */
    public void actionKnowStore_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionKnowStore_actionPerformed(e);
    }

    /**
     * output actionAnswer_actionPerformed
     */
    public void actionAnswer_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAnswer_actionPerformed(e);
    }

    /**
     * output actionRemoteAssist_actionPerformed
     */
    public void actionRemoteAssist_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemoteAssist_actionPerformed(e);
    }

    /**
     * output actionPopupCopy_actionPerformed
     */
    public void actionPopupCopy_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPopupCopy_actionPerformed(e);
    }

    /**
     * output actionHTMLForMail_actionPerformed
     */
    public void actionHTMLForMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHTMLForMail_actionPerformed(e);
    }

    /**
     * output actionExcelForMail_actionPerformed
     */
    public void actionExcelForMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExcelForMail_actionPerformed(e);
    }

    /**
     * output actionHTMLForRpt_actionPerformed
     */
    public void actionHTMLForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHTMLForRpt_actionPerformed(e);
    }

    /**
     * output actionExcelForRpt_actionPerformed
     */
    public void actionExcelForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExcelForRpt_actionPerformed(e);
    }

    /**
     * output actionLinkForRpt_actionPerformed
     */
    public void actionLinkForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLinkForRpt_actionPerformed(e);
    }

    /**
     * output actionPopupPaste_actionPerformed
     */
    public void actionPopupPaste_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPopupPaste_actionPerformed(e);
    }

    /**
     * output actionToolBarCustom_actionPerformed
     */
    public void actionToolBarCustom_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionToolBarCustom_actionPerformed(e);
    }

    /**
     * output actionCloudFeed_actionPerformed
     */
    public void actionCloudFeed_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudFeed_actionPerformed(e);
    }

    /**
     * output actionCloudShare_actionPerformed
     */
    public void actionCloudShare_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudShare_actionPerformed(e);
    }

    /**
     * output actionCloudScreen_actionPerformed
     */
    public void actionCloudScreen_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudScreen_actionPerformed(e);
    }

    /**
     * output actionXunTongFeed_actionPerformed
     */
    public void actionXunTongFeed_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionXunTongFeed_actionPerformed(e);
    }

}