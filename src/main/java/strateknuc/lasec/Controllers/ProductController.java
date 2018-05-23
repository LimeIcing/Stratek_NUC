package strateknuc.lasec.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import strateknuc.lasec.Interfaces.CategoryRepositoryInterface;
import strateknuc.lasec.Interfaces.ProductRepositoryInterface;
import strateknuc.lasec.Models.ProductModel;
import strateknuc.lasec.Models.Repositories.CategoryRepository;
import strateknuc.lasec.Models.Repositories.ProductRepository;

import java.sql.SQLIntegrityConstraintViolationException;

@Controller
public class ProductController {

    // AUTHOR(S): AP, ECS
    @Autowired
    private ProductRepositoryInterface productRepository = new ProductRepository();
    @Autowired
    private CategoryRepositoryInterface categoryRepository = new CategoryRepository();

    // AUTHOR(S): AP, ECS
    // create.html GET REQUEST
    // This is called when the create.html file gets refreshed
    @RequestMapping(value = "/admin/create", method = RequestMethod.GET)
    public String create(Model model, Model categoryModel) {
        model.addAttribute("productModel", new ProductModel());
        categoryModel.addAttribute("options", categoryRepository.get());

        return "/admin/create";
    }

    // AUTHOR(S): AP
    // create.html POST REQUEST
    // This is called when you create a new product via the create page
    @RequestMapping(value = "/admin/create", method = RequestMethod.POST)
    public String create(@ModelAttribute ProductModel productModel, RedirectAttributes rdt) throws Exception {
        String msg;

        try {
            productRepository.createProduct(productModel);
            msg = "Vare oprettet. Navn: " + productModel.getName() + ", EAN nr.: " + productModel.getEan();
        }
        catch (SQLIntegrityConstraintViolationException e) {
            msg = "Varen med EAN: " + productModel.getEan() + " eksisterer allerede og kan derfor ikke oprettes.";
        }

        rdt.addFlashAttribute("message", msg);

        return "redirect:/admin/index";
    }

    // AUTHOR(S): CPS
    @RequestMapping(value = "/admin/editProduct/{ean}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable(value = "ean") String ean, Model categoryModel) throws Exception {
        model.addAttribute("product", productRepository.get(ean));
        categoryModel.addAttribute("options", categoryRepository.get());

        return "/admin/editProduct";
    }

    // AUTHOR(S): ECS
    // editProduct.html POST REQUEST
    // This is called when a product is edited via the edit page
    @RequestMapping(value = "/admin/editProduct", method = RequestMethod.POST)
    public String edit(@ModelAttribute ProductModel productModel, RedirectAttributes rdt) throws Exception{
        rdt.addFlashAttribute("message", "Vare redigeret");
        productRepository.updateProduct(productModel);

        return "redirect:/admin/editList";
    }

    // AUTHOR(S): CPS, ECS
    // Mapping for Delete page
    @RequestMapping(value = "/admin/delete/{ean}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable(value = "ean") String ean) throws Exception {
        model.addAttribute("product", productRepository.get(ean));

        return "/admin/delete";
    }

    // AUTHOR(S): ECS, CPS
    // editProduct.html POST REQUEST
    // This is called when you delete a product via the delete confirmation page
    @RequestMapping(value = "/admin/delete/{ean}", method = RequestMethod.POST)
    public String delete(@PathVariable(value = "ean") String ean, RedirectAttributes rdt) throws Exception {
        rdt.addFlashAttribute("message", "Vare slettet");
        productRepository.deleteProduct(ean);

        return "redirect:/admin/editList";
    }

    // AUTHOR(S): LKB, ECS, CPS
    @RequestMapping(value = "/product/category/{category}", method = RequestMethod.GET)
    public String productIndex (Model model, @PathVariable(value = "category") String category) throws Exception {
        model.addAttribute("products", productRepository.getList(category));

        return "/product/category";
    }

    // AUTHOR(S): ECS
    @RequestMapping(value = "/admin/editList", method = RequestMethod.GET)
    public String adminProducts (Model model) throws Exception {
        model.addAttribute("products", productRepository.getAdminList());

        return "/admin/editList";
    }

    // AUTHOR(S): ECS
    @RequestMapping(value = "/product/details/{ean}", method = RequestMethod.GET)
    public String productDetails(Model model, @PathVariable(value = "ean") String ean) throws Exception {
        model.addAttribute("product", productRepository.get(ean));

        return "/product/details";
    }
}