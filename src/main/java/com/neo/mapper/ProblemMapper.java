package com.neo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neo.entity.TProblem;

public interface ProblemMapper {

	List<TProblem> showProblem();
	
	List<TProblem> showAllProblem();

	List<TProblem> showProblems(@Param("pageCurrent") Integer pageCurrent, @Param("showAmount") Integer showAmount);
	
	TProblem showProblemDetails(@Param("problemId")String id); // JSON.stringify()

	List<TProblem> findProblemByTitleOrStatuAll(@Param("title")String title, @Param("status")String status);
	
	List<TProblem> findProblemByTitleOrStatus(@Param("title")String title, @Param("status")String status, 
			@Param("startIndex") Integer startIndex, @Param("showAmount") Integer showAmount);

	Integer updateProblem(TProblem problem);

	Integer insertProblem(TProblem problem);

}
