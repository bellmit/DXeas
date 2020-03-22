package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SaleFeeInputEntryFactory
{
    private SaleFeeInputEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.ISaleFeeInputEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISaleFeeInputEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7AD49973") ,com.kingdee.eas.custom.salepayment.ISaleFeeInputEntry.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.ISaleFeeInputEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISaleFeeInputEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7AD49973") ,com.kingdee.eas.custom.salepayment.ISaleFeeInputEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.ISaleFeeInputEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISaleFeeInputEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7AD49973"));
    }
    public static com.kingdee.eas.custom.salepayment.ISaleFeeInputEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISaleFeeInputEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7AD49973"));
    }
}