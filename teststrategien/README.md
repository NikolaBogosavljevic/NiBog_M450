## **Übung 1: Testfälle für Verkaufssoftware**

### **Abstrakte Testfälle**

| ID  | Bedingung                        | Erwartetes Resultat         |
|-----|----------------------------------|-----------------------------|
| 1   | Preis < 15'000 CHF               | Kein Rabatt                 |
| 2   | 15'000 CHF ≤ Preis ≤ 20'000 CHF  | 5% Rabatt                   |
| 3   | 20'000 CHF < Preis < 25'000 CHF  | 7% Rabatt                   |
| 4   | Preis ≥ 25'000 CHF               | 8.5% Rabatt                 |

### **Konkrete Testfälle**

| ID  | Preis (CHF)  | Erwarteter Rabatt (%) | Berechneter Preis (CHF) |
|-----|--------------|------------------------|--------------------------|
| 1   | 14'999       | 0%                     | 14'999                   |
| 2   | 18'000       | 5%                     | 17'100                   |
| 3   | 22'500       | 7%                     | 20'925                   |
| 4   | 27'000       | 8.5%                   | 24'705                   |

---

## **Übung 2: Funktionale Black-Box Tests für eine Autovermietungs-Webseite**

### **Tabelle der Testfälle**

| ID | Beschreibung                                    | Erwartetes Resultat                              | Effektives Resultat | Status  | Mögliche Ursache         |
|----|------------------------------------------------|-------------------------------------------------|----------------------|---------|--------------------------|
| 1  | Benutzer kann sich erfolgreich registrieren    | Erfolgreiche Registrierung                      |                      |         |                          |
| 2  | Verfügbare Autos für gewähltes Datum anzeigen  | Liste der verfügbaren Autos wird korrekt angezeigt |                      |         |                          |
| 3  | Buchung eines Autos mit korrekten Daten        | Erfolgreiche Buchung                            |                      |         |                          |
| 4  | Fehlermeldung bei ungültiger Kreditkarte       | Fehlermeldung "Ungültige Kreditkarte"           |                      |         |                          |
| 5  | Benutzer kann eine bestehende Buchung stornieren | Erfolgreiche Stornierung                       |                      |         |                          |

---

# Aufgabe 3: Testfälle und Verbesserungsvorschläge

## **Black-Box Testfälle**

| ID | Beschreibung                                  | Erwartetes Resultat                              |
|----|----------------------------------------------|-------------------------------------------------|
| 1  | Konto erstellen                              | Neues Konto wird mit Startguthaben erstellt     |
| 2  | Geld einzahlen                               | Kontostand erhöht sich um den Einzahlungsbetrag |
| 3  | Geld abheben, wenn Guthaben ausreichend      | Kontostand verringert sich um den Abhebebetrag  |
| 4  | Geld abheben, wenn Guthaben nicht ausreichend| Fehlernachricht "Kontostand zu niedrig"         |
| 5  | Wechselkurs abfragen                         | Korrekte Umrechnung des Betrags in Zielwährung  |

## **White-Box Testfälle**

| ID | Methode                       | Beschreibung                                                    |
|----|-------------------------------|-----------------------------------------------------------------|
| 1  | `Account.deposit(double)`     | Testet die Logik für Einzahlungen                               |
| 2  | `Account.withdraw(double)`    | Testet, ob Abhebungen korrekt durchgeführt oder abgelehnt werden|
| 3  | `Bank.getAccount(int)`        | Testet, ob das richtige Konto basierend auf der ID zurückgegeben wird |
| 4  | `ExchangeRateOkhttp.getExchangeRate(String, String)` | Testet die Abfrage und Verarbeitung von Wechselkursdaten |
| 5  | `Counter.transferAmount(Account, Account)` | Testet die korrekte Überweisung zwischen zwei Konten           |

## **Verbesserungsvorschläge**

1. **Fehlermanagement verbessern:**  
   Beispielsweise sollten spezifische Fehlermeldungen wie `AccountExeption` klarer strukturiert werden.
   
2. **Modularisierung und Wiederverwendung:**  
   Reduzieren Sie redundante Methodenaufrufe in der `Counter`-Klasse.
   
3. **Automatisierte Tests:**  
   Verwenden Sie Frameworks wie JUnit, um Unit-Tests für Methoden wie `withdraw`, `deposit` und `getExchangeRate` zu schreiben.

4. **Dokumentation:**  
   Methoden wie `createAccount` in der `Bank`-Klasse sollten besser dokumentiert werden.

5. **Testautomatisierung:**  
   Implementieren Sie automatisierte Tests mit Mocking für externe Abfragen in der Klasse `ExchangeRateOkhttp`.
