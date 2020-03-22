package com.kingdee.eas.custom.festival;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PaymentImportFacadeFactory
{
    private PaymentImportFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.festival.IPaymentImportFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IPaymentImportFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("BD56BFDA") ,com.kingdee.eas.custom.festival.IPaymentImportFacade.class);
    }
    
    public static com.kingdee.eas.custom.festival.IPaymentImportFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IPaymentImportFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("BD56BFDA") ,com.kingdee.eas.custom.festival.IPaymentImportFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.festival.IPaymentImportFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IPaymentImportFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("BD56BFDA"));
    }
    public static com.kingdee.eas.custom.festival.IPaymentImportFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.festival.IPaymentImportFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("BD56BFDA"));
    }
}