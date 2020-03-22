package com.kingdee.eas.custom.taihe.settle;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CarcassDisrateTreeFactory
{
    private CarcassDisrateTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.settle.ICarcassDisrateTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ICarcassDisrateTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7CA34B3D") ,com.kingdee.eas.custom.taihe.settle.ICarcassDisrateTree.class);
    }
    
    public static com.kingdee.eas.custom.taihe.settle.ICarcassDisrateTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ICarcassDisrateTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7CA34B3D") ,com.kingdee.eas.custom.taihe.settle.ICarcassDisrateTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.settle.ICarcassDisrateTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ICarcassDisrateTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7CA34B3D"));
    }
    public static com.kingdee.eas.custom.taihe.settle.ICarcassDisrateTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.settle.ICarcassDisrateTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7CA34B3D"));
    }
}