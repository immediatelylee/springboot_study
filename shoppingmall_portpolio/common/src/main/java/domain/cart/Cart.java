package domain.cart;

import com.fasterxml.jackson.annotation.JsonIgnore;
import domain.user.User;

import javax.persistence.*;

public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Integer productCount;
    @Column
    private Character useYn;
    // 객체들 간의 관계
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "product_order_id", referencedColumnName = "id")
    @JsonIgnore
    private ProductOrder productOrder;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public CartResponseDto toResponseDto(int disPrice) {

        return CartResponseDto.builder()
                .id(id)
                .user(user)
                .product(product)
                .salePrice((int)((((float) 100 - (float) disPrice) / (float)100) * product.getPrice()))
                .productCount(productCount)
                .build();
    }

    // 배치에서 호출하는 메소드
    public Cart setInvalidity() {
        useYn = 'N';
        return this;
    }
}
