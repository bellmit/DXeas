package com.kingdee.eas.farm.feemanager.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class OilPriceFactory
{
    private OilPriceFactory()
    {
    }
    public static com.kingdee.eas.farm.feemanager.basedata.IOilPrice getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.IOilPrice)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("74075243") ,com.kingdee.eas.farm.feemanager.basedata.IOilPrice.class);
    }
    
    public static com.kingdee.eas.farm.feemanager.basedata.IOilPrice getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.IOilPrice)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("74075243") ,com.kingdee.eas.farm.feemanager.basedata.IOilPrice.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feemanager.basedata.IOilPrice getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.IOilPrice)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("74075243"));
    }
    public static com.kingdee.eas.farm.feemanager.basedata.IOilPrice getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.IOilPrice)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("74075243"));
    }
}