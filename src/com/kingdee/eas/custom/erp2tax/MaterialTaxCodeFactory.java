package com.kingdee.eas.custom.erp2tax;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MaterialTaxCodeFactory
{
    private MaterialTaxCodeFactory()
    {
    }
    public static com.kingdee.eas.custom.erp2tax.IMaterialTaxCode getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.erp2tax.IMaterialTaxCode)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("E13EE15A") ,com.kingdee.eas.custom.erp2tax.IMaterialTaxCode.class);
    }
    
    public static com.kingdee.eas.custom.erp2tax.IMaterialTaxCode getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.erp2tax.IMaterialTaxCode)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("E13EE15A") ,com.kingdee.eas.custom.erp2tax.IMaterialTaxCode.class, objectCtx);
    }
    public static com.kingdee.eas.custom.erp2tax.IMaterialTaxCode getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.erp2tax.IMaterialTaxCode)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("E13EE15A"));
    }
    public static com.kingdee.eas.custom.erp2tax.IMaterialTaxCode getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.erp2tax.IMaterialTaxCode)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("E13EE15A"));
    }
}