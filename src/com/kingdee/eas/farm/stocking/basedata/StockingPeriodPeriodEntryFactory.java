package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StockingPeriodPeriodEntryFactory
{
    private StockingPeriodPeriodEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStockingPeriodPeriodEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingPeriodPeriodEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EE943CD3") ,com.kingdee.eas.farm.stocking.basedata.IStockingPeriodPeriodEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IStockingPeriodPeriodEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingPeriodPeriodEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EE943CD3") ,com.kingdee.eas.farm.stocking.basedata.IStockingPeriodPeriodEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStockingPeriodPeriodEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingPeriodPeriodEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EE943CD3"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStockingPeriodPeriodEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingPeriodPeriodEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EE943CD3"));
    }
}