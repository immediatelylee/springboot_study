package com.shoppingmal_pp.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shoppingmal_pp.common.BaseTimeEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User extends BaseTimeEntity {

    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    @Id     // primary key
    private UUID id;

    @Column
    private String authorities;

    @Column
    private String buildingName;

    // created_date -> EntityListeners

    @Column
    private String detailAddr;

    @Column
    private String email;

    @Column
    private String identifier;

    // modifired_date -> EntityListener

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String roadAddr;

    @ColumnDefault("0")
    @Column
    private Integer savings;

    @Column
    private Character disabledYn;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<QuestionAnswer> answers;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Cart> carts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ProductOrder> productOrders;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Review> reviews;

    public User updateProfiles(MeRequestDto meRequestDto) {
        this.name = meRequestDto.getName();
        this.email = meRequestDto.getEmail();
        this.roadAddr = meRequestDto.getRoadAddr();
        this.buildingName = meRequestDto.getBuildingName();
        this.detailAddr = meRequestDto.getDetailAddr();

        return this;
    }

    public User deleteProfiles() {
        this.disabledYn = 'Y';

        return this;
    }

    public User updatePassword(String password) {
        this.password = password;

        return this;
    }

    public UserResponseDto toResponseDto(User user) {

        return UserResponseDto.builder()
                .id(user.getId())
                .identifier(user.getIdentifier())
                .name(user.getName())
                .email(user.getEmail())
                .roadAddr(user.getRoadAddr())
                .buildingName(user.getBuildingName())
                .detailAddr(user.getDetailAddr())
                .savings(user.getSavings())
                .build();
    }

    public UserResponseDto.ReviewUserResponseDto toReviewResponseDto() {

        return UserResponseDto.ReviewUserResponseDto.builder()
                .identifier(identifier)
                .build();
    }

    public UserResponseDto.QuestionUserResponseDto toQuestionResponseDto(User user) {
        return UserResponseDto.QuestionUserResponseDto.builder()
                .id(user.getId())
                .identifier(user.getIdentifier())
                .build();
    }
}
