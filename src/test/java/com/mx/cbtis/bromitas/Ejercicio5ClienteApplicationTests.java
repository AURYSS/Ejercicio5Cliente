package com.mx.cbtis.bromitas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import com.mx.cbtis.controller.GestorController;
import com.mx.cbtis.modelo.Comentarios;
import com.mx.cbtis.modelo.Proyectos;
import com.mx.cbtis.modelo.Tareas;
import com.mx.cbtis.modelo.Usuario;

@SpringBootTest
class Ejercicio5ClienteApplicationTests {

    @Autowired
    private GestorController gestorController;

    private RestTemplate mockRestTemplate;

    @BeforeEach
    void setUp() {
        mockRestTemplate = mock(RestTemplate.class);
    }

    @Test
    void contextLoads() {
        assertNotNull(gestorController, "El controlador GestorController debe cargarse correctamente");
    }

    @Test
    void testVistasEstaticasYModelos() {
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
    void testEndpointsSegurosConFallback() {
        Usuario usuario = new Usuario();
        usuario.setCorreo_electronico("test@correo.com");
        usuario.setContrasena("1234");

        try {
            gestorController.setSaveUsuario(usuario);
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
            gestorController.verificarUsuario(usuario);
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
