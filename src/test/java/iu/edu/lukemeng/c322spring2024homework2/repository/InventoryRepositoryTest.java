package iu.edu.lukemeng.c322spring2024homework2.repository;

import iu.edu.lukemeng.c322spring2024homework2.model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class InventoryRepositoryTest {

    @Test
    void addGuitar() throws IOException {
        // issues found in this test after making new assigned required implementations fixed the rest of the tests basically as well.
        // fixed things like parameter issues with the new enums and out of bounds erros made cause by my own mistakes when updating code
        
        InventoryRepository inventoryRepository = new InventoryRepository();
        inventoryRepository.addGuitar(new Guitar("101", 1200.0, Builder.FENDER, "Model1", Type.ACOUSTIC, Wood.MAHOGANY, Wood.CEDAR));

        Guitar foundGuitar = inventoryRepository.getGuitar("101");
        assertNotNull(foundGuitar);
        assertEquals("101", foundGuitar.getSerialNumber());
        assertEquals(1200.0, foundGuitar.getPrice());
        assertEquals(Builder.FENDER, foundGuitar.getBuilder());
        assertEquals("Model1", foundGuitar.getModel());
        assertEquals(Type.ACOUSTIC, foundGuitar.getType());
        assertEquals(Wood.MAHOGANY, foundGuitar.getBackWood());
        assertEquals(Wood.CEDAR, foundGuitar.getTopWood());
    }

    @Test
    void getGuitar() throws IOException {
        InventoryRepository inventoryRepository = new InventoryRepository();
        inventoryRepository.addGuitar(new Guitar("102", 1200.0, Builder.MARTIN, "Model2", Type.ELECTRIC, Wood.MAPLE, Wood.SITKA));

        Guitar foundGuitar = inventoryRepository.getGuitar("102");
        assertNotNull(foundGuitar);
        assertEquals("102", foundGuitar.getSerialNumber());
        assertEquals(1200.0, foundGuitar.getPrice());
        assertEquals(Builder.MARTIN, foundGuitar.getBuilder());
        assertEquals("Model2", foundGuitar.getModel());
        assertEquals(Type.ELECTRIC, foundGuitar.getType());
        assertEquals(Wood.MAPLE, foundGuitar.getBackWood());
        assertEquals(Wood.SITKA, foundGuitar.getTopWood());
    }

    @Test
    void search() throws IOException {
        InventoryRepository inventoryRepository = new InventoryRepository();
        inventoryRepository.addGuitar(new Guitar("103", 1200.0, Builder.GIBSON, "Model1", Type.ACOUSTIC, Wood.MAHOGANY, Wood.CEDAR));
        inventoryRepository.addGuitar(new Guitar("109", 1200.0, Builder.GIBSON, "Model2", Type.ACOUSTIC, Wood.MAHOGANY, Wood.CEDAR));

        // had issues here initially seperate from issues mentioned in comments above. issue was the way the file was being read. 
        // I ended up using BufferenReader instead of Files. I just use it more and find it easier to read file using it
        Guitar searchGuitar = new Guitar(null, 1200.0, Builder.GIBSON, null, Type.ACOUSTIC, Wood.MAHOGANY, Wood.CEDAR);
        assertEquals(2, inventoryRepository.search(searchGuitar).size());
    }
}
