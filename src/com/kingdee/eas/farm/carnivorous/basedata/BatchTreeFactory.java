package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BatchTreeFactory
{
    private BatchTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBatchTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBatchTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("93763696") ,com.kingdee.eas.farm.carnivorous.basedata.IBatchTree.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IBatchTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBatchTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("93763696") ,com.kingdee.eas.farm.carnivorous.basedata.IBatchTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBatchTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBatchTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("93763696"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IBatchTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IBatchTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("93763696"));
    }
}