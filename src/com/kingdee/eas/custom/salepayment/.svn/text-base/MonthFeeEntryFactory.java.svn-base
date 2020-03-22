package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MonthFeeEntryFactory
{
    private MonthFeeEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.IMonthFeeEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IMonthFeeEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A1CF74B8") ,com.kingdee.eas.custom.salepayment.IMonthFeeEntry.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.IMonthFeeEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IMonthFeeEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A1CF74B8") ,com.kingdee.eas.custom.salepayment.IMonthFeeEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.IMonthFeeEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IMonthFeeEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A1CF74B8"));
    }
    public static com.kingdee.eas.custom.salepayment.IMonthFeeEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IMonthFeeEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A1CF74B8"));
    }
}