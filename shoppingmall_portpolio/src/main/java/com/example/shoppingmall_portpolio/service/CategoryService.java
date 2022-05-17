package com.example.shoppingmall_portpolio.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class CategoryService {

    private final CategoryRepositroy categoryRepository;
    private final ValueOperations<String,Object> valueOperations;


}
