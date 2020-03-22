package com.kingdee.eas.farm.feemanager.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettlementFactory
{
    private SettlementFactory()
    {
    }
    public static com.kingdee.eas.farm.feemanager.basedata.ISettlement getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ISettlement)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B488B9D5") ,com.kingdee.eas.farm.feemanager.basedata.ISettlement.class);
    }
    
    public static com.kingdee.eas.farm.feemanager.basedata.ISettlement getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ISettlement)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B488B9D5") ,com.kingdee.eas.farm.feemanager.basedata.ISettlement.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feemanager.basedata.ISettlement getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ISettlement)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B488B9D5"));
    }
    public static com.kingdee.eas.farm.feemanager.basedata.ISettlement getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ISettlement)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B488B9D5"));
    }
}