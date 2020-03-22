package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedStandardTreeFactory
{
    private BreedStandardTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedStandardTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedStandardTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FA29705E") ,com.kingdee.eas.farm.stocking.basedata.IBreedStandardTree.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IBreedStandardTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedStandardTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FA29705E") ,com.kingdee.eas.farm.stocking.basedata.IBreedStandardTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedStandardTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedStandardTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FA29705E"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedStandardTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedStandardTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FA29705E"));
    }
}