### Resumen del Proyecto

El proyecto es un sistema de gestión para un centro deportivo que permite manejar tanto las personas que trabajan en el centro como las actividades que se ofrecen. Además, integra una base de datos MariaDB para almacenar y gestionar la información de manera persistente.

### Funcionalidades Principales

- **Manejo de Personas:**
  - Registro, eliminación y actualización de entrenadores, gerentes, recepcionistas y usuarios.
  - Se pueden ingresar datos como nombre, edad, DNI, número de empleado, antigüedad, horario, departamento, idiomas (en el caso de los recepcionistas), peso, altura y plan de entrenamiento.

- **Manejo de Actividades:**
  - Creación de clases de yoga, bodypump y ciclismo.
  - Añadir personas a clases.
  - Comprobar el aforo de las clases.

- **Base de Datos MariaDB:**
  - Integración de una base de datos MariaDB para almacenar la información de personas y actividades de manera persistente.
  - Utiliza consultas SQL para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la base de datos.

### Uso del Sistema

El sistema cuenta con un menú principal desde el cual se puede acceder a las funcionalidades de manejo de personas y actividades. Utiliza la entrada estándar para recibir datos de usuario, como nombre, edad, etc., y ofrece opciones para realizar acciones como registrar, eliminar o actualizar información. La información ingresada se almacena en la base de datos MariaDB para su posterior recuperación y gestión.

### Tecnologías Utilizadas

El proyecto está desarrollado en Java y utiliza clases y enumeraciones para representar las personas que trabajan en el centro deportivo y las actividades que se ofrecen. La base de datos MariaDB se integra mediante consultas SQL utilizando JDBC (Java Database Connectivity). La entrada de datos se realiza a través de la consola con la ayuda de la clase `Scanner`.

### Notas de Uso

- Es importante asegurarse de ingresar la información correctamente según las indicaciones proporcionadas por el sistema para evitar errores.
- Se debe prestar atención a la entrada de datos, especialmente al ingresar números de empleado, DNI y otros identificadores únicos, para garantizar la integridad de la información almacenada en la base de datos.
