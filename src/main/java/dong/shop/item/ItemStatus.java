package dong.shop.item;

public enum ItemStatus {

    BASIC("기본"),
    DISCOUNT("할인 제품"),

    DELETE("삭제된 상품");

    private final String description;

    ItemStatus(String description) {
        this.description = description;
    }

}
