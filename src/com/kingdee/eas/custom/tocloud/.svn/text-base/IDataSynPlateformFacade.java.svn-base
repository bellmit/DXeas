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
import com.kingdee.eas.common.EASAppException;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public interface IDataSynPlateformFacade extends IBizCtrl
{
    public String login() throws BOSException;
    public String getBillList(String param) throws BOSException, EASBizException;
    public String getBillHeader(String param) throws BOSException, EASBizException;
    public String synData(String jsonParam) throws BOSException, EASAppException;
}