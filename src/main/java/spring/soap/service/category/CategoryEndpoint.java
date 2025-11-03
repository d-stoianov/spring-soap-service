package spring.soap.service.category;

import io.spring.guides.gs_producing_web_service.categories.GetCategoryRequest;
import io.spring.guides.gs_producing_web_service.categories.GetCategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CategoryEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service/categories";

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryEndpoint(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCategoryRequest")
    @ResponsePayload
    public GetCategoryResponse getCategory(@RequestPayload GetCategoryRequest request) {
        GetCategoryResponse response = new GetCategoryResponse();

        response.setCategory(categoryRepository.findCategory(request.getName()));

        return response;
    }
}