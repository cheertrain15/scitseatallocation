package com.scitportalsystem.www.dao;


import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ConsultDAO {
	
	@Inject
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(ConsultDAO.class);
	
	}
