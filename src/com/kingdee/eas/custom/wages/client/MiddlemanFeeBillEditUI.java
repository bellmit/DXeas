/**
 * output package name
 */
package com.kingdee.eas.custom.wages.client;

import java.awt.event.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.wages.BasicPostFactory;
import com.kingdee.eas.custom.wages.BasicPostInfo;
import com.kingdee.eas.custom.wages.byThePieceUnit;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.wlhlcomm.excel.ExcelReadUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;

/**
 * output class name
 */
public class MiddlemanFeeBillEditUI extends AbstractMiddlemanFeeBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(MiddlemanFeeBillEditUI.class);
    
    /**
     * output class constructor
     */
    public MiddlemanFeeBillEditUI() throws Exception
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
	public void onLoad() throws Exception {
		super.onLoad();
		initUI();
		kdtEntry.addKDTEditListener(new KDTEditListener(){
			public void editCanceled(KDTEditEvent arg0) {
			}
			public void editStarted(KDTEditEvent arg0) {
			}
			public void editStarting(KDTEditEvent arg0) {
			}
			public void editStopped(KDTEditEvent arg0) {
				for(int i =0;i<kdtEntry.getRowCount();i++){
					if(kdtEntry.getRow(i).getCell("stratMonth").getValue()!=null&&kdtEntry.getRow(i).getCell("endMonth").getValue()!=null){
							SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
							Date date1 = (Date) kdtEntry.getRow(i).getCell("stratMonth").getValue();
							Date date2 = (Date) kdtEntry.getRow(i).getCell("endMonth").getValue();
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
					        String str1 = formatter.format(date1);
					        String str2 = formatter.format(date2);
					        Calendar bef = Calendar.getInstance();
					        Calendar aft = Calendar.getInstance();
					        try {
								bef.setTime(sdf.parse(str1));
								aft.setTime(sdf.parse(str2));
							    int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
							    int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
							    kdtEntry.getRow(i).getCell("allMonth").setValue(result+month+1);
							    System.out.println(Math.abs(month + result)); 
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					      
					}
				}
			}
			public void editStopping(KDTEditEvent arg0) {
			}
			public void editValueChanged(KDTEditEvent arg0) {
			}
		});
		importPerson.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				getExcelMassage();
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});	
	}
	/**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
		
        return null;
    }
    private void initUI() {

		CompanyOrgUnitInfo company = SysContext.getSysContext().getCurrentFIUnit(); 
//	 	//分录F7添加过滤
//	 	//Post
	    KDBizPromptBox prmtPerson = (KDBizPromptBox) kdtEntry.getColumn("person").getEditor().getComponent(); // 人员F7  
	    EntityViewInfo view1 = new EntityViewInfo(); // 新定义视图  
	    FilterInfo filter1 = new FilterInfo(); // 设置过滤条件  
	    filter1.getFilterItems().add(new FilterItemInfo("CU2.longNumber", "%"+company.getNumber()+"%",CompareType.LIKE)); // 按照当前单位登记过滤  
	    //filter.getFilterItems().add(new FilterItemInfo("bizStatus", BizStatusEnum.NORMAL_VALUE)); // 添加正常状态筛选条件  
	    view1.setFilter(filter1); // 设置过滤条件  
	    prmtPerson.setEntityViewInfo(view1); // 重新设定视图  
	    //prmtHfPerson.setEnabledMultiSelection(true); //F7多选  
	    
//	 	//Person
	    KDBizPromptBox prmtNPerson = (KDBizPromptBox) kdtEntry.getColumn("NPerson").getEditor().getComponent(); // 人员F7  
	    EntityViewInfo view2 = new EntityViewInfo(); // 新定义视图  
	    FilterInfo filter2 = new FilterInfo(); // 设置过滤条件  
	    filter2.getFilterItems().add(new FilterItemInfo("CU2.longNumber", "%"+company.getNumber()+"%",CompareType.LIKE)); // 按照当前单位登记过滤  
	    //filter.getFilterItems().add(new FilterItemInfo("bizStatus", BizStatusEnum.NORMAL_VALUE)); // 添加正常状态筛选条件  
	    view2.setFilter(filter2); // 设置过滤条件  
	    prmtNPerson.setEntityViewInfo(view2); // 重新设定视图  
	    //prmtHfPerson.setEnabledMultiSelection(true); //F7多选  
	    
	    
	    
	    
    }
  //导入excel文件至单据分录
	private void getExcelMassage(){
		Map<Integer,Map<Integer,Object>> excelValues = ExcelReadUtil.getExcelData();
		if(excelValues != null){
			PersonInfo p = new PersonInfo();
			//BasicPostInfo b = new BasicPostInfo();
			for(int i = 1; i <= excelValues.size(); i++){
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
							}	
						}
						break;
					case 2:
						break;
					case 3:
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
							}	
						}
						break;
					case 4:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;
					case 5:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;			
					case 6:
						if(obj != null){
							row.getCell(in+3).setValue(obj);
						}
					
//						//日期
//						if(obj != null){
//							DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//							long l = Math.round((Double)obj);
//							Date date = new Date(l);
////							df.format(date);
//							row.getCell(in).setValue(date);
//						}
						break;
					case 7:
						if(obj != null){
							row.getCell(in+3).setValue(obj);
						}
//						if(obj != null){
//							DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//							Date date0;
//							try {
//								date0 = df.parse((String) obj);
//								row.getCell(in).setValue(date0);
//							} catch (ParseException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//							
//						}
						break;
					case 8:
						if(obj != null){
							row.getCell(in+3).setValue(obj);
						}
//						if(obj != null){
//							DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//							Date date0;
//							try {
//								date0 = df.parse((String) obj);
//								row.getCell(in).setValue(date0);
//							} catch (ParseException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//							
//						}
						break;
					case 9:
						if(obj != null){
							row.getCell(in+3).setValue(obj);
						}
						//日期
//						if(obj != null){
//							DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//							Date date0;
//							try {
//								date0 = df.parse((String) obj);
//								row.getCell(in).setValue(date0);
//							} catch (ParseException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//							
//						}
						break;
					case 10:
						if(obj != null){
							row.getCell(in+3).setValue(obj);
						}
						break;
					case 11:
						if(obj != null){
							row.getCell(in+3).setValue(obj);
						}
						break;
					case 12:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;
					case 13:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;
					case 14:
						if(obj != null){
							row.getCell(in).setValue(obj);
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
		sql.append("where FNumber ='").append(personnumber).append("'").append(sp);
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
	
    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.wages.MiddlemanFeeBillInfo objectValue = new com.kingdee.eas.custom.wages.MiddlemanFeeBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        objectValue.setBizDate(new Date());
        return objectValue;
    }

}