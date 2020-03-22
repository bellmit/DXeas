package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StockingBRelationTreeFactory
{
    private StockingBRelationTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStockingBRelationTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingBRelationTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("5F1948DF") ,com.kingdee.eas.farm.stocking.basedata.IStockingBRelationTree.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IStockingBRelationTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingBRelationTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("5F1948DF") ,com.kingdee.eas.farm.stocking.basedata.IStockingBRelationTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStockingBRelationTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingBRelationTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("5F1948DF"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IStockingBRelationTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IStockingBRelationTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("5F1948DF"));
    }
}