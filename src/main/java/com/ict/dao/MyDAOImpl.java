package com.ict.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.vo.VO;

//여기는 무조건 DB 갔다가 오는 곳
@Repository("myDAOImpl")
public class MyDAOImpl implements MyDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<VO> getList() throws Exception {
		return sqlSessionTemplate.selectList("gestbook.list"); // mapper.xml로 가게 됨
	}
	
	@Override
	public int getInsert(VO vo) throws Exception {
		return sqlSessionTemplate.insert("gestbook.insert", vo); // mapper.~ 로 여러 db접속을 구별
	}
	
	@Override
	public VO getOneList(String idx) throws Exception {
		return sqlSessionTemplate.selectOne("gestbook.onelist", idx);
	}
	
	@Override
	public int getDelete(String idx) throws Exception {
		return sqlSessionTemplate.delete("gestbook.delete", idx);
	}
	
	@Override
	public int getUpdate(VO vo) throws Exception {
		return sqlSessionTemplate.update("gestbook.update", vo);
	}
}
