package huangwf5.dao.impl;

import huangwf5.dao.interfaces.IBceAttrDAO;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.asiainfo.crm.so.order.dsmp.pcestudio.bo.BOUpItemRelatBean;
import com.asiainfo.crm.so.order.dsmp.pcestudio.bo.BOUpItemRelatEngine;
import com.asiainfo.crm.so.order.dsmp.pcestudio.bo.BOUpPlanProdRelBean;
import com.asiainfo.crm.so.order.dsmp.pcestudio.bo.BOUpPlanProdRelEngine;
import com.asiainfo.crm.so.order.dsmp.pcestudio.bo.BOUpProductItemBean;
import com.asiainfo.crm.so.order.dsmp.pcestudio.bo.BOUpProductItemEngine;

public class BceAttrDAOImpl implements IBceAttrDAO {

	@Override
	public BOUpProductItemBean[] getProductItemByCreaterAndItemType(String creater,String itemType) throws Exception {
		boolean flag=false;
		StringBuilder condition=new StringBuilder(" 1 = 1");
		Map param=new HashMap();
		if(null!=creater && !"".equals(creater)){
			condition.append(" and ").append(BOUpProductItemBean.S_Creater).append(" =:creater");
			param.put("creater",creater);
			flag=true;
			
		}
		if(null!=itemType && !"".equals(itemType)){
			condition.append(" and ").append(BOUpProductItemBean.S_ItemType).append(" =:itemType");
			param.put("itemType",itemType);
			flag=true;
		}
		if(!flag){
			System.out.println("查询产品单元表的时候，传入的参数creater和itemType都是空的");
		}
			
		 return BOUpProductItemEngine.getBeans(condition.toString(), param);

		
	}

	@Override
	public BOUpItemRelatBean[] getUpItemRelatByKindAndRelatProductItemIdAndDelFlag(
			String prodItemRelatKindId, String relatProductItemId, String delFlag) throws Exception {
		StringBuffer sb=new StringBuffer();
		HashMap param = new HashMap();
		sb.append(" 1=1 ");
		boolean kindFlag=false;
		boolean productItemIdFlag=false;
		boolean delFlagTip=false;
		
		if(null!=prodItemRelatKindId&&!"".equals(prodItemRelatKindId)){
			sb.append(" and ").append(BOUpItemRelatBean.S_ProdItemRelatKindId).append("=:prodItemRelatKindId");
			param.put("prodItemRelatKindId", prodItemRelatKindId);
			kindFlag=true;
		}
		if(null!=relatProductItemId && !"".equals(relatProductItemId)){
			sb.append(" and ").append(BOUpItemRelatBean.S_RelatProductItemId).append("=:relatProductItemId");
			param.put("relatProductItemId", relatProductItemId);
			productItemIdFlag=true;

		}
		if(null!=delFlag && !"".equals(delFlag)){
			sb.append(" and ").append(BOUpItemRelatBean.S_DelFlag).append("=:delFlag");
			param.put("delFlag", delFlag);
			delFlagTip=true;

		}
		
		if(!kindFlag&!productItemIdFlag&!delFlagTip){//没有传入任何查询条件，返回空
			return null;
			
		}else{
				return BOUpItemRelatEngine.getBeans(sb.toString(), param);
			
		}
		
	}

	@Override
	public BOUpItemRelatBean[] getUpItemRelatByKind$ProductItemId$DelFlag(
			String prodItemRelatKindId, String productItemId, String delFlag) throws Exception {
		StringBuffer sb=new StringBuffer();
		HashMap parameter =new HashMap();
		boolean prodItemRelatKindIdFlag=true;
		boolean productItemIdFlag=true;
		boolean delFlagFlag=true;
		sb.append(" 1=1 ");
		if(StringUtils.isNotEmpty(prodItemRelatKindId)){
			sb.append(" and ").append(BOUpItemRelatBean.S_ProdItemRelatKindId).append("=:prodItemRelatKindId ");
			parameter.put("prodItemRelatKindId", prodItemRelatKindId);
			prodItemRelatKindIdFlag=false;
		}
		if(StringUtils.isNotEmpty(productItemId)){
			sb.append(" and ").append(BOUpItemRelatBean.S_ProductItemId).append("=:productItemId ");
			parameter.put("productItemId", productItemId);
			productItemIdFlag=false;
		}
		if(StringUtils.isNotEmpty(delFlag)){
			sb.append(" and ").append(BOUpItemRelatBean.S_DelFlag).append("=:delFlag ");
			parameter.put("delFlag",delFlag);
			delFlagFlag=false;
		}
		if(prodItemRelatKindIdFlag&&productItemIdFlag&&delFlagFlag){
			return null;
		}
		return BOUpItemRelatEngine.getBeans(sb.toString(), parameter);
	}

	@Override
	public BOUpPlanProdRelBean[] getUpPlanProdBeanByProductItemId$attrF$delFlag(
			String productItemId, String extendAttrF, String delFlag) throws Exception {
		StringBuffer sb=new StringBuffer();
		HashMap param=new HashMap();
		boolean itemFlag=true;
		boolean attrFFlag=true;
		boolean delFlagFlag=true;
		sb.append(" 1=1 ");
		if(StringUtils.isNotEmpty(productItemId)){
			sb.append(" and ").append(BOUpPlanProdRelBean.S_ProductItemId).append("=:productItemId");
			param.put("productItemId", productItemId);
			itemFlag=false;
		}
		if(StringUtils.isNotEmpty(extendAttrF)){
			sb.append(" and ").append(BOUpPlanProdRelBean.S_ExtendAttrF).append("=:extendAttrF");
			param.put("extendAttrF", extendAttrF);
			attrFFlag=false;
		}
		if(StringUtils.isNotEmpty(delFlag)){
			sb.append(" and ").append(BOUpPlanProdRelBean.S_DelFlag).append("=:delFlag");
			param.put("delFlag",delFlag);
			delFlagFlag=false;
		}
		if(delFlagFlag&&attrFFlag&&delFlagFlag){//没有传入查询条件的时候，返回null，不查询数据
			return null;
		}
		return BOUpPlanProdRelEngine.getBeans(sb.toString(), param);
	}

	@Override
	public BOUpProductItemBean[] getProductItemByProductItemId(
			String productItemId) throws Exception {
		StringBuffer sb=new StringBuffer();
		HashMap param=new HashMap();
		boolean itemFlag=true;
		sb.append(" 1=1 ");
		if(StringUtils.isNotEmpty(productItemId)){
			sb.append(" and ").append(BOUpProductItemBean.S_ProductItemId).append("=:productItemId");
			param.put("productItemId", productItemId);
			itemFlag=false;
		}
		if(itemFlag){//如果没有传入查询条件，则返回空
			
			return null;
		}
		 return BOUpProductItemEngine.getBeans(sb.toString(),param);
	}

}
