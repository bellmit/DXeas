package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SalePaymentSetFactory
{
    private SalePaymentSetFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.ISalePaymentSet getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISalePaymentSet)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C716D017") ,com.kingdee.eas.custom.salepayment.ISalePaymentSet.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.ISalePaymentSet getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISalePaymentSet)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C716D017") ,com.kingdee.eas.custom.salepayment.ISalePaymentSet.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.ISalePaymentSet getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISalePaymentSet)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C716D017"));
    }
    public static com.kingdee.eas.custom.salepayment.ISalePaymentSet getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISalePaymentSet)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C716D017"));
    }
}