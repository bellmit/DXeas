package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HatchStandardEntryFactory
{
    private HatchStandardEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.IHatchStandardEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchStandardEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("686001E3") ,com.kingdee.eas.farm.hatch.IHatchStandardEntry.class);
    }
    
    public static com.kingdee.eas.farm.hatch.IHatchStandardEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchStandardEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("686001E3") ,com.kingdee.eas.farm.hatch.IHatchStandardEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.IHatchStandardEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchStandardEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("686001E3"));
    }
    public static com.kingdee.eas.farm.hatch.IHatchStandardEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.IHatchStandardEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("686001E3"));
    }
}