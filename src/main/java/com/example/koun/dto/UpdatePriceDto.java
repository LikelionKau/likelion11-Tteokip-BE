package com.example.koun.dto;

public class UpdatePriceDto {

    private int newPrice;

    private UpdatePriceDto() {

    }

    public int getNewPrice() {
        return newPrice;
    }

    public static class Builder {
        private int newPrice;

        public Builder newPrice(int newPrice) {
            this.newPrice = newPrice;
            return this;
        }

        public UpdatePriceDto build() {
            UpdatePriceDto dto = new UpdatePriceDto();
            dto.newPrice = this.newPrice;
            return dto;
        }
    }
}
