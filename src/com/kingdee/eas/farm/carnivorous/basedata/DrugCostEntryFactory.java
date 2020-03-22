package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class DrugCostEntryFactory
{
    private DrugCostEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IDrugCostEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IDrugCostEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8354EA83") ,com.kingdee.eas.farm.carnivorous.basedata.IDrugCostEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IDrugCostEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IDrugCostEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8354EA83") ,com.kingdee.eas.farm.carnivorous.basedata.IDrugCostEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IDrugCostEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IDrugCostEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8354EA83"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IDrugCostEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IDrugCostEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8354EA83"));
    }
}