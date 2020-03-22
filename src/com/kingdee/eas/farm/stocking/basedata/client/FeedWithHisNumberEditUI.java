/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata.client;

import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.farm.stocking.basedata.FeedWithHisNumberCollection;
import com.kingdee.eas.farm.stocking.basedata.FeedWithHisNumberFactory;
import com.kingdee.eas.farm.stocking.processbizill.FodderApplyBill;
import com.kingdee.eas.farm.stocking.processbizill.FodderApplyBillEntryFactory;
import com.kingdee.eas.farm.stocking.processbizill.FodderApplyBillFactory;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class FeedWithHisNumberEditUI extends AbstractFeedWithHisNumberEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(FeedWithHisNumberEditUI.class);

	/**
	 * output class constructor
	 */
	public FeedWithHisNumberEditUI() throws Exception
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
		return com.kingdee.eas.farm.stocking.basedata.FeedWithHisNumberFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.stocking.basedata.FeedWithHisNumberInfo objectValue = new com.kingdee.eas.farm.stocking.basedata.FeedWithHisNumberInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));

		return objectValue;
	}
	/**
	 * 
	 */
	@Override
	protected void beforeStoreFields(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.beforeStoreFields(e);
		if(chkisCancelCancel.isSelected()){
			FeedWithHisNumberCollection coll = FeedWithHisNumberFactory.getRemoteInstance().getFeedWithHisNumberCollection("where isCancelCancel=1"+(editData.getId()!=null?(" and id <>'"+editData.getString("id")+"'"):""));
			if(coll.size()>0)
				commUtils.giveUserTipsAndRetire("已存在启用的对应关系");
		}
	}
	@Override
	public void actionRemove_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if(editData.getString("id")!=null)
			if(FodderApplyBillEntryFactory.getRemoteInstance().getFodderApplyBillEntryCollection("where feednum='"+editData.getString("id")+"'").size()>0)
				commUtils.giveUserTipsAndRetire("已被使用过,无法删除");
		super.actionRemove_actionPerformed(arg0);
	}


}