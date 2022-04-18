package me.osx11.market.handlers;

import me.osx11.market.BaseHandler;
import me.osx11.market.IMarket;
import me.osx11.market.Market;
import me.osx11.market.requests.ListProductsRequest;

public class ListProductsHandler extends BaseHandler {
    private final ListProductsRequest request;

    public ListProductsHandler(ListProductsRequest request) {
        super();
        this.request = request;
    }

    @Override
    public void proceed() {
        IMarket market = Market.getInstance();

        market.printProducts();
        System.out.println();

        request.markHandled();
    }
}
