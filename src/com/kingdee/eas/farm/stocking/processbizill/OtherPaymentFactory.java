package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class OtherPaymentFactory
{
    private OtherPaymentFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IOtherPayment getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IOtherPayment)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D3D984BB") ,com.kingdee.eas.farm.stocking.processbizill.IOtherPayment.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IOtherPayment getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IOtherPayment)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D3D984BB") ,com.kingdee.eas.farm.stocking.processbizill.IOtherPayment.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IOtherPayment getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IOtherPayment)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D3D984BB"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IOtherPayment getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IOtherPayment)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D3D984BB"));
    }
}