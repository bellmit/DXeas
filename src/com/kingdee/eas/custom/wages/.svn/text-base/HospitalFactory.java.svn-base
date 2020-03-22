package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class HospitalFactory
{
    private HospitalFactory()
    {
    }
    public static com.kingdee.eas.custom.wages.IHospital getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IHospital)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("65CCD242") ,com.kingdee.eas.custom.wages.IHospital.class);
    }
    
    public static com.kingdee.eas.custom.wages.IHospital getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IHospital)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("65CCD242") ,com.kingdee.eas.custom.wages.IHospital.class, objectCtx);
    }
    public static com.kingdee.eas.custom.wages.IHospital getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IHospital)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("65CCD242"));
    }
    public static com.kingdee.eas.custom.wages.IHospital getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.wages.IHospital)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("65CCD242"));
    }
}