package com.shoppingmal_pp.domain.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shoppingmal_pp.domain.review.Review;
import com.shoppingmal_pp.domain.cart.Cart;
import com.shoppingmal_pp.domain.productDisPrc.ProductDisPrc;
import com.shoppingmal_pp.domain.productimg.ProductImg;
import com.shoppingmal_pp.domain.question.Question;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

public class Product {
    @Id     // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String productNm;
    @Column(length = 10)
    private String largeCatCd;
    @Column(length = 10)
    private String smallCatCd;

    @Column
    private Integer price;
    @Column
    private Integer purchaseCount;
    @Column
    private Integer limitCount;
    @Column
    private Integer totalCount;

    @Column(length = 10)
    private ProductStatus productStatus;

    @Column(length = 150)
    private String titleImg;

    @Column
    @ColumnDefault("0") //default 0
    private Integer rateAvg;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductImg> productImgList;

    @BatchSize(size = 1000)
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ProductDisPrc> productDisPrcList;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Question> questions;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Cart> carts;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Review> reviews;

    public ProductResponseDto toResponseDto(int disPrice) {

        return ProductResponseDto.builder()
                .id(id)
                .productNm(productNm)
                .largeCatCd(largeCatCd)
                .smallCatCd(smallCatCd)
                .price(price)
                .disPrice(disPrice)
                .purchaseCount(purchaseCount)
                .limitCount(limitCount)
                .totalCount(totalCount)
                .productStatus(productStatus)
                .rateAvg(rateAvg)
                .titleImg(titleImg)
                .build();
    }

    public ProductResponseDto.MainProductResponseDto toMainProductResponseDto(int disPrice) {

        return ProductResponseDto.MainProductResponseDto.builder()
                .id(id)
                .productNm(productNm)
                .titleImg(titleImg)
                .price(price)
                .disPrice(disPrice)
                .salePrice((int)((((float) 100 - (float) disPrice) / (float)100) * price))
                .rateAvg(rateAvg)
                .timestamp(Timestamp.valueOf(this.getCreatedDate()).getTime())
                .purchaseCnt(purchaseCount)
                .build();
    }

    public ProductResponseDto.AdminProductResponseDto toAdminProductResponseDto(int disPrice) {

        return ProductResponseDto.AdminProductResponseDto.builder()
                .id(id)
                .productNm(productNm)
                .titleImg(titleImg)
                .price(price)
                .disPrice(disPrice)
                .purchaseCount(purchaseCount)
                .totalCount(totalCount)
                .rateAvg(rateAvg)
                .build();
    }

}
