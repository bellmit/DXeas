/**
 * output package name
 */
package com.kingdee.eas.custom.dx.baseset.client;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.base.permission.client.longtime.ILongTimeTask;
import com.kingdee.eas.base.permission.client.longtime.LongTimeDialog;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.multiDetail.DetailPanel;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.excel.ExcelReadUtil;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.KDWorkButton;

/**
 * output class name
 */
public class PackbasicEditUI extends AbstractPackbasicEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(PackbasicEditUI.class);
    
    /**
     * output class constructor
     */
    public PackbasicEditUI() throws Exception
    {
        super();
        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		this.setPreferredSize(new Dimension((int)(width*0.8),(int)(height*0.8)));
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
        addTableQuerySearchPanel(kdtEntry);
    }
    private void queryData(final Map<Integer, Map<Integer, Object>> excelValues) {
		// TODO Auto-generated method stub
		LongTimeDialog dialog = new LongTimeDialog( (Frame) SwingUtilities.getWindowAncestor(this)); 
		dialog.setLongTimeTask(new ILongTimeTask() {
			public Object exec() throws Exception { 
				Object result = "12345"; 
				if(excelValues != null){
					MaterialInfo info  = new MaterialInfo();
					MeasureUnitInfo minfo = new MeasureUnitInfo();
					//BasicPostInfo b = new BasicPostInfo();
					IMaterial iMaterial = MaterialFactory.getRemoteInstance();
					CoreBaseCollection coll = null;
					int size = excelValues.size();
					if(size > 0){
						kdtEntry.removeRows();
					}
					for(int i = 1; i <= size; i++){
						Map<Integer,Object> rowValues = new HashMap<Integer, Object>(); 
						rowValues = excelValues.get(i);
						if(rowValues.values() == null) continue;
						IRow row = null;
						String personid = "";
						boolean begin = true;
						for (Integer in : rowValues.keySet()) {
							//map.keySet()返回的是所有key的值
//							if(in == 1){
//								continue;
//							}
							Object obj = rowValues.get(in);//得到每个key对应value的值
							if(begin&&rowValues.get(2)!=null){
								row = kdtEntry.addRow();
								begin = false;
							}
							switch(in){
							case 1:
								
								
								
								if(obj != null){
									try {
										coll = iMaterial.getCollection("where number='" + UIRuleUtil.getString(obj) + "'");
										if(coll.size() > 0){
											row.getCell(in).setValue((MaterialInfo)coll.get(0));
											row.getCell(in+1).setValue(((MaterialInfo)coll.get(0)).getString("name"));
											row.getCell(in+2).setValue(((MaterialInfo)coll.get(0)).getString("Model"));
											//System.out.println(mg+"++++++++++++++++");
											
											//row.getCell("materialGroup").setValue(getGroup(((MaterialInfo)coll.get(0)).getString("number")));
										}
									} catch (BOSException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									break;
								}
								break;
							case 2:
								if(obj != null){
//									row.getCell(in).setValue(obj);
//								}
								}
									
								
								break;
							case 3:
//								if(obj != null){
//									row.getCell(in).setValue(obj);
//								}
								break;
							case 4:
								if(obj != null){
									row.getCell(in).setValue(obj);
								}
								break;
							}	
						}
					}
				}
				return result; 
			} 

			

			public void afterExec(Object result) throws Exception {
				MsgBox.showInfo("导入完成");
			} 
		}); 
		Component[] cps=dialog.getContentPane().getComponents(); 
		for(Component cp:cps){ 
			if(cp instanceof JLabel){ 
				((JLabel) cp).setText("数据导入中..."); 
			} 
		} 
		dialog.show(); 
	}
  //导入excel文件至单据分录
	private void getExcelMassage() throws BOSException{
		Map<Integer,Map<Integer,Object>> excelValues = ExcelReadUtil.getExcelData();
		if(excelValues != null && excelValues.size() > 0){
			queryData(excelValues);
		}
	}
    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

  //分录新增按钮
	private void addTableQuerySearchPanel(final KDTable table) {
		KDWorkButton jb=new KDWorkButton("EXCEL导入");
		jb.setBounds(152,0,100, 27);
		jb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					getExcelMassage();
				} catch (BOSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}});

		JPanel controlPanel = (JPanel) table.getParent().getParent();
		if(controlPanel instanceof DetailPanel ){
			for(int index=0;index<controlPanel.getComponentCount();index++) {
				if(controlPanel.getComponent(index).getName().equalsIgnoreCase("controlPanel")) {
					JPanel  d = (JPanel )controlPanel.getComponent(index);
					Rectangle rect = table.getBounds();
					int x = rect.width - (jb.getWidth() + 86 + 30);
					d.add(jb,new com.kingdee.bos.ctrl.swing.KDLayout.Constraints(x-215, 5, jb.getWidth(), 19, 9));
					break;
				}
			}
		}
	}

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.dx.baseset.PackbasicInfo objectValue = new com.kingdee.eas.custom.dx.baseset.PackbasicInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new Date());
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        return objectValue;
    }

}