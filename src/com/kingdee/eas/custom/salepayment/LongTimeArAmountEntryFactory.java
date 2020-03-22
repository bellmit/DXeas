package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class LongTimeArAmountEntryFactory
{
    private LongTimeArAmountEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.ILongTimeArAmountEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ILongTimeArAmountEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("70A9A6AC") ,com.kingdee.eas.custom.salepayment.ILongTimeArAmountEntry.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.ILongTimeArAmountEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ILongTimeArAmountEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("70A9A6AC") ,com.kingdee.eas.custom.salepayment.ILongTimeArAmountEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.ILongTimeArAmountEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ILongTimeArAmountEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("70A9A6AC"));
    }
    public static com.kingdee.eas.custom.salepayment.ILongTimeArAmountEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ILongTimeArAmountEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("70A9A6AC"));
    }
}