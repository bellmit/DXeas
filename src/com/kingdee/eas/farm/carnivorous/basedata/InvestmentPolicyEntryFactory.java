package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class InvestmentPolicyEntryFactory
{
    private InvestmentPolicyEntryFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicyEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicyEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("60E10D2B") ,com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicyEntry.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicyEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicyEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("60E10D2B") ,com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicyEntry.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicyEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicyEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("60E10D2B"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicyEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicyEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("60E10D2B"));
    }
}