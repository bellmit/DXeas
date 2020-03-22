/**
 * output package name
 */
package com.kingdee.eas.custom.festival.client;

import java.awt.event.*;
import java.util.Calendar;

import org.apache.log4j.Logger;

import cn.org.rapid_framework.jdbc.sqlgenerator.metadata.Table;

import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.basedata.assistant.PeriodFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.framework.*;
import com.kingdee.bos.ctrl.kdf.table.KDTable;

/**
 * output class name
 */
public class FactoryCalendarEditUI extends AbstractFactoryCalendarEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(FactoryCalendarEditUI.class);

	/**
	 * output class constructor
	 */
	public FactoryCalendarEditUI() throws Exception
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
	 * output btnAddLine_actionPerformed method
	 */
	protected void btnAddLine_actionPerformed(java.awt.event.ActionEvent e) throws Exception
	{
		super.btnAddLine_actionPerformed(e);
	}

	/**
	 * output menuItemEnterToNextRow_itemStateChanged method
	 */
	protected void menuItemEnterToNextRow_itemStateChanged(java.awt.event.ItemEvent e) throws Exception
	{
		super.menuItemEnterToNextRow_itemStateChanged(e);
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.custom.festival.FactoryCalendarFactory.getRemoteInstance();
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
		com.kingdee.eas.custom.festival.FactoryCalendarInfo objectValue = new com.kingdee.eas.custom.festival.FactoryCalendarInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));

		return objectValue;
	}

	/**
	 * 点击  获取日历按钮时加载  该年份的日历
	 */
	@Override
	protected void btnGetCalendar_keyPress(KeyEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(txtyear.getIntegerValue()==null)
			commUtils.giveUserTipsAndRetire("年份为空");
		String[] month={"01","02","03","04","05","06","07","08","09","10","11","12"};
		KDTable[] EntryMonth={kdtEntrysJanuary,kdtEntrysFebruary,kdtEntrysMarch,kdtEntrysApril,
				kdtEntrysMay,kdtEntrysJune,kdtEntrysJuly,kdtEntrysAugust,kdtEntrysSeptember,kdtEntrysOctober,
				kdtEntrysNovember,kdtEntrysDecember};

		CoreBaseCollection coll=null;
		for(int i=0;i<month.length;i++){
			coll = PeriodFactory.getRemoteInstance().getCollection(" where number='"+txtyear.getStringValue()+month[i]+"'");
			if(coll.size()>0)
				loadCalendarByMonth(EntryMonth[i],(PeriodInfo)coll.get(i));
		}
		super.btnGetCalendar_keyPress(e);
	}


	/**
	 * 按月份加载
	 * @param periodInfo 
	 * @param table 
	 * @param objects
	 */
	private void loadCalendarByMonth(KDTable table, PeriodInfo periodInfo) {
		table.removeRows();
		Calendar cal = Calendar.getInstance();
		cal.setTime(periodInfo.getBeginDate());
		do{
			table.addRow();
			table.getCell(table.getRowCount()-1, "date").setValue(cal.getTime());
			cal.add(Calendar.DATE, +1);
		}while(!cal.after(periodInfo.getEndDate()));
	}
}