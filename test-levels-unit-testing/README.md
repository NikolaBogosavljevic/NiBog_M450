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
