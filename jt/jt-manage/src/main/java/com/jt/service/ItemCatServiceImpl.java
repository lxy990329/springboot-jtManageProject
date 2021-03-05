package com.jt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.ItemCatMapper;
import com.jt.pojo.ItemCat;
import com.jt.vo.EasyUITree;

@Service
public class ItemCatServiceImpl implements ItemCatService{
    @Autowired
    ItemCatMapper itemCatMapper;
    
	@Override
	public ItemCat findItemCatNameById(Long itemCatId) {
		return itemCatMapper.selectById(itemCatId);
	}

	/**
	 * 数据转换
	 *   List<EasyUITree> vo对象 ，页面要求返回的戴护具结果
	 *   List<ItemCat>数据记录
	 *   ItemCat对象转换EasyUITree对象
	 */
	@Override
	public List<EasyUITree> findItemCatList(Long parentId) {
		//1、根据parentId查询数据库记录
		List<ItemCat> catList=findItemCatListByParentId(parentId);
		List<EasyUITree> treeList=new ArrayList<EasyUITree>();
		//2、利用循环的方法实现数据的遍历
		for(ItemCat itemCat:catList) {
			//目的是为了封装vo对象
			Long id=itemCat.getId();
			String text=itemCat.getName();
			String state=itemCat.getIsParent()?"closed":"open";
			EasyUITree tree =new EasyUITree(id,text,state);//将tree对象分装到list集合里面
			treeList.add(tree);
		}
		return treeList;
	}

	private List<ItemCat> findItemCatListByParentId(Long parentId) {
		QueryWrapper<ItemCat> queryWrapper = new QueryWrapper<ItemCat>();
		queryWrapper.eq("parent_id",parentId);
		return itemCatMapper.selectList(queryWrapper);
	}

}

