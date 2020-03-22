package com.kingdee.eas.farm.stocking.basedata.app;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class CoProductPriceTreeControllerBean extends AbstractCoProductPriceTreeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.stocking.basedata.app.CoProductPriceTreeControllerBean");
    
    @Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select count(*) FCount from T_FM_CoProductPrice where FTreeID='").append(pk.toString()).append("'");
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()&&rs.getInt("Fcount")>0) {
				throw new EASBizException(new NumericExceptionSubItem("001","该节点下面已有基础资料，禁止删除！"));
			}
		}catch(SQLException err) {
			err.printStackTrace();
		}
		super._delete(ctx, pk);
	}
}