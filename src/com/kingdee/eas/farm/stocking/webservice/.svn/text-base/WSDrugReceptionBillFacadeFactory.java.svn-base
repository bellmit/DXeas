package com.kingdee.eas.farm.stocking.webservice;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class WSDrugReceptionBillFacadeFactory
{
    private WSDrugReceptionBillFacadeFactory()
    {
    }
    public static com.kingdee.eas.farm.stocking.webservice.IWSDrugReceptionBillFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IWSDrugReceptionBillFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("2D82D696") ,com.kingdee.eas.farm.stocking.webservice.IWSDrugReceptionBillFacade.class);
    }
    
    public static com.kingdee.eas.farm.stocking.webservice.IWSDrugReceptionBillFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IWSDrugReceptionBillFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("2D82D696") ,com.kingdee.eas.farm.stocking.webservice.IWSDrugReceptionBillFacade.class, objectCtx);
    }
    public static com.kingdee.eas.farm.stocking.webservice.IWSDrugReceptionBillFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IWSDrugReceptionBillFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("2D82D696"));
    }
    public static com.kingdee.eas.farm.stocking.webservice.IWSDrugReceptionBillFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.farm.stocking.webservice.IWSDrugReceptionBillFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("2D82D696"));
    }
}