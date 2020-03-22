/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata.client;

import java.awt.event.*;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.farm.stocking.processbizill.FodderApplyBillEntryFactory;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class FeedWithHisNumberListUI extends AbstractFeedWithHisNumberListUI
{
    private static final Logger logger = CoreUIObject.getLogger(FeedWithHisNumberListUI.class);
    
    /**
     * output class constructor
     */
    public FeedWithHisNumberListUI() throws Exception
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
        return com.kingdee.eas.farm.stocking.basedata.FeedWithHisNumberFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.basedata.FeedWithHisNumberInfo objectValue = new com.kingdee.eas.farm.stocking.basedata.FeedWithHisNumberInfo();
		
        return objectValue;
    }

	@Override
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(this.getSelectedKeyValue()))
			if(FodderApplyBillEntryFactory.getRemoteInstance().getFodderApplyBillEntryCollection("where feednum='"+this.getSelectedKeyValue()+"'").size()>0)
				commUtils.giveUserTipsAndRetire("已被使用过,无法删除");
		super.actionRemove_actionPerformed(e);
	}

}