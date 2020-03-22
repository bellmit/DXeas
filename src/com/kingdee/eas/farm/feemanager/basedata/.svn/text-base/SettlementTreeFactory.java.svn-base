package com.kingdee.eas.farm.feemanager.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettlementTreeFactory
{
    private SettlementTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.feemanager.basedata.ISettlementTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ISettlementTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("6B65AF13") ,com.kingdee.eas.farm.feemanager.basedata.ISettlementTree.class);
    }
    
    public static com.kingdee.eas.farm.feemanager.basedata.ISettlementTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ISettlementTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("6B65AF13") ,com.kingdee.eas.farm.feemanager.basedata.ISettlementTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feemanager.basedata.ISettlementTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ISettlementTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("6B65AF13"));
    }
    public static com.kingdee.eas.farm.feemanager.basedata.ISettlementTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ISettlementTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("6B65AF13"));
    }
}