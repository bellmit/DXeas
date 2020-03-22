package com.kingdee.eas.farm.food.stocount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CountPositionSetMaterialEntryFactory
{
    private CountPositionSetMaterialEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.food.stocount.ICountPositionSetMaterialEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.ICountPositionSetMaterialEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B10A2024") ,com.kingdee.eas.farm.food.stocount.ICountPositionSetMaterialEntry.class);
    }
    
    public static com.kingdee.eas.farm.food.stocount.ICountPositionSetMaterialEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.ICountPositionSetMaterialEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B10A2024") ,com.kingdee.eas.farm.food.stocount.ICountPositionSetMaterialEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.food.stocount.ICountPositionSetMaterialEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.ICountPositionSetMaterialEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B10A2024"));
    }
    public static com.kingdee.eas.farm.food.stocount.ICountPositionSetMaterialEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.food.stocount.ICountPositionSetMaterialEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B10A2024"));
    }
}