package com.kingdee.eas.spray.webservices;

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

public interface IWSSprayFacade extends IBizCtrl
{
    public String getNowBalance(String jsonStr) throws BOSException;
    public String uploadUseRecord(String jsonStr) throws BOSException;
}