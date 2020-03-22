package com.kingdee.eas.farm.pig.breedingboar;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BoarDailyFactory
{
    private BoarDailyFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDaily getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDaily)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("66D2D13F") ,com.kingdee.eas.farm.pig.breedingboar.IBoarDaily.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDaily getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDaily)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("66D2D13F") ,com.kingdee.eas.farm.pig.breedingboar.IBoarDaily.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDaily getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDaily)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("66D2D13F"));
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDaily getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDaily)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("66D2D13F"));
    }
}