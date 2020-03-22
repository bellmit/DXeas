package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MaterialConversionFactory
{
    private MaterialConversionFactory()
    {
    }
    public static com.kingdee.eas.custom.szcount.IMaterialConversion getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IMaterialConversion)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EC09F248") ,com.kingdee.eas.custom.szcount.IMaterialConversion.class);
    }
    
    public static com.kingdee.eas.custom.szcount.IMaterialConversion getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IMaterialConversion)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EC09F248") ,com.kingdee.eas.custom.szcount.IMaterialConversion.class, objectCtx);
    }
    public static com.kingdee.eas.custom.szcount.IMaterialConversion getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IMaterialConversion)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EC09F248"));
    }
    public static com.kingdee.eas.custom.szcount.IMaterialConversion getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IMaterialConversion)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EC09F248"));
    }
}