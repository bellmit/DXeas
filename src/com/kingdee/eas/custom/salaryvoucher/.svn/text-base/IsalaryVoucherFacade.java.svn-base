package com.kingdee.eas.custom.salaryvoucher;

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
import com.kingdee.bos.util.*;

public interface IsalaryVoucherFacade extends IBizCtrl
{
    public String[] createSalaryVoucher(PeriodInfo periodInfo, SalaryVoucherInfo salaryVoucher, String[] conInfo) throws BOSException;
    public String[] getSHRPerson(String EASNumber, String[] conInfo) throws BOSException;
    public String getSHRAdmin(String sHRAdminCode, String[] conInfo) throws BOSException;
    public boolean getbooleanAdminOrgUnit(String personNum) throws BOSException;
    public void updateSCalScheme(String[] conInfo) throws BOSException;
    public void updateCmpItem(String[] conInfo) throws BOSException;
    public boolean getConnection(String[] conInfo) throws BOSException;
}