package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SowAbortionEntryFactory
{
    private SowAbortionEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ISowAbortionEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowAbortionEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1028B2C0") ,com.kingdee.eas.farm.pig.breedingsow.ISowAbortionEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingsow.ISowAbortionEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowAbortionEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1028B2C0") ,com.kingdee.eas.farm.pig.breedingsow.ISowAbortionEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ISowAbortionEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowAbortionEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1028B2C0"));
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ISowAbortionEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ISowAbortionEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1028B2C0"));
    }
}