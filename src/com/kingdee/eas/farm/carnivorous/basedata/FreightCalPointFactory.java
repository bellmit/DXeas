package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FreightCalPointFactory
{
    private FreightCalPointFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFreightCalPoint getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFreightCalPoint)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("94C7E0E3") ,com.kingdee.eas.farm.carnivorous.basedata.IFreightCalPoint.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IFreightCalPoint getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFreightCalPoint)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("94C7E0E3") ,com.kingdee.eas.farm.carnivorous.basedata.IFreightCalPoint.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFreightCalPoint getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFreightCalPoint)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("94C7E0E3"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFreightCalPoint getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFreightCalPoint)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("94C7E0E3"));
    }
}