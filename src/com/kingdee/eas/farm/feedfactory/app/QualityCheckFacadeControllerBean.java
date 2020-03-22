package com.kingdee.eas.farm.feedfactory.app;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.feedfactory.FeedFactoryBaseDataInfo;
import com.kingdee.eas.farm.feedfactory.TruckPlanFacadeFactory;
import com.kingdee.eas.qm.basedata.IQCStandardItemEntry;
import com.kingdee.eas.qm.basedata.QCItemFactory;
import com.kingdee.eas.qm.basedata.QCItemInfo;
import com.kingdee.eas.qm.basedata.QCStandardFactory;
import com.kingdee.eas.qm.basedata.QCStandardInfo;
import com.kingdee.eas.qm.basedata.QCStandardItemEntryFactory;
import com.kingdee.eas.qm.basedata.QCStandardItemEntryInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class QualityCheckFacadeControllerBean extends AbstractQualityCheckFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.feedfactory.app.QualityCheckFacadeControllerBean");

    /**
     * 获取指定物料的质检标准
     * 如果指定物料在所在组织有多个 核准的 检验标准  则 报错 提示用户修改
     * TODO  目前方式性能超差，  有时间改成  单一sql一次查询 查出所有数据
     */
	@Override
	protected QCStandardInfo _getMaterialCheckStandard(Context ctx,
			String checkOrgUnitID, String materialID) throws BOSException {
		// 获得 检验组织id
		String searchOrgID = checkOrgUnitID;
		FeedFactoryBaseDataInfo baseDataInfo = TruckPlanFacadeFactory.getLocalInstance(ctx).getFeedFactoryBaseData();
		if(baseDataInfo != null && baseDataInfo.getQcOrgUnit() != null){
			searchOrgID = baseDataInfo.getQcOrgUnit().getId().toString();
		}
		
		
		// 根据物料查询所有启用状态的质检标准
		String sql = "select distinct t.fid from T_QM_QCStandard t inner join T_QM_QCStandardMaterialEntries tme on t.fid = tme.FParentID inner join T_QM_DataBaseDAssign ts on t.fid = ts.fdatabasedid  where tme.FMaterialID=? and ts.FASSIGNORGUNITID=? and t.FCheckedStatus=2 and t.FDeletedStatus = 1 ";
		Object[] args = {materialID,searchOrgID};
		IRowSet rs = DbUtil.executeQuery(ctx, sql, args);
//		if(rs.size() < 1){
////			throw new BOSException("当前物料在饲料厂没有核准的默认检验标准");
//			return null;
//		}
		if(rs.size() >1 ){
			throw new BOSException("当前物料在饲料厂设置的检验标准多于一条，请重新维护检验标准。");
		}
		try{
			if(rs.next()){
				String standardID = rs.getString("fid");
				QCStandardInfo standardInfo = QCStandardFactory.getLocalInstance(ctx).getQCStandardInfo(new ObjectUuidPK(standardID));
				// 获取检验项目
				String eSql = "select fid from T_QM_QCStandardItemEntries where fparentid = ?";
				Object[] eArgs = {standardID};
				IRowSet eRs = DbUtil.executeQuery(ctx, eSql,eArgs);
				
				IQCStandardItemEntry iEntry = QCStandardItemEntryFactory.getLocalInstance(ctx);
				while(eRs.next()){
					String fid = eRs.getString("fid");
					QCStandardItemEntryInfo itemEntryInfo = iEntry.getQCStandardItemEntryInfo(new ObjectUuidPK(fid));
					if(itemEntryInfo.getQCItem() != null && itemEntryInfo.getQCItem().getName() == null){
						QCItemInfo itemInfo = QCItemFactory.getLocalInstance(ctx).getQCItemInfo(new ObjectUuidPK(itemEntryInfo.getQCItem().getId()));
						itemEntryInfo.setQCItem(itemInfo);
					}
					if(itemEntryInfo.getUnit() != null && itemEntryInfo.getUnit().getName() == null){
						MeasureUnitInfo unitInfo = MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(new ObjectUuidPK(itemEntryInfo.getUnit().getId()));
						itemEntryInfo.setUnit(unitInfo);
					}
					standardInfo.getItemEntries().add(itemEntryInfo);
					
				}
				return standardInfo;
			}else{
				return null;
			}
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		} catch (EASBizException e) {
			
			e.printStackTrace();
			throw new BOSException(e);
		}
	}
}