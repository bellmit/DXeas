package com.kingdee.eas.bdm.bdapply.app;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.framework.DataBaseDAssignFactory;
import com.kingdee.eas.basedata.framework.DataBaseDAssignInfo;
import com.kingdee.eas.basedata.framework.DataStateEnum;
import com.kingdee.eas.basedata.master.material.IMaterialGroup;
import com.kingdee.eas.basedata.master.material.IMaterialGroupStandard;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialGroupDetialInfo;
import com.kingdee.eas.basedata.master.material.MaterialGroupFactory;
import com.kingdee.eas.basedata.master.material.MaterialGroupInfo;
import com.kingdee.eas.basedata.master.material.MaterialGroupStandardFactory;
import com.kingdee.eas.basedata.master.material.MaterialGroupStandardInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.UsedStatusEnum;
import com.kingdee.eas.basedata.org.CtrlUnitFactory;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.IOrgSwitchFacade;
import com.kingdee.eas.basedata.org.OrgSwitchFacadeFactory;
import com.kingdee.eas.bdm.bdapply.MaterialInfoReqFactory;
import com.kingdee.eas.bdm.bdapply.MaterialInfoReqInfo;
import com.kingdee.eas.bdm.bdapply.MaterialInfoReqMaterialStdEntryInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.HanYuPinYinUtil;
import com.kingdee.eas.custom.szcount.ISzCountPositionSet;
import com.kingdee.eas.custom.szcount.SzCountPositionSetFactory;
import com.kingdee.eas.custom.szcount.SzCountPositionSetInfo;
import com.kingdee.eas.custom.szcount.SzCountPositionSetMaterialEntryInfo;
import com.kingdee.eas.framework.BillBaseException;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.util.app.PinYinHelper;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class MaterialInfoReqControllerBean extends AbstractMaterialInfoReqControllerBean {
	private static Logger logger = Logger.getLogger("com.kingdee.eas.bdm.bdapply.app.MaterialInfoReqControllerBean");

	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		MaterialInfoReqInfo info = (MaterialInfoReqInfo) model;
		info.setBillStatus(com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus.Save);
		return super._save(ctx, model);
	}

	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		MaterialInfoReqInfo info = (MaterialInfoReqInfo) model;
		info.setErrorMsg(null);
		info.setBillStatus(com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus.Submit);

		MaterialGroupInfo materialGroupInfo = info.getMaterialGroup();
		SelectorItemCollection slor = new SelectorItemCollection();
		slor.add("*");
		materialGroupInfo = MaterialGroupFactory.getLocalInstance(ctx).getMaterialGroupInfo(new ObjectUuidPK(materialGroupInfo.getString("id")),slor );
		//		if(materialGroupInfo.getLongNumber().startsWith("02!0204")){
		//			checkValueSimIsExist(ctx,info);
		//		}

		return super._submit(ctx, model);
	}

	/**
	 * 禽肉产品检验价值分类是否存在
	 * @param ctx
	 * @param info
	 * @throws EASBizException 
	 */
	private void checkValueSimIsExist(Context ctx, MaterialInfoReqInfo info) throws EASBizException {/*
		// TODO Auto-generated method stub
		MaterialInfoReqMaterialStdEntryInfo materialInfoReqMaterialStdEntryInfo;
		boolean flag = false;
		for(int i=0;i<info.getMaterialStdEntry().size();i++){
			materialInfoReqMaterialStdEntryInfo = info.getMaterialStdEntry().get(i);
			if(materialInfoReqMaterialStdEntryInfo.getMaterialClassifyStd() != null){
				if(materialInfoReqMaterialStdEntryInfo.getMaterialClassifyStd().getNumber().equalsIgnoreCase("price")){
					if(materialInfoReqMaterialStdEntryInfo.getMaterialClassify()!=null){
						flag = true;
						break;
					}
				}
			}
		}
		if(!flag){
			throw new EASBizException(new NumericExceptionSubItem("001","禽肉产品价值分类不能为空"));
		}
	*/}

	protected void _materialInfoAudit(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub
		MaterialInfoReqInfo mirinfo = (MaterialInfoReqInfo) model;
		ctx.put("disablePermissionForKScript", Boolean.TRUE);
		this.addNewMaterialInfo(ctx, mirinfo);

		try {

			mirinfo.setBillStatus(com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus.Audit);
			mirinfo.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			super._update(ctx, new ObjectUuidPK(mirinfo.getId()), mirinfo);
			//MessageUtils.sendMessage(ctx, mirinfo.getCreator().getId().toString(), "物料申请审批完成", "单号为："+mirinfo.getNumber()+"，物料为："+mirinfo.getName()+"已经审批通过！");
		} catch (Exception e) {
			throw new BOSException(e);
		}
		ctx.put("disablePermissionForKScript", Boolean.FALSE);
	}

	// 得到自动编码
	protected String getAutoCode(Context ctx, IObjectValue objValue, String companyId) throws EASBizException,
	BOSException {
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
	protected boolean isCodeRuleEnable(Context ctx, IObjectValue objValue, String companyId) throws EASBizException,
	BOSException {
		ICodingRuleManager codeRuleMgr = CodingRuleManagerFactory.getLocalInstance(ctx);
		return codeRuleMgr.isExist(objValue, companyId);
	}

	/**
	 * 新增物料
	 * 
	 * @param ctx
	 * @param mirinfo
	 * @return
	 * @throws BOSException
	 */
	public String addNewMaterialInfo(Context ctx, MaterialInfoReqInfo mirinfo) throws BOSException {
		String materialId = null;
		try {
			IOrgSwitchFacade orgSwitch = OrgSwitchFacadeFactory.getLocalInstance(ctx);
			orgSwitch.orgSwitch("00000000-0000-0000-0000-000000000000CCE7AED4");

			MaterialInfo info = new MaterialInfo();
			ObjectUuidPK pk = new ObjectUuidPK();
			if (mirinfo.getAdmincu() != null) {
				pk = new ObjectUuidPK("00000000-0000-0000-0000-000000000000CCE7AED4");
				CtrlUnitInfo ccuinfo = new CtrlUnitInfo();
				ccuinfo = CtrlUnitFactory.getLocalInstance(ctx).getCtrlUnitInfo(pk);
				info.setAdminCU(ccuinfo);
			}

			info.setAlias(mirinfo.getAlias());
			// mi.setAssistAttr(mirinfo.getAssistAtrr());
			if (mirinfo.getAssistUnit() != null) {
				pk = new ObjectUuidPK(mirinfo.getAssistUnit().getId());
				MeasureUnitInfo muinfo = MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(pk);
				info.setAssistUnit(muinfo);
			}

			info.setAvailable(true);
			String pinYinSpelling = HanYuPinYinUtil.getInstance().getPinYinSpelling(mirinfo.getName());
			if(pinYinSpelling.length()> 44){
				info.setNamePinYin(pinYinSpelling.substring(43));
			}else{
				info.setNamePinYin(pinYinSpelling);
			}
			String pinYinSpellingHead = HanYuPinYinUtil.getInstance().getPinYinSpellingHead(mirinfo.getName());
			if(pinYinSpellingHead.length()>44){
				info.setNameShortPinYin(pinYinSpellingHead.substring(43));
			}else{
				info.setNameShortPinYin(pinYinSpellingHead);
			}
			info.setBarCode(mirinfo.getBarcode());
			if (mirinfo.getBaseUnit() != null) {
				pk = new ObjectUuidPK(mirinfo.getBaseUnit().getId());
				MeasureUnitInfo muinfo = MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(pk);
				info.setBaseUnit(muinfo);
			}

			//info.setCreateTime(mirinfo.getCreateTime());
			//info.setCreator(mirinfo.getCreator());
			// if(mirinfo.getCU() != null){
			pk = new ObjectUuidPK("00000000-0000-0000-0000-000000000000CCE7AED4");
			CtrlUnitInfo ccuinfo = new CtrlUnitInfo();
			ccuinfo = CtrlUnitFactory.getLocalInstance(ctx).getCtrlUnitInfo(pk);
			info.setCU(ccuinfo);
			// }
			info.setModel(mirinfo.getModel());
			info.setDefaultLocale(mirinfo.getDefaultLocale());
			info.setDescription(mirinfo.getDescription());
			info.setEffectedStatus(0);
			info.setForeignname(mirinfo.getForeignname());
			// mi.setFreezeOrgUnit()
			info.setGrossWeight(mirinfo.getGrossWeight());

			IMaterialGroup imsgs = MaterialGroupFactory.getLocalInstance(ctx);
			if (mirinfo.getMaterialGroup() != null) {
				pk = new ObjectUuidPK(mirinfo.getMaterialGroup().getId());
				MaterialGroupInfo mginfo = new MaterialGroupInfo();
				mginfo =imsgs.getMaterialGroupInfo(pk);
				info.setMaterialGroup(mginfo);
			}

			info.setHelpCode(mirinfo.getHelpCode());
			info.setShortName(mirinfo.getShortname());
			info.setInt("standActivity",mirinfo.getStandActivity() );
			if (mirinfo.getSeqUnit() != null) {
				pk = new ObjectUuidPK(mirinfo.getSeqUnit().getId());
				MeasureUnitInfo muinfo = MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(pk);
				info.setSeqUnit(muinfo);
			}

			info.setRegisteredmark(mirinfo.getRegisteredmark());
			info.setWarrantnumber(mirinfo.getWarrantnumber());
			info.setStatus(mirinfo.getStatus());

			if (mirinfo.getPricepPrecision() == null) {
				info.setPricePrecision(0);
			} else {
				info.setPricePrecision(Integer.parseInt(mirinfo.getPricepPrecision().toString()));
			}

			info.setName(mirinfo.getName());

			String FCUID = "00000000-0000-0000-0000-000000000000CCE7AED4";// 取得当前公司

			if (isCodeRuleEnable(ctx, info, FCUID)) {
				//info.setNumber(getAutoCode(ctx, info, FCUID));
				info.setNumber(MaterialFactory.getLocalInstance(ctx).readNewNumber(ccuinfo.getId().toString(), info));
			} else {
				info.setNumber(mirinfo.getNumber());
			}

			ObjectUuidPK objectUuidpk = null;// 分录取F7
			objectUuidpk = new ObjectUuidPK("dR8lnQEPEADgAAWKwKgSxZeb4R8=");// 修改

			MaterialGroupStandardInfo materialGroupStandardInfo = null;
			materialGroupStandardInfo = MaterialGroupStandardFactory.getLocalInstance(ctx)
			.getMaterialGroupStandardInfo(objectUuidpk);//物料基本分类

			//modify@20160928 by dai
			MaterialGroupDetialInfo mgdinfo = new MaterialGroupDetialInfo();
			mgdinfo.setMaterialGroupStandard(materialGroupStandardInfo);
			mgdinfo.setMaterialGroup(info.getMaterialGroup());//基本分类标准
			info.getMaterialGroupDetails().add(mgdinfo);

			//add by dai @20160928
			//			IMaterialGroupStandard imgss = MaterialGroupStandardFactory.getLocalInstance(ctx);
			for(int i=0;i<mirinfo.getMaterialStdEntry().size();i++) {
				if(mirinfo.getMaterialStdEntry().get(i).getMaterialClassify()==null) {
					continue;
				}
				MaterialGroupDetialInfo mgdinfo2 = new MaterialGroupDetialInfo();
				mgdinfo2.setMaterialGroupStandard(mirinfo.getMaterialStdEntry().get(i).getMaterialClassifyStd());
				mgdinfo2.setMaterialGroup(imsgs.getMaterialGroupInfo(new ObjectUuidPK(mirinfo.getMaterialStdEntry().get(i).getMaterialClassify().getId())));// 客户分类标准
				info.getMaterialGroupDetails().add(mgdinfo2);
			}

			// }

			//add by dai @20160928
			info.setBoolean("isOutsourcedPart", mirinfo.isIsOutSourcePart());
			//info.setBoolean("useAsstAttrRealtion", mirinfo.isIsUseAsstAttrRelation());
			info.setUseAsstAttrRelation(mirinfo.isIsUseAsstAttrRelation());


			IObjectPK newpk = MaterialFactory.getLocalInstance(ctx).submit(info);
			// materialId = newpk.toString();
			if (info.getId() != null) {
				materialId = info.getId().toString();
				objectUuidpk = new ObjectUuidPK(info.getId());
				MaterialFactory.getLocalInstance(ctx).approve(objectUuidpk);
				mirinfo.setStatus(UsedStatusEnum.APPROVED);

				insertQuote(ctx, info, mirinfo.getCU().getId().toString());
				
				//将物料信息插入计数单中
				addMaterialinfotoCount(ctx,info);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BOSException("sql Execute Error :", e);
		}
		return materialId;
	}
	//将物料信息插入计数单中
	private void addMaterialinfotoCount(Context ctx, MaterialInfo info) {
		// TODO Auto-generated method stub
		
		IRowSet sql = getCountQL(ctx,info);
		try {
			while (sql.next()) {
				//String upsql = "insert into CT_SZC_SzCPSME(FID,FParentID,CFMaterialID,CFMaterialtype,CFBaseUnit,FMaterialNum,CFIsCount,CFInventoryUnit) values(newbosid('4E23C5CF'),"+sql.getString("fid")+","+info.getId().toString()+","+info.getModel()+","+info.getBaseUnit().getId().toString()+","+info.getNumber()+",1,"+info.getBaseUnit().getId().toString()+")";
				//DbUtil.execute(ctx,upsql.toString());
				SzCountPositionSetInfo cinfo = SzCountPositionSetFactory.getLocalInstance(ctx).getSzCountPositionSetInfo(new ObjectUuidPK(sql.getString("fid")));
				SzCountPositionSetMaterialEntryInfo meinfo = new SzCountPositionSetMaterialEntryInfo();
				meinfo.setMaterial(info);
				meinfo.setMaterialNum(info.getNumber());
				meinfo.setMaterialtype(info.getModel());
				meinfo.setBaseUnit(info.getBaseUnit().getName());
				meinfo.setInventoryUnit(info.getBaseUnit().getName());
				meinfo.setIsCount(true);
				cinfo.getMaterialEntry().add(meinfo);
				ISzCountPositionSet is = SzCountPositionSetFactory.getLocalInstance(ctx);
				is.save(cinfo);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//sql整合
	private IRowSet getCountQL(Context ctx, MaterialInfo info) {
		// TODO Auto-generated method stub
		String MName = info.getName();
		boolean flag = MName.contains("鲜");
		IRowSet rs = null;
		StringBuffer sb = new StringBuffer();
		String sp = "\n";
		sb.append("/*dialect*/").append(sp);
		sb.append(" ").append(sp);
		sb.append("select t1.FID fid from  ").append(sp);
		sb.append("CT_SZC_SzCountPositionSet t1 ").append(sp);
		//sb.append("inner join CT_FM_CustomerOrderPlanEntry t2 on t2.FParentID = t1.FID ").append(sp);
		//sb.append("inner join CT_FM_CustomerOPME t3 on t3.FParentID = t2.FID ").append(sp);	
		if(flag){
			sb.append("where t1.CFIsIceFrish = 1").append(sp);	
		}else{
			sb.append("where t1.CFIsIceFrish != 1").append(sp);	
		}
		//sb.append("group by  t3.CFMaterialNumberID,t3.CFMaterialName").append(sp);
		
		try {
			rs = SQLExecutorFactory.getLocalInstance(ctx,sb.toString()).executeSQL();
			return rs;	
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return rs;
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		MaterialInfoReqInfo info=MaterialInfoReqFactory.getLocalInstance(ctx).getMaterialInfoReqInfo(pk);
		if(info.getBillStatus().equals(com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus.Audit)) {
			throw new BillBaseException(new NumericExceptionSubItem("001","单据已经完成审核操作，禁止删除！"));
		}
		super._delete(ctx, pk);
	}

	/***
	 * 插入引用关系
	 * @param ctx
	 * @param info
	 */
	public static void insertQuote(Context ctx,CoreBaseInfo destInfo,String cuID) {
		try {
			/*StringBuffer sql=new StringBuffer();
			sql.append(" insert into ");
			sql.append(" T_BD_DataBaseDAssign (");
			sql.append(" fid,FDataBaseDID,FAssignCUID,FBOSObjectType,FStatus");
			sql.append(" )values(");
			sql.append(" ");
			sql.append(" )");
			DbUtil.execute(ctx, sql.toString());*/
			DataBaseDAssignInfo dInfo=new DataBaseDAssignInfo();
			dInfo.setAssignCU(CtrlUnitFactory.getLocalInstance(ctx).getCtrlUnitInfo(new ObjectUuidPK(cuID)));
			dInfo.setDataBaseDID(destInfo.getId());
			dInfo.setBosObjectType(destInfo.getBOSType().toString());
			dInfo.setStatus(DataStateEnum.ENABLE);
			DataBaseDAssignFactory.getLocalInstance(ctx).save(dInfo);
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
}
