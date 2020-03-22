package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class OtherPaymentTypeFactory
{
    private OtherPaymentTypeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IOtherPaymentType getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IOtherPaymentType)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("545E1A81") ,com.kingdee.eas.farm.stocking.basedata.IOtherPaymentType.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IOtherPaymentType getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IOtherPaymentType)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("545E1A81") ,com.kingdee.eas.farm.stocking.basedata.IOtherPaymentType.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IOtherPaymentType getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IOtherPaymentType)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("545E1A81"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IOtherPaymentType getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IOtherPaymentType)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("545E1A81"));
    }
}