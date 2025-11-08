package ua.util;

import ua.model.Product;
import java.util.List;
import java.util.logging.Logger;


public class GroupRepository extends GenericRepository<Product> {
    private static final Logger logger = Logger.getLogger(GroupRepository.class.getName());

    public GroupRepository() {
        super(Product::getName);
    }

    public List<Product> sortByStock() {
        logger.info("Sorting group by stock (аналог кількості студентів)");
        return sortBy(Product.BY_STOCK);
    }

    public List<Product> sortByDateDesc() {
        logger.info("Sorting group by creation date (descending)");
        return sortBy(Product.BY_DATE.reversed());
    }

    public List<Product> sortByIdentityAsc() {
        logger.info("Sorting group by identity (asc)");
        return sortByIdentity("asc");
    }
}
