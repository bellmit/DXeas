package com.kingdee.eas.custom.stockprice.app;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.stockprice.RealTimeInventoryEntryInfo;
import com.kingdee.eas.custom.stockprice.RealTimeInventoryFactory;
import com.kingdee.eas.custom.stockprice.RealTimeInventoryInfo;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;


public class saveRealTimeInventoryFacadeControllerBean extends AbstractsaveRealTimeInventoryFacadeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.stockprice.app.saveRealTimeInventoryFacadeControllerBean");
	protected void _saveRealTimeInventory(Context ctx)throws BOSException
	{
		//七条公司七条线
		String sql="select fid,fnumber from T_ORG_Storage where fnumber in ('0','1','2')";
		IRowSet sqlRs = SQLExecutorFactory.getLocalInstance(ctx, sql).executeSQL();
		try {
			while(sqlRs.next()){
				StorageOrgUnitInfo stoOrgUnitnew = StorageOrgUnitFactory.getLocalInstance(ctx).getStorageOrgUnitInfo(new ObjectUuidPK(sqlRs.getString("fid")));
				StringBuffer sb=new StringBuffer();
				sb.append(" /*dialect*/ select  t2.fnumber materialNum,");//物料编码
				sb.append(" t2.fname_l2 materialName,");//物料名称
				sb.append(" t2.fid materialID,");//物料名称
				sb.append(" t2.FModel model,");//规格型号
				sb.append(" case when t1.flot like '20%' then t1.flot else null end as flot,");//批次，以‘20’开头的显示，否则不显示
				sb.append(" case when t1.flot like '20%' and t2.fnumber like '02%' then to_date(substr(t1.flot,0,8),'yyyy-MM-dd') else null end productDate,");//生产日期，批次转日期
				sb.append(" case  when t1.flot like '20%' and t2.fnumber like '02%' then to_char(to_date(substr(t1.flot,0,8),'yyyy-MM-dd')+360,'yyyy-mm-dd HH24:MI:SS') else null end endDate,"); //到期日期，生产日期+360天
				sb.append(" t3.fid unit,");//计量单位
				sb.append(" t1.FCurStoreQty currentQty,");//库存
				sb.append(" t1.FCurStoreQty availableQty,");//可用库存
				sb.append(" t4.fid baseUnit,");//基本计量单位
				sb.append(" t1.FBaseQty baseQty,");//基本库存
				sb.append(" t1.FBaseQty availableBaseQty,");//可用基本库存
				sb.append(" t5.fid assistUnit,");//辅助计量单位
				sb.append(" t1.FCurStoreAssistQty curStoreAssistQty,");//辅助库存
				sb.append(" t6.fid storeType,");//库存类型
				sb.append(" t7.fid storeState,");//库存状态
				sb.append(" t8.fid project,");//项目号
				sb.append(" t9.fid customer,");//客户
				sb.append(" t10.fid supplier,");//供应商
				sb.append(" t11.fid location,");//库位
				sb.append(" t12.fid wareHouse,");//仓库
				sb.append(" t14.fid trackNumber,");//追踪号
				sb.append(" t15.fid asstAttrValue,");//辅助属性
				sb.append(" t1.FLockQty lockQty,");//锁库(预留)数量
				sb.append(" t1.FLockBaseQty lockBaseQty,");//锁库(预留)基本数量
				sb.append(" t1.FLockAssistQty lockAssisQty,");//锁库(预留)辅助数量
				sb.append(" t13.fid stoOrgUnit");
				sb.append(" from T_IM_Inventory t1");
				sb.append(" inner join T_BD_Material t2 on t2.fid=t1.FMaterialID");
				sb.append(" left join T_BD_MeasureUnit t3 on t3.fid=t1.FUnitID");
				sb.append(" left join T_BD_MeasureUnit t4 on t4.fid=t1.FBaseUnitID");
				sb.append(" left join T_BD_MeasureUnit t5 on t5.fid=t1.FAssistUnitID");
				sb.append(" left join T_IM_STORETYPE   t6 on t6.fid=t1.FStoreTypeID");
				sb.append(" left join T_IM_STORESTATE  t7 on t7.fid=t1.FStoreStatusID");
				sb.append(" left join T_MM_Project     t8 on t8.fid=t1.FProjectID");
				sb.append(" left join T_BD_Customer    t9 on t9.fid=t1.FCustomerID");
				sb.append(" left join T_BD_Supplier    t10 on t10.fid=t1.FSupplierID");
				sb.append(" left join T_DB_LOCATION    t11 on t11.fid=t1.FLocationID");
				sb.append(" left join T_DB_WAREHOUSE   t12 on t12.fid=t1.FWarehouseID");
				sb.append(" inner join T_ORG_Storage   t13 on t13.fid=t1.FStorageOrgUnitID");
				sb.append(" left join T_MM_TrackNumber t14 on t14.fid=t1.FTrackNumberID");
				sb.append(" left join T_BD_AsstAttrValue t15 on t15.fid=t1.FAssistPropertyID");


				sb.append(" where t13.fnumber='").append(sqlRs.getString("fnumber")).append("'");
				sb.append(" and t1.fbaseQty<>0");
				sb.append(" order by t2.fnumber");

				//新建一个即时库存 存储的单据info，存储表头信息
				RealTimeInventoryInfo realTimeInventoryInfo;
				if(stoOrgUnitnew==null)
					return;
				else
					realTimeInventoryInfo=new RealTimeInventoryInfo();

				realTimeInventoryInfo.setBizDate(new Date());//业务日期
				realTimeInventoryInfo.setStoOrgUnit(stoOrgUnitnew);//库存组织
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				realTimeInventoryInfo.setNumber(sdf.format(new Date()));//单据编号

				try {
					RealTimeInventoryFactory.getLocalInstance(ctx).save(realTimeInventoryInfo);
				} catch (EASBizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				String id=realTimeInventoryInfo.getId().toString();

				//将获得的即时库存信息在 表中插入
				RealTimeInventoryEntryInfo info=new RealTimeInventoryEntryInfo();
				IRowSet rs2 = DbUtil.executeQuery(ctx, sb.toString());

				int seq=1;//设置分录的序号
				try {
					while(rs2.next()){
						String uuid = BOSUuid.create(info.getBOSType()).toString();
						StringBuffer buffer=new StringBuffer();
						buffer.append(" insert into T_STO_RealTimeInventoryEntry");

						buffer.append(" (fid,fparentid,fseq,FMaterialID,FMaterialNum,FModel,FFlot,FStorageOrgUnitID,FLocationID,");
						buffer.append(" FWareHouseID,FBaseUnitID,FSupplierID,FCustomerID,FStoreTypeID,FStoreStateID,");
						buffer.append(" FProductionDate,Fexp,FAmount,FUnitID,FBaseQty,FAvailableQty,FAvailableBaseQty,FAssistUnitID,FAssistPropertyID");
						buffer.append(")");
						buffer.append(" values('");
						buffer.append(uuid).append("','").append(id).append("',");//id,parentId

						buffer.append(seq).append(",");seq++;//单据序列号

						buffer.append(getActualValue(rs2.getString("materialID"))).append(",");//物料
						buffer.append(getActualValue(rs2.getString("materialNum"))).append(",");//物料编码
						buffer.append(getActualValue(rs2.getString("model"))).append(",");//物料规格
						buffer.append(getActualValue(rs2.getString("flot"))).append(",");//批次
						buffer.append(getActualValue(rs2.getString("stoOrgUnit"))).append(",");//库存组织
						buffer.append(getActualValue(rs2.getString("location"))).append(",");//库位
						buffer.append(getActualValue(rs2.getString("wareHouse"))).append(",");//仓库
						buffer.append(getActualValue(rs2.getString("baseUnit"))).append(",");//基本计量单位
						buffer.append(getActualValue(rs2.getString("supplier"))).append(",");//供应商
						buffer.append(getActualValue(rs2.getString("customer"))).append(",");//客户
						buffer.append(getActualValue(rs2.getString("storeType"))).append(",");//库存类型
						buffer.append(getActualValue(rs2.getString("storeState"))).append(",");//库存状态
						buffer.append(getActualDate(rs2.getString("productDate"))).append(",");//生产日期
						buffer.append(getActualDate(rs2.getString("endDate"))).append(",");//到期日期
						buffer.append(rs2.getBigDecimal("currentQty")).append(",");//数量
						buffer.append(getActualValue(rs2.getString("unit"))).append(",");//计量单位
						buffer.append(rs2.getBigDecimal("baseQty")).append(",");//基本数量
						buffer.append(rs2.getBigDecimal("availableQty")).append(",");//可用数量
						buffer.append(rs2.getBigDecimal("availableBaseQty")).append(",");//基本可用数量
						buffer.append(getActualValue(rs2.getString("assistUnit"))).append(",");//辅助计量单位
						buffer.append(getActualValue(rs2.getString("asstAttrValue"))).append(")");//辅助计量单位
						DbUtil.execute(ctx, buffer.toString());
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		
		
		
		
		
	}
	private  String getActualValue(String str){
		if(str==null)
			return str;
		else
			return "'"+str+"'";

	}
	private  String getActualDate(String str){
		if(str==null)
			return str;
		else
			return "{d '"+str+"'}";

	}
	@Override
	protected void _saveMaterialBasePrice(Context ctx) throws BOSException {
		// TODO Auto-generated method stub
		//创建一个销售单价保存单据的info
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String bizDateStr=sdf.format(new Date());
		String shortBizDateStr = bizDateStr.substring(0,10);  
		
		//已经取价格则退出
		IRowSet rs = DbUtil.executeQuery(ctx, "select 1 from T_STO_SalesPrice where to_char(FbizDate,'yyyy-MM-dd')='"+shortBizDateStr+"'");
		if(rs.size()>0){
			return;
		}
		try {
				String userID=ContextUtil.getCurrentUserInfo(ctx).getString("id");
				//插入表头
				StringBuffer sql=new StringBuffer();
				sql.append(" select distinct FAdminCUID from T_SD_MaterialBasePrice");
				rs=DbUtil.executeQuery(ctx, sql.toString());
				sql.setLength(0);
				String id;
				while(rs.next()) {
					id=BOSUuid.create("AFF94C0D").toString();
					sql.setLength(0);
					sql.append(" insert into T_STO_SalesPrice(")
					.append(" fid,fnumber,fbizDate,FCompanyID,FCreatorID,FCreateTime,")
					.append(" FLastUpdateUserID,FLastUpdateTime,FControlUnitID")
					.append(" )")
					.append(" select distinct '").append(id).append("','XSJG-'||t2.fnumber||'-").append(shortBizDateStr).append("',{ts '").append(bizDateStr).append("'},FAdminCUID,'").append(userID).append("',{ts '").append(bizDateStr).append("'},")
					.append(" '").append(userID).append("',{ ts '").append(bizDateStr).append("'},FAdminCUID")
					.append(" from T_SD_MaterialBasePrice t1 ")
					.append(" inner join t_org_baseUnit t2 on t2.fid=t1.FAdminCUID")
					.append(" where FAdminCUID='").append(rs.getString("FAdminCUID")).append("';");
					DbUtil.execute(ctx, sql.toString());
				}
				
				//插入分录
				StringBuffer buffer=new StringBuffer();
				buffer.append("insert into T_STO_SalesPriceEntry (");
				buffer.append("fid,fparentid,fseq,FMaterialNum,FMaterialID,FModel,FCreatorID,FCreateTime,FAuditorID,FAuditDate,");
				buffer.append("FPrice,FMaxPrice,FMinPrice,FAssistPropertyID,FChannelTypeID,FPriceTypeID,FPriority,FCurrencyID,FUnitID,");
				buffer.append("FBlockedStatus,FCheckedStatus,FEffectiveDate,FExpireDate,FOrgUnitID,fbizDate) ");
				
				buffer.append(" select newbosid('2E254C65'),tmain.fid,0,"); 
				buffer.append(" t2.fnumber materialNum,");//物料编码
//				buffer.append(" t2.fname_l2 materialName,");//物料名称
				buffer.append(" t2.fid materialID,");//物料ID
				buffer.append(" t2.fmodel model,");//规格型号
				buffer.append(" t9.fid   creator,");//创建者
				buffer.append(" t1.FCreateTime createTime,");//创建时间
				buffer.append(" t8.fid    auditor,");//审核人
				buffer.append(" t1.FAuditDate  auditDate,");//审核时间

				buffer.append(" t1.FPrice    price,");//价格
				buffer.append(" t1.FMaxPrice   maxPrice,");//最高限价
				buffer.append(" t1.FFloorPrice floorPrice,");//最低限价
				buffer.append(" t3.fid assistProperty,");//辅助属性
				buffer.append(" t5.fid channelType,");//渠道类型
				buffer.append(" t4.fid priceType,");//价格类型
				buffer.append(" t1.FPriority priority,");//优先级
				buffer.append(" t7.fid  currency,");//币别
				buffer.append(" t6.fid  unit,");//单位

				buffer.append(" t1.FBlockedStatus blockedStatus,");//启用状态
				buffer.append(" t1.FCheckedStatus checkedStatus,");//审核状态
				buffer.append(" t1.FEffectiveDate    EffectiveDate,");//生效日期
				buffer.append(" t1.FExpireDate    ExpireDate,");//失效日期
				buffer.append(" t1.FAdminCUID,");
				buffer.append(" tmain.fbizDate");
//				buffer.append(" tds.FAssignCUID");
				buffer.append(" from T_SD_MaterialBasePrice t1");
				buffer.append(" inner join T_STO_SalesPrice tmain on tmain.FCompanyID=t1.FAdminCUID and to_char(tmain.fbizDate,'yyyy-MM-dd')='").append(shortBizDateStr).append("'");
//				buffer.append(" inner join T_BD_DataBaseDAssign tds on tds.FDataBaseDID=t1.fid");
//				buffer.append(" inner join t_org_baseunit torg on torg.fid=tds.FAssignCUID");
				buffer.append(" inner join T_BD_Material         t2  on t2.fid=t1.FMaterialID");
				buffer.append(" left  join T_BD_AsstAttrValue    t3  on t3.fid=t1.FAssistPropertyID");
				buffer.append(" left  join T_SCM_PriceType       t4  on t4.fid=t1.FPriceTypeID");
				buffer.append(" left  join T_BD_ChannelType      t5  on t5.fid=t1.FChannelTypeID");
				buffer.append(" left  join T_BD_MeasureUnit      t6  on t6.fid=t1.FUnitID");
				buffer.append(" left  join T_BD_Currency         t7  on t7.fid=t1.FCurrencyID");
				buffer.append(" left  join T_PM_User             t8  on t8.fid=t1.FAuditorID");
				buffer.append(" left  join T_PM_User             t9  on t9.fid=t1.FCreatorID");
				buffer.append(" left  join T_PM_User             t10 on t10.fid=t1.FLastUpdateUserID");
				buffer.append(" order by t2.fnumber");
				DbUtil.execute(ctx, buffer.toString());
				
//			}
		} catch (SQLException e) {
			throw new BOSException(e);
		}
	}

	/**
	 * 获得食品厂的库存组织info
	 *//*
	protected StorageOrgUnitInfo getFoodFactoryStoUnit(Context ctx){
		StorageOrgUnitInfo stoOrgUnit=null;
		String str="select fid from T_ORG_Storage where fnumber in ('11','12','21','22','31','32','4')";
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, str);
			if(rs.next())
				stoOrgUnit = StorageOrgUnitFactory.getLocalInstance(ctx).getStorageOrgUnitInfo(new ObjectUuidPK(rs.getString("fid")));
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stoOrgUnit;
	}*/
	/**
	 * 获得食品厂的财务组织info
	 *//*
	protected CompanyOrgUnitInfo getFoodFactoryFIUnit(Context ctx){
		CompanyOrgUnitInfo company=null;
		String str="select fid from T_ORG_Storage where fnumber='4'";
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, str);
			if(rs.next())
				company = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(new ObjectUuidPK(rs.getString("fid")));
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return company;
	}*/
}