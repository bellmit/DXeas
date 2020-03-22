package com.kingdee.eas.farm.pig.breedingboar;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BoarDailyCullEntryFactory
{
    private BoarDailyCullEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyCullEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyCullEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8E1A2FA1") ,com.kingdee.eas.farm.pig.breedingboar.IBoarDailyCullEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyCullEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyCullEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8E1A2FA1") ,com.kingdee.eas.farm.pig.breedingboar.IBoarDailyCullEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyCullEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyCullEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8E1A2FA1"));
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyCullEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyCullEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8E1A2FA1"));
    }
}