package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MaterialConversionTreeFactory
{
    private MaterialConversionTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.szcount.IMaterialConversionTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IMaterialConversionTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("15DF7606") ,com.kingdee.eas.custom.szcount.IMaterialConversionTree.class);
    }
    
    public static com.kingdee.eas.custom.szcount.IMaterialConversionTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IMaterialConversionTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("15DF7606") ,com.kingdee.eas.custom.szcount.IMaterialConversionTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.szcount.IMaterialConversionTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IMaterialConversionTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("15DF7606"));
    }
    public static com.kingdee.eas.custom.szcount.IMaterialConversionTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.szcount.IMaterialConversionTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("15DF7606"));
    }
}