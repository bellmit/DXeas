package com.kingdee.eas.custom.settlebill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettleBillOtherEntryFactory
{
    private SettleBillOtherEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.settlebill.ISettleBillOtherEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleBillOtherEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("67DD4E45") ,com.kingdee.eas.custom.settlebill.ISettleBillOtherEntry.class);
    }
    
    public static com.kingdee.eas.custom.settlebill.ISettleBillOtherEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleBillOtherEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("67DD4E45") ,com.kingdee.eas.custom.settlebill.ISettleBillOtherEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.settlebill.ISettleBillOtherEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleBillOtherEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("67DD4E45"));
    }
    public static com.kingdee.eas.custom.settlebill.ISettleBillOtherEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleBillOtherEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("67DD4E45"));
    }
}