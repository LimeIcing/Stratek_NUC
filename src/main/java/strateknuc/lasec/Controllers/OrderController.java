package strateknuc.lasec.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import strateknuc.lasec.Interfaces.OrderRepositoryInterface;
import strateknuc.lasec.Models.OrderModel;
import strateknuc.lasec.Models.ProductModel;
import strateknuc.lasec.Models.Repositories.OrderRepository;

@Controller
public class OrderController {

    //Author: SS, AP, LKB
    @Autowired
    private OrderRepositoryInterface repo = new OrderRepository();

    //Author: SS, AP, LKB
    private OrderModel shoppingCart = new OrderModel();

    //Author: SS, AP, LKB
    //------KØB USE CASE------
    //TODO: change url path to køb button's name
    //når man trykker på køb så bliver produktet tilføjet til kurven
    @RequestMapping(value = "/product/category", method = RequestMethod.POST)
    public String addToOrderModel(@ModelAttribute ProductModel productModel)
    {
        shoppingCart.addProduct(productModel);
        shoppingCart.setTotalPrice();
        return "/product/category";
    }

    //Author: SS, AP, LKB
    //TODO: look at return statement, change html if neccessary
    //------CHECKOUT USE CASE-----
    //pre : shopping cart must have elements inside
    //post: one or more elements inside shopping cart
    //når man trykker på checkout knappen inde i shoppingcart
    @RequestMapping(value = "/shoppingCart", method = RequestMethod.POST)
    public String checkout(@ModelAttribute OrderModel orderModel)
    {
        repo.addOrderToDatabase(orderModel.getCustomerName(),
                orderModel.getCustomerEmail(), shoppingCart.getProductlist());

        return "/shoppingCart";

    }



}
