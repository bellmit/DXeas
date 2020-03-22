package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FreightBaseFactory
{
    private FreightBaseFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFreightBase getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFreightBase)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C7C1B9D2") ,com.kingdee.eas.farm.carnivorous.basedata.IFreightBase.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IFreightBase getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFreightBase)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C7C1B9D2") ,com.kingdee.eas.farm.carnivorous.basedata.IFreightBase.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFreightBase getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFreightBase)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C7C1B9D2"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFreightBase getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFreightBase)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C7C1B9D2"));
    }
}