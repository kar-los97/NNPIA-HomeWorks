package cz.upce.orm_jpa.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private BillState state;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "id")
    private Set<BillProduct> productsInBill;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BillState getState() {
        return state;
    }

    public void setState(BillState state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<BillProduct> getProductsInBill() {
        return productsInBill;
    }

    public void setProductsInBill(Set<BillProduct> productsInBill) {
        this.productsInBill = productsInBill;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", state=" + state +
                ", user=" + user +
                ", productsInBill=" + productsInBill +
                '}';
    }
}
