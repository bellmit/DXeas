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
	 *列表界面过滤，普通列表界面如果是历史版本，则不予显示，查看以前版本，则根据id查询并予以显示
	 */
	protected FilterInfo getDefaultFilterForQuery() {
		// TODO Auto-generated method stub
		FilterInfo filterInfo = super.getDefaultFilterForQuery();
		// 过滤实际上是MaskString里面的过滤条件进行过滤，系统默认了两个过滤条件（#1  or #2 ），先在我们要添加其他的条件
		String ms = filterInfo.getMaskString();
		ms="("+ms+")";
		String srcBillID=(String) this.getUIContext().get("srcBillID");
		if(srcBillID!=null){
			this.setUITitle("合同历史版本查看");
			ContractInfo cmInfo;
			/*
			 * 在查看历史版本列表的时候，通过该版本的上一版本id上查，过滤条件为（#1 and #2  and（#3 or #4……）：必须是历史版本的id之一）
			 */
			try {
				cmInfo = ContractFactory.getRemoteInstance().getContractInfo(new ObjectUuidPK(srcBillID));
				IContract ff = ContractFactory.getRemoteInstance();
				int i=0;
				//不断的根据上一版本的字段追溯到第一个版本，然后把所有的版本的id作为mask过滤的条件or
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
			 * 没有上一版本id的必然是第一版本，查看的它的列表肯定是普通序时簿界面，普通序时簿界面，只需是非历史版本即可
			 * 存在争议，如果出现第三个过滤条件则需要修改条件代码
			 * 下面else过滤历史版本代码
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
     * 在序时簿界面生成付款申请单
     */
	@Override
//	public void actionToPayReq_actionPerformed(ActionEvent e) throws Exception {
//		// TODO Auto-generated method stub
//		ArrayList billNum= this.getSelectedIdValues();
//		if(billNum.size()>1)
//		{
//			MsgBox.showInfo("请不要一次选择多张单据");
//			abort();
//		}
//		if(billNum.size()==0)
//		{
//			MsgBox.showInfo("请选择记录行");
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
//			MsgBox.showInfo("该单据尚未审核");
//			abort();
//		}
//		ContractPaymentCollection entrys=info.getPayment();
//		//除去未选择的分录
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
//		//除去已申请付款金额 申请完的分录
//		for(int k=entrys.size()-1;k>=0;k--)
//			if(entrys.get(k).getUnRequiredAmt()==null||entrys.get(k).getUnRequiredAmt().equals(BigDecimal.ZERO))
//					entrys.remove(entrys.get(k));
//		if(entrys.size()==0)
//		{
//			MsgBox.showInfo("所选择的分录的可用金额已申请完");
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
	 * 生成付款申请单时的界面展示
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
//		//开始展现 UI
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
	 * 审核操作
	 * 历史版本的单据禁止审核
	 * 非提交状态下的单据禁止审核
	 */
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		String id=this.getSelectedKeyValue();
		checkSelected(id);
		ContractInfo info=ContractFactory.getRemoteInstance().getContractInfo(new ObjectUuidPK(id));
		
		if(ClientUtils.checkBillInWorkflow(this, info.getId().toString()))
			commUtils.giveUserTipsAndRetire("单据正处于工作流中");
		
		if(info.getContractStatus().equals(billStatus.submit)){
			super.actionAudit_actionPerformed(e);
			this.setMessageText("审核完成");
			refresh(e);
			return;
		}
		if(info.getIsHistory()==1)
		{
			MsgBox.showInfo("历史版本的单据禁止修改！");
			SysUtil.abort();
		}
		MsgBox.showInfo("当前状态下禁止审核！");
	}

	@Override
	/**
	 * 审核操作
	 * 有下游单据的单据禁止反审核
	 * 历史版本的单据禁止反审核
	 * 非提交状态下的单据禁止反审核
	 */
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		String id=this.getSelectedKeyValue();
		checkSelected(id);
		ContractInfo info=ContractFactory.getRemoteInstance().getContractInfo(new ObjectUuidPK(id));
		if(info.getIsHistory()==1)
		{
			MsgBox.showInfo("历史版本的单据禁止修改！");
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
				MsgBox.showInfo("有下游单据的单据禁止反审核！");
				SysUtil.abort();
			}
			super.actionUnAudit_actionPerformed(e);
			this.setMessageText("反审核完成");
			refresh(e);
			return;
		}

		MsgBox.showInfo("仅允许反审核已审核的合同签呈！");
	}

	@Override
	/*
	 * 删除
	 * 已审核的和历史版本的单据都禁止删除
	 */
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		String id=this.getSelectedKeyValue();
		checkSelected(id);
		ContractInfo info=ContractFactory.getRemoteInstance().getContractInfo(new ObjectUuidPK(id));
		
		if(ClientUtils.checkBillInWorkflow(this, info.getId().toString()))
			commUtils.giveUserTipsAndRetire("单据正处于工作流中");
		
		if(info.getIsHistory()==1)
		{
			MsgBox.showInfo("历史版本的单据禁止删除！");
			SysUtil.abort();
		}
		if(info.getContractStatus().equals(billStatus.Audit)){
			MsgBox.showInfo("已审核的单据禁止删除！");
			return;
		}		
		super.actionRemove_actionPerformed(e);
	}

	@Override
	/*
	 * 编辑操作
	 * 历史版本的单据禁止修改
	 * 审核状态下的单据禁止修改
	 */
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		String id=this.getSelectedKeyValue();
		checkSelected(id);
		ContractInfo info=ContractFactory.getRemoteInstance().getContractInfo(new ObjectUuidPK(id));
		if(info.getIsHistory()==1)
		{
			MsgBox.showInfo("历史版本的单据禁止修改！");
			SysUtil.abort();
		}
		if(info.getContractStatus().equals(billStatus.Audit)){
			MsgBox.showInfo("已审核的单据禁止修改！");
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

		//修改审核和反审核的图标
		this.Audit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_auditing"));
		this.unAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_fauditing"));
		//定义了一个监听事件
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
	//判断当前是否有选择的合同记录
	protected void checkSelected(String id)
	{
		if(id==null)
		{
			MsgBox.showInfo("请选择记录行");
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
	 * 变更查看操作
	 */
	@Override
	public void actionViewHistory_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		String id=this.getSelectedKeyValue();
		checkSelected(id);
		ContractInfo info=ContractFactory.getRemoteInstance().getContractInfo(new ObjectUuidPK(id));
		if(info.getPerVersionID()==null){
			MsgBox.showInfo("该单据没有发生过合同变更！");
			SysUtil.abort();
		}			
		makecmChangeViewUI(info);
		super.actionViewHistory_actionPerformed(e);
	}
	/*
	 * 弹出历史版本的序时簿界面
	 * 展现另一个界面的一般步骤：
	 * 1.String获取要弹出界面的全路径
	 * 2.定义一个map，出入参数
	 * 3.定义一个windows，弹出界面
	 */
	@SuppressWarnings("unchecked")
	private void makecmChangeViewUI(ContractInfo srcBillInfo) throws EASBizException, UIException,BOSException, Exception 
	{
		if(this.getSelectedKeyValue().toString()==null)
			MsgBox.showInfo("请选择记录行");
		String destBillEditUIClassName ="com.kingdee.eas.custom.signwasthetable.client.ContractListUI";
		Map map = new UIContext(this);
		map.put("srcBillID",srcBillInfo.getId().toString());
		map.put(UIContext.OWNER, this);
		IUIWindow uiWindow = null ;
		uiWindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create(destBillEditUIClassName, map, null,OprtState.ADDNEW);
		//开始展现 UI
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