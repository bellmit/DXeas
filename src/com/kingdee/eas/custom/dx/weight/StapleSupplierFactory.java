package com.kingdee.eas.custom.dx.weight;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class StapleSupplierFactory
{
    private StapleSupplierFactory()
    {
    }
    public static com.kingdee.eas.custom.dx.weight.IStapleSupplier getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.IStapleSupplier)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("3C3D2296") ,com.kingdee.eas.custom.dx.weight.IStapleSupplier.class);
    }
    
    public static com.kingdee.eas.custom.dx.weight.IStapleSupplier getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.IStapleSupplier)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("3C3D2296") ,com.kingdee.eas.custom.dx.weight.IStapleSupplier.class, objectCtx);
    }
    public static com.kingdee.eas.custom.dx.weight.IStapleSupplier getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.IStapleSupplier)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("3C3D2296"));
    }
    public static com.kingdee.eas.custom.dx.weight.IStapleSupplier getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.IStapleSupplier)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("3C3D2296"));
    }
}