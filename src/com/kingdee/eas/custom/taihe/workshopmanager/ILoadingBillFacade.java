package com.kingdee.eas.custom.taihe.workshopmanager;

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

public interface ILoadingBillFacade extends IBizCtrl
{
    public String downloadData(String jsonStr) throws BOSException;
    public String uploadData(String jsonStr) throws BOSException;
    public String queryData(String jsonStr) throws BOSException;
    public String create2SaleIssure(String jsonStr) throws BOSException, EASBizException;
    public String finishLoading(String jsonStr) throws BOSException;
    public String deleteData(String jsonStr) throws BOSException;
}