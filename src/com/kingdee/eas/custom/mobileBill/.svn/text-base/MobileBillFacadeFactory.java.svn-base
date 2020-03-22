package com.kingdee.eas.custom.mobileBill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MobileBillFacadeFactory
{
    private MobileBillFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.mobileBill.IMobileBillFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.mobileBill.IMobileBillFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C4483270") ,com.kingdee.eas.custom.mobileBill.IMobileBillFacade.class);
    }
    
    public static com.kingdee.eas.custom.mobileBill.IMobileBillFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.mobileBill.IMobileBillFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C4483270") ,com.kingdee.eas.custom.mobileBill.IMobileBillFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.mobileBill.IMobileBillFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.mobileBill.IMobileBillFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C4483270"));
    }
    public static com.kingdee.eas.custom.mobileBill.IMobileBillFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.mobileBill.IMobileBillFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C4483270"));
    }
}