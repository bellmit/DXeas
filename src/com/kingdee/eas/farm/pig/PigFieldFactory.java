package com.kingdee.eas.farm.pig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PigFieldFactory
{
    private PigFieldFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.IPigField getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigField)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FF32C24C") ,com.kingdee.eas.farm.pig.IPigField.class);
    }
    
    public static com.kingdee.eas.farm.pig.IPigField getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigField)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FF32C24C") ,com.kingdee.eas.farm.pig.IPigField.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.IPigField getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigField)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FF32C24C"));
    }
    public static com.kingdee.eas.farm.pig.IPigField getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigField)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FF32C24C"));
    }
}