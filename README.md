# Wildberries Project
Это выпускной проект из WB Techoschool. Это приложение, предназначенное для отображения митапов, проводимых в городах Российской Федерации.
## Содержание

To make it easy for you to get started with GitLab, here's a list of recommended next steps.

Already a pro? Just edit this README.md and make it your own. Want to make it easy? [Use the template at the bottom](#editing-this-readme)!

## Технологии

Основные технологии, используемые в проекте:

- Язык программирования: Kotlin 
- Архитектурный паттерн: MVVM 
- Архитектура: Clean Architecture
Библиотеки:
- Jetpack: LiveData, ViewModel, Navigation, Compose
- Retrofit: для сетевых запросов
- Coroutines: для многопоточности
- Koin: для внедрения зависимостей
- JUnit: для тестирования
-Compose: для разметки

## Функции
- Регистрация и авторизация пользователя
- Просмотр и управление списком митапов
- Работа с API для получения данных
)

## Установка
Шаги для локальной установки проекта:
1. Склонируйте репозиторий: git clone https://github.com/AndreyKreshun/WildberriesProject.git
2. Откройте проект в Android Studio.
3. Установите необходимые зависимости с помощью Gradle.
4. Запустите приложение на эмуляторе или реальном устройстве.

## Архитектура
Используется Clean Architecture
1. Presentation Layer: ViewModel
Data Layer: репозитории, источники данных (API, локальные базы данных)
Domain Layer: бизнес-логика, использование UseCases
