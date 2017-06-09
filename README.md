# hdm-wim-devlab

*Hinweis: Bei diesem Projekt handelt es sich um ein Forschungsprojekt der Hochschule der Medien, Stuttgart.*

* [Spielregeln](#spielregeln)
* [Google PubSub](#google-pubsub)
    * [Grundlegende Kommunikation](#grundlegende-kommunikation)
    * [Aktuell existierende Topics](#aktuell-existierende-topics)
    * [Felder einer PubSub Message](#felder-einer-pubsub-message)
        * [`attributes`](#attributes)
        * [Event Type](#event-type)
        * [Event Source](#event-source)
        * [Message Konstruktor](#message-konstruktor)
        

## Spielregeln

* Jede Gruppe hat ein eigenes Verzeichnis.
* Jede Gruppe stellt einen oder mehrere Microservices bereit. Jede Gruppe ist damit selbst für die eigene Systemumgebung verantwortlich.
* Entwickelt wird eine Event Driven Architecture. Die Kommunikation findet über Messages statt.
* Diese Events werden mittels [Google PubSub](https://cloud.google.com/pubsub/docs/overview) übermittelt.

## Google PubSub

* Zugriff auf die Funktionen Senden & Empfangen kann über folgenden [GitHub Issue](https://github.com/Purii/hdm-wim-devlab/issues/4) beantragt werden (Google Account benötigt).
* Topics können nicht selbst angelegt werden, sondern müssen ebenfalls über einen [Issue](https://github.com/Purii/hdm-wim-devlab/issues/new) beantragt werden.
* Für PubSub wird eine [ausführliche Dokumentation](https://cloud.google.com/pubsub/docs/reference/libraries) bereitgestellt. Die Dokumentation der SDK findet sich [hier](http://googlecloudplatform.github.io/google-cloud-java/0.18.0/apidocs/index.html) (Package: com.google.cloud.pubsub.spi.v1)

### Grundlegende Kommunikation
![PubSub Workflow](https://github.com/Purii/hdm-wim-devlab/blob/master/assets/26975555-9a009aa6-4d20-11e7-98c3-f6268862762d.jpg)

* **Gruppe:** jeweiliges Team
* **Message:** von allen zu verwenden aus der SharedLib, siehe [Message Klasse](https://github.com/Purii/hdm-wim-devlab/blob/master/SharedLib/src/main/java/de/hdm/wim/sharedLib/classes/Message.java)
* **AppEngine:** erzeugt Publisher und Subscriber automatisch (wird durch Event-Gruppe zur Verfügung gestellt), Publisher kreieren eine PubSubMessage und versenden diese über PubSub im angegebenen Topic (Achtung: Topics sind Konstanten, einzusehen in dieser [Klasse](https://github.com/Purii/hdm-wim-devlab/blob/master/SharedLib/src/main/java/de/hdm/wim/sharedLib/Constants.java))
* **PubSub:** verteilt PubSubMessages durch die Topics
* **Publish:** Eine Message wird in das eingetragene Topic veröffentlicht, siehe [Message Klasse](https://github.com/Purii/hdm-wim-devlab/blob/master/SharedLib/src/main/java/de/hdm/wim/sharedLib/classes/Message.java)
* **Subscribe:** Mehrere PubSubMessages werden aus dem eingetragenen Topic als Stream übertragen, siehe [PubSubMessage Klasse](https://github.com/Purii/hdm-wim-devlab/blob/master/SharedLib/src/main/java/de/hdm/wim/sharedLib/classes/PubSubMessage.java)

***Bitte die Vorgaben für die Klassen aus der SharedLib einhalten!***
***Topics können in den Issues beantragt werden!***

### Aktuell existierende Topics

[Topics](https://github.com/Purii/hdm-wim-devlab/blob/master/SharedLib/src/main/java/de/hdm/wim/sharedLib/Constants.java), die genutzt werden:

* FeedbackGui
* Insights (User klickt mehrfach auf denselben Dokumentvorschlag; Favoriten des Users)
* Offers (Vorschläge)
* SessionInsights (User loggt sich ein/aus; User ist passiv)
* RichTokens (SR > CEP)
* Tokens (ST > SR)
* Training (CEP > ML) ?

### Felder einer PubSub Message

Über PubSub werden Messages versendet. Folgende Felder dienen dabei als [Grundlage](https://cloud.google.com/pubsub/docs/reference/rest/v1/PubsubMessage):

| Feld  | Datentyp | Beschreibung |
| :------------ | :---------------: | ------------ |
| `data` | `string (bytes format)` | Frei definierbar durch Gruppe. Beispiele: Dokumentenvorschläge, Tokens,.. |
| `attributes` | `map (key: string, value: string)` | Metadaten, Beispiele sind: `eventSource`, `eventType` |
| `messageId` | `string` | Wird durch PubSub Server hinzugefügt |
| `publishTime` | `string (Timestamp format)` | Timestamp im RFC3339 UTC "Zulu" Format (Genauigkeit in Nanosekunden). Beispiel: `2014-10-02T15:01:23.045123456Z` |

#### `attributes`
Relevant ist für uns neben dem Feld `data` das Feld `attributes`.
Die einzelnen Attribute werden anhand von Keys identifiziert.
Dazu sind die vordefinierten Konstanten der Datei [`sharedLib/Constants.java`](https://github.com/Purii/hdm-wim-devlab/blob/master/SharedLib/src/main/java/de/hdm/wim/sharedLib/Constants.java#L14) zu verwenden.
Diese können nach Bedarf erweitert werden.

#### Event Type

Event Type spezifiziert die grundlegenden Eigenschaften einer Message. 

| `EventType`  | Beschreibung | Topic |
| :------------ | --------------- | --------------- |
| StayAlive | Heartbeat von GUI Clients | SessionInsights |
| Insight | User klickt mehrfach auf ein Dokumente | Insights |
| GoogleOffer | Vorschlag zur Anzeige von Google Calender, Drive,.. | Offers |
| Offer | Dokumentvorschläge | Offers |
| Training? | Feedback an ML | Training |
| Token | Einfache Tokens | Tokens |
| RichToken | Angereicherte Tokens | RichTokens |
| Feedback | Feedback des Users | FeedbackGui |

#### Event Source

Event Source beschreibt die Herkunft der Message.

| `EventSource` | Beschreibung |
| :------------ | --------------- |
| SPEECH_TOKENIZATION | Speech Tokenization |
| EVENT | Complex Event Processing |
| MACHINE_LEARNING | Machine Learning |
| USER_INTERFACE | User Interface |
| SEMANTIC_REPRESENTATION | Semantic Representation |

Causality?

### Message Konstruktor

[`Verlinkung zur Message-Klasse`](https://github.com/Purii/hdm-wim-devlab/blob/master/SharedLib/src/main/java/de/hdm/wim/sharedLib/classes/Message.java)

```java
    	/**
	 * Instantiates a new Message.
	 *
	 * @param data the data
	 * @param topic the topic
	 * @param attributes the attributes
	 */
	public Message( String data, String topic, Hashtable attributes ){
		this.data 		= data;
		this.topic 		= topic;
		this.attributes = attributes;
	}
```
