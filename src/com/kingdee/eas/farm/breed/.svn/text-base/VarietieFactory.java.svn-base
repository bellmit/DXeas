package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class VarietieFactory
{
    private VarietieFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IVarietie getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IVarietie)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D136E687") ,com.kingdee.eas.farm.breed.IVarietie.class);
    }
    
    public static com.kingdee.eas.farm.breed.IVarietie getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IVarietie)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D136E687") ,com.kingdee.eas.farm.breed.IVarietie.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IVarietie getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IVarietie)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D136E687"));
    }
    public static com.kingdee.eas.farm.breed.IVarietie getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IVarietie)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D136E687"));
    }
}