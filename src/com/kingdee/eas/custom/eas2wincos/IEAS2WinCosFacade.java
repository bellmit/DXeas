package com.kingdee.eas.custom.eas2wincos;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public interface IEAS2WinCosFacade extends IBizCtrl
{
    public String importBill(String companyID, String jsonStr, int sourceType) throws BOSException, EASBizException;
    public String exportBill(String companyID, String jsonStr, int sourceType) throws BOSException, EASBizException;
}