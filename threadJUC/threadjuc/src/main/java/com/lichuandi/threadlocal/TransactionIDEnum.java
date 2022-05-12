package com.lichuandi.threadlocal;

/**
 * @Auther digege
 * @Date 2021/5/28
 * @Description：
 * @page com.lichuandi.threadlocal
 * version：
 */
public enum TransactionIDEnum {
    NULL(null),
    TXBOC006("TXBOC006");
    private String value;
    TransactionIDEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    public static TransactionIDEnum get(String value) {
        if (value instanceof String) {
            for (TransactionIDEnum transactionIDEnum : TransactionIDEnum.values()) {
                if (value.equals(transactionIDEnum.getValue())) {
                    return transactionIDEnum;
                }
            }
        }
        return NULL;
    }

    /**
     * description:
     * This method use to determine whether the transactionIDEnum's value and value are equal.
     * If equal then return true,otherwise return false.
     * change history:
     * date             defect#             person             comments
     * ---------------------------------------------------------------------------------------------------------------------
     *
     * @param transactionIDEnum - transaction ID
     * @param value - value
     * @return boolean
     * @author Bear
     * @date 2018/3/20
     */
    public static boolean equals(TransactionIDEnum transactionIDEnum, String value) {
        if (value instanceof String) {
            return value.equals(transactionIDEnum.getValue());
        }
        return (null == transactionIDEnum.getValue());
    }

    public static boolean equals(String value, TransactionIDEnum transactionIDEnum) {
        return equals(transactionIDEnum, value);
    }
    @Override
    public String toString() {
        return this.value;
    }
}
