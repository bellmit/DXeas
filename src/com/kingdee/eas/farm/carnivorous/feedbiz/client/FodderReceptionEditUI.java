/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.feedbiz.client;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.views.jsp.ActionTag;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.KDFrame;
import com.kingdee.bos.ctrl.swing.KDTextArea;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.base.param.util.ParamManager;
import com.kingdee.eas.base.permission.PermissionFactory;
import com.kingdee.eas.basedata.assistant.IPrintIntegration;
import com.kingdee.eas.basedata.assistant.PrintIntegrationFactory;
import com.kingdee.eas.basedata.assistant.PrintIntegrationInfo;
import com.kingdee.eas.basedata.assistant.util.CommonPrintIntegrationDataProvider;
import com.kingdee.eas.basedata.assistant.util.PrintIntegrationManager;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.MaterialInventoryInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CostCenterOrgUnitFactory;
import com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.SaleOrgUnitInfo;
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
import com.kingdee.eas.custom.commld.CodingUtil;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.custom.commld.ListenerUtil;
import com.kingdee.eas.custom.commld.UIUtil;
import com.kingdee.eas.custom.commld.commUtils;
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
import com.kingdee.eas.farm.carnivorous.feedbiz.FodderBillType;
import com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.SeedSourceType;
import com.kingdee.eas.farm.stocking.basedata.SettleItemType;
import com.kingdee.eas.framework.ObjectValueUtil;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.framework.print.MultiapproveDataProvider;
import com.kingdee.eas.hr.contract.client.ContractBillEditUIBiz;
import com.kingdee.eas.industry.emm.pm.SqlExecuteFacadeFactory;
import com.kingdee.eas.publicdata.CarEntryCollection;
import com.kingdee.eas.publicdata.CarEntryFactory;
import com.kingdee.eas.publicdata.CarEntryInfo;
import com.kingdee.eas.publicdata.CarFactory;
import com.kingdee.eas.publicdata.CarInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.scm.common.util.MultiDataSourceDataProviderProxy;
import com.kingdee.eas.scm.common.util.SCMCommonDataProvider;
import com.kingdee.eas.scm.im.inv.client.InvClientUtils;
import com.kingdee.eas.scm.sd.sale.SaleOrderFactory;
import com.kingdee.eas.scm.sd.sale.SaleOrderInfo;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.eas.wlhlcomm.client.UITools;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.util.PropertyContainer;

/**
 * output class name
 */
public class FodderReceptionEditUI extends AbstractFodderReceptionEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(FodderReceptionEditUI.class);
	private String curStorageOrgUnitID;//当前库存组织
	private String curCompanyID;//当前财务组织
	private F7ContextManager f7Manager;
	private OrgUnitInfo orgInfo = null;//库存组织
	private boolean isLoadField=false;
	private SystemSettingInfo sysSetting;
	private WarehouseInfo wareHouseInfo=null;
	/**
	 * output class constructor
	 */
	public FodderReceptionEditUI() throws Exception{
		super();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
	}

	public void loadFields(){
		actionCopy.setVisible(false);
		actionCopy.setEnabled(true);
		actionTraceUp.setVisible(true);
		actionTraceDown.setVisible(true);
		actionTraceUp.setEnabled(true);
		actionTraceDown.setEnabled(true);

		isLoadField=true;
		super.loadFields(); 
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
		UITools.apendFootRow(kdtEntrys, new String[]{"receiveQty","confirmQty","bagQty","amount"});

		if(fodderSourceType.getSelectedItem()!=null){
			if(fodderSourceType.getSelectedItem().equals(com.kingdee.eas.farm.carnivorous.feedbiz.fodderSourceType.innerCollect)){
				prmtreturnCompany.setEnabled(true);
				prmtsupplier.setValue(null);
				prmtsupplier.setEnabled(false);
			}else{
				prmtsupplier.setEnabled(true);
			}
		}

		//仓库
		//		if(prmtstorageOrgUnit.getValue()!=null){
		//			curStorageOrgUnitID=((StorageOrgUnitInfo)prmtstorageOrgUnit.getValue()).getString("id");
		//			EntityViewInfo ev=new EntityViewInfo();
		//			FilterInfo filter=new FilterInfo();
		//			filter.getFilterItems().add(new FilterItemInfo("storageOrg.id",curStorageOrgUnitID,CompareType.EQUALS));
		//			ev.setFilter(filter);
		//			((KDBizPromptBox) this.kdtEntrys.getColumn("warehouse").getEditor().getComponent()).setEntityViewInfo(ev);
		//		}


		KDBizPromptBox prmtEntryPerson = ((KDBizPromptBox)kdtEntrys.getColumn("person").getEditor().getComponent());
		StockingComm.makeApplierF7(prmtEntryPerson, ((IPropertyContainer)prmtcompany.getValue()).getString("id"), this, false);
	}

	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
	}

	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
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
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		super.actionSubmit_actionPerformed(e);
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
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
			MsgBox.showInfo(this, InvClientUtils.getResource("CanPrintAndPrintView"));
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
			MsgBox.showInfo(this, InvClientUtils
					.getResource("CanPrintAndPrintView"));
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
					FodderReceptionInfo bill = FodderReceptionFactory.getRemoteInstance().getFodderReceptionInfo(new ObjectUuidPK(info2.getPrintBillID()),sic);
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
		return com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionFactory.getRemoteInstance();
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
		com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo objectValue = new com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());

		curStorageOrgUnitID= "SWmjBG/5RY6GMi8KGGvy0MznrtQ=";//SysContext.getSysContext().getCurrentStorageUnit().getString("id");

		try {
			//设置默认出库组织
			StorageOrgUnitInfo stoInfo = StorageOrgUnitFactory.getRemoteInstance().getStorageOrgUnitInfo(new ObjectUuidPK("SWmjBG/5RY6GMi8KGGvy0MznrtQ="));
			objectValue.setStorageOrgUnit(stoInfo);
			//设置默认财务组织
			CompanyOrgUnitInfo companyInfo = CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK("k8vfYGNhTMupurgEsGg5zMznrtQ="));
			objectValue.setReturnCompany(companyInfo);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




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
	}

	protected void verifyInput(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.verifyInput(e);
		Boolean isSanZhuan=false;
		for(int rowIndex=0;rowIndex<this.kdtEntrys.getRowCount();rowIndex++) {
			if(this.kdtEntrys.getCell(rowIndex, "unitQty").getValue()==null||((BigDecimal)this.kdtEntrys.getCell(rowIndex, "unitQty").getValue()).signum()==0){
				isSanZhuan=true;
			}
			BigDecimal qty=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "receiveQty").getValue());
			if(billType.getSelectedItem()==FodderBillType.Lost||billType.getSelectedItem()==FodderBillType.Return){
				if(qty.signum()>=0){
					MsgBox.showWarning("单据类型为退料或丢料时.分录第"+(rowIndex+1)+"行领用数量必须为负数");
					SysUtil.abort();
				}
			}else if(billType.getSelectedItem()==FodderBillType.Comm){
				if(qty.signum()<=0){
					MsgBox.showWarning("单据类型为普通领料时.分录第"+(rowIndex+1)+"行领用数量必须为正数");
					SysUtil.abort();
				}
			}
			BigDecimal amount=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "amount").getValue());
			if(amount.signum()==0){
				MsgBox.showWarning("分录第"+(rowIndex+1)+"行领用金额不能为空或0");
				SysUtil.abort();
			}
		}

		if((billType.getSelectedItem()==FodderBillType.Comm||billType.getSelectedItem()==FodderBillType.Return)
				&&fodderSourceType.getSelectedItem()==com.kingdee.eas.farm.carnivorous.feedbiz.fodderSourceType.innerCollect){
			//			if(prmtreturnCompany.getValue()==null){
			//				MsgBox.showWarning("单据类型为退料或普通领料且来源类型为内采时,饲料公司不能为空!");
			//				SysUtil.abort();
			//			}
		}
	}


	private void initControl() throws Exception {
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));

		kdtEntrys.getColumn("receivePrice").getStyleAttributes().setNumberFormat("0.####");

		billType_changed();
		btnViewStdUse.registerKeyboardAction(new ActionListener(){
			public void actionPerformed(ActionEvent paramActionEvent) {
				try {
					actionViewStdUse_actionPerformed(paramActionEvent);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}},KeyStroke.getKeyStroke(KeyEvent.VK_F6,0), JComponent.WHEN_IN_FOCUSED_WINDOW);		

		CompanyF7 cf7=new CompanyF7();
		cf7.setIsCUFilter(true);
		this.prmtcompany.setSelector(cf7);

		StorageF7 sf7=new StorageF7();
		sf7.setIsCUFilter(true);
		this.prmtstorageOrgUnit.setSelector(sf7);

		f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtEntrys.getColumn("material").getEditor().getComponent(), null, null, orgInfo,false);
		f7Manager.registerMeasureUnitF7(kdtEntrys, "material", "unit");


		//领用组织改变分录中的仓库字段添加过滤
		prmtstorageOrgUnit.addDataChangeListener(new DataChangeListener(){

			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				EntityViewInfo ev=new EntityViewInfo();
				FilterInfo filter=new FilterInfo();
				filter.getFilterItems().add(new FilterItemInfo("storageOrg.id",((StorageOrgUnitInfo)prmtstorageOrgUnit.getValue()).getString("id"),CompareType.EQUALS));
				ev.setFilter(filter);
				((KDBizPromptBox)kdtEntrys.getColumn("warehouse").getEditor().getComponent()).setEntityViewInfo(ev);
			}
		});






		this.prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setFilter();
			}});


		this.prmtfarmer.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				prmtfarm.setValue(null);
				if(prmtfarmer.getValue()!=null){
					if(!isLoadField) {
						String farmerID=null,farmID=null;
						DataChangeListener[] listener = ListenerUtil.F7GetDateChangeListener(prmtfarm);
						ListenerUtil.F7RemoveDateChangeListener(prmtfarm);
						//						StockingComm.setFarmInfoByFarmer(prmtfarmer, prmtfarm);
						if(prmtfarm.getValue()!=null){
							try {
								txtfarmAddress.setText((String) UIRuleUtil.getProperty((IObjectValue) prmtfarm.getValue(), "address"));

							} catch (DataAccessException e1) {
								e1.printStackTrace();
							} catch (BOSException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						ListenerUtil.F7AddDateChangeListener(prmtfarm, listener);

						farmerID=((IPropertyContainer)prmtfarmer.getValue()).getString("id");
						//						if(prmtfarm.getValue()!=null){
						//							farmID=((IPropertyContainer)prmtfarm.getValue()).getString("id");
						//							prmtbatchContract.setValue(StockingComm.getLastBatchContractInfo(null, farmerID, farmID,true));
						//						}	
						isLoadField=false;
					}}
				setFilter();
			}});

		this.prmtfarm.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				prmtbatchContract.setValue(null);
				bunker.setSelectedItem(null);
				if(prmtfarm.getValue()!=null){
					if(!isLoadField){
						isLoadField=true;
						try {
							String farmID=((IPropertyContainer)prmtfarm.getValue()).getString("id");
							DataChangeListener[] listener = ListenerUtil.F7GetDateChangeListener(prmtfarmer);
							ListenerUtil.F7RemoveDateChangeListener(prmtfarmer);
							prmtfarmer.setValue(StockingComm.getFarmerInfoByFarm(null, prmtfarm));
							ListenerUtil.F7AddDateChangeListener(prmtfarmer, listener);
							String farmerID = null;
							if(prmtfarmer.getValue()!=null){
								txtfarmerPhone.setText((String) UIRuleUtil.getProperty((IObjectValue) prmtfarmer.getValue(), "mobileTel"));
								farmerID=((IPropertyContainer)prmtfarmer.getValue()).getString("id");
								//prmtbatchContract.setValue(StockingComm.getLastBatchContractInfo(null, farmerID, farmID,true));
							}
							FarmInfo farm=FarmFactory.getRemoteInstance().getFarmInfo(new ObjectUuidPK(farmID));
							if(farm.getMileStd() != null){
								txtfeedInstance.setValue(farm.getMileStd());
							}
							bunker.setSelectedItem(farm.getBunker());
						} catch (DataAccessException e1) {
							e1.printStackTrace();
						} catch (BOSException e1) {
							e1.printStackTrace();
						} catch (EASBizException e1) {
							e1.printStackTrace();
						}
						isLoadField=false;
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
							//设置合同数量
							txtcontractQty.setValue(contractInfo.getFemaleBreedQty());
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


		this.pkBizDate.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				if(pkBizDate.getValue()!=null&&pkindate.getValue()!=null){
					int dayAge=DateUtilsComm.getDiffBetweenTwoDays(DateUtilsComm.clearDateHMS((Date)pkindate.getValue()),DateUtilsComm.clearDateHMS((Date) pkBizDate.getValue()));
					txtweekDay.setValue(dayAge+1);
				}
			}});

		this.prmtcar.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				if(prmtcar.getValue()!=null){
					SelectorItemCollection slor =new SelectorItemCollection();
					slor.add("*");
					slor.add("Entry.*");
					slor.add("Entry.driver.*");
					try {
						if(!isLoadField){
							isLoadField=true;
							CarInfo car=CarFactory.getRemoteInstance().getCarInfo(new ObjectUuidPK(((IPropertyContainer)prmtcar.getValue()).getString("id")), slor);
							CarEntryCollection carEntry=car.getEntry();
							for(int i=0;i<carEntry.size();i++){
								CarEntryInfo entry =carEntry.get(i);
								if(entry.isIsDefault()){
									prmtdriver.setValue(entry.getDriver());
									break;
								}
							}
							isLoadField=false;
						}
					} catch (EASBizException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BOSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
					prmtdriver.setValue(null);
				}
				setFilter();
			}

		});

		this.prmtdriver.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				if(prmtdriver.getValue()!=null){
					try {
						if(!isLoadField){
							isLoadField=true;
							txtlinkCell.setText((String) UIRuleUtil.getProperty((IObjectValue) prmtdriver.getValue(), "driverphone"));
							String driverID=((IPropertyContainer)prmtdriver.getValue()).getString("id");
							String sql="select distinct t1.fid fid from CT_PUB_Car t1 inner join T_PUB_CarEntry t2 on t1.fid=t2.fparentid where t2.FDriverID='"+driverID+"' ";//and t1.CFBaseStatus=2
							IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
							if(rs.next()){
								CarInfo carInfo=CarFactory.getRemoteInstance().getCarInfo(new ObjectUuidPK(rs.getString("fid")));
								prmtcar.setValue(carInfo);
							}
							isLoadField=false;
						}
					} catch (DataAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BOSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (EASBizException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
					txtlinkCell.setText(null);
				}
				setFilter();
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



		final KDBizPromptBox kdtEntrys_material_PromptBox = new KDBizPromptBox();//com.kingdee.eas.basedata.master.material.app.F7MaterialBaseInfoQuery
		kdtEntrys_material_PromptBox.setQueryInfo("com.kingdee.eas.farm.carnivorous.feedbiz.app.FodderMaterialQuery");
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


		fodderSourceType.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(fodderSourceType.getSelectedItem()==null){
					return;
				}
				else if(fodderSourceType.getSelectedItem().equals(com.kingdee.eas.farm.carnivorous.feedbiz.fodderSourceType.innerCollect)){
					prmtsupplier.setValue(null);
					prmtsupplier.setEnabled(false);
				}else{
					prmtsupplier.setEnabled(true);
				}
			}});

		billType.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				billType_changed();
			}});

		((KDFormattedTextField)kdtEntrys.getColumn("amount").getEditor().getComponent()).setPrecision(2);
		((KDFormattedTextField)kdtEntrys.getColumn("actualCost").getEditor().getComponent()).setPrecision(2);

		setFilter();
	}


	private void billType_changed() {
		if(billType.getSelectedItem()==null)return;
		if(billType.getSelectedItem()==FodderBillType.Return){
			txtreturnOpinion.setEnabled(true);
			kdtEntrys.getColumn("productionDate").getStyleAttributes().setLocked(false);
			kdtEntrys.getColumn("shift").getStyleAttributes().setLocked(false);
			kdtEntrys.getColumn("hjFee").getStyleAttributes().setLocked(false);
		}else{
			txtreturnOpinion.setText(null);
			txtreturnOpinion.setEnabled(false);
			kdtEntrys.getColumn("productionDate").getStyleAttributes().setLocked(true);
			kdtEntrys.getColumn("shift").getStyleAttributes().setLocked(true);
			kdtEntrys.getColumn("hjFee").getStyleAttributes().setLocked(true);
			for(int i=0;i<kdtEntrys.getRowCount();i++){
				kdtEntrys.getCell(i, "productionDate").setValue(null);
				kdtEntrys.getCell(i, "shift").setValue(null);
				kdtEntrys.getCell(i, "shift").setValue(null);	
			}
		}
	}

	/**
	 * 批次改变
	 */
	private void batch_changed(DataChangeEvent e) {
		isLoadField=true;
		if(e.getNewValue()!=null) {
			try {
				pkindate.setValue(UIRuleUtil.getProperty((IObjectValue) e.getNewValue(), "inDate"));
				txtbatchQty.setValue(UIRuleUtil.getProperty((IObjectValue) e.getNewValue(), "femaleQty"));
			} catch (DataAccessException e3) {
				e3.printStackTrace();
			} catch (BOSException e3) {
				e3.printStackTrace();
			}		
		}else{
			pkindate.setValue(null);
			txtbatchQty.setValue(null);
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
			checkKdtEntry(contractInfo.getSettlementPolicy());
			prmtperson.setValue(contractInfo.getPerson());
			//设置成本中心
			if(contractInfo.getCostCenter() != null){
				CostCenterOrgUnitInfo costCenter = CostCenterOrgUnitFactory.getRemoteInstance().getCostCenterOrgUnitInfo(new ObjectUuidPK(contractInfo.getCostCenter().getId()));
				prmtcostCenter.setValue(costCenter);
			}
			prmtbreedData.setValue(contractInfo.getBreedData());
			if(pkBizDate.getValue()!=null&&contractInfo.getActualBreedDate()!=null){
				int dayAge=DateUtilsComm.getDiffBetweenTwoDays(DateUtilsComm.clearDateHMS(contractInfo.getActualBreedDate()),DateUtilsComm.clearDateHMS((Date) pkBizDate.getValue()));
				txtweekDay.setValue(dayAge+1);
			}
			String batchID=StockingComm.getBatchIDByContractID(null, contractID);
			isLoadField=true;
			if(StringUtils.isNotEmpty(batchID)) {
				this.prmtbatch.setValue(BatchFactory.getRemoteInstance().getBatchInfo(new ObjectUuidPK(batchID)));
			}else {
				this.prmtbatch.setValue(null);
			}

			isLoadField=false;

			//计算饲料数量
			calcFeedQty();



		}else{
			this.prmtbatch.setValue(null);
			prmtsettlePolicy.setValue(null);
			prmtperson.setValue(null);
			txtweekDay.setValue(null);
			kdtEntrys.removeRows();
		}
		if(kdtEntrys.getRowCount()==0){
			kdtEntrys.addRow();
		}
		setFilter();
	}

	/**
	 * 计算饲料数量
	 * @throws BOSException 
	 * @throws ParseException 
	 * @throws EASBizException 
	 * @throws SQLException 
	 */
	private void calcFeedQty() throws BOSException, ParseException, EASBizException, SQLException {

		String s3 = null;
		if(pkBizDate.getValue() != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String s1 = sdf.format(new Date());
			s1 = s1.substring(11,19);
			System.out.println(s1);
			String s2 = sdf.format(pkBizDate.getValue());
			s2 = s2.substring(0,10);
			System.out.println(s2);
			s3 = s2+" "+s1;
			System.out.println(s3);
			pkBizDate.setValue(sdf.parse(s3));
		}


		//批次
		BatchInfo batchInfo = null;
		if(prmtbatch.getValue() != null){
			batchInfo = (BatchInfo) prmtbatch.getValue();
		}
		//批次合同
		BatchContractBillInfo batchContractInfo = (BatchContractBillInfo) prmtbatchContract.getValue();
		if(batchContractInfo.getId() != null){
			batchContractInfo = BatchContractBillFactory.getRemoteInstance().getBatchContractBillInfo(new ObjectUuidPK(batchContractInfo.getId()));
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//查找前中后期物料的超料标准
		if(prmtsettlePolicy.getValue() != null){

			//该批次合同雏苗数量
			BigDecimal contRactQty = batchContractInfo.getFemaleBreedQty();

			SettlePolicyInfo setInfo = (SettlePolicyInfo) prmtsettlePolicy.getValue();
			//------------------------------------------------------前期物料----------------------------------------------------------
			BigDecimal easlyRate = BigDecimal.ZERO;
			String s1 = "/*dialect*/ select distinct t2.CFOverRate overRate from T_FM_SettlePolicy t1 inner join T_FM_SettlePolicyPriceEntry t2 on t2.fparentid = t1.fid" +
			" inner join T_BD_Material t3 on t3.fid = t2.FMaterialID where t3.fnumber in ('02-000851','02-001461','02-001509') " +
			" and t1.fid ='"+setInfo.getId()+"'";
			IRowSet r1 = SQLExecutorFactory.getRemoteInstance(s1).executeSQL();
			if(r1.next()){
				easlyRate = UIRuleUtil.getBigDecimal(r1.getBigDecimal("overRate"));
				easlyRate = easlyRate.multiply(new BigDecimal("100"));
			}

			//前期饲料领用单领用数量
			StringBuffer s11 = new StringBuffer();
			s11.append( "/*dialect*/ select sum(tt.earlyQty) earlyQty, sum(tt.earlyAuditQty) earlyAuditQty,  sum(tt.earlyUnAuditQty) earlyUnAuditQty from (  select 0 earlyQty,sum(t2.FReceiveQty) earlyAuditQty,0 earlyUnAuditQty from T_FM_FodderReception t1");
			s11.append( " inner join T_FM_FodderReceptionEntry t2 on t2.fparentid=t1.fid inner join T_BD_Material t3 on t3.fid=t2.FMaterialID" );
			s11.append( " where t3.fnumber in ('02-000851','02-001461','02-001509') and t1.FBillStatus in(4,7) and t1.CFBatchContractID ='"+batchContractInfo.getId()+"'" );
			if(editData.getId() != null){
				s11.append( " and t1.fid !='"+editData.getId()+"'" );
			}
			s11.append( " and to_char(t1.fbizdate,'yyyy-MM-dd HH:mm:ss')<'"+s3+"'" );
			s11.append( " union all select 0 earlyQty,0 earlyAuditQty,sum(t2.FReceiveQty) earlyUnAuditQty from T_FM_FodderReception t1" );
			s11.append( " inner join T_FM_FodderReceptionEntry t2 on t2.fparentid=t1.fid inner join T_BD_Material t3 on t3.fid=t2.FMaterialID" );
			s11.append( " where t3.fnumber in ('02-000851','02-001461','02-001509') and t1.FBillStatus in (1,2) and t1.CFBatchContractID ='"+batchContractInfo.getId()+"'" );
			if(editData.getId() != null){
				s11.append( " and t1.fid !='"+editData.getId()+"'" );
			}
			s11.append( " and to_char(t1.fbizdate,'yyyy-MM-dd HH:mm:ss')<'"+s3+"'" );
			s11.append( " union all select sum(t2.FReceiveQty) earlyQty,0 earlyAuditQty,0 earlyUnAuditQty from T_FM_FodderReception t1" );
			s11.append( " inner join T_FM_FodderReceptionEntry t2 on t2.fparentid=t1.fid inner join T_BD_Material t3 on t3.fid=t2.FMaterialID" );
			s11.append( " where t3.fnumber in ('02-000851','02-001461','02-001509') and t1.CFBatchContractID ='"+batchContractInfo.getId()+"'" );
			if(editData.getId() != null){
				s11.append( " and t1.fid !='"+editData.getId()+"'" );
			}
			s11.append( " and to_char(t1.fbizdate,'yyyy-MM-dd HH:mm:ss')<'"+s3+"')tt");



			BigDecimal earlyQty = BigDecimal.ZERO;
			BigDecimal earlyAuditQty = BigDecimal.ZERO;
			BigDecimal earlyUnAuditQty = BigDecimal.ZERO;
			IRowSet r11 = SQLExecutorFactory.getRemoteInstance(s11.toString()).executeSQL();
			if(r11.next()){
				earlyQty = UIRuleUtil.getBigDecimal(r11.getBigDecimal("earlyQty"));//审核+未审核
				earlyAuditQty = UIRuleUtil.getBigDecimal(r11.getBigDecimal("earlyAuditQty"));//审核
				earlyUnAuditQty = UIRuleUtil.getBigDecimal(r11.getBigDecimal("earlyUnAuditQty"));//未审核
			}

			//前期肉仔鸡配合饲料标准用量
			txtearlyStand.setValue(contRactQty.multiply(easlyRate).divide(new BigDecimal("100")));
			//前期肉仔鸡配合饲料已开票数量
			txtearlyVou.setValue(earlyQty);
			//前期肉仔鸡配合饲料已审核数量
			txtearlyAudit.setValue(earlyAuditQty);
			//前期肉仔鸡配合饲料未审核数量
			txtearlyUnAudit.setValue(earlyUnAuditQty);
			//前期肉仔鸡配合饲料允许开票数量
			txtearlyAllow.setValue(contRactQty.multiply(easlyRate).divide(new BigDecimal("100")).subtract(earlyQty));

			//-------------------------------------------------中期-------------------------------------------------------------------
			BigDecimal midRate = BigDecimal.ZERO;
			String s2 = "/*dialect*/ select distinct t2.CFOverRate overRate from T_FM_SettlePolicy t1 inner join T_FM_SettlePolicyPriceEntry t2 on t2.fparentid = t1.fid" +
			" inner join T_BD_Material t3 on t3.fid = t2.FMaterialID where t3.fnumber in ('02-000853','02-000854','02-000855','02-000856','02-001462','02-001463') " +
			" and t1.fid ='"+setInfo.getId()+"'";
			IRowSet r2 = SQLExecutorFactory.getRemoteInstance(s2.toString()).executeSQL();
			if(r2.next()){
				midRate = UIRuleUtil.getBigDecimal(r2.getBigDecimal("overRate"));
				midRate = midRate.multiply(new BigDecimal("100"));
			}

			//中期饲料领用单领用数量
			StringBuffer s21 = new StringBuffer();
			s21.append( "/*dialect*/ select sum(tt.earlyQty) earlyQty, sum(tt.earlyAuditQty) earlyAuditQty,  sum(tt.earlyUnAuditQty) earlyUnAuditQty from (  select 0 earlyQty,sum(t2.FReceiveQty) earlyAuditQty,0 earlyUnAuditQty from T_FM_FodderReception t1");
			s21.append( " inner join T_FM_FodderReceptionEntry t2 on t2.fparentid=t1.fid inner join T_BD_Material t3 on t3.fid=t2.FMaterialID" );
			s21.append( " where t3.fnumber in ('02-000853','02-000854','02-000855','02-000856','02-001462','02-001463') and  t1.FBillStatus in(4,7)  and t1.CFBatchContractID ='"+batchContractInfo.getId()+"'" );
			if(editData.getId() != null){
				s21.append( " and t1.fid !='"+editData.getId()+"'" );
			}
			s21.append( " and to_char(t1.fbizdate,'yyyy-MM-dd HH:mm:ss')<'"+s3+"'" );
			s21.append( " union all select 0 earlyQty,0 earlyAuditQty,sum(t2.FReceiveQty) earlyUnAuditQty from T_FM_FodderReception t1" );
			s21.append( " inner join T_FM_FodderReceptionEntry t2 on t2.fparentid=t1.fid inner join T_BD_Material t3 on t3.fid=t2.FMaterialID" );
			s21.append( " where t3.fnumber in ('02-000853','02-000854','02-000855','02-000856','02-001462','02-001463') and t1.FBillStatus in (1,2) and t1.CFBatchContractID ='"+batchContractInfo.getId()+"'" );
			if(editData.getId() != null){
				s21.append( " and t1.fid !='"+editData.getId()+"'" );
			}
			s21.append( " and to_char(t1.fbizdate,'yyyy-MM-dd HH:mm:ss')<'"+s3+"'" );
			s21.append( " union all select sum(t2.FReceiveQty) earlyQty,0 earlyAuditQty,0 earlyUnAuditQty from T_FM_FodderReception t1" );
			s21.append( " inner join T_FM_FodderReceptionEntry t2 on t2.fparentid=t1.fid inner join T_BD_Material t3 on t3.fid=t2.FMaterialID" );
			s21.append( " where t3.fnumber in ('02-000853','02-000854','02-000855','02-000856','02-001462','02-001463') and t1.CFBatchContractID ='"+batchContractInfo.getId()+"'" );
			if(editData.getId() != null){
				s21.append( " and t1.fid !='"+editData.getId()+"'" );
			}
			s21.append( " and to_char(t1.fbizdate,'yyyy-MM-dd HH:mm:ss')<'"+s3+"')tt");

			BigDecimal midQty = BigDecimal.ZERO;
			BigDecimal midAuditQty = BigDecimal.ZERO;
			BigDecimal midUnAuditQty = BigDecimal.ZERO;
			IRowSet r21 = SQLExecutorFactory.getRemoteInstance(s21.toString()).executeSQL();
			if(r21.next()){
				midQty = UIRuleUtil.getBigDecimal(r21.getBigDecimal("earlyQty"));
				midAuditQty = UIRuleUtil.getBigDecimal(r21.getBigDecimal("earlyAuditQty"));
				midUnAuditQty = UIRuleUtil.getBigDecimal(r21.getBigDecimal("earlyUnAuditQty"));
			}

			//中期肉仔鸡配合饲料标准用量
			txtmidStand.setValue(contRactQty.multiply(midRate).divide(new BigDecimal("100")));
			//中期肉仔鸡配合饲料已开票数量
			txtmidVouch.setValue(midQty);
			//中期肉仔鸡配合饲料已审核数量
			txtmidAudit.setValue(midAuditQty);
			//中期肉仔鸡配合饲料未审核数量
			txtmidUnAudit.setValue(midUnAuditQty);
			//中期肉仔鸡配合饲料允许开票数量
			txtmidAllow.setValue(contRactQty.multiply(midRate).divide(new BigDecimal("100")).subtract(midQty));

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
							calAmount(i);
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


	@Override
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		//		super.actionCopy_actionPerformed(e);
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
		//        editData.setNumber(null);
		//		editData.setFarmer(null);
		editData.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		editData.setNumber(CodingUtil.getNewNumberByCodingRule(null, editData));
		//		editData.setBizDate(new java.util.Date());
		setOprtState("ADDNEW");
		setDataObject(editData);
		loadFields();
		showCopyAddNew();
		//		editData.setPerson(null);
		actionCopy.setEnabled(false);
		chkMenuItemSubmitAndAddNew.setVisible(true);
		setDefaultFocused();
		isLoadField=false;

		setMakeRelations(null);

	}


	/**
	 * 设置过滤条件
	 * @param companyID
	 */
	private void setFilter() {
		if(this.prmtcompany.getValue()!=null) {
			curCompanyID=((IPropertyContainer) this.prmtcompany.getValue()).getString("id");
		}else{
			curCompanyID=null;
		}


		String farmerID="";
		String farmID="";

		farmerID=prmtfarmer.getValue()==null?"":((FarmerInfo)prmtfarmer.getValue()).getId().toString();
		farmID=prmtfarm.getValue()==null?"":((FarmInfo)prmtfarm.getValue()).getId().toString();

		//批次过滤
		StockingComm.setStockingBatchFilter(prmtbatch,curCompanyID,farmerID,farmID,true,false);
		//养殖户过滤
		StockingComm.setFarmerFilter(prmtfarmer, curCompanyID,false);
		//养殖场过滤
		StockingComm.setFarmFilter(prmtfarm, curCompanyID, farmerID,true);
		//合同过滤
		StockingComm.setBatchContractFilter(prmtbatchContract, curCompanyID,farmerID,farmID,true,true);

		//物料过滤
		KDBizPromptBox material  = (KDBizPromptBox) this.kdtEntrys.getColumn("material").getEditor().getComponent();
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		String policyID;
		if(prmtbatchContract.getValue()!=null){
			try {
				if(UIRuleUtil.getProperty((IObjectValue) prmtbatchContract.getValue(), "settlementPolicy")!=null){
					policyID = ((SettlePolicyInfo)UIRuleUtil.getProperty((IObjectValue) prmtbatchContract.getValue(), "settlementPolicy")).getId().toString();
					filter=StockingComm.getMaterialFilter(null, policyID, SettleItemType.FODDER_VALUE);
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
		//		material.setEntityViewInfo(ev);

		//车辆过滤
		String driverID=prmtdriver.getValue()==null?null:((IPropertyContainer)prmtdriver.getValue()).getString("id");
		StockingComm.setCarFilter(prmtcar, curCompanyID,driverID);
		//司机过滤
		String carID=prmtcar.getValue()==null?null:((IPropertyContainer)prmtcar.getValue()).getString("id");
		StockingComm.setDriverFilter(prmtdriver, curCompanyID, carID);
	}


	@Override
	public void kdtEntrys_Changed(int rowIndex, int colIndex) throws Exception {
		// TODO Auto-generated method stub
		super.kdtEntrys_Changed(rowIndex, colIndex);

		//根据数量处罚确认数量事件
		if(kdtEntrys.getColumn(colIndex).getKey().equals("receiveQty")) {	
			kdtEntrys_Changed(rowIndex, kdtEntrys.getColumn("confirmQty").getColumnIndex());
			kdtEntrys.getCell(rowIndex, kdtEntrys.getColumn("confirmQty").getColumnIndex()).setValue(kdtEntrys.getCell(rowIndex, "receiveQty").getValue());
			if(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "unitQty").getValue()).signum()!=0){
				if(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "receiveQty").getValue())
						.remainder(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "unitQty").getValue())).signum()!=0){
					MsgBox.showWarning("有单包重的物料领用数量必须填入包重的整数倍");
					kdtEntrys.getCell(rowIndex, "receiveQty").setValue(null);
					kdtEntrys.getCell(rowIndex, "confirmQty").setValue(null);
					return;					
				}
				kdtEntrys.getCell(rowIndex,"bagQty").setValue(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "confirmQty").getValue())
						.divide(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "unitQty").getValue()),0,RoundingMode.HALF_UP));
			}
		}
		//单包重
		if(kdtEntrys.getColumnKey(colIndex).equals("material")&&kdtEntrys.getCell(rowIndex, "material").getValue()!=null) {
			kdtEntrys.getCell(rowIndex, "unitQty").setValue(StockingComm.getUnitQty(null, curCompanyID, ((IPropertyContainer) kdtEntrys.getCell(rowIndex, "material").getValue()).getString("id")));
			kdtEntrys_Changed(rowIndex, kdtEntrys.getColumn("unitQty").getColumnIndex());
		}
		if(kdtEntrys.getColumnKey(colIndex).equals("unitQty")){
			if(kdtEntrys.getCell(rowIndex, "unitQty").getValue()==null||UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "unitQty").getValue()).signum()==0){
				kdtEntrys.getCell(rowIndex, "bagQty").setValue(null);
			}
			kdtEntrys_Changed(rowIndex, kdtEntrys.getColumn("receiveQty").getColumnIndex());
		}

		if(colIndex!=kdtEntrys.getColumn("confirmQty").getColumnIndex())
			kdtEntrys.getCell(rowIndex, kdtEntrys.getColumn("confirmQty").getColumnIndex()).setValue(kdtEntrys.getCell(rowIndex, "receiveQty").getValue());
		UITools.apendFootRow(kdtEntrys, new String[]{"receiveQty","confirmQty","bagQty","amount"});

		if(kdtEntrys.getColumnIndex("warehouse")==colIndex)
			if(kdtEntrys.getCell(rowIndex, colIndex).getValue()!=null)
				wareHouseInfo=(WarehouseInfo) kdtEntrys.getCell(rowIndex, colIndex).getValue();

		if("material".equals(kdtEntrys.getColumnKey(colIndex))){
			if(kdtEntrys.getCell(rowIndex, "material").getValue()!=null){
				String materialID = ((IPropertyContainer)kdtEntrys.getCell(rowIndex, "material").getValue()).getString("id");
				calPrice(rowIndex, materialID);	
				MaterialInventoryInfo mivInfo= StockingComm.getDefaultWarehouseDataByMaterial(null, ((StorageOrgUnitInfo)prmtstorageOrgUnit.getValue()).getString("id"), materialID);
				if(mivInfo!=null){
					kdtEntrys.getCell(rowIndex, "warehouse").setValue(mivInfo.getDefaultWarehouse());
				}
			}else{
				kdtEntrys.getCell(rowIndex, "unitQty").setValue(null);
				kdtEntrys.getCell(rowIndex, "receiveQty").setValue(null);
				kdtEntrys.getCell(rowIndex, "confirmQty").setValue(null);
				kdtEntrys.getCell(rowIndex, "bagQty").setValue(null);
			}

			//			calAveragePrice(rowIndex, materialID);
		}
		if(kdtEntrys.getColumnKey(colIndex).equals("receiveQty")){
			calAmount(rowIndex);
		}
		//点击金额，计算单价
		if(kdtEntrys.getColumnKey(colIndex).equals("amount")){
			BigDecimal amount = UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "amount").getValue());
			BigDecimal receiveQty = UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "receiveQty").getValue());
			kdtEntrys.getCell(rowIndex, "receivePrice").setValue(amount.divide(receiveQty,4,BigDecimal.ROUND_HALF_UP));


		}

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
	 * 计算金额
	 * @param rowIndex
	 */
	private void calAmount(int rowIndex) {
		if(billType.getSelectedItem()==FodderBillType.Cost){
			return;
		}
		BigDecimal amount=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "receiveQty").getValue()).multiply(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "receivePrice").getValue())).setScale(2,RoundingMode.HALF_UP);
		kdtEntrys.getCell(rowIndex, "amount").setValue(amount.compareTo(BigDecimal.ZERO)==0?null:amount);
		BigDecimal actualCost=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "receiveQty").getValue()).multiply(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "unitCost").getValue())).setScale(2,RoundingMode.HALF_UP);
		kdtEntrys.getCell(rowIndex, "actualCost").setValue(actualCost.compareTo(BigDecimal.ZERO)==0?null:actualCost);
	}


	@Override
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if(billType.getSelectedItem().equals(FodderBillType.Cost)){
			for(int i=0;i<kdtEntrys.getRowCount();i++){
				kdtEntrys.getCell(i, "receiveQty").setValue(BigDecimal.ONE);
				kdtEntrys.getCell(i, "confirmQty").setValue(BigDecimal.ONE);
			}
		}else
			//			for(int i=0;i<kdtEntrys.getRowCount();i++){
			//				calAmount(i);
			//			}


			//校验饲料数量
			checkFodderQty();

		//设置表头的‘是否进超药流程’字段
		isAllowProcess();






		super.beforeStoreFields(arg0);

		if(billType.getSelectedItem().equals(FodderBillType.Cost)){
			for(int i=0;i<kdtEntrys.getRowCount();i++){
				kdtEntrys.getCell(i, "receiveQty").setValue(BigDecimal.ZERO);
				kdtEntrys.getCell(i, "confirmQty").setValue(BigDecimal.ZERO);
			}
		}
	}
	/**
	 * 是否进超药流程字段赋值
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void isAllowProcess() throws EASBizException, BOSException {
		// TODO Auto-generated method stub

		List<String> matNum = new ArrayList<String>();
		for(int i = 0,size = kdtEntrys.getRowCount();i<size;i++){
			MaterialInfo matInfo = null;
			if(kdtEntrys.getCell(i,"material").getValue() != null){
				matInfo = (MaterialInfo) kdtEntrys.getCell(i,"material").getValue();
				matInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(matInfo.getId()));
				matNum.add(matInfo.getNumber().toString());
			}
		}


		if((matNum.contains("02-000851") || matNum.contains("02-001461") || matNum.contains("02-001509"))
				|| (matNum.contains("02-000853") || matNum.contains("02-000854")
						|| matNum.contains("02-000855")
						|| matNum.contains("02-000856")
						|| matNum.contains("02-001462")
						|| matNum.contains("02-001463"))){
			///前中都不超料
			//如果前期开票数量<=前期标准数量 并且 中期开票数量<=中期标准数量 
			if(UIRuleUtil.getBigDecimal(txtearlyVou.getValue())
					.compareTo(UIRuleUtil.getBigDecimal(txtearlyStand.getValue())) <= 0
					&& UIRuleUtil.getBigDecimal(txtmidVouch.getValue())
					.compareTo(UIRuleUtil.getBigDecimal(txtmidStand.getValue())) <= 0){
				txtallowProcess.setText("0");
			}

			//前期、中期都超料
			//如果前期开票数量>前期标准数量 并且 中期开票数量>中期标准数量 并且 后期开票数量 >后期标准数量
			if(UIRuleUtil.getBigDecimal(txtearlyVou.getValue())
					.compareTo(UIRuleUtil.getBigDecimal(txtearlyStand.getValue())) > 0
					&& UIRuleUtil.getBigDecimal(txtmidVouch.getValue())
					.compareTo(UIRuleUtil.getBigDecimal(txtmidStand.getValue())) > 0){
				txtallowProcess.setText("3");
			}else{
				txtallowProcess.setText("0");
			}


			//前中期分别判断

			//前期超 中期不超
			if(UIRuleUtil.getBigDecimal(txtearlyVou.getValue())
					.compareTo(UIRuleUtil.getBigDecimal(txtearlyStand.getValue())) > 0
					&& !(UIRuleUtil.getBigDecimal(txtmidVouch.getValue())
							.compareTo(UIRuleUtil.getBigDecimal(txtmidStand.getValue())) > 0)){
				txtallowProcess.setText("1");
			}

			//中期超 前期不超
			if(!(UIRuleUtil.getBigDecimal(txtearlyVou.getValue())
					.compareTo(UIRuleUtil.getBigDecimal(txtearlyStand.getValue())) > 0)
					&& (UIRuleUtil.getBigDecimal(txtmidVouch.getValue())
							.compareTo(UIRuleUtil.getBigDecimal(txtmidStand.getValue())) > 0)){
				txtallowProcess.setText("2");
			}
		}
	}

	/**
	 * 校验饲料数量
	 */
	private void checkFodderQty() {
		// TODO Auto-generated method stub
		try {
			BigDecimal qqty = BigDecimal.ZERO;
			BigDecimal zqty = BigDecimal.ZERO;
			BigDecimal hqty = BigDecimal.ZERO;
			List<String> matList = new ArrayList<String>();
			for(int i = 0,size = kdtEntrys.getRowCount();i<size;i++){

				MaterialInfo matInfo = null;
				if(kdtEntrys.getCell(i,"material").getValue() != null){
					matInfo = (MaterialInfo) kdtEntrys.getCell(i,"material").getValue();
					matInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(matInfo.getId()));
					//如果是前期物料
					if("02-000851".equalsIgnoreCase(matInfo.getNumber())
							|| "02-001509".equalsIgnoreCase(matInfo.getNumber())
							|| "02-001461".equalsIgnoreCase(matInfo.getNumber())){
						qqty = qqty.add(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(i,"receiveQty").getValue()));
						matList.add(matInfo.getNumber());
					}
					//如果是中期物料
					if("02-000853".equalsIgnoreCase(matInfo.getNumber())
							|| "02-000854".equalsIgnoreCase(matInfo.getNumber())
							|| "02-000855".equalsIgnoreCase(matInfo.getNumber())
							|| "02-000856".equalsIgnoreCase(matInfo.getNumber())
							|| "02-001462".equalsIgnoreCase(matInfo.getNumber())
							|| "02-001463".equalsIgnoreCase(matInfo.getNumber())){
						zqty = zqty.add(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(i,"receiveQty").getValue()));
						matList.add(matInfo.getNumber());
					}
				}
			}


			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String s3 = sdf.format(pkBizDate.getValue());


			//批次合同
			BatchContractBillInfo batchContractInfo = (BatchContractBillInfo) prmtbatchContract.getValue();
			if(batchContractInfo.getId() != null){
				batchContractInfo = BatchContractBillFactory.getRemoteInstance().getBatchContractBillInfo(new ObjectUuidPK(batchContractInfo.getId()));
			}

			//查找前中后期物料的超药比例
			if(prmtsettlePolicy.getValue() != null){

				//该批次合同雏苗数量
				BigDecimal contRactQty = batchContractInfo.getFemaleBreedQty();


				SettlePolicyInfo setInfo = (SettlePolicyInfo) prmtsettlePolicy.getValue();

				if(matList.contains("02-000851")
						|| matList.contains("02-001509")
						|| matList.contains("02-001461")){
					//------------------------------------------------------前期物料----------------------------------------------------------
					BigDecimal easlyRate = BigDecimal.ZERO;
					String s1 = "/*dialect*/ select distinct t2.CFOverRate overRate from T_FM_SettlePolicy t1 inner join T_FM_SettlePolicyPriceEntry t2 on t2.fparentid = t1.fid" +
					" inner join T_BD_Material t3 on t3.fid = t2.FMaterialID where t3.fnumber in ('02-000851','02-001461','02-001509') " +
					" and t1.fid ='"+setInfo.getId()+"'";
					IRowSet r1 = SQLExecutorFactory.getRemoteInstance(s1).executeSQL();
					if(r1.next()){
						easlyRate = UIRuleUtil.getBigDecimal(r1.getBigDecimal("overRate"));
						easlyRate = easlyRate.multiply(new BigDecimal("100"));
					}

					//前期饲料领用单领用数量
					StringBuffer s11 = new StringBuffer();
					s11.append( "/*dialect*/ select sum(tt.earlyQty) earlyQty, sum(tt.earlyAuditQty) earlyAuditQty,  sum(tt.earlyUnAuditQty) earlyUnAuditQty from (  select 0 earlyQty,sum(t2.FReceiveQty) earlyAuditQty,0 earlyUnAuditQty from T_FM_FodderReception t1");
					s11.append( " inner join T_FM_FodderReceptionEntry t2 on t2.fparentid=t1.fid inner join T_BD_Material t3 on t3.fid=t2.FMaterialID" );
					s11.append( " where t3.fnumber in ('02-000851','02-001461','02-001509') and t1.FBillStatus in(4,7) and t1.CFBatchContractID ='"+batchContractInfo.getId()+"'" );
					if(editData.getId() != null){
						s11.append( " and t1.fid !='"+editData.getId()+"'" );
					}
					s11.append( " and to_char(t1.fbizdate,'yyyy-MM-dd HH:mm:ss')<'"+s3+"'" );
					s11.append( " union all select 0 earlyQty,0 earlyAuditQty,sum(t2.FReceiveQty) earlyUnAuditQty from T_FM_FodderReception t1" );
					s11.append( " inner join T_FM_FodderReceptionEntry t2 on t2.fparentid=t1.fid inner join T_BD_Material t3 on t3.fid=t2.FMaterialID" );
					s11.append( " where t3.fnumber in ('02-000851','02-001461','02-001509') and t1.FBillStatus in (1,2) and t1.CFBatchContractID ='"+batchContractInfo.getId()+"'" );
					if(editData.getId() != null){
						s11.append( " and t1.fid !='"+editData.getId()+"'" );
					}
					s11.append( " and to_char(t1.fbizdate,'yyyy-MM-dd HH:mm:ss')<'"+s3+"'" );
					s11.append( " union all select sum(t2.FReceiveQty) earlyQty,0 earlyAuditQty,0 earlyUnAuditQty from T_FM_FodderReception t1" );
					s11.append( " inner join T_FM_FodderReceptionEntry t2 on t2.fparentid=t1.fid inner join T_BD_Material t3 on t3.fid=t2.FMaterialID" );
					s11.append( " where t3.fnumber in ('02-000851','02-001461','02-001509')  and t1.CFBatchContractID ='"+batchContractInfo.getId()+"'" );
					if(editData.getId() != null){
						s11.append( " and t1.fid !='"+editData.getId()+"'" );
					}
					s11.append( " and to_char(t1.fbizdate,'yyyy-MM-dd HH:mm:ss')<'"+s3+"')tt");


					BigDecimal earlyQty = BigDecimal.ZERO;
					BigDecimal earlyAuditQty = BigDecimal.ZERO;
					BigDecimal earlyUnAuditQty = BigDecimal.ZERO;
					IRowSet r11 = SQLExecutorFactory.getRemoteInstance(s11.toString()).executeSQL();
					if(r11.next()){
						earlyQty = UIRuleUtil.getBigDecimal(r11.getBigDecimal("earlyQty"));
						earlyAuditQty = UIRuleUtil.getBigDecimal(r11.getBigDecimal("earlyAuditQty"));
						earlyUnAuditQty = UIRuleUtil.getBigDecimal(r11.getBigDecimal("earlyUnAuditQty"));
					}

					if(qqty.add(earlyQty).compareTo(contRactQty.multiply(easlyRate).divide(new BigDecimal("100"))) > 0){
						int n = com.kingdee.eas.util.client.MsgBox.showConfirm2(this,"510饲料开票数量大于最高标准数量，是否继续？");
						if(2 == n){
							SysUtil.abort();
						}else{
							//前期肉仔鸡配合饲料已开票数量
							txtearlyVou.setValue(earlyQty.add(qqty));
							//前期肉仔鸡配合饲料审核数量
							txtearlyAudit.setValue(earlyAuditQty);
							//前期肉仔鸡配合饲料未审核数量
							txtearlyUnAudit.setValue(earlyUnAuditQty.add(qqty));
							//前期肉仔鸡配合饲料允许开票数量
							txtearlyAllow.setValue(contRactQty.multiply(easlyRate).divide(new BigDecimal("100")).subtract(earlyQty).subtract(qqty));
						}
					}else{
						//前期肉仔鸡配合饲料已开票数量
						txtearlyVou.setValue(earlyQty.add(qqty));
						//前期肉仔鸡配合饲料审核数量
						txtearlyAudit.setValue(earlyAuditQty);
						//前期肉仔鸡配合饲料未审核数量
						txtearlyUnAudit.setValue(earlyUnAuditQty.add(qqty));
						//前期肉仔鸡配合饲料允许开票数量
						txtearlyAllow.setValue(contRactQty.multiply(easlyRate).divide(new BigDecimal("100")).subtract(earlyQty).subtract(qqty));
					}
				}



				//-------------------------------------------------中期-------------------------------------------------------------------
				if(matList.contains("02-000853")
						|| matList.contains("02-000854")
						|| matList.contains("02-000855")
						|| matList.contains("02-000856")
						|| matList.contains("02-001462")
						|| matList.contains("02-001463")){
					BigDecimal midRate = BigDecimal.ZERO;
					String s2 = "/*dialect*/ select distinct t2.CFOverRate overRate from T_FM_SettlePolicy t1 inner join T_FM_SettlePolicyPriceEntry t2 on t2.fparentid = t1.fid" +
					" inner join T_BD_Material t3 on t3.fid = t2.FMaterialID where t3.fnumber in ('02-000853','02-000854','02-000855','02-000856','02-001462','02-001463') " +
					" and t1.fid ='"+setInfo.getId()+"'";
					IRowSet r2 = SQLExecutorFactory.getRemoteInstance(s2.toString()).executeSQL();
					if(r2.next()){
						midRate = UIRuleUtil.getBigDecimal(r2.getBigDecimal("overRate"));
						midRate = midRate.multiply(new BigDecimal("100"));
					}

					//中期饲料领用单领用数量
					StringBuffer s21 = new StringBuffer();
					s21.append( "/*dialect*/ select sum(tt.earlyQty) earlyQty, sum(tt.earlyAuditQty) earlyAuditQty,  sum(tt.earlyUnAuditQty) earlyUnAuditQty from (  select 0 earlyQty,sum(t2.FReceiveQty) earlyAuditQty,0 earlyUnAuditQty from T_FM_FodderReception t1");
					s21.append( " inner join T_FM_FodderReceptionEntry t2 on t2.fparentid=t1.fid inner join T_BD_Material t3 on t3.fid=t2.FMaterialID" );
					s21.append( " where t3.fnumber in ('02-000853','02-000854','02-000855','02-000856','02-001462','02-001463') and  t1.FBillStatus in(4,7)  and t1.CFBatchContractID ='"+batchContractInfo.getId()+"'" );
					if(editData.getId() != null){
						s21.append( " and t1.fid !='"+editData.getId()+"'" );
					}
					s21.append( " and to_char(t1.fbizdate,'yyyy-MM-dd HH:mm:ss')<'"+s3+"'" );
					s21.append( " union all select 0 earlyQty,0 earlyAuditQty,sum(t2.FReceiveQty) earlyUnAuditQty from T_FM_FodderReception t1" );
					s21.append( " inner join T_FM_FodderReceptionEntry t2 on t2.fparentid=t1.fid inner join T_BD_Material t3 on t3.fid=t2.FMaterialID" );
					s21.append( " where t3.fnumber in ('02-000853','02-000854','02-000855','02-000856','02-001462','02-001463') and t1.FBillStatus in (1,2) and t1.CFBatchContractID ='"+batchContractInfo.getId()+"'" );
					if(editData.getId() != null){
						s21.append( " and t1.fid !='"+editData.getId()+"'" );
					}
					s21.append( " and to_char(t1.fbizdate,'yyyy-MM-dd HH:mm:ss')<'"+s3+"'" );
					s21.append( " union all select sum(t2.FReceiveQty) earlyQty,0 earlyAuditQty,0 earlyUnAuditQty from T_FM_FodderReception t1" );
					s21.append( " inner join T_FM_FodderReceptionEntry t2 on t2.fparentid=t1.fid inner join T_BD_Material t3 on t3.fid=t2.FMaterialID" );
					s21.append( " where t3.fnumber in ('02-000853','02-000854','02-000855','02-000856','02-001462','02-001463') and t1.CFBatchContractID ='"+batchContractInfo.getId()+"'" );
					if(editData.getId() != null){
						s21.append( " and t1.fid !='"+editData.getId()+"'" );
					}
					s21.append( " and to_char(t1.fbizdate,'yyyy-MM-dd HH:mm:ss')<'"+s3+"')tt");

					BigDecimal midQty = BigDecimal.ZERO;
					BigDecimal midAuditQty = BigDecimal.ZERO;
					BigDecimal midUnAuditQty = BigDecimal.ZERO;
					IRowSet r21 = SQLExecutorFactory.getRemoteInstance(s21.toString()).executeSQL();
					if(r21.next()){
						midQty = UIRuleUtil.getBigDecimal(r21.getBigDecimal("earlyQty"));
						midAuditQty = UIRuleUtil.getBigDecimal(r21.getBigDecimal("earlyAuditQty"));
						midUnAuditQty = UIRuleUtil.getBigDecimal(r21.getBigDecimal("earlyUnAuditQty"));
					}

					if(zqty.add(midQty).compareTo(contRactQty.multiply(midRate).divide(new BigDecimal("100"))) > 0){
						int n = com.kingdee.eas.util.client.MsgBox.showConfirm2(this,"511/512饲料开票数量大于最高标准数量，是否继续？");
						if(2 == n){
							SysUtil.abort();
						}else{
							//中期肉仔鸡配合饲料已开票数量
							txtmidVouch.setValue(midQty.add(zqty));
							//中期肉仔鸡配合饲料已审核数量
							txtmidAudit.setValue(midAuditQty);
							//中期肉仔鸡配合饲料未审核数量
							txtmidUnAudit.setValue(midUnAuditQty.add(zqty));
							//中期肉仔鸡配合饲料允许开票数量
							txtmidAllow.setValue(contRactQty.multiply(midRate).divide(new BigDecimal("100")).subtract(midQty).subtract(zqty));
						}
					}else{
						//中期肉仔鸡配合饲料已开票数量
						txtmidVouch.setValue(midQty.add(zqty));
						//中期肉仔鸡配合饲料已审核数量
						txtmidAudit.setValue(midAuditQty);
						//中期肉仔鸡配合饲料未审核数量
						txtmidUnAudit.setValue(midUnAuditQty.add(zqty));
						//中期肉仔鸡配合饲料允许开票数量
						txtmidAllow.setValue(contRactQty.multiply(midRate).divide(new BigDecimal("100")).subtract(midQty).subtract(zqty));
					}
				}
			}
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