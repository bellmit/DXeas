/**
 * output package name
 */
package com.kingdee.eas.custom.ccchargeback.client;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.ccchargeback.ChargeBackStdFactory;
import com.kingdee.eas.custom.ccchargeback.ChargeBackStdInfo;
import com.kingdee.eas.custom.ccchargeback.ccCheckBillFacadeFactory;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.MathUtilsComm;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.farm.breed.HenhouseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class CcChargeBackBizBillEditUI extends AbstractCcChargeBackBizBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(CcChargeBackBizBillEditUI.class);

	private static ChargeBackStdInfo chargeBackStdInfo=null;
	private static HenhouseInfo henHouseInfo=null;
	/**
	 * output class constructor
	 */
	public CcChargeBackBizBillEditUI() throws Exception
	{
		super();
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		super.loadFields();
		if(editData.getId()==null)
			editData.setBillStatus(com.kingdee.eas.custom.ccchargeback.billStatus.save);
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
		return com.kingdee.eas.custom.ccchargeback.CcChargeBackBizBillFactory.getRemoteInstance();
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
		com.kingdee.eas.custom.ccchargeback.CcChargeBackBizBillInfo objectValue = new com.kingdee.eas.custom.ccchargeback.CcChargeBackBizBillInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());//���Ƶ�Ԫ
		objectValue.setBizDate(new Date());

		return objectValue;
	}


	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		checkIsExistSTD();	
		setUI();
	}


	/**
	 * ��Ʒ���������¼������÷�¼����Ĺ�������
	 */
	@Override
	protected void prmtstoOrgUnit_dataChang(DataChangeEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(kdtEntrys.getRowCount()>0)
			kdtEntrys.removeRows();
		setPrmtstoOrgUnitFilter();
		super.prmtstoOrgUnit_dataChang(e);
	}
	
	/**
	 * UI����
	 */
	private void setUI() {
		// TODO Auto-generated method stub
		this.setUITitle("��Ʒ�����յ�");
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

		setEntryColWidth();


		contLastUpdateTime.setVisible(true);
		contLastUpdateUser.setVisible(true);

		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));


		setCCStoOrgUnitFilter();
		setPrmtstoOrgUnitFilter();

		if(this.oprtState.equals("ADDNEW")||oprtState.equals("EDIT"))
			txtSTDRemark.setStringValue(fillRemark());
	}


	/**
	 * ��Ʒ�����յ���Ʒ��������
	 */
	private void setCCStoOrgUnitFilter() {
		// TODO Auto-generated method stub
		EntityViewInfo evi=new EntityViewInfo();
		FilterInfo filterInfo=new FilterInfo();
		filterInfo.getFilterItems().add(new FilterItemInfo("number","304%",CompareType.LIKE));
		filterInfo.getFilterItems().add(new FilterItemInfo("number","3041",CompareType.NOTEQUALS));
		filterInfo.getFilterItems().add(new FilterItemInfo("number","3042",CompareType.NOTEQUALS));
		filterInfo.getFilterItems().add(new FilterItemInfo("number","304",CompareType.NOTEQUALS));
		evi.setFilter(filterInfo);
		prmtstoOrgUnit.setEntityViewInfo(evi);
	}

	/**
	 * ���ü���Ĺ�������
	 */
	private void setPrmtstoOrgUnitFilter() {
		// TODO Auto-generated method stub

		String ccFactoryName=null;

		Component prmt = kdtEntrys.getColumn("henHouse").getEditor().getComponent();

		if(prmtstoOrgUnit.getValue()!=null)
			ccFactoryName=((StorageOrgUnitInfo) prmtstoOrgUnit.getValue()).getName();

		KDBizPromptBox f7 = null;
		if(prmt instanceof KDBizPromptBox)
			f7=(KDBizPromptBox)prmt;

		EntityViewInfo evi=new EntityViewInfo();
		FilterInfo filterInfo=new FilterInfo();
		filterInfo.getFilterItems().add(new FilterItemInfo("chickenFarm.name",ccFactoryName,CompareType.EQUALS));
		evi.setFilter(filterInfo);
		f7.setEntityViewInfo(evi);
	}
	/**
	 * ����Ƿ����Ψһ������Ʒ�����ձ�׼
	 * @throws BOSException 
	 */
	private void checkIsExistSTD() throws BOSException {
		// TODO Auto-generated method stub


		CoreBaseCollection coll = ChargeBackStdFactory.getRemoteInstance().getCollection("where billStatus=2");
		if(coll.size()==0)
			MsgBox.showInfo("û�����õ���Ʒ�����ձ�׼");
		if(coll.size()>1)
			MsgBox.showInfo("���ڶ�����õ���Ʒ�����ձ�׼");
		else
			chargeBackStdInfo=(ChargeBackStdInfo) coll.get(0);
		
		if(oprtState.equals("ADDNEW")&&chargeBackStdInfo==null)
			SysUtil.abort();
	}


	/**
	 * С�������¼�����
	 */
	@Override
	protected void txtchicksQty_dataChang(DataChangeEvent e) throws Exception {
		// TODO Auto-generated method stub
		setchicksChargeBack();
		setBuckleAndDeductMoney();
		super.txtchicksQty_dataChang(e);
	}

	/**
	 * С�������¼�����
	 */
	@Override
	protected void txtchicksWT_dataChang(DataChangeEvent e) throws Exception {
		// TODO Auto-generated method stub
		setchicksChargeBack();
		setBuckleAndDeductMoney();
		super.txtchicksWT_dataChang(e);
	}

	/**
	 * ��¼
	 */
	@Override
	protected void kdtEntrys_editStartin(KDTEditEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.kdtEntrys_editStartin(e);
		if("henHouse".equals(kdtEntrys.getColumn(e.getColIndex()).getKey())&&kdtEntrys.getCell(e.getRowIndex(),e.getColIndex()).getValue()!=null)
			henHouseInfo=(HenhouseInfo) kdtEntrys.getCell(e.getRowIndex(),e.getColIndex()).getValue();
		else
			henHouseInfo=null;


	}
	@Override
	protected void kdtEntrys_editStoppe(KDTEditEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.kdtEntrys_editStoppe(e);

		//��������
		if("henHouse".equals(kdtEntrys.getColumn(e.getColIndex()).getKey()))
			setIncoppQtyByHenHouseID(e.getRowIndex(),e.getColIndex());

		//צ�����
		if("pulvillusProportion".equals(kdtEntrys.getColumn(e.getColIndex()).getKey()))
			setPulvillusInformationByPulvillusPropotrion(e.getRowIndex(),e.getColIndex());

		//�ز�Ƥ��
		if("dermatitisProportion".equals(kdtEntrys.getColumn(e.getColIndex()).getKey()))
			setDermatitisByDermatitisProportion(e.getRowIndex(),e.getColIndex());

		//�������͵�ֻ�������
		if("SamplingRate".equals(kdtEntrys.getColumn(e.getColIndex()).getKey())||"maxWT".equals(kdtEntrys.getColumn(e.getColIndex()).getKey()))
			setCropInformation(e.getRowIndex(),e.getColIndex());

		setBuckleAndDeductMoney();
	}



	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(kdtEntrys.getRowCount()==0)
			commUtils.giveUserTipsAndRetire("��¼����Ϊ��");
		super.actionAudit_actionPerformed(e);
		this.setMessageText("���ͨ��");	this.showMessage();
		refreshCurPage();
	}
	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(editData.getId()!=null)
			if(ClientUtils.checkBillInWorkflow(this, editData.getId().toString()))
				commUtils.giveUserTipsAndRetire("�����Ѵ��ڹ�������");
		checkBeforeSave();
		super.actionSave_actionPerformed(e);
		refreshCurPage();
	}
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(editData.getId()!=null)
			if(ClientUtils.checkBillInWorkflow(this, editData.getId().toString()))
				commUtils.giveUserTipsAndRetire("�����Ѵ��ڹ�������");
		

		checkBeforeSave();
		super.actionSubmit_actionPerformed(e);
		refreshCurPage();
	}

	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		this.setMessageText("�����ͨ��");this.showMessage();
		refreshCurPage();
	}
	/**
	 * �����ؿۿ���صļ���
	 * @param rowIndex
	 * @param colIndex
	 */
	private void setCropInformation(int rowIndex, int colIndex) {
		// TODO Auto-generated method stub
		if(chargeBackStdInfo==null||chargeBackStdInfo.getCropSTD()==null||kdtEntrys.getCell(rowIndex, "incoopQty").getValue()==null){}
		else if(kdtEntrys.getCell(rowIndex, "SamplingRate").getValue()==null||kdtEntrys.getCell(rowIndex, "maxWT").getValue()==null){
			kdtEntrys.getCell(rowIndex, "cropBuckle").setValue(BigDecimal.ZERO);
			kdtEntrys.getCell(rowIndex, "cropDeductMoney").setValue(BigDecimal.ZERO);
		}
		else{
			BigDecimal samplingRate = (BigDecimal)kdtEntrys.getCell(rowIndex, "SamplingRate").getValue();//������
			BigDecimal maxWT=(BigDecimal)kdtEntrys.getCell(rowIndex, "maxWT").getValue();//��ֻ�������
			BigDecimal overRate = samplingRate.subtract(chargeBackStdInfo.getCropSTD());

			if(overRate.compareTo(BigDecimal.ZERO)!=1){
				kdtEntrys.getCell(rowIndex, "cropBuckle").setValue(BigDecimal.ZERO);
				kdtEntrys.getCell(rowIndex, "cropDeductMoney").setValue(BigDecimal.ZERO);
			}else{
				BigDecimal cropBuckle = maxWT.multiply(overRate).multiply(new BigDecimal("0.0001")).multiply(chargeBackStdInfo.getCoefficient()).multiply((BigDecimal)kdtEntrys.getCell(rowIndex, "incoopQty").getValue());
				kdtEntrys.getCell(rowIndex, "cropBuckle").setValue(cropBuckle);
				if(chargeBackStdInfo.getCoefficientGold()!=null){
					kdtEntrys.getCell(rowIndex, "cropDeductMoney").setValue(cropBuckle.multiply(chargeBackStdInfo.getCoefficientGold()));
				}else
					kdtEntrys.getCell(rowIndex, "cropDeductMoney").setValue(BigDecimal.ZERO);
			}
		}
	}
	/**
	 * �����ز�Ƥ�ױ�����д�����Ϣ
	 * @param rowIndex
	 * @param colIndex
	 */
	private void setDermatitisByDermatitisProportion(int rowIndex, int colIndex) {
		// TODO Auto-generated method stub
		if(chargeBackStdInfo==null){}
		else if(kdtEntrys.getCell(rowIndex, colIndex).getValue()==null){
			kdtEntrys.getCell(rowIndex, "dermatitisOver").setValue(BigDecimal.ZERO);
			kdtEntrys.getCell(rowIndex, "dermatitisAmt").setValue(BigDecimal.ZERO);
		}
		else{
			BigDecimal dermatitisProportion = (BigDecimal)kdtEntrys.getCell(rowIndex, colIndex).getValue();
			BigDecimal overRate = dermatitisProportion.subtract(chargeBackStdInfo.getDermatitisSTD());
			if(overRate.compareTo(BigDecimal.ZERO)==1){
				kdtEntrys.getCell(rowIndex, "dermatitisOver").setValue(overRate);//��������
				if(chargeBackStdInfo.getIncrProportionDer()!=null&&chargeBackStdInfo.getIncrProportionDer().compareTo(BigDecimal.ZERO)!=0){
					BigDecimal dermatitisAmt = chargeBackStdInfo.getIncrAmtDer().divide(chargeBackStdInfo.getIncrProportionDer(),2,BigDecimal.ROUND_HALF_EVEN).multiply(overRate);
//					int num=MathUtilsComm.translateFromBigdecimalToInteger(overRate.divide(chargeBackStdInfo.getIncrProportionDer(),0,BigDecimal.ROUND_FLOOR));
					if(chargeBackStdInfo.getIncrAmtDer()!=null)
						kdtEntrys.getCell(rowIndex, "dermatitisAmt").setValue(dermatitisAmt);//�������
				}
			}else{
				kdtEntrys.getCell(rowIndex, "dermatitisOver").setValue(BigDecimal.ZERO);//��������
				kdtEntrys.getCell(rowIndex, "dermatitisAmt").setValue(BigDecimal.ZERO);
			}
		}
	}
	/**
	 * ����צ�������д�����Ϣ
	 * @param rowIndex
	 * @param colIndex
	 */
	private void setPulvillusInformationByPulvillusPropotrion(int rowIndex,
			int colIndex) {
		// TODO Auto-generated method stub
		if(chargeBackStdInfo==null){}
		else if(kdtEntrys.getCell(rowIndex, colIndex).getValue()==null){
			kdtEntrys.getCell(rowIndex, "pulvillusOver").setValue(BigDecimal.ZERO);
			kdtEntrys.getCell(rowIndex, "pulvillusChargebackAmt").setValue(BigDecimal.ZERO);
		}
		else{
			BigDecimal pulvillusProportion = (BigDecimal)kdtEntrys.getCell(rowIndex, colIndex).getValue();
			BigDecimal overRate = pulvillusProportion.subtract(chargeBackStdInfo.getPulvillusSTD());
			if(overRate.compareTo(BigDecimal.ZERO)==1){
				kdtEntrys.getCell(rowIndex, "pulvillusOver").setValue(overRate);//��������
				if(chargeBackStdInfo.getIncrProportion()!=null&&chargeBackStdInfo.getIncrProportion().compareTo(BigDecimal.ZERO)!=0){
					BigDecimal paw= chargeBackStdInfo.getProportionAmt().divide(chargeBackStdInfo.getIncrProportion(),2,BigDecimal.ROUND_HALF_EVEN).multiply(overRate);
//					int num=MathUtilsComm.translateFromBigdecimalToInteger(overRate.divide(chargeBackStdInfo.getIncrProportion(),0,BigDecimal.ROUND_FLOOR));
					if(chargeBackStdInfo.getProportionAmt()!=null)
						kdtEntrys.getCell(rowIndex, "pulvillusChargebackAmt").setValue(paw);//��������
				}
			}else{
				kdtEntrys.getCell(rowIndex, "pulvillusOver").setValue(BigDecimal.ZERO);//��������
				kdtEntrys.getCell(rowIndex, "pulvillusChargebackAmt").setValue(BigDecimal.ZERO);
			}
		}
	}
	/**
	 * ���ݼ����ȡ��������
	 * @param rowIndex
	 * @param colIndex
	 * @throws EASBizException
	 * @throws BOSException
	 */
	private void setIncoppQtyByHenHouseID(int rowIndex, int colIndex) throws EASBizException, BOSException {
		// TODO Auto-generated method stub
		HenhouseInfo henHouseInfos=null;
		if(kdtEntrys.getCell(rowIndex, colIndex).getValue()!=null)
			henHouseInfos = (HenhouseInfo)kdtEntrys.getCell(rowIndex, colIndex).getValue();
		else
			return;
		if(henHouseInfos!=henHouseInfo)
			for(int i=0;i<kdtEntrys.getColumnCount();i++)
				if(!kdtEntrys.getColumn(i).getKey().equals("henHouse"))
					kdtEntrys.getCell(rowIndex, i).setValue(null);

		if(kdtEntrys.getCell(rowIndex, colIndex).getValue()==null)
			return;

		String henHouseID = henHouseInfos.getId().toString();
		if(ccCheckBillFacadeFactory.getRemoteInstance().getLairageQtyByHenhouseId(henHouseID)!=null){
			String lairageQty=ccCheckBillFacadeFactory.getRemoteInstance().getLairageQtyByHenhouseId(henHouseID);
			kdtEntrys.getCell(rowIndex, "incoopQty").setValue(new BigDecimal(lairageQty));
		}else
			kdtEntrys.getCell(rowIndex, "incoopQty").setValue(null);
	}
	/**
	 * ����С������������������С��������Ϣ
	 */
	private void setchicksChargeBack() {
		// TODO Auto-generated method stub
		if(chargeBackStdInfo==null)
			return;
		
		
		if(txtchicksQty.getBigDecimalValue()!=null&&txtchicksWT.getBigDecimalValue()!=null)
			if(txtchicksQty.getBigDecimalValue().compareTo(BigDecimal.ZERO)!=0){
				BigDecimal avgWt = txtchicksWT.getBigDecimalValue().divide(txtchicksQty.getBigDecimalValue(),2,BigDecimal.ROUND_HALF_EVEN);
				txtchicksAvgWT.setValue(avgWt);//��ֻ����
				if(chargeBackStdInfo.getYieldRate()!=null&&chargeBackStdInfo.getYieldRate().compareTo(BigDecimal.ZERO)!=0){
					BigDecimal grossAvgWT = avgWt.multiply(new BigDecimal("100")).divide(chargeBackStdInfo.getYieldRate(),2,BigDecimal.ROUND_HALF_EVEN);
					txtgrossChickenWT.setValue(grossAvgWT);//���㼦ֻë��
					BigDecimal grossTotalWT = txtchicksWT.getBigDecimalValue().multiply(new BigDecimal("100")).divide(chargeBackStdInfo.getYieldRate(),2,BigDecimal.ROUND_HALF_EVEN);
					txtgrossChickTotalWT.setValue(grossTotalWT);
				}
			}
	}
	/**
	 * ��¼ͷ�ۿ������Ϣ����д
	 */
	private void setBuckleAndDeductMoney() {
		// TODO Auto-generated method stub
		BigDecimal totalWT = BigDecimal.ZERO;
		BigDecimal totalAmt = BigDecimal.ZERO;
		if(txtgrossChickTotalWT.getBigDecimalValue()!=null)
			totalWT=totalWT.add(txtgrossChickTotalWT.getBigDecimalValue());
		for(int i=0;i<kdtEntrys.getRowCount();i++){
			if(kdtEntrys.getCell(i, "pulvillusChargebackAmt").getValue()!=null)
				totalAmt=totalAmt.add(new BigDecimal(String.valueOf(kdtEntrys.getCell(i, "pulvillusChargebackAmt").getValue())));
			if(kdtEntrys.getCell(i, "dermatitisAmt").getValue()!=null)
				totalAmt=totalAmt.add(new BigDecimal(String.valueOf(kdtEntrys.getCell(i, "dermatitisAmt").getValue())));
			if(kdtEntrys.getCell(i, "cropDeductMoney").getValue()!=null)
				totalAmt=totalAmt.add(new BigDecimal(String.valueOf( kdtEntrys.getCell(i, "cropDeductMoney").getValue())));
			if(kdtEntrys.getCell(i, "cropBuckle").getValue()!=null)
				totalWT=totalWT.add(new BigDecimal(String.valueOf( kdtEntrys.getCell(i, "cropBuckle").getValue())));
		}
		txttotalAmt.setValue(totalAmt);
		txttotalWeight.setValue(totalWT);
	}
	/**
	 * ��д˵��
	 * @return
	 */
	private String fillRemark() {
		// TODO Auto-generated method stub
		String str="1.������Ʒ���������з�¼�������,���������";
		str+="\n2.�����������ֶε�λΪ(KG),�����ֶεĵ�λΪ(%)";
		int number=2;
		if(chargeBackStdInfo!=null){
			if(chargeBackStdInfo.getCarcassSTD()!=null)
				str+="\n"+String.valueOf(++number)+".������������"+String.valueOf(chargeBackStdInfo.getCarcassSTD())+"KG�İ�С������,";
			if(chargeBackStdInfo.getYieldRate()!=null)
				str+="���尴ë������"+String.valueOf(chargeBackStdInfo.getYieldRate())+"%���п���(����Сë��ֻ��=С��ֻ��/("+String.valueOf(chargeBackStdInfo.getYieldRate())+"%)";

			if(chargeBackStdInfo.getPulvillusSTD()!=null)
				str+="\n"+String.valueOf(++number)+".צ�����"+String.valueOf(chargeBackStdInfo.getPulvillusSTD())+"%ʱ���пۿ�,";
			if(chargeBackStdInfo.getIncrProportion()!=null&&chargeBackStdInfo.getProportionAmt()!=null)
				str+="ÿ����"+String.valueOf(chargeBackStdInfo.getIncrProportion())+"%����"+String.valueOf(chargeBackStdInfo.getProportionAmt())+"Ԫ";

			if(chargeBackStdInfo.getDermatitisSTD()!=null)
				str+="\n"+String.valueOf(++number)+".�ز�Ƥ�׸���"+String.valueOf(chargeBackStdInfo.getDermatitisSTD())+"%ʱ���пۿ�,";
			if(chargeBackStdInfo.getIncrProportionDer()!=null&&chargeBackStdInfo.getIncrAmtDer()!=null)
				str+="ÿ����"+String.valueOf(chargeBackStdInfo.getIncrProportionDer())+"%����"+String.valueOf(chargeBackStdInfo.getIncrAmtDer())+"Ԫ";

			if(chargeBackStdInfo.getCropSTD()!=null)
				str+="\n"+String.valueOf(++number)+".��ұ�������"+String.valueOf(chargeBackStdInfo.getCropSTD())+"%ʱ���д���,";
			if(chargeBackStdInfo.getCoefficient()!=null){
				str+="���ع�ʽ:��ҿ���=(������-��ұ�׼)*����ֻ��*"+String.valueOf(chargeBackStdInfo.getCoefficient())+"%*��������������,";
//				&&chargeBackStdInfo.getCoefficientGold()!=null
				str+="\r\n   �ۿʽ:��ҿۿ�=��ҿ���*"+String.valueOf(chargeBackStdInfo.getCoefficientGold());
			}
		}
		return str;
	}
	/**
	 * У���¼���Ƿ������ͬ��������
	 */
	private void checkDuplicateValueEntry() {
		// TODO Auto-generated method stub
		for(int i=0;i<kdtEntrys.getRowCount();i++)
			for(int j=i+1;j<kdtEntrys.getRowCount();j++)
				if(kdtEntrys.getCell(i, "henHouse").getValue().equals(kdtEntrys.getCell(j, "henHouse").getValue()))
					commUtils.giveUserTipsAndRetire("��¼�����ظ��ļ���");
	}
	/**
	 * ���ñ��еĿ��,���ֵ���ʾλ��
	 */
	private void setEntryColWidth() {
		// TODO Auto-generated method stub
		String [] colName={"henHouse","henHouseName","incoopQty","pulvillusProportion","pulvillusOver","pulvillusChargebackAmt","dermatitisProportion","dermatitisOver","dermatitisAmt","avgWT","SamplingRate","maxWT","cropBuckle","cropDeductMoney"};
		int []width={100,80,80,80,90,80,100,120,100,80,90,120,80,80};
		HorizontalAlignment[] style={HorizontalAlignment.LEFT,HorizontalAlignment.LEFT,HorizontalAlignment.RIGHT,HorizontalAlignment.RIGHT,HorizontalAlignment.RIGHT,HorizontalAlignment.RIGHT,HorizontalAlignment.RIGHT,HorizontalAlignment.RIGHT,HorizontalAlignment.RIGHT,HorizontalAlignment.RIGHT,HorizontalAlignment.RIGHT,HorizontalAlignment.RIGHT,HorizontalAlignment.RIGHT,HorizontalAlignment.RIGHT};
		for(int i=0;i<colName.length;i++){
			kdtEntrys.getColumn(colName[i]).setWidth(width[i]);
			kdtEntrys.getColumn(colName[i]).getStyleAttributes().setHorizontalAlign(style[i]);
		}
		kdtEntrys.setAutoResize(true);
		kdtEntrys.getColumn("avgWT").getStyleAttributes().setHided(true);
		kdtEntrys.getColumn("dermatitisAmt").getStyleAttributes().setLocked(true);
	}

	/**
	 * output actionSubmit_actionPerformed
	 * ˢ�²���
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
	 * ������ύǰ������У��
	 */
	private void checkBeforeSave() {
		// TODO Auto-generated method stub
		if(kdtEntrys.getRowCount()==0)
			commUtils.giveUserTipsAndRetire("��¼����Ϊ��");
		checkDuplicateValueEntry();
	}
}