/**
 * output package name
 */
package com.kingdee.eas.bdm.bdapply.client;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.extendcontrols.ext.IFilterInfoProducer;
import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTActiveCellEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTActiveCellListener;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.assistant.CityFactory;
import com.kingdee.eas.basedata.assistant.CityInfo;
import com.kingdee.eas.basedata.assistant.CountryFactory;
import com.kingdee.eas.basedata.assistant.CountryInfo;
import com.kingdee.eas.basedata.assistant.CurrencyInfo;
import com.kingdee.eas.basedata.assistant.PaymentTypeFactory;
import com.kingdee.eas.basedata.assistant.ProvinceFactory;
import com.kingdee.eas.basedata.assistant.ProvinceInfo;
import com.kingdee.eas.basedata.framework.util.EntityControlTypeUtil;
import com.kingdee.eas.basedata.master.cssp.CSSPGroupFactory;
import com.kingdee.eas.basedata.master.cssp.CSSPGroupInfo;
import com.kingdee.eas.basedata.master.cssp.CSSPGroupStandardCollection;
import com.kingdee.eas.basedata.master.cssp.CSSPGroupStandardFactory;
import com.kingdee.eas.basedata.master.cssp.CSSPGroupStandardInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerGroupDetailCollection;
import com.kingdee.eas.basedata.master.cssp.CustomerGroupDetailInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.cssp.ICSSPGroup;
import com.kingdee.eas.basedata.master.cssp.ICSSPGroupStandard;
import com.kingdee.eas.basedata.master.cssp.StandardTypeEnum;
import com.kingdee.eas.basedata.master.cssp.UsedStatusEnum;
import com.kingdee.eas.basedata.master.material.client.FilterUtil;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.SaleOrgUnitInfo;
import com.kingdee.eas.basedata.person.IPerson;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.basedata.scm.sd.sale.ISaleGroup;
import com.kingdee.eas.basedata.scm.sd.sale.ISalePerson;
import com.kingdee.eas.basedata.scm.sd.sale.SaleGroupCollection;
import com.kingdee.eas.basedata.scm.sd.sale.SaleGroupFactory;
import com.kingdee.eas.basedata.scm.sd.sale.SaleGroupInfo;
import com.kingdee.eas.basedata.scm.sd.sale.SalePersonCollection;
import com.kingdee.eas.basedata.scm.sd.sale.SalePersonFactory;
import com.kingdee.eas.basedata.scm.sd.sale.SalePersonInfo;
import com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus;
import com.kingdee.eas.bdm.bdapply.util.ChineseCharToEn;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.commld.ListenerUtil;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.ExceptionHandler;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class CustomerInfoReqEditUI extends AbstractCustomerInfoReqEditUI
{

	private static final Logger logger = CoreUIObject.getLogger(CustomerInfoReqEditUI.class);
	public String cuid="";
	protected CSSPGroupStandardCollection customerGroupStandards = null;
	private static final Color necessaryColor = new Color(252, 255, 206);
	private static final Integer defaultType = new Integer("0");
	private static final Integer typeForCustomer = new Integer("1");
	/**
	 * output class constructor
	 */
	public CustomerInfoReqEditUI() throws Exception
	{
		super();
		setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		// 销售组F7
		this.prmtsaleGroup.setQueryInfo("com.kingdee.eas.bdm.bdapply.app.SaleGroupF7Query");	
	}
	@Override
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if(this.txtbizRegisterNo.getStringValue() == null){
			MsgBox.showConfirm2("税务登记号不能为空！");
			SysUtil.abort();
		}

		// 食品公司部分字段设置表必填
		//		if(prmtcompany.getValue() != null && customerType.getSelectedItem().equals(CustomerType.Comm)){
		//			String companyName = ((IPropertyContainer)prmtcompany.getValue()).getString("name");
		//			if(StringUtils.isNotEmpty(companyName) && companyName.indexOf("食品") >= 0){
		//				if(this.prmtcity.getValue() == null){
		//					MsgBox.showInfo("城市不能为空！");
		//					SysUtil.abort();
		//				}
		//				if(prmtSalePerson.getValue() == null){
		//					MsgBox.showInfo("销售员不能为空！");
		//					SysUtil.abort();
		//				}
		////				if(StringUtils.isEmpty(txtcontractPerson.getStringValue())){
		////					MsgBox.showInfo("联系人不能为空！");
		////					SysUtil.abort();
		////				}
		////				if(StringUtils.isEmpty(txtmobile.getStringValue())){
		////					MsgBox.showInfo("联系人手机号码不能为空！");
		////					SysUtil.abort();
		////				}
		//
		//				if(StringUtils.isEmpty(txtmonthSaleQty.getStringValue())){
		//					MsgBox.showInfo("月销量不能为空！");
		//					SysUtil.abort();
		//				}
		//				if(StringUtils.isEmpty(txtpinPai.getStringValue())){
		//					MsgBox.showInfo("品牌不能为空！");
		//					SysUtil.abort();
		//				}
		//				if(StringUtils.isEmpty(txtpinXiang.getStringValue())){
		//					MsgBox.showInfo("品相不能为空！");
		//					SysUtil.abort();
		//				}
		//				if(StringUtils.isEmpty(txtaddress.getStringValue())){
		//					MsgBox.showInfo("地址不能为空！");
		//					SysUtil.abort();
		//				}
		//				for(int i=0;i < kdtCustomerGroupEntry.getRowCount();i++){
		//					if(kdtCustomerGroupEntry.getCell(i, "customerGroup").getValue() == null){
		//						MsgBox.showInfo("第"+(i+1)+"行客户分类不能为空");
		//						SysUtil.abort();
		//					}
		//				}
		//			}
		//		}
		super.beforeStoreFields(arg0);
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		DataChangeListener[] getDateChangeListener = ListenerUtil.F7GetDateChangeListener(prmtSalePerson);
		ListenerUtil.F7RemoveDateChangeListener(prmtSalePerson);
		super.loadFields();
		ListenerUtil.F7AddDateChangeListener(prmtSalePerson, getDateChangeListener);
		if(oprtState.equals(OprtState.ADDNEW)) {
			loadGroupData();
			loadCustomerGroupTable(this.customerGroupStandards, null);
		}
		setAddressFilter();

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
	protected void loadGroupData()
	{
		try
		{
			if (this.customerGroupStandards == null)

			{
				ICSSPGroupStandard iCustomerGroupStandard = CSSPGroupStandardFactory.getRemoteInstanceWithObjectContext(getMainOrgContext());

				EntityViewInfo evi = new EntityViewInfo();
				evi.setFilter(EntityControlTypeUtil.getFilterInfoForControlTypeS4(SysContext.getSysContext().getCurrentCtrlUnit().getString("id"), SysContext.getSysContext().getCurrentCtrlUnit().getLongNumber()));


				FilterInfo filterInfo = new FilterInfo();
				filterInfo.getFilterItems().add(new FilterItemInfo("type", defaultType, CompareType.EQUALS));



				filterInfo.getFilterItems().add(new FilterItemInfo("type", typeForCustomer, CompareType.EQUALS));


				filterInfo.setMaskString("#0 or #1");
				evi.getFilter().mergeFilter(filterInfo, "and");
				SorterItemInfo sorterByBasic = new SorterItemInfo("isBasic");
				sorterByBasic.setSortType(SortType.DESCEND);
				evi.getSorter().add(sorterByBasic);
				this.customerGroupStandards = iCustomerGroupStandard.getCSSPGroupStandardCollection(evi);
			}

			this.kdtCustomerGroupEntry.checkParsed();
			if (this.customerGroupStandards.size() == 0) {
				this.kdtCustomerGroupEntry.addRow();
			}
		}
		catch (Exception e)
		{
			ExceptionHandler.handle(this, EASResource.getString("com.kingdee.eas.basedata.master.cssp.CSSPResource", "loadCSGroupInfoFailed") + e.getMessage(), e);
		}
	}

	protected void loadCustomerGroupTable(CSSPGroupStandardCollection standards, CustomerInfo vo)
	{
		CSSPGroupInfo[] tempSaveGroup = null;
		CSSPGroupStandardInfo[] tempSaveGroupStandard = null;
		String[] tempSaveGroupStandardFullName = null;
		this.kdtCustomerGroupEntry.removeRows();
		CSSPGroupStandardInfo stdVO = null;
		CSSPGroupInfo grpVO = null;
		String grpFullName = null;

		if (standards != null) {
			int i = 0; for (int c = standards.size(); i < c; ++i) {
				stdVO = standards.get(i);
				grpVO = getCustomerGroupByStandard(stdVO, null);
				try {
					grpFullName = getGroupFullName(grpVO);
				} catch (Exception e) {
					handUIException(e);

				}

				IRow row = this.kdtCustomerGroupEntry.addRow();

				row.getCell(0).setValue(stdVO);
				row.getCell(1).setValue(grpVO);
				row.getCell(2).setValue(grpFullName);

				if ((!(stdVO.getIsBasic().equals(StandardTypeEnum.basicStandard))) || (
						(!(getOprtState().equals(OprtState.EDIT))) && (!(getOprtState().equals(OprtState.ADDNEW)))))
					continue;
				row.getCell(1).getStyleAttributes().setBackground(necessaryColor);
			}
		}

		if((getOprtState().equals(OprtState.EDIT) || getOprtState().equals(OprtState.ADDNEW))){
			for(int i=0;i<kdtCustomerGroupEntry.getRowCount();i++){
				if(kdtCustomerGroupEntry.getCell(i, "customerGroupstd").getValue() != null ){
					if(((IPropertyContainer)kdtCustomerGroupEntry.getCell(i, "customerGroupstd").getValue()).getString("number").equals("003")){
						kdtCustomerGroupEntry.getCell(i,"customerGroup").getStyleAttributes().setBackground(necessaryColor);
					}
				}
			}
		}
	}
	protected CSSPGroupInfo getCustomerGroupByStandard(CSSPGroupStandardInfo standard, CustomerInfo vo)
	{
		if (vo != null) {
			CustomerGroupDetailCollection details = vo.getCustomerGroupDetails();

			int i = 0; for (int c = details.size(); i < c; ++i) {
				CustomerGroupDetailInfo detail = details.get(i);
				if ((detail != null) && (detail.getCustomerGroupStandard() != null) && (standard != null) && (detail.getCustomerGroupStandard().getId().toString().equalsIgnoreCase(standard.getId().toString())))
				{
					return detail.getCustomerGroup();

				}
			}

		}

		return null;
	}
	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}
	@Override
	protected IObjectValue createNewDetailData(KDTable paramKDTable) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * output createNewData method
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData() 
	{
		com.kingdee.eas.bdm.bdapply.CustomerInfoReqInfo objectValue = new com.kingdee.eas.bdm.bdapply.CustomerInfoReqInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setSaleOrgUnit(SysContext.getSysContext().getCurrentSaleUnit());
		CurrencyInfo rmb = new CurrencyInfo();
		rmb.setId(BOSUuid.read("dfd38d11-00fd-1000-e000-1ebdc0a8100dDEB58FDC"));
		rmb.setNumber("BB01");
		rmb.setName("人民币");
		objectValue.setSettlementCurrency(rmb);
		try {
			objectValue.setPayType(PaymentTypeFactory.getRemoteInstance().getPaymentTypeInfo(new ObjectUuidPK("cd54aa9f-03a4-459c-9c5a-5489dce5f0676BCA0AB5")));
			CountryInfo china = CountryFactory.getRemoteInstance().getCountryInfo(new ObjectUuidPK("6a05bcad-00fd-1000-e000-01e6c0a8100d2665126B"));
			objectValue.setCountry(china);

		} catch (EASBizException e) {

			e.printStackTrace();
		} catch (BOSException e) {

			e.printStackTrace();
		}

		objectValue.setStatus(UsedStatusEnum.UNAPPROVE);
		objectValue.setBizDate(new java.util.Date());
		return objectValue;
	}
	/**
	 * output actionSave_actionPerformed
	 */
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		if (this.editData.getBillStatus()!=null&&this.editData.getBillStatus().equals(bdaApplyBillStatus.Submit)) {
			MsgBox.showInfo("该单据已经提交，请重新提交！");
			SysUtil.abort();
		}
		if (this.editData.getBillStatus()!=null&&this.editData.getBillStatus().equals(bdaApplyBillStatus.Audit)) {
			MsgBox.showInfo("该单据已经完成审核操作！");
			SysUtil.abort();
		}
		checknull();
		UniqueCustomerReq();
		UniqueCustomer();
		setedit();

		super.actionSave_actionPerformed(e);
	}

	/**
	 * output actionSubmit_actionPerformed
	 */
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		if (this.editData.getBillStatus()!=null&&this.editData.getBillStatus().equals(bdaApplyBillStatus.Audit)) {
			MsgBox.showInfo("该单据已经完成审核操作！");
			SysUtil.abort();
		}
		checknull();
		UniqueCustomerReq();
		UniqueCustomer();
		setedit();

		super.actionSubmit_actionPerformed(e);
	}
	/**
	 * output actionEdit_actionPerformed
	 */
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		if (this.editData.getBillStatus()!=null&&this.editData.getBillStatus().equals(bdaApplyBillStatus.Audit)) {
			MsgBox.showInfo("该单据已经完成审核操作！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);
	}


	// @Override
	public void actionCustomerInfoReqAudit_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		String currentCompanyId = SysContext.getSysContext().getCurrentFIUnit()
		.getId().toString();
		if (!currentCompanyId.equals("00000000-0000-0000-0000-000000000000CCE7AED4")) {
			MsgBox.showInfo("非集团组织下不允许审核");
			SysUtil.abort();
		}
		if (this.editData.getId().equals("")) {
			MsgBox.showInfo("该单据为空，不能审核");
			SysUtil.abort();
		}
		if (!this.editData.getBillStatus().equals(bdaApplyBillStatus.Submit)) {
			MsgBox.showInfo("只能审核提交状态的单据！");
			SysUtil.abort();
		}
		//this.actionSubmit_actionPerformed(null);
		super.actionCustomerInfoReqAudit_actionPerformed(e);
		refreshCurPage();
		MsgBox.showInfo("审核成功");
	}

	// @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		chkMenuItemSubmitAndAddNew.setVisible(false);
		chkMenuItemSubmitAndAddNew.setSelected(false);
		this.contBizDate.setVisible(false);
		this.contcolordisplay.setVisible(false);
		this.txtNumber.requestFocus();
		this.txtname.setRequired(true);
		txtDescription.setVisible(true);
		this.contLastUpdateTime.setVisible(true);
		this.contLastUpdateUser.setVisible(true);

		this.CustomerInfoReqAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.newMenuItem1.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.contBizDate.setVisible(true);


		FilterInfo filterinfo = new FilterInfo();
		filterinfo.getFilterItems().add(new FilterItemInfo("isLeaf", 1,CompareType.EQUALS));
		EntityViewInfo evi = new EntityViewInfo();
		evi.setFilter(filterinfo);
		//customergroup
		this.prmtCSSGroup.setQueryInfo("com.kingdee.eas.bdm.bdapply.app.F7CustomerGroupQuery");
		prmtCSSGroup.setVisible(true);
		prmtCSSGroup.setEditable(true);
		prmtCSSGroup.setDisplayFormat("$name$");
		prmtCSSGroup.setEditFormat("$name$");
		prmtCSSGroup.setCommitFormat("$name$");
		prmtCSSGroup.setEntityViewInfo(evi);

		setbartoolstate();

		this.prmtcity.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				cityClied(e);
			}});
		initControl();

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

	private void cityClied(DataChangeEvent e) {
		try {
			if(e.getNewValue()==null) {
				this.prmtprovince.setValue(null);
				this.prmtcountry.setValue(null);
			}else{
				CityInfo cInfo=(CityInfo) e.getNewValue();
				if(cInfo.getProvince()!=null) {
					ProvinceInfo pInfo = ProvinceFactory.getRemoteInstance().getProvinceInfo(new ObjectUuidPK(cInfo.getProvince().getId()));
					this.prmtprovince.setValue(pInfo);
					if(pInfo.getCountry()!=null) {
						CountryInfo coInfo = CountryFactory.getRemoteInstance().getCountryInfo(new ObjectUuidPK(pInfo.getCountry().getId()));
						this.prmtcountry.setValue(coInfo);

					}
				}
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
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

	public void checknull() {
		if (this.txtname.getText().equals("")) {
			MsgBox.showInfo("名称不能 为空,请检查 ");
			this.txtname.requestFocus();
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
			MsgBox.showInfo("助记码不能为空,请检查 ");
			this.txtmnemonicCode.requestFocus();
			SysUtil.abort();
		}
		if (this.txttaxRegisterNo.getText().equals("")) {
			MsgBox.showInfo("税务登记号不能 为空,请检查 ");
			this.txttaxRegisterNo.requestFocus();
			SysUtil.abort();
		}
		if(this.prmtCSSGroup.getValue()!=null) {
			CSSPGroupInfo ob = (CSSPGroupInfo) this.prmtCSSGroup.getValue();
			if(!ob.isIsLeaf()) {
				MsgBox.showInfo("客户分类请选择明细节点！ ");
				SysUtil.abort();
			}
		}

		if(this.kdtCustomerGroupEntry.getRowCount() > 0){
			CSSPGroupStandardInfo standard = (CSSPGroupStandardInfo) this.kdtCustomerGroupEntry.getRow(0).getCell("customerGroupstd").getValue();
			if(standard != null){
				String defaultID = "00000000-0000-0000-0000-000000000002BC122A7F";
				String id = standard.getId().toString();
				if(!id.equals(defaultID)){
					MsgBox.showInfo("请保证客户分类第一行为【 客商分类标准】！ ");
					SysUtil.abort();
				}else{
					CSSPGroupInfo groupInfo = (CSSPGroupInfo) this.kdtCustomerGroupEntry.getRow(0).getCell("customerGroup").getValue();
					if(groupInfo == null){
						MsgBox.showInfo("请在基本资料页签的客户分类分录中至少为客户选择一个【客商分类标准】的【客户分类】 ");
						SysUtil.abort();
					}else if(!groupInfo.isIsLeaf()){
						MsgBox.showInfo("客户分类请选择明细节点");
						SysUtil.abort();
					}
				}
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

	// 唯一验证
	public void UniqueCustomerReq() {
		if (this.oprtState.equals(OprtState.ADDNEW)) {

			String sql = "select * from CT_BDM_CustomerInfoReq where cfname='"+ txtname.getName() + "' ";
			if(this.txttaxRegisterNo.getText().trim().equals(""))
				sql+= "and (cftaxregisterno='"+this.txttaxRegisterNo.getText().trim()+"' or cftaxregisterno is null)";
			else 
				sql+= "and cftaxregisterno='"+this.txttaxRegisterNo.getText().trim()+"'";
			if (checkrepeat(sql, "")) {
				MsgBox.showInfo("申请单客户名称+税务登记号已存在，请检查");
				this.txtname.requestFocus();
				SysUtil.abort();
			}
			/*sql = "select * from CT_BDM_CustomerInfoReq where cftaxregisterno='"
					+ txttaxRegisterNo.getText() + "' ";
			if (checkrepeat(sql, "申请单税务登记号已存在，请检查")) {
				MsgBox.showInfo("申请单税务登记号已存在，请检查");
				this.txttaxRegisterNo.requestFocus();
				SysUtil.abort();
			}*/
		}
		if (this.oprtState.equals(OprtState.EDIT)) {
			String sql = "select * from CT_BDM_CustomerInfoReq where fid !='"
				+ editData.getId() + "' and cfname='"+ this.txtname.getText().trim() + "' ";
			if(this.txttaxRegisterNo.getText().trim().equals(""))
				sql+= "and (cftaxregisterno='"+this.txttaxRegisterNo.getText().trim()+"' or cftaxregisterno is null)";
			else 
				sql+= "and cftaxregisterno='"+this.txttaxRegisterNo.getText().trim()+"'";
			if (checkrepeat(sql, "")) {
				MsgBox.showInfo("申请单客户名称+税务登记号已存在，请检查");
				this.txtname.requestFocus();
				SysUtil.abort();
			}
			/*sql = "select * from CT_BDM_CustomerInfoReq where fid !='"
					+ editData.getId() + "' and cftaxregisterno='"
					+ this.txttaxRegisterNo.getText().trim() + "' ";
			if (checkrepeat(sql, "申请单税务登记号已存在，请检查")) {
				MsgBox.showInfo("申请单税务登记号已存在，请检查");
				this.txttaxRegisterNo.requestFocus();
				SysUtil.abort();
			}*/
		}
	}

	public void UniqueCustomer() {
		String sql = "select * from t_bd_customer where fname_l2='"+ this.txtname.getText().trim() + "' ";
		if(this.txttaxRegisterNo.getText().trim().equals(""))
			sql+= "and (ftxregisterno='"+this.txttaxRegisterNo.getText().trim()+"' or ftxregisterno is null)";
		else 
			sql+= "and ftxregisterno='"+this.txttaxRegisterNo.getText().trim()+"'";
		if (checkrepeat(sql, "")) {
			MsgBox.showInfo("客户资料名称+税务登记号已存在，请检查");
			this.txtname.requestFocus();
			SysUtil.abort();
		}
		/*sql = "select * from t_bd_customer where ftxregisterno='"
				+ this.txttaxRegisterNo.getText().trim() + "' ";
		if (checkrepeat(sql, "")) {
			MsgBox.showInfo("客户资料税务登记号已存在，请检查");
			this.txttaxRegisterNo.requestFocus();
			SysUtil.abort();
		}*/

	}

	public void setbartoolstate(){
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

	// @Override
	public void actionNotby_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		String currentCompanyId = SysContext.getSysContext().getCurrentFIUnit()
		.getId().toString();
		if (!currentCompanyId.equals("00000000-0000-0000-0000-000000000000CCE7AED4")) {
			MsgBox.showInfo("非集团组织下不允许操作");
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
//		super.actionNotby_actionPerformed(e);
//		this.actionSubmit_actionPerformed(null);
		String billId=this.editData.getId().toString();
		String uiname="com.kingdee.eas.bdm.bdapply.client.UpdateErrorMsgUI";
		UIContext uicontext = new UIContext();
		uicontext.put("cuid",cuid);
		uicontext.put("billType","客户");
		uicontext.put("billId",billId);
		IUIWindow iuiwindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create(
				uiname, uicontext, null, OprtState.VIEW);
		iuiwindow.show();
		refreshCurPage();
	}
	// 去掉属性的空格
	public void setedit(){
		this.txtaddress.setText(this.txtaddress.getText().trim());
		this.txtartificialPerson.setText(this.txtartificialPerson.getText().trim());
		this.txtbarcode.setText(this.txtbarcode.getText().trim());
		this.txtbizRegisterNo.setText(this.txtbizRegisterNo.getText().trim());
		this.txtbusiExequatur.setText(this.txtbusiExequatur.getText().trim());
		this.txtDescription.setText(this.txtDescription.getText().trim());
		this.txtforeignname.setText(this.txtforeignname.getText().trim());
		this.txtGSPAuthentication.setText(this.txtGSPAuthentication.getText().trim());
		this.txtmnemonicCode.setText(this.txtmnemonicCode.getText().trim());
		this.txtname.setText(this.txtname.getText().trim());
		this.txtNumber.setText(this.txtNumber.getText().trim());
		this.txtsimpleName.setText(this.txtsimpleName.getText().trim());
		this.txttaxRate.setText(this.txttaxRate.getText().trim());
		this.txttaxRegisterNo.setText(this.txttaxRegisterNo.getText().trim());
		this.txtbusiLicence.setText(this.txtbusiLicence.getText().trim());
	}

	private void initControl() {
		this.kdtCustomerGroupEntry.addKDTEditListener(new KDTEditAdapter(){ 
			public void editStarting(KDTEditEvent e)
			{
				try {
					//					tblCustomerInfo_EditStarting(e);
				} catch (Exception exc) {
					handUIException(exc);
				}
			}

			public void editStopped(KDTEditEvent e)
			{
				try
				{
					tblCustomerInfo_Changed(e.getRowIndex(), e.getColIndex(), e);
				}
				catch (Exception exc) {
					handUIException(exc);
				}
			}});

		this.kdtCustomerGroupEntry.addKDTActiveCellListener(new KDTActiveCellListener(){
			public void activeCellChanged(KDTActiveCellEvent e) {
				// TODO Auto-generated method stub
				_activeCellChanged(e.getRowIndex());
			}});

		this.kdtCustomerGroupEntry.checkParsed();
		KDBizPromptBox materialGroupStd=new KDBizPromptBox();
		materialGroupStd.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerGroupStandardQuery");
		materialGroupStd.setVisible(true);
		materialGroupStd.setEditable(true);
		materialGroupStd.setDisplayFormat("$displayname$");
		materialGroupStd.setEditFormat("$number$");
		materialGroupStd.setCommitFormat("$name$;$number$");
		KDTDefaultCellEditor editor=new KDTDefaultCellEditor(materialGroupStd);
		this.kdtCustomerGroupEntry.getColumn("customerGroupstd").setEditor(editor);
		this.kdtCustomerGroupEntry.getColumn("customerGroupstd").setWidth(200);

		KDBizPromptBox materialGroup=new KDBizPromptBox();
		materialGroup.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.CustomerGroupQuery");
		materialGroup.setVisible(true);
		materialGroup.setEditable(true);
		materialGroup.setDisplayFormat("$displayname$");
		materialGroup.setEditFormat("$displayname$");
		materialGroup.setCommitFormat("$displayname$");
		KDTDefaultCellEditor editor2=new KDTDefaultCellEditor(materialGroup);
		this.kdtCustomerGroupEntry.getColumn("customerGroup").setEditor(editor2);
		this.kdtCustomerGroupEntry.getColumn("customerGroup").setWidth(200);
		this.kdtCustomerGroupEntry.getColumn("groupFullName").setWidth(250);
	}

	protected void tblCustomerInfo_Changed(int rowIndex, int colIndex, KDTEditEvent e)
	{
		ICell cell = this.kdtCustomerGroupEntry.getRow(rowIndex).getCell(colIndex);
		Object value = cell.getValue();
		String fieldName = this.kdtCustomerGroupEntry.getColumnKey(colIndex);

		if ("groupName".equalsIgnoreCase(fieldName)) {
			if (value == null) {
				IRow rowCustomer = this.kdtCustomerGroupEntry.getRow(rowIndex);
				rowCustomer.getCell(2).setValue(null);
			}
			if ((value == null) || (!(value instanceof CSSPGroupInfo))) return;
			try {
				customerGroupDataChange((CSSPGroupInfo)value, rowIndex);
			} catch (EASBizException e1) {
				handUIException(e1);
			} catch (BOSException e1) {
				handUIException(e1);
			}
		}

		if("customerGroup".equalsIgnoreCase(kdtCustomerGroupEntry.getColumnKey(colIndex))){
			if(kdtCustomerGroupEntry.getCell(rowIndex, "customerGroupstd").getValue() != null && e.getValue() != null){
				String id = ((IPropertyContainer)kdtCustomerGroupEntry.getCell(rowIndex, "customerGroupstd").getValue()).getString("id");
				if(id.equals("00000000-0000-0000-0000-000000000002BC122A7F")){
					try {
						id = ((IPropertyContainer)kdtCustomerGroupEntry.getCell(rowIndex, "customerGroup").getValue()).getString("id");
						IRowSet rs = SQLExecutorFactory.getRemoteInstance("select CFCityID from T_BD_CSSPGroup where fid='"+id+"' and CFCityID is not null").executeSQL();
						if(rs.next()){
							prmtcity.setValue(CityFactory.getRemoteInstance().getCityInfo(new ObjectUuidPK(rs.getString("CFCityID"))));
						}
					} catch (BOSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (EASBizException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
	}

	private String customerGroupDataChange(CSSPGroupInfo info, int rowIndex)
	throws BOSException, EASBizException
	{
		String groupNameFullName = new String();
		IRow rowCustomer = this.kdtCustomerGroupEntry.getRow(rowIndex);
		ICSSPGroup iCSSPGroup = CSSPGroupFactory.getRemoteInstance();

		if (info == null) {
			return null;
		}
		groupNameFullName = info.getName();
		while ((info.getParent() != null) && 
				(info != null) && (info.getParent() != null)) {
			CSSPGroupInfo parentGroup = iCSSPGroup.getCSSPGroupInfo(new ObjectUuidPK(info.getParent().getId()));


			groupNameFullName = parentGroup.getName() + "." + groupNameFullName;

			info = parentGroup;
		}

		if ((groupNameFullName != null) && (groupNameFullName.length() > 80))
		{
			groupNameFullName = groupNameFullName.substring(0, 80);
			MsgBox.showInfo(EASResource.getString("com.kingdee.eas.basedata.master.cssp.CSSPResource", "LENGTHMORETHAN80"));
		}

		rowCustomer.getCell(2).setValue(groupNameFullName);

		return groupNameFullName;
	}
	private String getGroupFullName(CSSPGroupInfo info) throws BOSException, EASBizException
	{
		String groupNameFullName = null;
		ICSSPGroup iCSSPGroup = CSSPGroupFactory.getRemoteInstance();

		if (info == null) {
			return null;
		}
		groupNameFullName = info.getDisplayName().replaceAll("_", ".");
		return groupNameFullName;
	}

	public void _activeCellChanged(int rowIndex)
	/*      */   {
		/* 2818 */     int argRowIndex = rowIndex;
		/* 2819 */     KDBizPromptBox promptBox = new KDBizPromptBox();
		/* 2820 */     EntityViewInfo view = new EntityViewInfo();
		/* 2821 */     FilterInfo filterInfo = new FilterInfo();
		/* 2822 */     promptBox.setQueryInfo("com.kingdee.eas.bdm.bdapply.app.F7CustomerGroupQuery");
		/*      */
		if(rowIndex<0) {
			return;
		}
		/* 2825 */     IRow rowCustomer = this.kdtCustomerGroupEntry.getRow(rowIndex);
		if (rowCustomer.getCell(0).getValue()==null) {
			return;
		}
		/*      */ 
		/* 2827 */     if (!(rowCustomer.getCell(0).getValue() instanceof CSSPGroupStandardInfo)) {
			/* 2828 */       return;
		/*      */     }
		/* 2830 */     CSSPGroupStandardInfo std = (CSSPGroupStandardInfo)rowCustomer.getCell(0).getValue();
		/*      */ 
		/* 2832 */     filterInfo.getFilterItems().add(new FilterItemInfo("groupStandard.id", std.getId().toString(), CompareType.EQUALS));
		/*      */
		/*      */filterInfo.getFilterItems().add(new FilterItemInfo("isLeaf",1,CompareType.EQUALS));
		/*      */
		/*      */     try
		/*      */     {
			/* 2838 */       FilterInfo filterInfoCU = FilterUtil.getS4Filter(SysContext.getSysContext().getCurrentCtrlUnit());
			/* 2839 */       filterInfo.mergeFilter(filterInfoCU, "and");
		/*      */     } catch (BOSException e) {
			/* 2841 */       e.printStackTrace();
		/*      */     }
		/*      */ 
		/* 2844 */     view.setFilter(filterInfo);
		/*      */ 
		/* 2846 */     promptBox.setEntityViewInfo(view);
		/* 2847 */     promptBox.setEditable(true);
		/* 2848 */     promptBox.setDisplayFormat("$name$");
		/* 2849 */     promptBox.setEditFormat("$name$");
		/* 2850 */     promptBox.setCommitFormat("$name$");
		/*      */ 
		/* 2852 */     promptBox.getQueryAgent().setHasCUDefaultFilter(false);
		/*      */ 
		/* 2854 */     promptBox.setFilterInfoProducer(new IFilterInfoProducer()
		/*      */     {
			/*      */       public FilterInfo getFilterInfo()
			/*      */       {
				/* 2858 */         return null;
				/*      */
				/*      */
				/*      */
				/*      */
				/*      */
				/*      */
				/*      */
				/*      */
				/*      */
				/*      */
			/*      */       }
			/*      */ 
			/*      */       public void setCurrentCtrlUnit(CtrlUnitInfo cui)
			/*      */       {
			/*      */       }
			/*      */ 
			/*      */       public void setCurrentMainBizOrgUnit(OrgUnitInfo oui, OrgType ot)
			/*      */       {
			/*      */       }
		/*      */     });
		/* 2879 */     this.kdtCustomerGroupEntry.getColumn(1).setEditor(new KDTDefaultCellEditor(promptBox));
	/*      */   }
	/**
	 * 选中销售员后自动 带出销售组
	 */
	@Override
	protected void prmtSalePerson_dataChanged(DataChangeEvent e)
	throws Exception {
		try {

			IPerson iPerson = PersonFactory.getRemoteInstance();

			if (this.prmtSalePerson.getData() instanceof PersonInfo)
			{
				String salePersonID = null;

				PersonInfo aPersonInfo = (PersonInfo)this.prmtSalePerson.getData();

				if ((aPersonInfo != null) && (aPersonInfo.getId() != null)) {
					salePersonID = aPersonInfo.getId().toString();
				}
				SaleOrgUnitInfo info = SysContext.getSysContext().getCurrentSaleUnit();

				SaleGroupInfo aSaleGroupInfo = null;





				StringBuffer sql = new StringBuffer();
				sql.append("select id,person.id,saleGroup.*, saleGroup.saleOrg.id where saleGroup.saleOrg.id='");
				sql.append(info.getId().toString()).append("'").append(" and person.id='").append(salePersonID).append("'");




				sql.append(" and deletedStatus = ").append(1);

				ISalePerson is = SalePersonFactory.getRemoteInstance();
				SalePersonCollection salePersonCollection = is.getSalePersonCollection(sql.toString());


				if (salePersonCollection.size() > 0)
				{
					aSaleGroupInfo = salePersonCollection.get(0).getSaleGroup();
				}
				else aSaleGroupInfo = null;

				this.prmtsaleGroup.setValue(aSaleGroupInfo);

			}
			if (this.prmtSalePerson.getData() instanceof SalePersonInfo) {
				SalePersonInfo salePersonInfo = (SalePersonInfo)this.prmtSalePerson.getData();
				SaleGroupInfo aSaleGroupInfo = null;
				if ((salePersonInfo.getSaleGroup() != null) && (this.prmtsaleOrgUnit.getData() != null)) {
					String saleGroupID = salePersonInfo.getSaleGroup().getId().toString();
					String saleOrgUnitID = SysContext.getSysContext().getCurrentSaleUnit().getId().toString();
					ISaleGroup iSaleGroup = SaleGroupFactory.getRemoteInstance();



					EntityViewInfo viewInfo = new EntityViewInfo();
					FilterInfo filterInfo = new FilterInfo();
					filterInfo.getFilterItems().add(new FilterItemInfo("id", saleGroupID, CompareType.EQUALS));
					filterInfo.getFilterItems().add(new FilterItemInfo("saleOrg.id", saleOrgUnitID, CompareType.EQUALS));
					viewInfo.setFilter(filterInfo);
					SaleGroupCollection saleGroupCollection = iSaleGroup.getSaleGroupCollection(viewInfo);
					if ((saleGroupCollection != null) && (saleGroupCollection.size() > 0)) {
						aSaleGroupInfo = saleGroupCollection.get(0);
					}
				}


				this.prmtsaleGroup.setData(aSaleGroupInfo);


			}


		} catch (Exception e1) {
			handUIException(e1);
		}

	}
}