# Test-Levels
## Aufgabe 1

### Was wird wie in Ihrer Firma getestet? Cognizant/Accenture
- **Was:** Funktionalität, Performance, Sicherheit, Usability, Kompatibilität.
- **Wie:** Manuell und automatisiert (Unit-, Integration-, Systemtests).

### Mit welchen Test Levels hatten Sie bereits zu tun?
- Unit, Integration, System, Acceptance.

### Wann werden Tests ausgeführt?
- Während der Entwicklung (CI/CD), vor Releases, nach Updates.

### Haben Sie dedizierte Testing- oder QA-Teams?
- Ja, separate QA-Teams; in kleineren Projekten testen Entwickler.

### Wie sieht Ihr Testing Life Cycle aus?
1. Planung: Anforderungen analysieren, Teststrategie erstellen.
2. Design: Testfälle schreiben, Testumgebungen vorbereiten.
3. Implementierung: Tests entwickeln (manuell/automatisiert).
4. Ausführung: Tests durchführen, Ergebnisse dokumentieren.
5. Reporting: Fehler analysieren und dokumentieren.
6. Wartung: Tests anpassen, Regressionstests ausführen.

## Aufgabe 2

### Begriffe und Abhängigkeiten

#### Testing Approach
- Strategien, z. B. Risk-Based Testing, Exploratory Testing.

#### Testing Levels
- Hierarchien: Unit, Integration, System, Acceptance.

#### Testing Types, Techniques und Tactics
- **Types:** Funktional (z. B. Regression), nicht-funktional (z. B. Performance).
- **Techniques:** Black-Box, White-Box, Grey-Box.
- **Tactics:** Automatisierung, exploratives Testen.


---

# Unit-Testing

## Aufgabe 1
### Unsere Tests:
![image](https://github.com/user-attachments/assets/cf5bea17-4436-4b46-b65e-062c58b42dc9)

### Testen in Entwicklungsumgebung
![image](https://github.com/user-attachments/assets/6725ebeb-a3d8-454d-92a3-78d0c0123a60)


### Maven Test:
![image](https://github.com/user-attachments/assets/a998b623-5ce7-4356-9e41-37994c2268c0)


## Aufgabe 2
### Gängigste JUnit Features
JUnit ist ein beliebtes Framework für Unit-Tests in Java. Es hilft dabei, einzelne Komponenten einer Software unabhängig zu testen. Hier sind die gängigsten Features:

#### 1. **Annotations**
- `@Test`: Markiert eine Methode als Test.
- `@BeforeEach`: Führt eine Methode vor jedem Test aus.
- `@AfterEach`: Führt eine Methode nach jedem Test aus.
- `@BeforeAll`: Führt eine Methode einmal vor allen Tests in einer Testklasse aus (muss `static` sein).
- `@AfterAll`: Führt eine Methode einmal nach allen Tests in einer Testklasse aus (muss `static` sein).

#### 2. **Assertions**
- `assertEquals(expected, actual)`: Überprüft, ob der erwartete und der tatsächliche Wert gleich sind.
- `assertTrue(condition)`: Überprüft, ob eine Bedingung wahr ist.
- `assertFalse(condition)`: Überprüft, ob eine Bedingung falsch ist.
- `assertThrows(exception.class, () -> code)`: Prüft, ob eine Ausnahme geworfen wird.

#### 3. **Parameterized Tests**
- `@ParameterizedTest`: Markiert eine Methode als parametrisierten Test.
- `@ValueSource`, `@CsvSource`, `@MethodSource`: Definieren die Eingabewerte.

#### 4. **Test Lifecycle**
- `@BeforeEach` / `@AfterEach`: Vorbereitung und Bereinigung vor/nach jedem Test.
- `@BeforeAll` / `@AfterAll`: Vorbereitung und Bereinigung vor/nach allen Tests.

#### 5. **Test Suites**
- Gruppiert mehrere Testklassen und führt sie gemeinsam aus (`@Suite` in JUnit 5).

### Kurze Anwendungsfälle / Beispiele für die jeweiligen Features

### Beispiel für @Test
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    void testAddition() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3), "Addition sollte korrekt sein");
    }
}

```

### Verlinkung einer Referenzseite
Für weitere Details und Beispiele besuchen Sie die [offizielle JUnit-Dokumentation](https://junit.org/junit5/docs/current/user-guide/).

---


# Übung 3: Banken Simulation

## Funktionsweise der Software

### **Hauptklassen**

#### **<ins>Account</ins>**

Hier werden die grundlegende Eigenschaften und Methoden eines Kontos definiert:

- Attribute: ```id, balance```, ```bookings```
- Methoden: ```deposit(int date, long amount)```, ```withdraw(int date, long amount)```, ```getId()```, ```getBalance()```, ```print()``` \
Einzahlen und Zurückziehen vom Geld; Kontostand und Kontonummer bekommen.

#### **<ins>SavingsAccount</ins>** (erbt von Account)

Spezialisierte Kontoart für gespartes Guthaben:

- Methoden: ```withdraw(int date, long ammount)``` \
Guthaben prüfen, ruft Account.java wenn genügend Guthaben, verhindert Abhebungen wenn nicht.

#### **<ins>SalaryAccount</ins>** (erbt von Account)

Konto für Gehaltseinzahlungen:

- Attribute: ```creditLimit``` -> Kreditlimit des Kontos, erlaubt Überziehungen nur bis definiertem (negativen) Betrag. 
- Methoden: ```withdraw(int date, long amount)``` \
Berechnet Guthaben nach Abhebung, verhindert falls Limit überschritten, ruft Account.java wenn Bedingung erfüllt.

#### **<ins>PromoYouthSavingsAccount</ins>** (erbt von SavingsAccount)

Jugend-Sparkonto mit Promotionen:

- Methoden: ```deposit(int date, long amount)``` \
Bei Einzahlungen wird ein Bonus von 1% des Betrags gewährt.

#### **<ins>Bank</ins>**

Verwaltung einer Sammlung von Konten:

- Attribute: ```accounts``` (verwaltet Konten), ```nextAccountId``` (automatisch generierte Id für neue Konten) 
- Methoden:
    - Kontoerstellung: ```createSavingsAccount()```, ```createPromoYouthAccount()```, ```createSalaryAccount(long creditLimit)``` \
      Jegliche Konten werden erstellt. 

    - Transaktionen: ```deposit(String id, int date, long amount)```, ```withdraw(String id, int date, long amount)``` \
      Führt Einzahlungen & Abhebungen auf/von einem Konto. 
      
    - Saldo-Abfragen: ```getBalance()```, ```getBalance(String id)``` \
      Gesamter oder spezifischer Kontostand zurückgeben. 
      
    - Kontodruck: ```print(String id)```, ```print(String id, int year, int month)```, ```printTop5()```, ```printBottom5()``` \
      Kontoauszug eines spezifischen Kontos oder nur für bestimmten Monat, fünf Konten mit dem höchsten/niedrigsten Saldo zurückgeben. 
      
#### **<ins>Booking</ins>**

Repräsentiert eine Buchung:

- Attribute: ```date```, ```amount``` 
- Methoden: ```Booking(int date, long amount)```, ```getDate()```, ```getAmount()```, ```print(long balance)``` \
  Buchung erstellen, Datum / Betrag einer Buchung zurückgeben, Buchungzeile mit akutellem Saldo drucken.

#### **<ins>BankUtils</ins>**

Dienstprogrammklasse mit hilfreichen Funktionen:

- Attribute: ```TWO_DIGIT_FORMAT```, ```AMOUNT_FORMAT```
- Methoden: ```formatBankDate(int date)```, ```formatAccount(long amount)``` \
  formatiert Banktag-Datum (basiert auf Anzahl Tage seit 1.1.1970), formatiert lesbaren Betrag.

### **Beziehungen**

- Vererbungen: ```SavingsAccount```, ```SalaryAccount```, ```PromoYouthSAvingsAccount``` erben von ```Account```
- Komposition: ```Bank``` enthält mehrere ```Account```-Objekte, ```Account```-Objekte können mit ```Booking```-Objekten verknüpft sein



