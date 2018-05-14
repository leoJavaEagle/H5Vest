package com.neo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neo.entity.TProduct;

public interface IndexMapper {

	List<TProduct> showIndex();
	
	List<TProduct> showProduct();
	
	TProduct findProductById(@Param("id") String productId);
	
	Integer updateProduct(TProduct product);
	
	Integer insertProduct(TProduct product);

	List<TProduct> findProductByTitleOrStatus(@Param("productName")String productName, @Param("status")String status);
	
}
