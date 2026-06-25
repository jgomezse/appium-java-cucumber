# Appium Java Cucumber

Proyecto de pruebas móviles automatizadas con Appium + Java + Cucumber.

App objetivo: **Swag Labs** (`com.swaglabsmobileapp`).

## Requisitos

- Java 17 Corretto
- Gradle 8.13 (wrapper incluido)
- Appium 3.5.2 con driver uiautomator2
- Node 22

## Configuración

No requiere pasos previos — el APK (`apk/sauceLabs.apk`) y las properties ya están configurados.

La configuración se carga de `src/test/resources/appium.properties`.  
Cada propiedad puede sobrescribirse individualmente por línea de comandos:
```bash
./gradlew clean test -Dappium.deviceName=otro -Dappium.appPackage=com.otra.app
```

## Ejecución local

```bash
appium                              # Iniciar Appium server
emulator -avd mobile_emulator       # Iniciar emulador
./gradlew clean test                # Smoke tests (@smoke)
```

### Ejecución por tags

```bash
./gradlew clean test -Dcucumber.filter.tags="@login"       # Solo login
./gradlew clean test -Dcucumber.filter.tags="@compra"       # Solo compra
./gradlew clean test -Dcucumber.filter.tags="@exploracion"  # Exploración de localizadores
```

## Reportes

```bash
./gradlew clean test
# Cucumber HTML → build/reports/cucumber/cucumber.html
# Allure        → allure serve build/allure-results
```

## CI (GitHub Actions)

El workflow en `.github/workflows/appium-tests.yml` se ejecuta:
- Automáticamente al hacer push a `main`
- Manualmente desde la pestaña **Actions** → `workflow_dispatch`

Sube como artefacto `cucumber-report` (`cucumber.html`).

## Estructura

```
├── .github/workflows/appium-tests.yml
├── apk/sauceLabs.apk
├── build.gradle
└── src/test/
    ├── java/com/appium/
    │   ├── config/     → AppiumConfig, CapabilitiesConfig
    │   ├── pages/      → BasePage
    │   ├── hooks/      → Hooks (@Before/@After)
    │   ├── runner/     → TestRunner (JUnit 5 Suite)
    │   ├── steps/      → Steps de Cucumber
    │   └── features/   → Archivos .feature
    └── resources/
        └── appium.properties
```
