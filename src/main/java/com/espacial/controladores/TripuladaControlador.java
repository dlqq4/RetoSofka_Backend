package com.espacial.controladores;

import com.espacial.modelo.NaveTripulada;
import com.espacial.repositorio.TripuladaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //ESTE CONTROLADOR TRABAJA COMO SERVICIO API REST (GET, POST, PUT, DELETE)
@RequestMapping("/tripulada")
public class TripuladaControlador {


    @Autowired //ANOTACION PARA INYECTAR DEPENDENCIAS
    private TripuladaRepositorio tripuladaRepositorio;

    @PostMapping("/agregar")
    public void addTripulada(@RequestBody NaveTripulada naveTripulada){
        tripuladaRepositorio.save(naveTripulada);
    }

    @GetMapping("/listar")
    public List<NaveTripulada> listarNaveTripulada(){
        return tripuladaRepositorio.findAll();
    }


    @DeleteMapping("/borrar") //BORRAR TODO
    public void deleteTripulada() {
        tripuladaRepositorio.deleteAll();
    }



    //COMO MEJORA ESTE METODO DEBERIA ESTAR EN UNA CLASE SERVICO
    public List<NaveTripulada> buscaNombre(String filtro) throws Exception{
        try {
            List<NaveTripulada> naveTripuladas = tripuladaRepositorio.findByNombre(filtro);
            return naveTripuladas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/nombre")
    public ResponseEntity<?> search(@RequestParam String filtro) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(buscaNombre(filtro));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\" "+ e.getMessage()+"\"}"));
        }
    }

    //COMO MEJORA ESTE METODO DEBERIA ESTAR EN UNA CLASE SERVICO
    public List<NaveTripulada> buscaPais(String filtro) throws Exception{
        try {
            List<NaveTripulada> naveTripuladas = tripuladaRepositorio.findByPais(filtro);
            return naveTripuladas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/pais")
    public ResponseEntity<?> searchPais(@RequestParam String filtro) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(buscaPais(filtro));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\" "+ e.getMessage()+"\"}"));
        }
    }


}
