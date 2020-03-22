package com.kingdee.eas.custom.salediscount.app;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.bot.BOTMappingFactory;
import com.kingdee.bos.metadata.bot.BOTMappingInfo;
import com.kingdee.bos.metadata.bot.DefineSysEnum;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.botp.BotpExtConfigHelper;
import com.kingdee.eas.base.botp.BotpExtConfigHelper.ExtConfigInfo;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.base.param.ParamControlFactory;
import com.kingdee.eas.base.param.util.ParamManager;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.assistant.CurrencyInfo;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.assistant.PeriodFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.assistant.PeriodTypeInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.MaterialInventoryInfo;
import com.kingdee.eas.basedata.master.material.MaterialSalesCollection;
import com.kingdee.eas.basedata.master.material.MaterialSalesFactory;
import com.kingdee.eas.basedata.master.material.MaterialSalesInfo;
import com.kingdee.eas.basedata.master.material.app.MaterialControllerBean;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.IOrgSwitchFacade;
import com.kingdee.eas.basedata.org.OrgSwitchFacadeFactory;
import com.kingdee.eas.basedata.org.SaleOrgUnitInfo;
import com.kingdee.eas.basedata.scm.sd.sale.IPriceProvider;
import com.kingdee.eas.basedata.scm.sd.sale.MaterialBasePriceInfo;
import com.kingdee.eas.basedata.scm.sd.sale.PriceCondition;
import com.kingdee.eas.basedata.scm.sd.sale.PriceProviderFactory;
import com.kingdee.eas.basedata.scm.sd.sale.SalePriceTO;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.ResultInfo;
import com.kingdee.eas.custom.common.app.AppCommonUtil;
import com.kingdee.eas.custom.salediscount.CustomerDiscountInfo;
import com.kingdee.eas.custom.salediscount.CustomerMaterialDSInfo;
import com.kingdee.eas.custom.salediscount.DiscountCashDetail;
import com.kingdee.eas.custom.salediscount.DiscountCashInfo;
import com.kingdee.eas.custom.salediscount.DiscountCompanyFactory;
import com.kingdee.eas.custom.salediscount.DiscountCompanyInfo;
import com.kingdee.eas.custom.salediscount.DiscountGridLogEntryInfo;
import com.kingdee.eas.custom.salediscount.DiscountRecordBillEntryInfo;
import com.kingdee.eas.custom.salediscount.DiscountRecordBillFactory;
import com.kingdee.eas.custom.salediscount.DiscountRecordBillInfo;
import com.kingdee.eas.custom.salediscount.DiscountSetEntryCollection;
import com.kingdee.eas.custom.salediscount.DiscountSetEntryFactory;
import com.kingdee.eas.custom.salediscount.DiscountSetEntryInfo;
import com.kingdee.eas.custom.salediscount.DiscountSetFactory;
import com.kingdee.eas.custom.salediscount.DiscountSetInfo;
import com.kingdee.eas.custom.salediscount.DiscountTypeEnum;
import com.kingdee.eas.custom.salediscount.DsNameTypeEnum;
import com.kingdee.eas.custom.salediscount.IDiscountRecordBill;
import com.kingdee.eas.custom.salediscount.billStatus;
import com.kingdee.eas.fi.cas.BillStatusEnum;
import com.kingdee.eas.fi.cas.ReceivingBillCollection;
import com.kingdee.eas.fi.cas.ReceivingBillInfo;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.scm.common.SCMBillCommonFacadeFactory;
import com.kingdee.eas.scm.sd.sale.SaleOrderCollection;
import com.kingdee.eas.scm.sd.sale.SaleOrderFactory;
import com.kingdee.eas.scm.sd.sale.SaleOrderInfo;
import com.kingdee.eas.scm.sd.sale.SaleReturnsCollection;
import com.kingdee.eas.scm.sd.sale.SaleReturnsFactory;
import com.kingdee.eas.scm.sd.sale.SaleReturnsInfo;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.eas.wlhlcomm.BotpAppCommon;
import com.kingdee.jdbc.rowset.IRowSet;

public class DiscountFacadeControllerBean extends AbstractDiscountFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.salediscount.app.DiscountFacadeControllerBean");


//	/**
//	 * 获得指定公司的折让设置  是否启用折让
//	 */
//	protected DiscountCompanyInfo _getCompanyDSSet(Context ctx, String companyID)
//			throws BOSException {
//		String sql = "select fid from CT_NDI_DiscountCompany where CFCompanyID =?";
//		String[] args = {companyID};
//		IRowSet  rs = DbUtil.executeQuery(ctx, sql, args);
//		try{
//			if(rs.next()){
//				String fid = rs.getString("fid");
//				return DiscountCompanyFactory.getLocalInstance(ctx).getDiscountCompanyInfo(new ObjectUuidPK(fid));
//			}else{
//				return null;
//			}
//		}catch(Exception e){
//			throw new BOSException(e);
//		}
//	}
	
	
	/**
	 * 获得指定公司的折让设置  是否启用折让
	 */
	protected DiscountCompanyInfo _getCompanyDSSet(Context ctx, String companyID)
			throws BOSException {
		String sql = "select fid,CFEnableLZdiscount,CFEnableSWDiscount,CFEnableMonthDiscount,CFEnableYearDiscount,CFEnableFXDiscount,CFOrderYZToRecordBotp,CFOrderYearZToRecordBotp,CFOrderFXToRecordBotp,CFRecordToReceivingBotp  from CT_NDI_DiscountCompany where CFCompanyID =?";
		String[] args = {companyID};
		IRowSet  rs = DbUtil.executeQuery(ctx, sql, args);
		try{
			if(rs.next()){
				
				DiscountCompanyInfo discountCompanySet = new DiscountCompanyInfo();
				
//				String companyID = rs.getString("");
				CompanyOrgUnitInfo companyInfo = new CompanyOrgUnitInfo();
				companyInfo.setId(BOSUuid.read(companyID));
				discountCompanySet.setCompany(companyInfo);
				
				discountCompanySet.setId(BOSUuid.read(rs.getString("fid")));
				discountCompanySet.setEnableLZdiscount(rs.getBoolean("CFEnableLZdiscount"));
				discountCompanySet.setEnableSWDiscount(rs.getBoolean("CFEnableSWDiscount"));
				discountCompanySet.setEnableMonthDiscount(rs.getBoolean("CFEnableMonthDiscount"));
				discountCompanySet.setEnableYearDiscount(rs.getBoolean("CFEnableYearDiscount"));
				discountCompanySet.setEnableFXDiscount(rs.getBoolean("CFEnableFXDiscount"));
				discountCompanySet.setOrderYZToRecordBotp(rs.getString("CFOrderYZToRecordBotp"));
				discountCompanySet.setOrderYearZToRecordBotp(rs.getString("CFOrderYearZToRecordBotp"));
				discountCompanySet.setOrderFXToRecordBotp(rs.getString("CFOrderFXToRecordBotp"));
				discountCompanySet.setRecordToReceivingBotp(rs.getString("CFRecordToReceivingBotp"));
				
				
				return discountCompanySet; 
			}else{
				return null;
			}
		}catch(Exception e){
			throw new BOSException(e);
		}
	}
	/**
	 * 获得立折信息
	 */
    @Override
	protected ResultInfo _getLiDiscountValue(Context ctx, 
			String saleOrgUnitID,
			String customerID, 
			String materialID, 
			BigDecimal noDSQty,
			BigDecimal basePrice,
			String bizDate,
			BigDecimal coefficient,
			List dsGridLogs,
			int seq,
			String saleOrderID,
			String valieOrderEntryIDs,
			boolean isReturns,
			Map materialQtyMap)
			throws BOSException {
		// TODO Auto-generated method stub
    	if(coefficient == null || coefficient.equals(new BigDecimal("0"))){
			coefficient = new BigDecimal("1");
		}
		BigDecimal baseQty = noDSQty.multiply(coefficient);
		return getDiscountValue(ctx, 
				saleOrgUnitID,
				customerID,
				materialID,
				baseQty,
				noDSQty.multiply(basePrice),
				basePrice,
				DiscountTypeEnum.LIZHE_VALUE,
				bizDate,dsGridLogs,
				seq,
				saleOrderID,
				valieOrderEntryIDs,
				isReturns,
				materialQtyMap);
	}

	/**
	 * 获得赠包数据
	 */
    @Override
	protected ResultInfo _getZengBaoDiscountValue(Context ctx,
			String saleOrgUnitID, 
			String customerID,
			String materialID,
			BigDecimal noDSQty,
			
			BigDecimal basePrice,
			String bizDate,
			BigDecimal coefficient,
			List dsGridLogs,
			int seq,
			String saleOrderID,
			String valieOrderEntryIDs,
			boolean isReturns,
			Map materialQtyMap) throws BOSException {
		// TODO Auto-generated method stub
    	if(coefficient == null || coefficient.equals(new BigDecimal("0"))){
			coefficient = new BigDecimal("1");
		}
    	
		BigDecimal baseQty = noDSQty.multiply(coefficient);
		return getDiscountValue(ctx, 
				saleOrgUnitID, 
				customerID,
				materialID,
				baseQty,
				noDSQty.multiply(basePrice),
				basePrice,
				DiscountTypeEnum.SHIWU_VALUE, 
				bizDate,
				dsGridLogs,
				seq,
				saleOrderID,
				valieOrderEntryIDs,
				isReturns,
				materialQtyMap);
		
		
		
	}

    /**
     * 获得月折数据
     */
	@Override
	protected ResultInfo _getMonthDiscountValue(Context ctx,
			String saleOrgUnitID, 
			String customerID,
			String materialID,
			BigDecimal noDSQty,
			BigDecimal basePrice,
			String date,
			BigDecimal coefficient,
			List dsGridLogs,
			int seq,
			String saleOrderID,
			String valieOrderEntryIDs,
			boolean isReturns,
			Map materialQtyMap) throws BOSException {
		// TODO Auto-generated method stub
		if(coefficient == null || coefficient.equals(new BigDecimal("0"))){
			coefficient = new BigDecimal("1");
		}
		BigDecimal baseQty = noDSQty.multiply(coefficient);
		return getDiscountValue(ctx,
				saleOrgUnitID,
				customerID,
				materialID,
				baseQty,
				noDSQty.multiply(basePrice),
				basePrice,
				DiscountTypeEnum.YUEZHE_VALUE,
				date,
				dsGridLogs,
				seq,
				saleOrderID,
				valieOrderEntryIDs,
				isReturns,
				materialQtyMap);
	}

	/**
	 * 获得年折数据
	 */
	@Override
	protected ResultInfo _getYearDiscountValue(Context ctx,
			String saleOrgUnitID, 
			String customerID, 
			String materialID,
			BigDecimal noDSQty,
			BigDecimal basePrice,
			String date,
			BigDecimal coefficient,
			List dsGridLogs,
			int seq,
			String saleOrderID,
			String valieOrderEntryIDs,
			boolean isReturns,
			Map materialQtyMap) throws BOSException {
		// TODO Auto-generated method stub
		if(coefficient == null || coefficient.equals(new BigDecimal("0"))){
			coefficient = new BigDecimal("1");
		}
		BigDecimal baseQty = noDSQty.multiply(coefficient);
		return getDiscountValue(ctx, 
				saleOrgUnitID,
				customerID,
				materialID,
				baseQty,
				noDSQty.multiply(basePrice),
				basePrice,
				DiscountTypeEnum.NIANZHE_VALUE,
				date,
				dsGridLogs,
				seq,
				saleOrderID,
				valieOrderEntryIDs,
				isReturns,
				materialQtyMap);
	}

	/**
	 * 获得分销 折让
	 */
	@Override
	protected ResultInfo _getFenxiaoDiscountValue(Context ctx,
			String saleOrgUnitID,
			String customerID,
			String materialID,
			BigDecimal noDSQty, 
			BigDecimal basePrice,
			String date, 
			BigDecimal coefficient,
			List dsGridLogs,
			int seq,
			String saleOrderID,
			String valieOrderEntryIDs,
			boolean isReturns,
			Map materialQtyMap)
			throws BOSException {
		if(coefficient == null || coefficient.equals(new BigDecimal("0"))){
			coefficient = new BigDecimal("1");
		}
		BigDecimal baseQty = noDSQty.multiply(coefficient);
		return getDiscountValue(ctx,
				saleOrgUnitID,
				customerID,
				materialID,
				baseQty,
				noDSQty.multiply(basePrice),
				basePrice,
				DiscountTypeEnum.FENXIAO_VALUE, 
				date,
				dsGridLogs,
				seq,
				saleOrderID,
				valieOrderEntryIDs,
				isReturns,
				materialQtyMap);
	}
	/**
	 * 根据销售组织ID\ 客户ID\ 物料ID\ 折扣前数量\ 折让类别 
	 * 查询出具体折让类型的折让表达式和 折让金额(数量)
	 * 
	 * 
	 * ------------------------------20141022修改添加isReturns 字段 如果是销售退货申请单 则对折让政策不考虑各种限制-------------------
	 */
	protected ResultInfo getDiscountValue_old(Context ctx, 
			String saleOrgUnitID,
			String customerID,
			String materialID, 
			BigDecimal noDSBaseQuantity, 
			BigDecimal noDSAmount,
			BigDecimal basePrice,
			String discountType,
			String bizDate,
			List dsGridLogs,
			int seq,
			String saleOrderID,
			String valieOrderEntryIDs,
			boolean isReturns) throws BOSException {
		
		// 首先获得符合条件的所有 折让政策,然后逐个计算折让金额 最后累加得出 总金额
		// 当前日期
		Date currDate = new Date();
		
		// 返回结果 message 保存计算公式    returnObj 设置为BigDecimal  结算处的折让数合计
		ResultInfo result = new ResultInfo();
		result.setMessage("");
		result.setReturnObj(null);
		result.setSuccess(true);
		result.setDiscountLogInfos(new ArrayList());
		if(noDSBaseQuantity == null) return result;
		
		// 获得所有符合条件的 折让政策分录，然后逐条计算返回结果
		List<Map<String,Object>> dsEntryIDSet = getDiscountSets(ctx, saleOrgUnitID, customerID, materialID, noDSBaseQuantity, discountType,bizDate,dsGridLogs);
		try{
			StringBuilder fomula = new StringBuilder();
			BigDecimal allDiscount = new BigDecimal("0");
			
			
			
			if(dsEntryIDSet != null && dsEntryIDSet.size() > 0){
				
				
				for(int i = 0; i < dsEntryIDSet.size(); i++){
					// 用来计算的数量
					// 小于下限 不计算
					// 数量折算成吨
					BigDecimal noDSQty  = new BigDecimal("0");
					if(DiscountTypeEnum.SHIWU_VALUE.equals(discountType)){
						// 20141028 根据新需求 修改 实物折扣为 保留两位小数
//						 noDSQty = noDSBaseQuantity.divide(new BigDecimal("1000"),0, RoundingMode.DOWN);
						 noDSQty = noDSBaseQuantity.divide(new BigDecimal("1000"),2, RoundingMode.DOWN);
					}else{
						 noDSQty = noDSBaseQuantity.divide(new BigDecimal("1000"),6, RoundingMode.HALF_UP);
					}
					Map<String,Object> entrySetEntryInfo = dsEntryIDSet.get(i);
					// 政策限制条件
					String billID = (String) entrySetEntryInfo.get("billID");
					boolean CFIsLimitMerge = (Boolean) entrySetEntryInfo.get("CFIsLimitMerge");
					String entryID = (String) entrySetEntryInfo.get("dssetEntryID");
					
					
					// 获取当前可用数据
					// 是否启用销售量限制
					Boolean saleQtyLimitEnable = false;
					// 是否启用销售金额限制
					Boolean saleAmountLimitEnable = false;
					// 是否启用销售折让额限制
					Boolean disAmountEnable = false;
					BigDecimal canUseSaleQty = new BigDecimal("0");
					BigDecimal canUseSaleAmount =  new BigDecimal("0");
					BigDecimal canUseDisAmount =  new BigDecimal("0");
					
					// 获得 当前还可使用的折让 数 （去除内存中已计算的数据和 已经保存的折让日志数据）
					Map<String,Object>  limitLogs = getEnabledValues(ctx, 
							billID,
							customerID,
							CFIsLimitMerge,
							entrySetEntryInfo,
							dsGridLogs,
							seq,
							saleOrderID,
							valieOrderEntryIDs,
							isReturns);
					
					if(limitLogs != null ){
						boolean enabled = (Boolean) limitLogs.get("enabled");
						if(!enabled){
							continue;
						}else{
							// 获得需要校验的 内容和 可用数量、金额
							saleQtyLimitEnable = (Boolean) limitLogs.get("saleQtyLimitEnable");
							saleAmountLimitEnable = (Boolean) limitLogs.get("saleAmountLimitEnable");
							disAmountEnable = (Boolean) limitLogs.get("disAmountEnable");
							canUseSaleQty = (BigDecimal) limitLogs.get("canUseSaleQty");
							// 数量 这算成千克
//							canUseSaleQty = canUseSaleQty.multiply(new BigDecimal("1000"));
							
							canUseSaleAmount = (BigDecimal) limitLogs.get("canUseSaleAmount");
							canUseDisAmount = (BigDecimal) limitLogs.get("canUseDisAmount");
							
							// 获得 三个可用金额
						}
					}
					
					DiscountSetEntryInfo dse = DiscountSetEntryFactory.getLocalInstance(ctx).getDiscountSetEntryInfo(new ObjectUuidPK(entryID));
					
					StringBuilder message = new StringBuilder();
					if(dse != null){
						BigDecimal qty1 = dse.getQty1();
						qty1 = (qty1 == null ? new BigDecimal("0") : qty1);
						BigDecimal qty2 = dse.getQty2();
						qty2 = (qty2 == null ? new BigDecimal("0") : qty2);
						// qty2不能小于qty1
						if(qty2.compareTo(qty1) <= 0){
							qty2 = new BigDecimal("0");
						}
						BigDecimal standard1 = dse.getStandard1();
						standard1 = (standard1 == null ? new BigDecimal("0") : standard1);
						BigDecimal standard2 = dse.getStandard2();
						standard2 = (standard2 == null ? new BigDecimal("0") : standard2);
						
						
						// 实物折扣数量 和 标准
						BigDecimal swqty1 = dse.getSwQty1();
						swqty1 = (swqty1 == null ? new BigDecimal("0") : swqty1);
						BigDecimal swqty2 = dse.getSwQty2();
						swqty2 = (swqty2 == null ? new BigDecimal("0") : swqty2);
						
						int swStandard1 = dse.getSwStandard1();
						int swStandard2 = dse.getSwStandard2();
						
						// 获得千克单价
						BigDecimal kgPrice = noDSAmount.divide(noDSBaseQuantity, 6,BigDecimal.ROUND_HALF_UP);
						// 获得 通过 政策 的限制条件后的  数量金额
						ResultInfo<BigDecimal> theRightLimit = getTheRightLimit(ctx,
								DiscountTypeEnum.getEnum(discountType),
								saleQtyLimitEnable,
								canUseSaleQty,
								saleAmountLimitEnable,
								canUseSaleAmount,
								disAmountEnable,
								canUseDisAmount,
								kgPrice.multiply(new BigDecimal("1000")),
								basePrice,
								dse);
						// 可用金额 和 总金额比较，可用数量与 订单数量比较（吨）
						if(saleQtyLimitEnable && theRightLimit != null && theRightLimit.isSuccess() && "qty".equals(theRightLimit.getMessage())){
							// 可用数量小于 订单数量时，按可用数量来折算可进行折让计算的   数量
							if(canUseSaleQty.compareTo(noDSQty) < 0){
								noDSQty = canUseSaleQty;
							}
						}
						
						if(saleAmountLimitEnable && theRightLimit != null && theRightLimit.isSuccess() && "amount".equals(theRightLimit.getMessage())){
							// 可用金额小于订单未计算折让金额时，根据 可用金额与总金额比例折算可计算折让数量
							if(canUseSaleAmount.compareTo(noDSAmount) < 0){
								noDSQty = noDSQty.multiply(canUseSaleAmount).divide(noDSAmount,6,BigDecimal.ROUND_HALF_UP);
							}
						}
						// 当前折让政策分录计算出的折让数
						BigDecimal discountValue  = new BigDecimal("0");
						if(noDSQty.compareTo(qty1) < 0){
							continue;
						}else if (qty2 == null || qty2.compareTo(new BigDecimal("0")) == 0 || noDSQty.compareTo(qty2) <= 0){
							if(DiscountTypeEnum.SHIWU_VALUE.equals(discountType)){
								// 实物折扣数量1 为0 时折扣数为 0
								if(swqty1 == null || swqty1.equals(new BigDecimal("0"))){
									continue;
								}
								BigDecimal validQtyK = noDSQty.divide(swqty1,0,RoundingMode.DOWN);
								
								// 计算公式累加
								message.append("+").append(validQtyK.toPlainString()).append("*").append(swStandard1);
								
								discountValue = validQtyK.multiply(new BigDecimal(swStandard1));
//								BigDecimal discountAmount = discountValue.multiply(basePrice);
								
								
							}else{
								// 按标准一执行  
								BigDecimal validQtyK = noDSQty;
								
								
								// 计算公式累加
								message.append("+").append(validQtyK.toPlainString()).append("*").append(standard1.toPlainString());
								
								discountValue = validQtyK.multiply(standard1);
								
							}
							
						}else if(noDSQty.compareTo(qty2) > 0){
							if(DiscountTypeEnum.SHIWU_VALUE.equals(discountType)){
								// 实物折扣数量1 为0 时折扣数为 0
								if(swqty1 == null || swqty1.equals(new BigDecimal("0"))){
									continue;
								}
								//--------------------------------------------------------------------
								// 按标准一执行  一部分
								BigDecimal validQty1K = qty2.divide(swqty1,0,RoundingMode.DOWN);
								// 计算公式累加
								message.append("+").append(validQty1K.toPlainString()).append("*").append(swStandard1);
								
								BigDecimal discountValue1 = validQty1K.multiply(new BigDecimal(swStandard1));
								
								// ------------------------------------------------------------------
								noDSQty = noDSQty.subtract(qty2);
								// 按标准二执行  
								// 实物折扣数量2 为0 时折扣数为 0
								if(swqty2 == null || swqty2.equals(new BigDecimal("0"))){
									continue;
								}
								BigDecimal validQty2K = noDSQty.divide(swqty2,0,RoundingMode.DOWN);
								// 计算公式累加
								message.append("+").append(validQty2K.toPlainString()).append("*").append(swStandard2);
								
								BigDecimal discountValue2 = validQty2K.multiply(new BigDecimal(swStandard2));
								discountValue = discountValue1.add(discountValue2);
							}else{
								//--------------------------------------------------------------------
								// 按标准一执行  一部分
								BigDecimal validQty1K = qty2;
								// 计算公式累加
								message.append("+").append(validQty1K.toPlainString()).append("*").append(standard1.toPlainString());
								
								BigDecimal discountValue1 = validQty1K.multiply(standard1);
								
								// ------------------------------------------------------------------
								noDSQty = noDSQty.subtract(qty2);
								// 按标准二执行  
								BigDecimal validQty2K = noDSQty;
								// 计算公式累加
								message.append("+").append(validQty2K.toPlainString()).append("*").append(standard2.toPlainString());
								
								BigDecimal discountValue2 = validQty2K.multiply(standard2);
								discountValue = discountValue1.add(discountValue2);
							}
						}
						// 折让金额限制
						BigDecimal exeDiscountValue = discountValue.multiply(new BigDecimal("1"));
						
						
						if(disAmountEnable && theRightLimit != null && theRightLimit.isSuccess() && "disamount".equals(theRightLimit.getMessage())){
							if(DiscountTypeEnum.SHIWU_VALUE.equals(discountType)){
								exeDiscountValue = exeDiscountValue.multiply(basePrice);
							}
							// 可用金额小于订单未计算折让金额时，根据 可用金额与总金额比例折算可计算折让数量
							if(canUseDisAmount.compareTo(exeDiscountValue) < 0){
								exeDiscountValue = canUseDisAmount;
								if(DiscountTypeEnum.SHIWU_VALUE.equals(discountType)){
									exeDiscountValue = exeDiscountValue.divide(basePrice,0,BigDecimal.ROUND_DOWN);
									message.append("+(").append(exeDiscountValue.toPlainString()).append("-").append(discountValue.toPlainString()).append(")");
								}else{
									message.append("+(").append(exeDiscountValue.toPlainString()).append("-").append(discountValue.toPlainString()).append(")");
								}
							}else{
								if(DiscountTypeEnum.SHIWU_VALUE.equals(discountType)){
									exeDiscountValue = exeDiscountValue.divide(basePrice,0,BigDecimal.ROUND_DOWN);
									
								}
							}
						}
						
						// 折让金额等于考虑了 折扣量 限制后的 数量
						discountValue = exeDiscountValue;
						
						// 把message添加到fomula
						fomula.append(message.toString());
						if(discountValue.compareTo(new BigDecimal("0")) != 0){
							allDiscount = allDiscount.add(discountValue);
							
							// 记录 
							DiscountGridLogEntryInfo logEntryInfo = new DiscountGridLogEntryInfo();
							logEntryInfo.setDiscountSetEntryID(entryID);
							logEntryInfo.setDiscountSetID(dse.getParent().getId().toString());
							logEntryInfo.setDiscountType(DiscountTypeEnum.getEnum(discountType));
//							logEntryInfo.setOrderEntryQty(item);
							if(DiscountTypeEnum.SHIWU_VALUE.equals(discountType)){
								
								logEntryInfo.setDsQuantity(discountValue);
								if(basePrice == null){
									basePrice = new BigDecimal("0");
								}
								BigDecimal amount = discountValue.multiply(basePrice);
								logEntryInfo.setDsAmount(amount);
							}else{
								logEntryInfo.setDsAmount(discountValue);
							}
							logEntryInfo.setFomula(message.toString());
//							logEntryInfo.set
							// 返回
							result.getDiscountLogInfos().add(logEntryInfo);
						}
						
						
					}
					
					
				}
			}
			
			String returnMessage = "";
			if(fomula.length() > 0){
				returnMessage = fomula.toString().substring(1);
			}
			result.setMessage(returnMessage);
			result.setReturnObj(allDiscount);
		}catch(EASBizException bize){
			throw new BOSException(bize);
		}
		
		return result;
		
	}

	
	
	/**
	 * ************************添加销量累计逻辑后调整代码*******************
	 * 根据销售组织ID\ 客户ID\ 物料ID\ 折扣前数量\ 折让类别 
	 * 查询出具体折让类型的折让表达式和 折让金额(数量)
	 * 
	 * 
	 * ------------------------------20141022修改添加isReturns 字段 如果是销售退货申请单 则对折让政策不考虑各种限制-------------------
	 * 
	 * ------------------------------20151220添加销量累计逻辑后调整代码-------------------
	 */
	protected ResultInfo getDiscountValue(Context ctx, 
			String saleOrgUnitID,
			String customerID,
			String materialID, 
			BigDecimal noDSBaseQuantity, 
			BigDecimal noDSAmount,
			BigDecimal basePrice,
			String discountType,
			String bizDate,
			List dsGridLogs,
			int seq,
			String saleOrderID,
			String valieOrderEntryIDs,
			boolean isReturns,
			Map materialQtyMap) throws BOSException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 首先获得符合条件的所有 折让政策,然后逐个计算折让金额 最后累加得出 总金额
		// 当前日期
		Date currDate = new Date();
		
		// 返回结果 message 保存计算公式    returnObj 设置为BigDecimal  结算处的折让数合计
		ResultInfo result = new ResultInfo();
		result.setMessage("");
		result.setReturnObj(null);
		result.setSuccess(true);
		result.setDiscountLogInfos(new ArrayList());
		if(noDSBaseQuantity == null) return result;
		
		// 内部客户不计算折让
		if(AppCommon.isInternalCustomer(ctx,customerID)){
//			result.setme
			return null;
		}
		// 获得所有符合条件的 折让政策分录，然后逐条计算返回结果
		List<Map<String,Object>> dsEntryIDSet = getDiscountSets(ctx, saleOrgUnitID, customerID, materialID, noDSBaseQuantity, discountType,bizDate,dsGridLogs);
		try{
			StringBuilder fomula = new StringBuilder();
			BigDecimal allDiscount = new BigDecimal("0");
			
			
			
			if(dsEntryIDSet != null && dsEntryIDSet.size() > 0){
				
				
				for(int i = 0; i < dsEntryIDSet.size(); i++){
					// 用来计算的数量
					// 小于下限 不计算
					// 数量折算成吨
					BigDecimal noDSQty  = new BigDecimal("0");
					if(DiscountTypeEnum.SHIWU_VALUE.equals(discountType)){
						// 20141028 根据新需求 修改 实物折扣为 保留两位小数
//						 noDSQty = noDSBaseQuantity.divide(new BigDecimal("1000"),0, RoundingMode.DOWN);
						 noDSQty = noDSBaseQuantity.divide(new BigDecimal("1000"),6, RoundingMode.DOWN);
					}else{
						 noDSQty = noDSBaseQuantity.divide(new BigDecimal("1000"),6, RoundingMode.HALF_UP);
					}
					Map<String,Object> entrySetEntryInfo = dsEntryIDSet.get(i);
					// 政策限制条件
					String billID = (String) entrySetEntryInfo.get("billID");
					boolean CFIsLimitMerge = (Boolean) entrySetEntryInfo.get("CFIsLimitMerge");
					String entryID = (String) entrySetEntryInfo.get("dssetEntryID");
					// 是否按累计销量统计
					boolean FByMonthQtyLimit = (Boolean) entrySetEntryInfo.get("FByMonthQtyLimit");
					// 累计销量的物料分类ID
					String FACCUMULAMATERIALG = (String) entrySetEntryInfo.get("CFACCUMULAMATERIAL");
					// 累计开始时间
					Date FAccumulaBeginDate = (Date) entrySetEntryInfo.get("FAccumulaBeginDate");
					// 累计结束时间
					Date FAccumulaEnddate = (Date) entrySetEntryInfo.get("FAccumulaEnddate");
					
					
					// 获取当前可用数据
					// 是否启用销售量限制
					Boolean saleQtyLimitEnable = false;
					// 是否启用销售金额限制
					Boolean saleAmountLimitEnable = false;
					// 是否启用销售折让额限制
					Boolean disAmountEnable = false;
					BigDecimal canUseSaleQty = new BigDecimal("0");
					BigDecimal canUseSaleAmount =  new BigDecimal("0");
					BigDecimal canUseDisAmount =  new BigDecimal("0");
					
					// 获得 当前还可使用的折让 数 （去除内存中已计算的数据和 已经保存的折让日志数据）
					Map<String,Object>  limitLogs = getEnabledValues(ctx, 
							billID,
							customerID,
							CFIsLimitMerge,
							entrySetEntryInfo,
							dsGridLogs,
							seq,
							saleOrderID,
							valieOrderEntryIDs,
							isReturns);
					
					if(limitLogs != null ){
						boolean enabled = (Boolean) limitLogs.get("enabled");
						if(!enabled){
							continue;
						}else{
							// 获得需要校验的 内容和 可用数量、金额
							saleQtyLimitEnable = (Boolean) limitLogs.get("saleQtyLimitEnable");
							saleAmountLimitEnable = (Boolean) limitLogs.get("saleAmountLimitEnable");
							disAmountEnable = (Boolean) limitLogs.get("disAmountEnable");
							canUseSaleQty = (BigDecimal) limitLogs.get("canUseSaleQty");
							// 数量 这算成千克
//							canUseSaleQty = canUseSaleQty.multiply(new BigDecimal("1000"));
							
							canUseSaleAmount = (BigDecimal) limitLogs.get("canUseSaleAmount");
							canUseDisAmount = (BigDecimal) limitLogs.get("canUseDisAmount");
							
							// 获得 三个可用金额
						}
					}
					
					DiscountSetEntryInfo dse = DiscountSetEntryFactory.getLocalInstance(ctx).getDiscountSetEntryInfo(new ObjectUuidPK(entryID));
					
					
					
					if(dse != null){
						
						
						
						// 获得千克单价
						BigDecimal kgPrice = noDSAmount.divide(noDSBaseQuantity, 6,BigDecimal.ROUND_HALF_UP);
						// 获得 通过 政策 的限制条件后的  数量金额
						ResultInfo<BigDecimal> theRightLimit = getTheRightLimit(ctx,
								DiscountTypeEnum.getEnum(discountType),
								saleQtyLimitEnable,
								canUseSaleQty,
								saleAmountLimitEnable,
								canUseSaleAmount,
								disAmountEnable,
								canUseDisAmount,
								kgPrice.multiply(new BigDecimal("1000")),
								basePrice,
								dse);
						// 可用金额 和 总金额比较，可用数量与 订单数量比较（吨）
						if(saleQtyLimitEnable && theRightLimit != null && theRightLimit.isSuccess() && "qty".equals(theRightLimit.getMessage())){
							// 可用数量小于 订单数量时，按可用数量来折算可进行折让计算的   数量
							if(canUseSaleQty.compareTo(noDSQty) < 0){
								noDSQty = canUseSaleQty;
							}
						}
						
						if(saleAmountLimitEnable && theRightLimit != null && theRightLimit.isSuccess() && "amount".equals(theRightLimit.getMessage())){
							// 可用金额小于订单未计算折让金额时，根据 可用金额与总金额比例折算可计算折让数量
							if(canUseSaleAmount.compareTo(noDSAmount) < 0){
								noDSQty = noDSQty.multiply(canUseSaleAmount).divide(noDSAmount,6,BigDecimal.ROUND_HALF_UP);
							}
						}
						
						
						// 获得当前行计算的 折让记录
						ResultInfo<BigDecimal> execResult = this.execDiscountDetails(ctx, saleOrgUnitID, customerID, materialID, bizDate, noDSQty, discountType, FByMonthQtyLimit, FACCUMULAMATERIALG, FAccumulaBeginDate, FAccumulaEnddate, materialQtyMap, dse);
						
						BigDecimal discountValue = execResult.getReturnObj();
						// 如果计算的折让金额 不大于0 则直接跳过 执行下一条政策明细
						if(discountValue.compareTo(new BigDecimal("0")) <= 0) 
						{
							continue;
						}
						StringBuffer message = new StringBuffer(execResult.getMessage());
						
						// 折让金额限制
						BigDecimal exeDiscountValue = discountValue.multiply(new BigDecimal("1"));
						
						
						if(disAmountEnable && theRightLimit != null && theRightLimit.isSuccess() && "disamount".equals(theRightLimit.getMessage())){
							if(DiscountTypeEnum.SHIWU_VALUE.equals(discountType)){
								exeDiscountValue = exeDiscountValue.multiply(basePrice);
							}
							// 可用金额小于订单未计算折让金额时，根据 可用金额与总金额比例折算可计算折让数量
							if(canUseDisAmount.compareTo(exeDiscountValue) < 0){
								exeDiscountValue = canUseDisAmount;
								if(DiscountTypeEnum.SHIWU_VALUE.equals(discountType)){
									exeDiscountValue = exeDiscountValue.divide(basePrice,0,BigDecimal.ROUND_DOWN);
									message.append("+(").append(exeDiscountValue.toPlainString()).append("-").append(discountValue.toPlainString()).append(")");
								}else{
									message.append("+(").append(exeDiscountValue.toPlainString()).append("-").append(discountValue.toPlainString()).append(")");
								}
							}else{
								if(DiscountTypeEnum.SHIWU_VALUE.equals(discountType)){
									exeDiscountValue = exeDiscountValue.divide(basePrice,0,BigDecimal.ROUND_DOWN);
									
								}
							}
						}
						
						// 折让金额等于考虑了 折扣量 限制后的 数量
						discountValue = exeDiscountValue;
						
						// 把message添加到fomula
						fomula.append(message.toString());
						if(discountValue.compareTo(new BigDecimal("0")) != 0){
							allDiscount = allDiscount.add(discountValue);
							
							// 记录 
							DiscountGridLogEntryInfo logEntryInfo = new DiscountGridLogEntryInfo();
							logEntryInfo.setDiscountSetEntryID(entryID);
							logEntryInfo.setDiscountSetID(dse.getParent().getId().toString());
							logEntryInfo.setDiscountType(DiscountTypeEnum.getEnum(discountType));
//							logEntryInfo.setOrderEntryQty(item);
							if(DiscountTypeEnum.SHIWU_VALUE.equals(discountType)){
								
								logEntryInfo.setDsQuantity(discountValue);
								if(basePrice == null){
									basePrice = new BigDecimal("0");
								}
								BigDecimal amount = discountValue.multiply(basePrice);
								logEntryInfo.setDsAmount(amount);
							}else{
								logEntryInfo.setDsAmount(discountValue);
							}
							logEntryInfo.setFomula(message.toString());
//							logEntryInfo.set
							// 返回
							result.getDiscountLogInfos().add(logEntryInfo);
						}
						
						
					}
					
					
				}
			}
			
			String returnMessage = "";
			if(fomula.length() > 0){
				returnMessage = fomula.toString().substring(1);
			}
			result.setMessage(returnMessage);
			result.setReturnObj(allDiscount);
		}catch(EASBizException bize){
			bize.printStackTrace();
			throw new BOSException(bize);
		} catch (ParseException e) {
			
			e.printStackTrace();
			throw new BOSException(e);
		}
		
		return result;
		
	}
	
	/**
	 * 执行 折让政策计算出 该政策的 执行金额 和计算公式
	 * 20151222 添加   独立出计算过程
	 * @param ctx
	 * @param dse
	 * @return
	 * @throws BOSException 
	 * @throws ParseException 
	 */
	private ResultInfo execDiscountDetails(Context ctx, 
			String saleOrgUnitID,
			String customerID,
			String materialID, 
			String bizDate,
			BigDecimal noDSQty,
			String discountType,
			boolean FByMonthQtyLimit,
			String accumulaMaterialGroupID,
			Date FAccumulaBeginDate,
			Date FAccumulaEnddate,
			Map materialQtyMap,
			DiscountSetEntryInfo dse) throws BOSException, ParseException{
		try{
			dse = DiscountSetEntryFactory.getLocalInstance(ctx).getDiscountSetEntryInfo(new ObjectUuidPK(dse.getId()));
		}catch (EASBizException e){
			throw new BOSException(e);
		}
		// 结果集
		ResultInfo<BigDecimal> result = new ResultInfo<BigDecimal>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		BigDecimal qty1 = dse.getQty1();
		qty1 = (qty1 == null ? new BigDecimal("0") : qty1);
		BigDecimal qty2 = dse.getQty2();
		qty2 = (qty2 == null ? new BigDecimal("0") : qty2);
		BigDecimal qty3 = dse.getQty3();
		qty3 = (qty3 == null ? new BigDecimal("0") : qty3);
		BigDecimal qty4 = dse.getQty4();
		qty4 = (qty4 == null ? new BigDecimal("0") : qty4);
		BigDecimal qty5 = dse.getQty5();
		qty5 = (qty5 == null ? new BigDecimal("0") : qty5);
		// qty2不能小于qty1
		if(qty2.compareTo(qty1) <= 0){
			qty2 = new BigDecimal("0");
		}
		BigDecimal standard1 = dse.getStandard1();
		standard1 = (standard1 == null ? new BigDecimal("0") : standard1);
		BigDecimal standard2 = dse.getStandard2();
		standard2 = (standard2 == null ? new BigDecimal("0") : standard2);
		BigDecimal standard3 = dse.getStandard3();
		standard3 = (standard3 == null ? new BigDecimal("0") : standard3);
		BigDecimal standard4 = dse.getStandard4();
		standard4 = (standard4 == null ? new BigDecimal("0") : standard4);
		BigDecimal standard5 = dse.getStandard5();
		standard5 = (standard5 == null ? new BigDecimal("0") : standard5);
		
		// 实物折扣数量 和 标准
		BigDecimal swqty1 = dse.getSwQty1();
		swqty1 = (swqty1 == null ? new BigDecimal("0") : swqty1);
		BigDecimal swqty2 = dse.getSwQty2();
		swqty2 = (swqty2 == null ? new BigDecimal("0") : swqty2);
		BigDecimal swqty3 = dse.getSwQty3();
		swqty3 = (swqty3 == null ? new BigDecimal("0") : swqty3);
		BigDecimal swqty4 = dse.getSwQty4();
		swqty4 = (swqty4 == null ? new BigDecimal("0") : swqty4);
		BigDecimal swqty5 = dse.getSwQty5();
		swqty5 = (swqty5 == null ? new BigDecimal("0") : swqty5);
		
		
		int swStandard1 = dse.getSwStandard1();
		int swStandard2 = dse.getSwStandard2();
		int swStandard3 = dse.getSwStandard3();
		int swStandard4 = dse.getSwStandard4();
		int swStandard5 = dse.getSwStandard5();
		
		
		StringBuilder message = new StringBuilder();
		// 当前折让政策分录计算出的折让数
		BigDecimal discountValue  = new BigDecimal("0");
		// 不累计销量的逻辑
		if(!FByMonthQtyLimit){
			if(noDSQty.compareTo(qty1) < 0){
				
				return returnExecResult(result, message, discountValue);
			}else if (qty2.compareTo(new BigDecimal("0")) == 0 || noDSQty.compareTo(qty2) <= 0){
				if(DiscountTypeEnum.SHIWU_VALUE.equals(discountType)){
					// 实物折扣数量1 为0 时折扣数为 0
					if(swqty1.equals(new BigDecimal("0"))){
						return returnExecResult(result, message, discountValue);
					}
					BigDecimal validQtyK = noDSQty.divide(swqty1,0,RoundingMode.DOWN);
					
					// 计算公式累加
					message.append("+").append(validQtyK.toPlainString()).append("*").append(swStandard1);
					
					discountValue = validQtyK.multiply(new BigDecimal(swStandard1));
//								BigDecimal discountAmount = discountValue.multiply(basePrice);
					
					
				}else{
					// 按标准一执行  
					BigDecimal validQtyK = noDSQty;
					
					
					// 计算公式累加
					message.append("+").append(validQtyK.toPlainString()).append("*").append(standard1.toPlainString());
					
					discountValue = validQtyK.multiply(standard1);
					
				}
				
			}else if(noDSQty.compareTo(qty2) > 0 && (qty3.compareTo(new BigDecimal("0")) == 0  || noDSQty.compareTo(qty3) <= 0)){
				if(DiscountTypeEnum.SHIWU_VALUE.equals(discountType)){
					// 实物折扣数量2 为0 时折扣数为 0
					if(swqty2 == null || swqty2.equals(new BigDecimal("0"))){
						return returnExecResult(result, message, discountValue);
					}
					//--------------------------------------------------------------------
					// 按标准1执行  一部分
					BigDecimal validQty1K = qty2.divide(swqty1,0,RoundingMode.DOWN);
					// 计算公式累加
					message.append("+").append(validQty1K.toPlainString()).append("*").append(swStandard1);
					
					BigDecimal discountValue1 = validQty1K.multiply(new BigDecimal(swStandard1));
					
					// ------------------------------------------------------------------
					noDSQty = noDSQty.subtract(qty2);
					// 按标准二执行  
					// 实物折扣数量2 为0 时折扣数为 0
					if(swqty2 == null || swqty2.equals(new BigDecimal("0"))){
						return returnExecResult(result, message, discountValue);
					}
					BigDecimal validQty2K = noDSQty.divide(swqty2,0,RoundingMode.DOWN);
					// 计算公式累加
					message.append("+").append(validQty2K.toPlainString()).append("*").append(swStandard2);
					
					BigDecimal discountValue2 = validQty2K.multiply(new BigDecimal(swStandard2));
					discountValue = discountValue1.add(discountValue2);
				}else{
					//--------------------------------------------------------------------
					// 按标准一执行  一部分
					BigDecimal validQty1K = qty2;
					// 计算公式累加
					message.append("+").append(validQty1K.toPlainString()).append("*").append(standard1.toPlainString());
					
					BigDecimal discountValue1 = validQty1K.multiply(standard1);
					
					// ------------------------------------------------------------------
					noDSQty = noDSQty.subtract(qty2);
					// 按标准二执行  
					BigDecimal validQty2K = noDSQty;
					// 计算公式累加
					message.append("+").append(validQty2K.toPlainString()).append("*").append(standard2.toPlainString());
					
					BigDecimal discountValue2 = validQty2K.multiply(standard2);
					discountValue = discountValue1.add(discountValue2);
				}
			}else if(noDSQty.compareTo(qty3) > 0 && (qty4.compareTo(new BigDecimal("0")) == 0  || noDSQty.compareTo(qty4) <= 0)){
				if(DiscountTypeEnum.SHIWU_VALUE.equals(discountType)){
					// 实物折扣数量3 为0 时折扣数为 0
					if(swqty3 == null || swqty3.equals(new BigDecimal("0"))){
						return returnExecResult(result, message, discountValue);
					}
					//--------------------------------------------------------------------
					// 按标准1执行  一部分
					BigDecimal validQty1K = qty2.divide(swqty1,0,RoundingMode.DOWN);
					// 计算公式累加
					message.append("+").append(validQty1K.toPlainString()).append("*").append(swStandard1);
					
					BigDecimal discountValue1 = validQty1K.multiply(new BigDecimal(swStandard1));
//					noDSQty = noDSQty.subtract(qty2);
					// ------------------------------------------------------------------
					//--------------------------------------------------------------------
					// 按标准2执行  一部分
					BigDecimal validQty2K = (qty3.subtract(qty2)).divide(swqty2,0,RoundingMode.DOWN);
					// 计算公式累加
					message.append("+").append(validQty2K.toPlainString()).append("*").append(swStandard2);
					
					BigDecimal discountValue2 = validQty2K.multiply(new BigDecimal(swStandard2));
					
					// ------------------------------------------------------------------
					noDSQty = noDSQty.subtract(qty3);
					// 按标准3执行  
					// 实物折扣数量2 为0 时折扣数为 0
					if(swqty3 == null || swqty3.equals(new BigDecimal("0"))){
						return returnExecResult(result, message, discountValue);
					}
					BigDecimal validQty3K = noDSQty.divide(swqty3,0,RoundingMode.DOWN);
					// 计算公式累加
					message.append("+").append(validQty3K.toPlainString()).append("*").append(swStandard3);
					
					BigDecimal discountValue3 = validQty3K.multiply(new BigDecimal(swStandard3));
					discountValue = discountValue1.add(discountValue2).add(discountValue3);
				}else{
					//--------------------------------------------------------------------
					// 按标准一执行  一部分
					BigDecimal validQty1K = qty2;
					// 计算公式累加
					message.append("+").append(validQty1K.toPlainString()).append("*").append(standard1.toPlainString());
					
					BigDecimal discountValue1 = validQty1K.multiply(standard1);
					
					// ------------------------------------------------------------------
					//--------------------------------------------------------------------
					// 按标准2执行  一部分
					BigDecimal validQty2K = qty3.subtract(qty2);
					// 计算公式累加
					message.append("+").append(validQty2K.toPlainString()).append("*").append(standard2.toPlainString());
					
					BigDecimal discountValue2 = validQty2K.multiply(standard2);
					
					// ------------------------------------------------------------------
					noDSQty = noDSQty.subtract(qty3);
					// 按标准3执行  
					BigDecimal validQty3K = noDSQty;
					// 计算公式累加
					message.append("+").append(validQty3K.toPlainString()).append("*").append(standard3.toPlainString());
					
					BigDecimal discountValue3 = validQty3K.multiply(standard3);
					discountValue = discountValue1.add(discountValue2).add(discountValue3);
				}
			}else if(noDSQty.compareTo(qty4) > 0 && (qty5.compareTo(new BigDecimal("0")) == 0  || noDSQty.compareTo(qty5) <= 0)){
				if(DiscountTypeEnum.SHIWU_VALUE.equals(discountType)){
					// 实物折扣数量4 为0 时折扣数为 0
					if(swqty4 == null || swqty4.equals(new BigDecimal("0"))){
						return returnExecResult(result, message, discountValue);
					}
					//--------------------------------------------------------------------
					// 按标准1执行  一部分
					BigDecimal validQty1K = qty2.divide(swqty1,0,RoundingMode.DOWN);
					// 计算公式累加
					message.append("+").append(validQty1K.toPlainString()).append("*").append(swStandard1);
					
					BigDecimal discountValue1 = validQty1K.multiply(new BigDecimal(swStandard1));
//					noDSQty = noDSQty.subtract(qty2);
					// ------------------------------------------------------------------
					//--------------------------------------------------------------------
					// 按标准2执行  一部分
					BigDecimal validQty2K = (qty3.subtract(qty2)).divide(swqty2,0,RoundingMode.DOWN);
					// 计算公式累加
					message.append("+").append(validQty2K.toPlainString()).append("*").append(swStandard2);
					
					BigDecimal discountValue2 = validQty2K.multiply(new BigDecimal(swStandard2));
					
					// ------------------------------------------------------------------
					//--------------------------------------------------------------------
					// 按标准3执行  一部分
					BigDecimal validQty3K = (qty4.subtract(qty3)).divide(swqty3,0,RoundingMode.DOWN);
					// 计算公式累加
					message.append("+").append(validQty3K.toPlainString()).append("*").append(swStandard3);
					
					BigDecimal discountValue3 = validQty3K.multiply(new BigDecimal(swStandard3));
					
					// ------------------------------------------------------------------
					noDSQty = noDSQty.subtract(qty4);
					// 按标准3执行  
					// 实物折扣数量2 为0 时折扣数为 0
					if(swqty4 == null || swqty4.equals(new BigDecimal("0"))){
						return returnExecResult(result, message, discountValue);
					}
					BigDecimal validQty4K = noDSQty.divide(swqty4,0,RoundingMode.DOWN);
					// 计算公式累加
					message.append("+").append(validQty4K.toPlainString()).append("*").append(swStandard4);
					
					BigDecimal discountValue4 = validQty4K.multiply(new BigDecimal(swStandard4));
					discountValue = discountValue1.add(discountValue2).add(discountValue3).add(discountValue4);
				}else{
					//--------------------------------------------------------------------
					// 按标准一执行  一部分
					BigDecimal validQty1K = qty2;
					// 计算公式累加
					message.append("+").append(validQty1K.toPlainString()).append("*").append(standard1.toPlainString());
					
					BigDecimal discountValue1 = validQty1K.multiply(standard1);
					
					// ------------------------------------------------------------------
					//--------------------------------------------------------------------
					// 按标准2执行  一部分
					BigDecimal validQty2K = qty3.subtract(qty2);
					// 计算公式累加
					message.append("+").append(validQty2K.toPlainString()).append("*").append(standard2.toPlainString());
					
					BigDecimal discountValue2 = validQty2K.multiply(standard2);
					
					// ------------------------------------------------------------------
					//--------------------------------------------------------------------
					// 按标准3执行  一部分
					BigDecimal validQty3K = qty4.subtract(qty3);
					// 计算公式累加
					message.append("+").append(validQty3K.toPlainString()).append("*").append(standard3.toPlainString());
					
					BigDecimal discountValue3 = validQty3K.multiply(standard3);
					
					// ------------------------------------------------------------------
					noDSQty = noDSQty.subtract(qty4);
					// 按标准3执行  
					BigDecimal validQty4K = noDSQty;
					// 计算公式累加
					message.append("+").append(validQty4K.toPlainString()).append("*").append(standard4.toPlainString());
					
					BigDecimal discountValue4 = validQty4K.multiply(standard4);
					discountValue = discountValue1.add(discountValue2).add(discountValue3).add(discountValue4);
				}
			}else if(noDSQty.compareTo(qty5) > 0 ){
				if(DiscountTypeEnum.SHIWU_VALUE.equals(discountType)){
					// 实物折扣数量5 为0 时折扣数为 0
					if(swqty5 == null || swqty5.equals(new BigDecimal("0"))){
						return returnExecResult(result, message, discountValue);
					}
					//--------------------------------------------------------------------
					// 按标准1执行  一部分
					BigDecimal validQty1K = qty2.divide(swqty1,0,RoundingMode.DOWN);
					// 计算公式累加
					message.append("+").append(validQty1K.toPlainString()).append("*").append(swStandard1);
					
					BigDecimal discountValue1 = validQty1K.multiply(new BigDecimal(swStandard1));
//					noDSQty = noDSQty.subtract(qty2);
					// ------------------------------------------------------------------
					//--------------------------------------------------------------------
					// 按标准2执行  一部分
					BigDecimal validQty2K = (qty3.subtract(qty2)).divide(swqty2,0,RoundingMode.DOWN);
					// 计算公式累加
					message.append("+").append(validQty2K.toPlainString()).append("*").append(swStandard2);
					
					BigDecimal discountValue2 = validQty2K.multiply(new BigDecimal(swStandard2));
					
					// ------------------------------------------------------------------
					//--------------------------------------------------------------------
					// 按标准3执行  一部分
					BigDecimal validQty3K = (qty4.subtract(qty3)).divide(swqty3,0,RoundingMode.DOWN);
					// 计算公式累加
					message.append("+").append(validQty3K.toPlainString()).append("*").append(swStandard3);
					
					BigDecimal discountValue3 = validQty3K.multiply(new BigDecimal(swStandard3));
					
					// ------------------------------------------------------------------
					//--------------------------------------------------------------------
					// 按标准4执行  一部分
					BigDecimal validQty4K = (qty5.subtract(qty4)).divide(swqty4,0,RoundingMode.DOWN);
					// 计算公式累加
					message.append("+").append(validQty4K.toPlainString()).append("*").append(swStandard4);
					
					BigDecimal discountValue4 = validQty4K.multiply(new BigDecimal(swStandard4));
					
					// ------------------------------------------------------------------
					noDSQty = noDSQty.subtract(qty5);
					// 按标准4执行  
					// 实物折扣数量4 为0 时折扣数为 0
					if(swqty5 == null || swqty5.equals(new BigDecimal("0"))){
						return returnExecResult(result, message, discountValue);
					}
					BigDecimal validQty5K = noDSQty.divide(swqty5,0,RoundingMode.DOWN);
					// 计算公式累加
					message.append("+").append(validQty5K.toPlainString()).append("*").append(swStandard5);
					
					BigDecimal discountValue5 = validQty5K.multiply(new BigDecimal(swStandard5));
					discountValue = discountValue1.add(discountValue2).add(discountValue3).add(discountValue4).add(discountValue5);
				}else{
					//--------------------------------------------------------------------
					// 按标准一执行  一部分
					BigDecimal validQty1K = qty2;
					// 计算公式累加
					message.append("+").append(validQty1K.toPlainString()).append("*").append(standard1.toPlainString());
					
					BigDecimal discountValue1 = validQty1K.multiply(standard1);
					
					// ------------------------------------------------------------------
					//--------------------------------------------------------------------
					// 按标准2执行  一部分
					BigDecimal validQty2K = qty3.subtract(qty2);
					// 计算公式累加
					message.append("+").append(validQty2K.toPlainString()).append("*").append(standard2.toPlainString());
					
					BigDecimal discountValue2 = validQty2K.multiply(standard2);
					
					// ------------------------------------------------------------------
					//--------------------------------------------------------------------
					// 按标准3执行  一部分
					BigDecimal validQty3K = qty4.subtract(qty3);
					// 计算公式累加
					message.append("+").append(validQty3K.toPlainString()).append("*").append(standard3.toPlainString());
					
					BigDecimal discountValue3 = validQty3K.multiply(standard3);
					
					// ------------------------------------------------------------------
					//--------------------------------------------------------------------
					// 按标准4执行  一部分
					BigDecimal validQty4K = qty5.subtract(qty4);
					// 计算公式累加
					message.append("+").append(validQty4K.toPlainString()).append("*").append(standard4.toPlainString());
					
					BigDecimal discountValue4 = validQty4K.multiply(standard4);
					
					// ------------------------------------------------------------------
					noDSQty = noDSQty.subtract(qty5);
					// 按标准3执行  
					BigDecimal validQty5K = noDSQty;
					// 计算公式累加
					message.append("+").append(validQty5K.toPlainString()).append("*").append(standard5.toPlainString());
					
					BigDecimal discountValue5 = validQty5K.multiply(standard5);
					discountValue = discountValue1.add(discountValue2).add(discountValue3).add(discountValue4).add(discountValue5);
				}
			}
		}else{
			// 累计销量的逻辑
			
			// 判断是否按照销量累计 设置 折让政策，如果是 则取已经开票的销售数量进行比对  获得 折让 计算
			
			Date billBizDate = sdf.parse(bizDate);
			
			// 获得 分类长编码
			/*******************************，如果没有设置物料类别 则 按照物料统计销量***********/
			BigDecimal	hasSaledQty = null;
			String groupLongNumber = null;
			if(StringUtils.isNotBlank(accumulaMaterialGroupID)){
				groupLongNumber = this.getMaterialGroupLongNumber(ctx, accumulaMaterialGroupID);
				
				hasSaledQty = this.getCusMaterialGroupSaleBaseQty(ctx, saleOrgUnitID, customerID, groupLongNumber,null, FAccumulaBeginDate, FAccumulaEnddate, billBizDate);
			}else{
				hasSaledQty = this.getCusMaterialGroupSaleBaseQty(ctx, saleOrgUnitID, customerID, null,materialID, FAccumulaBeginDate, FAccumulaEnddate, billBizDate);
			}
			
			if(hasSaledQty == null){
				hasSaledQty = new BigDecimal("0");
			}
			// 获得该折让设置 的物料分类在其他分录的合计销量
			
			BigDecimal currBillSaleQty = null;
			if(StringUtils.isNotBlank(accumulaMaterialGroupID)){
				currBillSaleQty = getBillSaledQty(ctx, groupLongNumber,null, materialQtyMap);
			}else{
				currBillSaleQty =  getBillSaledQty(ctx, null,materialID, materialQtyMap);
			}
			/*******************************，如果没有设置物料类别 则 按照物料统计销量***********/
			
			// 折算成吨
			if(DiscountTypeEnum.SHIWU_VALUE.equals(discountType)){
				// 20141028 根据新需求 修改 实物折扣为 保留两位小数
//				 noDSQty = noDSBaseQuantity.divide(new BigDecimal("1000"),0, RoundingMode.DOWN);
				hasSaledQty = hasSaledQty.divide(new BigDecimal("1000"),6, RoundingMode.DOWN);
				currBillSaleQty = currBillSaleQty.divide(new BigDecimal("1000"),6, RoundingMode.DOWN);
				
			}else{
				hasSaledQty = hasSaledQty.divide(new BigDecimal("1000"),6, RoundingMode.HALF_UP);
				currBillSaleQty = currBillSaleQty.divide(new BigDecimal("1000"),6, RoundingMode.HALF_UP);
			}
			
			// 除当前行外 累计 已计算的销量
			BigDecimal allSaledQty = hasSaledQty.add(currBillSaleQty);
			
			// 累加上当前行数量后总的销量 吨
			BigDecimal allSaledQtyWithCurr = allSaledQty.add(noDSQty); 
			
			
			// 累计销量不到 销量一 跳过该条 折让设置
			if(allSaledQtyWithCurr.compareTo(qty1) < 0){
				return returnExecResult(result, message, discountValue);
			}else if (qty2.compareTo(new BigDecimal("0")) == 0 || allSaledQtyWithCurr.compareTo(qty2) <= 0){
				// 参与计算销售数量  如果不加当前开票数量已经大于qty1，则直接等于当前开票数量，如果不大于qty1 则 只计算当前票中大于qty1的部分
				BigDecimal usedSaleQty1 = new BigDecimal("0");
				
				if(allSaledQty.compareTo(qty1) >0){
					
				
					
					// 20161025 强英鸭业  赠包算法为  累计销量 每满一吨就 赠包 ，除去当前行外 的数量  去掉已经赠送的部分  与当前 行数量累计计算
//					
					if(DiscountTypeEnum.SHIWU_VALUE.equals(discountType) ){
						// 实物折扣数量1 为0 时折扣数为 0
						if(swqty1 == null || swqty1.equals(new BigDecimal("0"))){
							return returnExecResult(result, message, discountValue);
						}
						BigDecimal nowUseQty =  allSaledQty.subtract((allSaledQty.divide(swqty1,0,RoundingMode.DOWN)).multiply(swqty1));
						usedSaleQty1 = nowUseQty.add(noDSQty);
					}else{
						usedSaleQty1 = noDSQty;
					}
				}else{
					usedSaleQty1 = allSaledQtyWithCurr.subtract(qty1);
				}
				
				if(DiscountTypeEnum.SHIWU_VALUE.equals(discountType)){
					// 实物折扣数量1 为0 时折扣数为 0
					if(swqty1 == null || swqty1.equals(new BigDecimal("0"))){
						return returnExecResult(result, message, discountValue);
					}
				
					
					BigDecimal validQtyK = usedSaleQty1.divide(swqty1,0,RoundingMode.DOWN);
					
					// 计算公式累加
					message.append("+").append(validQtyK.toPlainString()).append("*").append(swStandard1);
					
					discountValue = validQtyK.multiply(new BigDecimal(swStandard1));
//								BigDecimal discountAmount = discountValue.multiply(basePrice);
					
					
				}else{
					// 按标准一执行  
					BigDecimal validQtyK = usedSaleQty1;
					
					
					// 计算公式累加
					message.append("+").append(validQtyK.toPlainString()).append("*").append(standard1.toPlainString());
					
					discountValue = validQtyK.multiply(standard1);
					
				}
				
			}else if(allSaledQtyWithCurr.compareTo(qty2) > 0 && (qty3.compareTo(new BigDecimal("0")) == 0  || allSaledQtyWithCurr.compareTo(qty3) <= 0)){
				// 参与计算销售数量  如果不加当前开票数量已经大于qty1，则直接等于当前开票数量，如果不大于qty1 则 只计算当前票中大于qty1的部分
				BigDecimal usedSaleQty1 = new BigDecimal("0");
				BigDecimal discountValue1 = new BigDecimal("0");
				BigDecimal usedSaleQty2 = new BigDecimal("0");
				BigDecimal discountValue2 = new BigDecimal("0");
				if(allSaledQty.compareTo(qty2) >0){
					usedSaleQty2 = noDSQty;
				}else{
					usedSaleQty2 = allSaledQtyWithCurr.subtract(qty2);
					usedSaleQty1 = qty2.subtract(allSaledQty);
				}
				
				if(DiscountTypeEnum.SHIWU_VALUE.equals(discountType)){ 
					// 实物折扣数量1 为0 时折扣数为 0
					if(swqty2 == null || swqty2.equals(new BigDecimal("0"))){
						return returnExecResult(result, message, discountValue);
					}
					//--------------------------------------------------------------------
					if(usedSaleQty1.compareTo(new BigDecimal("0")) > 0){
						// 按标准一执行  一部分
						BigDecimal validQty1K = usedSaleQty1.divide(swqty1,0,RoundingMode.DOWN);
						// 计算公式累加
						message.append("+").append(validQty1K.toPlainString()).append("*").append(swStandard1);
						
						discountValue1 = validQty1K.multiply(new BigDecimal(swStandard1));
					}
					// ------------------------------------------------------------------
					
					// 按标准二执行  
					// 实物折扣数量2 为0 时折扣数为 0
					if(swqty2 == null || swqty2.equals(new BigDecimal("0"))){
						return returnExecResult(result, message, discountValue);
					}
					BigDecimal validQty2K = usedSaleQty2.divide(swqty2,0,RoundingMode.DOWN);
					// 计算公式累加
					message.append("+").append(validQty2K.toPlainString()).append("*").append(swStandard2);
					
					discountValue2 = validQty2K.multiply(new BigDecimal(swStandard2));
					discountValue = discountValue1.add(discountValue2);
				}else{
					//--------------------------------------------------------------------
					// 按标准一执行  一部分
					//--------------------------------------------------------------------
					if(usedSaleQty1.compareTo(new BigDecimal("0")) > 0){
						BigDecimal validQty1K = usedSaleQty1;
						// 计算公式累加
						message.append("+").append(validQty1K.toPlainString()).append("*").append(standard1.toPlainString());
						
						discountValue1 = validQty1K.multiply(standard1);
					}
					// ------------------------------------------------------------------
					
					// 按标准二执行  
					BigDecimal validQty2K = usedSaleQty2;
					// 计算公式累加
					message.append("+").append(validQty2K.toPlainString()).append("*").append(standard2.toPlainString());
					
					discountValue2 = validQty2K.multiply(standard2);
					discountValue = discountValue1.add(discountValue2);
				}
			}else if(allSaledQtyWithCurr.compareTo(qty3) > 0 && (qty4.compareTo(new BigDecimal("0")) == 0  || allSaledQtyWithCurr.compareTo(qty4) <= 0)){
				// 参与计算销售数量  如果不加当前开票数量已经大于qty1，则直接等于当前开票数量，如果不大于qty1 则 只计算当前票中大于qty1的部分
				BigDecimal usedSaleQty1 = new BigDecimal("0");
				BigDecimal discountValue1 = new BigDecimal("0");
				BigDecimal usedSaleQty2 = new BigDecimal("0");
				BigDecimal discountValue2 = new BigDecimal("0");
				if(allSaledQty.compareTo(qty3) >0){
					usedSaleQty2 = noDSQty;
				}else{
					usedSaleQty2 = allSaledQtyWithCurr.subtract(qty3);
					usedSaleQty1 = qty3.subtract(allSaledQty);
				}
				
				if(DiscountTypeEnum.SHIWU_VALUE.equals(discountType)){ 
					// 实物折扣数量1 为0 时折扣数为 0
					if(swqty3 == null || swqty3.equals(new BigDecimal("0"))){
						return returnExecResult(result, message, discountValue);
					}
					//--------------------------------------------------------------------
					if(usedSaleQty1.compareTo(new BigDecimal("0")) > 0){
						// 按标准一执行  一部分
						BigDecimal validQty1K = usedSaleQty1.divide(swqty2,0,RoundingMode.DOWN);
						// 计算公式累加
						message.append("+").append(validQty1K.toPlainString()).append("*").append(swStandard2);
						
						discountValue1 = validQty1K.multiply(new BigDecimal(swStandard2));
					}
					// ------------------------------------------------------------------
					
					// 按标准二执行  
					// 实物折扣数量2 为0 时折扣数为 0
					if(swqty3 == null || swqty3.equals(new BigDecimal("0"))){
						return returnExecResult(result, message, discountValue);
					}
					BigDecimal validQty2K = usedSaleQty2.divide(swqty3,0,RoundingMode.DOWN);
					// 计算公式累加
					message.append("+").append(validQty2K.toPlainString()).append("*").append(swStandard3);
					
					discountValue2 = validQty2K.multiply(new BigDecimal(swStandard3));
					discountValue = discountValue1.add(discountValue2);
				}else{
					//--------------------------------------------------------------------
					// 按标准2执行  一部分
					//--------------------------------------------------------------------
					if(usedSaleQty1.compareTo(new BigDecimal("0")) > 0){
						BigDecimal validQty1K = usedSaleQty1;
						// 计算公式累加
						message.append("+").append(validQty1K.toPlainString()).append("*").append(standard2.toPlainString());
						
						discountValue1 = validQty1K.multiply(standard2);
					}
					// ------------------------------------------------------------------
					
					// 按标准二执行  
					BigDecimal validQty2K = usedSaleQty2;
					// 计算公式累加
					message.append("+").append(validQty2K.toPlainString()).append("*").append(standard3.toPlainString());
					
					discountValue2 = validQty2K.multiply(standard3);
					discountValue = discountValue1.add(discountValue2);
				}
			}else if(allSaledQtyWithCurr.compareTo(qty4) > 0 && (qty5.compareTo(new BigDecimal("0")) == 0  || allSaledQtyWithCurr.compareTo(qty5) <= 0)){
				// 参与计算销售数量  如果不加当前开票数量已经大于qty1，则直接等于当前开票数量，如果不大于qty1 则 只计算当前票中大于qty1的部分
				BigDecimal usedSaleQty1 = new BigDecimal("0");
				BigDecimal discountValue1 = new BigDecimal("0");
				BigDecimal usedSaleQty2 = new BigDecimal("0");
				BigDecimal discountValue2 = new BigDecimal("0");
				if(allSaledQty.compareTo(qty4) >0){
					usedSaleQty2 = noDSQty;
				}else{
					usedSaleQty2 = allSaledQtyWithCurr.subtract(qty4);
					usedSaleQty1 = qty4.subtract(allSaledQty);
				}
				
				if(DiscountTypeEnum.SHIWU_VALUE.equals(discountType)){ 
					// 实物折扣数量1 为0 时折扣数为 0
					if(swqty4 == null || swqty4.equals(new BigDecimal("0"))){
						return returnExecResult(result, message, discountValue);
					}
					//--------------------------------------------------------------------
					if(usedSaleQty1.compareTo(new BigDecimal("0")) > 0){
						// 按标准一执行  一部分
						BigDecimal validQty1K = usedSaleQty1.divide(swqty3,0,RoundingMode.DOWN);
						// 计算公式累加
						message.append("+").append(validQty1K.toPlainString()).append("*").append(swStandard3);
						
						discountValue1 = validQty1K.multiply(new BigDecimal(swStandard3));
					}
					// ------------------------------------------------------------------
					
					// 按标准二执行  
					// 实物折扣数量2 为0 时折扣数为 0
					if(swqty4 == null || swqty4.equals(new BigDecimal("0"))){
						return returnExecResult(result, message, discountValue);
					}
					BigDecimal validQty2K = usedSaleQty2.divide(swqty4,0,RoundingMode.DOWN);
					// 计算公式累加
					message.append("+").append(validQty2K.toPlainString()).append("*").append(swStandard4);
					
					discountValue2 = validQty2K.multiply(new BigDecimal(swStandard4));
					discountValue = discountValue1.add(discountValue2);
				}else{
					//--------------------------------------------------------------------
					// 按标准2执行  一部分
					//--------------------------------------------------------------------
					if(usedSaleQty1.compareTo(new BigDecimal("0")) > 0){
						BigDecimal validQty1K = usedSaleQty1;
						// 计算公式累加
						message.append("+").append(validQty1K.toPlainString()).append("*").append(standard3.toPlainString());
						
						discountValue1 = validQty1K.multiply(standard3);
					}
					// ------------------------------------------------------------------
					
					// 按标准二执行  
					BigDecimal validQty2K = usedSaleQty2;
					// 计算公式累加
					message.append("+").append(validQty2K.toPlainString()).append("*").append(standard4.toPlainString());
					
					discountValue2 = validQty2K.multiply(standard4);
					discountValue = discountValue1.add(discountValue2);
				}
			}else if(allSaledQtyWithCurr.compareTo(qty5) > 0 ){
				// 参与计算销售数量  如果不加当前开票数量已经大于qty1，则直接等于当前开票数量，如果不大于qty1 则 只计算当前票中大于qty1的部分
				BigDecimal usedSaleQty1 = new BigDecimal("0");
				BigDecimal discountValue1 = new BigDecimal("0");
				BigDecimal usedSaleQty2 = new BigDecimal("0");
				BigDecimal discountValue2 = new BigDecimal("0");
				if(allSaledQty.compareTo(qty4) >0){
					usedSaleQty2 = noDSQty;
				}else{
					usedSaleQty2 = allSaledQtyWithCurr.subtract(qty5);
					usedSaleQty1 = qty5.subtract(allSaledQty);
				}
				
				if(DiscountTypeEnum.SHIWU_VALUE.equals(discountType)){ 
					// 实物折扣数量5 为0 时折扣数为 0
					if(swqty5 == null || swqty5.equals(new BigDecimal("0"))){
						return returnExecResult(result, message, discountValue);
					}
					//--------------------------------------------------------------------
					if(usedSaleQty1.compareTo(new BigDecimal("0")) > 0){
						// 按标准4执行  一部分
						BigDecimal validQty1K = usedSaleQty1.divide(swqty4,0,RoundingMode.DOWN);
						// 计算公式累加
						message.append("+").append(validQty1K.toPlainString()).append("*").append(swStandard4);
						
						discountValue1 = validQty1K.multiply(new BigDecimal(swStandard4));
					}
					// ------------------------------------------------------------------
					
					// 按标准5执行  
					// 实物折扣数量5 为0 时折扣数为 0
					if(swqty5 == null || swqty5.equals(new BigDecimal("0"))){
						return returnExecResult(result, message, discountValue);
					}
					BigDecimal validQty2K = usedSaleQty2.divide(swqty5,0,RoundingMode.DOWN);
					// 计算公式累加
					message.append("+").append(validQty2K.toPlainString()).append("*").append(swStandard5);
					
					discountValue2 = validQty2K.multiply(new BigDecimal(swStandard5));
					discountValue = discountValue1.add(discountValue2);
				}else{
					//--------------------------------------------------------------------
					// 按标准4执行  一部分
					//--------------------------------------------------------------------
					if(usedSaleQty1.compareTo(new BigDecimal("0")) > 0){
						BigDecimal validQty1K = usedSaleQty1;
						// 计算公式累加
						message.append("+").append(validQty1K.toPlainString()).append("*").append(standard4.toPlainString());
						
						discountValue1 = validQty1K.multiply(standard4);
					}
					// ------------------------------------------------------------------
					
					// 按标准二执行  
					BigDecimal validQty2K = usedSaleQty2;
					// 计算公式累加
					message.append("+").append(validQty2K.toPlainString()).append("*").append(standard5.toPlainString());
					
					discountValue2 = validQty2K.multiply(standard5);
					discountValue = discountValue1.add(discountValue2);
				}
			}
		
		}
		
		return returnExecResult(result, message, discountValue);
	}
	
	/**
	 * 获取对应物料类别 在当前单据内产生的销量
	 * @param groupLongNumber
	 * @param materialQtyMap
	 * @return
	 * @throws BOSException 
	 * 20161020 更新，可按照物料获取 单据内销量
	 */
	private BigDecimal getBillSaledQty(Context ctx, 
			String groupLongNumber,
			String materialID,
			Map materialQtyMap) throws BOSException {
		BigDecimal saleQty = new BigDecimal("0");
		
		if(materialQtyMap != null && materialQtyMap.size() > 0){
			StringBuilder materialIDs = new StringBuilder();
			Set<String> idSet = materialQtyMap.keySet();
			Iterator<String> idIte = idSet.iterator();
			if(StringUtils.isNotBlank(groupLongNumber) && StringUtils.isBlank(materialID)){
				while(idIte.hasNext()){
					String matID = idIte.next();
					materialIDs.append("'");
					materialIDs.append(matID);
					materialIDs.append("',");
				}
				// 获取 materialID sql
				StringBuilder searchSQL = new StringBuilder("select tm.fid from t_bd_material tm inner join t_bd_materialgroup tg on tm.FMaterialGroupID = tg.fid where tg.flongnumber like '");
				searchSQL.append(groupLongNumber);
				searchSQL.append("%' and tm.fid in (");
				searchSQL.append(materialIDs.substring(0, materialIDs.length()-1));
				searchSQL.append(") ");
				
				try{
					IRowSet rs = DbUtil.executeQuery(ctx, searchSQL.toString());
					while(rs.next()){
						String mid = rs.getString("fid");
						BigDecimal mqty = (BigDecimal) materialQtyMap.get(mid);
						
						saleQty = saleQty.add(mqty);
					}
				}catch(SQLException sqle){
					sqle.printStackTrace();
					throw new BOSException(sqle);
				}
			}else if(StringUtils.isNotBlank(materialID)){
				BigDecimal mqty = (BigDecimal) materialQtyMap.get(materialID);
				if(mqty != null){
					saleQty = saleQty.add(mqty);
				}
			}
			
		}
		
		return saleQty;
	}
	/**
	 * 返回执行结果
	 * @param result
	 * @param message
	 * @param discountValue
	 * @return
	 */
	private ResultInfo<BigDecimal> returnExecResult(ResultInfo<BigDecimal> result, StringBuilder message, BigDecimal discountValue){
		result.setMessage(message.toString());
		result.setReturnObj(discountValue);
		return result;
	}
	
	/**
	 * 根据每种限制方式  已经计算好的各自可用金额 或者数量 来比对 ，选择限制条件最苛刻的一个作为最终的限制条件
	 * @param ctx
	 * @param saleQtyLimitEnable
	 * @param canUseSaleQty
	 * @param saleAmountLimitEnable
	 * @param canUseSaleAmount
	 * @param disAmountEnable
	 * @param canUseDisAmount
	 * @param tPrice  每吨价格
	 * @param basePrice  原价格
	 * @return
	 */
	private ResultInfo<BigDecimal> getTheRightLimit(Context ctx,
			DiscountTypeEnum discountType,
			Boolean saleQtyLimitEnable,
			BigDecimal canUseSaleQty,
			Boolean saleAmountLimitEnable,
			BigDecimal canUseSaleAmount,
			Boolean disAmountEnable,
			BigDecimal canUseDisAmount,
			BigDecimal tPrice,
			BigDecimal basePrice,
			DiscountSetEntryInfo dse) {
		canUseSaleQty = canUseSaleQty == null? new BigDecimal("0"):canUseSaleQty;
		canUseSaleAmount = canUseSaleAmount == null? new BigDecimal("0"):canUseSaleAmount;
		canUseDisAmount = canUseDisAmount == null? new BigDecimal("0"):canUseDisAmount;
		
		ResultInfo<BigDecimal> resultInfo = new ResultInfo<BigDecimal>();
		String enableLimit = "qty"; // 用来设置返回值中的message    qty：amount：disamount 默认使用销售数量
		BigDecimal limit = canUseSaleQty.multiply(new BigDecimal("1")); // 默认的 数量为  销售数量   单位为 吨
		
//		BigDecimal qtyAmount = new BigDecimal("0");
//		BigDecimal amountAmount = canUseSaleAmount.multiply(new BigDecimal("1"));
//		BigDecimal disAmountMin = new BigDecimal("0");
//		BigDecimal disAmountMax = new BigDecimal("0");
//		// 从
//		
//		qtyAmount = tPrice.multiply(canUseSaleQty);
		// 先计算出 按销量和 销售额 限制 折让时 生成的 折让金额，然后三者比较返回较小的一个
		BigDecimal amountQty = canUseSaleAmount.divide(basePrice,2,BigDecimal.ROUND_HALF_UP);
		// 按销量限制 计算的折让金额
		BigDecimal qtyDsamount = this.getDsamount(ctx, canUseSaleQty, discountType, dse);
		if(discountType.equals(DiscountTypeEnum.ShiWu)){
			qtyDsamount = qtyDsamount.multiply(basePrice);
		}
		
		
		// 按照销售金额限制 计算的 折让金额
		BigDecimal amountDsamount = this.getDsamount(ctx, amountQty, discountType, dse);
		if(discountType.equals(DiscountTypeEnum.ShiWu)){
			amountDsamount = amountDsamount.multiply(basePrice);
		}
		// 在还有课赠送金额的  实物折扣中 计算 最大最小 折扣额
//		if(DiscountTypeEnum.ShiWu.equals(discountType) && disAmountEnable && canUseDisAmount.compareTo(new BigDecimal("0")) > 0){
//			BigDecimal tQty = canUseDisAmount.divide(tPrice,0,BigDecimal.ROUND_DOWN);
////			disAmountMin = tQty.multiply(tPrice);
////			disAmountMax = tQty.add(new BigDecimal("1")).multiply(tPrice);
//		}else{
////			disAmountMin = canUseDisAmount.multiply(new BigDecimal("1"));
////			disAmountMax = canUseDisAmount.multiply(new BigDecimal("1"));
//		}
		// 如果 三个全不需要校验 ，直接返回 resultInfo.success 为false
		if(!saleQtyLimitEnable && !saleAmountLimitEnable && !disAmountEnable){
			resultInfo.setSuccess(false);
			return resultInfo;
		}
		// 如果三个全需要校验，则比较一下 返回 金额最小的一个
		else if(saleQtyLimitEnable && saleAmountLimitEnable && disAmountEnable){
			if(qtyDsamount.compareTo(amountDsamount) >= 0){
				enableLimit = "amount";
				limit = canUseSaleAmount;
				
				if(amountDsamount.compareTo(canUseDisAmount) > 0){
					enableLimit = "disamount";
					limit = canUseDisAmount;
				}
				
			}else{
				enableLimit = "qty";
				limit = canUseSaleQty;
				
				if(qtyDsamount.compareTo(canUseDisAmount) > 0){
					enableLimit = "disamount";
					limit = canUseDisAmount;
				}
			}
		}
		// 只有一个是 启用时  则只返回  那一个 
		else if(saleQtyLimitEnable && !saleAmountLimitEnable && !disAmountEnable){
			enableLimit = "qty";
			limit = canUseSaleQty;
		}else if(!saleQtyLimitEnable && saleAmountLimitEnable && !disAmountEnable){
			enableLimit = "amount";
			limit = canUseSaleAmount;
		}else if(!saleQtyLimitEnable && !saleAmountLimitEnable && disAmountEnable){
			enableLimit = "disamount";
			limit = canUseDisAmount;
		}
		// 有两个 有效的情况下  则 返回 较小的一个
		else if(saleQtyLimitEnable && saleAmountLimitEnable && !disAmountEnable){
			if(qtyDsamount.compareTo(amountDsamount) >= 0){
				enableLimit = "amount";
				limit = canUseSaleAmount;
			}else{
				enableLimit = "qty";
				limit = canUseSaleQty;
			}
		}else if(saleQtyLimitEnable && !saleAmountLimitEnable && disAmountEnable){
			if(qtyDsamount.compareTo(canUseDisAmount) >= 0){
				enableLimit = "disamount";
				limit = canUseDisAmount;
			}else{
				enableLimit = "qty";
				limit = canUseSaleQty;
				
			}
		}else if(!saleQtyLimitEnable && saleAmountLimitEnable && disAmountEnable){
			if(amountDsamount.compareTo(canUseDisAmount) >= 0){
				enableLimit = "disamount";
				limit = canUseDisAmount;
			}else{
				enableLimit = "amount";
				limit = canUseSaleAmount;
			}
		}
		
		resultInfo.setSuccess(true);
		resultInfo.setMessage(enableLimit);
		resultInfo.setReturnObj(limit);
		return resultInfo;
	}
	
	/**
	 * 根据销量 获得 折让金额  用来 
	 * @param ctx
	 * @param dse
	 * @return
	 */
	private BigDecimal getDsamount(Context ctx,BigDecimal saleQtyTon,DiscountTypeEnum discountType,DiscountSetEntryInfo dse){
		
		BigDecimal dsamount = new BigDecimal("0");
		
		if(dse != null){
			BigDecimal qty1 = dse.getQty1();
			qty1 = (qty1 == null ? new BigDecimal("0") : qty1);
			BigDecimal qty2 = dse.getQty2();
			qty2 = (qty2 == null ? new BigDecimal("0") : qty2);
			// qty2不能小于qty1
			if(qty2.compareTo(qty1) <= 0){
				qty2 = new BigDecimal("0");
			}
			BigDecimal standard1 = dse.getStandard1();
			standard1 = (standard1 == null ? new BigDecimal("0") : standard1);
			BigDecimal standard2 = dse.getStandard2();
			standard2 = (standard2 == null ? new BigDecimal("0") : standard2);
			
			
			// 实物折扣数量 和 标准
			BigDecimal swqty1 = dse.getSwQty1();
			swqty1 = (swqty1 == null ? new BigDecimal("0") : swqty1);
			BigDecimal swqty2 = dse.getSwQty2();
			swqty2 = (swqty2 == null ? new BigDecimal("0") : swqty2);
			
			int swStandard1 = dse.getSwStandard1();
			int swStandard2 = dse.getSwStandard2();
			
			
		
		
			
			// 当前折让政策分录计算出的折让数
			BigDecimal discountValue  = new BigDecimal("0");
			
			BigDecimal saleQtyT = saleQtyTon.multiply(new BigDecimal("1"));
			if(saleQtyT.compareTo(qty1) < 0){
				return dsamount;
			}else if (qty2 == null || qty2.compareTo(new BigDecimal("0")) == 0 || saleQtyT.compareTo(qty2) <= 0){
				if(DiscountTypeEnum.SHIWU_VALUE.equals(discountType)){
					// 实物折扣数量1 为0 时折扣数为 0
					if(swqty1 == null || swqty1.equals(new BigDecimal("0"))){
						return dsamount;
					}
					BigDecimal validQtyK = saleQtyT.divide(swqty1,0,RoundingMode.DOWN);
					
					discountValue = validQtyK.multiply(new BigDecimal(swStandard1));
//					BigDecimal discountAmount = discountValue.multiply(basePrice);
					
					
				}else{
					// 按标准一执行  
					BigDecimal validQtyK = saleQtyT;
					
					
					discountValue = validQtyK.multiply(standard1);
					
				}
				
			}else if(saleQtyT.compareTo(qty2) > 0){
				if(DiscountTypeEnum.SHIWU_VALUE.equals(discountType)){
					// 实物折扣数量1 为0 时折扣数为 0
					if(swqty1 == null || swqty1.equals(new BigDecimal("0"))){
						return dsamount;
					}
					//--------------------------------------------------------------------
					// 按标准一执行  一部分 
					
					BigDecimal validQty1K = qty2.divide(swqty1,0,RoundingMode.DOWN);
//					BigDecimal validQty1K = qty2.divide(swqty1,2,RoundingMode.HALF_UP);
					
					BigDecimal discountValue1 = validQty1K.multiply(new BigDecimal(swStandard1));
					
					// ------------------------------------------------------------------
					saleQtyT = saleQtyT.subtract(qty2);
					// 按标准二执行  
					// 实物折扣数量2 为0 时折扣数为 0
					if(swqty2 == null || swqty2.equals(new BigDecimal("0"))){
						
					}else{
						BigDecimal validQty2K = saleQtyT.divide(swqty2,0,RoundingMode.DOWN);
						
						BigDecimal discountValue2 = validQty2K.multiply(new BigDecimal(swStandard2));
						discountValue = discountValue1.add(discountValue2);
					}
				}else{
					//--------------------------------------------------------------------
					// 按标准一执行  一部分
					BigDecimal validQty1K = qty2;
					
					BigDecimal discountValue1 = validQty1K.multiply(standard1);
					
					// ------------------------------------------------------------------
					saleQtyT = saleQtyT.subtract(qty2);
					// 按标准二执行  
					BigDecimal validQty2K = saleQtyT;
					
					BigDecimal discountValue2 = validQty2K.multiply(standard2);
					discountValue = discountValue1.add(discountValue2);
				}
			}
			// 折让金额限制
			BigDecimal exeDiscountValue = discountValue.multiply(new BigDecimal("1"));
			dsamount = exeDiscountValue;
		}
		return dsamount;
	}
	
	/**
	 * 获得指定折让政策分录的 折让计算 日志中的 合计
	 * @param ctx
	 * @param discountSetID
	 * @param CFIsLimitMerge
	 * @param entrySetEntryInfo
	 * @param dsGridLogs
	 * @return 
	 * 一、返回null时  不限制；
	 * 二、否则返回的map中包含("enabled", Boolean.FALSE),则政策已经不符合条件，不进行折让计算
	 * 三、根据折让政策设置中 条件 ① 如果  销量限制为0；在返回中包含("saleQtyLimitEnable", Boolean.FALSE)否则设置为("saleQtyLimitEnable", Boolean.TRUE)
	 * 								计算出当前可用的数量("canUseSaleQty",canUseSaleQty )，返回实际可用数量，如果数量小于等于0则当前折让政策已经不满足条件，不在计算
	 * 
	 * 							②销售额限制为0；在返回中包含("saleAmountLimitEnable", Boolean.FALSE)否则设置为("saleAmountLimitEnable", Boolean.TRUE)
	 * 								计算出当前可用的数量("canUseSaleAmount",canUseSaleAmount )，返回实际可用销售额，如果可用销售额小于等于0则当前折让政策已经不满足条件，不在计算
	 * 							③折让金额限制为0；怎返回中包含("disAmountEnable", Boolean.FALSE)否则设置为("disAmountEnable", Boolean.TRUE)
	 * 								计算出当前可用的折让金额("canUseDisAmount",canUseDisAmount )，返回实际可用折让金额，如果可用折让金额小于等于0则当前折让政策已经不满足条件，不在计算
	 * 			
	 * @throws BOSException 
	 */
	private Map<String,Object> getEnabledValues(Context ctx,
			String discountSetID,
			String customerID,
			boolean CFIsLimitMerge,
			Map<String,Object> entrySetEntryInfo,
			List dsGridLogs,
			int seq,
			String saleOrderID,
			String valieOrderEntryIDs,
			boolean isReturns) throws BOSException{
		Map<String,Object> enabledValues = new HashMap<String,Object>();
		if(entrySetEntryInfo == null || entrySetEntryInfo.size() == 0){
			return null;
		}
		// 是否启用销售量限制
		Boolean saleQtyLimitEnable = false;
		// 是否启用销售金额限制
		Boolean saleAmountLimitEnable = false;
		// 是否启用销售折让额限制
		Boolean disAmountEnable = false;
		String entryID = (String) entrySetEntryInfo.get("dssetEntryID");
		// 总销量限制
		BigDecimal CFQtyLimit = (BigDecimal) entrySetEntryInfo.get("CFQtyLimit");
		CFQtyLimit = (CFQtyLimit == null ? new BigDecimal("0") : CFQtyLimit);
		// 销售量 校验
		if(CFQtyLimit.compareTo(new BigDecimal("0")) == 0   || isReturns){
			// 不启用销售量限制
			enabledValues.put("saleQtyLimitEnable", Boolean.FALSE);
		}else{
			// 启用销售量限制
			enabledValues.put("saleQtyLimitEnable", Boolean.TRUE);
			saleQtyLimitEnable = Boolean.TRUE;
		}
		// 销售总额限制
		BigDecimal CFSaleAmountLimit = (BigDecimal) entrySetEntryInfo.get("CFSaleAmountLimit");
		CFSaleAmountLimit = (CFSaleAmountLimit == null ? new BigDecimal("0") : CFSaleAmountLimit);
		// 销售额 校验
		if(CFSaleAmountLimit.compareTo(new BigDecimal("0")) == 0 || isReturns){
			// 不启用销售额限制
			enabledValues.put("saleAmountLimitEnable", Boolean.FALSE);
		
		}else{
			// 启用销售额限制
			enabledValues.put("saleAmountLimitEnable", Boolean.TRUE);
			saleAmountLimitEnable = Boolean.TRUE;
		}
			
		// 折扣总额限制
		BigDecimal CFSdLimit = (BigDecimal) entrySetEntryInfo.get("CFSdLimit");
		CFSdLimit = (CFSdLimit == null ? new BigDecimal("0") : CFSdLimit);
		// 销售折让金额 校验
		if(CFSdLimit.compareTo(new BigDecimal("0")) == 0 || isReturns){
			// 不启用销售折让金额限制
			enabledValues.put("disAmountEnable", Boolean.FALSE);
		}else{
			// 启用销售折让金额限制
			enabledValues.put("disAmountEnable", Boolean.TRUE);
			disAmountEnable = Boolean.TRUE;
		}
		
		if(StringUtils.isBlank(entryID)) return null;
		// 如果 限制都为空 或者都为 0 则返回null
		if(CFQtyLimit.equals(new BigDecimal("0")) &&
				CFSdLimit.equals(new BigDecimal("0")) && 
				CFSaleAmountLimit.equals(new BigDecimal("0"))){
			return null;
		}
		// 获得内存中保存的日志 中已使用的 折扣数量  金额
		Map everGridLogs = this.getUnsaveDSGridLogSum(ctx, dsGridLogs, customerID, discountSetID, CFIsLimitMerge, entryID, seq);
		if(everGridLogs != null && everGridLogs.size() > 0){
			BigDecimal saleQtySum = (BigDecimal) everGridLogs.get("saleQtySum");
			BigDecimal saleAmountSum = (BigDecimal) everGridLogs.get("saleAmountSum");
			BigDecimal saleDiscountSum = (BigDecimal) everGridLogs.get("saleDiscountSum");
			
			// 对三个已用的金额数量 与 限制数比较，超过则 直接返回 ("enabled", Boolean.FALSE),否则 在 总可用量中减掉 已分配量
			// 销售量校验
			if(saleQtyLimitEnable && saleQtySum != null && saleQtySum.compareTo(new BigDecimal("0") ) > 0 ){
				if(saleQtySum.compareTo(CFQtyLimit) >= 0){
					enabledValues.put("enabled", Boolean.FALSE);
					return enabledValues;
				}else{
					CFQtyLimit = CFQtyLimit.subtract(saleQtySum);
				}
			}
			// 销售金额
			if(saleAmountLimitEnable && saleAmountSum != null && saleAmountSum.compareTo(new BigDecimal("0") ) > 0 ){
				if(saleAmountSum.compareTo(CFSaleAmountLimit) >= 0){
					enabledValues.put("enabled", Boolean.FALSE);
					return enabledValues;
				}else{
					CFSaleAmountLimit = CFSaleAmountLimit.subtract(saleAmountSum);
				}
			}
			
			// 折扣金额 校验
			if(disAmountEnable && saleDiscountSum != null && saleDiscountSum.compareTo(new BigDecimal("0") ) > 0 ){
				if(saleDiscountSum.compareTo(CFSdLimit) >= 0){
					enabledValues.put("enabled", Boolean.FALSE);
					return enabledValues;
				}else{
					CFSdLimit = CFSdLimit.subtract(saleDiscountSum);
				}
			}
		}
		
		
//		String saleOrderID = "";
//		String sqleOrderEntryID = "";
//		if(dsGridLogs != null && dsGridLogs.size() > 0){
//			// 取第一个日志信息，如果存在则设置订单id和分录id
//			DiscountGridLogEntryInfo dgLogEntryInfo = (DiscountGridLogEntryInfo) dsGridLogs.get(0);
//			saleOrderId = dgLogEntryInfo.getOrderID();
//			sqleOrderEntryID = dgLogEntryInfo.getOrderEntryID();
//			
//		}
		
		
		// 计算对应 折让政策分录是否已经 达到上限，未达到的话 继续与保存的 折让日志 比对 。
		
		// 获取已经计算的数量，折算当前可用数量
		String searchSql = "select sum(te.CFOrderQtyT) orderQtyT,sum(te.CFDsAmount) dsAmount,sum(te.CFDsQuantityKg) dsQuantityKg, sum(te.CFOrderEntryAmount) orderEntryAmount from CT_NDI_DiscountGridLogEntry te inner join CT_NDI_DiscountGridLog t on te.fparentid = t.fid where 1=1 ";
		if(StringUtils.isNotBlank(valieOrderEntryIDs) && valieOrderEntryIDs.length() > 10){
			searchSql = searchSql + " and te.CFOrderEntryID in (" + valieOrderEntryIDs + ")";
			
		}
		IRowSet rs = null;
		if(CFIsLimitMerge){
			
			if(StringUtils.isBlank(saleOrderID)){
				searchSql = searchSql + " and te.CFDiscountSetID =? and t.cfcustomerid=?";
				String[] args  = {discountSetID,customerID};
				rs = DbUtil.executeQuery(ctx, searchSql,args);
			}else{
				searchSql = searchSql + "  and te.CFDiscountSetID =? and t.cfcustomerid=? and (t.CFSaleOrderID != ? or t.CFSaleOrderID is null)";
				String[] args  = {discountSetID,customerID,saleOrderID};
				rs = DbUtil.executeQuery(ctx, searchSql,args);
			}
		}else{
			if(StringUtils.isNotBlank(saleOrderID)){
				searchSql = searchSql + "  and CFDiscountSetEntryID =? and (t.CFSaleOrderID != ? or t.CFSaleOrderID is null)";
				String[] args  = {entryID,saleOrderID};
				rs = DbUtil.executeQuery(ctx, searchSql,args);
			}else{
				searchSql = searchSql + " and  CFDiscountSetEntryID =?";
				String[] args  = {entryID};
				rs = DbUtil.executeQuery(ctx, searchSql,args);
			}
		}
		
		
		try{
			
			if(rs.next()){
				// 获得已计算折让 数量 金额
				BigDecimal orderQtyT = rs.getBigDecimal("orderQtyT");
				orderQtyT = (orderQtyT == null ? new BigDecimal("0") : orderQtyT);
				BigDecimal orderEntryAmount = rs.getBigDecimal("orderEntryAmount");
				orderEntryAmount = (orderEntryAmount == null ? new BigDecimal("0") : orderEntryAmount);
				BigDecimal dsAmount = rs.getBigDecimal("dsAmount");
				dsAmount = (dsAmount == null ? new BigDecimal("0") : dsAmount);
//				BigDecimal dsQuantityKg = rs.getBigDecimal("dsQuantityKg");
				
				// 获得内存中已计算的 数量 金额 
				
				// 销售量校验
				if(saleQtyLimitEnable && orderQtyT.compareTo(CFQtyLimit) >= 0){
					enabledValues.put("enabled", Boolean.FALSE);
					return enabledValues;
				}else if(saleQtyLimitEnable){
					CFQtyLimit = CFQtyLimit.subtract(orderQtyT);
				}
				
				// 销售额校验
				if(saleAmountLimitEnable && orderEntryAmount.compareTo(CFSaleAmountLimit) >= 0){
					enabledValues.put("enabled", Boolean.FALSE);
					return enabledValues;
				}else if(saleAmountLimitEnable){
					CFSaleAmountLimit = CFSaleAmountLimit.subtract(orderEntryAmount);
				}
				// 折扣金额 校验
				if(disAmountEnable && dsAmount.compareTo(CFSdLimit) >= 0){
					enabledValues.put("enabled", Boolean.FALSE);
					return enabledValues;
				}else if(disAmountEnable){
					CFSdLimit = CFSdLimit.subtract(dsAmount);
				}
				
				
			}
			// 保存可用金额
			enabledValues.put("enabled", Boolean.TRUE);
			enabledValues.put("canUseSaleQty",CFQtyLimit );
			enabledValues.put("canUseSaleAmount",CFSaleAmountLimit );
			enabledValues.put("canUseDisAmount",CFSdLimit );
			return enabledValues;
		}catch(SQLException sqle){
			throw new BOSException("查询政策分录 日志历史记录时出错", sqle);
		}
		
		
	}
	/**
	 * 根据内存中保存的折让记录日志计算已经 合计了多少折让
	 * @param ctx
	 * @param dsGridLogs
	 * @return
	 */
	private Map<String,Object> getUnsaveDSGridLogSum(Context ctx,
			List dsGridLogs,
			String customerID,
			String dssetbillID,
			boolean CFIsLimitMerge,
			String dssetEntryID,
			int seq){
		Map<String,Object> logSumMap = new HashMap<String, Object>();
		BigDecimal saleQtySum = new BigDecimal("0");
		BigDecimal saleAmountSum = new BigDecimal("0");
		BigDecimal saleDiscountSum = new BigDecimal("0");
		for(int i = 0; dsGridLogs != null && i < dsGridLogs.size(); i++){
			DiscountGridLogEntryInfo gridLogEntryInfo = (DiscountGridLogEntryInfo) dsGridLogs.get(i);
			// 只累计内存中 非当前订单行分录的日志信息
			if(seq != gridLogEntryInfo.getOrderEntrySeq()){
				if(gridLogEntryInfo != null ){
					// 如果政策 合计计算  同一客户 同一政策内的数量金额 合计计算,否则 只计算当前政策分录的数据
					if(CFIsLimitMerge){
						// 同一个订单内的肯定是同一个客户 所以不用校验 客户
						if(dssetbillID.equals(gridLogEntryInfo.getDiscountSetID())){
							saleQtySum = saleQtySum.add(gridLogEntryInfo.getOrderQtyT());
							saleAmountSum = saleAmountSum.add(gridLogEntryInfo.getOrderEntryAmount());
							saleDiscountSum = saleDiscountSum.add(gridLogEntryInfo.getDsAmount());
						}
					}else{
						// 同一个订单内的肯定是同一个客户 所以不用校验 客户
						if(dssetbillID.equals(gridLogEntryInfo.getDiscountSetID()) && dssetEntryID.equals(gridLogEntryInfo.getDiscountSetEntryID())){
							saleQtySum = saleQtySum.add(gridLogEntryInfo.getOrderQtyT());
							saleAmountSum = saleAmountSum.add(gridLogEntryInfo.getOrderEntryAmount());
							saleDiscountSum = saleDiscountSum.add(gridLogEntryInfo.getDsAmount());
						}
					}
				}
			}
		}
		
			
		logSumMap.put("saleQtySum", saleQtySum);
		logSumMap.put("saleAmountSum", saleAmountSum);
		logSumMap.put("saleDiscountSum", saleDiscountSum);
		return logSumMap;
	}
	/**
	 * 获取符合条件的  折让政策 分录ID
	 * @param ctx
	 * @param saleOrgUnitID
	 * @param customerID
	 * @param materialID
	 * @param noDSQty
	 * @param discountType
	 * @return
	 * @throws BOSException 
	 */
	private List<Map<String,Object>> getDiscountSets(Context ctx, 
			String saleOrgUnitID,
			String customerID,
			String materialID, 
			BigDecimal noDSQty,
			String discountType,
			String bizDate,
			List dsGridLogs) throws BOSException{
		ArrayList<Map<String,Object>> entryIDs = new ArrayList<Map<String,Object>>();
		
		// TODO 根据客户id获得 客户分类范围，（例如客户所属分类长编码为：01!0102!010203,则范围为（'01','01!0102','01!0102!010203'）
		// 客户范围
//		String customerGroupRangeStr = getInRange(this.getCustomerGroupRange(ctx, customerID));
		// 物料范围
//		String materialGroupRangeStr = getInRange(this.getMaterialGroupRange(ctx, materialID));
		
		// 分销折扣时，查询订单客户对应的上级客户的分销折扣政策,没有上级客户 则没有对应政策
//		if(DiscountTypeEnum.FENXIAO_VALUE.equals(discountType)){
//			String parentCustomerId = DiscountFacadeFactory.getLocalInstance(ctx).getParentCustomer(customerID);
//			if(StringUtils.isBlank(parentCustomerId)){
//				return entryIDs;
//			}else{
//				customerID = parentCustomerId;
//			}
//		}
		
		StringBuilder sb = new StringBuilder();
		// 区分客户的
		sb.append("/*dialect*/select te.fid entryID,t.fid billID,t.CFIsLimitMerge,t.fbyMonthQtyLimit,te.CFACCUMULAMATERIAL,t.FAccumulaEnddate,t.FAccumulaBeginDate,");
		sb.append(" te.CFQtyLimit,te.CFSdLimit,te.CFSaleAmountLimit ");
		
		sb.append(" from CT_NDI_DiscountSetEntry te inner join CT_NDI_DiscountSet t on te.FParentID = t.fid ");
		sb.append(" where t.FBlockedStatus = 1 and ( t.cfisallcustomer = 0 or  t.cfisallcustomer is null ) and t.FCheckedStatus = 2 and te.CFLockedState=1 and t.CFDiscountType='");
		sb.append(discountType);
		sb.append("' and t.FEffectiveDate <= to_date('");
		sb.append(bizDate);
		sb.append(" 23:59:59','yyyy-mm-dd hh24:mi:ss')  and t.FExpireDate>= to_date('");
		sb.append(bizDate);
		sb.append("','yyyy-mm-dd') ");
		sb.append(" and te.fmaterialid='");
		sb.append(materialID);
		sb.append("' and  te.FCustomerID = '");
		sb.append(customerID);
		sb.append("' ");
		// add 组织隔离
		sb.append(" and t.fsaleorgunitid = '");
		sb.append(saleOrgUnitID);
		sb.append("' ");
		
		
		// 不区分客户的
		sb.append(" union all select te.fid entryID,t.fid billID,t.CFIsLimitMerge,t.fbyMonthQtyLimit,te.CFACCUMULAMATERIAL,t.FAccumulaEnddate,t.FAccumulaBeginDate,");
		sb.append(" te.CFQtyLimit,te.CFSdLimit,te.CFSaleAmountLimit ");
		
		sb.append(" from CT_NDI_DiscountSetEntry te inner join CT_NDI_DiscountSet t on te.FParentID = t.fid ");
		sb.append(" where t.FBlockedStatus = 1  and t.FCheckedStatus = 2 and te.CFLockedState=1 and t.CFDiscountType='");
		sb.append(discountType);
		sb.append("' and t.FEffectiveDate <= to_date('");
		sb.append(bizDate);
		sb.append(" 23:59:59','yyyy-mm-dd hh24:mi:ss')  and t.FExpireDate>= to_date('");
		sb.append(bizDate);
		sb.append("','yyyy-mm-dd') ");
		sb.append(" and te.fmaterialid='");
		sb.append(materialID);
		sb.append("' and  t.cfisallcustomer = 1 ");
		
		// add 组织隔离
		sb.append(" and t.fsaleorgunitid = '");
		sb.append(saleOrgUnitID);
		sb.append("' ");
//		sb.append(" and (te.fmaterialid='");
//		sb.append(materialID);
//		sb.append("' or te.FMaterialGroupID in ");
//		sb.append(materialGroupRangeStr);
//		sb.append(") and (te.FCustomerGroupID in ");
//		sb.append(customerGroupRangeStr);
//		sb.append(" or te.FCustomerID = '");
//		sb.append(customerID);
//		sb.append("') ");
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			while (rs.next()){
				String entryID = rs.getString("entryID");
				String billID = rs.getString("billID");
				// 如果分录设置了校验数量，那么判断一下 折让日志中该政策是否满足 限制条件
				BigDecimal CFQtyLimit = rs.getBigDecimal("CFQtyLimit");
				BigDecimal CFSdLimit = rs.getBigDecimal("CFSdLimit");
				boolean CFIsLimitMerge = rs.getBoolean("CFIsLimitMerge");
				BigDecimal CFSaleAmountLimit = rs.getBigDecimal("CFSaleAmountLimit");
				boolean FByMonthQtyLimit = rs.getBoolean("FByMonthQtyLimit");
				String FACCUMULAMATERIALG = rs.getString("CFACCUMULAMATERIAL");
				Date FAccumulaBeginDate = rs.getDate("FAccumulaBeginDate");
				Date FAccumulaEnddate = rs.getDate("FAccumulaEnddate");
				
				Map<String, Object> entrydssetMap = new HashMap<String, Object>();
				entrydssetMap.put("billID", billID);
				entrydssetMap.put("FByMonthQtyLimit", Boolean.valueOf(FByMonthQtyLimit));
				entrydssetMap.put("CFIsLimitMerge", Boolean.valueOf(CFIsLimitMerge));
				entrydssetMap.put("dssetEntryID", entryID);
				entrydssetMap.put("dssetEntryID", entryID);
				entrydssetMap.put("CFQtyLimit", CFQtyLimit);
				entrydssetMap.put("CFSdLimit", CFSdLimit);
				// 是否累计销量
				entrydssetMap.put("CFSaleAmountLimit", CFSaleAmountLimit);
				// 累计销量的物料分类
				entrydssetMap.put("CFACCUMULAMATERIAL", FACCUMULAMATERIALG);
				// 累计开始时间
				entrydssetMap.put("FAccumulaBeginDate", FAccumulaBeginDate);
				// 累计结束时间
				entrydssetMap.put("FAccumulaEnddate", FAccumulaEnddate);
				
				entryIDs.add(entrydssetMap);
			}
			
			return entryIDs;
		}catch(Exception e){
			throw new BOSException("查询符合条件的折让政策报错",e);
		}
	}
	/**
	 * 
	 * @param range
	 * @return
	 */
	private String getInRange(HashSet<String> range){
		if(range == null || range.size() == 0){
			return "()";
		}
		
		StringBuilder result = new StringBuilder("(");
		String[] rangeStrs = new String[range.size()];
		rangeStrs = range.toArray(rangeStrs);
		for(int i =0; i < rangeStrs.length; i++){
			
			result.append("'");
			result.append(rangeStrs[i]);
			result.append("',");
			
		}
		
		String resultStr = result.toString();
		resultStr= resultStr.substring(0, resultStr.length() );
		resultStr = resultStr+")";
			
		return resultStr;
	}
	/**
	 * 根据物料id获得 物料分类范围，
	 * （例如物料所属分类长编码为：01!0102!010203,则范围为（'01','0102','010203'）
	 * @param ctx
	 * @param materialID
	 * @return
	 * @throws BOSException 
	 */
	private HashSet<String> getMaterialGroupRange(Context ctx,String materialID) throws BOSException{
		HashSet<String> groupRange = new HashSet<String>();
		String str = "select t.flongnumber from T_BD_MaterialGroup t inner join  t_bd_material tc on tc.FMaterialGroupID = t.fid where tc.fid=?";
		String[] args = {materialID};
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, str,args);
			while(rs.next()){
				String longNumber = rs.getString("flongnumber");
				String[] ancestorNumbers = longNumber.split("!");
				for(int i = 0; i < ancestorNumbers.length; i++){
					groupRange.add(ancestorNumbers[i]);
				}
			}
		}catch (Exception e){
			throw new BOSException("获取物料编码范围时出错",e);
		}
		
		return groupRange;
	}
	
	/**
	 * 根据客户id获得 客户分类范围，
	 * （例如客户所属分类长编码为：01!0102!010203,则范围为（'01','0102','010203'）
	 * @param ctx
	 * @param customerID
	 * @return
	 * @throws BOSException 
	 */
	private HashSet<String> getCustomerGroupRange(Context ctx,String customerID) throws BOSException{
		HashSet<String> groupRange = new HashSet<String>();
		String str = "select t.flongnumber from T_BD_CSSPGroup t inner join  t_bd_customer tc on tc.FBrowseGroupID = t.fid where tc.fid=?";
		String[] args = {customerID};
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, str,args);
			while(rs.next()){
				String longNumber = rs.getString("flongnumber");
				String[] ancestorNumbers = longNumber.split("!");
				for(int i = 0; i < ancestorNumbers.length; i++){
					groupRange.add(ancestorNumbers[i]);
				}
			}
		}catch (Exception e){
			throw new BOSException("获取客户编码范围时出错",e);
		}
		
		return groupRange;
	}
	
	
	
	/**
	 * 根据 公司、客户、物料获得  对应的  价格政策 的价格，如果不存在价格政策，则取 基本价格换算成 物料
	 * 对应销售资料中的 计量单位的价格 返回
	 */
	@Override
	protected BigDecimal _getMaterialPolicyPrice(Context ctx,
			String companyID,
			String customerID,
			String materialID,
			String bizDate,
			BigDecimal orderQty,
			String unitID) throws BOSException {
		try{
			MeasureUnitInfo unitInfo = MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(new ObjectUuidPK(unitID));
			BigDecimal unitrate = unitInfo.getCoefficient();
			// 首先从 公司物料 中取得 物料的  销售单位
			MaterialSalesInfo msData = this.getMaterialSaleinfo(ctx,materialID, companyID);
			
			
			
			if(msData != null){
//				
				
				PriceCondition priceCondition = getPriceCondition(ctx, companyID, customerID, materialID, unitInfo,bizDate,orderQty);
				IPriceProvider iPriceProvider = PriceProviderFactory.getLocalInstance(ctx);
//				List priceList = iPriceProvider.fetchPrices(priceCondition);
				
				PriceCondition[] priceConditionArray = new PriceCondition[1];
				priceConditionArray[0] = priceCondition;
				List[] salePrices = iPriceProvider.getPrices(priceConditionArray);
				// 取第一个销售单价
				if(salePrices != null && salePrices.length > 0 && salePrices[0]!= null){
					List<SalePriceTO> salePrice0 = salePrices[0];
					if(salePrice0 != null){
						for(int i = 0; i < salePrice0.size(); i++){
							SalePriceTO salePriceTo = (SalePriceTO)salePrice0.get(0);
							if(salePriceTo != null && salePriceTo.price != null){
								return salePriceTo.price;
							}
						}
					}
				
				}else {
					// 取物料销售资料的单位价格 然后换算
					MeasureUnitInfo saleUnitInfo = msData.getUnit();
					saleUnitInfo = MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(new ObjectUuidPK(saleUnitInfo.getId()));
					
					priceCondition = getPriceCondition(ctx, companyID, customerID, materialID, saleUnitInfo,bizDate,orderQty);
					iPriceProvider = PriceProviderFactory.getLocalInstance(ctx);
					List priceList = iPriceProvider.fetchPrices(priceCondition);
					// 价格政策 存在则直接返回
					if(priceList != null && priceList.size() > 0 && priceList.get(0) != null){
						SalePriceTO basePriceTO = (SalePriceTO)priceList.get(0);
						if(basePriceTO != null){
							BigDecimal salePrice =  basePriceTO.price;
							BigDecimal salerate = saleUnitInfo.getCoefficient();
							
							
							
							return unitrate.multiply(salePrice).divide(salerate,6,BigDecimal.ROUND_HALF_UP);
							
						}
					}else{
					
						// 如果指定计量单位不存在 则查询 千克的 单价设置，然后换算成 计量单位的 单价 WZw+TdalSm2M+YYqGxdjM1uCXFc=
						// gw5fUwEOEADgAAsRwKgSOFuCXFc=
						MeasureUnitInfo baseUnitInfo = MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(new ObjectUuidPK("gw5fUwEOEADgAAsRwKgSOFuCXFc="));
						priceCondition = getPriceCondition(ctx, companyID, customerID, materialID, baseUnitInfo,bizDate,orderQty);
						iPriceProvider = PriceProviderFactory.getLocalInstance(ctx);
						priceList = iPriceProvider.fetchPrices(priceCondition);
						// 价格政策 存在则直接返回
						if(priceList != null && priceList.size() > 0){
							SalePriceTO basePriceTO = (SalePriceTO)priceList.get(0);
							if(basePriceTO != null){
								
								return basePriceTO.price.multiply(unitrate);
							}
						}
					}
				
					// 根据基本价格换算
					BigDecimal unitPrice = this._getMaterialBasePrice(ctx, companyID, materialID,unitInfo.getId().toString());
					if(unitPrice != null){
						return unitPrice;
					}else{
						BigDecimal baseUnitPrice = this._getMaterialBasePrice(ctx, companyID, materialID,"WZw+TdalSm2M+YYqGxdjM1uCXFc=");
						if(baseUnitPrice != null){
							BigDecimal rate = unitInfo.getCoefficient();
							
							saleUnitInfo = msData.getUnit();
							saleUnitInfo = MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(new ObjectUuidPK(saleUnitInfo.getId()));
							
							return baseUnitPrice.multiply(rate);
						}else{
							// 如果没有基本计量单位的价格  那么 获取 基本价格中的第一个价格  进行换算取得价格
							MaterialBasePriceInfo mbpInfo = this.getMaterialFirstBasePrice(ctx, companyID, materialID);
							
							if(mbpInfo != null && mbpInfo.getUnit() != null && mbpInfo.getUnit().getCoefficient() != null){
								BigDecimal coefficient = mbpInfo.getUnit().getCoefficient();
								BigDecimal price = mbpInfo.getPrice();
								
								if(price != null){
									return price.multiply(unitInfo.getCoefficient()).divide(coefficient,6,BigDecimal.ROUND_HALF_UP);
								}
							}
						}
					}
				}
				
			}
		
		}catch(EASBizException bizE){
			throw new BOSException("获取物料政策价格时出错",bizE);
		}
		return super._getMaterialPolicyPrice(ctx, companyID,customerID, materialID,bizDate,orderQty,unitID);
	}
	/**
	 * 获得 价格政策 
	 * @param ctx
	 * @param companyID
	 * @param customerID
	 * @param materialID
	 * @return
	 */
	private PriceCondition getPriceCondition(Context ctx,
			String companyID,
			String customerID,
			String materialID,
			MeasureUnitInfo unitInfo,
			String bizDate,
			BigDecimal orderQty){
		
		MeasureUnitInfo measureUnitInfo = unitInfo;

		 
	    PriceCondition priceCondition = new PriceCondition();
	    MaterialInfo materialInfo = new MaterialInfo();
	    materialInfo.setId(BOSUuid.read(materialID));
	    priceCondition.setMaterialInfo(materialInfo);
	    CustomerInfo customerInfo = new CustomerInfo();
	    customerInfo.setId(BOSUuid.read(customerID));
	    priceCondition.setCustomerInfo(customerInfo);
	    priceCondition.setOrderQty(orderQty);
	    priceCondition.setCurDate(getDate(companyID,bizDate));
	    if (measureUnitInfo != null) {
	      priceCondition.setMeasureUnit(measureUnitInfo.getId().toString());
	    }
	    CurrencyInfo currencyInfo = new CurrencyInfo();
	    currencyInfo.setId(BOSUuid.read("dfd38d11-00fd-1000-e000-1ebdc0a8100dDEB58FDC"));
	    priceCondition.setCurrencyInfo(currencyInfo);




	 
//	    if (getMainBizOrgType().equals(OrgType.Sale)) {
	    SaleOrgUnitInfo saleOrgUnitInfo = new SaleOrgUnitInfo();
	    saleOrgUnitInfo.setId(BOSUuid.read(companyID));
	    priceCondition.setSaleOrg(saleOrgUnitInfo);
//	    }
	 
	    priceCondition.setAssiProperty(null);




	 
	    priceCondition.setFetchMode(1);
	 
	    return priceCondition;
		
	}
	/**
	 * 获取价格政策日期
	 * @param companyID
	 * @return
	 */
	 private Date getDate(String companyID, String bizDate)
	   {
	     Date result = null;
	     Date curDate = Calendar.getInstance().getTime();
	     try {
	       curDate = SCMBillCommonFacadeFactory.getRemoteInstance().getServerDate();

	 
	       ObjectUuidPK pk = new ObjectUuidPK(companyID);
	       String isUseSysDate = ParamControlFactory.getRemoteInstance().getParamValue(pk, "PricePa022");
	 
	       boolean isGetPriceBySysDate = Boolean.valueOf(isUseSysDate).booleanValue();
	 
	       if (isGetPriceBySysDate)
	         result = curDate;
	       else{
	    	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    	   result = sdf.parse(bizDate);
	       }
	    	   
	     } catch (Exception e) {
	       result = curDate;

	     }
	 
	     if (result == null)
	       result = curDate;
	     return result;
	   }
	/**
	 * 根据管理单元ID\ 物料ID获得  基本价格
	 */
	@Override
	protected BigDecimal _getMaterialBasePrice(Context ctx, String CUid, String materialID,String unitID) throws BOSException {
		String sql = "select fprice from T_SD_MaterialBasePrice where FCheckedStatus = '2' and FBlockedStatus = '1' and FAdminCUID=? and FMaterialID=? and FUnitID=? ";
		Object[] args = {CUid,materialID,unitID};
		IRowSet rs = DbUtil.executeQuery(ctx, sql,args);
		try{
			if(rs.next()){
				BigDecimal price = rs.getBigDecimal("fprice");
				return price;
			}
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		}
		// 没有结果返回null
		return super._getMaterialBasePrice(ctx, CUid, materialID,unitID);
	}
	/**
	 * 获取指定物料在指定公司 能获取到的第一条 基本价格的数据
	 * @param ctx
	 * @param CUid
	 * @param materialID
	 * @return
	 * @throws BOSException 
	 */
	private MaterialBasePriceInfo getMaterialFirstBasePrice(Context ctx, String CUid, String materialID) throws BOSException{
		MaterialBasePriceInfo mbpInfo = new MaterialBasePriceInfo();
		String sql = "select t.fprice,t.funitid,tu.FCoefficient from T_SD_MaterialBasePrice t inner join T_BD_MeasureUnit tu on t.funitid = tu.fid  where t.FCheckedStatus = '2' and t.FBlockedStatus = '1' and t.FAdminCUID=? and t.FMaterialID=?  ";
		Object[] args = {CUid,materialID};
		IRowSet rs = DbUtil.executeQuery(ctx, sql,args);
		try{
			if(rs.next()){
				BigDecimal price = rs.getBigDecimal("fprice");
				BigDecimal coefficient = rs.getBigDecimal("FCoefficient");
				String unitid = rs.getString("funitid");
				
				MeasureUnitInfo muInfo = new MeasureUnitInfo();
				muInfo.setId(BOSUuid.read(unitid));
				muInfo.setCoefficient(coefficient);
				mbpInfo.setUnit(muInfo);
				mbpInfo.setPrice(price);
				return mbpInfo;
			}
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		}
		// 没有结果返回null
		return mbpInfo;
	}
	/**
	 * 判断制定公司(财务组织) 是否启用了 折让处理
	 */ 
	protected boolean _isCompanyDSEnable(Context ctx, String companyID,String discountType) throws BOSException {
		String sql = "select CFEnableLZdiscount,CFEnableSWDiscount,CFEnableMonthDiscount,CFEnableYearDiscount,CFEnableFXDiscount from CT_NDI_DiscountCompany where CFCompanyID =?";
		String[] args = {companyID};
		IRowSet  rs = DbUtil.executeQuery(ctx, sql, args);
		try{
			if(rs.next()){
				boolean lz = rs.getBoolean("CFEnableLZdiscount");
				boolean sw = rs.getBoolean("CFEnableSWDiscount");
				boolean month = rs.getBoolean("CFEnableMonthDiscount");
				boolean year = rs.getBoolean("CFEnableYearDiscount");
				boolean fx = rs.getBoolean("CFEnableFXDiscount");
				
				DiscountTypeEnum typeEnum = DiscountTypeEnum.getEnum(discountType);
				if(typeEnum != null){
					if(typeEnum.equals(DiscountTypeEnum.LiZhe)){
						return lz;
					}else if(typeEnum.equals(DiscountTypeEnum.ShiWu)){
						return sw;
					}else if(typeEnum.equals(DiscountTypeEnum.YueZhe)){
						return month;
					}
					else if(typeEnum.equals(DiscountTypeEnum.NianZhe)){
						return year;
					}
					else if(typeEnum.equals(DiscountTypeEnum.FenXiao)){
						return fx;
					}
				}
			}
		}catch(SQLException sqle){
			throw new BOSException(sqle);
		}
		// 默认返回false
		return false;
	}
	/**
	 * 更新分录状态
	 */
	protected void _updateDSEntryState(Context ctx, List entryIDs,
			String entryState) throws BOSException {
		if(entryIDs != null && entryIDs.size() > 0){
			StringBuffer sb = new StringBuffer("(");
			for(int i = 0; i < entryIDs.size(); i++){
				sb.append("'").append(entryIDs.get(i)).append("',");
			}
			String ids = sb.substring(0, sb.length()-1);
			ids = ids + ")";
			
			String upSql = "update CT_NDI_DiscountSetEntry set CFLockedState = '"+entryState+"' where fid in " + ids;
			DbUtil.execute(ctx, upSql);
		}
	}
	/**
	 * 查询对应的销售组织是否 启用销售折让模块 
	 */
	protected boolean _isEnableDiscount(Context ctx, String saleOrgUnitID)
			throws BOSException {
		ObjectUuidPK orgPk = new ObjectUuidPK(saleOrgUnitID);
		//参数控制 是否启用销售折让模块
		String value = "" ;
		try {
			value = ParamManager.getParamValue(ctx, orgPk, "SALEDIS001");///* 上下文信息，客户端调用可以为null */
		
			if(value != null && value.equals("true")){
				return true;
			}else{
				return false;
			}
		} catch (EASBizException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	/**
	 * 查询对应的公司是否进行 客户余额校验
	 */
	@Override
	protected boolean _isCheckCustomerBalance(Context ctx, String companyID)
			throws BOSException {
		ObjectUuidPK orgPk = new ObjectUuidPK(companyID);
		//参数控制 是否进行 客户余额校验
		String value = "" ;
		try {
			value = ParamManager.getParamValue(ctx, orgPk, "Custom008");///* 上下文信息，客户端调用可以为null */
		
			if(value != null && value.equals("true")){
				return true;
			}else{
				return false;
			}
		} catch (EASBizException e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 查询对应的公司是否进行物料库存校验
	 */
	@Override
	protected boolean _isCheckMaterialInventory(Context ctx, String companyID)
			throws BOSException {
		ObjectUuidPK orgPk = new ObjectUuidPK(companyID);
		//参数控制 是否进行 客户余额校验
		String value = "" ;
		try {
			value = ParamManager.getParamValue(ctx, orgPk, "Custom007");///* 上下文信息，客户端调用可以为null */
		
			if(value != null && value.equals("true")){
				return true;
			}else{
				return false;
			}
		} catch (EASBizException e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 删除对应订单的  折让计算日志
	 */
	@Override
	protected void _removeOrderDsgridLogs(Context ctx, String orderID)
			throws BOSException {
		// 先删除单据体
		String delSql = "delete CT_NDI_DiscountGridLogEntry where CFOrderID =?";
		String[] args = {orderID};
		DbUtil.execute(ctx, delSql, args);
		// 再删除单据头
		delSql = "delete CT_NDI_DiscountGridLog where CFSaleOrderID =?";
		String[] args1 = {orderID};
		DbUtil.execute(ctx, delSql, args1);
		
	}
	/**
	 * 删除 对应订单分录的 销售折让日志
	 */
	@Override
	protected void _removeOrderEntryDsgridLogs(Context ctx,String saleOrderID,
			String validSaleOrderEntryID) throws BOSException {
		// 先删除单据体
		StringBuffer delSql = new StringBuffer("delete CT_NDI_DiscountGridLogEntry where cforderid='");
		delSql.append(saleOrderID);
		delSql.append("' ");
		if(StringUtils.isNotBlank(validSaleOrderEntryID)){
			delSql.append(" and  CFOrderEntryID not in (");
			delSql.append(validSaleOrderEntryID);
			delSql.append(") ");
		}
		
		DbUtil.execute(ctx, delSql.toString());
	}
	/**
	 * 获得指定客户的上级客户ID
	 */
	protected String _getParentCustomer(Context ctx, String customerID)
			throws BOSException {
		String sql = "select CFParentCustomerID from CT_NDI_DiscountCustomerRel where CFCustomerID =?";
		String[] args = {customerID};
		IRowSet rs = DbUtil.executeQuery(ctx, sql, args);
		try{
			if(rs.next()){
				return rs.getString("CFParentCustomerID");
			}
		}catch(SQLException sqle){
			throw new BOSException("查询客户上级客户时出错",sqle);
		}
		return null;
	}
	/**
	 * 获得指定销售订单已经存在折让计算日志表中的日志信息
	 */
	protected List _getOrderDiscountGridLogs(Context ctx, String orderID)
			throws BOSException {
		List logs = new ArrayList();
		String sql = "select te.* from CT_NDI_DiscountGridLog t inner join CT_NDI_DiscountGridLogEntry te on t.fid = te.fparentid where t.CFSaleOrderID=?";
		String[] args = {orderID};
		
		IRowSet rs = DbUtil.executeQuery(ctx, sql,args);
		try{
			if(rs.next()){
				DiscountGridLogEntryInfo logEntryInfo = new DiscountGridLogEntryInfo();
				logEntryInfo.setDiscountSetEntryID(rs.getString("CFDiscountSetEntryID"));
				logEntryInfo.setDiscountSetID(rs.getString("CFDiscountSetID"));
				logEntryInfo.setDiscountType(DiscountTypeEnum.getEnum(rs.getString("CFDiscountType")));
				logEntryInfo.setDsQuantity(rs.getBigDecimal("CFDsQuantity"));
				logEntryInfo.setDsAmount(rs.getBigDecimal("CFDsAmount"));
				logEntryInfo.setFomula(rs.getString("CFFomula"));
				logEntryInfo.setDsQuantityKg(rs.getBigDecimal("CFDsQuantityKg"));
				
				logEntryInfo.setOrderQtyT(rs.getBigDecimal("CFOrderQtyT"));
				logEntryInfo.setOrderEntryQty(rs.getBigDecimal("CFOrderEntryQty"));
				logEntryInfo.setOrderEntryAmount(rs.getBigDecimal("CFOrderEntryAmount"));
				logEntryInfo.setOrderEntryID(rs.getString("CFOrderEntryID"));
				logEntryInfo.setOrderEntrySeq(rs.getInt("CFOrderEntrySeq"));
				
				logs.add(logEntryInfo);
			}
		}catch(SQLException sqle){
			throw new BOSException("查询销售订单已经存在折让计算日志表中的日志信息时报错",sqle);
		}
		
		return logs;
	}
	/**
	 * 校验指定的 折让政策 或者折让政策分录是否 已经使用（产生了折让日志）
	 */
	@Override
	protected boolean _isDiscountUsed(Context ctx, String dsBillID,
			String dsEntryID) throws BOSException {
//		return super._isDiscountUsed(ctx, dsBillID, dsEntryID);
		String id = "";
		if(StringUtils.isNotBlank(dsEntryID)){
			id = dsEntryID;
		}else{
			id = dsBillID;
		}
		String sql = "select fid from CT_NDI_DiscountGridLogEntry where CFDiscountSetID=? or CFDiscountSetEntryID =? ";
		String[] args = {id,id};
		IRowSet rs = DbUtil.executeQuery(ctx, sql,args);
		try{
			if(rs.next()){
				return true;
			}
		}catch(SQLException sqle){
			throw new BOSException(sqle);
		}
		
		return false;
	}
	/**
	 * 获得客户的  折让 记录
	 *  返回的map中包含三种值  
	 *  当前客户 当月总销量 
	 *  当前客户 
	 */
	@Override
	protected Map _getDiscountInfos(Context ctx, String companyID,
			Date beginTime, Date endTime, String discountType,PeriodInfo periodInfo)
			throws BOSException {
		Map<CustomerInfo,CustomerDiscountInfo>  returns = new HashMap<CustomerInfo, CustomerDiscountInfo>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		// 20141022修改  退货申请单的需要减掉
		StringBuilder sb = new StringBuilder();
		
		sb.append("/*dialect*/ select customerID,materialID,max(customerNumber) customerNumber,max(customerName) customerName,");
		sb.append(" max(materialNumber) materialNumber,max(materialName) materialName,");
		sb.append("sum(allQty) allQty,sum(allAmount) allAmount,");
		sb.append(" sum(swDs) swDs, sum(swDSQty) swDSQty, ");
		sb.append(" sum(lzDS) lzDS, sum(lzDSQty) lzDSQty, ");
		sb.append(" sum(monthDS) monthDS, sum(monthDSQty) monthDSQty, ");
		sb.append(" sum(yearDS) yearDS, sum(yearDSQty) yearDSQty, ");
		sb.append(" sum(fxDS) fxDS, sum(fxDSQty) fxDSQty from  ");
		sb.append(" (select tc.fid customerID,max(tc.fnumber) customerNumber, max(tc.fname_l2) customerName, ");
		sb.append(" tm.fid materialID,max(tm.fnumber) materialNumber,max(tm.fname_l2) materialName,");
		sb.append(" sum(te.fbaseqty) allQty, sum(te.famount) allAmount, ");
		sb.append(" sum(te.cfSwDSamount) swDS,sum(decode(te.cfSwDSamount,0,0,te.fbaseqty)) swDSQty,");
		sb.append(" sum(te.cfLzAmount) lzDS,sum(decode(te.cfLzAmount,0,0,te.fbaseqty)) lzDSQty, ");
		sb.append(" sum(te.cfMonthDSAmount) monthDS,sum(decode(te.cfMonthDSAmount,0,0,te.fbaseqty)) monthDSQty,");
		sb.append(" sum(te.cfYearDSAmount) yearDS,sum(decode(te.cfYearDSAmount,0,0,te.fbaseqty)) yearDSQty,");
		sb.append(" sum(te.cfFxDSAmount) fxDS,sum(decode(te.cfFxDSAmount,0,0,te.fbaseqty)) fxDSQty ");
		
		sb.append(" from t_sd_saleorder t inner join t_sd_saleorderentry te on t.fid = te.fparentid ");
		sb.append(" inner join  t_bd_customer tc on t.fordercustomerid = tc.fid ");
		sb.append(" inner join t_bd_material tm on te.fmaterialid = tm.fid ");
//		sb.append(" inner join t_bd_material tm on te.fmaterialid = tm.fid ");
		sb.append(" where (t.fbasestatus=4 or t.fbasestatus = 7)  and t.fsaleorgunitid = '");
		sb.append(companyID);
		sb.append("' and t.fbizdate >= to_date('");
		sb.append(sdf.format(beginTime));
		sb.append("','yyyy-mm-dd') and t.fbizdate <= to_date('");
		sb.append(sdf.format(endTime));
		sb.append("','yyyy-mm-dd') group by tc.fid,tm.fid ");
		
		sb.append(" union all ");
		
		sb.append(" select tc.fid customerID,max(tc.fnumber) customerNumber, max(tc.fname_l2) customerName, ");
		sb.append(" tm.fid materialID,max(tm.fnumber) materialNumber,max(tm.fname_l2) materialName,");
		sb.append(" -sum(te.fbaseqty) allQty, -sum(te.famount) allAmount, ");
		sb.append(" -sum(te.cfSwDSamount) swDS,-sum(decode(te.cfSwDSamount,0,0,te.fbaseqty)) swDSQty,");
		sb.append(" -sum(te.cfLzAmount) lzDS,-sum(decode(te.cfLzAmount,0,0,te.fbaseqty)) lzDSQty, ");
		sb.append(" -sum(te.cfMonthDSAmount) monthDS,-sum(decode(te.cfMonthDSAmount,0,0,te.fbaseqty)) monthDSQty,");
		sb.append(" -sum(te.cfYearDSAmount) yearDS,-sum(decode(te.cfYearDSAmount,0,0,te.fbaseqty)) yearDSQty,");
		sb.append(" -sum(te.cfFxDSAmount) fxDS,-sum(decode(te.cfFxDSAmount,0,0,te.fbaseqty)) fxDSQty ");
		
		sb.append(" from t_sd_salereturns t inner join t_sd_salereturnsentry te on t.fid = te.fparentid ");
		sb.append(" inner join  t_bd_customer tc on t.FReturnsCustomerID = tc.fid ");
		sb.append(" inner join t_bd_material tm on te.fmaterialid = tm.fid ");
//		sb.append(" inner join t_bd_material tm on te.fmaterialid = tm.fid ");
		sb.append(" where (t.fbasestatus=4 or t.fbasestatus = 7)  and t.fsaleorgunitid = '");
		sb.append(companyID);
		sb.append("' and t.fbizdate >= to_date('");
		sb.append(sdf.format(beginTime));
		sb.append("','yyyy-mm-dd') and t.fbizdate <= to_date('");
		sb.append(sdf.format(endTime));
		sb.append("','yyyy-mm-dd') group by tc.fid,tm.fid ) ");
		sb.append(" group by customerID,materialID order by customerID,materialID ");
		//  order by tc.fid,tm.fid 
		
		IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
		try{
			String currCustomerID = "";
			CustomerInfo currCustomerInfo = null; 
			CustomerDiscountInfo currCustomerDSInfo = null;
			while(rs.next()){
				String customerID = rs.getString("customerID");
				String customerNumber = rs.getString("customerNumber");
				String customerName = rs.getString("customerName");
				String materialID = rs.getString("materialID");
				String materialNumber = rs.getString("materialNumber");
				String materialName = rs.getString("materialName");
				// 迭代的客户id不等于当前客户id时，重新 初始一个
				if(!customerID.equals(currCustomerID) ){
					// 先保存历史记录 再重新建新case
					if(StringUtils.isNotBlank(currCustomerID)){
						returns.put(currCustomerInfo, currCustomerDSInfo);
					}
					currCustomerID = customerID;
					currCustomerDSInfo = new CustomerDiscountInfo();
					List<CustomerMaterialDSInfo> materialDSInfos = new ArrayList<CustomerMaterialDSInfo>();
					currCustomerDSInfo.setMaterialDiscountInfos(materialDSInfos);
					currCustomerDSInfo.setAllSaleQty(new BigDecimal("0"));
					currCustomerDSInfo.setDiscountSaleQty(new BigDecimal("0"));
					// 客户
					CustomerInfo customerInfo = new CustomerInfo();
					customerInfo.setId(BOSUuid.read(customerID));
					customerInfo.setNumber(customerNumber);
					customerInfo.setName(customerName);
					currCustomerDSInfo.setCustomerInfo(customerInfo);
					currCustomerInfo = customerInfo;
					
				}
				// 客户物料折让信息
				CustomerMaterialDSInfo cmDSInfo = new CustomerMaterialDSInfo();
				MaterialInfo materialInfo = new MaterialInfo();
				materialInfo.setId(BOSUuid.read(materialID));
				materialInfo.setNumber(materialNumber);
				materialInfo.setName(materialName);
				cmDSInfo.setMaterialInfo(materialInfo);
				cmDSInfo.setCustomerInfo(currCustomerInfo);
				cmDSInfo.setSaleAmount(rs.getBigDecimal("allAmount").divide(new BigDecimal("1"),2,RoundingMode.HALF_UP));
				cmDSInfo.setSaleQty(rs.getBigDecimal("allQty"));
				if(DiscountTypeEnum.YUEZHE_VALUE.equals(discountType)){
					cmDSInfo.setSaleOrderDiscountAmount(rs.getBigDecimal("monthDS"));
					cmDSInfo.setSaleOrderDiscountQty(rs.getBigDecimal("monthDSQty"));
				}else if(DiscountTypeEnum.SHIWU_VALUE.equals(discountType)){
					cmDSInfo.setSaleOrderDiscountAmount(rs.getBigDecimal("swDS"));
					cmDSInfo.setSaleOrderDiscountQty(rs.getBigDecimal("swDSQty"));
					
				}else if(DiscountTypeEnum.LIZHE_VALUE.equals(discountType)){
					cmDSInfo.setSaleOrderDiscountAmount(rs.getBigDecimal("lzDS"));
					cmDSInfo.setSaleOrderDiscountQty(rs.getBigDecimal("lzDSQty"));
				}else if(DiscountTypeEnum.NIANZHE_VALUE.equals(discountType)){
					cmDSInfo.setSaleOrderDiscountAmount(rs.getBigDecimal("yearDS"));
					cmDSInfo.setSaleOrderDiscountQty(rs.getBigDecimal("yearDSQty"));
				}else if(DiscountTypeEnum.FENXIAO_VALUE.equals(discountType)){
					cmDSInfo.setSaleOrderDiscountAmount(rs.getBigDecimal("fxDS"));
					cmDSInfo.setSaleOrderDiscountQty(rs.getBigDecimal("fxDSQty"));
				}
				// 保留两位小数
				BigDecimal saleDisAmount = cmDSInfo.getSaleOrderDiscountAmount().divide(new BigDecimal("1"),2,RoundingMode.HALF_UP);
				cmDSInfo.setSaleOrderDiscountAmount(saleDisAmount);
				// 获取已经保存过的 折让记录
				cmDSInfo = this.getSavedDiscountRecords(ctx, cmDSInfo, companyID, currCustomerInfo, discountType, periodInfo);
				
				// 添加明细到客户折让明细中
				currCustomerDSInfo.getMaterialDiscountInfos().add(cmDSInfo);
				currCustomerDSInfo.setDiscountSaleQty(currCustomerDSInfo.getDiscountSaleQty().add(cmDSInfo.getSaleOrderDiscountQty().divide(new BigDecimal("1"),4,RoundingMode.HALF_UP)));
				currCustomerDSInfo.setAllSaleQty(currCustomerDSInfo.getAllSaleQty().add(cmDSInfo.getSaleQty().divide(new BigDecimal("1"),4,RoundingMode.HALF_UP)));
				
				
			}
			// 将最后一条记录加入返回值中 
			if(currCustomerInfo != null && !returns.containsKey(currCustomerInfo)){
				
				returns.put(currCustomerInfo, currCustomerDSInfo);
			}
			
			
			
		}catch(SQLException sqle){
			throw new BOSException(sqle);
		}
		return returns;
	}
	
	/**
	 * 查询已保存的记录 
	 * @param ctx
	 * @param cmDSInfo
	 * @param companyID
	 * @param customerInfo
	 * @param discountType
	 * @param periodInfo
	 * @return
	 * @throws BOSException 
	 */
	private CustomerMaterialDSInfo getSavedDiscountRecords(Context ctx,
			CustomerMaterialDSInfo cmDSInfo,
			String companyID,
			CustomerInfo customerInfo,
			String discountType,
			PeriodInfo periodInfo) throws BOSException{
		
		StringBuilder sb = new StringBuilder();
		sb.append("select t.fid billID,te.fid entryID,t.fnumber,t.CFDiscountType,t.cfversion,tu.fid creatorID,tu.fnumber creatorNumber,tu.fname_l2 creatorName,t.cfamount,t.CFAdjustType,t.fbizdate,t.fcreatetime,t.cfstatus,te.CFDiscountAmount from ");
		sb.append(" CT_NDI_DiscountRecordBill t inner join ");
		sb.append(" CT_NDI_DiscountRecordBillEntry te on te.fparentid = t.fid ");
		sb.append(" inner join t_pm_user tu on t.fcreatorid = tu.fid ");
		sb.append(" where t.fdescription = '调整生成' and t.cfcustomerid='");
		sb.append(customerInfo.getId().toString());
		sb.append("' and t.cfcompanyid='");
		sb.append(companyID);
		sb.append("' and t.cfdiscounttype = ");
		sb.append(discountType);
		sb.append(" and t.cfperiodid = '");
		sb.append(periodInfo.getId().toString());
		sb.append("' and te.cfmaterialid='");
		sb.append(cmDSInfo.getMaterialInfo().getId().toString());
		sb.append("'  ");
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			if(rs.next()){
				String billID = rs.getString("billID");
				String entryID = rs.getString("entryID");
				String number = rs.getString("fnumber");
				String CFDiscountType = rs.getString("CFDiscountType");
				
				String creatorID = rs.getString("creatorID");
				String creatorNumber = rs.getString("creatorNumber");
				String creatorName = rs.getString("creatorName");
				UserInfo creator = new UserInfo();
				creator.setId(BOSUuid.read(creatorID));
				creator.setName(creatorName);
				creator.setNumber(creatorNumber);
				
				BigDecimal allDisAmount = rs.getBigDecimal("cfamount");
				String CFAdjustType = rs.getString("CFAdjustType");
				Date bizDate = rs.getDate("fbizdate");
				Date creatTime = rs.getDate("fcreatetime");
				String state = rs.getString("cfstatus");
				BigDecimal entryDisAmount = rs.getBigDecimal("CFDiscountAmount");
				
				int vision = rs.getInt("cfversion");
				
				// 数据设置到返回值中 
				cmDSInfo.setDisRecordID(billID);
				cmDSInfo.setDisRecordEntryID(entryID);
				cmDSInfo.setDisRecordNumber(number);
				cmDSInfo.setDisRecordBizdate(bizDate);
				cmDSInfo.setDisRecordCreateTime(creatTime);
				cmDSInfo.setDisRecordCreator(creator);
				
				
				cmDSInfo.setDisRecordVision(vision);
				cmDSInfo.setDisRecordStatus(billStatus.getEnum(state));
				cmDSInfo.setAdjustType(CFAdjustType);
				
				cmDSInfo.setDisRecordAdustAmount(entryDisAmount);
				cmDSInfo.setAdjustAmount(entryDisAmount);
				cmDSInfo.setDisRecordAllAdjust(allDisAmount);
				
				
			}
		}catch(SQLException sqle){
			throw new BOSException("查询折让历史记录出错",sqle);
		}
		return cmDSInfo;
		
	}
	
	/**
	 * 
	 */
	@Override
	protected ResultInfo _addDiscountRecords(Context ctx,
			CompanyOrgUnitInfo companyInfo, String discountType, Date bizDate,
			List adjustInfos,String adjustType) throws BOSException {

		ResultInfo ri = new ResultInfo();
		IDiscountRecordBill disRecordBill =  DiscountRecordBillFactory.getLocalInstance(ctx);
		Set<String> delRecordIDs = new HashSet<String>(); // 删除的 记录单id
		
		List<CustomerMaterialDSInfo> adjustDSInfos  = adjustInfos;
		Map<String,DiscountRecordBillInfo> newRecords = new HashMap<String, DiscountRecordBillInfo>();
		for(int i = 0; i < adjustDSInfos.size(); i++){
			CustomerMaterialDSInfo cmDSInfo = adjustDSInfos.get(i);
			DiscountRecordBillInfo disRecordInfo = null;
			// 保存需要删除的 历史记录单
			if(StringUtils.isNotBlank(cmDSInfo.getDisRecordID()) && !delRecordIDs.contains(cmDSInfo.getDisRecordID())){
				try{
					ObjectUuidPK pk = new ObjectUuidPK(cmDSInfo.getDisRecordID());
					DiscountRecordBillInfo recordBillInfo = disRecordBill.getDiscountRecordBillInfo(pk);
					if(recordBillInfo != null && billStatus.audit.equals(recordBillInfo.getStatus())){
						disRecordBill.unAudit(recordBillInfo);
					}
					disRecordBill.delete(pk);
					
					delRecordIDs.add(cmDSInfo.getDisRecordID());
				}catch(EASBizException easbize){
//					throw new BOSException("保存调整生成的折让记录出错",easbize);
					ri.setSuccess(false);
					ri.setMessage(easbize.getMessage());
					return ri;
				}
			}
			
			// 折让金额为0的  只删除历史记录 不在新增记录
			if(cmDSInfo.getAdjustAmount() == null || cmDSInfo.getAdjustAmount().compareTo(new BigDecimal("0")) == 0){
				continue;
			}
//			if(newRecords.containsKey(cmDSInfo.getCustomerInfo().getId().toString()) ){
//				disRecordInfo = newRecords.get(cmDSInfo.getCustomerInfo().getId().toString());
//			}else{
				disRecordInfo = new DiscountRecordBillInfo();
				disRecordInfo.setCompany(companyInfo);
				disRecordInfo.setCustomer(cmDSInfo.getCustomerInfo());
				Calendar cal = Calendar.getInstance();
				cal.setTime(bizDate);
				String number = companyInfo.getNumber() + "_"  +cmDSInfo.getCustomerInfo().getNumber() + "_" + cal.get(Calendar.MONTH) ;
				
				// 设置使用编码规则获得编码 获得不成功再自动生成
				String newNumber = "";
				
				if (companyInfo != null) {
					/**
					 * 获得唯一编码
					 */
					try {
						newNumber = this.getAutoCode(ctx, disRecordInfo, companyInfo.getId().toString());
					} catch (EASBizException e) {

						e.printStackTrace();
						
						throw new BOSException("取得记录单编号是出错",e);
						
					}
					
					// 获得唯一编码
					newNumber = getuniqnumber(ctx,disRecordInfo,companyInfo.getId().toString(),newNumber);
					
				}
				if (StringUtils.isNotBlank(newNumber)) {
					disRecordInfo.setNumber(companyInfo.getNumber() + newNumber);
				} else {
					disRecordInfo.setNumber(companyInfo.getNumber() + getuniqnumber(ctx, disRecordInfo, ContextUtil.getCurrentCtrlUnit(ctx).getId().toString(), newNumber));
				}
				
				disRecordInfo.setBizDate(bizDate);
				disRecordInfo.setDiscountType(DiscountTypeEnum.getEnum(discountType));
//				disRecordInfo.setAmount(new BigDecimal("0"));
				disRecordInfo.setDescription(adjustType);
				disRecordInfo.setAdjustType(cmDSInfo.getAdjustType());
				disRecordInfo.setPeriod(cmDSInfo.getPeriod());
				if(cmDSInfo.getDisRecordVision() > 0){
					disRecordInfo.setVersion(cmDSInfo.getDisRecordVision() + 1);
				}else{
					disRecordInfo.setVersion(1);
				}
				
				
				disRecordInfo.setStatus(com.kingdee.eas.custom.salediscount.billStatus.save);
				// 添加到map中
				newRecords.put(cmDSInfo.getCustomerInfo().getId().toString(),disRecordInfo);
				
//			}
			
			
			
			// 组装分录   设置到 记录单中
			DiscountRecordBillEntryInfo newEntry = new DiscountRecordBillEntryInfo();
			newEntry.setParent(disRecordInfo);
			newEntry.setMaterial(cmDSInfo.getMaterialInfo());
			newEntry.setMaterialName(cmDSInfo.getMaterialInfo().getName());
			newEntry.setDiscountAmount(cmDSInfo.getAdjustAmount());
			disRecordInfo.setAmount(cmDSInfo.getAdjustAmount());
			
			disRecordInfo.getEntrys().add(newEntry);
			
			try{
				IObjectPK recordPK = disRecordBill.addnew(disRecordInfo);
				
				if(recordPK != null){
					disRecordInfo.setId(BOSUuid.read(recordPK.toString()));
					disRecordBill.submit(disRecordInfo);
					disRecordBill.audit(disRecordInfo);
				}
			}catch(EASBizException easbize){
//				throw new BOSException("保存调整生成的折让记录出错",easbize);
				ri.setSuccess(false);
				ri.setMessage(easbize.getMessage());
				return ri;
			}
			
		}
		
		ri.setSuccess(true);
		ri.setMessage("");
		return ri;
	}
	
	// 得到自动编码
	protected String getAutoCode(Context ctx, IObjectValue objValue, String companyId) throws EASBizException, BOSException {
		IOrgSwitchFacade orgSwitch = null;
		ICodingRuleManager codeRuleMgr = null;
		CompanyOrgUnitInfo currCompany = ContextUtil.getCurrentFIUnit(ctx);
		if (ctx != null) {
			orgSwitch = OrgSwitchFacadeFactory.getLocalInstance(ctx);
			codeRuleMgr = CodingRuleManagerFactory.getLocalInstance(ctx);
		} else {
			orgSwitch = OrgSwitchFacadeFactory.getRemoteInstance();
			codeRuleMgr = CodingRuleManagerFactory.getRemoteInstance();
		}
		orgSwitch.orgSwitch(companyId);
		String number = "";
		if (codeRuleMgr.isUseIntermitNumber(objValue, companyId)) {
			number = codeRuleMgr.readNumber(objValue, companyId);
			number = codeRuleMgr.getNumber(objValue, companyId);
		} else 
		{
			number = codeRuleMgr.getNumber(objValue, companyId);
		}
		// 取得 编码后 切换回原公司
		if (currCompany != null) {
			orgSwitch.orgSwitch(currCompany.getId().toString());
		}

		return number;
	}
	
	/**
	 * 获得 唯一的 折让记录单编码 
	 * @param ctx
	 * @param objValue
	 * @param companyId
	 * @param number
	 * @return
	 * @throws BOSException
	 */
	public String getuniqnumber(Context ctx,IObjectValue objValue,String companyId, String number) throws BOSException{
		String sql = " select fid from CT_NDI_DiscountRecordBill where fnumber='"+number+"' ";
		String newnumber = number;
		try {
			
			IRowSet rs = com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,sql);
			if(rs.next()){
				newnumber = getAutoCode(ctx,objValue,companyId);
				
				return getuniqnumber(ctx,objValue,companyId,newnumber);
			}
			else {
				return number;
			}
		} catch (EASBizException e) {
			 throw new BOSException("错误：",e);
		} catch (BOSException e) {
			 throw new BOSException("错误：",e);
		} catch (SQLException e) {
			 throw new BOSException("错误：",e);
		}
	}
	/**
	 * 销售订单生成对应的  折让记录单
	 */
	@Override
	protected boolean _generateDiscountRecordbill(Context ctx, String companyID,
			List discountTypes, List customers, Date beginDate, Date endDate) throws BOSException {
		
		// 首先获取 符合条件的订单，然后逐单处理
		SaleOrderCollection orderCol = this.getSaleOrderInfos(ctx, companyID,customers, beginDate, endDate);
		// 获得 botpID   月折 ：SaleOrder-DiscountRecord-Monthly 
		// 公司 折让设置
		DiscountCompanyInfo disComSetInfo = _getCompanyDSSet(ctx,companyID);
		if(disComSetInfo == null){
			throw new BOSException("未找到对应组织的 折让设置，不能生成折让记录单");
		}
		Map<String,String> botpIDs = getToRecordBillIDs(ctx,disComSetInfo);
		// bostype
		String saleOrderBostype = "C48A423A";
		String discountRecordBostype = "BB4F0454";
		
		
		// 折让记录单接口
		IDiscountRecordBill  iDiscountRecord = DiscountRecordBillFactory.getLocalInstance(ctx);
		if(orderCol != null && orderCol.size() > 0){
			
			// 加载 botp
			Map<String,BOTMappingInfo> botpInfoMap = initBotpInfos(ctx,botpIDs);
			
			// periodMap 
			Map<String,PeriodInfo> periodMap = new HashMap<String, PeriodInfo>();
			
			for(int i = 0; i < orderCol.size(); i++){
				SaleOrderInfo orderInfo = orderCol.get(i);
				
				try{
					orderInfo = SaleOrderFactory.getLocalInstance(ctx).getSaleOrderInfo(new ObjectUuidPK(orderInfo.getId()));
					Date bizdDate = orderInfo.getBizDate();
					Calendar cal = Calendar.getInstance();
					cal.setTime(bizdDate);
					int year = cal.get(Calendar.YEAR);
					int period = cal.get(Calendar.MONTH);
					
					PeriodTypeInfo	type = new PeriodTypeInfo();
					type.setId(BOSUuid.read("JsOI2jUYRWCjgdHPsfrsDF9piaY="));
					
					PeriodInfo currentPeriod = null;
					if(periodMap.containsKey(Integer.toString(year) + Integer.toString(period))){
						currentPeriod = periodMap.get(Integer.toString(year) + Integer.toString(period));
					}else{
						currentPeriod = PeriodFactory.getLocalInstance(ctx).getPeriodInfo(year, period + 1, type);
						periodMap.put(Integer.toString(year) + Integer.toString(period), currentPeriod);
					}
					// 月折
					if(discountTypes.contains(DiscountTypeEnum.YUEZHE_VALUE)){
//						String yzBotID = botpIDs.get("SaleOrder-DiscountRecord-Monthly");
						String yzBotID = botpIDs.get(disComSetInfo.getOrderYZToRecordBotp());
						String yzBotNum=disComSetInfo.getOrderYZToRecordBotp();
						if(StringUtils.isNotBlank(yzBotID)){
							IObjectPK botpPK = new ObjectUuidPK(yzBotID);
							CoreBillBaseCollection srcBillCollection = new CoreBillBaseCollection();
							srcBillCollection.add(orderInfo);
							// 如果botp不允许多次生成，校验 是否已经生成过  如果没有的话则 重新生成
//							BOTMappingInfo botMappingInfo = BOTMappingFactory.getLocalInstance(ctx).getMappingInfoByPK(botpPK);
							
							
							BOTMappingInfo botMappingInfo = botpInfoMap.get(yzBotNum);
							ExtConfigInfo extConfig = null;
							BotpExtConfigHelper botpExtHelper = new BotpExtConfigHelper();
							BotpExtConfigHelper.XMLProcessor xmlProcessor = botpExtHelper.new XMLProcessor();
							String configStr = botMappingInfo.getExtConfig();
							extConfig = xmlProcessor.marshallingExtConfig(configStr);
//							botMappingInfo.gete
							String reBuildCtrl = extConfig.getReBuildControl();
							if("2".equals(reBuildCtrl)){
								boolean isExist = AppCommonUtil.botpExistDestBill(ctx, botpPK.toString(),orderInfo.getId().toString());
								if(!isExist){
							
									// 获取所有可用的botcoll
									String srcBillType = "C48A423A";
									String destBillTypeBOSType = "BB4F0454";
									String[] srcBillIDs = {orderInfo.getId().toString()};
									String[] entryNames = {"entrys"};
									List entriesKey = new ArrayList<String>();
//									IObjectCollection objColl = AppCommonUtil.generateDestBill(ctx,
//												"C48A423A", 
//												"BB4F0454",
//												srcBillCollection,
//												DefineSysEnum.BTP, 
//												botpPK);
									
									
									IObjectCollection objColl  = AppCommonUtil.transformForBotp(ctx,
											srcBillIDs, 
											entryNames,
											entriesKey, 
											null,
											destBillTypeBOSType, 
											botpPK, 
											srcBillType );
									if(objColl != null && objColl.size() > 0){
										DiscountRecordBillInfo disRecordInfo = (DiscountRecordBillInfo) objColl.getObject(0);
										String newNumber = "";
										if (companyID != null) {
											/**
											 * 获得唯一编码
											 */
											try {
												newNumber = this.getAutoCode(ctx, disRecordInfo, companyID);
											} catch (EASBizException e) {
	
												e.printStackTrace();
												
												throw new BOSException("取得记录单编号是出错",e);
												
											}
											
											// 获得唯一编码
											newNumber = getuniqnumber(ctx,disRecordInfo,companyID,newNumber);
											
										}
										if (StringUtils.isNotBlank(newNumber)) {
											disRecordInfo.setNumber(newNumber);
										} else {
											disRecordInfo.setNumber(getuniqnumber(ctx, disRecordInfo, ContextUtil.getCurrentCtrlUnit(ctx).getId().toString(), newNumber));
										}
										disRecordInfo.setPeriod(currentPeriod);
										// 提交
										iDiscountRecord.submit(disRecordInfo);
										// 审核
										iDiscountRecord.audit(disRecordInfo);
										
									}
								}
							}
						}else{
							throw new BOSException("当前公司尚未维护订单月折BOTP编码或者维护错误，请联系管理员处理");
						}
					}
					// 年折
					if(discountTypes.contains(DiscountTypeEnum.NIANZHE_VALUE)){
//						String yzBotID = botpIDs.get("SaleOrder-DiscountRecord-Yearly");
						String yzBotID = botpIDs.get(disComSetInfo.getOrderYearZToRecordBotp());
						String yzBotNum=disComSetInfo.getOrderYearZToRecordBotp();
						if(StringUtils.isNotBlank(yzBotID)){
							IObjectPK botpPK = new ObjectUuidPK(yzBotID);
							CoreBillBaseCollection srcBillCollection = new CoreBillBaseCollection();
							srcBillCollection.add(orderInfo);
							
							// 如果botp不允许多次生成，校验 是否已经生成过  如果没有的话则 重新生成
//							BOTMappingInfo botMappingInfo = BOTMappingFactory.getLocalInstance(ctx).getMappingInfoByPK(botpPK);
							BOTMappingInfo botMappingInfo = botpInfoMap.get(yzBotNum);
//							ExtConfigInfo extConfig = botMappingInfo.getExtConfigInfo();
							ExtConfigInfo extConfig = null;
							BotpExtConfigHelper botpExtHelper = new BotpExtConfigHelper();
							BotpExtConfigHelper.XMLProcessor xmlProcessor = botpExtHelper.new XMLProcessor();
							String configStr = botMappingInfo.getExtConfig();
							extConfig = xmlProcessor.marshallingExtConfig(configStr);
							String reBuildCtrl = extConfig.getReBuildControl();
							if("2".equals(reBuildCtrl)){
								boolean isExist = AppCommonUtil.botpExistDestBill(ctx, botpPK.toString(),orderInfo.getId().toString());
								if(!isExist){
								
//									IObjectCollection objColl = AppCommonUtil.generateDestBill(ctx,
//												"C48A423A", 
//												"BB4F0454",
//												srcBillCollection,DefineSysEnum.BTP, 
//												botpPK);
									String srcBillType = "C48A423A";
									String destBillTypeBOSType = "BB4F0454";
									String[] srcBillIDs = {orderInfo.getId().toString()};
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
									
									if(objColl != null && objColl.size() > 0){
										DiscountRecordBillInfo disRecordInfo = (DiscountRecordBillInfo) objColl.getObject(0);
										String newNumber = "";
										if (companyID != null) {
											/**
											 * 获得唯一编码
											 */
											try {
												newNumber = this.getAutoCode(ctx, disRecordInfo, companyID);
											} catch (EASBizException e) {
	
												e.printStackTrace();
												
												throw new BOSException("取得记录单编号是出错",e);
												
											}
											
											// 获得唯一编码
											newNumber = getuniqnumber(ctx,disRecordInfo,companyID,newNumber);
											
										}
										if (StringUtils.isNotBlank(newNumber)) {
											disRecordInfo.setNumber(newNumber);
										} else {
											disRecordInfo.setNumber(getuniqnumber(ctx, disRecordInfo, ContextUtil.getCurrentCtrlUnit(ctx).getId().toString(), newNumber));
										}
										disRecordInfo.setPeriod(currentPeriod);
										// 提交
										iDiscountRecord.submit(disRecordInfo);
										// 审核
										iDiscountRecord.audit(disRecordInfo);
										
									}
								}
							}
						}else{
							throw new BOSException("当前公司尚未维护订单年折BOTP编码或者维护错误，请联系管理员处理");
						}
					}
					// 分销折扣
					if(discountTypes.contains(DiscountTypeEnum.FENXIAO_VALUE)){
//						String yzBotID = botpIDs.get("SaleOrder-DiscountRecord-Fx");
//						String yzBotNum="SaleOrder-DiscountRecord-Fx";
						String yzBotID = botpIDs.get(disComSetInfo.getOrderFXToRecordBotp());
						String yzBotNum=disComSetInfo.getOrderFXToRecordBotp();
						if(StringUtils.isNotBlank(yzBotID)){
							IObjectPK botpPK = new ObjectUuidPK(yzBotID);
							
							CoreBillBaseCollection srcBillCollection = new CoreBillBaseCollection();
							srcBillCollection.add(orderInfo);
							
							// 如果botp不允许多次生成，校验 是否已经生成过  如果没有的话则 重新生成
//							BOTMappingInfo botMappingInfo = BOTMappingFactory.getLocalInstance(ctx).getMappingInfoByPK(botpPK);
							BOTMappingInfo botMappingInfo = botpInfoMap.get(yzBotNum);
//							ExtConfigInfo extConfig = botMappingInfo.getExtConfigInfo();
							ExtConfigInfo extConfig = null;
							BotpExtConfigHelper botpExtHelper = new BotpExtConfigHelper();
							BotpExtConfigHelper.XMLProcessor xmlProcessor = botpExtHelper.new XMLProcessor();
							String configStr = botMappingInfo.getExtConfig();
							extConfig = xmlProcessor.marshallingExtConfig(configStr);
							
							String reBuildCtrl = extConfig.getReBuildControl();
							if("2".equals(reBuildCtrl)){
								boolean isExist = AppCommonUtil.botpExistDestBill(ctx, botpPK.toString(),orderInfo.getId().toString());
								if(!isExist){
								
//									IObjectCollection objColl = AppCommonUtil.generateDestBill(ctx,
//												"C48A423A", 
//												"BB4F0454",
//												srcBillCollection,DefineSysEnum.BTP, 
//												botpPK);
									
									String srcBillType = "C48A423A";
									String destBillTypeBOSType = "BB4F0454";
									String[] srcBillIDs = {orderInfo.getId().toString()};
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
									if(objColl != null && objColl.size() > 0){
										DiscountRecordBillInfo disRecordInfo = (DiscountRecordBillInfo) objColl.getObject(0);
										String newNumber = "";
										if (companyID != null) {
											/**
											 * 获得唯一编码
											 */
											try {
												newNumber = this.getAutoCode(ctx, disRecordInfo, companyID);
											} catch (EASBizException e) {
	
												e.printStackTrace();
												
												throw new BOSException("取得记录单编号是出错",e);
												
											}
											
											// 获得唯一编码
											newNumber = getuniqnumber(ctx,disRecordInfo,companyID,newNumber);
											
										}
										if (StringUtils.isNotBlank(newNumber)) {
											disRecordInfo.setNumber(newNumber);
										} else {
											disRecordInfo.setNumber(getuniqnumber(ctx, disRecordInfo, ContextUtil.getCurrentCtrlUnit(ctx).getId().toString(), newNumber));
										}
										disRecordInfo.setPeriod(currentPeriod);
										// 提交
										iDiscountRecord.submit(disRecordInfo);
										// 审核
										iDiscountRecord.audit(disRecordInfo);
										
									}
								}
							}
						}else{
							throw new BOSException("当前公司尚未维护订单分销折让BOTP编码或者维护错误，请联系管理员处理");
						}
					}
				}catch(BOSException e){
					e.printStackTrace();
					String message = e.getMessage();
					if(message != null && message.indexOf("不符合转换规则") >=0){
						continue;
					}else{
						throw e;
					}
				}catch(Exception e){
					e.printStackTrace();
					continue;
				}
			}
		}
		return true;
		// 退货申请单生成 折让记录单
//		return _generateReturnsDiscountRecordbill(ctx, companyID, discountTypes, beginDate, endDate);
	}
	
	/**
	 * 获取所有botpid对应的mapinfo
	 * @param botpIDs
	 * @return
	 * @throws BOSException 
	 */
	private Map<String, BOTMappingInfo> initBotpInfos(Context ctx,
			Map<String, String> botpIDs) throws BOSException {
		Map<String,BOTMappingInfo> botpInfos = new HashMap<String, BOTMappingInfo>();
		Set<String> keySet = botpIDs.keySet();
		Iterator<String> keyIte = keySet.iterator();
		while(keyIte.hasNext()){
			String key = keyIte.next();
			String botID = botpIDs.get(key);
			
			IObjectPK botpPK = new ObjectUuidPK(botID);
			BOTMappingInfo botMappingInfo = BOTMappingFactory.getLocalInstance(ctx).getMappingInfoByPK(botpPK);
			
			botpInfos.put(key, botMappingInfo);
		}
		return botpInfos;
	}
	/**
	 * 销售退货申请单生成对应的  折让记录单
	 * ！！！！！！！！！！！！！！！！！！！！！！！！ TODO 强英当前不支持
	 */
	protected boolean _generateReturnsDiscountRecordbill(Context ctx, String companyID,
			List discountTypes, Date beginDate, Date endDate) throws BOSException {
		
		// 首先获取 符合条件的订单，然后逐单处理
		SaleReturnsCollection returnsCol = this.getSaleReturnsInfos(ctx, companyID, beginDate, endDate);
		// 获得 botpID   月折 ：SaleOrder-DiscountRecord-Monthly 
		Map<String,String> botpIDs = this.getToReturnsBillIDs(ctx,null);
		// bostype
		String saleReturnBostype = "546F192F";
		String discountRecordBostype = "BB4F0454";
		// 折让记录单接口
		IDiscountRecordBill  iDiscountRecord = DiscountRecordBillFactory.getLocalInstance(ctx);
		if(returnsCol != null && returnsCol.size() > 0){
			for(int i = 0; i < returnsCol.size(); i++){
				SaleReturnsInfo returnInfo = returnsCol.get(i);
				
				try{
					returnInfo = SaleReturnsFactory.getLocalInstance(ctx).getSaleReturnsInfo(new ObjectUuidPK(returnInfo.getId()));
					
					Date bizdDate = returnInfo.getBizDate();
					Calendar cal = Calendar.getInstance();
					cal.setTime(bizdDate);
					int year = cal.get(Calendar.YEAR);
					int period = cal.get(Calendar.MONTH);
					
					PeriodTypeInfo	type = new PeriodTypeInfo();
					type.setId(BOSUuid.read("JsOI2jUYRWCjgdHPsfrsDF9piaY="));
					PeriodInfo currentPeriod = PeriodFactory.getLocalInstance(ctx).getPeriodInfo(year, period + 1, type);
					
					// 月折
					if(discountTypes.contains(DiscountTypeEnum.YUEZHE_VALUE)){
						String yzBotID = botpIDs.get("SaleTH-DiscountRecord-Monthly");
						String yzBotNum="SaleTH-DiscountRecord-Monthly";
						if(StringUtils.isNotBlank(yzBotID)){
							IObjectPK botpPK = new ObjectUuidPK(yzBotID);
							CoreBillBaseCollection srcBillCollection = new CoreBillBaseCollection();
							srcBillCollection.add(returnInfo);
							// 如果botp不允许多次生成，校验 是否已经生成过  如果没有的话则 重新生成
							BOTMappingInfo botMappingInfo = BOTMappingFactory.getLocalInstance(ctx).getMappingInfoByPK(botpPK);
//							ExtConfigInfo extConfig = botMappingInfo.getExtConfigInfo();
							
							ExtConfigInfo extConfig = null;
							BotpExtConfigHelper botpExtHelper = new BotpExtConfigHelper();
							BotpExtConfigHelper.XMLProcessor xmlProcessor = botpExtHelper.new XMLProcessor();
							String configStr = botMappingInfo.getExtConfig();
							extConfig = xmlProcessor.marshallingExtConfig(configStr);
							
							String reBuildCtrl = extConfig.getReBuildControl();
							if("2".equals(reBuildCtrl)){
								boolean isExist = AppCommonUtil.botpExistDestBill(ctx, botpPK.toString(),returnInfo.getId().toString());
								if(!isExist){
							
									IObjectCollection objColl = AppCommonUtil.generateDestBill(ctx,
												saleReturnBostype, 
												"BB4F0454",
												srcBillCollection,DefineSysEnum.BTP, 
												botpPK);
									
									if(objColl != null && objColl.size() > 0){
										DiscountRecordBillInfo disRecordInfo = (DiscountRecordBillInfo) objColl.getObject(0);
										String newNumber = "";
										if (companyID != null) {
											/**
											 * 获得唯一编码
											 */
											try {
												newNumber = this.getAutoCode(ctx, disRecordInfo, companyID);
											} catch (EASBizException e) {
	
												e.printStackTrace();
												
												throw new BOSException("取得记录单编号是出错",e);
												
											}
											
											// 获得唯一编码
											newNumber = getuniqnumber(ctx,disRecordInfo,companyID,newNumber);
											
										}
										if (StringUtils.isNotBlank(newNumber)) {
											disRecordInfo.setNumber(newNumber);
										} else {
											disRecordInfo.setNumber(getuniqnumber(ctx, disRecordInfo, ContextUtil.getCurrentCtrlUnit(ctx).getId().toString(), newNumber));
										}
										disRecordInfo.setPeriod(currentPeriod);
										// 提交
										iDiscountRecord.submit(disRecordInfo);
										// 审核
										iDiscountRecord.audit(disRecordInfo);
										
									}
								}
							}
						}
					}
					// 年折
					if(discountTypes.contains(DiscountTypeEnum.NIANZHE_VALUE)){
						String yzBotID = botpIDs.get("SaleTH-DiscountRecord-Yearly");
						if(StringUtils.isNotBlank(yzBotID)){
							IObjectPK botpPK = new ObjectUuidPK(yzBotID);
							CoreBillBaseCollection srcBillCollection = new CoreBillBaseCollection();
							srcBillCollection.add(returnInfo);
							
							// 如果botp不允许多次生成，校验 是否已经生成过  如果没有的话则 重新生成
							BOTMappingInfo botMappingInfo = BOTMappingFactory.getLocalInstance(ctx).getMappingInfoByPK(botpPK);
//							ExtConfigInfo extConfig = botMappingInfo.getExtConfigInfo();
							
							ExtConfigInfo extConfig = null;
							BotpExtConfigHelper botpExtHelper = new BotpExtConfigHelper();
							BotpExtConfigHelper.XMLProcessor xmlProcessor = botpExtHelper.new XMLProcessor();
							String configStr = botMappingInfo.getExtConfig();
							extConfig = xmlProcessor.marshallingExtConfig(configStr);
							
							String reBuildCtrl = extConfig.getReBuildControl();
							if("2".equals(reBuildCtrl)){
								boolean isExist = AppCommonUtil.botpExistDestBill(ctx, botpPK.toString(),returnInfo.getId().toString());
								if(!isExist){
								
									IObjectCollection objColl = AppCommonUtil.generateDestBill(ctx,
												saleReturnBostype, 
												"BB4F0454",
												srcBillCollection,DefineSysEnum.BTP, 
												botpPK);
									
									if(objColl != null && objColl.size() > 0){
										DiscountRecordBillInfo disRecordInfo = (DiscountRecordBillInfo) objColl.getObject(0);
										String newNumber = "";
										if (companyID != null) {
											/**
											 * 获得唯一编码
											 */
											try {
												newNumber = this.getAutoCode(ctx, disRecordInfo, companyID);
											} catch (EASBizException e) {
	
												e.printStackTrace();
												
												throw new BOSException("取得记录单编号是出错",e);
												
											}
											
											// 获得唯一编码
											newNumber = getuniqnumber(ctx,disRecordInfo,companyID,newNumber);
											
										}
										if (StringUtils.isNotBlank(newNumber)) {
											disRecordInfo.setNumber(newNumber);
										} else {
											disRecordInfo.setNumber(getuniqnumber(ctx, disRecordInfo, ContextUtil.getCurrentCtrlUnit(ctx).getId().toString(), newNumber));
										}
										disRecordInfo.setPeriod(currentPeriod);
										// 提交
										iDiscountRecord.submit(disRecordInfo);
										// 审核
										iDiscountRecord.audit(disRecordInfo);
										
									}
								}
							}
						}
					}
					// 分销折扣
					if(discountTypes.contains(DiscountTypeEnum.FENXIAO_VALUE)){
						String yzBotID = botpIDs.get("SaleTH-DiscountRecord-Fx");
						if(StringUtils.isNotBlank(yzBotID)){
							IObjectPK botpPK = new ObjectUuidPK(yzBotID);
							
							CoreBillBaseCollection srcBillCollection = new CoreBillBaseCollection();
							srcBillCollection.add(returnInfo);
							
							// 如果botp不允许多次生成，校验 是否已经生成过  如果没有的话则 重新生成
							BOTMappingInfo botMappingInfo = BOTMappingFactory.getLocalInstance(ctx).getMappingInfoByPK(botpPK);
//							ExtConfigInfo extConfig = botMappingInfo.getExtConfigInfo();
							
							ExtConfigInfo extConfig = null;
							BotpExtConfigHelper botpExtHelper = new BotpExtConfigHelper();
							BotpExtConfigHelper.XMLProcessor xmlProcessor = botpExtHelper.new XMLProcessor();
							String configStr = botMappingInfo.getExtConfig();
							extConfig = xmlProcessor.marshallingExtConfig(configStr);
							
							String reBuildCtrl = extConfig.getReBuildControl();
							if("2".equals(reBuildCtrl)){
								boolean isExist = AppCommonUtil.botpExistDestBill(ctx, botpPK.toString(),returnInfo.getId().toString());
								if(!isExist){
								
									IObjectCollection objColl = AppCommonUtil.generateDestBill(ctx,
												saleReturnBostype, 
												"BB4F0454",
												srcBillCollection,DefineSysEnum.BTP, 
												botpPK);
									
									if(objColl != null && objColl.size() > 0){
										DiscountRecordBillInfo disRecordInfo = (DiscountRecordBillInfo) objColl.getObject(0);
										String newNumber = "";
										if (companyID != null) {
											/**
											 * 获得唯一编码
											 */
											try {
												newNumber = this.getAutoCode(ctx, disRecordInfo, companyID);
											} catch (EASBizException e) {
	
												e.printStackTrace();
												
												throw new BOSException("取得记录单编号是出错",e);
												
											}
											
											// 获得唯一编码
											newNumber = getuniqnumber(ctx,disRecordInfo,companyID,newNumber);
											
										}
										if (StringUtils.isNotBlank(newNumber)) {
											disRecordInfo.setNumber(newNumber);
										} else {
											disRecordInfo.setNumber(getuniqnumber(ctx, disRecordInfo, ContextUtil.getCurrentCtrlUnit(ctx).getId().toString(), newNumber));
										}
										disRecordInfo.setPeriod(currentPeriod);
										// 提交
										iDiscountRecord.submit(disRecordInfo);
										// 审核
										iDiscountRecord.audit(disRecordInfo);
										
									}
								}
							}
						}
					}
				}catch(Exception e){
					e.printStackTrace();
					continue;
				}
			}
		}
		
		
		return true;
	}
	
	
	
	/**
	 * 获得从销售订单到 折让记录单的  botpid
	 * @param ctx
	 * @return
	 * @throws BOSException 
	 */
	private Map<String,String> getToRecordBillIDs(Context ctx,DiscountCompanyInfo disComSetInfo) throws BOSException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select t.fid,t.fname from t_bot_mapping t inner join t_bot_extMapping te on t.fextMappingID = te.fid ");
		sql.append(" where te.fiseffected=1 and t.fname in ('");
		sql.append(StringUtils.trim(disComSetInfo.getOrderYZToRecordBotp()));
		sql.append("','");
		sql.append(StringUtils.trim(disComSetInfo.getOrderYearZToRecordBotp()));
		sql.append("','");
		sql.append(StringUtils.trim(disComSetInfo.getOrderFXToRecordBotp()));
		sql.append("')");
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		Map<String,String> ids = new HashMap<String,String>();
		try{
			while(rs.next()){
				String fid = rs.getString("fid");
				String fname = rs.getString("fname");
				
				ids.put(fname, fid);
			}
		}catch(SQLException sqle){
			throw new BOSException("查询生成折让记录单botp内码时出错",sqle);
		}
		return ids;
	}
	
	/**
	 * 获得从销售退货申请单到 折让记录单的  botpid
	 * TODO
	 * 强英当前不支持   ！！！！！！！！！！！！！
	 * @param ctx
	 * @return
	 * @throws BOSException 
	 */
	private Map<String,String> getToReturnsBillIDs(Context ctx,DiscountCompanyInfo disComSetInfo) throws BOSException {
		
		return new HashMap<String,String>();
//		String sql = " select t.fid,t.fname from t_bot_mapping t inner join t_bot_extMapping te on t.fextMappingID = te.fid where te.fiseffected=1 and t.fname in ('SaleTH-DiscountRecord-Monthly','SaleTH-DiscountRecord-Yearly','SaleTH-DiscountRecord-Fx')";
//		IRowSet rs = DbUtil.executeQuery(ctx, sql);
//		Map<String,String> ids = new HashMap<String,String>();
//		try{
//			while(rs.next()){
//				String fid = rs.getString("fid");
//				String fname = rs.getString("fname");
//				
//				ids.put(fname, fid);
//			}
//		}catch(SQLException sqle){
//			throw new BOSException("查询生成折让记录单botp内码时出错",sqle);
//		}
//		return ids;
	}
	/**
	 * 获取符合条件的销售订单
	 * @param ctx
	 * @param companyID
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws BOSException 
	 */
	private SaleOrderCollection getSaleOrderInfos(Context ctx,String companyID,List customers,Date beginDate, Date endDate) throws BOSException{
		SaleOrderCollection  saleOrders = new SaleOrderCollection();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuilder sb = new StringBuilder();
		sb.append("/*dialect*/select fid id, fnumber fnumber from t_sd_saleorder where (fbasestatus=4 or fbasestatus = 7) and fsaleorgunitid='");
		sb.append(companyID);
		sb.append("' and fbizdate >=to_date('");
		sb.append(sdf.format(beginDate));
		sb.append("','yyyy-mm-dd') and fbizdate <=to_date('");
		sb.append(sdf.format(endDate));
		sb.append("','yyyy-mm-dd')");
		
		if(customers != null && customers.size() > 0){
			String idRange = AppCommon.getIDRangeStrFromBills(customers);
			if(StringUtils.isNotBlank(idRange)){
				sb.append(" and FORDERCUSTOMERID in ");
				sb.append(idRange);
			}
		}
		
		IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
		try{
			while(rs.next()){
				String id = rs.getString("id");
				String number = rs.getString("fnumber");
				
				SaleOrderInfo orderInfo = new SaleOrderInfo();
				orderInfo.setId(BOSUuid.read(id));
				orderInfo.setNumber(number);
				saleOrders.add(orderInfo);
			}
		}catch(SQLException sqle){
			throw new BOSException("查询订单出错",sqle);
		}
		return saleOrders;
	}
	
	/**
	 * 获取符合条件的销售退货申请单
	 * @param ctx
	 * @param companyID
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws BOSException 
	 */
	protected SaleReturnsCollection getSaleReturnsInfos(Context ctx,String companyID,Date beginDate, Date endDate) throws BOSException{
		SaleReturnsCollection  saleReturns = new SaleReturnsCollection();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuilder sb = new StringBuilder();
		sb.append("/*dialect*/select fid id, fnumber fnumber from t_sd_salereturns where (fbasestatus=4 or fbasestatus = 7) and fsaleorgunitid='");
		sb.append(companyID);
		sb.append("' and fbizdate >=to_date('");
		sb.append(sdf.format(beginDate));
		sb.append("','yyyy-mm-dd') and fbizdate <=to_date('");
		sb.append(sdf.format(endDate));
		sb.append("','yyyy-mm-dd')");
		
		IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
		try{
			while(rs.next()){
				String id = rs.getString("id");
				String number = rs.getString("fnumber");
				
				SaleReturnsInfo returnInfo = new SaleReturnsInfo();
				returnInfo.setId(BOSUuid.read(id));
				returnInfo.setNumber(number);
				saleReturns.add(returnInfo);
			}
		}catch(SQLException sqle){
			throw new BOSException("查询退货申请单出错",sqle);
		}
		return saleReturns;
	}
	/**
	 * 查询折让记录信息，
	 */
	@Override
	protected List _getDiscountCashInfos(Context ctx, String companyID,
			List discountTypes, Date beginDate, Date endDate, List customers,boolean isNotReceiving,boolean isHaveReceiving)
			throws BOSException {
		List<DiscountCashInfo> cashInfos = new ArrayList<DiscountCashInfo>();
		String customerIDs = this.getCustomerIDs(customers);
		String discountTypeIDs = this.getDiscountTypes(discountTypes);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuilder sb = new StringBuilder();
		sb.append("/*dialect*/select t.fid,t.CFCustomerID,tcus.fnumber customerNumber,tcus.fname_l2 customerName,t.fnumber billnumber,t.fbizdate billdate,t.cfamount,t.CFDiscountType,t.CFStatus, ");
		sb.append(" tc.fid receivingID,tc.fnumber receivingNumber,tc.fbillstatus receivingStatus,tc.fbizdate rebizdate,tc.fcreatetime recreatetime, ");
		sb.append(" tu.fname_l2 recreator ");
		sb.append("from CT_NDI_DiscountRecordBill t ");
		sb.append(" left join t_bd_customer tcus on t.CFCustomerID = tcus.fid ");
		sb.append(" left join t_bot_relation tr on t.fid = tr.fsrcobjectid and tr.fsrcentityid='BB4F0454' and tr.fdestentityid='FA44FD5B' ");
		sb.append(" left join t_cas_receivingbill tc on tr.fdestobjectid=tc.fid ");
		sb.append(" left join t_pm_user tu on tc.fcreatorid=tu.fid ");
		sb.append(" where t.cfstatus = 4 and t.fbizdate >= to_date('");
		sb.append(sdf.format(beginDate));
		sb.append("','yyyy-mm-dd') and t.fbizdate <= to_date('");
		sb.append(sdf.format(endDate));
		sb.append("','yyyy-mm-dd') ");
		sb.append(" and t.CFCompanyID='");
		sb.append(companyID);
		sb.append("' ");
		if(StringUtils.isNotBlank(customerIDs) && customerIDs.length() > 5){
			sb.append(" and t.CFCustomerID in ");
			sb.append(customerIDs);
		}
		// 未生成收款单 
		if(isNotReceiving){
			sb.append(" and tc.fid is null ");
		}
		
		if(isHaveReceiving){
			sb.append(" and tc.fid is not null ");
		}
		sb.append(" and t.CFDiscountType in ");
		sb.append(discountTypeIDs);
		sb.append(" order by t.CFCustomerID,t.CFDiscountType,t.fbizdate,t.fnumber ");
		
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			String lastCustomerID = "";
			String lastDiscountType="";
			DiscountCashInfo dcInfo = new DiscountCashInfo();
			DiscountCashDetail detail = null;
			CustomerInfo newCustomerInfo = null;
			while(rs.next()){
				String fid = rs.getString("fid");
				String billnumber = rs.getString("billnumber");
				String CFCustomerID = rs.getString("CFCustomerID");
				String customerNumber = rs.getString("customerNumber");
				String customerName = rs.getString("customerName");

				Date billdate = rs.getDate("billdate");
				BigDecimal cfamount = rs.getBigDecimal("cfamount");
				cfamount = (cfamount==null?new BigDecimal("0"):cfamount);
				String CFDiscountType = rs.getString("CFDiscountType");
				String CFStatus = rs.getString("CFStatus");
				String receivingID = rs.getString("receivingID");
				String receivingNumber = rs.getString("receivingNumber");
				int receivingStatus = rs.getInt("receivingStatus");
				Date rebizdate = rs.getDate("rebizdate");
				Date recreatetime = rs.getDate("recreatetime");
				String recreator = rs.getString("recreator");
				
				if(!CFCustomerID.equals(lastCustomerID) || !CFDiscountType.equals(lastDiscountType)){
//					// 客户id非空 首先保存 上一条记录
//					if(StringUtils.isNotBlank(lastCustomerID)){
						
//					}
					
					// 如果客户发生变化  则重新 创建一个 兑现记录
					dcInfo = new DiscountCashInfo();
					// 添加到结果集
					cashInfos.add(dcInfo);
					newCustomerInfo = new CustomerInfo();
					newCustomerInfo.setId(BOSUuid.read(CFCustomerID));
					newCustomerInfo.setNumber(customerNumber);
					newCustomerInfo.setName(customerName);
					// 指向当前客户ID
					lastCustomerID = CFCustomerID;
					lastDiscountType = CFDiscountType;
					dcInfo.setCustomerInfo(newCustomerInfo);
					dcInfo.setAllAmount(new BigDecimal("0"));
					dcInfo.setBillCount(0);
					dcInfo.setDiscountTypeEnum(DiscountTypeEnum.getEnum(CFDiscountType));
					// 分录为空
					dcInfo.setDetails(new ArrayList<DiscountCashDetail>());
				}
				
				// 录入明细信息
				// 明细
				detail = new DiscountCashDetail();
				
				detail.setCustomerInfo(newCustomerInfo);
				detail.setCount(dcInfo.getBillCount() + 1);
				dcInfo.setBillCount(dcInfo.getBillCount() + 1);
				// 记录单
				DiscountRecordBillInfo recordInfo = new DiscountRecordBillInfo();
				recordInfo.setId(BOSUuid.read(fid));
				recordInfo.setNumber(billnumber);
				recordInfo.setAmount(cfamount);
				// 金额累加到 合计中
				dcInfo.setAllAmount(dcInfo.getAllAmount().add(cfamount));
				recordInfo.setBizDate(billdate);
				recordInfo.setStatus(billStatus.getEnum(CFStatus));
				detail.setRecordBillInfo(recordInfo);
				
				// 收款单信息
				
				if(StringUtils.isNotBlank(receivingID)){
					ReceivingBillInfo receivingBillInfo = new ReceivingBillInfo();
					receivingBillInfo.setId(BOSUuid.read(receivingID));
					receivingBillInfo.setNumber(receivingNumber);
					receivingBillInfo.setBizDate(rebizdate);
					receivingBillInfo.setBillStatus(BillStatusEnum.getEnum(receivingStatus));
					receivingBillInfo.setCreateTime(new Timestamp(recreatetime.getTime()));
					detail.setReceivingBillInfo(receivingBillInfo);
				}
				detail.setReveivingCreator(recreator);
				
				// 添加到 合计中 
				dcInfo.getDetails().add(detail);
				
			}
		}catch(SQLException e){
			throw new BOSException("查询折让记录信息出错",e);
		}
		
		return cashInfos;
	}
	/**
	 * 根据折让类别 获得  整理好的 类别 
	 * @param discountTypes
	 * @return
	 */
	private String getDiscountTypes(List<String> discountTypes) {
		if(discountTypes == null || discountTypes.size() == 0){
			return "()";
		}
		
		StringBuilder result = new StringBuilder("(");
		
		for(int i =0; i < discountTypes.size(); i++){
			
			result.append("'");
			result.append(discountTypes.get(i));
			result.append("',");
			
		}
		
		String resultStr = result.toString();
		resultStr= resultStr.substring(0, resultStr.length()-1 );
		resultStr = resultStr+")";
			
		return resultStr;
	}
	/**
	 *  根据客户 获得  整理后的    客户id，     格式：   ('','','','')
	 */
	private String getCustomerIDs(List<CustomerInfo> customers) {
		if(customers == null || customers.size() == 0){
			return "()";
		}
		
		StringBuilder result = new StringBuilder("(");
		
		for(int i =0; i < customers.size(); i++){
			
			result.append("'");
			result.append(customers.get(i).getId().toString());
			result.append("',");
			
		}
		
		String resultStr = result.toString();
		resultStr= resultStr.substring(0, resultStr.length() -1);
		resultStr = resultStr+")";
			
		return resultStr;
	}
	/**
	 * 折让记录单生成 收款单
	 */
	@Override
	protected boolean _generateReceiveBills(Context ctx, String companyID,
			Map receivRecords) throws BOSException {
		Map<String,List<DiscountRecordBillInfo>> toReceiveBills = receivRecords;
		Set<String> keySet = toReceiveBills.keySet();
		Iterator<String> keyIte = keySet.iterator();
		// 公司 折让设置
		DiscountCompanyInfo disComSetInfo = _getCompanyDSSet(ctx,companyID);
		if(disComSetInfo == null){
			throw new BOSException("未找到对应组织的 折让设置，不能生成折让记录单");
		}
		// 获得生成收款单的 botpid
		String discountRecBillBotpID = getToReceiveBillID(ctx,disComSetInfo);
		while(keyIte.hasNext()){
			List<DiscountRecordBillInfo> recordBills = toReceiveBills.get(keyIte.next());
			ReceivingBillCollection receivingCol = new ReceivingBillCollection();
			
			try{
				
				IObjectPK botpPK = new ObjectUuidPK(discountRecBillBotpID);
				CoreBillBaseCollection srcBillCollection = new CoreBillBaseCollection();
				
				for(int i = 0; i < recordBills.size(); i++){
					
					DiscountRecordBillInfo recordBill = recordBills.get(i);
					
					recordBill = DiscountRecordBillFactory.getLocalInstance(ctx).getDiscountRecordBillInfo(new ObjectUuidPK(recordBill.getId()));
					// 如果已经有 下游单据  则  不再生成
					if(!AppCommon.existDestBill(ctx, recordBill.getBOSType().toString(), recordBill.getId().toString())){
						srcBillCollection.add(recordBill);
					}
				}
							
				BOTMappingInfo botMappingInfo = BOTMappingFactory.getLocalInstance(ctx).getMappingInfoByPK(botpPK);
				if(botMappingInfo != null){
					
					IObjectCollection objColl = AppCommonUtil.generateDestBill(ctx,
								"BB4F0454", 
								"FA44FD5B",
								srcBillCollection,DefineSysEnum.BTP, 
								botpPK);
								
				}
			}catch(Exception easbiz){
				throw new BOSException("生成收款单出错",easbiz);
			}
		}
		return true;
	}
	
	/**
	 * 获得从折让记录单到 收款单的  botpid
	 * @param ctx
	 * @return
	 * @throws BOSException 
	 */
	private String getToReceiveBillID(Context ctx,DiscountCompanyInfo disComSetInfo) throws BOSException {
		if(StringUtils.isBlank(disComSetInfo.getRecordToReceivingBotp())){
			throw new BOSException("当前公司没有设置折让记录单生成收款单BOTP编码，请联系管理员添加");
		}
		String sql = "select t.fid from t_bot_mapping t inner join t_bot_extMapping te on t.fextMappingID = te.fid where te.fiseffected=1 and t.fname ='" + StringUtils.trim(disComSetInfo.getRecordToReceivingBotp())+"'";
		IRowSet rs = DbUtil.executeQuery(ctx, sql);
		
		try{
			while(rs.next()){
				String fid = rs.getString("fid");
				
				return fid;
			}
		}catch(SQLException sqle){
			throw new BOSException("查询生成收款单botp内码时出错",sqle);
		}
		return "";
	}
	/**
	 * 根据单据编号和原单据类型 判断是否 有下游单据
	 */
	@Override
	protected boolean _isExistDestBill(Context ctx, String srcBillID,
			String SrcBosType) throws BOSException {
		return AppCommonUtil.existDestBill(ctx, SrcBosType, srcBillID);
	}
	/**
	 * 对指定的 政策明细   校验是否存在其他政策的 明细与之重复 
	 */
	protected boolean _isExistDSInfos(Context ctx, String customerID,
			String materialID, String dsType, String dsNameType,
			String beginDate, String endDate, String dsInfoID)
			throws BOSException {
		StringBuilder sb = new StringBuilder();
		sb.append("select t.fid from CT_NDI_DiscountSet t inner join CT_NDI_DiscountSetEntry te on t.fid = te.fparentid ");
		sb.append("where t.FBlockedStatus = 1  and t.FCheckedStatus = 2 and te.CFLockedState=1 and t.FCustomerID ='");
		sb.append(customerID);
		sb.append("' and te.FMaterialID='");
		sb.append(materialID);
		sb.append("' and t.CFDiscountType='");
		sb.append(dsType);
		sb.append("' and t.CFDsNameType='");
		sb.append(dsNameType);
		sb.append("' and ((t.FEffectiveDate >= to_date('");
		sb.append(beginDate);
		sb.append("','yyyy-mm-dd') and t.FExpireDate<= to_date('");
		sb.append(beginDate);
		sb.append("','yyyy-mm-dd')) or  (t.FEffectiveDate >= to_date('");
		sb.append(endDate);
		sb.append("','yyyy-mm-dd') and t.FExpireDate<= to_date('");
		sb.append(endDate);
		sb.append("','yyyy-mm-dd')))  ");
		if(StringUtils.isNotBlank(dsInfoID)){
			sb.append(" and t.fid != '");
			sb.append(dsInfoID);
			sb.append("' ");
		}
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			if(rs.next()){
				return true;
			}
		}catch(SQLException sqle){
			throw new BOSException("查询是否有重复设置的折让政策明细时出错",sqle);
		}
		
		return false;
	}
	/**
	 * 验证 指定的折让政策的所有分录 是否与其他政策的 设置重复 
	 */
	protected ResultInfo _isExistDSInfos(Context ctx, String discountSetID)
			throws BOSException {
		ResultInfo result = new ResultInfo();
		result.setSuccess(false);
		result.setMessage("还未开始校验，默认不存在重复");
		try{
			if(StringUtils.isNotBlank(discountSetID)){
				DiscountSetInfo dsInfo = DiscountSetFactory.getLocalInstance(ctx).getDiscountSetInfo(new ObjectUuidPK(discountSetID));
				
				DsNameTypeEnum dsNameType = dsInfo.getDsNameType();
				DiscountTypeEnum dsType = dsInfo.getDiscountType();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date beginDate = dsInfo.getEffectiveDate();
				Date endDate = dsInfo.getExpireDate();
				// 逐条分录校验
				DiscountSetEntryCollection  entrys = dsInfo.getEntries();
				for(int i = 0; i < entrys.size(); i++){
					DiscountSetEntryInfo dsEntryInfo = entrys.get(i);
					dsEntryInfo = DiscountSetEntryFactory.getLocalInstance(ctx).getDiscountSetEntryInfo(new ObjectUuidPK(dsEntryInfo.getId()));
					
					CustomerInfo customerInfo = dsEntryInfo.getCustomer();
					MaterialInfo materialInfo = dsEntryInfo.getMaterial();
					
					// 未禁用的分录才校验
					if(com.kingdee.eas.custom.salediscount.EntryState.UnLocked.equals(dsEntryInfo.getLockedState())){
						boolean entryState  = this._isExistDSInfos(ctx, 
								customerInfo.getId().toString(), 
								materialInfo.getId().toString(), 
								dsType.getValue(),
								dsNameType.getValue(),
								sdf.format(beginDate), 
								sdf.format(endDate), 
								dsInfo.getId().toString());
						
						if(entryState){
							result.setSuccess(true);
							result.setMessage("编号" + dsInfo.getNumber() + "的政策的第" + (i+1) + "行分录与系统中已经启动的政策重复");
							return result;
						}
					}
					
				}
				
			}
		}catch(EASBizException easbize){
			throw new BOSException("校验政策是否重复时，获取政策详细信息出错",easbize);
		}
		
		result.setSuccess(false);
		result.setMessage("不存在重复的政策");
		return result;
	}
	

	protected MaterialSalesInfo _getSalesInfo(Context ctx, String matid, String ouid)
	  throws BOSException, EASBizException
	{
	  EntityViewInfo viewInfo = new EntityViewInfo();
//	  FilterInfo filterinfo = MaterialControllerBean.getFilterOUMaterial(ctx, "orgUnit.id", ouid, "material.id", matid);

	   FilterInfo filterinfo = new FilterInfo();

	   filterinfo.getFilterItems().add(new FilterItemInfo("material.id", matid, CompareType.EQUALS));
	   filterinfo.getFilterItems().add(new FilterItemInfo("orgUnit.id", ouid, CompareType.EQUALS));

	  viewInfo.setFilter(filterinfo);
//	  getSalesSelectors(viewInfo.getSelector());

	  MaterialSalesCollection con = MaterialSalesFactory.getLocalInstance(ctx).getMaterialSalesCollection(viewInfo);

	  if ((con != null) && (con.size() >= 1))
	  {
	    int i = 0; if (i < con.size())
	    {
	      MaterialSalesInfo info = con.get(i);
	      if (info.getOrgUnit().getId().toString().equals(ouid));

	      return info;
	    }

	    return con.get(0);

	  }

	  MaterialSalesInfo info = null;


	  return info;
	}
	/**
	 * 获取 制定公司指定物料的库存
	 */
	protected MaterialInventoryInfo _getInventoryInfo(Context ctx, String matid, String ouid) throws BOSException {
		return AppCommonUtil._getInventoryInfo(ctx,matid,ouid);
	}
	/**
	 * 获取制定物料的销售资料
	 */
	protected MaterialSalesInfo _getMaterialSaleinfo(Context ctx, String materialID, String companyID)
			throws BOSException {
	     EntityViewInfo viewInfo = new EntityViewInfo();
	     
	     FilterInfo filterinfo = new FilterInfo();
	     filterinfo.getFilterItems().add(new FilterItemInfo("orgUnit.id", companyID,CompareType.EQUALS));
	     filterinfo.getFilterItems().add(new FilterItemInfo("material.id", materialID,CompareType.EQUALS));
	     viewInfo.setFilter(filterinfo);
	     
	 
	     MaterialSalesCollection con = MaterialSalesFactory.getLocalInstance(ctx).getMaterialSalesCollection(viewInfo);
	 
	     if ((con != null) && (con.size() >= 1))
	     {
	       int i = 0; if (i < con.size())
	       {
	         MaterialSalesInfo info = con.get(i);
	         if (info.getOrgUnit().getId().toString().equals(companyID));
	         return info;
	       }
	 
	       return con.get(0);
	     }
	 
	     MaterialSalesInfo info = null;
	 
	     return info;
	}
	/**
	 * 获取指定 物料分组的 长编码
	 * @param ctx
	 * @param materialGroupID
	 * @return
	 * @throws BOSException 
	 */
	private String getMaterialGroupLongNumber(Context ctx,String materialGroupID) throws BOSException{
		
		String gsql = "select FLongNumber from T_BD_MaterialGroup where fid =? ";
		Object[] args = {materialGroupID};
		String groupLongNumber = "";
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, gsql,args);
			if(rs.next()){
				groupLongNumber = rs.getString("FLongNumber");
				return groupLongNumber;
			}
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		}
		
		return null;
	}
	/**
	 * 获得客户在指定公司特定时间内某种物料分类的销量合计
	 */
	@Override
	protected BigDecimal _getCusMaterialGroupSaleBaseQty(Context ctx,
			String companyID, String customerID, String groupLongNumber,String materialID,
			Date accumulateBeginDate, Date accumulateEndDate, Date billBizDate)
			throws BOSException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(accumulateBeginDate == null || accumulateEndDate == null){
			return null;
		}
		
		String beginDateStr = sdf.format(accumulateBeginDate);
		String endDateStr = sdf.format(accumulateEndDate);
		String billDateStr = sdf.format(billBizDate);
		
		try{
			
		// 销售组存在时  汇总金额
//			if(StringUtils.isNotBlank(groupLongNumber)){
				StringBuilder sb = new StringBuilder("/*dialect*/");
				sb.append(" select sum(te.cfnodsqty) allBaseQty from ");
				sb.append(" t_sd_saleorder t inner join t_sd_saleorderentry te on t.fid = te.fparentid ");
				sb.append(" inner join t_bd_material tm on te.fmaterialid = tm.fid ");
				sb.append(" inner join T_BD_MaterialGroup tmg on tm.FMaterialGroupID = tmg.fid ");
				
				sb.append(" where (te.FIsPresent = 0 or te.fispresent is null) and t.fbasestatus in(4,7) ");
				if(StringUtils.isNotBlank(groupLongNumber)){
					sb.append(" and tmg.flongnumber like '");
					sb.append(groupLongNumber);
					sb.append("%' ");
				}
				if(StringUtils.isNotBlank(materialID)){
					sb.append(" and tm.fid = '");
					sb.append(materialID);
					sb.append("' ");
				}
				sb.append(" and t.FSaleOrgUnitID ='");
				sb.append(companyID);
				sb.append("' and t.FOrderCustomerID ='");
				sb.append(customerID);
				sb.append("' ");
				sb.append(" and t.fbizdate >= to_date('");
				sb.append(beginDateStr);
				sb.append("','yyyy-mm-dd') and t.fbizdate <= to_date('");
				sb.append(endDateStr);
				sb.append(" 23:59:59','yyyy-MM-dd HH24:mi:ss') and  t.fbizdate <= to_date('");
				sb.append(billDateStr);
				sb.append(" 23:59:59','yyyy-MM-dd HH24:mi:ss') ");
				
				IRowSet qtySet = DbUtil.executeQuery(ctx, sb.toString());
				if(qtySet.next()){
					BigDecimal qty = qtySet.getBigDecimal("allBaseQty");
					return qty;
				}else{
					return new BigDecimal("0");
				}
//			}else{
//				return new BigDecimal("0");
//			}
		}catch(Exception e){
			e.printStackTrace();
			return new BigDecimal("0");
		}
	}
	/**
	 * 获得物料在指定 销售组织的  单包重
	 */
	@Override
	protected BigDecimal _getMaterialBagQty(Context ctx, String saleOrgUnitID,
			String materialID) throws BOSException {
		try{
			String sql = "select cfbagqty from T_BD_MaterialSales where FOrgUnit=? and FMaterialID=?";
			Object[] args = {saleOrgUnitID,materialID};
			IRowSet rs = DbUtil.executeQuery(ctx, sql, args);
			if(rs.next()){
				BigDecimal bagqty = rs.getBigDecimal("cfbagqty");
				return bagqty;
			}
			return null;
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		}
	}
	
	
	
	
	
}