package dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

import javax.validation.constraints.Min;

@Setter
@Getter
@ToString
public class CartRequestDto {

    private UUID userId;
    private Long productId;
    @Min(value = 1, message = "수량은 1보다 작을 수 없습니다.")
    private Integer productCount;
}
