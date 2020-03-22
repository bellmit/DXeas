package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmerFactory
{
    private FarmerFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmer getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmer)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FA0A7F85") ,com.kingdee.eas.farm.carnivorous.basedata.IFarmer.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmer getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmer)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FA0A7F85") ,com.kingdee.eas.farm.carnivorous.basedata.IFarmer.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmer getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmer)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FA0A7F85"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IFarmer getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IFarmer)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FA0A7F85"));
    }
}