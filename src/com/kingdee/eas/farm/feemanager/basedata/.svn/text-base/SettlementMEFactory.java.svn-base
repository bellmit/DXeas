package com.kingdee.eas.farm.feemanager.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettlementMEFactory
{
    private SettlementMEFactory()
    {
    }
    public static com.kingdee.eas.farm.feemanager.basedata.ISettlementME getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ISettlementME)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B541A22D") ,com.kingdee.eas.farm.feemanager.basedata.ISettlementME.class);
    }
    
    public static com.kingdee.eas.farm.feemanager.basedata.ISettlementME getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ISettlementME)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B541A22D") ,com.kingdee.eas.farm.feemanager.basedata.ISettlementME.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feemanager.basedata.ISettlementME getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ISettlementME)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B541A22D"));
    }
    public static com.kingdee.eas.farm.feemanager.basedata.ISettlementME getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ISettlementME)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B541A22D"));
    }
}