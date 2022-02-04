package ru.cft.optimusgang.licenses.repository.model.enums;

import java.util.Random;

public enum ProductType {
    MICROSOFT_OFFICE,
    JET_BRAINS,
    STEAM;

    public static ProductType getRandomProduct() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
