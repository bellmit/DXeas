package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CKWeightBillEntryDetailFactory
{
    private CKWeightBillEntryDetailFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBillEntryDetail getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBillEntryDetail)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("16D53E9F") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBillEntryDetail.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBillEntryDetail getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBillEntryDetail)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("16D53E9F") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBillEntryDetail.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBillEntryDetail getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBillEntryDetail)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("16D53E9F"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBillEntryDetail getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKWeightBillEntryDetail)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("16D53E9F"));
    }
}