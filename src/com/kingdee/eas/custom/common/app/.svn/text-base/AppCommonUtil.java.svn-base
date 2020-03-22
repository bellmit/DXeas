package com.kingdee.eas.custom.common.app;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.IMetaDataLoader;
import com.kingdee.bos.metadata.MetaDataLoaderFactory;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.bos.metadata.bot.BOTMappingFactory;
import com.kingdee.bos.metadata.bot.BOTMappingInfo;
import com.kingdee.bos.metadata.bot.BOTRelationCollection;
import com.kingdee.bos.metadata.bot.DefineSysEnum;
import com.kingdee.bos.metadata.bot.IBOTMapping;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.eas.base.botp.BOTPException;
import com.kingdee.eas.base.btp.BTPException;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.BTPTransformResult;
import com.kingdee.eas.base.btp.IBTPManager;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.assistant.SystemStatusCtrolUtils;
import com.kingdee.eas.basedata.master.cssp.SupplierFactory;
import com.kingdee.eas.basedata.master.cssp.SupplierInfo;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.MaterialInventoryCollection;
import com.kingdee.eas.basedata.master.material.MaterialInventoryFactory;
import com.kingdee.eas.basedata.master.material.MaterialInventoryInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.fm.common.FMException;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.framework.CoreBillBaseInfo;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.eas.util.StringUtil;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * 
 * 后台 通用 接口 
 * @author kevin_gj_wang
 *
 */
public class AppCommonUtil {
	
	
	/**
	 * 更新 单据凭证标志
	 * @param ctx
	 * @param tableName
	 * @param fid
	 * @param state
	 * @throws BOSException 
	 */
	public static void updateVoucherState(Context ctx, String tableName,String fid,boolean state) throws BOSException{
		StringBuilder sb = new StringBuilder("/*dialect*/");
		sb.append("update ");
		sb.append(tableName);
		sb.append(" set FFIVOUCHERED =");
		sb.append(state?1:0);
		sb.append(" ");
		
		sb.append(" where fid='");
		sb.append(fid);
		sb.append("'");
		DbUtil.execute(ctx, sb.toString());
	}
	/**
	 * 根据计量单位名称获得对应计量单位对象
	 * @param unitName
	 * @return
	 */
	public static MeasureUnitInfo getUnitByUnitName(Context ctx, String unitName){
		StringBuilder sb = new StringBuilder();
		sb.append("select fid from t_bd_measureunit t where t.fname_l2 = '");
		sb.append(unitName);
		sb.append("'");
		MeasureUnitInfo unitInfo = null;
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			if(rs.next()){
				String fid = rs.getString("fid");
				if(StringUtils.isNotBlank(fid)){
					unitInfo = MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(new ObjectUuidPK(fid));
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
		return unitInfo;
	}
	
	/**
	 * 根据供应商名称获得对应供应商对象
	 * @param unitName
	 * @return
	 */
	public static SupplierInfo getSupplierByName(Context ctx, String supplierName){
		StringBuilder sb = new StringBuilder();
		sb.append("select fid from t_bd_supplier t where t.fname_l2 = '");
		sb.append(supplierName);
		sb.append("'");
		SupplierInfo supplierInfo = null;
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			if(rs.next()){
				String fid = rs.getString("fid");
				if(StringUtils.isNotBlank(fid)){
					supplierInfo = SupplierFactory.getLocalInstance(ctx).getSupplierInfo(new ObjectUuidPK(fid));
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
		return supplierInfo;
	}
	/**
	 * 根据物料名称 查询物料
	 * @param ctx
	 * @param materialName
	 * @return
	 */
	public static MaterialInfo getMaterialByName(Context ctx,
			String materialName,String controlOrgUnitNumber) {
		
		
		
		
		StringBuilder sb = new StringBuilder();
		sb.append("select t.fid from t_bd_material t inner join t_org_ctrlunit tc on t.FCONTROLUNITID = tc.fid where t.fstatus=1 and t.fname_l2 = '");
		sb.append(materialName);
		sb.append("' and tc.fnumber='");
		sb.append(controlOrgUnitNumber);
		sb.append("' ");
		
		
		MaterialInfo materialInfo = null;
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			if(rs.next()){
				String fid = rs.getString("fid");
				if(StringUtils.isNotBlank(fid)){
					materialInfo = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(fid));
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
		return materialInfo;
	}
	
	/**
	 * 验证某张表中是否已经存在指定编号的单据  如果存在返回true 否则返回false
	 * @param ctx
	 * @param billNumber
	 * @return
	 * @throws BOSException 
	 */
	public static boolean checkBillNumberExist(Context ctx, String tableName, String billNumber) {
		StringBuilder sb = new StringBuilder();
		sb.append("select t.fnumber from ");
		sb.append(tableName);
		sb.append(" t where t.fnumber='");
		sb.append(billNumber);
		sb.append("' ");
		
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			if(rs.next()){
				System.out.print("true");
				return true;
				
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 获得指定 单据类型 可用的下推单据类型
	 * @param ctx
	 * @param srcBOSType
	 * @return
	 * @throws BOSException
	 * @throws BOTPException
	 */
	public Map<String,EntityObjectInfo> getDestBostype(Context ctx, String srcBOSType) throws BOSException, BOTPException{
		
		HashMap<String,EntityObjectInfo> destEOI = new HashMap<String, EntityObjectInfo>();
		// 后台获得 可生成的目标单据类型
		IBOTMapping iBOTMapping = BOTMappingFactory.getLocalInstance(ctx);
		
		String targetTypeAndAliasString = iBOTMapping
				.getTargetBillTypeList(srcBOSType);
		if(StringUtils.isNotBlank(targetTypeAndAliasString)){
			String[] targetTypeAndAlias = StringUtil.split(targetTypeAndAliasString, "|");
			
			String targetBillTypeString = targetTypeAndAlias[0];
			String targetAliasString = targetTypeAndAlias[1];
			
			String[] targetAlias = StringUtil.split(targetAliasString, ",");
			String[] targetBillType = StringUtil.split(targetBillTypeString, ",");
			// 逐个循环 添加目标单据eoi到result
			IMetaDataLoader loader = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
			for(int i = 0; i < targetBillType.length; i++){
				String targetType = targetBillType[i];
				EntityObjectInfo tempObj = loader.getEntity(BOSObjectType.create(targetType));
				destEOI.put(targetType, tempObj);
			}
			
		}
		return destEOI;
	}
	/**
	 * 获得指定 单据所有可用的botp 列表
	 * @param ctx
	 * @param srcBillType
	 * @param targetBosType
	 * @param defineSys
	 * @param transmitContext
	 * @param srcBillIDs
	 * @param entrieNames
	 * @param entriesKeys
	 * @param botpSelectors
	 * @return
	 * @throws BOSException 
	 * @throws BOTPException 
	 */
	public BOTMappingCollection getAllCanUsedBots(Context ctx,String srcBillType,  String[] srcBillIDs, String[] entryNames,
			List entriesKey, SelectorItemCollection botpSelectors) throws BOTPException, BOSException{
		if(botpSelectors == null){
			botpSelectors = new SelectorItemCollection();
		}
		
		
		Map<String,EntityObjectInfo> destBosTypes =  getDestBostype(ctx,srcBillType);
		
		BOTMappingCollection botColl = new BOTMappingCollection();
		
		OrgUnitInfo orgUnit = ContextUtil.getCurrentCtrlUnit(ctx);
		Map transmitContext = new HashMap();
		transmitContext.put("TRANSMITCU", orgUnit);
		// 逐个目标单据类型 获得对应的所有转换规则 
		if(destBosTypes.size() > 0){
			Set<String> keySet = destBosTypes.keySet();
			Iterator<String> keyIte = keySet.iterator();
			
			IBOTMapping botMapping = BOTMappingFactory.getLocalInstance(ctx);
			while(keyIte.hasNext()){
				// 目标单据bostype
				String destBOSType = keyIte.next();
				
				
				BOTMappingCollection botMappingCols = botMapping.getMappingCollectionForSelectUseRuleFilter(srcBillType,
						destBOSType, 
						DefineSysEnum.BTP,
						transmitContext, 
						srcBillIDs, 
						entryNames,
						entriesKey, 
						botpSelectors);
				// 添加到结果集中
				botColl.addCollection(botMappingCols);
			}
		}
//		String targetBosType
//		DefineSysEnum.BTP,
	
		return botColl;
		
	}
	/**
	 * 
	 * 
	 * @param paramArrayOfString1
	 * @param paramArrayOfString2
	 * @param paramList
	 * @param paramSelectorItemCollection
	 * @param paramString1
	 * @param paramIObjectPK
	 * @param paramString2
	 * @return
	 * @throws BOSException
	 * @throws BTPException
	 */
	public static IObjectCollection transformForBotp(Context ctx,
			String[] idList, 
			String[] entryNames,
			List entryIDs, 
			SelectorItemCollection botpSelectors,
			String destBillTypeBOSType, 
			IObjectPK botpPK, 
			String srcBillType )
			throws BOSException, BTPException{
		
		
		IObjectValue destBillInfo = null; // destBillBosType：目标单据BOS类型
		
		ObjectUuidPK destPK = null;
		IBTPManager btp = null;
		BTPTransformResult result = null;
		// 记录当前状态
		String status = "";
		// 记录目标单据状态
		StringBuilder numSb = new StringBuilder();
		StringBuilder statusSb = new StringBuilder();
		try {
			// ***********************************
			IMetaDataLoader loader = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
			loader = MetaDataLoaderFactory.getRemoteMetaDataLoader();
			EntityObjectInfo eo = loader.getEntity(BOSObjectType.create(destBillTypeBOSType));
			
			if (eo == null) {
				return null;
			}
			
			
			
			
//			Class cls = Class.forName(eo.getBusinessImplFactory());
//			Method mtd = cls.getMethod("getLocalInstance", new Class[] { com.kingdee.bos.Context.class });
//			ICoreBase iCoreBase = (ICoreBase) mtd.invoke(cls, new Object[] { ctx });
			
			
			btp = BTPManagerFactory.getLocalInstance(ctx);
			// [注释]获取BTP的本地接口
//			result = btp.transform(srcBill, botMappingInfo);
			result=  btp.transformForBotp(idList, entryNames, entryIDs, botpSelectors, destBillTypeBOSType, botpPK, srcBillType);
			
			 // 获取结果 单据编码
			 
			// [注释] result：为转换成功生的目标单据
			// objectValue：源单据的值对象
			IObjectCollection destBillColl =  result.getBills();
			
			
			return destBillColl;
			
		} catch (Exception e1) {// botp 失败 删除单据
			e1.printStackTrace();
//			try {
//				if (((InvBillBaseInfo) destBillInfo).getBaseStatus().equals(
//						com.kingdee.eas.scm.common.BillBaseStatusEnum.AUDITED))
//					iInstace.unAudit(destPK);// 反审核
//				iInstace.delete(destPK);// 删除
//			} catch (Exception e3) {
//				e3.printStackTrace();
//			}
//			try {
//				if (destBillInfo != null)
//					btp.removeAllRelation((CoreBillBaseInfo) destBillInfo);
//			} catch (Exception e3) {
//				e3.printStackTrace();
//			}
//			resultInfo.set
			statusSb.append(status).append(";");
			
			status = "";
			
			throw new BOSException(e1.getMessage());
		}
	}
		
		
	
	/**
	 * 
	 * @param ctx
	 * @param srcBosType 源单据的BosType
	 * @param destBosType 目标单据的BosType
	 * @param srcBillCollection 源单据集合，可以批量转换
	 * @param botpPK 要使用的BOTP的PK。
	 * @throws Exception
	 */
	public static IObjectCollection generateDestBill(Context ctx, String srcBosType,

			String destBosType, CoreBillBaseCollection srcBillCollection,DefineSysEnum defineEnum,

			IObjectPK botpPK) throws Exception 
			{

				IBOTMapping botMapping = BOTMappingFactory.getLocalInstance(ctx);
		
				CoreBillBaseInfo billInfo = srcBillCollection.get(0);
				// 验证botp是否存在
				BOTMappingInfo botMappingInfo = botMapping.getMapping(billInfo,
						destBosType, defineEnum);
		
				if (botMappingInfo == null) {
		
					throw new FMException(FMException.NODESTBILL);
		
				}
		
				IBTPManager iBTPManager = BTPManagerFactory.getLocalInstance(ctx);
		
				BTPTransformResult btpResult = null;
		
				/*
				 * String[] ids = new String[srcBillCollection.size()];
				 * 
				 * for (int i = 0; i < srcBillCollection.size(); ++i) {
				 * 
				 * CoreBaseInfo info = srcBillCollection.get(i);
				 * 
				 * ids[i] = info.getId().toString();
				 * 
				 * }
				 */
				// 调用botp
				btpResult = iBTPManager.transformForBotp(srcBillCollection,
						destBosType, botpPK);
		
				IObjectCollection destBillCols = btpResult.getBills();
		
				BOTRelationCollection botRelationCols = btpResult
						.getBOTRelationCollection();
				// 保存关联
				for (int i = 0; i < destBillCols.size(); i++) {
		
					CoreBillBaseInfo destBillInfo = (CoreBillBaseInfo) destBillCols
							.getObject(i);
		
					iBTPManager.submitRelations(destBillInfo, botRelationCols);
	
				}
				
				return destBillCols;
	
		}  
	
	/**
	 * 验证某个单据是否存在下游单据
	 * @param ctx
	 * @param srcBosType
	 * @param srcBillId
	 * @return
	 * @throws BOSException 
	 */
	public static boolean existDestBill(Context ctx,String srcBosType,String srcBillId) throws BOSException{
		StringBuilder sb = new StringBuilder();
		sb.append("select t.fid from t_bot_relation t where fsrcentityid='");
		sb.append(srcBosType);
		sb.append("' and fsrcobjectid='");
		sb.append(srcBillId);
		sb.append("'");
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			if(rs.next()){
				return true;
			}
		}catch(Exception e){
			throw new BOSException(e);
		}
		
		
		
		return false;
	}
	
	/**
	 * 根据 单据日期获得对应的整理后的单据日期
	 * 如果单据日期大于当前期间的起始日期，则直接返回，
	 * 如果小于当前期间起始日期，则返回当前应收期间起始日期
	 * @param ctx
	 * @param billDate
	 * @param type SystemEnum.ACCOUNTSRECEIVABLE 应收   
	 * @return
	 * @throws BOSException 
	 */
	public static Date getARBillDate(Context ctx,SystemEnum type, Date billDate) throws BOSException{
		// 
		try{
		CompanyOrgUnitInfo currCompany = ContextUtil.getCurrentFIUnit(ctx);
		PeriodInfo currPeriod = SystemStatusCtrolUtils.getCurrentPeriod(ctx, type, currCompany);
		if(currPeriod != null){
			Date beginDate = currPeriod.getBeginDate();
			if(beginDate != null){
				if(beginDate.compareTo(billDate) > 0){
					return beginDate;
				}
			}
		}
		}catch(Exception e){
			throw new BOSException(e);
		}
		// 默认返回原日期
		return billDate;
	}
	
	/**
	 * 获取 指定单据的botp ID列表
	 * @param ctx
	 * @param srcBosType
	 * @param isEffected
	 * @return
	 * @throws BOSException 
	 */
	public List<String> getBillBotMappings(Context ctx, String srcBosType,DefineSysEnum definesysEnum, boolean isEffected) throws BOSException{
		ArrayList<String> result = new ArrayList<String>();
		
		StringBuilder sb = new StringBuilder();
		sb.append("select t.fid from t_bot_mapping t inner join t_bot_extMapping te on t.fextMappingID = te.fid where t.fdefinesys=");
		sb.append(definesysEnum.getValue());
		sb.append(" and t.fsrcentityname='");
		sb.append(srcBosType);
		sb.append("' and te.fiseffected=");
		if(isEffected){
			sb.append("1");
		}else{
			sb.append("0");
		}
		
		sb.append(" order by t.fname ");
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			while(rs.next()){
				String fid = rs.getString(1);
				result.add(fid);
			}
		}catch(Exception e){
			throw new BOSException(e);
		}
		
		
		
		return result;
		
	}
	
	
	/**
	 * 清理无效的凭证关联信息
	 * @param ctx
	 * @param srcBillID
	 * @param srcEntityID
	 * @throws BOSException 
	 */
	public static void clearInvalidVoucherRelInfos(Context ctx,String srcBillID,String srcEntityID) throws BOSException{
		StringBuilder clearSql = new StringBuilder();
		clearSql.append("delete from t_bot_relation where fid in (select t.fid from t_bot_relation t left join t_gl_voucher tg  on t.fdestobjectid=tg.fid   where t.fbotmappingid='手动保存' and t.fdestentityid='2652E01E' and t.fsrcobjectid='");
		clearSql.append(srcBillID);
		clearSql.append("' and t.fsrcentityid='");
		clearSql.append(srcEntityID);
		clearSql.append("' and tg.fnumber is  null) ");
		DbUtil.execute(ctx, clearSql.toString());
		
	}
	
	
	
	/**
	 * 获取 检验报告 对应采购入库单  单价
	 * @param ctx
	 * @param fid 检验报告id
	 * @return
	 * @throws BOSException 
	 * @throws SQLException 
	 */
	public static BigDecimal getPurbillPrice(Context ctx, String fid) throws BOSException, SQLException {
		StringBuilder sb = new StringBuilder();

		sb.append("select t.fdestobjectid from t_bot_relation t where t.fdestentityid='783061E3' and  t.fsrcobjectid='");
		sb.append(fid);
		sb.append("'");
		IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
		if(rs.next()){
			String purId = rs.getString(1);
			sb = new StringBuilder();
			sb.append("select te.ftaxprice from t_im_purinwarehsentry te inner join t_im_purinwarehsbill t  on te.fparentid = t.fid ");
			sb.append(" where t.fid = '");
			sb.append(purId);
			sb.append("'");
			
			rs = DbUtil.executeQuery(ctx, sb.toString());
			if(rs.next()){
				BigDecimal price = rs.getBigDecimal(1);
				return price;
			}
		}
		return null;
	}
	
	/**
	 * 验证某个单据是否存在下游单据   某个单据  某个botpID 
	 * @param ctx
	 * @param botpID  
	 * @param srcBosType
	 * 
	 * @param srcBillId
	 * @return
	 * @throws BOSException 
	 */
	public static boolean botpExistDestBill(Context ctx,String botpID, String srcBillId) throws BOSException{
		StringBuilder sb = new StringBuilder();
		sb.append("select t.fid from t_bot_relation t where  fsrcobjectid='");
		sb.append(srcBillId);
		sb.append("' and fbotmappingid='");
		sb.append(botpID);
		sb.append("'");
		
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			if(rs.next()){
				return true;
			}
		}catch(Exception e){
			throw new BOSException(e);
		}
		
		return false;
	}
	
	/**
	 * 获取 指定原始单据和目标单据的botp ID列表
	 * @param ctx
	 * @param srcBosType
	 * @param isEffected
	 * @return
	 * @throws BOSException 
	 */
	public List<String> getBillBotMappings(Context ctx, String srcBosType,String destBosType,DefineSysEnum definesysEnum, boolean isEffected) throws BOSException{
		ArrayList<String> result = new ArrayList<String>();
		
		StringBuilder sb = new StringBuilder();
		sb.append("select t.fid from t_bot_mapping t inner join t_bot_extMapping te on t.fextMappingID = te.fid where t.fdefinesys=");
		sb.append(definesysEnum.getValue());
		sb.append(" and t.fsrcentityname='");
		sb.append(srcBosType);
		sb.append("' and t.fdestentityname='");
		sb.append(destBosType);
		sb.append("' and te.fiseffected=");
		if(isEffected){
			sb.append("1");
		}else{
			sb.append("0");
		}
		
		sb.append(" order by t.fname ");
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			while(rs.next()){
				String fid = rs.getString(1);
				result.add(fid);
			}
		}catch(Exception e){
			throw new BOSException(e);
		}
		
		
		
		return result;
		
	}
	
	
	


	   public static MaterialInventoryInfo _getInventoryInfo(Context ctx, String matid, String ouid)
	     throws BOSException
	   {
	     EntityViewInfo viewInfo = new EntityViewInfo();
	     FilterInfo filter = new FilterInfo();

	     filter.getFilterItems().add(new FilterItemInfo("material.id", matid, CompareType.EQUALS));
	     filter.getFilterItems().add(new FilterItemInfo("orgUnit.id", ouid, CompareType.EQUALS));
	     
	     viewInfo.setFilter(filter);
	     viewInfo.getSelector().add(new SelectorItemInfo("*"));
	     viewInfo.getSelector().add(new SelectorItemInfo("unit.name"));
	     viewInfo.getSelector().add(new SelectorItemInfo("unit.number"));
	     viewInfo.getSelector().add(new SelectorItemInfo("defaultWarehouse.name"));
	     viewInfo.getSelector().add(new SelectorItemInfo("defaultWarehouse.number"));
	     viewInfo.getSelector().add(new SelectorItemInfo("defaultWarehouse.hasLocation"));
	     viewInfo.getSelector().add(new SelectorItemInfo("defaultWarehouse.whman.id"));
	     viewInfo.getSelector().add(new SelectorItemInfo("defaultWarehouse.whman.number"));
	     viewInfo.getSelector().add(new SelectorItemInfo("defaultWarehouse.whman.name"));
	     getInventorySelectors(viewInfo.getSelector());
	 
	     MaterialInventoryCollection con = MaterialInventoryFactory.getLocalInstance(ctx).getMaterialInventoryCollection(viewInfo);
	 
	     if ((con != null) && (con.size() >= 1))
	     {
	       for (int i = 0; i < con.size(); ++i)
	       {
	         MaterialInventoryInfo info = con.get(i);
	         if (info.getOrgUnit().getId().toString().equals(ouid))
	         {
	           return info;
	         }
	       }
	       return con.get(0);
	     }
	 
	     MaterialInventoryInfo info = null;
	 
	     return info;
	   }
	

	   private static SelectorItemCollection getInventorySelectors(SelectorItemCollection sic)
	   {
	     sic.add(new SelectorItemInfo("id"));
	     sic.add(new SelectorItemInfo("material.longNumber"));
	     sic.add(new SelectorItemInfo("material.id"));
	     sic.add(new SelectorItemInfo("material.name"));
	     sic.add(new SelectorItemInfo("material.number"));
	     sic.add(new SelectorItemInfo("material.shortName"));
	     sic.add(new SelectorItemInfo("orgUnit.id"));
	     sic.add(new SelectorItemInfo("orgUnit.name"));
	     sic.add(new SelectorItemInfo("orgUnit.number"));
	     sic.add(new SelectorItemInfo("effectedStatus"));
	     sic.add(new SelectorItemInfo("freezeOrgUnit.name"));
	     sic.add(new SelectorItemInfo("status"));
	     sic.add(new SelectorItemInfo("creator.name"));
	     sic.add(new SelectorItemInfo("lastUpdateUser.name"));
	     sic.add(new SelectorItemInfo("createTime"));
	     sic.add(new SelectorItemInfo("lastUpdateTime"));
	 
	     sic.add(new SelectorItemInfo("unit.id"));
	     sic.add(new SelectorItemInfo("unit.number"));
	     sic.add(new SelectorItemInfo("unit.name"));
	     sic.add(new SelectorItemInfo("isControl"));
	     sic.add(new SelectorItemInfo("qtySafety"));
	     sic.add(new SelectorItemInfo("qtyMin"));
	     sic.add(new SelectorItemInfo("qtyMax"));
	     sic.add(new SelectorItemInfo("daysBottom"));
	     sic.add(new SelectorItemInfo("daysTop"));
	     sic.add(new SelectorItemInfo("daysTurnover"));
	     sic.add(new SelectorItemInfo("isNegative"));
	     sic.add(new SelectorItemInfo("isBatchNo"));
	     sic.add(new SelectorItemInfo("isSequenceNo"));
	     sic.add(new SelectorItemInfo("isLotNumber"));
	     sic.add(new SelectorItemInfo("isBarcode"));
	     sic.add(new SelectorItemInfo("qtyMinPackage"));
	     sic.add(new SelectorItemInfo("abcType"));
	     sic.add(new SelectorItemInfo("isCompages"));
	     sic.add(new SelectorItemInfo("issuePriorityMode"));
	 
	     sic.add(new SelectorItemInfo("isPeriodValid"));
	     sic.add(new SelectorItemInfo("periodValid"));
	     sic.add(new SelectorItemInfo("periodValidUnit"));
	     sic.add(new SelectorItemInfo("inWarehsAhead"));
	     sic.add(new SelectorItemInfo("outWarehsAhead"));
	     sic.add(new SelectorItemInfo("prepWarnAhead"));
	     sic.add(new SelectorItemInfo("aheadUnit"));
	 
	     return sic;
	   }
	
	   /**
		 * 
		 * @Title: updateModelStatus 
		 * @Description: 更新单据状态2
		 * @param @param model
		 * @param @param status    
		 * @return void    返回类型 
		 * @throws BOSException 
		 * @throws
		 */ 
		public static void updateModelStatus(Context ctx, String tableName, String fid,com.kingdee.eas.custom.salediscount.billStatus status) throws BOSException{
			StringBuilder sb = new StringBuilder("/*dialect*/");
			sb.append("update ");
			sb.append(tableName);
			sb.append(" set CFStatus ='");
			sb.append(status.getValue());
			sb.append("' ");
			SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			if(status.equals(com.kingdee.eas.custom.salediscount.billStatus.audit)){
				sb.append(" , fauditorid = '");
				sb.append(ctx.getCaller().toString());
				sb.append("' , cfaudittime=to_date('");
				sb.append(sFormat.format(new Date()));
				sb.append("','yyyy-mm-dd hh24:mi:ss') ");
			}else if(status.equals(com.kingdee.eas.custom.salediscount.billStatus.save)){
				sb.append(" , fauditorid = '");
				sb.append("' , cfaudittime=null ");
			}
			sb.append(" where fid='");
			sb.append(fid);
			sb.append("'");
			DbUtil.execute(ctx, sb.toString());
		}
}
