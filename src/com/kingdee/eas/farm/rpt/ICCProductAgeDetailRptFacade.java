package com.kingdee.eas.farm.rpt;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.framework.*;
import java.util.HashMap;
import com.kingdee.bos.util.*;

public interface ICCProductAgeDetailRptFacade extends IBizCtrl
{
    public IRowSet getRptData(HashMap param) throws BOSException;
}