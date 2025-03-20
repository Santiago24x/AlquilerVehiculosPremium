package com.uts.AlquilerVehiculos.controller;

import com.uts.AlquilerVehiculos.model.Cliente;
import com.uts.AlquilerVehiculos.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@CrossOrigin("*")
@Tag(name = "Clientes", description = "API para la gestión de clientes") // Define la sección en Swagger
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Operation(summary = "Obtener todos los clientes", description = "Devuelve una lista de todos los clientes registrados")
    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listarTodos();
    }

    @Operation(summary = "Obtener un cliente por ID", description = "Devuelve los datos de un cliente específico")
    @GetMapping("/{id}")
    public Optional<Cliente> obtenerPorId(@PathVariable Long id) {
        return clienteService.obtenerPorId(id);
    }

    @Operation(summary = "Guardar un nuevo cliente", description = "Crea un nuevo cliente en la base de datos")
    @PostMapping
    public Cliente guardar(@RequestBody Cliente cliente) {
        return clienteService.guardar(cliente);
    }

    @Operation(summary = "Actualizar un cliente", description = "Modifica los datos de un cliente existente")
    @PutMapping("/{id}")
    public Cliente actualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.actualizar(id, cliente);
    }

    @Operation(summary = "Eliminar un cliente", description = "Elimina un cliente de la base de datos")
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        boolean eliminado = clienteService.eliminar(id);
        return eliminado ? "Cliente eliminado" : "Cliente no encontrado";
    }
}
