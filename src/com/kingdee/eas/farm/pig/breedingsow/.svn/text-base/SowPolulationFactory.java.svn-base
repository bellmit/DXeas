package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SowPolulationFactory
{
    private SowPolulationFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ISowPolulation getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowPolulation)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EF9E5B4B") ,com.kingdee.eas.farm.pig.breedingsow.ISowPolulation.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingsow.ISowPolulation getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowPolulation)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EF9E5B4B") ,com.kingdee.eas.farm.pig.breedingsow.ISowPolulation.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ISowPolulation getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowPolulation)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EF9E5B4B"));
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ISowPolulation getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowPolulation)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EF9E5B4B"));
    }
}