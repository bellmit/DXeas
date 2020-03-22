package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class VetFactory
{
    private VetFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IVet getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IVet)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0F96BAC3") ,com.kingdee.eas.farm.carnivorous.basedata.IVet.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IVet getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IVet)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0F96BAC3") ,com.kingdee.eas.farm.carnivorous.basedata.IVet.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IVet getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IVet)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0F96BAC3"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IVet getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IVet)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0F96BAC3"));
    }
}