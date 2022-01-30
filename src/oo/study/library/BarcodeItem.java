package oo.study.library;

import java.util.UUID;

public abstract class BarcodeItem {
    String barcode;

    String getBarcode() {
        return barcode;
    }

    public void generateNewBarcode() {
        this.barcode = UUID.randomUUID().toString();
    }
}
