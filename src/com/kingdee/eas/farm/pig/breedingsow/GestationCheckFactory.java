package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class GestationCheckFactory
{
    private GestationCheckFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IGestationCheck getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IGestationCheck)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("07CBAC73") ,com.kingdee.eas.farm.pig.breedingsow.IGestationCheck.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingsow.IGestationCheck getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IGestationCheck)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("07CBAC73") ,com.kingdee.eas.farm.pig.breedingsow.IGestationCheck.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IGestationCheck getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IGestationCheck)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("07CBAC73"));
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IGestationCheck getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IGestationCheck)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("07CBAC73"));
    }
}