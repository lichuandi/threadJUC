package com.lichuandi.spi;

import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author digege
 * @date 2021/11/8 23:52
 * @description：TODO
 * @page com.lichuandi.spi
 * version：1
 */
public class SPITest {
  public static void main(String[] args) {
      Iterator<SPIService> providers = Service.providers(SPIService.class);
      ServiceLoader<SPIService> load = ServiceLoader.load(SPIService.class);

      while(providers.hasNext()) {
          SPIService ser = providers.next();
          ser.execute();
      }
      System.out.println("--------------------------------");
      Iterator<SPIService> iterator = load.iterator();
      while(iterator.hasNext()) {
          SPIService ser = iterator.next();
          ser.execute();
      }
      System.out.println("---***常规的方法**-----------------------------");
      SPIService spiImpl1 = new SpiImpl1();
      SPIService spiImpl2 = new SpiImpl2();
      spiImpl1.execute();
      spiImpl2.execute();

  }
}
