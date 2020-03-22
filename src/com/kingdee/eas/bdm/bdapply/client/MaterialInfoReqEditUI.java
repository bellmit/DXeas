/**
 * output package name
 */
package com.kingdee.eas.bdm.bdapply.client;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.EventListener;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTActiveCellEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTActiveCellListener;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.framework.util.EntityControlTypeUtil;
import com.kingdee.eas.basedata.master.material.IMaterialGroupStandard;
import com.kingdee.eas.basedata.master.material.MaterialGroupFactory;
import com.kingdee.eas.basedata.master.material.MaterialGroupInfo;
import com.kingdee.eas.basedata.master.material.MaterialGroupStandardCollection;
import com.kingdee.eas.basedata.master.material.MaterialGroupStandardFactory;
import com.kingdee.eas.basedata.master.material.MaterialGroupStandardInfo;
import com.kingdee.eas.basedata.master.material.MaterialGroupStandardTypeEnum;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.UsedStatusEnum;
import com.kingdee.eas.basedata.master.material.client.F7BaseSelector;
import com.kingdee.eas.basedata.master.material.client.F7MaterialGroupUI;
import com.kingdee.eas.basedata.master.material.client.MaterialClientTools;
import com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus;
import com.kingdee.eas.bdm.bdapply.util.ChineseCharToEn;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.commld.ListenerUtil;
import com.kingdee.eas.framework.ObjectValueUtil;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class MaterialInfoReqEditUI extends AbstractMaterialInfoReqEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(MaterialInfoReqEditUI.class);
	private MaterialGroupStandardCollection materialGroupStandards;
	private MaterialGroupStandardInfo materialGroupStandardInfo;
	private MaterialGroupInfo materialBrowseGroup;
	/**
	 * output class constructor
	 */
	public MaterialInfoReqEditUI() throws Exception
	{
		super();
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		ListenerUtil.F7RemoveDateChangeListener(prmtmaterialGroup);
		super.loadFields();
		if(this.oprtState.equals(OprtState.ADDNEW)) {
			this.loadGroupData();
			this.loadMaterialGroupTable(materialGroupStandards, null);
		}

		prmtmaterialGroup.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {
				// TODO Auto-generated method stub
				if(prmtmaterialGroup.getValue() != null){
//					String id = ((IPropertyContainer)prmtmaterialGroup.getValue()).getString("id");
//					String sql = "select CFTaxRate from T_BD_MaterialGroup where FID='"+id+"' and CFTaxRate is not null";
//					try {
//						IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
//						if(rs.next()){
//							txttaxRate.setValue(UIRuleUtil.getBigDecimal(rs.getBigDecimal("CFTaxRate")));
//						}
//					} catch (BOSException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
				}
			}});
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.bdm.bdapply.MaterialInfoReqInfo objectValue = new com.kingdee.eas.bdm.bdapply.MaterialInfoReqInfo();
		try {
			objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
			objectValue.setBizDate(new java.util.Date());
			objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
			objectValue.setPricepPrecision(new BigDecimal(3));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return objectValue;
	}
	@Override
	protected IObjectValue createNewDetailData(KDTable paramKDTable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected void doAfterSave(IObjectPK pk) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterSave(pk);
		oprtState=OprtState.EDIT;
	}
	@Override
	protected void doAfterSubmit(IObjectPK pk) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterSubmit(pk);
		oprtState=OprtState.EDIT;
	}
	/**
	 * output actionSave_actionPerformed
	 */
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		if (this.editData.getBillStatus().equals(bdaApplyBillStatus.Submit)) {
			MsgBox.showInfo("该单据已经提交，请重新提交！");
			SysUtil.abort();
		}
		if (this.editData.getBillStatus().equals(bdaApplyBillStatus.Audit)) {
			MsgBox.showInfo("该单据已经完成审核操作！");
			SysUtil.abort();
		}
		checknull();
		UniqueMaterialReq();
		setedit();
		super.actionSave_actionPerformed(e);
	}
	/**
	 * output actionEdit_actionPerformed
	 */
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		if (this.editData.getBillStatus().equals(bdaApplyBillStatus.Audit)) {
			MsgBox.showInfo("该单据已经完成审核操作！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);
	}

	/**
	 * output actionSubmit_actionPerformed
	 */
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {

		if (this.editData.getBillStatus().equals(bdaApplyBillStatus.Audit)) {
			MsgBox.showInfo("该单据已经完成审核操作！");
			SysUtil.abort();
		}
		checknull();
		UniqueMaterialReq();
		UniqueMaterial();
		setedit();
		super.actionSubmit_actionPerformed(e);
	}
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		chkMenuItemSubmitAndAddNew.setVisible(false);
		chkMenuItemSubmitAndAddNew.setSelected(false);
		setbartoolstate();
		this.contBizDate.setVisible(false);
		this.contcolordisplay.setVisible(false);
		this.txtname.setRequired(true);

		this.prmtassistUnit.setDisplayFormat("$name$");
		this.prmtlengthUnit.setDisplayFormat("$name$");
		this.prmtweightUnit.setDisplayFormat("$name$");
		this.prmtvolummUnit.setDisplayFormat("$name$");

		//this.prmtmaterialGroup.setQueryInfo("com.kingdee.eas.bdm.bdapply.app.F7MaterialGroupQuery");
		UIContext ctx = new UIContext(this);
		ctx.put("onlyBaseStandard", Boolean.TRUE);
		ctx.put("cu", SysContext.getSysContext().getCurrentCtrlUnit());
		/* MaterialGroupStandardInfo msInfo=MaterialGroupStandardFactory.getRemoteInstance().getMaterialGroupStandardInfo(new ObjectUuidPK("9owAAAAwB4yXm+Ef"));
		 ctx.put("groupStandard", msInfo);*/

		F7BaseSelector f7Selector2 = new F7BaseSelector(com.kingdee.eas.basedata.master.material.client.F7MaterialGroupUI.class, prmtmaterialGroup, ctx);
		this.prmtmaterialGroup.setSelector(f7Selector2);
		this.prmtmaterialGroup.setVisible(true);
		this.prmtmaterialGroup.setEditable(true);
		this.prmtmaterialGroup.setDisplayFormat("$displayname$");
		this.prmtmaterialGroup.setEditFormat("$number$");
		this.prmtmaterialGroup.setCommitFormat("$number$");
		this.prmtmaterialGroup.setRequired(true);

		EntityViewInfo view = new EntityViewInfo();
		/*  942 */     FilterInfo filterInfo = new FilterInfo();
		/*  943 */     filterInfo.getFilterItems().add(new FilterItemInfo("groupStandard.standardType", new Integer(1)));
		/*  954 */     view.setFilter(filterInfo);
		/*  955 */     this.prmtmaterialGroup.setEntityViewInfo(view);

		this.txtNumber.requestFocus();

		this.contLastUpdateTime.setVisible(true);
		this.contLastUpdateUser.setVisible(true);

		this.materialInfoAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.basenotby.setIcon(EASResource.getIcon("imgTbtn_unaudit"));

		MaterialClientTools.setMeasureUnitF7(this, this.prmtbaseUnit);
		MaterialClientTools.setMeasureUnitF7(this, this.prmtinvUnit);
		MaterialClientTools.setMeasureUnitF7(this, this.prmtassistUnit);

		kdtMaterialStdEntry.checkParsed();
		KDBizPromptBox materialGroupStd=new KDBizPromptBox();
		materialGroupStd.setQueryInfo("com.kingdee.eas.basedata.master.material.app.MaterialGroupStandardQuery");
		materialGroupStd.setVisible(true);
		materialGroupStd.setEditable(true);
		materialGroupStd.setDisplayFormat("$displayname$");
		materialGroupStd.setEditFormat("$number$");
		materialGroupStd.setCommitFormat("$number$");
		KDTDefaultCellEditor editor=new KDTDefaultCellEditor(materialGroupStd);
		this.kdtMaterialStdEntry.getColumn("materialClassifyStd").setEditor(editor);
		this.kdtMaterialStdEntry.getColumn("materialClassifyStd").setWidth(200);

		KDBizPromptBox materialGroup=new KDBizPromptBox();
		materialGroup.setSelector(f7Selector2);
		materialGroup.setVisible(true);
		materialGroup.setEditable(true);
		materialGroup.setDisplayFormat("$displayname$");
		materialGroup.setEditFormat("$number$");
		materialGroup.setCommitFormat("$number$");
		KDTDefaultCellEditor editor2=new KDTDefaultCellEditor(materialGroup);
		this.kdtMaterialStdEntry.getColumn("materialClassify").setEditor(editor2);
		this.kdtMaterialStdEntry.getColumn("materialClassify").setWidth(200);

		this.kdtMaterialStdEntry.addKDTActiveCellListener(new KDTActiveCellListener(){
			public void activeCellChanged(KDTActiveCellEvent e) {
				_activeCellChanged(e.getRowIndex(),e.getColumnIndex());
			}});
		this.prmtbaseUnit.addDataChangeListener(new com.kingdee.bos.ctrl.swing.event.DataChangeListener() {
			public void dataChanged(com.kingdee.bos.ctrl.swing.event.DataChangeEvent e) {
				try {
					prmtbaseUnit_dataChanged(e);
				} catch (Exception exc) {
					handUIException(exc);
				} finally {
				}
			}
		});
		
		if(oprtState.equals("ADDNEW")){
			txtpricepPrecision.setValue(new BigDecimal(2));
		}
	}

	public void _activeCellChanged(int rowIndex, int columnIndex)
	{
		if ("materialClassify".equals(this.kdtMaterialStdEntry.getColumnKey(columnIndex))) {
			KDBizPromptBox promptBox = new KDBizPromptBox();
			EntityViewInfo view = new EntityViewInfo();
			FilterInfo filterInfo = new FilterInfo();
			promptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.MaterialGroupQuery");


			IRow rowMaterial = this.kdtMaterialStdEntry.getRow(rowIndex);

			if (!(rowMaterial.getCell("materialClassifyStd").getValue() instanceof MaterialGroupStandardInfo)) {
				return;
			}
			MaterialGroupStandardInfo std = (MaterialGroupStandardInfo)rowMaterial.getCell("materialClassifyStd").getValue();

			filterInfo.getFilterItems().add(new FilterItemInfo("groupStandard.id", std.getId().toString(), CompareType.EQUALS));


			if (!(MaterialInfo.isAllowNonLeafGroup())) {
				filterInfo.getFilterItems().add(new FilterItemInfo("isLeaf", Boolean.TRUE));
			}
			view.setFilter(filterInfo);
			promptBox.setEntityViewInfo(view);
			promptBox.setEditable(true);
			promptBox.setDisplayFormat("$name$");
			promptBox.setEditFormat("$name$");
			promptBox.setCommitFormat("$number$");

			UIContext ctx = new UIContext(this);

			ctx.put("cu", SysContext.getSysContext().getCurrentCtrlUnit());
			ctx.put("groupStandard", std);
			F7BaseSelector f7Selector = new F7BaseSelector(F7MaterialGroupUI.class, promptBox, ctx);
			promptBox.setSelector(f7Selector);

			this.kdtMaterialStdEntry.getColumn("materialClassify").setEditor(new KDTDefaultCellEditor(promptBox));
		}
	}

	@Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		super.onShow();
	}
	// 唯一验证
	public void UniqueMaterialReq() {
		if (this.oprtState.equals(OprtState.ADDNEW)) {
			String sql = "select * from CT_BDM_MaterialInfoReq where cfname='"+ this.txtname.getText().trim() + "'";
			if(this.txtmodel.getText().trim().equals(""))
				sql+= "and (CFModel='"+this.txtmodel.getText().trim()+"' or CFModel is null)";
			else 
				sql+= "and CFModel='"+this.txtmodel.getText().trim()+"'";
			if (checkrepeat(sql, "")) {
				this.txtname.requestFocus();
				MsgBox.showInfo("申请单中该名称+规格型号已存在，请检查");
				SysUtil.abort();
			}
		}
		if (this.oprtState.equals(OprtState.EDIT)) {
			String sql = "select * from CT_BDM_MaterialInfoReq where fid !='"+ editData.getId() + "' and cfname='"+ this.txtname.getText().trim() + "' ";
			if(this.txtmodel.getText().trim().equals(""))
				sql+= "and (CFModel='"+this.txtmodel.getText().trim()+"' or CFModel is null)";
			else 
				sql+= "and CFModel='"+this.txtmodel.getText().trim()+"'";
			if (checkrepeat(sql, "")) {
				this.txtname.requestFocus();
				MsgBox.showInfo("申请单中该名称+规格型号已存在，请检查");
				SysUtil.abort();
			}
		}

	}

	public void UniqueMaterial(){
		String sql = "select * from t_bd_Material where fname_l2='"+ this.txtname.getText().trim() + "' ";
		if(this.txtmodel.getText().trim().equals(""))
			sql+= "and (FModel='"+this.txtmodel.getText().trim()+"' or FModel is null)";
		else 
			sql+= "and FModel='"+this.txtmodel.getText().trim()+"'";
		if (checkrepeat(sql, "")) {
			this.txtname.requestFocus();
			MsgBox.showInfo("物料资料中该名称+规格型号已存在，请检查");
			SysUtil.abort();
		}
	}

	public void setbartoolstate() {
		if (editData.getId() != null) {
			if (this.editData.getBillStatus().equals(bdaApplyBillStatus.Audit)) {
				this.btnEdit.setEnabled(false);
				this.btnRemove.setEnabled(false);
				this.btnSave.setEnabled(false);
				this.btnSubmit.setEnabled(false);
				this.btnCreateTo.setEnabled(false);
			}
		}
	}

	public boolean checkrepeat(String sql, String except) {
		boolean bl = true;// 存在
		IRowSet rs = null;
		try {
			rs = SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
			if (rs.next()) {
				bl = true;
			} else {
				bl = false;
			}
		} catch (Exception e1) {
			super.handleException(e1);
		} 
		return bl;
	}
	//刷新页面
	protected void refreshCurPage() throws EASBizException, BOSException,
	Exception {
		if (editData.getId() != null) {
			com.kingdee.bos.dao.IObjectPK iObjectPk = new ObjectUuidPK(editData.getId());
			IObjectValue iObjectValue = getValue(iObjectPk);
			setDataObject(iObjectValue);
			loadFields();
			setSave(true);
		}
	}

	public void checknull() throws EASBizException, BOSException {
		if (this.txtname.getText().equals("")) {
			MsgBox.showInfo("名称不能 为空,请检查 ");
			this.txtname.requestFocus();
			SysUtil.abort();
		}
		//		if (StringUtils.isBlank(this.txthelpCode.getText())) {
		try {
			txthelpCode.setText(ChineseCharToEn.getAllFirstLetter(this.txtname.getText()));
		}catch(Exception err) {
			err.printStackTrace();
			MsgBox.showInfo("自动生成助记码失败，请手动设置");
			SysUtil.abort();
		}

		//		}
		if (this.txthelpCode.getText().equals("")) {
			MsgBox.showInfo("助记码空,请检查 ");
			this.txthelpCode.requestFocus();
			SysUtil.abort();

		}
		if (this.prmtmaterialGroup.getValue()==null) {
			MsgBox.showInfo("物料基本分类不能 为空,请检查 ");
			this.prmtmaterialGroup.requestFocus();
			SysUtil.abort();
		}else{
			MaterialGroupInfo mgroupInfo=(MaterialGroupInfo)this.prmtmaterialGroup.getValue();
			ObjectUuidPK pk=new ObjectUuidPK(mgroupInfo.getId());
			mgroupInfo=MaterialGroupFactory.getRemoteInstance().getMaterialGroupInfo(pk);
			if(mgroupInfo.isIsLeaf()==false){
				MsgBox.showInfo("物料基本分类请选择明细,请检查！ ");
				this.prmtmaterialGroup.requestFocus();
				SysUtil.abort();
			}
		}
		if (this.prmtbaseUnit.getValue()==null) {
			MsgBox.showInfo("基本计量单位不能 为空,请检查 ");
			this.prmtbaseUnit.requestFocus();
			SysUtil.abort();
		}else if(this.prmtassistUnit.getValue() != null){
			MeasureUnitInfo baseUnitInfo = (MeasureUnitInfo) this.prmtbaseUnit.getValue();
			MeasureUnitInfo assitUnitInfo = (MeasureUnitInfo) this.prmtassistUnit.getValue();
			if(baseUnitInfo.getId().toString().equals(assitUnitInfo.getId().toString())){
				MsgBox.showInfo("辅助计量单位不能和基本计量单位相同,请检查 ");
				this.prmtbaseUnit.requestFocus();
				SysUtil.abort();
			}
		}
	}
	public void actionMaterialInfoAudit_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		String currentCompanyId = SysContext.getSysContext().getCurrentFIUnit().getId().toString();
		if (!currentCompanyId.equals("00000000-0000-0000-0000-000000000000CCE7AED4")) {
			MsgBox.showInfo("非集团组织下不允许审核！");
			SysUtil.abort();
		}
		if (this.editData.getId()==null) {
			MsgBox.showInfo("请先保存单据");
			SysUtil.abort();
		}
		if (!this.editData.getBillStatus().equals(bdaApplyBillStatus.Submit)) {
			MsgBox.showInfo("只能审核提交状态的单据！");
			SysUtil.abort();
		}
		/*if (this.editData.getBillStatus().equals(bdaApplyBillStatus.Audit)||this.editData.getBillStatus().equals(bdaApplyBillStatus.unAudit)) {
			MsgBox.showInfo("该单据已经完成审核操作！");
			SysUtil.abort();
		}*/
		//UniqueMaterial()s;
		//this.actionSubmit_actionPerformed(null);
		super.actionMaterialInfoAudit_actionPerformed(e);
		MsgBox.showInfo("审核成功");
		refreshCurPage();
	}

	// @Override审核部通过按钮
	public void actionBasenotby_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		String currentCompanyId = SysContext.getSysContext().getCurrentFIUnit().getId().toString();
		if (!currentCompanyId.equals("00000000-0000-0000-0000-000000000000CCE7AED4")) {
			MsgBox.showInfo("非集团组织下不允许操作！");
			SysUtil.abort();
		}
		if (this.editData.getId()==null) {
			MsgBox.showInfo("请先保存单据");
			SysUtil.abort();
		}
		if (!this.editData.getBillStatus().equals(bdaApplyBillStatus.Submit)) {
			MsgBox.showInfo("只能审核提交状态的单据！");
			SysUtil.abort();
		}
		super.actionBasenotby_actionPerformed(e);
//		this.actionSubmit_actionPerformed(null);
		/*if (this.editData.getBillStatus().equals(bdaApplyBillStatus.Audit)||this.editData.getBillStatus().equals(bdaApplyBillStatus.unAudit)) {
			MsgBox.showInfo("该单据已经完成审核操作！");
			SysUtil.abort();
		}*/
		String billId=this.editData.getId().toString();
		String uiname="com.kingdee.eas.bdm.bdapply.client.UpdateErrorMsgUI";
		UIContext uicontext = new UIContext();
		uicontext.put("cuid","");
		uicontext.put("billType","物料");
		uicontext.put("billId",billId);
		IUIWindow iuiwindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create(uiname, uicontext, null, OprtState.EDIT);
		iuiwindow.show();
		refreshCurPage();
	}
	// 去掉属性的前后空格
	public void setedit() {
		this.txtname.setText(this.txtname.getText().trim());
		this.txtalias.setText(this.txtalias.getText().trim());
		this.txtbarcode.setText(this.txtbarcode.getText().trim());
		this.txtDescription.setText(this.txtDescription.getText().trim());
		this.txtforeignname.setText(this.txtforeignname.getText().trim());
		this.txthelpCode.setText(this.txthelpCode.getText().trim());
		this.txtmodel.setText(this.txtmodel.getText());
		this.txtregisteredmark.setText(this.txtregisteredmark.getText().trim());
		this.txtshortname.setText(this.txtshortname.getText().trim());
		this.txtgrossWeight.setText(this.txtgrossWeight.getText().trim());
		this.txtregisteredmark.setText(this.txtregisteredmark.getText().trim());
		this.txtwarrantnumber.setText(this.txtwarrantnumber.getText().trim());
	}
	@Override
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		if (!(UtilRequest.isPrepare("ActionCopy", this))) {
			checkModified();
		}

		if ((this.editData != null) && (!(OprtState.VIEW.equals(getOprtState())))) {
			IObjectValue objectValue = (IObjectValue) getUIContext().get("CURRENT.VO");
			if (objectValue != null) {
				try {
					String id = this.idList.getID(this.idList.getCurrentIndex());
					setOprtState("RELEASEALL");
					pubFireVOChangeListener(id);
				} catch (Throwable E) {
				}
			}
		}
		ObjectValueUtil.copy(this.editData);

		unLockUI();

		setFieldsNull(this.editData);
		setOprtState("ADDNEW");
		this.editData.setBillStatus(bdaApplyBillStatus.Save);
		this.editData.setStatus(UsedStatusEnum.UNAPPROVE);
		setDataObject(this.editData);
		innerLoadFields();

		showCopyAddNew();
		this.actionCopy.setEnabled(false);
		this.chkMenuItemSubmitAndAddNew.setVisible(true);
		setDefaultFocused();

		setMakeRelations(null);
	}

	private void innerLoadFields() {
		EventListener[] lsts = removeDetailTableListener(KDTPropertyChangeListener.class);
		loadFields();
		restoreDetailTableListener(KDTPropertyChangeListener.class, lsts);
	}
	protected void loadGroupData()
	{
		try
		{
			IMaterialGroupStandard iMaterialGroupStandard = MaterialGroupStandardFactory.getRemoteInstanceWithObjectContext(getMainOrgContext());

			EntityViewInfo view = new EntityViewInfo();
			view.setFilter(EntityControlTypeUtil.getFilterInfoForControlTypeS4(SysContext.getSysContext().getCurrentCtrlUnit().getString("id"),SysContext.getSysContext().getCurrentCtrlUnit().getLongNumber()));


			FilterInfo filterInfo = new FilterInfo();
			filterInfo.getFilterItems().add(new FilterItemInfo("standardType", MaterialGroupStandardTypeEnum.BasicStandard, CompareType.NOTEQUALS));



			view.getFilter().mergeFilter(filterInfo, "and");
			this.materialGroupStandards = iMaterialGroupStandard.getMaterialGroupStandardCollection(view);

		}
		catch (Exception e)
		{
			handUIException(e);
		}
	}

	protected void loadMaterialGroupTable(MaterialGroupStandardCollection standards, MaterialInfo materialInfo)
	{
		this.kdtMaterialStdEntry.removeRows();
		MaterialGroupStandardInfo stdVO = null;
		MaterialGroupInfo grpVO = null;
		if (standards != null) {
			int i = 0; for (int c = standards.size(); i < c; ++i) {
				stdVO = standards.get(i);
				grpVO = getMaterialGroupByStandard(stdVO, materialInfo);

				if (stdVO.getStandardType() != MaterialGroupStandardTypeEnum.BasicStandard) {
					IRow row = this.kdtMaterialStdEntry.addRow();

					row.getCell("materialClassifyStd").setValue(stdVO);
					row.getCell("materialClassify").setValue(grpVO);
				}
			}
		}
	}

	protected MaterialGroupInfo getMaterialGroupByStandard(MaterialGroupStandardInfo standard, MaterialInfo vo)
	{
		if ((OprtState.ADDNEW.equals(getOprtState())) && 
				(this.materialGroupStandardInfo != null) && 
				(standard.getNumber().equals(this.materialGroupStandardInfo.getNumber()))) {
			return this.materialBrowseGroup;
		}

		return null;
	}
	/**
	 * 基本计量单位选中后自动更新 库存计量单位
	 */
	protected void prmtbaseUnit_dataChanged(DataChangeEvent e) throws Exception {

		MeasureUnitInfo baseUnit = (MeasureUnitInfo) this.prmtbaseUnit.getValue();
		this.prmtinvUnit.setValue(baseUnit);
	}
}