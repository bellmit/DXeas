package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AppealBillFactory
{
    private AppealBillFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IAppealBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IAppealBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C8B2075B") ,com.kingdee.eas.farm.stocking.processbizill.IAppealBill.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IAppealBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IAppealBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C8B2075B") ,com.kingdee.eas.farm.stocking.processbizill.IAppealBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IAppealBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IAppealBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C8B2075B"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IAppealBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IAppealBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C8B2075B"));
    }
}