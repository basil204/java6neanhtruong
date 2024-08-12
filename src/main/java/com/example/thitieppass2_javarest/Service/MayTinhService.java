package com.example.thitieppass2_javarest.Service;

import com.example.thitieppass2_javarest.model.LoaiMayTinh;
import com.example.thitieppass2_javarest.model.MayTinh;
import com.example.thitieppass2_javarest.repository.LoaiMayTinhRepository;
import com.example.thitieppass2_javarest.repository.MayTinhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MayTinhService {
    @Autowired
    MayTinhRepository mayTinhRepository;
    @Autowired
    LoaiMayTinhRepository loaiMayTinhRepository;
    public List<MayTinh> getall() {
return  mayTinhRepository.findAll();
    }

    public Object add(MayTinh mayTinh) {
        return mayTinhRepository.save(mayTinh);
    }

    public Object update(Long id, MayTinh mayTinh) {
        MayTinh mayTinh1 = mayTinhRepository.findById(id).orElseThrow();
        LoaiMayTinh loaiMayTinh = loaiMayTinhRepository.findById(mayTinh.getLoaiMayTinh().getLoai_id()).get();
        mayTinh1.setLoaiMayTinh(loaiMayTinh);
        mayTinh1.setTen_may(mayTinh.getTen_may());
        mayTinh1.setGia(mayTinh.getGia());
       return mayTinhRepository.save(mayTinh1);
    }

    public Page<MayTinh> listpage(Pageable pageable) {
        return mayTinhRepository.findAlls(pageable);
    }
}
