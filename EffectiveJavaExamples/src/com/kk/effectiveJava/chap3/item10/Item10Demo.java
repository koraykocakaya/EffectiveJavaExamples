package com.kk.effectiveJava.chap3.item10;

/**
 * equals metodunu override etmeyi sadce gercekten gerekli oldugunda yapmamizi ogutlemektedir. <br>
 * 1. Bunu mumkunse gercekten sadece logical esitliklerini kontrol edecegimiz classlar icin yapmamizi onermektedir <br>
 * 2. Enum gibi bazi classlar icin logical equality direkt objenin equal olmasi anlamina geldigi icin Object classindaki equals yeterli olacaktir <br>
 * 3. equals Override ettiğimizde bu kurallar saglanmalidir <br>
 *  3.1 Reflexive null degilse x.equals(x) daima true donmeli <br>
 *  3.2 Symmetric x.equals(y) true ise y.equals.(x) de true donmeli <br>
 *  3.3 Transitive x.equals(y) = true y.equals(z) = true ise x.equals(z) = true olmalidir <br>
 *  3.4 Consistent x.equals(y) true ise extra bir degisiklik olmadan her zamana true donmelidir <br>
 *  3.5 Null olmayan hic bir kayit icin x.eqals(null) daima false donmelidir
 * 4. 
 * @author korayk
 *
 */
public class Item10Demo {

}
