package com.espacial.controladores;


import com.espacial.modelo.VehiculoLanzadera;
import com.espacial.repositorio.VehiculoLanzaderaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lanzadera")
public class VehiculoLanzaderaControlador {


    @Autowired
    private VehiculoLanzaderaRepositorio vehiculoLanzaderaRepositorio;


    @PostMapping("/agregar")
    public void addLanzadera(@RequestBody VehiculoLanzadera vehiculoLanzadera){  //LA ANOTACION @REQUESTBODY ES PARA RECIBIR UN JSON Y PASARLO A UN OBJETO PERSONA
        vehiculoLanzaderaRepositorio.save(vehiculoLanzadera);
    }
    @GetMapping("/listar")
    public List<VehiculoLanzadera> listarNave(){  //METODO LISTAR TODOS
        return vehiculoLanzaderaRepositorio.findAll();
    }

    @DeleteMapping("/borrar") //BORRAR TODO
    public void deleteLanzadera() {
        vehiculoLanzaderaRepositorio.deleteAll();
    }



    //COMO MEJORA ESTE METODO DEBERIA ESTAR EN UNA CLASE SERVICO
    public List<VehiculoLanzadera> buscaPais(String filtro) throws Exception{
        try {
            List<VehiculoLanzadera> vehiculoLanzaderas = vehiculoLanzaderaRepositorio.findByPais(filtro);
            return vehiculoLanzaderas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/pais")
    public ResponseEntity<?> search(@RequestParam String filtro) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(buscaPais(filtro));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\" "+ e.getMessage()+"\"}"));
        }
    }


}
