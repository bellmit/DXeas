package com.kingdee.eas.custom.wages;

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

public interface IgetWorkmonthFacade extends IBizCtrl
{
    public int getworkmonth(String date) throws BOSException;
    public String getdkgs(String yssd, String companyID) throws BOSException;
    public String getDaySub(String begindate, String enddate) throws BOSException;
}