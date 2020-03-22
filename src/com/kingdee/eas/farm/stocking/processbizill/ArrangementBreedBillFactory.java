package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ArrangementBreedBillFactory
{
    private ArrangementBreedBillFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IArrangementBreedBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IArrangementBreedBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("229F1696") ,com.kingdee.eas.farm.stocking.processbizill.IArrangementBreedBill.class);
    }
    
    public static com.kingdee.eas.farm.stocking.processbizill.IArrangementBreedBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IArrangementBreedBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("229F1696") ,com.kingdee.eas.farm.stocking.processbizill.IArrangementBreedBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IArrangementBreedBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IArrangementBreedBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("229F1696"));
    }
    public static com.kingdee.eas.farm.stocking.processbizill.IArrangementBreedBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.processbizill.IArrangementBreedBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("229F1696"));
    }
}