package com.kingdee.eas.farm.pig.app;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.pig.ImmuneMode;
import com.kingdee.eas.farm.pig.PigFarmFactory;
import com.kingdee.eas.farm.pig.PigFarmInfo;
import com.kingdee.eas.farm.pig.PigFarmType;
import com.kingdee.eas.farm.pig.immuneSourceType;
import com.kingdee.eas.farm.pig.bean.ImmunePlanDetailInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class pigBaseDataFacadeControllerBean extends AbstractpigBaseDataFacadeControllerBean
{
    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6969479602149182400L;
	
	private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.pig.app.pigBaseDataFacadeControllerBean");
    
    /**
     * 获得养殖场信息
     */
    protected PigFarmInfo _getPigfarm(Context ctx, String stoOrgID)throws BOSException
    {
    	try{
    		return PigFarmFactory.getLocalInstance(ctx).getPigFarmInfo("where stoOrgUnit.id ='"+stoOrgID+"'");
    		
    	}catch(EASBizException ease){
    		ease.printStackTrace();
    		throw new BOSException(ease);
    	}
    }

    /**
     * 获得指定的养殖场类型获得对应的 日常免疫计划
     */
	@Override
	protected List<ImmunePlanDetailInfo> _getDailyImmunePlans(Context ctx, String pigFarmType, Date bizdate)
			throws BOSException {
		List<ImmunePlanDetailInfo> result = new ArrayList<ImmunePlanDetailInfo>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfMM = new SimpleDateFormat("MM");
		SimpleDateFormat sdfDD = new SimpleDateFormat("dd");
		String yStr = sdf.format(bizdate);
		String mmStr = sdfMM.format(bizdate);
		String ddStr = sdfDD.format(bizdate);
		int mmddInt = 0;
		try{
			int mmInt = Integer.parseInt(mmStr);
			int ddInt = Integer.parseInt(ddStr);
			
			mmddInt = (mmInt*100) + ddInt;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		StringBuilder sql = new StringBuilder();
		sql.append("select t.fid,t.FPigFarmType,t.FActiveDate,t.FDisableDate,t.FImmuneBeginDate,");
		sql.append(" t.FImmuneEndDate,tm.fid materialID,tm.fnumber materialNumber,tm.fname_l2 materialName,");
		sql.append(" tu.fid unitID,tu.fnumber unitNumber,tu.fname_l2 unitName, t.FImmuneMode, t.FQty ");
		sql.append(" from T_PIG_DailyImmunePlan t ");
		sql.append(" inner join t_bd_material tm on t.FImmuneMaterialID = tm.fid ");
		sql.append(" inner join t_bd_measureunit tu on t.FUnitID = tu.fid ");
		sql.append(" where t.FDeletedStatus=1 and  ");
		sql.append(" ( t.FByPigFarmType = 0 or (t.FByPigFarmType = 1 and t.FPigFarmType ='");
		sql.append(pigFarmType);
		sql.append("')) and t.FActiveDate <= {ts '");
		sql.append(yStr);
		sql.append(" 23:59:59' }  and t.FDisableDate >= {ts '");
		sql.append(yStr);
		sql.append("'}  and (month(t.FImmuneBeginDate)*100 + dayofmonth(t.FImmuneBeginDate)) >= ");
		sql.append(mmddInt);
		sql.append(" and (month(t.FImmuneEndDate)*100 + dayofmonth(t.FImmuneEndDate)) >= ");
		sql.append(mmddInt);
		sql.append(" ");
		
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		try{
			while(rs.next()){
				
				String fid = rs.getString("fid");
				String FPigFarmType = rs.getString("FPigFarmType");
				Date FActiveDate = rs.getDate("FActiveDate");
				Date FDisableDate = rs.getDate("FDisableDate");
				Date FImmuneBeginDate = rs.getDate("FImmuneBeginDate");
				Date FImmuneEndDate = rs.getDate("FImmuneEndDate");
				String materialID = rs.getString("materialID");
				String materialNumber = rs.getString("materialNumber");
				String materialName = rs.getString("materialName");
				String unitID = rs.getString("unitID");
				String unitNumber = rs.getString("unitNumber");
				String unitName = rs.getString("unitName");
				String FImmuneMode = rs.getString("FImmuneMode");
				BigDecimal FQty = rs.getBigDecimal("FQty");
				
				
				ImmunePlanDetailInfo detailInfo = new ImmunePlanDetailInfo();
				MaterialInfo materialInfo = new MaterialInfo();
				MeasureUnitInfo unitInfo = new MeasureUnitInfo();
				
				// 疫苗
				materialInfo.setId(BOSUuid.read(materialID));
				materialInfo.setNumber(materialNumber);
				materialInfo.setName(materialName);
				// 计量单位
				unitInfo.setId(BOSUuid.read(unitID));
				unitInfo.setNumber(unitNumber);
				unitInfo.setName(unitName);
				// 设置明细信息
				detailInfo.setSourceEntryID(fid);
				detailInfo.setActiveDate(FActiveDate);
				detailInfo.setDisableDate(FDisableDate);
				detailInfo.setImmuneBeginDate(FImmuneBeginDate);
				detailInfo.setImmuneEndDate(FImmuneEndDate);
				detailInfo.setImmuneMaterial(materialInfo);
				detailInfo.setImmuneMode(ImmuneMode.getEnum(FImmuneMode));
				detailInfo.setPigFarmType(PigFarmType.getEnum(FPigFarmType));
				detailInfo.setQtyPer(FQty);
				detailInfo.setUnit(unitInfo);
				detailInfo.setSourceType(immuneSourceType.DailyImmune);
				result.add(detailInfo);
			}
		}catch(SQLException sqle){
			logger.error(sqle.getMessage());
			throw new BOSException(sqle);
		}
		return result;
	}
    
     
    
}