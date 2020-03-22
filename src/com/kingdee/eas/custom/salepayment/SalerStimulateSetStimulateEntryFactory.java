package com.kingdee.eas.custom.salepayment;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class SalerStimulateSetStimulateEntryFactory
{
    private SalerStimulateSetStimulateEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.salepayment.ISalerStimulateSetStimulateEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISalerStimulateSetStimulateEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("741CB8BF") ,com.kingdee.eas.custom.salepayment.ISalerStimulateSetStimulateEntry.class);
    }
    
    public static com.kingdee.eas.custom.salepayment.ISalerStimulateSetStimulateEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISalerStimulateSetStimulateEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("741CB8BF") ,com.kingdee.eas.custom.salepayment.ISalerStimulateSetStimulateEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salepayment.ISalerStimulateSetStimulateEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISalerStimulateSetStimulateEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("741CB8BF"));
    }
    public static com.kingdee.eas.custom.salepayment.ISalerStimulateSetStimulateEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salepayment.ISalerStimulateSetStimulateEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("741CB8BF"));
    }
}