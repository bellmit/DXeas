package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCSendFodderStandardFactory
{
    private CCSendFodderStandardFactory()
    {
    }
    public static com.kingdee.eas.farm.breed.business.ICCSendFodderStandard getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICCSendFodderStandard)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D0118CA9") ,com.kingdee.eas.farm.breed.business.ICCSendFodderStandard.class);
    }
    
    public static com.kingdee.eas.farm.breed.business.ICCSendFodderStandard getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICCSendFodderStandard)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D0118CA9") ,com.kingdee.eas.farm.breed.business.ICCSendFodderStandard.class, objectCtx);
    }
    public static com.kingdee.eas.farm.breed.business.ICCSendFodderStandard getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICCSendFodderStandard)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D0118CA9"));
    }
    public static com.kingdee.eas.farm.breed.business.ICCSendFodderStandard getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.breed.business.ICCSendFodderStandard)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D0118CA9"));
    }
}