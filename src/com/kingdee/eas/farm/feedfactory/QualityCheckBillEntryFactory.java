package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class QualityCheckBillEntryFactory
{
    private QualityCheckBillEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.feedfactory.IQualityCheckBillEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IQualityCheckBillEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("1AC2DAC0") ,com.kingdee.eas.farm.feedfactory.IQualityCheckBillEntry.class);
    }
    
    public static com.kingdee.eas.farm.feedfactory.IQualityCheckBillEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IQualityCheckBillEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("1AC2DAC0") ,com.kingdee.eas.farm.feedfactory.IQualityCheckBillEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feedfactory.IQualityCheckBillEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IQualityCheckBillEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("1AC2DAC0"));
    }
    public static com.kingdee.eas.farm.feedfactory.IQualityCheckBillEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IQualityCheckBillEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("1AC2DAC0"));
    }
}