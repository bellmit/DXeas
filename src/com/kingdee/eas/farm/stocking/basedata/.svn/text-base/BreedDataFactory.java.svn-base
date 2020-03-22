package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedDataFactory
{
    private BreedDataFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedData getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedData)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A7A7130D") ,com.kingdee.eas.farm.stocking.basedata.IBreedData.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IBreedData getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedData)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A7A7130D") ,com.kingdee.eas.farm.stocking.basedata.IBreedData.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedData getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedData)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A7A7130D"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedData getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedData)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A7A7130D"));
    }
}