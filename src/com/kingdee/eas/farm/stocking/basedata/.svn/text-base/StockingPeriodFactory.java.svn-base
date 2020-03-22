package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StockingPeriodFactory
{
    private StockingPeriodFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStockingPeriod getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingPeriod)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("264A037E") ,com.kingdee.eas.farm.stocking.basedata.IStockingPeriod.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IStockingPeriod getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingPeriod)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("264A037E") ,com.kingdee.eas.farm.stocking.basedata.IStockingPeriod.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStockingPeriod getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingPeriod)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("264A037E"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStockingPeriod getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingPeriod)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("264A037E"));
    }
}