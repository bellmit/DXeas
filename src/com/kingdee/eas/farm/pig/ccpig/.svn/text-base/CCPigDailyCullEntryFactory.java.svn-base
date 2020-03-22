package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCPigDailyCullEntryFactory
{
    private CCPigDailyCullEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyCullEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyCullEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EAF2F415") ,com.kingdee.eas.farm.pig.ccpig.ICCPigDailyCullEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyCullEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyCullEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EAF2F415") ,com.kingdee.eas.farm.pig.ccpig.ICCPigDailyCullEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyCullEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyCullEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EAF2F415"));
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDailyCullEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDailyCullEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EAF2F415"));
    }
}