package com.kingdee.eas.farm.stocking.webservice;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDaily;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDaily;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyFactory;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class StockingUpDStockFacadeControllerBean extends AbstractStockingUpDStockFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.stocking.webservice.StockingUpDStockFacadeControllerBean");
    protected void _reShareCoalAndDiesel(Context ctx)throws BOSException, EASBizException
    {
    	
    	IRowSet rs = DbUtil.executeQuery(ctx,"select FID from T_FM_StockingBatch where FAllOutDate is null and  FIsAllOut=0");
    	IStockingBreedDaily localInstance = StockingBreedDailyFactory.getLocalInstance(ctx);
    	try {
			while(rs.next()){
				localInstance.recalStockingByBatchID(rs.getString("FID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}