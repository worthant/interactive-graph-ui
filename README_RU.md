<!-- Вот основной логотип и имя вашего проекта -->

<p align="center">
  <a href="resources/MVC.png">
    <picture>
      <img src="resources/logo.png" height="200">
    </picture>
    <h1 align="center">
        Интерактивный граф на JSF
        <a aria-label="Перевод" href="./README.md">
            <img alt="" src="https://img.shields.io/badge/translation-EU-red?style=for-the-badge">
        </a>
    </h1>
  </a>
</p>

<!-- Вот несколько классных меток для вашего проекта, удалите те, которые вам не нужны -->

<p align="center">
  <a aria-label="WildFly Version" href="https://www.wildfly.org/">
      <img alt="" src="https://img.shields.io/badge/WildFly-26.13-50FA7B?style=for-the-badge&labelColor=000000&color=50FA7B">
   </a>
   <a aria-label="Java" href="https://www.jetbrains.com/">
      <img alt="" src="https://img.shields.io/badge/Java-17.0.8-FFD300?style=for-the-badge&labelColor=000000&color=FFD300">
   </a>
   <a aria-label="Maven Project" href="https://maven.apache.org/">
      <img alt="" src="https://img.shields.io/badge/Maven-Project-FFA5FF?style=for-the-badge&labelColor=000000&color=FFAFFF">
   </a>
   <a aria-label="JavaServer Faces Framework" href="https://www.oracle.com/java/technologies/javaserverfaces.html">
      <img alt="" src="https://img.shields.io/badge/JSF-Framework-orange?style=for-the-badge&logo=java&labelColor=000000&color=FFFFFF">
   </a>
   <a aria-label="Tailwind CSS Version" href="https://tailwindcss.com/">
      <img alt="" src="https://img.shields.io/badge/Tailwind_CSS-3.3.3-00CCFF?style=for-the-badge&labelColor=000000&color=00FFFF">
   </a>
</p>

<details open>
   <summary><b>Содержание</b></summary>

- [Демонстрация](#demo)
- [Описание](#descr)
- [Технические требования](#requirements)
- [Темы для подготовки к лабораторной защите](#defense)
- [Как использовать мой проект](#user-manual)
- [Теоретические материалы](#theory)

</details>

<a id="demo"></a>

## Демонстрация 🎥

| Видео на youtube |
|------------------------|
|https://youtu.be/ny15aofvGCI|

<a id="descr"></a>

## Описание 📝

> 👋 **Добро пожаловать в этот лабораторный проект!**
>
> 🛠 **Что это такое?**  
> Это современное веб-приложение, построенное на фреймворке `JavaServer Faces`. В его архитектуре используются `2 facelets-шаблона` для гибкости и модульности. Стартовая страница предоставляет общую информацию и перенаправляет на основную страницу с функциональностью. Серверная логика реализована с помощью `Managed Beans`, обеспечивая гибкую и масштабируемую обработку данных.
>
> 🎯 **Цель сайта**  
> Сделать процесс ввода координат точек и проверки их попадания в заданную область максимально удобным и интуитивно понятным. Мой `UI` был разработан с упором на хороший `UX` 😎
>
> ---
>
> 📌 **Основные функции**
>
> - 🖥 **Интерактивный Ввод Данных**: Используйте интуитивно понятные элементы интерфейса для ввода координат.
> - 📊 **Динамический График**: Визуализация области и точек на координатной плоскости в реальном времени.
> - 🔒 **Валидация на Сервере**: С помощью Managed Beans обеспечивается надежная проверка введенных данных.
>
> ---
>
> 🚀 **Хотите узнать больше?** [Ознакомьтесь с руководством пользователя](#user-manual) и погрузитесь в удивительный мир этого веб-приложения! 💻

<a id="requirements"></a>

## Технические требования

|![graph](resources/graph.png)|
|-----------------------------|

### Цель: Разработать веб-приложение на базе JavaServer Faces Framework

#### 📋 Основные части приложения

- [x] `Managed Beans`: Управляемые бины, которые содержат логику обработки данных на стороне сервера.
- [x] `index.xhtml`: Стартовая страница, содержащая общую информацию и перенаправляющая на основную страницу.
- [x] `main.xhtml`: Основная страница приложения с веб-формой для ввода координат и отображения результатов.

#### 🎨 Стартовая страница `index.xhtml` должна включать

1. [x] Шапка: ФИО, номер группы, номер варианта.
2. [x] Интерактивные часы: Показывают текущие дату и время, обновляются раз в 10 секунд
3. [x] Ссылка: позволяет перейти на основную страницу приложения

#### 📊 Основная страница `main.xhtml` должна включать

1. [x] Набор компонентов: Для задания координат точки и радиуса области в соответствии с вариантом задания. Может потребоваться использование дополнительных библиотек компонентов - [ICEfaces](http://www.icesoft.org/java/projects/ICEfaces/overview.jsf) (префикс "ace") и [PrimeFaces](http://www.primefaces.org/) (префикс "p").
    - [x] Форма: Отправляет данные на сервер через Managed Beans.
    - [x] Набор полей: Для задания координат точки и радиуса области.
2. [x] Валидацию: JavaScript- или JSF-валидация введенных данных.
3. [x] 🟠 Интерактивный Элемент:
    - [x] Динамическая визуализация результатов на графике.
    - [x] Обновление графика после каждого запроса.
    - [x] Адаптивный график, который меняет свое состояние в зависимости от выбранного радиуса.
    - [x] Цвет точек должен зависить от факта попадания / непопадания в область.
4. [x] Результаты: Таблицу с результатами предыдущих проверок, хранящихся в Managed Bean.
5. [x] Ссылку, позволяющую вернуться на стартовую страницу

#### Дополнительные требования к приложению:

- [x] Все результаты проверки должны сохраняться в базе данных под управлением PostgreSQL.
- [x] Для доступа к БД необходимо использовать ORM EclipseLink.
- [x] Для управления списком результатов должен использоваться Session-scoped Managed Bean.
- [x] Конфигурация управляемых бинов должна быть задана с помощью параметров в конфигурационном файле.
- [x] Правила навигации между страницами приложения должны быть заданы в отдельном конфигурационном файле.

#### 🌐 Развертывание

- [x] Разработанное веб-приложение должно быть развёрнуто на сервере `WildFly` в standalone-конфигурации, порты должны быть настроены в соответствии с выданным `portbase`, доступ к http listener'у должен быть открыт для всех IP.

<a id="defense"></a>

## Темы для подготовки к лабораторной защите

1. [x] Технология `JavaServer Faces`. Особенности, отличия от `сервлетов` и `JSP`, преимущества и недостатки. Структура JSF-приложения.
2. [x] Использование `JSP-страниц` и `Facelets-шаблонов` в JSF-приложениях.
3. [x] `JSF-компоненты` - особенности реализации, иерархия классов. Дополнительные библиотеки компонентов. Модель `обработки событий` в JSF-приложениях.
4. [x] Конвертеры и валидаторы данных.
5. [x] Представление страницы `JSF` на `стороне сервера`. Класс UIViewRoot.
6. [x] `Управляемые бины` - назначение, способы конфигурации. Контекст управляемых бинов.
7. [x] Конфигурация JSF-приложений. Файл faces-config.xml. Класс FacesServlet.
8. [x] Навигация в JSF-приложениях.
9. [x] Доступ к БД из Java-приложений. Протокол `JDBC`, формирование запросов, работа с драйверами СУБД.
10. [x] `Концепция ORM`. Библиотеки ORM в приложениях на Java. Основные API. Интеграция ORM-провайдеров с драйверами JDBC.
11. [x] Библиотеки ORM `Hibernate` и `EclipseLink`. Особенности, API, сходства и отличия.
12. [x] `Технология JPA`. Особенности, API, интеграция с ORM-провайдерами.

<a id="user-manual"></a>

## Как использовать мой проект

### Docker

> [!TIP]
> Чтобы просто посмотреть лабу (нетривиально профилировать для курса по ОПИ и на helios нету docker)

```bash
git clone git@github.com:worthant/interactive-graph-ui.git
cd interactive-graph-ui
mvn clean package
docker-compose up --build
```

### Ручная настройка (для гелиоса)

> [!NOTE]
> Я добавил полностью рабочий `standalone.xml` конфиг в resources - можете его глянуть для примера и использовать в лабе

1. Выполните все шаги из [моего гайда](https://github.com/worthant/web3-jsf-eclipselink-template/)
2. Не забудьте создать базу данных в studs:

> Подключиться - `psql -h pg -d studs`

```sql
CREATE TABLE point_model {
  id SERIAL PRIMARY KEY,
  x DOUBLE PRECISION NOT NULL,
  y DOUBLE PRECISION NOT NULL,
  r DOUBLE PRECISION NOT NULL
}
```
3. Также не забудьте пробросить порты:

```bash
ssh -L port:localhost:port sXXXXXX@se.ifmo.ru -p 2222
```

4. Готово, заходите в браузер и вводите:

```bash
http://localhost:port/interactive-graph-ui-1.0-SNAPSHOT/
```

<a id="theory"></a>

## Теоретические материалы

1. **JavaServer Faces**: [Официальная документация JSF](https://docs.oracle.com/javaee/7/javaserver-faces-2-2/vdldocs-facelets/index.html)
2. **ORM EclipseLink**: [Документация EclipseLink](https://www.eclipse.org/eclipselink/documentation/)
3. **Lecture from se.ifmo**: [internet.pdf](https://se.ifmo.ru/~s367837/internet.pdf)
4. **Sergei Nazemtsev's theory**: [theory.md](https://github.com/web-labs/Web-Lab-3/blob/main/theory.md)
1. **ACID-транзакции**: [habr](https://habr.com/ru/articles/555920/)
1. **Жизненный цикл JSF**: [java-online](https://java-online.ru/jsf-lifecycle.xhtml)
1. **Lombok**: [complete guide](https://auth0.com/blog/a-complete-guide-to-lombok/)
1. **CSS Battle**: [css is fun!)](https://cssbattle.dev/)
1. **Responsive CSS**: [vk - HASH](https://vk.com/wall-46465252_58953)
5. **Tailwind CSS**: [tw](https://tailwindcss.com/)
6. **Tailwind Components**: [for error pages and beautiful buttons](https://tailwindcomponents.com/)
