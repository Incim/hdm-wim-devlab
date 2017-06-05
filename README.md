# hdm-wim-devlab

*Hinweis: Bei diesem Projekt handelt es sich um ein Forschungsprojekt der Hochschule der Medien, Stuttgart.*


## Spielregeln

* Jede Gruppe hat ein eigenes Verzeichnis.
* Jede Gruppe stellt einen oder mehrere Microservices bereit. Jede Gruppe ist damit selbst für die eigene Systemumgebung verantwortlich.
* Entwickelt wird eine Event Driven Architecture. Die Kommunikation findet über Messages statt.
* Diese Events werden mittels [Google PubSub](https://cloud.google.com/pubsub/docs/overview) übermittelt.

### Google PubSub

* Zugriff auf die Funktionen Senden & Empfangen kann über folgenden [GitHub Issue](https://github.com/Purii/hdm-wim-devlab/issues/4) beantragt werden (Google Account benötigt).
* Topics können nicht selbst angelegt werden, sondern müssen ebenfalls über einen [Issue](https://github.com/Purii/hdm-wim-devlab/issues/new) beantragt werden.
* Für PubSub wird eine [ausführliche Dokumentation](https://cloud.google.com/pubsub/docs/reference/libraries) bereitgestellt. Die Dokumentation der SDK findet sich [hier](http://googlecloudplatform.github.io/google-cloud-java/0.18.0/apidocs/index.html) (Package: com.google.cloud.pubsub.spi.v1)
