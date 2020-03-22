/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.feedbiz.client;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.report.util.RptTableColumn;
import com.kingdee.eas.framework.report.util.RptTableHeader;
import com.kingdee.eas.framework.report.util.KDTableUtil;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class BatchAndInv extends AbstractBatchAndInv
{
	private static final Logger logger = CoreUIObject.getLogger(BatchAndInv.class);

	/**
	 * output class constructor
	 */
	public BatchAndInv() throws Exception
	{
		super();
	}

	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}




	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();

		this.kDTable1.setName("���ο�����");
		List<Map> lotList = (List<Map>) this.getUIContext().get("lotList");

		showLotInfos(lotList);
	}

	/**
	 *  ����ʱ����ѯ����ŵ�����
	 * @param lotMap
	 */
	private void showLotInfos(List<Map> lotList) {
		// TODO Auto-generated method stub

		if(lotList != null && lotList.size() > 0){
			this.kDTable1.checkParsed();
			for(Map lotMap : lotList) {
				Set<String> keySet = lotMap.keySet();
				Iterator<String> it = keySet.iterator();
				while(it.hasNext()){
					String key = it.next();
					BigDecimal value = (BigDecimal) lotMap.get(key);
					IRow newRow = this.kDTable1.addRow();
					newRow.getCell("select").setValue(false);
					newRow.getCell("lot").setValue(key);
					newRow.getCell("lot").getStyleAttributes().setLocked(true);
					newRow.getCell("qty").setValue(value);
					newRow.getCell("qty").getStyleAttributes().setLocked(true);
				}
			}
		}


	}

	@Override
	public void initUIContentLayout() {
		// TODO Auto-generated method stub
		super.initUIContentLayout();
	}

	@Override
	protected void kDWorkButton1_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		super.kDWorkButton1_actionPerformed(e);

		List<String> errorList = new ArrayList<String>();

		Map<String,BigDecimal> choMap = new HashMap<String,BigDecimal>();

		for(int i = 0,size = kDTable1.getRowCount();i<size;i++){
			if(kDTable1.getCell(i,"select").getValue().equals(true)){
				errorList.add(UIRuleUtil.getString(kDTable1.getCell(i,"select").getValue()));
				choMap.put(UIRuleUtil.getString(kDTable1.getCell(i,"lot").getValue())
						,UIRuleUtil.getBigDecimal(kDTable1.getCell(i,"qty").getValue()));
			}
		}
		if(errorList.size() > 1){
			MsgBox.showWarning("ֻ��ѡ��һ����¼��");
			SysUtil.abort();
		}

		this.getUIContext().put("billNums", choMap);


		this.getUIWindow().close();
		this.destroyWindow();
	}

	/**
	 * ���ñ�ͷ
	 * @return
	 */
	protected RptTableHeader createHeader() {
		RptTableHeader header = new RptTableHeader();
		StringBuffer headerLabel=new StringBuffer();
		RptTableColumn col = null;

		//�����Ƿ�ѡ��Boolean����
		headerLabel.append("����");
		header.addColumn(new RptTableColumn("lot"));

		headerLabel.append(",");
		headerLabel.append("��ʱ�������");
		//����ͬ���������ʾ���
		col = new RptTableColumn();
		col.setWidth(200);
		col.setName("qty");
		header.addColumn(col);

		header.setLabels(new Object[][] { headerLabel.toString().split(",") });
		KDTableUtil.setHeader(header, this.kDTable1);
		return null;

	}

}