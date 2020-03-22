package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ThirdpartycheckEntryFactory
{
    private ThirdpartycheckEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.foodtrac.IThirdpartycheckEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IThirdpartycheckEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C8A607AE") ,com.kingdee.eas.custom.foodtrac.IThirdpartycheckEntry.class);
    }
    
    public static com.kingdee.eas.custom.foodtrac.IThirdpartycheckEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IThirdpartycheckEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C8A607AE") ,com.kingdee.eas.custom.foodtrac.IThirdpartycheckEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.foodtrac.IThirdpartycheckEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IThirdpartycheckEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C8A607AE"));
    }
    public static com.kingdee.eas.custom.foodtrac.IThirdpartycheckEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IThirdpartycheckEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C8A607AE"));
    }
}