package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SaleFeeInputFactory
{
    private SaleFeeInputFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.ISaleFeeInput getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISaleFeeInput)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B5F58E3F") ,com.kingdee.eas.custom.salepayment.ISaleFeeInput.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.ISaleFeeInput getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISaleFeeInput)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B5F58E3F") ,com.kingdee.eas.custom.salepayment.ISaleFeeInput.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.ISaleFeeInput getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISaleFeeInput)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B5F58E3F"));
    }
    public static com.kingdee.eas.custom.salepayment.ISaleFeeInput getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISaleFeeInput)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B5F58E3F"));
    }
}