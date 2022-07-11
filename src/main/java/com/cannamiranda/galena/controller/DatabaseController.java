package com.cannamiranda.galena.controller;


import com.cannamiranda.galena.model.Galener;
import com.cannamiranda.galena.model.XlsxHandler;
import com.cannamiranda.galena.repository.GalenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DatabaseController {

    @Autowired
    private GalenerRepository galenerRepository;


    @RequestMapping(value = "/galeners", method = RequestMethod.GET)
    public List<Galener> getGaleners () throws FileNotFoundException {
        List<Galener> galeners = new ArrayList<Galener>();
        galeners = galenerRepository.findAll();
        return galeners;
    }

    @RequestMapping(value = "/galeners", method = RequestMethod.POST)
    public ResponseEntity<Galener> cadastrarGalener(@RequestBody Galener galener, UriComponentsBuilder uriBuilder){
        galenerRepository.save(galener);
        URI uri = uriBuilder.path("/galeners/{id}").buildAndExpand(galener.getEmail()).toUri();
        return ResponseEntity.created(uri).body(galener);
    }

    @RequestMapping(value = "/carregarPlanilha", method = RequestMethod.POST)
    public List<Galener> cadastrarGaleners(@RequestBody XlsxHandler xlsxHandler) throws IOException {
        List<Galener> galeners = xlsxHandler.getGalenerListFromXlsxData();

        for (Galener gal : galeners) {
            galenerRepository.save(gal);
        }

        return galeners;
    }

    @RequestMapping(value = "/galeners/{id}", method = RequestMethod.GET)
    public ResponseEntity<Galener> getGalenerDetails(@PathVariable Long id){
        Galener galener = galenerRepository.findById(id);
        //System.out.println(galener);
        if (galener != null){
            return ResponseEntity.ok(galener);
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/galeners/{id}", method = RequestMethod.PUT)
    @Transactional
    public ResponseEntity<Galener> atualizarGalener(@PathVariable Long id, @RequestBody Galener galenerAtualizado){
        Galener galenerBanco = galenerRepository.findById(id);
        Galener galener = galenerRepository.findById(id);
        if (galener != null) {
            galenerBanco.atualizar(galenerAtualizado, galenerRepository);
            return ResponseEntity.ok(galenerAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/galeners/{id}", method = RequestMethod.DELETE)
    @Transactional
    public ResponseEntity<Galener> deleteGalener(@PathVariable Long id){
        Galener galener = galenerRepository.findById(id);
        if (galener != null) {
            galenerRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
