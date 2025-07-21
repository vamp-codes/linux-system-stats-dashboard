# Linux System Stats Dashboard

A local web dashboard built with Spring Boot and OSHI that displays real-time Linux system stats like CPU, memory, disk, uptime, and more.

---

## Tech Stack

- **Backend:** Java, Spring Boot
- **System Info:** [OSHI](https://github.com/oshi/oshi)
- **Frontend:** HTML, CSS, JavaScript
- **Build Tool:** Maven

---

## Features

-  CPU, memory, and disk usage
- Battery status
-  Network stats
- Running processes (WIP)
-  Hostname, kernel, distro
- Uptime display

---

### Prerequisites
- Java 17+
- Maven
- Git

### Clone and Run

```bash
git clone https://github.com/vamp-codes/linux-system-stats-dashboard.git
cd linux-system-stats-dashboard
mvn spring-boot:run
