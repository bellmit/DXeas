package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TranferBoxBillFactory
{
    private TranferBoxBillFactory()
    {
    }
    public static com.kingdee.eas.farm.hatch.ITranferBoxBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.ITranferBoxBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9DC48058") ,com.kingdee.eas.farm.hatch.ITranferBoxBill.class);
    }
    
    public static com.kingdee.eas.farm.hatch.ITranferBoxBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.ITranferBoxBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9DC48058") ,com.kingdee.eas.farm.hatch.ITranferBoxBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.hatch.ITranferBoxBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.ITranferBoxBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9DC48058"));
    }
    public static com.kingdee.eas.farm.hatch.ITranferBoxBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.hatch.ITranferBoxBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9DC48058"));
    }
}