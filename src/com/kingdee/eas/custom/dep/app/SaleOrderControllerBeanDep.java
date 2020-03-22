package com.kingdee.eas.custom.dep.app;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.bot.BOTMappingFactory;
import com.kingdee.bos.metadata.bot.BOTMappingInfo;
import com.kingdee.eas.base.btp.BTPException;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.basedata.assistant.PeriodFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerFactory;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.IOrgSwitchFacade;
import com.kingdee.eas.basedata.org.OrgSwitchFacadeFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.common.app.AppCommonUtil;
import com.kingdee.eas.custom.eas2wincos.interfaces.ExportSaleOrder;
import com.kingdee.eas.custom.salediscount.DiscountFacadeFactory;
//import com.kingdee.eas.custom.xszr.JszrFactory;
//import com.kingdee.eas.custom.xszr.JszrInfo;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.scm.sd.sale.SaleOrderEntryCollection;
import com.kingdee.eas.scm.sd.sale.SaleOrderEntryInfo;
import com.kingdee.eas.scm.sd.sale.SaleOrderFactory;
import com.kingdee.eas.scm.sd.sale.SaleOrderInfo;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * ���۶��� dep��̨
 * @author Administrator
 *
 */
public class SaleOrderControllerBeanDep {

	
	// @Override
	// ��˷�д ��ʱ������� 
	public void afterAudit(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {

		/**************************************����������߼�  wgj 20150804 begin****/
		generateDestReceivingBills(ctx,pk.toString());
		/**************************************����������߼�  wgj 20150804 begin****/
	}

	// @Override
	/**
	 * �������ɺ���
	 */
	public void afterUnAudit(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		
	}


	// �Ƿ���ڱ������
	public boolean isCodeRuleEnable(Context ctx, IObjectValue objValue,
			String companyId) throws EASBizException, BOSException {
		ICodingRuleManager codeRuleMgr = CodingRuleManagerFactory
				.getLocalInstance(ctx);
		return codeRuleMgr.isExist(objValue, companyId);
	}

	// �õ��Զ�����
	public String getAutoCode(Context ctx, IObjectValue objValue,
			String companyId) throws EASBizException, BOSException {
		IOrgSwitchFacade orgSwitch = OrgSwitchFacadeFactory
				.getLocalInstance(ctx);
		// orgSwitch.orgSwitch(companyId);
		ICodingRuleManager codeRuleMgr = CodingRuleManagerFactory
				.getLocalInstance(ctx);
		;
		if (codeRuleMgr.isUseIntermitNumber(objValue, companyId)) {
			return codeRuleMgr.readNumber(objValue, companyId);
		} else {
			return codeRuleMgr.getNumber(objValue, companyId);
		}
	}
	/**
	 * add by dai 20150709 wincos�ӿ�
	 */
//	@Override
	public void afterAudit(Context ctx, IObjectPK[] pks) throws BOSException, EASBizException {
		
		for(int i=0;i<pks.length;i++) {
			try{
				SaleOrderInfo info = SaleOrderFactory.getLocalInstance(ctx).getSaleOrderInfo(pks[i]);
				ExportSaleOrder ep = new ExportSaleOrder();
				ep.export2WinCosByID(ctx, info.getSaleOrgUnit().getString("id"), pks[i].toString());
			}catch(Exception ease){
				ease.printStackTrace();
			}
			
			/**************************************����������߼�  wgj 20150804 begin****/
			generateDestReceivingBills(ctx,pks[i].toString());
			/**************************************����������߼�  wgj 20150804 begin****/
		}
		
		
		
	}
	
	

	/**************************************����������߼�  wgj 20150804 begin*************************************************/
	
	
	/**
	 * ��� ��ǰ��˾��������ϣ�����ô������������ε��տ
	 * @param ctx
	 * @param pk
	 * @throws BOSException 
	 */
	public void generateDestReceivingBills(Context ctx, String pk) throws BOSException {
		String cuid = ContextUtil.getCurrentCtrlUnit(ctx).getId().toString();
		boolean isEnableDiscount = DiscountFacadeFactory.getLocalInstance(ctx).isEnableDiscount(cuid);
		// ��������ϣ�����ô��� �����������տ
		if(isEnableDiscount){
			boolean exist = AppCommonUtil.existDestBill(ctx, "C48A423A", pk);
			if(exist){
				throw new BOSException("�Ѿ��������ε��ݣ��������");
			}
			try{
				AppCommonUtil appCommon = new AppCommonUtil();
//				List<String> botIDs = appCommon.getBillBotMappings(ctx, "C48A423A","FA44FD5B", DefineSysEnum.BTP, true);
				
				List<Map<String,String>> botIDs = getToReceivingBillIDs(ctx);
//				botIDs.add("MO0sKFucTBiZEEOp3H0w7gRRIsQ=");
//				botIDs.add("");
//				botIDs.add("");
				if(botIDs != null && botIDs.size() > 0){
					// ���ڵ���
					SaleOrderInfo billInfo = SaleOrderFactory.getLocalInstance(ctx).getSaleOrderInfo(new ObjectUuidPK(pk));
					
					for(int i =0; i < botIDs.size(); i++){
						Map<String,String> botInfos = botIDs.get(i);
						String[] botID = {};
						botID = botInfos.keySet().toArray(botID);
						String botMappingID =botID[0];
						String botName = botInfos.get(botMappingID);
						// �����������Ļ� ������ �� ����botp
						BigDecimal cash = billInfo.getBigDecimal("ntfCash");
						BigDecimal pos = billInfo.getBigDecimal("ntfPos");
						BigDecimal tctd = billInfo.getBigDecimal("ntfTongcunTongdui");
						
						if(botName.equals("HSDS-SKDCASH01") && (cash == null || cash.compareTo(new BigDecimal("0")) == 0 )){
							continue;
						}else if(botName.equals("HSDS-SKDPOS01") && (pos == null || pos.compareTo(new BigDecimal("0")) == 0 )){
							continue;
						} else if(botName.equals("HSDS-SKDTCTD01") && (tctd == null || tctd.compareTo(new BigDecimal("0")) == 0 )){
							continue;
						}
						IObjectPK botpPK = new ObjectUuidPK(botMappingID);
						try{
							CoreBillBaseCollection srcBillCollection = new CoreBillBaseCollection();
							srcBillCollection.add(billInfo);
							
							BOTMappingInfo botMappingInfo = BOTMappingFactory.getLocalInstance(ctx).getMappingInfoByPK(botpPK);
							if(botMappingInfo != null){
								
//							IObjectCollection objColl = AppCommonUtil.generateDestBill(ctx,
//										"C48A423A", 
//										"FA44FD5B",
//										srcBillCollection,DefineSysEnum.BTP, 
//										botpPK);
							
							String srcBillType = "C48A423A";
							String destBillTypeBOSType = "FA44FD5B";
							String[] srcBillIDs = {billInfo.getId().toString()};
							String[] entryNames = {"entrys"};
							List entriesKey = new ArrayList<String>();
							IObjectCollection objColl  = AppCommonUtil.transformForBotp(ctx,
									srcBillIDs, 
									entryNames,
									entriesKey, 
									null,
									destBillTypeBOSType, 
									botpPK, 
									srcBillType );
							
							
								// ���Ӧ�յ�
//								if(objColl != null && objColl.size() > 0){
//									
//									for(int j = 0; j < objColl.size(); j++){
//										CoreBillBaseInfo destBillInfo = (CoreBillBaseInfo) objColl.getObject(j);
//										ReceivingBillInfo receivingBillInfo = (ReceivingBillInfo)destBillInfo;
//										// ������ɵ�Ӧ�յ�
////										ReceivingBillFactory.getLocalInstance(ctx).submit(receivingBillInfo);
////										ReceivingBillFactory.getLocalInstance(ctx).passAudit(new ObjectUuidPK(receivingBillInfo.getId()),receivingBillInfo);
//									}
//								}
							}
//							transResult.getVoucherCollection();
							
						}catch(BTPException btpE){
//							String message = btpE.getMessage();
//							btpE.printStackTrace();
//							continue;
							throw new BOSException(btpE);
//							btpE.printStackTrace();
						}catch (Exception e) {
//							String message = e.getMessage();
//							e.printStackTrace();
							throw new BOSException(e);
//							continue;
						}
					}
				}
				
//				ARAppUtil arUtil = new ARAppUtil();
//				
//				String checkStr = arUtil.checkArBillingRelExist(ctx, CONSTANTS.SLIM, billInfo);
//				if(StringUtils.isNotBlank(checkStr)){
//					throw new BOSException(checkStr);
//				}
			}catch (Exception e) {
				throw new BOSException(e); 
				// TODO: handle exception
			}
		}
		
	}
	/**
	 * ɾ�����ݺ�����������־
	 */
	public void afterDelete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		
		String cuid = ContextUtil.getCurrentCtrlUnit(ctx).getId().toString();
		boolean isEnableDiscount = DiscountFacadeFactory.getLocalInstance(ctx).isEnableDiscount(cuid);
		// ��������ϣ�����ô��� �����������տ
		if(isEnableDiscount){
			// �����������־
			DiscountFacadeFactory.getLocalInstance(ctx).removeOrderDsgridLogs(pk.toString());
		}
		
	}

	/**
	 * ��ô����۶����� �տ��  botpid
	 * @param ctx
	 * @return
	 * @throws BOSException 
	 */
	private List<Map<String,String>> getToReceivingBillIDs(Context ctx) throws BOSException {
		String sql = "select t.fid,t.fname from t_bot_mapping t inner join t_bot_extMapping te on t.fextMappingID = te.fid where te.fiseffected=1 and t.fname in ('HSDS-SKDCASH01','HSDS-SKDPOS01','HSDS-SKDTCTD01')";
		IRowSet rs = DbUtil.executeQuery(ctx, sql);
		List<Map<String,String>> ids = new ArrayList<Map<String,String>>();
		try{
			while(rs.next()){
				String fid = rs.getString("fid");
				String fname = rs.getString("fname");
				Map<String,String> botId = new HashMap<String, String>();
				botId.put(fid, fname);
				ids.add(botId);
			}
		}catch(SQLException sqle){
			throw new BOSException("��ѯ�����տbotp����ʱ����",sqle);
		}
		return ids;
	}
	/**************************************����������߼�  wgj 20150804 end***************************************************/
	
	
	/**
	 *  �����۸� ��   ���ҽ��  У��
	 */
	public SaleOrderInfo reCalcuteNetAmount(Context ctx, IObjectValue obj) throws EASBizException, BOSException {
		SaleOrderInfo orderInfo = (SaleOrderInfo) obj;
		// �������� ����
		if(orderInfo != null){
			CustomerInfo orderCustomer = orderInfo.getOrderCustomer();
			boolean isInternalCustomer = false;
			if(orderCustomer != null){
				isInternalCustomer = AppCommon.isInternalCustomer(ctx,orderCustomer.getId().toString());
			}
			SaleOrderEntryCollection entryColl = orderInfo.getEntries();
			if(entryColl != null && entryColl.size() > 0){
				for(int i = 0; i < entryColl.size(); i++){
					SaleOrderEntryInfo entryInfo = entryColl.get(i);
					BigDecimal taxPrice = entryInfo.getTaxPrice();
					BigDecimal basePrice = entryInfo.getBigDecimal("DsBasePrice");
					BigDecimal netAmount = entryInfo.getBigDecimal("BaseAmount");
					BigDecimal baseQty = entryInfo.getBaseQty();
					if(basePrice == null){
						basePrice = taxPrice;
						netAmount = taxPrice.multiply(baseQty);
						entryInfo.setBigDecimal("DsBasePrice", basePrice);
						entryInfo.setBigDecimal("BaseAmount", netAmount);
					}
					
					// �ڲ��ͻ� �����۸񲻵��ں�˰����  �򱨴�
					if(isInternalCustomer && taxPrice.compareTo(basePrice) != 0){
						throw new BOSException("�ڲ��ͻ���˰���۲���������۸�һ�£��뱣֤�۸�������ȷ�����޸ĵ���");
					}
					
					
					
					
					BigDecimal allAmount = basePrice.multiply(baseQty);
					if(netAmount.compareTo(allAmount) != 0){
						netAmount = allAmount;
						entryInfo.setBigDecimal("BaseAmount", netAmount);
					}
					
					
					
				}
			}
			
		}
		return orderInfo;
	}
	
}
