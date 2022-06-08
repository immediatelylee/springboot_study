package domain.productOrder;

import domain.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class productOrder {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String address;
    @Column
    private Integer amount;
    //created_date
    @Column
    private String delivery_message;
    @Column
    private String order_name;
    @Column
    private String order_number;
    @Column
    private OrderStatus order_status;
    @Column
    private Character refund_state;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user_id;
    // modified_data

    @OneToMany(mappedBy = "productOrder", cascade = CascadeType.ALL)
    private List<Cart> carts;

    public ProductOrderResponseDto toResponseDto() {
        LocalDateTime createdDate = this.getModifiedDate();

        return ProductOrderResponseDto.builder()
                .id(id)
                .orderNumber(orderNumber)
                .orderName(orderName)
                .deliveryMessage(deliveryMessage)
                .orderStatus(orderStatus.getValue())
                .address(address)
                .refundState(refundState)
                .amount(amount)
                .createdDate(createdDate.getYear() + "." + createdDate.getMonthValue() + "."
                        + createdDate.getDayOfMonth() + " " + createdDate.getHour() + ":" + createdDate.getMinute() + ":"
                        + createdDate.getSecond())
                .carts(carts)
                .build();
    }



}
