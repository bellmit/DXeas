package com.kingdee.eas.farm.pig.breedingsow;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class CheckHeatBillFactory
{
    private CheckHeatBillFactory()
    {
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ICheckHeatBill getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ICheckHeatBill)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2E0136BE") ,com.kingdee.eas.farm.pig.breedingsow.ICheckHeatBill.class);
    }
    
    public static com.kingdee.eas.farm.pig.breedingsow.ICheckHeatBill getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ICheckHeatBill)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2E0136BE") ,com.kingdee.eas.farm.pig.breedingsow.ICheckHeatBill.class, objectCtx);
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ICheckHeatBill getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ICheckHeatBill)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2E0136BE"));
    }
    public static com.kingdee.eas.farm.pig.breedingsow.ICheckHeatBill getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.pig.breedingsow.ICheckHeatBill)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2E0136BE"));
    }
}