package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class QcBillEntryDetailFactory
{
    private QcBillEntryDetailFactory()
    {
    }
    public static com.kingdee.eas.weighbridge.IQcBillEntryDetail getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IQcBillEntryDetail)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("070425EF") ,com.kingdee.eas.weighbridge.IQcBillEntryDetail.class);
    }
    
    public static com.kingdee.eas.weighbridge.IQcBillEntryDetail getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IQcBillEntryDetail)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("070425EF") ,com.kingdee.eas.weighbridge.IQcBillEntryDetail.class, objectCtx);
    }
    public static com.kingdee.eas.weighbridge.IQcBillEntryDetail getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IQcBillEntryDetail)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("070425EF"));
    }
    public static com.kingdee.eas.weighbridge.IQcBillEntryDetail getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.weighbridge.IQcBillEntryDetail)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("070425EF"));
    }
}