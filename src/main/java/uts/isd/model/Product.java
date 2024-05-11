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
    public Product(){};
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
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public String getProductImg() {
        return this.productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public double getProductPrice() {
        return this.productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getProductSpecialPrice() {
        return this.productSpecialPrice;
    }

    public void setProductSpecialPrice(double productSpecialPrice) {
        this.productSpecialPrice = productSpecialPrice;
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

    public int getProductStock() {
        return this.productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public int getProductOrderQty() {
        return this.productOrderQty;
    }

    public void setProductOrderQty(int productOrderQty) {
        this.productOrderQty = productOrderQty;
    }

    
}
