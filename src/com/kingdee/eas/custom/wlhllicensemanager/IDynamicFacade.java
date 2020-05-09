package com.kingdee.eas.custom.wlhllicensemanager;

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

public interface IDynamicFacade extends IBizCtrl
{
    public String getDataByID(String jsonStr) throws BOSException, EASBizException;
    public String uploadDataByBosType(String bosType, String jsonStr) throws BOSException, EASBizException;
    public String downloadBillList(String jsonStr) throws BOSException, EASBizException;
    public String deleteAttachment(String jsonStr) throws BOSException, EASBizException;
    public String getEumInfo(String enumPathJson) throws BOSException, EASBizException;
}