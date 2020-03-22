/**
 * output package name
 */
package com.kingdee.eas.custom.wages.client;

import java.awt.Color;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
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
import com.kingdee.eas.framework.client.FrameWorkClientUtils;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.wlhlcomm.excel.ExcelReadUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTIndexColumn;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;
import com.kingdee.bos.ctrl.kdf.table.foot.KDTFootManager;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;

/**
 * output class name
 */
public class ByThePieceBillEditUI extends AbstractByThePieceBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(ByThePieceBillEditUI.class);
    
    /**
     * output class constructor
     */
    public ByThePieceBillEditUI() throws Exception
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
	 * 添加合计行
	 */
	private void appendSumRow() {
		// TODO Auto-generated method stub
		ArrayList<String> arrayList=new ArrayList<String>();
		arrayList.add("pieceAmount");
		arrayList.add("pieceMoney");
		apendFootRow(kdtEntry,(String []) arrayList.toArray(new String[arrayList.size()]));
	}
	/** 
	 * 功能：添加合计行 
	 *  
	 * @param table 
	 *            指定的KDTable 
	 * @param fields 
	 *            需要合计的列 
	 */  
	public static void apendFootRow(KDTable table, String fields[]) {  
		int size = fields.length;  
		if (size == 0)  
			return;  
		Map sumValue = new HashMap();  
		// 利用getRowCount的到的行可能不正确  
		int count = table.getRowCount3();  

		for (int i = 0; i < fields.length; i++) {  
			sumValue.put(fields[i], new BigDecimal("0.00"));  
		}  
		IRow footRow = null;  
		KDTFootManager footManager = table.getFootManager();  
		if (footManager == null) {  
			footManager = new KDTFootManager(table);  
			footManager.addFootView();  
			table.setFootManager(footManager);  
		}  
		// 计算所有指定行的合计值  
		footRow = footManager.getFootRow(0);  
		for (int i = 0; i < count; i++) {  
			IRow row = table.getRow(i);  
			for (int j = 0; j < fields.length; j++) {  
				sumValueForCell(row, fields[j], sumValue);  
			}  
		}  

		if (footRow == null) {  
			footRow = footManager.addFootRow(0);  
		}  
		// 设置合计行显示样式  
		String colFormat = "%{0.00}f";  

		String total = EASResource.getString(FrameWorkClientUtils.strResource  
				+ "Msg_Total");  

		table.getIndexColumn().setWidthAdjustMode(KDTIndexColumn.WIDTH_MANUAL);  
		table.getIndexColumn().setWidth(30);  
		footManager.addIndexText(0, total);  
		footRow.getStyleAttributes().setBackground(new Color(0xf6, 0xf6, 0xbf));  
		for (int i = 0; i < size; i++) {  
			String colName = fields[i];  
			footRow.getCell(colName).getStyleAttributes().setNumberFormat(  
					colFormat);  
			footRow.getCell(colName).getStyleAttributes().setHorizontalAlign(  
					HorizontalAlignment.RIGHT);  
			footRow.getCell(colName).getStyleAttributes().setFontColor(  
					Color.black);  
		}  

		// 设置合计行的值  
		for (int i = 0; i < fields.length; i++) {  
			footRow.getCell(fields[i]).setValue(sumValue.get(fields[i]));  
		}  
	}  

	private static void sumValueForCell(IRow row, String key, Map sumValue) {  
		ICell cell = row.getCell(key);  

		if (cell != null) {  
			Object obj = cell.getValue();  
			if (obj != null) {  
				BigDecimal keyValue = (BigDecimal) sumValue.get(key);  
				keyValue = keyValue.add(new BigDecimal(obj.toString()));  
				sumValue.put(key, keyValue);  
			}  
		}  
	}  
    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output btnAddLine_actionPerformed method
     */
    protected void btnAddLine_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.btnAddLine_actionPerformed(e);
    }

    /**
     * output menuItemEnterToNextRow_itemStateChanged method
     */
    protected void menuItemEnterToNextRow_itemStateChanged(java.awt.event.ItemEvent e) throws Exception
    {
        super.menuItemEnterToNextRow_itemStateChanged(e);
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
        com.kingdee.eas.custom.wages.ByThePieceBillInfo objectValue = new com.kingdee.eas.custom.wages.ByThePieceBillInfo();
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
				// TODO Auto-generated method stub
				
			}
			public void editStarted(KDTEditEvent paramKDTEditEvent) {
				// TODO Auto-generated method stub
				
			}
			public void editStarting(KDTEditEvent paramKDTEditEvent) {
				// TODO Auto-generated method stub
				
			}
			public void editStopped(KDTEditEvent paramKDTEditEvent) {
				// TODO Auto-generated method stub
				
				for(int i= 0;i<kdtEntry.getRowCount();i++){
					if(kdtEntry.getRow(i).getCell("pieceAmount").getValue()!=null&&kdtEntry.getRow(i).getCell("pieceUnitPrice").getValue()!=null){
						BigDecimal a = getBigDecimal(kdtEntry.getRow(i).getCell("pieceAmount").getValue());
						BigDecimal b = getBigDecimal(kdtEntry.getRow(i).getCell("pieceUnitPrice").getValue());
						kdtEntry.getRow(i).getCell("pieceMoney").setValue(a.multiply(b));
					}if(kdtEntry.getRow(i).getCell("person").getValue()!=null){
						PersonInfo info = (PersonInfo) kdtEntry.getRow(i).getCell("person").getValue();
						BasicPostInfo BPinfo = getPersonPost(info.getId());
						if(BPinfo!=null){
							kdtEntry.getRow(i).getCell("personPost").setValue(BPinfo);
						}else{
							kdtEntry.getRow(i).getCell("personPost").setValue(null);
						}
						
					}
				}
			}
			public void editStopping(KDTEditEvent paramKDTEditEvent) {
				// TODO Auto-generated method stub
				
			}
			public void editValueChanged(KDTEditEvent paramKDTEditEvent) {
				// TODO Auto-generated method stub
				
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
		
		
		//20181021 by yumingxu
		CompanyOrgUnitInfo company = SysContext.getSysContext().getCurrentFIUnit(); 
////	 	//分录F7添加过滤
////	 	//Post
//	    KDBizPromptBox prmtPost = (KDBizPromptBox) kdtEntry.getColumn("personPost").getEditor().getComponent(); // 岗位F7  
//	    EntityViewInfo view1 = new EntityViewInfo(); // 新定义视图  
//	    FilterInfo filter1 = new FilterInfo(); // 设置过滤条件  
//	    filter1.getFilterItems().add(new FilterItemInfo("company.id", company.getId().toString()+"%",CompareType.LIKE)); // 按照当前单位登记过滤  
//	    //String theGroupName = ((IPropertyContainer) prmttheGroup.getValue()).getString("Name");
//	    view1.setFilter(filter1); // 设置过滤条件  
//	    prmtPost.setEntityViewInfo(view1); // 重新设定视图  
		
		
	    
//	 	//Person
	    KDBizPromptBox prmtPerson = (KDBizPromptBox) kdtEntry.getColumn("person").getEditor().getComponent(); // 人员F7  
	    EntityViewInfo view2 = new EntityViewInfo(); // 新定义视图  
	    FilterInfo filter2 = new FilterInfo(); // 设置过滤条件  
	    filter2.getFilterItems().add(new FilterItemInfo("CU2.longNumber", "%"+company.getNumber()+"%",CompareType.LIKE)); // 按照当前单位登记过滤  
	    //filter.getFilterItems().add(new FilterItemInfo("bizStatus", BizStatusEnum.NORMAL_VALUE)); // 添加正常状态筛选条件  
	    view2.setFilter(filter2); // 设置过滤条件  
	    prmtPerson.setEntityViewInfo(view2); // 重新设定视图  
		
		
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
								//row.getCell(in+1).setValue(p.getName());
								if(getPersonPost(p.getId())!=null){
									row.getCell(in+2).setValue(getPersonPost(p.getId()));
									row.getCell("pieceUnitPrice").setValue((getPersonPost(p.getId())).getProductRatio());
								}
								
							}	
						}
						break;
					case 2:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;
					case 3:
//						if(obj != null){
//							
//							String objS = (String)obj;
//							if(objS.equals("公斤")){
//								row.getCell(in).setValue(byThePieceUnit.getEnumList().get(0));
//							}else if(objS.equals("根")){
//								row.getCell(in).setValue(byThePieceUnit.getEnumList().get(1));
//							}else if(objS.equals("袋")){
//								row.getCell(in).setValue(byThePieceUnit.getEnumList().get(2));
//							}else{
//								
//							}
//							
//							
//						}
						
						
						
						
						
						break;
					case 4:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;
					case 5:
//						if(obj != null){
//							row.getCell(in).setValue(obj);
//						}
//						break;
						if(obj != null){
							
							String objS = (String)obj;
							if(objS.equals("公斤")){
								row.getCell(in).setValue(byThePieceUnit.getEnumList().get(0));
							}else if(objS.equals("根")){
								row.getCell(in).setValue(byThePieceUnit.getEnumList().get(1));
							}else if(objS.equals("袋")){
								row.getCell(in).setValue(byThePieceUnit.getEnumList().get(2));
							}else{
								
							}
							
							
						}
						break;
					case 6:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;
					case 7:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;
					case 8:
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
	//获取员工基础岗位
    private BasicPostInfo getPersonPost(BOSUuid uuid) {
    	BasicPostInfo reBPInfo = null;
    	StringBuffer sb = new StringBuffer();
    	String sp = "\n";
    	sb.append("select t1.FID FID from ").append(sp);
    	sb.append("	CT_WAG_BasicPost 			t1").append(sp);
    	sb.append("	inner join CT_WAG_BasicPostEntry		t2	on t2.FParentID = t1.FID").append(sp);
    	sb.append("	where t2.CFPersonID = '").append(uuid).append("'").append(sp);
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
}