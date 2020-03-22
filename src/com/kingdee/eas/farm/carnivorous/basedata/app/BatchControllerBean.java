package com.kingdee.eas.farm.carnivorous.basedata.app;

import java.math.BigDecimal;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.assistant.CORelatedType;
import com.kingdee.eas.basedata.assistant.CalculateModeEnum;
import com.kingdee.eas.basedata.assistant.CostObjectEntryInfo;
import com.kingdee.eas.basedata.assistant.CostObjectFactory;
import com.kingdee.eas.basedata.assistant.CostObjectGroupFactory;
import com.kingdee.eas.basedata.assistant.CostObjectGroupInfo;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.basedata.assistant.ICostObject;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchInfo;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo;
import com.kingdee.eas.farm.stocking.basedata.BreedDataFactory;
import com.kingdee.eas.farm.stocking.basedata.BreedDataInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.app.CreateCreatCostObject;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class BatchControllerBean extends AbstractBatchControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.basedata.app.BatchControllerBean");
	@Override
	protected void _save(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		BatchInfo info = (BatchInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.unApprove)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已核准或禁用！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		super._save(ctx, pk, model);
	}

	@Override
	protected void _submit(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		BatchInfo info = (BatchInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.unApprove)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已核准或禁用！"));
		}
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.approve)&&!info.getBaseStatus().equals(FarmBaseStatusEnum.frozen)) {
			info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		}
		super._submit(ctx, pk, model);
	}

	@Override
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		BatchInfo info = (BatchInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未核准！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.frozen);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		BatchInfo info = (BatchInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.frozen)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未禁用！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.approve);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BatchInfo info = (BatchInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.unApprove)) {
			throw new EASBizException(new NumericExceptionSubItem("001","未核准资料才能执行此操作！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.approve);
		
		this._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	/**
	 * 批次审核自动生成成本对象
	 * @param ctx
	 * @param info
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private CostObjectInfo createCostObject(Context ctx, BatchInfo info) throws EASBizException, BOSException {
		// TODO Auto-generated method stub
		String s1 = "select t1.fid broodCostObject from T_BD_CostObject     t1  " +
		" inner join T_BD_CostObjectEntry t2 on t2.fparentid=t1.fid" +
		" inner join T_BD_Material t3 on t3.fid=t2.FRelatedID" +
		" inner join T_FM_StockingBatch t4 on t4.fnumber =t1.FBatchNumber" +
		" inner join T_FM_BreedData  t5 on t5.fid=t4.FBreedDataID and t5.CFBroodMaterialID=t3.fid" +
		" where t4.fnumber='"+info.getNumber()+"'";
		IRowSet rs1 = DbUtil.executeQuery(ctx, s1);	
		String broodid = null;
		CostObjectInfo broodObject = null;
		try {
			if(rs1.next()){
				broodid = rs1.getString("broodCostObject");
				broodObject = CostObjectFactory.getLocalInstance(ctx).getCostObjectInfo(new ObjectUuidPK(broodid));
				return broodObject;
			}else{
				return produceBroodCostObject(ctx,info);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return broodObject;
	}

	/**
	 * 生成新的成本对象
	 * @param info 
	 * @param ctx 
	 * @throws BOSException 
	 */
	private CostObjectInfo produceBroodCostObject(Context ctx, BatchInfo info) throws BOSException {

		//获取批次名称
		String batchNum = info.getNumber();
		//获取品种信息
		BreedDataInfo breedDataInfo = null;
		//获取财务组织
		CompanyOrgUnitInfo companyInfo = null;
		//获取品种信息育雏期物料
		MaterialInfo broodMatInfo = null;

		//成本对象
		ICostObject iCostObject = null;

		//育成期、预产期成本对象分组
		String broodObjectGroupid = "xZ4+MUw2QA6VSzS9nkSsYsw5rkg=";
		CostObjectGroupInfo broodObjectGroup = null;


		try {
			//成本对象保存
			iCostObject = CostObjectFactory.getRemoteInstance();
			//育成期、预产期成本对象分组
			broodObjectGroup = CostObjectGroupFactory.getRemoteInstance().getCostObjectGroupInfo(new ObjectUuidPK(broodObjectGroupid));

			//财务组织
			companyInfo = CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK(info.getCompany().getId().toString()));
			//品种资料
			breedDataInfo = BreedDataFactory.getRemoteInstance().getBreedDataInfo(new ObjectUuidPK(info.getBreedData().getId().toString()));
			//育雏期物料
			if(breedDataInfo.getBroodMaterial() != null){
				broodMatInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(breedDataInfo.getBroodMaterial().getId().toString()));
			}else{
				throw new BOSException("品种资料的育雏期物料没有设置！");
			}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//设置育雏成本对象编码名称
		String broodCostObjectN = batchNum+"-"+broodMatInfo.getName().toString();

		//----------------------------------育雏期--------------------------------------
		//育雏期成本对象表头
		CostObjectInfo broodCostObjectInfo = new CostObjectInfo();
		//分录
		CostObjectEntryInfo broodEntryCostObjectInfo = new CostObjectEntryInfo();
		broodCostObjectInfo.setId(BOSUuid.create(broodCostObjectInfo.getBOSType()));
		//名称
		broodCostObjectInfo.setName(broodCostObjectN);
		//编码
		broodCostObjectInfo.setNumber(broodCostObjectN);
		//批次
		broodCostObjectInfo.setBatchNumber(batchNum);
		//财务组织
		broodCostObjectInfo.setCompany(companyInfo);
		//关联类型--产品
		broodCostObjectInfo.setRelatedType(CORelatedType.Product);
		//成本计算方法--分批法
		broodCostObjectInfo.setCalculateMode(CalculateModeEnum.BYBATCH);
		broodCostObjectInfo.setRelatedId(broodMatInfo.getId());//物料id
		broodCostObjectInfo.setRelatedNumber(broodMatInfo.getNumber());
		broodCostObjectInfo.setRelatedName(broodMatInfo.getName());
		broodCostObjectInfo.setCostObjectGroup(broodObjectGroup);//成本对象分组
		broodCostObjectInfo.setStdProductID(broodMatInfo);//关联物料

		//分录
		broodEntryCostObjectInfo.setIsMainProduct(true);
		broodEntryCostObjectInfo.setQuotiety(BigDecimal.ZERO);
		broodEntryCostObjectInfo.setRelatedID(broodMatInfo.getId());
		broodEntryCostObjectInfo.setRelatedNumber(broodMatInfo.getNumber());
		broodEntryCostObjectInfo.setRelatedName(broodMatInfo.getName());
		broodCostObjectInfo.getEntries().add(broodEntryCostObjectInfo);

		try {
			//育雏期成本对象保存
			iCostObject.save(broodCostObjectInfo);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CostObjectInfo broodObject = null;
		if(broodCostObjectInfo.getId() != null){
			try {
				broodObject = CostObjectFactory.getRemoteInstance().getCostObjectInfo(new ObjectUuidPK(broodCostObjectInfo.getId()));
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			throw new BOSException("成本对象没有生成！");
		}
		return broodObject;
	
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BatchInfo info = (BatchInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未核准！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		this._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BatchInfo info = BatchFactory.getLocalInstance(ctx).getBatchInfo(pk);
		if (info.getBaseStatus().equals(FarmBaseStatusEnum.approve) || info.getBaseStatus().equals(FarmBaseStatusEnum.frozen)) {
			throw new EASBizException(new NumericExceptionSubItem("001","已经核准或禁用，不能删除！"));
		}
//		try {
//			checkIsHasBeenQuoted(ctx, pk);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		super._delete(ctx, pk);
	}



	/**
	 * 校验当前批次是否被引用
	 * @param ctx
	 * @param pk
	 * @throws BOSException 
	 * @throws SQLException 
	 * @throws EASBizException 
	 */
	private void checkIsHasBeenQuoted(Context ctx, IObjectPK pk) throws BOSException, SQLException, EASBizException {
		// TODO Auto-generated method stub

		// 药品处方单
		IRowSet rs = DbUtil.executeQuery(ctx, "select * from T_FM_DrugReceiveBill where FBatchID=?",new Object[]{pk.toString()});
		if(rs.next()){
			throw new EASBizException(new NumericExceptionSubItem("001","当前批次已被药品处方单引用"));
		}

		// 雏苗领用单
		rs = DbUtil.executeQuery(ctx, "select * from T_FM_BreedSeedReceiveBill where FBatchID=?",new Object[]{pk.toString()});
		if(rs.next()){
			throw new EASBizException(new NumericExceptionSubItem("001","当前批次已被雏苗领用单引用"));
		}

		// 饲料领用单
		rs = DbUtil.executeQuery(ctx, "select * from T_FM_FodderReceptionEntry where FBatchID=?",new Object[]{pk.toString()});
		if(rs.next()){
			throw new EASBizException(new NumericExceptionSubItem("001","当前批次已被饲料领用单引用"));
		}

		// 批次合同
		rs = DbUtil.executeQuery(ctx, "select * from T_FM_BatchContractBill where FBatchID=?",new Object[]{pk.toString()});
		if(rs.next()){
			throw new EASBizException(new NumericExceptionSubItem("001","当前批次已被批次合同引用"));
		}
	}

}