package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ProductCategoryInfoFactory
{
    private ProductCategoryInfoFactory()
    {
    }
    public static com.kingdee.eas.custom.foodtrac.IProductCategoryInfo getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IProductCategoryInfo)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("51A46076") ,com.kingdee.eas.custom.foodtrac.IProductCategoryInfo.class);
    }
    
    public static com.kingdee.eas.custom.foodtrac.IProductCategoryInfo getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IProductCategoryInfo)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("51A46076") ,com.kingdee.eas.custom.foodtrac.IProductCategoryInfo.class, objectCtx);
    }
    public static com.kingdee.eas.custom.foodtrac.IProductCategoryInfo getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IProductCategoryInfo)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("51A46076"));
    }
    public static com.kingdee.eas.custom.foodtrac.IProductCategoryInfo getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IProductCategoryInfo)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("51A46076"));
    }
}