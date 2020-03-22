package com.kingdee.eas.custom.tocloud;

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

public interface IDeleteCloudBill extends IBizCtrl
{
    public String deleteCloudBill(String param) throws BOSException, EASBizException;
    public String getCostValue(String param) throws BOSException, EASBizException;
    public String saveBill(String param) throws BOSException;
    public String submitBill(String param) throws BOSException;
    public String auditBill(String param) throws BOSException;
}