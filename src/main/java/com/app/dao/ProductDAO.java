package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;

import com.app.myBatis.config.MyBatisConfig;
import com.app.vo.ProductVO;

public class ProductDAO {
	public SqlSession sqlSession;
	
	public ProductDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);					// DAO가 메모리에 할당될 때 생성자는 자동실행 되기 때문에, 생성자에 작성함.
	}																							// 즉 sql세션객체는 dao할당될 때 생성됨. 
	
	// 상품추가
	public void insert(ProductVO productVO) {
//		SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
		sqlSession.insert("product.insert", productVO);		// mapper의 뭐를 실행시키기 위해? ★★★namespace.id★★★를 적고, 두번째 매개변수 productVO 
	}
	
	// 상품 전체 조회(목록)
	public List<ProductVO> selectAll() {
//		SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);			// 중복되기 때문에 생성자에 담는다.
		List<ProductVO> products = sqlSession.selectList("product.selectAll");		// mapper의 뭐를 실행시키기 위해? ★★★namespace.id★★★ Product.selectAll를 적는다.
		return products;
	}
	
	// 상품 조회(상세 조회)
	public Optional<ProductVO> select(Long id) {
		return Optional.ofNullable(sqlSession.selectOne("product.select", id));
	}
	
	// 상품 수정
	public void update(ProductVO productVO) {
		sqlSession.update("product.update", productVO);
	}
	
	// 상품 삭제
	public void delete(Long id) {
		sqlSession.delete("product.delete", id);
	}
}
