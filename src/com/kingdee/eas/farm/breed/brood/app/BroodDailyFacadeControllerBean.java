package com.kingdee.eas.farm.breed.brood.app;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.brood.BroodCoopSetFactory;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class BroodDailyFacadeControllerBean extends AbstractBroodDailyFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.breed.brood.app.BroodDailyFacadeControllerBean");

    /**
     * ���� �����֯id�Ͳֿ�id��� ���� ��������
     */
    @Override
	protected Object _getBroodCoopSet(Context ctx, String henhouseID) throws BOSException {
		String sql = "select fid from CT_FM_BroodCoopSet where CFHenhouseID =?  ";
		String[] args = {henhouseID};
		
		try{
			IRowSet rs  = DbUtil.executeQuery(ctx, sql, args);
			if(rs.next()){
				String fid = rs.getString("fid");
				
				return BroodCoopSetFactory.getLocalInstance(ctx).getBroodCoopSetInfo(new ObjectUuidPK(fid));
				
			}
			
			return null;
		}catch(SQLException sqle){
			throw new BOSException(sqle);
		} catch (EASBizException e) {
//			e.printStackTrace();
			throw new BOSException(e);
		}
	}

	
    
}