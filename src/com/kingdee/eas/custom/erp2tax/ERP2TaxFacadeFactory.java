package com.kingdee.eas.custom.erp2tax;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ERP2TaxFacadeFactory
{
    private ERP2TaxFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.erp2tax.IERP2TaxFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.erp2tax.IERP2TaxFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("9BA5303F") ,com.kingdee.eas.custom.erp2tax.IERP2TaxFacade.class);
    }
    
    public static com.kingdee.eas.custom.erp2tax.IERP2TaxFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.erp2tax.IERP2TaxFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("9BA5303F") ,com.kingdee.eas.custom.erp2tax.IERP2TaxFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.erp2tax.IERP2TaxFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.erp2tax.IERP2TaxFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("9BA5303F"));
    }
    public static com.kingdee.eas.custom.erp2tax.IERP2TaxFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.erp2tax.IERP2TaxFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("9BA5303F"));
    }
}