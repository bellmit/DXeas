package com.kingdee.eas.farm.stocking.common;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.IMetaDataLoader;
import com.kingdee.bos.metadata.MetaDataLoaderFactory;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.bos.metadata.bot.BOTMappingFactory;
import com.kingdee.bos.metadata.bot.BOTMappingInfo;
import com.kingdee.bos.metadata.bot.DefineSysEnum;
import com.kingdee.bos.metadata.bot.IBOTMapping;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.eas.base.botp.BOTPException;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.BTPTransformResult;
import com.kingdee.eas.base.btp.IBTPManager;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.fm.common.FMIsqlFacadeFactory;
import com.kingdee.eas.fm.common.IFMIsqlFacade;
import com.kingdee.eas.framework.BillBaseException;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillBaseInfo;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.ISCMBillBase;
import com.kingdee.eas.scm.common.SCMBillBaseInfo;
import com.kingdee.eas.scm.im.inv.IInvBillBase;
import com.kingdee.eas.scm.im.inv.InvBillBaseInfo;
import com.kingdee.eas.util.StringUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class BotpCommUtils {
	public static final String MaterialRequest_BOSTYPE="BFBCAD51";//领料申请单BOSTYPE
	public static final String MaterialReq_BOSTYPE="500AB75E";//领料出库单BOSTYPE
	public static final String ManufactureRec_BOSTYPE="FA1292B4";//生产入库单BOSTYPE
	public static final String ReceiveBill_BOSTYPE="FA44FD5B";//收款单
	public static final String PaymentBill_BOSTYPE="40284E81";//付款单
	public static final String SaleIssueBill_BOSTYPE="CC3E933B";//销售出库单
	public static final String PurInwarehouse_BOSTYPE="783061E3";//采购入库
	public static final String TransBill_BOSTYPE="5C2A1F0C";//调拨订单
	
	public static final HashMap<String,String> typeValueMap=new HashMap<String, String>(){{put(MaterialRequest_BOSTYPE,"领料申请单");put(MaterialReq_BOSTYPE,"领料出库单");put(ManufactureRec_BOSTYPE,"生产入库单");}};
	private Context ctx;
	
	public static BotpCommUtils getInstance(Context ctx) {
		return new BotpCommUtils(ctx);
	}
	public BotpCommUtils(Context ctx) {
		this.ctx=ctx;
	}
	/**
	 * 检查是否存在下游单据
	 * @param ctx
	 * @param pk
	 * @param coreBillInfo
	 * @throws BOSException
	 * @throws EASBizException
	 */
	public void isExitBTPBill(Context ctx, IObjectPK pk, CoreBillBaseInfo coreBillInfo,String destBillBosType) throws BOSException,EASBizException {
		IBTPManager iBTPManager;
		if(ctx!=null)
			iBTPManager= BTPManagerFactory.getLocalInstance(ctx);
		else 
			iBTPManager= BTPManagerFactory.getRemoteInstance();
		/*if (!(iBTPManager.ifHaveDestBills(pk.toString()))) {
			try {
				if (coreBillInfo instanceof CoreBillBaseInfo) {
					iBTPManager.removeAllSRCRelation(coreBillInfo);
				}
			} catch (BTPException ex) {
				throw new BTPException(BTPException.RELATIONDELETEERROR, ex);
			}
		} else {
			throw new BillBaseException(new NumericExceptionSubItem("001","单据存在下游单据"));
		}*/
		StringBuffer sql=new StringBuffer();
		sql.append(" select fid from t_bot_relation ");
		sql.append(" where FSrcObjectID='").append(coreBillInfo.getString("id")).append("'");
		if(StringUtils.isNotEmpty(destBillBosType)) {
			sql.append(" and FDestEntityID='").append(destBillBosType).append("'");
		}
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());//MaterialRequest_BOSTYPE});,new Object[]{coreBillInfo.getString("id"),destBillBosType}
		try {
			if(rs.next()) {
				throw new BillBaseException(new NumericExceptionSubItem("001","单据存在下游单据"+(StringUtils.isNotEmpty(destBillBosType)?typeValueMap.get(destBillBosType):null))); 
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

	//反写源单据对应属性(用于二开反写规则不生效的情况),String类型需用'value'形式
	public static void updateSrcPorpert(Context ctx,BOSObjectType srcType,BOSObjectType desType,String desID,Map changeKeyValue) {
		try {
		IFMIsqlFacade iFMIsqlFacade = null;
		if(ctx==null){
			iFMIsqlFacade=FMIsqlFacadeFactory.getRemoteInstance();
		}else{
			iFMIsqlFacade=FMIsqlFacadeFactory.getLocalInstance(ctx);
		}
		String desTable = iFMIsqlFacade.getTableNameByBosType(desType);
		String srcTable = iFMIsqlFacade.getTableNameByBosType(srcType);
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" /*dialect*/select  distinct t1.fid from "+srcTable+" t1 ")
		.append(" inner join T_BOT_Relation t2 on t1.fid=t2.FSrcObjectID ")
		.append(" inner join "+desTable+" t3 on t2.FDestObjectID=t3.fid ")
		.append(" where t3.fid='"+desID+"' ");
		IRowSet rs=null;
			if(ctx==null){
				rs=SQLExecutorFactory.getRemoteInstance(sqlBuf.toString()).executeSQL();
			}else{
				rs=DbUtil.executeQuery(ctx, sqlBuf.toString());
			}
			while(rs.next()){
				String srcID=rs.getString("fid");
				StringBuffer updateSql = new StringBuffer();
				updateSql.append(" update "+srcTable+"  set  ");
				Iterator iterator = changeKeyValue.entrySet().iterator();
				Boolean isFirst=true;
				while (iterator.hasNext()) {
					Map.Entry next = (Entry) iterator.next();
					String changeProperty = (String) next.getKey();
					String changeValue =(String) next.getValue();
					if(isFirst){
						updateSql.append(changeProperty+"="+changeValue);
					}else{
						updateSql.append(","+changeProperty+"="+changeValue);
					}
					isFirst=false;
				}
				updateSql.append(" where fid='").append(srcID).append("'");
				if(ctx==null){
					CommFacadeFactory.getRemoteInstance().excuteUpdateSql(updateSql.toString());
				}else{
					DbUtil.executeQuery(ctx, updateSql.toString());
				}
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	/**
	 * 通过number 获取Botp info
	 */
	public static BOTMappingInfo getBotpInfoByNumber(Context ctx,String number) {
		try {
			EntityViewInfo ev=new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("number",number,CompareType.EQUALS));
			ev.setFilter(filter);
			BOTMappingCollection col = BOTMappingFactory.getLocalInstance(ctx).getBOTMappingCollection(ev);
			if(col!=null&&col.size()>0) {
				return col.get(0);
			}
		}catch(Exception err){
			err.printStackTrace();
		}
		return null;
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
	public BOTMappingCollection getAllCanUsedBotps(Context ctx,OrgUnitInfo orgUnit,String srcBillType, String destBillType ,String[] srcBillIDs, String[] entryNames,List entriesKey, SelectorItemCollection botpSelectors) throws BOTPException, BOSException{
		if(botpSelectors == null){
			botpSelectors = new SelectorItemCollection();
		}
		
		Map<String,EntityObjectInfo> destBosTypes = null;
		try {
			destBosTypes=getDestBostype(ctx,srcBillType);
		}catch(Exception e) {
			
		}
		
		BOTMappingCollection botColl = new BOTMappingCollection();
		
//		OrgUnitInfo orgUnit = ContextUtil.getCurrentCtrlUnit(ctx);
		if(destBosTypes==null) 
			return botColl;
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
				
				if(destBillType!=null&&!destBillType.equals(destBOSType)) {
					continue;
				}
				
				BOTMappingCollection botMappingCols = botMapping.getMappingCollectionForSelectUseRuleFilter(srcBillType,destBOSType, DefineSysEnum.BTP, transmitContext, srcBillIDs, entryNames, entriesKey, botpSelectors);
				// 添加到结果集中
				botColl.addCollection(botMappingCols);
			}
		}
		return botColl;
		
	}

	/**
	 * 生成下游单据
	 * add by sunsiyu
	 * @throws BOSException
	 * @throws EASBizException 
	 */
	public CoreBillBaseInfo createToOrderBill(Context ctx, CoreBillBaseInfo info, String orderBillBosType,BOTMappingInfo botmappinginfo) throws BOSException, EASBizException {
		IObjectValue destBillInfo = null; // destBillBosType：目标单据BOS类型
		ObjectUuidPK destPK = null;
		IBTPManager btp = null;
		BTPTransformResult result = null;

		try {
			// ***********************************
			IMetaDataLoader loader = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
			loader = MetaDataLoaderFactory.getRemoteMetaDataLoader();
			EntityObjectInfo eo = loader.getEntity(BOSObjectType.create(orderBillBosType));
			if (eo == null) {
				return null;
			}
			Class cls = Class.forName(eo.getBusinessImplFactory());
			Method mtd = cls.getMethod("getLocalInstance", new Class[] { com.kingdee.bos.Context.class });
			ICoreBillBase iCoreBase = (ICoreBillBase) mtd.invoke(cls, new Object[] { ctx });

			// 调用BOTP接口自动生成单据--入库单
			btp = BTPManagerFactory.getLocalInstance(ctx);
			// [注释]获取BTP的本地接口
			if(botmappinginfo==null)
				result = btp.transform(info, orderBillBosType);
			else 
				result = btp.transform(info, botmappinginfo);
			// [注释] result：为转换成功生的目标单据
			
			// [注释] 保存单据的关联系统
			try {// 提交 和审核
				destBillInfo=result.getBills().getObject(0);
				btp.submitRelations(result.getBOTRelationCollection());
				iCoreBase.save((CoreBaseInfo) destBillInfo);
				return (CoreBillBaseInfo) destBillInfo;
			} catch (Exception e2) {// botp 失败 清除关联关系
				try {
					if (destBillInfo != null)
						btp.removeAllRelation((CoreBillBaseInfo) destBillInfo);
				} catch (Exception e3) {
					e3.printStackTrace();
				}
				throw new EASBizException(new NumericExceptionSubItem("001",e2.getMessage()));
			}
		} catch (Exception e1) {// botp 失败 清除关联关系
			try {
				if (destBillInfo != null)
					btp.removeAllRelation((CoreBillBaseInfo) destBillInfo);
			} catch (Exception e3) {
				e3.printStackTrace();
			}
			throw new EASBizException(new NumericExceptionSubItem("001",e1.getMessage()));
		}
	}
	
	
	
	
	
	/**
	 * 生成供应链单据
	 * 
	 * @throws BOSException
	 */
	public SCMBillBaseInfo createToSCMBill(Context ctx, CoreBillBaseInfo info, String orderBillBosType,BOTMappingInfo botmappinginfo) throws BOSException {
		IObjectValue destBillInfo = null; // destBillBosType：目标单据BOS类型
		ISCMBillBase iInstace = null;// 库存业务单据对象接口
		ObjectUuidPK destPK = null;
		IBTPManager btp = null;
		BTPTransformResult result = null;

		try {
			// ***********************************
			IMetaDataLoader loader = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
			loader = MetaDataLoaderFactory.getRemoteMetaDataLoader();
			EntityObjectInfo eo = loader.getEntity(BOSObjectType.create(orderBillBosType));
			if (eo == null) {
				return null;
			}
			Class cls = Class.forName(eo.getBusinessImplFactory());
			Method mtd = cls.getMethod("getLocalInstance", new Class[] { com.kingdee.bos.Context.class });
			ICoreBillBase iCoreBase = (ICoreBillBase) mtd.invoke(cls, new Object[] { ctx });
			iInstace = (ISCMBillBase) iCoreBase;

			// 调用BOTP接口自动生成单据--入库单
			btp = BTPManagerFactory.getLocalInstance(ctx);
			// [注释]获取BTP的本地接口
			if(botmappinginfo==null)
				result = btp.transform(info, orderBillBosType);
			else 
				result = btp.transform(info, botmappinginfo);
			// [注释] result：为转换成功生的目标单据
			
			// [注释] 保存单据的关联系统
			try {// 提交 和审核

				// objectValue：源单据的值对象
				for(int index=0;index<result.getBills().size();index++) {
//					if(((SCMBillBaseInfo)destBillInfo).getEntries().size()>0) {
						destBillInfo = result.getBills().getObject(index);
						
						//出入库单据结算到下个月
						String storageOrgUnitID=null;
						if(destBillInfo.getObjectValue("storageOrgUnit")!=null) {
							storageOrgUnitID=destBillInfo.getObjectValue("storageOrgUnit").getString("id");
						}
						destBillInfo.setDate("bizDate", getEnzymePeriodDate(ctx, storageOrgUnitID));
						//
						iInstace.save((CoreBaseInfo) destBillInfo);
				}
				btp.submitRelations(result.getBOTRelationCollection());
				return (SCMBillBaseInfo) destBillInfo;
			} catch (Exception e2) {
				throw new BOSException(e2);
			}
		} catch (Exception e1) {// botp 失败 删除单据
			try {
				if (((SCMBillBaseInfo) destBillInfo).getBaseStatus().equals(com.kingdee.eas.scm.common.BillBaseStatusEnum.AUDITED))
					iInstace.unAudit(destPK);// 反审核
				iInstace.delete(destPK);// 删除
			} catch (Exception e3) {
				e3.printStackTrace();
			}
			try {
				if (destBillInfo != null)
					btp.removeAllRelation((CoreBillBaseInfo) destBillInfo);
			} catch (Exception e3) {
				e3.printStackTrace();
			}
			throw new BOSException(e1.getMessage());
		}
	}
	
	/**
	 * 生成供应链单据
	 * 
	 * @throws BOSException
	 */
	public CoreBillBaseInfo createToBill(Context ctx, CoreBillBaseInfo info, String orderBillBosType,BOTMappingInfo botmappinginfo) throws BOSException {
		IObjectValue destBillInfo = null; // destBillBosType：目标单据BOS类型
		ObjectUuidPK destPK = null;
		IBTPManager btp = null;
		BTPTransformResult result = null;

		try {
			// ***********************************
			IMetaDataLoader loader = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
			loader = MetaDataLoaderFactory.getRemoteMetaDataLoader();
			EntityObjectInfo eo = loader.getEntity(BOSObjectType.create(orderBillBosType));
			if (eo == null) {
				return null;
			}
			Class cls = Class.forName(eo.getBusinessImplFactory());
			Method mtd = cls.getMethod("getLocalInstance", new Class[] { com.kingdee.bos.Context.class });
			ICoreBillBase iCoreBase = (ICoreBillBase) mtd.invoke(cls, new Object[] { ctx });

			// 调用BOTP接口自动生成单据--入库单
			btp = BTPManagerFactory.getLocalInstance(ctx);
			// [注释]获取BTP的本地接口
			if(botmappinginfo==null)
				result = btp.transform(info, orderBillBosType);
			else 
				result = btp.transform(info, botmappinginfo);
			// [注释] result：为转换成功生的目标单据
			
			// [注释] 保存单据的关联系统
			try {// 提交 和审核
				destBillInfo=result.getBills().getObject(0);
				btp.submitRelations(result.getBOTRelationCollection());
				return (CoreBillBaseInfo) destBillInfo;
			} catch (Exception e2) {
				throw new BOSException(e2);
			}
		} catch (Exception e1) {// botp 失败 删除单据
			throw new BOSException(e1.getMessage());
		}
	}
	
	/**
	 * 获取记账期间日期
	 * @param ctx
	 * @param storageOrgUnit
	 */
	private Date getEnzymePeriodDate(Context ctx,String storageOrgUnitID) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String dateStr=sdf.format(new Date());
		try{
			if(StringUtils.isNotBlank(storageOrgUnitID)) {
				StringBuffer sql=new StringBuffer();
				sql.append(" select CFTargetDate");
				sql.append(" from CT_ENZ_EnzymeBSPE tentry");
				sql.append(" inner join CT_ENZ_EnzymeBaseSetting tmain on tmain.fid=tentry.FParentID");
				sql.append(" where tmain.CFStorageOrgUnitID=?");
				sql.append(" and tentry.CFBeginDate<={d'").append(dateStr).append("'}");
				sql.append(" and tentry.CFEndDate>={d'").append(dateStr).append("'}");
				IRowSet rs = DbUtil.executeQuery(ctx, sql.toString(),new Object[]{storageOrgUnitID});
				if(rs.next()) {
					return rs.getDate("CFTargetDate");
				}
			}
		}catch(Exception err){err.printStackTrace();}
		return new Date();
	}
	
	/**
	 * 生成供应链单据
	 * 
	 * @throws BOSException
	 */
	public  void createToSCMBillByEntrties(Context ctx, String[] idList, String[] entryNames, List entryIDs,
			SelectorItemCollection botpSelectors, String destBillTypeBOSType, IObjectPK botpPK, String srcBillType)
			throws BOSException {
		IObjectValue destBillInfo = null; // destBillBosType：目标单据BOS类型
		ISCMBillBase iInstace = null;// 库存业务单据对象接口
		ObjectUuidPK destPK = null;
		IBTPManager btp = null;
		BTPTransformResult result = null;

		try {
			// ***********************************
			IMetaDataLoader loader = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
			loader = MetaDataLoaderFactory.getRemoteMetaDataLoader();
			EntityObjectInfo eo = loader.getEntity(BOSObjectType.create(destBillTypeBOSType));
			if (eo == null) {
				return;
			}
			Class cls = Class.forName(eo.getBusinessImplFactory());
			Method mtd = cls.getMethod("getLocalInstance", new Class[] { com.kingdee.bos.Context.class });
			ICoreBillBase iCoreBase = (ICoreBillBase) mtd.invoke(cls, new Object[] { ctx });
			iInstace = (ISCMBillBase) iCoreBase;

			// 调用BOTP接口自动生成单据--入库单
			btp = BTPManagerFactory.getLocalInstance(ctx);
			// [注释]获取BTP的本地接口
			// result = btp.transform(info, botmappinginfo);
			result = btp.transformForBotp(idList, entryNames, entryIDs, botpSelectors, destBillTypeBOSType, botpPK, srcBillType);
			// [注释] result：为转换成功生的目标单据
			// objectValue：源单据的值对象
			for (int index = 0; index < result.getBills().size(); index++) {
				// if(((SCMBillBaseInfo)destBillInfo).getEntries().size()>0) {
				destBillInfo = result.getBills().getObject(index);
				iInstace.save((CoreBaseInfo) destBillInfo);
				// }
			}
			// destPK = new ObjectUuidPK(((CoreBaseInfo)
			// destBillInfo).getId());// 目标单据Id

			// [注释] 保存单据的关联系统
			try {// 提交 和审核

				// destBillInfo=iInstace.getValue(destPK);//重新加载单据 单据状态不更新
				/*
				 * if(destBillInfo.get("baseStatus").equals(BillBaseStatusEnum.
				 * SUBMITED.getValue())) iInstace.audit(destPK);
				 */
				btp.submitRelations(result.getBOTRelationCollection());
			} catch (Exception e2) {
				throw new BOSException(e2);
			}
		} catch (Exception e1) {// botp 失败 删除单据
			try {
				if (((SCMBillBaseInfo) destBillInfo).getBaseStatus()
						.equals(com.kingdee.eas.scm.common.BillBaseStatusEnum.AUDITED))
					iInstace.unAudit(destPK);// 反审核
				iInstace.delete(destPK);// 删除
			} catch (Exception e3) {
				e3.printStackTrace();
			}
			try {
				if (destBillInfo != null)
					btp.removeAllRelation((CoreBillBaseInfo) destBillInfo);
			} catch (Exception e3) {
				e3.printStackTrace();
			}
			throw new BOSException(e1.getMessage());
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
		
		HashMap<String, EntityObjectInfo> destEOI = new HashMap<String, EntityObjectInfo>();
		// 后台获得 可生成的目标单据类型
		IBOTMapping iBOTMapping = BOTMappingFactory.getLocalInstance(ctx);

		String targetTypeAndAliasString = iBOTMapping.getTargetBillTypeList(srcBOSType);
		if (StringUtils.isNotBlank(targetTypeAndAliasString)) {
			String[] targetTypeAndAlias = StringUtil.split(targetTypeAndAliasString, "|");

			String targetBillTypeString = targetTypeAndAlias[0];
			String targetAliasString = targetTypeAndAlias[1];

			String[] targetAlias = StringUtil.split(targetAliasString, ",");
			String[] targetBillType = StringUtil.split(targetBillTypeString, ",");
			// 逐个循环 添加目标单据eoi到result
			IMetaDataLoader loader = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
			for (int i = 0; i < targetBillType.length; i++) {
				String targetType = targetBillType[i];
				EntityObjectInfo tempObj = loader.getEntity(BOSObjectType.create(targetType));
				destEOI.put(targetType, tempObj);
			}

		}
		return destEOI;
	}
	/**
	 * 删除BOTP已经生成的单据
	 * @param ctx
	 * @param col
	 */
	public static void deleteBTPBills(Context ctx,CoreBaseCollection col) {
		IInvBillBase iInstace = null;// 库存业务单据对象接口			
		IMetaDataLoader loader = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
		loader = MetaDataLoaderFactory.getRemoteMetaDataLoader();
		InvBillBaseInfo info;
		ObjectUuidPK pk;
		for(int index=0;index<col.size();index++) {
			try{
				info=(InvBillBaseInfo) col.get(index);
				pk=new ObjectUuidPK(info.getId());
				EntityObjectInfo eo = loader.getEntity(BOSObjectType.create(info.getBOSType().toString()));
				if (eo == null) {
					return;
				}
				Class cls = Class.forName(eo.getBusinessImplFactory());
				Method mtd = cls.getMethod("getLocalInstance", new Class[] { com.kingdee.bos.Context.class });
				iInstace = (IInvBillBase) mtd.invoke(cls, new Object[] { ctx });
				info=iInstace.getInvBillBaseInfo(pk);
				if(info.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)) {
					iInstace.unAudit(pk);
				}
				iInstace.delete(pk);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
	}

}
