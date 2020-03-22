package com.kingdee.eas.weighbridge;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public interface ICommSqlFacade extends IBizCtrl
{
    public IRowSet executeQuery(String sqlStr) throws BOSException;
    public IRowSet executeQuery(String sqlStr, Object[] params) throws BOSException;
    public void execute(String sqlStr) throws BOSException;
    public void execute(String sqlStr, Object[] params) throws BOSException;
}