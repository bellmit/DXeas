package com.kingdee.eas.farm.pig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StrainTreeFactory
{
    private StrainTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.IStrainTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IStrainTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("44C1D0F3") ,com.kingdee.eas.farm.pig.IStrainTree.class);
    }
    
    public static com.kingdee.eas.farm.pig.IStrainTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IStrainTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("44C1D0F3") ,com.kingdee.eas.farm.pig.IStrainTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.IStrainTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IStrainTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("44C1D0F3"));
    }
    public static com.kingdee.eas.farm.pig.IStrainTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IStrainTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("44C1D0F3"));
    }
}