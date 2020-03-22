package com.kingdee.eas.custom.dx.weight;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettleBillFactory
{
    private SettleBillFactory()
    {
    }
    public static com.kingdee.eas.custom.dx.weight.ISettleBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.ISettleBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("89940253") ,com.kingdee.eas.custom.dx.weight.ISettleBill.class);
    }
    
    public static com.kingdee.eas.custom.dx.weight.ISettleBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.ISettleBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("89940253") ,com.kingdee.eas.custom.dx.weight.ISettleBill.class, objectCtx);
    }
    public static com.kingdee.eas.custom.dx.weight.ISettleBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.ISettleBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("89940253"));
    }
    public static com.kingdee.eas.custom.dx.weight.ISettleBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.ISettleBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("89940253"));
    }
}