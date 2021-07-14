package com.ict.service;

import java.util.List;

import com.ict.vo.VO;

// 서비스는 DAO + 가공처리, 트랜젝션 처리
// 가공하기위해 DAO처럼 되어있음
public interface MyService {
	// 리스트
	List<VO> getList() throws Exception;
	
	// 삽입
	int getInsert(VO vo) throws Exception;
	
	// 상세보기
	VO getOneList(String idx) throws Exception;
	
	// 수정
	int getUpdate(VO vo) throws Exception;
	
	// 삭제
	int getDelete(String idx) throws Exception;
}
