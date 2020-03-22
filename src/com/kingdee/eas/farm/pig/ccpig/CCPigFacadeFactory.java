package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCPigFacadeFactory
{
    private CCPigFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3EBC9AA8") ,com.kingdee.eas.farm.pig.ccpig.ICCPigFacade.class);
    }
    
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3EBC9AA8") ,com.kingdee.eas.farm.pig.ccpig.ICCPigFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3EBC9AA8"));
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3EBC9AA8"));
    }
}