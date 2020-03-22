package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CompanyMonthFeeFactory
{
    private CompanyMonthFeeFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.ICompanyMonthFee getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ICompanyMonthFee)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7B1F1F0F") ,com.kingdee.eas.custom.salepayment.ICompanyMonthFee.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.ICompanyMonthFee getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ICompanyMonthFee)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7B1F1F0F") ,com.kingdee.eas.custom.salepayment.ICompanyMonthFee.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.ICompanyMonthFee getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ICompanyMonthFee)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7B1F1F0F"));
    }
    public static com.kingdee.eas.custom.salepayment.ICompanyMonthFee getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ICompanyMonthFee)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7B1F1F0F"));
    }
}