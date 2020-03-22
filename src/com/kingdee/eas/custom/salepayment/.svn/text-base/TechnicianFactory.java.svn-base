package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TechnicianFactory
{
    private TechnicianFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.ITechnician getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ITechnician)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("982DF758") ,com.kingdee.eas.custom.salepayment.ITechnician.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.ITechnician getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ITechnician)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("982DF758") ,com.kingdee.eas.custom.salepayment.ITechnician.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.ITechnician getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ITechnician)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("982DF758"));
    }
    public static com.kingdee.eas.custom.salepayment.ITechnician getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ITechnician)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("982DF758"));
    }
}