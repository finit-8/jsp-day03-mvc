package com.app.vo;

import java.util.Objects;

// 1. 필드 구성 
// 2. private 붙이기
// 3. 기본생성자, 초기화 생성자
// 4. getter, setter
// 5. toString 재정의
// 6. Hash, Equals 재정의
public class ProductVO {
   private Long id;
   private String productName;
   private int productPrice;
   private int productStock;
   
   public ProductVO() {;}

   public ProductVO(Long id, String productName, int productPrice, int productStock) {
      this.id = id;
      this.productName = productName;
      this.productPrice = productPrice;
      this.productStock = productStock;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getProductName() {
      return productName;
   }

   public void setProductName(String productName) {
      this.productName = productName;
   }

   public int getProductPrice() {
      return productPrice;
   }

   public void setProductPrice(int productPrice) {
      this.productPrice = productPrice;
   }

   public int getProductStock() {
      return productStock;
   }

   public void setProductStock(int productStock) {
      this.productStock = productStock;
   }

   @Override
   public String toString() {
      return "ProductVO [id=" + id + ", productName=" + productName + ", productPrice=" + productPrice
            + ", productStock=" + productStock + "]";
   }

   @Override
   public int hashCode() {
      return Objects.hash(id);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      ProductVO other = (ProductVO) obj;
      return Objects.equals(id, other.id);
   }
   
}













