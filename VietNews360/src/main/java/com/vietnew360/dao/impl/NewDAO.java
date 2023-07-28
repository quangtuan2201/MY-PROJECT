package com.vietnew360.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vietnew360.dao.INewDAO;
import com.vietnew360.mapper.NewMapper;
import com.vietnew360.model.NewModel;
@Repository
public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {
	/*
	 * @Override public List<NewModel> findByCategoryId(Long categoryId) { String
	 * sql = "SELECT * FROM news WHERE categoryid = ?"; return query(sql, new
	 * NewMapper(), categoryId); }
	 * 
	 * @Override public Long save(NewModel newModel) { StringBuilder sql = new
	 * StringBuilder("INSERT INTO news (title, content,"); sql.
	 * append(" thumbnail, shortdescription, categoryid, createddate, createdby)");
	 * sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?)"); return insert(sql.toString(),
	 * newModel.getTitle(), newModel.getContent(), newModel.getThumbnail(),
	 * newModel.getShortDescription(), newModel.getCategoryId(),
	 * newModel.getCreatedDate(), newModel.getCreatedBy()); }
	 * 
	 * @Override public NewModel findOne(Long id) { String sql =
	 * "SELECT * FROM news WHERE id = ?"; List<NewModel> news = query(sql, new
	 * NewMapper(), id); return news.isEmpty() ? null : news.get(0); }
	 * 
	 * @Override public void update(NewModel updateNew) { StringBuilder sql = new
	 * StringBuilder("UPDATE news SET title = ?, thumbnail = ?,");
	 * sql.append(" shortdescription = ?, content = ?, categoryid = ?,"); sql.
	 * append(" createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?"
	 * ); update(sql.toString(), updateNew.getTitle(), updateNew.getThumbnail(),
	 * updateNew.getShortDescription(), updateNew.getContent(),
	 * updateNew.getCategoryId(), updateNew.getCreatedDate(),
	 * updateNew.getCreatedBy(), updateNew.getModifiedDate(),
	 * updateNew.getModifiedBy(), updateNew.getId()); }
	 * 
	 * @Override public void delete(long id) { String sql =
	 * "DELETE FROM news WHERE id = ?"; update(sql, id); }
	 */

	@Override
	public List<NewModel> findAll() {
		StringBuilder sql = new StringBuilder("SELECT * FROM news");
		return query(sql.toString(), new NewMapper());//
	}

}
