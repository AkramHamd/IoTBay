package uts.isd.model;
import java.io.Serializable;

public class Product implements Serializable {
    private String productName;
    private String productBrand;
    private String productDescription;
    private String productImage;
    private Integer productPrice;
    private Integer specialPrice;
    private boolean productOnSpecial;
    private Integer productStock;
    private Integer orderQty;

    public Product(
        String productName,
        String productBrand,
        String productDescription,
        String productImage,
        Integer productPrice,
        Integer specialPrice,
        Boolean productOnSpecial,
        Integer productStock,
        Integer orderQty) {
        this.productName = productName;
        this.productBrand = productBrand;
        this.productDescription = productDescription;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.specialPrice = specialPrice;
        this.productOnSpecial = productOnSpecial;
        this.productStock = productStock;
        }
        
    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBrand() {
        return this.productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductDescription() {
        return this.productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductImage() {
        return this.productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Integer getProductPrice() {
        return this.productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getSpecialPrice() {
        return this.specialPrice;
    }

    public void setSpecialPrice(Integer specialPrice) {
        this.specialPrice = specialPrice;
    }

    public boolean isProductOnSpecial() {
        return this.productOnSpecial;
    }

    public boolean getProductOnSpecial() {
        return this.productOnSpecial;
    }

    public void setProductOnSpecial(boolean productOnSpecial) {
        this.productOnSpecial = productOnSpecial;
    }

    public Integer getProductStock() {
        return this.productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public Integer getOrderQty() {
        return this.orderQty;
    }

    public void setOrderQty(Integer orderQty) {
        this.orderQty = orderQty;
    }
}
