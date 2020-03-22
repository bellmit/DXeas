/**
 * output package name
 */
package com.kingdee.eas.custom.salediscount.client;

import java.awt.event.*;
import java.math.BigDecimal;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.custom.salediscount.DiscountSetEntryInfo;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class SetDSLimit extends AbstractSetDSLimit
{
    private static final Logger logger = CoreUIObject.getLogger(SetDSLimit.class);
    
    /**
     * output class constructor
     */
    public SetDSLimit() throws Exception
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
     * output actionOnLoad_actionPerformed
     */
    public void actionOnLoad_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionOnLoad_actionPerformed(e);
        this.setUITitle("设置限制条件");
        this.ftfQtySumLimit.setValue(new BigDecimal("0"));
        this.ftfDSAmountLimit.setValue(new BigDecimal("0"));
        this.ftfSaleAmountLimit.setValue(new BigDecimal("0"));
    }

	/**
	 * 关闭
	 */
	protected void btnClose_actionPerformed(ActionEvent e) throws Exception {
		this.getUIWindow().close();
	}

	/**
	 * 确定
	 */
	protected void btnConfirm_actionPerformed(ActionEvent e) throws Exception {
		DiscountSetEntryInfo entryInfo = new DiscountSetEntryInfo();
		entryInfo.setQtyLimit(this.ftfQtySumLimit.getBigDecimalValue());
		entryInfo.setSdLimit(this.ftfDSAmountLimit.getBigDecimalValue());
		entryInfo.setSaleAmountLimit(this.ftfSaleAmountLimit.getBigDecimalValue());
		this.getUIContext().put("entryInfo", entryInfo);
	    this.getUIWindow().close();
	}
    
    
    

}