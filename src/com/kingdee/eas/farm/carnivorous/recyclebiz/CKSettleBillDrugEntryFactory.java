package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CKSettleBillDrugEntryFactory
{
    private CKSettleBillDrugEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillDrugEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillDrugEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("7F3D3AFB") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillDrugEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillDrugEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillDrugEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("7F3D3AFB") ,com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillDrugEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillDrugEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillDrugEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("7F3D3AFB"));
    }
    public static com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillDrugEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ICKSettleBillDrugEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("7F3D3AFB"));
    }
}