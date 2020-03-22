package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CCPigBatchPigDetailFactory
{
    private CCPigBatchPigDetailFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBatchPigDetail getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBatchPigDetail)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("64DE9973") ,com.kingdee.eas.farm.pig.ccpig.ICCPigBatchPigDetail.class);
    }
    
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBatchPigDetail getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBatchPigDetail)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("64DE9973") ,com.kingdee.eas.farm.pig.ccpig.ICCPigBatchPigDetail.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBatchPigDetail getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBatchPigDetail)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("64DE9973"));
    }
    public static com.kingdee.eas.farm.pig.ccpig.ICCPigBatchPigDetail getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.ccpig.ICCPigBatchPigDetail)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("64DE9973"));
    }
}