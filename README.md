# 💱 Currency Converter

**(November 2023) This project was developed to explore the usage of microservices architecture.**

**Currency Converter** is a microservices-based currency conversion application built using **Java Spring Boot, Maven, and Frontend Technologies (HTML, CSS, JavaScript)**. Users can convert between different currencies seamlessly.

## 🚀 Project Overview

- **Frontend (Client):** A user-friendly interface for currency conversion.
- **Backend (Microservices):**
  - `dolar_euro`: USD to EUR conversion service
  - `tl_usd`: Turkish Lira to USD conversion service
  - `tl_euro`: Turkish Lira to EUR conversion service
  - `gateway`: API Gateway managing all microservices

📌 API Usage

All microservices can be accessed through the API Gateway. For example:
GET http://localhost:8080/convert?from=USD&to=EUR&amount=100
This request will return the equivalent amount of 100 USD in EUR.
