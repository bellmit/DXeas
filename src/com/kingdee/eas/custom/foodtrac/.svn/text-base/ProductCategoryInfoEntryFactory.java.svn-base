package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProductCategoryInfoEntryFactory
{
    private ProductCategoryInfoEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.foodtrac.IProductCategoryInfoEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IProductCategoryInfoEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B373919C") ,com.kingdee.eas.custom.foodtrac.IProductCategoryInfoEntry.class);
    }
    
    public static com.kingdee.eas.custom.foodtrac.IProductCategoryInfoEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IProductCategoryInfoEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B373919C") ,com.kingdee.eas.custom.foodtrac.IProductCategoryInfoEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.foodtrac.IProductCategoryInfoEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IProductCategoryInfoEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B373919C"));
    }
    public static com.kingdee.eas.custom.foodtrac.IProductCategoryInfoEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IProductCategoryInfoEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B373919C"));
    }
}