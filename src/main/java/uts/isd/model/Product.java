package uts.isd.model;
import java.io.Serializable;

public class Product implements Serializable{
    
    private int productId;
    private String productName;
    private String productBrand;
    private String productDescription;
    private String productImg;
    private double productPrice;
    private double productSpecialPrice;
    private boolean productOnSpecial;
    private int productStock;
    private int productOrderQty;
    
    public Product(int productId, String productName, String productBrand, String productDescription, String productImg,
            double productPrice, double productSpecialPrice, boolean productOnSpecial, int productStock,
            int productOrderQty) {
        this.productId = productId;
        this.productName = productName;
        this.productBrand = productBrand;
        this.productDescription = productDescription;
        this.productImg = productImg;
        this.productPrice = productPrice;
        this.productSpecialPrice = productSpecialPrice;
        this.productOnSpecial = productOnSpecial;
        this.productStock = productStock;
        this.productOrderQty = productOrderQty;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getProductSpecialPrice() {
        return productSpecialPrice;
    }

    public void setProductSpecialPrice(double productSpecialPrice) {
        this.productSpecialPrice = productSpecialPrice;
    }

    public boolean isProductOnSpecial() {
        return productOnSpecial;
    }

    public void setProductOnSpecial(boolean productOnSpecial) {
        this.productOnSpecial = productOnSpecial;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public int getProductOrderQty() {
        return productOrderQty;
    }

    public void setProductOrderQty(int productOrderQty) {
        this.productOrderQty = productOrderQty;
    }
}
