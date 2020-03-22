package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedDataTreeFactory
{
    private BreedDataTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedDataTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedDataTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("88C4AC4B") ,com.kingdee.eas.farm.stocking.basedata.IBreedDataTree.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IBreedDataTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedDataTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("88C4AC4B") ,com.kingdee.eas.farm.stocking.basedata.IBreedDataTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedDataTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedDataTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("88C4AC4B"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedDataTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedDataTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("88C4AC4B"));
    }
}