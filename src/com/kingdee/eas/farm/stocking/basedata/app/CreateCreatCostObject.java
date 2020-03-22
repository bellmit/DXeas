package com.kingdee.eas.farm.stocking.basedata.app;

import java.math.BigDecimal;
import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.assistant.CORelatedType;
import com.kingdee.eas.basedata.assistant.CalculateModeEnum;
import com.kingdee.eas.basedata.assistant.CostObjectEntryInfo;
import com.kingdee.eas.basedata.assistant.CostObjectFactory;
import com.kingdee.eas.basedata.assistant.CostObjectGroupFactory;
import com.kingdee.eas.basedata.assistant.CostObjectGroupInfo;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchInfo;
import com.kingdee.eas.farm.carnivorous.basedata.IBatch;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo;
import com.kingdee.eas.farm.stocking.basedata.BreedDataEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.BreedDataInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class CreateCreatCostObject {

	public void create(BreedDataInfo bInfo, StockingBatchInfo info, BaseSysSettingInfo sysSetting, Context ctx)
	throws BOSException, EASBizException {
		System.out.print("create分录条数：" + bInfo.getEntry().size());
		System.out.print("create分录：" + bInfo.getEntry());
		System.out.print("INfo：" + info.getCompany());
		System.out.print("INfo：" + info);

		CoreBaseCollection cols=new CoreBaseCollection();
		CostObjectGroupInfo costObjectGroup;

		if (info.getEggCostItem() == null) {
			for (int i = 0; i < bInfo.getEntry().size(); i++) {
				BreedDataEntryInfo BeInfo = bInfo.getEntry().get(i);
				System.out.print("BreedDataEntry：" + BeInfo);
				if (BeInfo.containsKey("isQualified")&&BeInfo.isIsQualified() == true) {
					// 创建种蛋成本对象
					CostObjectInfo eInfo = new CostObjectInfo();
					eInfo.setCompany(info.getCompany());
					eInfo.setNumber("CD-" + info.getNumber());
					eInfo.setBatchNumber(info.getNumber());
					if (StringUtils.isEmpty(info.getName())) {
						eInfo.setName("CD-"+info.getNumber());
					} else {
						eInfo.setName("CD-"+info.getName());
					}
					eInfo.setCalculateMode(CalculateModeEnum.BYBATCH);// 计算方法
					eInfo.setRelatedType(CORelatedType.Product);//关联类型
					eInfo.setRelatedId(BeInfo.getMaterial().getId());// 物料id

					eInfo.setRelatedNumber(BeInfo.getMaterial().getNumber());
					eInfo.setRelatedName(BeInfo.getMaterial().getName());


					//						eInfo.setCostObjectGroup(sysSetting.getCostGroup());// 成本对象分组
					eInfo.setStdProductID(BeInfo.getMaterial());// 关联物料

					eInfo.setGroup(BeInfo.getMaterial().getMaterialGroup());

					costObjectGroup=null;
					if(BeInfo.getMaterial().getMaterialGroup()!=null) {
						costObjectGroup=getCostObjectGroupByMaterialGroupID(ctx, info.getCompany().getString("id"), BeInfo.getMaterial().getMaterialGroup().getString("id"));
					}
					if(costObjectGroup==null) {
						costObjectGroup=sysSetting.getCostGroup();
					}
					eInfo.setCostObjectGroup(costObjectGroup);// 成本对象分组

					CostObjectEntryInfo ceInfo = new CostObjectEntryInfo();
					ceInfo.setIsMainProduct(true);
					ceInfo.setQuotiety(BigDecimal.ONE);
					ceInfo.setRelatedID(BeInfo.getMaterial().getId());
					ceInfo.setRelatedNumber(BeInfo.getMaterial().getNumber());
					ceInfo.setRelatedName(BeInfo.getMaterial().getName());
					eInfo.getEntries().add(ceInfo);

					cols.add(eInfo);

					/*	try {
							CostObjectFactory.getLocalInstance(ctx).save(eInfo);
						} catch (EASBizException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (BOSException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.print("eInfo" + eInfo);*/

					info.setEggCostItem(eInfo);
					break;
				}
			}
		}

		if (info.getCostItem() == null) {
			// 创建育成成本对象
			CostObjectInfo cInfo = new CostObjectInfo();
			cInfo.setCompany(info.getCompany());
			cInfo.setNumber("YC-" + info.getNumber());
			cInfo.setBatchNumber(info.getNumber());
			if (StringUtils.isEmpty(info.getName())) {
				cInfo.setName("YC-"+info.getNumber());
			} else {
				cInfo.setName("YC-"+info.getName());
			}
			cInfo.setCalculateMode(CalculateModeEnum.BYBATCH);// 计算方法
			cInfo.setRelatedType(CORelatedType.Product);//关联类型
			cInfo.setRelatedId(bInfo.getBridMaterial().getId());// 物料id

			cInfo.setRelatedNumber(bInfo.getBridMaterial().getNumber());
			cInfo.setRelatedName(bInfo.getBridMaterial().getName());
			//			cInfo.setCostObjectGroup(sysSetting.getCostGroup());// 成本对象分组
			cInfo.setStdProductID(bInfo.getBridMaterial());// 关联物料

			cInfo.setGroup(bInfo.getBridMaterial().getMaterialGroup());

			costObjectGroup=null;
			if(bInfo.getBridMaterial().getMaterialGroup()!=null) {
				costObjectGroup=getCostObjectGroupByMaterialGroupID(ctx, info.getCompany().getString("id"), bInfo.getBridMaterial().getMaterialGroup().getString("id"));
			}
			if(costObjectGroup==null) {
				costObjectGroup=sysSetting.getCostGroup();
			}
			cInfo.setCostObjectGroup(costObjectGroup);// 成本对象分组

			CostObjectEntryInfo ceInfo = new CostObjectEntryInfo();
			ceInfo.setIsMainProduct(true);
			ceInfo.setQuotiety(BigDecimal.ONE);
			ceInfo.setRelatedID(bInfo.getBridMaterial().getId());
			ceInfo.setRelatedNumber(bInfo.getBridMaterial().getNumber());
			ceInfo.setRelatedName(bInfo.getBridMaterial().getName());
			cInfo.getEntries().add(ceInfo);
			cols.add(cInfo);
			info.setCostItem(cInfo);

			//			try {
			//				CostObjectFactory.getLocalInstance(ctx).save(cInfo);
			//			} catch (EASBizException e) {
			//				// TODO Auto-generated catch block
			//				e.printStackTrace();
			//			} catch (BOSException e) {
			//				// TODO Auto-generated catch block
			//				e.printStackTrace();
			//			}
			//			System.out.print("cInfo" + cInfo);
			//			info.setCostItem(cInfo);

		}
		if(cols.size()>0) {
			CostObjectFactory.getLocalInstance(ctx).addnew(cols);
		}
	}

	/**
	 * 通过物料分组获取成本对象分组
	 * @param ctx
	 * @param companyID
	 * @param materialGroupID
	 * @return 
	 */
	private CostObjectGroupInfo getCostObjectGroupByMaterialGroupID(Context ctx,String companyID,String materialGroupID) {
		try{
			StringBuffer sql=new StringBuffer();
			sql.append(" select fid")
			.append(" from t_bd_costObjectGroup ")
			.append(" where FSourceID='").append(materialGroupID).append("'")
			;
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()) {
				return CostObjectGroupFactory.getLocalInstance(ctx).getCostObjectGroupInfo(new ObjectUuidPK(rs.getString("fid")));
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}

	/**
	 * 商品禽成本对象
	 * @param info
	 * @param info2
	 * @param sysSetting
	 * @param ctx
	 */
	public void create(BreedDataInfo bInfo, BatchInfo info, BaseSysSettingInfo sysSetting, Context ctx)
	throws BOSException, EASBizException  {
		try {
			CoreBaseCollection cols=new CoreBaseCollection();
			CostObjectGroupInfo costObjectGroup;

			IBatch ibatch = BatchFactory.getLocalInstance(ctx);
			CostObjectInfo cInfo = new CostObjectInfo();

			//查看成本对象是否存在
			String s2 = "/*dialect*/ select fid costid from T_BD_CostObject where fnumber ='"+"SPD-" + info.getNumber()+"'";
			IRowSet r2 = DbUtil.executeQuery(ctx, s2.toString());
			String costid = null;
			if(r2.next()){
				costid = r2.getString("costid");
				String s1 = "update  T_FM_Batch set CFCarvCostObjectID = '"+costid+"'  where fid ='"+info.getId()+"'";
				com.kingdee.eas.util.app.DbUtil.execute(ctx, s1.toString());
			}else{
				if (info.getCarvCostObject() == null) {
					// 创建育成成本对象
					cInfo.setCompany(info.getCompany());
					cInfo.setNumber("SPD-" + info.getNumber());
					cInfo.setBatchNumber(info.getNumber());
					if (StringUtils.isEmpty(info.getName())) {
						cInfo.setName("SPD-"+info.getNumber());
					} else {
						cInfo.setName("SPD-"+info.getName());
					}
					cInfo.setCalculateMode(CalculateModeEnum.BYBATCH);// 计算方法
					cInfo.setRelatedType(CORelatedType.Product);//关联类型
					cInfo.setRelatedId(bInfo.getWeedoutMaterial().getId());// 物料id

					cInfo.setRelatedNumber(bInfo.getWeedoutMaterial().getNumber());
					cInfo.setRelatedName(bInfo.getWeedoutMaterial().getName());
					//			cInfo.setCostObjectGroup(sysSetting.getCostGroup());// 成本对象分组
					cInfo.setStdProductID(bInfo.getWeedoutMaterial());// 关联物料

					cInfo.setGroup(bInfo.getWeedoutMaterial().getMaterialGroup());

					costObjectGroup=null;
					MaterialInfo matInfo = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(bInfo.getWeedoutMaterial().getId()));
					if(matInfo.getMaterialGroup()!=null) {
						costObjectGroup=getCostObjectGroupByMaterialGroupID(ctx, info.getCompany().getString("id"), matInfo.getMaterialGroup().getString("id"));
					}
					if(costObjectGroup==null) {
						costObjectGroup=sysSetting.getCostGroup();
					}
					cInfo.setCostObjectGroup(costObjectGroup);// 成本对象分组
					CostObjectEntryInfo ceInfo = new CostObjectEntryInfo();
					ceInfo.setIsMainProduct(true);
					ceInfo.setQuotiety(BigDecimal.ONE);
					ceInfo.setRelatedID(bInfo.getWeedoutMaterial().getId());
					ceInfo.setRelatedNumber(bInfo.getWeedoutMaterial().getNumber());
					ceInfo.setRelatedName(bInfo.getWeedoutMaterial().getName());
					cInfo.getEntries().add(ceInfo);
					cols.add(cInfo);
					info.setCarvCostObject(cInfo);

				}
				if(cols.size()>0) {
					CostObjectFactory.getLocalInstance(ctx).addnew(cols);
				}
				String s1 = "update  T_FM_Batch set CFCarvCostObjectID = '"+cInfo.getId()+"'  where fid ='"+info.getId()+"'";
				com.kingdee.eas.util.app.DbUtil.execute(ctx, s1.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
