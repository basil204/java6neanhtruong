package com.example.thitieppass2_javarest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "mayTinh")
public class MayTinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("may_id")
    private Long may_id;
    @NotBlank(message = "null ten")
    @JsonProperty("ten_may")
    private String ten_may;
    @JsonProperty("gia")
    private double gia;

    @ManyToOne
    @JoinColumn(name = "loai_id")
    private LoaiMayTinh loaiMayTinh;
}
