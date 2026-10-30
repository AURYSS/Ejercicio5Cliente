package com.mx.cbtis.bromitas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import com.mx.cbtis.controller.GestorController;

@SpringBootTest
class Ejercicio5ClienteApplicationTests {

    @Autowired
    private GestorController gestorController;

    @Test
    void contextLoads() {
        assertNotNull(gestorController, "El controlador GestorController debe cargarse correctamente");
    }

    @Test
    void testVistasEstaticas() {
        assertEquals("home", gestorController.getHome());
        assertEquals("tutorial", gestorController.getTutorial());
        assertEquals("manual", gestorController.getManual());
        assertEquals("login", gestorController.getLogin());
        
        Model model = new ExtendedModelMap();
        assertEquals("register", gestorController.getRegister(model));
        assertNotNull(model.getAttribute("usuario"));

        Model modelInicio = new ExtendedModelMap();
        assertEquals("inicio", gestorController.getInicio(modelInicio));
        assertNotNull(modelInicio.getAttribute("proyectos"));
    }
}
