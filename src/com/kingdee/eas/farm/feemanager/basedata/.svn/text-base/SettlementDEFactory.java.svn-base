package com.kingdee.eas.farm.feemanager.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettlementDEFactory
{
    private SettlementDEFactory()
    {
    }
    public static com.kingdee.eas.farm.feemanager.basedata.ISettlementDE getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ISettlementDE)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B541A116") ,com.kingdee.eas.farm.feemanager.basedata.ISettlementDE.class);
    }
    
    public static com.kingdee.eas.farm.feemanager.basedata.ISettlementDE getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ISettlementDE)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B541A116") ,com.kingdee.eas.farm.feemanager.basedata.ISettlementDE.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feemanager.basedata.ISettlementDE getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ISettlementDE)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B541A116"));
    }
    public static com.kingdee.eas.farm.feemanager.basedata.ISettlementDE getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ISettlementDE)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B541A116"));
    }
}