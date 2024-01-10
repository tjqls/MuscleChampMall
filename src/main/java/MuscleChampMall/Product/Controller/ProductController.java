package MuscleChampMall.Product.Controller;

import MuscleChampMall.Product.Entity.Product;
import MuscleChampMall.Product.Service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/list")
    public String list(Model model) {
        List<Product> productList = this.productService.getAll();
        model.addAttribute("productList" , productList);
        return"product/detail";
    }
}
