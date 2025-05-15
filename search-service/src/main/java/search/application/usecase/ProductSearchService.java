package search.application.usecase;

import org.springframework.stereotype.Service;
import search.application.ports.input.ProductSearchPort;


@Service
public class ProductSearchService implements ProductSearchPort {
    @Override
    public void search(String keyword){

    }
}
