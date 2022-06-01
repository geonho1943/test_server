package com.my.test.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.my.test.vo.Comm;


public class CommDao extends SqlSessionDaoSupport {
	
	public List<Comm> getThisComm() {
		return this.getSqlSession().selectList("ns_comm.getThisComm");
	}
	
	public int insertComm(Comm comm) {
		return this.getSqlSession().insert("ns_comm.insertUser", comm);
	}
	
	public int updateComm(Comm comm) {
		return this.getSqlSession().update("ns_comm.updateComm", comm);
	}
	
	public int deleteComm(int doc_com_idx) {
		return this.getSqlSession().delete("ns_comm.deleteComm",doc_com_idx);
	}
}
