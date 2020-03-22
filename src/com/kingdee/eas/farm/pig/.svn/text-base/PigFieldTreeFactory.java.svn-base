package com.kingdee.eas.farm.pig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PigFieldTreeFactory
{
    private PigFieldTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.IPigFieldTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigFieldTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C858A40A") ,com.kingdee.eas.farm.pig.IPigFieldTree.class);
    }
    
    public static com.kingdee.eas.farm.pig.IPigFieldTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigFieldTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C858A40A") ,com.kingdee.eas.farm.pig.IPigFieldTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.IPigFieldTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigFieldTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C858A40A"));
    }
    public static com.kingdee.eas.farm.pig.IPigFieldTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigFieldTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C858A40A"));
    }
}