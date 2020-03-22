package com.kingdee.eas.farm.carnivorous.basebiz.app;

import java.io.StringWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.bizrule.util.UIRuleCodeHelper;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.permission.AdminToOrgRangeHandler;
import com.kingdee.eas.basedata.master.cssp.CustomerFactory;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.cssp.SupplierFactory;
import com.kingdee.eas.basedata.master.cssp.SupplierInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.BizParentAndDelegateInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CostCenterOrgUnitFactory;
import com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitFactory;
import com.kingdee.eas.basedata.org.FullOrgUnitFactory;
import com.kingdee.eas.basedata.org.FullOrgUnitInfo;
import com.kingdee.eas.basedata.org.IAdminOrgUnit;
import com.kingdee.eas.basedata.org.OUPartAdminFactory;
import com.kingdee.eas.basedata.org.OUPartAdminInfo;
import com.kingdee.eas.basedata.org.OUPartHRInfo;
import com.kingdee.eas.basedata.org.OrgSpecialTablesRebuildFacadeFactory;
import com.kingdee.eas.basedata.org.OrgStructureFactory;
import com.kingdee.eas.basedata.org.OrgStructureInfo;
import com.kingdee.eas.basedata.org.OrgTreeFactory;
import com.kingdee.eas.basedata.org.OrgTreeInfo;
import com.kingdee.eas.basedata.org.OrgTypeRelationFactory;
import com.kingdee.eas.basedata.org.OrgUnitDefaultRelationFactory;
import com.kingdee.eas.basedata.org.OrgUnitDefaultRelationInfo;
import com.kingdee.eas.basedata.org.OrgUnitLayerTypeFactory;
import com.kingdee.eas.basedata.org.OrgUnitLayerTypeInfo;
import com.kingdee.eas.basedata.org.OrgUnitRelationFactory;
import com.kingdee.eas.basedata.org.OrgUnitRelationInfo;
import com.kingdee.eas.basedata.ws.common.WsCommonImportUtil;
import com.kingdee.eas.basedata.ws.common.WsCommonTag;
import com.kingdee.eas.basedata.ws.common.WsCommonUtil;
import com.kingdee.eas.basedata.ws.common.WsCommonXMLUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplFactory;
import com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFarmEntryInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.carnivorous.basedata.SystemSettingCollection;
import com.kingdee.eas.farm.carnivorous.basedata.SystemSettingFactory;
import com.kingdee.eas.farm.carnivorous.basedata.SystemSettingInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.StockingFarmTypeEnum;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.util.StringUtils;

public class FarmerQualicationApplControllerBean extends AbstractFarmerQualicationApplControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.basebiz.app.FarmerQualicationApplControllerBean");
	protected void _audit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{
		FarmerQualicationApplInfo info = (FarmerQualicationApplInfo) model;
		if(!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)) {
			return; 
		}

		CoreBaseCollection farmCollection=new CoreBaseCollection();
		//生成养殖场信息
		for(int index=0;index<info.getFarmEntry().size();index++) {
			FarmInfo faInfo = info.getFarmEntry().get(index).getFarm();
			if(faInfo==null) {
				faInfo=new FarmInfo();
				faInfo.setId(BOSUuid.create(faInfo.getBOSType()));
				faInfo.setCU(ContextUtil.getCurrentCtrlUnit(ctx));
				faInfo.setNumber(StockingComm.getAutoNumberByOrg(ctx, faInfo));
			}else{
				String farmID = info.getFarmEntry().get(index).getFarm().getId().toString();
				faInfo=FarmFactory.getLocalInstance(ctx).getFarmInfo(new ObjectUuidPK(farmID));
				faInfo.setIsAllot(false);
				FarmFactory.getLocalInstance(ctx).unAudit(faInfo);
			}
			faInfo.setTreeid(info.getFarmEntry().get(index).getFarmGrop());
			faInfo.setCompany(info.getCompany());
			faInfo.setName(info.getFarmEntry().get(index).getName());
			faInfo.setAddress(info.getFarmEntry().get(index).getAddress());
			faInfo.setArea(info.getFarmEntry().get(index).getArea());
			faInfo.setFloorArea(info.getFarmEntry().get(index).getFloorArea());
			faInfo.setMileStd(info.getFarmEntry().get(index).getMileStd());
			faInfo.setRecyMiles(info.getFarmEntry().get(index).getRecyMiles());
			faInfo.setSuccahQty(info.getFarmEntry().get(index).getSuccahQty());
			faInfo.setMnemonicCode(info.getFarmEntry().get(index).getMnemonicCode());
			faInfo.setFarmType(StockingFarmTypeEnum.stocking);//养户放养
			//运费单价
			faInfo.setTransPrice(UIRuleUtil.getBigDecimal(info.getFarmEntry().get(index).getTransPrice()));
			
			//设置养殖规模
			faInfo.setGm(info.getFarmEntry().get(index).getFarmQty().toString());
			//设置养殖模式
			faInfo.setFaemsType(info.getFarmEntry().get(index).getFarmTypea());
			//设置成本中心
            if(info.getFarmEntry().get(index).getCostCenter() != null){
            	CostCenterOrgUnitInfo costCenterInfo = info.getFarmEntry().get(index).getCostCenter();
            	costCenterInfo = CostCenterOrgUnitFactory.getLocalInstance(ctx).getCostCenterOrgUnitInfo(new ObjectUuidPK(costCenterInfo.getId()));
            	faInfo.setCostCenter(costCenterInfo);
            }
			
			
			
			farmCollection.add(faInfo);
			info.getFarmEntry().get(index).setFarm(faInfo);
		}

		//保存并核准养殖场
		FarmFactory.getLocalInstance(ctx).save(farmCollection);
		for(int i=0;i<farmCollection.size();i++){
			FarmFactory.getLocalInstance(ctx).audit((FarmInfo) farmCollection.get(i));
		}

		if(!info.isOnlyFarm()){
			//生成养殖户信息
			FarmerInfo farmerInfo=null;
			if(info.getFarmer()==null) {
				farmerInfo=new FarmerInfo();
				farmerInfo.setCU(ContextUtil.getCurrentCtrlUnit(ctx));			
				farmerInfo.setNumber(StockingComm.getAutoNumberByOrg(ctx, farmerInfo));
			}else{
				farmerInfo=info.getFarmer();
				if(farmerInfo.getBaseStatus()==FarmBaseStatusEnum.approve){
					FarmerFactory.getLocalInstance(ctx).unAudit(farmerInfo);
				}
			}
			farmerInfo.setTreeid(info.getFarmerGrop());
			farmerInfo.setCompany(info.getCompany());
			farmerInfo.setName(info.getName());
			farmerInfo.setIdentity (info.getIdentity());
			farmerInfo.setTel(info.getTel());
			farmerInfo.setMobileTel(info.getMobileTel());
			farmerInfo.setAddress(info.getAddress());
			farmerInfo.setSex(info.getSex());
			farmerInfo.setBEBank(info.getBEBank());
			farmerInfo.setBankAddress(info.getBankAddress());
			//设置技术员
			farmerInfo.setPerson(info.getTechnologyPerson());
			farmerInfo.setBankNo(info.getBankNo());
			farmerInfo.setFarmerActualName(info.getFarmActualName());
			farmerInfo.setAuditTime(new java.util.Date());
			farmerInfo.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			farmerInfo.setAge(info.getAge());
			farmerInfo.setEduLvl(info.getEduLvl());
			farmerInfo.setNation(info.getNation());
			farmerInfo.setFamilyPersonCount(info.getFamilyPeronCount());
			farmerInfo.setFarmerType(info.getFarmerType());

			//设置养殖户的对应系统客户和对应系统供应商
			if(info.getSystemCustomer() != null){
				CustomerInfo customerInfo = CustomerFactory.getLocalInstance(ctx).getCustomerInfo(new ObjectUuidPK(info.getSystemCustomer().getId()));
				farmerInfo.setCustomer(customerInfo);
			}
			if(info.getSystemSupplier() != null){
				SupplierInfo supplierInfo = SupplierFactory.getLocalInstance(ctx).getSupplierInfo(new ObjectUuidPK(info.getSystemSupplier().getId()));
				farmerInfo.setSupplier(supplierInfo);
			}


			farmerInfo.getFarmEntry().clear();

			//添加到养殖户养殖场信息
			for(int index=0;index<info.getFarmEntry().size();index++) {
				FarmerFarmEntryInfo entryInfo=new FarmerFarmEntryInfo();
				FarmInfo faInfo = info.getFarmEntry().get(index).getFarm();
				entryInfo.setFarm(faInfo);
				entryInfo.setMemoryCode(info.getFarmEntry().get(index).getMnemonicCode());
				farmerInfo.getFarmEntry().add(entryInfo);				
			}

			//保存养殖户信息
			FarmerFactory.getLocalInstance(ctx).save(farmerInfo);
			FarmerFactory.getLocalInstance(ctx).audit(farmerInfo);
			info.setFarmer(farmerInfo);
		}
		info.setBillStatus(BillBaseStatusEnum.AUDITED);
		info.setAuditTime(new java.util.Date());
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		super._update(ctx, new ObjectUuidPK(info.getId()), info);

	}

	protected void _unAudit(Context ctx, IObjectValue model)throws BOSException, EASBizException 
	{
		FarmerQualicationApplInfo info = (FarmerQualicationApplInfo) model;
		try {
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
			info.setAuditTime(null);
			info.setAuditor(null);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception ex) {
			throw new BOSException(ex);
		}
	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FarmerQualicationApplInfo info = (FarmerQualicationApplInfo) model;
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		}
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		FarmerQualicationApplInfo info = (FarmerQualicationApplInfo) model;
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
			info.setBillStatus(BillBaseStatusEnum.SUBMITED);
		}
		return super._submit(ctx, info);
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FarmerQualicationApplInfo info = FarmerQualicationApplFactory.getLocalInstance(ctx).getFarmerQualicationApplInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核，禁止删除！"));
		}
		super._delete(ctx, pk);
	}

}