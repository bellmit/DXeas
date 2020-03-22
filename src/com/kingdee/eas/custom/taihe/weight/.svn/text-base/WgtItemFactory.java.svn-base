package com.kingdee.eas.custom.taihe.weight;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WgtItemFactory
{
    private WgtItemFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.weight.IWgtItem getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.IWgtItem)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("574F99E1") ,com.kingdee.eas.custom.taihe.weight.IWgtItem.class);
    }
    
    public static com.kingdee.eas.custom.taihe.weight.IWgtItem getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.IWgtItem)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("574F99E1") ,com.kingdee.eas.custom.taihe.weight.IWgtItem.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.weight.IWgtItem getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.IWgtItem)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("574F99E1"));
    }
    public static com.kingdee.eas.custom.taihe.weight.IWgtItem getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.IWgtItem)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("574F99E1"));
    }
}