package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Smartphone p20 = new Smartphone(2, "P20-lite", 1500, "Huawei");


    @Test
    public void shouldFind1Item() {

        repository.save(p20);

        Product[] expected = new Product[]{p20};
        Product[] actual = manager.searchBy("Huawei");

        assertArrayEquals(expected, actual);
    }

}