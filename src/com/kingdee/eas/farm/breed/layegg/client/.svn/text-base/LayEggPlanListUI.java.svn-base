/**
 * output package name
 */
package com.kingdee.eas.farm.breed.layegg.client;

import java.awt.event.*;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.base.netctrl.client.FilterItem;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.FarmException;

/**
 * output class name
 */
public class LayEggPlanListUI extends AbstractLayEggPlanListUI
{
	private static final Logger logger = CoreUIObject.getLogger(LayEggPlanListUI.class);

	/**
	 * output class constructor
	 */
	public LayEggPlanListUI() throws Exception
	{
		super();
	}
	/**
	 * 序时簿界面  分录不占据行数
	 */
	protected FilterInfo getDefaultFilterForQuery(){
		FilterInfo filterInfo=super.getDefaultFilterForQuery();
		FilterInfo filterInfoNew=new FilterInfo();
		filterInfoNew.getFilterItems().add(new FilterItemInfo("entrys.seq",new Integer(1),CompareType.EQUALS));
		filterInfoNew.getFilterItems().add(new FilterItemInfo("entrys.seq",null,CompareType.EQUALS));
		filterInfoNew.setMaskString("#0 or #1");
		try {
		if(filterInfo!=null)
				filterInfo.mergeFilter(filterInfoNew, "and");
		else
			filterInfo=filterInfoNew;
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return filterInfoNew;
	}
	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
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

	}
	/**
	 * 审核
	 */
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		try{
			super.actionAudit_actionPerformed(e);
			MsgBox.showInfo("审核完成");

			this.refreshList();
			this.setMessageText("审核完成");
			this.showMessage();
		}catch(FarmException fe){
			MsgBox.showError(fe.getMessage());
		}
	}

	/**
	 * 反审核
	 */
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		try{
			super.actionUnAudit_actionPerformed(e);
			MsgBox.showInfo("反审核完成");

			this.refreshList();
			this.setMessageText("反审核完成");
			this.showMessage();
		}catch(FarmException fe){
			MsgBox.showError(fe.getMessage());
		}
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.breed.layegg.LayEggPlanFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.breed.layegg.LayEggPlanInfo objectValue = new com.kingdee.eas.farm.breed.layegg.LayEggPlanInfo();

		return objectValue;
	}

}