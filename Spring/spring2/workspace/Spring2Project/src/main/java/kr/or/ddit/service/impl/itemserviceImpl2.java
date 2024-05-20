package kr.or.ddit.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.mapper.IItemMapper2;
import kr.or.ddit.vo.Item2;
import kr.or.ddit.service.IItemservice2;

@Service
public class itemserviceImpl2 implements IItemservice2 {

	@Inject
	private IItemMapper2 mapper;
	
	
	@Override
	public void register(Item2 item) {
		mapper.register(item);
	}


	@Override
	public List<Item2> list() {
		return mapper.list();
	}


	@Override
	public Item2 read(int itemId) {
		// TODO Auto-generated method stub
		return mapper.read(itemId);
	}


	@Override
	public String getPicture(int itemId) {
		// TODO Auto-generated method stub
		return mapper.getPicture(itemId);
	}


	@Override
	public String getPicture2(int itemId) {
		// TODO Auto-generated method stub
		return mapper.getPicture2(itemId);
	}


	@Override
	public void modify(Item2 item) {
		mapper.modify(item);
	}


	@Override
	public void remove(int itemId) {
		mapper.remove(itemId);
	}

	
}
