/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.recyclebiz.client;

import java.awt.Toolkit;
import java.awt.event.*;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.cp.eip.mc.web.service.MessageWebService.Msg;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKCloseAccountFacadeFactory;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class CKCloseAccountUI extends AbstractCKCloseAccountUI
{
	private static final Logger logger = CoreUIObject.getLogger(CKCloseAccountUI.class);

	/**
	 * output class constructor
	 */
	public CKCloseAccountUI() throws Exception
	{
		super();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		initUI();
		initControl();
	}

	private void initControl() {
		// TODO Auto-generated method stub
		prmtCompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				showInfo();
			}
		});
		prmtPeriod.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				showInfo();
			}
		});
		showInfo();
	}

	private void initUI() {
		// TODO Auto-generated method stub
		// prmtCompany		
		prmtCompany.setQueryInfo("com.kingdee.eas.basedata.org.app.CompanyOrgUnitQuery");		
		prmtCompany.setEditable(true);		
		prmtCompany.setDisplayFormat("$name$");		
		prmtCompany.setEditFormat("$number$");		
		prmtCompany.setCommitFormat("$number$");		
		prmtCompany.setRequired(true);
		// prmtperiod		
		this.prmtPeriod.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7PeriodQuery");		
		this.prmtPeriod.setEditable(true);		
		this.prmtPeriod.setDisplayFormat("$number$");		
		this.prmtPeriod.setEditFormat("$number$");		
		this.prmtPeriod.setCommitFormat("$number$");		
		this.prmtPeriod.setRequired(true);
		for (int i = 0; i < this.toolBar.getComponents().length; i++) {
			this.toolBar.getComponent(i).setVisible(false);
		}
	}

	private void showInfo() {
		// TODO Auto-generated method stub
		if(prmtCompany.getValue()==null||prmtPeriod.getValue()==null){
			txtInfo.setText("��ѡ��˾���ڼ�");
		}
		String companyID=((IPropertyContainer)prmtCompany.getValue()).getString("id");
		String companyName=((IPropertyContainer)prmtCompany.getValue()).getString("name");
		String periodID=((IPropertyContainer)prmtPeriod.getValue()).getString("id");
		String periodNumber=((IPropertyContainer)prmtPeriod.getValue()).getString("number");
		boolean isClosed;
		try {
			isClosed = CKCloseAccountFacadeFactory.getRemoteInstance().checkIsClosed(companyID, periodID);
			if(isClosed){
				txtInfo.setText(companyName+" "+periodNumber+" �ѹ���");
			}else{
				txtInfo.setText(companyName+" "+periodNumber+" δ����");
			}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void dealWork(Boolean isClose) throws EASBizException, BOSException {
		// TODO Auto-generated method stub
		String companyID=((IPropertyContainer)prmtCompany.getValue()).getString("id");
		String periodID=((IPropertyContainer)prmtPeriod.getValue()).getString("id");
		boolean isClosed = CKCloseAccountFacadeFactory.getRemoteInstance().checkIsClosed(companyID, periodID);
		if(isClose){
			if(isClosed){
				MsgBox.showWarning("�ù�˾��ѡ�ڼ���ִ�й�����!");
				SysUtil.abort();
			}		
		}else{
			if(!isClosed){
				MsgBox.showWarning("�ù�˾δִ�й�����,���跴����!");
				SysUtil.abort();
			}	
		}
		String work=isClose?"����":"������";
		if(MsgBox.showConfirm2("����ִ�иù�˾����ѡ�ڼ��"+work+"����,�Ƿ����?")!=MsgBox.YES){
			SysUtil.abort();
		}
		if(isClose){
			CKCloseAccountFacadeFactory.getRemoteInstance().closeAccount(companyID, periodID);
			MsgBox.showInfo("���˳ɹ�!");
		}else{
			CKCloseAccountFacadeFactory.getRemoteInstance().unCloseAccount(companyID, periodID);
			MsgBox.showInfo("�����˳ɹ�!");
		}
		showInfo();
	}

	private void verifyInput() {
		// TODO Auto-generated method stub
		if(prmtCompany.getValue()==null){
			MsgBox.showWarning("��˾δ��д!");
			SysUtil.abort();
		}
		if(prmtPeriod.getValue()==null){
			MsgBox.showWarning("�ڼ�δ��д!");
			SysUtil.abort();
		}	
	}

	@Override
	protected void btnClose_actionPerformed(ActionEvent e) throws Exception {
		verifyInput();
		dealWork(true);
	}

	@Override
	protected void btnUnClose_actionPerformed(ActionEvent e) throws Exception {
		verifyInput();
		dealWork(false);
	}

	@Override
	protected void btnExit_actionPerformed(ActionEvent e) throws Exception {
		actionExitCurrent_actionPerformed(e);
	}

	@Override
	protected IObjectValue createNewData() {
		// TODO Auto-generated method stub
		prmtCompany.setValue(SysContext.getSysContext().getCurrentFIUnit());
		try {
			prmtPeriod.setValue(DateUtilsComm.getUpperPeriodInfo(DateUtilsComm.getCurrentPeriodInfo()));
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected ICoreBase getBizInterface() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}