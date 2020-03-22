package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SowPolulationEntryFactory
{
    private SowPolulationEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ISowPolulationEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowPolulationEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F01E13E7") ,com.kingdee.eas.farm.pig.breedingsow.ISowPolulationEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingsow.ISowPolulationEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowPolulationEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F01E13E7") ,com.kingdee.eas.farm.pig.breedingsow.ISowPolulationEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ISowPolulationEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowPolulationEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F01E13E7"));
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ISowPolulationEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowPolulationEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F01E13E7"));
    }
}