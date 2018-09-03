package cn.taotao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.taotao.mapper.TbItemMapper;
import cn.taotao.pojo.TbItem;
import cn.taotao.pojo.TbItemExample;
import cn.taotao.pojo.TbItemExample.Criteria;

public class ItemServiceImpl implements ItemService{
    //注入接口的代理对象
	@Autowired
	private TbItemMapper itemMapper;
	@Override
	public TbItem geTbItem(long itemId) {
		//使用itemMapper的方法--根据id查询
//		TbItem item=itemMapper.selectByPrimaryKey(itemId);
		//根据查询条件查询
		TbItemExample example=new TbItemExample();
		//添加查询条件，没添加就是默认的查询所有
		Criteria criteria=example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list=itemMapper.selectByExample(example);
		if(list!=null &&list.size()>0){
			TbItem item=list.get(0);
			return item;
		}
		return null;
	}
	

}
