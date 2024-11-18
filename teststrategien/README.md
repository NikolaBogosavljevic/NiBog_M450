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
