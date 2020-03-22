package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class GestationCheckEntryFactory
{
    private GestationCheckEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IGestationCheckEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IGestationCheckEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("68DD3BBF") ,com.kingdee.eas.farm.pig.breedingsow.IGestationCheckEntry.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingsow.IGestationCheckEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IGestationCheckEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("68DD3BBF") ,com.kingdee.eas.farm.pig.breedingsow.IGestationCheckEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IGestationCheckEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IGestationCheckEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("68DD3BBF"));
    }
    public static com.kingdee.eas.farm.pig.breedingsow.IGestationCheckEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.IGestationCheckEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("68DD3BBF"));
    }
}