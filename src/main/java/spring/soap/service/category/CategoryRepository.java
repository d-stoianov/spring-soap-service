package spring.soap.service.category;

import io.spring.guides.gs_producing_web_service.categories.Category;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

@Component
public class CategoryRepository {
    private static final Map<String, Category> categories = new HashMap<>();

    @PostConstruct
    public void initData() {
        Category fruitsCat = new Category();
        fruitsCat.setName("Fruits");
        categories.put(fruitsCat.getName(), fruitsCat);

        Category dairyCat = new Category();
        dairyCat.setName("Dairy");
        categories.put(dairyCat.getName(), dairyCat);
    }

    public Category findCategory(String name) {
        Assert.notNull(name, "The category's name must not be null");
        return categories.get(name);
    }
}