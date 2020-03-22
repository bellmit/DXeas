package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCSendFodderStandardTreeFactory
{
    private CCSendFodderStandardTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.business.ICCSendFodderStandardTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICCSendFodderStandardTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1DE0F7E7") ,com.kingdee.eas.farm.breed.business.ICCSendFodderStandardTree.class);
    }
    
    public static com.kingdee.eas.farm.breed.business.ICCSendFodderStandardTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICCSendFodderStandardTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1DE0F7E7") ,com.kingdee.eas.farm.breed.business.ICCSendFodderStandardTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.business.ICCSendFodderStandardTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICCSendFodderStandardTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1DE0F7E7"));
    }
    public static com.kingdee.eas.farm.breed.business.ICCSendFodderStandardTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICCSendFodderStandardTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1DE0F7E7"));
    }
}