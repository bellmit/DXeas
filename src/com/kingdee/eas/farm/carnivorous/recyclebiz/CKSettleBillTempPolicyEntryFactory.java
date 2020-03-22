package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CKSettleBillTempPolicyEntryFactory
{
    private CKSettleBillTempPolicyEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillTempPolicyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillTempPolicyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B3004D75") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillTempPolicyEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillTempPolicyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillTempPolicyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B3004D75") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillTempPolicyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillTempPolicyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillTempPolicyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B3004D75"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillTempPolicyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillTempPolicyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B3004D75"));
    }
}