package com.example.demoapp.domain.prestashop;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {

    Category category;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    private class Category {

        private String id;
        private String nb_products_recursive;
        private String active;
        private String id_shop_default;
        private String date_add;
        private String date_upd;
        private String name;
        private String link_rewrite;

    }
}
