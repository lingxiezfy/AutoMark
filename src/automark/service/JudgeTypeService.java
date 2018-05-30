package automark.service;

import java.util.List;

import automark.model.JudgeType;

public interface JudgeTypeService {
	/**
	 * 获取所有的批阅方式列表
	 * @return
	 */
	public List<JudgeType> findAlljudgeTypes(); 
}
