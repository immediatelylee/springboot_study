package com.shoppingmal_pp.domain.cart;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Page<Cart> findAllByUserIdAndUseYnOrderByCreatedDateDesc(UUID userId, char useYn, Pageable pageable);

    List<Cart> findAllByUserIdAndUseYnOrderByCreatedDateDesc(UUID userId, char useYn);

    List<Cart> findAllByUserIdAndProductId(UUID userId, Long productId);
}
