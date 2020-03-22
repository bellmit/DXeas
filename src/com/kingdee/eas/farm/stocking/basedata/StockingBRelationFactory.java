package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StockingBRelationFactory
{
    private StockingBRelationFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStockingBRelation getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingBRelation)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("424919A1") ,com.kingdee.eas.farm.stocking.basedata.IStockingBRelation.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IStockingBRelation getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingBRelation)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("424919A1") ,com.kingdee.eas.farm.stocking.basedata.IStockingBRelation.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStockingBRelation getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingBRelation)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("424919A1"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStockingBRelation getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingBRelation)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("424919A1"));
    }
}