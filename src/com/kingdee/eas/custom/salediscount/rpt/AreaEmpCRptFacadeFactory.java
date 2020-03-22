package com.kingdee.eas.custom.salediscount.rpt;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class AreaEmpCRptFacadeFactory
{
    private AreaEmpCRptFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.salediscount.rpt.IAreaEmpCRptFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.IAreaEmpCRptFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("FAEDB9D5") ,com.kingdee.eas.custom.salediscount.rpt.IAreaEmpCRptFacade.class);
    }
    
    public static com.kingdee.eas.custom.salediscount.rpt.IAreaEmpCRptFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.IAreaEmpCRptFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("FAEDB9D5") ,com.kingdee.eas.custom.salediscount.rpt.IAreaEmpCRptFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salediscount.rpt.IAreaEmpCRptFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.IAreaEmpCRptFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("FAEDB9D5"));
    }
    public static com.kingdee.eas.custom.salediscount.rpt.IAreaEmpCRptFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salediscount.rpt.IAreaEmpCRptFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("FAEDB9D5"));
    }
}