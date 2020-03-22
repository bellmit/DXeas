/**
 * output package name
 */
package com.kingdee.eas.custom.szcount.client;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.swing.KDWorkButton;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.base.permission.client.longtime.ILongTimeTask;
import com.kingdee.eas.base.permission.client.longtime.LongTimeDialog;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.ExceptionUtils;
import com.kingdee.eas.custom.wlhllicensemanager.util.WlhlManagerClientUtils;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.client.multiDetail.DetailPanel;
import com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent;
import com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.excel.ExcelReadUtil;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class SzCountPositionSetEditUI extends AbstractSzCountPositionSetEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(SzCountPositionSetEditUI.class);

	/**
	 * output class constructor
	 */
	public SzCountPositionSetEditUI() throws Exception
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
		addTableQuerySearchPanel(kdtMaterialEntry);

		kdtMaterialEntry.addKDTEditListener(new KDTEditAdapter(){
			public void editStopped(KDTEditEvent arg0) {
				// TODO Auto-generated method stub
				int row  = arg0.getRowIndex();
				if(kdtMaterialEntry.getRow(row).getCell("material").getValue()!=null){
					MaterialInfo info =(MaterialInfo) kdtMaterialEntry.getRow(row).getCell("material").getValue();
					String aaa = info.getNumber().toString();
					for(int i = 0;i<kdtMaterialEntry.getRowCount()-1;i++){
						if((MaterialInfo)kdtMaterialEntry.getRow(i).getCell("material").getValue()!=null){
							if(((MaterialInfo)kdtMaterialEntry.getRow(i).getCell("material").getValue()).getNumber().equals(aaa)){
								if(row!=i){
									kdtMaterialEntry.getRow(row).getCell("material").setValue(null);
									kdtMaterialEntry.getRow(row).getCell("baseUnit").setValue(null);
									kdtMaterialEntry.getRow(row).getCell("inventoryUnit").setValue(null);
									kdtMaterialEntry.getRow(row).getCell("materialtype").setValue(null);
									kdtMaterialEntry.getRow(row).getCell("defaultQty").setValue(null);
									MsgBox.showWarning("物料已存在");
									break;
								}
							}
						}

					}
				}

			}
		});
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
		return com.kingdee.eas.custom.szcount.SzCountPositionSetFactory.getRemoteInstance();
	}


	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		setUITitle("计数岗位");
		WlhlManagerClientUtils.addTableQuerySearchPanel(kdtMaterialEntry);

		kdtOperatorEntry_detailPanel.addRemoveListener(new IDetailPanelListener(){
			public void afterEvent(DetailPanelEvent paramDetailPanelEvent)
			throws Exception {

			}
			//@Override
			public void beforeEvent(DetailPanelEvent paramDetailPanelEvent)
			throws Exception {
				if(MsgBox.showConfirm2("是否确认删除?")!=MsgBox.YES) {
					SysUtil.abort();
				}
			}});
		kdtMaterialEntry_detailPanel.addRemoveListener(new IDetailPanelListener(){
			public void afterEvent(DetailPanelEvent paramDetailPanelEvent)
			throws Exception {

			}
			//@Override
			public void beforeEvent(DetailPanelEvent paramDetailPanelEvent)
			throws Exception {
				if(MsgBox.showConfirm2("是否确认删除?")!=MsgBox.YES) {
					SysUtil.abort();
				}
			}});
	}

	@Override
	public void actionImportforEx_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		//kdtMaterialEntry.removeAll();
		super.actionImportforEx_actionPerformed(e);
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
	 * output setDataObject method
	 */
	public void setDataObject(IObjectValue dataObject) 
	{
		super.setDataObject(dataObject);
		if(STATUS_ADDNEW.equals(getOprtState())) {
			editData.put("treeid",(com.kingdee.eas.custom.szcount.SzCountPositionSetTreeInfo)getUIContext().get(UIContext.PARENTNODE));
		}
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
						kdtMaterialEntry.removeRows();
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
							if(in == 1){
								continue;
							}
							Object obj = rowValues.get(in);//得到每个key对应value的值
							if(begin&&rowValues.get(2)!=null){
								row = kdtMaterialEntry.addRow();
								begin = false;
							}
							switch(in){
							case 1://物料名称
							case 2:
								if(obj != null){
									try {
										coll = iMaterial.getCollection("where number='" + UIRuleUtil.getString(obj) + "'");
										if(coll.size() > 0){
											row.getCell("material").setValue((MaterialInfo)coll.get(0));
											row.getCell("materialNum").setValue(((MaterialInfo)coll.get(0)).getString("number"));
											String mg = ((MaterialInfo)coll.get(0)).getString("materialGroup");
											//System.out.println(mg+"++++++++++++++++");
											
											row.getCell("materialGroup").setValue(getGroup(((MaterialInfo)coll.get(0)).getString("number")));
										}
									} catch (BOSException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									break;
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
								break;
							case 7:
								if(obj != null){
									row.getCell(in).setValue(true);
								}else{
									row.getCell(in).setValue(false);
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
	//获取类别
	private String getGroup(String string) {
		// TODO Auto-generated method stub
		String Gname = null ;
		String sql = "select t3.FNAME_l2  from T_BD_Material t1 inner join T_BD_MaterialGroup t5 on t5.FID = t1.FMaterialGroupID inner join T_BD_MaterialGroup t2 on t2.FID = t5.FParentID inner join T_BD_MaterialGroup t3 on t3.FID =t2.FParentID where t1.FNumber = '"+string+"'";
		IRowSet rs;
		try {
			rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();

			while(rs.next()){
				Gname = rs.getString("FNAME_l2");
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Gname;
		
		
	}
	//导入excel文件至单据分录
	private void getExcelMassage() throws BOSException{
		Map<Integer,Map<Integer,Object>> excelValues = ExcelReadUtil.getExcelData();
		if(excelValues != null && excelValues.size() > 0){
			queryData(excelValues);
		}
	}

	//编码获取id
	private String getPersonID(String personnumber) {
		String personID = null ;
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("select FID from ").append(sp);
		sql.append("T_BD_Material ").append(sp);
		//sql.append("inner join T_BD_Person  t2  on t2.FID = t1.FPersonID").append(sp);
		sql.append("where FNumber ='").append(personnumber).append("'").append(sp);
		System.out.println("获取物料id"+sql.toString());
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
		com.kingdee.eas.custom.szcount.SzCountPositionSetInfo objectValue = new com.kingdee.eas.custom.szcount.SzCountPositionSetInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUserInfo()));
		objectValue.setCU(ClientUtils.getCurrentCtrlUnit());
		objectValue.setCompanyOrg(ClientUtils.getCurrentFIUnit());
		return objectValue;
	}

}