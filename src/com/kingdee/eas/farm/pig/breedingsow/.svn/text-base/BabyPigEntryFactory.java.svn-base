package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BabyPigEntryFactory
{
    private BabyPigEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IBabyPigEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IBabyPigEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8E936F1B") ,com.kingdee.eas.farm.pig.breedingsow.IBabyPigEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingsow.IBabyPigEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IBabyPigEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8E936F1B") ,com.kingdee.eas.farm.pig.breedingsow.IBabyPigEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IBabyPigEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IBabyPigEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8E936F1B"));
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IBabyPigEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IBabyPigEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8E936F1B"));
    }
}