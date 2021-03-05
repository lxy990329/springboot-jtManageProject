package com.jt.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jt.mapper.ItemContentCategoryMapper;
import com.jt.mapper.ItemContentMapper;
import com.jt.pojo.ItemCat;
import com.jt.pojo.ItemContent;
import com.jt.pojo.ItemContentCategory;
import com.jt.vo.EasyUITable;
import com.jt.vo.EasyUITree;
import com.jt.vo.Result;
@Service
public class ItemContentServiceImpl implements ItemContentService{
	@Autowired
	private ItemContentMapper itemContentMapper;
	@Autowired
	private ItemContentCategoryMapper itemContentCategoryMapper;
	@Override
	public EasyUITable findItemByPage(Long categoryId,int page,int rows) {
		// TODO Auto-generated method stub
		//使用mybatisPlus分页插件
		IPage<ItemContent> iPage=new Page<>(page,rows);
		/**
		 * QueryWrapper(LambdaQueryWrapper) 和 UpdateWrapper(LambdaUpdateWrapper) 的父类
		 * 用于生成 sql 的 where 条件, entity 属性也用于生成 sql 的 where 条件
		 */
		QueryWrapper<ItemContent> queryWrapper = new QueryWrapper<>();
		//降序排列
		queryWrapper.eq("category_id",categoryId);
		queryWrapper.orderByDesc("updated");
		iPage=itemContentMapper.selectPage(iPage, queryWrapper);//利用mybasticPlus的BaseMapper的selectPage方法

		int total=(int) iPage.getTotal();
		List<ItemContent> itemList=iPage.getRecords();
		return new EasyUITable(total,itemList);


	}

	@Override
	public List<EasyUITree> findItemCatList(Long parentId) {
		//1、根据parentId查询数据库记录
		List<ItemContentCategory> catList=findItemCatListByParentId(parentId);
		List<EasyUITree> treeList=new ArrayList<EasyUITree>();
		//2、利用循环的方法实现数据的遍历
		for(ItemContentCategory itemContentCategory:catList) {
			//目的是为了封装vo对象
			Long id=itemContentCategory.getId();
			String text=itemContentCategory.getName();
			String state=itemContentCategory.getIsParent()?"closed":"open";
			EasyUITree tree =new EasyUITree(id,text,state);//将tree对象分装到list集合里面
			treeList.add(tree);
		}
		return treeList;
	}

	private List<ItemContentCategory> findItemCatListByParentId(Long parentId) {
		QueryWrapper<ItemContentCategory> queryWrapper = new QueryWrapper<ItemContentCategory>();
		queryWrapper.eq("parent_id",parentId);

		return itemContentCategoryMapper.selectList(queryWrapper);
	}

	@Override
	public Result saveItem(ItemContentCategory itemContentCategory) {
		// TODO Auto-generated method stub
		Result result = new Result();
		result.setSuccess(false);
		result.setDetail(null);
		try {
        	List<ItemContentCategory> catList=findItemCatListByParentId(itemContentCategory.getParentId());
            Boolean T = false;
            for(ItemContentCategory Content:catList) {
            	
    			if (itemContentCategory.getName().equals(Content.getName())) {
    				T = true;
    			}
    			
    		}
       	    System.out.println(T);
            if(T){
            	result.setMsg("名字已存在");
            }
            else if(itemContentCategory.getName().equals("")){
            	result.setMsg("名字不能为空");
            }
            else{
            	result.setMsg("添加成功");
            	itemContentCategory.setStatus(1).setIsParent(false).setCreated(new Date()).setUpdated(itemContentCategory.getCreated());
        		itemContentCategoryMapper.insert(itemContentCategory);
        		result.setDetail(itemContentCategory.getId());
            	result.setSuccess(true);

            }
        } catch (Exception e) {
        	result.setMsg(e.getMessage());
            e.printStackTrace();
        }
		return result;
		
	}

	@Override
	public Result updateItem(ItemContentCategory itemContentCategory) {
		// TODO Auto-generated method stub
		Result result = new Result();
		result.setSuccess(false);
		ItemContentCategory Category=itemContentCategoryMapper.SelectAll(itemContentCategory);
		Category.setName(itemContentCategory.getName()).setUpdated(new Date());
        try {
        	List<ItemContentCategory> catList=findItemCatListByParentId(Category.getParentId());
            Boolean T = false;
            for(ItemContentCategory Content:catList) {
            	
    			if (Category.getName().equals(Content.getName())) {
    				T = true;
    			}
    			
    		}
       	    System.out.println(T);
            if(T){
            	result.setMsg("名字已存在");
            }
            else if(itemContentCategory.getName().equals("")){
            	result.setMsg("名字不能为空");
            }
            else{
            	result.setMsg("修改成功");
        		result.setDetail(Category.getId());
        		itemContentCategoryMapper.updateById(Category);
            	result.setSuccess(true);

            }
        } catch (Exception e) {
        	result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
		
	}

	@Override
	public Result deleteItem(Long id) {
		// TODO Auto-generated method stub
		Result result = new Result();
		itemContentCategoryMapper.deleteById(id);
		result.setMsg("删除成功");
		result.setSuccess(true);
		return result;
	}

	@Override
	public void saveContent(ItemContent content) {
		// TODO Auto-generated method stub
		content.setCreated(new Date()).setUpdated(content.getCreated());
		itemContentMapper.insert(content);
	}

	@Override
	public void updateContent(ItemContent content) {
		// TODO Auto-generated method stub
		content.setUpdated(new Date());
		itemContentMapper.updateById(content);
	}

	@Override
	public void deleteContent(Long[] ids) {
		// TODO Auto-generated method stub
		List<Long> idList=Arrays.asList(ids);
		itemContentMapper.deleteBatchIds(idList);
	}

}
