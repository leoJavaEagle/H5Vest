package com.neo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neo.entity.TProblem;

public interface ProblemMapper {

	List<TProblem> showProblem();

	List<TProblem> showAllProblem();
	
	TProblem showProblemDetails(@Param("problemId")String id);

	List<TProblem> findProblemByTitleOrStatus(@Param("title")String title, @Param("status")String status);

	Integer updateProblem(TProblem problem);

	Integer insertProblem(TProblem problem);

}
