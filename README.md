# 🧠 Tarea Flow – Backend API
![Java](https://img.shields.io/badge/Java-17-blue.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4-green.svg)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue.svg)
![Arquitectura](https://img.shields.io/badge/Hexagonal-CleanArchitecture-critical)
![Estado](https://img.shields.io/badge/Estado-En%20desarrollo-yellow)

> [!TIP]
> Este proyecto es ideal para comprender en profundidad cómo funciona la autenticación y la estructura de un backend profesional **sin depender de configuraciones automáticas.**

> [!WARNING]
> No se utiliza Spring Security. Todo el sistema de autenticación y autorización está construido manualmente para tener control total y aprender desde la base.

> 🔧 Backend para **Tarea Flow**, una app moderna de gestión de tareas estilo Trello. Diseñado desde cero para aprender buenas prácticas de arquitectura, autenticación manual con JWT y seguridad realista.

---

## ⚙️ Tecnologías clave

- ✅ **Java 17**
- ✅ **Spring Boot 3.4**
- ✅ **Arquitectura Hexagonal** (puertos y adaptadores)
- ✅ **PostgreSQL** con `pgcrypto` para generación automática de UUID
- ✅ **Control total sobre la autenticación con JWT**
- ✅ **Hashing de contraseñas manual** con `MessageDigest` (SHA-256)
- ✅ **Sistema de roles básico** (usuario individual / empresa)
- ✅ **Sin Spring Security**: seguridad completamente implementada desde cero

---

## 🔐 Autenticación personalizada

El backend implementa:

- Generación de tokens JWT al iniciar sesión
- Verificación de tokens en cada petición protegida
- Hashing de contraseñas manual
- Protección de rutas a través de filtros propios

---

## 📦 Estructura del proyecto

El backend sigue **arquitectura hexagonal**, separando bien las capas:

