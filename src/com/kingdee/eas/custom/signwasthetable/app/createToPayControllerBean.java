package com.kingdee.eas.custom.signwasthetable.app;

import org.apache.log4j.Logger;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTIndexColumn;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.kdf.table.foot.KDTFootManager;
import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
import com.kingdee.bos.ctrl.kdf.util.style.ShareStyleAttributes;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.kscript.debug.ObjectValue;
import com.kingdee.bos.metadata.IMetaDataLoader;
import com.kingdee.bos.metadata.MetaDataLoaderFactory;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.bos.metadata.bot.BOTMappingFactory;
import com.kingdee.bos.metadata.bot.BOTMappingInfo;
import com.kingdee.bos.metadata.bot.BOTRelationCollection;
import com.kingdee.bos.metadata.bot.DefineSysEnum;
import com.kingdee.bos.metadata.bot.IBOTMapping;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIException;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.botp.BOTPException;
import com.kingdee.eas.base.btp.BTPException;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.BTPTransformResult;
import com.kingdee.eas.base.btp.IBTPManager;
import com.kingdee.eas.base.form.core.UserDefinedData.client.UserDefinedDataMainUI.intComparator;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.assistant.CurrencyFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.basedata.scm.im.inv.BizDirectionEnum;
import com.kingdee.eas.basedata.scm.im.inv.ITransactionInvUpdateType;
import com.kingdee.eas.basedata.scm.im.inv.InvUpdateTypeInfo;
import com.kingdee.eas.basedata.scm.im.inv.RecIssueTypeInfo;
import com.kingdee.eas.basedata.scm.im.inv.TransactionInvUpdateTypeCollection;
import com.kingdee.eas.basedata.scm.im.inv.TransactionInvUpdateTypeFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.signwasthetable.ContractFactory;
import com.kingdee.eas.custom.signwasthetable.ContractInfo;
import com.kingdee.eas.custom.signwasthetable.ContractInfo;
import com.kingdee.eas.custom.signwasthetable.ContractPaymentCollection;
import com.kingdee.eas.custom.signwasthetable.ContractPaymentInfo;
import com.kingdee.eas.custom.signwasthetable.ContractPaymentCollection;
import com.kingdee.eas.custom.signwasthetable.ContractPaymentInfo;
import com.kingdee.eas.custom.signwasthetable.ContractTypeFactory;
import com.kingdee.eas.custom.signwasthetable.SignWasTheTable;
import com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo;
import com.kingdee.eas.custom.signwasthetable.SignWasTheTablePayReqCollection;
import com.kingdee.eas.custom.signwasthetable.SignWasTheTablePayReqInfo;
import com.kingdee.eas.custom.signwasthetable.billStatus;
import com.kingdee.eas.farm.breed.brood.BroodDailyInfo;
import com.kingdee.eas.farm.breed.comm.ExecBotpResultInfo;
import com.kingdee.eas.fi.ap.IPayRequestBill;
import com.kingdee.eas.fi.ap.PayRequestBillInfo;
import com.kingdee.eas.fm.common.FMException;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.framework.CoreBillBaseInfo;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.framework.ObjectValueUtil;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.framework.client.CoreBillEditUI;
import com.kingdee.eas.framework.client.FrameWorkClientUtils;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.ISCMBillBase;
import com.kingdee.eas.scm.im.inv.InvBillBaseEntryInfo;
import com.kingdee.eas.scm.im.inv.InvBillBaseInfo;
import com.kingdee.eas.scm.im.inv.InvCommonUtils;
import com.kingdee.eas.scm.sm.pur.b2b.model.ObjectCollection;
import com.kingdee.eas.util.StringUtil;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.eas.wlhlcomm.BotpAppCommon;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.jdbc.rowset.IRowSet;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.bot.BOTMappingFactory;
import com.kingdee.bos.metadata.bot.IBOTMapping;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.custom.signwasthetable.ContractInfo;

public class createToPayControllerBean extends AbstractcreateToPayControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.signwasthetable.app.createToPayControllerBean");
	protected IObjectValue _createPayReq(Context ctx, IObjectValue contract)throws BOSException
	{
		IObjectValue obv=genNextBill(ctx, contract);
		return obv;
	}
	public Map<String,EntityObjectInfo> getDestBostype(Context ctx, String srcBOSType) throws BOSException, BOTPException
	{

		HashMap<String,EntityObjectInfo> destEOI = new HashMap<String, EntityObjectInfo>();
		// 后台获得 可生成的目标单据类型
		IBOTMapping iBOTMapping = BOTMappingFactory.getLocalInstance(ctx);

		String targetTypeAndAliasString = iBOTMapping.getTargetBillTypeList(srcBOSType);
		if(StringUtils.isNotBlank(targetTypeAndAliasString)){
			String[] targetTypeAndAlias = StringUtil.split(targetTypeAndAliasString, "|");

			String targetBillTypeString = targetTypeAndAlias[0];
			String targetAliasString = targetTypeAndAlias[1];

			String[] targetAlias = StringUtil.split(targetAliasString, ",");
			String[] targetBillType = StringUtil.split(targetBillTypeString, ",");
			// 逐个循环 添加目标单据eoi到result
			IMetaDataLoader loader = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
			for(int i = 0; i < targetBillType.length; i++)
			{
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
	public BOTMappingCollection getAllCanUsedBots(Context ctx,String srcBillType,String[] srcBillIDs, String[] entryNames,
			List entriesKey, SelectorItemCollection botpSelectors) throws BOTPException, BOSException{
		if(botpSelectors == null){
			botpSelectors = new SelectorItemCollection();
		}	
		Map<String,EntityObjectInfo> destBosTypes =getDestBostype(ctx,srcBillType);

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
				BOTMappingCollection botMappingCols = botMapping.getMappingCollectionForSelectUseRuleFilter(srcBillType,destBOSType,DefineSysEnum.BTP,transmitContext,srcBillIDs,entryNames,entriesKey,botpSelectors);
				// 添加到结果集中
				botColl.addCollection(botMappingCols);
			}
		}
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
	public  IObjectValue transformForBotp(Context ctx,String[] idList,String[] entryNames,List entryIDs,SelectorItemCollection botpSelectors,String destBillTypeBOSType,
			IObjectPK botpPK,String srcBillType,ExecBotpResultInfo  resultInfo ) throws BOSException, BTPException{


		IObjectValue destBillInfo = null; // destBillBosType：目标单据BOS类型
		IPayRequestBill iInstace = null;// 库存业务单据对象接口
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
			Method mtd = cls.getMethod("getLocalInstance",new Class[] {com.kingdee.bos.Context.class});
			ICoreBase iCoreBase =(ICoreBase)mtd.invoke(cls,new Object[] { ctx });
			iInstace =(IPayRequestBill) iCoreBase;


			// SaleIssueBillFactory.getLocalInstance(ctx).audit(IObjectPK)
			// Method submitMtd=iCoreBase.getClass().getMethod("submit", new
			// Class[]{com.kingdee.eas.framework.CoreBillBaseInfo.class});
			// Method auditMtd=iCoreBase.getClass().getMethod("audit", new
			// Class[]{com.kingdee.bos.dao.IObjectPK.class});
			// Method unAuditMtd=iCoreBase.getClass().getMethod("unAudit", new
			// Class[]{com.kingdee.bos.dao.IObjectPK.class});
			// ************************************

			// 调用BOTP接口自动生成单据--入库单
			btp=BTPManagerFactory.getLocalInstance(ctx);
			// [注释]获取BTP的本地接口
			//			result = btp.transform(srcBill, botMappingInfo);
			result=btp.transformForBotp(idList,entryNames,entryIDs,botpSelectors,destBillTypeBOSType,botpPK,srcBillType);

			// 获取结果 单据编码

			// [注释] result：为转换成功生的目标单据
			// objectValue：源单据的值对象
			IObjectCollection destBillColl=result.getBills();


			for(int m = 0; m < destBillColl.size(); m++){
				destBillInfo = destBillColl.getObject(m);


				destPK = new ObjectUuidPK(((CoreBaseInfo) destBillInfo).getId());// 目标单据Id


			}
			return destBillInfo;

		} catch (Exception e1) {// botp 失败 删除单据
			e1.printStackTrace();
			statusSb.append(status).append(";");
			resultInfo.setDestBillStatus(statusSb.toString());
			resultInfo.setDestObjectNumber(numSb.toString());
			resultInfo.setError(e1.getMessage());
			status = "";

			throw new BOSException(e1.getMessage());
		}




	}
	/**
	 * 生成 下游单据
	 * 
	 * @param ctx 上下文
	 * @param srcBosType 源单据bostype
	 * @param destBosType 目标单据类型
	 * @param srcBillCollection 原单据billinfocollection ，（只包含需要生成下游单据的entry，其余entry在上一步应该删除）
	 * @param defineEnum kskskskssk
	 * @param botpPK asdfdsa
	 * @returnsss sadfdsa
	 * @throws Exception
	 */
	public static IObjectCollection generateDestBill(Context ctx,String srcBosType,String destBosType,CoreBillBaseCollection srcBillCollection,DefineSysEnum defineEnum,IObjectPK botpPK) throws Exception 
	{
		IBOTMapping botMapping = BOTMappingFactory.getLocalInstance(ctx);

		CoreBillBaseInfo billInfo = srcBillCollection.get(0);
		// 验证botp是否存在
		BOTMappingInfo botMappingInfo = botMapping.getMapping(billInfo,destBosType,defineEnum);

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

		BOTRelationCollection botRelationCols = btpResult.getBOTRelationCollection();
		// 保存关联
		for (int i = 0; i < destBillCols.size(); i++) {

			CoreBillBaseInfo destBillInfo = (CoreBillBaseInfo) destBillCols.getObject(i);

			iBTPManager.submitRelations(destBillInfo, botRelationCols);

		}

		return destBillCols;

	}  
	public IObjectValue genNextBill(Context ctx, IObjectValue model) throws BOSException {
		IObjectValue destObj=null;
		// 状态校验
		ContractInfo cmInfo = (ContractInfo) model;
		if(!billStatus.Audit.equals(cmInfo.getContractStatus()))
		{
			throw new FarmException("只有审核状态的单据才能生成下游单据");
		}

		// 结果
		List<ExecBotpResultInfo>  execResults = new ArrayList<ExecBotpResultInfo>();
		// 转换规则ID
		// 获取所有可用的botcoll
		String srcBillType =cmInfo.getBOSType().toString();
		String[] srcBillIDs = {cmInfo.getId().toString()};
		String[] entryNames = {"payment"};
		List entriesKey = new ArrayList<String>();
		ContractPaymentCollection entryColl = cmInfo.getPayment();
		if(entryColl.size() > 0)
		{
			for(int i = 0; i < entryColl.size(); i++)
			{
				ContractPaymentInfo entryInfo = entryColl.get(i);
				if(entryInfo != null && entryInfo.getId() != null)
				{
					entriesKey.add(entryInfo.getId().toString());
				}
			}
		}

		SelectorItemCollection botpSelectors = null;

		BotpAppCommon botpAppComm = new BotpAppCommon();
		BOTMappingCollection botColl=new BOTMappingCollection();
		try {
			botColl=getAllCanUsedBots(ctx,srcBillType,srcBillIDs,entryNames,entriesKey,botpSelectors);
		} catch (BOTPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		//获取所有可用的botp 后逐个执行操作
		if(botColl != null && botColl.size() > 0)
		{

			BOTMappingCollection inbots = new BOTMappingCollection();
			BOTMappingCollection outbots = new BOTMappingCollection();
			for(int i = 0; i < botColl.size(); i++)
			{
				BOTMappingInfo botMappingInfo = botColl.get(i);
				if(botMappingInfo.getAlias().indexOf("合同签呈") > -1)
				{
					inbots.add(botMappingInfo);
				}else{
					outbots.add(botMappingInfo);
				}

			}
			// 执行结果 
			ExecBotpResultInfo  resultInfo;
			// 先生成单据
			for(int i = 0; i < inbots.size(); i++)
			{
				{
					BOTMappingInfo botMappingInfo = inbots.get(i);
					resultInfo =this.getEmptyExecresult(ctx,cmInfo);
					resultInfo.setMappingName(botMappingInfo.getAlias());
					resultInfo.setMappingNumber(botMappingInfo.getName());
					try
					{
						destObj=transformForBotp(ctx,srcBillIDs,entryNames,entriesKey,botpSelectors,botMappingInfo.getDestEntityName(),new ObjectUuidPK(botMappingInfo.getId()),srcBillType,resultInfo);
						// 增加到结果列表中
						execResults.add(resultInfo);
					}catch(Exception e){
						System.out.println(botMappingInfo.getAlias());
						// 增加到结果列表中
						execResults.add(resultInfo);
						e.printStackTrace();
						continue;
					}
				}
			}

		}

		return destObj;
	}
	private ExecBotpResultInfo getEmptyExecresult(Context ctx,ContractInfo billInfo){
		ExecBotpResultInfo execResult = new ExecBotpResultInfo();
		execResult.setSrcEntiryName("合同签呈");
		execResult.setSrcObjectNumber(billInfo.getNumber());
		execResult.setSrcEntityBostype(this.getBOSType().toString());
		return execResult;


	}
	public  IObjectValue transformForBotp1(Context ctx,String[] idList,String[] entryNames,List entryIDs,SelectorItemCollection botpSelectors,String destBillTypeBOSType,
			IObjectPK botpPK,String srcBillType,ExecBotpResultInfo  resultInfo ) throws BOSException, BTPException{


		IObjectValue destBillInfo = null; // destBillBosType：目标单据BOS类型
		IPayRequestBill iInstace = null;// 库存业务单据对象接口
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
			Method mtd = cls.getMethod("getLocalInstance",new Class[] {com.kingdee.bos.Context.class});
			ICoreBase iCoreBase =(ICoreBase)mtd.invoke(cls,new Object[] { ctx });
			iInstace =(IPayRequestBill) iCoreBase;


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
			result=btp.transformForBotp(idList,entryNames,entryIDs,botpSelectors,destBillTypeBOSType,botpPK,srcBillType);

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
				//					if(destBillInfo instanceof PayRequestBillInfo){
				//						if(((AbstractInvBillBaseInfo) destBillInfo).getTransactionType()!=null) {
				//							FilterInfo filterInfo = new FilterInfo();
				//							filterInfo.getFilterItems().add(new FilterItemInfo("transactionType.id",
				//									((AbstractInvBillBaseInfo) destBillInfo).getTransactionType().getId().toString(), CompareType.EQUALS));
				//							String prefix = "invUpdateType.";
				//							filterInfo.getFilterItems().add(
				//									new FilterItemInfo(prefix + "status", Integer.valueOf(1), CompareType.EQUALS));
				//							EntityViewInfo ev = new EntityViewInfo();
				//							// filterInfo.mergeFilter(buildInvUpdateTypeFilterInfo(entry,
				//							// isF7), "AND");
				//							filterInfo.setMaskString("#0 AND #1");
				//							ev.setFilter(filterInfo);
				//			
				//							TransactionInvUpdateTypeCollection updateTypeCol = InvCommonUtils.getTransactionInvUpdateTypeCol(ctx,
				//									ev);
				//							InvUpdateTypeInfo updateType = null;
				//							if (updateTypeCol != null && updateTypeCol.size() > 0) {
				//	

			}
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
	private ExecBotpResultInfo getEmptyExecresultFromSignTable(Context ctx,SignWasTheTableInfo billInfo){
		ExecBotpResultInfo execResult = new ExecBotpResultInfo();
		execResult.setSrcEntiryName("签呈表");
		execResult.setSrcObjectNumber(billInfo.getNumber());
		execResult.setSrcEntityBostype(billInfo.getBOSType().toString());
		return execResult;
	}

	/**
	 * 行政签呈生成付款申请
	 */
	@Override
	protected IObjectValue _toPayReqFromSignTable(Context ctx,
			IObjectValue model, ArrayList entryList,BOTMappingInfo botMappingInfo)
	throws BOSException, EASBizException {
		return botMappingInfo;/*
		// TODO Auto-generated method stub
		SignWasTheTableInfo info=(SignWasTheTableInfo) model;
		String[] srcBillIDs={info.getId().toString()};
		String[] entryNames={"PayReq"};
		SelectorItemCollection botpSelectors = null;
		ArrayList<String> entriesKey=new ArrayList<String>();
		SignWasTheTablePayReqInfo entryInfo=null;
		int num;

		for(int i=0;i<entryList.size();i++){
			num=(Integer)entryList.get(i);
			entryInfo = info.getPayReq().get(num);
			entriesKey.add(entryInfo.getId().toString());
		}

		ExecBotpResultInfo resultInfo = this.getEmptyExecresultFromSignTable(ctx,info);
		resultInfo.setMappingName(botMappingInfo.getAlias());
		resultInfo.setMappingNumber(botMappingInfo.getName());

		IObjectValue destObj = transformForBotp(ctx,srcBillIDs,entryNames,entriesKey,botpSelectors,botMappingInfo.getDestEntityName(),new ObjectUuidPK(botMappingInfo.getId()),info.getBOSType().toString(),resultInfo);
		return (PayRequestBillInfo)destObj;
		 */}
	/**
	 * 签呈表生成付款申请时获取可用的botp转换规则
	 */
	@Override
	protected BOTMappingCollection _getCanUsedBotMapping(Context ctx,
			IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		SignWasTheTableInfo info = (SignWasTheTableInfo)model;
		String srcBillType =info.getBOSType().toString();
		String[] srcBillIDs = {info.getId().toString()};
		String[] entryNames = {"payReq"};
		ArrayList<String> entriesKey = new ArrayList<String>();
		//		SignWasTheTablePayReqCollection entryColl = info.getPayReq();
		SignWasTheTablePayReqInfo entryInfo=null;
		//		if(entryColl.size() > 0){
		//			for(int i = 0; i < entryColl.size(); i++){
		//				entryInfo = entryColl.get(i);
		//				if(entryInfo != null && entryInfo.getId() != null)
		//					entriesKey.add(entryInfo.getId().toString());
		//			}
		//		}

		SelectorItemCollection botpSelectors = null;

		BOTMappingCollection botColl=new BOTMappingCollection();
		try {
			botColl=getAllCanUsedBots(ctx,srcBillType,srcBillIDs,entryNames,entriesKey,botpSelectors);
		} catch (BOTPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return botColl;
	}


	public static void generateDestBill(Context ctx, String srcBosType,String destBosType, CoreBillBaseCollection srcBillCollection,IObjectPK botpPK) throws Exception {
		IBOTMapping botMapping = BOTMappingFactory.getLocalInstance(ctx);
		CoreBillBaseInfo billInfo = srcBillCollection.get(0);
		BOTMappingInfo botMappingInfo = botMapping.getMapping(billInfo, destBosType, DefineSysEnum.BTP);
		if (botMappingInfo == null) {
			throw new FMException(FMException.NODESTBILL);
		}
		IBTPManager iBTPManager = BTPManagerFactory.getLocalInstance(ctx);
		BTPTransformResult btpResult = null;
		btpResult = iBTPManager.transformForBotp(srcBillCollection,destBosType, botpPK);
		IObjectCollection destBillCols = btpResult.getBills();
		BOTRelationCollection botRelationCols = btpResult.getBOTRelationCollection();
		for (int i = 0; i < destBillCols.size(); i++) {
			CoreBillBaseInfo destBillInfo = (CoreBillBaseInfo) destBillCols.getObject(i);
			iBTPManager.submitRelations(destBillInfo, botRelationCols);
		}
	}
}