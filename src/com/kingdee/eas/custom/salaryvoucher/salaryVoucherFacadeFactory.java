package com.kingdee.eas.custom.salaryvoucher;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.Context;

public class salaryVoucherFacadeFactory
{
    private salaryVoucherFacadeFactory()
    {
    }
    public static com.kingdee.eas.custom.salaryvoucher.IsalaryVoucherFacade getRemoteInstance() throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.IsalaryVoucherFacade)BOSObjectFactory.createRemoteBOSObject(new BOSObjectType("8582D4AF") ,com.kingdee.eas.custom.salaryvoucher.IsalaryVoucherFacade.class);
    }
    
    public static com.kingdee.eas.custom.salaryvoucher.IsalaryVoucherFacade getRemoteInstanceWithObjectContext(Context objectCtx) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.IsalaryVoucherFacade)BOSObjectFactory.createRemoteBOSObjectWithObjectContext(new BOSObjectType("8582D4AF") ,com.kingdee.eas.custom.salaryvoucher.IsalaryVoucherFacade.class, objectCtx);
    }
    public static com.kingdee.eas.custom.salaryvoucher.IsalaryVoucherFacade getLocalInstance(Context ctx) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.IsalaryVoucherFacade)BOSObjectFactory.createBOSObject(ctx, new BOSObjectType("8582D4AF"));
    }
    public static com.kingdee.eas.custom.salaryvoucher.IsalaryVoucherFacade getLocalInstance(String sessionID) throws BOSException
    {
        return (com.kingdee.eas.custom.salaryvoucher.IsalaryVoucherFacade)BOSObjectFactory.createBOSObject(sessionID, new BOSObjectType("8582D4AF"));
    }
}