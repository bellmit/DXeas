package com.kingdee.eas.wlhlcomm;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.IMetaDataLoader;
import com.kingdee.bos.metadata.MetaDataLoaderFactory;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.bos.metadata.bot.BOTMappingFactory;
import com.kingdee.bos.metadata.bot.DefineSysEnum;
import com.kingdee.bos.metadata.bot.IBOTMapping;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.botp.BOTPException;
import com.kingdee.eas.base.btp.BTPException;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.BTPTransformResult;
import com.kingdee.eas.base.btp.IBTPManager;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.scm.im.inv.BizDirectionEnum;
import com.kingdee.eas.basedata.scm.im.inv.InvUpdateTypeInfo;
import com.kingdee.eas.basedata.scm.im.inv.RecIssueTypeInfo;
import com.kingdee.eas.basedata.scm.im.inv.TransactionInvUpdateTypeCollection;
import com.kingdee.eas.farm.breed.comm.ExecBotpResultInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.ISCMBillBase;
import com.kingdee.eas.scm.im.inv.InvBillBaseEntryInfo;
import com.kingdee.eas.scm.im.inv.InvBillBaseInfo;
import com.kingdee.eas.scm.im.inv.InvCommonUtils;
import com.kingdee.eas.util.StringUtil;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * botp 后台通用方法
 * @author USER
 *
 */
public class BotpAppCommon {

	 
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
	public  IObjectValue transformForBotp(Context ctx,
			String[] idList, 
			String[] entryNames,
			List entryIDs, 
			SelectorItemCollection botpSelectors,
			String destBillTypeBOSType, 
			IObjectPK botpPK, 
			String srcBillType,
			ExecBotpResultInfo  resultInfo )
			throws BOSException, BTPException{
		
		
		IObjectValue destBillInfo = null; // destBillBosType：目标单据BOS类型
		ISCMBillBase iInstace = null;// 库存业务单据对象接口
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
			
			resultInfo.setDestEntityName(eo.getAlias());
			resultInfo.setDestEntityBostype(destBillTypeBOSType);
			
			
			Class cls = Class.forName(eo.getBusinessImplFactory());
			Method mtd = cls.getMethod("getLocalInstance", new Class[] { com.kingdee.bos.Context.class });
			ICoreBase iCoreBase = (ICoreBase) mtd.invoke(cls, new Object[] { ctx });
			iInstace = (ISCMBillBase) iCoreBase;
			
			
			// SaleIssueBillFactory.getLocalInstance(ctx).audit(IObjectPK)
			// Method submitMtd=iCoreBase.getClass().getMethod("submit", new
			// Class[]{com.kingdee.eas.framework.CoreBillBaseInfo.class});
			// Method auditMtd=iCoreBase.getClass().getMethod("audit", new
			// Class[]{com.kingdee.bos.dao.IObjectPK.class});
			// Method unAuditMtd=iCoreBase.getClass().getMethod("unAudit", new
			// Class[]{com.kingdee.bos.dao.IObjectPK.class});
			// ************************************
			
			// 调用BOTP接口自动生成单据--入库单
			btp = BTPManagerFactory.getLocalInstance(ctx);
			// [注释]获取BTP的本地接口
//			result = btp.transform(srcBill, botMappingInfo);
			result=  btp.transformForBotp(idList, entryNames, entryIDs, botpSelectors, destBillTypeBOSType, botpPK, srcBillType);
			 // 获取结果 单据编码
			 
			// [注释] result：为转换成功生的目标单据
			// objectValue：源单据的值对象
			IObjectCollection destBillColl =  result.getBills();
			
			
			for(int m = 0; m < destBillColl.size(); m++){
				destBillInfo = destBillColl.getObject(m);
				
				
				destPK = new ObjectUuidPK(((CoreBaseInfo) destBillInfo).getId());// 目标单据Id
	
				/*
				 * String number = null; while (true) { number = getAutoNumber(ctx,
				 * companyID, destBillInfo); if (!checkNumberIsExist(ctx, companyID,
				 * number, "t_im_saleIssuebill")) { break; } } ((SaleIssueBillInfo)
				 * destBillInfo).setNumber(number); iInstace.save(destPK,
				 * (CoreBaseInfo) destBillInfo);
				 */
				// [注释] 保存单据的关联系统
				// 提交 和审核
					if(destBillInfo instanceof InvBillBaseInfo){
						if(((InvBillBaseInfo) destBillInfo).getTransactionType()!=null) {
							FilterInfo filterInfo = new FilterInfo();
							filterInfo.getFilterItems().add(
									new FilterItemInfo("transactionType.id", ((InvBillBaseInfo) destBillInfo).getTransactionType()
											.getId().toString(), CompareType.EQUALS));
							String prefix = "invUpdateType.";
							filterInfo.getFilterItems().add(
									new FilterItemInfo(prefix + "status", Integer.valueOf(1), CompareType.EQUALS));
							EntityViewInfo ev = new EntityViewInfo();
							// filterInfo.mergeFilter(buildInvUpdateTypeFilterInfo(entry,
							// isF7), "AND");
							filterInfo.setMaskString("#0 AND #1");
							ev.setFilter(filterInfo);
			
							TransactionInvUpdateTypeCollection updateTypeCol = InvCommonUtils.getTransactionInvUpdateTypeCol(ctx,
									ev);
							InvUpdateTypeInfo updateType = null;
							if (updateTypeCol != null && updateTypeCol.size() > 0) {
								updateType = updateTypeCol.get(0).getInvUpdateType();
							}
							for (int i = 0; i < ((AbstractObjectCollection) destBillInfo.get("entry")).size(); i++) {
								AbstractObjectCollection sd = (AbstractObjectCollection) destBillInfo.get("entry");
								// InvBillBaseEntryInfo d =
								// (InvBillBaseEntryInfo)sd.getObject(i);
								((InvBillBaseEntryInfo) sd.getObject(i)).setInvUpdateType(updateType);
							}
							RecIssueTypeInfo riType = ((InvBillBaseInfo)destBillInfo).getTransactionType().getRiType();
							if(riType.getBizDirection()==null) {
								((InvBillBaseInfo)destBillInfo).getTransactionType().getRiType().setBizDirection(BizDirectionEnum.normal);
							};
						}
					}
	//				CoreBaseCollection destCol.add((CoreBaseInfo) destBillInfo);
					numSb.append(destBillInfo.getString("number")).append(";");
					 status = "保存";
					iInstace.save((CoreBaseInfo) destBillInfo);
					
					iInstace.submit((CoreBaseInfo) destBillInfo);
					status = "提交";
					destBillInfo=iInstace.getValue(destPK);//重新加载单据  单据状态不更新
					if (destBillInfo.get("baseStatus").equals(BillBaseStatusEnum.SUBMITED.getValue()))
					{
						iInstace.audit(destPK);
						
					}
					
					status = "审核";
					
					statusSb.append(status).append(";");
					resultInfo.setDestBillStatus(statusSb.toString());
					resultInfo.setDestObjectNumber(numSb.toString());
					status = "";
				}
			   
				// 保存关联关系
//				btp.submitRelations(result.getBOTRelationCollection());
				
				return destBillInfo;
			
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
			resultInfo.setDestBillStatus(statusSb.toString());
			resultInfo.setDestObjectNumber(numSb.toString());
			resultInfo.setError(e1.getMessage());
			status = "";
			
			throw new BOSException(e1.getMessage());
		}
		
		
		
		
	}
	/**
	 * 添加关联关系 
	 * @param ctx 
	 * @param srcBostype 
	 * @param srcObjectID
	 * @param destBostype
	 * @param destObjectID
	 * @throws BOSException  
	 */
	public static void addRelations(Context ctx, String srcBostype,String srcObjectID,String destBostype,String destObjectID) throws BOSException{
		String userName = ctx.getUserName();
		// 如果不存在 才添加
		if(!checkRelationsExist(ctx,srcBostype,srcObjectID,destBostype,destObjectID)){
			StringBuilder sql = new StringBuilder("/*dialect*/ insert into t_bot_relation ");
			sql.append("(fid,FSrcEntityID,FSrcObjectID,FDestEntityID,FDestObjectID,FDate,FOperatorID,FisEffected) values (");
			sql.append("'"+BOSUuid.create("59302EC6")+"','");
			sql.append(srcBostype);
			sql.append("','");
			sql.append(srcObjectID);
			sql.append("','");
			sql.append(destBostype);
			sql.append("','");
			sql.append(destObjectID);
			sql.append("',sysdate,'");
			sql.append(userName);
			sql.append("',1)");			
			DbUtil.execute(ctx, sql.toString());
		}
	}
	/**
	 * 添加关联关系 
	 * @param ctx 
	 * @param srcBostype 
	 * @param srcObjectID
	 * @param destBostype
	 * @param destObjectID
	 * @throws BOSException 
	 */
	public static boolean  checkRelationsExist(Context ctx, String srcBostype,String srcObjectID,String destBostype,String destObjectID) throws BOSException{
		StringBuilder sql = new StringBuilder("select 1 from t_bot_relation where ");
		sql.append(" FSrcEntityID='");
		sql.append(srcBostype);
		sql.append("' and FSrcObjectID ='");
		sql.append(srcObjectID);
		sql.append("' and FDestEntityID = '");
		sql.append(destBostype);
		sql.append("' and FDestObjectID = '");
		sql.append(destObjectID);
		sql.append("' ");
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		}catch(SQLException sqle){
			throw new BOSException(sqle);
		}
	}
	
	/**
	 * 删除关联关系 
	 * @param ctx 
	 * @param srcBostype 
	 * @param srcObjectID
	 * @param destBostype
	 * @param destObjectID
	 * @throws BOSException 
	 */
	public static void removeRelations(Context ctx, String srcBostype,String srcObjectID,String destBostype,String destObjectID) throws BOSException{
		
		StringBuilder sql = new StringBuilder("delete from t_bot_relation where ");
		sql.append(" FSrcEntityID='");
		sql.append(srcBostype);
		sql.append("' ");
		if(StringUtils.isNotBlank(srcObjectID)){
			sql.append("' and FSrcObjectID ='");
			sql.append(srcObjectID);
			sql.append("' ");
		}
		sql.append(" and FDestEntityID = '");
		sql.append(destBostype);
		sql.append("' ");
		if(StringUtils.isNotBlank(destObjectID)){
			sql.append(" and FDestObjectID = '");
			sql.append(destObjectID);
			sql.append("' ");
		}
		
		DbUtil.execute(ctx, sql.toString());
	}
	
	/**
	 * 查询关联关系对应源单据与目标单据的ID 
	 * @param ctx 
	 * @param srcBostype 
	 * @param srcObjectID
	 * @param destBostype
	 * @param destObjectID
	 * @throws BOSException 
	 */
	public static Map<String, HashSet<String>> getBillIDsByRelation(Context ctx, String srcBostype,String srcObjectID,String destBostype,String destObjectID) throws BOSException{
		Map<String, HashSet<String>> result=new HashMap<String, HashSet<String>>();
		HashSet<String> srcSet=new HashSet<String>();
		HashSet<String> destSet=new HashSet<String>();
		StringBuilder sql = new StringBuilder("select * from t_bot_relation where ");
		sql.append(" FSrcEntityID='");
		sql.append(srcBostype);
		sql.append("' ");
		if(StringUtils.isNotBlank(srcObjectID)){
			sql.append(" and FSrcObjectID ='");
			sql.append(srcObjectID);
			sql.append("' ");
		}
		sql.append(" and FDestEntityID = '");
		sql.append(destBostype);
		sql.append("' ");
		if(StringUtils.isNotBlank(destObjectID)){
			sql.append(" and FDestObjectID = '");
			sql.append(destObjectID);
			sql.append("' ");
		}
		
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		try {
			while(rs.next()){
				srcSet.add(rs.getString("FSrcObjectID"));
				destSet.add(rs.getString("FDestObjectID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result.put("srcBillIDs",srcSet);
		result.put("destBillIDs",destSet);
		return result;
	}
}
 