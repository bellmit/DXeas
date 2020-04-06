/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.feedbiz.client;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.swing.SwingUtilities;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.AbstractObjectValue;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.QueryInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.base.permission.PermissionFactory;
import com.kingdee.eas.basedata.assistant.IPrintIntegration;
import com.kingdee.eas.basedata.assistant.PrintIntegrationFactory;
import com.kingdee.eas.basedata.assistant.PrintIntegrationInfo;
import com.kingdee.eas.basedata.assistant.util.CommonPrintIntegrationDataProvider;
import com.kingdee.eas.basedata.assistant.util.PrintIntegrationManager;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.MaterialInventoryInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CostCenterOrgUnitFactory;
import com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.basedata.org.client.f7.StorageF7;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseCollection;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseFactory;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.CodingUtil;
import com.kingdee.eas.custom.commld.ListenerUtil;
import com.kingdee.eas.farm.carnivorous.basedata.FarmFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicy;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyFactory;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo;
import com.kingdee.eas.farm.carnivorous.basedata.SystemSettingCollection;
import com.kingdee.eas.farm.carnivorous.basedata.SystemSettingFactory;
import com.kingdee.eas.farm.carnivorous.basedata.SystemSettingInfo;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.BizTypeEnum;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBill;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.SeedSourceType;
import com.kingdee.eas.farm.hatch.HatchBabyBill;
import com.kingdee.eas.farm.hatch.HatchBaseData;
import com.kingdee.eas.farm.hatch.HatchBaseDataFactory;
import com.kingdee.eas.farm.hatch.HatchBaseDataInfo;
import com.kingdee.eas.farm.stocking.basedata.SettleItemType;
import com.kingdee.eas.farm.stocking.basedata.StockingFarmTypeEnum;
import com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillCollection;
import com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillFactory;
import com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillInfo;
import com.kingdee.eas.framework.ObjectValueUtil;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.framework.print.MultiapproveDataProvider;
import com.kingdee.eas.industry.emm.pm.SqlExecuteFacadeFactory;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.scm.common.util.MultiDataSourceDataProviderProxy;
import com.kingdee.eas.scm.common.util.SCMCommonDataProvider;
import com.kingdee.eas.scm.im.inv.client.InvClientUtils;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.util.PropertyContainer;

/**
 * output class name
 */
public class BreedSeedReceiveBillEditUI extends AbstractBreedSeedReceiveBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(BreedSeedReceiveBillEditUI.class);


	private String curStorageOrgUnitID;//当前库存组织
	private String curCompanyID;//当前财务组织
	private F7ContextManager f7Manager;
	private OrgUnitInfo orgInfo = null;//库存组织
	private boolean isLoadField=false;
	private SystemSettingInfo sysSetting;
	private boolean isHouseManager=false;
	private WarehouseInfo wareHouseInfo=null;

	/**
	 * output class constructor
	 */
	public BreedSeedReceiveBillEditUI() throws Exception
	{
		super();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
	}
	public void loadFields()
	{
		actionCopy.setVisible(false);
		actionCopy.setEnabled(true);
		isLoadField=true;
		DataChangeListener[] ls = prmtbatchContract.getListeners(DataChangeListener.class);
		for(int index=0;index<ls.length;index++) {
			prmtbatchContract.removeDataChangeListener(ls[index]);
		}
		super.loadFields(); 
		for(int index=0;index<ls.length;index++) {
			prmtbatchContract.addDataChangeListener(ls[index]);
		}
		isLoadField=false;
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(true);
		}else if (this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)){
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(false);
		}else {
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(true);
		}

		//业务员过滤
		StockingComm.makeApplierF7(prmtperson, ((IPropertyContainer)prmtcompany.getValue()).getString("id"), this, false);
	}


	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSubmit_actionPerformed(e);
		if(editData.getId()==null)
			super.actionPre_actionPerformed(e);
	}

	@Override
	public void actionEdit_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)||this.editData.getBillStatus().equals(BillBaseStatusEnum.CLOSED)) {
			MsgBox.showWarning("单据已经审核或关闭，禁止修改！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(arg0);
	}

	@Override
	public void actionRemove_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionRemove_actionPerformed(arg0);
	}


	/**
	 * output actionAudit_actionPerformed
	 */
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception
	{
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止再次审核！");
			SysUtil.abort();
		}
		if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)) {
			MsgBox.showWarning("单据尚未提交，禁止审核！");
			SysUtil.abort();
		}
		if(WorkFlowUtil.checkBillInWorkflow(null,editData.getId().toString())){
			MsgBox.showWarning("当前单据尚在工作流执行过程,不能执行该操作");
			SysUtil.abort();
		}
		super.actionAudit_actionPerformed(e);

		this.doAfterSave(new ObjectUuidPK(editData.getId()));

		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}
	/**
	 * output actionUnAudit_actionPerformed
	 */
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
	{
		if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据尚未审核，禁止反审核！");
			SysUtil.abort();
		}
		super.actionUnAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}



	public void actionClose_actionPerformed(ActionEvent e) throws Exception
	{
		if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据未审核，禁止关闭！");
			SysUtil.abort();
		}
		super.actionClose_actionPerformed(e);

		this.doAfterSave(new ObjectUuidPK(editData.getId()));

		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("关闭成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}

	public void actionUnClose_actionPerformed(ActionEvent e) throws Exception
	{
		if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.CLOSED)) {
			MsgBox.showWarning("单据尚未关闭，禁止反关闭！");
			SysUtil.abort();
		}
		super.actionUnClose_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反关闭成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}




	@Override
	public void actionAddLine_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAddLine_actionPerformed(e);
	}

	@Override
	public void actionAddNew_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAddNew_actionPerformed(e);
		isLoadField=false;
		setFilter();
	}

	@Override
	public void actionPrint_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if (editData == null)
			return;
		BillBaseStatusEnum billBaseStatus = editData.getBillStatus();
		if (editData.getId() == null
				|| billBaseStatus != null
				&& (billBaseStatus.getValue() == 0 || billBaseStatus.getValue() == 1)) {
			MsgBox.showInfo(this, InvClientUtils
					.getResource("CanPrintAndPrintView"));
			SysUtil.abort();
		}
		BeforeInvokePrintFunction(true);
	}

	public void actionPrintPreview_actionPerformed(ActionEvent e)
	throws Exception {
		if (editData == null)
			return;
		BillBaseStatusEnum billBaseStatus = editData.getBillStatus();
		if (editData.getId() == null
				|| billBaseStatus != null
				&& (billBaseStatus.getValue() == 0 || billBaseStatus.getValue() == 1)) {
			MsgBox.showInfo(this, InvClientUtils.getResource("CanPrintAndPrintView"));
			SysUtil.abort();
		}
		BeforeInvokePrintFunction(false);
	}

	protected void BeforeInvokePrintFunction(boolean isPrint) {
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
					BreedSeedReceiveBillInfo bill = BreedSeedReceiveBillFactory.getRemoteInstance().getBreedSeedReceiveBillInfo(new ObjectUuidPK(info2.getPrintBillID()),sic);
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

	private SelectorItemCollection getPrintIntegrationSelector() {
		SelectorItemCollection piSic = new SelectorItemCollection();
		piSic.add(new SelectorItemInfo("id"));
		piSic.add(new SelectorItemInfo("lastPrintTime"));
		piSic.add(new SelectorItemInfo("printedNumber"));
		piSic.add(new SelectorItemInfo("printBillID"));
		piSic.add(new SelectorItemInfo("lastPrintUser.name"));
		return piSic;
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
				new FilterItemInfo("billStatus", new Integer(0),
						CompareType.NOTEQUALS));
		filter.getFilterItems().add(
				new FilterItemInfo("billStatus", new Integer(1),
						CompareType.NOTEQUALS));
		filter.setMaskString("#0 and #1 and #2");
		return filter;
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
		return com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillFactory.getRemoteInstance();
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
		com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo()));
		objectValue.setBizDate(new java.util.Date());
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		//		objectValue.setStorageOrgUnit(SysContext.getSysContext().getCurrentStorageUnit());
		objectValue.setBizType(BizTypeEnum.Comm);
		objectValue.setBillStatus(BillBaseStatusEnum.ADD);
		curStorageOrgUnitID=SysContext.getSysContext().getCurrentStorageUnit().getString("id");
		return objectValue;
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		SystemSettingCollection coll = SystemSettingFactory.getRemoteInstance().getSystemSettingCollection("where company='"+SysContext.getSysContext().getCurrentFIUnit().getString("id")+"'");
		if(coll.size()==0) {
			MsgBox.showWarning("请设置系统参数");
			SysUtil.abort();
		}
		sysSetting=coll.get(0);
		curStorageOrgUnitID=sysSetting.getDefaultStorageOrgUnit().getString("id");
		curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		orgInfo = StorageOrgUnitFactory.getRemoteInstance().getOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID));
		f7Manager = new F7ContextManager(this, OrgType.Storage);
		initControl();
		((KDFormattedTextField)kdtEntrys.getColumn("amount").getEditor().getComponent()).setPrecision(2);
		((KDFormattedTextField)kdtEntrys.getColumn("actualCost").getEditor().getComponent()).setPrecision(2);
	}

	private void initControl() {
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));

		kdtEntrys.getColumn("actualAmt").getStyleAttributes().setLocked(true);
		
		

		// prmtstorageOrg		
		this.prmtstorageOrgUnit.setQueryInfo("com.kingdee.eas.farm.carnivorous.feedbiz.app.storageIsBizUnitQuery");		
		this.prmtstorageOrgUnit.setEditable(true);		
		this.prmtstorageOrgUnit.setDisplayFormat("$name$");		
		this.prmtstorageOrgUnit.setEditFormat("$number$");		
		this.prmtstorageOrgUnit.setCommitFormat("$number$");		
		this.prmtstorageOrgUnit.setRequired(true);


		this.pkBizDate.setDatePattern("yyyy-MM-dd");

		CompanyF7 cf7=new CompanyF7();
		cf7.setIsCUFilter(true);
		this.prmtcompany.setSelector(cf7);

		if(seedSourceType.getSelectedItem().equals(SeedSourceType.innerCollect)){
			prmtpurSupplier.setEnabled(false);
		}else{
			prmtpurSupplier.setEnabled(true);
		}

		StorageF7 sf7=new StorageF7();
		sf7.setIsCUFilter(true);
		//		this.prmtstorageOrgUnit.setSelector(sf7);

		f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtEntrys.getColumn("material").getEditor().getComponent(), null, null, orgInfo,false);
		f7Manager.registerMeasureUnitF7(kdtEntrys, "material", "unit");


		//设置棚舍的query
		//设置棚舍的查询
		final KDBizPromptBox kdtHouseEntry_house_PromptBox = new KDBizPromptBox();
		kdtHouseEntry_house_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.basedata.app.carviousFarmHouseQuery");
		kdtHouseEntry_house_PromptBox.setVisible(true);
		kdtHouseEntry_house_PromptBox.setEditable(true);
		kdtHouseEntry_house_PromptBox.setDisplayFormat("$number$");
		kdtHouseEntry_house_PromptBox.setEditFormat("$number$");
		kdtHouseEntry_house_PromptBox.setCommitFormat("$number$");
		KDTDefaultCellEditor kdtHouseEntry_house_CellEditor = new KDTDefaultCellEditor(kdtHouseEntry_house_PromptBox);
		this.kdtEntrys.getColumn("house").setEditor(kdtHouseEntry_house_CellEditor);
		ObjectValueRender kdtHouseEntry_house_OVR = new ObjectValueRender();
		kdtHouseEntry_house_OVR.setFormat(new BizDataFormat("$name$"));
		this.kdtEntrys.getColumn("house").setRenderer(kdtHouseEntry_house_OVR);


		final KDBizPromptBox kdtEntrys_material_PromptBox = new KDBizPromptBox();
		kdtEntrys_material_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery");
		kdtEntrys_material_PromptBox.setVisible(true);
		kdtEntrys_material_PromptBox.setEditable(true);
		kdtEntrys_material_PromptBox.setDisplayFormat("$number$");
		kdtEntrys_material_PromptBox.setEditFormat("$name$");
		kdtEntrys_material_PromptBox.setCommitFormat("$name$;$number$");
		KDTDefaultCellEditor kdtEntrys_material_CellEditor = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox);
		this.kdtEntrys.getColumn("material").setEditor(kdtEntrys_material_CellEditor);
		ObjectValueRender kdtEntrys_material_OVR = new ObjectValueRender();
		kdtEntrys_material_OVR.setFormat(new BizDataFormat("$number$"));
		this.kdtEntrys.getColumn("material").setRenderer(kdtEntrys_material_OVR);

		f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtEntrys.getColumn("material").getEditor().getComponent(), null, null, orgInfo,false);


		//仓库
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("storageOrg.id",curStorageOrgUnitID,CompareType.EQUALS));
		ev.setFilter(filter);
		((KDBizPromptBox) this.kdtEntrys.getColumn("warehouse").getEditor().getComponent()).setEntityViewInfo(ev);
		setFilter();
		this.prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setFilter();
			}
		});

		this.prmtstorageOrgUnit.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				storageOrgUnit_changed(e);

				//根据库存组织自动更新分录的领用仓库
				if(prmtstorageOrgUnit.getValue() != null){
					StorageOrgUnitInfo stoInfo = (StorageOrgUnitInfo) prmtstorageOrgUnit.getValue();
					//设置仓库
					for(int i =0,size = kdtEntrys.getRowCount();i<size;i++){
						if(kdtEntrys.getCell(i,"material").getValue()!=null) {
							MaterialInventoryInfo mivInfo;
							try {
								mivInfo = StockingComm.getDefaultWarehouseDataByMaterial(null, stoInfo.getId().toString(), ((IPropertyContainer)kdtEntrys.getCell(i,"material").getValue()).getString("id"));
								if(mivInfo!=null){
									kdtEntrys.getCell(i, "warehouse").setValue(mivInfo.getDefaultWarehouse());
								}
							} catch (EASBizException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (BOSException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}
			}});

		this.prmtfarmer.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				prmtfarm.setValue(null);
				if(!isLoadField) {
					DataChangeListener[] listner = ListenerUtil.F7GetDateChangeListener(prmtfarm);
					ListenerUtil.F7RemoveDateChangeListener(prmtfarm);
					if(prmtfarm.getValue()!=null){
						try {
							txtfarmAddress.setText((String) UIRuleUtil.getProperty((IObjectValue) prmtfarm.getValue(), "address"));
						} catch (DataAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (BOSException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					ListenerUtil.F7AddDateChangeListener(prmtfarm, listner);
				}
				setFilter();
			}});

		this.prmtfarm.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				prmtbatchContract.setValue(null);
				if(prmtfarm.getValue()!=null){
					if(!isLoadField) {
						FarmInfo farmInfo = ((FarmInfo)prmtfarm.getValue());
						try { 
							farmInfo = FarmFactory.getRemoteInstance().getFarmInfo(new ObjectUuidPK(farmInfo.getId()));
							txtfarmAddress.setText(farmInfo.getAddress());
						} catch (EASBizException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (BOSException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						FarmerInfo farmerInfo = StockingComm.getFarmerInfoByFarm(null,prmtfarm);
						DataChangeListener[] listner = ListenerUtil.F7GetDateChangeListener(prmtfarmer);
						ListenerUtil.F7RemoveDateChangeListener(prmtfarmer);
						prmtfarmer.setValue(farmerInfo);
						if(prmtfarmer.getValue()!=null){
							try {
								txtfarmerPhone.setText((String) UIRuleUtil.getProperty((IObjectValue) prmtfarmer.getValue(), "mobileTel"));
							} catch (DataAccessException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (BOSException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						ListenerUtil.F7AddDateChangeListener(prmtfarmer, listner);
					}
				}
				setFilter();

				//设置批次合同
				try {
					if(prmtfarmer.getValue() != null && prmtfarm.getValue() != null){
						String s1 = "/*dialect*/ select t1.fid billid from T_FM_BatchContractBill t1 where t1.CFIsRecSettled = 0 and t1.FFarmerID ='"+((FarmerInfo)prmtfarmer.getValue()).getId()+"' and t1.FFarmID = '"+((FarmInfo)prmtfarm.getValue()).getId()+"'";
						IRowSet r1 = SqlExecuteFacadeFactory.getRemoteInstance().executeQuery(s1);
						if(r1.next()){
							String billid = UIRuleUtil.getString(r1.getString("billid"));
							BatchContractBillInfo contractInfo = BatchContractBillFactory.getRemoteInstance().getBatchContractBillInfo(new ObjectUuidPK(billid));
							prmtbatchContract.setValue(contractInfo);
						}
					}
					prmtbatchContract_dataChange(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}});

		prmtbatchContract.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				prmtbatchContract_dataChange(arg0);
			}});


		try {
			ObjectUuidPK userID = new ObjectUuidPK(SysContext.getSysContext().getCurrentUserInfo().getId());
			ObjectUuidPK cuID = new ObjectUuidPK(SysContext.getSysContext().getCurrentCtrlUnit().getId());
			PermissionFactory.getRemoteInstance().checkFunctionPermission(userID, cuID, "isInitStockingBatchCrt");
		}catch(Exception err) {
		}

		kdtEntrys.getColumn("receiveQty").getStyleAttributes().setNumberFormat("#");
		kdtEntrys.getColumn("lossQty").getStyleAttributes().setNumberFormat("#");
		kdtEntrys.getColumn("supplementQty").getStyleAttributes().setNumberFormat("#");
		kdtEntrys.getColumn("allReceiveQty").getStyleAttributes().setNumberFormat("#");
		kdtEntrys.getColumn("confirmQty").getStyleAttributes().setNumberFormat("#");

		((KDFormattedTextField)kdtEntrys.getColumn("receiveQty").getEditor().getComponent()).setDataType(KDFormattedTextField.INTEGER);
		((KDFormattedTextField)kdtEntrys.getColumn("lossQty").getEditor().getComponent()).setDataType(KDFormattedTextField.INTEGER);
		((KDFormattedTextField)kdtEntrys.getColumn("supplementQty").getEditor().getComponent()).setDataType(KDFormattedTextField.INTEGER);
		((KDFormattedTextField)kdtEntrys.getColumn("allReceiveQty").getEditor().getComponent()).setDataType(KDFormattedTextField.INTEGER);
		((KDFormattedTextField)kdtEntrys.getColumn("confirmQty").getEditor().getComponent()).setDataType(KDFormattedTextField.INTEGER);


		seedSourceType.addItemListener(new ItemListener(){

			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(seedSourceType.getSelectedItem().equals(SeedSourceType.innerCollect)){
					prmtpurSupplier.setValue(null);
					prmtpurSupplier.setEnabled(false);
				}else{
					prmtpurSupplier.setEnabled(true);
				}
			}});

		prmtsourceHatchArea.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {
				setFilter();

				//根据孵化场 自动设置孵化场对应的库存组织
				if(prmtsourceHatchArea.getValue() != null){
					HatchBaseDataInfo hatchInfo = (HatchBaseDataInfo) prmtsourceHatchArea.getValue();
					try {
						hatchInfo = HatchBaseDataFactory.getRemoteInstance().getHatchBaseDataInfo(new ObjectUuidPK(hatchInfo.getId()));
						if(hatchInfo.getHatchFactory() != null){
							StorageOrgUnitInfo stInfo = hatchInfo.getHatchFactory();
							stInfo = StorageOrgUnitFactory.getRemoteInstance().getStorageOrgUnitInfo(new ObjectUuidPK(stInfo.getId()));
							prmtstorageOrgUnit.setValue(stInfo);

							//设置仓库
							for(int i =0,size = kdtEntrys.getRowCount();i<size;i++){
								if(kdtEntrys.getCell(i,"material").getValue()!=null) {
									StorageOrgUnitInfo stoInfo = (StorageOrgUnitInfo) prmtstorageOrgUnit.getValue();
									MaterialInventoryInfo mivInfo= StockingComm.getDefaultWarehouseDataByMaterial(null, stoInfo.getId().toString(), ((IPropertyContainer)kdtEntrys.getCell(i,"material").getValue()).getString("id"));
									if(mivInfo!=null){
										kdtEntrys.getCell(i, "warehouse").setValue(mivInfo.getDefaultWarehouse());
									}
								}
							}
						}
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
	protected void prmtbatchContract_dataChange(DataChangeEvent arg0) {
		// TODO Auto-generated method stub
		if(prmtbatchContract.getValue()!=null){
			String batchContractID = ((IPropertyContainer)prmtbatchContract.getValue()).getString("id");
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("*");
			slor.add("breedData.*");
			slor.add("farmer.*");
			slor.add("farm.*");
			slor.add("person.*");
			slor.add("batch.*");
			slor.add("settlementPolicy.*");
			try {
				BatchContractBillInfo contractInfo = BatchContractBillFactory.getRemoteInstance().getBatchContractBillInfo(new ObjectUuidPK(batchContractID),slor );
				prmtbreedData.setValue(contractInfo.getBreedData());
				prmtperson.setValue(contractInfo.getPerson());

				//根据批次合同的雏苗投入政策自动带出 整的单价
				BigDecimal policyPrice = BigDecimal.ZERO;
				if(contractInfo.getPutPolicy() != null){
					String s1 = "/*dialect*/ select t2.CFCostPrice costPrice from CT_FM_InvestmentPolicyChicken t1" +
					" inner join CT_FM_InvestmentPCE t2 on t2.fparentid = t1.fid where t1.fid = '"+contractInfo.getPutPolicy().getId()+"'";
					IRowSet r1 = SqlExecuteFacadeFactory.getRemoteInstance().executeQuery(s1);
					if(r1.next()){
						policyPrice = UIRuleUtil.getBigDecimal(r1.getBigDecimal("costPrice"));
					}
				}
				if(contractInfo.getCostCenter() != null){
					CostCenterOrgUnitInfo costCenter = CostCenterOrgUnitFactory.getRemoteInstance().getCostCenterOrgUnitInfo(new ObjectUuidPK(contractInfo.getCostCenter().getId()));
					prmtcostObject.setValue(costCenter);
				}
				prmtbatch.setValue(contractInfo.getBatch());
				ArrayList<String> seedIDs=StockingComm.getSeedIDs(null, contractInfo.getBreedData().getId().toString());
				if(seedIDs.size()==0||seedIDs.size()>1){
					MsgBox.showWarning("品种资料对应种苗物料未维护或维护了多个!");
					prmtbatchContract.setValue(null);
					return;
				}else{
					MaterialInfo seed=MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(seedIDs.get(0)));
					kdtEntrys.removeRows();
					IRow row = kdtEntrys.addRow();
					row.getCell("material").setValue(seed);
					row.getCell("materialName").setValue(seed.getName());
					row.getCell("model").setValue(seed.getModel());
					row.getCell("unit").setValue(seed.getBaseUnit());
					row.getCell("receiveQty").setValue(contractInfo.getFemaleBreedQty());
					row.getCell("contractPrice").setValue(UIRuleUtil.getBigDecimal(contractInfo.getBreedPrice()));
					row.getCell("receivePrice").setValue(policyPrice);
					row.getCell("basePrice").setValue(policyPrice);
					row.getCell("policySettleAmt").setValue(UIRuleUtil.getBigDecimal(contractInfo.getFemaleBreedQty()).multiply(policyPrice));
					row.getCell("allReceiveQty").setValue(contractInfo.getFemaleBreedQty());
					prmtsettlePolicy.setValue(contractInfo.getSettlementPolicy());
					kdtEntrys_Changed(row.getRowIndex(), kdtEntrys.getColumnIndex("material"));
				}
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			prmtbreedData.setValue(null);
			prmtperson.setValue(null);
			prmtbatch.setValue(null);
			prmtsettlePolicy.setValue(null);
			kdtEntrys.removeRows();
		}
		setFilter();
	}
	//设置隔离
	private void setFilter() {
		// TODO Auto-generated method stub

		if(this.prmtcompany.getValue()!=null) {
			curCompanyID=((IPropertyContainer) this.prmtcompany.getValue()).getString("id");
		}else{
			curCompanyID=null;
		}

		String farmerID=null,farmID=null,houseID=null;
		if(prmtfarmer.getValue()!=null) {
			farmerID=((IPropertyContainer) prmtfarmer.getValue()).getString("id");
		}
		if(prmtfarm.getValue()!=null) {
			farmID=((IPropertyContainer) prmtfarm.getValue()).getString("id");
		}
		prmtbatch.setRequired(false);
		//养殖户过滤
		StockingComm.setFarmerFilter(prmtfarmer, curCompanyID,false);
		//养殖场过滤
		StockingComm.setFarmFilter(this.prmtfarm, curCompanyID, farmerID,true);

		//合同过滤
		StockingComm.setContractFilterByFarmer(prmtfarmer, prmtfarm, prmtbatchContract, curCompanyID,true);

		//棚舍过滤根据养殖场
		EntityViewInfo view = new EntityViewInfo(); 
		FilterInfo filter = new FilterInfo(); 
		//添加新的筛选条件，按照当前组织过滤
		filter.getFilterItems().add(new FilterItemInfo("parent.id", farmID ,CompareType.EQUALS)); 
		//筛选条件
		view.setFilter(filter);
		//为公司重新设置F7的视图
		((KDBizPromptBox)kdtEntrys.getColumn("house").getEditor().getComponent()).setEntityViewInfo(view); 

		//库存组织根据财务组织过滤
		this.prmtstorageOrgUnit.setQueryInfo("com.kingdee.eas.farm.carnivorous.feedbiz.app.storageIsBizUnitQuery");		
		this.prmtstorageOrgUnit.setEditable(true);		
		this.prmtstorageOrgUnit.setDisplayFormat("$name$");		
		this.prmtstorageOrgUnit.setEditFormat("$number$");
		this.prmtstorageOrgUnit.setCommitFormat("$number$");		
		this.prmtstorageOrgUnit.setRequired(true);
		FilterInfo outStoFilter=new FilterInfo();
		EntityViewInfo outStoevi=new EntityViewInfo();
		outStoFilter.getFilterItems().add(new FilterItemInfo("company.id",curCompanyID,CompareType.EQUALS));
		outStoevi.setFilter(outStoFilter);
		this.prmtstorageOrgUnit.setEntityViewInfo(outStoevi);





		//供应商过滤
		if(prmtsourceHatchArea.getValue()!=null){
			HatchBaseDataInfo hatchBaseDataInfo;
			try {

				hatchBaseDataInfo = HatchBaseDataFactory.getRemoteInstance().getHatchBaseDataInfo(new ObjectUuidPK(((IPropertyContainer)prmtsourceHatchArea.getValue()).getString("id")));
				String purCompanyID = hatchBaseDataInfo.getHatchFactory().getId().toString();	
				for(int i=1;SQLExecutorFactory.getRemoteInstance("select *from T_ORG_Company where fid ='"+purCompanyID+"'").executeSQL().size()==0||i>100;i++){
					StorageOrgUnitInfo purCompany=StorageOrgUnitFactory.getRemoteInstance().getStorageOrgUnitInfo(new ObjectUuidPK(purCompanyID));
					purCompanyID=purCompany.getParent().getId().toString();
				}
				CompanyOrgUnitInfo purCompany=CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK(purCompanyID));
				f7Manager.registerBizSupplierF7(prmtpurSupplier, null, null, purCompany);
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			f7Manager.registerBizSupplierF7(prmtpurSupplier, null, null, SysContext.getSysContext().getCurrentOrgUnit());
		}
		prmtpurSupplier.setDisplayFormat("$name$");
		prmtpurSupplier.setEditFormat("$number$");
		prmtpurSupplier.setCommitFormat("$number$");
	}

	private void storageOrgUnit_changed(DataChangeEvent e){
		if(e.getNewValue()==null) {
			curStorageOrgUnitID=null;
		}else{
			curStorageOrgUnitID=((PropertyContainer) this.prmtstorageOrgUnit.getValue()).getString("id");
			try {
				orgInfo = StorageOrgUnitFactory.getRemoteInstance().getOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID));
			} catch (EASBizException e1) {
				e1.printStackTrace();
			} catch (BOSException e1) {
				e1.printStackTrace();
			}
		}
		//仓库
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("storageOrg.id",curStorageOrgUnitID,CompareType.EQUALS));
		ev.setFilter(filter);
		((KDBizPromptBox) this.kdtEntrys.getColumn("warehouse").getEditor().getComponent()).setEntityViewInfo(ev);
	}

	@Override
	public void kdtEntrys_Changed(int rowIndex, int colIndex) throws Exception {
		// TODO Auto-generated method stub
		super.kdtEntrys_Changed(rowIndex, colIndex);


		if(kdtEntrys.getColumn(colIndex).getKey().equals("material")) {
			//设置仓库
			if(kdtEntrys.getCell(rowIndex,"material").getValue()!=null) {
				if(prmtbatchContract.getValue()!=null){
					String batchContractID = ((IPropertyContainer)prmtbatchContract.getValue()).getString("id");
					BatchContractBillInfo contractInfo = BatchContractBillFactory.getRemoteInstance().getBatchContractBillInfo(new ObjectUuidPK(batchContractID));
					kdtEntrys.getCell(rowIndex, "receiveQty").setValue(contractInfo.getFemaleBreedQty());
				}

				StorageOrgUnitInfo stoInfo = (StorageOrgUnitInfo) prmtstorageOrgUnit.getValue();
				if(stoInfo != null){
					MaterialInventoryInfo mivInfo= StockingComm.getDefaultWarehouseDataByMaterial(null, stoInfo.getId().toString(), ((IPropertyContainer)kdtEntrys.getCell(rowIndex,"material").getValue()).getString("id"));
					if(mivInfo!=null){
						kdtEntrys.getCell(rowIndex, "warehouse").setValue(mivInfo.getDefaultWarehouse());
					}
				}
				calAmount(rowIndex);
			}
		}

		if(kdtEntrys.getColumn(colIndex).getKey().equals("allReceiveQty")) {
			kdtEntrys_Changed(rowIndex, kdtEntrys.getColumnIndex("material"));
		}

		if("warehouse".equals(kdtEntrys.getColumnKey(colIndex))){
			if(kdtEntrys.getCell(rowIndex, colIndex).getValue()!=null)
				wareHouseInfo=(WarehouseInfo) kdtEntrys.getCell(rowIndex, colIndex).getValue();
		}
		kdtEntrys.getCell(rowIndex, "confirmQty").setValue(kdtEntrys.getCell(rowIndex, "allReceiveQty").getValue());
		kdtEntrys.getCell(rowIndex, "amount").setValue(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex,"receivePrice").getValue()).multiply(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex,"confirmQty").getValue())).setScale(2, RoundingMode.HALF_UP));
		//分录金额计算
		if(kdtEntrys.getColumn(colIndex).getKey().equals("receivePrice")
				|| kdtEntrys.getColumn(colIndex).getKey().equals("allReceiveQty")
				|| kdtEntrys.getColumn(colIndex).getKey().equals("contractPrice")
				|| kdtEntrys.getColumn(colIndex).getKey().equals("actualPrice")){
			calAmount(rowIndex);
		}
		//分录单价计算
		if(kdtEntrys.getColumn(colIndex).getKey().equals("policySettleAmt")
				|| kdtEntrys.getColumn(colIndex).getKey().equals("contractAmt")
				|| kdtEntrys.getColumn(colIndex).getKey().equals("actualAmt")){
			calPrice(rowIndex);
		}



		//备份实际领用数量
		if(kdtEntrys.getCell(rowIndex, "allReceiveQty").getValue() != null){
			kdtEntrys.getCell(rowIndex, "allRQty").setValue(kdtEntrys.getCell(rowIndex, "allReceiveQty").getValue());
		}
		//备份路损数量
		if(kdtEntrys.getCell(rowIndex, "giftQty").getValue() != null){
			kdtEntrys.getCell(rowIndex, "gqty").setValue(kdtEntrys.getCell(rowIndex, "giftQty").getValue());
		}


	}
	/**
	 * 计算单价
	 * @param rowIndex
	 */
	private void calPrice(int rowIndex) {

		BigDecimal policySettleAmt = UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "policySettleAmt").getValue());
		BigDecimal contractAmt = UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "contractAmt").getValue());
		BigDecimal actualAmt = UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "actualAmt").getValue());
		BigDecimal allReceiveQty = UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "allReceiveQty").getValue());

		kdtEntrys.getCell(rowIndex, "receivePrice").setValue(policySettleAmt.divide(allReceiveQty,2,BigDecimal.ROUND_HALF_UP));
		kdtEntrys.getCell(rowIndex, "contractPrice").setValue(contractAmt.divide(allReceiveQty,2,BigDecimal.ROUND_HALF_UP));
		kdtEntrys.getCell(rowIndex, "actualPrice").setValue(actualAmt.divide(allReceiveQty,2,BigDecimal.ROUND_HALF_UP));

	}
	/**
	 * 政策单价，合同结算单价，实际开票价格根据实际领用数量，自动计算对应金额
	 * @param rowIndex 
	 */
	private void calAmount(int rowIndex) {
		// TODO Auto-generated method stub

		BigDecimal receivePrice = UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "receivePrice").getValue());
		BigDecimal contractPrice = UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "contractPrice").getValue());
		BigDecimal actualPrice = UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "actualPrice").getValue());
		BigDecimal allReceiveQty = UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "allReceiveQty").getValue());

		kdtEntrys.getCell(rowIndex, "policySettleAmt").setValue(receivePrice.multiply(allReceiveQty));
		kdtEntrys.getCell(rowIndex, "contractAmt").setValue(contractPrice.multiply(allReceiveQty));
		kdtEntrys.getCell(rowIndex, "actualAmt").setValue(actualPrice.multiply(allReceiveQty));

	}
	@Override
	protected void setFieldsNull(AbstractObjectValue obj) {
		// TODO Auto-generated method stub
		super.setFieldsNull(obj);
	}


	@Override
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		if(!UtilRequest.isPrepare("ActionCopy", this))
			checkModified();
		if(editData != null && !OprtState.VIEW.equals(getOprtState()))
		{
			IObjectValue objectValue = (IObjectValue)getUIContext().get("CURRENT.VO");
			if(objectValue != null)
				try
			{
					String id = idList.getID(idList.getCurrentIndex());
					setOprtState("RELEASEALL");
					pubFireVOChangeListener(id);
			}
			catch(Throwable E) { }
		}
		ObjectValueUtil.copy(editData);
		unLockUI();
		setFieldsNull(editData);
		editData.setBillStatus(BillBaseStatusEnum.ADD);
		//        editData.setFarmer(null);
		editData.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		editData.setNumber(CodingUtil.createNumberByCodingRule(null, editData, SysContext.getSysContext().getCurrentFIUnit()));
		setOprtState("ADDNEW");
		setDataObject(editData);
		loadFields();
		showCopyAddNew();
		actionCopy.setEnabled(false);
		chkMenuItemSubmitAndAddNew.setVisible(true);
		setDefaultFocused();
		isLoadField=false;
		setMakeRelations(null);
	}
	@Override
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		super.beforeStoreFields(arg0);

		if(prmtfarm.getValue() != null){
			FarmInfo farmInfo = (FarmInfo) prmtfarm.getValue();
			//如果养殖类型是公司自养  棚舍不允许为空
			if(farmInfo.getFarmType().equals(StockingFarmTypeEnum.company)){
				for(int i=0;i<kdtEntrys.getRowCount();i++){
					if(UIRuleUtil.isNull(kdtEntrys.getCell(i, "house").getValue())){
						MsgBox.showWarning("第"+(i+1)+"行分录棚舍不能为空!");
						SysUtil.abort();
					}
				}
			}
		}
		if(seedSourceType.getSelectedItem()==SeedSourceType.innerCollect&&prmtsourceHatchArea.getValue()==null){
			MsgBox.showWarning("雏苗来源类型为"+SeedSourceType.innerCollect.getAlias()+"的情况下必须填写来源孵化场!");
			SysUtil.abort();
		}
		if(seedSourceType.getSelectedItem()==SeedSourceType.outPur&&prmtpurSupplier.getValue()==null){
			MsgBox.showWarning("雏苗来源类型为"+SeedSourceType.outPur.getAlias()+"的情况下必须填写外购供应商!");
			SysUtil.abort();
		}
	}



	/**
	 * 合计行
	 */
	@Override
	protected void setTableToSumField() {
		// TODO Auto-generated method stub
		setTableToSumField(kdtEntrys, new String[]{"actualCost","receiveQty","lossQty","supplementQty","allReceiveQty","confirmQty"});
	}
	@Override
	protected void setTableToSumField(KDTable arg0, String[] arg1) {
		// TODO Auto-generated method stub
		super.setTableToSumField(arg0, arg1);
	}

	/**
	 * 计算政策价格及路耗数量
	 * @param rowIndex
	 * @param materialID
	 */
	private void calAveragePrice(int rowIndex, String materialID) {
		String  policyID="";
		if(prmtbatchContract.getValue()!=null){
			try {
				policyID=((SettlePolicyInfo)UIRuleUtil.getProperty((IObjectValue) prmtbatchContract.getValue(), "settlementPolicy")).getId().toString();
				SettlePolicyInfo policy=SettlePolicyFactory.getRemoteInstance().getSettlePolicyInfo(new ObjectUuidPK(policyID));
				BigDecimal lossRate=policy.getRoadLossRate()==null?BigDecimal.ZERO:policy.getRoadLossRate();
				BigDecimal price = StockingComm.getBasePrice(null, policyID, materialID);
				BigDecimal qty=	UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "allReceiveQty").getValue());
				kdtEntrys.getCell(rowIndex, "basePrice").setValue(price);
				kdtEntrys.getCell(rowIndex, "receivePrice").setValue(price);
				kdtEntrys.getCell(rowIndex, "giftQty").setValue(qty.multiply(lossRate).divide(new BigDecimal(100)));
			} catch (DataAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}