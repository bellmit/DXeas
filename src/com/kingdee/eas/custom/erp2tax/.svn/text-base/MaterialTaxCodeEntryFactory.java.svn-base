package com.kingdee.eas.custom.erp2tax;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class MaterialTaxCodeEntryFactory
{
    private MaterialTaxCodeEntryFactory()
    {
    }
    public static com.kingdee.eas.custom.erp2tax.IMaterialTaxCodeEntry getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.erp2tax.IMaterialTaxCodeEntry)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C579FF38") ,com.kingdee.eas.custom.erp2tax.IMaterialTaxCodeEntry.class);
    }
    
    public static com.kingdee.eas.custom.erp2tax.IMaterialTaxCodeEntry getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.erp2tax.IMaterialTaxCodeEntry)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C579FF38") ,com.kingdee.eas.custom.erp2tax.IMaterialTaxCodeEntry.class, objectCtx);
    }
    public static com.kingdee.eas.custom.erp2tax.IMaterialTaxCodeEntry getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.erp2tax.IMaterialTaxCodeEntry)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C579FF38"));
    }
    public static com.kingdee.eas.custom.erp2tax.IMaterialTaxCodeEntry getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.erp2tax.IMaterialTaxCodeEntry)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C579FF38"));
    }
}