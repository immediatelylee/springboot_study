package com.shoppingmal_pp.domain.review;

import com.shoppingmal_pp.domain.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000000000)
    private String content;

    @Column
    private int rate;
    @Column
    private String title;

    @ManyToOne
    @JoinColumn(name="product_id" referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private User user;

    public ReviewResponseDto toResponseDto() {
        LocalDateTime createdDate = this.getCreatedDate();

        return ReviewResponseDto.builder()
                .id(id)
                .userIdentifier(user.toReviewResponseDto())
                .title(title)
                .rate(rate)
                .createdDate(createdDate.getYear() + "-" + createdDate.getMonthValue() + "-"
                        + createdDate.getDayOfMonth() + " " + createdDate.getHour() + ":" + createdDate.getMinute() + ":"
                        + createdDate.getSecond())
                .build();
    }

}
