# MP03-UF2-MBM - Sistema de Vendes de Bitllets

## Descripción

Esta es una aplicación de línea de comandos desarrollada en Java y Kotlin para gestionar la venta de boletos de metro. La plataforma maneja la selección del tipo de boleto, la determinación de la zona, el procesamiento del pago y la generación de un tiquete de compra.

## Funciones Principales

### 1. Creación de Llista de Tiquets
- **Función**: `createTicketList()`
- **Descripción**: Genera y devuelve una lista de boletos con sus precios correspondientes.

### 2. Validación de Moneda
- **Función**: `isMoneyAllowed(userMoney: Double): Boolean`
- **Descripción**: Verifica la validez de la moneda o boleto introducido por el usuario.

### 3. Procesamiento del Pago
- **Función**: `payment(scanner: Scanner, price: Double): Double`
- **Descripción**: Gestiona el flujo de pago, sumando las cantidades introducidas hasta alcanzar el precio total del boleto.

### 4. Cálculo de Cambio
- **Función**: `calculateChange(money: Double, price: Double): Double`
- **Descripción**: Determina y retorna la cantidad exacta de cambio a devolver al usuario.

### 5. Selección de Tiquet y Zona
- **Funciones**:
  - `selectTicket(scanner: Scanner, ticketList: List<Ticket>): Ticket`
  - `selectZone(scanner: Scanner): Int`
- **Descripción**: Permite al usuario elegir un tipo de boleto específico y la zona correspondiente.

### 6. Finalización de la Compra
- **Funciones**:
  - `endPurchase(userCart: MutableList<CompletedPurchase>, scanner: Scanner)`
  - `printTickets(completedTickets: MutableList<CompletedPurchase>, scanner: Scanner)`
- **Descripción**: Gestiona la generación e impresión de los boletos adquiridos por el usuario.

### 7. Parada de la Máquina
- **Función**: `stopMachine(scanner: Scanner)`
- **Descripción**: Detiene el funcionamiento de la máquina de ventas utilizando una contraseña secreta como mecanismo de seguridad.

## Requisitos

- **Lenguajes**: Java, Kotlin
- **Llibreries**: Llibreries estándar de Kotlin y Java.

## Instrucciones de Ejecución

1. Asegúrate de tener configurados Java y Kotlin en tu entorno de desarrollo.
2. Compila el código fuente usando las herramientas de compilación correspondientes.
3. Ejecuta la aplicación y sigue las instrucciones en pantalla para interactuar con la máquina de ventas.

## Colaboradores

- Daniel Reinosa
- Joel Montalvan
- Nikita Barbosa

---
Esperamos que este README sea útil para comprender y utilizar el código de gestión de venta de billetes. ¡Gracias por revisar nuestro proyecto!
