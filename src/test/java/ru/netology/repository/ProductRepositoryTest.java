package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exception.NotFoundException;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Smartphone p20 = new Smartphone(1, "P20-lite", 1500, "Huawei");
    private Book lotr = new Book(2, "The Lord of the Rings",400 , "J.R.R.Tolkien");
    private Smartphone se = new Smartphone(3, "iPhone SE",3000 , "Apple");

    @Test
    void shouldRemoveById() {

        repository.save(p20);
        repository.save(lotr);
        repository.save(se);

        repository.removeById(1);

        assertArrayEquals(new Product[]{lotr, se}, repository.getAll());
    }

    @Test
    void shouldThrowException() {

        repository.save(p20);
        repository.save(lotr);
        repository.save(se);

        assertThrows(NotFoundException.class, () -> repository.removeById(4));
    }
}