package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedStandardDrugEntryFactory
{
    private BreedStandardDrugEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedStandardDrugEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedStandardDrugEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C82AA7F2") ,com.kingdee.eas.farm.stocking.basedata.IBreedStandardDrugEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.basedata.IBreedStandardDrugEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedStandardDrugEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C82AA7F2") ,com.kingdee.eas.farm.stocking.basedata.IBreedStandardDrugEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedStandardDrugEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedStandardDrugEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C82AA7F2"));
    }
    public static com.kingdee.eas.farm.stocking.basedata.IBreedStandardDrugEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.basedata.IBreedStandardDrugEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C82AA7F2"));
    }
}