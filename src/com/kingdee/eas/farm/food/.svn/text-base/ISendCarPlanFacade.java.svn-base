package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import java.util.ArrayList;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import java.util.HashMap;
import com.kingdee.bos.util.*;

public interface ISendCarPlanFacade extends IBizCtrl
{
    public ArrayList getRowSet(HashMap hashMap) throws BOSException, EASBizException;
    public ArrayList getCCBatchAgeAndQty(Date bizDate, int breedDays, int count) throws BOSException;
}