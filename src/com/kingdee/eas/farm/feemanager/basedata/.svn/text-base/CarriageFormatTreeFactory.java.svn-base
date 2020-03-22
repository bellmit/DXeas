package com.kingdee.eas.farm.feemanager.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CarriageFormatTreeFactory
{
    private CarriageFormatTreeFactory()
    {
    }
    public static com.kingdee.eas.farm.feemanager.basedata.ICarriageFormatTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ICarriageFormatTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("50CE9415") ,com.kingdee.eas.farm.feemanager.basedata.ICarriageFormatTree.class);
    }
    
    public static com.kingdee.eas.farm.feemanager.basedata.ICarriageFormatTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ICarriageFormatTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("50CE9415") ,com.kingdee.eas.farm.feemanager.basedata.ICarriageFormatTree.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feemanager.basedata.ICarriageFormatTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ICarriageFormatTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("50CE9415"));
    }
    public static com.kingdee.eas.farm.feemanager.basedata.ICarriageFormatTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feemanager.basedata.ICarriageFormatTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("50CE9415"));
    }
}