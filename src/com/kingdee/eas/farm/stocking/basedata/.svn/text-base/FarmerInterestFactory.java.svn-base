package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FarmerInterestFactory
{
    private FarmerInterestFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFarmerInterest getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarmerInterest)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("0B2F013E") ,com.kingdee.eas.farm.stocking.basedata.IFarmerInterest.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IFarmerInterest getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarmerInterest)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("0B2F013E") ,com.kingdee.eas.farm.stocking.basedata.IFarmerInterest.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFarmerInterest getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarmerInterest)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("0B2F013E"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IFarmerInterest getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IFarmerInterest)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("0B2F013E"));
    }
}