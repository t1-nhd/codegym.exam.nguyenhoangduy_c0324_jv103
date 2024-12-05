package codegym.nguyenhoangduy_c0324_m4_finalexam.controller;


import codegym.nguyenhoangduy_c0324_m4_finalexam.model.Product;
import codegym.nguyenhoangduy_c0324_m4_finalexam.model.ProductSearchDTO;
import codegym.nguyenhoangduy_c0324_m4_finalexam.repository.ICategoryRepository;
import codegym.nguyenhoangduy_c0324_m4_finalexam.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class ProductController {
    @Autowired
    IProductService productService;
    @Autowired
    ICategoryRepository categoryRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("search", new ProductSearchDTO());
        model.addAttribute("categories", categoryRepository.findAll());
        return "product/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryRepository.findAll());
        return "product/create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("success", "Thêm mới sản phẩm thành công");
        return "redirect:/index";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product/edit";
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("success", "Sản phẩm đã được chỉnh sửa thành công");
        return "redirect:/index";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product/delete";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        productService.detele(id);
        redirectAttributes.addFlashAttribute("success", "Xóa sản phẩm thành công");
        return "redirect:/index";
    }
}
