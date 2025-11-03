package spring.soap.service.good;

import io.spring.guides.gs_producing_web_service.Good;
import io.spring.guides.gs_producing_web_service.categories.Category;
import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import spring.soap.service.category.CategoryRepository;

@Component
public class GoodRepository {
    private static final Map<String, Good> goods = new HashMap<>();

    private final CategoryRepository categoryRepository;

    public GoodRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @PostConstruct
    public void initData() {
        Category fruitsCat = this.categoryRepository.findCategory("Fruits");
        Category dairyCat = this.categoryRepository.findCategory("Dairy");

        Good orange = new Good();
        orange.setName("Orange");
        orange.setAmount(500);
        orange.setPrice(1.2);
        orange.setCategory(fruitsCat);

        goods.put(orange.getName(), orange);

        Good apple = new Good();
        apple.setName("Apple");
        apple.setAmount(700);
        apple.setPrice(1.5);
        apple.setCategory(fruitsCat);

        goods.put(apple.getName(), apple);

        Good milk = new Good();
        milk.setName("Milk");
        milk.setAmount(1250);
        milk.setPrice(1.25);
        milk.setCategory(dairyCat);

        goods.put(milk.getName(), milk);
    }

    public Good findGood(String name) {
        Assert.notNull(name, "The good's name must not be null");
        return goods.get(name);
    }
}