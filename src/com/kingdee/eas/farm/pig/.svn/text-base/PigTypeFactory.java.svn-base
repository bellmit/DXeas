package com.kingdee.eas.farm.pig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PigTypeFactory
{
    private PigTypeFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.IPigType getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigType)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FFFFFBA8") ,com.kingdee.eas.farm.pig.IPigType.class);
    }
    
    public static com.kingdee.eas.farm.pig.IPigType getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigType)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FFFFFBA8") ,com.kingdee.eas.farm.pig.IPigType.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.IPigType getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigType)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FFFFFBA8"));
    }
    public static com.kingdee.eas.farm.pig.IPigType getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.IPigType)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FFFFFBA8"));
    }
}