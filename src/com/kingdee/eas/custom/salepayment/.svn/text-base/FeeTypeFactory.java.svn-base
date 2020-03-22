package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class FeeTypeFactory
{
    private FeeTypeFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.IFeeType getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IFeeType)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1EA9126C") ,com.kingdee.eas.custom.salepayment.IFeeType.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.IFeeType getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IFeeType)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1EA9126C") ,com.kingdee.eas.custom.salepayment.IFeeType.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.IFeeType getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IFeeType)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1EA9126C"));
    }
    public static com.kingdee.eas.custom.salepayment.IFeeType getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.IFeeType)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1EA9126C"));
    }
}