package com.shoppingmal_pp.domain.productimg;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shoppingmal_pp.common.BaseTimeEntity;
import com.shoppingmal_pp.domain.product.Product;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ProductImg extends BaseTimeEntity {

    @Id     // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String productImgAttFile;

    @Column(nullable = false)
    private Character basicImgYn;

    @Column(nullable = false)
    private Character useYn;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @JsonIgnore
    private Product product;
}
