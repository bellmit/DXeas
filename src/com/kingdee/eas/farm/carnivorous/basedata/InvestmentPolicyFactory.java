package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class InvestmentPolicyFactory
{
    private InvestmentPolicyFactory()
    {
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicy getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicy)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("CEEDA787") ,com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicy.class);
    }
    
    public static com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicy getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicy)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("CEEDA787") ,com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicy.class, objectCtx);
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicy getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicy)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("CEEDA787"));
    }
    public static com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicy getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.IInvestmentPolicy)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("CEEDA787"));
    }
}