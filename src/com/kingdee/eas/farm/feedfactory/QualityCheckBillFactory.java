package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class QualityCheckBillFactory
{
    private QualityCheckBillFactory()
    {
    }
    public static com.kingdee.eas.farm.feedfactory.IQualityCheckBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IQualityCheckBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D62CF0D2") ,com.kingdee.eas.farm.feedfactory.IQualityCheckBill.class);
    }
    
    public static com.kingdee.eas.farm.feedfactory.IQualityCheckBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IQualityCheckBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D62CF0D2") ,com.kingdee.eas.farm.feedfactory.IQualityCheckBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.feedfactory.IQualityCheckBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IQualityCheckBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D62CF0D2"));
    }
    public static com.kingdee.eas.farm.feedfactory.IQualityCheckBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.feedfactory.IQualityCheckBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D62CF0D2"));
    }
}