package com.kingdee.eas.farm.feemanager.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CarriageFormatFactory
{
    private CarriageFormatFactory()
    {
    }
    public static com.kingdee.eas.farm.feemanager.basedata.ICarriageFormat getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ICarriageFormat)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("78A06FD7") ,com.kingdee.eas.farm.feemanager.basedata.ICarriageFormat.class);
    }
    
    public static com.kingdee.eas.farm.feemanager.basedata.ICarriageFormat getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ICarriageFormat)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("78A06FD7") ,com.kingdee.eas.farm.feemanager.basedata.ICarriageFormat.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feemanager.basedata.ICarriageFormat getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ICarriageFormat)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("78A06FD7"));
    }
    public static com.kingdee.eas.farm.feemanager.basedata.ICarriageFormat getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ICarriageFormat)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("78A06FD7"));
    }
}