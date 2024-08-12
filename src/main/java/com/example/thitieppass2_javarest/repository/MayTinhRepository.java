package com.example.thitieppass2_javarest.repository;

import com.example.thitieppass2_javarest.model.MayTinh;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MayTinhRepository extends JpaRepository<MayTinh, Long> {
    @Query("select mt from MayTinh mt join fetch mt.loaiMayTinh")
    Page<MayTinh> findAlls(Pageable pageable);
}
