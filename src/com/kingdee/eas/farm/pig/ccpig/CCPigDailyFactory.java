package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCPigDailyFactory
{
    private CCPigDailyFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDaily getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDaily)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BFD97A4B") ,com.kingdee.eas.farm.pig.ccpig.ICCPigDaily.class);
    }
    
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDaily getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDaily)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BFD97A4B") ,com.kingdee.eas.farm.pig.ccpig.ICCPigDaily.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDaily getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDaily)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BFD97A4B"));
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigDaily getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigDaily)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BFD97A4B"));
    }
}