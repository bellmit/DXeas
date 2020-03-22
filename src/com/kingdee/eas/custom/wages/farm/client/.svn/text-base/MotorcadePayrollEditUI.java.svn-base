/**
 * output package name
 */
package com.kingdee.eas.custom.wages.farm.client;

import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import mondrian.rolap.BitKey.Big;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.wages.BasicPostInfo;
import com.kingdee.eas.farm.food.comm.FarmCommUtils;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.FrameWorkClientUtils;
import com.kingdee.eas.framework.client.multiDetail.DetailPanel;
import com.kingdee.eas.hr.base.IsChinese;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.excel.ExcelReadUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTIndexColumn;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.foot.KDTFootManager;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.ctrl.swing.KDButton;
import com.kingdee.bos.ctrl.swing.KDPanel;

/**
 * output class name
 */
public class MotorcadePayrollEditUI extends AbstractMotorcadePayrollEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(MotorcadePayrollEditUI.class);
    String sumweight = "";
    /**
     * output class constructor
     */
    public MotorcadePayrollEditUI() throws Exception
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
    /* (non-Javadoc)
	 * @see com.kingdee.eas.framework.client.CoreBillEditUI#onLoad()
	 */
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		initUI();
		importEx.setEnabled(true);
		addButtonToHMDEntry(kdtEntrys,importEx,5);  
	}
	/* (non-Javadoc)
	 * @see com.kingdee.eas.custom.wages.farm.client.AbstractFarmRatingEditUI#actionImportEx_actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionImportEx_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionImportEx_actionPerformed(e);
		Map<Integer,Map<Integer,Object>> excelValues = ExcelReadUtil.getExcelData();
		if(excelValues != null){
			kdtEntrys.removeRows();
			PersonInfo p = new PersonInfo();
			BasicPostInfo b = new BasicPostInfo();
			for(int i = 2; i <= excelValues.size(); i++){
				Map<Integer,Object> rowValues = new HashMap<Integer, Object>(); 
				rowValues = excelValues.get(i);
				if(rowValues.values() == null) continue;
				IRow row = kdtEntrys.addRow();
				String personid = "";
				for (Integer in : rowValues.keySet()) {
					//map.keySet()返回的是所有key的值					
					Object obj = rowValues.get(in);//得到每个key对应value的值
					switch(in){
					case 1://员工编码
						if(obj != null){
							personid = getPersonID(obj.toString());
							p = PersonFactory.getRemoteInstance().getPersonInfo(new ObjectUuidPK(personid));
							row.getCell(in).setValue(p);
						}
						break;
					case 2:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;
					case 3:
						if(obj != null){
							row.getCell(in).setValue(obj);
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
					case 9:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;
					case 10:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;
					case 11:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;
					case 12:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;
					}	
				}
			}
		}
	}
	private void initUI() {
		appendSumRow();
		this.calculation.setEnabled(true);
		this.getperson.setEnabled(true);
		this.getperson.addMouseListener(new MouseListener(){

			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
				if(pkbegindate.getValue()==null||pkenddate.getValue()==null){
					MsgBox.showWarning("请先确定核算期间");
					SysUtil.abort();
				}
				IRowSet rs = getExeQueryRowSet();
				IRowSet rs1 = getsumWeight();
				
				kdtEntrys.removeRows();
				PersonInfo p = new PersonInfo();
				BasicPostInfo b = new BasicPostInfo();
				while(rs1.next()){
					sumweight = rs1.getString("CFSuttle");
					txtsumweight.setText(sumweight);
					
				}
				while(rs.next()){
					String name = rs.getString("FID"); //ID 	
					kdtEntrys.addRow();
					IObjectPK pk = new ObjectStringPK(name); //主键 
					p = PersonFactory.getRemoteInstance().getPersonInfo(pk);
					kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "person").setValue(p);
					kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "shipptonnage").setValue(rs.getString("CFSuttle"));
					BigDecimal rate = new BigDecimal(rs.getString("CFSuttle"));
					rate = rate.divide(new BigDecimal(sumweight),2,BigDecimal.ROUND_HALF_UP);//.setScale(2, BigDecimal.ROUND_HALF_UP);
					kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "tonnagerate").setValue(rate.toString());
					kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "compensation").setValue("0");
					kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "chinknumber").setValue(rs.getString("chinknumber"));
					
				}
				} catch (BOSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (EASBizException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
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
		
		kdtEntrys.addKDTEditListener(new KDTEditAdapter() {
			public void editStopped(KDTEditEvent e) {
				try {
					kdtEntrys_Changed(e.getRowIndex(),e.getColIndex());
				}
				catch (Exception exc) {
					handUIException(exc);
				}
			}
		});
		this.calculation.addMouseListener(new MouseListener(){

			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				//BigDecimal auweight = new BigDecimal(getautweight());
				BigDecimal auweight = new BigDecimal(txtsumweight.getText());
				if(StringUtils.isEmpty(txtmintonnage.getText())){
					MsgBox.showWarning("最低吨数指标为空，不能计算补偿！");
					SysUtil.abort();
				}
				String mintonnage = txtmintonnage.getText().replace(",", "");
				System.out.println("最低吨数"+mintonnage);
				if(auweight.compareTo(new BigDecimal(mintonnage))<0){
					BigDecimal subweight = new BigDecimal(mintonnage);
					subweight = subweight.subtract(auweight);
					for(int i=0;i<kdtEntrys.getRowCount();i++){
						 BigDecimal rate = new BigDecimal(kdtEntrys.getCell(i, "tonnagerate").getValue().toString());
				    	 kdtEntrys.getCell(i, "compensation").setValue(subweight.multiply(rate));
				    }
					MsgBox.showWarning("补偿计算完成！");
				}else{
					for(int i=0;i<kdtEntrys.getRowCount();i++){
						 //BigDecimal rate = new BigDecimal(kdtEntrys.getCell(i, "tonnagerate").getValue().toString());
				    	 kdtEntrys.getCell(i, "compensation").setValue("0");
				    }
					MsgBox.showWarning("实际送料吨数大于保底送料吨数，补偿为0！");
				}
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
	
	  public void kdtEntrys_Changed(int rowIndex,int colIndex) throws Exception{
	       if ("shipptonnage".equalsIgnoreCase(kdtEntrys.getColumn(colIndex).getKey())) {
	    	   BigDecimal rate = new BigDecimal(kdtEntrys.getCell(rowIndex,"shipptonnage").getValue().toString());
	    	   rate = rate.divide(new BigDecimal(txtsumweight.getText()), 2,BigDecimal.ROUND_HALF_UP);
	    	   kdtEntrys.getCell(rowIndex,"tonnagerate").setValue(rate);
	       }
	}
	  private String getautweight() {
			// TODO Auto-generated method stub
		  	 BigDecimal sumauweight = new BigDecimal("0");
		     for(int i=0;i<kdtEntrys.getRowCount();i++){
		    	 String ship = kdtEntrys.getCell(i, "shipptonnage").getValue().toString();
		    	 sumauweight=sumauweight.add(new BigDecimal(ship));
		    }
			return sumauweight.toString();
		}
	 /**
	 *<p>Custom: 北三峡</p>
	 *<p>Company: 青岛未来互连</p>
	 * @author 于明旭
	 * 送料吨数取出库过榜单数量(选择起止日期)，人员取出库过榜单备注
	 */
    private IRowSet getExeQueryRowSet() throws BOSException {
    	String begindate= this.pkbegindate.getText();
    	String enddate= this.pkenddate.getText();
    	StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("/*dialect*/").append(sp);
		sql.append("select t5.FName_l2,t5.FID FID,nvl(sum(t3.CFSuttle),0) CFSuttle,nvl(t2.FNumber,0) chinknumber,t6.FNumber from ").append(sp);
		sql.append("T_ORG_Position t1").append(sp);
		sql.append("inner join T_ORG_PositionMember t4 on t4.FPositionID = t1.FID").append(sp);
		sql.append("inner join T_BD_Person t5 on t5.FID = t4.FPersonID").append(sp);
		sql.append("inner join T_ORG_Admin t6 on t6.FID = t1.FAdminOrgUnitID").append(sp);
		sql.append("and t6.FNumber = '306'").append(sp);
		sql.append("left join ").append(sp);
		sql.append("(").append(sp);
		sql.append("select").append(sp);
		sql.append("trim(t1.FDescription) FDescription,sum(t2.CFSuttle)/1000 CFSuttle ").append(sp);
		sql.append("from CT_WHB_OutStorageBill t1").append(sp);
		sql.append("inner join CT_WHB_OutStorageBillEntry t2 on t2.FParentID = t1.FID").append(sp);
		sql.append("inner join T_BD_Material t3 on t3.FID = t2.CFMaterialID").append(sp);
		sql.append("where").append(sp);
		sql.append("t1.FDescription is not null").append(sp);
		sql.append("and (t3.FName_l2 like '%配合饲料%' or t3.FName_l2 like '益生%' or t3.FName_l2 like '肉鸡开口料%')").append(sp);
		sql.append("and to_char(t1.FBizDate,'yyyy-MM-dd') >= '"+begindate+"'").append(sp);
		sql.append("and to_char(t1.FBizDate,'yyyy-MM-dd') <= '"+enddate+"'").append(sp);
		sql.append("group by t1.FDescription").append(sp);
		sql.append(") t3 on t3.FDescription = t5.FName_l2").append(sp);
		sql.append("left join (").append(sp);
		sql.append("select").append(sp);
		sql.append("trim(t1.FDescription) FDescription,count(t3.FNumber) FNumber").append(sp);
		sql.append("from CT_WHB_OutStorageBill t1").append(sp);
		sql.append("inner join CT_WHB_OutStorageBillEntry t2 on t2.FParentID = t1.FID").append(sp);
		sql.append("inner join T_BD_Material t3 on t3.FID = t2.CFMaterialID").append(sp);
		sql.append("inner join T_BD_MaterialGroup t4 on t4.FID = t3.FMaterialGroupID").append(sp);
		sql.append("where").append(sp);
		sql.append("t1.FDescription is not null").append(sp);
		sql.append("and t4.FNumber = '020101'").append(sp);
		sql.append("and to_char(t1.FBizDate,'yyyy-MM-dd') >= '"+begindate+"'").append(sp);
		sql.append("and to_char(t1.FBizDate,'yyyy-MM-dd') <= '"+enddate+"'").append(sp);
		sql.append("group by t1.FDescription").append(sp);
		sql.append(") t2 on t2.FDescription = t3.FDescription").append(sp);
		sql.append("group by t5.FName_l2,t2.FNumber,t6.FNumber,t5.FID").append(sp);
		System.out.println("获取出库过磅数量"+sql.toString());
    	IRowSet rs =SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		return rs;
    }
    /**
	 *<p>Custom: 北三峡</p>
	 *<p>Company: 青岛未来互连</p>
	 * @author 于明旭
	 * 核算期间内出库过磅单重量总和
	 */
    private IRowSet getsumWeight() throws BOSException {
    	String begindate= this.pkbegindate.getText();
    	String enddate= this.pkenddate.getText();
    	StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("select").append(sp);
		sql.append("sum(t2.CFSuttle)/1000 CFSuttle ").append(sp);
		sql.append("from CT_WHB_OutStorageBill t1").append(sp);
		sql.append("inner join CT_WHB_OutStorageBillEntry t2 on t2.FParentID = t1.FID").append(sp);
		sql.append("inner join T_BD_Material t3 on t3.FID = t2.CFMaterialID").append(sp);
		sql.append("inner join T_BD_MaterialGroup t4 on t4.FID = t3.FMaterialGroupID").append(sp);
		sql.append("where").append(sp);
		//sql.append("t1.FDescription is not null").append(sp);
		sql.append("t4.FNumber in  ('020101','020102')").append(sp);
		sql.append("and to_char(t1.FBizDate,'yyyy-MM-dd') >= '"+begindate+"'").append(sp);
		sql.append("and to_char(t1.FBizDate,'yyyy-MM-dd') <= '"+enddate+"'").append(sp);
		sql.append("and t1.CFBillStatus = '4'").append(sp);
		System.out.println("获取出库过磅总重量"+sql.toString());
    	IRowSet rs =SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		return rs;
    }

    /**
    	 * 员工姓名
    	 * 从备注中取得员工姓名
    	 * @return 数字
    	 */
    	private String TypeName(String personname) {
    		//测试
    		String str =personname;
    		String str2="";
    		//String reg = "[^\u4e00-\u9fa5]";
    		 
    		str=str.trim();

    		for(int i=0;i<str.length();i++){
    			Character.UnicodeBlock ub = Character.UnicodeBlock.of(str.charAt(i)); 
    			if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS  
    	                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A  
    	                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B  
    	                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS  
    	                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT) {  
    				str2+=str.charAt(i);
    	        }  
    		}
    		//System.out.println(str2);
    		return str2;

    	}
    	//用户名获取用户id
    	private String getPersonID(String personname) throws BOSException, SQLException{
    		StringBuffer sql = new StringBuffer();
    		String sp = "\n";
    		sql.append("select FID from ").append(sp);
    		sql.append("T_BD_Person ").append(sp);
    		//sql.append("inner join T_BD_Person  t2  on t2.FID = t1.FPersonID").append(sp);
    		sql.append("where FName_l2 ='").append(personname).append("'").append(sp);
    		//System.out.println("获取用户id"+sql.toString());
    		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
    		String personID = null ;
    		while(rs.next()){
    			personID = rs.getString("FID");
    		}
    		return personID;
    	}
	/* (non-Javadoc)
	 * @see com.kingdee.eas.custom.wages.farm.client.AbstractMotorcadePayrollEditUI#onShow()
	 */
	@Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		this.audit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.unaudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		super.onShow();
	}
	private void addButtonToHMDEntry(KDTable table, KDButton button,int width) {  
        if (table.getParent() == null || table.getParent().getParent() == null)  
         return;  
        // 隐藏按钮  
        Component c = table.getParent().getParent();  
        if (c instanceof DetailPanel) {  
         JPanel panel = (JPanel) c;  
         JPanel controlPanel = null;  
         // 获取controlPanel  
         Component[] components = panel.getComponents();  
         for (int i = 0; i < components.length; i++) {  
          Component component = components[i];  
          if ("controlPanel".equals(component.getName())) {  
           controlPanel = (KDPanel) component;  
          }  
         }  
         // 获取btn  
         if (controlPanel != null) {  
          Rectangle rect = table.getBounds();  
          int x = rect.width - (button.getWidth() +86+ width);  
          controlPanel.add(button, new com.kingdee.bos.ctrl.swing.KDLayout.Constraints(x, 3, button.getWidth(), 19, 9));  
         }  
        }  
          
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
     * output actionCalculator_actionPerformed
     */
    public void actionCalculator_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCalculator_actionPerformed(e);
    }
    /**
	 * 添加合计行
	 */
	private void appendSumRow() {
		// TODO Auto-generated method stub
		ArrayList<String> arrayList=new ArrayList<String>();
//		for(int i=0;i<kdtEntrys.getColumnCount();i++){
////			if(kdtEntrys.getColumn(i).getKey().indexOf("Qty")>=0||kdtEntrys.getColumn(i).getKey().indexOf("Wgt")>=0||kdtEntrys.getColumn(i).getKey().indexOf("Cost")>=0||kdtEntrys.getColumn(i).getKey().indexOf("Fee")>=0
////					||kdtEntrys.getColumn(i).getKey().indexOf("Usage")>=0||kdtEntrys.getColumn(i).getKey().indexOf("price")>=0||kdtEntrys.getColumn(i).getKey().indexOf("breedingStock")>=0||kdtEntrys.getColumn(i).getKey().indexOf("consumption")>=0
////					||kdtEntrys.getColumn(i).getKey().indexOf("fertilizer")>=0){
//				arrayList.add(kdtEntrys.getColumn(i).getKey());
//				kdtEntrys.getColumn(i).getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);
//			//}
//		}
		String []array={"shipptonnage"};
		apendFootRow(kdtEntrys,array);
	}
   
    /**
     * output actionSave_actionPerformed
     */
    public void actionSave_actionPerformed(ActionEvent e) throws Exception
    {
    	if(StringUtils.isEmpty(txtDescription.getText())){
			MsgBox.showWarning("酬勤系数为空不能保存，不能计算补偿！");
			SysUtil.abort();
		}
        super.actionSave_actionPerformed(e);
    }

    /**
     * output actionSubmit_actionPerformed
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmit_actionPerformed(e);
    }

    /**
     * output actionCancel_actionPerformed
     */
    public void actionCancel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCancel_actionPerformed(e);
    }

    /**
     * output actionCancelCancel_actionPerformed
     */
    public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCancelCancel_actionPerformed(e);
    }
    /**
     * output actionEdit_actionPerformed
     */
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据已经审核，禁止修改！");
    		SysUtil.abort();
    	}
        super.actionEdit_actionPerformed(e);
    }

    /**
     * output actionRemove_actionPerformed
     */
    public void actionRemove_actionPerformed(ActionEvent e) throws Exception
    {
    	if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据已经审核，禁止删除！");
    		SysUtil.abort();
    	}
        super.actionRemove_actionPerformed(e);
    }
    /**
     * output actionAudit_actionPerformed
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {

    	if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据已经审核，禁止再次审核！");
    		SysUtil.abort();
    	}
    	if(!FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.SUBMITED)) {
    		MsgBox.showWarning("单据尚未提交，禁止审核！");
    		SysUtil.abort();
    	}
		super.actionAudit_actionPerformed(e);
		this.editData.setBillStatus(BillBaseStatusEnum.AUDITED);
		//this.setDataObject(this.getBizInterface().getValue(new ObjectUuidPK(this.editData.getId())));
		this.loadData();
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
    }

    /**
     * output actionUnaudit_actionPerformed
     */
    public void actionUnaudit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(!FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据尚未审核，禁止反审核！");
    		SysUtil.abort();
    	}
		super.actionUnaudit_actionPerformed(e);
		//this.setDataObject(this.editData);
		this.loadData();
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
    }
    /**
	 * output actionSubmit_actionPerformed
	 * 刷新操作
	 */
	protected void refreshCurPage() throws EASBizException, BOSException, Exception {
		if (editData.getId() != null) {
			com.kingdee.bos.dao.IObjectPK iObjectPk = new ObjectUuidPK(editData.getId());
			IObjectValue iObjectValue = getValue(iObjectPk);
			setDataObject(iObjectValue);
			loadFields();
			setSave(true);
		}
	}  

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.wages.farm.MotorcadePayrollFactory.getRemoteInstance();
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
        com.kingdee.eas.custom.wages.farm.MotorcadePayrollInfo objectValue = new com.kingdee.eas.custom.wages.farm.MotorcadePayrollInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new Date());
        return objectValue;
    }

}