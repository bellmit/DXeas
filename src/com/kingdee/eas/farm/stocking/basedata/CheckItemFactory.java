package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CheckItemFactory
{
    private CheckItemFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.ICheckItem getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ICheckItem)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2A1B400A") ,com.kingdee.eas.farm.stocking.basedata.ICheckItem.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.ICheckItem getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ICheckItem)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2A1B400A") ,com.kingdee.eas.farm.stocking.basedata.ICheckItem.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.ICheckItem getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ICheckItem)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2A1B400A"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.ICheckItem getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.ICheckItem)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2A1B400A"));
    }
}