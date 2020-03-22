package com.kingdee.eas.custom.settlebill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettleBillFactory
{
    private SettleBillFactory()
    {
    }
    public static com.kingdee.eas.custom.settlebill.ISettleBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2B689EA3") ,com.kingdee.eas.custom.settlebill.ISettleBill.class);
    }
    
    public static com.kingdee.eas.custom.settlebill.ISettleBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2B689EA3") ,com.kingdee.eas.custom.settlebill.ISettleBill.class, objectCtx);
    }
    public static com.kingdee.eas.custom.settlebill.ISettleBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2B689EA3"));
    }
    public static com.kingdee.eas.custom.settlebill.ISettleBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2B689EA3"));
    }
}