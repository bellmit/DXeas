package com.kingdee.eas.custom.commonld;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PaymentBillImportFacadeFactory
{
    private PaymentBillImportFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.commonld.IPaymentBillImportFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.commonld.IPaymentBillImportFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8D73E0AC") ,com.kingdee.eas.custom.commonld.IPaymentBillImportFacade.class);
    }
    
    public static com.kingdee.eas.custom.commonld.IPaymentBillImportFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.commonld.IPaymentBillImportFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8D73E0AC") ,com.kingdee.eas.custom.commonld.IPaymentBillImportFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.commonld.IPaymentBillImportFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.commonld.IPaymentBillImportFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8D73E0AC"));
    }
    public static com.kingdee.eas.custom.commonld.IPaymentBillImportFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.commonld.IPaymentBillImportFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8D73E0AC"));
    }
}