# 🛵🚗PROGRAMA DE ALQUILER DE VEHÍCULOS🚗🛵
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

Introduce un nuevo vehículo en el catálogo. Esta opción hace uso de la función **agregarVehículo** de la clase Vehículo, que se encarga de pedir:
- Una matrícula, asegurando que tenga 4 números y 3 letras.

- Número de bastidor, asegurando que tenga 5 números.
- Año de matriculación, asegurando que el vehículo no sea anterior al 2020 para evitarle a nuestros clientes conflictos en zonas de bajas emisiones.
- Modelo.
- Tipo de vehículo, asegurando que sea coche o moto, ya que la agencia no dispone de otros vehículos, como furgonetas, caravanas, bicicletas eléctricas...

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
   - Si se responde "s" o "sí", se ejecuta la función **seleccionAccesorio** de la clase Accesorio, que muestra un catálogo de accesorios a escoger. Esta función permite a los usuarios que han alquilado una <u>moto</u> alquilar solamente el casco. Si se ha escogido un <u>coche</u>, se puede escoger 1 GPS, 1 baca o 1 remolque, y las sillitas de bebé, 2 como mucho.

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