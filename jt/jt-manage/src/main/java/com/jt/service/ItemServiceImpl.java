package com.jt.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jt.mapper.ItemDescMapper;
import com.jt.mapper.ItemMapper;
import com.jt.pojo.Item;
import com.jt.pojo.ItemDesc;
import com.jt.vo.EasyUITable;
import com.jt.vo.SysResult;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private ItemDescMapper itemDescMapper;

	@Override
	public EasyUITable findItemByPage(int page, int rows) {
		// TODO Auto-generated method stub
		//使用mybatisPlus分页插件
		IPage<Item> iPage=new Page<>(page,rows);
		/**
		 * QueryWrapper(LambdaQueryWrapper) 和 UpdateWrapper(LambdaUpdateWrapper) 的父类
		 * 用于生成 sql 的 where 条件, entity 属性也用于生成 sql 的 where 条件
		 */
		QueryWrapper<Item> queryWrapper = new QueryWrapper<>();
		//降序排列
		queryWrapper.orderByDesc("updated");
		iPage=itemMapper.selectPage(iPage, queryWrapper);//利用mybasticPlus的BaseMapper的selectPage方法
		
		int total=(int) iPage.getTotal();
		List<Item> itemList=iPage.getRecords();
		
		return new EasyUITable(total,itemList);
	}
	
    //入库操作
	@Override
	@Transactional//事务控制
	public void saveItem(Item item,ItemDesc itemDesc) {
		//实现tb_item入库
		item.setStatus(1).setCreated(new Date()).setUpdated(item.getCreated());
		itemMapper.insert(item);
		//实现tb_item_desc入库
		itemDesc.setItemId(item.getId()).setCreated(item.getCreated()).setUpdated(item.getUpdated());
		itemDescMapper.insert(itemDesc);
	}

	@Override
	public void updateItem(Item item,ItemDesc itemDesc) {
		//根据主键进行修改，并且设置更新时间
		item.setUpdated(new Date());
		itemMapper.updateById(item);
		//同时更新属性
		itemDesc.setItemId(item.getId()).setUpdated(item.getUpdated());
		itemDescMapper.updateById(itemDesc);
	}

	@Override
	public void deleteItem(long[] ids) {
		//mybatisPlus
		//List<Long[]> idList=Arrays.asList(ids);
		//itemMapper.deleteBatchIds(idList);	}
		
		//Mybatis手动的实现数据删除
		itemMapper.deleteItems(ids);
		itemDescMapper.deleteItemDescs(ids);
		//List<long[]> idList=Arrays.asList(ids);
		//itemDescMapper.deleteBatchIds(idList);	
	}

	@Override
	public void updateStatus(int status, Long[] ids) {
		//mybatisPlud
//		Item item = new Item();
//		item.setStatus(status).setUpdated(new Date());
//		UpdateWrapper<Item> updateWrapper=new UpdateWrapper<>();
//		updateWrapper.in("id",Arrays.asList(ids));
//		itemMapper.update(item, updateWrapper);
		//2、使用sql方式实现业务
		itemMapper.updateStatus(status,new Date(),ids);
	}

	@Override
	public ItemDesc findItemDescById(Long itemId) {
		return itemDescMapper.selectById(itemId);
	}
		
	
	
	
	
	
	
	
}
