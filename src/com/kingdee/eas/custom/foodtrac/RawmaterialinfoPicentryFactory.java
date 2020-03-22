package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class RawmaterialinfoPicentryFactory
{
    private RawmaterialinfoPicentryFactory()
    {
    }
    public static com.kingdee.eas.custom.foodtrac.IRawmaterialinfoPicentry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IRawmaterialinfoPicentry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A0AE3060") ,com.kingdee.eas.custom.foodtrac.IRawmaterialinfoPicentry.class);
    }
    
    public static com.kingdee.eas.custom.foodtrac.IRawmaterialinfoPicentry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IRawmaterialinfoPicentry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A0AE3060") ,com.kingdee.eas.custom.foodtrac.IRawmaterialinfoPicentry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.foodtrac.IRawmaterialinfoPicentry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IRawmaterialinfoPicentry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A0AE3060"));
    }
    public static com.kingdee.eas.custom.foodtrac.IRawmaterialinfoPicentry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IRawmaterialinfoPicentry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A0AE3060"));
    }
}