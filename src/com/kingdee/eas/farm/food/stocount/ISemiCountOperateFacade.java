package com.kingdee.eas.farm.food.stocount;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import java.util.HashMap;
import com.kingdee.bos.util.*;

public interface ISemiCountOperateFacade extends IBizCtrl
{
    public HashMap semiset(String personid) throws BOSException;
    public HashMap productset(String personid) throws BOSException;
}