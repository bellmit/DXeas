package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class ContractPaymentFactory
{
    private ContractPaymentFactory()
    {
    }
    public static com.kingdee.eas.custom.signwasthetable.IContractPayment getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IContractPayment)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("C410D04A") ,com.kingdee.eas.custom.signwasthetable.IContractPayment.class);
    }
    
    public static com.kingdee.eas.custom.signwasthetable.IContractPayment getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IContractPayment)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("C410D04A") ,com.kingdee.eas.custom.signwasthetable.IContractPayment.class, objectCtx);
    }
    public static com.kingdee.eas.custom.signwasthetable.IContractPayment getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IContractPayment)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("C410D04A"));
    }
    public static com.kingdee.eas.custom.signwasthetable.IContractPayment getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.signwasthetable.IContractPayment)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("C410D04A"));
    }
}