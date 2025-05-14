# 🛵🚗PROGRAMA DE ALQUILER DE VEHÍCULOS🚗🛵

## 📑 Índice

- [🎤 Presentación del proyecto](#-presentación-del-proyecto)
- [📌 Planteamiento del programa](#-planteamiento-del-programa-reserva_vehículos)
- [🧩 Plugin PlantUML en IntelliJ](#-plugin-plantuml-en-intellij)
- [🛠 Evolución del diseño UML](#-evolución-del-diseño-uml-en-plantuml)
- [💻 Código base en Java](#-código-base-desarrollado-a-partir-de-los-diagramas-de-plantuml)
- [📚 Clase Accesorio](#-clase-accesorio)
- [🔧 Clase Mantenimiento](#-clase-mantenimiento)
- [👤 Clase Usuario](#-clase-usuario)
- [🔗 Clase Usuario-Vehículo](#-clase-usuario-vehículo)
- [🚗 Clase Vehículo](#-clase-vehículo)
- [🧷 Clase Vehículo-Accesorio](#-clase-vehículo-accesorio)
- [🧪 Programa ejecutándose](#-programa-ejecutándose-en-intellij)
- [💡 ¿Cómo funciona?](#cómo-funciona)
- [🛑 Mejoras posibles](#-mejoras-posibles)

![Java](https://img.shields.io/badge/language-Java-blue)
![IntelliJ IDEA](https://img.shields.io/badge/IDE-IntelliJ%20IDEA-orange)
![PlantUML](https://img.shields.io/badge/diagramming-PlantUML-brightgreen)
---

## 🎤 Presentación del proyecto

Vamos a presentar nuestro proyecto titulado **“Sistema de Reservas de Vehículos”**, desarrollado como práctica para el módulo de *Entornos de Desarrollo* en 1º de DAM.

### 📌 Planteamiento del programa: Reserva_Vehículos

Comenzamos con un **planteamiento básico del sistema**, donde definimos las necesidades principales: gestionar usuarios, vehículos, sus reservas, y elementos relacionados como los accesorios o el mantenimiento.  
Para el diseño inicial utilizamos **PlantUML**, integrado directamente en IntelliJ IDEA, lo que nos permitió crear los diagramas UML de clases de forma visual y sincronizada con el código.

### 🧩 Plugin PlantUML en IntelliJ

Usamos el **plugin PlantUML dentro de IntelliJ IDEA** para generar y visualizar los diagramas UML directamente desde nuestro código fuente.  
Esto nos permitió mantener los diagramas actualizados en tiempo real y asegurarnos de que la estructura del código coincidía con el diseño previsto.

### 🛠 Evolución del diseño UML en PlantUML

En las siguientes fases del desarrollo, fuimos **refinando nuestro modelo UML**.  
Mejoramos progresivamente las relaciones entre las clases y clarificamos sus responsabilidades: desde los usuarios hasta los vehículos y sus componentes.  
Este proceso continuo nos ayudó a evitar errores de diseño antes de implementar la lógica del sistema.

### 💻 Código base desarrollado a partir de los diagramas de PlantUML

Una vez definido el modelo UML, lo utilizamos como **base para el desarrollo del código en Java**.  
Aunque PlantUML no genera código automáticamente, nos permitió tener una referencia clara de qué clases, atributos y métodos debíamos implementar, lo cual organizó mejor el desarrollo.

### 📚 Clase Accesorio

La clase `Accesorio` representa todos los elementos extra que se pueden añadir a un vehículo, como sillas infantiles, dispositivos GPS o cofres portaequipajes.  
Contiene información como el nombre, la descripción y el coste adicional del accesorio.

### 🔧 Clase Mantenimiento

La clase `Mantenimiento` gestiona todo lo relacionado con el mantenimiento de los vehículos: cambios de aceite, revisiones técnicas, reparaciones, etc.  
Nos permite llevar un registro histórico del estado de cada vehículo.

🧩 **Relación con la clase `Vehículo`**:  
- **Tipo**: **Composición**  
- **Explicación**: Los mantenimientos están fuertemente ligados a un vehículo específico. Si eliminamos el vehículo, sus registros de mantenimiento también pierden sentido. Por eso es una relación fuerte.

### 👤 Clase Usuario

Esta clase define a los `Usuarios` del sistema. Incluye sus datos personales, credenciales de acceso y, posiblemente, su rol (como cliente o administrador).  
Desde esta clase se gestionan el registro, el inicio de sesión y el historial de reservas del usuario.

### 🔗 Clase Usuario-Vehículo

La clase `Usuario-Vehículo` modela la **relación entre usuarios y vehículos**.

🧩 **Relación con `Usuario` y `Vehículo`**:  
- **Tipo**: **Asociación muchos a muchos**  
- **Explicación**: Un usuario puede reservar varios vehículos, y un mismo vehículo puede ser reservado por varios usuarios. Esta clase intermedia permite registrar, por ejemplo, las fechas de reserva o el historial de uso.

### 🚗 Clase Vehículo

Esta es una de las clases principales del sistema. Cada objeto representa un vehículo disponible para reservar, con atributos como matrícula, modelo, tipo, disponibilidad o precio.  
Es el eje central del sistema.

🧩 **Relación con `Mantenimiento`**: Composición (como vimos antes)  
🧩 **Relación con `Accesorio`**: Se explica en la siguiente diapositiva.

### 🧷 Clase Vehículo-Accesorio

Esta clase gestiona la relación entre los vehículos y los accesorios que pueden llevar.

🧩 **Relación con `Vehículo` y `Accesorio`**:  
- **Tipo**: **Agregación**  
- **Explicación**: Los accesorios pueden asignarse o eliminarse de los vehículos sin que ninguno de los dos desaparezca. Ambos existen por separado. Esta clase representa una relación flexible, típica de la agregación.

### 🧪 Programa ejecutándose en IntelliJ

Finalmente, mostramos una captura del programa funcionando en **IntelliJ IDEA**, que ha sido nuestro entorno principal de desarrollo.  
Aquí puede verse el resultado final, con las clases implementadas y el sistema de reservas funcionando correctamente.

---

## 💡¿Cómo funciona?💡
Este programa tiene **6 opciones** al iniciarlo:
1. Ver catálogo.
2. Registrar otro vehículo.
3. Registrar mantenimiento.
4. Alquilar vehículo.
5. Mostrar todos los alquileres.
6. Finalizar el sistema.

---

### OPCIÓN 1️⃣: Ver catálogo 📖.

Muestra el catálogo de vehículos disponibles con sus datos. Esta opción hace uso de la función **verCatálogo** de la clase Vehículo.

---

### OPCIÓN 2️⃣: Registrar otro vehículo ➕🚗🛵.

Introduce un nuevo vehículo en el catálogo. Esta opción hace uso de la función **agregarVehículo** de la clase Vehículo.

Al registrar un nuevo vehículo en el sistema, se deben cumplir las siguientes condiciones:

| 🏷️ **Campo**              | 🔍 **Validación requerida**                                                                 |
|---------------------------|---------------------------------------------------------------------------------------------|
| **Matrícula**             | Debe tener **4 números** seguidos de **3 letras** (Ejemplo: `1234ABC`)                      |
| **Número de bastidor**    | Debe tener exactamente **5 dígitos numéricos** (Ejemplo: `12345`)                           |
| **Año de matriculación**  | Debe ser **2020 o posterior**, para cumplir con normativas de zonas de bajas emisiones      |
| **Modelo**                | Texto libre (Ejemplo: `Toyota Yaris`, `BMW X5`, etc.)                                       |
| **Tipo de vehículo**      | Debe ser **"coche" o "moto"** (otros tipos no están disponibles en la agencia)              |
| **Disponibilidad**        | Se registra automáticamente como disponible al crearlo (puede omitirse en la interfaz)     |
| **Precio por día**        | *(Opcional pero recomendable)* Añadirlo permite mostrarlo en el catálogo y calcular alquileres  |

---

### OPCIÓN 3️⃣: Registrar mantenimiento ➕👷‍🔧.

Registra un mantenimiento y lo asocia a un vehículo para asegurar que el vehículo está en óptimas condiciones antes de que un cliente lo alquile.

Esta opción hace uso de la función **addMantenimiento** de la clase Mantenimiento. Esta función agrega un número identificador del mantenimiento y una fecha en formato AAAA-MM-DD.

También utiliza la función **asociarMantenimiento** de la clase Mantenimiento para asociar el mantenimiento registrado a un vehículo.

---

### OPCIÓN 4️⃣: Alquilar vehículo 🚘🏍️✍️.

Inicia un proceso para registrar a un cliente y asociarle el vehículo que desea llevarse, indicando las fechas de recogida y entrega.

Esta opción hace uso de la función **alquilarVehículo** de la clase Usuario_vehículo. Esta función realiza varias funciones:

1. Usa la función **introducirUsuario** ➕🧔🏻‍♂️👩🏻 de la clase Usuario, que se encarga de pedir:
   - Un DNI, asegurando que tenga 8 números y 1 letra.
   - Un nombre.
   - Un apellido.
   - Un número de teléfono, asegurando que tenga 9 números.

2. Muestra el catálogo de vehículos 📖 a escoger.

3. Pide una fecha de recogida 📆 del vehículo (día, mes, año).

4. Pide una fecha de entrega 📆 del vehículo (día, mes, año), asegurando que esta no sea anterior a la fecha de recogida.

5. Recoge el alquiler realizado en una **lista de alquileres** de la clase Usuario_vehículo.

6. Elimina el coche alquilado del **catálogo** de coches disponibles de la clase Vehículo.

7. Ofrece la opción de elegir accesorios:
   - Con la función **tieneAccesorio** de la clase Vehiculo_Accesorio.
   - Si se responde "s" o "sí", se ejecuta la función **seleccionAccesorio** de la clase Accesorio, que muestra un catálogo de accesorios a escoger. Esta función permite a los usuarios que han alquilado una _moto_ alquilar solamente el casco. Si se ha escogido un _coche_, se puede escoger 1 GPS, 1 baca o 1 remolque, y las sillitas de bebé, 2 como mucho.

---

### OPCIÓN 5️⃣: Mostrar todos los alquileres.

Muestra los vehículos que están alquilados y los datos del cliente que los han alquilado.

Esta opción se sirve de la función **mostrarAlquileres** de la clase Usuario_vehículo. Esta función revisa si hay alquileres realizados, y si los hay, muestra de cada uno de ellos los datos:

- Nombre del cliente.
- DNI del cliente.
- Modelo y matrícula del vehículo.
- Fecha de recogida del vehículo.
- Fecha de entrega del vehículo.

---

### OPCIÓN 6️⃣: Finalizar el sistema.

Pone fin al programa. 👋

---

## 🛠️ Mejoras posibles

- 📱 Versión gráfica con interfaz en JavaFX o Swing.
- ☁️ Persistencia de datos con archivos o bases de datos.
- 🔐 Gestión de roles: usuarios administradores y clientes con distintos permisos.
- 🔄 Disponibilidad en tiempo real al alquilar.
- 📅 Recordatorios de mantenimiento por fecha.
