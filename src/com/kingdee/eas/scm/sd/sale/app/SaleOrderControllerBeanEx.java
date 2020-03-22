package com.kingdee.eas.scm.sd.sale.app;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

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
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.IOrgSwitchFacade;
import com.kingdee.eas.basedata.org.OrgSwitchFacadeFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.common.app.AppCommonUtil;
import com.kingdee.eas.custom.eas2wincos.interfaces.ExportSaleOrder;
import com.kingdee.eas.custom.salediscount.DiscountFacadeFactory;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.scm.sd.sale.SaleOrderFactory;
import com.kingdee.eas.scm.sd.sale.SaleOrderInfo;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class SaleOrderControllerBeanEx extends
		com.kingdee.eas.scm.sd.sale.app.SaleOrderControllerBean {
	private static Logger logger = Logger
			.getLogger("com.kingdee.eas.scm.sd.sale.app.SaleOrderControllerBeanEx");
//
//	// ����������Ϣ
//	protected void _calZR(Context ctx, IObjectValue model) throws BOSException {
//		super._calZR(ctx, model);
//	}
//
//	// �õ����
//	protected void _getYE(Context ctx, IObjectValue model) throws BOSException {
//		// TODO Auto-generated method stub
//		super._getYE(ctx, model);
//	}

	// @Override
	// ��˷�д ��ʱ������� 
	protected void _audit(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		// TODO Auto-generated method stub
		super._audit(ctx, pk);
		try {
			String ficompanyid = ContextUtil.getCurrentFIUnit(ctx).getId().toString();
			SaleOrderInfo so = SaleOrderFactory.getLocalInstance(ctx).getSaleOrderInfo(pk);
			if (so.get("khhkzf") == null)
				so.put("khhkzf",new BigDecimal(0));
			if (so.get("DisAmount")  == null)
				so.put("DisAmount",new BigDecimal(0));
			so.put("SaleGroupA",so.getSaleGroup());
			so.put("SalePersonA",so.getSalePerson());
			
			SaleOrderFactory.getLocalInstance(ctx).update(new ObjectUuidPK(so.getId().toString()), so);
			
			//�õ�����ҵ�����ڵĻ���ڼ�
			PeriodInfo po = null;
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");   
			java.util.Date FBizDate = so.getBizDate();
			String date=format.format(FBizDate);
			int year = Integer.parseInt(date.substring(0, 4));
			int month =Integer.parseInt(date.substring(5, 7));
			String customid = so.getOrderCustomer().getId().toString();
			IRowSet rr = com.kingdee.eas.util.app.DbUtil.executeQuery(
					ctx,"select fid from t_bd_period where fperiodyear="+ year + " and fPeriodnumber="+ month);
			if (rr.next()) {
				ObjectUuidPK pp = new ObjectUuidPK(rr.getString("fid"));
				po = PeriodFactory.getLocalInstance(ctx).getPeriodInfo(pp);
			} else {
				// MsgBox.info("��ʾ", "û�л���ڼ�", this);
				SysUtil.abort();
			}
			
			// ���¼�ʱ��������
			StringBuffer b = new StringBuffer();
			b.append("select fid from CT_XSZ_Jszr where CFcustomerID='");
			b.append(customid + "' and cfficompanyid='");
			b.append(ficompanyid + "'");
			BigDecimal bqzf=new BigDecimal(0);
			BigDecimal bqqc=new BigDecimal(0);
			IRowSet rb = com.kingdee.eas.util.app.DbUtil.executeQuery(ctx, b.toString());
			if (rb.next()) {
				bqzf=(BigDecimal) so.get("DisAmount");
				BigDecimal khhk=(BigDecimal) so.get("khhkzf");//����֧�����
				b=new StringBuffer();
				b.append(" /*dialect*/ update CT_XSZ_Jszr set cfbqzf=cfbqzf+"+bqzf);
				b.append(" ,cfhkye=cfhkye-"+khhk);
				b.append(" where fid='"+rb.getString("fid")+"'");
				com.kingdee.eas.util.app.DbUtil.execute(ctx, b.toString());
				
				b=new StringBuffer();
				b.append(" /*dialect*/ update CT_XSZ_Jszr set cfzrye=cfbqqc-cfbqzf ");
				b.append(" where fid='"+rb.getString("fid")+"'");
				com.kingdee.eas.util.app.DbUtil.execute(ctx, b.toString());
				
				
//				ObjectUuidPK pc = new ObjectUuidPK(rb.getString("fid"));
//				JszrInfo jszr = JszrFactory.getLocalInstance(ctx).getJszrInfo(pc);
//				bqzf=so.getDisAmount();
//				BigDecimal khhk=so.getKhhkzf();//����֧�����
//				if(khhk==null) khhk=new BigDecimal(0);
//				BigDecimal hkye=jszr.getHkye();//������
//				if(hkye==null) hkye=new BigDecimal(0);
//				if(jszr.getBqzf()==null) jszr.setBqzf(new BigDecimal(0));
//				if (jszr.getBqqc()!=null) bqqc=jszr.getBqqc();
//				jszr.setBqzf(jszr.getBqzf().add(bqzf));// ����֧��
//				jszr.setZrye(bqqc.subtract(jszr.getBqzf()));//���ڽ��ࡢ��ʱ���
//				jszr.setHkye(hkye.subtract(khhk));//���»�����
//				JszrFactory.getLocalInstance(ctx).update(pc, jszr);
			} else {
//				// 11.23 ���������,�½���ʱ����
//				if (((BigDecimal)so.get("DisAmount")).compareTo(new BigDecimal(0)) > 0) {
//					JszrInfo jszrNew = new JszrInfo();
//					com.kingdee.eas.basedata.master.cssp.CustomerInfo cus = CustomerFactory
//							.getLocalInstance(ctx).getCustomerInfo(new ObjectUuidPK(so.getOrderCustomer().getId().toString()));
//					if (this.isCodeRuleEnable(ctx, jszrNew, cus.getId().toString())) {
//						jszrNew.setNumber(this.getAutoCode(ctx, jszrNew, cus.getId().toString()));
//					}
//					jszrNew.setCustomer(cus);
//					jszrNew.setFICompany(ContextUtil.getCurrentFIUnit(ctx));
//					jszrNew.setBqqc(new BigDecimal(0));//�ڳ��������Ϊ0
//					bqzf=((BigDecimal)so.get("DisAmount"));
//					jszrNew.setBqzf(bqzf);// ����֧��
//					jszrNew.setZrye(jszrNew.getBqqc().subtract(bqzf));
//					jszrNew.setHkye(new BigDecimal(0));
//					JszrFactory.getLocalInstance(ctx).addnew(jszrNew);
//				}
			}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			throw new BOSException("����",e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BOSException("����",e);
		}
		
		
		
		/**************************************����������߼�  wgj 20150804 begin****/
		generateDestReceivingBills(ctx,pk.toString());
		/**************************************����������߼�  wgj 20150804 begin****/
	}

	// @Override
	protected void _unAudit(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		// TODO Auto-generated method stub
		super._unAudit(ctx, pk);
		try {
			CompanyOrgUnitInfo ficompany = ContextUtil.getCurrentFIUnit(ctx);
			SaleOrderInfo so = SaleOrderFactory.getLocalInstance(ctx).getSaleOrderInfo(pk);
			String customid = so.getOrderCustomer().getId().toString();
			if (so.get("khhkzf") == null) so.put("khhkzf",new BigDecimal(0));
			if (so.get("DisAmount") == null)so.put("DisAmount",new BigDecimal(0));
		    	// ���¼�ʱ��������
				PeriodInfo po = null;
				IRowSet rsa = com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,"select fid from t_bd_period where fperiodyear="
						+ so.getYear() + " and fPeriodnumber="+ so.getPeriod());
				if (rsa.next()) {
					ObjectUuidPK pp = new ObjectUuidPK(rsa.getString("fid"));
					po = PeriodFactory.getLocalInstance(ctx).getPeriodInfo(pp);
				} else {
						// MsgBox.info("��ʾ", "û�л���ڼ�", this);
						SysUtil.abort();
				}
				StringBuffer b = new StringBuffer();
				BigDecimal bqzf=new BigDecimal(0);
				b.append("select fid from CT_xsz_jszr where CFcustomerID='");
				b.append(customid + "' and cfficompanyid='");
				b.append(ficompany.getId().toString() + "'");
				IRowSet rb = com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,b.toString());
				if (rb.next()) {
					bqzf=(BigDecimal)so.get("DisAmount");
					BigDecimal khhk=(BigDecimal) so.get("khhkzf");//����֧�����
					b=new StringBuffer();
					b.append(" /*dialect*/ update CT_XSZ_Jszr set cfbqzf=cfbqzf-"+bqzf);
					b.append(" ,cfhkye=cfhkye+"+khhk);
					b.append(" where fid='"+rb.getString("fid")+"'");
					com.kingdee.eas.util.app.DbUtil.execute(ctx, b.toString());
					
					b=new StringBuffer();
					b.append(" /*dialect*/ update CT_XSZ_Jszr set cfzrye=cfbqqc-cfbqzf ");
					b.append(" where fid='"+rb.getString("fid")+"'");
					com.kingdee.eas.util.app.DbUtil.execute(ctx, b.toString());
					
//					ObjectUuidPK pc = new ObjectUuidPK(rb.getString("fid"));
//					JszrInfo jszr = JszrFactory.getLocalInstance(ctx).getJszrInfo(pc);
//					if (jszr.getBqzf() == null) jszr.setBqzf(new BigDecimal(0));
//					if (jszr.getZrye() == null) jszr.setZrye(new BigDecimal(0));
//					if (jszr.getBqqc() == null) jszr.setBqqc(new BigDecimal(0));
//					bqzf=so.getDisAmount();
//					BigDecimal khhk=so.getKhhkzf();//����֧�����
//					if(khhk==null) khhk=new BigDecimal(0);
//					BigDecimal hkye=jszr.getHkye();//������
//					if(hkye==null) hkye=new BigDecimal(0);
//					jszr.setBqzf(jszr.getBqzf().subtract(bqzf));//���±���֧�� 
//					jszr.setZrye(jszr.getBqqc().subtract(jszr.getBqzf()));//�����������
//					jszr.setHkye(hkye.subtract(khhk));//���»�����
//					JszrFactory.getLocalInstance(ctx).update(pc, jszr);
				}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			SysUtil.abort();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	// �Ƿ���ڱ������
	protected boolean isCodeRuleEnable(Context ctx, IObjectValue objValue,
			String companyId) throws EASBizException, BOSException {
		ICodingRuleManager codeRuleMgr = CodingRuleManagerFactory
				.getLocalInstance(ctx);
		return codeRuleMgr.isExist(objValue, companyId);
	}

	// �õ��Զ�����
	protected String getAutoCode(Context ctx, IObjectValue objValue,
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
	protected void _audit(Context ctx, IObjectPK[] pks) throws BOSException, EASBizException {
		super._audit(ctx, pks);
		for(int i=0;i<pks.length;i++) {
			try{
				SaleOrderInfo info = SaleOrderFactory.getLocalInstance(ctx).getSaleOrderInfo(pks[i]);
				ExportSaleOrder ep = new ExportSaleOrder();
				ep.export2WinCosByID(ctx, info.getSaleOrgUnit().getString("id"), pks[i].toString());
			}catch(Exception ease){
				ease.printStackTrace();
			}
			
			/**************************************����������߼�  wgj 20150804 begin****/
//			generateDestReceivingBills(ctx,pks[i].toString());
			/**************************************����������߼�  wgj 20150804 begin****/
		}
		
		
		
	}
	
	

	/**************************************����������߼�  wgj 20150804 begin*************************************************/
	
	
	/**
	 * ��� ��ǰ��˾���������������ô������������ε��տ
	 * @param ctx
	 * @param pk
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public void generateDestReceivingBills(Context ctx, String pk) throws BOSException, EASBizException {
		String cuid = ContextUtil.getCurrentCtrlUnit(ctx).getId().toString();
		boolean isEnableDiscount = DiscountFacadeFactory.getLocalInstance(ctx).isEnableDiscount(cuid);
		// ���������������ô��� �����������տ
		if(isEnableDiscount){
			boolean exist = AppCommonUtil.existDestBill(ctx, "C48A423A", pk);
			if(exist){
				throw new EASBizException(new NumericExceptionSubItem("01","�Ѿ��������ε��ݣ��������"));
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
							String message = btpE.getMessage();
							btpE.printStackTrace();
							continue;
//							throw new BOSException("�������ε���ʱ�����쳣",btpE);
						}catch (Exception e) {
							String message = e.getMessage();
							e.printStackTrace();
							continue;
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
				e.printStackTrace();
				throw new EASBizException(new NumericExceptionSubItem("01","���������ô����������ε��ݱ���"));
				// TODO: handle exception
			}
		}
		
	}
	/**
	 * ɾ�����ݺ�����������־
	 */
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		super._delete(ctx, pk);
		
		String cuid = ContextUtil.getCurrentCtrlUnit(ctx).getId().toString();
		boolean isEnableDiscount = DiscountFacadeFactory.getLocalInstance(ctx).isEnableDiscount(cuid);
		// ���������������ô��� �����������տ
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
	
}
