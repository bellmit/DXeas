package com.kingdee.eas.farm.food.stocount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SemiProductCountEntryFactory
{
    private SemiProductCountEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.food.stocount.ISemiProductCountEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.ISemiProductCountEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D3F9F687") ,com.kingdee.eas.farm.food.stocount.ISemiProductCountEntry.class);
    }
    
    public static com.kingdee.eas.farm.food.stocount.ISemiProductCountEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.ISemiProductCountEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D3F9F687") ,com.kingdee.eas.farm.food.stocount.ISemiProductCountEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.stocount.ISemiProductCountEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.ISemiProductCountEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D3F9F687"));
    }
    public static com.kingdee.eas.farm.food.stocount.ISemiProductCountEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.ISemiProductCountEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D3F9F687"));
    }
}