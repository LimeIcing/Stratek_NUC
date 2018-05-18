package strateknuc.lasec.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import strateknuc.lasec.Interfaces.OrderRepositoryInterface;
import strateknuc.lasec.Interfaces.ProductRepositoryInterface;
import strateknuc.lasec.Models.OrderModel;
import strateknuc.lasec.Models.Repositories.OrderRepository;
import strateknuc.lasec.Models.Repositories.ProductRepository;

//Author: SS, AP, LKB, ECS, CPS
@Controller
public class OrderController {

    @Autowired
    private ProductRepositoryInterface productRepository = new ProductRepository();

    @Autowired
    private OrderRepositoryInterface orderRepository = new OrderRepository();

    private OrderModel shoppingCart = new OrderModel();

    //------KØB USE CASE------
    //TODO: change url path to køb button's name
    //når man trykker på køb så bliver produktet tilføjet til kurven
    @RequestMapping(value = "/product/category/{ean}", method = RequestMethod.POST)
    public String addToOrderModel(@PathVariable(value = "ean") String ean)
    {
        shoppingCart.addProduct(productRepository.get(ean));
        System.out.println(ean);
        shoppingCart.setTotalPrice();

        return "redirect:/shoppingCart";
    }

    //hver gang man går ind på indkøbskurv siden
    //så bliver denne metode kaldt
    @RequestMapping(value = "/shoppingCart", method = RequestMethod.GET)
    public String showCart(Model model)
    {
        model.addAttribute("productList",shoppingCart.getProductlist());
        model.addAttribute("totalPrice", shoppingCart.getTotalprice());

        return "/shoppingCart";
    }
    //hver gang man går ind på indkøbskurv siden
    //så bliver denne metode kaldt
    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String showCheckOut(Model model)
    {
        model.addAttribute("productList",shoppingCart.getProductlist());
        model.addAttribute("totalPrice", shoppingCart.getTotalprice());

        return "/checkout";
    }

    //TODO: look at return statement, change html if neccessary
    //------CHECKOUT USE CASE-----
    //pre : shopping cart must have elements inside
    //post: one or more elements inside shopping cart
    //når man trykker på checkout knappen inde i shoppingcart
    @RequestMapping(value = "/shoppingCart", method = RequestMethod.POST)
    public String checkout(@ModelAttribute OrderModel orderModel)
    {
        orderRepository.addOrderToDatabase(orderModel.getCustomerName(),
                orderModel.getCustomerEmail(), shoppingCart.getProductlist());

        shoppingCart.clearOrder();
        return "/index";

    }



}
