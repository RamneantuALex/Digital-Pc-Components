package com.proiect.demo.entity;

import com.proiect.demo.controller.ElectronicSystemController;
import com.proiect.demo.entity.ElectronicSystem;
import com.proiect.demo.repository.BasketRepository;
import com.proiect.demo.repository.ElectronicSystemRepository;
import com.proiect.demo.repository.ProductDiscountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class ElectronicSystemControllerTest {

    @Mock
    private ElectronicSystemRepository electronicSystemRepository;

    @Mock
    private BasketRepository basketRepository;

    @Mock
    private ProductDiscountRepository discountRepository;

    @InjectMocks
    private ElectronicSystemController electronicSystemController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllElectronicSystems() {
        when(electronicSystemRepository.findAll()).thenReturn(List.of(new ElectronicSystem(), new ElectronicSystem()));
        List<ElectronicSystem> electronicSystems = electronicSystemController.getAllBaskets();
        verify(electronicSystemRepository, times(1)).findAll();
        assertNotNull(electronicSystems);
        assertEquals(2, electronicSystems.size());
    }

    @Test
    void testGetElectronicSystemById() {
        int id = 1;
        ElectronicSystem electronicSystem = new ElectronicSystem();
        electronicSystem.setId(id);
        when(electronicSystemRepository.findById(id)).thenReturn(Optional.of(electronicSystem));
        ElectronicSystem result = electronicSystemController.getElectronicSystemById(id);
        verify(electronicSystemRepository, times(1)).findById(id);
        assertNotNull(result);
        assertEquals(id, result.getId());
    }

    @Test
    void testCreateElectronicSystem() {
        ElectronicSystem electronicSystem = new ElectronicSystem();
        when(electronicSystemRepository.save(any(ElectronicSystem.class))).thenReturn(electronicSystem);
        ElectronicSystem result = electronicSystemController.createElectronicSystem(new ElectronicSystem());
        verify(electronicSystemRepository, times(1)).save(any(ElectronicSystem.class));
        assertNotNull(result);
    }

    @Test
    void testUpdateElectronicSystem() {
        int id = 1;
        ElectronicSystem existingElectronicSystem = new ElectronicSystem();
        existingElectronicSystem.setId(id);
        when(electronicSystemRepository.findById(id)).thenReturn(Optional.of(existingElectronicSystem));
        when(electronicSystemRepository.save(any(ElectronicSystem.class))).thenReturn(existingElectronicSystem);
        ElectronicSystem updatedElectronicSystem = new ElectronicSystem();
        updatedElectronicSystem.setId(id);
        updatedElectronicSystem.setDescription("Updated Description");
        ElectronicSystem result = electronicSystemController.updateElectronicSystem(id, updatedElectronicSystem);
        verify(electronicSystemRepository, times(1)).findById(id);
        verify(electronicSystemRepository, times(1)).save(any(ElectronicSystem.class));
        assertNotNull(result);
        assertEquals("Updated Description", result.getDescription());
    }

    @Test
    void testGetAllPromotions() {
        when(electronicSystemRepository.findByPromotion(true)).thenReturn(List.of(new ElectronicSystem(), new ElectronicSystem()));
        List<ElectronicSystem> promotions = electronicSystemController.getAllPromotions();
        verify(electronicSystemRepository, times(1)).findByPromotion(true);
        assertNotNull(promotions);
        assertEquals(2, promotions.size());
    }
}
