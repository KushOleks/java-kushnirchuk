package ua;

import ua.model.Product;
import ua.util.*;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

public class MainSerialization {
    private static final Logger logger = Logger.getLogger(MainSerialization.class.getName());

    public static void main(String[] args) {
        logger.info("=== Лабораторна №7: Серіалізація JSON / YAML ===");

        // 🔹 Завантаження конфігурації
        ConfigLoader.load("src/main/resources/config.properties");
        String jsonPath = ConfigLoader.get("json.path");
        String yamlPath = ConfigLoader.get("yaml.path");

        // 🔹 Створення тестових об’єктів
        List<Product> products = List.of(
                new Product("Laptop", 1500, 5, LocalDate.of(2025,1,5)),
                new Product("Mouse", 25, 100, LocalDate.of(2025,2,1)),
                new Product("Keyboard", 40, 50, LocalDate.of(2025,2,10))
        );

        try {
            // --- Серіалізація ---
            DataSerializer.toJSON(products, jsonPath);
            DataSerializer.toYAML(products, yamlPath);

            // --- Десеріалізація ---
            List<Product> jsonRestored = DataSerializer.fromJSON(jsonPath, Product.class);
            List<Product> yamlRestored = DataSerializer.fromYAML(yamlPath, Product.class);

            // --- Порівняння ---
            System.out.println("\n✅ JSON Restored:");
            jsonRestored.forEach(System.out::println);

            System.out.println("\n✅ YAML Restored:");
            yamlRestored.forEach(System.out::println);

            logger.info("Серіалізація та десеріалізація успішно виконані.");

        } catch (DataSerializationException e) {
            logger.severe("❌ Помилка серіалізації: " + e.getMessage());
        }
    }
}