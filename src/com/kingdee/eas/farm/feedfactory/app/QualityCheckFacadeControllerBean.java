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
     * ��ȡָ�����ϵ��ʼ��׼
     * ���ָ��������������֯�ж�� ��׼�� �����׼  �� ���� ��ʾ�û��޸�
     * TODO  Ŀǰ��ʽ���ܳ��  ��ʱ��ĳ�  ��һsqlһ�β�ѯ �����������
     */
	@Override
	protected QCStandardInfo _getMaterialCheckStandard(Context ctx,
			String checkOrgUnitID, String materialID) throws BOSException {
		// ��� ������֯id
		String searchOrgID = checkOrgUnitID;
		FeedFactoryBaseDataInfo baseDataInfo = TruckPlanFacadeFactory.getLocalInstance(ctx).getFeedFactoryBaseData();
		if(baseDataInfo != null && baseDataInfo.getQcOrgUnit() != null){
			searchOrgID = baseDataInfo.getQcOrgUnit().getId().toString();
		}
		
		
		// �������ϲ�ѯ��������״̬���ʼ��׼
		String sql = "select distinct t.fid from T_QM_QCStandard t inner join T_QM_QCStandardMaterialEntries tme on t.fid = tme.FParentID inner join T_QM_DataBaseDAssign ts on t.fid = ts.fdatabasedid  where tme.FMaterialID=? and ts.FASSIGNORGUNITID=? and t.FCheckedStatus=2 and t.FDeletedStatus = 1 ";
		Object[] args = {materialID,searchOrgID};
		IRowSet rs = DbUtil.executeQuery(ctx, sql, args);
//		if(rs.size() < 1){
////			throw new BOSException("��ǰ���������ϳ�û�к�׼��Ĭ�ϼ����׼");
//			return null;
//		}
		if(rs.size() >1 ){
			throw new BOSException("��ǰ���������ϳ����õļ����׼����һ����������ά�������׼��");
		}
		try{
			if(rs.next()){
				String standardID = rs.getString("fid");
				QCStandardInfo standardInfo = QCStandardFactory.getLocalInstance(ctx).getQCStandardInfo(new ObjectUuidPK(standardID));
				// ��ȡ������Ŀ
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