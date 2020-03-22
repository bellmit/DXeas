package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class QeggAndDuckSeedEarlyEntryFactory
{
    private QeggAndDuckSeedEarlyEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IQeggAndDuckSeedEarlyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IQeggAndDuckSeedEarlyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("16186E17") ,com.kingdee.eas.farm.stocking.processbizill.IQeggAndDuckSeedEarlyEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IQeggAndDuckSeedEarlyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IQeggAndDuckSeedEarlyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("16186E17") ,com.kingdee.eas.farm.stocking.processbizill.IQeggAndDuckSeedEarlyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IQeggAndDuckSeedEarlyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IQeggAndDuckSeedEarlyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("16186E17"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IQeggAndDuckSeedEarlyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IQeggAndDuckSeedEarlyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("16186E17"));
    }
}