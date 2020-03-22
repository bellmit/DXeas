package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CustomerSaleTargetTreeFactory
{
    private CustomerSaleTargetTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.ICustomerSaleTargetTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ICustomerSaleTargetTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2B1067E8") ,com.kingdee.eas.custom.salepayment.ICustomerSaleTargetTree.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.ICustomerSaleTargetTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ICustomerSaleTargetTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2B1067E8") ,com.kingdee.eas.custom.salepayment.ICustomerSaleTargetTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.ICustomerSaleTargetTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ICustomerSaleTargetTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2B1067E8"));
    }
    public static com.kingdee.eas.custom.salepayment.ICustomerSaleTargetTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ICustomerSaleTargetTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2B1067E8"));
    }
}