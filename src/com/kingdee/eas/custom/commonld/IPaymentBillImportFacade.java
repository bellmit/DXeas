package com.kingdee.eas.custom.commonld;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import java.util.HashMap;
import com.kingdee.bos.util.*;

public interface IPaymentBillImportFacade extends IBizCtrl
{
    public HashMap importPaymentBill(HashMap param) throws BOSException, EASBizException;
}