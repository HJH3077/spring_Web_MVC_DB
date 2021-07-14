package com.ict.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.dao.MyDAO;
import com.ict.vo.VO;

// 가공하기위해 DAO처럼 되어있음
@Service("myServiceImpl")
public class MyServiceImpl implements MyService{
	@Autowired
	private MyDAO myDAO;
	
	@Override
	public List<VO> getList() throws Exception {
		// 갔다오고 그 리스트를 그대로 출력해야 하므로 그냥 받은 리스트를 바로 리턴해줌
		return myDAO.getList();
	}
	
	@Override
	public int getInsert(VO vo) throws Exception {
		return myDAO.getInsert(vo);
	}
	
	@Override
	public VO getOneList(String idx) throws Exception {
		return myDAO.getOneList(idx);
	}
	
	@Override
	public int getDelete(String idx) throws Exception {
		return myDAO.getDelete(idx);
	}
	
	@Override
	public int getUpdate(VO vo) throws Exception {
		return myDAO.getUpdate(vo);
	}
}
