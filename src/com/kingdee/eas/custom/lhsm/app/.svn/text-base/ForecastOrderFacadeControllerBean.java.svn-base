package com.kingdee.eas.custom.lhsm.app;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.bot.BOTRelationFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.base.permission.UserFactory;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.assistant.SystemStatusCtrolUtils;
import com.kingdee.eas.basedata.master.cssp.CustomerFactory;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.IMaterialInventory;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.MaterialInventoryCollection;
import com.kingdee.eas.basedata.master.material.MaterialInventoryFactory;
import com.kingdee.eas.basedata.master.material.MaterialSalesCollection;
import com.kingdee.eas.basedata.master.material.MaterialSalesFactory;
import com.kingdee.eas.basedata.master.material.MaterialSalesInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitFactory;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.IOrgSwitchFacade;
import com.kingdee.eas.basedata.org.OrgSwitchFacadeFactory;
import com.kingdee.eas.basedata.org.SaleOrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.basedata.scm.common.BizTypeInfo;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.basedata.scm.sd.sale.IPriceProvider;
import com.kingdee.eas.basedata.scm.sd.sale.PriceCondition;
import com.kingdee.eas.basedata.scm.sd.sale.PriceProviderFactory;
import com.kingdee.eas.basedata.scm.sd.sale.SaleGroupFactory;
import com.kingdee.eas.basedata.scm.sd.sale.SaleGroupInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.CodingUtil;
import com.kingdee.eas.custom.commld.ExceptionUtils;
import com.kingdee.eas.custom.lhsm.CompanyInvFactory;
import com.kingdee.eas.custom.lhsm.CompanyInvInfo;
import com.kingdee.eas.custom.lhsm.ForecastEnum;
import com.kingdee.eas.custom.lhsm.ISaleForecast;
import com.kingdee.eas.custom.lhsm.SaleForecastEntryCollection;
import com.kingdee.eas.custom.lhsm.SaleForecastEntryFactory;
import com.kingdee.eas.custom.lhsm.SaleForecastEntryInfo;
import com.kingdee.eas.custom.lhsm.SaleForecastFactory;
import com.kingdee.eas.custom.lhsm.SaleForecastInfo;
import com.kingdee.eas.custom.lhsm.WayOfTakingDeliveryEnum;
import com.kingdee.eas.custom.wlhllicensemanager.util.WlhlDynamicBillUtils;
import com.kingdee.eas.fi.ar.OtherBillFactory;
import com.kingdee.eas.fi.ar.OtherBillInfo;
import com.kingdee.eas.fi.cas.ReceivingBillFactory;
import com.kingdee.eas.fi.cas.ReceivingBillInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.EntryBaseStatusEnum;
import com.kingdee.eas.scm.im.inv.SaleIssueBillFactory;
import com.kingdee.eas.scm.im.inv.SaleIssueBillInfo;
import com.kingdee.eas.scm.im.inv.ws.ImportException;
import com.kingdee.eas.scm.im.inv.ws.util.InfoUtil;
import com.kingdee.eas.scm.sd.sale.ISaleOrder;
import com.kingdee.eas.scm.sd.sale.SaleOrderEntryInfo;
import com.kingdee.eas.scm.sd.sale.SaleOrderFactory;
import com.kingdee.eas.scm.sd.sale.SaleOrderInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
/**
 * 销售订单添加字段
 * cfissaleIssue boolean
 * @author leno
 *
 */
public class ForecastOrderFacadeControllerBean extends AbstractForecastOrderFacadeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.lhsm.app.ForecastOrderFacadeControllerBean");

	/**
	 * 
	 * <p>Title: _getSqlData</p>
	 * <p>Description: 查库</p>
	 * <p>继承方法</p>
	 * @param ctx
	 * @param sql
	 * @return
	 * @throws BOSException
	 */
	protected IRowSet _getSqlData(Context ctx, String sql) throws BOSException {

		IRowSet rs = com.kingdee.eas.util.app.DbUtil.executeQuery(ctx, sql);
		return rs;
	}

	/**
	 * 生成销售订单
	 * <p>Title: transToOrder</p>
	 * <p>Description: </p>
	 * <p>继承方法</p>
	 * @param ctx
	 * @param forecastId
	 * @param storageOrgId
	 * @return
	 * @throws Exception 
	 */

	public String[] _transToOrder(Context ctx, String forecastId,
			String storageOrgId,String currOrgUnitId)  {
		SaleOrderInfo info = new SaleOrderInfo();
		ObjectUuidPK objectUuidpk;
		String[] msg = new String[2];
		try{
			// 当前组织
			CompanyOrgUnitInfo currOrgUnitInfo = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(new ObjectUuidPK(currOrgUnitId));
			//			currOrgUnitInfo = BaseDataUtil.getCompanyInfo();
			PeriodInfo  currPeriod = SystemStatusCtrolUtils.getCurrentPeriod(ctx, SystemEnum.ACCOUNTSPAYABLE, currOrgUnitInfo);

			// 销售预报单
			SaleForecastInfo forecast = SaleForecastFactory.getLocalInstance(ctx).getSaleForecastInfo(new ObjectUuidPK(forecastId));
			//		forecast.get
			java.sql.Timestamp timeStamp = new Timestamp(System.currentTimeMillis());

			info.setCreator(forecast.getCreator());
			info.setCreateTime(timeStamp);

			info.setCU(forecast.getCU());
			info.setNumber("");
			info.setBizDate(forecast.getBizDate());
			info.setDescription("");
			// info.setHasEffected(true);//是否曾经开始
			// info.setAuditor(new UserInfo());
			info.setSourceBillId(forecast.getId().toString());
			// info.setSourceFunction("");

			// scmbillbase
			// info.setAuditTime(new Timestamp(0));
			info.setBaseStatus(BillBaseStatusEnum.ADD);
			// TODO
			BizTypeInfo bizType = new BizTypeInfo();

			//			info.setBizType(bizType);// 业务类型 生产领料
			// com.kingdee.eas.cp.ap.BillTypeInfo
			// billTypeinfo=BillTypeFactory.getLocalInstance(ctx).
			// getBillTypeInfo("50957179-0105-1000-e000-0163c0a812fd463ED552");
			//			info.setSourceBillType(sBillInfo.getBillType());
			//			info.setBillType(sBillInfo.getBillType());
			info.setYear(Calendar.getInstance().get(Calendar.YEAR));

			info.setPeriod(currPeriod.getNumber());//
			// info.setModifier(new UserInfo());
			// info.setModificationTime(new Timestamp(0));
			// invbillbase
			objectUuidpk = new ObjectUuidPK(storageOrgId);// 需要修改
			StorageOrgUnitInfo storageorgunitinfo = StorageOrgUnitFactory.getLocalInstance(ctx).getStorageOrgUnitInfo(objectUuidpk);
			info.setStorageOrgUnit(storageorgunitinfo);// 库存组织 需要修改
			CustomerInfo customerinfo=CustomerFactory.getLocalInstance(ctx).getCustomerInfo(new ObjectUuidPK(forecast.getCustomer().getId()));
			info.setOrderCustomer(customerinfo);// 订货客户
			//info.setSaleOrgUnit(forecast.getCompany());// 销售组织

			info.setSaleGroup(forecast.getSaleGroup());  // 销售组
			info.setSalePerson(forecast.getSalePerson()); // 销售员
			info.setIsInnerSale(false);// 内部销售


			//			info.setCurrency(sBillInfo.getCurrency());// 币别
			//			info.setExchangeRate(sBillInfo.getExchangeRate());// 汇率
			info.setPaymentType(forecast.getPayType());// 付款方式
			//info.setBizType(forecast.getBizType()); // 业务类别

			this.buildBillEntrys(ctx, info, forecast, forecast.getCU().getId().toString(), customerinfo.getId().toString());
			ISaleOrder ifac = SaleOrderFactory.getLocalInstance(ctx);
			ifac.save(info);
			msg[0] = "0";
			info = SaleOrderFactory.getLocalInstance(ctx).getSaleOrderInfo(new ObjectUuidPK(info.getId()));
			msg[1] = info.getNumber().toString();
			//		info.setAdminOrgUnit(sBillInfo.getReceiptAdminOrgUnit());// 部门 需要修改
			// info.setStocker(new PersonInfo());
			// info.setVoucher(new VoucherInfo());//
			// info.setTotalQty(new BigDecimal(0));//
			// info.setTotalAmount(new BigDecimal(0));//
			// info.setFiVouchered(true);//
			// info.setTotalStandardCost(new BigDecimal(0));//
			// info.setTotalActualCost(new BigDecimal(0));//
			// info.setIsReversed(true);
			// info.setIsInitBill(true);

			// SaleOrder
			//			

			//info.setCustomerOrderNumber(sBillInfo.getCustomerOrderNumber());// 客户订单号
			//		objectUuidpk = new ObjectUuidPK(forecast.getCustomer().getId());// 需要修改

			// 同销售公司销售订单订货客户
			//info.setDirectSupplier(sBillInfo.getDirectSupplier());// 直运供应商
			//info.setPurchaseOrgUnit(sBillInfo.getPurchaseOrgUnit());// 采购组织
			//info.setDeliveryType(sBillInfo.getDeliveryType());
			//		info.setTransLeadTime(0);// 运输提前期

			//info.setCashDiscount(sBillInfo.getCashDiscount());// 现金折扣
			//info.setSettlementType(sBillInfo.getSettlementType());// 结算方式
			//info.setPrepayment(sBillInfo.getPrepayment());// 预收金额
			//info.setPrepaymentRate(sBillInfo.getPrepaymentRate());

			//		objectUuidpk = new ObjectUuidPK(cuInfo.getId().toString());// 需要修改
			//		SaleOrgUnitInfo saleOrgUnitInfo=SaleOrgUnitFactory.getLocalInstance(ctx).getSaleOrgUnitInfo(objectUuidpk);


			//info.setSaleGroup(sBillInfo.getSaleGroup());// 销售组
			//info.setSalePerson(sBillInfo.getSalePerson());// 销售员
			//			info.setAdminOrgUnit(sBillInfo.getReceiptAdminOrgUnit());// 部门
			//info.setTotalAmount(sBillInfo.getTotalAmount());// 金额
			//info.setTotalTax(sBillInfo.getTotalTax());// 税额
			//info.setTotalTaxAmount(sBillInfo.getTotalTaxAmount());// 价税合计
			//info.setPreReceived(sBillInfo.getPreReceived());// 已收应收款
			//info.setUnPrereceivedAmount(sBillInfo.getUnPrereceivedAmount());// 未预收款金额
			//info.setSendAddress(sBillInfo.getSendAddress());// 送货地址
			//info.setIsSysBill(sBillInfo.isIsSysBill());// 是否系统单据
			//info.setConvertMode(sBillInfo.getConvertMode());// 折算方式
			//info.setLocalTotalAmount(sBillInfo.getLocalTotalAmount());// 金额本位币合计
			//info.setLocalTotalTaxAmount(sBillInfo.getLocalTotalTaxAmount());// 价税合计本位币

			objectUuidpk = new ObjectUuidPK(forecast.getCompany().getId().toString());// 需要修改
			CompanyOrgUnitInfo companyOrgUnitInfo=CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(objectUuidpk);
			info.setCompanyOrgUnit(companyOrgUnitInfo);// 财务组织

			info.setIsInTax(false);// 是否含税
			info.setCustomerPhone(forecast.getLinkmanTel());// 联系电话
			info.setLinkMan(forecast.getLinkman());// 联系人
			//		info.setAlterPerson(sBillInfo.getAlterPerson());// 变更人
			//info.setOldID(sBillInfo.getOldID());// 原ID
			//info.setOldStatus(sBillInfo.getOldStatus());// 旧的状态值
			info.setVersion(0);
			//		info.setAlterDate(sBillInfo.getAlterDate());// 变更时间
			//info.setIsCentralBalance(sBillInfo.isIsCentralBalance());// 集中结算

			//		objectUuidpk = new ObjectUuidPK(cuInfo.getId().toString());// 需要修改
			//		StorageOrgUnitInfo storageOrgUnitInfo=StorageOrgUnitFactory.getLocalInstance(ctx).getStorageOrgUnitInfo(objectUuidpk);
			//		info.setStorageOrgUnit(storageOrgUnitInfo);// 库存组织

			//info.setIsReverse(sBillInfo.isIsReverse());
			//info.setBeenPaidPrepayment(sBillInfo.getBeenPaidPrepayment());// 已收预收款金额
			//info.setReceiveCondition(sBillInfo.getReceiveCondition());// 收款条件

			//		return super.transToOrder(ctx, forecastId, storageOrgId);
		}catch(Exception e){
			msg[0]="1";
			msg[1] = e.getMessage();

		}
		return msg;
	}

	public String[] _rejectForecast(Context ctx, String forecasId)
	throws BOSException, EASBizException {
		// 销售预报单
		SaleForecastInfo forecast = SaleForecastFactory.getLocalInstance(ctx).getSaleForecastInfo(new ObjectUuidPK(forecasId));
		if(forecast != null){
			forecast.setState(ForecastEnum.SUBJECT);
			SaleForecastFactory.getLocalInstance(ctx).update(new ObjectUuidPK(forecast.getId()), forecast);
		}

		return super.rejectForecast(ctx, forecasId);
	}
	/**
	 * 执行更新删除操作接口
	 * <p>Title: _execSql</p> 
	 * <p>Description: </p>
	 * <p>继承方法</p>
	 * @param ctx
	 * @param sql
	 * @return
	 * @throws BOSException
	 */
	protected boolean _execSql(Context ctx, String sql) throws BOSException {
		com.kingdee.eas.util.app.DbUtil.execute(ctx, sql);
		return true;
	}

	/**
	 * 生成订单分录
	 * <p>Title: buildBillEntrys</p>
	 * <p>Description: </p>
	 * 
	 * @param ctx
	 * @param saleInfo
	 * @param forecast
	 * @param fCuId
	 * @param fcustomerid
	 * @throws Exception 
	 */
	protected void buildBillEntrys(Context ctx, SaleOrderInfo saleInfo,
			SaleForecastInfo forecast,String fCuId,String fcustomerid) throws Exception {


		java.sql.Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		// 行政组织 初始化
		ObjectUuidPK objectUuidpk = new ObjectUuidPK(fCuId);// 需要修改
		CtrlUnitInfo cuInfo = CtrlUnitFactory.getLocalInstance(ctx).getCtrlUnitInfo(objectUuidpk);
		if (cuInfo == null) {
			throw new ImportException(ImportException.CUEXCEPTION);
		}
		// 加载销售预报单
		forecast = SaleForecastFactory.getLocalInstance(ctx).getSaleForecastInfo(new ObjectUuidPK(forecast.getId()));
		// 预报单分录
		SaleForecastEntryCollection entrys = forecast.getEntrys();
		// 订单分录
		//		SaleOrderEntryCollection saleOrderEntrys = new SaleOrderEntryCollection();
		for(int i = 0; i < entrys.size(); i++){
			// 获取预报单分录
			SaleForecastEntryInfo saleForecastInfo = entrys.get(i);
			ObjectUuidPK saleForecastInfoPK = new ObjectUuidPK(saleForecastInfo.getId());
			saleForecastInfo = SaleForecastEntryFactory.getLocalInstance(ctx).getSaleForecastEntryInfo(saleForecastInfoPK);
			// 订单分录
			SaleOrderEntryInfo info = new SaleOrderEntryInfo();
			// corebillentrybase
			info.setSeq(0);

			//scmbillentrybase
			MaterialInfo materialInfo = saleForecastInfo.getMaterialNumber();
			materialInfo = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(materialInfo.getId()));
			info.setMaterial(materialInfo);
			info.setAssistProperty(null);//辅助属性
			info.setUnit(saleForecastInfo.getMeasureUnit());
			//			info.setUnit(saleForecastInfo.getu)
			info.setSourceBillId(saleForecastInfo.getParent().getId().toString());
			info.setSourceBillNumber(saleForecastInfo.getParent().getNumber());
			info.setSourceBillEntryId(saleForecastInfo.getId().toString());

			//info.setAssCoefficient(new BigDecimal(""));
			info.setBaseStatus(EntryBaseStatusEnum.ADD);
			//			info.setAssociateQty(sBillInfo.getAssociateQty());
			//info.setSourceBillType(new BillTypeInfo());
			info.setBaseUnit(materialInfo.getBaseUnit());
			info.setAssistUnit(materialInfo.getAssistUnit());
			//info.setRemark("");
			//info.setReasonCode(new ReasonCodeInfo());

			//saleOrderEntry
			//info.setIsPresent(true);
			info.setBaseQty(saleForecastInfo.getBaseQty());
			info.setQty(saleForecastInfo.getQty());
			//			info.setAssistQty(sBillInfo.getAssistQty());
			//			info.setPrice(sBillInfo.getPrice());
			//			info.setTaxPrice(sBillInfo.getTaxPrice());
			//			info.setCheapRate(null);
			//			info.setDiscountCondition(DiscountConditionEnum.AMOUNT);
			//			info.setDiscountType(DiscountModeEnum.PERCENT);
			//			info.setDiscount(null);
			//			info.setDiscountAmount(null);
			info.setAmount(saleForecastInfo.getBaseQty());

			//			info.setLocalAmount(sBillInfo.getLocalAmount());
			//			info.setActualPrice(sBillInfo.getActualPrice());
			//			info.setActualTaxPrice(sBillInfo.getActualTaxPrice());
			//			info.setTaxPrice(sBillInfo.getTaxPrice());
			//			info.setTax(sBillInfo.getTax());
			//			info.setTaxAmount(sBillInfo.getTaxAmount());
			info.setSendDate(new Date());
			info.setDeliveryDate(timeStamp);

			objectUuidpk = new ObjectUuidPK(cuInfo.getId().toString());// 需要修改
			StorageOrgUnitInfo storageorgunitinfo = StorageOrgUnitFactory.getLocalInstance(ctx).getStorageOrgUnitInfo(objectUuidpk);
			info.setStorageOrgUnit(storageorgunitinfo);// 库存组织

			objectUuidpk = new ObjectUuidPK(cuInfo.getId().toString());// 需要修改
			CompanyOrgUnitInfo companyorgunitinfo = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(objectUuidpk);
			info.setCompanyOrgUnit(companyorgunitinfo);


			WarehouseInfo warehouserInfo=getMaterialInventory(ctx,companyorgunitinfo,saleForecastInfo.getMaterialNumber());;
			info.setWarehouse(warehouserInfo);

			//info.setSendOverRate(null);

			//			info.setSendOwingRate(null);
			//			info.setSendAdvanceDay(null);
			//			info.setSendDeferralDay(null);
			//			info.setTotalIssueQty(null);
			//			info.setTotalReturnedQty(null);
			//			info.setTotalInvoicedQty(null);
			//			info.setTotalShippingQty(null);
			//			info.setTotalReceivedAmount(null);
			//			info.setParent(null);
			//			info.setTotalIssueBaseQty(null);

			//			info.setTotalReBaseQty(null);
			//			info.setTotalShipBaseQty(null);
			//			info.setTotalUnReturnBaseQty(null);
			//			info.setTotalUnIssueBaseQty(null);
			//			info.setTotalUnShipBaseQty(null);
			//			info.setTotalUnIssueQty(null);
			//			info.setIsLocked(true);
			//			info.setLockQty(null);
			//			info.setLockBaseQty(null);
			//			info.setLockAssistQty(null);
			//			info.setLocalTax(null);
			//			info.setLocalTaxAmount(null);
			//			info.setIsBySaleOrder(true);
			//			info.setOrderedQty(null);
			//			info.setUnOrderedQty(null);
			//			info.setPrepaymentRate(null);
			//			info.setPrepayment(null);
			//			info.setPreReceived(null);
			//			info.setUnPrereceivedAmount(null);
			//			info.setQuantityUnCtrl(true);
			//			info.setTimeUnCtrl(true);

			objectUuidpk = new ObjectUuidPK(fcustomerid);// 需要修改
			CustomerInfo customerinfo=CustomerFactory.getLocalInstance(ctx).getCustomerInfo(objectUuidpk);
			info.setDeliveryCustomer(customerinfo);
			info.setPaymentCustomer(customerinfo);
			info.setReceiveCustomer(customerinfo);
			if(saleInfo != null && saleInfo.getEntries() != null){
				saleInfo.getEntries().add(info);
			}

		}




	}
	/**
	 * 
	 * <p>Title: getMaterialInventory</p>
	 * <p>Description: </p>
	 * 
	 * @param ctx
	 * @param aCompanyOrgUnitInfo
	 * @param materialInfo
	 * @return
	 * @throws Exception
	 */
	private WarehouseInfo getMaterialInventory(Context ctx,
			CompanyOrgUnitInfo aCompanyOrgUnitInfo, MaterialInfo materialInfo)
	throws Exception {
		WarehouseInfo warehouserInfo = null;
		if (aCompanyOrgUnitInfo != null && materialInfo != null) {
			EntityViewInfo viewInfo = new EntityViewInfo();
			FilterInfo filterInfo = new FilterInfo();
			FilterItemInfo filterItemMaterialInfo = new FilterItemInfo("material", materialInfo.getId().toString(),CompareType.EQUALS);
			FilterItemInfo filterItemOrgInfo = new FilterItemInfo("CU",aCompanyOrgUnitInfo.getId().toString(), CompareType.EQUALS);
			filterInfo.getFilterItems().add(filterItemMaterialInfo);
			filterInfo.getFilterItems().add(filterItemOrgInfo);
			filterInfo.setMaskString("#0 and #1");
			viewInfo.setFilter(filterInfo);
			IMaterialInventory iMaterialInventory = MaterialInventoryFactory.getLocalInstance(ctx);
			MaterialInventoryCollection materialCostCollection = iMaterialInventory.getMaterialInventoryCollection(viewInfo);
			if (materialCostCollection != null&& materialCostCollection.size() > 0){
				return materialCostCollection.get(0).getDefaultWarehouse();
			}else{
				return warehouserInfo;
			}	
		} else {
			return warehouserInfo;
		}
	}
	protected void _saleorder(Context ctx,String id) throws BOSException {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select distinct fcompanyid,fcustomerid ");
			sql.append(" from ct_lhs_saleforecastentry2");
			sql.append(" where isnull(fstatus,0)=0 ");
			sql.append(" and FParentid='"+id+"' ");
			IRowSet rs=com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,sql.toString());
			if(rs != null && rs.size() > 0){
				while(rs.next()){
					InvBillSaleOrderB aa=new InvBillSaleOrderB();
					aa.saleOrderA(ctx,id,rs.getString("fcompanyid"), rs.getString("fcustomerid"));
				}	
			}
		} catch (SQLException e) {
			throw new BOSException("生成销售订单错误：",e);
		} catch (Exception e) {
			throw new BOSException("生成销售订单错误：",e);
		}
	}

	/*protected void _addSaleForecast(Context ctx) throws BOSException {
		try {
			String cuid="";
			String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=TempK3db "; //mydb为数据库 
			String user="sa";
			String password="sunshine";
			StringBuffer sql=new StringBuffer();
			sql.append("select * from t_lhs_database ");
			IRowSet rsb=com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,sql.toString());
			if(rsb.next()){
				url=rsb.getString("furl");
				user=rsb.getString("fuser");
				password=rsb.getString("fpassword");
			}

			sql=new StringBuffer();
			sql.append("select * from t_org_company where fnumber='70000' ");
			rsb=com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,sql.toString());
			if(rsb.next()){
				cuid=rsb.getString("fid");
			}

			DbCon dbcon=new DbCon(url,user,password);
			sql=new StringBuffer();
			sql.append("select * from ct_lhs_SaleForecast where  cfstate='2' ");
			ResultSet rs=dbcon.excutequery(sql.toString());
			while(rs.next()){
				SaleForecastInfo info=new SaleForecastInfo();
				addSaleForecastInfo(ctx,info,cuid,rs);
				String fid=rs.getString("fid");
				sql=new StringBuffer();
				sql.append(" select * from Ct_Lhs_Saleforecastentry  ");
				sql.append(" where  fparentid='"+fid+"' ");
				DbCon dbcona=new DbCon(url,user,password);
				ResultSet rsa=dbcona.excutequery(sql.toString());
				while(rsa.next()){
					SaleForecastEntryInfo entryinfo=new SaleForecastEntryInfo();
					addSaleForecastEntryInfo(ctx,entryinfo,cuid,rsa);
					info.getEntrys().add(entryinfo);
				}
				dbcona.disconnect();
				if(info!=null){
					SaleForecastFactory.getLocalInstance(ctx).submit(info);
					SaleForecastFactory.getLocalInstance(ctx).audit(info);
				}
				dbcona=new DbCon(url,user,password);
				dbcona.execute("update ct_lhs_SaleForecast set cfstate='3' where fid='"+fid+"' ");
				dbcona.disconnect();
			}
			dbcon.disconnect();
		} catch (SQLException e) {
			throw new BOSException("查询错误：",e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BOSException("查询错误：",e);
		}
		super._addSaleForecast(ctx);
	}*/
	public void addSaleForecastEntryInfo(Context ctx,SaleForecastEntryInfo entryinfo,String cuid,ResultSet rs) throws EASBizException, BOSException, SQLException{

		ObjectUuidPK pk = new ObjectUuidPK(rs.getString("CFMATERIALID"));
		MaterialInfo materialinfo=MaterialFactory.getLocalInstance(ctx).getMaterialInfo(pk);
		entryinfo.setMaterialNumber(materialinfo);
		entryinfo.setMaterialName(materialinfo.getName());


		pk = new ObjectUuidPK(materialinfo.getBaseUnit().getId());// 需要修改
		MeasureUnitInfo baseunitinfo=MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(pk);
		entryinfo.setBaseUnit(baseunitinfo);

		MeasureUnitInfo unitinfo=null;
		BigDecimal coefficient=BigDecimal.ZERO;
		FilterInfo filterinfo = new FilterInfo();
		filterinfo.getFilterItems().add(new FilterItemInfo("CU.id", cuid));
		filterinfo.getFilterItems().add(new FilterItemInfo("material.id", materialinfo.getId()));
		filterinfo.setMaskString("#0 and #1");
		EntityViewInfo evi = new EntityViewInfo();
		evi.setFilter(filterinfo);
		MaterialSalesCollection mInvc = MaterialSalesFactory.getLocalInstance(ctx).getMaterialSalesCollection(evi);
		if (mInvc.size() > 0) {
			MaterialSalesInfo materialInvInfo = (MaterialSalesInfo) mInvc.get(0);

			pk = new ObjectUuidPK(materialInvInfo.getUnit().getId());// 需要修改
			unitinfo=MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(pk);

			if(unitinfo==null){
				unitinfo=baseunitinfo;
			}
			entryinfo.setMeasureUnit(unitinfo);
			coefficient=unitinfo.getCoefficient();
		}
		if(coefficient==null)coefficient=new BigDecimal("1");
		if(coefficient.compareTo(new BigDecimal("0"))==0)coefficient=new BigDecimal("1");


		BigDecimal basePrice=rs.getBigDecimal("cfbaseprice");
		BigDecimal price=basePrice.multiply(coefficient);
		BigDecimal amount=rs.getBigDecimal("cfamount");
		BigDecimal baseqty=rs.getBigDecimal("cfbaseqty");
		BigDecimal qty=baseqty.divide(coefficient,2,4);

		//saleOrderEntry
		entryinfo.setPrice(price);
		entryinfo.setBasePrice(basePrice);
		entryinfo.setQty(qty);
		entryinfo.setBaseQty(baseqty);
		entryinfo.setAmount(amount);
		entryinfo.setQtya(new BigDecimal("0"));
		entryinfo.setQtyb(baseqty);
		entryinfo.setRemark(rs.getString("CFRemark"));
		if(rs.getString("CFCOMPANYID")!=null){
			pk = new ObjectUuidPK(rs.getString("CFCOMPANYID"));
			CompanyOrgUnitInfo orgunitInfo=CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(pk);
			entryinfo.setCompany(orgunitInfo);
		}
		entryinfo.setSourceEntryId(rs.getString("fid"));
	}
	public void addSaleForecastInfo(Context ctx,SaleForecastInfo info,String cuid,ResultSet rs) throws EASBizException, BOSException, SQLException{
		String fid=rs.getString("fid");
		ObjectUuidPK pk=null;
		//coreBase
		//info.setId(BOSUuid.read(fid));
		// objectbase
		java.sql.Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		info.setCreateTime(timeStamp);
		// disItemInfoA.setLastUpdateUser(new UserInfo());
		// disItemInfoA.setLastUpdateTime(null);
		pk = new ObjectUuidPK(cuid);
		CtrlUnitInfo cuInfo = CtrlUnitFactory.getLocalInstance(ctx).getCtrlUnitInfo(pk);// 需要修改
		info.setCU(cuInfo);

		CompanyOrgUnitInfo companyinfo=CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(pk);
		info.setCompany(companyinfo);
		//CoreBillBase
		info.setNumber(rs.getString("fnumber"));
		info.setBizDate(new Date());//new Date()
		// info.setHandler(new UserInfo());
		info.setDescription("");
		// info.setHasEffected(true);//是否曾经开始
		// info.setAuditor(new UserInfo());
		info.setSourceBillId(fid);
		// info.setSourceFunction("");

		pk = new ObjectUuidPK(rs.getString("CFCUSTOMERID"));
		CustomerInfo customerinfo=CustomerFactory.getLocalInstance(ctx).getCustomerInfo(pk);
		info.setCustomer(customerinfo);

		info.setLinkman(rs.getString("CFLINKMAN"));
		info.setLinkmanTel(rs.getString("CFLINKMANTEL"));
		info.setDescription(rs.getString("FDescription"));
		info.setSendAddress(rs.getString("CFSENDADDRESS"));
		info.setWayOfTakingDelivery(WayOfTakingDeliveryEnum.SEND);

		pk = new ObjectUuidPK(rs.getString("CFSALEPERSONID"));
		//SalePersonInfo salePerson=SalePersonFactory.getLocalInstance(ctx).getSalePersonInfo(pk);
		PersonInfo personinfo=PersonFactory.getLocalInstance(ctx).getPersonInfo(pk);
		if(personinfo!=null){
			//pk = new ObjectUuidPK(salePerson.getPerson().getId());
			//PersonInfo personinfo=PersonFactory.getLocalInstance(ctx).getPersonInfo(pk);
			info.setSalePerson(personinfo);

			StringBuffer sql=new StringBuffer();
			sql.append("select * from t_bd_saleperson where fpersonid='"+personinfo.getId().toString()+"' ");
			IRowSet rsb=com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,sql.toString());
			if(rsb.next()){
				pk = new ObjectUuidPK(rsb.getString("FSaleGroupID"));
				SaleGroupInfo saleGroupinfo=SaleGroupFactory.getLocalInstance(ctx).getSaleGroupInfo(pk);
				info.setSaleGroup(saleGroupinfo);
			}

			sql=new StringBuffer();
			sql.append("select * from t_pm_user t where t.fpersonid='"+personinfo.getId().toString()+"' ");
			rsb=com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,sql.toString());
			if(rsb.next()){
				String fUserid = rsb.getString("fid");
				pk = new ObjectUuidPK(fUserid);
				UserInfo creatorInfo = UserFactory.getLocalInstance(ctx).getUserInfo(pk);
				info.setCreator(creatorInfo);
			}else{
				String fUserid = ((UserInfo) ctx.get("UserInfo")).getId().toString();
				pk = new ObjectUuidPK(fUserid);
				UserInfo creatorInfo = UserFactory.getLocalInstance(ctx).getUserInfo(pk);
				info.setCreator(creatorInfo);
			}
		}
		pk = new ObjectUuidPK("40b75328-7f57-463f-8d19-280574ef24bf6BCA0AB5");
		com.kingdee.eas.basedata.assistant.PaymentTypeInfo paymentTypeInfo=com.kingdee.eas.basedata.assistant.PaymentTypeFactory.getLocalInstance(ctx).getPaymentTypeInfo(pk);
		info.setPayType(paymentTypeInfo);

		info.setState(ForecastEnum.SUBMIT);
	}

	/*protected void _updateSaleForecast(Context ctx, String id)throws BOSException {
		try {
			String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=TempK3db "; //mydb为数据库 
			String user="sa";
			String password="sunshine";
			StringBuffer sql=new StringBuffer();
			sql.append("select * from t_lhs_database ");
			IRowSet rsb=com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,sql.toString());
			if(rsb.next()){
				url=rsb.getString("furl");
				user=rsb.getString("fuser");
				password=rsb.getString("fpassword");
			}


			sql=new StringBuffer();
			sql.append(" select isnull(t1.FSourceBillId,'') FSourceBillId, t1.cfstate cfstate,t2.fid fentryid,   ");
			sql.append(" isnull(CFsourceEntryId,'') FsourceEntryId, ");
			sql.append(" isnull(t2.cfqtya,0) cfqtya,isnull(t2.cfqtyb,0) cfqtyb ");
			sql.append(" from Ct_Lhs_Saleforecast t1 ");
			sql.append(" inner join Ct_Lhs_Saleforecastentry t2 on t2.fparentid=t1.fid ");
			sql.append(" where t1.fid='"+id+"' ");
			IRowSet rs=com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,sql.toString());
			int i=0;
			while(rs.next()){
				String sourcebillid=rs.getString("FSourceBillId");
				String state=rs.getString("cfstate");
				if(sourcebillid==null)sourcebillid="";
				if(!sourcebillid.equals("")){
					if(state.equals("-1")){
						DbCon dbcon=new DbCon(url,user,password);
						sql=new StringBuffer();
						sql.append(" update Ct_Lhs_Saleforecast set cfstate='"+rs.getString("cfstate")+"' ");
						sql.append(" where fid='"+sourcebillid+"' ");
						dbcon.execute(sql.toString());
						dbcon.disconnect();

						sql=new StringBuffer();
						sql.append("delete Ct_Lhs_Saleforecastentry where fparentid='"+id+"'");
						com.kingdee.eas.util.app.DbUtil.execute(ctx,sql.toString());

						sql=new StringBuffer();
						sql.append("delete Ct_Lhs_Saleforecast where fid='"+id+"'");
						com.kingdee.eas.util.app.DbUtil.execute(ctx,sql.toString());
					}else{
						if(i==0){

							sql=new StringBuffer();
							sql.append(" update Ct_Lhs_Saleforecast set cfstate='"+rs.getString("cfstate")+"' ");
							sql.append(" where fid='"+sourcebillid+"' ");
							DbCon dbcon=new DbCon(url,user,password);
							dbcon.execute(sql.toString());
							dbcon.disconnect();

							sql=new StringBuffer();
							sql.append(" update Ct_Lhs_Saleforecastentry set cfqtya='"+rs.getString("cfqtya")+"', ");
							sql.append(" cfqtyb='"+rs.getString("cfqtyb")+"' ");
							sql.append(" where fid='"+rs.getString("FsourceEntryId")+"' ");
							dbcon=new DbCon(url,user,password);
							dbcon.execute(sql.toString());
							dbcon.disconnect();
						}else{

							sql=new StringBuffer();
							sql.append(" update Ct_Lhs_Saleforecastentry set cfqtya='"+rs.getString("cfqtya")+"', ");
							sql.append(" cfqtyb='"+rs.getString("cfqtyb")+"' ");
							sql.append(" where fid='"+rs.getString("FsourceEntryId")+"' ");
							DbCon dbcon=new DbCon(url,user,password);
							dbcon.execute(sql.toString());
							dbcon.disconnect();
						}
					}
					i=i+1;
				}
			}

		} catch (SQLException e) {
			throw new BOSException("查询错误：",e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BOSException("查询错误：",e);
		}
		super._updateSaleForecast(ctx, id);
	}*/
	protected void _companyInv(Context ctx, String cuid) throws BOSException {
		StringBuffer sql=new StringBuffer();
		try {
			sql=new StringBuffer();
			sql.append("select t1.fcompanyorgunitid fcompanyid,t1.fmaterialid,t1.fbaseqty fqty ");
			sql.append(" from T_IM_Inventory t1");
			sql.append(" inner join t_org_company t2 on t2.fid=t1.fcompanyorgunitid");
			sql.append(" where t2.fparentid= '"+cuid+"' ");
			IRowSet rs=com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,sql.toString());
			int i=0;
			while(rs.next()){

				String  companyid=rs.getString("fcompanyid");
				String materialid=rs.getString("fmaterialid");
				sql=new StringBuffer();
				sql.append("select * from ct_lhs_companyinv ");
				sql.append(" where cfcompanyid='"+companyid+"' ");
				sql.append(" and cfmaterialid='"+materialid+"' ");
				IRowSet rsa=com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,sql.toString());
				if(rsa.next()){

				}else{
					CompanyInvInfo info = new CompanyInvInfo();

					//coreBase
					info.setId(null);
					// objectbase
					String userid = ((UserInfo) ctx.get("UserInfo")).getId().toString();
					ObjectUuidPK pk = new ObjectUuidPK(userid);
					UserInfo userinfo = new UserInfo();
					userinfo.setId(BOSUuid.read(userid));
					info.setCreator(userinfo);

					java.sql.Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
					info.setCreateTime(timeStamp);
					// disItemInfoA.setLastUpdateUser(new UserInfo());
					// disItemInfoA.setLastUpdateTime(null);
					pk = new ObjectUuidPK(companyid);
					CtrlUnitInfo cuInfo = CtrlUnitFactory.getLocalInstance(ctx).getCtrlUnitInfo(pk);// 需要修改
					info.setCU(cuInfo);

					// database
					String fNumber = "";
					Date date = new Date();
					if (isCodeRuleEnable(ctx, info, cuInfo.getId().toString()) == true) {
						fNumber = this.getAutoCode(ctx, info, cuInfo.getId().toString());
					}
					if (!fNumber.equals("")) {
					} else {
						fNumber = String.valueOf(date.getYear() + 1900)
						+ String.valueOf(date.getMonth() + 1)
						+ String.valueOf(date.getDate())+String.valueOf(date.getSeconds()+"0"+String.valueOf(i));

						i=i+1;
					}
					info.setNumber(fNumber);
					info.setName("公司及时库存");
					// disItemInfoA.setDescription("");
					// disItemInfoA.setSimpleName("");

					//DisItem
					//info.setTreeid();
					pk = new ObjectUuidPK(companyid);
					CompanyOrgUnitInfo companyInfo = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(pk);// 需要修改
					info.setCompany(companyInfo);

					pk = new ObjectUuidPK(materialid);
					MaterialInfo materialinfo =MaterialFactory.getLocalInstance(ctx).getMaterialInfo(pk);// 需要修改
					info.setMaterial(materialinfo);

					info.setQty(rs.getBigDecimal("fqty"));


					CompanyInvFactory.getLocalInstance(ctx).submit(info);
				}
			} 
		} catch (EASBizException e) {
			throw new BOSException("错误：",e);
		} catch (SQLException e) {
			throw new BOSException("错误：",e);
		}
	}
	protected void _companyInv(Context ctx, String cuids, String materialids)
	throws BOSException {
		StringBuffer sql=new StringBuffer();
		try {
			sql = new StringBuffer();
			sql.append("delete from ct_lhs_companyinv ");
			com.kingdee.eas.util.app.DbUtil.execute(ctx,sql.toString());

			sql=new StringBuffer();
			sql.append(" select t1.fcompanyorgunitid fcompanyid,t1.fmaterialid,sum(t1.fbaseqty) fbaseqty ");
			sql.append(" from T_IM_Inventory t1");
			sql.append(" inner join t_org_company t2 on t2.fid=t1.fcompanyorgunitid");
			//sql.append(" inner join  ct_czc_ssorglist t4 on t4.cforgidid = t1.fcompanyorgunitid ");
			sql.append(" left join t_db_warehouse t3 on t1.fwarehouseid = t3.fid  ");
			sql.append(" where (t3.fname_l2 like '%鸭产品%' or t3.fname_l2 like '%副产品%') ");
			if(!materialids.equals("")){
				sql.append(" and t1.fmaterialid in ("+materialids+") ");
			}
			if(!cuids.equals("")){
				sql.append(" and t2.fid in ("+cuids+") ");
			}else{
				sql.append(" and t2.fid in ( select CFORGIDID from T_LHS_SSorgList) ");
			}

			sql.append(" group by  t1.fcompanyorgunitid,t1.fmaterialid");
			IRowSet rs=com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,sql.toString());
			int i=0;
			while(rs.next()){
				String  companyid=rs.getString("fcompanyid");
				String materialid=rs.getString("fmaterialid");
				BigDecimal baseqty=rs.getBigDecimal("fbaseqty");
				if(baseqty==null)baseqty=new BigDecimal("0");
				sql=new StringBuffer();
				sql.append(" select * from ct_lhs_companyinv ");
				sql.append(" where cfcompanyid='"+companyid+"' ");
				sql.append(" and cfmaterialid='"+materialid+"' ");
				IRowSet rsa=com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,sql.toString());
				if(rsa.next()){
					String fid=rsa.getString("fid");
					sql=new StringBuffer();
					sql.append(" update ct_lhs_companyinv set cfqty="+baseqty+" ");
					sql.append(" where fid='"+fid+"' ");
					com.kingdee.eas.util.app.DbUtil.execute(ctx,sql.toString());
				}else{
					CompanyInvInfo info = new CompanyInvInfo();

					//coreBase
					info.setId(null);
					// objectbase
					String fUserid = ((UserInfo) ctx.get("UserInfo")).getId().toString();
					ObjectUuidPK pk = new ObjectUuidPK(fUserid);
					UserInfo creatorInfo = UserFactory.getLocalInstance(ctx).getUserInfo(pk);
					info.setCreator(creatorInfo);

					java.sql.Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
					info.setCreateTime(timeStamp);
					// disItemInfoA.setLastUpdateUser(new UserInfo());
					// disItemInfoA.setLastUpdateTime(null);
					pk = new ObjectUuidPK(companyid);
					CtrlUnitInfo cuInfo = CtrlUnitFactory.getLocalInstance(ctx).getCtrlUnitInfo(pk);// 需要修改
					info.setCU(cuInfo);

					// database
					String fNumber = "";
					Date date = new Date();
					if (isCodeRuleEnable(ctx, info, cuInfo.getId().toString()) == true) {
						fNumber = this.getAutoCode(ctx, info, cuInfo.getId().toString());
					}
					if (!fNumber.equals("")) {
					} else {
						fNumber = String.valueOf(date.getYear() + 1900)
						+ String.valueOf(date.getMonth() + 1)
						+ String.valueOf(date.getDate())+String.valueOf(date.getSeconds()+"0"+String.valueOf(i));

						i=i+1;
					}
					info.setNumber(fNumber);
					info.setName("公司即时库存");
					// disItemInfoA.setDescription("");
					// disItemInfoA.setSimpleName("");

					//DisItem
					//info.setTreeid();
					pk = new ObjectUuidPK(companyid);
					CompanyOrgUnitInfo companyInfo = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(pk);// 需要修改
					info.setCompany(companyInfo);

					pk = new ObjectUuidPK(materialid);
					MaterialInfo materialinfo =MaterialFactory.getLocalInstance(ctx).getMaterialInfo(pk);// 需要修改
					info.setMaterial(materialinfo);
					info.setQty(baseqty);
					CompanyInvFactory.getLocalInstance(ctx).submit(info);
				}
			}
			//待出库库存（销售订单未关闭）
			BigDecimal saleorderbqty=new BigDecimal("0");
			sql=new StringBuffer();
			sql.append(" select t1.fcontrolunitid,t2.fmaterialid, ");
			sql.append(" sum(isnull(t2.fbaseqty,0)) fbaseqty ");
			sql.append(" from t_sd_saleorder t1 ");
			sql.append(" inner join t_sd_saleorderentry t2 on t2.fparentid=t1.fid ");
			//sql.append(" inner join  ct_czc_ssorglist t4 on t4.cforgidid = t1.fcontrolunitid ");
			sql.append("where t1.fbasestatus != 7  ");
			if(!cuids.equals("")){
				sql.append(" and t1.fcontrolunitid in("+cuids+")  ");
			}
			if(!materialids.equals("")){
				sql.append(" and t2.fmaterialid in("+materialids+")  ");
			}
			sql.append(" and isnull(t1.cfissaleIssue,0)=0 ");
			sql.append(" and t1.FbizDate>= {ts '2011-11-01'}");
			sql.append(" group by t1.fcontrolunitid,t2.fmaterialid ");
			//sql.append(" and t1.fnumber like '%SO%'");
			rs=com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,sql.toString());
			i=0;
			while(rs.next()){
				String companyid=rs.getString("fcontrolunitid");
				String materialid=rs.getString("fmaterialid");
				BigDecimal baseqty=rs.getBigDecimal("fbaseqty");
				if(baseqty==null)baseqty=new BigDecimal("0");
				sql=new StringBuffer();
				sql.append(" select * from ct_lhs_companyinv ");
				sql.append(" where cfcompanyid='"+companyid+"' ");
				sql.append(" and cfmaterialid='"+materialid+"' ");
				IRowSet rsa=com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,sql.toString());
				if(rsa.next()){
					String fid=rsa.getString("fid");
					sql=new StringBuffer();
					sql.append(" update ct_lhs_companyinv set cfqty1="+baseqty+"");
					sql.append(" where fid='"+fid+"' ");
					com.kingdee.eas.util.app.DbUtil.execute(ctx,sql.toString());
				}
			}
			//处理可出库库存
			sql=new StringBuffer();
			sql.append(" /*dialect*/update ct_lhs_companyinv set cfqty2=nvl(cfqty,0)-nvl(cfqty1,0) ");
			com.kingdee.eas.util.app.DbUtil.execute(ctx,sql.toString()); 
		} catch (EASBizException e) {
			throw new BOSException("错误：",e);
		} catch (SQLException e) {
			throw new BOSException("错误：",e);
		}
	}

	protected boolean isCodeRuleEnable(Context ctx, IObjectValue objValue,
			String companyId) throws EASBizException, BOSException {
		// String companyId = OrgInnerUtils.getCurCompany();
		// ICodingRuleManager codeRuleMgr = null;
		ICodingRuleManager codeRuleMgr = CodingRuleManagerFactory
		.getLocalInstance(ctx);
		return codeRuleMgr.isExist(objValue, companyId);
	}

	// 得到自动编码
	protected String getAutoCode(Context ctx, IObjectValue objValue,
			String companyId) throws EASBizException, BOSException {
		// String companyId = OrgInnerUtils.getCurCompany();
		// ICodingRuleManager codeRuleMgr = null;
		IOrgSwitchFacade orgSwitch = OrgSwitchFacadeFactory.getLocalInstance(ctx);  
		orgSwitch.orgSwitch(companyId);
		ICodingRuleManager codeRuleMgr = CodingRuleManagerFactory
		.getLocalInstance(ctx);
		if (codeRuleMgr.isUseIntermitNumber(objValue, companyId)) {
			return codeRuleMgr.readNumber(objValue, companyId);
		} else {
			return codeRuleMgr.getNumber(objValue, companyId);
		}
	}

	@Override
	protected String _downloadBillData(Context ctx, String jsonStr) throws BOSException {
		// TODO Auto-generated method stub
		JSONObject resultJson=new JSONObject();
		resultJson.put("result", true);
		try {
			resultJson.put("data", new WlhlDynamicBillUtils().getDataByID(ctx, jsonStr));
		} catch (EASBizException e) {
			resultJson.put("result", false);
			resultJson.put("failReason", e.getMessage());
			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
		}
		return resultJson.toString();
	}

	@Override
	protected String _downloadBillList(Context ctx, String jsonStr) throws BOSException {
		JSONObject resultJson=new JSONObject();
		resultJson.put("result", true);

		JSONObject jo=JSONObject.fromObject(jsonStr);
		//String bosType="FFAFDB4F";
		//合同预报单
		String bosType=jo.getString("bosType");
		String queryStr="where "+jo.getString("queryStr");
		String[] queryCols=null;
		if(jo.get("queryCols")!=null) {
			queryCols=new String[jo.getJSONArray("queryCols").size()];
			for(int index=0;index<jo.getJSONArray("queryCols").size();index++) {
				queryCols[index]=jo.getJSONArray("queryCols").getString(index);
			}
		}
		int beginRow=0,endRow=0;
		if(jo.containsKey("beginRow")&&UIRuleUtil.isNotNull(jo.get("beginRow")))
			beginRow = jo.getInt("beginRow");

		if(jo.containsKey("endRow")&&UIRuleUtil.isNotNull(jo.get("endRow")))
			endRow = jo.getInt("endRow");

		com.alibaba.fastjson.JSONArray ja=new com.alibaba.fastjson.JSONArray();

		try {
			ja=new WlhlDynamicBillUtils().downloadBillList(ctx, bosType, null, queryStr, queryCols, beginRow, endRow);
			resultJson.put("data", ja);
		}catch(Exception e) {
			resultJson.put("result", false);
			resultJson.put("failReason", e.getMessage());
			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
		}
		return ja.toString();
	}

	@Override
	protected String _uploadBillData(Context ctx, String jsonStr) throws BOSException {
		JSONObject resultJson=new JSONObject();
		resultJson.put("result", true);
		try {
			JSONObject jo=JSONObject.fromObject(jsonStr);
			String bosType="FFAFDB4F";
			new WlhlDynamicBillUtils().uploadDataByBosType(ctx, bosType,jo.getJSONObject("data").toString(),null);
		} catch (EASBizException e) {
			resultJson.put("result", false);
			resultJson.put("failReason", e.getMessage());
			resultJson.put("failLocation", e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber());
		}
		return resultJson.toString();
	}


	/**
	 * 根据用户获取销售组织范围
	 */
	@Override
	protected String _getOrgUnitRangeByUserNum(Context ctx, String parma)
	throws BOSException {
		// TODO Auto-generated method stub
		JSONObject paramJson = JSONObject.fromObject(parma);
		JSONObject resultJson=new JSONObject();
		resultJson.put("result", true);
		String userNum = paramJson.getString("userNum");
		String sql = "select t2.FNumber,t2.FName_l2 Fname,t2.FID  from T_PM_OrgRange t1 inner join T_ORG_Sale t2 on t1.FOrgID=t2.FID inner join T_PM_User t3 on t3.FID=t1.FUserID where t3.FName_l2='"+userNum+"' group by t2.FNumber,t2.FName_l2,t2.FID";
		IRowSet rs = DbUtil.executeQuery(ctx, sql);
		try {
			JSONArray jsonArray=new JSONArray();
			JSONObject jsonData=null;
			while(rs.next()){
				jsonData=new JSONObject();
				jsonData.put("number", rs.getString("FNumber"));
				jsonData.put("name", rs.getString("Fname"));
				jsonData.put("id", rs.getString("FID"));

				jsonArray.add(jsonData);
			}
			resultJson.put("data",jsonArray);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultJson.put("result", false);
			resultJson.put("reason", ExceptionUtils.getExceptionStatement(e));
			resultJson.put("location", ExceptionUtils.getExceptionLocationSimple(e));
			return resultJson.toString();
		}
		return resultJson.toString();
	}

	@Override
	protected String _getMaterialByOrg(Context ctx, String jsonStr)
	throws BOSException {
		// TODO Auto-generated method stub
		//		JSONObject paramJson = JSONObject.fromObject(jsonStr);
		JSONObject resultJson=new JSONObject();
		resultJson.put("result", true);
		JSONObject paramJson = JSONObject.fromObject(jsonStr);
		if(StringUtils.isEmpty(paramJson.getString("saleOrgNum"))){
			resultJson.put("result",false);
			resultJson.put("reason","销售组织为空");
			return resultJson.toString();
		}


		String saleOrgNum = paramJson.getString("saleOrgNum");
		StringBuffer sb = new StringBuffer();
		sb.append("/*dialect*/").append("\n")
		//yumingxu 20180405
		//.append("select * from (").append("\n") 
		
		.append("select").append("\n") 
		.append("t1.FNumber             materialNum,").append("\n")
		.append("t1.FID                 materialID,").append("\n")
		.append("t1.FName_l2            materialName,").append("\n")
		.append("t1.FModel              materialModel,").append("\n")
		.append("t5.FID                 measureUnitID,").append("\n")
		.append("t5.FName_l2            measureUnitName,").append("\n")
		.append("t5.FNumber             measureUnitNum,").append("\n")
		.append("t6.FID                 baseMeasureUnitID,").append("\n")
		.append("t6.FName_l2            baseMeasureUnitName,").append("\n")
		.append("t6.FNumber             baseMeasureUnitNum,").append("\n")
		.append("nvl(t5.FCoefficient,1) coefficient,").append("\n")
		//yumingxu 0406
		.append("case when t7.FPrice is null then t12.FPrice else t7.FPrice end     price,").append("\n")
		//.append("t7.FPrice              price,").append("\n")
		.append("t8.FID                 assistMeasureUnitID,").append("\n")
		.append("t8.FName_l2            assistMeasureUnitName,").append("\n")
		.append("t8.FNumber             assistMeasureUnitNum,").append("\n")
		.append("nvl(t8.FCoefficient,1) assistMeasureUnitCoe,").append("\n")
		.append("t2.FNumber             materialGroupNum,").append("\n")
		.append("t2.FName_l2            materialGroupName,").append("\n")
		.append("t2.FID                 materialGroupID,").append("\n")
		//.append("t11.FNumber            priceGroupNumber,").append("\n")
		//.append("t11.FName_l2           priceGroupName,").append("\n")
		//.append("t11.FID                priceGroupID,").append("\n")
		.append("t21.FID                wareHouseID,").append("\n")
		.append("t21.FName_l2           wareHouseName,").append("\n")
		.append("t21.FNumber            wareHouseNum,").append("\n")
		.append("t7.FPriority           FPriority").append("\n")
		.append("from T_BD_Material t1 ").append("\n")
		.append("inner join T_BD_MaterialGroup          t2 on t2.FID=t1.FMaterialGroupID  ").append("\n")
		.append("left  join T_BD_MaterialSales          t3 on t3.FMaterialID=t1.FID ").append("\n")
		.append("inner join T_ORG_BaseUnit              t4 on t4.FID=t3.FOrgUnit and t4.Fnumber='").append(saleOrgNum).append("'").append("\n")
		.append("inner join T_BD_MeasureUnit            t5 on t5.FID=t3.FUnitID").append("\n")
		.append("inner join T_BD_MeasureUnit            t6 on t6.FID=t1.FBaseUnit").append("\n")
		//yumignxu 0405
		.append("left  join T_SD_MaterialBasePrice      t7 on t1.FID=t7.FMaterialID  and t7.FAdminCUID=t4.FID and t7.FCheckedStatus=2 and t7.FUnitID=t5.FID").append("\n")//t7.FBlockedStatus=1
		.append("left  join T_SD_MaterialBasePrice      t12 on t1.FID=t12.FMaterialID  and t12.FAdminCUID='75QAAAAAAajM567U' and t12.FCheckedStatus=2 and t12.FUnitID=t5.FID").append("\n")//t12.FBlockedStatus=1
		//.append("left  join T_SD_MaterialBasePrice      t7 on t1.FID=t7.FMaterialID and t7.FAdminCUID=t4.FID and t7.FBlockedStatus=1 and t7.FUnitID=t5.FID").append("\n")
		.append("inner join T_BD_MeasureUnit            t8 on t8.FID=t1.FAssistUnit").append("\n");
		
		sb.append("left  join T_BD_MaterialInventory      t20 on t1.FID=t20.FMaterialID and t20.FOrgUnit=t4.FID").append("\n");
		sb.append("left  join T_DB_WAREHOUSE              t21 on t21.FID=t20.FDefaultWarehouseID").append("\n");



		sb.append("left  join T_BD_MaterialGroupDetial    t9  on t1.FID=t9.FMaterialID").append("\n");
		sb.append("left  join T_BD_MaterialGroupStandard  t10 on t10.FID=t9.FMaterialGroupStandardID").append("\n");
		//sb.append("left  join T_BD_MaterialGroup          t11 on t11.FID=t9.FMaterialGroupID").append("\n");
		sb.append("where ");

		//if(paramJson.containsKey("materialID")&&StringUtils.isNotBlank(paramJson.getString("materialID"))){
			sb.append(" t1.FID='").append(paramJson.getString("materialID")).append("'");
		//}
		if(paramJson.containsKey("materialNumber")&&StringUtils.isNotBlank(paramJson.getString("materialNumber"))){
			sb.append("where (t1.FNumber like '%").append(paramJson.getString("materialNumber")).append("%' or t1.FName_l2 like '%").append(paramJson.getString("materialNumber")).append("%')");
		}
//		if(paramJson.containsKey("materialName")&&StringUtils.isNotBlank(paramJson.getString("materialName"))){
//			sb.append(" and t1.FName_l2 like '%").append(paramJson.getString("materialName")).append("%'");
//		}
		sb.append("Group by t1.FNumber,t1.FID,t1.FName_l2,t1.FModel,t5.FNumber,t5.FID,t5.FName_l2 ,t6.FNumber,t6.FID,t6.FName_l2,t5.FCoefficient,t7.FPrice,t8.FID,t8.FName_l2,t8.FCoefficient,t8.FNumber,t2.FNumber,t2.FName_l2,t2.FID,t21.FID,t21.FName_l2,t21.Fnumber,t7.FPriority,t12.FPrice").append("\n")
		.append("order by t7.FPriority,t1.FNumber desc").append("\n");
		//yumingxu 20180405
		//sb.append(")      where rownum<2").append("\n"); 
		//System.out.println(sb.toString());
		IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());

		try{
			JSONArray jsonArray=new JSONArray();
			JSONObject jsonData=null;
			while(rs.next()){
				jsonData=new JSONObject();			
				jsonData.put("materialNum", rs.getString("materialNum"));
				jsonData.put("materialID", rs.getString("materialID"));
				jsonData.put("materialName", rs.getString("materialName"));
				jsonData.put("materialModel", rs.getString("materialModel"));
				jsonData.put("measureUnitID", rs.getString("measureUnitID"));
				jsonData.put("measureUnitName", rs.getString("measureUnitName"));
				jsonData.put("measureUnitNum", rs.getString("measureUnitNum"));
				jsonData.put("baseMeasureUnitID", rs.getString("baseMeasureUnitID"));
				jsonData.put("baseMeasureUnitName", rs.getString("baseMeasureUnitName"));
				jsonData.put("baseMeasureUnitNum", rs.getString("baseMeasureUnitNum"));
				jsonData.put("coefficient", rs.getString("coefficient"));
				jsonData.put("price", rs.getString("price"));
				jsonData.put("assistMeasureUnitID", rs.getString("assistMeasureUnitID"));
				jsonData.put("assistMeasureUnitName", rs.getString("assistMeasureUnitName"));
				jsonData.put("assistMeasureUnitNum", rs.getString("assistMeasureUnitNum"));
				jsonData.put("assistMeasureUnitCoe", rs.getString("assistMeasureUnitCoe"));
				jsonData.put("materialGroupNum", rs.getString("materialGroupNum"));
				jsonData.put("materialGroupName", rs.getString("materialGroupName"));
				jsonData.put("materialGroupID", rs.getString("materialGroupID"));
				//jsonData.put("priceGroupNumber", rs.getString("priceGroupNumber"));
				//jsonData.put("priceGroupName", rs.getString("priceGroupName"));
				//jsonData.put("priceGroupID", rs.getString("priceGroupID"));
				jsonData.put("wareHouseID", rs.getString("wareHouseID"));
				jsonData.put("wareHouseNum", rs.getString("wareHouseNum"));
				jsonData.put("wareHouseName", rs.getString("wareHouseName"));
				jsonArray.add(jsonData);
			}
			resultJson.put("data",jsonArray);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			resultJson.put("result", false);
			resultJson.put("reason", ExceptionUtils.getExceptionStatement(e));
			resultJson.put("location", ExceptionUtils.getExceptionLocationSimple(e));
			return resultJson.toString();
		}
		return resultJson.toString();
	}

	/**
	 * 获取价格
	 * @param ctx 
	 * @param jsonData
	 * @param saleOrgNum
	 * @return
	 */
	private BigDecimal getPrice(Context ctx, PriceCondition [] priceConditionArray) {
		// TODO Auto-generated method stub
		BigDecimal price=BigDecimal.ZERO;
		List[] priceArray;
		try {
			priceArray = getPrices(ctx,priceConditionArray);
			if(priceArray!=null&&priceArray.length>0&&priceArray[0].get(0)!=null)
				price = ((com.kingdee.eas.basedata.scm.sd.sale.SalePriceTO)priceArray[0].get(0)).price;
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return price;
	}

	public List[] getPrices(Context ctx,PriceCondition[] priceConditionArray)
	throws BOSException, EASBizException
	{
		if (!(checkConditions(priceConditionArray))) {
			return null;
		}
		List[] priceList = null;



		if (isAllConditionFoundPrice(priceList)) {
			return priceList;
		}
		IPriceProvider iPriceProvider = PriceProviderFactory.getLocalInstance(ctx);
		priceList = iPriceProvider.getPrices(priceConditionArray);

		return priceList;
	}
	private boolean isAllConditionFoundPrice(List[] priceList)
	{
		if ((priceList == null) || (priceList.length == 0)) {
			return false;
		}
		int i = 0; for (int n = priceList.length; i < n; ++i) {
			if (priceList[i] == null) {
				return false;
			}
		}
		return true;
	}
	private boolean checkConditions(PriceCondition[] priceConditionArray)
	{
		int i = 0; for (int size = priceConditionArray.length; i < size; ++i) {
			PriceCondition pc = priceConditionArray[i];
			if ((pc != null) && (pc.getMaterialInfo() != null) && (pc.getMeasureUnit() != null) && (pc.getCustomerInfo() != null) && (pc.getCurrencyInfo() != null) && (pc.getSaleOrg() != null))
			{
				return true;
			}
		}
		return false;
	}
	/**
	 * 生成销售预报单
	 */
	@Override
	protected String _createNewForecastOrder(Context ctx, String param)
	throws BOSException {
		// TODO Auto-generated method stub
		JSONObject rjson=new JSONObject();
		rjson.put("result", true);

		JSONObject fJson = JSONObject.fromObject(param);

		ISaleForecast iSaleForecast = SaleForecastFactory.getLocalInstance(ctx);

		if(StringUtils.isNotEmpty(UIRuleUtil.getString(fJson.get("userNum")))){
			IRowSet rs = DbUtil.executeQuery(ctx, "select FID from T_PM_User where fnumber='"+fJson.getString("userNum")+"'");
			try {
				if(rs.next())
					ctx.setCaller(new ObjectUuidPK(rs.getString("FID")));
				else{
					rjson.put("result", false);
					rjson.put("reason", "没有找到当前用户");
					return rjson.toString();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			rjson.put("result", false);
			rjson.put("reason", "没有找到当前用户");
			return rjson.toString();
		}

		SaleForecastInfo info=null;
		try {
			if(StringUtils.isEmpty(UIRuleUtil.getString(fJson.get("id")))){
				info=new SaleForecastInfo();
				info.setState(ForecastEnum.SAVE);
			}else{
				info=iSaleForecast.getSaleForecastInfo(new ObjectUuidPK(fJson.getString("id")));
			}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//客户
		if(StringUtils.isNotEmpty(UIRuleUtil.getString(fJson.get("customerID")))){
			info.setBOSUuid("customer", BOSUuid.read(fJson.getString("customerID")));
		}else{
			rjson.put("result", false);
			rjson.put("reason", "订货客户为空");
			return rjson.toString();
		}



		//客户
		if(StringUtils.isNotEmpty(UIRuleUtil.getString(fJson.get("saleCustomerID")))){
			info.setBOSUuid("saleCustomer", BOSUuid.read(fJson.getString("saleCustomerID")));
		}

		//付款方式
		if(StringUtils.isNotEmpty(UIRuleUtil.getString(fJson.get("paymenTypeID")))){
			info.setBOSUuid("payType", BOSUuid.read(fJson.getString("paymenTypeID")));
		}

		//销售组
		if(StringUtils.isNotEmpty(UIRuleUtil.getString(fJson.get("saleGroupID")))){
			info.setBOSUuid("saleGroup", BOSUuid.read(fJson.getString("saleGroupID")));
		}

		//销售员
		if(StringUtils.isNotEmpty(UIRuleUtil.getString(fJson.get("salePersonID")))){
			info.setBOSUuid("salePerson", BOSUuid.read(fJson.getString("salePersonID")));
		}

		//送货方式
		if(StringUtils.isNotEmpty(UIRuleUtil.getString(fJson.get("wayOfTakingDelivery")))){
			info.setWayOfTakingDelivery(WayOfTakingDeliveryEnum.getEnum(fJson.getString("wayOfTakingDelivery")));
		}

		//联系人
		if(StringUtils.isNotEmpty(UIRuleUtil.getString(fJson.get("linkMan")))){
			info.setLinkman(fJson.getString("linkMan"));
		}
		//联系方式
		if(StringUtils.isNotEmpty(UIRuleUtil.getString(fJson.get("linkmanTel")))){
			info.setLinkmanTel(fJson.getString("linkmanTel"));
		}

		//送货地址
		if(StringUtils.isNotEmpty(UIRuleUtil.getString(fJson.get("sendAddress")))){
			info.setSendAddress(fJson.getString("sendAddress"));
		}

		//业务日期
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
		if(StringUtils.isNotEmpty(UIRuleUtil.getString(fJson.get("bizDate")))){
			try {
				info.setBizDate(sdf2.parse(fJson.getString("bizDate")));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			info.setBizDate(new Date());
		}

		//摘要
		if(StringUtils.isNotEmpty(UIRuleUtil.getString(fJson.get("description")))){
			info.setDescription(fJson.getString("description"));
		}

		//开始日期
		if(StringUtils.isNotEmpty(UIRuleUtil.getString(fJson.get("beginDate")))){
			try {
				info.setBeginDate(sdf.parse(fJson.getString("beginDate")));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//结束日期
		if(StringUtils.isNotEmpty(UIRuleUtil.getString(fJson.get("endDate")))){
			try {
				info.setEndDate(sdf.parse(fJson.getString("endDate")));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		CoreBaseInfo coreInfo;
		//公司
		if(StringUtils.isNotEmpty(UIRuleUtil.getString(fJson.get("companyNum")))){
			coreInfo=InfoUtil.getLinkPropCoreBaseInfo(ctx, info, "company", fJson.getString("companyNum"));
			info.setCompany((CompanyOrgUnitInfo) coreInfo);
		}else{
			rjson.put("result", false);
			rjson.put("reason", "公司为空");
			return rjson.toString();
		}

		//控制单元
		if(info.getCU()==null)
			if(StringUtils.isNotEmpty(UIRuleUtil.getString(fJson.get("companyNum")))){
				coreInfo=InfoUtil.getLinkPropCoreBaseInfo(ctx, info, "CU", fJson.getString("companyNum"));
				info.setCU((CtrlUnitInfo) coreInfo);
			}else{
				rjson.put("result", false);
				rjson.put("reason", "公司");
				return rjson.toString();
			}

		//销售组织
		if(StringUtils.isNotEmpty(UIRuleUtil.getString(fJson.get("saleOrgUnitNum")))){
			coreInfo=InfoUtil.getLinkPropCoreBaseInfo(ctx, info, "saleOrgUnit", fJson.getString("saleOrgUnitNum"));
			info.setSaleOrgUnit((SaleOrgUnitInfo) coreInfo);
		}

		// 编码
		if(StringUtils.isEmpty(info.getNumber()))
			info.setNumber(CodingUtil.getNewNumberByCodingRule(ctx, info));

		// 总金额和总数量
		info.setTotalAmount(UIRuleUtil.getBigDecimal(fJson.get("totalAmount")));
		info.setTotalQty(UIRuleUtil.getBigDecimal(fJson.get("totalQty")));

		// 分录
		SaleForecastEntryInfo entryInfo=null;
		IMaterial iMaterial = MaterialFactory.getLocalInstance(ctx);
		MaterialInfo materialInfo;
		int i=0;
		int oldSize = info.getEntrys().size();
		if(fJson.containsKey("entry")&&fJson.getJSONArray("entry")!=null){
			JSONObject  entryJson;
			for(;i<fJson.getJSONArray("entry").size();i++){
				entryJson = (JSONObject) fJson.getJSONArray("entry").get(i);
				if(i<oldSize){
					entryInfo=info.getEntrys().get(i);
				}else{
					entryInfo=new SaleForecastEntryInfo();
				}


				//物料
				if(StringUtils.isNotEmpty(UIRuleUtil.getString(entryJson.get("materialID")))){
					try {
						materialInfo = iMaterial.getMaterialInfo(new ObjectUuidPK(entryJson.getString("materialID")));
						entryInfo.setMaterialNumber(materialInfo);
						entryInfo.setMaterialName(materialInfo.getName());
					} catch (EASBizException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					rjson.put("result",false);
					rjson.put("reason","请填写物料");
					return rjson.toString();
				}


				//数量
				if(UIRuleUtil.getBigDecimal(entryJson.get("qty")).compareTo(BigDecimal.ZERO)!=0){
					entryInfo.setQty(UIRuleUtil.getBigDecimal(entryJson.get("qty")));
					//					calEntryBaseQtyByQty(ctx,entryInfo);
				}
				//政策单价
				if(UIRuleUtil.getBigDecimal(entryJson.get("srcPrice")).compareTo(BigDecimal.ZERO)!=0){
					entryInfo.setSrcPrice(UIRuleUtil.getBigDecimal(entryJson.get("srcPrice")));
				}

				//基本数量
				if(UIRuleUtil.getBigDecimal(entryJson.get("baseqty")).compareTo(BigDecimal.ZERO)!=0){
					entryInfo.setBaseQty(UIRuleUtil.getBigDecimal(entryJson.get("baseqty")));
				}

				// 辅助计量单位数量
				if(UIRuleUtil.getBigDecimal(entryJson.get("assistUnitQty")).compareTo(BigDecimal.ZERO)!=0){
					entryInfo.setAssistUnitQty(UIRuleUtil.getBigDecimal(entryJson.get("assistUnitQty")));
				}

				//未分配数量
				if(UIRuleUtil.getBigDecimal(entryJson.get("qtyb")).compareTo(BigDecimal.ZERO)!=0){
					entryInfo.setQtyb(UIRuleUtil.getBigDecimal(entryJson.get("qtyb")));
				}

				// 基本计量单位
				if(StringUtils.isNotEmpty(UIRuleUtil.getString(entryJson.get("baseUnitID")))){
					entryInfo.setBOSUuid("baseUnit", BOSUuid.read(entryJson.getString("baseUnitID")));
				}

				// 仓库
				if(StringUtils.isNotEmpty(UIRuleUtil.getString(entryJson.get("wareHouseID")))){
					entryInfo.setBOSUuid("wareHouse", BOSUuid.read(entryJson.getString("wareHouseID")));
				}


				// 物料组
				if(StringUtils.isNotEmpty(UIRuleUtil.getString(entryJson.get("materialGroupID")))){
					entryInfo.setBOSUuid("materialGroup", BOSUuid.read(entryJson.getString("materialGroupID")));
				}

				// 价值分类
				if(StringUtils.isNotEmpty(UIRuleUtil.getString(entryJson.get("materialGroupBID")))){
					entryInfo.setBOSUuid("materialGroupB", BOSUuid.read(entryJson.getString("materialGroupBID")));
				}

				// 计量单位
				if(StringUtils.isNotEmpty(UIRuleUtil.getString(entryJson.get("measureUnitID")))){
					entryInfo.setBOSUuid("measureUnit", BOSUuid.read(entryJson.getString("measureUnitID")));
				}

				// 辅助计量单位
				if(StringUtils.isNotEmpty(UIRuleUtil.getString(entryJson.get("assistMeasureUnitID")))){
					entryInfo.setBOSUuid("assistUnit", BOSUuid.read(entryJson.getString("assistMeasureUnitID")));
				}



				//单价
				if(UIRuleUtil.getBigDecimal(entryJson.get("price")).compareTo(BigDecimal.ZERO)!=0){
					entryInfo.setPrice(UIRuleUtil.getBigDecimal(entryJson.get("price")));
					//					calEntryBasePriceByPrice(ctx,entryInfo);
				}


				// 基本单价
				if(UIRuleUtil.getBigDecimal(entryJson.get("baseprice")).compareTo(BigDecimal.ZERO)!=0){
					entryInfo.setBasePrice(UIRuleUtil.getBigDecimal(entryJson.get("baseprice")));
				}


				// 金额
				if(UIRuleUtil.getBigDecimal(entryJson.get("amount")).compareTo(BigDecimal.ZERO)!=0){
					entryInfo.setAmount(UIRuleUtil.getBigDecimal(entryJson.get("amount")));
				}


				// 备注
				if(StringUtils.isNotEmpty(UIRuleUtil.getString(entryJson.get("remark")))){
					entryInfo.setRemark(entryJson.getString("remark"));
				}
				// 规格
				if(StringUtils.isNotEmpty(UIRuleUtil.getString(entryJson.get("model")))){
					entryInfo.setModel(entryJson.getString("model"));
				}

				// 溢价
				entryInfo.setPremium(UIRuleUtil.getBigDecimal((entryJson.get("premium"))));

				// 净价
				entryInfo.setSuttlePrice((UIRuleUtil.getBigDecimal(entryJson.get("suttlePrice"))));

				// 价内费用
				entryInfo.setInternalCost((UIRuleUtil.getBigDecimal(entryJson.get("internalCost"))));

				//意向公司
				if(StringUtils.isNotEmpty(UIRuleUtil.getString(entryJson.get("company")))){
					entryInfo.setBOSUuid("company", BOSUuid.read(entryJson.getString("company")));
					//					coreInfo=InfoUtil.getLinkPropCoreBaseInfo(ctx, entryInfo, "company", entryJson.getString("company"));
					//					entryInfo.setCompany((CompanyOrgUnitInfo) coreInfo);
				}else
					entryInfo.setCompany(info.getCompany());

				if(entryInfo.getId()==null)
					info.getEntrys().add(entryInfo);
			}
			//多余的分录删除
			for(int j=info.getEntrys().size()-1;j>0;j--){
				if(j>=i){
					info.getEntrys().remove(info.getEntrys().get(j));
				}
			}
		}else{
			rjson.put("result", false);
			rjson.put("reason", "至少需要包含一条数据");
			return rjson.toString();
		}
		try {
			IObjectPK pk = null;
			if(StringUtils.isNotEmpty(UIRuleUtil.getString(fJson.get("action"))))
				if(fJson.getString("action").equals("2"))
					pk = iSaleForecast.submit(info);
				else
					pk = iSaleForecast.save(info);
			else
				pk = iSaleForecast.save(info);
			rjson.put("pkValue",pk.toString());
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rjson.toString();
	}
	/**
	 * 根据单价计算基本单价
	 * @param ctx
	 * @param entryInfo
	 */
	private void calEntryBasePriceByPrice(Context ctx,
			SaleForecastEntryInfo entryInfo) {
		// TODO Auto-generated method stub
		MeasureUnitInfo unitinfo =entryInfo.getMeasureUnit();
		MeasureUnitInfo baseunitinfo =entryInfo.getBaseUnit();
		if(unitinfo!=null&&baseunitinfo!=null){	
			BigDecimal coefficient=unitinfo.getCoefficient();
			if(coefficient==null)coefficient=new BigDecimal("1");
			BigDecimal baseprice=UIRuleUtil.getBigDecimal(entryInfo.getPrice()).divide(coefficient,4,6);
			baseprice = baseprice.setScale(6, 6);
			entryInfo.setBasePrice(baseprice);
		}
	}

	/**
	 * 数量带出基本数量
	 * @param ctx
	 * @param entryInfo
	 */
	private void calEntryBaseQtyByQty(Context ctx,
			SaleForecastEntryInfo entryInfo) {
		// TODO Auto-generated method stub
		MeasureUnitInfo unitinfo =entryInfo.getMeasureUnit();
		MeasureUnitInfo baseunitinfo =entryInfo.getBaseUnit();
		if(unitinfo!=null&&baseunitinfo!=null){	
			BigDecimal coefficient=unitinfo.getCoefficient();
			if(coefficient==null)coefficient=new BigDecimal("1");
			BigDecimal baseqty=entryInfo.getQty().multiply(coefficient);
			baseqty = baseqty.setScale(2, 4);
			entryInfo.setBaseQty(baseqty);
			entryInfo.setQtyb(baseqty);
		}
	}



	/**
	 * 获取当前公司的客户
	 */

	@Override
	protected String _getCustomerBySaleOrg(Context ctx, String param)
	throws BOSException {
		// TODO Auto-generated method stub
		JSONObject rjson=new JSONObject();
		rjson.put("result", true);

		JSONObject fJson = JSONObject.fromObject(param);

		String saleOrgUnitID;
		if(StringUtils.isNotEmpty(fJson.getString("saleOrgNum"))){
			saleOrgUnitID=fJson.getString("saleOrgNum");
		}else{
			rjson.put("result", false);
			rjson.put("reason", "销售组织为空");
			return rjson.toString();
		}

		try {
			
			StringBuffer sql = new StringBuffer();
			sql.append("select t2.FID,t2.FNumber,t2.Fname_l2 Fname,t4.FID provinceID,t4.FName_l2 provinceName,t4.FNumber provinceNum ")
			.append(" ,t2.FAddress,tl.FContactPerson,tl.FMobile")
			.append(" from T_BD_CustomerSaleInfo t1 inner join T_BD_Customer t2 on t2.FID=t1.FCustomerID ")
			.append(" inner join T_ORG_Sale t3 on t3.FID=t1.FSaleOrgID left join T_BD_Province t4 on t4.FID=t2.FProvince ")
			.append(" left join T_BD_CustomerLinkMan tl on t1.fid=tl.FCustomerSaleId ")
			.append(" where t3.Fnumber='"+saleOrgUnitID+"' ");
			if(StringUtils.isNotEmpty(fJson.getString("CustomerNumber"))){
				String CustomerNumber=fJson.getString("CustomerNumber");
				sql.append(" and (t2.FNumber like '%"+CustomerNumber+"%' or t2.FName_l2 like '%"+CustomerNumber+"%')");
			}
			System.out.println(sql.toString());
			IRowSet rs = DbUtil.executeQuery(ctx,sql.toString() );
			JSONArray array=new JSONArray();
			JSONObject js=null;
			ArrayList<String> list=new ArrayList<String>();
			while(rs.next()){
				if(list.contains(rs.getString("FID"))) {
					continue;
				}
				list.add(rs.getString("FID"));
				js=new JSONObject();
				js.put("id",rs.getString("FID"));
				js.put("number",rs.getString("FNumber"));
				js.put("name",rs.getString("Fname"));
				js.put("provinceID",rs.getString("provinceID"));
				js.put("provinceName",rs.getString("provinceName"));
				js.put("provinceNum",rs.getString("provinceNum"));
				//地址、联系人、手机
				js.put("address",rs.getString("FAddress"));
				js.put("contactPerson",rs.getString("FContactPerson"));
				js.put("phone",rs.getString("FMobile"));
				array.add(js);
			}
			rjson.put("data",array);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rjson.toString();
	}


	/**
	 * 获取付款方式
	 */
	@Override
	protected String _getPaymentType(Context ctx, String param)
	throws BOSException {
		// TODO Auto-generated method stub
		JSONObject rjson=new JSONObject();
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, "select FID,FName_l2 Fname,Fnumber from T_BD_PaymentType");
			JSONArray jsonArray=new JSONArray();
			JSONObject json=null;
			while(rs.next()){
				json=new JSONObject();
				json.put("ID",rs.getString("FID"));
				json.put("number",rs.getString("Fnumber"));
				json.put("name",rs.getString("Fname"));
				jsonArray.add(json);
			}
			rjson.put("data",jsonArray);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rjson.toString();
	}


	/**
	 * 根据销售组织获取销售组
	 */
	@Override
	protected String _getSaleGroupBySaleOrg(Context ctx, String param)
	throws BOSException {
		// TODO Auto-generated method stub
		JSONObject rjson=new JSONObject();
		rjson.put("result", true);

		JSONObject fJson = JSONObject.fromObject(param);

		String saleOrgUnitID;
		String salePersonID;
		if(StringUtils.isNotEmpty(UIRuleUtil.getString(fJson.get("saleOrgNum")))){
			saleOrgUnitID=fJson.getString("saleOrgNum");
		}else{
			rjson.put("result", false);
			rjson.put("reason", "销售组织为空");
			return rjson.toString();
		}

		StringBuffer sb=new StringBuffer();
		sb.append("select t1.FID,t1.FName_l2 fname,t1.Fnumber from T_BD_SaleGroup t1\n");

		//销售员
		if(StringUtils.isNotEmpty(UIRuleUtil.getString(fJson.get("salePersonID")))){
			salePersonID=fJson.getString("salePersonID");
			sb.append(" inner join T_BD_SalePerson t2 on t2.FSaleGroupID=t1.FID and t2.FID='").append(salePersonID).append("'\n");
		}

		sb.append(" inner join T_ORG_Sale t3 on t3.FID=t1.FSaleOrgID").append("\n");
		sb.append(" where t3.Fnumber='").append(saleOrgUnitID).append("'\n");
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			JSONArray jsonArray=new JSONArray();
			JSONObject json=null;
			while(rs.next()){
				json=new JSONObject();
				json.put("ID",rs.getString("FID"));
				json.put("number",rs.getString("Fnumber"));
				json.put("name",rs.getString("Fname"));
				jsonArray.add(json);
			}
			rjson.put("data",jsonArray);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rjson.toString();
	}


	/**
	 * 获取销售员
	 */
	@Override
	protected String _getSalePerson(Context ctx, String param)
	throws BOSException {
		// TODO Auto-generated method stub
		JSONObject rjson=new JSONObject();
		rjson.put("result", true);

		JSONObject fJson = JSONObject.fromObject(param);




		StringBuffer sb = new StringBuffer();
		sb.append("select t4.FID,t4.FNumber,t4.FName_l2 Fname,t2.FID saleGroupID,t2.FNumber saleGroupNum,t2.FName_l2 saleGroupName from T_BD_SalePerson t1 \n")
		.append(" inner join T_BD_SaleGroup   t2 on t2.FID=t1.FSaleGroupID and t1.FDeletedStatus=1\n")
		.append(" inner join T_ORG_Sale       t3 on t3.FID=t2.FSaleOrgID\n")
		.append(" left  join T_BD_Person      t4 on t4.FID=t1.FPersonID\n")
		.append(" left  join T_PM_User        t5 on t4.FID=t5.FPersonId\n")
		.append(" where 1=1\n");
		//
		if(StringUtils.isNotEmpty(UIRuleUtil.getString(fJson.get("saleOrgNum")))){
			sb.append(" and t3.FNumber='").append(fJson.getString("saleOrgNum")).append("'\n");
		}else{
			rjson.put("result", false);
			rjson.put("reason", "销售组织为空");
			return rjson.toString();
		}

		if(StringUtils.isNotEmpty(UIRuleUtil.getString(fJson.get("saleGroupID")))){
			sb.append(" and t2.FID='").append(fJson.getString("saleGroupID")).append("'\n");
		}
		if(StringUtils.isNotEmpty(UIRuleUtil.getString(fJson.get("userNum")))){
			sb.append(" and t5.FNumber='").append(fJson.getString("userNum")).append("'\n");
		}

		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			JSONArray jsonArray=new JSONArray();
			JSONObject json=null;
			while(rs.next()){
				json=new JSONObject();
				json.put("ID",rs.getString("FID"));
				json.put("number",rs.getString("Fnumber"));
				json.put("name",rs.getString("Fname"));

				json.put("saleGroupID",rs.getString("saleGroupID"));
				json.put("saleGroupNum",rs.getString("saleGroupNum"));
				json.put("saleGroupName",rs.getString("saleGroupName"));
				jsonArray.add(json);
			}
			rjson.put("data",jsonArray);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rjson.toString();
	}


	/**
	 * 获取销售预报单详细信息
	 */
	@Override
	protected String _getForecastDetailInfo(Context ctx, String param)
	throws BOSException {
		// TODO Auto-generated method stub

		JSONObject rjson = new JSONObject();
		rjson.put("result",true);
		JSONObject fJson = JSONObject.fromObject(param);
		String id;
		if(StringUtils.isEmpty(UIRuleUtil.getString(fJson.get("id")))){
			rjson.put("result",false);
			rjson.put("reason","ID is null");
			return rjson.toString();
		}else{
			id=fJson.get("id").toString();
		}

		String sp="\n";
		StringBuffer sb=new StringBuffer();
		sb.append("select").append(sp);
		sb.append(" saleForecast.FID       FID,").append(sp);
		sb.append(" saleForecast.Fnumber   Fnumber,").append(sp);
		sb.append(" saleForecast.cfstate   state,").append(sp);
		sb.append(" customer.FID           customerID,").append(sp);
		sb.append(" customer.FName_l2      customerName,").append(sp);
		sb.append(" customer.FNumber       customerNum,").append(sp);
		sb.append(" saleCustomer.FID        saleCustomerID,").append(sp);
		sb.append(" saleCustomer.FNumber    saleCustomerNum,").append(sp);
		sb.append(" saleCustomer.FName_l2   saleCustomerName,").append(sp);
		sb.append(" saleperson.FID         salePersonID,").append(sp);
		sb.append(" saleperson.FName_l2    salepersonName,").append(sp);
		sb.append(" saleperson.FNumber     salepersonNum,").append(sp);
		sb.append(" salegroup.FID          salegroupID,").append(sp);
		sb.append(" salegroup.FName_l2     salegroupName,").append(sp);
		sb.append(" salegroup.FNumber      salegroupNum,").append(sp);
		sb.append(" paytype.FID            paymenTypeID,").append(sp);
		sb.append(" paytype.FName_l2       paymenTypeName,").append(sp);
		sb.append(" paytype.FNumber        paymenTypeNum,").append(sp);
		sb.append(" company.FID            companyID,").append(sp);
		sb.append(" company.FNumber        companyNum,").append(sp);
		sb.append(" company.FName_l2       companyName,").append(sp);
		sb.append(" saleorgunit.FID        saleorgunitID,").append(sp);
		sb.append(" saleorgunit.FNumber    saleorgunitNum,").append(sp);
		sb.append(" saleorgunit.FName_l2   saleorgunitName,").append(sp);
		sb.append(" cu.FID                 cuID,").append(sp);
		sb.append(" cu.FNumber             cuNum,").append(sp);
		sb.append(" cu.Fname_l2            cuName,").append(sp);
		sb.append(" material.FID           materialID,").append(sp);
		sb.append(" material.Fnumber       materialNum,").append(sp);
		sb.append(" material.Fname_l2      materialName,").append(sp);
		sb.append(" measureunit.FID        measureunitID,").append(sp);
		sb.append(" measureunit.FNumber    measureunitNum,").append(sp);
		sb.append(" measureunit.Fname_l2   measureunitName,").append(sp);
		sb.append(" baseunit.FID           baseunitID,").append(sp);
		sb.append(" baseunit.FNumber       baseunitNum,").append(sp);
		sb.append(" baseunit.FName_l2      baseunitName,").append(sp);
		sb.append(" assitunit.FID          assistMeasureUnitID,").append(sp);
		sb.append(" assitunit.FNumber      assistMeasureUnitNum,").append(sp);
		sb.append(" assitunit.FName_l2     assistMeasureUnitName, ").append(sp);
		sb.append(" companyEntry.FID       companyEntryID,").append(sp);
		sb.append(" companyEntry.Fnumber   companyEntryNum,").append(sp);
		sb.append(" companyEntry.FName_l2  companyEntryName,").append(sp);
		sb.append(" saleForecast.CFwayOfTakingDelivery,").append(sp);
		sb.append(" saleForecast.CFlinkMan,").append(sp);
		sb.append(" saleForecast.CFlinkmanTel,").append(sp);
		sb.append(" saleForecast.CFsendAddress,").append(sp);
		sb.append(" saleForecast.Fdescription,").append(sp);
		sb.append(" saleForecast.FbizDate,").append(sp);
		sb.append(" saleForecast.CFbeginDate,").append(sp);
		sb.append(" saleForecast.CFendDate,").append(sp);
		sb.append(" saleForecast.CFTotalQty,").append(sp);
		sb.append(" saleForecast.CFTotalAmount,").append(sp);
		sb.append(" entrys.CFprice,").append(sp);
		sb.append(" entrys.CFqty,").append(sp);
		sb.append(" entrys.CFremark,").append(sp);
		sb.append(" entrys.CFbasePrice,").append(sp);
		sb.append(" entrys.CFbaseQty,").append(sp);
		sb.append(" entrys.CFamount,").append(sp);
		sb.append(" entrys.CFQtyB, ").append(sp);
		sb.append(" entrys.FPremium,").append(sp);
		sb.append(" entrys.FModel, ").append(sp);
		sb.append(" entrys.FInternalCost, ").append(sp);
		sb.append(" entrys.FSuttlePrice, ").append(sp);
		sb.append(" entrys.FSrcPrice, ").append(sp);
		sb.append(" warehouse.FID           warehouseID, ").append(sp);
		sb.append(" warehouse.Fname_l2      warehouseName, ").append(sp);
		sb.append(" warehouse.FNumber       warehouseNum, ").append(sp);
		sb.append(" materialGroup.FID           materialGroupID, ").append(sp);
		sb.append(" materialGroup.Fname_l2  materialGroupName, ").append(sp);
		sb.append(" materialGroup.FNumber   materialGroupNum, ").append(sp);
		sb.append(" materialGroupB.FID      materialGroupBID, ").append(sp);
		sb.append(" materialGroupB.Fname_l2 materialGroupBName, ").append(sp);
		sb.append(" materialGroupB.FNumber  materialGroupBNum, ").append(sp);
		sb.append(" entrys.FASSISTUNITQTY   assistUnitQty").append(sp); 
		sb.append("from ").append(sp);
		sb.append("CT_LHS_SaleForecast                 as saleForecast").append(sp);
		sb.append("left  join t_pm_user                as auditor        on saleforecast.fauditorid = auditor.fid").append(sp);
		sb.append("left  join t_pm_user                as creator        on saleforecast.fcreatorid = creator.fid").append(sp);
		sb.append("left  join t_pm_user                as lastupdateuser on saleforecast.flastupdateuserid = lastupdateuser.fid").append(sp);
		sb.append("left  join ct_lhs_saleforecastentry as entrys         on saleforecast.fid = entrys.fparentid").append(sp);
		sb.append("left  join t_pm_user                as handler        on saleforecast.fhandlerid = handler.fid").append(sp);
		sb.append("left  join t_bd_customer            as customer       on saleforecast.cfcustomerid = customer.fid").append(sp);
		sb.append("left  join t_bd_customer            as saleCustomer   on saleforecast.FSaleCustomerID = saleCustomer.fid").append(sp);
		sb.append("left  join t_bd_person              as saleperson     on saleforecast.cfsalepersonid = saleperson.fid").append(sp);
		sb.append("left  join t_bd_salegroup           as salegroup      on saleforecast.cfsalegroupid = salegroup.fid").append(sp);
		sb.append("left  join t_bd_paymenttype         as paytype        on saleforecast.cfpaytypeid = paytype.fid").append(sp);
		sb.append("left  join t_org_company            as company        on saleforecast.cfcompanyid = company.fid").append(sp);
		sb.append("left  join t_org_sale               as saleorgunit    on saleforecast.cfsaleorgunitid = saleorgunit.fid").append(sp);
		sb.append("inner join t_org_ctrlunit           as cu             on saleforecast.fcontrolunitid = cu.fid").append(sp);
		sb.append("left  join t_bd_material            as material       on entrys.cfmaterialnumberid = material.fid").append(sp);
		sb.append("left  join t_bd_measureunit         as measureunit    on entrys.cfmeasureunitid = measureunit.fid").append(sp);
		sb.append("left  join t_bd_measureunit         as assitunit      on entrys.FASSISTUNITID = assitunit.fid").append(sp);
		sb.append("left  join t_bd_measureunit         as baseunit       on entrys.cfbaseunitid = baseunit.fid").append(sp);
		sb.append("left  join t_org_company            as companyEntry   on entrys.cfcompanyid = companyEntry.fid").append(sp);
		sb.append("left  join T_BD_MaterialGroup       as materialGroup  on entrys.FMaterialGroupID = materialGroup.fid").append(sp);
		sb.append("left  join T_BD_MaterialGroup       as materialGroupB on entrys.FMaterialGroupBID = materialGroupB.fid").append(sp);
		sb.append("left  join T_DB_WAREHOUSE           as warehouse      on entrys.FWareHouseID = warehouse.fid").append(sp);
		sb.append("where saleForecast.FID='").append(id).append("'").append(sp);

		IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
		try {
			JSONObject jsonItem;
			JSONObject jsonData=new JSONObject();
			JSONArray  jsonArray=new JSONArray();
			JSONObject jsonEntry=new JSONObject();
			boolean flag=true;
			while(rs.next()){

				if(flag){
					jsonData.put("id",rs.getString("FID"));
					jsonData.put("number",rs.getString("Fnumber"));
					jsonData.put("state",rs.getString("state"));


					jsonData.put("customerID",rs.getString("customerID"));
					jsonItem=new JSONObject();
					jsonItem.put("customerID",rs.getString("customerID"));
					jsonItem.put("customerName",rs.getString("customerName"));
					jsonItem.put("customerNum",rs.getString("customerNum"));
					jsonData.put("customer",jsonItem);

					jsonData.put("saleCustomerID",rs.getString("saleCustomerID"));
					jsonItem=new JSONObject();
					jsonItem.put("saleCustomerID",rs.getString("saleCustomerID"));
					jsonItem.put("saleCustomerName",rs.getString("saleCustomerName"));
					jsonItem.put("saleCustomerNum",rs.getString("saleCustomerNum"));
					jsonData.put("saleCustomer",jsonItem);

					jsonData.put("salePersonID",rs.getString("salePersonID"));
					jsonItem=new JSONObject();
					jsonItem.put("salePersonID",rs.getString("salePersonID"));
					jsonItem.put("salepersonName",rs.getString("salepersonName"));
					jsonItem.put("salepersonNum",rs.getString("salepersonNum"));
					jsonData.put("salePerson",jsonItem);

					jsonData.put("salegroupID",rs.getString("salegroupID"));
					jsonItem=new JSONObject();
					jsonItem.put("salegroupID",rs.getString("salegroupID"));
					jsonItem.put("salegroupName",rs.getString("salegroupName"));
					jsonItem.put("salegroupNum",rs.getString("salegroupNum"));
					jsonData.put("salegroup",jsonItem);

					jsonData.put("paymenTypeID",rs.getString("paymenTypeID"));
					jsonItem=new JSONObject();
					jsonItem.put("paymenTypeID",rs.getString("paymenTypeID"));
					jsonItem.put("paymenTypeName",rs.getString("paymenTypeName"));
					jsonItem.put("paymenTypeNum",rs.getString("paymenTypeNum"));
					jsonData.put("paymenType",jsonItem);

					jsonData.put("companyNum",rs.getString("companyNum"));
					jsonItem=new JSONObject();
					jsonItem.put("companyID",rs.getString("companyID"));
					jsonItem.put("companyNum",rs.getString("companyNum"));
					jsonItem.put("companyName",rs.getString("companyName"));
					jsonData.put("company",jsonItem);

					jsonData.put("saleOrgUnitNum",rs.getString("saleOrgUnitNum"));
					jsonItem=new JSONObject();
					jsonItem.put("saleorgunitID",rs.getString("saleorgunitID"));
					jsonItem.put("saleorgunitNum",rs.getString("saleorgunitNum"));
					jsonItem.put("saleorgunitName",rs.getString("saleorgunitName"));
					jsonData.put("saleOrgUnit",jsonItem);


					jsonData.put("cuID",rs.getString("cuID"));
					jsonItem=new JSONObject();
					jsonItem.put("cuID",rs.getString("cuID"));
					jsonItem.put("cuNum",rs.getString("cuNum"));
					jsonItem.put("cuName",rs.getString("cuName"));
					jsonData.put("cu",jsonItem);


					jsonData.put("wayOfTakingDelivery",rs.getString("CFwayOfTakingDelivery"));
					jsonData.put("linkMan",rs.getString("CFlinkMan"));
					jsonData.put("linkmanTel",rs.getString("CFlinkmanTel"));
					jsonData.put("sendAddress",rs.getString("CFsendAddress"));
					jsonData.put("description",rs.getString("Fdescription"));
					jsonData.put("bizDate",rs.getString("FbizDate"));
					jsonData.put("beginDate",rs.getString("CFbeginDate"));
					jsonData.put("endDate",rs.getString("CFendDate"));
					jsonData.put("totalAmount",rs.getString("CFTotalAmount"));
					jsonData.put("totalQty",rs.getString("CFtotalQty"));
					flag=false;
				}

				jsonEntry=new JSONObject();

				jsonEntry.put("materialID",rs.getString("materialID"));
				jsonItem=new JSONObject();
				jsonItem.put("materialID",rs.getString("materialID"));
				jsonItem.put("materialNum",rs.getString("materialNum"));
				jsonItem.put("materialName",rs.getString("materialName"));
				jsonEntry.put("material",jsonItem);

				jsonEntry.put("measureunitID",rs.getString("measureunitID"));
				jsonItem=new JSONObject();
				jsonItem.put("measureunitID",rs.getString("measureunitID"));
				jsonItem.put("measureunitNum",rs.getString("measureunitNum"));
				jsonItem.put("measureunitName",rs.getString("measureunitName"));
				jsonEntry.put("measureunit",jsonItem);

				jsonEntry.put("baseunitNum",rs.getString("baseunitNum"));
				jsonItem=new JSONObject();
				jsonItem.put("baseunitID",rs.getString("baseunitID"));
				jsonItem.put("baseunitNum",rs.getString("baseunitNum"));
				jsonItem.put("baseunitName",rs.getString("baseunitName"));
				jsonEntry.put("baseunit",jsonItem);

				jsonEntry.put("assistMeasureUnitID",rs.getString("assistMeasureUnitID"));
				jsonItem=new JSONObject();
				jsonItem.put("assistMeasureUnitID",rs.getString("assistMeasureUnitID"));
				jsonItem.put("assistMeasureUnitNum",rs.getString("assistMeasureUnitNum"));
				jsonItem.put("assistMeasureUnitName",rs.getString("assistMeasureUnitName"));
				jsonEntry.put("assistMeasureUnit",jsonItem);

				jsonEntry.put("companyID",rs.getString("companyEntryID"));
				jsonItem=new JSONObject();
				jsonItem.put("companyEntryNum",rs.getString("companyEntryNum"));
				jsonItem.put("companyEntryID",rs.getString("companyEntryID"));
				jsonItem.put("companyEntryName",rs.getString("companyEntryName"));
				jsonEntry.put("company",jsonItem);

				jsonEntry.put("materialGroupBID",rs.getString("materialGroupBID"));
				jsonItem=new JSONObject();
				jsonItem.put("materialGroupBNum",rs.getString("materialGroupBNum"));
				jsonItem.put("materialGroupBID",rs.getString("materialGroupBID"));
				jsonItem.put("materialGroupBName",rs.getString("materialGroupBName"));
				jsonEntry.put("materialGroupB",jsonItem);

				jsonEntry.put("materialGroupID",rs.getString("materialGroupID"));
				jsonItem=new JSONObject();
				jsonItem.put("materialGroupNum",rs.getString("materialGroupNum"));
				jsonItem.put("materialGroupID",rs.getString("materialGroupID"));
				jsonItem.put("materialGroupName",rs.getString("materialGroupName"));
				jsonEntry.put("materialGroup",jsonItem);

				jsonEntry.put("warehouseID",rs.getString("warehouseID"));
				jsonItem=new JSONObject();
				jsonItem.put("warehouseNum",rs.getString("warehouseNum"));
				jsonItem.put("warehouseID",rs.getString("warehouseID"));
				jsonItem.put("warehouseName",rs.getString("warehouseName"));
				jsonEntry.put("warehouse",jsonItem);


				jsonEntry.put("price",rs.getString("CFprice"));
				jsonEntry.put("qty",rs.getString("CFqty"));
				jsonEntry.put("remark",rs.getString("CFremark"));
				jsonEntry.put("basePrice",rs.getString("CFbasePrice"));
				jsonEntry.put("baseQty",rs.getString("CFbaseQty"));
				jsonEntry.put("amount",rs.getString("CFamount"));
				jsonEntry.put("QtyB",rs.getString("CFQtyB"));
				jsonEntry.put("premium",rs.getString("FPremium"));
				jsonEntry.put("model",rs.getString("FModel"));
				jsonEntry.put("assistUnitQty",rs.getString("assistUnitQty"));
				jsonEntry.put("internalCost",rs.getString("FInternalCost"));
				jsonEntry.put("suttlePrice",rs.getString("FSuttlePrice"));
				jsonEntry.put("srcPrice",rs.getString("FSrcPrice"));
				jsonArray.add(jsonEntry);
			}
			jsonData.put("entry",jsonArray);
			rjson.put("data",jsonData);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rjson.put("result",false);
			rjson.put("reason",ExceptionUtils.getExceptionStatement(e));
			rjson.put("loc",ExceptionUtils.getExceptionLocationSimple(e));
		}
		return rjson.toString();
	}

	@Override
	protected String _getMaterialPrice(Context ctx, String param)
	throws BOSException {
		// TODO Auto-generated method stub
		JSONObject fJson = JSONObject.fromObject(param);
		return null;
	}


	/**
	 * 根据公司获取仓库
	 */
	@Override
	protected String _getWareHouseList(Context ctx, String param)
	throws BOSException {
		// TODO Auto-generated method stub
		JSONObject fromObject = JSONObject.fromObject(param);
		String orgUnitID = fromObject.getString("orgUnitID");
		StringBuffer sb = new StringBuffer();
		sb.append("select t1.FNumber,t1.FName_l2 fname,t1.FID from ").append("\n")
		.append("T_DB_Warehouse              t1").append("\n")
		.append("inner join T_ORG_Storage    t2 on t2.FID=t1.FstorageOrgID").append("\n")
		.append("where t1.FWhState=1").append("\n")
		.append("      and t2.FID='").append(orgUnitID).append("'\n")
		.append("order by t1.FNumber").append("\n");

		JSONArray array = new JSONArray();
		IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
		try {
			ResultSetMetaData metaData = rs.getMetaData();
			JSONObject json = null;
			while(rs.next()){
				json = new JSONObject();
				for(int i=0;i<metaData.getColumnCount();i++){
					json.put(metaData.getColumnName(i+1),rs.getObject(i+1));
				}
				array.add(json);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array.toString();
	}

	@Override
	protected String _getSaleForecastBillPro(Context ctx, String param)
	throws BOSException {
		// TODO Auto-generated method stub
		String id = JSONObject.fromObject(param).getString("id");
		String sql = "select t2.FID,t2.Fnumber,t2.FBaseStatus from CT_LHS_SALEFORECASTENTRY2 t1 inner join t_sd_saleorder t2 on t2.FID=t1.fsaleorderid where t1.fparentID='"+id+"' and t1.fsaleorderid is not null";
		try {
			IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx,sql).executeSQL();
			SaleForecastInfo saleForecastInfo = SaleForecastFactory.getLocalInstance(ctx).getSaleForecastInfo(new ObjectUuidPK(id));
			ArrayList<String> orderNumList = new ArrayList<String>();
			JSONArray array = new JSONArray();
			JSONObject json = null;
			while(rs.next()){
				if(orderNumList.contains(rs.getString("Fnumber")))
					continue;
				else
					orderNumList.add(rs.getString("Fnumber"));
				json = new JSONObject();
				json.put("billType","销售订单");
				json.put("billNum",rs.getString("Fnumber"));
				json.put("billStatus",BillBaseStatusEnum.getEnum(rs.getInt("FBaseStatus")).getAlias());
				json.put("srcBillNum",saleForecastInfo.getNumber());
				array.add(json);
				ArrayList obj = BOTRelationFactory.getLocalInstance(ctx).getDestObjIdByDestType(rs.getString("FID"), "CC3E933B");
				if(obj.size() > 0){
					id = obj.get(0).toString();
					SaleIssueBillInfo info = SaleIssueBillFactory.getLocalInstance(ctx).getSaleIssueBillInfo(new ObjectUuidPK(id));
					json = new JSONObject();
					json.put("billType","销售出库");
					json.put("billNum",info.getNumber());
					json.put("billStatus",info.getBaseStatus().getAlias());
					json.put("srcBillNum",rs.getString("Fnumber"));
					array.add(json);

					obj = BOTRelationFactory.getLocalInstance(ctx).getDestObjIdByDestType(id, "FC910EF3");
					if(obj.size() > 0){
						id = obj.get(0).toString();
						OtherBillInfo otherInfo = OtherBillFactory.getLocalInstance(ctx).getOtherBillInfo(new ObjectUuidPK(id));
						json = new JSONObject();
						json.put("billType","应收单");
						json.put("billNum",otherInfo.getNumber());
						json.put("billStatus",otherInfo.getBillStatus().getAlias());
						json.put("srcBillNum",info.getNumber());
						array.add(json);

						obj = BOTRelationFactory.getLocalInstance(ctx).getDestObjIdByDestType(id, "FA44FD5B");
						if(obj.size() > 0){
							id = obj.get(0).toString();
							ReceivingBillInfo ReceivingBill = ReceivingBillFactory.getLocalInstance(ctx).getReceivingBillInfo(new ObjectUuidPK(id));
							json = new JSONObject();
							json.put("billType","收款单");
							json.put("billNum",ReceivingBill.getNumber());
							json.put("billStatus",ReceivingBill.getBillStatus().getAlias());
							json.put("srcBillNum",otherInfo.getNumber());
							array.add(json);
						}
					}
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

		return null;
	}

	@Override
	protected String _getSalePersonOrgUnitRange(Context ctx, String param)
	throws BOSException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	protected void _exportData(Context ctx,String cuid,int type, String fid,String fstatus) throws BOSException {
		try {
			boolean bl = false;
			StringBuffer sql=new StringBuffer();
			if(type==1){
				bl = exportcompany(ctx,cuid,fid,fstatus);
			}
			if(type==2){
				bl = exportcustomer(ctx,cuid,fid,fstatus);
			}
			if(type==4){
				bl = exportmaterial(ctx,cuid,fid,fstatus);
			}

			if(type==3){
				sql = new StringBuffer();
				sql.append("select * from t_org_company where fname_l2='诸城六和东方食品有限公司' ");
				IRowSet rsb=com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,sql.toString());

				if(rsb.next()){
					cuid=rsb.getString("fid");
				}

				bl = exportperson(ctx,cuid,fid,fstatus);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean exportcustomer(Context ctx,String cuid,String fid,String fstatus) throws BOSException{
		boolean bl = false;
		try {
			String url="jdbc:sqlserver://10.1.1.21:1433;DatabaseName=lhjt "; //mydb为数据库 
			String user="sa";
			String password="lhjt";
			StringBuffer sql=new StringBuffer();
			sql.append("select * from t_lhs_database ");

			IRowSet rsb=com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,sql.toString());
			if(rsb.next()){
				url=rsb.getString("furl");
				user=rsb.getString("fuser");
				password=rsb.getString("fpassword");
			}
			DbCon aa=new DbCon(url,user,password);
//			//删除数据
//			sql = new StringBuffer();
//			aa.execute(" delete from t_BD_Customer ");
			aa.execute(" delete from t_BD_Customer where fid='"+fid+"' ");


			sql=new StringBuffer();
			sql.append(" Select t2.fid,t2.fnumber,t2.fname_l2 fname,"); 
			sql.append(" isnull(t3.fcontactperson,'') fcontactperson,isnull(t3.fmobile,'') fmobile, ");
			sql.append(" isnull(t4.faddress_l2,'') faddress ,isnull(t2.fmnemoniccode,'') fhelpcode  ");
			sql.append(" from T_BD_CustomerSaleInfo t1 ");
			sql.append(" inner join t_BD_Customer t2 on t2.FID=t1.FCustomerID ");
			sql.append(" left join t_bd_customerlinkman t3 on t3.fcustomersaleid=t1.fid ");
			sql.append(" left join t_bd_customerdlvaddress t4 on t4.fcustomersaleinfoid=t1.fid ");
			sql.append(" where t1.FControlUnitID='" + cuid + "' ");
			sql.append(" and t2.FID='" + fid+ "'");
			IRowSet rsa=com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,sql.toString());
			if(rsa.next()){
				String fcontactperson="";
				fcontactperson=rsa.getString("fcontactperson");
				if(fcontactperson==null){
					fcontactperson="";
				}
				String fmobile="";
				fmobile=rsa.getString("fmobile");
				if(fmobile==null){
					fmobile="";
				}
				String faddress="";
				faddress=rsa.getString("faddress");
				if(faddress==null){
					faddress="";
				}
				String fhelpcode="";
				fhelpcode=rsa.getString("fhelpcode");
				if(fhelpcode==null){
					fhelpcode="";
				}
				sql = new StringBuffer();
				sql.append(" insert into t_BD_Customer  ");
				sql.append("(fid,fname_l2,fnumber,FADDRESS,FLinkman,FLinktel,fmnemoniccode,fstatus)");
				sql.append(" values('"+rsa.getString("fid")+"','"+rsa.getString("fname")+"','"+rsa.getString("fnumber")+"',  ");
				sql.append(" '"+faddress+"','"+fcontactperson+"','"+fmobile+"','"+fhelpcode+"','"+fstatus+"' )  ");
				aa.execute(sql.toString());
				bl  = true;
			}
			aa.disconnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BOSException("错误：",e);
		}
		return bl;
	}
	public boolean exportmaterial(Context ctx,String cuid,String fid,String fstatus) throws BOSException{
		boolean bl = false;
		StringBuffer sql=new StringBuffer();
		try {
			String url="jdbc:sqlserver://10.1.1.21:1433;DatabaseName=TempK3db "; //mydb为数据库 
			String user="sa";
			String password="lhjt";

			sql.append("select * from t_lhs_database ");
			IRowSet rsb=com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,sql.toString());
			if(rsb.next()){
				url=rsb.getString("furl");
				user=rsb.getString("fuser");
				password=rsb.getString("fpassword");
			}
			DbCon aa=new DbCon(url,user,password);
			//删除数据
//			sql = new StringBuffer();
			aa.execute(" delete from t_BD_Material where fid='"+fid+"'");



			sql=new StringBuffer();
			sql.append(" Select t1.FID,t1.fname_l2,t1.fnumber,t1.fhelpcode,t3.fname_l2 fbaseunitname ");
			sql.append(" from t_BD_Material t1");
			sql.append(" inner join t_bd_measureunit t3 on t3.fid = t1.fbaseunit ");
			sql.append(" where  t1.fid='"+fid+"'");

		    rsb=com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,sql.toString());
			int i = 0;
			while(rsb.next()){
				i++;
				String unitname="";
				String coefficient="";

				sql = new StringBuffer();
				sql.append("  select t3.fid fid,t3.fname_l2 funitname,t3.fcoefficient from ");
				sql.append("  t_bd_materialsales t1 inner join t_org_company t2 on t1.fcontrolunitid=t2.fid ");
				sql.append("  inner join t_bd_measureunit t3 on t3.fid = t1.funitid ");
				sql.append("  where t1.fmaterialid='"+rsb.getString("fid")+"' and t2.fid='"+cuid+"' ");
				IRowSet rsa = com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,sql.toString());
				if(rsa.next()){
					unitname=rsa.getString("funitname");
					coefficient=rsa.getString("fcoefficient");
				}else{
					coefficient="1";
				}
				sql = new StringBuffer();
				sql.append(" insert into t_BD_Material ");
				sql.append(" (fid,fname_l2,fnumber,FCoefficient,FUNITNAME,FBASEUNITNAME,fhelpcode,fstatus) ");
				sql.append(" values('"+rsb.getString("fid")+"','"+rsb.getString("fname_l2")+"','"+rsb.getString("fnumber")+"',  ");
				sql.append(" '"+coefficient+"','"+unitname+"','"+rsb.getString("fbaseunitname")+"','"+rsb.getString("fhelpcode")+"','"+fstatus+"' )  ");
				aa.execute(sql.toString());
//				
				bl =true;
			}
			aa.disconnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//MsgBox.showInfo(e.getMessage()+sql);
			throw new BOSException("错误：",e);

		}
		return bl;
	}
	public boolean exportcompany(Context ctx,String cuid,String fid,String fstatus) throws BOSException{
		boolean bl = false;
		try {
			String url="jdbc:sqlserver://10.1.1.21:1433;DatabaseName=lhjt "; //mydb为数据库 
			String user="sa";
			String password="lhjt";
			StringBuffer sql=new StringBuffer();
			sql.append("select * from t_lhs_database ");
			IRowSet rsb=com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,sql.toString());
			if(rsb.next()){
				url=rsb.getString("furl");
				user=rsb.getString("fuser");
				password=rsb.getString("fpassword");
			}
			DbCon aa=new DbCon(url,user,password);
//			//删除数据
			sql = new StringBuffer();
			aa.execute(" delete from t_org_admin where fid='"+fid+"' ");


			ObjectUuidPK pk = new ObjectUuidPK(fid);
			CompanyOrgUnitInfo companyinfo = CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(pk);
			sql = new StringBuffer();
			sql.append(" insert into t_org_admin (fid,fname_l2,fnumber,fstatus) ");
			sql.append(" values('"+fid+"','"+companyinfo.getName()+"','"+companyinfo.getNumber()+"','"+fstatus+"')  ");
			aa.execute(sql.toString());

		    bl = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BOSException("错误：",e);
		}
		return bl;
	}
	public boolean exportperson(Context ctx,String cuid,String fid,String fstatus) throws BOSException{
		boolean bl = false;
		try {
			String url="jdbc:sqlserver://10.1.1.21:1433;DatabaseName=lhjt "; //mydb为数据库 
			String user="sa";
			String password="lhjt";
			StringBuffer sql=new StringBuffer();
			sql.append("select * from t_lhs_database ");
			IRowSet rsb=com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,sql.toString());
			if(rsb.next()){
				url=rsb.getString("furl");
				user=rsb.getString("fuser");
				password=rsb.getString("fpassword");
			}
			DbCon aa=new DbCon(url,user,password);

			aa.execute(" delete from t_bd_person where fid='"+fid+"' ");	

			sql=new StringBuffer();
			sql.append(" Select t1.FID,t1.fname_l2,t1.fnumber ");
			sql.append(" from t_bd_person t1 ");
			sql.append(" inner join t_bd_saleperson t2 on t2.fpersonid=t1.fid ");
			sql.append(" inner join t_bd_SaleGroup t3 on t3.fid=t2.fsalegroupid ");
			sql.append(" where t3.FSaleOrgID='"+cuid+"'");
			sql.append(" and t1.fid='"+fid+"' ");

		    rsb=com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,sql.toString());
			int i = 0;
			while(rsb.next()){

				sql = new StringBuffer();
				sql.append(" insert into t_bd_person (fid,fname_l2,fnumber,fpassword,fstatus) ");
				sql.append(" values('"+rsb.getString("fid")+"','"+rsb.getString("fname_l2")+"',  ");
				sql.append(" '"+rsb.getString("fnumber")+"','7jAcxFCTFDiFCd7JbTBT15a5yUw','"+fstatus+"') ");
				aa.execute(sql.toString());

				bl = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BOSException("错误：",e);
		}
		return bl;
	}*/
}