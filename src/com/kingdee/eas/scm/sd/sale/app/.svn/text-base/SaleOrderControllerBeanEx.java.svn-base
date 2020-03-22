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
//	// 计算折让信息
//	protected void _calZR(Context ctx, IObjectValue model) throws BOSException {
//		super._calZR(ctx, model);
//	}
//
//	// 得到余额
//	protected void _getYE(Context ctx, IObjectValue model) throws BOSException {
//		// TODO Auto-generated method stub
//		super._getYE(ctx, model);
//	}

	// @Override
	// 审核反写 即时折让余额 
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
			
			//得到订单业务日期的会计期间
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
				// MsgBox.info("提示", "没有会计期间", this);
				SysUtil.abort();
			}
			
			// 更新即时折让资料
			StringBuffer b = new StringBuffer();
			b.append("select fid from CT_XSZ_Jszr where CFcustomerID='");
			b.append(customid + "' and cfficompanyid='");
			b.append(ficompanyid + "'");
			BigDecimal bqzf=new BigDecimal(0);
			BigDecimal bqqc=new BigDecimal(0);
			IRowSet rb = com.kingdee.eas.util.app.DbUtil.executeQuery(ctx, b.toString());
			if (rb.next()) {
				bqzf=(BigDecimal) so.get("DisAmount");
				BigDecimal khhk=(BigDecimal) so.get("khhkzf");//本次支付汇款
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
//				BigDecimal khhk=so.getKhhkzf();//本次支付汇款
//				if(khhk==null) khhk=new BigDecimal(0);
//				BigDecimal hkye=jszr.getHkye();//汇款余额
//				if(hkye==null) hkye=new BigDecimal(0);
//				if(jszr.getBqzf()==null) jszr.setBqzf(new BigDecimal(0));
//				if (jszr.getBqqc()!=null) bqqc=jszr.getBqqc();
//				jszr.setBqzf(jszr.getBqzf().add(bqzf));// 本次支付
//				jszr.setZrye(bqqc.subtract(jszr.getBqzf()));//本期结余、即时余额
//				jszr.setHkye(hkye.subtract(khhk));//更新汇款余额
//				JszrFactory.getLocalInstance(ctx).update(pc, jszr);
			} else {
//				// 11.23 如果有折让,新建即时折让
//				if (((BigDecimal)so.get("DisAmount")).compareTo(new BigDecimal(0)) > 0) {
//					JszrInfo jszrNew = new JszrInfo();
//					com.kingdee.eas.basedata.master.cssp.CustomerInfo cus = CustomerFactory
//							.getLocalInstance(ctx).getCustomerInfo(new ObjectUuidPK(so.getOrderCustomer().getId().toString()));
//					if (this.isCodeRuleEnable(ctx, jszrNew, cus.getId().toString())) {
//						jszrNew.setNumber(this.getAutoCode(ctx, jszrNew, cus.getId().toString()));
//					}
//					jszrNew.setCustomer(cus);
//					jszrNew.setFICompany(ContextUtil.getCurrentFIUnit(ctx));
//					jszrNew.setBqqc(new BigDecimal(0));//期初余额设置为0
//					bqzf=((BigDecimal)so.get("DisAmount"));
//					jszrNew.setBqzf(bqzf);// 本期支付
//					jszrNew.setZrye(jszrNew.getBqqc().subtract(bqzf));
//					jszrNew.setHkye(new BigDecimal(0));
//					JszrFactory.getLocalInstance(ctx).addnew(jszrNew);
//				}
			}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			throw new BOSException("错误：",e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BOSException("错误：",e);
		}
		
		
		
		/**************************************新折让添加逻辑  wgj 20150804 begin****/
		generateDestReceivingBills(ctx,pk.toString());
		/**************************************新折让添加逻辑  wgj 20150804 begin****/
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
		    	// 更新即时折让资料
				PeriodInfo po = null;
				IRowSet rsa = com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,"select fid from t_bd_period where fperiodyear="
						+ so.getYear() + " and fPeriodnumber="+ so.getPeriod());
				if (rsa.next()) {
					ObjectUuidPK pp = new ObjectUuidPK(rsa.getString("fid"));
					po = PeriodFactory.getLocalInstance(ctx).getPeriodInfo(pp);
				} else {
						// MsgBox.info("提示", "没有会计期间", this);
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
					BigDecimal khhk=(BigDecimal) so.get("khhkzf");//本次支付汇款
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
//					BigDecimal khhk=so.getKhhkzf();//本次支付汇款
//					if(khhk==null) khhk=new BigDecimal(0);
//					BigDecimal hkye=jszr.getHkye();//汇款余额
//					if(hkye==null) hkye=new BigDecimal(0);
//					jszr.setBqzf(jszr.getBqzf().subtract(bqzf));//更新本期支付 
//					jszr.setZrye(jszr.getBqqc().subtract(jszr.getBqzf()));//更新折让余额
//					jszr.setHkye(hkye.subtract(khhk));//更新汇款余额
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


	// 是否存在编码规则
	protected boolean isCodeRuleEnable(Context ctx, IObjectValue objValue,
			String companyId) throws EASBizException, BOSException {
		ICodingRuleManager codeRuleMgr = CodingRuleManagerFactory
				.getLocalInstance(ctx);
		return codeRuleMgr.isExist(objValue, companyId);
	}

	// 得到自动编码
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
	 * add by dai 20150709 wincos接口
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
			
			/**************************************新折让添加逻辑  wgj 20150804 begin****/
//			generateDestReceivingBills(ctx,pks[i].toString());
			/**************************************新折让添加逻辑  wgj 20150804 begin****/
		}
		
		
		
	}
	
	

	/**************************************新折让添加逻辑  wgj 20150804 begin*************************************************/
	
	
	/**
	 * 如果 当前公司启用了新销售折让处理，则生成下游的收款单
	 * @param ctx
	 * @param pk
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public void generateDestReceivingBills(Context ctx, String pk) throws BOSException, EASBizException {
		String cuid = ContextUtil.getCurrentCtrlUnit(ctx).getId().toString();
		boolean isEnableDiscount = DiscountFacadeFactory.getLocalInstance(ctx).isEnableDiscount(cuid);
		// 启用了新销售折让处理 则生成下游收款单
		if(isEnableDiscount){
			boolean exist = AppCommonUtil.existDestBill(ctx, "C48A423A", pk);
			if(exist){
				throw new EASBizException(new NumericExceptionSubItem("01","已经存在下游单据，不能审核"));
			}
			try{
				AppCommonUtil appCommon = new AppCommonUtil();
//				List<String> botIDs = appCommon.getBillBotMappings(ctx, "C48A423A","FA44FD5B", DefineSysEnum.BTP, true);
				
				List<Map<String,String>> botIDs = getToReceivingBillIDs(ctx);
//				botIDs.add("MO0sKFucTBiZEEOp3H0w7gRRIsQ=");
//				botIDs.add("");
//				botIDs.add("");
				if(botIDs != null && botIDs.size() > 0){
					// 当期单据
					SaleOrderInfo billInfo = SaleOrderFactory.getLocalInstance(ctx).getSaleOrderInfo(new ObjectUuidPK(pk));
					
					for(int i =0; i < botIDs.size(); i++){
						Map<String,String> botInfos = botIDs.get(i);
						String[] botID = {};
						botID = botInfos.keySet().toArray(botID);
						String botMappingID =botID[0];
						String botName = botInfos.get(botMappingID);
						// 不符合条件的话 则跳过 不 调用botp
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
							
							
								// 审核应收单
//								if(objColl != null && objColl.size() > 0){
//									
//									for(int j = 0; j < objColl.size(); j++){
//										CoreBillBaseInfo destBillInfo = (CoreBillBaseInfo) objColl.getObject(j);
//										ReceivingBillInfo receivingBillInfo = (ReceivingBillInfo)destBillInfo;
//										// 审核生成的应收单
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
//							throw new BOSException("生成下游单据时发生异常",btpE);
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
				throw new EASBizException(new NumericExceptionSubItem("01","新销售折让处理生成下游单据报错"));
				// TODO: handle exception
			}
		}
		
	}
	/**
	 * 删除单据后清理折让日志
	 */
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		super._delete(ctx, pk);
		
		String cuid = ContextUtil.getCurrentCtrlUnit(ctx).getId().toString();
		boolean isEnableDiscount = DiscountFacadeFactory.getLocalInstance(ctx).isEnableDiscount(cuid);
		// 启用了新销售折让处理 则生成下游收款单
		if(isEnableDiscount){
			// 清除订单的日志
			DiscountFacadeFactory.getLocalInstance(ctx).removeOrderDsgridLogs(pk.toString());
		}
		
	}

	/**
	 * 获得从销售订单到 收款单的  botpid
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
			throw new BOSException("查询生成收款单botp内码时出错",sqle);
		}
		return ids;
	}
	/**************************************新折让添加逻辑  wgj 20150804 end***************************************************/
	
}
