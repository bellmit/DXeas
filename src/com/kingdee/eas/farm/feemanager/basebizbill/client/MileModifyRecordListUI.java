/**
 * output package name
 */
package com.kingdee.eas.farm.feemanager.basebizbill.client;

import java.awt.event.*;
import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordInfo;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class MileModifyRecordListUI extends AbstractMileModifyRecordListUI
{
	private static final Logger logger = CoreUIObject.getLogger(MileModifyRecordListUI.class);

	/**
	 * output class constructor
	 */
	public MileModifyRecordListUI() throws Exception
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
	 * output tblMain_tableClicked method
	 */
	protected void tblMain_tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws Exception
	{
		super.tblMain_tableClicked(e);
	}

	/**
	 * output tblMain_tableSelectChanged method
	 */
	protected void tblMain_tableSelectChanged(com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent e) throws Exception
	{
		super.tblMain_tableSelectChanged(e);
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.feemanager.basebizbill.MileModifyRecordFactory.getRemoteInstance();
	}

	@Override
	protected FilterInfo getDefaultFilterForQuery() {
		// TODO Auto-generated method stub
		FilterInfo filter = super.getDefaultFilterForQuery();
		String maskString = filter.getMaskString();
		if(this.getUIContext().get("src")!=null){
			TransportationrecordInfo transInfo=(TransportationrecordInfo) getUIContext().get("src");
			filter.getFilterItems().add(new FilterItemInfo("transportRecord.number",transInfo.getString("number"),CompareType.EQUALS));
		}
		filter.setMaskString("("+maskString+") and #"+(filter.getFilterItems().size()-1));
		return filter;
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		//设置按钮不可用
		for(int i=0;i<toolBar.getComponentCount();i++)
			toolBar.getComponent(i).setEnabled(false);
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.feemanager.basebizbill.MileModifyRecordInfo objectValue = new com.kingdee.eas.farm.feemanager.basebizbill.MileModifyRecordInfo();

		return objectValue;
	}

}