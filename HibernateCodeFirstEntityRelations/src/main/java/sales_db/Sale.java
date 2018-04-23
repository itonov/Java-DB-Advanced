package sales_db;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sale")
public class Sale {
    private Integer id;

    private Product product;

    private Customer customer;

    private StoreLocation location;

    private Date date;

    public Sale() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne
    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    public StoreLocation getLocation() {
        return this.location;
    }

    public void setLocation(StoreLocation storeLocation) {
        this.location = storeLocation;
    }

    @Column(name = "date")
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
