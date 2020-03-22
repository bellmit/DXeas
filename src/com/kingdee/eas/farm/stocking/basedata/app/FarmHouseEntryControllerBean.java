package com.kingdee.eas.farm.stocking.basedata.app;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class FarmHouseEntryControllerBean extends AbstractFarmHouseEntryControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseEntryControllerBean");

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		/*FarmHouseEntryInfo info = FarmHouseEntryFactory.getLocalInstance(ctx).getFarmHouseEntryInfo(pk);
		try{
			StringBuffer sql=new StringBuffer();
			sql.append(" select fid from t_fm_stockingBatch where fhouseID='").append(pk.toString()).append("'")
			.append(" union all")
			.append(" select fid from T_FM_BreedSeedBill where fhouseID='").append(pk.toString()).append("'")
			.append(" ");
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			if(rs.size()>0) {
				throw new Exception("棚舍"+info.getName()+"已经被使用，禁止删除");
			}
		}catch(Exception err){
			throw new EASBizException(new NumericExceptionSubItem("001",err.getMessage()));
		}*/
		super._delete(ctx, pk);
	}
    
    
}