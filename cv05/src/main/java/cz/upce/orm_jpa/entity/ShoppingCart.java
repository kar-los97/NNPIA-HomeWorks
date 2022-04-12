package cz.upce.orm_jpa.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;

    public Set<ShoppingCartProduct> getProductsInShoppingCart() {
        return productsInShoppingCart;
    }

    public void setProductsInShoppingCart(Set<ShoppingCartProduct> productsInShoppingCart) {
        this.productsInShoppingCart = productsInShoppingCart;
    }

    @OneToMany(mappedBy = "id")
    private Set<ShoppingCartProduct> productsInShoppingCart;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", user=" + user +
                ", productsInShoppingCart=" + productsInShoppingCart +
                '}';
    }
}
