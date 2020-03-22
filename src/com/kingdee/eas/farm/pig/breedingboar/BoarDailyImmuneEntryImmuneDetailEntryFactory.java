package com.kingdee.eas.farm.pig.breedingboar;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BoarDailyImmuneEntryImmuneDetailEntryFactory
{
    private BoarDailyImmuneEntryImmuneDetailEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyImmuneEntryImmuneDetailEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyImmuneEntryImmuneDetailEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("266CF50E") ,com.kingdee.eas.farm.pig.breedingboar.IBoarDailyImmuneEntryImmuneDetailEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyImmuneEntryImmuneDetailEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyImmuneEntryImmuneDetailEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("266CF50E") ,com.kingdee.eas.farm.pig.breedingboar.IBoarDailyImmuneEntryImmuneDetailEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyImmuneEntryImmuneDetailEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyImmuneEntryImmuneDetailEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("266CF50E"));
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyImmuneEntryImmuneDetailEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyImmuneEntryImmuneDetailEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("266CF50E"));
    }
}