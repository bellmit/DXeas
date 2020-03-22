package com.kingdee.eas.custom.rye;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class RyeReadFilesFactory
{
    private RyeReadFilesFactory()
    {
    }
    public static com.kingdee.eas.custom.rye.IRyeReadFiles getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.rye.IRyeReadFiles)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("DC7B44D8") ,com.kingdee.eas.custom.rye.IRyeReadFiles.class);
    }
    
    public static com.kingdee.eas.custom.rye.IRyeReadFiles getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.rye.IRyeReadFiles)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("DC7B44D8") ,com.kingdee.eas.custom.rye.IRyeReadFiles.class, objectCtx);
    }
    public static com.kingdee.eas.custom.rye.IRyeReadFiles getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.rye.IRyeReadFiles)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("DC7B44D8"));
    }
    public static com.kingdee.eas.custom.rye.IRyeReadFiles getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.rye.IRyeReadFiles)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("DC7B44D8"));
    }
}