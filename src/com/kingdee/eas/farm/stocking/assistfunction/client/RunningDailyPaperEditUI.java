/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.assistfunction.client;

import java.awt.Toolkit;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.assistant.PeriodUtils;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.framework.*;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;

/**
 * output class name
 */
public class RunningDailyPaperEditUI extends AbstractRunningDailyPaperEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(RunningDailyPaperEditUI.class);

	/**
	 * output class constructor
	 */
	public RunningDailyPaperEditUI() throws Exception
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
		return com.kingdee.eas.farm.stocking.assistfunction.RunningDailyPaperFactory.getRemoteInstance();
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		
		kdtEntrys.addKDTEditListener(new KDTEditAdapter(){
			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStopped(e);
				if(e.getColIndex()==kdtEntrys.getColumn("hatchAgentFee").getColumnIndex()&&cboxDaiFu.isSelected()){
					for(int i=0;i<kdtEntrys.getRowCount();i++)
						kdtEntrys.getCell(i, "hatchAgentFee").setValue(e.getValue());
				}
			}
			
		});
		
		btnMultiRow.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				if(prmtperiod.getValue()!=null){
					kdtEntrys.removeRows();
					PeriodInfo period=(PeriodInfo) prmtperiod.getValue();
					int days = DateUtilsComm.getDiffBetweenTwoDays(period.getBeginDate(),period.getEndDate());
					Calendar cal = Calendar.getInstance();
					for(int i=0;i<days+1;i++){
						cal.setTime(period.getBeginDate());
						cal.add(Calendar.DATE, i);
						kdtEntrys.addRow();
						kdtEntrys.getRow(kdtEntrys.getRowCount()-1).getCell("bizDate").setValue(cal.getTime());
					}
				}
			}});
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
		com.kingdee.eas.farm.stocking.assistfunction.RunningDailyPaperInfo objectValue = new com.kingdee.eas.farm.stocking.assistfunction.RunningDailyPaperInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setPeriod(DateUtilsComm.getCurrentPeriodInfo());
		return objectValue;
	}

}