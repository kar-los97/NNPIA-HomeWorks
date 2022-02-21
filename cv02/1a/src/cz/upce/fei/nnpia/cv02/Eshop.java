package cz.upce.fei.nnpia.cv02;

public class Eshop implements IEshop {
    UserService userService;
    ShoppingCartService shoppingCartService;

    public Eshop(UserService userService, ShoppingCartService shoppingCartService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public void process(){
        userService.createUser();
        shoppingCartService.getSumOfShoppingCart();
        shoppingCartService.addAmountToShoppingCart(50);
    }

    public static void main(String[] args) {
        IEshop eshop = DependencyInjector.getEshop();
        eshop.process();

    }
}
