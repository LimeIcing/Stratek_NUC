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

/**
 * @author AP, ECS, CPS, LKB
 */
@Controller
public class ProductController {

    // AUTHOR(S): AP, ECS
    @Autowired
    private ProductRepositoryInterface productRepository = new ProductRepository();
    @Autowired
    private CategoryRepositoryInterface categoryRepository = new CategoryRepository();

    /**
     * GET method called when you click 'Opret produkt' on the admin page.
     * @param model Model for holding the empty ProductModel to be filled out in the view.
     * @param categoryModel List of categories used in the drop-down selector in the view.
     * @return The mapping for the creation page.
     */
    // AUTHOR(S): AP, ECS
    @RequestMapping(value = "/admin/create", method = RequestMethod.GET)
    public String create(Model model, Model categoryModel) {
        model.addAttribute("productModel", new ProductModel());
        categoryModel.addAttribute("options", categoryRepository.get());

        return "/admin/create";
    }

    /**
     * POST method called when you create a new product via the create page.
     * @param productModel The filled out ProductModel from the form on the create page.
     * @param rdt A version of Model used to show a message on the page.
     * @return Redirect mapping for the damin front page.
     */
    // AUTHOR(S): AP, ECS
    @RequestMapping(value = "/admin/create", method = RequestMethod.POST)
    public String create(@ModelAttribute ProductModel productModel, RedirectAttributes rdt) {
        String msg = productRepository.createProduct(productModel);

        rdt.addFlashAttribute("message", msg);

        return "redirect:/admin/index";
    }

    /**
     * GET method called when clicking the edit button on the list of products on the admin page.
     * @param model Holds the ProductModel fetched from the DB.
     * @param ean EAN number used to fetch the correct product from the DB.
     * @param categoryModel List of categories used in the drop-down selector in the view.
     * @return The mapping for the edit page.
     */
    // AUTHOR(S): CPS
    @RequestMapping(value = "/admin/editProduct/{ean}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable(value = "ean") String ean, Model categoryModel) {
        model.addAttribute("product", productRepository.get(ean));
        categoryModel.addAttribute("options", categoryRepository.get());

        return "/admin/editProduct";
    }

    /**
     * POST method called when a product is edited via the edit page.
     * @param productModel The ProductModel holding the edited values from the edit page.
     * @param rdt A version of Model used to show a message on the page.
     * @return Redirect mapping leading back to the list of products on the admin page.
     */
    // AUTHOR(S): ECS
    @RequestMapping(value = "/admin/editProduct", method = RequestMethod.POST)
    public String edit(@ModelAttribute ProductModel productModel, RedirectAttributes rdt) {
        rdt.addFlashAttribute("message", "Vare redigeret");
        productRepository.updateProduct(productModel);

        return "redirect:/admin/editList";
    }

    /**
     * GET method called when clicking the delete button on the list of products on the admin page.
     * @param model Holds the ProductModel fetched from the DB.
     * @param ean EAN number used to fetch the correct product from the DB.
     * @return Mapping for the delete confirmation page.
     */
    // AUTHOR(S): CPS, ECS
    @RequestMapping(value = "/admin/delete/{ean}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable(value = "ean") String ean) {
        model.addAttribute("product", productRepository.get(ean));

        return "/admin/delete";
    }

    /**
     * POST method called when you delete a product via the delete confirmation page
     * @param ean EAN number of the product to be deleted from the DB.
     * @param rdt A version of Model used to show a message on the page.
     * @return Redirect mapping leading back to the list of products on the admin page.
     */
    // AUTHOR(S): ECS, CPS
    @RequestMapping(value = "/admin/delete/{ean}", method = RequestMethod.POST)
    public String delete(@PathVariable(value = "ean") String ean, RedirectAttributes rdt) {
        rdt.addFlashAttribute("message", "Vare slettet");
        productRepository.deleteProduct(ean);

        return "redirect:/admin/editList";
    }

    /**
     * GET method called when you click a product category to browse.
     * @param model Holds the list of products in the given category.
     * @param category The category that's been clicked on.
     * @return Mapping for the list of products in the given category.
     */
    // AUTHOR(S): LKB, ECS, CPS
    @RequestMapping(value = "/product/category/{category}", method = RequestMethod.GET)
    public String productIndex (Model model, @PathVariable(value = "category") String category) {
        model.addAttribute("products", productRepository.getList(category));

        return "/product/category";
    }

    /**
     * GETE method called when you click 'Redigér produkt' on the admin page.
     * @param model Holds the list of all products.
     * @return Mapping for the list of products on the admin page.
     */
    // AUTHOR(S): ECS
    @RequestMapping(value = "/admin/editList", method = RequestMethod.GET)
    public String adminProducts (Model model) {
        model.addAttribute("products", productRepository.getAdminList());

        return "/admin/editList";
    }

    /**
     * GET method called when you click a product somewhere on the customer site.
     * @param model Holds the ProductModel of the clicked product, fetched from the DB.
     * @param ean EAN number of the clicked product.
     * @return Mapping for the product details page.
     */
    // AUTHOR(S): ECS
    @RequestMapping(value = "/product/details/{ean}", method = RequestMethod.GET)
    public String productDetails(Model model, @PathVariable(value = "ean") String ean) {
        model.addAttribute("product", productRepository.get(ean));

        return "/product/details";
    }
}