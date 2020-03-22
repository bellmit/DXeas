package com.kingdee.eas.farm.food.stocount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProdCountEntryFactory
{
    private ProdCountEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.food.stocount.IProdCountEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.IProdCountEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("701F3757") ,com.kingdee.eas.farm.food.stocount.IProdCountEntry.class);
    }
    
    public static com.kingdee.eas.farm.food.stocount.IProdCountEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.IProdCountEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("701F3757") ,com.kingdee.eas.farm.food.stocount.IProdCountEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.stocount.IProdCountEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.IProdCountEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("701F3757"));
    }
    public static com.kingdee.eas.farm.food.stocount.IProdCountEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.IProdCountEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("701F3757"));
    }
}