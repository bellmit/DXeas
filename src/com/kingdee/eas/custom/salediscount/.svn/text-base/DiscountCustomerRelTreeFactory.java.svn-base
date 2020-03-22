package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DiscountCustomerRelTreeFactory
{
    private DiscountCustomerRelTreeFactory()
    {
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountCustomerRelTree getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountCustomerRelTree)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("A867173D") ,com.kingdee.eas.custom.salediscount.IDiscountCustomerRelTree.class);
    }
    
    public static com.kingdee.eas.custom.salediscount.IDiscountCustomerRelTree getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountCustomerRelTree)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("A867173D") ,com.kingdee.eas.custom.salediscount.IDiscountCustomerRelTree.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountCustomerRelTree getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountCustomerRelTree)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("A867173D"));
    }
    public static com.kingdee.eas.custom.salediscount.IDiscountCustomerRelTree getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.IDiscountCustomerRelTree)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("A867173D"));
    }
}