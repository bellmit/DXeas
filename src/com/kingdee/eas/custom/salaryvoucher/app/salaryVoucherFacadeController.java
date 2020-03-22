package com.kingdee.eas.custom.salaryvoucher.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.salaryvoucher.SalaryVoucherInfo;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface salaryVoucherFacadeController extends BizController
{
    public String[] createSalaryVoucher(Context ctx, PeriodInfo periodInfo, SalaryVoucherInfo salaryVoucher, String[] conInfo) throws BOSException, RemoteException;
    public String[] getSHRPerson(Context ctx, String EASNumber, String[] conInfo) throws BOSException, RemoteException;
    public String getSHRAdmin(Context ctx, String sHRAdminCode, String[] conInfo) throws BOSException, RemoteException;
    public boolean getbooleanAdminOrgUnit(Context ctx, String personNum) throws BOSException, RemoteException;
    public void updateSCalScheme(Context ctx, String[] conInfo) throws BOSException, RemoteException;
    public void updateCmpItem(Context ctx, String[] conInfo) throws BOSException, RemoteException;
    public boolean getConnection(Context ctx, String[] conInfo) throws BOSException, RemoteException;
}