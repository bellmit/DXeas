package com.kingdee.eas.custom.commonld;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public interface ICommFacade extends IBizCtrl
{
    public void excuteUpdateSql(String str) throws BOSException, EASBizException;
    public Date getDateFromServer() throws BOSException;
}