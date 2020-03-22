package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class TechnicianCustomerEntryFactory
{
    private TechnicianCustomerEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.ITechnicianCustomerEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ITechnicianCustomerEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2921BABC") ,com.kingdee.eas.custom.salepayment.ITechnicianCustomerEntry.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.ITechnicianCustomerEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ITechnicianCustomerEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2921BABC") ,com.kingdee.eas.custom.salepayment.ITechnicianCustomerEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.ITechnicianCustomerEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ITechnicianCustomerEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2921BABC"));
    }
    public static com.kingdee.eas.custom.salepayment.ITechnicianCustomerEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ITechnicianCustomerEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2921BABC"));
    }
}