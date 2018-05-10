package com.neo.mapper;

import java.util.List;

import com.neo.entity.TProblem;

public interface ProblemMapper {

	List<TProblem> showProblem();
	
	List<TProblem> showProblemDetails(String problemId);
}
