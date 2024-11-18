# Aufgaben

## Aufgabe 1: Formen von Tests in der Informatik

1. **Komponententest (Unit Testing):**  
   - Testet einzelne Module oder Klassen in Isolation. 
   - **Beispiel:** Testen der Methode `calculatePrice()` unabhängig von anderen Klassen. 
   - **Durchführung:** Entwickler verwenden Frameworks wie JUnit (Java) oder NUnit (C#), um Funktionen gezielt mit verschiedenen Eingabewerten zu testen.

2. **Integrationstest:**  
   - Testet die Schnittstellen und das Zusammenspiel zwischen verschiedenen Modulen.
   - **Beispiel:** Preisberechnung mit verschiedenen Modulen für Rabatte, Extras und Steuern.
   - **Durchführung:** Alle Module werden kombiniert, und es wird geprüft, ob sie korrekt interagieren.

3. **Systemtest:**  
   - Testet das gesamte System auf die Erfüllung der Anforderungen.
   - **Beispiel:** Testen einer kompletten Auto-Verkauf Software.
   - **Durchführung:** Qualitätssicherungsteams prüfen das System in einer Testumgebung, die die reale Nutzung simuliert.
  
     
---

## Aufgabe 2: Beispiele für SW-Fehler, SW-Mangel und hoher Schaden

   - Beispiel für einen Software-Fehler:
         Eine Buchhaltungssoftware berechnet Mehrwertsteuer falsch aufgrund eines Rundungsfehlers.

   - Beispiel für einen Software-Mangel:
         Eine mobile App zeigt korrekte Daten an, aber die Benutzeroberfläche ist schwer verständlich und nicht intuitiv.

   - Beispiel für hohen Schaden bei einem SW-Fehler:
         Fehler in einer Flugsteuerungssoftware führt zur Fehlberechnung von Flugbahnen, was eine Kollision verursachen könnte.

---

## Aufgabe 3: Testtreiber für `calculatePrice()`

### Testtreiber in Java

```java
public class PriceCalculationTest {

    public static void main(String[] args) {
        boolean result = test_calculate_price();
        if (result) {
            System.out.println("All tests passed.");
        } else {
            System.out.println("Some tests failed.");
        }
    }

    static boolean test_calculate_price() {
        boolean test_ok = true;

        double price = calculatePrice(1000, 200, 300, 3, 10);
        if (Math.abs(price - 1450.0) > 0.01) {  // Expected result with 10% discount
            System.out.println("Test 1 failed. Expected: 1450.0, Got: " + price);
            test_ok = false;
        }

        price = calculatePrice(1000, 200, 300, 5, 15);
        if (Math.abs(price - 1375.0) > 0.01) {  // Expected result with 15% discount
            System.out.println("Test 2 failed. Expected: 1375.0, Got: " + price);
            test_ok = false;
        }

        price = calculatePrice(1000, 200, 300, 1, 5);
        if (Math.abs(price - 1475.0) > 0.01) {  // No extras discount applies
            System.out.println("Test 3 failed. Expected: 1475.0, Got: " + price);
            test_ok = false;
        }

        return test_ok;
    }

    static double calculatePrice(double baseprice, double specialprice, double extraprice, int extras, double discount) {
        double addon_discount;
        double result;

        if (extras >= 5)
            addon_discount = 15;
        else if (extras >= 3)
            addon_discount = 10;
        else
            addon_discount = 0;

        if (discount > addon_discount)
            addon_discount = discount;

        result = baseprice / 100.0 * (100 - discount) + specialprice
                + extraprice / 100.0 * (100 - addon_discount);

        return result;
    }
}

```

## Aufgabe 3 - Bonus: Fehleranalyse im Code

### Fehleranalyse

**Fehler:**  
Der Fehler liegt in der Reihenfolge der Bedingungsprüfung im `if-else` Block:

```java
if (extras >= 3) 
    addon_discount = 10;
else if (extras >= 5)
    addon_discount = 15;
```
In diesem Fall wird die Bedingung extras >= 5 nie erreicht, da die Bedingung extras >= 3 bereits erfüllt wird, bevor die zweite Bedingung geprüft wird.

#### Begründung
Die ursprüngliche Reihenfolge führt dazu, dass immer addon_discount = 10 gesetzt wird, wenn extras >= 3, auch wenn extras >= 5 gilt. Die korrigierte Reihenfolge stellt sicher, dass der Rabatt von 15% für fünf oder mehr Zusatzausstattungen angewendet wird, bevor der niedrigere Rabatt geprüft wird.

#### Korrektur
Die Bedingung extras >= 5 sollte vor extras >= 3 stehen, um sicherzustellen, dass der höhere Rabatt korrekt angewendet wird:

```java
if (extras >= 5) 
    addon_discount = 15;
else if (extras >= 3)
    addon_discount = 10;
```
