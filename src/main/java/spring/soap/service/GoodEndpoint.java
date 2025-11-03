package spring.soap.service;

import io.spring.guides.gs_producing_web_service.GetGoodRequest;
import io.spring.guides.gs_producing_web_service.GetGoodResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class GoodEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private final GoodRepository goodRepository;

    @Autowired
    public GoodEndpoint(GoodRepository goodRepository) {
        this.goodRepository = goodRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getGoodRequest")
    @ResponsePayload
    public GetGoodResponse getGood(@RequestPayload GetGoodRequest request) {
        GetGoodResponse response = new GetGoodResponse();

        response.setGood(goodRepository.findGood(request.getName()));

        return response;
    }
}