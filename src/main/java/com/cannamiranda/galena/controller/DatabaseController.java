package com.cannamiranda.galena.controller;


import com.cannamiranda.galena.model.Galener;
import com.cannamiranda.galena.model.XlsxHandler;
import com.cannamiranda.galena.repository.GalenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
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
    public ResponseEntity<Galener> getGalenerDetails(@RequestBody String id){
    //public ResponseEntity<Galener> getGalenerDetails(@PathVariable String id){
        //Galener galener = galenerRepository.getReferenceById(id);
        //System.out.println(galenerRepository.findById(id));
        Optional<Galener> galener = galenerRepository.findById(id);
        if (galener.isPresent()){
            return ResponseEntity.ok(new Galener());
        }
        //Galener galener = new Galener();
        //Galener galener = galenerRepository.getOne(id);
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/galeners/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Galener> atualizarGalener(@PathVariable String id, @RequestBody Galener galenerAtualizado){
        Galener galenerBanco = galenerRepository.getReferenceById(id);
        galenerBanco.atualizar(galenerAtualizado);

        return ResponseEntity.ok(galenerBanco);
    }
}
