package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WelfarecategoryFactory
{
    private WelfarecategoryFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IWelfarecategory getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWelfarecategory)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CB994882") ,com.kingdee.eas.custom.wages.IWelfarecategory.class);
    }
    
    public static com.kingdee.eas.custom.wages.IWelfarecategory getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWelfarecategory)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CB994882") ,com.kingdee.eas.custom.wages.IWelfarecategory.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IWelfarecategory getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWelfarecategory)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CB994882"));
    }
    public static com.kingdee.eas.custom.wages.IWelfarecategory getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IWelfarecategory)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CB994882"));
    }
}