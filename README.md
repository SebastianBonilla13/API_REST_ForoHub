# API_REST_ForoHub
Desarrollo de un Foro de preguntas que ofrece una interacción textual (vía consola). CRUD de Tópicos/Temas en los que se pueden aportar Respuestas. Autenticando con JWT la sesión.

## Funcionalidades  
- Registro y autenticación de usuarios.
- CRUD de Tpicos. 
- Crear y listar Respuestas.
- Autenticación mediante JWT.
- Herramientas utilizadas:
  - **Java**  
  - **Framework Spring Boot**
  - **Spring Data JPA**
  - **PostgreSQL**
  - **HttpClient/HttpRequest**  
  - **JSON**  
  - **Insomnia/Postam**
 
  - **estructura MVC APIs REST**

## Requisitos Previos  

### 1. Instalar Java Development Kit (JDK)  
- Descargar JDK desde la página oficial:  
  [Descargar JDK](https://www.oracle.com/java/technologies/javase-downloads.html)  
- Asegúrate de tener la versión 8 o superior instalada.  

## 2. Descargar y Configurar PostGresSQL 
- Descargar e instalar PostGresSQL, en donde se creará una base de datos relacional,
- para pa ersistencia de los datos. Guardando y consultando los datos en la aplicación.
- Página oficial: https://www.postgresql.org/download/
- puerto por defecto, puerto: 5432
- Crear la base de datos: db_forohubbb

# Ejemplo de Uso  

- Ejecución del proyecto en tu IDE favorito.
- Ejecución MySQL
- Insomnia  

## Autenticación 
- Inicio sesión
  
Solicitud:
```plaintext
  POST http://localhost:8080/login
```
Body:
```plaintext
  {
    "username": "nombre_usuario",
    "password": "contraseña"
  }
```
Respuesta:
```plaintext
  {
    "jwTtoken": "token_generado"
  }
```
![image](https://github.com/user-attachments/assets/82808fd7-75e0-4174-9402-50e8318c3cc2)

## Ejemplo Solicitudes
- Crear Tópico

Agregar Token:
Activar autenticación
Token tipo: Bearer Token

![image](https://github.com/user-attachments/assets/bed3fa7f-6044-4bc4-8d37-59f399cc2274)

Solicitud:
```plaintext
  POST http://localhost:8080/topico
```
Body:
```plaintext
  { 
	"titulo": "Cómo resolver algoritmos avanzados",
	"mensaje": "Estoy teniendo problemas con los algoritmos de grafos. ¿Alguien puede ayudarme?",
	"estado": "ACTIVO",
	"idUsuario": "2",
	"curso": "Estructuras de Datos y Algoritmos"
  }
```
Respuesta:
```plaintext
  {
	"id": "11",
	"titulo": "Cómo resolver algoritmos avanzados",
	"mensaje": "Estoy teniendo problemas con los algoritmos de grafos. ¿Alguien puede ayudarme?",
	"fechaCreacion": "2025-01-21T17:06:33.004225900",
	"estado": "ACTIVO",
	"idUsuario": "2",
	"curso": "Estructuras de Datos y Algoritmos",
	"respuestas": []
  }
```
![image](https://github.com/user-attachments/assets/99ebfb24-f110-4d8f-b4b6-4eb86e75cc48)


- Listar Tópico

Solicitud:
```plaintext
  GET http://localhost:8080/topico
```
Respuesta:
```plaintext
  {
	"id": "11",
	"titulo": "Cómo resolver algoritmos avanzados",
	"mensaje": "Estoy teniendo problemas con los algoritmos de grafos. ¿Alguien puede ayudarme?",
	"fechaCreacion": "2025-01-21T17:06:33.004226",
	"estado": "ACTIVO",
	"idUsuario": "2",
	"curso": "Estructuras de Datos y Algoritmos",
	"respuestas": []
  }
```

![image](https://github.com/user-attachments/assets/9f58e12a-4357-4692-9a5f-53903f85d3a3)
