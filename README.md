# Práctica Tema 2: Interfaz con Kotlin & Compose Desktop

## 1. Qué he hecho
He replicado la ventana que pedía el ejercicio para mostrar 3 tarjetas de contacto o perfil en vertical. Para no dejarlo tan plano, le di un toque propio a cada una:
- Cada tarjeta tiene su propio avatar circular con un borde de color diferentes.
- El nombre va en negrita y el rol/puesto tiene un color personalizado.
- He metido la línea divisoria horizontal (`HorizontalDivider`) que pedía la tarea.
- He puesto correos y localidades de Mallorca para que no fuera todo texto genérico de prueba.

## 2. Cómo lo he hecho
- **Modelo de datos (`data class Perfil`)**: En vez de picar a mano los textos tres veces, me creé una clase para guardar los datos de cada persona (nombre, rol, correo, ciudad, su imagen y los colores de acento).
- **Componente reutilizable (`TarjetaPerfil`)**: Creé una función `@Composable` que recibe el perfil por parámetro y dibuja la tarjeta completa.
- **Estructura y layouts**:
    - `Column` principal con `Arrangement.spacedBy(16.dp)` para que las 3 tarjetas se separen solas sin meter huecos raros a mano. Además le añadí `verticalScroll` por si se abre en una pantalla más pequeña.
    - Dentro de cada `Card` usé una `Row` para alinear la imagen a la izquierda y la info a la derecha.
    - Una `Column` dentro de la fila para ordenar los textos y el separador.
- **Modifiers clave**:
    - `size(...)`, `clip(CircleShape)` y `border(...)` para dejar los avatares redondos y con borde.
    - `weight(1f)` en la columna de texto para que aproveche todo el espacio libre de la tarjeta a lo ancho.
    - `padding` en los contenedores para que no quede todo pegado a los bordes.

## 3. Por qué lo he hecho de esta forma
- **Código limpio y escalable**: En Compose no tiene mucho sentido repetir código estático. Separando la tarjeta en su propio `@Composable` y pasando los datos mediante el modelo, si el día de mañana me piden mostrar 20 personas por ejemplo, la interfaz sigue sirviendo exactamente igual.
- **Experimentación visual**: Aproveché los parámetros de los componentes de Material 3 y los `Modifier` para jugar con los colores, que además era uno de los puntos que se valoraban en la corrección.