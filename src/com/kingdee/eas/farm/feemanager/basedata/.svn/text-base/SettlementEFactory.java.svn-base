package com.kingdee.eas.farm.feemanager.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettlementEFactory
{
    private SettlementEFactory()
    {
    }
    public static com.kingdee.eas.farm.feemanager.basedata.ISettlementE getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ISettlementE)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("DC8E8110") ,com.kingdee.eas.farm.feemanager.basedata.ISettlementE.class);
    }
    
    public static com.kingdee.eas.farm.feemanager.basedata.ISettlementE getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ISettlementE)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("DC8E8110") ,com.kingdee.eas.farm.feemanager.basedata.ISettlementE.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feemanager.basedata.ISettlementE getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ISettlementE)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("DC8E8110"));
    }
    public static com.kingdee.eas.farm.feemanager.basedata.ISettlementE getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ISettlementE)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("DC8E8110"));
    }
}