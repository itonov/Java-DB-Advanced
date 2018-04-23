package bookshop_system.dto;

import java.math.BigDecimal;

public class ReducedBook {
    private String title;
    private String editionType;
    private String ageRestriction;
    private BigDecimal price;

    public ReducedBook() {
    }

    public ReducedBook(String title, String editionType, String ageRestriction, BigDecimal price) {
        this.title = title;
        this.editionType = editionType;
        this.ageRestriction = ageRestriction;
        this.price = price;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEditionType() {
        return this.editionType;
    }

    public void setEditionType(String editionType) {
        this.editionType = editionType;
    }

    public String getAgeRestriction() {
        return this.ageRestriction;
    }

    public void setAgeRestriction(String ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
