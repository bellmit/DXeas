package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CompanyMonthFeeEntryFactory
{
    private CompanyMonthFeeEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.ICompanyMonthFeeEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ICompanyMonthFeeEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A4150AA3") ,com.kingdee.eas.custom.salepayment.ICompanyMonthFeeEntry.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.ICompanyMonthFeeEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ICompanyMonthFeeEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A4150AA3") ,com.kingdee.eas.custom.salepayment.ICompanyMonthFeeEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.ICompanyMonthFeeEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ICompanyMonthFeeEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A4150AA3"));
    }
    public static com.kingdee.eas.custom.salepayment.ICompanyMonthFeeEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ICompanyMonthFeeEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A4150AA3"));
    }
}