/**
 * output package name
 */
package com.kingdee.eas.bdm.bdapply.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.eas.basedata.assistant.CityFactory;
import com.kingdee.eas.basedata.assistant.CityInfo;
import com.kingdee.eas.basedata.assistant.CountryFactory;
import com.kingdee.eas.basedata.assistant.ProvinceFactory;
import com.kingdee.eas.basedata.master.cssp.CSSPGroupFactory;
import com.kingdee.eas.basedata.master.cssp.CSSPGroupInfo;
import com.kingdee.eas.basedata.master.cssp.UsedStatusEnum;
import com.kingdee.eas.bdm.bdapply.SupplierReqInfo;
import com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus;
import com.kingdee.eas.bdm.bdapply.util.ChineseCharToEn;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.framework.CoreBaseCollection;
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
public class SupplierReqEditUI extends AbstractSupplierReqEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(SupplierReqEditUI.class);
	public String cuid="";
	/**
	 * output class constructor
	 */
	public SupplierReqEditUI() throws Exception
	{
		super();
		setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		super.loadFields();
		setAddressFilter();
	}

	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		SupplierReqInfo objectValue = new SupplierReqInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setPurInOrgUnit(SysContext.getSysContext().getCurrentPurchaseUnit());

		objectValue.setUserstated(UsedStatusEnum.UNAPPROVE);
		objectValue.setBizDate(new Date(System.currentTimeMillis()));
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		try {
			objectValue.setCountry(CountryFactory.getRemoteInstance().getCountryInfo(new ObjectUuidPK("6a05bcad-00fd-1000-e000-01e6c0a8100d2665126B")));
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objectValue;
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
		checkIsNull();
		UniqueSupplierReq();
		setEditTrim();
		super.actionSave_actionPerformed(e);
	}


	@Override
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(!UtilRequest.isPrepare("ActionCopy", this)){
			checkModified();
		}
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
		editData.setUserstated(UsedStatusEnum.UNAPPROVE);
		editData.setBillStatus(bdaApplyBillStatus.Save);
		editData.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		setOprtState("ADDNEW");
		setDataObject(editData);
		loadFields();
		showCopyAddNew();
		actionCopy.setEnabled(false);
		chkMenuItemSubmitAndAddNew.setVisible(true);
		setDefaultFocused();

		setMakeRelations(null);
	}
	/**
	 * output actionSubmit_actionPerformed
	 */
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {

		if (this.editData.getBillStatus().equals(bdaApplyBillStatus.Audit)) {
			MsgBox.showInfo("该单据已经完成审核操作！");
			SysUtil.abort();
		}
		checkIsNull();
		UniqueSupplierReq();
		UniqueSupplier();
		setEditTrim();
		String name=this.txtname.getText();
		if(name==null)name="";
		String taxregisterno=this.txttaxRegisterNo.getText();
		if(taxregisterno==null)taxregisterno="";

		super.actionSubmit_actionPerformed(e);
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
	 * output actionSupplierAudit_actionPerformed
	 */
	public void actionSupplierAudit_actionPerformed(ActionEvent e)throws Exception {
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
		//		this.actionSubmit_actionPerformed(null);
		super.actionSupplierAudit_actionPerformed(e);
		MsgBox.showInfo("审核成功");
		refreshCurPage();
	}
	// 重载的方法与自定义的方法

	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.setUITitle("供应商申请单");
		chkMenuItemSubmitAndAddNew.setVisible(false);
		chkMenuItemSubmitAndAddNew.setSelected(false);
		this.contBizDate.setVisible(false);
		this.contcolordisplay.setVisible(false);
		this.txtname.setRequired(true);
		//this.txtbizRegisterNo.setRequired(true);
		this.txtaddress.setRequired(true);

		this.txtNumber.requestFocus();
		this.userstated.setEditable(false);
		this.prmtparent.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.PSupplierQuery");
		this.prmtparent.setVisible(true);
		this.prmtparent.setEditable(true);
		this.prmtparent.setDisplayFormat("$name$");
		this.prmtparent.setEditFormat("$number$");
		this.prmtparent.setCommitFormat("$number$");
		//this.prmtparent.setRequired(false);
		/*
		CSSPGroupF7UI

		SelectorListener[] ls = prmtCSSGroup.getSelectorListeners();
		for(int index=0;index<ls.length;index++) {
			prmtCSSGroup.removeSelectorListener(ls[index]);
		}
		this.prmtCSSGroup.setDisplayFormat("$displayname$");
		this.prmtCSSGroup.setEditFormat("$number$");
		this.prmtCSSGroup.setCommitFormat("$number$");
		 this.prmtCSSGroup.setRequired(true);
		 prmtCSSGroup.addSelectorListener(new SelectorListener() {
			 SupplierGroupListUI prmt_F7ListUI = null;
				public void willShow(SelectorEvent e) {
					if (prmt_F7ListUI == null) {
							prmt_F7ListUI = new SupplierGroupListUI();
					}

					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmt_F7ListUI));
					prmt_F7ListUI.setF7Use(true,ctx);
					prmtCSSGroup.setSelector(prmt_F7ListUI);
				}
			});
		 */



		this.contLastUpdateTime.setVisible(true);
		this.contLastUpdateUser.setVisible(true);

		this.supplieraduit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.basenotby.setIcon(EASResource.getIcon("imgTbtn_unaudit"));

		this.contBizDate.setVisible(true);

		FilterInfo filterinfo = new FilterInfo();
		filterinfo.getFilterItems().add(new FilterItemInfo("isLeaf", 1,CompareType.EQUALS));
		EntityViewInfo evi = new EntityViewInfo();
		evi.setFilter(filterinfo);
		this.prmtCSSGroup.setEntityViewInfo(evi);
		//customergroup
		/*this.prmtCSSGroup.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.F7SupplierGroupQuery");
		prmtCSSGroup.setVisible(true);
		prmtCSSGroup.setEditable(true);
		prmtCSSGroup.setDisplayFormat("$number$");
		prmtCSSGroup.setEditFormat("$name$");
		prmtCSSGroup.setCommitFormat("$number$");
		prmtCSSGroup.setEntityViewInfo(evi);*/

		setBarToolState();

		prmtcountry.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				setAddressFilter();
			}});
		prmtprovince.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				setAddressFilter();
			}});
		prmtcity.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				setAddressFilter();
			}});
		prmtregion.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				setAddressFilter();
			}});
		prmtprovince.setCommitFormat("$name$");
		prmtcity.setCommitFormat("$name$");
		prmtcity.setDisplayFormat("$name$");
		prmtCSSGroup.setCommitFormat("$name$");
		prmtCSSGroup.addDataChangeListener(new DataChangeListener(){

			public void dataChanged(DataChangeEvent paramDataChangeEvent) {
				// TODO Auto-generated method stub
				if(prmtCSSGroup.getValue()!=null){
					try {
						CSSPGroupInfo cssGrpupInfo = (CSSPGroupInfo)prmtCSSGroup.getValue();
						SelectorItemCollection slor=new SelectorItemCollection();
						slor.add("*");
						slor.add("Parent.*");
						slor.add("parent.parent.*");
						cssGrpupInfo=CSSPGroupFactory.getRemoteInstance().getCSSPGroupInfo(new ObjectUuidPK(cssGrpupInfo.getString("id")),slor);
						if(cssGrpupInfo.isIsLeaf()){
							if(cssGrpupInfo.getParent().getName().endsWith("省")||cssGrpupInfo.getParent().getName().endsWith("市")||cssGrpupInfo.getParent().getName().endsWith("自治区")){
								String provinceName = cssGrpupInfo.getParent().getName();
								provinceName=provinceName.substring(0,provinceName.lastIndexOf("省")>0?provinceName.lastIndexOf("省"):provinceName.length());
								provinceName=provinceName.substring(0,provinceName.lastIndexOf("市")>0?provinceName.lastIndexOf("市"):provinceName.length());
								provinceName=provinceName.substring(0,provinceName.lastIndexOf("自治区")>0?provinceName.lastIndexOf("自治区"):provinceName.length());

								CoreBaseCollection coll = ProvinceFactory.getRemoteInstance().getCollection("where name like '"+provinceName+"%'");
								if(coll.size()==1){
									prmtprovince.setValue(coll.get(0));
									String cityName = cssGrpupInfo.getName();
									cityName=cityName.substring(0,cityName.lastIndexOf("市")>0?cityName.lastIndexOf("市"):cityName.length());
									cityName=cityName.substring(0,cityName.lastIndexOf("区")>0?cityName.lastIndexOf("区"):cityName.length());
									coll=CityFactory.getRemoteInstance().getCollection("where name like '"+cityName+"%'");
									CoreBaseCollection collCity = CityFactory.getRemoteInstance().getCollection("where name like '"+provinceName+"%'");

									//直辖市下属
									if(coll.size()==1)
										prmtcity.setValue(coll.get(0));
									else if(collCity.size()>0&&((CityInfo)collCity.get(0)).isIsDirCity()){
										prmtcity.setValue(collCity.get(0));
									}
									else
										prmtcity.setValue(null);
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

	/**
	 * 设置地区过滤
	 */
	private void setAddressFilter() {
		String countryNum=null,provinceNum=null,cityNum=null;
		if(prmtcountry.getValue()!=null){
			countryNum=((IPropertyContainer) prmtcountry.getValue()).getString("number");
		}
		if(prmtprovince.getValue()!=null){
			provinceNum=((IPropertyContainer) prmtprovince.getValue()).getString("number");
		}
		if(prmtcity.getValue()!=null){
			cityNum=((IPropertyContainer) prmtcity.getValue()).getString("number");
		}
		EntityViewInfo ev1=new EntityViewInfo();
		FilterInfo filter1=new FilterInfo();
		filter1.getFilterItems().add(new FilterItemInfo("country.number",countryNum,CompareType.EQUALS));
		ev1.setFilter(filter1);
		prmtprovince.setEntityViewInfo(ev1);

		EntityViewInfo ev2=new EntityViewInfo();
		FilterInfo filter2=new FilterInfo();
		filter2.getFilterItems().add(new FilterItemInfo("province.number",provinceNum,CompareType.EQUALS));
		ev2.setFilter(filter2);
		prmtcity.setEntityViewInfo(ev2);

		EntityViewInfo ev3=new EntityViewInfo();
		FilterInfo filter3=new FilterInfo();
		filter3.getFilterItems().add(new FilterItemInfo("city.number",cityNum,CompareType.EQUALS));
		ev3.setFilter(filter3);
		prmtregion.setEntityViewInfo(ev3);

	}

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

	// 唯一验证
	public boolean checkrepeat(String sql, String except) {
		boolean bl = true;// 存在
		IRowSet rs = null;
		try {
			rs =SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
			if (rs.next()) {
				bl = true;
			} else {
				bl = false;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 

		return bl;
	}

	// --需要修改
	public void UniqueSupplierReq() {
		String sql="";
		if (this.oprtState.equals(OprtState.ADDNEW)) {
			//			String sql = "select * from CT_BDM_SupplierReq where cfname='"
			//					+ this.txtname.getText().trim() + "' ";
			//			if (checkrepeat(sql, "")) {
			//				MsgBox.showInfo("申请单名称已存在，请检查");
			//				this.txtname.requestFocus();
			//				SysUtil.abort();
			//			}
			sql = "select * from CT_BDM_SupplierReq where cftaxregisterno='"
				+ this.txttaxRegisterNo.getText() + "' ";
			if (checkrepeat(sql, "")) {
				MsgBox.showInfo("申请单税务登记号已存在，请检查");
				this.txttaxRegisterNo.requestFocus();
				SysUtil.abort();
			}
		}
		if (this.oprtState.equals(OprtState.EDIT)) {
			//			String sql = "select * from CT_BDM_SupplierReq where fid<>'"
			//					+ editData.getId() + "' and cfname='"
			//					+ this.txtname.getText().trim() + "' ";
			//			if (checkrepeat(sql, "")) {
			//				MsgBox.showInfo("申请单名称已存在，请检查");
			//				this.txtname.requestFocus();
			//				SysUtil.abort();
			//			}
			sql = "select * from CT_BDM_SupplierReq where fid<>'"
				+ editData.getId() + "' and cftaxregisterno='"
				+ this.txttaxRegisterNo.getText().trim() + "' ";
			if (checkrepeat(sql, "")) {
				MsgBox.showInfo("申请单税务登记号已存在，请检查");
				this.txttaxRegisterNo.requestFocus();
				SysUtil.abort();
			}
		}
	}

	public void UniqueSupplier() {
		String sql="";
		//		String sql = "select * from t_bd_supplier where fname_l2='"
		//				+ this.txtname.getText().trim() + "'";
		//		if (checkrepeat(sql, "")) {
		//			MsgBox.showInfo("供应商名称已存在，请检查");
		//			this.txtname.requestFocus();
		//			SysUtil.abort();
		//		}
		sql = "select * from t_bd_supplier where  ftaxregisterno='"
			+ this.txttaxRegisterNo.getText().trim() + "' ";
		if (checkrepeat(sql, "")) {
			MsgBox.showInfo("供应商税务登记号已存在，请检查");
			this.txttaxRegisterNo.requestFocus();
			SysUtil.abort();
		}

	}


	@Override
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if(txttaxRegisterNo.getStringValue().length() != 18){
			MsgBox.showInfo("社会信用代码的长度必须为18位");
			SysUtil.abort();
		}
		super.beforeStoreFields(arg0);
	}
	public void setBarToolState() {
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


	public void checkIsNull() {
		if (this.txtname.getText().equals("")) {
			MsgBox.showInfo("名称不能为空,请检查");
			txtname.requestFocus();
			SysUtil.abort();
		}
		//		if (StringUtils.isBlank(this.txtmnemonicCode.getText())) {
		try {
			txtmnemonicCode.setText(ChineseCharToEn.getAllFirstLetter(this.txtname.getText()));
		}catch(Exception err) {
			err.printStackTrace();
			MsgBox.showInfo("自动生成助记码失败，请手动设置");
			SysUtil.abort();
		}

		//		}
		if (this.txtmnemonicCode.getText().equals("")) {

			MsgBox.showInfo("助记码不能为空,请检查");
			txtmnemonicCode.requestFocus();
			SysUtil.abort();
		}
		if (this.txttaxRegisterNo.getText().equals("")) {
			MsgBox.showInfo("税务登记号不能为空,请检查");
			txttaxRegisterNo.requestFocus();
			SysUtil.abort();
		}
		if(this.prmtCSSGroup.getValue()!=null) {
			CSSPGroupInfo ob = (CSSPGroupInfo) this.prmtCSSGroup.getValue();
			if(!ob.isIsLeaf()) {
				MsgBox.showInfo("供应商分类请选择明细节点！ ");
				SysUtil.abort();
			}
		}
	}

	// @Override
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
		//		super.actionBasenotby_actionPerformed(e);
		//		this.actionSubmit_actionPerformed(null);
		String billId=this.editData.getId().toString();
		String uiname="com.kingdee.eas.bdm.bdapply.client.UpdateErrorMsgUI";
		UIContext uicontext = new UIContext();
		uicontext.put("cuid",cuid);
		uicontext.put("billType","供应商");
		uicontext.put("billId",billId);
		IUIWindow iuiwindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create(
				uiname, uicontext, null, OprtState.VIEW);
		iuiwindow.show();
		super.actionBasenotby_actionPerformed(e);
		refreshCurPage();
	}
	// 去掉属性的前后空格
	public void setEditTrim() {
		this.txtname.setText(this.txtname.getText().trim());
		this.txtaddress.setText(this.txtaddress.getText().trim());

		this.txtbarcode.setText(this.txtbarcode.getText().trim());
		this.txtDescription.setText(this.txtDescription.getText().trim());
		this.txtforeignName.setText(this.txtforeignName.getText().trim());
		this.txtmnemonicCode.setText(this.txtmnemonicCode.getText().trim());
		this.txtNumber.setText(this.txtNumber.getText().trim());
		this.txtsimplename.setText(this.txtsimplename.getText().trim());
		this.txttaxRegisterNo.setText(this.txttaxRegisterNo.getText().trim());
		this.txtvesion.setText(this.txtvesion.getText().trim());
		this.txtGSPAuthentication.setText(this.txtGSPAuthentication.getText().trim());
		this.txttaxRate.setText(this.txttaxRate.getText().trim());
		this.txtbusiExequatur.setText(this.txtbusiExequatur.getText().trim());
	}
	@Override
	protected IObjectValue createNewDetailData(KDTable paramKDTable) {
		// TODO Auto-generated method stub
		return null;
	}
}