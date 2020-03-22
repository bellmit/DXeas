package com.kingdee.eas.wlhlcomm.app;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.param.ParamControlFactory;
import com.kingdee.eas.basedata.assistant.CurrencyInfo;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.MaterialSalesFactory;
import com.kingdee.eas.basedata.master.material.MaterialSalesInfo;
import com.kingdee.eas.basedata.org.SaleOrgUnitInfo;
import com.kingdee.eas.basedata.scm.sd.sale.IPriceProvider;
import com.kingdee.eas.basedata.scm.sd.sale.MaterialBasePriceInfo;
import com.kingdee.eas.basedata.scm.sd.sale.PriceCondition;
import com.kingdee.eas.basedata.scm.sd.sale.PriceProviderFactory;
import com.kingdee.eas.basedata.scm.sd.sale.SalePriceTO;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.scm.common.SCMBillCommonFacadeFactory;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class SalePriceFacadeControllerBean extends AbstractSalePriceFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.wlhlcomm.app.SalePriceFacadeControllerBean");

    /**
     * 获取物料基本价格
     */
	@Override
	protected BigDecimal _getMaterialBasePrice(Context ctx, String adminCUid,
			String materialID, String unitID) throws BOSException {
		

		String sql = "select fprice from T_SD_MaterialBasePrice where FCheckedStatus = '2' and FBlockedStatus = '1' and FAdminCUID=? and FMaterialID=? and FUnitID=? ";
		Object[] args = {adminCUid,materialID,unitID};
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
		return null;
	
	}

	/**
	 * 获取物料 价格政策价格
	 */
	@Override
	protected BigDecimal _getMaterialPolicyPrice(Context ctx, String companyID,
			String customerID, String materialID, String bizDateStr,
			BigDecimal orderQty, String unitID) throws BOSException {

		try{
			MeasureUnitInfo unitInfo = MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(new ObjectUuidPK(unitID));
			BigDecimal unitrate = unitInfo.getCoefficient();
			// 首先从 公司物料 中取得 物料的  销售单位
			MaterialSalesInfo msData = MaterialSalesFactory.getLocalInstance(ctx).getSalesInfo(materialID, companyID);
			if(msData != null){
//				
				
				PriceCondition priceCondition = getPriceCondition(ctx, companyID, customerID, materialID, unitInfo,bizDateStr,orderQty);
				IPriceProvider iPriceProvider = PriceProviderFactory.getLocalInstance(ctx);
				List priceList = iPriceProvider.fetchPrices(priceCondition);
				// 价格政策 存在则直接返回
				if(priceList != null && priceList.size() > 0){
					SalePriceTO basePriceTO = (SalePriceTO)priceList.get(0);
					if(basePriceTO != null){
						return basePriceTO.price;
					}
				}else {
					// 取物料销售资料的单位价格 然后换算
					MeasureUnitInfo saleUnitInfo = msData.getUnit();
					saleUnitInfo = MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(new ObjectUuidPK(saleUnitInfo.getId()));
					
					priceCondition = getPriceCondition(ctx, companyID, customerID, materialID, saleUnitInfo,bizDateStr,orderQty);
					iPriceProvider = PriceProviderFactory.getLocalInstance(ctx);
					priceList = iPriceProvider.fetchPrices(priceCondition);
					// 价格政策 存在则直接返回
					if(priceList != null && priceList.size() > 0){
						SalePriceTO basePriceTO = (SalePriceTO)priceList.get(0);
						if(basePriceTO != null){
							BigDecimal salePrice =  basePriceTO.price;
							BigDecimal salerate = saleUnitInfo.getCoefficient();
							
							
							
							return unitrate.multiply(salePrice).divide(salerate,6,BigDecimal.ROUND_HALF_UP);
							
						}
					}else{
					
						// 如果指定计量单位不存在 则查询 千克的 单价设置，然后换算成 计量单位的 单价 gw5fUwEOEADgAAsRwKgSOFuCXFc=
						MeasureUnitInfo baseUnitInfo = MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(new ObjectUuidPK("gw5fUwEOEADgAAsRwKgSOFuCXFc="));
						priceCondition = getPriceCondition(ctx, companyID, customerID, materialID, baseUnitInfo,bizDateStr,orderQty);
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
						BigDecimal baseUnitPrice = this._getMaterialBasePrice(ctx, companyID, materialID,"gw5fUwEOEADgAAsRwKgSOFuCXFc=");
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
		return super._getMaterialPolicyPrice(ctx, companyID,customerID, materialID,bizDateStr,orderQty,unitID);
	
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
    
}