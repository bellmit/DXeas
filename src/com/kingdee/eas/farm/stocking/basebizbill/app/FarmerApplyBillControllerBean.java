package com.kingdee.eas.farm.stocking.basebizbill.app;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.permission.AdminToOrgRangeHandler;
import com.kingdee.eas.basedata.master.cssp.app.DataImportUtils;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.BizParentAndDelegateInfo;
import com.kingdee.eas.basedata.org.CostCenterType;
import com.kingdee.eas.basedata.org.CtrlUnitFactory;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.FullOrgUnitFactory;
import com.kingdee.eas.basedata.org.FullOrgUnitInfo;
import com.kingdee.eas.basedata.org.IAdminOrgUnit;
import com.kingdee.eas.basedata.org.OUPartAdminFactory;
import com.kingdee.eas.basedata.org.OUPartAdminInfo;
import com.kingdee.eas.basedata.org.OUPartCostCenterFactory;
import com.kingdee.eas.basedata.org.OUPartCostCenterInfo;
import com.kingdee.eas.basedata.org.OrgSpecialTablesRebuildFacadeFactory;
import com.kingdee.eas.basedata.org.OrgStructureFactory;
import com.kingdee.eas.basedata.org.OrgStructureInfo;
import com.kingdee.eas.basedata.org.OrgTreeFactory;
import com.kingdee.eas.basedata.org.OrgTreeInfo;
import com.kingdee.eas.basedata.org.OrgUnitDefaultRelationInfo;
import com.kingdee.eas.basedata.org.OrgUnitLayerTypeFactory;
import com.kingdee.eas.basedata.org.OrgUnitLayerTypeInfo;
import com.kingdee.eas.basedata.org.OrgUnitRelationInfo;
import com.kingdee.eas.basedata.orgext.OUPartMarketFactory;
import com.kingdee.eas.basedata.orgext.OUPartMarketInfo;
import com.kingdee.eas.basedata.orgext.OUPartServiceFactory;
import com.kingdee.eas.basedata.orgext.OUPartServiceInfo;
import com.kingdee.eas.basedata.ws.common.WsCommonImportUtil;
import com.kingdee.eas.basedata.ws.common.WsCommonTag;
import com.kingdee.eas.basedata.ws.common.WsCommonUtil;
import com.kingdee.eas.basedata.ws.common.WsCommonXMLUtil;
import com.kingdee.eas.basedata.ws.org.ImportFullOrgFacadeFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillFactory;
import com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillInfo;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.FarmFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmersFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmersFarmEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmersInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingFarmTypeEnum;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class FarmerApplyBillControllerBean extends AbstractFarmerApplyBillControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.stocking.basebizbill.app.FarmerApplyBillControllerBean");
	protected void _audit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{
		FarmerApplyBillInfo info = (FarmerApplyBillInfo) model;
		if(!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)) {
			return;
		}
		//生成养殖户信息
		FarmersInfo farmerInfo=null;
		if(info.getFarmer()==null) {
			farmerInfo=new FarmersInfo();
			farmerInfo.setNumber(StockingComm.getAutoNumberByOrg(ctx, farmerInfo));
		}else{
			farmerInfo=info.getFarmer();
		}
		farmerInfo.setTreeid(info.getFarmerGroup());
		farmerInfo.setCompany(info.getCompany());
		farmerInfo.setName(info.getName());
		farmerInfo.setIdentity(info.getIdentity());
		farmerInfo.setTel(info.getTel());
		farmerInfo.setMobileTel(info.getMobileTel());
		farmerInfo.setAddress(info.getAddress());
		farmerInfo.setSex(info.getSex());
		farmerInfo.setBank(info.getBankName());
		farmerInfo.setBankNo(info.getBankNo());
		farmerInfo.setBEBank(info.getBEBank());
		farmerInfo.setFarmerActName(info.getActualName());
		farmerInfo.setBaseStatus(FarmBaseStatusEnum.enable);//enable
		farmerInfo.setAuditTime(new java.util.Date());
		farmerInfo.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		farmerInfo.setAge(info.getAge());
		farmerInfo.setEduLvl(info.getEduLvl());
		farmerInfo.setNation(info.getNation());
		farmerInfo.setFamilyPersonCount(info.getFamilyPeronCount());

		BaseSysSettingInfo sSetting = StockingComm.getSysSetting(ctx, info.getCompany().getString("id"));
		//养殖户内部管理
		if(sSetting.isIsInner()) {
			FullOrgUnitInfo parentOrg =null;
			if(sSetting.getParentCostCenter()==null) {
				parentOrg=FullOrgUnitFactory.getLocalInstance(ctx).getFullOrgUnitInfo(new ObjectUuidPK(info.getCompany().getId()));
			}else{
				parentOrg=FullOrgUnitFactory.getLocalInstance(ctx).getFullOrgUnitInfo(new ObjectUuidPK(sSetting.getParentCostCenter().getId()));
			}
			FullOrgUnitInfo orgInfo=new FullOrgUnitInfo();
			orgInfo.setId(BOSUuid.create(orgInfo.getBOSType()));
			orgInfo.setNumber(getCostCenterNum(ctx, parentOrg));
			orgInfo.setIsAdminOrgUnit(true);
			orgInfo.setIsCostOrgUnit(true);
			orgInfo.setIsLeaf(true);
			orgInfo.setName(info.getName());
			orgInfo.setIsCU(false);
			orgInfo.put("isCus", false);
			orgInfo.setOrgTypeStr(";Admin;;CostCenter;");

			//拓展行政组织
			OUPartAdminInfo adminOrg=new OUPartAdminInfo();
			adminOrg.setId(BOSUuid.create(adminOrg.getBOSType()));
			adminOrg.setUnit(orgInfo);
			OrgUnitLayerTypeInfo layerTypeInfo=OrgUnitLayerTypeFactory.getLocalInstance(ctx).getOrgUnitLayerTypeInfo(new ObjectUuidPK("00000000-0000-0000-0000-00000000000362824988"));
			adminOrg.setUnitLayerType(layerTypeInfo);
			adminOrg.setControlUnit(parentOrg.getCU());
			adminOrg.setIsEntity(false);
			adminOrg.setEconomicType(null);
			orgInfo.setPartAdmin(adminOrg);

			//扩展成本中心
			OUPartCostCenterInfo costOrg=new OUPartCostCenterInfo();
			costOrg.setId(BOSUuid.create(costOrg.getBOSType()));
			costOrg.setUnit(orgInfo);
			costOrg.setIsBizUnit(true);
			costOrg.setCostCenterType(CostCenterType.DirectProdDept);

			//扩展成本中心市场组织
			OUPartMarketInfo oumOrg=new OUPartMarketInfo();
			oumOrg.setIsBizUnit(false);
			orgInfo.put("marketorgtype", oumOrg);
			//扩展成本中心服务组织
			OUPartServiceInfo osorg=new OUPartServiceInfo();
			osorg.setIsBizUnit(false);

			orgInfo.setPartCostCenter(costOrg);//扩展成本中心
			orgInfo.setParent(parentOrg);

			orgInfo.put("costCenter", costOrg);

			BizParentAndDelegateInfo badInfo=new BizParentAndDelegateInfo();
			/*badInfo.setAdminParent(parentOrg);
    		badInfo.setCostParent(parentOrg);
    		OrgUnitRelationInfo orgRInfo=new OrgUnitRelationInfo();
    		orgRInfo.set
			badInfo.getDelegateCollection().add(orgRInfo);*/
			badInfo.setAdminParent(parentOrg);
			//			 badInfo.setCostParent(parentOrg);
			OrgUnitRelationInfo orgRInfo=new OrgUnitRelationInfo();
			badInfo.getDelegateCollection().add(orgRInfo);
			orgInfo.put("pdvalueinfo", badInfo);

			FullOrgUnitFactory.getLocalInstance(ctx).addnew(orgInfo);

			OUPartCostCenterFactory.getLocalInstance(ctx).save(costOrg);
			OUPartAdminFactory.getLocalInstance(ctx).save(adminOrg);
			OUPartMarketFactory.getLocalInstance(ctx).save(oumOrg);
			OUPartServiceFactory.getLocalInstance(ctx).save(osorg);

			OrgUnitDefaultRelationInfo odrInfo=new OrgUnitDefaultRelationInfo();
			odrInfo.setFromUnit(orgInfo);
			odrInfo.setToUnit(parentOrg);

			//组织结构视图
			CoreBaseCollection cols=new CoreBaseCollection();
			OrgStructureInfo osinfo=new OrgStructureInfo();
			osinfo.setUnit(orgInfo);
			//成本中心视图
			OrgTreeInfo item=OrgTreeFactory.getLocalInstance(ctx).getOrgTreeInfo(new ObjectUuidPK("00000000-0000-0000-0000-0000000000054F2827FD"));
			osinfo.setTree(item);
			OrgStructureFactory.getLocalInstance(ctx).save(osinfo);
			cols.add(osinfo);

			OrgStructureInfo osinfo2=new OrgStructureInfo();
			osinfo2.setUnit(orgInfo);
			//行政组织视图
			 OrgTreeInfo item2=OrgTreeFactory.getLocalInstance(ctx).getOrgTreeInfo(new ObjectUuidPK("00000000-0000-0000-0000-0000000000034F2827FD"));
			 osinfo2.setTree(item2);


			 CoreBaseCollection colls = OrgStructureFactory.getLocalInstance(ctx).getCollection("where unit='"+parentOrg.getString("id")+"'");
			 osinfo2.setParent((OrgStructureInfo) colls.get(0));
			 osinfo2.setLevel(((OrgStructureInfo) colls.get(0)).getLevel()+1);
			 cols.add(osinfo2);

			 OrgStructureFactory.getLocalInstance(ctx).save(cols);
			 OrgSpecialTablesRebuildFacadeFactory.getLocalInstance(ctx).rebuildSpecialTables(orgInfo, 3);
			 new AdminToOrgRangeHandler().afterDeal(ctx, orgInfo);
			 IAdminOrgUnit iAdmin = AdminOrgUnitFactory.getLocalInstance(ctx);
			 AdminOrgUnitInfo adminInfo = iAdmin.getAdminOrgUnitInfo(new ObjectUuidPK(orgInfo.getId().toString()));
			 adminInfo.setBOSUuid("layerType", BOSUuid.read("00000000-0000-0000-0000-00000000000362824988"));
			 adminInfo.setBOSUuid("parent", orgInfo.getId());
			//组织结构试图 新增完成



			//行政组织委托财务组织
			/*odrInfo.setTypeRelation(OrgTypeRelationFactory.getLocalInstance(ctx).getOrgTypeRelationInfo(new ObjectUuidPK("00000000-0000-0000-0000-0000000000010FE9F8B5")));
    		OrgUnitDefaultRelationFactory.getLocalInstance(ctx).save(odrInfo);*/
			//行政组织委托财务组织
			 OrgUnitRelationInfo orgUnitRalationInfo=new OrgUnitRelationInfo();
			 orgUnitRalationInfo.setFromUnit(orgInfo);
			 orgUnitRalationInfo.setToUnit(ContextUtil.getCurrentFIUnit(ctx));
			 orgUnitRalationInfo.setBOSUuid("TypeRelation", BOSUuid.read("00000000-0000-0000-0000-0000000000010FE9F8B5"));
			 orgUnitRalationInfo.setIsDefault(false);
			 orgUnitRalationInfo.setVersionNumber("000");
			 BOSUuid id = BOSUuid.create("3B2666DB");
			 DbUtil.execute(ctx,"insert into T_ORG_UnitRelation (FID,FVersionNumber,FIsDefault,FTypeRelationID,FToUnitID,FFromUnitID) values(?,?,?,?,?,?)",new Object[]{id.toString(),"000",0,"00000000-0000-0000-0000-0000000000010FE9F8B5",ContextUtil.getCurrentFIUnit(ctx).getString("id"),orgInfo.getString("id")});
			farmerInfo.put("costCenter",orgInfo.getId().toString());

			farmerInfo.setNumber(orgInfo.getNumber());

		}else{
			//生成客户、供应商

		}

		CoreBaseCollection farmCollection=new CoreBaseCollection();
		farmerInfo.getFarmEntry().clear();
		//生成养殖场信息
		for(int index=0;index<info.getFarmEntry().size();index++) {
			FarmInfo faInfo=info.getFarmEntry().get(index).getFarm();
			if(faInfo==null) {
				faInfo=new FarmInfo();
				faInfo.setId(BOSUuid.create(faInfo.getBOSType()));
				if(info.getFarmEntry().size()==1) {
					faInfo.setNumber(farmerInfo.getNumber());
				}else{
					faInfo.setNumber(StockingComm.getAutoNumberByOrg(ctx, faInfo));
				}
			}
			faInfo.setTreeid(info.getFarmEntry().get(index).getFarmGroup());
			faInfo.setCompany(info.getCompany());
			faInfo.setName(info.getFarmEntry().get(index).getName());
			faInfo.setAddress(info.getFarmEntry().get(index).getAddress());
			faInfo.setArea(info.getFarmEntry().get(index).getArea());
			faInfo.setFloorArea(info.getFarmEntry().get(index).getFloorArea());
			faInfo.setFarmType(StockingFarmTypeEnum.stocking);//养户放养
			faInfo.setBaseStatus(FarmBaseStatusEnum.enable);
			farmCollection.add(faInfo);

			info.getFarmEntry().get(index).setFarm(faInfo);

			//添加到用户养殖场信息
			FarmersFarmEntryInfo entryInfo=new FarmersFarmEntryInfo();
			entryInfo.setFarm(faInfo);
			farmerInfo.getFarmEntry().add(entryInfo);
		}

		try {
			//保存养殖场
			FarmFactory.getLocalInstance(ctx).save(farmCollection);
			//保存养殖户信息
			FarmersFactory.getLocalInstance(ctx).save(farmerInfo);

			info.setFarmer(farmerInfo);

			info.setBillStatus(BillBaseStatusEnum.AUDITED);
			info.setAuditTime(new java.util.Date());
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception ex) {
			throw new BOSException(ex);
		}
	}
	/**
	 * 创建组织
	 * 
	 * @param ctx
	 */
	private void createOrgInfo(Context ctx) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document document = builder.newDocument();
		// 创建属性名、赋值
		Element root = document.createElement("DataInfo");
		document.appendChild(root);

		// 创建第一个根节点、赋值
		Element head = document.createElement("DataHead");

		root.appendChild(head);

		Element number = document.createElement("number");
		number.setTextContent("test");
		head.appendChild(number);

		Element name = document.createElement("name");
		name.setTextContent("测试组织");
		head.appendChild(name);

		Element cu = document.createElement("CU");
		cu.setTextContent("00000000-0000-0000-0000-000000000000CCE7AED4");
		head.appendChild(cu);

		Element op = document.createElement("op");
		op.setTextContent("0");
		root.appendChild(op);

		Element bostype = document.createElement("bostype");
		bostype.setTextContent("7FAFDF41");
		root.appendChild(bostype);

		//定义了用于处理转换指令，以及执行从源到结果的转换的  
		TransformerFactory transformerFactory = TransformerFactory.newInstance();  
		Transformer transformer = transformerFactory.newTransformer();  
		transformer.setOutputProperty("encoding", "UTF-8"); 
		StringWriter writer = new StringWriter();  
		transformer.transform(new DOMSource(document), new StreamResult(writer));  
		System.out.println(writer.toString());  

		//        EntityObjectInfo eo = WsCommonUtil.getEntityObjectInfo(ctx, "7FAFDF41");
		// 使xml文件 缩进效果  

		this._importFullOrgData(ctx,writer.toString());

	}
	private String billNumber;
	private String retstatus;
	private String errorMessage;
	protected String _importFullOrgData(Context ctx, String xmlData) throws BOSException, EASBizException {
		/*    */     try {
			/* 35 */       Document doc = WsCommonXMLUtil.builderDocument(xmlData);
			/* 36 */       if (null != doc)
				/*    */
			/*    */       {
				/* 39 */         WsCommonXMLUtil.validateRootElement(doc, "DataInfo");
				/*    */
				/*    */ 
				/* 42 */         HashMap headPro = WsCommonXMLUtil.getBillHead(doc, "DataHead");
				/*    */ 
				/* 44 */         this.billNumber = ((String)headPro.get("number"));
				//		  /* 45 */         CtrlUnitInfo cuInfo = WsCommonUtil.getCuInfo(ctx, (String)headPro.get("CU"));
				//		  /* 46 */         if (cuInfo == null) {
				//		  /* 47 */           throw new Exception(DataImportUtils.getResource("com.kingdee.eas.basedata.ws.common.WebSericeResource", "CUNOTFOUND", ctx));
				//		  /*    */         }
				//		  /* 49 */         ContextUtil.setCurrentCtrlUnit(ctx, cuInfo);

				ContextUtil.setCurrentCtrlUnit(ctx, CtrlUnitFactory.getLocalInstance(ctx).getCtrlUnitInfo(new ObjectUuidPK("00000000-0000-0000-0000-000000000000CCE7AED4")));
				/*    */
				/*    */ 
				/* 52 */         String attributeName = "0";//WsCommonXMLUtil.getAttributeValue(doc, "op");
				/*    */ 
				/* 54 */         String bostype = "7FAFDF41";//WsCommonXMLUtil.getAttributeValue(doc, "bostype");
				/*    */ 
				/* 56 */         FullOrgUnitInfo fullOrgUnitInfo = new FullOrgUnitInfo();
				/*    */ 
				/* 58 */         EntityObjectInfo eo = WsCommonUtil.getEntityObjectInfo(ctx, bostype);
				/*    */
				/*    */ 
				/* 61 */         Map map = WsCommonImportUtil.getBillHeadProperties(eo);
				/*    */ 
				//		  /* 63 */         fullOrgUnitInfo = (FullOrgUnitInfo)WsCommonUtil.validateBills(ctx, eo, attributeName, this.billNumber, "", fullOrgUnitInfo);
				/*    */ 
				/* 65 */         if (("0".equals(attributeName)) || ("3".equals(attributeName)) || ("4".equals(attributeName))) {
					/* 66 */           String[] mustValidateHead = WsCommonTag.getMustValidateProsByFullOrgHead();
					/* 67 */           if (!("0".equals(attributeName)))
					/*    */           {
						/* 69 */             WsCommonUtil.validateHeadProperty(mustValidateHead, headPro);
						/*    */
					/*    */           }
					/*    */           else mustValidateHead = null;
					/*    */ 
					/* 74 */           WsCommonImportUtil.buildBillHead(ctx, fullOrgUnitInfo, map, mustValidateHead, null, headPro, "");
				/*    */         }
				/*    */ 
				/* 77 */         ctx.put("disablePermissionForKScript", Boolean.TRUE);
				/*    */ 
				/* 79 */         WsCommonUtil.operationBills(ctx, eo, fullOrgUnitInfo, attributeName, headPro, map);
			/*    */       }
		/*    */     } catch (Exception e) {
			/* 82 */       this.retstatus = "1";
			/* 83 */       this.errorMessage = e.getMessage();
		/*    */     }
		/* 85 */     return WsCommonXMLUtil.buildResultXml(this.retstatus, this.billNumber, this.errorMessage);
	/*    */   }

	/**
	 * 得到属于父节点下的最大成本中心编码
	 * @param ctx
	 * @param parentOrg
	 * @return
	 */
	private String getCostCenterNum(Context ctx,FullOrgUnitInfo parentOrg) {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select max(Fnumber) Fnumber ")
			.append(" from t_org_baseUnit ")
			.append(" where FParentID='").append(parentOrg.getId()).append("'")
			.append(" ");
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			String number;
			String newValue="";
			int acValue;
			if(rs.next()) {
				number=rs.getString("fnumber");
				for(int index=(number.length()-1);index>=0;index--) {
					acValue=Integer.valueOf(number.substring(index, index+1));
					if(index==0){
						number="";
					}
					if(acValue>=0&&acValue<=9) {
						newValue=String.valueOf(acValue)+newValue;
					}else{
						number=number.substring(0, index);
						break;
					}
				}
				newValue=number+(Integer.valueOf(newValue)+1);
				return newValue;
			}else{
				return parentOrg.getNumber()+"1";
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}

	protected void _unAudit(Context ctx, IObjectValue model)throws BOSException
	{
		FarmerApplyBillInfo info = (FarmerApplyBillInfo) model;
		try {
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
			info.setAuditTime(null);
			info.setAuditor(null);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception ex) {
			throw new BOSException(ex);
		}
	}
	protected void _isTemplate(Context ctx, IObjectValue model)throws BOSException
	{

	}
	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FarmerApplyBillInfo info = (FarmerApplyBillInfo) model;
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		}
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		FarmerApplyBillInfo info = (FarmerApplyBillInfo) model;
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
			info.setBillStatus(BillBaseStatusEnum.SUBMITED);
		}
		try {
			//			createOrgInfo(ctx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super._submit(ctx, info);
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FarmerApplyBillInfo info = FarmerApplyBillFactory.getLocalInstance(ctx).getFarmerApplyBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核，禁止删除！"));
		}
		super._delete(ctx, pk);
	}
	@Override
	protected void _isCheckItemEntry(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub

	}


}