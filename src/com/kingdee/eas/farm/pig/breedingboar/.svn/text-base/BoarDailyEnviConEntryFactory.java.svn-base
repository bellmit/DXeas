package com.kingdee.eas.farm.pig.breedingboar;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BoarDailyEnviConEntryFactory
{
    private BoarDailyEnviConEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyEnviConEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyEnviConEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BCE9942B") ,com.kingdee.eas.farm.pig.breedingboar.IBoarDailyEnviConEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyEnviConEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyEnviConEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BCE9942B") ,com.kingdee.eas.farm.pig.breedingboar.IBoarDailyEnviConEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyEnviConEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyEnviConEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BCE9942B"));
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyEnviConEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyEnviConEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BCE9942B"));
    }
}