/**
 * output package name
 */
package com.kingdee.eas.custom.salepayment.client;

import java.awt.Toolkit;
import java.awt.event.*;
import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.swing.DecimalFormatEx;
import com.kingdee.bos.ctrl.swing.NumberFormatterEx;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class SalePaymentSetEditUI extends AbstractSalePaymentSetEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(SalePaymentSetEditUI.class);
    
    /**
     * output class constructor
     */
    public SalePaymentSetEditUI() throws Exception
    {
        super();
        
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
        return com.kingdee.eas.custom.salepayment.SalePaymentSetFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.salepayment.SalePaymentSetInfo objectValue = new com.kingdee.eas.custom.salepayment.SalePaymentSetInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        
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
		
//		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
//		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
//		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		
	}
    
}