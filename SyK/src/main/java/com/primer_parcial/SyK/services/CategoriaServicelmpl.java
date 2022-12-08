package com.primer_parcial.SyK.services;

import com.primer_parcial.SyK.models.Categoria;
import com.primer_parcial.SyK.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CategoriaServicelmpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Override
    public ResponseEntity<Categoria> createCategoria(Categoria categoria) {
            try {

                categoriaRepository.save(categoria);
                return new ResponseEntity(categoria, HttpStatus.CREATED);
            } catch (Exception e) {
                System.out.print(e.fillInStackTrace());
                return ResponseEntity.badRequest().build();
            }

    }

    @Override
    public ResponseEntity<Categoria> editCategoria(Long id, Categoria categoria) {
        Optional<Categoria> categoriaBD = categoriaRepository.findById(id);
        if (categoriaBD.isPresent()) {
            try {
                categoriaBD.get().setNombre(categoria.getNombre());
                categoriaBD.get().setDescripcion(categoria.getDescripcion());
                categoriaRepository.save(categoriaBD.get());
                return new ResponseEntity(categoria, HttpStatus.OK);
            }catch (Exception e){
                return ResponseEntity.badRequest().build();
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity<Categoria> deleteCategoria(Long id) {
        Optional<Categoria> categoriaBD = categoriaRepository.findById(id);
        if (categoriaBD.isPresent()){
            categoriaRepository.delete(categoriaBD.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}

