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
import strateknuc.lasec.Models.Repositories.OrderRepository;
import strateknuc.lasec.Models.Repositories.ProductRepository;

// AUTHOR(S): SS, AP, LKB, ECS, CPS
@Controller
public class OrderController {

    @Autowired
    private ProductRepositoryInterface productRepository = new ProductRepository();

    @Autowired
    private OrderRepositoryInterface orderRepository = new OrderRepository();

    private OrderModel shoppingCart = new OrderModel();

    // When you click 'køb', the product is added to shoppingCart
    @RequestMapping(value = "/product/category/{ean}", method = RequestMethod.POST)
    public String addToCartFromList(@PathVariable(value = "ean") String ean, RedirectAttributes rdt){
        rdt.addFlashAttribute("message", "Lagt i Kurv");
        shoppingCart.addProduct(productRepository.get(ean));

        return "redirect:/product/category/" + productRepository.get(ean).getCategory();
    }

    /**
     *
     * @param ean
     * @param rdt
     * @return Returns path for the details page that you're already on
     */
    // AUTHOR(S): CPS
    // Post method for when you are on the product/details page and press Buy
    @RequestMapping(value = "/product/details/{ean}", method = RequestMethod.POST)
    public String addToCartFromDetails(@PathVariable(value = "ean") String ean, RedirectAttributes rdt){
        rdt.addFlashAttribute("message", "Lagt i Kurv");
        shoppingCart.addProduct(productRepository.get(ean));

        return "redirect:/product/details/" + productRepository.get(ean).getEan();
    }

    // Every time you go to the page for the cart, this method is called
    @RequestMapping(value = "/shoppingCart", method = RequestMethod.GET)
    public String showCart(Model model) {
        model.addAttribute("productList",shoppingCart.getProductlist());
        model.addAttribute("totalPrice", shoppingCart.getTotalPrice());

        return "/shoppingCart";
    }

    // Pre : shopping cart must have elements inside
    // Post: one or more elements inside shopping cart
    // When you click 'checkout' in the cart, this method is called
    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String showCheckOut(Model model) {
        model.addAttribute("productList",shoppingCart.getProductlist());
        model.addAttribute("totalPrice",shoppingCart.getTotalPrice());
        model.addAttribute("order",shoppingCart);

        return "/checkout";
    }

    // When you click 'Bekræft køb' in checkout, this method is called, the cart is saved in the DB as an order and
    // product_orders, and you get redirected to the front page
    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public String checkout(@ModelAttribute OrderModel orderModel) {
        orderRepository.addOrderToDatabase(orderModel.getCustomerName(),
                orderModel.getCustomerEmail(), shoppingCart.getProductlist());
        shoppingCart.clearOrder();

        return "/index";
    }

    // AUTHOR(S): LKB
    // Mapping for when you click on "Se Ordre" on the admin site
    // Retrieves a list of orders and creates a model of them
    @RequestMapping(value = "/admin/showOrders", method = RequestMethod.GET)
    public String showOrders(Model model) {
        model.addAttribute("orders", orderRepository.getOrdersFromDatabase());

        return "/admin/showOrders";
    }
}
