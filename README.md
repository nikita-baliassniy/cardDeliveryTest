##cardDeliveryTest запуск

RunnerClassGenerator отвечает за генерацию тестовых данных для тестового
CucumberRunner за запуск тестов, CardDeliveryTest.feature - сама фича с тестами.
Строка запуска: 
mvn clean compile exec:java -Denvironment=service "-Dcucumber.options=--tags @card-delivery-replanning" test

*chromedriver.exe в проекте работает с последней (30.05.2022) версией хрома - 102.0.5005

## Сомнительное поведение SUT

Некоторые моменты, которые заставили усомниться в корректности поведения app-card-delivery:
- Отсутствует распознавание букв ё в имени и фамилии, это точно нужно чинить;
- Хотя поле описано как "Фамилия и имя" даже с введенным одним словом, система не придирается;
- Список городов весьма урезанный (хотя потом случайно в совершенно другом задании я нашел, что список исключительно центров) - это убивает смысл в использовании студентами генераторов случайных данных. Задавать в ручную список, а не использовать уже встроенные списки городов, как-то грустно. 
- После успешного планирования доставки можно даже не менять дату, но система при нажатии на "запланировать" все равно распознает это как перепланирование на новую дату. Хотя стоило бы сделать отдельный попап "Такое планирование уже есть, выберите другую дату" или что-то в этом роде.

## Сомнительное описание

Если это задание для студентов используется в качестве тестового для сторонних кандидатов, я бы очень рекомендовал внести правки в его оформление:
- Настройка CI осуществляется аналогично предыдущему заданию - У кандидатов его не было, было бы неплохо просто вставить сюда текст, а не ссылку.
- Требования ... такие же - Это какие? Видимо, тоже из предыдущих заданий.
- см. пример в презентации - Наверное, лучше его сюда вставить просто.

## Возможности апгрейда

В дальнейшем можно отделить общую часть, которая есть у обоих заданий, в отдельный мавен-проект и коннектить его как зависимость.
Кроме того, можно прикрутить аллюр для красивых тестов, ну и настроить CI в jenkins, например. Или gitlab CI, если на то есть средства :)