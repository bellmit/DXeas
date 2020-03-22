package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedContractEntryFactory
{
    private BreedContractEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBreedContractEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBreedContractEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("AB31C191") ,com.kingdee.eas.farm.stocking.processbizill.IBreedContractEntry.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IBreedContractEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBreedContractEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("AB31C191") ,com.kingdee.eas.farm.stocking.processbizill.IBreedContractEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBreedContractEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBreedContractEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("AB31C191"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBreedContractEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBreedContractEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("AB31C191"));
    }
}