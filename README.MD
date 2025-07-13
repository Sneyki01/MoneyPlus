# 💸 MoneyPlus - Conversor de Monedas

¡Bienvenido a **MoneyPlus**! 🪙  
Tu conversor de divisas de confianza para consultar tipos de cambio en tiempo real usando la API [exchangerate-api.com](https://www.exchangerate-api.com/).

---

## 🚀 ¿Qué hace?

✅ Consulta el tipo de cambio actual entre **12 monedas populares**.  
✅ Permite ingresar un monto para hacer la conversión exacta.  
✅ Puedes hacer múltiples búsquedas en una sola sesión.  
✅ Guarda un historial de conversiones en un archivo `.txt` si lo deseas.

---

## 🌍 Monedas disponibles

| Código | Moneda               |
|--------|----------------------|
| USD    | Dólar estadounidense |
| EUR    | Euro                 |
| GBP    | Libra esterlina      |
| JPY    | Yen japonés          |
| CHF    | Franco suizo         |
| CAD    | Dólar canadiense     |
| AUD    | Dólar australiano    |
| NZD    | Dólar neozelandés    |
| CNY    | Yuan chino           |
| MXN    | Peso mexicano        |
| BRL    | Real brasileño       |
| ARS    | Peso argentino       |

---

## ⚙️ ¿Cómo usarlo?

1. **Clona el repositorio:**

    ```bash
    git clone https://github.com/Sneyki01/MoneyPlus.git
    ```

2. **Abre el proyecto en IntelliJ IDEA** (o tu IDE favorito).

3. **Ejecuta `Main.java`**

4. Sigue las instrucciones en consola:
    - Selecciona la moneda base y la moneda a cotizar.
    - Ingresa el monto a convertir.
    - Decide si deseas realizar más conversiones.
    - Al final, podrás guardar el historial de conversiones en un archivo **`historial_conversiones.txt`**.

---

## 📂 Estructura del proyecto

```Plaintext
src/
├── model/
│ └── ExchangeRateResponse.java
├── service/
│ └── ExchangeRateAPIService.java
├── utils/
│ ├── JsonParserUtil.java
│ └── XchangeRateSave.java
└── Main.java
```

---

## 🎯 Tecnologías

- **Java 21+**
- API REST con **HttpURLConnection**
- **JSON Parsing** con `Gson`
- Manejo de archivos con `FileWriter`
- Estructura modular con **Utils**, **Service**, **Model**

---

## 🏆 Créditos

Desarrollado por: Edwing Herrera - Sneyki  
Practicando buenas prácticas de programación, modularidad y experiencia de usuario para proyectos Java 🚀

---

## ✅ Mejoras a futuro

- Validación de entradas más robusta
- Soporte para más monedas
- Guardar historial con fecha y hora

---

## 📄 Licencia

Este proyecto es de uso libre para fines educativos.
