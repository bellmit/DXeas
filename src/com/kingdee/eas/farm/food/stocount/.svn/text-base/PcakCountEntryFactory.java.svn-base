package com.kingdee.eas.farm.food.stocount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PcakCountEntryFactory
{
    private PcakCountEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.food.stocount.IPcakCountEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.IPcakCountEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1CFBADDD") ,com.kingdee.eas.farm.food.stocount.IPcakCountEntry.class);
    }
    
    public static com.kingdee.eas.farm.food.stocount.IPcakCountEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.IPcakCountEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1CFBADDD") ,com.kingdee.eas.farm.food.stocount.IPcakCountEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.stocount.IPcakCountEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.IPcakCountEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1CFBADDD"));
    }
    public static com.kingdee.eas.farm.food.stocount.IPcakCountEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.IPcakCountEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1CFBADDD"));
    }
}