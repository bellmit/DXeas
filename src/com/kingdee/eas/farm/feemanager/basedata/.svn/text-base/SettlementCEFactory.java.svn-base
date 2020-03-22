package com.kingdee.eas.farm.feemanager.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettlementCEFactory
{
    private SettlementCEFactory()
    {
    }
    public static com.kingdee.eas.farm.feemanager.basedata.ISettlementCE getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ISettlementCE)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B541A0F7") ,com.kingdee.eas.farm.feemanager.basedata.ISettlementCE.class);
    }
    
    public static com.kingdee.eas.farm.feemanager.basedata.ISettlementCE getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ISettlementCE)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B541A0F7") ,com.kingdee.eas.farm.feemanager.basedata.ISettlementCE.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feemanager.basedata.ISettlementCE getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ISettlementCE)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B541A0F7"));
    }
    public static com.kingdee.eas.farm.feemanager.basedata.ISettlementCE getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ISettlementCE)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B541A0F7"));
    }
}