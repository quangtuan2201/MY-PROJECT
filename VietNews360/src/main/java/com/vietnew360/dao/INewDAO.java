package com.vietnew360.dao;

import java.util.List;

import com.vietnew360.model.NewModel;

public interface INewDAO extends GenericDAO<NewModel> {

	List<NewModel> findAll();

}
