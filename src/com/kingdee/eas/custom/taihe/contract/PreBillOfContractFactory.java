package com.kingdee.eas.custom.taihe.contract;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class PreBillOfContractFactory
{
    private PreBillOfContractFactory()
    {
    }
    public static com.kingdee.eas.custom.taihe.contract.IPreBillOfContract getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IPreBillOfContract)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("D4B2F957") ,com.kingdee.eas.custom.taihe.contract.IPreBillOfContract.class);
    }
    
    public static com.kingdee.eas.custom.taihe.contract.IPreBillOfContract getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IPreBillOfContract)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("D4B2F957") ,com.kingdee.eas.custom.taihe.contract.IPreBillOfContract.class, objectCtx);
    }
    public static com.kingdee.eas.custom.taihe.contract.IPreBillOfContract getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IPreBillOfContract)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("D4B2F957"));
    }
    public static com.kingdee.eas.custom.taihe.contract.IPreBillOfContract getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.taihe.contract.IPreBillOfContract)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("D4B2F957"));
    }
}