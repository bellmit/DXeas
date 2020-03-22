package com.kingdee.eas.custom.salediscount.rpt;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MainBusinessProfitRptFacadeFactory
{
    private MainBusinessProfitRptFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.salediscount.rpt.IMainBusinessProfitRptFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.IMainBusinessProfitRptFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("94A7DFA0") ,com.kingdee.eas.custom.salediscount.rpt.IMainBusinessProfitRptFacade.class);
    }
    
    public static com.kingdee.eas.custom.salediscount.rpt.IMainBusinessProfitRptFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.IMainBusinessProfitRptFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("94A7DFA0") ,com.kingdee.eas.custom.salediscount.rpt.IMainBusinessProfitRptFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salediscount.rpt.IMainBusinessProfitRptFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.IMainBusinessProfitRptFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("94A7DFA0"));
    }
    public static com.kingdee.eas.custom.salediscount.rpt.IMainBusinessProfitRptFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.IMainBusinessProfitRptFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("94A7DFA0"));
    }
}