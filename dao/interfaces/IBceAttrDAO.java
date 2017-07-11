package huangwf5.dao.interfaces;

import com.asiainfo.crm.so.order.dsmp.pcestudio.bo.BOUpItemRelatBean;
import com.asiainfo.crm.so.order.dsmp.pcestudio.bo.BOUpPlanProdRelBean;
import com.asiainfo.crm.so.order.dsmp.pcestudio.bo.BOUpProductItemBean;

public interface IBceAttrDAO {
 
	 public BOUpProductItemBean[] getProductItemByCreaterAndItemType(String creater,String itemType) throws Exception ;
     
	 public BOUpItemRelatBean[] getUpItemRelatByKindAndRelatProductItemIdAndDelFlag(String prodItemRelatKindId,String relatProductItemId,String delFlag) throws Exception;
	 
	 //根据类型，产品单元id，del_flag查询相应产品单元
	 public BOUpItemRelatBean[] getUpItemRelatByKind$ProductItemId$DelFlag(String prodItemRelatKindId,String productItemId,String delFlag) throws Exception;
	 
	 public BOUpPlanProdRelBean[] getUpPlanProdBeanByProductItemId$attrF$delFlag(String productItemId,String extendAttrF,String delFlag) throws Exception;
	 
	 public BOUpProductItemBean[]  getProductItemByProductItemId(String productItemId) throws Exception;
}
