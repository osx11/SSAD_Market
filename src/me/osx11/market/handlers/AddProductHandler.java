package me.osx11.market.handlers;

import me.osx11.market.BaseHandler;
import me.osx11.market.IMarket;
import me.osx11.market.Market;
import me.osx11.market.Product;
import me.osx11.market.exceptions.CommandHandleException;
import me.osx11.market.requests.AddProductRequest;

public class AddProductHandler extends BaseHandler {
    private final AddProductRequest request;

    public AddProductHandler(AddProductRequest request) {
        super();
        this.request = request;
    }

    @Override
    public void proceed() throws CommandHandleException {
        IMarket market = Market.getInstance();

        if (market.getCurrentUser() == null) {
            throw new CommandHandleException("You must login or register first. Use LOGIN or REGISTER command");
        }

        if (!market.getCurrentUser().isStaff()) {
            throw new CommandHandleException("Only authorized personnel can create products.");
        }

        Product product = new Product(request.getProductName());
        market.addProduct(product);

        System.out.println("Product '" + request.getProductName() + "' has been added successfully!");
        System.out.println();

        request.markHandled();
    }
}
