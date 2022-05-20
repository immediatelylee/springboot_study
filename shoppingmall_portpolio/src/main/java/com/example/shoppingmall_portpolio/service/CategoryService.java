package com.example.shoppingmall_portpolio.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@RequiredArgsConstructor
@Slf4j
@Service
public class CategoryService {

    private final CategoryRepositroy categoryRepository;
    private final ValueOperations<String,Object> valueOperations;

    /**
     * 모든 카테고리 조회, 캐싱된 데이터 조회 (memory I/O)
     */
    @SuppressWarnings("unchecked") // unchecked 에러 무시 관심을 갖는 에러에 집중할수 있도록
    public HashMap<String, Object> getCategoryList() {

        return (HashMap<String, Object>) valueOperations.get(CATEGORY_LIST_KEY);
    }

    /**
     * 상위 카테고리 추가, 추가 후 캐시 업데이트
     */
    public String addFirstCategory(CategoryRequestDto.firstCategory firstCategory) {
        // Mysql에 추가 (File i/o)
        saveFirstCategory(firstCategory);

        // 상품 카테고리 캐싱 (Memory i/o)
        setCategoryCaching();

        return "1차 카테고리가 등록 되었습니다.";
    }
}
