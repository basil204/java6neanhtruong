package com.example.thitieppass2_javarest;

import com.example.thitieppass2_javarest.Service.MayTinhService;
import com.example.thitieppass2_javarest.model.MayTinh;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rest")
public class Controller {
    @Autowired
    MayTinhService mayTinhService;
    @GetMapping("list")
    public List<MayTinh> list() {
        return mayTinhService.getall();
    }
    @GetMapping("lists")
    public Page<MayTinh> lists(Pageable pageable) {
        return mayTinhService.listpage(pageable);
    }
    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody MayTinh mayTinh, BindingResult bindingResult) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            if(fieldError != null){
               return ResponseEntity.badRequest().body(fieldError.getDefaultMessage());
            }
        }
        return ResponseEntity.ok(mayTinhService.add(mayTinh));
    }
    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody MayTinh mayTinh, @PathVariable Long id, BindingResult bindingResult) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            if(fieldError != null){
                return ResponseEntity.badRequest().body(fieldError.getDefaultMessage());
            }

        }
       return ResponseEntity.ok(mayTinhService.update(id, mayTinh));

    }
}
