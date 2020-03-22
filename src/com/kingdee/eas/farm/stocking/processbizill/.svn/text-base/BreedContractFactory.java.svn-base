package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class BreedContractFactory
{
    private BreedContractFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBreedContract getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBreedContract)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2CAB4B61") ,com.kingdee.eas.farm.stocking.processbizill.IBreedContract.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IBreedContract getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBreedContract)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2CAB4B61") ,com.kingdee.eas.farm.stocking.processbizill.IBreedContract.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBreedContract getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBreedContract)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2CAB4B61"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IBreedContract getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IBreedContract)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2CAB4B61"));
    }
}