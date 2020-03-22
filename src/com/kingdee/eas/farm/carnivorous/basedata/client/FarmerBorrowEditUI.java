/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata.client;

import java.awt.Toolkit;
import java.awt.event.*;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.MetaDataPK;
import com.kingdee.bos.metadata.bot.BOTRelationFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.ItemAction;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.dao.AbstractObjectValue;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.assistant.IPrintIntegration;
import com.kingdee.eas.basedata.assistant.PrintIntegrationFactory;
import com.kingdee.eas.basedata.assistant.PrintIntegrationInfo;
import com.kingdee.eas.basedata.assistant.util.CommonPrintIntegrationDataProvider;
import com.kingdee.eas.basedata.assistant.util.PrintIntegrationManager;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.UIUtil;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerBorrowFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerBorrowInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerTreeFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerTreeInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.framework.print.MultiapproveDataProvider;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.util.MultiDataSourceDataProviderProxy;
import com.kingdee.eas.scm.common.util.SCMCommonDataProvider;
import com.kingdee.eas.scm.im.inv.client.InvClientUtils;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class FarmerBorrowEditUI extends AbstractFarmerBorrowEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(FarmerBorrowEditUI.class);

	/**
	 * output class constructor
	 */
	public FarmerBorrowEditUI() throws Exception
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
		return com.kingdee.eas.farm.carnivorous.basedata.FarmerBorrowFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.carnivorous.basedata.FarmerBorrowInfo objectValue = new com.kingdee.eas.farm.carnivorous.basedata.FarmerBorrowInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setBizDate(new Date());
		return objectValue;
	}

	private void setUIStatus() {


		// TODO Auto-generated method stub
		if(this.editData.getBaseStatus()!=null) {
			if(this.editData.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
				this.actionCancel.setEnabled(true);
				this.actionCancelCancel.setEnabled(true);
				this.actionEdit.setEnabled(false);
				this.actionAudit.setEnabled(false);
				this.actionUnAudit.setEnabled(true);		
			}else if(this.editData.getBaseStatus().equals(FarmBaseStatusEnum.unApprove)) {
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(false);
				this.actionEdit.setEnabled(true);
				this.actionAudit.setEnabled(true);
				this.actionUnAudit.setEnabled(false);		
			}else  if(this.editData.getBaseStatus().equals(FarmBaseStatusEnum.frozen)) {
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(true);
				this.actionEdit.setEnabled(false);
				this.actionAudit.setEnabled(false);
				this.actionUnAudit.setEnabled(false);		
			}else {
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(false);
				this.actionEdit.setEnabled(true);
			}
		}if(editData.getId()==null){
			this.actionCancel.setEnabled(false);
			this.actionCancelCancel.setEnabled(false);
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(false);			
			this.actionEdit.setEnabled(false);
		}


	}
	@Override
	public void actionRemove_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBaseStatus()!=null&&!this.editData.getBaseStatus().equals(FarmBaseStatusEnum.unApprove)) {
			MsgBox.showWarning("单据已经核准或禁用，禁止删除！");
			return;
		}
		super.actionRemove_actionPerformed(arg0);
	}
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("核准完成");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
		setUIStatus();
	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反核准完成");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
		setUIStatus();
	}

	@Override
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		//	super.actionCopy_actionPerformed(e);
		if (!(UtilRequest.isPrepare("ActionCopy", this)))
		{
			checkModified();
		}
		if ((this.editData != null) && (!(OprtState.VIEW.equals(getOprtState()))))
		{
			IObjectValue objectValue = (IObjectValue)getUIContext().get("CURRENT.VO");
			if (objectValue != null)
			{
				try
				{
					String id = this.idList.getID(this.idList.getCurrentIndex());
					setOprtState("RELEASEALL");
					pubFireVOChangeListener(id);
				}
				catch (Throwable E) {
				}
			}
		}
		ObjectValueUtil.copy(this.editData);
		unLockUI();
		setFieldsNull(this.editData);
		setOprtState("ADDNEW");
		this.editData.setBaseStatus(null);
		setDataObject(this.editData);
		loadFields();
		showCopyAddNew();
		this.actionCopy.setEnabled(false);
		this.chkMenuItemSubmitAndAddNew.setVisible(true);
		this.baseStatus.setSelectedIndex(0);
		setDefaultFocused();
	}

	@Override
	public boolean isPrepareActionPrint() {
		// TODO Auto-generated method stub
		return super.isPrepareActionPrint();
	}
	@Override
	public boolean isPrepareActionPrintPreview() {
		// TODO Auto-generated method stub
		return super.isPrepareActionPrintPreview();
	}
	@Override
	public void actionPrint_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if (editData == null)
			return;
		FarmBaseStatusEnum billBaseStatus = editData.getBaseStatus();
		if (editData.getId() == null
				|| billBaseStatus != null
				&& (billBaseStatus.getValue() == 0 || billBaseStatus.getValue() == 1)) {
			MsgBox.showInfo(this, InvClientUtils
					.getResource("CanPrintAndPrintView"));
			SysUtil.abort();
		}
		BeforeInvokePrintFunction(true);
	}
	@Override
	public void actionPrintPreview_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub

		if (editData == null)
			return;
		FarmBaseStatusEnum billBaseStatus = editData.getBaseStatus();
		if (editData.getId() == null
				|| billBaseStatus != null
				&& (billBaseStatus.getValue() == 0 || billBaseStatus.getValue() == 1)) {
			MsgBox.showInfo(this, InvClientUtils.getResource("CanPrintAndPrintView"));
			SysUtil.abort();
		}
		BeforeInvokePrintFunction(false);
	}



	protected void BeforeInvokePrintFunction(boolean isPrint) {
		// TODO Auto-generated method stub

		ArrayList idList;
		idList = new ArrayList();
		if (editData != null && !StringUtils.isEmpty(editData.getString("id")))
			idList.add(editData.getString("id"));
		if (idList == null || idList.size() == 0 || getTDQueryPK() == null|| getTDFileName() == null)
			return;
		try {
			String bosType = getBizInterface().getType().toString();
			IPrintIntegration printInte = PrintIntegrationFactory.getRemoteInstance();
			java.util.List infoList = printInte.getBillsPrintInfoByList(idList,bosType);
			if (infoList.size() > 0) {
				StringBuffer sb = new StringBuffer();
				SelectorItemCollection sic = new SelectorItemCollection();
				sic.add(new SelectorItemInfo("id"));
				sic.add(new SelectorItemInfo("number"));
				for (int i = 0; i < 1; i++) {
					PrintIntegrationInfo info = (PrintIntegrationInfo) infoList.get(i);
					PrintIntegrationInfo info2 = PrintIntegrationFactory.getRemoteInstance().getPrintIntegrationInfo(new ObjectUuidPK(info.getId()),getPrintIntegrationSelector());
					//修改处
					FarmerBorrowInfo bill = FarmerBorrowFactory.getRemoteInstance().getFarmerBorrowInfo(new ObjectUuidPK(info2.getPrintBillID()),sic);
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String lastPrtTime = format.format(info2.getLastPrintTime());
					sb.append(MessageFormat.format(EASResource.getString("com.kingdee.eas.scm.sd.sale.SALEAutoGenerateResource","58_SaleOrderEditUI"),new Object[] {bill.getNumber().toString(),info2.getLastPrintUser().getName().toString(),lastPrtTime,(new Integer(info2.getPrintedNumber())).toString() }));
				}
				int flag = 0;
				if (isPrint)
					flag = MsgBox.showConfirm2(MessageFormat.format(EASResource.getString("com.kingdee.eas.scm.sd.sale.SALEAutoGenerateResource","56_SaleOrderEditUI"),new Object[] { "\n\r\n\r",sb.toString() }));
				else
					flag = MsgBox.showConfirm2(MessageFormat.format(EASResource.getString("com.kingdee.eas.scm.sd.sale.SALEAutoGenerateResource","57_SaleOrderEditUI"),new Object[] { "\n\r\n\r",sb.toString() }));
				if (flag == 2)
					return;
			}
		} catch (Exception e) {
			super.handleException(e);
		}

		try {
			invokePrintFunction(isPrint);
		} catch (Exception e) {
			super.handleException(e);
		}
		return;

	}

	protected FilterInfo getPrintFilter(List ids) {
		FilterInfo filter = new FilterInfo();
		if (ids.size() == 1) {
			filter.getFilterItems().add(
					new FilterItemInfo("id", ids.toArray()[0].toString(),
							CompareType.EQUALS));
		} else {
			filter.getFilterItems().add(
					new FilterItemInfo("id", new HashSet(ids),
							CompareType.INCLUDE));
		}
		filter.getFilterItems().add(
				new FilterItemInfo("baseStatus", new Integer(0),
						CompareType.NOTEQUALS));
		filter.getFilterItems().add(
				new FilterItemInfo("baseStatus", new Integer(1),
						CompareType.NOTEQUALS));
		filter.setMaskString("#0 and #1 and #2");
		return filter;
	}


	protected void invokePrintFunction(boolean isPrint) {
		ArrayList idList = new ArrayList();
		if (editData != null && !StringUtils.isEmpty(editData.getString("id")))
			idList.add(editData.getString("id"));
		if (idList == null || idList.size() == 0 || getTDQueryPK() == null|| getTDFileName() == null)
			return;
		MultiDataSourceDataProviderProxy data = new MultiDataSourceDataProviderProxy();
		SCMCommonDataProvider mainQueryData = new SCMCommonDataProvider(idList,getTDQueryPK());
		mainQueryData.setFilter(getPrintFilter(idList));
		data.put("MainQuery", mainQueryData);
		MultiapproveDataProvider multiapproveDataSource = new MultiapproveDataProvider(getSelectedIdForPrint(), isShowMultiapproveHistoryForPrint(),"billId");
		multiapproveDataSource.setMultiapproveDataFilter(getMultiapproveDataFilter());
		data.put(getMultiapproveQueryNameForPrint(), multiapproveDataSource);
		KDNoteHelper appHlp = new KDNoteHelper();
		CommonPrintIntegrationDataProvider printQueryData = new CommonPrintIntegrationDataProvider(editData.getBOSType().toString(), PrintIntegrationManager.getPrintQueryPK());
		data.put("PrintQuery", printQueryData);
		PrintIntegrationManager.initPrint(appHlp, editData.getBOSType(),idList, getTDFileName(),"com.kingdee.eas.scm.common.SCMResource", true);
		if (isPrint)
			appHlp.print(getTDFileName(), data, SwingUtilities.getWindowAncestor(this));
		else
			appHlp.printPreview(getTDFileName(), data, SwingUtilities.getWindowAncestor(this));
	}


	private SelectorItemCollection getPrintIntegrationSelector() {
		SelectorItemCollection piSic = new SelectorItemCollection();
		piSic.add(new SelectorItemInfo("id"));
		piSic.add(new SelectorItemInfo("lastPrintTime"));
		piSic.add(new SelectorItemInfo("printedNumber"));
		piSic.add(new SelectorItemInfo("printBillID"));
		piSic.add(new SelectorItemInfo("lastPrintUser.name"));
		return piSic;
	}

	protected String getTDFileName() {
		return "/bim/farm/carnivorous/basedata/FarmerBorrow";
	}

	protected IMetaDataPK getTDQueryPK() {
		return new MetaDataPK("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerBorrowQuery");
	}

	@Override
	protected void setFieldsNull(AbstractObjectValue newData) {
		super.setFieldsNull(newData);
		newData.put("baseStatus", 1);
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.kDLabelContainer4.setVisible(false);
		this.btnPrint.setVisible(true);
		this.btnPrintPreview.setVisible(true);
		this.btnPrint.setEnabled(true);
		this.btnPrintPreview.setEnabled(true);
		this.actionPrintPreview.setEnabled(true);
		this.actionPrint.setEnabled(true);
		this.btnCancel.setEnabled(true);
		this.btnCancelCancel.setEnabled(true);
		//生成凭证按钮可见可编辑
		

		init();

	}
	private void init() {
		// TODO Auto-generated method stub

		this.prmtfarmerTree.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerGroupQuery");		
		this.prmtfarmerTree.setVisible(true);		
		this.prmtfarmerTree.setEditable(true);		
		this.prmtfarmerTree.setDisplayFormat("$name$");		
		this.prmtfarmerTree.setEditFormat("$number$");		
		this.prmtfarmerTree.setCommitFormat("$number$");		
		this.prmtfarmerTree.setRequired(false);

		//借款项目过滤
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("billStatue", 2, CompareType.EQUALS));
//		filter.getFilterItems().add(new FilterItemInfo("isTake", true, CompareType.EQUALS));
//		filter.setMaskString("#0 and #1");
		view.setFilter(filter);
		prmtbrowerItem.setEntityViewInfo(view);

		btnCancel.setVisible(false);
		btnCancelCancel.setVisible(false);

		prmtfarmer.addDataChangeListener(new DataChangeListener(){



			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				FarmerInfo farmerInfo = null;
				if(prmtfarmer.getValue() != null){
					farmerInfo = (FarmerInfo) prmtfarmer.getValue();
					try {
						farmerInfo = FarmerFactory.getRemoteInstance().getFarmerInfo(new ObjectUuidPK(farmerInfo.getId()));
						FarmerTreeInfo atreeInfo = farmerInfo.getTreeid();
						atreeInfo =  FarmerTreeFactory.getRemoteInstance().getFarmerTreeInfo(new ObjectUuidPK(atreeInfo.getId()));
						prmtfarmerTree.setValue(atreeInfo);
						txtaccountNum.setText(farmerInfo.getBankNo());

					} catch (EASBizException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BOSException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}



			}


		});


	}
	@Override
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		super.beforeStoreFields(arg0);

		if(new BigDecimal(txtamount.getValue().toString()).compareTo(BigDecimal.ZERO) <= 0){
			MsgBox.showConfirm2("金额必须大于0！");
			SysUtil.abort();

		}
	}
	@Override
	public void actionVoucher_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionVoucher_actionPerformed(e);
		
		if(editData.getId()==null)
			return;
		//校验生成凭证
		ArrayList<String> destObejctIDs = BOTRelationFactory.getRemoteInstance().getDestObjIdByDestType(editData.getId().toString(), "2652E01E");
//		if(destObejctIDs.size()==1){
//			CommFacadeFactory.getRemoteInstance().excuteUpdateSql("update CT_FM_MaiginBill set CFVoucherNumID='"+destObejctIDs.get(0)+"' where fid='"+editData.getString("id")+"'");
//		}
//		UIUtil.refreshEditUI(this);
		
	}



}