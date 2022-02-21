package cz.upce.fei.nnpia.cv02;

public class DependencyInjector {
    //navrhový vzor singleton
    private static UserService userService;
    private static ShoppingCartService shoppingCartService;
    private static MailService mailService;

    private static MailService getMailService() {
        if (mailService == null) {
            mailService = new MailService();
        }
        return mailService;
    }

    private static UserService getUserService() {
        if (userService == null) {
            userService = new UserService(getShoppingCartService(),getMailService());
        }
        return userService;
    }

    private static ShoppingCartService getShoppingCartService(){
        if(shoppingCartService==null){
            shoppingCartService = new ShoppingCartService();
        }
        return shoppingCartService;
    }

    public static IEshop getEshop() {
        return new Eshop(getUserService(), getShoppingCartService());
    }
}
