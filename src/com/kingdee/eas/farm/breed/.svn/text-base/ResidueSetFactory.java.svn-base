package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ResidueSetFactory
{
    private ResidueSetFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IResidueSet getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IResidueSet)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("453BBBB1") ,com.kingdee.eas.farm.breed.IResidueSet.class);
    }
    
    public static com.kingdee.eas.farm.breed.IResidueSet getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IResidueSet)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("453BBBB1") ,com.kingdee.eas.farm.breed.IResidueSet.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IResidueSet getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IResidueSet)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("453BBBB1"));
    }
    public static com.kingdee.eas.farm.breed.IResidueSet getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IResidueSet)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("453BBBB1"));
    }
}