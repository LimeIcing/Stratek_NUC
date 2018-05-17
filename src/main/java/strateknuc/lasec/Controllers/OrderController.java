package strateknuc.lasec.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import strateknuc.lasec.Interfaces.OrderRepositoryInterface;
import strateknuc.lasec.Models.OrderModel;
import strateknuc.lasec.Models.Repositories.OrderRepository;

@Controller
public class OrderController {

    @Autowired
    OrderRepositoryInterface repo = new OrderRepository();

    OrderModel shoppingCart = new OrderModel();

}
