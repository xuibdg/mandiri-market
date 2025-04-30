package com.shop.mandiri_market.utils.exception;

public enum GlobalErrorMapping {
    SYSTEM_ERROR("-1", "Error silahkan kontak tim kami"),
    SUCCESS("0", "SUCCESS"),
    ERROR("1", "ERROR"),
    DATA_NOT_FOUND_CUSTOM("IEG-0012", "Data ${1} tidak ditemukan. Pastikan Value yang anda masukan sudah sesuai"),
    RULE_NOT_FOUND("IEG-0013", "Data RULE tidak ditemukan. Pastikan Value yang anda masukan sudah sesuai"),
    CASHIER_NOT_FOUND("IEG-0014", "Data Cashier tidak ditemukan. Pastikan Value yang anda masukan sudah sesuai"),
    PRODUCT_STOCK_NOT_FOUND("IEG-0015", "Data Product Stock tidak ditemukan. Pastikan Value yang anda masukan sudah sesuai"),
    PRODUCT_NOT_FOUND("IEG-0016", "Data Product tidak ditemukan. Pastikan Value yang anda masukan sudah sesuai")
    ;


    public final String code;
    public final String message;

    GlobalErrorMapping(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
