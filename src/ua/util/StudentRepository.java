package ua.util;

import ua.model.Product;
import java.util.List;
import java.util.logging.Logger;


public class StudentRepository extends GenericRepository<Product> {
    private static final Logger logger = Logger.getLogger(StudentRepository.class.getName());

    public StudentRepository() {
        super(Product::getName);
    }

    public List<Product> sortByName() {
        logger.info("Sorting students by name");
        return sortBy(Product.BY_NAME);
    }

    public List<Product> sortByPrice() {
        logger.info("Sorting students by 'price' (аналог оцінки)");
        return sortBy(Product::compareTo);
    }

    public List<Product> sortByDate() {
        logger.info("Sorting students by registration date (createdDate)");
        return sortBy(Product.BY_DATE);
    }
}
