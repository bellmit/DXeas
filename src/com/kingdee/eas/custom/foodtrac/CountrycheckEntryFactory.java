package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CountrycheckEntryFactory
{
    private CountrycheckEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.foodtrac.ICountrycheckEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ICountrycheckEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D175BE3B") ,com.kingdee.eas.custom.foodtrac.ICountrycheckEntry.class);
    }
    
    public static com.kingdee.eas.custom.foodtrac.ICountrycheckEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ICountrycheckEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D175BE3B") ,com.kingdee.eas.custom.foodtrac.ICountrycheckEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.foodtrac.ICountrycheckEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ICountrycheckEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D175BE3B"));
    }
    public static com.kingdee.eas.custom.foodtrac.ICountrycheckEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ICountrycheckEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D175BE3B"));
    }
}