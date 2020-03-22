package com.kingdee.eas.custom.eas2temp.comm;

import java.math.BigDecimal;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.assistant.IMeasureUnit;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.common.EASBizException;

public class MeasureUnitUtils {
	
	/**
	 * 两个计量单位之间数量的换算
	 * @param srcUnitInfo
	 * @param destUnitInfo
	 * @param srcQty
	 * @return
	 * @throws BOSException
	 * @throws EASBizException 
	 */
	public static BigDecimal getUnitQtyByUnit(Context ctx,MeasureUnitInfo srcUnitInfo,MeasureUnitInfo destUnitInfo,BigDecimal srcQty) throws BOSException, EASBizException {
		BigDecimal destQty=BigDecimal.ZERO;
		if(srcUnitInfo==null||destUnitInfo==null||srcQty==null) {
			return destQty;
		}
		IMeasureUnit is = null;
		if(ctx==null)
			is=MeasureUnitFactory.getRemoteInstance();
		else
			is=MeasureUnitFactory.getLocalInstance(ctx);
		srcUnitInfo=is.getMeasureUnitInfo(new ObjectUuidPK(srcUnitInfo.getId()));
		destUnitInfo=is.getMeasureUnitInfo(new ObjectUuidPK(destUnitInfo.getId()));
		//非同一计量单位分组
		if(!srcUnitInfo.getMeasureUnitGroup().getId().equals(destUnitInfo.getMeasureUnitGroup().getId())) {
			return destQty;
		}
		try{
			BigDecimal srcCoef=srcUnitInfo.getCoefficient();
			BigDecimal destCoef=destUnitInfo.getCoefficient();
			destQty=srcQty.multiply(destCoef).divide(srcCoef,4,BigDecimal.ROUND_HALF_UP);
		}catch(Exception e){
			throw new BOSException(e);
		}
		return destQty;
	}
	
	/**
	 * 两个计量单位之间数量的换算 系统
	 * @param srcUnitInfo
	 * @param destUnitInfo
	 * @param srcQty
	 * @return
	 * @throws BOSException
	 * @throws EASBizException 
	 */
	public static BigDecimal getUnitRateByUnit(Context ctx,MeasureUnitInfo srcUnitInfo,MeasureUnitInfo destUnitInfo) throws BOSException, EASBizException {
		BigDecimal destQty=BigDecimal.ZERO;
		if(srcUnitInfo==null||destUnitInfo==null) {
			return destQty;
		}
		IMeasureUnit is = null;
		if(ctx==null)
			is=MeasureUnitFactory.getRemoteInstance();
		else
			is=MeasureUnitFactory.getLocalInstance(ctx);
		srcUnitInfo=is.getMeasureUnitInfo(new ObjectUuidPK(srcUnitInfo.getId()));
		destUnitInfo=is.getMeasureUnitInfo(new ObjectUuidPK(destUnitInfo.getId()));
		//非同一计量单位分组
		if(!srcUnitInfo.getMeasureUnitGroup().getId().equals(destUnitInfo.getMeasureUnitGroup().getId())) {
			return destQty;
		}
		BigDecimal destCoef=BigDecimal.ZERO;
		try{
			BigDecimal srcCoef=srcUnitInfo.getCoefficient();
			destCoef=destUnitInfo.getCoefficient();
			destCoef=destCoef.divide(srcCoef,4,BigDecimal.ROUND_HALF_UP);
		}catch(Exception e){
			throw new BOSException(e);
		}
		return destCoef;
	}
}
