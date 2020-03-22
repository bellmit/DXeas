/**
 * output package name
 */
package com.kingdee.eas.custom.wages.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.kscript.debug.SetValue;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.wages.BasicPostFactory;
import com.kingdee.eas.custom.wages.BasicPostInfo;
import com.kingdee.eas.custom.wages.CoefficientFactory;
import com.kingdee.eas.custom.wages.CoefficientInfo;
import com.kingdee.eas.custom.wages.FractionBill;
import com.kingdee.eas.custom.wages.FractionBillEntryCollection;
import com.kingdee.eas.custom.wages.FractionBillEntryInfo;
import com.kingdee.eas.custom.wages.MonthWagesEntryCollection;
import com.kingdee.eas.custom.wages.MonthWagesEntryInfo;
import com.kingdee.eas.custom.wages.byThePieceUnit;
import com.kingdee.eas.custom.wages.classesState;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.excel.ExcelReadUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;

/**
 * output class name
 */
public class FractionBillEditUI extends AbstractFractionBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(FractionBillEditUI.class);
    
    /**
     * output class constructor
     */
    public FractionBillEditUI() throws Exception
    {
        super();
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.wages.FractionBillFactory.getRemoteInstance();
    }

    /**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
		
        return null;
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.wages.FractionBillInfo objectValue = new com.kingdee.eas.custom.wages.FractionBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        objectValue.setBizDate(new Date());
        return objectValue;
    }
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		kdtEntry.addKDTEditListener(new KDTEditListener(){
			public void editCanceled(KDTEditEvent paramKDTEditEvent) {
			}
			public void editStarted(KDTEditEvent paramKDTEditEvent) {
			}
			public void editStarting(KDTEditEvent paramKDTEditEvent) {
			}
			public void editStopped(KDTEditEvent paramKDTEditEvent) {
				for(int i= 0;i<kdtEntry.getRowCount();i++){
					if(kdtEntry.getRow(i).getCell("personRatio").getValue()!=null){
						BigDecimal a= getBigDecimal(kdtEntry.getRow(i).getCell("personRatio").getValue());
						if(a.compareTo(new BigDecimal(1))>0){
							kdtEntry.getRow(i).getCell("personRatio").setValue("1");
						}
					}
				}
//					if(kdtEntry.getRow(i).getCell("person").getValue()!=null){
						String fieldName = kdtEntry.getColumnKey(paramKDTEditEvent.getColIndex());
						int i = paramKDTEditEvent.getRowIndex();
						if("person".equalsIgnoreCase(fieldName)){
							
						
						PersonInfo info = (PersonInfo) kdtEntry.getRow(i).getCell("person").getValue();
						BasicPostInfo BPinfo = getPersonPost(info.getId().toString());
						if(BPinfo!=null){
							kdtEntry.getRow(i).getCell("personPost").setValue(BPinfo);
							System.out.println("----"+BPinfo.getPostname().toString());
							//基础资料岗位系数修改   20180425   yumingxu
							CoefficientInfo cfinfo;
							try {
								cfinfo = CoefficientFactory.getRemoteInstance().getCoefficientInfo(new ObjectUuidPK(BPinfo.getCoefficientRate().getId()));
								System.out.println("----"+cfinfo.getName().toString());
								kdtEntry.getRow(i).getCell("postRatio").setValue(new BigDecimal(getCoefficientRate(cfinfo.getId().toString())));
							} catch (EASBizException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (BOSException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
							
//							kdtEntry.getRow(i).getCell("postRatio").setValue(BPinfo.getCoefficient());
							kdtEntry.getRow(i).getCell("slaughterCt").setValue(BPinfo.getSlaughter());
							
						}else{
							kdtEntry.getRow(i).getCell("personPost").setValue(null);
							kdtEntry.getRow(i).getCell("postRatio").setValue(null);
							kdtEntry.getRow(i).getCell("slaughterCt").setValue(null);
						}
						
					}
				
			}
			public void editStopping(KDTEditEvent paramKDTEditEvent) {
			}
			public void editValueChanged(KDTEditEvent paramKDTEditEvent) {
			}});
		
		importPerson.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				getExcelMassage();
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
			}
			
		});	
		getPerson.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				if(pkBizDate.getValue()!=null&&prmtcompany.getValue()!=null){
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					Date date = (Date) pkBizDate.getValue();
					String dateString = formatter.format(date);
					String companyID = ((IPropertyContainer) prmtcompany.getValue()).getString("ID");
					kdtEntry.removeRows();
					getPerson(dateString,companyID);
				}else{
					MsgBox.showWarning("请填写完整的业务日期和公司");
				}
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
			}
		});
		calculation.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				for(int i =0;i<kdtEntry.getRowCount();i++){
					if(kdtEntry.getRow(i).getCell("slaughterQty").getValue()!=null&&kdtEntry.getRow(i).getCell("postRatio").getValue()!=null&&kdtEntry.getRow(i).getCell("personRatio").getValue()!=null&&kdtEntry.getRow(i).getCell("slaughterCt").getValue()!=null){
						  Double a=new Double(kdtEntry.getRow(i).getCell("slaughterQty").getValue().toString());
						  Double b=new Double(kdtEntry.getRow(i).getCell("postRatio").getValue().toString());
						  Double c=new Double(kdtEntry.getRow(i).getCell("personRatio").getValue().toString());
						  Double d=new Double(kdtEntry.getRow(i).getCell("slaughterCt").getValue().toString());
						  Double z = a/d*b*c;
						  kdtEntry.getRow(i).getCell("fraction").setValue(z);
						  if(StringUtils.isNotEmpty(txtscore.getText())){
							  Double x=new Double(txtscore.getText());
							 kdtEntry.getRow(i).getCell("dayWages").setValue(z*x);
						  }
					}
				}
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
			}
		});
	}
	//object 转 bigdecimal
	public static BigDecimal getBigDecimal( Object value ) {  
        BigDecimal ret = null;  
        if( value != null ) {  
            if( value instanceof BigDecimal ) {  
                ret = (BigDecimal) value;  
            } else if( value instanceof String ) {  
                ret = new BigDecimal( (String) value );  
            } else if( value instanceof BigInteger ) {  
                ret = new BigDecimal( (BigInteger) value );  
            } else if( value instanceof Number ) {  
                ret = new BigDecimal( ((Number)value).doubleValue() );  
            } else {  
                throw new ClassCastException("Not possible to coerce ["+value+"] from class "+value.getClass()+" into a BigDecimal.");  
            }  
        }  
        return ret;  
    }  
	
  //获取今日公司考勤管理中所有分数工资类
    private void getPerson(String date ,String companyID){
    	StringBuffer sb = new StringBuffer();
    	String sp = "\n";
    	sb.append("/*dialect*/").append(sp);
    	sb.append("select t1.CFClasses,t2.CFPersonNumID,t2.CFPersonPostID,nvl(t2.CFPersonRatio,1) CFPersonRatio from ").append(sp);
    	sb.append("CT_WAG_AttendanceBill 			t1").append(sp);
    	sb.append("	inner join CT_WAG_AttendanceBillEntry	t2	on t2.FParentID = t1.FID").append(sp);
    	sb.append("where to_char(t1.FbizDate,'yyyy-MM-dd')  = '").append(date).append("'").append(sp);
    	sb.append("and t1.CFCompanyID = '").append(companyID).append("'").append(sp);
    	sb.append("and t2.CFWagesType = '0' and FBillStatus = '4' ").append(sp);
    	sb.append("order by t1.CFClasses").append(sp);   	
    	IRowSet rs;
    	IRowSet rsQty;
    	StringBuffer sbQty = new StringBuffer();
    	sbQty.append("/*dialect*/").append(sp);
    	sbQty.append("select nvl(CFAfternoonQty,0) AfternoonQty,nvl(CFMorningQty,0) MorningQty, nvl(CFFinishedProductWgt,0) FinishedProductWgt,nvl(CFHalfWorkDay,0) HalfWorkDay from CT_SZC_FreshDaily ").append(sp);
    	sbQty.append("where CFCompanyID = '").append(companyID).append("' and to_char(FBizDate,'yyyy-MM-dd') = '").append(date).append("' and FProductType = '0' and FBillStatus = '4'").append(sp);
    	String AfternoonQty = null;
    	String MorningQty = null;
    	String FinishedProductWgt = null;
    	String HalfWorkDay = null;
		try {
			rsQty = SQLExecutorFactory.getRemoteInstance(sbQty.toString()).executeSQL();
			System.out.println(sbQty);
			if(rsQty.next()){
				AfternoonQty = rsQty.getString("AfternoonQty");
				MorningQty = rsQty.getString("MorningQty");
				FinishedProductWgt = rsQty.getString("FinishedProductWgt");
				HalfWorkDay = rsQty.getString("HalfWorkDay");
			}
			if(rsQty.size()<1){
				AfternoonQty = "0";
				MorningQty = "0";
				FinishedProductWgt = "0";
				HalfWorkDay = "1";
			}
			System.out.println(sb.toString());
			rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			while(rs.next()){
	    		IRow row = kdtEntry.addRow();
	    		PersonInfo personInfo = PersonFactory.getRemoteInstance().getPersonInfo(new ObjectUuidPK(rs.getString("CFpersonNumID")));
	    		row.getCell("person").setValue(personInfo);
	    		row.getCell("personName").setValue(personInfo.getName());
	    		BasicPostInfo bpInfoNow = BasicPostFactory.getRemoteInstance().getBasicPostInfo(new ObjectUuidPK(rs.getString("CFPersonPostID")));
	    		row.getCell("personPost").setValue(bpInfoNow);
	    		//基础资料岗位系数修改   20180425   yumingxu
	    		//row.getCell("postRatio").setValue(bpInfoNow.getCoefficient());
	    		System.out.println("----"+bpInfoNow.getPostname().toString());
	    		CoefficientInfo cfinfo = bpInfoNow.getCoefficientRate();
	    		System.out.println("--RATE--"+cfinfo.getId().toString());
	    		if(StringUtils.isBlank(cfinfo.getId().toString())){
	    			row.getCell("postRatio").setValue(new BigDecimal("0"));
	    		}else{
	    			row.getCell("postRatio").setValue(new BigDecimal(getCoefficientRate(cfinfo.getId().toString())));
	    		}
	    		
	    		
	    		row.getCell("slaughterCt").setValue(bpInfoNow.getSlaughter());
	    		row.getCell("fractionUnit").setValue(bpInfoNow.getUnitMetering());
	    		/*BasicPostInfo bpInfo = getPersonPost(rs.getString("CFpersonNumID"));
	    		row.getCell("personPost").setValue(bpInfo);
	    		row.getCell("postRatio").setValue(bpInfo.getCoefficient());
	    		row.getCell("slaughterCt").setValue(bpInfo.getSlaughter());
	    		row.getCell("fractionUnit").setValue(bpInfo.getUnitMetering());*/
	    		//row.getCell("personRatio").setValue(1);
	    		row.getCell("personRatio").setValue(rs.getString("CFPersonRatio"));
	    		
	    		
	    		if(rs.getString("CFClasses").equals("0")){
	    			row.getCell("classes").setValue(classesState.morning);
	    			//添加公斤数逻辑判断
		    		if(row.getCell("fractionUnit").getValue().toString().equals("公斤")){
		    			if(HalfWorkDay.equals("1")){
		    				row.getCell("slaughterQty").setValue(FinishedProductWgt);
		    			}else{
		    				row.getCell("slaughterQty").setValue(new BigDecimal(FinishedProductWgt).divide(new BigDecimal("2")));
		    			}	
		    		}else{
		    			row.getCell("slaughterQty").setValue(MorningQty);
		    		}
	    		}else{
	    			row.getCell("classes").setValue(classesState.afternoon);
	    			//添加公斤数逻辑判断
		    		if(row.getCell("fractionUnit").getValue().toString().equals("公斤")){
		    			if(HalfWorkDay.equals("1")){
		    				row.getCell("slaughterQty").setValue(FinishedProductWgt);
		    			}else{
		    				row.getCell("slaughterQty").setValue(new BigDecimal(FinishedProductWgt).divide(new BigDecimal("2")));
		    			}	
		    		}else{
		    			row.getCell("slaughterQty").setValue(AfternoonQty);
		    		}
	    		}
	    		
	    		
	    	}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
  //获取员工基础岗位
    private BasicPostInfo getPersonPost(String string) {
    	BasicPostInfo reBPInfo = null;
    	StringBuffer sb = new StringBuffer();
    	String sp = "\n";
    	sb.append("select t1.FID FID from ").append(sp);
    	sb.append("	CT_WAG_BasicPost 			t1").append(sp);
    	sb.append("	inner join CT_WAG_BasicPostEntry		t2	on t2.FParentID = t1.FID").append(sp);
    	sb.append("	where t2.CFPersonID = '").append(string).append("'").append(sp);
    	try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			if(rs.next()){
				reBPInfo = BasicPostFactory.getRemoteInstance().getBasicPostInfo(new ObjectUuidPK(rs.getString("FID")));
				
			}else{
				return reBPInfo;
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return reBPInfo;
    }
  //导入excel文件至单据分录
	private void getExcelMassage(){
		Map<Integer,Map<Integer,Object>> excelValues = ExcelReadUtil.getExcelData();
		if(excelValues != null){
			PersonInfo p = new PersonInfo();
			//BasicPostInfo b = new BasicPostInfo();
			for(int i = 2; i <= excelValues.size(); i++){
				Map<Integer,Object> rowValues = new HashMap<Integer, Object>(); 
				rowValues = excelValues.get(i);
				if(rowValues.values() == null) continue;
				IRow row = null;
				String personid = "";
				boolean begin = true;
				for (Integer in : rowValues.keySet()) {
					//map.keySet()返回的是所有key的值					
					Object obj = rowValues.get(in);//得到每个key对应value的值
					if(begin&&rowValues.get(1)!=null){
						row = kdtEntry.addRow();
						begin = false;
					}
					switch(in){
					case 1://员工姓名
						if(obj != null){
							personid = getPersonID(obj.toString());
							if(StringUtils.isEmpty(personid)){
								break;
							}else{
								try {
									p = PersonFactory.getRemoteInstance().getPersonInfo(new ObjectUuidPK(personid));
								} catch (EASBizException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (BOSException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								row.getCell(in).setValue(p);
								row.getCell(in+1).setValue(p.getName());
								BasicPostInfo info = getPersonPost(p.getId().toString());
								if(info!=null){
									row.getCell(in+2).setValue(info);
									row.getCell(in+3).setValue(info.getCoefficientRate());
									row.getCell(in+4).setValue(info.getSlaughter());
								}
								
								
							}	
						}
						break;
					case 2:
						if(obj != null){
							row.getCell(in+4).setValue(obj);
						}
						break;
					case 3:
						if(obj != null){
							row.getCell(in+4).setValue(obj);
						}
						break;
					case 4:
						if(obj != null){
							String objS = (String)obj;
							if(objS.equals("公斤")){
								row.getCell(in+4).setValue(byThePieceUnit.getEnumList().get(0));
							}else if(objS.equals("只数")){
								row.getCell(in+4).setValue(byThePieceUnit.getEnumList().get(1));
							}else{
								
							}
							
							
						}
						break;
					case 5:
						if(obj != null){
							row.getCell(in+4).setValue(obj);
						}
						break;
					case 6:
						if(obj != null){
							row.getCell(in+4).setValue(obj);
						}
						break;
					}	
				}
			}
		}
	}
	//用户名获取用户id
	private String getPersonID(String personnumber) {
		String personID = null ;
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("select FID from ").append(sp);
		sql.append("T_BD_Person ").append(sp);
		//sql.append("inner join T_BD_Person  t2  on t2.FID = t1.FPersonID").append(sp);
		sql.append("where FName_l2 ='").append(personnumber).append("'").append(sp);
		System.out.println("获取用户id"+sql.toString());
		IRowSet rs;
		try {
			rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			
			while(rs.next()){
				personID = rs.getString("FID");
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return personID;
	}
	//获取岗位系数
	private String getCoefficientRate(String id) {
		String personID = null ;
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("select CFCoefficientRate rate from ").append(sp);
		sql.append("CT_WAG_Coefficient ").append(sp);
		//sql.append("inner join T_BD_Person  t2  on t2.FID = t1.FPersonID").append(sp);
		sql.append("where FID ='").append(id).append("'").append(sp);
		//System.out.println("获取用户id"+sql.toString());
		IRowSet rs;
		try {
			rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			
			while(rs.next()){
				personID = rs.getString("rate");
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return personID;
	}
	/**
     * output actionSubmit_actionPerformed
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = (Date) pkBizDate.getValue();
		String companyID = ((IPropertyContainer) prmtcompany.getValue()).getString("ID");
		String dateString = formatter.format(date);
    	StringBuffer sb = new StringBuffer();
    	String sp = "\n";
    	sb.append("/*dialect*/").append(sp);
    	sb.append("select t2.CFPersonNumID from ").append(sp);
    	sb.append("CT_WAG_AttendanceBill 			t1").append(sp);
    	sb.append("	inner join CT_WAG_AttendanceBillEntry	t2	on t2.FParentID = t1.FID").append(sp);
    	sb.append("where to_char(t1.FbizDate,'yyyy-MM-dd')  = '").append(dateString).append("'").append(sp);
    	sb.append("and t2.CFWagesType = '0' and FBillStatus != '4'").append(sp);
    	sb.append("and t1.CFCompanyID = '"+companyID+"'").append(sp);
    	sb.append("order by t1.CFClasses").append(sp);   	
    	IRowSet rs;
    	rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
    	if(rs.next()==true){
    		MsgBox.showWarning("存在未审核的考勤管理！");
    	}
    	BigDecimal sumWages = new BigDecimal("0");
    	int m = 0;
    	StringBuffer personname = new StringBuffer();
		FractionBillEntryCollection infoec = editData.getEntry();
		for(int i=0;i<infoec.size();i++){
			FractionBillEntryInfo infoe = infoec.get(i);
			if(infoe.getDayWages() != null){
				sumWages = infoe.getDayWages();
			}
			BigDecimal cywages = sumWages.subtract(new BigDecimal("300"));
			if(cywages.intValue()>0){
				personname.append(infoe.getPersonName()+" ");
				m = 1;
			}
		}
    	if(m==1){
    		MsgBox.showWarning("用户："+personname.toString()+"日工资超过300元！");
    	}
    	
        super.actionSubmit_actionPerformed(e);
    }
    
    
    
    
}