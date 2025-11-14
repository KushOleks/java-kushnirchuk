package ua.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class DataSerializer {
    private static final Logger logger = Logger.getLogger(DataSerializer.class.getName());

    private static final ObjectMapper jsonMapper = new ObjectMapper();
    private static final ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());

    public static <T> void toJSON(List<T> data, String filePath) {
        try {
            jsonMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), data);
            logger.info("✅ JSON saved to: " + filePath);
        } catch (IOException e) {
            logger.severe("❌ Failed to save JSON: " + e.getMessage());
            throw new DataSerializationException("Error saving JSON file", e);
        }
    }

    public static <T> List<T> fromJSON(String filePath, Class<T> type) {
        try {
            return List.of(jsonMapper.readValue(new File(filePath), type));
        } catch (IOException e) {
            logger.severe("❌ Failed to load JSON: " + e.getMessage());
            throw new DataSerializationException("Error reading JSON file", e);
        }
    }

    public static <T> void toYAML(List<T> data, String filePath) {
        try {
            yamlMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), data);
            logger.info("✅ YAML saved to: " + filePath);
        } catch (IOException e) {
            logger.severe("❌ Failed to save YAML: " + e.getMessage());
            throw new DataSerializationException("Error saving YAML file", e);
        }
    }

    public static <T> List<T> fromYAML(String filePath, Class<T> type) {
        try {
            return List.of(yamlMapper.readValue(new File(filePath), type));
        } catch (IOException e) {
            logger.severe("❌ Failed to load YAML: " + e.getMessage());
            throw new DataSerializationException("Error reading YAML file", e);
        }
    }
}