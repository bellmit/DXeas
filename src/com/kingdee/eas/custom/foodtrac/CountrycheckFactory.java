package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CountrycheckFactory
{
    private CountrycheckFactory()
    {
    }
    public static com.kingdee.eas.custom.foodtrac.ICountrycheck getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ICountrycheck)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A7528C77") ,com.kingdee.eas.custom.foodtrac.ICountrycheck.class);
    }
    
    public static com.kingdee.eas.custom.foodtrac.ICountrycheck getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ICountrycheck)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A7528C77") ,com.kingdee.eas.custom.foodtrac.ICountrycheck.class, objectCtx);
    }
    public static com.kingdee.eas.custom.foodtrac.ICountrycheck getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ICountrycheck)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A7528C77"));
    }
    public static com.kingdee.eas.custom.foodtrac.ICountrycheck getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ICountrycheck)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A7528C77"));
    }
}