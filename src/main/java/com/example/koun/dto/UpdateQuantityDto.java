package com.example.koun.dto;

public class UpdateQuantityDto{
    private int newQuantity;

    private UpdateQuantityDto() {
    }

    public int getNewQuantity() {
        return newQuantity;
    }

    public static class Builder {
        private int newQuantity;

        public Builder newQuantity(int newQuantity) {
            this.newQuantity = newQuantity;
            return this;
        }

        public UpdateQuantityDto build() {
            UpdateQuantityDto dto = new UpdateQuantityDto();
            dto.newQuantity = this.newQuantity;
            return dto;
        }
    }
}

