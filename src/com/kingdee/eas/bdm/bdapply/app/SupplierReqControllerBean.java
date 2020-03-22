package com.kingdee.eas.bdm.bdapply.app;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.IMetaDataLoader;
import com.kingdee.bos.metadata.MetaDataLoaderFactory;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.metadata.entity.LinkPropertyInfo;
import com.kingdee.bos.metadata.entity.PropertyInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.basedata.assistant.CityFactory;
import com.kingdee.eas.basedata.assistant.CityInfo;
import com.kingdee.eas.basedata.assistant.CountryFactory;
import com.kingdee.eas.basedata.assistant.CountryInfo;
import com.kingdee.eas.basedata.assistant.IndustryFactory;
import com.kingdee.eas.basedata.assistant.IndustryInfo;
import com.kingdee.eas.basedata.master.cssp.CSSPGroupFactory;
import com.kingdee.eas.basedata.master.cssp.CSSPGroupInfo;
import com.kingdee.eas.basedata.master.cssp.CSSPGroupStandardFactory;
import com.kingdee.eas.basedata.master.cssp.CSSPGroupStandardInfo;
import com.kingdee.eas.basedata.master.cssp.SupplierFactory;
import com.kingdee.eas.basedata.master.cssp.SupplierGroupDetailInfo;
import com.kingdee.eas.basedata.master.cssp.SupplierInfo;
import com.kingdee.eas.basedata.master.cssp.UsedStatusEnum;
import com.kingdee.eas.basedata.org.CtrlUnitFactory;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.IOrgSwitchFacade;
import com.kingdee.eas.basedata.org.OrgSwitchFacadeFactory;
import com.kingdee.eas.bdm.bdapply.SupplierReqFactory;
import com.kingdee.eas.bdm.bdapply.SupplierReqInfo;
import com.kingdee.eas.bdm.bdapply.util.BaseDataHandleUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.EffectedStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.util.NumericExceptionSubItem;


public class SupplierReqControllerBean extends AbstractSupplierReqControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.bdm.bdapply.app.SupplierReqControllerBean");
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		SupplierReqInfo info = (SupplierReqInfo) model;
		info.setBillStatus(com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus.Save);
		return super._save(ctx, model);
	}

	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		SupplierReqInfo info = (SupplierReqInfo) model;
		info.setErrorMsg(null);
		info.setBillStatus(com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus.Submit);
		return super._submit(ctx, model);
	}

	@Override
	protected void _allAudit(Context ctx, IObjectValue model)
	throws BOSException {
		// TODO Auto-generated method stub
		SupplierReqInfo cirinfo = (SupplierReqInfo)model;
		ctx.put("disablePermissionForKScript", Boolean.TRUE);
		this.addNewSupplier(ctx, cirinfo);
		try {
			cirinfo.setBillStatus(com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus.Audit);
			cirinfo.setAuditor(ContextUtil.getCurrentUserInfo(ctx));

			super._update(ctx, new ObjectUuidPK(cirinfo.getId()), cirinfo);
		} catch (EASBizException e) {
			throw new BOSException(e);
		}
		ctx.put("disablePermissionForKScript", Boolean.FALSE);
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		SupplierReqInfo info=SupplierReqFactory.getLocalInstance(ctx).getSupplierReqInfo(pk);
		if(info.getBillStatus().equals(com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus.Audit)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经完成审核操作，禁止删除！"));
		}
		super._delete(ctx, pk);
	}
	protected void _supplierAudit(Context ctx, IObjectValue model)throws BOSException {
		SupplierReqInfo cirinfo = (SupplierReqInfo)model;
		ctx.put("disablePermissionForKScript", Boolean.TRUE);
		this.addNewSupplier(ctx, cirinfo);
		try {
			cirinfo.setBillStatus(com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus.Audit);
			cirinfo.setAuditor(ContextUtil.getCurrentUserInfo(ctx));

			super._update(ctx, new ObjectUuidPK(cirinfo.getId()), cirinfo);
		} catch (EASBizException e) {
			throw new BOSException(e);
		}
		ctx.put("disablePermissionForKScript", Boolean.FALSE);
	}		
	// 是否启用编码规则
	protected boolean isCodeRuleEnable(Context ctx, IObjectValue objValue,
			String companyId) throws EASBizException, BOSException {
		ICodingRuleManager codeRuleMgr = CodingRuleManagerFactory.getLocalInstance(ctx);
		return codeRuleMgr.isExist(objValue, companyId);
	}
	public void addNewSupplier(Context ctx,SupplierReqInfo cirinfo) throws BOSException{
		Object feature = ctx.get("IS_OBJECT_CONTEXT");
		ctx.put("IS_OBJECT_CONTEXT", null);
		try{
			//SupplierReqEntryInfo srei = (SupplierReqEntryInfo)cirinfo.getEntrys().get(0);// 分录
			SupplierInfo suppInfo = new SupplierInfo(); 
			ObjectUuidPK objectUuidpk = null;
			suppInfo.setName(cirinfo.getName());
			suppInfo.setAddress(cirinfo.getAddress());
			suppInfo.setBarCode(cirinfo.getBarcode());
			//			suppInfo.setBizRegisterNo(cirinfo.getBizRegisterNo());
			suppInfo.setBusiExequatur(cirinfo.getBusiExequatur());
			//			suppInfo.setBusiLicence(cirinfo.getBusiLicence());
			suppInfo.setDescription(cirinfo.getDescription());
			suppInfo.setForeignName(cirinfo.getForeignName());
			suppInfo.setGSPAuthentication(cirinfo.getGSPAuthentication());
			suppInfo.setTaxRate(cirinfo.getTaxRate());
			suppInfo.put("linkMan", cirinfo.getLinkMan());
			suppInfo.put("linkCell", cirinfo.getLinkCell());
			suppInfo.setTaxRegisterNo(cirinfo.getTaxRegisterNo());
			suppInfo.setArtificialPerson(cirinfo.getArtificialPerson());
			if(cirinfo.getIndustry() != null){
				objectUuidpk  = new ObjectUuidPK(cirinfo.getIndustry().getId().toString());
				IndustryInfo  iinfo = IndustryFactory.getLocalInstance(ctx).getIndustryInfo(objectUuidpk);
				suppInfo.setIndustry(iinfo);
			}
			if(cirinfo.getCountry() != null){
				objectUuidpk  = new ObjectUuidPK(cirinfo.getCountry().getId().toString());
				CountryInfo   ctinfo = CountryFactory.getLocalInstance(ctx).getCountryInfo(objectUuidpk);
				suppInfo.setCountry(ctinfo);
			}
			if(cirinfo.getCity() != null){
				objectUuidpk  = new ObjectUuidPK(cirinfo.getCity().getId().toString());
				CityInfo   cityinfo = CityFactory.getLocalInstance(ctx).getCityInfo(objectUuidpk);
				suppInfo.setCity(cityinfo);
			}

			suppInfo.setRegion(cirinfo.getRegion());
			suppInfo.setAddress(cirinfo.getAddress());
			suppInfo.setTaxData(cirinfo.getTaxData());
			suppInfo.setTaxRate(cirinfo.getTaxRate());
			suppInfo.setTaxRegisterNo(cirinfo.getTaxRegisterNo());
			suppInfo.setVersion(1);
			suppInfo.setCountry(cirinfo.getCountry());
			suppInfo.setProvince(cirinfo.getProvince());
			suppInfo.setCity(cirinfo.getCity());
			suppInfo.setRegion(cirinfo.getRegion());
			suppInfo.setIsInternalCompany(false);
			//			suppInfo.setBizRegisterNo(cirinfo.getBizRegisterNo());
			suppInfo.setEffectedStatus(EffectedStatusEnum.getEnum(1));
			suppInfo.setMnemonicCode(cirinfo.getMnemonicCode());
			suppInfo.setBusiExequatur(cirinfo.getBusiExequatur());
			//			suppInfo.setBusiLicence(cirinfo.getBusiLicence());
			suppInfo.setGSPAuthentication(cirinfo.getGSPAuthentication());
			suppInfo.setIsMultiCopy(false);//true
			suppInfo.setSimpleName(cirinfo.getSimplename());
			suppInfo.setParent(cirinfo.getParent());
			suppInfo.setUsedStatus(cirinfo.getUserstated());// 下拉框
			//suppInfo.setCreateTime(cirinfo.getCreateTime());
			//suppInfo.setCreator(cirinfo.getCreator());

			objectUuidpk = new ObjectUuidPK(cirinfo.getCSSGroup().getId());
			SelectorItemCollection selector = new SelectorItemCollection();
			selector.add("*");
			CSSPGroupInfo    cSSPGroupInfo = CSSPGroupFactory.getLocalInstance(ctx).getCSSPGroupInfo(objectUuidpk, selector );
			suppInfo.setBrowseGroup(cSSPGroupInfo);

			//	if(cirinfo.getCU() != null){
			objectUuidpk  = new ObjectUuidPK("00000000-0000-0000-0000-000000000000CCE7AED4");
			CtrlUnitInfo cuinfo = CtrlUnitFactory.getLocalInstance(ctx).getCtrlUnitInfo(objectUuidpk);
			suppInfo.setAdminCU(cuinfo);
			suppInfo.setCU(cuinfo);
			//	}


			String FCUID = objectUuidpk.toString();//集团
			if (isCodeRuleEnable(ctx,suppInfo,FCUID)) {
				//suppInfo.setNumber(getAutoCode(ctx,suppInfo,FCUID));
				suppInfo.setNumber(SupplierFactory.getLocalInstance(ctx).readNewNumber(FCUID, suppInfo));
			}else{
				suppInfo.setNumber(cirinfo.getNumber());
			}

			suppInfo.setVersion(1);
			objectUuidpk = new ObjectUuidPK(cirinfo.getCSSGroup().getId());
			// 添加分录
			objectUuidpk = new ObjectUuidPK("00000000-0000-0000-0000-000000000001BC122A7F");//供应商分类标准  
			//objectUuidpk = new ObjectUuidPK("00000000-0000-0000-0000-000000000002BC122A7F");//客商分类标准
			CSSPGroupStandardInfo CSSPGSIInfo = null;
			CSSPGSIInfo = CSSPGroupStandardFactory.getLocalInstance(ctx).getCSSPGroupStandardInfo(objectUuidpk);

			SupplierGroupDetailInfo sgdinfo = new SupplierGroupDetailInfo();
			sgdinfo.setSupplierGroupStandard(CSSPGSIInfo);
			sgdinfo.setSupplierGroup(cSSPGroupInfo);//cirinfo.getParent().getSupplierGroupDetails().get(0)
			sgdinfo.setSupplierGroupFullName(cirinfo.getCSSGroup().getName());//srei.getSupplierGroupFullName()

			suppInfo.getSupplierGroupDetails().add(sgdinfo);

			SupplierFactory.getLocalInstance(ctx).submit(suppInfo);

			if(suppInfo.getId()!=null){
				objectUuidpk  = new ObjectUuidPK(suppInfo.getId().toString());
				SupplierFactory.getLocalInstance(ctx).approve(objectUuidpk);
				cirinfo.setUserstated(UsedStatusEnum.APPROVED);
				// 保存引用关系
				BaseDataHandleUtil.insertQuote(ctx, suppInfo, cirinfo.getCU().getId().toString());

				// 保存财务资料
				BaseDataHandleUtil.addSupplierCompanyInfo(ctx,cirinfo,suppInfo);
				// 保存销售资料
				BaseDataHandleUtil.addSupplierSaleInfo(ctx, cirinfo, suppInfo);
			}
			//			
			//			SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");	
			//			String date = f.format(new Date());
			//			String userId=cirinfo.getCreator().getId().toString();
			//			ObjectUuidPK cPK=new ObjectUuidPK("dfd38d11-00fd-1000-e000-1ebdc0a8100dDEB58FDC");//人民币
			//			//供应商财务资料
			//			StringBuffer sql=new StringBuffer();
			//			sql.append(" /*dialect*/ insert into T_BD_SupplierCompanyInfo (");
			//			sql.append(" fid,fcreatorid,fcreatetime,flastupdateuserid,flastupdatetime,");
			//			sql.append(" fcontrolunitid,fcomorgid,FSettlementCurrencyID,");
			//			sql.append(" fsupplierid,fusingstatus,fEffectedStatus");
			//			sql.append(" )values(");
			//			sql.append(" '"+BOSUuid.create("F26C0EC7").toString()+"','"+userId+"',to_Date('"+date+"','yyyy-MM-dd'),'"+userId+"',to_Date('"+date+"','yyyy-MM-dd')"+",");
			//			sql.append(" '"+FCUID+"','"+FCUID+"','"+cPK.toString()+"',");
			//	sql.append(" '"+fid.toString()+"','0','2'");
			//	sql.append(" )");
			//	DbUtil.execute(ctx,sql.toString());

		}catch (Exception e) {
			throw new BOSException("sql Execute Error :", e);
		}finally{ 
			ctx.put("IS_OBJECT_CONTEXT", feature);
		}
	}
	// 得到自动编码
	protected String getAutoCode(Context ctx, IObjectValue objValue,String companyId) throws EASBizException, BOSException {
		// String companyId = OrgInnerUtils.getCurCompany();
		// ICodingRuleManager codeRuleMgr = null;
		IOrgSwitchFacade orgSwitch = OrgSwitchFacadeFactory.getLocalInstance(ctx);
		orgSwitch.orgSwitch(companyId);
		ICodingRuleManager codeRuleMgr = CodingRuleManagerFactory.getLocalInstance(ctx);
		if (codeRuleMgr.isUseIntermitNumber(objValue, companyId)) {
			return codeRuleMgr.readNumber(objValue, companyId);
		} else {
			return codeRuleMgr.getNumber(objValue, companyId);
		}
	}

	protected void _notby(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub
		SupplierReqInfo cirinfo = (SupplierReqInfo) model;

		cirinfo.setBillStatus(com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus.unAudit);
		cirinfo.setAuditor(ContextUtil.getCurrentUserInfo(ctx));

		try {
			super._update(ctx, new ObjectUuidPK(cirinfo.getId()), cirinfo);
		} catch (EASBizException e) {
			throw new BOSException(e);
		}

	}

	/**
	 * 单据获取slor
	 * @param ctx
	 * @param bosType
	 * @return
	 * @throws BOSException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static String[] getSlorList(Context ctx,String bosType,String beginStr,ArrayList<String> arrayList){
		try{
			EntityObjectInfo eo = getEntityObject(ctx, bosType);
			LinkPropertyInfo lpo;
			PropertyInfo pro;//属性

			if(StringUtils.isEmpty(beginStr)){
				arrayList.add("*");
			}
			CoreBaseInfo entryInfo;
			String proName;
			for(int index=0;index<eo.getEntityProperties().size();index++){
				pro = eo.getEntityProperties().get(index);
				if(StringUtils.isEmpty(pro.getName()) || pro.getName().equals("parent"))
					continue;
				if(pro instanceof LinkPropertyInfo){
					lpo=(LinkPropertyInfo) pro;
					Class cls=Class.forName(lpo.getRelationship().getSupplierObject().getBusinessImplName()+"Info");
					if(lpo.getMappingField()==null){
						proName = StringUtils.isEmpty(beginStr)?(pro.getName()+".*"):(beginStr+"."+pro.getName()+".*");
						if(!arrayList.contains(proName)){
							arrayList.add(proName);
						}
						entryInfo = (CoreBaseInfo) cls.newInstance();
						getSlorList(ctx,entryInfo.getBOSType().toString(),(StringUtils.isEmpty(beginStr)?(pro.getName()):(beginStr+"."+pro.getName())),arrayList);
					}else{
						proName = StringUtils.isEmpty(beginStr)?(pro.getName()+".*"):(beginStr+"."+pro.getName()+".*");
						if(!arrayList.contains(proName)){
							arrayList.add(proName);
						}
					}
				}
			}
			return arrayList.toArray(new String[arrayList.size()]);
		}catch(Exception err) {
			err.printStackTrace();
		}
		return new String[]{"*"};
	}
	public static EntityObjectInfo getEntityObject(Context ctx,String bosType) {
		IMetaDataLoader loader = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
		EntityObjectInfo eo = loader.getEntity(BOSObjectType.create(bosType));
		return eo;
	}
}