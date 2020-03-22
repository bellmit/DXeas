package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmerTypeFactory
{
    private FarmerTypeFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmerType getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmerType)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("EA2D385F") ,com.kingdee.eas.farm.carnivorous.basedata.IFarmerType.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmerType getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmerType)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("EA2D385F") ,com.kingdee.eas.farm.carnivorous.basedata.IFarmerType.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmerType getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmerType)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("EA2D385F"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmerType getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmerType)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("EA2D385F"));
    }
}