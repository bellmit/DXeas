package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class QuitWagesBillFactory
{
    private QuitWagesBillFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IQuitWagesBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IQuitWagesBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CA63A65B") ,com.kingdee.eas.custom.wages.IQuitWagesBill.class);
    }
    
    public static com.kingdee.eas.custom.wages.IQuitWagesBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IQuitWagesBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CA63A65B") ,com.kingdee.eas.custom.wages.IQuitWagesBill.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IQuitWagesBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IQuitWagesBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CA63A65B"));
    }
    public static com.kingdee.eas.custom.wages.IQuitWagesBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IQuitWagesBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CA63A65B"));
    }
}