package com.espacial.controladores;

import com.espacial.modelo.NaveNoTripulada;
import com.espacial.repositorio.NoTripuladaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notripulada")
public class NaveNoTripuladaControlador{


    @Autowired
    private NoTripuladaRepositorio noTripuladaRepositorio;


    @PostMapping("/agregar")
    public void addNoTripulada(@RequestBody NaveNoTripulada naveNoTripulada){
        noTripuladaRepositorio.save(naveNoTripulada);
    }

    @GetMapping("/listar")
    public List<NaveNoTripulada> listarNaveNoTripulada(){  //METODO LISTAR TODOS
        return noTripuladaRepositorio.findAll();
    }


    @DeleteMapping("/borrar") //BORRAR TODO
    public void deleteNoTripulada() {
        noTripuladaRepositorio.deleteAll();
    }


    //COMO MEJORA ESTE METODO DEBERIA ESTAR EN UNA CLASE SERVICO
    public List<NaveNoTripulada> buscaPais(String filtro) throws Exception{
        try {
            List<NaveNoTripulada> naveNoTripuladas = noTripuladaRepositorio.findByPais(filtro);
            return naveNoTripuladas;
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



