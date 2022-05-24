package com.my.test.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.my.test.vo.Doc;

public class DocDao extends SqlSessionDaoSupport{
	
	public int insertDoc(Doc doc) {
		return this.getSqlSession().insert("ns_doc.insertDoc", doc);
	}
	
	public Doc getOneDoc(int doc_idx) {
		return this.getSqlSession().selectOne("ns_doc.getOneDoc", doc_idx);
	}
	
	public List<Doc> getAllDoc() {
		return this.getSqlSession().selectList("ns_doc.getAllDoc");
	}
	
	public int updateDoc(Doc doc) {
		return this.getSqlSession().update("ns_doc.updateDoc", doc);
	}
	
	public int deleteDoc(int doc_idx) {
		return this.getSqlSession().delete("ns_doc.deleteDoc",doc_idx);
	}
	
}