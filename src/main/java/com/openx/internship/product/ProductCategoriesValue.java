package com.openx.internship.product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ProductCategoriesValue {
    private Map<String, BigDecimal> totalValueOfCategories = new HashMap<>();

    public void addCategory(String category, BigDecimal value) {
        totalValueOfCategories.put(category, value);
    }

    public Map<String, BigDecimal> getTotalValueOfCategories() {
        return totalValueOfCategories;
    }
}
