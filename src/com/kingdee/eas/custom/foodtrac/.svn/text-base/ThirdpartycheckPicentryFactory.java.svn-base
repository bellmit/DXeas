package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ThirdpartycheckPicentryFactory
{
    private ThirdpartycheckPicentryFactory()
    {
    }
    public static com.kingdee.eas.custom.foodtrac.IThirdpartycheckPicentry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IThirdpartycheckPicentry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0188A46C") ,com.kingdee.eas.custom.foodtrac.IThirdpartycheckPicentry.class);
    }
    
    public static com.kingdee.eas.custom.foodtrac.IThirdpartycheckPicentry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IThirdpartycheckPicentry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0188A46C") ,com.kingdee.eas.custom.foodtrac.IThirdpartycheckPicentry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.foodtrac.IThirdpartycheckPicentry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IThirdpartycheckPicentry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0188A46C"));
    }
    public static com.kingdee.eas.custom.foodtrac.IThirdpartycheckPicentry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.IThirdpartycheckPicentry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0188A46C"));
    }
}