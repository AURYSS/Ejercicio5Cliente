package com.mx.cbtis.bromitas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import com.mx.cbtis.controller.VistaController;

@SpringBootTest
class Ejercicio5ClienteApplicationTests {

    @Autowired
    private VistaController vistaController;

    @Test
    void contextLoads() {
        assertNotNull(vistaController);
    }

    @Test
    void testTodasLasVistas() {
        assertEquals("home", vistaController.getHome());
        assertEquals("tutorial", vistaController.getTutorial());
        assertEquals("manual", vistaController.getManual());
        assertEquals("login", vistaController.getLogin());

        Model modelReg = new ExtendedModelMap();
        assertEquals("register", vistaController.getRegister(modelReg));
        assertNotNull(modelReg.getAttribute("usuario"));

        Model modelIni = new ExtendedModelMap();
        assertEquals("inicio", vistaController.getInicio(modelIni));
        assertNotNull(modelIni.getAttribute("proyectos"));

        Model modelTar = new ExtendedModelMap();
        assertEquals("proyecto", vistaController.getTarea(modelTar));
        assertNotNull(modelTar.getAttribute("tareas"));
    }
}
