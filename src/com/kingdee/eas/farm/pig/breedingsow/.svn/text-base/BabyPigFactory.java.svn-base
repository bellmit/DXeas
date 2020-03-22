package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BabyPigFactory
{
    private BabyPigFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IBabyPig getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IBabyPig)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D6E1CF97") ,com.kingdee.eas.farm.pig.breedingsow.IBabyPig.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingsow.IBabyPig getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IBabyPig)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D6E1CF97") ,com.kingdee.eas.farm.pig.breedingsow.IBabyPig.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IBabyPig getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IBabyPig)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D6E1CF97"));
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IBabyPig getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IBabyPig)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D6E1CF97"));
    }
}