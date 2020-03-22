package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DiscountCustomerRelFactory
{
    private DiscountCustomerRelFactory()
    {
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountCustomerRel getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountCustomerRel)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("F808C6FF") ,com.kingdee.eas.custom.salediscount.IDiscountCustomerRel.class);
    }
    
    public static com.kingdee.eas.custom.salediscount.IDiscountCustomerRel getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountCustomerRel)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("F808C6FF") ,com.kingdee.eas.custom.salediscount.IDiscountCustomerRel.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountCustomerRel getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountCustomerRel)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("F808C6FF"));
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountCustomerRel getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountCustomerRel)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("F808C6FF"));
    }
}