package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class farmingFacadeFactory
{
    private farmingFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.IfarmingFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IfarmingFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E37AA0AC") ,com.kingdee.eas.farm.breed.IfarmingFacade.class);
    }
    
    public static com.kingdee.eas.farm.breed.IfarmingFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IfarmingFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E37AA0AC") ,com.kingdee.eas.farm.breed.IfarmingFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.IfarmingFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IfarmingFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E37AA0AC"));
    }
    public static com.kingdee.eas.farm.breed.IfarmingFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.IfarmingFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E37AA0AC"));
    }
}