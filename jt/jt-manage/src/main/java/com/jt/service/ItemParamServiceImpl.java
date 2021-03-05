package com.jt.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.mapper.ItemParamMapper;
import com.jt.pojo.ItemParam;
import com.jt.vo.EasyUITable;

@Service
public class ItemParamServiceImpl implements ItemParamService{
	@Autowired
	private ItemParamMapper itemParamMapper;
	@Override
	public EasyUITable findItemParamByPage(int page, int rows) {
		//1、总记录数
		Integer total=itemParamMapper.selectCount(null);
		//2、list分页之后的结果
		int start=(page-1)*rows;
		List<ItemParam> itemParamList=itemParamMapper.findItemParamByPage(start,rows);
		List<ItemParam> itemParamList1 = new ArrayList<ItemParam>(); 
		//System.out.println(itemParamList);
		
		//List<ItemParam> itemParamList1 = itemParamList;
		for(ItemParam list:itemParamList) {
			Long   id = list.getId();				//商品id
			Long   itemCatId = list.getItemCatId();
			String paramData = list.getParamData();
			Date created = list.getCreated();
			Date updated = list.getUpdated();
			//System.out.println(list.getItemCatId());
			String itemCatName = itemParamMapper.findName(list.getItemCatId());
			ItemParam T = new ItemParam(id,itemCatId,paramData,itemCatName,created,updated);
			itemParamList1.add(T); 
		}
		System.out.println(itemParamList1);
		return new EasyUITable(total,itemParamList1);
	}

	@Override
	public void saveItemParam(ItemParam itemParam,Long itemCatId) {
		itemParam
		.setItemCatId(itemCatId)
		.setCreated(new Date())
		.setUpdated(itemParam.getCreated());
		System.out.println(itemParam.getItemCatId());
		itemParamMapper.insert(itemParam);
	}

	@Override
	public void deleteItemParams(Long[] ids) {
		List<Long> idList=Arrays.asList(ids);
		itemParamMapper.deleteBatchIds(idList);
	}

	@Override
	public void updateItemParam(ItemParam itemParam) {
		itemParam.setUpdated(new Date());
        itemParamMapper.updateById(itemParam);
 
	}
}
