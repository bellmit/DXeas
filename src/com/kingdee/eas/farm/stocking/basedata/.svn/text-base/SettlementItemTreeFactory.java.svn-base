package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettlementItemTreeFactory
{
    private SettlementItemTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.ISettlementItemTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISettlementItemTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A1567EAB") ,com.kingdee.eas.farm.stocking.basedata.ISettlementItemTree.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.ISettlementItemTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISettlementItemTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A1567EAB") ,com.kingdee.eas.farm.stocking.basedata.ISettlementItemTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.ISettlementItemTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISettlementItemTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A1567EAB"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.ISettlementItemTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ISettlementItemTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A1567EAB"));
    }
}