package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CountrycheckPicentryFactory
{
    private CountrycheckPicentryFactory()
    {
    }
    public static com.kingdee.eas.custom.foodtrac.ICountrycheckPicentry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ICountrycheckPicentry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("655546BF") ,com.kingdee.eas.custom.foodtrac.ICountrycheckPicentry.class);
    }
    
    public static com.kingdee.eas.custom.foodtrac.ICountrycheckPicentry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ICountrycheckPicentry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("655546BF") ,com.kingdee.eas.custom.foodtrac.ICountrycheckPicentry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.foodtrac.ICountrycheckPicentry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ICountrycheckPicentry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("655546BF"));
    }
    public static com.kingdee.eas.custom.foodtrac.ICountrycheckPicentry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.foodtrac.ICountrycheckPicentry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("655546BF"));
    }
}