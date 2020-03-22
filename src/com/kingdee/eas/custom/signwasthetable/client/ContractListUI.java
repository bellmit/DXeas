/**
 * output package name
 */
package com.kingdee.eas.custom.signwasthetable.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.swing.JFrame;

import org.apache.log4j.Logger;

import chrriis.common.Filter;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIException;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.ctrl.analysis.web.dashboard.dial.Dial;
import com.kingdee.bos.ctrl.data.modal.CommonQuery;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectListener;
import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
import com.kingdee.bos.ctrl.reportone.forapp.eas.EasResource;
import com.kingdee.bos.ctrl.reportone.r1.form.designer.gui.wizard.base.BaseInitWizard.Dialog;
import com.kingdee.bos.ctrl.swing.tree.KingdeeTreeModel;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.cbos.process.vm.model.Array;
import com.kingdee.eas.base.commonquery.client.CommonQueryDialog;
import com.kingdee.eas.base.commonquery.client.CustomerQueryPanel;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.custom.signwasthetable.CmChangeEntryCollection;
import com.kingdee.eas.custom.signwasthetable.CmChangeEntryInfo;
import com.kingdee.eas.custom.signwasthetable.CmChangeFactory;
import com.kingdee.eas.custom.signwasthetable.CmChangeInfo;
import com.kingdee.eas.custom.signwasthetable.ContractFactory;
import com.kingdee.eas.custom.signwasthetable.ContractInfo;
import com.kingdee.eas.custom.signwasthetable.ContractPaymentCollection;
import com.kingdee.eas.custom.signwasthetable.ContractPaymentInfo;
import com.kingdee.eas.custom.signwasthetable.IContract;
import com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo;
import com.kingdee.eas.custom.signwasthetable.billStatus;
import com.kingdee.eas.fi.ap.PayRequestBillInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.IIDList;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.lowagie.text.pdf.PRAcroForm;
import com.sun.jmx.snmp.Timestamp;

/**
 * output class name
 */
public class ContractListUI extends AbstractContractListUI
{
	private static final Logger logger = CoreUIObject.getLogger(ContractListUI.class);

	/**
	 * output class constructor
	 */
	public ContractListUI() throws Exception
	{
		super();		
	}
	@Override
	/*
	 *�б������ˣ���ͨ�б�����������ʷ�汾��������ʾ���鿴��ǰ�汾�������id��ѯ��������ʾ
	 */
	protected FilterInfo getDefaultFilterForQuery() {
		// TODO Auto-generated method stub
		FilterInfo filterInfo = super.getDefaultFilterForQuery();
		// ����ʵ������MaskString����Ĺ����������й��ˣ�ϵͳĬ������������������#1  or #2 ������������Ҫ�������������
		String ms = filterInfo.getMaskString();
		ms="("+ms+")";
		String srcBillID=(String) this.getUIContext().get("srcBillID");
		if(srcBillID!=null){
			this.setUITitle("��ͬ��ʷ�汾�鿴");
			ContractInfo cmInfo;
			/*
			 * �ڲ鿴��ʷ�汾�б��ʱ��ͨ���ð汾����һ�汾id�ϲ飬��������Ϊ��#1 and #2  and��#3 or #4����������������ʷ�汾��id֮һ��
			 */
			try {
				cmInfo = ContractFactory.getRemoteInstance().getContractInfo(new ObjectUuidPK(srcBillID));
				IContract ff = ContractFactory.getRemoteInstance();
				int i=0;
				//���ϵĸ�����һ�汾���ֶ�׷�ݵ���һ���汾��Ȼ������еİ汾��id��Ϊmask���˵�����or
				for(i=0;;i++)
				{
					if(cmInfo.getPerVersionID()!=null)
					{
						filterInfo.getFilterItems().add(new FilterItemInfo("id",cmInfo.getPerVersionID(),CompareType.EQUALS));
						if(i==0)
							ms+=" and ( #"+String.valueOf(filterInfo.getFilterItems().size()-1);
						else
							ms+=" or #"+String.valueOf(filterInfo.getFilterItems().size()-1);
						cmInfo=ff.getContractInfo(new ObjectUuidPK(cmInfo.getPerVersionID()));
					}
					else
						break;
				}
				if(i>0)
					ms+=")";
			} catch (EASBizException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*
			 * û����һ�汾id�ı�Ȼ�ǵ�һ�汾���鿴�������б�϶�����ͨ��ʱ�����棬��ͨ��ʱ�����棬ֻ���Ƿ���ʷ�汾����
			 * �������飬������ֵ�����������������Ҫ�޸���������
			 * ����else������ʷ�汾����
			 */
		}else
		{
			filterInfo.getFilterItems().add(new FilterItemInfo("isHistory",0,CompareType.EQUALS));
			ms=ms+"and #3";
		}
		filterInfo.setMaskString(ms);
		return filterInfo;
	}
    /**
     * ����ʱ���������ɸ������뵥
     */
	@Override
//	public void actionToPayReq_actionPerformed(ActionEvent e) throws Exception {
//		// TODO Auto-generated method stub
//		ArrayList billNum= this.getSelectedIdValues();
//		if(billNum.size()>1)
//		{
//			MsgBox.showInfo("�벻Ҫһ��ѡ����ŵ���");
//			abort();
//		}
//		if(billNum.size()==0)
//		{
//			MsgBox.showInfo("��ѡ���¼��");
//			abort();
//		}
//		int[] rows = KDTableUtil.getSelectedRows(tblMain);
//		ArrayList<Integer> ids=new ArrayList<Integer>();
//		for(int i=0;i<rows.length;i++)
//			ids.add((Integer) tblMain.getRow(rows[i]).getCell("phaseCoding").getValue());
//		String id=billNum.get(0).toString();		
//		ContractInfo info=null;
//		if(id!=null)
//			info=ContractFactory.getRemoteInstance().getContractInfo(new ObjectUuidPK(id));
//		if(!info.getContractStatus().equals(billStatus.Audit))
//		{
//			MsgBox.showInfo("�õ�����δ���");
//			abort();
//		}
//		ContractPaymentCollection entrys=info.getPayment();
//		//��ȥδѡ��ķ�¼
//		for(int k=entrys.size()-1;k>=0;k--)
//			for(int j=0;j<ids.size();j++)
//			{
//				if(entrys.get(k).getPhaseCoding()==ids.get(j))
//					break;
//				if(j==ids.size()-1&&entrys.get(k).getPhaseCoding()!=ids.get(j))
//				{
//					entrys.remove(entrys.get(k));
//				}
//			}
//		//��ȥ�����븶���� ������ķ�¼
//		for(int k=entrys.size()-1;k>=0;k--)
//			if(entrys.get(k).getUnRequiredAmt()==null||entrys.get(k).getUnRequiredAmt().equals(BigDecimal.ZERO))
//					entrys.remove(entrys.get(k));
//		if(entrys.size()==0)
//		{
//			MsgBox.showInfo("��ѡ��ķ�¼�Ŀ��ý����������");
//			refreshList();
//			abort();
//		}
//
//
//		IObjectValue subBillInfo = com.kingdee.eas.custom.signwasthetable.createToPayFactory.getRemoteInstance().createPayReq(info);
//		refreshList();
//		PayRequestBillInfo payreq=(PayRequestBillInfo) subBillInfo;
//		if(payreq != null && payreq.size() > 0){
//			refreshList();
//			showPayreqBill(payreq);
//		}
//
//
//		super.actionToPayReq_actionPerformed(e);
//	}
	/*
	 * ���ɸ������뵥ʱ�Ľ���չʾ
	 */
//	public void showPayreqBill(PayRequestBillInfo info) {
//
//		String destBillEditUIClassName ="com.kingdee.eas.fi.ap.client.PayRequestBillEditUI";
//		Map map = new UIContext(this);
//		map.put("ID",info.getId().toString());
//		map.put(UIContext.OWNER, this);
//		IUIWindow uiWindow = null ;
//		try {
//			uiWindow = UIFactory.createUIFactory(UIFactoryName.EDITWIN).create(destBillEditUIClassName, map, null,OprtState.EDIT);
//			//			uiWindow.setUIObject(tableMenu.)
//		} catch (UIException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//��ʼչ�� UI
//		uiWindow.show();
//
//
//	}
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
	@Override
	/**
	 * ��˲���
	 * ��ʷ�汾�ĵ��ݽ�ֹ���
	 * ���ύ״̬�µĵ��ݽ�ֹ���
	 */
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		String id=this.getSelectedKeyValue();
		checkSelected(id);
		ContractInfo info=ContractFactory.getRemoteInstance().getContractInfo(new ObjectUuidPK(id));
		
		if(ClientUtils.checkBillInWorkflow(this, info.getId().toString()))
			commUtils.giveUserTipsAndRetire("���������ڹ�������");
		
		if(info.getContractStatus().equals(billStatus.submit)){
			super.actionAudit_actionPerformed(e);
			this.setMessageText("������");
			refresh(e);
			return;
		}
		if(info.getIsHistory()==1)
		{
			MsgBox.showInfo("��ʷ�汾�ĵ��ݽ�ֹ�޸ģ�");
			SysUtil.abort();
		}
		MsgBox.showInfo("��ǰ״̬�½�ֹ��ˣ�");
	}

	@Override
	/**
	 * ��˲���
	 * �����ε��ݵĵ��ݽ�ֹ�����
	 * ��ʷ�汾�ĵ��ݽ�ֹ�����
	 * ���ύ״̬�µĵ��ݽ�ֹ�����
	 */
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		String id=this.getSelectedKeyValue();
		checkSelected(id);
		ContractInfo info=ContractFactory.getRemoteInstance().getContractInfo(new ObjectUuidPK(id));
		if(info.getIsHistory()==1)
		{
			MsgBox.showInfo("��ʷ�汾�ĵ��ݽ�ֹ�޸ģ�");
			SysUtil.abort();
		}
		if(info.getContractStatus().equals(billStatus.Audit)){
			StringBuffer buffer=new StringBuffer();
			buffer.append("select t3.fparentid from T_SIG_ContractPayment t3 ");
			buffer.append("inner join T_BOT_RelationEntry t2 on t3.fid=t2.FSrcEntryID ");
			buffer.append("inner join T_AP_PayRequestBillEntry t1 on t1.fid=t2.FDestEntryID ");
			buffer.append("where t3.fparentid='").append(id).append("'");
			IRowSet rs=SQLExecutorFactory.getRemoteInstance(buffer.toString()).executeSQL();
			if(rs.next())
			{
				MsgBox.showInfo("�����ε��ݵĵ��ݽ�ֹ����ˣ�");
				SysUtil.abort();
			}
			super.actionUnAudit_actionPerformed(e);
			this.setMessageText("��������");
			refresh(e);
			return;
		}

		MsgBox.showInfo("�������������˵ĺ�ͬǩ�ʣ�");
	}

	@Override
	/*
	 * ɾ��
	 * ����˵ĺ���ʷ�汾�ĵ��ݶ���ֹɾ��
	 */
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		String id=this.getSelectedKeyValue();
		checkSelected(id);
		ContractInfo info=ContractFactory.getRemoteInstance().getContractInfo(new ObjectUuidPK(id));
		
		if(ClientUtils.checkBillInWorkflow(this, info.getId().toString()))
			commUtils.giveUserTipsAndRetire("���������ڹ�������");
		
		if(info.getIsHistory()==1)
		{
			MsgBox.showInfo("��ʷ�汾�ĵ��ݽ�ֹɾ����");
			SysUtil.abort();
		}
		if(info.getContractStatus().equals(billStatus.Audit)){
			MsgBox.showInfo("����˵ĵ��ݽ�ֹɾ����");
			return;
		}		
		super.actionRemove_actionPerformed(e);
	}

	@Override
	/*
	 * �༭����
	 * ��ʷ�汾�ĵ��ݽ�ֹ�޸�
	 * ���״̬�µĵ��ݽ�ֹ�޸�
	 */
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		String id=this.getSelectedKeyValue();
		checkSelected(id);
		ContractInfo info=ContractFactory.getRemoteInstance().getContractInfo(new ObjectUuidPK(id));
		if(info.getIsHistory()==1)
		{
			MsgBox.showInfo("��ʷ�汾�ĵ��ݽ�ֹ�޸ģ�");
			SysUtil.abort();
		}
		if(info.getContractStatus().equals(billStatus.Audit)){
			MsgBox.showInfo("����˵ĵ��ݽ�ֹ�޸ģ�");
			return;
		}		
		super.actionEdit_actionPerformed(e);
	}

	@Override
	public void loadFields() {
		// TODO Auto-generated method stub
		super.loadFields();			
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();

		//�޸���˺ͷ���˵�ͼ��
		this.Audit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_auditing"));
		this.unAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_fauditing"));
		//������һ�������¼�
		tblMain.addKDTSelectListener(new KDTSelectListener()
		{
			public void tableSelectChanged(KDTSelectEvent arg0) {
				// TODO Auto-generated method stub
				if(KDTableUtil.getSelectedRow(tblMain)==null)
					return;
				if(Integer.valueOf(KDTableUtil.getSelectedRow(tblMain).getCell("isHistory").getValue().toString())==1)
				{
					btnAddNew.setVisible(false);
					btnEdit.setVisible(false);
					btnRemove.setVisible(false);
					btnCreateTo.setVisible(false);
					btnAuditResult.setVisible(false);
					btnPrint.setVisible(false);
					btnPrintPreview.setVisible(false);
					btnAttachment.setVisible(false);
					btnTraceDown.setVisible(false);
					btnTraceUp.setVisible(false);
					btnNextPerson.setVisible(false);
					btnWorkFlowG.setVisible(false);
					btnAuditResult.setVisible(false);
					btnWFViewdoProccess.setVisible(false);
					btnMultiapprove.setVisible(false);
					btnAuditResult.setVisible(false);
					Audit.setVisible(false);
					unAudit.setVisible(false);
					btnRefresh.setVisible(false);
					btnView.setVisible(false);
					btnLocate.setVisible(false);
					btnQuery.setVisible(false);
					//				btn



					btnRemove.setEnabled(false);
					btnAddNew.setEnabled(false);
					btnEdit.setEnabled(false);
					actionAudit.setEnabled(false);
					actionUnAudit.setEnabled(false);
					actionTraceUp.setEnabled(false);
					actionTraceDown.setEnabled(false);
					actionCreateTo.setEnabled(false);
					actionWorkFlowG.setEnabled(false);
				}
				if(Integer.valueOf(KDTableUtil.getSelectedRow(tblMain).getCell("isHistory").getValue().toString())==0)
				{
					btnRemove.setEnabled(true);
					btnAddNew.setEnabled(true);
					btnEdit.setEnabled(true);
					actionAudit.setEnabled(true);
					actionUnAudit.setEnabled(true);
					actionTraceUp.setEnabled(true);
					actionTraceDown.setEnabled(true);
					actionCreateTo.setEnabled(true);
					actionWorkFlowG.setEnabled(true);
				}

			}});
	}
	//�жϵ�ǰ�Ƿ���ѡ��ĺ�ͬ��¼
	protected void checkSelected(String id)
	{
		if(id==null)
		{
			MsgBox.showInfo("��ѡ���¼��");
			SysUtil.abort();
		}
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.custom.signwasthetable.ContractFactory.getRemoteInstance();
	}
	/*
	 * ����鿴����
	 */
	@Override
	public void actionViewHistory_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		String id=this.getSelectedKeyValue();
		checkSelected(id);
		ContractInfo info=ContractFactory.getRemoteInstance().getContractInfo(new ObjectUuidPK(id));
		if(info.getPerVersionID()==null){
			MsgBox.showInfo("�õ���û�з�������ͬ�����");
			SysUtil.abort();
		}			
		makecmChangeViewUI(info);
		super.actionViewHistory_actionPerformed(e);
	}
	/*
	 * ������ʷ�汾����ʱ������
	 * չ����һ�������һ�㲽�裺
	 * 1.String��ȡҪ���������ȫ·��
	 * 2.����һ��map���������
	 * 3.����һ��windows����������
	 */
	@SuppressWarnings("unchecked")
	private void makecmChangeViewUI(ContractInfo srcBillInfo) throws EASBizException, UIException,BOSException, Exception 
	{
		if(this.getSelectedKeyValue().toString()==null)
			MsgBox.showInfo("��ѡ���¼��");
		String destBillEditUIClassName ="com.kingdee.eas.custom.signwasthetable.client.ContractListUI";
		Map map = new UIContext(this);
		map.put("srcBillID",srcBillInfo.getId().toString());
		map.put(UIContext.OWNER, this);
		IUIWindow uiWindow = null ;
		uiWindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create(destBillEditUIClassName, map, null,OprtState.ADDNEW);
		//��ʼչ�� UI
		uiWindow.show();
	}
	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.signwasthetable.ContractInfo objectValue = new com.kingdee.eas.custom.signwasthetable.ContractInfo();

		return objectValue;
	}
}