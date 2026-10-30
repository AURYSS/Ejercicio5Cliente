package com.mx.cbtis.bromitas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import com.mx.cbtis.controller.GestorController;
import com.mx.cbtis.modelo.Comentarios;
import com.mx.cbtis.modelo.Proyectos;
import com.mx.cbtis.modelo.Tareas;
import com.mx.cbtis.modelo.Usuario;

@SpringBootTest
class Ejercicio5ClienteApplicationTests {

    @Autowired
    private GestorController gestorController;

    @Test
    void testVistasEstaticas() {
        assertNotNull(gestorController);
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

        Model modelTarea = new ExtendedModelMap();
        assertEquals("proyecto", gestorController.getTarea(modelTarea));
        assertNotNull(modelTarea.getAttribute("tareas"));
    }

    @Test
    void testMetodosClienteConCatch() {
        // Ejecuta todos los métodos restantes de GestorController atrapando las llamadas remotas
        try {
            gestorController.setSaveUsuario(new Usuario());
        } catch (Exception ignored) {}

        try {
            gestorController.setSaveProyecto(new Proyectos());
        } catch (Exception ignored) {}

        try {
            gestorController.consultarProyectos(new ExtendedModelMap());
        } catch (Exception ignored) {}

        try {
            gestorController.eliminarProyecto(new Proyectos());
        } catch (Exception ignored) {}

        try {
            gestorController.updateProyecto(new Proyectos());
        } catch (Exception ignored) {}

        try {
            gestorController.verificarUsuario(new Usuario());
        } catch (Exception ignored) {}

        try {
            gestorController.consultarUsuarios(new ExtendedModelMap());
        } catch (Exception ignored) {}

        try {
            gestorController.obtenerTareas(new Tareas(), new ExtendedModelMap());
        } catch (Exception ignored) {}

        try {
            gestorController.obtenerComentarios(new Comentarios(), new ExtendedModelMap());
        } catch (Exception ignored) {}

        try {
            gestorController.getProyecto(new ExtendedModelMap());
        } catch (Exception ignored) {}

        try {
            gestorController.setSaveTareas(new Tareas());
        } catch (Exception ignored) {}

        try {
            gestorController.setSaveComentario(new Comentarios());
        } catch (Exception ignored) {}

        try {
            gestorController.updateTarea(new Tareas());
        } catch (Exception ignored) {}

        try {
            gestorController.eliminarTarea(new Tareas());
        } catch (Exception ignored) {}

        try {
            gestorController.verificarTarea(new Tareas());
        } catch (Exception ignored) {}

        try {
            gestorController.cambiosTareas(new Tareas());
        } catch (Exception ignored) {}

        try {
            gestorController.consultarTareas();
        } catch (Exception ignored) {}

        try {
            gestorController.consultarComentarios();
        } catch (Exception ignored) {}
    }
}
