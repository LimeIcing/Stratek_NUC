package strateknuc.lasec.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import strateknuc.lasec.Interfaces.OrderRepositoryInterface;
import strateknuc.lasec.Interfaces.ProductRepositoryInterface;
import strateknuc.lasec.Models.OrderModel;
import strateknuc.lasec.Models.ProductModel;
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
    public String addToOrderModel(@PathVariable(value = "ean") String ean) {

        shoppingCart.addProduct(productRepository.get(ean));
        shoppingCart.setTotalPrice();

        return "redirect:/product/category/" + productRepository.get(ean).getCategory();
    }
    // Post method for when you are on the product/details page and press Buy
    //CPS
    @RequestMapping(value = "/product/details/{ean}", method = RequestMethod.POST)
    public String addToOrderModelDetails(@PathVariable(value = "ean") String ean, RedirectAttributes rda) {
        rda.addFlashAttribute("message", "Lagt i kurv");
        shoppingCart.addProduct(productRepository.get(ean));
        shoppingCart.setTotalPrice();


        return "redirect:/product/details/" + productRepository.get(ean).getEan();
    }

    //hver gang man går ind på indkøbskurv siden
    //så bliver denne metode kaldt
    @RequestMapping(value = "/shoppingCart", method = RequestMethod.GET)
    public String showCart(Model model)
    {
        model.addAttribute("productList",shoppingCart.getProductlist());
        model.addAttribute("totalPrice", shoppingCart.getTotalPrice());

        return "/shoppingCart";
    }
    //hver gang man går ind på indkøbskurv siden
    //så bliver denne metode kaldt
    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String showCheckOut(Model model)
    {
        model.addAttribute("productList",shoppingCart.getProductlist());
        model.addAttribute("totalPrice",shoppingCart.getTotalPrice());
        model.addAttribute("order",shoppingCart);
        return "/checkout";
    }

    //TODO: look at return statement, change html if neccessary
    //------CHECKOUT USE CASE-----
    //pre : shopping cart must have elements inside
    //post: one or more elements inside shopping cart
    //når man trykker på checkout knappen inde i shoppingcart
    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public String checkout(@ModelAttribute OrderModel orderModel)
    {
        for (ProductModel p : shoppingCart.getProductlist()
             ) {
            System.out.println(p.getEan());

        }
        orderRepository.addOrderToDatabase(orderModel.getCustomerName(),
                orderModel.getCustomerEmail(), shoppingCart.getProductlist());


        shoppingCart.clearOrder();
        return "/index";

    }

    // AUTHOR: LKB
    // Mapping for when you click on "Se Ordre" on the admin site
    // Retrieves a list of orders and creates a model of them
    @RequestMapping(value = "/admin/showOrders", method = RequestMethod.GET)
    public String showOrders(Model model) {

        model.addAttribute("orders", orderRepository.getOrdersFromDatabase());
        return "/admin/showOrders";
    }



}
