/**
 * output package name
 */
package com.kingdee.eas.custom.signwasthetable.client;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.ui.dtp.model.layout.Layout;
import com.kingdee.bos.ui.dtp.model.layout.XYLayout;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.signwasthetable.CmChangeEntryInfo;
import com.kingdee.eas.custom.signwasthetable.CmChangeInfo;
import com.kingdee.eas.custom.signwasthetable.ContractFactory;
import com.kingdee.eas.custom.signwasthetable.ContractInfo;
import com.kingdee.eas.custom.signwasthetable.ContractPaymentCollection;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.portal.LayoutFactory;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.ctrl.analysis.web.dashboard.LayoutUtil;
import com.kingdee.bos.ctrl.data.engine.rows.IRow;
import com.kingdee.bos.ctrl.freechart.ui.HorizontalAlignment;
import com.kingdee.bos.ctrl.kdf.servertable.ICell;
import com.kingdee.bos.ctrl.kdf.servertable.IColumn;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.KDButton;

/**
 * output class name
 */
public class CmChangeEditUI extends AbstractCmChangeEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(CmChangeEditUI.class);

	/**
	 * output class constructor
	 */
	public CmChangeEditUI() throws Exception
	{
		super();
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		super.loadFields(); 
		
		//���ð�ť���ɼ�
		this.btnAddNew.setVisible(false);
		this.btnEdit.setVisible(false);
		this.btnCopy.setVisible(false);
		this.btnSave.setVisible(false);
		this.btnSubmit.setVisible(false);
		this.btnRemove.setVisible(false);
		this.btnCreateFrom.setVisible(false);
		this.btnCreateTo.setVisible(false);
		this.btnInsertLine.setVisible(false);
		this.btnRemoveLine.setVisible(false);
		this.btnAddLine.setVisible(false);
		this.btnAuditResult.setVisible(false);
		this.txtVersion.setEnabled(false);
		this.txtpreVersion.setEnabled(false);
		this.pkBizDate.setEnabled(false);
		this.pkViewDate.setEnabled(false);
		this.btnPre.setVisible(false);
		this.btnLast.setVisible(false);
		this.btnNext.setVisible(false);
		this.btnFirst.setVisible(false);
		this.btnPrint.setVisible(false);
		this.btnPrintPreview.setVisible(false);
		this.btnAttachment.setVisible(false);
		this.btnTraceDown.setVisible(false);
		this.btnTraceUp.setVisible(false);
		this.btnNextPerson.setVisible(false);
		this.btnWorkFlowG.setVisible(false);
		this.btnAuditResult.setVisible(false);
		this.btnWFViewdoProccess.setVisible(false);
		this.btnWFViewSubmitProccess.setVisible(false);
		this.btnMultiapprove.setVisible(false);
		this.btnAuditResult.setVisible(false);

		this.menuEdit.setVisible(false);
		this.menuTable1.setVisible(false);
		this.menuWorkflow.setVisible(false);
		this.menuFile.setVisible(false);
        
		//���ñ��ť������
		kdtEntrys_detailPanel.getAddNewLineButton().setEnabled(false);
		kdtEntrys_detailPanel.getRemoveLinesButton().setEnabled(false);
		kdtEntrys_detailPanel.getInsertLineButton().setEnabled(false);

	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		
		
		//ȡ����Դ���ݵ�id������id��õ�ǰ��ͬ�汾��id����һ�汾��id
		String srcBillID = (String) this.getUIContext().get("srcBillID");
		//����id���info
		ContractInfo cmInfo=ContractFactory.getRemoteInstance().getContractInfo(new ObjectUuidPK(srcBillID));
		ContractInfo cmInfoPre=ContractFactory.getRemoteInstance().getContractInfo(new ObjectUuidPK(cmInfo.getPerVersionID()));
		
		//���ñ�ͷ�ֶ���Ϣ����ǰ�汾����һ�汾�İ汾�ţ��汾�޸ĵ�ʱ�䣬��ǰ���ڣ�
		this.txtVersion.setStringValue(cmInfo.getVersion());
		this.pkBizDate.setValue(cmInfo.getBizDate());
		this.txtpreVersion.setStringValue(cmInfoPre.getVersion());
		this.pkViewDate.setValue(new Date());
		
		


		kdtEntrys.getColumn("VersionNum").setWidth(180);//�汾�������п������Ϊ180
		kdtEntrys.addRows(2);//�Զ��������У��ֱ���ʾ��һ�汾����һ�汾�Ľ��仯
		com.kingdee.bos.ctrl.kdf.table.IRow row=kdtEntrys.getRow(0);//��һ���汾
		com.kingdee.bos.ctrl.kdf.table.IRow rowNow=kdtEntrys.getRow(1);//��ǰ�汾
		row.getCell("VersionNum").setValue("���ǰ");
		rowNow.getCell("VersionNum").setValue("�����");	
		
		kdtEntrys.getColumn("VersionNum").setWidth(80);
		
		
		
		row.getCell("amount").setValue(cmInfoPre.getAmountOriCurrency());
		rowNow.getCell("amount").setValue(cmInfo.getAmountLocalCurrency());
		if(!row.getCell("amount").getValue().equals(rowNow.getCell("amount").getValue()))
		{
			rowNow.getCell("amount").getStyleAttributes().setFontColor(Color.red);
		}


		ContractPaymentCollection cmEntry = cmInfo.getPayment();
		ContractPaymentCollection cmpEntry = cmInfoPre.getPayment();

		com.kingdee.bos.ctrl.kdf.table.IRow rowAdd = null;//��ͷ��
		com.kingdee.bos.ctrl.kdf.table.ICell cellAdd=null;//��ͷ�������ĵ�Ԫ�񣬼���ʾ�����ĵ�Ԫ��
		rowAdd=kdtEntrys.getHeadRow(0);


		if((cmInfo.getBailAmount().compareTo(cmInfoPre.getBailAmount()))!=0)
		{
			kdtEntrys.addColumn();
			com.kingdee.bos.ctrl.kdf.table.ICell cellBail = rowAdd.getCell(kdtEntrys.getColumnCount()-1);
			cellBail.setValue("��֤����");
			row.getCell(cellBail.getColumnIndex()).setValue(cmInfoPre.getBailAmount());
			rowNow.getCell(cellBail.getColumnIndex()).setValue(cmInfo.getBailAmount());
			rowNow.getCell(cellBail.getColumnIndex()).getStyleAttributes().setFontColor(Color.red);
		}
		for(int i=0;i<cmEntry.size()||i<cmpEntry.size();i++)
		{
			//����������׶����
			if(i>=cmpEntry.size()&&i<cmEntry.size())
			{
				kdtEntrys.addColumn();
				cellAdd=rowAdd.getCell(kdtEntrys.getColumnCount()-1);
				cellAdd.setValue("��"+(i+1)+"�׶θ�����");	
				if(cmEntry.get(i).get("payAmount")!=null)
					rowNow.getCell(cellAdd.getColumnIndex()).setValue(cmEntry.get(i).get("payAmount"));
				rowNow.getCell(cellAdd.getColumnIndex()).getStyleAttributes().setFontColor(Color.red);

				if(cmEntry.get(i).get("overAmt")!=null)
				{
					kdtEntrys.addColumn();
					cellAdd=rowAdd.getCell(kdtEntrys.getColumnCount()-1);
					cellAdd.setValue("��"+(i+1)+"�׶οɸ�����");	
					if(cmEntry.get(i).get("overAmt")!=null)
						rowNow.getCell(cellAdd.getColumnIndex()).setValue(cmEntry.get(i).get("overAmt"));
					rowNow.getCell(cellAdd.getColumnIndex()).getStyleAttributes().setFontColor(Color.red);
				}
			}
			else if(i>=cmEntry.size()&&i<cmpEntry.size())
			{
				kdtEntrys.addColumn();
				cellAdd=rowAdd.getCell(kdtEntrys.getColumnCount()-1);
				cellAdd.setValue("��"+(i+1)+"�׶θ�����");	
				if(cmpEntry.get(i).get("payAmount")!=null)
					row.getCell(cellAdd.getColumnIndex()).setValue(cmpEntry.get(i).get("payAmount"));
				rowNow.getCell(cellAdd.getColumnIndex()).getStyleAttributes().setFontColor(Color.red);


				if(cmpEntry.get(i).get("overAmt")!=null)
				{
					kdtEntrys.addColumn();
					cellAdd=rowAdd.getCell(kdtEntrys.getColumnCount()-1);
					cellAdd.setValue("��"+(i+1)+"�׶οɸ�����");	
					if(cmEntry.get(i).get("overAmt")!=null)
						rowNow.getCell(cellAdd.getColumnIndex()).setValue(cmpEntry.get(i).get("overAmt"));
					rowNow.getCell(cellAdd.getColumnIndex()).getStyleAttributes().setFontColor(Color.red);
				}
			}
			else if(cmEntry.get(i).get("payAmount")!=null&&cmpEntry.get(i).get("payAmount")!=null)
			{
				if(cmEntry.get(i).get("payAmount").equals(cmpEntry.get(i).get("payAmount"))){}
				else
				{
					kdtEntrys.addColumn();
					cellAdd=rowAdd.getCell(kdtEntrys.getColumnCount()-1);
					cellAdd.setValue("��"+(i+1)+"�׶θ�����");	
					if(cmpEntry.get(i).get("payAmount")!=null)
						row.getCell(cellAdd.getColumnIndex()).setValue(cmpEntry.get(i).get("payAmount"));

					if(cmEntry.get(i).get("payAmount")!=null)
						rowNow.getCell(cellAdd.getColumnIndex()).setValue(cmEntry.get(i).get("payAmount"));

					rowNow.getCell(cellAdd.getColumnIndex()).getStyleAttributes().setFontColor(Color.red);
				}
			}
			if(i<cmEntry.size()&&i<cmpEntry.size())
				if(cmEntry.get(i).get("overAmt")!=null&&cmpEntry.get(i).get("overAmt")==null)
				{
					if(!cmEntry.get(i).get("overAmt").equals(cmpEntry.get(i).get("overAmt")))
					{
						kdtEntrys.addColumn();
						cellAdd=rowAdd.getCell(kdtEntrys.getColumnCount()-1);
						cellAdd.setValue("��"+(i+1)+"�׶οɸ�����");	
						if(cmEntry.get(i).get("overAmt")!=null)
							rowNow.getCell(cellAdd.getColumnIndex()).setValue(cmEntry.get(i).get("overAmt"));
						row.getCell(cellAdd.getColumnIndex()).setValue(cmpEntry.get(i).get("payAmount"));
						rowNow.getCell(cellAdd.getColumnIndex()).getStyleAttributes().setFontColor(Color.red);
					}
				}
				else if(cmEntry.get(i).get("overAmt")==null&&cmpEntry.get(i).get("overAmt")!=null)
				{
					kdtEntrys.addColumn();
					cellAdd=rowAdd.getCell(kdtEntrys.getColumnCount()-1);
					cellAdd.setValue("��"+(i+1)+"�׶οɸ�����");	
					if(cmpEntry.get(i).get("overAmt")!=null)
						row.getCell(cellAdd.getColumnIndex()).setValue(cmpEntry.get(i).get("overAmt"));
					rowNow.getCell(cellAdd.getColumnIndex()).setValue(cmpEntry.get(i).get("payAmount"));
				}
				else if(cmEntry.get(i).get("overAmt")!=null&&cmpEntry.get(i).get("overAmt")!=null)
					if(!cmEntry.get(i).get("overAmt").equals(cmpEntry.get(i).get("overAmt")))
					{
						kdtEntrys.addColumn();
						cellAdd=rowAdd.getCell(kdtEntrys.getColumnCount()-1);
						cellAdd.setValue("��"+(i+1)+"�׶οɸ�����");	
						if(cmpEntry.get(i).get("overAmt")!=null)
							row.getCell(cellAdd.getColumnIndex()).setValue(cmpEntry.get(i).get("overAmt"));
						if(cmEntry.get(i).get("overAmt")!=null)
							rowNow.getCell(cellAdd.getColumnIndex()).setValue(cmEntry.get(i).get("overAmt"));
						rowNow.getCell(cellAdd.getColumnIndex()).getStyleAttributes().setFontColor(Color.red);
					}

		}
		for(int j=0;j<kdtEntrys.getColumnCount();j++)
		{
			rowNow.getStyleAttributes().setBackground(Color.LIGHT_GRAY);
		}
		if(kdtEntrys.getColumnCount()<7)
			kdtEntrys.setAutoResize(true);

		//		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		//		Size(Toolkit.getDefaultToolkit().getScreenSize());
		//		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize().)
		
		
		
		for(int i=2;i<kdtEntrys.getColumnCount();i++)
			kdtEntrys.getColumn(i).getStyleAttributes().setHorizontalAlign(com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment.RIGHT);
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

	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.custom.signwasthetable.CmChangeFactory.getRemoteInstance();
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
	@SuppressWarnings("deprecation")
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.signwasthetable.CmChangeInfo objectValue = new com.kingdee.eas.custom.signwasthetable.CmChangeInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		return objectValue;
	}

}