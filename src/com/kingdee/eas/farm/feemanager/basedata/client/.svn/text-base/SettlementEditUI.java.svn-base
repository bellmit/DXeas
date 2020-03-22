/**
 * output package name
 */
package com.kingdee.eas.farm.feemanager.basedata.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.farm.feemanager.basebizbill.CalfrightFacadeFactory;
import com.kingdee.eas.farm.feemanager.basedata.CarriageFormatInfo;
import com.kingdee.eas.farm.feemanager.basedata.OilPriceInfo;
import com.kingdee.eas.farm.food.comm.FarmCommUtils;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class SettlementEditUI extends AbstractSettlementEditUI {
	private static final Logger logger = CoreUIObject
			.getLogger(SettlementEditUI.class);

	/**
	 * output class constructor
	 */
	public SettlementEditUI() throws Exception {
		super();
		//图标初始化
        this.review.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
        this.unreview.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
	}

	/**
	 * output loadFields method
	 */
	public void loadFields() {
		if ((BillBaseStatusEnum.AUDITED).equals(this.state.getSelectedItem())) {
			this.actionReview.setEnabled(false);
			this.actionAddNew.setEnabled(false);
			this.actionEdit.setEnabled(false);
			this.actionRemove.setEnabled(false);
			this.actionSave.setEnabled(false);
			this.actionSubmit.setEnabled(false);
			this.review.setEnabled(false);
			// 核审状态下 核审、新增、修改、删除、保存、分录增删等不可用

		} else if ((BillBaseStatusEnum.SUBMITED).equals(this.state
				.getSelectedItem())) {
			this.actionReview.setEnabled(true);
			this.actionAddNew.setEnabled(true);
			this.actionEdit.setEnabled(true);
			this.unreview.setEnabled(false);
			this.actionRemove.setEnabled(true);

			this.actionSave.setEnabled(true);
			this.actionSubmit.setEnabled(true);
		} else if ((BillBaseStatusEnum.ADD)
				.equals(this.state.getSelectedItem())) {
			this.actionReview.setEnabled(true);
			this.actionAddNew.setEnabled(true);
			this.actionEdit.setEnabled(true);
			this.unreview.setEnabled(false);
			this.actionRemove.setEnabled(true);

			this.actionSave.setEnabled(true);
			this.actionSubmit.setEnabled(true);
		} else if ((BillBaseStatusEnum.TEMPORARILYSAVED).equals(this.state
				.getSelectedItem())) {
			this.actionReview.setEnabled(true);
			this.unreview.setEnabled(false);
			this.actionAddNew.setEnabled(true);
			this.actionEdit.setEnabled(true);

			this.actionRemove.setEnabled(true);

			this.actionSave.setEnabled(true);
			this.actionSubmit.setEnabled(true);
		} else if ((BillBaseStatusEnum.DELETED).equals(this.state
				.getSelectedItem())) {
			this.actionReview.setEnabled(false);
			this.actionAddNew.setEnabled(false);
			this.actionEdit.setEnabled(false);
			this.unreview.setEnabled(false);
			this.actionRemove.setEnabled(false);

			this.actionSave.setEnabled(false);
			this.actionSubmit.setEnabled(true);
		}
		;
		// 其他状态下均可用

		super.loadFields();
	}

	@Override
	public void actionReview_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub

		if (FarmCommUtils.checkBillStatus(this.editData.getState(),
				BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("已经核审，禁止再次核审！");
			SysUtil.abort();
		}
		if (!FarmCommUtils.checkBillStatus(this.editData.getState(),
				BillBaseStatusEnum.SUBMITED)) {
			MsgBox.showWarning("尚未提交，禁止核审！");
			SysUtil.abort();
		}

		this.editData.setState(BillBaseStatusEnum.AUDITED);
		// this.setDataObject(this.getBizInterface().getValue(new
		// ObjectUuidPK(this.editData.getId())));

		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("核审成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
		this.loadData();
		super.actionReview_actionPerformed(e);
	}

	@Override
	public void actionUnreview_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if (!FarmCommUtils.checkBillStatus(this.editData.getState(),
				BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("尚未核审，禁止反核审！");
			SysUtil.abort();
		}
		// this.setDataObject(this.editData);
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反核审成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
		this.loadData();
		super.actionUnreview_actionPerformed(e);
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		initUIComp();
	}

	/**
	 * output storeFields method
	 */
	public void storeFields() {
		super.storeFields();
	}

	private void initUIComp() {
		// TODO Auto-generated method stub

		// F7查询过滤

	
		SelectorListener[] selLiss = prmtoilstandprice.getSelectorListeners();
		for (SelectorListener liss : selLiss) {
			prmtoilstandprice.removeSelectorListener(liss);
		}
		
		
		prmtoilstandprice.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.OilStandPriceListUI prmtoilstandprice_F7ListUI = null;

			public void willShow(SelectorEvent e) {
				if (prmtoilstandprice_F7ListUI == null) {
					try {
						EntityViewInfo evi = new EntityViewInfo(); // 实体视图信息
						FilterInfo fi = new FilterInfo();// 过滤信息
						fi.getFilterItems().add(
								new FilterItemInfo("state",
										BillBaseStatusEnum.AUDITED_VALUE,
										CompareType.EQUALS));
						fi.getFilterItems().add(
								new FilterItemInfo("companyOrgUnit.id",
										SysContext.getSysContext().getCurrentFIUnit().getId().toString(),
										CompareType.EQUALS));
						fi.setMaskString("#0 and #1");
						evi.setFilter(fi);
						prmtoilstandprice_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.OilStandPriceListUI(
								evi);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner", javax.swing.SwingUtilities
							.getWindowAncestor(prmtoilstandprice_F7ListUI));
					prmtoilstandprice_F7ListUI.setF7Use(true, ctx);

					prmtoilstandprice.setSelector(prmtoilstandprice_F7ListUI);
				}
			}
		});
		
		
		
		// 分录F7查询过滤
		final KDBizPromptBox kdtCE_carsize_PromptBox = new KDBizPromptBox();
        kdtCE_carsize_PromptBox.setQueryInfo("com.kingdee.eas.farm.feemanager.basedata.app.CarriageFormatQuery");
        kdtCE_carsize_PromptBox.setVisible(true);
        kdtCE_carsize_PromptBox.setEditable(true);
        kdtCE_carsize_PromptBox.setDisplayFormat("$name$");
        kdtCE_carsize_PromptBox.setEditFormat("$carriagename$");
        kdtCE_carsize_PromptBox.setCommitFormat("$number$");
        KDTDefaultCellEditor kdtCE_carsize_CellEditor = new KDTDefaultCellEditor(kdtCE_carsize_PromptBox);
        this.kdtCE.getColumn("carsize").setEditor(kdtCE_carsize_CellEditor);
        ObjectValueRender kdtCE_carsize_OVR = new ObjectValueRender();
        kdtCE_carsize_OVR.setFormat(new BizDataFormat("$carriagename$"));
        this.kdtCE.getColumn("carsize").setRenderer(kdtCE_carsize_OVR);
        			kdtCE_carsize_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.CarriageFormatListUI kdtCE_carsize_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtCE_carsize_PromptBox_F7ListUI == null) {
					try {
						EntityViewInfo evi = new EntityViewInfo(); // 实体视图信息
                        FilterInfo fi = new FilterInfo();// 过滤信息
                        fi.getFilterItems().add(
                                new FilterItemInfo("state",
                                        BillBaseStatusEnum.AUDITED_VALUE,
                                        CompareType.EQUALS));
                        fi.getFilterItems().add(
								new FilterItemInfo("companyOrgUnit.id",
										SysContext.getSysContext().getCurrentFIUnit().getId().toString(),
										CompareType.EQUALS));
                        fi.setMaskString("#0 and #1");
                        evi.setFilter(fi);
						kdtCE_carsize_PromptBox_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.CarriageFormatListUI(evi);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtCE_carsize_PromptBox_F7ListUI));
					kdtCE_carsize_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtCE_carsize_PromptBox.setSelector(kdtCE_carsize_PromptBox_F7ListUI);
				}
			}
		});
	}

	

	/**
	 * output actionPageSetup_actionPerformed
	 */
	public void actionPageSetup_actionPerformed(ActionEvent e) throws Exception {
		super.actionPageSetup_actionPerformed(e);
	}

	/**
	 * output actionExitCurrent_actionPerformed
	 */
	public void actionExitCurrent_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionExitCurrent_actionPerformed(e);
	}

	/**
	 * output actionHelp_actionPerformed
	 */
	public void actionHelp_actionPerformed(ActionEvent e) throws Exception {
		super.actionHelp_actionPerformed(e);
	}

	/**
	 * output actionAbout_actionPerformed
	 */
	public void actionAbout_actionPerformed(ActionEvent e) throws Exception {
		super.actionAbout_actionPerformed(e);
	}

	/**
	 * output actionOnLoad_actionPerformed
	 */
	public void actionOnLoad_actionPerformed(ActionEvent e) throws Exception {
		super.actionOnLoad_actionPerformed(e);
	}

	/**
	 * output actionSendMessage_actionPerformed
	 */
	public void actionSendMessage_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionSendMessage_actionPerformed(e);
	}

	/**
	 * output actionCalculator_actionPerformed
	 */
	public void actionCalculator_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionCalculator_actionPerformed(e);
	}

	/**
	 * output actionExport_actionPerformed
	 */
	public void actionExport_actionPerformed(ActionEvent e) throws Exception {
		super.actionExport_actionPerformed(e);
	}

	/**
	 * output actionExportSelected_actionPerformed
	 */
	public void actionExportSelected_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionExportSelected_actionPerformed(e);
	}

	/**
	 * output actionRegProduct_actionPerformed
	 */
	public void actionRegProduct_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionRegProduct_actionPerformed(e);
	}

	/**
	 * output actionPersonalSite_actionPerformed
	 */
	public void actionPersonalSite_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionPersonalSite_actionPerformed(e);
	}

	/**
	 * output actionProcductVal_actionPerformed
	 */
	public void actionProcductVal_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionProcductVal_actionPerformed(e);
	}

	/**
	 * output actionExportSave_actionPerformed
	 */
	public void actionExportSave_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionExportSave_actionPerformed(e);
	}

	/**
	 * output actionExportSelectedSave_actionPerformed
	 */
	public void actionExportSelectedSave_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionExportSelectedSave_actionPerformed(e);
	}

	/**
	 * output actionKnowStore_actionPerformed
	 */
	public void actionKnowStore_actionPerformed(ActionEvent e) throws Exception {
		super.actionKnowStore_actionPerformed(e);
	}

	/**
	 * output actionAnswer_actionPerformed
	 */
	public void actionAnswer_actionPerformed(ActionEvent e) throws Exception {
		super.actionAnswer_actionPerformed(e);
	}

	/**
	 * output actionRemoteAssist_actionPerformed
	 */
	public void actionRemoteAssist_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionRemoteAssist_actionPerformed(e);
	}

	/**
	 * output actionPopupCopy_actionPerformed
	 */
	public void actionPopupCopy_actionPerformed(ActionEvent e) throws Exception {
		super.actionPopupCopy_actionPerformed(e);
	}

	/**
	 * output actionHTMLForMail_actionPerformed
	 */
	public void actionHTMLForMail_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionHTMLForMail_actionPerformed(e);
	}

	/**
	 * output actionExcelForMail_actionPerformed
	 */
	public void actionExcelForMail_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionExcelForMail_actionPerformed(e);
	}

	/**
	 * output actionHTMLForRpt_actionPerformed
	 */
	public void actionHTMLForRpt_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionHTMLForRpt_actionPerformed(e);
	}

	/**
	 * output actionExcelForRpt_actionPerformed
	 */
	public void actionExcelForRpt_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionExcelForRpt_actionPerformed(e);
	}

	/**
	 * output actionLinkForRpt_actionPerformed
	 */
	public void actionLinkForRpt_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionLinkForRpt_actionPerformed(e);
	}

	/**
	 * output actionPopupPaste_actionPerformed
	 */
	public void actionPopupPaste_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionPopupPaste_actionPerformed(e);
	}

	/**
	 * output actionToolBarCustom_actionPerformed
	 */
	public void actionToolBarCustom_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionToolBarCustom_actionPerformed(e);
	}

	/**
	 * output actionCloudFeed_actionPerformed
	 */
	public void actionCloudFeed_actionPerformed(ActionEvent e) throws Exception {
		super.actionCloudFeed_actionPerformed(e);
	}

	/**
	 * output actionCloudShare_actionPerformed
	 */
	public void actionCloudShare_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionCloudShare_actionPerformed(e);
	}

	/**
	 * output actionCloudScreen_actionPerformed
	 */
	public void actionCloudScreen_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionCloudScreen_actionPerformed(e);
	}

	/**
	 * output actionXunTongFeed_actionPerformed
	 */
	public void actionXunTongFeed_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionXunTongFeed_actionPerformed(e);
	}

	/**
	 * output actionSave_actionPerformed
	 */
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		super.actionSave_actionPerformed(e);
	}

	/**
	 * output actionSubmit_actionPerformed
	 */
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
//		super.storeFields();
//		CarriageFormatInfo cinfo = (CarriageFormatInfo)this.prmtcarriage.getValue();
//		OilPriceInfo oinfo = (OilPriceInfo)this.prmtoilprice.getValue();
//		BigDecimal cb = new BigDecimal(cinfo.getFKilpfreightkil().toString());
//		BigDecimal osp = new BigDecimal(oinfo.getStandardprice().toString());
//		BigDecimal op = new BigDecimal(oinfo.getDailyprice().toString());
//		BigDecimal of = new BigDecimal(this.editData.getOilfloat().toString());
//		BigDecimal ff = new BigDecimal(this.editData.getFrightfloat().toString());
//		
//		BigDecimal result = new BigDecimal("0");
//		op = op.subtract(osp);
//		//取余
//		op = op.divideAndRemainder(of)[1];
//		op = op.multiply(ff);
//		result = result.add(cb);
//		result = result.add(op);
//		this.txtpolicyfreight.setValue(result);
//		this.txtpolicyfreight.setText(result.toString());
		super.actionSubmit_actionPerformed(e);
	}

	/**
	 * output actionCancel_actionPerformed
	 */
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		super.actionCancel_actionPerformed(e);
	}

	/**
	 * output actionCancelCancel_actionPerformed
	 */
	public void actionCancelCancel_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionCancelCancel_actionPerformed(e);
	}

	/**
	 * output actionFirst_actionPerformed
	 */
	public void actionFirst_actionPerformed(ActionEvent e) throws Exception {
		super.actionFirst_actionPerformed(e);
	}

	/**
	 * output actionPre_actionPerformed
	 */
	public void actionPre_actionPerformed(ActionEvent e) throws Exception {
		super.actionPre_actionPerformed(e);
	}

	/**
	 * output actionNext_actionPerformed
	 */
	public void actionNext_actionPerformed(ActionEvent e) throws Exception {
		super.actionNext_actionPerformed(e);
	}

	/**
	 * output actionLast_actionPerformed
	 */
	public void actionLast_actionPerformed(ActionEvent e) throws Exception {
		super.actionLast_actionPerformed(e);
	}

	/**
	 * output actionPrint_actionPerformed
	 */
	public void actionPrint_actionPerformed(ActionEvent e) throws Exception {
		super.actionPrint_actionPerformed(e);
	}

	/**
	 * output actionPrintPreview_actionPerformed
	 */
	public void actionPrintPreview_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionPrintPreview_actionPerformed(e);
	}

	/**
	 * output actionCopy_actionPerformed
	 */
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		super.actionCopy_actionPerformed(e);
	}

	/**
	 * output actionAddNew_actionPerformed
	 */
	public void actionAddNew_actionPerformed(ActionEvent e) throws Exception {
		super.actionAddNew_actionPerformed(e);
	}

	/**
	 * output actionEdit_actionPerformed
	 */
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		super.actionEdit_actionPerformed(e);
		if (FarmCommUtils.checkBillStatus(this.editData.getState(),
				BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经核审，禁止修改！");
			SysUtil.abort();
		}
	}

	/**
	 * output actionRemove_actionPerformed
	 */
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		super.actionRemove_actionPerformed(e);
		if (FarmCommUtils.checkBillStatus(this.editData.getState(),
				BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经核审，禁止修改！");
			SysUtil.abort();
		}
	}

	/**
	 * output actionAttachment_actionPerformed
	 */
	public void actionAttachment_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionAttachment_actionPerformed(e);
	}

	/**
	 * output actionSubmitOption_actionPerformed
	 */
	public void actionSubmitOption_actionPerformed(ActionEvent e)
			throws Exception {
		super.actionSubmitOption_actionPerformed(e);
	}

	/**
	 * output actionReset_actionPerformed
	 */
	public void actionReset_actionPerformed(ActionEvent e) throws Exception {
		super.actionReset_actionPerformed(e);
	}

	/**
	 * output actionMsgFormat_actionPerformed
	 */
	public void actionMsgFormat_actionPerformed(ActionEvent e) throws Exception {
		super.actionMsgFormat_actionPerformed(e);
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface()
			throws Exception {
		return com.kingdee.eas.farm.feemanager.basedata.SettlementFactory
				.getRemoteInstance();
	}

	/**
	 * output setDataObject method
	 */
	public void setDataObject(IObjectValue dataObject) {
		super.setDataObject(dataObject);
		if (STATUS_ADDNEW.equals(getOprtState())) {
			editData
					.put(
							"treeid",
							(com.kingdee.eas.farm.feemanager.basedata.SettlementTreeInfo) getUIContext()
									.get(UIContext.PARENTNODE));
		}
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData() {
		com.kingdee.eas.farm.feemanager.basedata.SettlementInfo objectValue = new com.kingdee.eas.farm.feemanager.basedata.SettlementInfo();
		objectValue
				.setCreator((com.kingdee.eas.base.permission.UserInfo) (com.kingdee.eas.common.client.SysContext
						.getSysContext().getCurrentUser()));
		
				

		return objectValue;
	}

}