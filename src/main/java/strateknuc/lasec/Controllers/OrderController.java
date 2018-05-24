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

/**
 * Controller for all the features having to do with ordering a product.
 * @author SS, AP, LKB, ECS, CPS
 */
@Controller
public class OrderController {

    @Autowired
    private ProductRepositoryInterface productRepository = new ProductRepository();

    @Autowired
    private OrderRepositoryInterface orderRepository = new OrderRepository();

    private OrderModel shoppingCart = new OrderModel();

    /**
     * POST method for the 'Køb' button on the list of products.
     * Adds the product to shoppingCart and displays a message saying so on the page.
     * @param ean A path variable. EAN number of the product used to fetch the wanted product from the DB.
     * @param rdt A version of Model used to show a message on the page.
     * @return Redirect mapping to the category page you're already on.
     */
    @RequestMapping(value = "/product/category/{ean}", method = RequestMethod.POST)
    public String addToCartFromList(@PathVariable(value = "ean") String ean, RedirectAttributes rdt){
        rdt.addFlashAttribute("message", "Lagt i Kurv");
        shoppingCart.addProduct(productRepository.get(ean));

        return "redirect:/product/category/" + productRepository.get(ean).getCategory();
    }

    /**
     * POST method for when you are on the product/details page and press 'Køb'.
     * @param ean A path variable. EAN number of the product used to fetch the wanted product from the DB.
     * @param rdt A version of Model used to show a message on the page.
     * @return Redirect mapping for the details page that you're already on.
     */
    // AUTHOR(S): CPS
    @RequestMapping(value = "/product/details/{ean}", method = RequestMethod.POST)
    public String addToCartFromDetails(@PathVariable(value = "ean") String ean, RedirectAttributes rdt){
        rdt.addFlashAttribute("message", "Lagt i Kurv");
        shoppingCart.addProduct(productRepository.get(ean));

        return "redirect:/product/details/" + productRepository.get(ean).getEan();
    }

    /**
     * GET method called when you click the shopping cart.
     * @param model The Model that's sent to the view with attributes for the cart's list of product and price sum.
     * @return The mapping for the shopping cart.
     */
    @RequestMapping(value = "/shoppingCart", method = RequestMethod.GET)
    public String showCart(Model model) {
        model.addAttribute("productList", shoppingCart.getProductlist());
        model.addAttribute("totalPrice", shoppingCart.getTotalPrice());

        return "/shoppingCart";
    }

    /**
     * Pre : shopping cart must have elements inside.
     * Post: one or more elements inside shopping cart.
     * GET method called when you click 'checkout' in the cart.
     * @param model The Model that's sent to the view with attributes for the cart and its variables.
     * @return Mapping for the checkout page.
     */
    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String showCheckOut(Model model) {
        model.addAttribute("productList", shoppingCart.getProductlist());
        model.addAttribute("totalPrice", shoppingCart.getTotalPrice());
        model.addAttribute("order", shoppingCart);

        return "/checkout";
    }

    /**
     * POST method called when you click 'Bekræft køb' in checkout.
     * When it's called, the cart is saved in the DB as rows in orders and product_orders.
     * @param orderModel The Model containing customer info from the form on the checkout page.
     * @return The mapping for the front page.
     */
    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public String checkout(@ModelAttribute OrderModel orderModel) {
        orderRepository.addOrderToDatabase(orderModel.getCustomerName(),
                orderModel.getCustomerEmail(), shoppingCart.getProductlist());
        shoppingCart.clearOrder();

        return "/index";
    }

    /**
     * GET method for when you click on "Se Ordre" on the admin site.
     * Retrieves a list of orders from the DB and gives it to the Model as an attribute.
     * @param model Model for holding the list of products.
     * @return The mapping for the list of orders.
     */
    // AUTHOR(S): LKB
    @RequestMapping(value = "/admin/showOrders", method = RequestMethod.GET)
    public String showOrders(Model model) {
        model.addAttribute("orders", orderRepository.getOrdersFromDatabase());

        return "/admin/showOrders";
    }
}