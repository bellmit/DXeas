package com.kingdee.eas.custom.emt;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public interface IWSEmtDataFacade extends IBizCtrl
{
    public String getUserFeedInfo(String lastUpdateDate) throws BOSException;
    public String getUserFeedBatchInfo(String lastUpdateTime) throws BOSException;
    public String getUserInComeInfo(String lastUpdateTime) throws BOSException;
    public String getUserPayInfo(String lastUpdateTime) throws BOSException;
}