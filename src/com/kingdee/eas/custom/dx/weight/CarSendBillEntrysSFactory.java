package com.kingdee.eas.custom.dx.weight;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CarSendBillEntrysSFactory
{
    private CarSendBillEntrysSFactory()
    {
    }
    public static com.kingdee.eas.custom.dx.weight.ICarSendBillEntrysS getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.ICarSendBillEntrysS)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F3395E70") ,com.kingdee.eas.custom.dx.weight.ICarSendBillEntrysS.class);
    }
    
    public static com.kingdee.eas.custom.dx.weight.ICarSendBillEntrysS getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.ICarSendBillEntrysS)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F3395E70") ,com.kingdee.eas.custom.dx.weight.ICarSendBillEntrysS.class, objectCtx);
    }
    public static com.kingdee.eas.custom.dx.weight.ICarSendBillEntrysS getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.ICarSendBillEntrysS)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F3395E70"));
    }
    public static com.kingdee.eas.custom.dx.weight.ICarSendBillEntrysS getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.dx.weight.ICarSendBillEntrysS)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F3395E70"));
    }
}