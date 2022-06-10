package dto;

import domain.product.Product;
import domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class CartResponseDto {

    private Long id;
    private User user;
    private Product product;
    private Integer salePrice;
    private Integer productCount;
}
