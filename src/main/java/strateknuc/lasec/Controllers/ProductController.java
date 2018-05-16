package strateknuc.lasec.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import strateknuc.lasec.Interfaces.CategoryRepositoryInterface;
import strateknuc.lasec.Interfaces.ProductRepositoryInterface;
import strateknuc.lasec.Models.CategoryModel;
import strateknuc.lasec.Models.ProductModel;
import strateknuc.lasec.Models.Repositories.CategoryRepository;
import strateknuc.lasec.Models.Repositories.ProductRepository;

@Controller
public class ProductController {

    // this finds and creates beans
    // AUTHOR(S): AP, ECS
    @Autowired
    private ProductRepositoryInterface productRepository = new ProductRepository();
    @Autowired
    private CategoryRepositoryInterface categoryRepository = new CategoryRepository();

    // AUTHOR(S): AP, ECS
    // create.html GET REQUEST
    // this is called when the create.html file gets refreshed
    @RequestMapping(value = "/admin/create", method = RequestMethod.GET)
    public String create(Model model, Model categoryModel) {
        model.addAttribute("productModel", new ProductModel());
        categoryModel.addAttribute("options", categoryRepository.get());
        return "/admin/create";
    }

    // AUTHOR(S): AP
    // create.html POST REQUEST
    // this is called when a form="action" method="POST" is called
    // i.e when a button gets pressed and sends data further
    @RequestMapping(value = "/admin/create", method = RequestMethod.POST)
    public String create(@ModelAttribute ProductModel productModel) {
        productRepository.createProduct(productModel);
        // redirect is used to switch pages
        return "/admin/index";
    }

    // AUTHOR(S): CPS
    @RequestMapping(value = "/admin/editProduct/{ean}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable(value = "ean") String ean, Model categoryModel) {
        model.addAttribute("product", productRepository.get(ean));
        categoryModel.addAttribute("options", categoryRepository.get());
        return "/admin/editProduct";
    }

    // AUTHOR(S): ECS
    // editProduct.html POST REQUEST
    // this is called when a form="action" method="POST" is called
    // i.e when a button gets pressed and sends data further
    @RequestMapping(value = "/admin/editProduct", method = RequestMethod.POST)
    public String edit(@ModelAttribute ProductModel productModel) {
        productRepository.updateProduct(productModel);
        return "/admin/editList";
    }

    // AUTHOR(S): ECS
    // editProduct.html POST REQUEST
    // this is called when a form="action" method="POST" is called
    // i.e when a button gets pressed and sends data further
    @RequestMapping(value = "/admin/editList", method = RequestMethod.POST)
    public String delete(String ean) {
        productRepository.deleteProduct(ean);
        return "/admin/editList";
    }

    // AUTHOR(S): LKB, ECS, CPS
    @RequestMapping(value = "/product/category/{category}", method = RequestMethod.GET)
    public String productIndex (Model model, @PathVariable(value = "category") String category) {
        model.addAttribute("products", productRepository.getList(category));
        return "/product/category";
    }

    // AUTHOR(S): ECS
    @RequestMapping(value = "/admin/editList", method = RequestMethod.GET)
    public String adminProducts (Model model) {
        model.addAttribute("products", productRepository.getAdminList());
        return "/admin/editList";
    }
}
