package com.kingdee.eas.farm.pig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PigTypeTreeFactory
{
    private PigTypeTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.IPigTypeTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigTypeTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C2F1CF66") ,com.kingdee.eas.farm.pig.IPigTypeTree.class);
    }
    
    public static com.kingdee.eas.farm.pig.IPigTypeTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigTypeTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C2F1CF66") ,com.kingdee.eas.farm.pig.IPigTypeTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.IPigTypeTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigTypeTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C2F1CF66"));
    }
    public static com.kingdee.eas.farm.pig.IPigTypeTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigTypeTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C2F1CF66"));
    }
}