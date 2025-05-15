package search.infrastructure.inbound.rest;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import search.application.ports.input.ProductSearchPort;

@RestController
@RequestMapping("/api/v1/search/products")
@RequiredArgsConstructor
@Slf4j
public class ProductSearchController {

    private final ProductSearchPort productSearchPort;
    

}
