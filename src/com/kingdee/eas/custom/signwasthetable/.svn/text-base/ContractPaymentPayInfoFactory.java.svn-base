package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ContractPaymentPayInfoFactory
{
    private ContractPaymentPayInfoFactory()
    {
    }
    public static com.kingdee.eas.custom.signwasthetable.IContractPaymentPayInfo getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IContractPaymentPayInfo)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("B9C0B5CC") ,com.kingdee.eas.custom.signwasthetable.IContractPaymentPayInfo.class);
    }
    
    public static com.kingdee.eas.custom.signwasthetable.IContractPaymentPayInfo getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IContractPaymentPayInfo)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("B9C0B5CC") ,com.kingdee.eas.custom.signwasthetable.IContractPaymentPayInfo.class, objectCtx);
    }
    public static com.kingdee.eas.custom.signwasthetable.IContractPaymentPayInfo getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IContractPaymentPayInfo)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("B9C0B5CC"));
    }
    public static com.kingdee.eas.custom.signwasthetable.IContractPaymentPayInfo getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IContractPaymentPayInfo)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("B9C0B5CC"));
    }
}