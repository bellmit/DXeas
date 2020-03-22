package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PackingConversionFactory
{
    private PackingConversionFactory()
    {
    }
    public static com.kingdee.eas.custom.szcount.IPackingConversion getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IPackingConversion)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2640A314") ,com.kingdee.eas.custom.szcount.IPackingConversion.class);
    }
    
    public static com.kingdee.eas.custom.szcount.IPackingConversion getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IPackingConversion)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2640A314") ,com.kingdee.eas.custom.szcount.IPackingConversion.class, objectCtx);
    }
    public static com.kingdee.eas.custom.szcount.IPackingConversion getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IPackingConversion)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2640A314"));
    }
    public static com.kingdee.eas.custom.szcount.IPackingConversion getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IPackingConversion)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2640A314"));
    }
}