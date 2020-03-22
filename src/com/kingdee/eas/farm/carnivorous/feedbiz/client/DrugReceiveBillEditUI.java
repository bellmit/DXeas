/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.feedbiz.client;

import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.SwingUtilities;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;
import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.KDWorkButton;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.bot.BOTRelationFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.base.permission.PermissionFactory;
import com.kingdee.eas.base.uiframe.client.UIModelDialog;
import com.kingdee.eas.basedata.assistant.IPrintIntegration;
import com.kingdee.eas.basedata.assistant.PrintIntegrationFactory;
import com.kingdee.eas.basedata.assistant.PrintIntegrationInfo;
import com.kingdee.eas.basedata.assistant.util.CommonPrintIntegrationDataProvider;
import com.kingdee.eas.basedata.assistant.util.PrintIntegrationManager;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.MaterialInventoryInfo;
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
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.commld.CodingUtil;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.custom.commld.ListenerUtil;
import com.kingdee.eas.custom.commld.UIUtil;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyPriceEntryCollection;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyPriceEntryFactory;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyPriceEntryInfo;
import com.kingdee.eas.farm.carnivorous.basedata.SystemSettingInfo;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.DrugBizType;
import com.kingdee.eas.farm.carnivorous.feedbiz.DrugReceiveBill;
import com.kingdee.eas.farm.carnivorous.feedbiz.DrugReceiveBillEntry;
import com.kingdee.eas.farm.carnivorous.feedbiz.DrugReceiveBillEntryInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.DrugReceiveBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.DrugReceiveBillInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.FodderBillType;
import com.kingdee.eas.farm.stocking.basedata.SettleItemType;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillFactory;
import com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillInfo;
import com.kingdee.eas.framework.ObjectValueUtil;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent;
import com.kingdee.eas.framework.print.MultiapproveDataProvider;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.framework.report.util.RptRowSet;
import com.kingdee.eas.industry.emm.pm.SqlExecuteFacadeFactory;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.scm.common.util.MultiDataSourceDataProviderProxy;
import com.kingdee.eas.scm.common.util.SCMCommonDataProvider;
import com.kingdee.eas.scm.im.inv.MaterialReqBillInfo;
import com.kingdee.eas.scm.im.inv.StockTransferBillInfo;
import com.kingdee.eas.scm.im.inv.client.InvClientUtils;
import com.kingdee.eas.scm.im.rpt.InOutStoreGatherReportFacadeFactory;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.IToolFacade;
import com.kingdee.eas.wlhlcomm.ToolFacadeFactory;
import com.kingdee.eas.wlhlcomm.impl.DetailPanelBackListener;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.util.PropertyContainer;

/**
 * output class name
 */
public class DrugReceiveBillEditUI extends AbstractDrugReceiveBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(DrugReceiveBillEditUI.class);
	private String curStorageOrgUnitID;//当前库存组织
	private String curCompanyID;//当前财务组织
	private F7ContextManager f7Manager;
	private OrgUnitInfo orgInfo = null;//库存组织
	private KDWorkButton showInventory;
	private boolean isLoadField=false;
	private SystemSettingInfo sysSetting;
	private WarehouseInfo wareHouseInfo=null;
	private String keyVa = null;
	//复制的时候修改养殖户养殖场批次信息不删掉分录信息
	private boolean isCopy = false;
	/**
	 * output class constructor
	 */
	public DrugReceiveBillEditUI() throws Exception{
		super();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
	}

	/**
	 * output storeFields method
	 */
	public void storeFields(){
		super.storeFields();
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception{
		return com.kingdee.eas.farm.carnivorous.feedbiz.DrugReceiveBillFactory.getRemoteInstance();
	}

	public void loadFields(){
		actionCopy.setVisible(false);
		actionCopy.setEnabled(true);
		DataChangeListener[] ls = this.prmtbatch.getListeners(DataChangeListener.class);
		for(int i=0;i<ls.length;i++) {
			this.prmtbatch.removeDataChangeListener(ls[i]);
		}
		isLoadField=true;
		super.loadFields(); 
		isLoadField=false;

		for(int i=0;i<ls.length;i++) {
			this.prmtbatch.addDataChangeListener(ls[i]);
		}

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

		setEntryInv();

		//仓库
		try {
			if(prmtstorageOrgUnit.getValue()!=null)
				curStorageOrgUnitID=(UIRuleUtil.getProperty((IObjectValue) prmtstorageOrgUnit.getValue(), "ID")).toString();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("storageOrg.id",curStorageOrgUnitID,CompareType.EQUALS));
		ev.setFilter(filter);
		((KDBizPromptBox) this.kdtEntrys.getColumn("warehouse").getEditor().getComponent()).setEntityViewInfo(ev);

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
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		isCopy = false;
		super.actionSubmit_actionPerformed(e);
		//		actionAudit_actionPerformed(e);
	}

	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		isCopy = false;
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)||this.editData.getBillStatus().equals(BillBaseStatusEnum.CLOSED)) {
			MsgBox.showWarning("单据已经审核或关闭，禁止修改！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);
	}

	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionRemove_actionPerformed(e);
	}



	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		isCopy = false;
		super.actionSave_actionPerformed(e);
	}

	/**
	 * output actionAudit_actionPerformed
	 */
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception
	{
		isCopy = false;
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止再次审核！");
			SysUtil.abort();
		}
		if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)) {
			MsgBox.showWarning("单据尚未提交，禁止审核！");
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
					DrugReceiveBillInfo bill = DrugReceiveBillFactory.getRemoteInstance().getDrugReceiveBillInfo(new ObjectUuidPK(info2.getPrintBillID()),sic);
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
			filter.getFilterItems().add(new FilterItemInfo("id", ids.toArray()[0].toString(),CompareType.EQUALS));
		} else {
			filter.getFilterItems().add(new FilterItemInfo("id", new HashSet(ids),CompareType.INCLUDE));
		}
		filter.getFilterItems().add(new FilterItemInfo("billStatus", new Integer(0),CompareType.NOTEQUALS));
		filter.getFilterItems().add(new FilterItemInfo("billStatus", new Integer(1),CompareType.NOTEQUALS));
		filter.setMaskString("#0 and #1 and #2");
		return filter;
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
		com.kingdee.eas.farm.carnivorous.feedbiz.DrugReceiveBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.feedbiz.DrugReceiveBillInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo()));
		objectValue.setBizDate(new Date());
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		try {
			objectValue.setStorageOrgUnit(SysContext.getSysContext().getCurrentStorageUnit());
		}catch(Exception err) {
		}
		curStorageOrgUnitID=SysContext.getSysContext().getCurrentStorageUnit().getString("id");
		return objectValue;
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		sysSetting = StockingComm.getSystemSettingInfo(null, SysContext.getSysContext().getCurrentFIUnit().getString("id"));
		if(sysSetting==null) {
			MsgBox.showWarning("请设置系统参数");
			SysUtil.abort();
		}

		curStorageOrgUnitID=sysSetting.getDefaultStorageOrgUnit().getString("id");
		curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		super.onLoad();
		orgInfo = StorageOrgUnitFactory.getRemoteInstance().getOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID));
		f7Manager = new F7ContextManager(this, OrgType.Storage);
		initControl();
		chkisInit.setVisible(false);

	}
	private void initControl() {
		this.btnCopy.setVisible(true);
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));

		CompanyF7 cf7=new CompanyF7();
		cf7.setIsCUFilter(true);
		this.prmtcompany.setSelector(cf7);

		StorageF7 sf7=new StorageF7();
		sf7.setIsCUFilter(true);
		this.prmtstorageOrgUnit.setSelector(sf7);

		this.prmtbatchContract.setRequired(true);

		f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtEntrys.getColumn("material").getEditor().getComponent(), null, null, orgInfo,false);
		f7Manager.registerMeasureUnitF7(kdtEntrys, "material", "unit");

		UIUtil.setQualityPhaseDisplayFormat(new KDTable[]{kdtEntrys}, HorizontalAlignment.RIGHT);

		//分录添加监听事件
		this.kdtEntrys.addKDTEditListener(new KDTEditAdapter(){

			@Override
			public void editStarting(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStarting(e);


			}

			@Override
			public void editStarted(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStarted(e);

				//点击批号字段的时候，自动弹出来一个ui界面，用于存放批次和即时库存
				if(kdtEntrys.getColumn(e.getColIndex()).getKey().equals("lot")
						&& kdtEntrys.getCell(e.getRowIndex(), "warehouse").getValue() != null
						&& kdtEntrys.getCell(e.getRowIndex(), "material").getValue() != null
						&& prmtstorageOrgUnit.getValue() != null){

					StorageOrgUnitInfo stoInmfo = (StorageOrgUnitInfo) prmtstorageOrgUnit.getValue();
					MaterialInfo matiNfo = (MaterialInfo) kdtEntrys.getCell(e.getRowIndex(), "material").getValue();
					WarehouseInfo wareHouseInfo = (WarehouseInfo) kdtEntrys.getCell(e.getRowIndex(), "warehouse").getValue();
					Map map=new UIContext(this);

					//通过物料和库存组织查询即时库存
					try {
						IToolFacade tool = ToolFacadeFactory.getRemoteInstance();
						RptParams para = tool.getInOutStoreGatherParam(stoInmfo.getId().toString(),
								wareHouseInfo.getId().toString(), new Date(), new Date(),matiNfo.getId().toString());

						RptParams rpt = InOutStoreGatherReportFacadeFactory.getRemoteInstance().query(para, 0, 10000);
						Map resultMap = rpt.toMap();
						RptRowSet rrs =  (RptRowSet) resultMap.get("rowset");

						List<Map> lotList = new ArrayList<Map>();

						Map<String,BigDecimal> lotMap = null;
						while(rrs.next()){
							lotMap = new HashMap<String,BigDecimal>();
							//物料的 编码，ID，名称,批次，规格型号，期初，期末数量
							String materialNumber=rrs.getString("FMATERIALNUMBER");
							String materialName=rrs.getString("FMATERIALNAME");
							String lot=rrs.getString("FLOT");
							String model=rrs.getString("FMATERIALSIZE");

							BigDecimal beginQty = rrs.getBigDecimal("FBEGINQTY");//期初数量
							BigDecimal beginAMT = rrs.getBigDecimal("FBEGINAMT");//期初金额
							BigDecimal endQty=rrs.getBigDecimal("FENDQTY");//期末数量
							lotMap.put(lot, endQty);
							lotList.add(lotMap);

						}
						map.put("lotList",lotList);
						IUIWindow uiWindow=null; 
						String scanUI = "com.kingdee.eas.farm.carnivorous.feedbiz.client.BatchAndInv";
						uiWindow = (UIModelDialog) UIFactory.createUIFactory(UIFactoryName.MODEL).create(
								scanUI, map, null, OprtState.VIEW);
						uiWindow.show();
						//获取返回的 物料明细
						Map<String,BigDecimal> choMap = (Map<String, BigDecimal>) uiWindow.getUIObject().getUIContext().get("billNums");
						Set<String> keySet = choMap.keySet();
						Iterator<String> it = keySet.iterator();
						while(it.hasNext()){
							String keyVa1 = it.next();
							kdtEntrys.getCell(e.getRowIndex(),"lot").setValue(keyVa1);
							BigDecimal inventory = choMap.get(keyVa1);
							//设置数量
							kdtEntrys.getCell(e.getRowIndex(),"batchInv").setValue(inventory);
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}

				}

			}

			@Override
			public void editStopping(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStopping(e);

			}

			@Override
			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStopped(e);

			}



		});



		this.prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {

			}});

		this.prmtstorageOrgUnit.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				storageOrgUnit_changed(e);
			}});

		this.prmtfarmer.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				prmtfarm.setValue(null);
				if(prmtfarmer.getValue()!=null){
					if(!isLoadField) {
						String farmerID=null,farmID=null;
						DataChangeListener[] listener = ListenerUtil.F7GetDateChangeListener(prmtfarm);
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
						ListenerUtil.F7AddDateChangeListener(prmtfarm, listener);
						farmerID=((IPropertyContainer)prmtfarmer.getValue()).getString("id");
						isLoadField=false;
					}}
				setFilter();
			}});

		this.prmtfarm.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				prmtbatchContract.setValue(null);
				if(prmtfarm.getValue()!=null){
					if(!isLoadField){
						isLoadField=true;
						DataChangeListener[] listener = ListenerUtil.F7GetDateChangeListener(prmtfarmer);
						ListenerUtil.F7RemoveDateChangeListener(prmtfarmer);
						prmtfarmer.setValue(StockingComm.getFarmerInfoByFarm(null, prmtfarm));
						ListenerUtil.F7AddDateChangeListener(prmtfarmer, listener);
						String farmerID = null;
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
//							String farmID=((IPropertyContainer)prmtfarm.getValue()).getString("id");
//							FarmInfo farm;
//							try {
//								farm = FarmFactory.getRemoteInstance().getFarmInfo(new ObjectUuidPK(farmID));
//							} catch (EASBizException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							} catch (BOSException e1) {
//								// TODO Auto-generated catch block
//								e1.printStackTrace();
//							}
							farmerID=((IPropertyContainer)prmtfarmer.getValue()).getString("id");
							//							prmtbatchContract.setValue(StockingComm.getLastBatchContractInfo(null, farmerID, farmID,true));
						}		;
						isLoadField=false;
					}
				}
				setFilter();

				//设置批次合同
				try {
					if(prmtfarmer.getValue() != null && prmtfarm.getValue() != null){
						String s1 = "/*dialect*/ select t1.fid billid from T_FM_BatchContractBill t1 where t1.CFIsRecSettled = 0 and  t1.FFarmerID ='"+((FarmerInfo)prmtfarmer.getValue()).getId()+"' and t1.FFarmID = '"+((FarmInfo)prmtfarm.getValue()).getId()+"'";
						IRowSet r1 = SqlExecuteFacadeFactory.getRemoteInstance().executeQuery(s1);
						if(r1.next()){
							String billid = UIRuleUtil.getString(r1.getString("billid"));
							BatchContractBillInfo contractInfo = BatchContractBillFactory.getRemoteInstance().getBatchContractBillInfo(new ObjectUuidPK(billid));
							prmtbatchContract.setValue(contractInfo);
						}
					}
					prmtbatchContract_Changed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}});

		this.prmtbatch.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				batch_changed(e);
			}});

		prmtbatchContract.addDataChangeListener(new DataChangeListener(){

			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				try {
					prmtbatchContract_Changed(arg0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});

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


		((KDFormattedTextField)kdtEntrys.getColumn("amount").getEditor().getComponent()).setPrecision(2);
		((KDFormattedTextField)kdtEntrys.getColumn("actualCost").getEditor().getComponent()).setPrecision(2);

		kdtEntrys_detailPanel.addAddListener(new DetailPanelBackListener(){
			@Override
			public void beforeEvent(DetailPanelEvent e) throws Exception {
				// TODO Auto-generated method stub
				super.beforeEvent(e);
				DrugReceiveBillEntryInfo entry=(DrugReceiveBillEntryInfo)e.getObjectValue();
				entry.setWarehouse(wareHouseInfo);				
			}
		});
		kdtEntrys_detailPanel.addInsertListener(new DetailPanelBackListener(){
			@Override
			public void beforeEvent(DetailPanelEvent e) throws Exception {
				// TODO Auto-generated method stub
				super.beforeEvent(e);
				DrugReceiveBillEntryInfo entry=(DrugReceiveBillEntryInfo)e.getObjectValue();
				entry.setWarehouse(wareHouseInfo);				
			}
		});

		Toolkit tk = Toolkit.getDefaultToolkit();  
		tk.addAWTEventListener(new AWTEventListener(){
			public void eventDispatched(AWTEvent event) {
				if (event.getClass() == KeyEvent.class) {  
					// 被处理的事件是键盘事件.  
					KeyEvent keyEvent = (KeyEvent) event;
					if (keyEvent.getID() == KeyEvent.KEY_PRESSED) {
						keyPressed(keyEvent);  
					} else if (keyEvent.getID() == KeyEvent.KEY_RELEASED) {  
						//放开时你要做的事情  
						keyReleased(keyEvent);  
					}  
				} 		
			}	
			private void keyPressed(KeyEvent event) {}
			private void keyReleased(KeyEvent event) {
				int code = event.getKeyCode();
				if(event.isControlDown()&&code==KeyEvent.VK_DOWN &&!oprtState.equalsIgnoreCase("view"))
				{
					kdtEntrys.addRow();
				}	
			}
		}, AWTEvent.KEY_EVENT_MASK);  

		setFilter();
	}



	private BigDecimal getAmtByContract(String contractID) {
		BigDecimal amount=BigDecimal.ZERO;
		String sql="select sum(CFAmount) amount from T_FM_DrugReceiveBill t1 inner join T_FM_DrugReceiveBillEntry t2 on t2.fparentid=t1.fid " +
		"where t1.FBatchContractID='"+contractID+"' and t1.FBillStatus in (4,7)";
		IRowSet rs;
		try {
			rs = SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
			if(rs.next()){
				amount=rs.getBigDecimal("amount")==null?BigDecimal.ZERO:rs.getBigDecimal("amount");
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return amount;
	}


	/**
	 * 批次改变
	 * 带出基本价格
	 */
	private void batch_changed(DataChangeEvent e) {
		isLoadField=true;
		if(e.getNewValue()!=null) {
			try {
				pkinDate.setValue(UIRuleUtil.getProperty((IObjectValue) e.getNewValue(), "inDate"));
				txtinQty.setValue(UIRuleUtil.getProperty((IObjectValue) e.getNewValue(), "femaleQty"));
				//				if(prmtbatchContract.getValue()!=null){
				//					BigDecimal amount=getAmtByContract(((IPropertyContainer)prmtbatchContract.getValue()).getString("id"));
				//					if(UIRuleUtil.getBigDecimal(txtinQty.getBigDecimalValue()).signum()==0){
				//						txtdrugedSingleAmt.setValue(BigDecimal.ZERO);	
				//					}else{
				////						txtdrugedSingleAmt.setValue(amount.divide(UIRuleUtil.getBigDecimal(txtinQty.getBigDecimalValue()),2,RoundingMode.HALF_UP));
				//					}
				//				}
			} catch (DataAccessException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			} catch (BOSException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}		
		}else{
			pkinDate.setValue(null);
			txtinQty.setValue(null);
		}
		isLoadField=false;
	}

	public void prmtbatchContract_Changed(DataChangeEvent arg0) throws Exception {
		if(prmtbatchContract.getValue()!=null){
			String contractID=((IPropertyContainer) prmtbatchContract.getValue()).getString("id");
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("*");
			slor.add("breedData.*");
			slor.add("farmer.*");
			slor.add("farm.*");
			slor.add("person.*");
			slor.add("batch.*");
			slor.add("settlementPolicy.*");
			BatchContractBillInfo contractInfo = BatchContractBillFactory.getRemoteInstance().getBatchContractBillInfo(new ObjectUuidPK(contractID),slor );
			prmtsettlePolicy.setValue(contractInfo.getSettlementPolicy());
			prmtperson.setValue(contractInfo.getPerson());

			//设置成本中心
			if(contractInfo.getCostCenter() != null){
				CostCenterOrgUnitInfo costCenter = CostCenterOrgUnitFactory.getRemoteInstance().getCostCenterOrgUnitInfo(new ObjectUuidPK(contractInfo.getCostCenter().getId()));
				prmtcostcenter.setValue(costCenter);
			}

			prmtbreedData.setValue(contractInfo.getBreedData());
			checkKdtEntry(contractInfo.getSettlementPolicy());
			String batchID=StockingComm.getBatchIDByContractID(null, contractID);
			isLoadField=true;
			if(StringUtils.isNotEmpty(batchID)) {
				this.prmtbatch.setValue(BatchFactory.getRemoteInstance().getBatchInfo(new ObjectUuidPK(batchID)));
			}else {
				this.prmtbatch.setValue(null);
			}
			isLoadField=false;

			calcDrugAmount();


		}else{
			this.prmtbatch.setValue(null);
			prmtsettlePolicy.setValue(null);
			prmtperson.setValue(null);
			prmtbreedData.setValue(null);
			//复制功能下  养殖场等改变不会删除分录
			if(!isCopy){
				kdtEntrys.removeRows();
			}
		}
		setFilter();
		if(kdtEntrys.getRowCount()==0){
			kdtEntrys.addRow();
		}
	}

	/**
	 * 计算开药金额
	 */
	private void calcDrugAmount() {
		// TODO Auto-generated method stub

		if(prmtbatchContract.getValue() != null){
			BatchContractBillInfo batchcontractInfo = (BatchContractBillInfo) prmtbatchContract.getValue();
			String s1 = "/*dialect*/ select t4.CFMaxSingleDrug maxDrug,sum(t2.CFAmount) amount from T_FM_DrugReceiveBill t1" +
			" inner join T_FM_DrugReceiveBillEntry t2 on t2.fparentid = t1.fid" +
			" inner join T_FM_BatchContractBill t3 on t3.fid=t1.FBatchContractID" +
			" inner join T_FM_SettlePolicy t4 on t4.fid = t3.FSettlementPolicyI"+
			" where t1.FBatchContractID = '"+batchcontractInfo.getId()+"' and t1.FBillStatus in (4,7)  group by t4.CFMaxSingleDrug";
			try {
				IRowSet r1 = SqlExecuteFacadeFactory.getRemoteInstance().executeQuery(s1);
				//已开药总金额
				BigDecimal amount = BigDecimal.ZERO;
				if(r1.next()){
					amount = UIRuleUtil.getBigDecimal(r1.getBigDecimal("amount"));
				}

				//已开药单只金额
				if(UIRuleUtil.getBigDecimal(txtinQty.getValue()).compareTo(BigDecimal.ZERO) >0){
					txthasOneDrug.setValue(amount.divide(UIRuleUtil.getBigDecimal(txtinQty.getValue()),2,RoundingMode.HALF_UP));
				}else{
					txthasOneDrug.setValue(BigDecimal.ZERO);
				}



				String s2 = "/*dialect*/ select t4.CFMaxSingleDrug maxDrug  from  T_FM_BatchContractBill t3  inner join T_FM_SettlePolicy t4 on t4.fid = t3.FSettlementPolicyI where t3.fid = '"+batchcontractInfo.getId()+"'";
				IRowSet r2 = SqlExecuteFacadeFactory.getRemoteInstance().executeQuery(s2);
				//最高单只药品
				BigDecimal maxDrug = BigDecimal.ZERO;
				if(r2.next()){
					maxDrug = UIRuleUtil.getBigDecimal(r2.getBigDecimal("maxDrug"));
				}

				//最高开药金额
				BigDecimal hignDrugAmount = maxDrug.multiply(UIRuleUtil.getBigDecimal(txtinQty.getValue()));
				txthasDrugAmount.setValue(amount);
				txthignDrugAmount.setValue(hignDrugAmount);
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}




	}

	private void checkKdtEntry(SettlePolicyInfo policy) {
		// TODO Auto-generated method stub
		SettlePolicyPriceEntryCollection priceEntrys = policy.getPriceEntry();
		for(int i=kdtEntrys.getRowCount()-1;i>=0;i--){
			if(kdtEntrys.getCell(i, "material").getValue()==null){
				kdtEntrys.removeRow(i);
			}else{
				Boolean isHas=false;
				String materialID=((IPropertyContainer)kdtEntrys.getCell(i, "material").getValue()).getString("id");
				for(int j =0;j<priceEntrys.size();j++){
					try {
						SettlePolicyPriceEntryInfo priceEntry=SettlePolicyPriceEntryFactory.getRemoteInstance().getSettlePolicyPriceEntryInfo(new ObjectUuidPK(priceEntrys.get(j).getId()));
						if(materialID.equals(priceEntry.getMaterial().getId().toString())){
							calPrice(i, materialID);
							kdtEntrys.getCell(i, "amount").setValue(UIRuleUtil.getBigDecimal(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(i,"receiveQty").getValue())).multiply(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(i,"receivePrice").getValue())).setScale(2, RoundingMode.HALF_UP));
							isHas=true;
						}
					} catch (EASBizException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BOSException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(!isHas){
					kdtEntrys.removeRow(i);
				}
			}
		}
	}

	private void storageOrgUnit_changed(DataChangeEvent e){
		if(e.getNewValue()==null) {
			curStorageOrgUnitID=null;
		}else{
			curStorageOrgUnitID=((PropertyContainer) this.prmtstorageOrgUnit.getValue()).getString("id");
			try {
				orgInfo = StorageOrgUnitFactory.getRemoteInstance().getOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID));
				f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtEntrys.getColumn("material").getEditor().getComponent(), null, null, orgInfo,false);
				f7Manager.registerMeasureUnitF7(kdtEntrys, "material", "unit");
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

	/**
	 * 设置过滤条件
	 * @param companyID
	 */
	private void setFilter() {

		f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtEntrys.getColumn("material").getEditor().getComponent(), null, null, orgInfo,false);
		f7Manager.registerMeasureUnitF7(kdtEntrys, "material", "unit");

		if(this.prmtcompany.getValue()!=null) {
			curCompanyID=((IPropertyContainer) this.prmtcompany.getValue()).getString("id");
		}else{
			curCompanyID=null;
		}
		//批次过滤
		String farmerID=null,farmID=null;
		if(prmtfarmer.getValue()!=null) {
			farmerID=((IPropertyContainer) prmtfarmer.getValue()).getString("id");
		}
		if(prmtfarm.getValue()!=null) {
			farmID=((IPropertyContainer) prmtfarm.getValue()).getString("id");
		}
		StockingComm.setStockingBatchFilter(prmtbatch,curCompanyID,farmerID,farmID,true,false);
		this.prmtbatch.setRequired(false);

		//养殖户过滤
		StockingComm.setFarmerFilter(prmtfarmer, curCompanyID,false);
		//养殖场过滤
		StockingComm.setFarmFilter(this.prmtfarm, curCompanyID, farmerID,true);
		//合同过滤
		StockingComm.setContractFilterByFarmer(prmtfarmer, prmtfarm, prmtbatchContract, curCompanyID,true);
		//兽医过滤
		StockingComm.setVetFilter(prmtvet, curCompanyID);

		//物料过滤
		KDBizPromptBox material  = (KDBizPromptBox) this.kdtEntrys.getColumn("material").getEditor().getComponent();
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		String policyID;
		if(prmtbatchContract.getValue()!=null){
			try {
				if(UIRuleUtil.getProperty((IObjectValue) prmtbatchContract.getValue(), "settlementPolicy")!=null){
					policyID = ((SettlePolicyInfo)UIRuleUtil.getProperty((IObjectValue) prmtbatchContract.getValue(), "settlementPolicy")).getId().toString();
					filter=StockingComm.getMaterialFilter(null, policyID, SettleItemType.DRUG_VALUE);
				}
			} catch (DataAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			filter.getFilterItems().add(new FilterItemInfo("id","",CompareType.EQUALS));
		}
		ev.setFilter(filter);
		material.setEntityViewInfo(ev);
	}

	public void kdtEntrys_Changed(int rowIndex, int colIndex) throws Exception {
		super.kdtEntrys_Changed(rowIndex, colIndex);
		if(kdtEntrys.getColumn(colIndex).getKey().equals("material")||kdtEntrys.getColumn(colIndex).getKey().equals("unit")) {	
			//设置基础价格
			String batchID=null;
			if(prmtbatch.getValue()!=null){
				batchID=((IPropertyContainer) prmtbatch.getValue()).getString("id");
			}
			StockingComm.setEntryBasePriceByBatchID(com.kingdee.eas.farm.stocking.common.StockingComm.PRRICE_OUT_TYPE,batchID,kdtEntrys.getRow(rowIndex));
			//触发单价事件，带出金额
			kdtEntrys_Changed(rowIndex, kdtEntrys.getColumn("receivePrice").getColumnIndex());
		}
		if(kdtEntrys.getColumn(colIndex).getKey().equals("receiveQty")) {	
			kdtEntrys.getCell(rowIndex, "confirmQty").setValue(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex,"receiveQty").getValue()));
		}

		if(kdtEntrys.getColumnKey(colIndex).equals("material")
				||kdtEntrys.getColumnKey(colIndex).equals("unit")
				||kdtEntrys.getColumnKey(colIndex).equals("warehouse")) {
			String storageOrgUnitID=null,materialID=null,unitID=null,warehouseID=null;
			if(prmtstorageOrgUnit.getValue()!=null) {
				storageOrgUnitID=((IPropertyContainer) prmtstorageOrgUnit.getValue()).getString("id");
			}

			if(kdtEntrys.getCell(rowIndex, "unit").getValue()!=null) {
				unitID= ((IPropertyContainer) kdtEntrys.getCell(rowIndex, "unit").getValue()).getString("id");
			}
			if(kdtEntrys.getCell(rowIndex, "warehouse").getValue()!=null) {
				warehouseID=((IPropertyContainer) kdtEntrys.getCell(rowIndex, "warehouse").getValue()).getString("id");
			}
			if("warehouse".equals(kdtEntrys.getColumnKey(colIndex))){
				if(kdtEntrys.getCell(rowIndex, colIndex).getValue()!=null)
					wareHouseInfo=(WarehouseInfo) kdtEntrys.getCell(rowIndex, colIndex).getValue();
			}
			if("material".equals(kdtEntrys.getColumnKey(colIndex))){
				if(kdtEntrys.getCell(rowIndex, "material").getValue()!=null) {
					materialID= ((IPropertyContainer) kdtEntrys.getCell(rowIndex, "material").getValue()).getString("id");
					calPrice(rowIndex,materialID);
					MaterialInventoryInfo mivInfo= StockingComm.getDefaultWarehouseDataByMaterial(null, ((StorageOrgUnitInfo)prmtstorageOrgUnit.getValue()).getString("id"), materialID);
					if(mivInfo!=null){
						kdtEntrys.getCell(rowIndex, "warehouse").setValue(mivInfo.getDefaultWarehouse());
					}				
				}

			}
		}

		if("receiveQty".equals(kdtEntrys.getColumnKey(colIndex))){
			kdtEntrys.getCell(rowIndex, "actualCost").setValue(UIRuleUtil.getBigDecimal(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex,"unitCost").getValue())).multiply(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex,"confirmQty").getValue())).setScale(2, RoundingMode.HALF_UP));
			kdtEntrys.getCell(rowIndex, "amount").setValue(UIRuleUtil.getBigDecimal(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex,"receiveQty").getValue())).multiply(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex,"receivePrice").getValue())).setScale(2, RoundingMode.HALF_UP));
		}
		if("amount".equals(kdtEntrys.getColumnKey(colIndex))){
			kdtEntrys.getCell(rowIndex, "receivePrice").setValue(UIRuleUtil.getBigDecimal(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex,"amount").getValue())).divide(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex,"receiveQty").getValue()),2,BigDecimal.ROUND_HALF_UP));
		}


		txttotalCost.setValue(UIRuleUtil.getBigDecimal(kdtEntrys.getFootRow(0).getCell("actualCost").getValue()));


	}
	/**
	 * 计算价格
	 * @param rowIndex
	 * @param materialID
	 */
	private void calPrice(int rowIndex, String materialID) {	
		String  policyID="";
		if(prmtbatchContract.getValue()!=null){
			try {
				policyID=((SettlePolicyInfo)UIRuleUtil.getProperty((IObjectValue) prmtbatchContract.getValue(), "settlementPolicy")).getId().toString();
				BigDecimal price = StockingComm.getBasePrice(null, policyID, materialID);
				kdtEntrys.getCell(rowIndex, "unitCost").setValue(price);
				kdtEntrys.getCell(rowIndex, "basePrice").setValue(price);
				kdtEntrys.getCell(rowIndex, "receivePrice").setValue(price);
			} catch (DataAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 设置分录及时库存
	 */
	private void setEntryInv() {
		for(int rowIndex=0;rowIndex<kdtEntrys.getRowCount();rowIndex++) {
			String storageOrgUnitID=null,materialID=null,unitID=null,warehouseID=null;
			if(prmtstorageOrgUnit.getValue()!=null) {
				storageOrgUnitID=((IPropertyContainer) prmtstorageOrgUnit.getValue()).getString("id");
			}
			if(kdtEntrys.getCell(rowIndex, "material").getValue()!=null) {
				materialID= ((IPropertyContainer) kdtEntrys.getCell(rowIndex, "material").getValue()).getString("id");
			}
			if(kdtEntrys.getCell(rowIndex, "unit").getValue()!=null) {
				unitID= ((IPropertyContainer) kdtEntrys.getCell(rowIndex, "unit").getValue()).getString("id");
			}
			if(kdtEntrys.getCell(rowIndex, "warehouse").getValue()!=null) {
				warehouseID=((IPropertyContainer) kdtEntrys.getCell(rowIndex, "warehouse").getValue()).getString("id");
			}

			//			kdtEntrys.getCell(rowIndex, "inventory").setValue(com.kingdee.eas.farm.stocking.common.StockingComm.getNowInventory(null, storageOrgUnitID, materialID, unitID, warehouseID));

		}
	}

	/**
	 * 复制
	 */
	@Override
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		isCopy = true;
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
		editData.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		editData.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		editData.setNumber(CodingUtil.getNewNumberByCodingRule(null, editData));
		editData.setBizDate(new java.util.Date());
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
		BigDecimal totalAmt = BigDecimal.ZERO;
		for(int i=0;i<kdtEntrys.getRowCount();i++){
			BigDecimal receiveQty=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(i, "receiveQty").getValue());
			BigDecimal amount=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(i, "amount").getValue());
			if(receiveQty.signum()==0){
				MsgBox.showWarning("分录第"+(i+1)+"行领用数量不能为空或0");
				SysUtil.abort();
			}
			if(bizType.getSelectedItem()==DrugBizType.comm&&receiveQty.signum()<0){
				MsgBox.showWarning("业务类型为普通领用时,分录第"+(i+1)+"行领用数量不能小于0");
				SysUtil.abort();
			}
			if(bizType.getSelectedItem()==DrugBizType.returnBack&&receiveQty.signum()>00){
				MsgBox.showWarning("业务类型为退药时,分录第"+(i+1)+"行领用数量不能大于0");
				SysUtil.abort();
			}
			totalAmt = totalAmt.add(amount);
		}
		txttotalAmt.setValue(totalAmt);

		//		if(UIRuleUtil.isNotNull(txthasDrugAmount.getValue())){
		txtsaveAmount.setValue(UIRuleUtil.getBigDecimal(txthasDrugAmount.getValue()).add(totalAmt));
		//		}


		if(bizType.getSelectedItem()==DrugBizType.trans){
			MsgBox.showWarning("不允许手工录入单据类型为调药的药品处方单!");
			SysUtil.abort();
		}		
		super.beforeStoreFields(arg0);
	}


	/**
	 * 生成下游单据标志
	 */
	@Override
	public void actionCreateTo_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionCreateTo_actionPerformed(e);
		if(editData.getId()==null)
			return;
		MaterialReqBillInfo materialReqBillInfo;
		//校验生成领料出库单
		ArrayList<String> destObejctIDs = BOTRelationFactory.getRemoteInstance().getDestObjIdByDestType(editData.getId().toString(), "500AB75E");
		if(destObejctIDs.size()>0)
			CommFacadeFactory.getRemoteInstance().excuteUpdateSql("update T_FM_DrugReceiveBill set FIsHasMaterial=1 where fid='"+editData.getString("id")+"'");

		StockTransferBillInfo stockTransferBillInfo;
		//校验生成库存调拨单
		destObejctIDs = BOTRelationFactory.getRemoteInstance().getDestObjIdByDestType(editData.getId().toString(), "2239F30A");
		if(destObejctIDs.size()>0)
			CommFacadeFactory.getRemoteInstance().excuteUpdateSql("update T_FM_DrugReceiveBill set FIsHasTrans=1 where fid='"+editData.getString("id")+"'");
		UIUtil.refreshEditUI(this);
	}


	@Override
	protected void setTableToSumField() {
		// TODO Auto-generated method stub
		setTableToSumField(kdtEntrys,new String[]{"receiveQty","confirmQty","amount","actualCost"});
	}

	@Override
	protected void setTableToSumField(KDTable arg0, String[] arg1) {
		// TODO Auto-generated method stub
		super.setTableToSumField(arg0, arg1);
	}

}