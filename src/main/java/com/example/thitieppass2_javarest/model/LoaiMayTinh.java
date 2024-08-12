package com.example.thitieppass2_javarest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "loaiMayTinh")
public class LoaiMayTinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("loai_id")
    private Long loai_id;
    @JsonProperty("ten_loai")
    private String ten_loai;

}
