package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AreaSetFactory
{
    private AreaSetFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.IAreaSet getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IAreaSet)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2C5E4321") ,com.kingdee.eas.custom.salepayment.IAreaSet.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.IAreaSet getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IAreaSet)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2C5E4321") ,com.kingdee.eas.custom.salepayment.IAreaSet.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.IAreaSet getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IAreaSet)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2C5E4321"));
    }
    public static com.kingdee.eas.custom.salepayment.IAreaSet getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IAreaSet)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2C5E4321"));
    }
}