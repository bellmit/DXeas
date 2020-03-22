package com.kingdee.eas.bdm.bdapply.app;

import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.attachment.AttachmentCollection;
import com.kingdee.eas.base.attachment.BoAttchAssoCollection;
import com.kingdee.eas.base.attachment.BoAttchAssoFactory;
import com.kingdee.eas.base.attachment.BoAttchAssoInfo;
import com.kingdee.eas.base.attachment.IBoAttchAsso;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.basedata.assistant.CityFactory;
import com.kingdee.eas.basedata.assistant.CityInfo;
import com.kingdee.eas.basedata.assistant.CountryFactory;
import com.kingdee.eas.basedata.assistant.CountryInfo;
import com.kingdee.eas.basedata.assistant.IndustryFactory;
import com.kingdee.eas.basedata.assistant.IndustryInfo;
import com.kingdee.eas.basedata.assistant.ProvinceFactory;
import com.kingdee.eas.basedata.assistant.ProvinceInfo;
import com.kingdee.eas.basedata.master.cssp.CSSPGroupFactory;
import com.kingdee.eas.basedata.master.cssp.CSSPGroupInfo;
import com.kingdee.eas.basedata.master.cssp.CSSPGroupStandardFactory;
import com.kingdee.eas.basedata.master.cssp.CSSPGroupStandardInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerFactory;
import com.kingdee.eas.basedata.master.cssp.CustomerGroupDetailInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.cssp.UsedStatusEnum;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitFactory;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.ICompanyOrgUnit;
import com.kingdee.eas.basedata.org.ICtrlUnit;
import com.kingdee.eas.basedata.org.IOrgSwitchFacade;
import com.kingdee.eas.basedata.org.ISaleOrgUnit;
import com.kingdee.eas.basedata.org.OrgSwitchFacadeFactory;
import com.kingdee.eas.basedata.org.SaleOrgUnitFactory;
import com.kingdee.eas.basedata.org.SaleOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.basedata.scm.sd.sale.SaleGroupInfo;
import com.kingdee.eas.bdm.bdapply.CustomerInfoReqCustomerGroupEntryInfo;
import com.kingdee.eas.bdm.bdapply.CustomerInfoReqFactory;
import com.kingdee.eas.bdm.bdapply.CustomerInfoReqInfo;
import com.kingdee.eas.bdm.bdapply.util.BaseDataHandleUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.HanYuPinYinUtil;
import com.kingdee.eas.framework.BillBaseException;
import com.kingdee.eas.framework.EffectedStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class CustomerInfoReqControllerBean extends AbstractCustomerInfoReqControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.bdm.bdapply.app.CustomerInfoReqControllerBean");
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		CustomerInfoReqInfo info = (CustomerInfoReqInfo) model;
		info.setBillStatus(com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus.Save);
		checkTxRegisterNoIsRepeat(ctx,info);
		//checkCustomerTypeGroup(ctx,info);
		return super._save(ctx, model);
	}

	@Override
	protected void _allAudit(Context ctx, IObjectValue model)
	throws BOSException {
		CustomerInfoReqInfo cirinfo = (CustomerInfoReqInfo) model;
		ctx.put("disablePermissionForKScript", Boolean.TRUE);
		String customerID = this.addNewCustomerInfo(ctx,cirinfo);
		ctx.put("disablePermissionForKScript", Boolean.FALSE);
		cirinfo.setBillStatus(com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus.Audit);
		cirinfo.setAuditor(ContextUtil.getCurrentUserInfo(ctx));

		try {
			super._update(ctx, new ObjectUuidPK(cirinfo.getId()), cirinfo);
		} catch (EASBizException e) {
			throw new BOSException(e);
		}
		attachAttachmentToCustomer(ctx,cirinfo,customerID);
	}

	/**
	 * 校验税务登记号是否重复
	 * @param ctx
	 * @param info
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void checkTxRegisterNoIsRepeat(Context ctx, CustomerInfoReqInfo info) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		if(StringUtils.isNotEmpty(info.getTaxRegisterNo())){
			String taxRegisterNo = info.getTaxRegisterNo();
			String str = "select * from T_BD_Customer where FTxRegisterNo='"+taxRegisterNo+"'";
			if(DbUtil.executeQuery(ctx, str).size() > 0){
				throw new EASBizException(EASBizException.CHECKDUPLICATED,new Object[]{"税务登记号_客户"});
			}
			str = "select * from CT_BDM_CustomerInfoReq where CFTaxRegisterNo='"+taxRegisterNo+"'";
			if(info.getId() != null){
				str += " and FID<>'"+info.getString("id")+"'";
			}
			if(DbUtil.executeQuery(ctx, str).size() > 0){
				throw new EASBizException(EASBizException.CHECKDUPLICATED,new Object[]{"税务登记号_客户申请"});
			}
		}
	}

	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		CustomerInfoReqInfo info = (CustomerInfoReqInfo) model;
		checkTxRegisterNoIsRepeat(ctx,info);
		info.setErrorMsg(null);
		info.setBillStatus(com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus.Submit);
		//checkCustomerTypeGroup(ctx,info);
		return super._submit(ctx, model);
	}

	/**
	 * 和美公司校验客户分类不能为空
	 * @param ctx
	 * @param info
	 * @throws EASBizException 
	 */
	private void checkCustomerTypeGroup(Context ctx, CustomerInfoReqInfo info) throws EASBizException {
		// TODO Auto-generated method stub
		CustomerInfoReqCustomerGroupEntryInfo materialInfoReqMaterialStdEntryInfo;
		boolean flag = false;
		for(int i=0;i<info.getCustomerGroupEntry().size();i++){
			materialInfoReqMaterialStdEntryInfo = info.getCustomerGroupEntry().get(i);
			if(materialInfoReqMaterialStdEntryInfo.getCustomerGroupstd() != null){
				if(materialInfoReqMaterialStdEntryInfo.getCustomerGroupstd().getNumber().equalsIgnoreCase("003")){
					if(materialInfoReqMaterialStdEntryInfo.getCustomerGroup()!=null){
						flag = true;
						break;
					}
				}
			}
		}
		if(!flag){
			throw new EASBizException(new NumericExceptionSubItem("001","客商分录里，客户类型分类不能为空"));
		}
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		CustomerInfoReqInfo info=CustomerInfoReqFactory.getLocalInstance(ctx).getCustomerInfoReqInfo(pk);
		if(info.getBillStatus().equals(com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus.Audit)) {
			throw new BillBaseException(new NumericExceptionSubItem("001","单据已经完成审核操作，禁止删除！"));
		}
		super._delete(ctx, pk);
	}
	//审核 生成客户
	protected void _customerInfoReqAudit(Context ctx, IObjectValue model)throws BOSException {
		CustomerInfoReqInfo cirinfo = (CustomerInfoReqInfo) model;
		ctx.put("disablePermissionForKScript", Boolean.TRUE);
		String customerID = this.addNewCustomerInfo(ctx,cirinfo);
		ctx.put("disablePermissionForKScript", Boolean.FALSE);
		cirinfo.setBillStatus(com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus.Audit);
		cirinfo.setAuditor(ContextUtil.getCurrentUserInfo(ctx));

		try {
			super._update(ctx, new ObjectUuidPK(cirinfo.getId()), cirinfo);
		} catch (EASBizException e) {
			throw new BOSException(e);
		}
		attachAttachmentToCustomer(ctx,cirinfo,customerID);
	}

	/**
	 * 将申请单的附件 增加到客户基本资料里
	 * @param ctx
	 * @param cirinfo
	 * @param customerID 
	 */
	private void attachAttachmentToCustomer(Context ctx,
			CustomerInfoReqInfo cirinfo, String customerID)  {
		// TODO Auto-generated method stub
		AttachmentCollection attachments = null; //附件集合
		IBoAttchAsso iBoAttchAsso = null;
		try {
			iBoAttchAsso=BoAttchAssoFactory.getLocalInstance(ctx);
			EntityViewInfo view = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("boID", cirinfo.getId().toString()));
			view.setFilter(filter);
			BoAttchAssoCollection coll = iBoAttchAsso.getBoAttchAssoCollection(view); //查询所关联附件
			if(coll==null&&coll.size()==0){
				return;
			}
			BoAttchAssoInfo boAttachInfo = null;
			for(int i=0;i<coll.size();i++){
				boAttachInfo = new BoAttchAssoInfo();
				boAttachInfo.setId(BOSUuid.create(boAttachInfo.getBOSType()));
				boAttachInfo.setAssoType("新加附件");
				boAttachInfo.setAttachment(coll.get(i).getAttachment());
				boAttachInfo.setAssoBusObjType("BF0C040E");
				boAttachInfo.setBoID(customerID);
				iBoAttchAsso.save(boAttachInfo);
			}

		} catch (BOSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} //附件与业务对象关联接口
		catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String  addNewCustomerInfo(Context ctx,CustomerInfoReqInfo cirinfo) throws BOSException{
		String customerId="";
		Object feature = ctx.get("IS_OBJECT_CONTEXT");
		ctx.put("IS_OBJECT_CONTEXT", null);
		try{
			//CustomerInfoReqEntryInfo entryinfo = cirinfo.getEntrys().get(0);
			CustomerInfo cinfo = new CustomerInfo();
			cinfo.setName(cirinfo.getName());

			ObjectUuidPK objectUuidpk = null;

			//cinfo.setNumber(cirinfo.getNumber());
			cinfo.setAddress(cirinfo.getAddress());
			cinfo.setBarCode(cirinfo.getBarcode());
			cinfo.setBizRegisterNo(cirinfo.getBizRegisterNo());
			cinfo.setBusiExequatur(cirinfo.getBusiExequatur());
			cinfo.setBusiLicence(cirinfo.getBusiLicence());
			cinfo.setDescription(cirinfo.getDescription());
			cinfo.put("remark",cirinfo.getDescription());
			cinfo.setForeignName(cirinfo.getForeignname());
			cinfo.put("customerType",cirinfo.getCustomerType().getValue());
			cinfo.setGSPAuthentication(cirinfo.getGSPAuthentication());
			cinfo.setTaxRate(cirinfo.getTaxRate());
			cinfo.setTaxRegisterNo(cirinfo.getTaxRegisterNo());
			cinfo.setArtificialPerson(cirinfo.getArtificialPerson());
			if(cirinfo.getIndustry() != null){
				objectUuidpk  = new ObjectUuidPK(cirinfo.getIndustry().getId().toString());
				IndustryInfo  iinfo = IndustryFactory.getLocalInstance(ctx).getIndustryInfo(objectUuidpk);
				cinfo.setIndustry(iinfo);
			}
			if(cirinfo.getCountry() != null){
				objectUuidpk  = new ObjectUuidPK(cirinfo.getCountry().getId().toString());
				CountryInfo   ctinfo = CountryFactory.getLocalInstance(ctx).getCountryInfo(objectUuidpk);
				cinfo.setCountry(ctinfo);
			}
			if(cirinfo.getCity() != null){
				objectUuidpk  = new ObjectUuidPK(cirinfo.getCity().getId().toString());
				CityInfo   cityinfo = CityFactory.getLocalInstance(ctx).getCityInfo(objectUuidpk);
				cinfo.setCity(cityinfo);
			}
			
			if(cirinfo.getProvince() != null){
				objectUuidpk  = new ObjectUuidPK(cirinfo.getProvince().getId().toString());
				ProvinceInfo   provinceinfo = ProvinceFactory.getLocalInstance(ctx).getProvinceInfo(objectUuidpk);
				cinfo.setProvince(provinceinfo);
			}

			cinfo.setRegion(cirinfo.getRegion());
			cinfo.setAddress(cirinfo.getAddress());
			cinfo.setTaxData(cirinfo.getTaxData());
			cinfo.setTaxRate(cirinfo.getTaxRate());
			cinfo.setTaxRegisterNo(cirinfo.getTaxRegisterNo());
			cinfo.setVersion(1);
			cinfo.setIsInternalCompany(false);
			cinfo.setBizRegisterNo(cirinfo.getBizRegisterNo());
			cinfo.setEffectedStatus(EffectedStatusEnum.getEnum(1));
			cinfo.setSuperiorUnit("");
			cinfo.setMnemonicCode(cirinfo.getMnemonicCode());
			cinfo.setBusiExequatur(cirinfo.getBusiExequatur());
			cinfo.setBusiLicence(cirinfo.getBusiLicence());
			cinfo.setGSPAuthentication(cirinfo.getGSPAuthentication());
			cinfo.setCustomerKind(cirinfo.getCustomerKind());
			cinfo.setInvoiceType(cirinfo.getInvoicetype());
			cinfo.setIsCredited(cirinfo.isIsCredited());
			cinfo.setIsMultiCopy(true);
			cinfo.setSimpleName(cirinfo.getSimpleName());
			cinfo.put("yuexiaoliang",cirinfo.getMonthSaleQty());
			cinfo.put("pinpai",cirinfo.getPinPai());
			cinfo.put("pinxiang",cirinfo.getPinXiang());

			String pinYinSpelling = HanYuPinYinUtil.getInstance().getPinYinSpelling(cirinfo.getName());
			if(pinYinSpelling.length()> 44){
				cinfo.setNamePinYin(pinYinSpelling.substring(43));
			}else{
				cinfo.setNamePinYin(pinYinSpelling);
			}
			String pinYinSpellingHead = HanYuPinYinUtil.getInstance().getPinYinSpellingHead(cirinfo.getName());
			if(pinYinSpellingHead.length()>44){
				cinfo.setNameShortPinYin(pinYinSpellingHead.substring(43));
			}else{
				cinfo.setNameShortPinYin(pinYinSpellingHead);
			}			

			if(cirinfo.getParent() != null){
				objectUuidpk  = new ObjectUuidPK(cirinfo.getParent().getId());
				CustomerInfo customerInfo  = CustomerFactory.getLocalInstance(ctx).getCustomerInfo(objectUuidpk);
				cinfo.setParent(customerInfo);
			}
			//			if(cirinfo.getCU() != null){
			objectUuidpk  = new ObjectUuidPK("00000000-0000-0000-0000-000000000000CCE7AED4");
			CtrlUnitInfo cuinfo = CtrlUnitFactory.getLocalInstance(ctx).getCtrlUnitInfo(objectUuidpk);
			cinfo.setAdminCU(cuinfo);
			cinfo.setCU(cuinfo);;;
			//			}

			String FCUID =ctx.get("CurCompanyId").toString();//取得当前公司

//			if(cirinfo.getCustomerGroupEntry().size()==0)
//				throw new EASBizException(new NumericExceptionSubItem("001","分录_客户基本分类不能为空"));

			//add@20160929 by dai
			if(cirinfo.getCustomerGroupEntry().size()>0) {
				objectUuidpk  = new ObjectUuidPK(cirinfo.getCustomerGroupEntry().get(0).getCustomerGroup().getId());
			}

			//objectUuidpk  = new ObjectUuidPK(cirinfo.getCSSGroup().getId());//
			CSSPGroupInfo    cSSPGroupInfo = CSSPGroupFactory.getLocalInstance(ctx).getCSSPGroupInfo(objectUuidpk);
			//				 cinfo.setBrowseGroup(cSSPGroupInfo);
			cinfo.setBrowseGroup(cSSPGroupInfo);



			if (isCodeRuleEnable(ctx,cinfo,FCUID)) {
				// cinfo.setNumber(getAutoCode(ctx,cinfo,FCUID));
				cinfo.setNumber(CustomerFactory.getLocalInstance(ctx).readNewNumber(FCUID, cinfo));
			}else{
				cinfo.setNumber(cirinfo.getNumber());
			}

			cinfo.setUsedStatus(cirinfo.getStatus());// 下拉框
			//cinfo.setCreateTime(cirinfo.getCreateTime());
			//cinfo.setCreator(cirinfo.getCreator());

			objectUuidpk = new ObjectUuidPK("00000000-0000-0000-0000-000000000002BC122A7F");//客商分类标准
			CSSPGroupStandardInfo CSSPGSIInfo = null;
			CSSPGSIInfo = CSSPGroupStandardFactory.getLocalInstance(ctx).getCSSPGroupStandardInfo(objectUuidpk);

			//modify@20160929
			/*CustomerGroupDetailInfo centryinfo = new CustomerGroupDetailInfo();//如何得到
			centryinfo.setCustomerGroupStandard(CSSPGSIInfo);// 客户分类标准

			//if(entryinfo.getCustomerGroup() != null){
				 centryinfo.setCustomerGroup(cSSPGroupInfo);
			//}
			centryinfo.setCustomerGroupFullName(cSSPGroupInfo.getName());
			cinfo.getCustomerGroupDetails().add(centryinfo);// 添加到分录

			 */		
			//add@20160929 by dai 
			for(int index=0;index<cirinfo.getCustomerGroupEntry().size();index++) {
				if(cirinfo.getCustomerGroupEntry().get(index).getCustomerGroup()==null) {
					continue;
				}
				CustomerGroupDetailInfo centryinfo = new CustomerGroupDetailInfo();//如何得到
				centryinfo.setCustomerGroupStandard(cirinfo.getCustomerGroupEntry().get(index).getCustomerGroupstd());
				centryinfo.setCustomerGroup(cirinfo.getCustomerGroupEntry().get(index).getCustomerGroup());
				centryinfo.setCustomerGroupFullName(cirinfo.getCustomerGroupEntry().get(index).getGroupFullName());
				cinfo.getCustomerGroupDetails().add(centryinfo);// 添加到分录
			}


			IObjectPK pk = CustomerFactory.getLocalInstance(ctx).submit(cinfo);

			customerId = pk.toString();

			Object[] Obj = new Object[4];
			for(int i = 0;i < cirinfo.getSettleCustomerEntry().size(); i++){
				Obj[0] = BOSUuid.create("E84E0555").toString();
				Obj[1] = i+1;
				Obj[2] = customerId;
				Obj[3] = cirinfo.getSettleCustomerEntry().get(i).getSettleCustomer().getString("id");
				DbUtil.execute(ctx, "insert into CT_MS_SaleCustomer (FID,FSeq,FParentID,CFSettleCustomerID) values(?,?,?,?)",Obj);
			}



			if(cinfo.getId()!=null){
				customerId=cinfo.getId().toString();
				objectUuidpk =new ObjectUuidPK(cinfo.getId());
				CustomerFactory.getLocalInstance(ctx).approve(objectUuidpk);
				cirinfo.setStatus(UsedStatusEnum.APPROVED);

				//获取上级组织下所有的控制单元
				ICtrlUnit iCtrl = CtrlUnitFactory.getLocalInstance(ctx);
				ISaleOrgUnit iSale = SaleOrgUnitFactory.getLocalInstance(ctx);
				ICompanyOrgUnit iCompany = CompanyOrgUnitFactory.getLocalInstance(ctx);

				CtrlUnitInfo CU = cirinfo.getCU();
				CompanyOrgUnitInfo FIInfo;
				SaleOrgUnitInfo saleInfo;

				//保留原始公司
				String comOrgID = cirinfo.getCompany().getString("id");
				SelectorItemCollection slor=new SelectorItemCollection();
				slor.add("*");
				FIInfo = iCompany.getCompanyOrgUnitInfo(new ObjectUuidPK(comOrgID),slor);

				//获取同级公司
				String str = null;
				if(FIInfo.getName().indexOf("事业部") >= 0|| FIInfo.getName().indexOf("集团") >= 0){
					str = FIInfo.getLongNumber();
				}else{
					str = FIInfo.getLongNumber().substring(0, FIInfo.getLongNumber().lastIndexOf("!"));
				}
				IRowSet rs = DbUtil.executeQuery(ctx,"select FID from T_ORG_Company where flongNumber like '"+str+"%'");

				//保留初始数据
				saleInfo=cirinfo.getSaleOrgUnit();
				SaleGroupInfo saleGroup = cirinfo.getSaleGroup();
				PersonInfo salePerson = cirinfo.getSalePerson();
				CtrlUnitInfo currentCU=null;
				CompanyOrgUnitInfo currentFIInfo=null;
				SaleOrgUnitInfo currentSaleInfo=null;
				while(rs.next()){

					currentFIInfo=null;
					currentSaleInfo=null;



					currentCU=iCtrl.getCtrlUnitInfo(new ObjectUuidPK(rs.getString("FID")));
					currentFIInfo=iCompany.getCompanyOrgUnitInfo(new ObjectUuidPK(rs.getString("FID")));
					if(currentFIInfo.isIsSaleOrgUnit())
						currentSaleInfo = iSale.getSaleOrgUnitInfo(new ObjectUuidPK(rs.getString("FID")));

					if(currentCU!=null)
						cirinfo.setCU(currentCU);
					if(currentFIInfo!=null)
						cirinfo.setCompany(currentFIInfo);

					if(currentSaleInfo!=null&&!currentSaleInfo.getString("id").equals(saleInfo.getString("id"))){
						cirinfo.setSaleGroup(null);
						cirinfo.setSalePerson(null);
						cirinfo.setSaleOrgUnit(currentSaleInfo);
					}else{
						cirinfo.setSaleGroup(saleGroup);
						cirinfo.setSalePerson(salePerson);
						cirinfo.setSaleOrgUnit(currentSaleInfo);
					}
					// 保存引用关系
					BaseDataHandleUtil.insertQuote(ctx, cinfo, cirinfo.getCU().getId().toString());
					// 保存财务资料
					BaseDataHandleUtil.addCustomerCompanyInfo(ctx,cirinfo,cinfo);
					// 保存销售资料
					if(currentSaleInfo!=null)
						BaseDataHandleUtil.addCustomerSaleInfo(ctx, cirinfo, cinfo);
				}
				cirinfo.setCU(CU);
				cirinfo.setCompany(FIInfo);
				cirinfo.setSaleOrgUnit(saleInfo);
				cirinfo.setSaleGroup(saleGroup);
				cirinfo.setSalePerson(salePerson);
			}
			System.out.println(cinfo.getId());
		} catch (EASBizException e) {
			throw new BOSException("sql Execute Error :", e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{ 
			ctx.put("IS_OBJECT_CONTEXT", feature);
		}
		return customerId;
	}
	// 得到自动编码
	protected String getAutoCode(Context ctx, IObjectValue objValue,
			String companyId) throws EASBizException, BOSException {
		IOrgSwitchFacade orgSwitch = OrgSwitchFacadeFactory.getLocalInstance(ctx);
		orgSwitch.orgSwitch(companyId);
		ICodingRuleManager codeRuleMgr = CodingRuleManagerFactory.getLocalInstance(ctx);
		if (codeRuleMgr.isUseIntermitNumber(objValue, companyId)) {
			return codeRuleMgr.readNumber(objValue, companyId);
		} else {
			return codeRuleMgr.getNumber(objValue, companyId);
		}
	}

	// 是否启用编码规则
	protected boolean isCodeRuleEnable(Context ctx, IObjectValue objValue,
			String companyId) throws EASBizException, BOSException {
		ICodingRuleManager codeRuleMgr = CodingRuleManagerFactory.getLocalInstance(ctx);
		return codeRuleMgr.isExist(objValue, companyId);
	}
	//审核不通过
	protected void _notby(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub
		CustomerInfoReqInfo cirinfo = (CustomerInfoReqInfo) model;

		cirinfo.setBillStatus(com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus.unAudit);
		cirinfo.setAuditor(ContextUtil.getCurrentUserInfo(ctx));

		try {
			super._update(ctx, new ObjectUuidPK(cirinfo.getId()), cirinfo);
		} catch (EASBizException e) {
			throw new BOSException(e);
		}

	}
}