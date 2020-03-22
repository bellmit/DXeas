package com.kingdee.eas.farm.pig.breedingboar;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BoarDailyLiveStockEntryFactory
{
    private BoarDailyLiveStockEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyLiveStockEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyLiveStockEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("16D67827") ,com.kingdee.eas.farm.pig.breedingboar.IBoarDailyLiveStockEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyLiveStockEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyLiveStockEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("16D67827") ,com.kingdee.eas.farm.pig.breedingboar.IBoarDailyLiveStockEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyLiveStockEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyLiveStockEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("16D67827"));
    }
    public static com.kingdee.eas.farm.pig.breedingboar.IBoarDailyLiveStockEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingboar.IBoarDailyLiveStockEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("16D67827"));
    }
}