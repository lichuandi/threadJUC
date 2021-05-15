package com.lichuandi.enums;

import org.junit.Test;

/**
 * @Auther digege @Date 2021/5/14
 * @Description：带一个参数的枚举
 *
 * @page com.lichuandi.enums version：1
 */
public enum TypeParaEnum {
  FIREWALL("firewall"),
  SECRET("secretMac"),
  BALANCE("f5");

  private String typeName;

  TypeParaEnum(String typeName) {
    this.typeName = typeName;
  }

  /**
   * 根据类型的名称，返回类型的枚举实例。
   *
   * @param typeName 类型名称
   */
  public static TypeParaEnum fromTypeName(String typeName) {
    for (TypeParaEnum type : TypeParaEnum.values()) {
      if (type.getTypeName().equals(typeName)) {
        return type;
      }
    }
    return null;
  }

  public String getTypeName() {
    return this.typeName;
  }

}
