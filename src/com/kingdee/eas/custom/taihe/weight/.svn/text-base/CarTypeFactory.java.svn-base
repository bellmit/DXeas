package com.kingdee.eas.custom.taihe.weight;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CarTypeFactory
{
    private CarTypeFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.weight.ICarType getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ICarType)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2AFECA38") ,com.kingdee.eas.custom.taihe.weight.ICarType.class);
    }
    
    public static com.kingdee.eas.custom.taihe.weight.ICarType getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ICarType)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2AFECA38") ,com.kingdee.eas.custom.taihe.weight.ICarType.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.weight.ICarType getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ICarType)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2AFECA38"));
    }
    public static com.kingdee.eas.custom.taihe.weight.ICarType getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.weight.ICarType)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2AFECA38"));
    }
}