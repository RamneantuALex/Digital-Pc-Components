package entity.sisteme.electronice;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "ElectronicSystem")
public class SistemeElectronice {

    enum system_type{ DESKTOP_PC, LAPTOP_PC, PRINTER, PERIPHERAL, COMPONENT}
    @Id
    private int price;
    private String description;
    private boolean promotion;
    private int stock;
    private String review;

   public SistemeElectronice(){}

    public SistemeElectronice(int price, String description, boolean promotion, int stock, String review) {
        this.price = price;
        this.description = description;
        this.promotion = promotion;
        this.stock = stock;
        this.review = review;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPromotion() {
        return promotion;
    }

    public void setPromotion(boolean promotion) {
        this.promotion = promotion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SistemeElectronice{");
        sb.append("price=").append(price);
        sb.append(", description='").append(description).append('\'');
        sb.append(", promotion=").append(promotion);
        sb.append(", stock=").append(stock);
        sb.append(", review='").append(review).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
