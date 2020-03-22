package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TheEggTableEntryFactory
{
    private TheEggTableEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITheEggTableEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITheEggTableEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F0FE2F9D") ,com.kingdee.eas.farm.stocking.processbizill.ITheEggTableEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.ITheEggTableEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITheEggTableEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F0FE2F9D") ,com.kingdee.eas.farm.stocking.processbizill.ITheEggTableEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITheEggTableEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITheEggTableEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F0FE2F9D"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.ITheEggTableEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.ITheEggTableEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F0FE2F9D"));
    }
}