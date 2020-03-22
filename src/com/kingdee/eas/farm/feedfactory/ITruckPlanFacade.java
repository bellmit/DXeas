package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.util.Map;
import java.util.List;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public interface ITruckPlanFacade extends IBizCtrl
{
    public List getFodderPlandetails(Date planDate) throws BOSException;
    public FeedFactoryBaseDataInfo getFeedFactoryBaseData() throws BOSException;
    public Map getDistanseSetinfo() throws BOSException;
}