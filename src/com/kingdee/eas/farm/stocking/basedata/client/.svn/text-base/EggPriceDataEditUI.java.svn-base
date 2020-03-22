/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata.client;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.custom.commld.UIUtil;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.SettlementItemFactory;
import com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo;
import com.kingdee.eas.farm.stocking.basedata.StatementsPolicyCollection;
import com.kingdee.eas.farm.stocking.basedata.StatementsPolicyFactory;
import com.kingdee.eas.farm.stocking.basedata.StatementsPolicyInfo;
import com.kingdee.eas.farm.stocking.basedata.StatementsPolicyRecycleEntryCollection;
import com.kingdee.eas.farm.stocking.basedata.StatementsPolicyRecycleEntryFactory;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.framework.ObjectValueUtil;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class EggPriceDataEditUI extends AbstractEggPriceDataEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(EggPriceDataEditUI.class);
	private String curStorageOrgUnitID;//当前库存组织
	private String curCompanyID;//当前财务组织
	private F7ContextManager f7Manager;
	private OrgUnitInfo orgInfo = null;//库存组织
	/**
	 * output class constructor
	 */
	public EggPriceDataEditUI() throws Exception
	{
		super();
	}
	@Override
	public void loadFields() {
		// TODO Auto-generated method 
		super.loadFields();
		if(this.editData.getBaseStatus()!=null) {
			if(this.editData.getBaseStatus().equals(FarmBaseStatusEnum.enable)) {
				this.actionCancel.setEnabled(true);
				this.actionCancelCancel.setEnabled(false);
				this.actionEdit.setEnabled(false);
			}
			else if(this.editData.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(true);
				this.actionEdit.setEnabled(false);
			} else {
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(false);
				this.actionEdit.setEnabled(true);
			}
		}

		kdtPriceEntry.addKDTEditListener(new KDTEditAdapter(){
			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
				
				//计算价格浮动
				if("currentPrice".equalsIgnoreCase(kdtPriceEntry.getColumn(e.getColIndex()).getKey())){
					if(kdtPriceEntry.getCell(e.getRowIndex(), "settleItem").getValue()==null){
						kdtPriceEntry.getCell(e.getRowIndex(), e.getColIndex()).setValue(e.getOldValue());
						commUtils.giveUserTipsAndRetire("请先填写结算项目");
					}
					if(e.getValue()==null)
						kdtPriceEntry.getCell(e.getRowIndex(), "price").setValue(null);
					BigDecimal baseprice=BigDecimal.ZERO;
					if(kdtPriceEntry.getCell(e.getRowIndex(), "basePrice").getValue()!=null)
						baseprice=(BigDecimal) kdtPriceEntry.getCell(e.getRowIndex(), "basePrice").getValue();
					kdtPriceEntry.getCell(e.getRowIndex(), "price").setValue(((BigDecimal)e.getValue()).subtract(baseprice));
				}
				
				//获取结算政策的基本价格
				if("settleItem".equalsIgnoreCase(kdtPriceEntry.getColumn(e.getColIndex()).getKey())){
					if(e.getValue()==null){
						for(int i=kdtPriceEntry.getColumn("seq").getColumnIndex();i<kdtPriceEntry.getColumnCount();i++)
							kdtPriceEntry.getCell(e.getRowIndex(), i).setValue(null);
						return;
					}

					SettlementItemInfo settleItemInfo = (SettlementItemInfo)e.getValue();
					//获取当前结算项目的政策价格
					if(pkeffectDate.getValue()==null&&pkunEffectDate.getValue()==null){
						kdtPriceEntry.getCell(e.getRowIndex(), e.getColIndex()).setValue(e.getOldValue());
						commUtils.giveUserTipsAndRetire("生效日期和失效日期不能为空");
					}
					if(prmtcompany.getValue()==null){
						kdtPriceEntry.getCell(e.getRowIndex(), e.getColIndex()).setValue(e.getOldValue());
						commUtils.giveUserTipsAndRetire("财务组织");
					}

					if(prmtsettlePolicy.getValue()==null)
						commUtils.giveUserTipsAndRetire("请先填写结算政策");
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date beginDate = (Date)pkeffectDate.getValue();
					Date endDate = (Date)pkunEffectDate.getValue();
					try {
						//养殖政策
						
						StatementsPolicyCollection coll = StatementsPolicyFactory.getRemoteInstance().getStatementsPolicyCollection("where id='"+((IPropertyContainer)prmtsettlePolicy.getValue()).getString("id")+"'");     
//								"where baseStatus=3 and beginDate<={"+sdf.format(beginDate)+"} and endDate>={"+sdf.format(endDate)+"} and company='"+(UIRuleUtil.getProperty((IObjectValue)prmtcompany.getValue(),"id").toString())+"'");
						if(coll.size()>0){
							StatementsPolicyInfo statementPolicyInfo = coll.get(0);
							//回收政策
							StatementsPolicyRecycleEntryCollection recycleEntryColl = StatementsPolicyRecycleEntryFactory.getRemoteInstance().getStatementsPolicyRecycleEntryCollection(
									"where settlementItem='"+settleItemInfo.getString("id")+"' and parent='"+statementPolicyInfo.getId()+"'");
							if(recycleEntryColl.size()>0)
								kdtPriceEntry.getCell(e.getRowIndex(), "basePrice").setValue(recycleEntryColl.get(0).getBasePrice());
							else{
								kdtPriceEntry.getCell(e.getRowIndex(), e.getColIndex()).setValue(e.getOldValue());
								commUtils.giveUserTipsAndRetire("没有该结算项目的回收政策");
							}
						}else{
							kdtPriceEntry.getCell(e.getRowIndex(), e.getColIndex()).setValue(e.getOldValue());
							commUtils.giveUserTipsAndRetire("没有当前期间的结算政策");
						}
					} catch (BOSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				super.editStopped(e);
			}
		});
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.stocking.basedata.EggPriceDataFactory.getRemoteInstance();
	}

	/**
	 * output setDataObject method
	 */
	public void setDataObject(IObjectValue dataObject) 
	{
		super.setDataObject(dataObject);
		if(STATUS_ADDNEW.equals(getOprtState())) {
			editData.put("treeid",(com.kingdee.eas.farm.stocking.basedata.EggPriceDataTreeInfo)getUIContext().get(UIContext.PARENTNODE));
		}
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.stocking.basedata.EggPriceDataInfo objectValue = new com.kingdee.eas.farm.stocking.basedata.EggPriceDataInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo()));
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setEffectDate(new java.util.Date());
		objectValue.setUnEffectDate(new java.util.Date());
		return objectValue;
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		UIUtil.setQualityPhaseDisplayFormat(new KDTable[]{kdtPriceEntry});
		curStorageOrgUnitID=StockingClientComm.checkAndGetStorageOrgUnitID();
		curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		super.onLoad();
		orgInfo = CompanyOrgUnitFactory.getRemoteInstance().getOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID));
		f7Manager = new F7ContextManager(this, OrgType.Company);
		initControl();
	}

	private void initControl() {
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));

		this.pkeffectDate.setDatePattern("yyyy-MM-dd");
		this.pkunEffectDate.setDatePattern("yyyy-MM-dd");

		BaseSysSettingInfo sysSetting = StockingComm.getSysSetting(null, SysContext.getSysContext().getCurrentFIUnit().getString("id"));
		if(sysSetting==null) {
			MsgBox.showWarning("请设置系统参数");
			SysUtil.abort();
		}
		CompanyF7 cf7=new CompanyF7();
		cf7.setIsCUFilter(true);
		this.prmtcompany.setSelector(cf7);
		prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				if(e.getNewValue()==null) {
					curCompanyID=null;
				}else{
					curCompanyID=((IPropertyContainer) e.getNewValue()).getString("id");
				}
				setSettleItemFilter();
			}});

		f7Manager.registerBizMaterialF7(this.prmtmaterial, null, null, orgInfo,false);

		f7Manager.registerBizMaterialF7((KDBizPromptBox) kdtPriceEntry.getColumn("material").getEditor().getComponent(), null, null, orgInfo,false);

		setSettleItemFilter();
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
		this.actionCancelCancel.setEnabled(true);
		this.actionEdit.setEnabled(false);

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
	}
	@Override
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		//		super.actionCopy_actionPerformed(e);
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
		//		loadData();
		loadFields();

		showCopyAddNew();
		this.actionCopy.setEnabled(false);
		this.chkMenuItemSubmitAndAddNew.setVisible(true);
		this.baseStatus.setSelectedIndex(0);
		setDefaultFocused();
	}
	/**
	 * 设置结算项目过滤条件
	 */
	private void setSettleItemFilter() {
		//结算项目过滤
		final KDBizPromptBox kdtPriceEntry_settlementItem_PromptBox = new KDBizPromptBox();
		kdtPriceEntry_settlementItem_PromptBox.setQueryInfo("com.kingdee.eas.farm.stocking.hatch.app.EggRelationQuery");
		kdtPriceEntry_settlementItem_PromptBox.setVisible(true);
		kdtPriceEntry_settlementItem_PromptBox.setEditable(true);
		kdtPriceEntry_settlementItem_PromptBox.setDisplayFormat("$number$");
		kdtPriceEntry_settlementItem_PromptBox.setEditFormat("$number$");
		kdtPriceEntry_settlementItem_PromptBox.setCommitFormat("$number$");
		KDTDefaultCellEditor kdtPriceEntry_settlementItem_CellEditor = new KDTDefaultCellEditor(kdtPriceEntry_settlementItem_PromptBox);
		this.kdtPriceEntry.getColumn("settleItem").setEditor(kdtPriceEntry_settlementItem_CellEditor);
		ObjectValueRender kdtPriceEntry_settlementItem_OVR = new ObjectValueRender();
		kdtPriceEntry_settlementItem_OVR.setFormat(new BizDataFormat("$name$"));
		this.kdtPriceEntry.getColumn("settleItem").setRenderer(kdtPriceEntry_settlementItem_OVR);
		kdtPriceEntry_settlementItem_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.SettlementItemListUI kdtPriceEntry_settlementItem_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtPriceEntry_settlementItem_PromptBox_F7ListUI == null) {
					try {
						kdtPriceEntry_settlementItem_PromptBox_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.SettlementItemListUI(){
							@Override
							protected FilterInfo getDefaultFilterForQuery() {
								FilterInfo filter=new FilterInfo();
								filter.getFilterItems().add(new FilterItemInfo("company.id",curCompanyID,CompareType.EQUALS));
								filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.ENABLE_VALUE,CompareType.EQUALS));
								return filter;
							}
							@Override
							protected boolean isIgnoreCUFilter() {
								// TODO Auto-generated method stub
								return false;
							}
							@Override
							protected boolean isIgnoreTreeCUFilter() {
								// TODO Auto-generated method stub
								return false;
							}
						};
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtPriceEntry_settlementItem_PromptBox_F7ListUI));
					kdtPriceEntry_settlementItem_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtPriceEntry_settlementItem_PromptBox.setSelector(kdtPriceEntry_settlementItem_PromptBox_F7ListUI);
				}
			}
		});
	}
}