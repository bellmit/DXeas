package com.kingdee.eas.custom.settlebill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SettleBillSubsidyFactory
{
    private SettleBillSubsidyFactory()
    {
    }
    public static com.kingdee.eas.custom.settlebill.ISettleBillSubsidy getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleBillSubsidy)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C1904788") ,com.kingdee.eas.custom.settlebill.ISettleBillSubsidy.class);
    }
    
    public static com.kingdee.eas.custom.settlebill.ISettleBillSubsidy getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleBillSubsidy)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C1904788") ,com.kingdee.eas.custom.settlebill.ISettleBillSubsidy.class, objectCtx);
    }
    public static com.kingdee.eas.custom.settlebill.ISettleBillSubsidy getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleBillSubsidy)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C1904788"));
    }
    public static com.kingdee.eas.custom.settlebill.ISettleBillSubsidy getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.settlebill.ISettleBillSubsidy)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C1904788"));
    }
}