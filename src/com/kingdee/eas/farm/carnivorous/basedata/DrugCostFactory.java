package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DrugCostFactory
{
    private DrugCostFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IDrugCost getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IDrugCost)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("59AAD32F") ,com.kingdee.eas.farm.carnivorous.basedata.IDrugCost.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IDrugCost getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IDrugCost)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("59AAD32F") ,com.kingdee.eas.farm.carnivorous.basedata.IDrugCost.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IDrugCost getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IDrugCost)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("59AAD32F"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IDrugCost getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IDrugCost)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("59AAD32F"));
    }
}